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

function groupNameProper (groupId) {
	let groupNames = {
		lotr: "Lord of the Rings",
		loz: "Legend of Zelda",
		at: "Adventure Time",
		bayonetta: "Bayonetta",
		pkmn: "Pokemon",
		kirby: "Kirby",
		ff: "Final Fantasy",
		rotmg: "Realm of the Mad God",
		skyrim: "Skyrim",
		fe: "Fire Emblem",
		sc: "Soul Calibur",
		kh: "Kingdom Hearts",
		rs: "Runescape",
		dmc: "Devil May Cry",
		ds: "Dark Souls",
		myth: "Mythology",
		gow: "God of War",
		mh: "Monster Hunter",
		terraria: "Terraria",
		got: "Game of Thrones",
		sw: "Star Wars",
		nh: "Nethack",
		internet: "Internet",
		abcm: "Merlin (ABC)",
		bleach: 'Bleach',
	};

	if (groupNames.hasOwnProperty(groupId))
		return groupNames[groupId];
	else
		return groupId;
}

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
            rarity: item[7],
            category: item[8],
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
                        category: 'none',
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

				//category
                if (!itemInfo.weaponGroups[layer.name][uName].hasOwnProperty('category'))
                    itemInfo.weaponGroups[layer.name][uName].category = 'none'; //none,joke,tech,holiday,

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

				console.log('opening','./models/'+ weaponInfo.model +'.json');
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
					case "pole_mid":
					case "daedricsword":
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
    let creativeModeItemCode = '';
    let registerCode = '';
    let registerRenderCode = '';

    let languageFileCode = '';

    let lootTableCode = '';
    let lootTableCodeMain = '';

    let htmlPreviewCode = '';

    let itemDataCode = 'Group,Name,LayerName,Model,Damage,Durability,Enchantability,Rarity,Category\r\n';

	let totalLootTableWeight = 0;

	let modConfigEnabledItemsCode = '';
	let configDisableSeries = '';

    //loop through groups
    weaponGroupList.map(function (groupId) {

    	let weaponList = Object.keys(itemInfo.weaponGroups[groupId]);

        itemVariablesCode += '\r\n\t//'+groupId+'\r\n';
        itemMaterialCode += '\r\n\t//'+groupId+'\r\n';
        createItemCode += '\r\n\t\t//'+groupId+'\r\n';
        creativeModeItemCode += '\r\n\t\t//'+groupId+'\r\n';
        lootTableCodeMain += '\r\n\t\t\t//'+groupId+'\r\n';
        registerCode += '\r\n\t\t//'+groupId+'\r\n\t\tevent.getRegistry().registerAll(';
        registerRenderCode += '\r\n\t\t//'+groupId+'\r\n';
        languageFileCode += '#\r\n#'+groupId+'\r\n';

        //disable individual items
        modConfigEnabledItemsCode += '\r\n';
        modConfigEnabledItemsCode += '\t\t@Name("'+groupNameProper(groupId)+'")\r\n';
        modConfigEnabledItemsCode += '\t\tpublic final '+groupId+'Enabled '+groupId+'enabled = new '+groupId+'Enabled();\r\n';
        modConfigEnabledItemsCode += '\t\tpublic static class '+groupId+'Enabled {\r\n';

        //config disable set
        configDisableSeries += '\r\n';
        configDisableSeries += '\t\t@Name("Include '+groupNameProper(groupId)+'")\r\n';
        configDisableSeries += '\t\t@Comment("Remove all '+groupNameProper(groupId)+' items from drop tables / creative mode")\r\n';
        configDisableSeries += '\t\tpublic boolean '+groupId+' = true;\r\n';

        //modConfigEnabledItemsCode += '\t\t\t@Name("Disable entire set")\r\n';
		//modConfigEnabledItemsCode += '\t\t\tpublic boolean aaaDisableSet = false;\r\n';

    	//loop through weapons in group
        weaponList.map(function (weaponId) {

        	let weapon = itemInfo.weaponGroups[groupId][weaponId];

        	let weapVar = groupId + camelName(weapon.layerName);
        	let matVar = materialName(groupId, weapon.layerName);

        	let damage = weapon.damage;
        	let maxUses = weapon.durability;
        	let enchantability = weapon.enchantability;
        	let rarity = weapon.rarity;


			itemVariablesCode += '\tstatic Item '+ weapVar +';\r\n';

			itemMaterialCode += '\tpublic static final ToolMaterial '+matVar+' = EnumHelper.addToolMaterial("'+matVar+'", 1, '+maxUses+', 1.0f, (float) (('+damage+'.0f) * ModConfig.damageScale - 4.0f), '+enchantability+');\r\n'

			createItemCode += '\t\t'+ weapVar +' = new Sword("'+ weapVar +'", '+matVar+');\r\n';

			//creative mode items
			creativeModeItemCode += '\t\tif (ModConfig.enabledItems.'+groupId+'enabled.'+weapVar;
			creativeModeItemCode += ' && ModConfig.disableSeries.'+groupId;
				if (weapon.category === 'joke' || weapon.category === 'tech' || weapon.category === 'generic')
					creativeModeItemCode += ' && ModConfig.disableSets.'+weapon.category;
				if (weapon.category === 'generic' && damage < 7)
					creativeModeItemCode += ' && ModConfig.disableSets.lowtier';
			creativeModeItemCode += ') '+ weapVar +'.setCreativeTab(tabHeroicArmory);\r\n';

			registerCode += weapVar + ',';

			registerRenderCode += '\t\tregisterRender(' + weapVar + ');\r\n';

            languageFileCode += 'item.' + weapVar + '.name='+ weapon.name +'\r\n';

            console.log('==================',weapon.name,damage);

            //loot table items
            lootTableCodeMain += '\t\t\tif (ModConfig.enabledItems.'+groupId+'enabled.'+weapVar;
            lootTableCodeMain += ' && ModConfig.disableSeries.'+groupId;
				if (weapon.category === 'joke' || weapon.category === 'tech' || weapon.category === 'generic')
					lootTableCodeMain += ' && ModConfig.disableSets.'+weapon.category;
				if (weapon.category === 'generic' && damage < 7)
					lootTableCodeMain += ' && ModConfig.disableSets.lowtier';
            lootTableCodeMain += ') entries.add(new LootEntryItem('+weapVar+', (int) ceil(Math.pow('+rarity+', ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:'+weapVar+'"));\r\n';

			totalLootTableWeight += +rarity;

            htmlPreviewCode += '\t<div style="background-image: url(src/main/resources/assets/heroicarmory/textures/items/'+ groupId +'/'+ underscoreName(weapon.layerName) +'.png)"></div>\r\n';

            itemDataCode += [groupId, weapon.name, weapon.layerName, weapon.model, weapon.damage, weapon.durability, weapon.enchantability, weapon.rarity, weapon.category].join(',') + '\r\n';

            modConfigEnabledItemsCode += '\r\n';
            modConfigEnabledItemsCode += '\t\t\t@Name("'+weapon.name+'")\r\n';
            modConfigEnabledItemsCode += '\t\t\tpublic boolean '+weapVar+' = true;\r\n';
        });

        //end registercode
        registerCode = registerCode.substring(0, registerCode.length - 1);
        registerCode += ');\r\n';

        modConfigEnabledItemsCode += '\t\t}\r\n';

	});

	//Add empty item to loot table
	lootTableCodeMain += '\r\n\t\t\t//Empty Item\r\n';
	lootTableCodeMain += '\t\t\tentries.add(new LootEntryItem(Items.BONE, (int) Math.round(('+ totalLootTableWeight +' / ModConfig.lootChance) - '+ totalLootTableWeight +'), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:emptyItem"));\r\n';

    //save ModItems.java
    let modItemsTemplate = fs.readFileSync('./ModItemsTemplate.java', {encoding: 'utf8'});
    modItemsTemplate = modItemsTemplate.replace('/*{{ITEMVARIABLES}}*/',itemVariablesCode);
    modItemsTemplate = modItemsTemplate.replace('/*{{MATERIALVARIABLES}}*/',itemMaterialCode);
    modItemsTemplate = modItemsTemplate.replace('/*{{CREATEITEMS}}*/',createItemCode);
    modItemsTemplate = modItemsTemplate.replace('/*{{CREATIVETAB}}*/',creativeModeItemCode);
    modItemsTemplate = modItemsTemplate.replace('/*{{REGISTERITEMS}}*/',registerCode);
    modItemsTemplate = modItemsTemplate.replace('/*{{REGISTERRENDERS}}*/',registerRenderCode);
    modItemsTemplate = modItemsTemplate.replace('/*{{LOOTTABLEMAIN}}*/',lootTableCodeMain);
    fs.writeFileSync('./src/main/java/heroicarmory/init/ModItems.java', modItemsTemplate);

    //save ModConfig.java
    let modConfigTemplate = fs.readFileSync('./ModConfigTemplate.java', {encoding: 'utf8'});
    modConfigTemplate = modConfigTemplate.replace('/*{{ENABLEDITEMS}}*/',modConfigEnabledItemsCode);
    modConfigTemplate = modConfigTemplate.replace('/*{{DISABLESERIES}}*/',configDisableSeries);
    fs.writeFileSync('./src/main/java/heroicarmory/ModConfig.java', modConfigTemplate);

    //save language file template
    let languageFileTemplate = fs.readFileSync('./languageTemplate.lang', {encoding: 'utf8'});
    languageFileTemplate += languageFileCode;
    fs.writeFileSync('./src/main/resources/assets/heroicarmory/lang/en_US.lang', languageFileTemplate);

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


