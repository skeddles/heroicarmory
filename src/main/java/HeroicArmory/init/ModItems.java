package heroicarmory.init;

import heroicarmory.Reference;
import heroicarmory.items.ItemBasic;
import heroicarmory.items.Sword;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModItems {
	
	static Item tutorialItem;
	
//Lord of the Rings
	//Narsil
	static Item narsil;
	public static final ToolMaterial NARSILMAT = EnumHelper.addToolMaterial("NARSILMAT", 3, 2048, 13f, 4.0f, 30);
	
	//Sauron's Mace
	static Item sauronMace;
	public static final ToolMaterial SAURONMACEMAT = EnumHelper.addToolMaterial("SAURONMACEMAT", 3, 2048, 13f, 4.0f, 30);
	
	//Witch King's Sword
	static Item witchKingSword;
	public static final ToolMaterial WITCHKINGSWORDMAT = EnumHelper.addToolMaterial("WITCHKINGSWORDMAT", 3, 2048, 13f, 4.0f, 30);
	
	//Morgul Blade
	static Item morgulBlade;
	public static final ToolMaterial MORGULBLADEMAT = EnumHelper.addToolMaterial("MERGULBLADEMAT", 3, 2048, 13f, 4.0f, 30);
	
	//Gimli's Battle Axe
	static Item gimliBattleAxe;
	public static final ToolMaterial GIMLIBATTLEAXEMAT = EnumHelper.addToolMaterial("GIMLIBATTLEAXEMAT", 3, 2048, 13f, 4.0f, 30);
	
	//Gimli's Long Axe
	static Item gimliLongAxe;
	public static final ToolMaterial GIMLILONGAXEMAT = EnumHelper.addToolMaterial("GIMLILONGAXEMAT", 3, 2048, 13f, 4.0f, 30);
	
	//Sting
	static Item sting;
	public static final ToolMaterial STINGMAT = EnumHelper.addToolMaterial("STINGMAT", 3, 2048, 13f, 4.0f, 30);

//Realm of the Mad God
	//Ravenheart Sword
	static Item ravenheartSword;
	public static final ToolMaterial RAVENHEARTSWORDMAT = EnumHelper.addToolMaterial("RAVENHEARTSWORDMAT", 3, 2048, 13f, 4.0f, 30);	
	
	//Dragonsoul Sword
	static Item dragonsoulSword;
	public static final ToolMaterial DRAGONSOULSWORDMAT = EnumHelper.addToolMaterial("DRAGONSOULSWORDMAT", 3, 2048, 13f, 4.0f, 30);
	
	//Archon Sword
	static Item archonSword;
	public static final ToolMaterial ARCHONSWORDMAT = EnumHelper.addToolMaterial("ARCHONSWORDMAT", 3, 2048, 13f, 4.0f, 30);

	//Skysplitter Sword
	static Item skysplitterSword;
	public static final ToolMaterial SKYSPLITTERSWORDMAT = EnumHelper.addToolMaterial("SKYSPLITTERSWORDMAT", 3, 2048, 13f, 4.0f, 30);
	
	//Sword of Acclaim
	static Item swordofAcclaim;
	public static final ToolMaterial SWORDOFACCLAIMMAT = EnumHelper.addToolMaterial("SWORDOFACCLAIMMAT", 3, 2048, 13f, 4.0f, 30);
	
	//Sword of Splendor
	static Item swordofSplendor;
	public static final ToolMaterial SWORDOFSPLENDORMAT = EnumHelper.addToolMaterial("SWORDOFSPLENDORMAT", 3, 2048, 13f, 4.0f, 30);
	
	//Crystal Sword
	static Item crystalSword;
	public static final ToolMaterial CRYSTALSWORDMAT = EnumHelper.addToolMaterial("CRYSTALSWORDMAT", 3, 2048, 13f, 4.0f, 30);
	
	//Ancient Stone Sword
	static Item ancientStoneSword;
	public static final ToolMaterial ANCIENTSTONESWORDMAT = EnumHelper.addToolMaterial("ANCIENTSTONESWORDMAT", 3, 2048, 13f, 4.0f, 30);
	

	//Pirate King's Cutlass
	static Item pirateKingCutlass;
	public static final ToolMaterial PIRATEKINGCUTLASSMAT = EnumHelper.addToolMaterial("PIRATEKINGCUTLASSMAT", 3, 2048, 13f, 4.0f, 30);

	//Demon Blade
	static Item demonBlade;
	public static final ToolMaterial DEMONBLADEMAT = EnumHelper.addToolMaterial("DEMONBLADEMAT", 3, 2048, 13f, 4.0f, 30);

	//Sword of the Colossus
	static Item swordoftheColossus;
	public static final ToolMaterial SWORDOFTHECOLOSSUSMAT = EnumHelper.addToolMaterial("SWORDOFTHECOLOSSUSMAT", 3, 2048, 13f, 4.0f, 30);

	//Sword of the Mad God
	static Item swordoftheMadGod;
	public static final ToolMaterial SWORDOFTHEMADGODMAT = EnumHelper.addToolMaterial("SWORDOFTHEMADGODMAT", 3, 2048, 13f, 4.0f, 30);
	
	//Pixie-Enchanted Sword
	static Item pixieEnchantedSword;
	public static final ToolMaterial PIXIEENCHANTEDSWORDMAT = EnumHelper.addToolMaterial("PIXIEENCHANTEDSWORDMAT", 3, 2048, 13f, 4.0f, 30);
	
	//Indomptable
	static Item indomptable;
	public static final ToolMaterial INDOMPTABLEMAT = EnumHelper.addToolMaterial("INDOMPTABLEMAT", 3, 2048, 13f, 4.0f, 30);
	
	//creative tab
	static final CreativeTabs tabHeroicArmory = new CreativeTabs("tabHeroicArmory") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(narsil);
		}		
	};
	
	public static void init() {
		tutorialItem = new ItemBasic("tutorialItem").setCreativeTab(tabHeroicArmory);
		
		//Lord of the Rings
		narsil = new Sword("narsil", NARSILMAT).setCreativeTab(tabHeroicArmory);
		sauronMace = new Sword("sauronMace", SAURONMACEMAT).setCreativeTab(tabHeroicArmory);
		witchKingSword = new Sword("witchKingSword", WITCHKINGSWORDMAT).setCreativeTab(tabHeroicArmory);
		morgulBlade = new Sword("morgulBlade", MORGULBLADEMAT).setCreativeTab(tabHeroicArmory);
		gimliBattleAxe = new Sword("gimliBattleAxe", GIMLIBATTLEAXEMAT).setCreativeTab(tabHeroicArmory);
		gimliLongAxe = new Sword("gimliLongAxe", GIMLILONGAXEMAT).setCreativeTab(tabHeroicArmory);
		sting = new Sword("sting", STINGMAT).setCreativeTab(tabHeroicArmory);
		
		//Realm of the Mad God
		ravenheartSword = new Sword("ravenheartSword", RAVENHEARTSWORDMAT).setCreativeTab(tabHeroicArmory);
		dragonsoulSword = new Sword("dragonsoulSword", DRAGONSOULSWORDMAT).setCreativeTab(tabHeroicArmory);
		archonSword = new Sword("archonSword", ARCHONSWORDMAT).setCreativeTab(tabHeroicArmory);
		skysplitterSword = new Sword("skysplitterSword", SKYSPLITTERSWORDMAT).setCreativeTab(tabHeroicArmory);
		swordofAcclaim = new Sword("swordofAcclaim", SWORDOFACCLAIMMAT).setCreativeTab(tabHeroicArmory);
		swordofSplendor = new Sword("swordofSplendor", SWORDOFSPLENDORMAT).setCreativeTab(tabHeroicArmory);
		crystalSword = new Sword("crystalSword", CRYSTALSWORDMAT).setCreativeTab(tabHeroicArmory);
		ancientStoneSword = new Sword("ancientStoneSword", ANCIENTSTONESWORDMAT).setCreativeTab(tabHeroicArmory);
		pirateKingCutlass = new Sword("pirateKingCutlass", PIRATEKINGCUTLASSMAT).setCreativeTab(tabHeroicArmory);
		demonBlade = new Sword("demonBlade", DEMONBLADEMAT).setCreativeTab(tabHeroicArmory);
		swordoftheColossus = new Sword("swordoftheColossus", SWORDOFTHECOLOSSUSMAT).setCreativeTab(tabHeroicArmory);
		swordoftheMadGod = new Sword("swordoftheMadGod", SWORDOFTHEMADGODMAT).setCreativeTab(tabHeroicArmory);
		pixieEnchantedSword = new Sword("pixieEnchantedSword", PIXIEENCHANTEDSWORDMAT).setCreativeTab(tabHeroicArmory);
		indomptable = new Sword("indomptable", INDOMPTABLEMAT).setCreativeTab(tabHeroicArmory);
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(tutorialItem, narsil, sauronMace, witchKingSword, morgulBlade, gimliBattleAxe, gimliLongAxe, sting);
		event.getRegistry().registerAll(ravenheartSword,dragonsoulSword,archonSword,skysplitterSword,swordofAcclaim,swordofSplendor,crystalSword,ancientStoneSword,pirateKingCutlass,demonBlade);
		event.getRegistry().registerAll(swordoftheColossus,swordoftheMadGod,pixieEnchantedSword,indomptable);
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		//Lord of the Rings
		registerRender(tutorialItem);
		registerRender(narsil);
		registerRender(sauronMace);
		registerRender(witchKingSword);
		registerRender(morgulBlade);
		registerRender(gimliBattleAxe);
		registerRender(gimliLongAxe);
		registerRender(sting);
		
		//Realm of the Mad God
		registerRender(ravenheartSword);
		registerRender(dragonsoulSword);
		registerRender(archonSword);
		registerRender(skysplitterSword);
		registerRender(swordofAcclaim);
		registerRender(swordofSplendor);
		registerRender(crystalSword);
		registerRender(ancientStoneSword);
		registerRender(pirateKingCutlass);
		registerRender(demonBlade);
		registerRender(swordoftheColossus);
		registerRender(swordoftheMadGod);
		registerRender(pixieEnchantedSword);
		registerRender(indomptable);
	}
	
	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}
}