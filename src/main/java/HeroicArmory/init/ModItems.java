package heroicarmory.init;

import heroicarmory.Reference;
import heroicarmory.items.ItemBasic;
import heroicarmory.items.Sword;
//import heroicarmory.items.SlowSword;

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

import net.minecraft.util.ResourceLocation;
import net.minecraft.init.Items; //dont need once custom
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.KilledByPlayer;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraft.world.storage.loot.functions.SetDamage;
import net.minecraftforge.event.LootTableLoadEvent;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModItems {

    //ITEM VARIABLES====================================================================================================
    
	//lotr
	static Item lotrGimliBattleAxe;
	static Item lotrGimliLongAxe;
	static Item lotrMorgulBlade;
	static Item lotrSting;
	static Item lotrGlamdring;
	static Item lotrAnduril;
	static Item lotrNarsil;
	static Item lotrSauronMace;
	static Item lotrWitchKingSword;

	//loz
	static Item lozMasterSword;
	static Item lozMasterSwordII;
	static Item lozTemperedSword;
	static Item lozMasterSwordIII;
	static Item lozGoldenSword;
	static Item lozFlameblade;
	static Item lozDarknutSwordTp;
	static Item lozGhirahimSword;
	static Item lozFierceDietySword;
	static Item lozZeldaSword;
	static Item lozBokoStick;
	static Item lozCaneofByrna;
	static Item lozMegatonHammer;
	static Item lozKokiriSwordMm;
	static Item lozKokiriSwordOoT;
	static Item lozDemiseSword;
	static Item lozGiantKnife;
	static Item lozBiggoronSword;
	static Item lozPhantomGanonSword;
	static Item lozUltimateSword;
	static Item lozRoyalGuardSword;
	static Item lozMagicSwordConcept;
	static Item lozMagicSword;
	static Item lozWhiteSword;
	static Item lozWhiteSwordConcept;
	static Item lozPicoriBlade;
	static Item lozRazorSword;
	static Item lozGreatFairySword;
	static Item lozGoddessWhiteSword;
	static Item lozGoddessSword;
	static Item lozGildedSword;

	//at
	static Item atJakeSword;
	static Item atCrystalSword;
	static Item atNothung;
	static Item atFinnSword;
	static Item atSwordoftheDead;
	static Item atWishStarSword;
	static Item atFightKingSword;
	static Item atRootSword;
	static Item atScarlet;
	static Item atGrassSword;
	static Item atDemonBloodSword;

	//ff
	static Item ffTheMasamune;
	static Item ffBusterSword;

	//rotmg
	static Item rotmgSwordoftheColossus;
	static Item rotmgCrystalSword;
	static Item rotmgPixieEnchantedSword;
	static Item rotmgSwordOfAcclaim;
	static Item rotmgDemonBlade;
	static Item rotmgSwordoftheMadGod;
	static Item rotmgIndomptable;
	static Item rotmgPirateKingCutlass;
	static Item rotmgSwordofSplendor;
	static Item rotmgSkysplitterSword;
	static Item rotmgArchonSword;
	static Item rotmgAncientStoneSword;
	static Item rotmgDragonsoulSword;
	static Item rotmgRavenheartSword;

	//sc
	static Item scFirangi;
	static Item scCocytus;
	static Item scErlangBlade;
	static Item scSoulEdgeNightmare;
	static Item scPhlegathon;
	static Item scAcheron;
	static Item scLethe;

	//rs
	static Item rsBronzeSword;
	static Item rsIronSword;
	static Item rsWhiteSword;
	static Item rsBlackSword;
	static Item rsSteelSword;
	static Item rsMithrilSword;
	static Item rsAdamantSword;
	static Item rsRuneSword;
	static Item rsDragonSword;
	static Item rsBronzeBattleaxe;
	static Item rsIronBattleaxe;
	static Item rsSteelBattleaxe;
	static Item rsBlackBattleaxe;
	static Item rsWhiteBattleaxe;
	static Item rsMithrilBattleaxe;
	static Item rsAdamantBattleaxe;
	static Item rsRuneBattleaxe;
	static Item rsDragonBattleaxe;
	static Item rsBronzeScimitar;
	static Item rsIronScimitar;
	static Item rsBlackScimitar;
	static Item rsWhiteScimitar;
	static Item rsSteelScimitar;
	static Item rsMithrilScimitar;
	static Item rsAdamantScimitar;
	static Item rsRuneScimitar;
	static Item rsDragonScimitar;
	static Item rsBronzeWarhammer;
	static Item rsIronWarhammer;
	static Item rsSteelWarhammer;
	static Item rsBlackWarhammer;
	static Item rsWhiteWarhammer;
	static Item rsMithrilWarhammer;
	static Item rsAdamantWarhammer;
	static Item rsRuneWarhammer;
	static Item rsBronzeMace;
	static Item rsIronMace;
	static Item rsSteelMace;
	static Item rsBlackMace;
	static Item rsWhiteMace;
	static Item rsMithrilMace;
	static Item rsAdamantMace;
	static Item rsRuneMace;
	static Item rsGraniteLongsword;
	static Item rsGraniteHammer;
	static Item rsGraniteMaul;
	static Item rsElderMaul;
	static Item rsToktzxilak;
	static Item rsWolfsbane;
	static Item rsZamorakGodsword;
	static Item rsBandosGodsword;
	static Item rsArmadylGodsword;
	static Item rsSaradominGodsword;

	//dmc
	static Item dmcRedQueen;
	static Item dmcRebellion;
	static Item dmcYamato;


    //MATERIAL VARIABLES================================================================================================
    
	//lotr
	public static final ToolMaterial LOTRGIMLIBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("LOTRGIMLIBATTLEAXEMATERIAL", 1, 4100, 1.0f, 3.0f, 8);
	public static final ToolMaterial LOTRGIMLILONGAXEMATERIAL = EnumHelper.addToolMaterial("LOTRGIMLILONGAXEMATERIAL", 1, 3600, 1.0f, 3.0f, 8);
	public static final ToolMaterial LOTRMORGULBLADEMATERIAL = EnumHelper.addToolMaterial("LOTRMORGULBLADEMATERIAL", 1, 100, 1.0f, 2.0f, 15);
	public static final ToolMaterial LOTRSTINGMATERIAL = EnumHelper.addToolMaterial("LOTRSTINGMATERIAL", 1, 2100, 1.0f, 1.0f, 28);
	public static final ToolMaterial LOTRGLAMDRINGMATERIAL = EnumHelper.addToolMaterial("LOTRGLAMDRINGMATERIAL", 1, 3000, 1.0f, 2.0f, 30);
	public static final ToolMaterial LOTRANDURILMATERIAL = EnumHelper.addToolMaterial("LOTRANDURILMATERIAL", 1, 1000, 1.0f, 3.0f, 12);
	public static final ToolMaterial LOTRNARSILMATERIAL = EnumHelper.addToolMaterial("LOTRNARSILMATERIAL", 1, 2000, 1.0f, 4.0f, 12);
	public static final ToolMaterial LOTRSAURONMACEMATERIAL = EnumHelper.addToolMaterial("LOTRSAURONMACEMATERIAL", 1, 3000, 1.0f, 10.0f, 8);
	public static final ToolMaterial LOTRWITCHKINGSWORDMATERIAL = EnumHelper.addToolMaterial("LOTRWITCHKINGSWORDMATERIAL", 1, 2500, 1.0f, 3.0f, 15);

	//loz
	public static final ToolMaterial LOZMASTERSWORDMATERIAL = EnumHelper.addToolMaterial("LOZMASTERSWORDMATERIAL", 1, 3000, 1.0f, 3.0f, 15);
	public static final ToolMaterial LOZMASTERSWORDIIMATERIAL = EnumHelper.addToolMaterial("LOZMASTERSWORDIIMATERIAL", 1, 4500, 1.0f, 4.0f, 10);
	public static final ToolMaterial LOZTEMPEREDSWORDMATERIAL = EnumHelper.addToolMaterial("LOZTEMPEREDSWORDMATERIAL", 1, 4500, 1.0f, 4.0f, 10);
	public static final ToolMaterial LOZMASTERSWORDIIIMATERIAL = EnumHelper.addToolMaterial("LOZMASTERSWORDIIIMATERIAL", 1, 7000, 1.0f, 5.0f, 8);
	public static final ToolMaterial LOZGOLDENSWORDMATERIAL = EnumHelper.addToolMaterial("LOZGOLDENSWORDMATERIAL", 1, 7000, 1.0f, 5.0f, 8);
	public static final ToolMaterial LOZFLAMEBLADEMATERIAL = EnumHelper.addToolMaterial("LOZFLAMEBLADEMATERIAL", 1, 2000, 1.0f, 2.0f, 10);
	public static final ToolMaterial LOZDARKNUTSWORDTPMATERIAL = EnumHelper.addToolMaterial("LOZDARKNUTSWORDTPMATERIAL", 1, 2800, 1.0f, 5.0f, 12);
	public static final ToolMaterial LOZGHIRAHIMSWORDMATERIAL = EnumHelper.addToolMaterial("LOZGHIRAHIMSWORDMATERIAL", 1, 3000, 1.0f, 3.0f, 18);
	public static final ToolMaterial LOZFIERCEDIETYSWORDMATERIAL = EnumHelper.addToolMaterial("LOZFIERCEDIETYSWORDMATERIAL", 1, 1600, 1.0f, 4.0f, 20);
	public static final ToolMaterial LOZZELDASWORDMATERIAL = EnumHelper.addToolMaterial("LOZZELDASWORDMATERIAL", 1, 2000, 1.0f, 2.0f, 18);
	public static final ToolMaterial LOZBOKOSTICKMATERIAL = EnumHelper.addToolMaterial("LOZBOKOSTICKMATERIAL", 1, 150, 1.0f, 0.0f, 20);
	public static final ToolMaterial LOZCANEOFBYRNAMATERIAL = EnumHelper.addToolMaterial("LOZCANEOFBYRNAMATERIAL", 1, 800, 1.0f, 1.0f, 32);
	public static final ToolMaterial LOZMEGATONHAMMERMATERIAL = EnumHelper.addToolMaterial("LOZMEGATONHAMMERMATERIAL", 1, 3200, 1.0f, 3.0f, 15);
	public static final ToolMaterial LOZKOKIRISWORDMMMATERIAL = EnumHelper.addToolMaterial("LOZKOKIRISWORDMMMATERIAL", 1, 750, 1.0f, 1.0f, 15);
	public static final ToolMaterial LOZKOKIRISWORDOOTMATERIAL = EnumHelper.addToolMaterial("LOZKOKIRISWORDOOTMATERIAL", 1, 750, 1.0f, 1.0f, 15);
	public static final ToolMaterial LOZDEMISESWORDMATERIAL = EnumHelper.addToolMaterial("LOZDEMISESWORDMATERIAL", 1, 2000, 1.0f, 5.0f, 8);
	public static final ToolMaterial LOZGIANTKNIFEMATERIAL = EnumHelper.addToolMaterial("LOZGIANTKNIFEMATERIAL", 1, 40, 1.0f, 4.0f, 10);
	public static final ToolMaterial LOZBIGGORONSWORDMATERIAL = EnumHelper.addToolMaterial("LOZBIGGORONSWORDMATERIAL", 1, 8000, 1.0f, 4.0f, 10);
	public static final ToolMaterial LOZPHANTOMGANONSWORDMATERIAL = EnumHelper.addToolMaterial("LOZPHANTOMGANONSWORDMATERIAL", 1, 3000, 1.0f, 5.0f, 15);
	public static final ToolMaterial LOZULTIMATESWORDMATERIAL = EnumHelper.addToolMaterial("LOZULTIMATESWORDMATERIAL", 1, 1000, 1.0f, 3.0f, 15);
	public static final ToolMaterial LOZROYALGUARDSWORDMATERIAL = EnumHelper.addToolMaterial("LOZROYALGUARDSWORDMATERIAL", 1, 1500, 1.0f, 2.0f, 15);
	public static final ToolMaterial LOZMAGICSWORDCONCEPTMATERIAL = EnumHelper.addToolMaterial("LOZMAGICSWORDCONCEPTMATERIAL", 1, 1600, 1.0f, 5.0f, 38);
	public static final ToolMaterial LOZMAGICSWORDMATERIAL = EnumHelper.addToolMaterial("LOZMAGICSWORDMATERIAL", 1, 1600, 1.0f, 5.0f, 38);
	public static final ToolMaterial LOZWHITESWORDMATERIAL = EnumHelper.addToolMaterial("LOZWHITESWORDMATERIAL", 1, 2600, 1.0f, 3.0f, 10);
	public static final ToolMaterial LOZWHITESWORDCONCEPTMATERIAL = EnumHelper.addToolMaterial("LOZWHITESWORDCONCEPTMATERIAL", 1, 2600, 1.0f, 3.0f, 10);
	public static final ToolMaterial LOZPICORIBLADEMATERIAL = EnumHelper.addToolMaterial("LOZPICORIBLADEMATERIAL", 1, 2000, 1.0f, 2.0f, 15);
	public static final ToolMaterial LOZRAZORSWORDMATERIAL = EnumHelper.addToolMaterial("LOZRAZORSWORDMATERIAL", 1, 2600, 1.0f, 2.0f, 12);
	public static final ToolMaterial LOZGREATFAIRYSWORDMATERIAL = EnumHelper.addToolMaterial("LOZGREATFAIRYSWORDMATERIAL", 1, 2800, 1.0f, 4.0f, 20);
	public static final ToolMaterial LOZGODDESSWHITESWORDMATERIAL = EnumHelper.addToolMaterial("LOZGODDESSWHITESWORDMATERIAL", 1, 1600, 1.0f, 3.0f, 15);
	public static final ToolMaterial LOZGODDESSSWORDMATERIAL = EnumHelper.addToolMaterial("LOZGODDESSSWORDMATERIAL", 1, 1600, 1.0f, 3.0f, 15);
	public static final ToolMaterial LOZGILDEDSWORDMATERIAL = EnumHelper.addToolMaterial("LOZGILDEDSWORDMATERIAL", 1, 2800, 1.0f, 3.0f, 28);

	//at
	public static final ToolMaterial ATJAKESWORDMATERIAL = EnumHelper.addToolMaterial("ATJAKESWORDMATERIAL", 1, 2000, 1.0f, 2.0f, 10);
	public static final ToolMaterial ATCRYSTALSWORDMATERIAL = EnumHelper.addToolMaterial("ATCRYSTALSWORDMATERIAL", 1, 3000, 1.0f, 2.0f, 10);
	public static final ToolMaterial ATNOTHUNGMATERIAL = EnumHelper.addToolMaterial("ATNOTHUNGMATERIAL", 1, 3000, 1.0f, 4.0f, 10);
	public static final ToolMaterial ATFINNSWORDMATERIAL = EnumHelper.addToolMaterial("ATFINNSWORDMATERIAL", 1, 2800, 1.0f, 3.0f, 11);
	public static final ToolMaterial ATSWORDOFTHEDEADMATERIAL = EnumHelper.addToolMaterial("ATSWORDOFTHEDEADMATERIAL", 1, 2800, 1.0f, 3.0f, 10);
	public static final ToolMaterial ATWISHSTARSWORDMATERIAL = EnumHelper.addToolMaterial("ATWISHSTARSWORDMATERIAL", 1, 2800, 1.0f, 3.0f, 15);
	public static final ToolMaterial ATFIGHTKINGSWORDMATERIAL = EnumHelper.addToolMaterial("ATFIGHTKINGSWORDMATERIAL", 1, 400, 1.0f, 4.0f, 5);
	public static final ToolMaterial ATROOTSWORDMATERIAL = EnumHelper.addToolMaterial("ATROOTSWORDMATERIAL", 1, 1800, 1.0f, 3.0f, 15);
	public static final ToolMaterial ATSCARLETMATERIAL = EnumHelper.addToolMaterial("ATSCARLETMATERIAL", 1, 2800, 1.0f, 3.0f, 28);
	public static final ToolMaterial ATGRASSSWORDMATERIAL = EnumHelper.addToolMaterial("ATGRASSSWORDMATERIAL", 1, 600, 1.0f, 2.0f, 14);
	public static final ToolMaterial ATDEMONBLOODSWORDMATERIAL = EnumHelper.addToolMaterial("ATDEMONBLOODSWORDMATERIAL", 1, 2800, 1.0f, 3.0f, 22);

	//ff
	public static final ToolMaterial FFTHEMASAMUNEMATERIAL = EnumHelper.addToolMaterial("FFTHEMASAMUNEMATERIAL", 1, 3000, 1.0f, 3.0f, 15);
	public static final ToolMaterial FFBUSTERSWORDMATERIAL = EnumHelper.addToolMaterial("FFBUSTERSWORDMATERIAL", 1, 3000, 1.0f, 5.0f, 15);

	//rotmg
	public static final ToolMaterial ROTMGSWORDOFTHECOLOSSUSMATERIAL = EnumHelper.addToolMaterial("ROTMGSWORDOFTHECOLOSSUSMATERIAL", 1, 3600, 1.0f, 4.0f, 15);
	public static final ToolMaterial ROTMGCRYSTALSWORDMATERIAL = EnumHelper.addToolMaterial("ROTMGCRYSTALSWORDMATERIAL", 1, 2200, 1.0f, 3.0f, 15);
	public static final ToolMaterial ROTMGPIXIEENCHANTEDSWORDMATERIAL = EnumHelper.addToolMaterial("ROTMGPIXIEENCHANTEDSWORDMATERIAL", 1, 1400, 1.0f, 5.0f, 15);
	public static final ToolMaterial ROTMGSWORDOFACCLAIMMATERIAL = EnumHelper.addToolMaterial("ROTMGSWORDOFACCLAIMMATERIAL", 1, 2600, 1.0f, 4.0f, 15);
	public static final ToolMaterial ROTMGDEMONBLADEMATERIAL = EnumHelper.addToolMaterial("ROTMGDEMONBLADEMATERIAL", 1, 3200, 1.0f, 5.0f, 15);
	public static final ToolMaterial ROTMGSWORDOFTHEMADGODMATERIAL = EnumHelper.addToolMaterial("ROTMGSWORDOFTHEMADGODMATERIAL", 1, 2800, 1.0f, 4.0f, 15);
	public static final ToolMaterial ROTMGINDOMPTABLEMATERIAL = EnumHelper.addToolMaterial("ROTMGINDOMPTABLEMATERIAL", 1, 600, 1.0f, 5.0f, 15);
	public static final ToolMaterial ROTMGPIRATEKINGCUTLASSMATERIAL = EnumHelper.addToolMaterial("ROTMGPIRATEKINGCUTLASSMATERIAL", 1, 600, 1.0f, 2.0f, 15);
	public static final ToolMaterial ROTMGSWORDOFSPLENDORMATERIAL = EnumHelper.addToolMaterial("ROTMGSWORDOFSPLENDORMATERIAL", 1, 3000, 1.0f, 4.0f, 15);
	public static final ToolMaterial ROTMGSKYSPLITTERSWORDMATERIAL = EnumHelper.addToolMaterial("ROTMGSKYSPLITTERSWORDMATERIAL", 1, 2000, 1.0f, 3.0f, 15);
	public static final ToolMaterial ROTMGARCHONSWORDMATERIAL = EnumHelper.addToolMaterial("ROTMGARCHONSWORDMATERIAL", 1, 1400, 1.0f, 3.0f, 15);
	public static final ToolMaterial ROTMGANCIENTSTONESWORDMATERIAL = EnumHelper.addToolMaterial("ROTMGANCIENTSTONESWORDMATERIAL", 1, 750, 1.0f, 4.0f, 15);
	public static final ToolMaterial ROTMGDRAGONSOULSWORDMATERIAL = EnumHelper.addToolMaterial("ROTMGDRAGONSOULSWORDMATERIAL", 1, 800, 1.0f, 2.0f, 15);
	public static final ToolMaterial ROTMGRAVENHEARTSWORDMATERIAL = EnumHelper.addToolMaterial("ROTMGRAVENHEARTSWORDMATERIAL", 1, 400, 1.0f, 2.0f, 15);

	//sc
	public static final ToolMaterial SCFIRANGIMATERIAL = EnumHelper.addToolMaterial("SCFIRANGIMATERIAL", 1, 1600, 1.0f, 2.0f, 15);
	public static final ToolMaterial SCCOCYTUSMATERIAL = EnumHelper.addToolMaterial("SCCOCYTUSMATERIAL", 1, 1600, 1.0f, 3.0f, 15);
	public static final ToolMaterial SCERLANGBLADEMATERIAL = EnumHelper.addToolMaterial("SCERLANGBLADEMATERIAL", 1, 1800, 1.0f, 2.0f, 15);
	public static final ToolMaterial SCSOULEDGENIGHTMAREMATERIAL = EnumHelper.addToolMaterial("SCSOULEDGENIGHTMAREMATERIAL", 1, 3200, 1.0f, 7.0f, 4);
	public static final ToolMaterial SCPHLEGATHONMATERIAL = EnumHelper.addToolMaterial("SCPHLEGATHONMATERIAL", 1, 2000, 1.0f, 2.0f, 15);
	public static final ToolMaterial SCACHERONMATERIAL = EnumHelper.addToolMaterial("SCACHERONMATERIAL", 1, 2000, 1.0f, 2.0f, 15);
	public static final ToolMaterial SCLETHEMATERIAL = EnumHelper.addToolMaterial("SCLETHEMATERIAL", 1, 2200, 1.0f, 4.0f, 15);

	//rs
	public static final ToolMaterial RSBRONZESWORDMATERIAL = EnumHelper.addToolMaterial("RSBRONZESWORDMATERIAL", 1, 350, 1.0f, 1.0f, 16);
	public static final ToolMaterial RSIRONSWORDMATERIAL = EnumHelper.addToolMaterial("RSIRONSWORDMATERIAL", 1, 500, 1.0f, 2.0f, 14);
	public static final ToolMaterial RSWHITESWORDMATERIAL = EnumHelper.addToolMaterial("RSWHITESWORDMATERIAL", 1, 1600, 1.0f, 2.0f, 17);
	public static final ToolMaterial RSBLACKSWORDMATERIAL = EnumHelper.addToolMaterial("RSBLACKSWORDMATERIAL", 1, 1600, 1.0f, 2.0f, 17);
	public static final ToolMaterial RSSTEELSWORDMATERIAL = EnumHelper.addToolMaterial("RSSTEELSWORDMATERIAL", 1, 1600, 1.0f, 2.0f, 8);
	public static final ToolMaterial RSMITHRILSWORDMATERIAL = EnumHelper.addToolMaterial("RSMITHRILSWORDMATERIAL", 1, 2600, 1.0f, 3.0f, 26);
	public static final ToolMaterial RSADAMANTSWORDMATERIAL = EnumHelper.addToolMaterial("RSADAMANTSWORDMATERIAL", 1, 3400, 1.0f, 4.0f, 10);
	public static final ToolMaterial RSRUNESWORDMATERIAL = EnumHelper.addToolMaterial("RSRUNESWORDMATERIAL", 1, 4200, 1.0f, 5.0f, 32);
	public static final ToolMaterial RSDRAGONSWORDMATERIAL = EnumHelper.addToolMaterial("RSDRAGONSWORDMATERIAL", 1, 5600, 1.0f, 6.0f, 15);
	public static final ToolMaterial RSBRONZEBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("RSBRONZEBATTLEAXEMATERIAL", 1, 350, 1.0f, 1.0f, 16);
	public static final ToolMaterial RSIRONBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("RSIRONBATTLEAXEMATERIAL", 1, 500, 1.0f, 2.0f, 14);
	public static final ToolMaterial RSSTEELBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("RSSTEELBATTLEAXEMATERIAL", 1, 1600, 1.0f, 2.0f, 17);
	public static final ToolMaterial RSBLACKBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("RSBLACKBATTLEAXEMATERIAL", 1, 1600, 1.0f, 2.0f, 17);
	public static final ToolMaterial RSWHITEBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("RSWHITEBATTLEAXEMATERIAL", 1, 1600, 1.0f, 2.0f, 8);
	public static final ToolMaterial RSMITHRILBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("RSMITHRILBATTLEAXEMATERIAL", 1, 2600, 1.0f, 3.0f, 26);
	public static final ToolMaterial RSADAMANTBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("RSADAMANTBATTLEAXEMATERIAL", 1, 3400, 1.0f, 4.0f, 10);
	public static final ToolMaterial RSRUNEBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("RSRUNEBATTLEAXEMATERIAL", 1, 4200, 1.0f, 5.0f, 32);
	public static final ToolMaterial RSDRAGONBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("RSDRAGONBATTLEAXEMATERIAL", 1, 5600, 1.0f, 6.0f, 15);
	public static final ToolMaterial RSBRONZESCIMITARMATERIAL = EnumHelper.addToolMaterial("RSBRONZESCIMITARMATERIAL", 1, 350, 1.0f, 2.0f, 16);
	public static final ToolMaterial RSIRONSCIMITARMATERIAL = EnumHelper.addToolMaterial("RSIRONSCIMITARMATERIAL", 1, 500, 1.0f, 2.0f, 14);
	public static final ToolMaterial RSBLACKSCIMITARMATERIAL = EnumHelper.addToolMaterial("RSBLACKSCIMITARMATERIAL", 1, 1600, 1.0f, 2.0f, 17);
	public static final ToolMaterial RSWHITESCIMITARMATERIAL = EnumHelper.addToolMaterial("RSWHITESCIMITARMATERIAL", 1, 1600, 1.0f, 2.0f, 17);
	public static final ToolMaterial RSSTEELSCIMITARMATERIAL = EnumHelper.addToolMaterial("RSSTEELSCIMITARMATERIAL", 1, 1600, 1.0f, 2.0f, 8);
	public static final ToolMaterial RSMITHRILSCIMITARMATERIAL = EnumHelper.addToolMaterial("RSMITHRILSCIMITARMATERIAL", 1, 2600, 1.0f, 3.0f, 26);
	public static final ToolMaterial RSADAMANTSCIMITARMATERIAL = EnumHelper.addToolMaterial("RSADAMANTSCIMITARMATERIAL", 1, 3400, 1.0f, 4.0f, 10);
	public static final ToolMaterial RSRUNESCIMITARMATERIAL = EnumHelper.addToolMaterial("RSRUNESCIMITARMATERIAL", 1, 4200, 1.0f, 5.0f, 32);
	public static final ToolMaterial RSDRAGONSCIMITARMATERIAL = EnumHelper.addToolMaterial("RSDRAGONSCIMITARMATERIAL", 1, 5600, 1.0f, 6.0f, 15);
	public static final ToolMaterial RSBRONZEWARHAMMERMATERIAL = EnumHelper.addToolMaterial("RSBRONZEWARHAMMERMATERIAL", 1, 2500, 1.0f, 3.0f, 16);
	public static final ToolMaterial RSIRONWARHAMMERMATERIAL = EnumHelper.addToolMaterial("RSIRONWARHAMMERMATERIAL", 1, 500, 1.0f, 2.0f, 14);
	public static final ToolMaterial RSSTEELWARHAMMERMATERIAL = EnumHelper.addToolMaterial("RSSTEELWARHAMMERMATERIAL", 1, 1600, 1.0f, 2.0f, 17);
	public static final ToolMaterial RSBLACKWARHAMMERMATERIAL = EnumHelper.addToolMaterial("RSBLACKWARHAMMERMATERIAL", 1, 1600, 1.0f, 2.0f, 17);
	public static final ToolMaterial RSWHITEWARHAMMERMATERIAL = EnumHelper.addToolMaterial("RSWHITEWARHAMMERMATERIAL", 1, 1600, 1.0f, 2.0f, 8);
	public static final ToolMaterial RSMITHRILWARHAMMERMATERIAL = EnumHelper.addToolMaterial("RSMITHRILWARHAMMERMATERIAL", 1, 2600, 1.0f, 3.0f, 26);
	public static final ToolMaterial RSADAMANTWARHAMMERMATERIAL = EnumHelper.addToolMaterial("RSADAMANTWARHAMMERMATERIAL", 1, 3400, 1.0f, 4.0f, 10);
	public static final ToolMaterial RSRUNEWARHAMMERMATERIAL = EnumHelper.addToolMaterial("RSRUNEWARHAMMERMATERIAL", 1, 4200, 1.0f, 5.0f, 32);
	public static final ToolMaterial RSBRONZEMACEMATERIAL = EnumHelper.addToolMaterial("RSBRONZEMACEMATERIAL", 1, 2500, 1.0f, 3.0f, 16);
	public static final ToolMaterial RSIRONMACEMATERIAL = EnumHelper.addToolMaterial("RSIRONMACEMATERIAL", 1, 500, 1.0f, 2.0f, 14);
	public static final ToolMaterial RSSTEELMACEMATERIAL = EnumHelper.addToolMaterial("RSSTEELMACEMATERIAL", 1, 1600, 1.0f, 2.0f, 17);
	public static final ToolMaterial RSBLACKMACEMATERIAL = EnumHelper.addToolMaterial("RSBLACKMACEMATERIAL", 1, 1600, 1.0f, 2.0f, 17);
	public static final ToolMaterial RSWHITEMACEMATERIAL = EnumHelper.addToolMaterial("RSWHITEMACEMATERIAL", 1, 1600, 1.0f, 2.0f, 8);
	public static final ToolMaterial RSMITHRILMACEMATERIAL = EnumHelper.addToolMaterial("RSMITHRILMACEMATERIAL", 1, 2600, 1.0f, 3.0f, 26);
	public static final ToolMaterial RSADAMANTMACEMATERIAL = EnumHelper.addToolMaterial("RSADAMANTMACEMATERIAL", 1, 3400, 1.0f, 4.0f, 10);
	public static final ToolMaterial RSRUNEMACEMATERIAL = EnumHelper.addToolMaterial("RSRUNEMACEMATERIAL", 1, 4200, 1.0f, 5.0f, 32);
	public static final ToolMaterial RSGRANITELONGSWORDMATERIAL = EnumHelper.addToolMaterial("RSGRANITELONGSWORDMATERIAL", 1, 2400, 1.0f, 6.0f, 5);
	public static final ToolMaterial RSGRANITEHAMMERMATERIAL = EnumHelper.addToolMaterial("RSGRANITEHAMMERMATERIAL", 1, 2000, 1.0f, 6.0f, 5);
	public static final ToolMaterial RSGRANITEMAULMATERIAL = EnumHelper.addToolMaterial("RSGRANITEMAULMATERIAL", 1, 2500, 1.0f, 7.0f, 5);
	public static final ToolMaterial RSELDERMAULMATERIAL = EnumHelper.addToolMaterial("RSELDERMAULMATERIAL", 1, 3200, 1.0f, 8.0f, 15);
	public static final ToolMaterial RSTOKTZXILAKMATERIAL = EnumHelper.addToolMaterial("RSTOKTZXILAKMATERIAL", 1, 3000, 1.0f, 5.0f, 15);
	public static final ToolMaterial RSWOLFSBANEMATERIAL = EnumHelper.addToolMaterial("RSWOLFSBANEMATERIAL", 1, 2500, 1.0f, 1.0f, 15);
	public static final ToolMaterial RSZAMORAKGODSWORDMATERIAL = EnumHelper.addToolMaterial("RSZAMORAKGODSWORDMATERIAL", 1, 2800, 1.0f, 5.0f, 18);
	public static final ToolMaterial RSBANDOSGODSWORDMATERIAL = EnumHelper.addToolMaterial("RSBANDOSGODSWORDMATERIAL", 1, 2801, 1.0f, 5.0f, 18);
	public static final ToolMaterial RSARMADYLGODSWORDMATERIAL = EnumHelper.addToolMaterial("RSARMADYLGODSWORDMATERIAL", 1, 2802, 1.0f, 5.0f, 18);
	public static final ToolMaterial RSSARADOMINGODSWORDMATERIAL = EnumHelper.addToolMaterial("RSSARADOMINGODSWORDMATERIAL", 1, 2803, 1.0f, 5.0f, 18);

	//dmc
	public static final ToolMaterial DMCREDQUEENMATERIAL = EnumHelper.addToolMaterial("DMCREDQUEENMATERIAL", 1, 2000, 1.0f, 3.0f, 15);
	public static final ToolMaterial DMCREBELLIONMATERIAL = EnumHelper.addToolMaterial("DMCREBELLIONMATERIAL", 1, 2000, 1.0f, 5.0f, 15);
	public static final ToolMaterial DMCYAMATOMATERIAL = EnumHelper.addToolMaterial("DMCYAMATOMATERIAL", 1, 2000, 1.0f, 4.0f, 12);

	
	//creative tab
	static final CreativeTabs tabHeroicArmory = new CreativeTabs("tabHeroicArmory") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(lotrNarsil);
		}		
	};
	
	public static void init() {

	    //CREATE ITEMS & ASSIGN CREATIVE TAB============================================================================
		
		//lotr
		lotrGimliBattleAxe = new Sword("lotrGimliBattleAxe", LOTRGIMLIBATTLEAXEMATERIAL).setCreativeTab(tabHeroicArmory);
		lotrGimliLongAxe = new Sword("lotrGimliLongAxe", LOTRGIMLILONGAXEMATERIAL).setCreativeTab(tabHeroicArmory);
		lotrMorgulBlade = new Sword("lotrMorgulBlade", LOTRMORGULBLADEMATERIAL).setCreativeTab(tabHeroicArmory);
		lotrSting = new Sword("lotrSting", LOTRSTINGMATERIAL).setCreativeTab(tabHeroicArmory);
		lotrGlamdring = new Sword("lotrGlamdring", LOTRGLAMDRINGMATERIAL).setCreativeTab(tabHeroicArmory);
		lotrAnduril = new Sword("lotrAnduril", LOTRANDURILMATERIAL).setCreativeTab(tabHeroicArmory);
		lotrNarsil = new Sword("lotrNarsil", LOTRNARSILMATERIAL).setCreativeTab(tabHeroicArmory);
		lotrSauronMace = new Sword("lotrSauronMace", LOTRSAURONMACEMATERIAL).setCreativeTab(tabHeroicArmory);
		lotrWitchKingSword = new Sword("lotrWitchKingSword", LOTRWITCHKINGSWORDMATERIAL).setCreativeTab(tabHeroicArmory);

		//loz
		lozMasterSword = new Sword("lozMasterSword", LOZMASTERSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		lozMasterSwordII = new Sword("lozMasterSwordII", LOZMASTERSWORDIIMATERIAL).setCreativeTab(tabHeroicArmory);
		lozTemperedSword = new Sword("lozTemperedSword", LOZTEMPEREDSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		lozMasterSwordIII = new Sword("lozMasterSwordIII", LOZMASTERSWORDIIIMATERIAL).setCreativeTab(tabHeroicArmory);
		lozGoldenSword = new Sword("lozGoldenSword", LOZGOLDENSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		lozFlameblade = new Sword("lozFlameblade", LOZFLAMEBLADEMATERIAL).setCreativeTab(tabHeroicArmory);
		lozDarknutSwordTp = new Sword("lozDarknutSwordTp", LOZDARKNUTSWORDTPMATERIAL).setCreativeTab(tabHeroicArmory);
		lozGhirahimSword = new Sword("lozGhirahimSword", LOZGHIRAHIMSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		lozFierceDietySword = new Sword("lozFierceDietySword", LOZFIERCEDIETYSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		lozZeldaSword = new Sword("lozZeldaSword", LOZZELDASWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		lozBokoStick = new Sword("lozBokoStick", LOZBOKOSTICKMATERIAL).setCreativeTab(tabHeroicArmory);
		lozCaneofByrna = new Sword("lozCaneofByrna", LOZCANEOFBYRNAMATERIAL).setCreativeTab(tabHeroicArmory);
		lozMegatonHammer = new Sword("lozMegatonHammer", LOZMEGATONHAMMERMATERIAL).setCreativeTab(tabHeroicArmory);
		lozKokiriSwordMm = new Sword("lozKokiriSwordMm", LOZKOKIRISWORDMMMATERIAL).setCreativeTab(tabHeroicArmory);
		lozKokiriSwordOoT = new Sword("lozKokiriSwordOoT", LOZKOKIRISWORDOOTMATERIAL).setCreativeTab(tabHeroicArmory);
		lozDemiseSword = new Sword("lozDemiseSword", LOZDEMISESWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		lozGiantKnife = new Sword("lozGiantKnife", LOZGIANTKNIFEMATERIAL).setCreativeTab(tabHeroicArmory);
		lozBiggoronSword = new Sword("lozBiggoronSword", LOZBIGGORONSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		lozPhantomGanonSword = new Sword("lozPhantomGanonSword", LOZPHANTOMGANONSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		lozUltimateSword = new Sword("lozUltimateSword", LOZULTIMATESWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		lozRoyalGuardSword = new Sword("lozRoyalGuardSword", LOZROYALGUARDSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		lozMagicSwordConcept = new Sword("lozMagicSwordConcept", LOZMAGICSWORDCONCEPTMATERIAL).setCreativeTab(tabHeroicArmory);
		lozMagicSword = new Sword("lozMagicSword", LOZMAGICSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		lozWhiteSword = new Sword("lozWhiteSword", LOZWHITESWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		lozWhiteSwordConcept = new Sword("lozWhiteSwordConcept", LOZWHITESWORDCONCEPTMATERIAL).setCreativeTab(tabHeroicArmory);
		lozPicoriBlade = new Sword("lozPicoriBlade", LOZPICORIBLADEMATERIAL).setCreativeTab(tabHeroicArmory);
		lozRazorSword = new Sword("lozRazorSword", LOZRAZORSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		lozGreatFairySword = new Sword("lozGreatFairySword", LOZGREATFAIRYSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		lozGoddessWhiteSword = new Sword("lozGoddessWhiteSword", LOZGODDESSWHITESWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		lozGoddessSword = new Sword("lozGoddessSword", LOZGODDESSSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		lozGildedSword = new Sword("lozGildedSword", LOZGILDEDSWORDMATERIAL).setCreativeTab(tabHeroicArmory);

		//at
		atJakeSword = new Sword("atJakeSword", ATJAKESWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		atCrystalSword = new Sword("atCrystalSword", ATCRYSTALSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		atNothung = new Sword("atNothung", ATNOTHUNGMATERIAL).setCreativeTab(tabHeroicArmory);
		atFinnSword = new Sword("atFinnSword", ATFINNSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		atSwordoftheDead = new Sword("atSwordoftheDead", ATSWORDOFTHEDEADMATERIAL).setCreativeTab(tabHeroicArmory);
		atWishStarSword = new Sword("atWishStarSword", ATWISHSTARSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		atFightKingSword = new Sword("atFightKingSword", ATFIGHTKINGSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		atRootSword = new Sword("atRootSword", ATROOTSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		atScarlet = new Sword("atScarlet", ATSCARLETMATERIAL).setCreativeTab(tabHeroicArmory);
		atGrassSword = new Sword("atGrassSword", ATGRASSSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		atDemonBloodSword = new Sword("atDemonBloodSword", ATDEMONBLOODSWORDMATERIAL).setCreativeTab(tabHeroicArmory);

		//ff
		ffTheMasamune = new Sword("ffTheMasamune", FFTHEMASAMUNEMATERIAL).setCreativeTab(tabHeroicArmory);
		ffBusterSword = new Sword("ffBusterSword", FFBUSTERSWORDMATERIAL).setCreativeTab(tabHeroicArmory);

		//rotmg
		rotmgSwordoftheColossus = new Sword("rotmgSwordoftheColossus", ROTMGSWORDOFTHECOLOSSUSMATERIAL).setCreativeTab(tabHeroicArmory);
		rotmgCrystalSword = new Sword("rotmgCrystalSword", ROTMGCRYSTALSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		rotmgPixieEnchantedSword = new Sword("rotmgPixieEnchantedSword", ROTMGPIXIEENCHANTEDSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		rotmgSwordOfAcclaim = new Sword("rotmgSwordOfAcclaim", ROTMGSWORDOFACCLAIMMATERIAL).setCreativeTab(tabHeroicArmory);
		rotmgDemonBlade = new Sword("rotmgDemonBlade", ROTMGDEMONBLADEMATERIAL).setCreativeTab(tabHeroicArmory);
		rotmgSwordoftheMadGod = new Sword("rotmgSwordoftheMadGod", ROTMGSWORDOFTHEMADGODMATERIAL).setCreativeTab(tabHeroicArmory);
		rotmgIndomptable = new Sword("rotmgIndomptable", ROTMGINDOMPTABLEMATERIAL).setCreativeTab(tabHeroicArmory);
		rotmgPirateKingCutlass = new Sword("rotmgPirateKingCutlass", ROTMGPIRATEKINGCUTLASSMATERIAL).setCreativeTab(tabHeroicArmory);
		rotmgSwordofSplendor = new Sword("rotmgSwordofSplendor", ROTMGSWORDOFSPLENDORMATERIAL).setCreativeTab(tabHeroicArmory);
		rotmgSkysplitterSword = new Sword("rotmgSkysplitterSword", ROTMGSKYSPLITTERSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		rotmgArchonSword = new Sword("rotmgArchonSword", ROTMGARCHONSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		rotmgAncientStoneSword = new Sword("rotmgAncientStoneSword", ROTMGANCIENTSTONESWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		rotmgDragonsoulSword = new Sword("rotmgDragonsoulSword", ROTMGDRAGONSOULSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		rotmgRavenheartSword = new Sword("rotmgRavenheartSword", ROTMGRAVENHEARTSWORDMATERIAL).setCreativeTab(tabHeroicArmory);

		//sc
		scFirangi = new Sword("scFirangi", SCFIRANGIMATERIAL).setCreativeTab(tabHeroicArmory);
		scCocytus = new Sword("scCocytus", SCCOCYTUSMATERIAL).setCreativeTab(tabHeroicArmory);
		scErlangBlade = new Sword("scErlangBlade", SCERLANGBLADEMATERIAL).setCreativeTab(tabHeroicArmory);
		scSoulEdgeNightmare = new Sword("scSoulEdgeNightmare", SCSOULEDGENIGHTMAREMATERIAL).setCreativeTab(tabHeroicArmory);
		scPhlegathon = new Sword("scPhlegathon", SCPHLEGATHONMATERIAL).setCreativeTab(tabHeroicArmory);
		scAcheron = new Sword("scAcheron", SCACHERONMATERIAL).setCreativeTab(tabHeroicArmory);
		scLethe = new Sword("scLethe", SCLETHEMATERIAL).setCreativeTab(tabHeroicArmory);

		//rs
		rsBronzeSword = new Sword("rsBronzeSword", RSBRONZESWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		rsIronSword = new Sword("rsIronSword", RSIRONSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		rsWhiteSword = new Sword("rsWhiteSword", RSWHITESWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		rsBlackSword = new Sword("rsBlackSword", RSBLACKSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		rsSteelSword = new Sword("rsSteelSword", RSSTEELSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		rsMithrilSword = new Sword("rsMithrilSword", RSMITHRILSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		rsAdamantSword = new Sword("rsAdamantSword", RSADAMANTSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		rsRuneSword = new Sword("rsRuneSword", RSRUNESWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		rsDragonSword = new Sword("rsDragonSword", RSDRAGONSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		rsBronzeBattleaxe = new Sword("rsBronzeBattleaxe", RSBRONZEBATTLEAXEMATERIAL).setCreativeTab(tabHeroicArmory);
		rsIronBattleaxe = new Sword("rsIronBattleaxe", RSIRONBATTLEAXEMATERIAL).setCreativeTab(tabHeroicArmory);
		rsSteelBattleaxe = new Sword("rsSteelBattleaxe", RSSTEELBATTLEAXEMATERIAL).setCreativeTab(tabHeroicArmory);
		rsBlackBattleaxe = new Sword("rsBlackBattleaxe", RSBLACKBATTLEAXEMATERIAL).setCreativeTab(tabHeroicArmory);
		rsWhiteBattleaxe = new Sword("rsWhiteBattleaxe", RSWHITEBATTLEAXEMATERIAL).setCreativeTab(tabHeroicArmory);
		rsMithrilBattleaxe = new Sword("rsMithrilBattleaxe", RSMITHRILBATTLEAXEMATERIAL).setCreativeTab(tabHeroicArmory);
		rsAdamantBattleaxe = new Sword("rsAdamantBattleaxe", RSADAMANTBATTLEAXEMATERIAL).setCreativeTab(tabHeroicArmory);
		rsRuneBattleaxe = new Sword("rsRuneBattleaxe", RSRUNEBATTLEAXEMATERIAL).setCreativeTab(tabHeroicArmory);
		rsDragonBattleaxe = new Sword("rsDragonBattleaxe", RSDRAGONBATTLEAXEMATERIAL).setCreativeTab(tabHeroicArmory);
		rsBronzeScimitar = new Sword("rsBronzeScimitar", RSBRONZESCIMITARMATERIAL).setCreativeTab(tabHeroicArmory);
		rsIronScimitar = new Sword("rsIronScimitar", RSIRONSCIMITARMATERIAL).setCreativeTab(tabHeroicArmory);
		rsBlackScimitar = new Sword("rsBlackScimitar", RSBLACKSCIMITARMATERIAL).setCreativeTab(tabHeroicArmory);
		rsWhiteScimitar = new Sword("rsWhiteScimitar", RSWHITESCIMITARMATERIAL).setCreativeTab(tabHeroicArmory);
		rsSteelScimitar = new Sword("rsSteelScimitar", RSSTEELSCIMITARMATERIAL).setCreativeTab(tabHeroicArmory);
		rsMithrilScimitar = new Sword("rsMithrilScimitar", RSMITHRILSCIMITARMATERIAL).setCreativeTab(tabHeroicArmory);
		rsAdamantScimitar = new Sword("rsAdamantScimitar", RSADAMANTSCIMITARMATERIAL).setCreativeTab(tabHeroicArmory);
		rsRuneScimitar = new Sword("rsRuneScimitar", RSRUNESCIMITARMATERIAL).setCreativeTab(tabHeroicArmory);
		rsDragonScimitar = new Sword("rsDragonScimitar", RSDRAGONSCIMITARMATERIAL).setCreativeTab(tabHeroicArmory);
		rsBronzeWarhammer = new Sword("rsBronzeWarhammer", RSBRONZEWARHAMMERMATERIAL).setCreativeTab(tabHeroicArmory);
		rsIronWarhammer = new Sword("rsIronWarhammer", RSIRONWARHAMMERMATERIAL).setCreativeTab(tabHeroicArmory);
		rsSteelWarhammer = new Sword("rsSteelWarhammer", RSSTEELWARHAMMERMATERIAL).setCreativeTab(tabHeroicArmory);
		rsBlackWarhammer = new Sword("rsBlackWarhammer", RSBLACKWARHAMMERMATERIAL).setCreativeTab(tabHeroicArmory);
		rsWhiteWarhammer = new Sword("rsWhiteWarhammer", RSWHITEWARHAMMERMATERIAL).setCreativeTab(tabHeroicArmory);
		rsMithrilWarhammer = new Sword("rsMithrilWarhammer", RSMITHRILWARHAMMERMATERIAL).setCreativeTab(tabHeroicArmory);
		rsAdamantWarhammer = new Sword("rsAdamantWarhammer", RSADAMANTWARHAMMERMATERIAL).setCreativeTab(tabHeroicArmory);
		rsRuneWarhammer = new Sword("rsRuneWarhammer", RSRUNEWARHAMMERMATERIAL).setCreativeTab(tabHeroicArmory);
		rsBronzeMace = new Sword("rsBronzeMace", RSBRONZEMACEMATERIAL).setCreativeTab(tabHeroicArmory);
		rsIronMace = new Sword("rsIronMace", RSIRONMACEMATERIAL).setCreativeTab(tabHeroicArmory);
		rsSteelMace = new Sword("rsSteelMace", RSSTEELMACEMATERIAL).setCreativeTab(tabHeroicArmory);
		rsBlackMace = new Sword("rsBlackMace", RSBLACKMACEMATERIAL).setCreativeTab(tabHeroicArmory);
		rsWhiteMace = new Sword("rsWhiteMace", RSWHITEMACEMATERIAL).setCreativeTab(tabHeroicArmory);
		rsMithrilMace = new Sword("rsMithrilMace", RSMITHRILMACEMATERIAL).setCreativeTab(tabHeroicArmory);
		rsAdamantMace = new Sword("rsAdamantMace", RSADAMANTMACEMATERIAL).setCreativeTab(tabHeroicArmory);
		rsRuneMace = new Sword("rsRuneMace", RSRUNEMACEMATERIAL).setCreativeTab(tabHeroicArmory);
		rsGraniteLongsword = new Sword("rsGraniteLongsword", RSGRANITELONGSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		rsGraniteHammer = new Sword("rsGraniteHammer", RSGRANITEHAMMERMATERIAL).setCreativeTab(tabHeroicArmory);
		rsGraniteMaul = new Sword("rsGraniteMaul", RSGRANITEMAULMATERIAL).setCreativeTab(tabHeroicArmory);
		rsElderMaul = new Sword("rsElderMaul", RSELDERMAULMATERIAL).setCreativeTab(tabHeroicArmory);
		rsToktzxilak = new Sword("rsToktzxilak", RSTOKTZXILAKMATERIAL).setCreativeTab(tabHeroicArmory);
		rsWolfsbane = new Sword("rsWolfsbane", RSWOLFSBANEMATERIAL).setCreativeTab(tabHeroicArmory);
		rsZamorakGodsword = new Sword("rsZamorakGodsword", RSZAMORAKGODSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		rsBandosGodsword = new Sword("rsBandosGodsword", RSBANDOSGODSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		rsArmadylGodsword = new Sword("rsArmadylGodsword", RSARMADYLGODSWORDMATERIAL).setCreativeTab(tabHeroicArmory);
		rsSaradominGodsword = new Sword("rsSaradominGodsword", RSSARADOMINGODSWORDMATERIAL).setCreativeTab(tabHeroicArmory);

		//dmc
		dmcRedQueen = new Sword("dmcRedQueen", DMCREDQUEENMATERIAL).setCreativeTab(tabHeroicArmory);
		dmcRebellion = new Sword("dmcRebellion", DMCREBELLIONMATERIAL).setCreativeTab(tabHeroicArmory);
		dmcYamato = new Sword("dmcYamato", DMCYAMATOMATERIAL).setCreativeTab(tabHeroicArmory);

		
		//Loot Tables
		LootTableList.register(new ResourceLocation("heroicarmory", "loot"));
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {

	    //REGISTER ITEMS================================================================================================
	    
		//lotr
		event.getRegistry().registerAll(lotrGimliBattleAxe,lotrGimliLongAxe,lotrMorgulBlade,lotrSting,lotrGlamdring,lotrAnduril,lotrNarsil,lotrSauronMace,lotrWitchKingSword);

		//loz
		event.getRegistry().registerAll(lozMasterSword,lozMasterSwordII,lozTemperedSword,lozMasterSwordIII,lozGoldenSword,lozFlameblade,lozDarknutSwordTp,lozGhirahimSword,lozFierceDietySword,lozZeldaSword,lozBokoStick,lozCaneofByrna,lozMegatonHammer,lozKokiriSwordMm,lozKokiriSwordOoT,lozDemiseSword,lozGiantKnife,lozBiggoronSword,lozPhantomGanonSword,lozUltimateSword,lozRoyalGuardSword,lozMagicSwordConcept,lozMagicSword,lozWhiteSword,lozWhiteSwordConcept,lozPicoriBlade,lozRazorSword,lozGreatFairySword,lozGoddessWhiteSword,lozGoddessSword,lozGildedSword);

		//at
		event.getRegistry().registerAll(atJakeSword,atCrystalSword,atNothung,atFinnSword,atSwordoftheDead,atWishStarSword,atFightKingSword,atRootSword,atScarlet,atGrassSword,atDemonBloodSword);

		//ff
		event.getRegistry().registerAll(ffTheMasamune,ffBusterSword);

		//rotmg
		event.getRegistry().registerAll(rotmgSwordoftheColossus,rotmgCrystalSword,rotmgPixieEnchantedSword,rotmgSwordOfAcclaim,rotmgDemonBlade,rotmgSwordoftheMadGod,rotmgIndomptable,rotmgPirateKingCutlass,rotmgSwordofSplendor,rotmgSkysplitterSword,rotmgArchonSword,rotmgAncientStoneSword,rotmgDragonsoulSword,rotmgRavenheartSword);

		//sc
		event.getRegistry().registerAll(scFirangi,scCocytus,scErlangBlade,scSoulEdgeNightmare,scPhlegathon,scAcheron,scLethe);

		//rs
		event.getRegistry().registerAll(rsBronzeSword,rsIronSword,rsWhiteSword,rsBlackSword,rsSteelSword,rsMithrilSword,rsAdamantSword,rsRuneSword,rsDragonSword,rsBronzeBattleaxe,rsIronBattleaxe,rsSteelBattleaxe,rsBlackBattleaxe,rsWhiteBattleaxe,rsMithrilBattleaxe,rsAdamantBattleaxe,rsRuneBattleaxe,rsDragonBattleaxe,rsBronzeScimitar,rsIronScimitar,rsBlackScimitar,rsWhiteScimitar,rsSteelScimitar,rsMithrilScimitar,rsAdamantScimitar,rsRuneScimitar,rsDragonScimitar,rsBronzeWarhammer,rsIronWarhammer,rsSteelWarhammer,rsBlackWarhammer,rsWhiteWarhammer,rsMithrilWarhammer,rsAdamantWarhammer,rsRuneWarhammer,rsBronzeMace,rsIronMace,rsSteelMace,rsBlackMace,rsWhiteMace,rsMithrilMace,rsAdamantMace,rsRuneMace,rsGraniteLongsword,rsGraniteHammer,rsGraniteMaul,rsElderMaul,rsToktzxilak,rsWolfsbane,rsZamorakGodsword,rsBandosGodsword,rsArmadylGodsword,rsSaradominGodsword);

		//dmc
		event.getRegistry().registerAll(dmcRedQueen,dmcRebellion,dmcYamato);


	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {

        //REGISTER RENDERS==============================================================================================
        
		//lotr
		registerRender(lotrGimliBattleAxe);
		registerRender(lotrGimliLongAxe);
		registerRender(lotrMorgulBlade);
		registerRender(lotrSting);
		registerRender(lotrGlamdring);
		registerRender(lotrAnduril);
		registerRender(lotrNarsil);
		registerRender(lotrSauronMace);
		registerRender(lotrWitchKingSword);

		//loz
		registerRender(lozMasterSword);
		registerRender(lozMasterSwordII);
		registerRender(lozTemperedSword);
		registerRender(lozMasterSwordIII);
		registerRender(lozGoldenSword);
		registerRender(lozFlameblade);
		registerRender(lozDarknutSwordTp);
		registerRender(lozGhirahimSword);
		registerRender(lozFierceDietySword);
		registerRender(lozZeldaSword);
		registerRender(lozBokoStick);
		registerRender(lozCaneofByrna);
		registerRender(lozMegatonHammer);
		registerRender(lozKokiriSwordMm);
		registerRender(lozKokiriSwordOoT);
		registerRender(lozDemiseSword);
		registerRender(lozGiantKnife);
		registerRender(lozBiggoronSword);
		registerRender(lozPhantomGanonSword);
		registerRender(lozUltimateSword);
		registerRender(lozRoyalGuardSword);
		registerRender(lozMagicSwordConcept);
		registerRender(lozMagicSword);
		registerRender(lozWhiteSword);
		registerRender(lozWhiteSwordConcept);
		registerRender(lozPicoriBlade);
		registerRender(lozRazorSword);
		registerRender(lozGreatFairySword);
		registerRender(lozGoddessWhiteSword);
		registerRender(lozGoddessSword);
		registerRender(lozGildedSword);

		//at
		registerRender(atJakeSword);
		registerRender(atCrystalSword);
		registerRender(atNothung);
		registerRender(atFinnSword);
		registerRender(atSwordoftheDead);
		registerRender(atWishStarSword);
		registerRender(atFightKingSword);
		registerRender(atRootSword);
		registerRender(atScarlet);
		registerRender(atGrassSword);
		registerRender(atDemonBloodSword);

		//ff
		registerRender(ffTheMasamune);
		registerRender(ffBusterSword);

		//rotmg
		registerRender(rotmgSwordoftheColossus);
		registerRender(rotmgCrystalSword);
		registerRender(rotmgPixieEnchantedSword);
		registerRender(rotmgSwordOfAcclaim);
		registerRender(rotmgDemonBlade);
		registerRender(rotmgSwordoftheMadGod);
		registerRender(rotmgIndomptable);
		registerRender(rotmgPirateKingCutlass);
		registerRender(rotmgSwordofSplendor);
		registerRender(rotmgSkysplitterSword);
		registerRender(rotmgArchonSword);
		registerRender(rotmgAncientStoneSword);
		registerRender(rotmgDragonsoulSword);
		registerRender(rotmgRavenheartSword);

		//sc
		registerRender(scFirangi);
		registerRender(scCocytus);
		registerRender(scErlangBlade);
		registerRender(scSoulEdgeNightmare);
		registerRender(scPhlegathon);
		registerRender(scAcheron);
		registerRender(scLethe);

		//rs
		registerRender(rsBronzeSword);
		registerRender(rsIronSword);
		registerRender(rsWhiteSword);
		registerRender(rsBlackSword);
		registerRender(rsSteelSword);
		registerRender(rsMithrilSword);
		registerRender(rsAdamantSword);
		registerRender(rsRuneSword);
		registerRender(rsDragonSword);
		registerRender(rsBronzeBattleaxe);
		registerRender(rsIronBattleaxe);
		registerRender(rsSteelBattleaxe);
		registerRender(rsBlackBattleaxe);
		registerRender(rsWhiteBattleaxe);
		registerRender(rsMithrilBattleaxe);
		registerRender(rsAdamantBattleaxe);
		registerRender(rsRuneBattleaxe);
		registerRender(rsDragonBattleaxe);
		registerRender(rsBronzeScimitar);
		registerRender(rsIronScimitar);
		registerRender(rsBlackScimitar);
		registerRender(rsWhiteScimitar);
		registerRender(rsSteelScimitar);
		registerRender(rsMithrilScimitar);
		registerRender(rsAdamantScimitar);
		registerRender(rsRuneScimitar);
		registerRender(rsDragonScimitar);
		registerRender(rsBronzeWarhammer);
		registerRender(rsIronWarhammer);
		registerRender(rsSteelWarhammer);
		registerRender(rsBlackWarhammer);
		registerRender(rsWhiteWarhammer);
		registerRender(rsMithrilWarhammer);
		registerRender(rsAdamantWarhammer);
		registerRender(rsRuneWarhammer);
		registerRender(rsBronzeMace);
		registerRender(rsIronMace);
		registerRender(rsSteelMace);
		registerRender(rsBlackMace);
		registerRender(rsWhiteMace);
		registerRender(rsMithrilMace);
		registerRender(rsAdamantMace);
		registerRender(rsRuneMace);
		registerRender(rsGraniteLongsword);
		registerRender(rsGraniteHammer);
		registerRender(rsGraniteMaul);
		registerRender(rsElderMaul);
		registerRender(rsToktzxilak);
		registerRender(rsWolfsbane);
		registerRender(rsZamorakGodsword);
		registerRender(rsBandosGodsword);
		registerRender(rsArmadylGodsword);
		registerRender(rsSaradominGodsword);

		//dmc
		registerRender(dmcRedQueen);
		registerRender(dmcRebellion);
		registerRender(dmcYamato);


	}
	
	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	
	//loot tables
	@SubscribeEvent
	public static void lootLoad(LootTableLoadEvent evt) {
		String name = evt.getName().toString();
		
		if (name.contains("chest")) {
			System.out.println("added loot to loot table " + name);
			LootEntry entry = new LootEntryTable(new ResourceLocation("heroicarmory:loot"), 1, 0, new LootCondition[0], "heroicarmorylootentry"); 

			LootPool pool = new LootPool(new LootEntry[] {entry}, new LootCondition[0], new RandomValueRange(1), new RandomValueRange(1), "heroicarmorypool"); 
			
			evt.getTable().addPool(pool);
		}
	}

}