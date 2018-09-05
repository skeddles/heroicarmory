let fs = require('fs-extra');
let PSD = require('psd');
let im = require('imagemagick');
let jimp = require('jimp');
let PngCrush = require('pngcrush');
let rmdir = require('rmdir');
let serialize = require('serialize-to-js').serializeToModule;

const COMPLETELY_REWRITE_INFO = false;

const PDSPATH = "heroic_armory.psd";
const INFOPATH = "./itemData.csv";
const TEXTUREPATH = './src/main/resources/assets/heroicarmory/textures/items/';
const MODELPATH = './src/main/resources/assets/heroicarmory/models/item/';

process.stdout.write('\033c');
console.log('Heroic Treasure Generator');

//load item info file
let itemInfo;
if (COMPLETELY_REWRITE_INFO) {
	console.log('Completely rewriting info file, saving backup');
	fs.createReadStream(INFOPATH).pipe(fs.createWriteStream(INFOPATH.replace('.js','_backup.js')));
	itemInfo = {
		weaponGroups: {}
	};
}
else {
    //itemInfo = require('./itemInfo');

    itemInfoRaw = fs.readFileSync(INFOPATH, {encoding: 'utf8'});

	//split each row into item
	itemInfoRaw = itemInfoRaw.split('\r\n');

	//remove title row
	itemInfoRaw.shift();

	//resulting object
    itemInfo = {
        weaponGroups: {}
    };

	//on each item, split into fields
	itemInfoRaw.map(function (item) {

		//skip empty rows
		if (item === '') return;

		item = item.split(',');

		//if group hasn't been added yet, add it
        if (!itemInfo.weaponGroups.hasOwnProperty( item[0] ))
            itemInfo.weaponGroups[item[0]] = {};

		//skip if undefined
        if (typeof item[2] === 'undefined') return;

        const itemName = underscoreName(item[2]);

        itemInfo.weaponGroups[item[0]][itemName] = {
			name: item[1],
			layerName: item[2],
			model: item[3],
            damage: item[4],
            durability: item[5],
            enchantability: item[6],
            rarity: item[7]
		};
	});
}

//empty folders for recreation
rmdir(TEXTUREPATH, function (err, dirs, files) {
	if (err) console.log('error',err)
    console.log('texture folder deleted');

    fs.mkdirSync(TEXTUREPATH);

	//delete folders for recreation
    rmdir(MODELPATH, function (err, dirs, files) {
        if (err) console.log('error',err)
        console.log('model folder deleted');

        fs.mkdirSync(MODELPATH);
        parsePsd();
    });
});


function parsePsd () {
	//parse psd
    let psd = PSD.fromFile(PDSPATH);
    psd.parse();
    let layerList = psd.tree().export().children;

	//export document
    psd.image.saveAsPng('spritesheetBad.png').then(function () {
        console.log('Exported spritesheet');

        //psd parser exports a file that jimp says it corrupt, pngcrushing it seems to fix it
        let pngcrush = new PngCrush(['-rem', 'allo', '-m', '0']); //methods 1-10

        fs.createReadStream('spritesheetBad.png').pipe(pngcrush).on('error', function (e) {
            console.log('fuktup');
            return callback('error crushing file');
        }).pipe(fs.createWriteStream('heroic_armory_sprites.png')).on('finish', function () {
            console.log('Fixed spritesheet');
            fs.unlinkSync('spritesheetBad.png');
            processDocLayers(layerList);
        });
    });
}

function processDocLayers (layerList) {
	//loop through layers
	layerList.forEach(function (layer) {

		//if folder
		if (layer.type === 'group') {
			console.log('GROUP: ', layer.name);

			//skip hidden groups
			if (!layer.visible)
				return;

			//if group not in list, add it
			if (!itemInfo.weaponGroups.hasOwnProperty(layer.name)) {
                itemInfo.weaponGroups[layer.name] = {};
                console.log('\tcreated folder for',layer.name);
            }

			//if it doesn't have a textures folder, create one
			const texturesFolderPath = './src/main/resources/assets/heroicarmory/textures/items/' + layer.name;
			if (!fs.existsSync(texturesFolderPath)) {
                fs.mkdirSync(texturesFolderPath);
                console.log('\tcreated texture folder',texturesFolderPath)
            }

			let weapons = layer.children;

			//search through weapons in group
			weapons.forEach(function (weapon) {
				console.log('\tWEAPON:',weapon.name)
				let uName = underscoreName(weapon.name);
				let cName = camelName(weapon.name);

				//if weapon not in list, add it
				if (!itemInfo.weaponGroups[layer.name].hasOwnProperty(uName)) {

					let defaultModel;
					//get width for default model
					if (Math.max(weapon.width,weapon.height) <= 16)
						defaultModel = '16x';
					else if (Math.max(weapon.width,weapon.height) <= 32)
						defaultModel = '32x';
					else
						defaultModel = '48x'

					itemInfo.weaponGroups[layer.name][uName] = {
						name: niceName(weapon.name),
						layerName: weapon.name,
						model: '16x',
						damage: 7,
						durability: 2000,
                        enchantability: 15,
                        rarity: 10,
					};
					console.log('\t\tadded to weapon list');

				}

				//fill in missing properties

				//damage
                if (!itemInfo.weaponGroups[layer.name][uName].hasOwnProperty('damage'))
                    itemInfo.weaponGroups[layer.name][uName].damage = 7; //6=iron, 7=diamond, 10=manyullen

				//durability
                if (!itemInfo.weaponGroups[layer.name][uName].hasOwnProperty('durability'))
                    itemInfo.weaponGroups[layer.name][uName].durability = 2000; //iron=250,diamond=1561 (but well made weapons should last longer)

				//enchantability
                if (!itemInfo.weaponGroups[layer.name][uName].hasOwnProperty('enchantability'))
                    itemInfo.weaponGroups[layer.name][uName].enchantability = 15; //iron=15,diamond=10,gold=22,magic items should be more enchantable

				//rarity
                if (!itemInfo.weaponGroups[layer.name][uName].hasOwnProperty('rarity'))
                    itemInfo.weaponGroups[layer.name][uName].rarity = 10; //0=ultra, 5=rare, 10=uncommon, 15=common, 20=dirt

			//GENERATE TEXTURES
				let weaponInfo = itemInfo.weaponGroups[layer.name][uName];

				//get sprite location
				let res = Math.ceil(Math.max(weapon.width, weapon.height) / 16) * 16;
				let x = weapon.left;
				let y = weapon.bottom-res;

				//export texture
				jimp.read('heroic_armory_sprites.png')
					.then(function (spriteSheet) {
						let texturePath = texturesFolderPath + '/' +uName + '.png';
						spriteSheet.crop(x, y, res, res)
							.write(texturePath);

						console.log('\t\texported texture',texturePath);
					})
					.catch(function (error) {
						console.log('error loading png:', error);
					});


			//CREATE MODELS
				const modelPath =  './src/main/resources/assets/heroicarmory/models/item/' + modelName(layer.name, weapon.name) +'.json';

				let modelCode = fs.readFileSync('./models/'+ weaponInfo.model +'.json', {encoding: 'utf8'});

				modelCode = modelCode.replace('{{group}}', layer.name);
				modelCode = modelCode.replace('{{weapon}}', uName);

				//calculate scale for some models
				switch (weaponInfo.model) {
					case "32x":
					case "32x_long":
					case "32x_longer":
					case "wishstar":
					case "scythe":
					case "keyblade":
					case "honedge":
						//calculate scale
						const scale = res / Math.max(weapon.width, weapon.height);
                        modelCode = modelCode.replace(/{{scale}}/g, scale);

                        //calculate position
                        const position = 8*(32/Math.max(weapon.width, weapon.height))-8;
                        modelCode = modelCode.replace(/{{position}}/g, position);
						break;
				}
				
				fs.writeFileSync(modelPath, modelCode);

				console.log('\tcreated model json',modelPath);


			});

			//console.log(weapons[0]);
		}
	});

    //write item object back to file
    //fs.writeFileSync('./iteminfothing.js', serialize(itemInfo, {beautify: true}));

	//generate mod items code
	generateModItems();
}

function generateModItems () {


    let weaponGroupList = Object.keys(itemInfo.weaponGroups);

    let itemVariablesCode = '';
    let itemMaterialCode = '';
    let createItemCode = '';
    let registerCode = '';
    let registerRenderCode = '';

    let languageFileCode = '';

    let lootTableCode = '';

    let htmlPreviewCode = '';

    let itemDataCode = 'Group,Name,LayerName,Model,Damage,Durability,Enchantability,Rarity\r\n';

	var totalLootTableWeight = 0;


    //loop through groups
    weaponGroupList.map(function (groupId) {

    	let weaponList = Object.keys(itemInfo.weaponGroups[groupId]);

        itemVariablesCode += '\r\n\t//'+groupId+'\r\n';
        itemMaterialCode += '\r\n\t//'+groupId+'\r\n';
        createItemCode += '\r\n\t\t//'+groupId+'\r\n';
        registerCode += '\r\n\t\t//'+groupId+'\r\n\t\tevent.getRegistry().registerAll(';
        registerRenderCode += '\r\n\t\t//'+groupId+'\r\n';
        languageFileCode += '#\r\n#'+groupId+'\r\n';

    	//loop through weapons in group
        weaponList.map(function (weaponId) {

        	let weapon = itemInfo.weaponGroups[groupId][weaponId];

        	let weapVar = groupId + camelName(weapon.layerName);
        	let matVar = materialName(groupId, weapon.layerName);

        	let damage = weapon.damage - 4;
        	let maxUses = weapon.durability;
        	let enchantability = weapon.enchantability;
        	let rarity = weapon.rarity;


			itemVariablesCode += '\tstatic Item '+ weapVar +';\r\n';

			itemMaterialCode += '\tpublic static final ToolMaterial '+matVar+' = EnumHelper.addToolMaterial("'+matVar+'", 1, '+maxUses+', 1.0f, '+damage+'.0f, '+enchantability+');\r\n'

			createItemCode += '\t\t'+ weapVar +' = new Sword("'+ weapVar +'", '+matVar+').setCreativeTab(tabHeroicArmory);\r\n';

			registerCode += weapVar + ',';

			registerRenderCode += '\t\tregisterRender(' + weapVar + ');\r\n';

            languageFileCode += 'item.' + weapVar + '.name='+ weapon.name +'\r\n';

            lootTableCode += '\t\t{name: "heroicarmory:'+weapVar+'", weight: '+rarity+', type: "item"},\r\n';
			totalLootTableWeight += +rarity;

            htmlPreviewCode += '\t<div style="background-image: url(src/main/resources/assets/heroicarmory/textures/items/'+ groupId +'/'+ underscoreName(weapon.layerName) +'.png)"></div>\r\n';

            itemDataCode += [groupId, weapon.name,weapon.layerName,weapon.model,weapon.damage,weapon.durability,weapon.enchantability,weapon.rarity].join(',') + '\r\n';

        });

        //end registercode
        registerCode = registerCode.substring(0, registerCode.length - 1);
        registerCode += ');\r\n';
	});

    //save ModItems.java
    let modItemsTemplate = fs.readFileSync('./ModItemsTemplate.java', {encoding: 'utf8'});
    modItemsTemplate = modItemsTemplate.replace('/*{{ITEMVARIABLES}}*/',itemVariablesCode);
    modItemsTemplate = modItemsTemplate.replace('/*{{MATERIALVARIABLES}}*/',itemMaterialCode);
    modItemsTemplate = modItemsTemplate.replace('/*{{CREATEITEMS}}*/',createItemCode);
    modItemsTemplate = modItemsTemplate.replace('/*{{REGISTERITEMS}}*/',registerCode);
    modItemsTemplate = modItemsTemplate.replace('/*{{REGISTERRENDERS}}*/',registerRenderCode);
    fs.writeFileSync('./src/main/java/HeroicArmory/init/ModItems.java', modItemsTemplate);

    //save language file template
    let languageFileTemplate = fs.readFileSync('./languageTemplate.lang', {encoding: 'utf8'});
    languageFileTemplate += languageFileCode;
    fs.writeFileSync('./src/main/resources/assets/heroicarmory/lang/en_US.lang', languageFileTemplate);

    //save loot table json
    let lootTableTemplate = fs.readFileSync('./lootTableTemplate.json', {encoding: 'utf8'});
    lootTableTemplate = lootTableTemplate.replace('{{ENTRIES}}',lootTableCode);
    lootTableTemplate = lootTableTemplate.replace('{{EMPTY}}', Math.round(totalLootTableWeight/2)); //25% of nothing
    fs.writeFileSync('./src/main/resources/assets/heroicarmory/loot_tables/loot.json', lootTableTemplate);

    //save html
    let htmlFileTemplate = fs.readFileSync('./texturePreviewTemplate.htm', {encoding: 'utf8'});
    htmlFileTemplate = htmlFileTemplate.replace('{{IMAGES}}',htmlPreviewCode);
    fs.writeFileSync('./texturePreview.htm', htmlFileTemplate);

    //save item data csv
    fs.writeFileSync(INFOPATH, itemDataCode);

}

function underscoreName (name) {
	//remove apostrophe s
	name = name.replace("'s",'');
	
	//make lowercase
	name = name.toLowerCase();
	
	//remove ending brackets
	name = name.replace(/\]/g,'');	
	
	//replace spaces, dashes, openbracket with underscores
	name = name.replace(/\s|-|\[/g,'_');
	
	return name;
}

function camelName2 (name) {
	//remove apostrophe s
	name = name.replace("'s",'');

	//remove brackets
	name = name.replace(/\[|\]/g,'');

	//remove spaces
	name = name.replace(/\s/g,'');

	//remove dashes
	name = name.replace(/-/g,'');

	//make first letter lowercase
	name = name.charAt(0).toLowerCase() + name.slice(1);

	return name;
}
function camelName (name) {
	//remove apostrophe s
	name = name.replace("'s",'');

	//remove brackets
	name = name.replace(/\[|\]/g,'');

	//remove spaces
	name = name.replace(/\s/g,'');

	//remove dashes
	name = name.replace(/-/g,'');

	return name;
}

function modelName (group, name) {
	//get camel name
	name = camelName(name);

	//make all lowercase
	name = name.toLowerCase();

	//prepend with group
	name = group+name;

	return name;
}

function materialName (group, name) {
	//get camel name
	name = modelName(group, name);

	//make all uppercase
	name = name.toUpperCase();

	//add material to end
	name = name + 'MATERIAL';


	return name;
}

function niceName (name) {
	//remove bracket words
	name = name.replace(/\[.*\]/, '');
	
	return name;
}


