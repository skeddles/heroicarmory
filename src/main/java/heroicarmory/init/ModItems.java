package heroicarmory.init;

import heroicarmory.Reference;
import heroicarmory.items.ItemBasic;
import heroicarmory.items.Sword;
import heroicarmory.ModConfig;

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
import net.minecraft.init.Items;
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

import java.util.ArrayList;
import static java.lang.Math.ceil;

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
	static Item lozSpikedBokoClub;
	static Item lozBokoClub;

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
	static Item atAxeBass;

	//ff
	static Item ffTheMasamune;
	static Item ffBusterSword;
	static Item ffCaladbolg;

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
	static Item scQueenGuard;
	static Item scHolyAntler;
	static Item scEpee;
	static Item scWarHammer;
	static Item scKalutues;
	static Item scEstoc;
	static Item scFlambert2P;
	static Item scReiterpallasch;
	static Item scFlambert;
	static Item scBlueCrystalRod;
	static Item scFireBlade;
	static Item scXiSword;
	static Item scOmegaSword2P;
	static Item scOmegaSword;
	static Item scOrichalcum;
	static Item scStiletto;
	static Item scRequiem;
	static Item scFaust;
	static Item scFlamberge;
	static Item scSteelPaddle;
	static Item scGlam;
	static Item scGreatBlade;

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
	static Item rsBarrelchestAnchor;

	//dmc
	static Item dmcRedQueen;
	static Item dmcRebellion;
	static Item dmcYamato;

	//pkmn
	static Item pkmnHonedgeShiny;
	static Item pkmnHonedge;

	//kirby
	static Item kirbyGalaxia;
	static Item kirbyKirbyUltraSword;
	static Item kirbyKirbySword;

	//fe
	static Item feChromFalchion;
	static Item feFalchion;

	//kh
	static Item khKeyblade;

	//bleach
	static Item bleachZabimaru;
	static Item bleachZangestsu;

	//ds
	static Item dsGreatswordofArtorias;
	static Item dsGreatLordGreatsword;
	static Item dsAstoraGreatsword;
	static Item dsZweilhander;

	//myth
	static Item mythDeathScythe;
	static Item mythTheDevilPitchfork;

	//bayonetta
	static Item bayonettaShuraba;
	static Item bayonettaAngelSlayer;

	//gow
	static Item gowLeviathanUpgraded;
	static Item gowLeviathan;
	static Item gowBladeofOlympus;
	static Item gowBladeofChaos;

	//skyrim
	static Item skyrimIronSword;
	static Item skyrimIronWarhammer;
	static Item skyrimSteelSword;
	static Item skyrimSteelWarhammer;
	static Item skyrimOrcishSword;
	static Item skyrimOrcishWarhammer;
	static Item skyrimDwarvenSword;
	static Item skyrimDwarvenWarhammer;
	static Item skyrimElvenSword;
	static Item skyrimElvenWarhammer;
	static Item skyrimGlassSword;
	static Item skyrimGlassWarhammer;
	static Item skyrimEbonySword;
	static Item skyrimEbonyWarhammer;
	static Item skyrimDaedricSword;
	static Item skyrimDaedricWarhammer;
	static Item skyrimDragonboneSword;
	static Item skyrimDragonboneWarhammer;
	static Item skyrimImperialSword;
	static Item skyrimDawnbreaker;
	static Item skyrimAncientNordSword;
	static Item skyrimChillrend;
	static Item skyrimEbonyBlade;

	//mh
	static Item mhChickenDecapitator;
	static Item mhGolemBlade;
	static Item mhDefender;
	static Item mhBlackBeltBlade;
	static Item mhWailingCleaver;
	static Item mhGaelicFlame;
	static Item mhBoneKatana;
	static Item mhHellishSlasher;
	static Item mhCentenarianDagger;
	static Item mhWyvernBladeBlood;
	static Item mhWyvernBladeHolly;
	static Item mhWyvernBladePale;
	static Item mhWyvernBladeAzure;
	static Item mhWyvernBladeLeaf;
	static Item mhRathalosFlamesword;

	//terraria
	static Item terrariaPalmWoodSword;
	static Item terrariaBorealWoodSword;
	static Item terrariaShadewoodSword;
	static Item terrariaEbonwoodSword;
	static Item terrariaCopperShortsword;
	static Item terrariaCopperBroadsword;
	static Item terrariaTinShortsword;
	static Item terrariaTinBroadsword;
	static Item terrariaLeadShortsword;
	static Item terrariaLeadBroadsword;
	static Item terrariaSpear;
	static Item terrariaIronShortsword;
	static Item terrariaIronBroadsword;
	static Item terrariaSilverBroadsword;
	static Item terrariaSilverShortsword;
	static Item terrariaGoldShortsword;
	static Item terrariaGoldBroadsword;
	static Item terrariaTungstenBroadsword;
	static Item terrariaTungstenShortsword;
	static Item terrariaPlatinumShortsword;
	static Item terrariaPlatinumBroadsword;
	static Item terrariaMandibleBlade;
	static Item terrariaKatana;
	static Item terrariaExoticScimitar;
	static Item terrariaMuramasa;
	static Item terrariaFalconBlade;
	static Item terrariaBladeofGrass;
	static Item terrariaFieryGreatsword;
	static Item terrariaBoneSword;
	static Item terrariaBloodButcherer;
	static Item terrariaEnchantedSword;
	static Item terrariaStarfury;
	static Item terrariaBeeKeeper;
	static Item terrariaIceBlade;
	static Item terrariaNightEdge;
	static Item terrariaArkhalis;
	static Item terrariaTrident;
	static Item terrariaTheRottedFork;
	static Item terrariaWhitePhaseblade;
	static Item terrariaYellowPhaseblade;
	static Item terrariaPurplePhaseblade;
	static Item terrariaGreenPhaseblade;
	static Item terrariaRedPhaseblade;
	static Item terrariaBluePhaseblade;
	static Item terrariaLightBane;
	static Item terrariaDarkLance;
	static Item terrariaPurpleClubberfish;
	static Item terrariaCactusSword;
	static Item terrariaSwordfish;

	//sw
	static Item swYellowLightsaber;
	static Item swGreenLightsaber;
	static Item swBlueLightsaber;
	static Item swRedLightsaber;
	static Item swMaceWinduLightsaber;
	static Item swTheInquisitorLightsaber;
	static Item swDarthMaulLightsaber;
	static Item swQuiGonJinnLightsaber;
	static Item swKyloRenLightsaber;
	static Item swCountDookuLightsaber;
	static Item swDarksaber;

	//internet
	static Item internetDemonoidPitchfork;

	//nh
	static Item nhMagicbane;
	static Item nhAthame;
	static Item nhGrayswandir;
	static Item nhSilverSaber;

	//abcm
	static Item abcmExcalibur;


    //MATERIAL VARIABLES================================================================================================
    
	//lotr
	public static final ToolMaterial LOTRGIMLIBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("LOTRGIMLIBATTLEAXEMATERIAL", 1, 4100, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 8);
	public static final ToolMaterial LOTRGIMLILONGAXEMATERIAL = EnumHelper.addToolMaterial("LOTRGIMLILONGAXEMATERIAL", 1, 3600, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 8);
	public static final ToolMaterial LOTRMORGULBLADEMATERIAL = EnumHelper.addToolMaterial("LOTRMORGULBLADEMATERIAL", 1, 100, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial LOTRSTINGMATERIAL = EnumHelper.addToolMaterial("LOTRSTINGMATERIAL", 1, 2100, 1.0f, (float) ((5.0f) * ModConfig.damageScale - 4.0f), 28);
	public static final ToolMaterial LOTRGLAMDRINGMATERIAL = EnumHelper.addToolMaterial("LOTRGLAMDRINGMATERIAL", 1, 3000, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 30);
	public static final ToolMaterial LOTRANDURILMATERIAL = EnumHelper.addToolMaterial("LOTRANDURILMATERIAL", 1, 1000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 12);
	public static final ToolMaterial LOTRNARSILMATERIAL = EnumHelper.addToolMaterial("LOTRNARSILMATERIAL", 1, 2000, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 12);
	public static final ToolMaterial LOTRSAURONMACEMATERIAL = EnumHelper.addToolMaterial("LOTRSAURONMACEMATERIAL", 1, 3000, 1.0f, (float) ((14.0f) * ModConfig.damageScale - 4.0f), 8);
	public static final ToolMaterial LOTRWITCHKINGSWORDMATERIAL = EnumHelper.addToolMaterial("LOTRWITCHKINGSWORDMATERIAL", 1, 2500, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);

	//loz
	public static final ToolMaterial LOZMASTERSWORDMATERIAL = EnumHelper.addToolMaterial("LOZMASTERSWORDMATERIAL", 1, 3000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial LOZMASTERSWORDIIMATERIAL = EnumHelper.addToolMaterial("LOZMASTERSWORDIIMATERIAL", 1, 4500, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial LOZTEMPEREDSWORDMATERIAL = EnumHelper.addToolMaterial("LOZTEMPEREDSWORDMATERIAL", 1, 4500, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial LOZMASTERSWORDIIIMATERIAL = EnumHelper.addToolMaterial("LOZMASTERSWORDIIIMATERIAL", 1, 7000, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 8);
	public static final ToolMaterial LOZGOLDENSWORDMATERIAL = EnumHelper.addToolMaterial("LOZGOLDENSWORDMATERIAL", 1, 7000, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 8);
	public static final ToolMaterial LOZFLAMEBLADEMATERIAL = EnumHelper.addToolMaterial("LOZFLAMEBLADEMATERIAL", 1, 2000, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial LOZDARKNUTSWORDTPMATERIAL = EnumHelper.addToolMaterial("LOZDARKNUTSWORDTPMATERIAL", 1, 2800, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 12);
	public static final ToolMaterial LOZGHIRAHIMSWORDMATERIAL = EnumHelper.addToolMaterial("LOZGHIRAHIMSWORDMATERIAL", 1, 3000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 18);
	public static final ToolMaterial LOZFIERCEDIETYSWORDMATERIAL = EnumHelper.addToolMaterial("LOZFIERCEDIETYSWORDMATERIAL", 1, 1600, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 20);
	public static final ToolMaterial LOZZELDASWORDMATERIAL = EnumHelper.addToolMaterial("LOZZELDASWORDMATERIAL", 1, 2000, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 18);
	public static final ToolMaterial LOZBOKOSTICKMATERIAL = EnumHelper.addToolMaterial("LOZBOKOSTICKMATERIAL", 1, 150, 1.0f, (float) ((4.0f) * ModConfig.damageScale - 4.0f), 20);
	public static final ToolMaterial LOZCANEOFBYRNAMATERIAL = EnumHelper.addToolMaterial("LOZCANEOFBYRNAMATERIAL", 1, 800, 1.0f, (float) ((5.0f) * ModConfig.damageScale - 4.0f), 32);
	public static final ToolMaterial LOZMEGATONHAMMERMATERIAL = EnumHelper.addToolMaterial("LOZMEGATONHAMMERMATERIAL", 1, 3200, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial LOZKOKIRISWORDMMMATERIAL = EnumHelper.addToolMaterial("LOZKOKIRISWORDMMMATERIAL", 1, 750, 1.0f, (float) ((5.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial LOZKOKIRISWORDOOTMATERIAL = EnumHelper.addToolMaterial("LOZKOKIRISWORDOOTMATERIAL", 1, 750, 1.0f, (float) ((5.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial LOZDEMISESWORDMATERIAL = EnumHelper.addToolMaterial("LOZDEMISESWORDMATERIAL", 1, 2000, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 8);
	public static final ToolMaterial LOZGIANTKNIFEMATERIAL = EnumHelper.addToolMaterial("LOZGIANTKNIFEMATERIAL", 1, 40, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial LOZBIGGORONSWORDMATERIAL = EnumHelper.addToolMaterial("LOZBIGGORONSWORDMATERIAL", 1, 8000, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial LOZPHANTOMGANONSWORDMATERIAL = EnumHelper.addToolMaterial("LOZPHANTOMGANONSWORDMATERIAL", 1, 3000, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial LOZULTIMATESWORDMATERIAL = EnumHelper.addToolMaterial("LOZULTIMATESWORDMATERIAL", 1, 1000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial LOZROYALGUARDSWORDMATERIAL = EnumHelper.addToolMaterial("LOZROYALGUARDSWORDMATERIAL", 1, 1500, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial LOZMAGICSWORDCONCEPTMATERIAL = EnumHelper.addToolMaterial("LOZMAGICSWORDCONCEPTMATERIAL", 1, 1600, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 38);
	public static final ToolMaterial LOZMAGICSWORDMATERIAL = EnumHelper.addToolMaterial("LOZMAGICSWORDMATERIAL", 1, 1600, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 38);
	public static final ToolMaterial LOZWHITESWORDMATERIAL = EnumHelper.addToolMaterial("LOZWHITESWORDMATERIAL", 1, 2600, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial LOZWHITESWORDCONCEPTMATERIAL = EnumHelper.addToolMaterial("LOZWHITESWORDCONCEPTMATERIAL", 1, 2600, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial LOZPICORIBLADEMATERIAL = EnumHelper.addToolMaterial("LOZPICORIBLADEMATERIAL", 1, 2000, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial LOZRAZORSWORDMATERIAL = EnumHelper.addToolMaterial("LOZRAZORSWORDMATERIAL", 1, 2600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 12);
	public static final ToolMaterial LOZGREATFAIRYSWORDMATERIAL = EnumHelper.addToolMaterial("LOZGREATFAIRYSWORDMATERIAL", 1, 2800, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 20);
	public static final ToolMaterial LOZGODDESSWHITESWORDMATERIAL = EnumHelper.addToolMaterial("LOZGODDESSWHITESWORDMATERIAL", 1, 1600, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial LOZGODDESSSWORDMATERIAL = EnumHelper.addToolMaterial("LOZGODDESSSWORDMATERIAL", 1, 1600, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial LOZGILDEDSWORDMATERIAL = EnumHelper.addToolMaterial("LOZGILDEDSWORDMATERIAL", 1, 2800, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 28);
	public static final ToolMaterial LOZSPIKEDBOKOCLUBMATERIAL = EnumHelper.addToolMaterial("LOZSPIKEDBOKOCLUBMATERIAL", 1, 900, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial LOZBOKOCLUBMATERIAL = EnumHelper.addToolMaterial("LOZBOKOCLUBMATERIAL", 1, 650, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);

	//at
	public static final ToolMaterial ATJAKESWORDMATERIAL = EnumHelper.addToolMaterial("ATJAKESWORDMATERIAL", 1, 2000, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial ATCRYSTALSWORDMATERIAL = EnumHelper.addToolMaterial("ATCRYSTALSWORDMATERIAL", 1, 3000, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial ATNOTHUNGMATERIAL = EnumHelper.addToolMaterial("ATNOTHUNGMATERIAL", 1, 3000, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial ATFINNSWORDMATERIAL = EnumHelper.addToolMaterial("ATFINNSWORDMATERIAL", 1, 2800, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 11);
	public static final ToolMaterial ATSWORDOFTHEDEADMATERIAL = EnumHelper.addToolMaterial("ATSWORDOFTHEDEADMATERIAL", 1, 2800, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial ATWISHSTARSWORDMATERIAL = EnumHelper.addToolMaterial("ATWISHSTARSWORDMATERIAL", 1, 2800, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial ATFIGHTKINGSWORDMATERIAL = EnumHelper.addToolMaterial("ATFIGHTKINGSWORDMATERIAL", 1, 400, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 5);
	public static final ToolMaterial ATROOTSWORDMATERIAL = EnumHelper.addToolMaterial("ATROOTSWORDMATERIAL", 1, 1800, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial ATSCARLETMATERIAL = EnumHelper.addToolMaterial("ATSCARLETMATERIAL", 1, 2800, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 28);
	public static final ToolMaterial ATGRASSSWORDMATERIAL = EnumHelper.addToolMaterial("ATGRASSSWORDMATERIAL", 1, 600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 14);
	public static final ToolMaterial ATDEMONBLOODSWORDMATERIAL = EnumHelper.addToolMaterial("ATDEMONBLOODSWORDMATERIAL", 1, 2800, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 22);
	public static final ToolMaterial ATAXEBASSMATERIAL = EnumHelper.addToolMaterial("ATAXEBASSMATERIAL", 1, 2000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);

	//ff
	public static final ToolMaterial FFTHEMASAMUNEMATERIAL = EnumHelper.addToolMaterial("FFTHEMASAMUNEMATERIAL", 1, 3000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial FFBUSTERSWORDMATERIAL = EnumHelper.addToolMaterial("FFBUSTERSWORDMATERIAL", 1, 3000, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial FFCALADBOLGMATERIAL = EnumHelper.addToolMaterial("FFCALADBOLGMATERIAL", 1, 2000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);

	//rotmg
	public static final ToolMaterial ROTMGSWORDOFTHECOLOSSUSMATERIAL = EnumHelper.addToolMaterial("ROTMGSWORDOFTHECOLOSSUSMATERIAL", 1, 3600, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial ROTMGCRYSTALSWORDMATERIAL = EnumHelper.addToolMaterial("ROTMGCRYSTALSWORDMATERIAL", 1, 2200, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial ROTMGPIXIEENCHANTEDSWORDMATERIAL = EnumHelper.addToolMaterial("ROTMGPIXIEENCHANTEDSWORDMATERIAL", 1, 1400, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial ROTMGSWORDOFACCLAIMMATERIAL = EnumHelper.addToolMaterial("ROTMGSWORDOFACCLAIMMATERIAL", 1, 2600, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial ROTMGDEMONBLADEMATERIAL = EnumHelper.addToolMaterial("ROTMGDEMONBLADEMATERIAL", 1, 3200, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial ROTMGSWORDOFTHEMADGODMATERIAL = EnumHelper.addToolMaterial("ROTMGSWORDOFTHEMADGODMATERIAL", 1, 2800, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial ROTMGINDOMPTABLEMATERIAL = EnumHelper.addToolMaterial("ROTMGINDOMPTABLEMATERIAL", 1, 600, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial ROTMGPIRATEKINGCUTLASSMATERIAL = EnumHelper.addToolMaterial("ROTMGPIRATEKINGCUTLASSMATERIAL", 1, 600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial ROTMGSWORDOFSPLENDORMATERIAL = EnumHelper.addToolMaterial("ROTMGSWORDOFSPLENDORMATERIAL", 1, 3000, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial ROTMGSKYSPLITTERSWORDMATERIAL = EnumHelper.addToolMaterial("ROTMGSKYSPLITTERSWORDMATERIAL", 1, 2000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial ROTMGARCHONSWORDMATERIAL = EnumHelper.addToolMaterial("ROTMGARCHONSWORDMATERIAL", 1, 1400, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial ROTMGANCIENTSTONESWORDMATERIAL = EnumHelper.addToolMaterial("ROTMGANCIENTSTONESWORDMATERIAL", 1, 750, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial ROTMGDRAGONSOULSWORDMATERIAL = EnumHelper.addToolMaterial("ROTMGDRAGONSOULSWORDMATERIAL", 1, 800, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial ROTMGRAVENHEARTSWORDMATERIAL = EnumHelper.addToolMaterial("ROTMGRAVENHEARTSWORDMATERIAL", 1, 400, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);

	//sc
	public static final ToolMaterial SCFIRANGIMATERIAL = EnumHelper.addToolMaterial("SCFIRANGIMATERIAL", 1, 1600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCCOCYTUSMATERIAL = EnumHelper.addToolMaterial("SCCOCYTUSMATERIAL", 1, 1600, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCERLANGBLADEMATERIAL = EnumHelper.addToolMaterial("SCERLANGBLADEMATERIAL", 1, 1800, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCSOULEDGENIGHTMAREMATERIAL = EnumHelper.addToolMaterial("SCSOULEDGENIGHTMAREMATERIAL", 1, 3200, 1.0f, (float) ((11.0f) * ModConfig.damageScale - 4.0f), 4);
	public static final ToolMaterial SCPHLEGATHONMATERIAL = EnumHelper.addToolMaterial("SCPHLEGATHONMATERIAL", 1, 2000, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCACHERONMATERIAL = EnumHelper.addToolMaterial("SCACHERONMATERIAL", 1, 2000, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCLETHEMATERIAL = EnumHelper.addToolMaterial("SCLETHEMATERIAL", 1, 2200, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCQUEENGUARDMATERIAL = EnumHelper.addToolMaterial("SCQUEENGUARDMATERIAL", 1, 2000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCHOLYANTLERMATERIAL = EnumHelper.addToolMaterial("SCHOLYANTLERMATERIAL", 1, 2000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCEPEEMATERIAL = EnumHelper.addToolMaterial("SCEPEEMATERIAL", 1, 2000, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCWARHAMMERMATERIAL = EnumHelper.addToolMaterial("SCWARHAMMERMATERIAL", 1, 1300, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 12);
	public static final ToolMaterial SCKALUTUESMATERIAL = EnumHelper.addToolMaterial("SCKALUTUESMATERIAL", 1, 1200, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 8);
	public static final ToolMaterial SCESTOCMATERIAL = EnumHelper.addToolMaterial("SCESTOCMATERIAL", 1, 2000, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCFLAMBERT2PMATERIAL = EnumHelper.addToolMaterial("SCFLAMBERT2PMATERIAL", 1, 2000, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCREITERPALLASCHMATERIAL = EnumHelper.addToolMaterial("SCREITERPALLASCHMATERIAL", 1, 2000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCFLAMBERTMATERIAL = EnumHelper.addToolMaterial("SCFLAMBERTMATERIAL", 1, 2000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCBLUECRYSTALRODMATERIAL = EnumHelper.addToolMaterial("SCBLUECRYSTALRODMATERIAL", 1, 1800, 1.0f, (float) ((4.0f) * ModConfig.damageScale - 4.0f), 30);
	public static final ToolMaterial SCFIREBLADEMATERIAL = EnumHelper.addToolMaterial("SCFIREBLADEMATERIAL", 1, 1500, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 13);
	public static final ToolMaterial SCXISWORDMATERIAL = EnumHelper.addToolMaterial("SCXISWORDMATERIAL", 1, 2000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCOMEGASWORD2PMATERIAL = EnumHelper.addToolMaterial("SCOMEGASWORD2PMATERIAL", 1, 2000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCOMEGASWORDMATERIAL = EnumHelper.addToolMaterial("SCOMEGASWORDMATERIAL", 1, 2000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCORICHALCUMMATERIAL = EnumHelper.addToolMaterial("SCORICHALCUMMATERIAL", 1, 2000, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 19);
	public static final ToolMaterial SCSTILETTOMATERIAL = EnumHelper.addToolMaterial("SCSTILETTOMATERIAL", 1, 1600, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCREQUIEMMATERIAL = EnumHelper.addToolMaterial("SCREQUIEMMATERIAL", 1, 2200, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCFAUSTMATERIAL = EnumHelper.addToolMaterial("SCFAUSTMATERIAL", 1, 2200, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCFLAMBERGEMATERIAL = EnumHelper.addToolMaterial("SCFLAMBERGEMATERIAL", 1, 2000, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCSTEELPADDLEMATERIAL = EnumHelper.addToolMaterial("SCSTEELPADDLEMATERIAL", 1, 800, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 8);
	public static final ToolMaterial SCGLAMMATERIAL = EnumHelper.addToolMaterial("SCGLAMMATERIAL", 1, 2000, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SCGREATBLADEMATERIAL = EnumHelper.addToolMaterial("SCGREATBLADEMATERIAL", 1, 2000, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 15);

	//rs
	public static final ToolMaterial RSBRONZESWORDMATERIAL = EnumHelper.addToolMaterial("RSBRONZESWORDMATERIAL", 1, 350, 1.0f, (float) ((5.0f) * ModConfig.damageScale - 4.0f), 16);
	public static final ToolMaterial RSIRONSWORDMATERIAL = EnumHelper.addToolMaterial("RSIRONSWORDMATERIAL", 1, 500, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 14);
	public static final ToolMaterial RSWHITESWORDMATERIAL = EnumHelper.addToolMaterial("RSWHITESWORDMATERIAL", 1, 1600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 17);
	public static final ToolMaterial RSBLACKSWORDMATERIAL = EnumHelper.addToolMaterial("RSBLACKSWORDMATERIAL", 1, 1600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 17);
	public static final ToolMaterial RSSTEELSWORDMATERIAL = EnumHelper.addToolMaterial("RSSTEELSWORDMATERIAL", 1, 1600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 8);
	public static final ToolMaterial RSMITHRILSWORDMATERIAL = EnumHelper.addToolMaterial("RSMITHRILSWORDMATERIAL", 1, 2600, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 26);
	public static final ToolMaterial RSADAMANTSWORDMATERIAL = EnumHelper.addToolMaterial("RSADAMANTSWORDMATERIAL", 1, 3400, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial RSRUNESWORDMATERIAL = EnumHelper.addToolMaterial("RSRUNESWORDMATERIAL", 1, 4200, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 32);
	public static final ToolMaterial RSDRAGONSWORDMATERIAL = EnumHelper.addToolMaterial("RSDRAGONSWORDMATERIAL", 1, 5600, 1.0f, (float) ((10.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial RSBRONZEBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("RSBRONZEBATTLEAXEMATERIAL", 1, 350, 1.0f, (float) ((5.0f) * ModConfig.damageScale - 4.0f), 16);
	public static final ToolMaterial RSIRONBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("RSIRONBATTLEAXEMATERIAL", 1, 500, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 14);
	public static final ToolMaterial RSSTEELBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("RSSTEELBATTLEAXEMATERIAL", 1, 1600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 17);
	public static final ToolMaterial RSBLACKBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("RSBLACKBATTLEAXEMATERIAL", 1, 1600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 17);
	public static final ToolMaterial RSWHITEBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("RSWHITEBATTLEAXEMATERIAL", 1, 1600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 8);
	public static final ToolMaterial RSMITHRILBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("RSMITHRILBATTLEAXEMATERIAL", 1, 2600, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 26);
	public static final ToolMaterial RSADAMANTBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("RSADAMANTBATTLEAXEMATERIAL", 1, 3400, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial RSRUNEBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("RSRUNEBATTLEAXEMATERIAL", 1, 4200, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 32);
	public static final ToolMaterial RSDRAGONBATTLEAXEMATERIAL = EnumHelper.addToolMaterial("RSDRAGONBATTLEAXEMATERIAL", 1, 5600, 1.0f, (float) ((10.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial RSBRONZESCIMITARMATERIAL = EnumHelper.addToolMaterial("RSBRONZESCIMITARMATERIAL", 1, 350, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 16);
	public static final ToolMaterial RSIRONSCIMITARMATERIAL = EnumHelper.addToolMaterial("RSIRONSCIMITARMATERIAL", 1, 500, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 14);
	public static final ToolMaterial RSBLACKSCIMITARMATERIAL = EnumHelper.addToolMaterial("RSBLACKSCIMITARMATERIAL", 1, 1600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 17);
	public static final ToolMaterial RSWHITESCIMITARMATERIAL = EnumHelper.addToolMaterial("RSWHITESCIMITARMATERIAL", 1, 1600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 17);
	public static final ToolMaterial RSSTEELSCIMITARMATERIAL = EnumHelper.addToolMaterial("RSSTEELSCIMITARMATERIAL", 1, 1600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 8);
	public static final ToolMaterial RSMITHRILSCIMITARMATERIAL = EnumHelper.addToolMaterial("RSMITHRILSCIMITARMATERIAL", 1, 2600, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 26);
	public static final ToolMaterial RSADAMANTSCIMITARMATERIAL = EnumHelper.addToolMaterial("RSADAMANTSCIMITARMATERIAL", 1, 3400, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial RSRUNESCIMITARMATERIAL = EnumHelper.addToolMaterial("RSRUNESCIMITARMATERIAL", 1, 4200, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 32);
	public static final ToolMaterial RSDRAGONSCIMITARMATERIAL = EnumHelper.addToolMaterial("RSDRAGONSCIMITARMATERIAL", 1, 5600, 1.0f, (float) ((10.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial RSBRONZEWARHAMMERMATERIAL = EnumHelper.addToolMaterial("RSBRONZEWARHAMMERMATERIAL", 1, 2500, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 16);
	public static final ToolMaterial RSIRONWARHAMMERMATERIAL = EnumHelper.addToolMaterial("RSIRONWARHAMMERMATERIAL", 1, 500, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 14);
	public static final ToolMaterial RSSTEELWARHAMMERMATERIAL = EnumHelper.addToolMaterial("RSSTEELWARHAMMERMATERIAL", 1, 1600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 17);
	public static final ToolMaterial RSBLACKWARHAMMERMATERIAL = EnumHelper.addToolMaterial("RSBLACKWARHAMMERMATERIAL", 1, 1600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 17);
	public static final ToolMaterial RSWHITEWARHAMMERMATERIAL = EnumHelper.addToolMaterial("RSWHITEWARHAMMERMATERIAL", 1, 1600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 8);
	public static final ToolMaterial RSMITHRILWARHAMMERMATERIAL = EnumHelper.addToolMaterial("RSMITHRILWARHAMMERMATERIAL", 1, 2600, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 26);
	public static final ToolMaterial RSADAMANTWARHAMMERMATERIAL = EnumHelper.addToolMaterial("RSADAMANTWARHAMMERMATERIAL", 1, 3400, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial RSRUNEWARHAMMERMATERIAL = EnumHelper.addToolMaterial("RSRUNEWARHAMMERMATERIAL", 1, 4200, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 32);
	public static final ToolMaterial RSBRONZEMACEMATERIAL = EnumHelper.addToolMaterial("RSBRONZEMACEMATERIAL", 1, 2500, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 16);
	public static final ToolMaterial RSIRONMACEMATERIAL = EnumHelper.addToolMaterial("RSIRONMACEMATERIAL", 1, 500, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 14);
	public static final ToolMaterial RSSTEELMACEMATERIAL = EnumHelper.addToolMaterial("RSSTEELMACEMATERIAL", 1, 1600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 17);
	public static final ToolMaterial RSBLACKMACEMATERIAL = EnumHelper.addToolMaterial("RSBLACKMACEMATERIAL", 1, 1600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 17);
	public static final ToolMaterial RSWHITEMACEMATERIAL = EnumHelper.addToolMaterial("RSWHITEMACEMATERIAL", 1, 1600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 8);
	public static final ToolMaterial RSMITHRILMACEMATERIAL = EnumHelper.addToolMaterial("RSMITHRILMACEMATERIAL", 1, 2600, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 26);
	public static final ToolMaterial RSADAMANTMACEMATERIAL = EnumHelper.addToolMaterial("RSADAMANTMACEMATERIAL", 1, 3400, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial RSRUNEMACEMATERIAL = EnumHelper.addToolMaterial("RSRUNEMACEMATERIAL", 1, 4200, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 32);
	public static final ToolMaterial RSGRANITELONGSWORDMATERIAL = EnumHelper.addToolMaterial("RSGRANITELONGSWORDMATERIAL", 1, 2400, 1.0f, (float) ((10.0f) * ModConfig.damageScale - 4.0f), 5);
	public static final ToolMaterial RSGRANITEHAMMERMATERIAL = EnumHelper.addToolMaterial("RSGRANITEHAMMERMATERIAL", 1, 2000, 1.0f, (float) ((10.0f) * ModConfig.damageScale - 4.0f), 5);
	public static final ToolMaterial RSGRANITEMAULMATERIAL = EnumHelper.addToolMaterial("RSGRANITEMAULMATERIAL", 1, 2500, 1.0f, (float) ((11.0f) * ModConfig.damageScale - 4.0f), 5);
	public static final ToolMaterial RSELDERMAULMATERIAL = EnumHelper.addToolMaterial("RSELDERMAULMATERIAL", 1, 3200, 1.0f, (float) ((12.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial RSTOKTZXILAKMATERIAL = EnumHelper.addToolMaterial("RSTOKTZXILAKMATERIAL", 1, 3000, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial RSWOLFSBANEMATERIAL = EnumHelper.addToolMaterial("RSWOLFSBANEMATERIAL", 1, 2500, 1.0f, (float) ((5.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial RSZAMORAKGODSWORDMATERIAL = EnumHelper.addToolMaterial("RSZAMORAKGODSWORDMATERIAL", 1, 2800, 1.0f, (float) ((12.0f) * ModConfig.damageScale - 4.0f), 18);
	public static final ToolMaterial RSBANDOSGODSWORDMATERIAL = EnumHelper.addToolMaterial("RSBANDOSGODSWORDMATERIAL", 1, 2800, 1.0f, (float) ((12.0f) * ModConfig.damageScale - 4.0f), 18);
	public static final ToolMaterial RSARMADYLGODSWORDMATERIAL = EnumHelper.addToolMaterial("RSARMADYLGODSWORDMATERIAL", 1, 2800, 1.0f, (float) ((12.0f) * ModConfig.damageScale - 4.0f), 18);
	public static final ToolMaterial RSSARADOMINGODSWORDMATERIAL = EnumHelper.addToolMaterial("RSSARADOMINGODSWORDMATERIAL", 1, 2800, 1.0f, (float) ((12.0f) * ModConfig.damageScale - 4.0f), 18);
	public static final ToolMaterial RSBARRELCHESTANCHORMATERIAL = EnumHelper.addToolMaterial("RSBARRELCHESTANCHORMATERIAL", 1, 2000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);

	//dmc
	public static final ToolMaterial DMCREDQUEENMATERIAL = EnumHelper.addToolMaterial("DMCREDQUEENMATERIAL", 1, 2000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial DMCREBELLIONMATERIAL = EnumHelper.addToolMaterial("DMCREBELLIONMATERIAL", 1, 2000, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial DMCYAMATOMATERIAL = EnumHelper.addToolMaterial("DMCYAMATOMATERIAL", 1, 2000, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 12);

	//pkmn
	public static final ToolMaterial PKMNHONEDGESHINYMATERIAL = EnumHelper.addToolMaterial("PKMNHONEDGESHINYMATERIAL", 1, 1600, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial PKMNHONEDGEMATERIAL = EnumHelper.addToolMaterial("PKMNHONEDGEMATERIAL", 1, 1600, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);

	//kirby
	public static final ToolMaterial KIRBYGALAXIAMATERIAL = EnumHelper.addToolMaterial("KIRBYGALAXIAMATERIAL", 1, 3500, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial KIRBYKIRBYULTRASWORDMATERIAL = EnumHelper.addToolMaterial("KIRBYKIRBYULTRASWORDMATERIAL", 1, 2000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial KIRBYKIRBYSWORDMATERIAL = EnumHelper.addToolMaterial("KIRBYKIRBYSWORDMATERIAL", 1, 1000, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);

	//fe
	public static final ToolMaterial FECHROMFALCHIONMATERIAL = EnumHelper.addToolMaterial("FECHROMFALCHIONMATERIAL", 1, 1900, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 20);
	public static final ToolMaterial FEFALCHIONMATERIAL = EnumHelper.addToolMaterial("FEFALCHIONMATERIAL", 1, 1900, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 20);

	//kh
	public static final ToolMaterial KHKEYBLADEMATERIAL = EnumHelper.addToolMaterial("KHKEYBLADEMATERIAL", 1, 1800, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 18);

	//bleach
	public static final ToolMaterial BLEACHZABIMARUMATERIAL = EnumHelper.addToolMaterial("BLEACHZABIMARUMATERIAL", 1, 2000, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial BLEACHZANGESTSUMATERIAL = EnumHelper.addToolMaterial("BLEACHZANGESTSUMATERIAL", 1, 2000, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 8);

	//ds
	public static final ToolMaterial DSGREATSWORDOFARTORIASMATERIAL = EnumHelper.addToolMaterial("DSGREATSWORDOFARTORIASMATERIAL", 1, 2200, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial DSGREATLORDGREATSWORDMATERIAL = EnumHelper.addToolMaterial("DSGREATLORDGREATSWORDMATERIAL", 1, 1200, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial DSASTORAGREATSWORDMATERIAL = EnumHelper.addToolMaterial("DSASTORAGREATSWORDMATERIAL", 1, 1800, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial DSZWEILHANDERMATERIAL = EnumHelper.addToolMaterial("DSZWEILHANDERMATERIAL", 1, 2000, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 15);

	//myth
	public static final ToolMaterial MYTHDEATHSCYTHEMATERIAL = EnumHelper.addToolMaterial("MYTHDEATHSCYTHEMATERIAL", 1, 1600, 1.0f, (float) ((10.0f) * ModConfig.damageScale - 4.0f), 2);
	public static final ToolMaterial MYTHTHEDEVILPITCHFORKMATERIAL = EnumHelper.addToolMaterial("MYTHTHEDEVILPITCHFORKMATERIAL", 1, 2200, 1.0f, (float) ((11.0f) * ModConfig.damageScale - 4.0f), 2);

	//bayonetta
	public static final ToolMaterial BAYONETTASHURABAMATERIAL = EnumHelper.addToolMaterial("BAYONETTASHURABAMATERIAL", 1, 2000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial BAYONETTAANGELSLAYERMATERIAL = EnumHelper.addToolMaterial("BAYONETTAANGELSLAYERMATERIAL", 1, 2000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);

	//gow
	public static final ToolMaterial GOWLEVIATHANUPGRADEDMATERIAL = EnumHelper.addToolMaterial("GOWLEVIATHANUPGRADEDMATERIAL", 1, 1800, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial GOWLEVIATHANMATERIAL = EnumHelper.addToolMaterial("GOWLEVIATHANMATERIAL", 1, 1600, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial GOWBLADEOFOLYMPUSMATERIAL = EnumHelper.addToolMaterial("GOWBLADEOFOLYMPUSMATERIAL", 1, 4000, 1.0f, (float) ((10.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial GOWBLADEOFCHAOSMATERIAL = EnumHelper.addToolMaterial("GOWBLADEOFCHAOSMATERIAL", 1, 2000, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);

	//skyrim
	public static final ToolMaterial SKYRIMIRONSWORDMATERIAL = EnumHelper.addToolMaterial("SKYRIMIRONSWORDMATERIAL", 1, 500, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 14);
	public static final ToolMaterial SKYRIMIRONWARHAMMERMATERIAL = EnumHelper.addToolMaterial("SKYRIMIRONWARHAMMERMATERIAL", 1, 600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 14);
	public static final ToolMaterial SKYRIMSTEELSWORDMATERIAL = EnumHelper.addToolMaterial("SKYRIMSTEELSWORDMATERIAL", 1, 1600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 17);
	public static final ToolMaterial SKYRIMSTEELWARHAMMERMATERIAL = EnumHelper.addToolMaterial("SKYRIMSTEELWARHAMMERMATERIAL", 1, 1700, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 17);
	public static final ToolMaterial SKYRIMORCISHSWORDMATERIAL = EnumHelper.addToolMaterial("SKYRIMORCISHSWORDMATERIAL", 1, 2000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 8);
	public static final ToolMaterial SKYRIMORCISHWARHAMMERMATERIAL = EnumHelper.addToolMaterial("SKYRIMORCISHWARHAMMERMATERIAL", 1, 2000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 8);
	public static final ToolMaterial SKYRIMDWARVENSWORDMATERIAL = EnumHelper.addToolMaterial("SKYRIMDWARVENSWORDMATERIAL", 1, 2600, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 12);
	public static final ToolMaterial SKYRIMDWARVENWARHAMMERMATERIAL = EnumHelper.addToolMaterial("SKYRIMDWARVENWARHAMMERMATERIAL", 1, 2700, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 12);
	public static final ToolMaterial SKYRIMELVENSWORDMATERIAL = EnumHelper.addToolMaterial("SKYRIMELVENSWORDMATERIAL", 1, 1600, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 18);
	public static final ToolMaterial SKYRIMELVENWARHAMMERMATERIAL = EnumHelper.addToolMaterial("SKYRIMELVENWARHAMMERMATERIAL", 1, 1700, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 18);
	public static final ToolMaterial SKYRIMGLASSSWORDMATERIAL = EnumHelper.addToolMaterial("SKYRIMGLASSSWORDMATERIAL", 1, 1600, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 11);
	public static final ToolMaterial SKYRIMGLASSWARHAMMERMATERIAL = EnumHelper.addToolMaterial("SKYRIMGLASSWARHAMMERMATERIAL", 1, 1700, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 11);
	public static final ToolMaterial SKYRIMEBONYSWORDMATERIAL = EnumHelper.addToolMaterial("SKYRIMEBONYSWORDMATERIAL", 1, 1900, 1.0f, (float) ((10.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SKYRIMEBONYWARHAMMERMATERIAL = EnumHelper.addToolMaterial("SKYRIMEBONYWARHAMMERMATERIAL", 1, 2000, 1.0f, (float) ((10.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SKYRIMDAEDRICSWORDMATERIAL = EnumHelper.addToolMaterial("SKYRIMDAEDRICSWORDMATERIAL", 1, 2200, 1.0f, (float) ((11.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SKYRIMDAEDRICWARHAMMERMATERIAL = EnumHelper.addToolMaterial("SKYRIMDAEDRICWARHAMMERMATERIAL", 1, 2300, 1.0f, (float) ((11.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SKYRIMDRAGONBONESWORDMATERIAL = EnumHelper.addToolMaterial("SKYRIMDRAGONBONESWORDMATERIAL", 1, 1300, 1.0f, (float) ((12.0f) * ModConfig.damageScale - 4.0f), 6);
	public static final ToolMaterial SKYRIMDRAGONBONEWARHAMMERMATERIAL = EnumHelper.addToolMaterial("SKYRIMDRAGONBONEWARHAMMERMATERIAL", 1, 1400, 1.0f, (float) ((12.0f) * ModConfig.damageScale - 4.0f), 6);
	public static final ToolMaterial SKYRIMIMPERIALSWORDMATERIAL = EnumHelper.addToolMaterial("SKYRIMIMPERIALSWORDMATERIAL", 1, 2000, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SKYRIMDAWNBREAKERMATERIAL = EnumHelper.addToolMaterial("SKYRIMDAWNBREAKERMATERIAL", 1, 2200, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SKYRIMANCIENTNORDSWORDMATERIAL = EnumHelper.addToolMaterial("SKYRIMANCIENTNORDSWORDMATERIAL", 1, 1200, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial SKYRIMCHILLRENDMATERIAL = EnumHelper.addToolMaterial("SKYRIMCHILLRENDMATERIAL", 1, 1600, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 12);
	public static final ToolMaterial SKYRIMEBONYBLADEMATERIAL = EnumHelper.addToolMaterial("SKYRIMEBONYBLADEMATERIAL", 1, 2100, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);

	//mh
	public static final ToolMaterial MHCHICKENDECAPITATORMATERIAL = EnumHelper.addToolMaterial("MHCHICKENDECAPITATORMATERIAL", 1, 1600, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 6);
	public static final ToolMaterial MHGOLEMBLADEMATERIAL = EnumHelper.addToolMaterial("MHGOLEMBLADEMATERIAL", 1, 1600, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial MHDEFENDERMATERIAL = EnumHelper.addToolMaterial("MHDEFENDERMATERIAL", 1, 2900, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial MHBLACKBELTBLADEMATERIAL = EnumHelper.addToolMaterial("MHBLACKBELTBLADEMATERIAL", 1, 1900, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial MHWAILINGCLEAVERMATERIAL = EnumHelper.addToolMaterial("MHWAILINGCLEAVERMATERIAL", 1, 1700, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial MHGAELICFLAMEMATERIAL = EnumHelper.addToolMaterial("MHGAELICFLAMEMATERIAL", 1, 1900, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 11);
	public static final ToolMaterial MHBONEKATANAMATERIAL = EnumHelper.addToolMaterial("MHBONEKATANAMATERIAL", 1, 1700, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 8);
	public static final ToolMaterial MHHELLISHSLASHERMATERIAL = EnumHelper.addToolMaterial("MHHELLISHSLASHERMATERIAL", 1, 2100, 1.0f, (float) ((10.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial MHCENTENARIANDAGGERMATERIAL = EnumHelper.addToolMaterial("MHCENTENARIANDAGGERMATERIAL", 1, 1800, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial MHWYVERNBLADEBLOODMATERIAL = EnumHelper.addToolMaterial("MHWYVERNBLADEBLOODMATERIAL", 1, 1900, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 12);
	public static final ToolMaterial MHWYVERNBLADEHOLLYMATERIAL = EnumHelper.addToolMaterial("MHWYVERNBLADEHOLLYMATERIAL", 1, 1900, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 12);
	public static final ToolMaterial MHWYVERNBLADEPALEMATERIAL = EnumHelper.addToolMaterial("MHWYVERNBLADEPALEMATERIAL", 1, 1900, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 12);
	public static final ToolMaterial MHWYVERNBLADEAZUREMATERIAL = EnumHelper.addToolMaterial("MHWYVERNBLADEAZUREMATERIAL", 1, 1900, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 12);
	public static final ToolMaterial MHWYVERNBLADELEAFMATERIAL = EnumHelper.addToolMaterial("MHWYVERNBLADELEAFMATERIAL", 1, 1900, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 12);
	public static final ToolMaterial MHRATHALOSFLAMESWORDMATERIAL = EnumHelper.addToolMaterial("MHRATHALOSFLAMESWORDMATERIAL", 1, 1900, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 12);

	//terraria
	public static final ToolMaterial TERRARIAPALMWOODSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIAPALMWOODSWORDMATERIAL", 1, 100, 1.0f, (float) ((4.0f) * ModConfig.damageScale - 4.0f), 18);
	public static final ToolMaterial TERRARIABOREALWOODSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIABOREALWOODSWORDMATERIAL", 1, 100, 1.0f, (float) ((4.0f) * ModConfig.damageScale - 4.0f), 18);
	public static final ToolMaterial TERRARIASHADEWOODSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIASHADEWOODSWORDMATERIAL", 1, 350, 1.0f, (float) ((5.0f) * ModConfig.damageScale - 4.0f), 18);
	public static final ToolMaterial TERRARIAEBONWOODSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIAEBONWOODSWORDMATERIAL", 1, 350, 1.0f, (float) ((5.0f) * ModConfig.damageScale - 4.0f), 18);
	public static final ToolMaterial TERRARIACOPPERSHORTSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIACOPPERSHORTSWORDMATERIAL", 1, 150, 1.0f, (float) ((5.0f) * ModConfig.damageScale - 4.0f), 8);
	public static final ToolMaterial TERRARIACOPPERBROADSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIACOPPERBROADSWORDMATERIAL", 1, 180, 1.0f, (float) ((5.0f) * ModConfig.damageScale - 4.0f), 8);
	public static final ToolMaterial TERRARIATINSHORTSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIATINSHORTSWORDMATERIAL", 1, 150, 1.0f, (float) ((5.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial TERRARIATINBROADSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIATINBROADSWORDMATERIAL", 1, 180, 1.0f, (float) ((5.0f) * ModConfig.damageScale - 4.0f), 10);
	public static final ToolMaterial TERRARIALEADSHORTSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIALEADSHORTSWORDMATERIAL", 1, 150, 1.0f, (float) ((5.0f) * ModConfig.damageScale - 4.0f), 12);
	public static final ToolMaterial TERRARIALEADBROADSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIALEADBROADSWORDMATERIAL", 1, 180, 1.0f, (float) ((5.0f) * ModConfig.damageScale - 4.0f), 12);
	public static final ToolMaterial TERRARIASPEARMATERIAL = EnumHelper.addToolMaterial("TERRARIASPEARMATERIAL", 1, 200, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial TERRARIAIRONSHORTSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIAIRONSHORTSWORDMATERIAL", 1, 250, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial TERRARIAIRONBROADSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIAIRONBROADSWORDMATERIAL", 1, 250, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial TERRARIASILVERBROADSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIASILVERBROADSWORDMATERIAL", 1, 300, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 26);
	public static final ToolMaterial TERRARIASILVERSHORTSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIASILVERSHORTSWORDMATERIAL", 1, 300, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 26);
	public static final ToolMaterial TERRARIAGOLDSHORTSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIAGOLDSHORTSWORDMATERIAL", 1, 300, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 26);
	public static final ToolMaterial TERRARIAGOLDBROADSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIAGOLDBROADSWORDMATERIAL", 1, 300, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 26);
	public static final ToolMaterial TERRARIATUNGSTENBROADSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIATUNGSTENBROADSWORDMATERIAL", 1, 600, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 18);
	public static final ToolMaterial TERRARIATUNGSTENSHORTSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIATUNGSTENSHORTSWORDMATERIAL", 1, 650, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 18);
	public static final ToolMaterial TERRARIAPLATINUMSHORTSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIAPLATINUMSHORTSWORDMATERIAL", 1, 600, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 22);
	public static final ToolMaterial TERRARIAPLATINUMBROADSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIAPLATINUMBROADSWORDMATERIAL", 1, 650, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 22);
	public static final ToolMaterial TERRARIAMANDIBLEBLADEMATERIAL = EnumHelper.addToolMaterial("TERRARIAMANDIBLEBLADEMATERIAL", 1, 500, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 6);
	public static final ToolMaterial TERRARIAKATANAMATERIAL = EnumHelper.addToolMaterial("TERRARIAKATANAMATERIAL", 1, 1100, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 12);
	public static final ToolMaterial TERRARIAEXOTICSCIMITARMATERIAL = EnumHelper.addToolMaterial("TERRARIAEXOTICSCIMITARMATERIAL", 1, 1200, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 12);
	public static final ToolMaterial TERRARIAMURAMASAMATERIAL = EnumHelper.addToolMaterial("TERRARIAMURAMASAMATERIAL", 1, 1900, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 23);
	public static final ToolMaterial TERRARIAFALCONBLADEMATERIAL = EnumHelper.addToolMaterial("TERRARIAFALCONBLADEMATERIAL", 1, 1400, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 11);
	public static final ToolMaterial TERRARIABLADEOFGRASSMATERIAL = EnumHelper.addToolMaterial("TERRARIABLADEOFGRASSMATERIAL", 1, 1200, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial TERRARIAFIERYGREATSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIAFIERYGREATSWORDMATERIAL", 1, 1200, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial TERRARIABONESWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIABONESWORDMATERIAL", 1, 800, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial TERRARIABLOODBUTCHERERMATERIAL = EnumHelper.addToolMaterial("TERRARIABLOODBUTCHERERMATERIAL", 1, 1300, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 16);
	public static final ToolMaterial TERRARIAENCHANTEDSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIAENCHANTEDSWORDMATERIAL", 1, 1200, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 32);
	public static final ToolMaterial TERRARIASTARFURYMATERIAL = EnumHelper.addToolMaterial("TERRARIASTARFURYMATERIAL", 1, 1800, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 9);
	public static final ToolMaterial TERRARIABEEKEEPERMATERIAL = EnumHelper.addToolMaterial("TERRARIABEEKEEPERMATERIAL", 1, 1200, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 8);
	public static final ToolMaterial TERRARIAICEBLADEMATERIAL = EnumHelper.addToolMaterial("TERRARIAICEBLADEMATERIAL", 1, 400, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 4);
	public static final ToolMaterial TERRARIANIGHTEDGEMATERIAL = EnumHelper.addToolMaterial("TERRARIANIGHTEDGEMATERIAL", 1, 1800, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 18);
	public static final ToolMaterial TERRARIAARKHALISMATERIAL = EnumHelper.addToolMaterial("TERRARIAARKHALISMATERIAL", 1, 1700, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 16);
	public static final ToolMaterial TERRARIATRIDENTMATERIAL = EnumHelper.addToolMaterial("TERRARIATRIDENTMATERIAL", 1, 1600, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 12);
	public static final ToolMaterial TERRARIATHEROTTEDFORKMATERIAL = EnumHelper.addToolMaterial("TERRARIATHEROTTEDFORKMATERIAL", 1, 2000, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 16);
	public static final ToolMaterial TERRARIAWHITEPHASEBLADEMATERIAL = EnumHelper.addToolMaterial("TERRARIAWHITEPHASEBLADEMATERIAL", 1, 600, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 0);
	public static final ToolMaterial TERRARIAYELLOWPHASEBLADEMATERIAL = EnumHelper.addToolMaterial("TERRARIAYELLOWPHASEBLADEMATERIAL", 1, 600, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 0);
	public static final ToolMaterial TERRARIAPURPLEPHASEBLADEMATERIAL = EnumHelper.addToolMaterial("TERRARIAPURPLEPHASEBLADEMATERIAL", 1, 600, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 0);
	public static final ToolMaterial TERRARIAGREENPHASEBLADEMATERIAL = EnumHelper.addToolMaterial("TERRARIAGREENPHASEBLADEMATERIAL", 1, 600, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 0);
	public static final ToolMaterial TERRARIAREDPHASEBLADEMATERIAL = EnumHelper.addToolMaterial("TERRARIAREDPHASEBLADEMATERIAL", 1, 600, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 0);
	public static final ToolMaterial TERRARIABLUEPHASEBLADEMATERIAL = EnumHelper.addToolMaterial("TERRARIABLUEPHASEBLADEMATERIAL", 1, 600, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 0);
	public static final ToolMaterial TERRARIALIGHTBANEMATERIAL = EnumHelper.addToolMaterial("TERRARIALIGHTBANEMATERIAL", 1, 1900, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial TERRARIADARKLANCEMATERIAL = EnumHelper.addToolMaterial("TERRARIADARKLANCEMATERIAL", 1, 1400, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 15);
	public static final ToolMaterial TERRARIAPURPLECLUBBERFISHMATERIAL = EnumHelper.addToolMaterial("TERRARIAPURPLECLUBBERFISHMATERIAL", 1, 600, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 0);
	public static final ToolMaterial TERRARIACACTUSSWORDMATERIAL = EnumHelper.addToolMaterial("TERRARIACACTUSSWORDMATERIAL", 1, 250, 1.0f, (float) ((5.0f) * ModConfig.damageScale - 4.0f), 6);
	public static final ToolMaterial TERRARIASWORDFISHMATERIAL = EnumHelper.addToolMaterial("TERRARIASWORDFISHMATERIAL", 1, 1400, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 0);

	//sw
	public static final ToolMaterial SWYELLOWLIGHTSABERMATERIAL = EnumHelper.addToolMaterial("SWYELLOWLIGHTSABERMATERIAL", 1, 2300, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 1);
	public static final ToolMaterial SWGREENLIGHTSABERMATERIAL = EnumHelper.addToolMaterial("SWGREENLIGHTSABERMATERIAL", 1, 2300, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 1);
	public static final ToolMaterial SWBLUELIGHTSABERMATERIAL = EnumHelper.addToolMaterial("SWBLUELIGHTSABERMATERIAL", 1, 2300, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 1);
	public static final ToolMaterial SWREDLIGHTSABERMATERIAL = EnumHelper.addToolMaterial("SWREDLIGHTSABERMATERIAL", 1, 2300, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 1);
	public static final ToolMaterial SWMACEWINDULIGHTSABERMATERIAL = EnumHelper.addToolMaterial("SWMACEWINDULIGHTSABERMATERIAL", 1, 2300, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 1);
	public static final ToolMaterial SWTHEINQUISITORLIGHTSABERMATERIAL = EnumHelper.addToolMaterial("SWTHEINQUISITORLIGHTSABERMATERIAL", 1, 2300, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 1);
	public static final ToolMaterial SWDARTHMAULLIGHTSABERMATERIAL = EnumHelper.addToolMaterial("SWDARTHMAULLIGHTSABERMATERIAL", 1, 2100, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 1);
	public static final ToolMaterial SWQUIGONJINNLIGHTSABERMATERIAL = EnumHelper.addToolMaterial("SWQUIGONJINNLIGHTSABERMATERIAL", 1, 2300, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 1);
	public static final ToolMaterial SWKYLORENLIGHTSABERMATERIAL = EnumHelper.addToolMaterial("SWKYLORENLIGHTSABERMATERIAL", 1, 1800, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 1);
	public static final ToolMaterial SWCOUNTDOOKULIGHTSABERMATERIAL = EnumHelper.addToolMaterial("SWCOUNTDOOKULIGHTSABERMATERIAL", 1, 2600, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 1);
	public static final ToolMaterial SWDARKSABERMATERIAL = EnumHelper.addToolMaterial("SWDARKSABERMATERIAL", 1, 2300, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 1);

	//internet
	public static final ToolMaterial INTERNETDEMONOIDPITCHFORKMATERIAL = EnumHelper.addToolMaterial("INTERNETDEMONOIDPITCHFORKMATERIAL", 1, 666, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 6);

	//nh
	public static final ToolMaterial NHMAGICBANEMATERIAL = EnumHelper.addToolMaterial("NHMAGICBANEMATERIAL", 1, 2400, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 22);
	public static final ToolMaterial NHATHAMEMATERIAL = EnumHelper.addToolMaterial("NHATHAMEMATERIAL", 1, 1600, 1.0f, (float) ((6.0f) * ModConfig.damageScale - 4.0f), 18);
	public static final ToolMaterial NHGRAYSWANDIRMATERIAL = EnumHelper.addToolMaterial("NHGRAYSWANDIRMATERIAL", 1, 2000, 1.0f, (float) ((9.0f) * ModConfig.damageScale - 4.0f), 28);
	public static final ToolMaterial NHSILVERSABERMATERIAL = EnumHelper.addToolMaterial("NHSILVERSABERMATERIAL", 1, 2000, 1.0f, (float) ((7.0f) * ModConfig.damageScale - 4.0f), 22);

	//abcm
	public static final ToolMaterial ABCMEXCALIBURMATERIAL = EnumHelper.addToolMaterial("ABCMEXCALIBURMATERIAL", 1, 3000, 1.0f, (float) ((8.0f) * ModConfig.damageScale - 4.0f), 24);

	
	//creative tab
	static final CreativeTabs tabHeroicArmory = new CreativeTabs("tabHeroicArmory") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(lotrNarsil);
		}		
	};
	
	public static void init() {

	    //CREATE ITEMS==================================================================================================
		
		//lotr
		lotrGimliBattleAxe = new Sword("lotrGimliBattleAxe", LOTRGIMLIBATTLEAXEMATERIAL);
		lotrGimliLongAxe = new Sword("lotrGimliLongAxe", LOTRGIMLILONGAXEMATERIAL);
		lotrMorgulBlade = new Sword("lotrMorgulBlade", LOTRMORGULBLADEMATERIAL);
		lotrSting = new Sword("lotrSting", LOTRSTINGMATERIAL);
		lotrGlamdring = new Sword("lotrGlamdring", LOTRGLAMDRINGMATERIAL);
		lotrAnduril = new Sword("lotrAnduril", LOTRANDURILMATERIAL);
		lotrNarsil = new Sword("lotrNarsil", LOTRNARSILMATERIAL);
		lotrSauronMace = new Sword("lotrSauronMace", LOTRSAURONMACEMATERIAL);
		lotrWitchKingSword = new Sword("lotrWitchKingSword", LOTRWITCHKINGSWORDMATERIAL);

		//loz
		lozMasterSword = new Sword("lozMasterSword", LOZMASTERSWORDMATERIAL);
		lozMasterSwordII = new Sword("lozMasterSwordII", LOZMASTERSWORDIIMATERIAL);
		lozTemperedSword = new Sword("lozTemperedSword", LOZTEMPEREDSWORDMATERIAL);
		lozMasterSwordIII = new Sword("lozMasterSwordIII", LOZMASTERSWORDIIIMATERIAL);
		lozGoldenSword = new Sword("lozGoldenSword", LOZGOLDENSWORDMATERIAL);
		lozFlameblade = new Sword("lozFlameblade", LOZFLAMEBLADEMATERIAL);
		lozDarknutSwordTp = new Sword("lozDarknutSwordTp", LOZDARKNUTSWORDTPMATERIAL);
		lozGhirahimSword = new Sword("lozGhirahimSword", LOZGHIRAHIMSWORDMATERIAL);
		lozFierceDietySword = new Sword("lozFierceDietySword", LOZFIERCEDIETYSWORDMATERIAL);
		lozZeldaSword = new Sword("lozZeldaSword", LOZZELDASWORDMATERIAL);
		lozBokoStick = new Sword("lozBokoStick", LOZBOKOSTICKMATERIAL);
		lozCaneofByrna = new Sword("lozCaneofByrna", LOZCANEOFBYRNAMATERIAL);
		lozMegatonHammer = new Sword("lozMegatonHammer", LOZMEGATONHAMMERMATERIAL);
		lozKokiriSwordMm = new Sword("lozKokiriSwordMm", LOZKOKIRISWORDMMMATERIAL);
		lozKokiriSwordOoT = new Sword("lozKokiriSwordOoT", LOZKOKIRISWORDOOTMATERIAL);
		lozDemiseSword = new Sword("lozDemiseSword", LOZDEMISESWORDMATERIAL);
		lozGiantKnife = new Sword("lozGiantKnife", LOZGIANTKNIFEMATERIAL);
		lozBiggoronSword = new Sword("lozBiggoronSword", LOZBIGGORONSWORDMATERIAL);
		lozPhantomGanonSword = new Sword("lozPhantomGanonSword", LOZPHANTOMGANONSWORDMATERIAL);
		lozUltimateSword = new Sword("lozUltimateSword", LOZULTIMATESWORDMATERIAL);
		lozRoyalGuardSword = new Sword("lozRoyalGuardSword", LOZROYALGUARDSWORDMATERIAL);
		lozMagicSwordConcept = new Sword("lozMagicSwordConcept", LOZMAGICSWORDCONCEPTMATERIAL);
		lozMagicSword = new Sword("lozMagicSword", LOZMAGICSWORDMATERIAL);
		lozWhiteSword = new Sword("lozWhiteSword", LOZWHITESWORDMATERIAL);
		lozWhiteSwordConcept = new Sword("lozWhiteSwordConcept", LOZWHITESWORDCONCEPTMATERIAL);
		lozPicoriBlade = new Sword("lozPicoriBlade", LOZPICORIBLADEMATERIAL);
		lozRazorSword = new Sword("lozRazorSword", LOZRAZORSWORDMATERIAL);
		lozGreatFairySword = new Sword("lozGreatFairySword", LOZGREATFAIRYSWORDMATERIAL);
		lozGoddessWhiteSword = new Sword("lozGoddessWhiteSword", LOZGODDESSWHITESWORDMATERIAL);
		lozGoddessSword = new Sword("lozGoddessSword", LOZGODDESSSWORDMATERIAL);
		lozGildedSword = new Sword("lozGildedSword", LOZGILDEDSWORDMATERIAL);
		lozSpikedBokoClub = new Sword("lozSpikedBokoClub", LOZSPIKEDBOKOCLUBMATERIAL);
		lozBokoClub = new Sword("lozBokoClub", LOZBOKOCLUBMATERIAL);

		//at
		atJakeSword = new Sword("atJakeSword", ATJAKESWORDMATERIAL);
		atCrystalSword = new Sword("atCrystalSword", ATCRYSTALSWORDMATERIAL);
		atNothung = new Sword("atNothung", ATNOTHUNGMATERIAL);
		atFinnSword = new Sword("atFinnSword", ATFINNSWORDMATERIAL);
		atSwordoftheDead = new Sword("atSwordoftheDead", ATSWORDOFTHEDEADMATERIAL);
		atWishStarSword = new Sword("atWishStarSword", ATWISHSTARSWORDMATERIAL);
		atFightKingSword = new Sword("atFightKingSword", ATFIGHTKINGSWORDMATERIAL);
		atRootSword = new Sword("atRootSword", ATROOTSWORDMATERIAL);
		atScarlet = new Sword("atScarlet", ATSCARLETMATERIAL);
		atGrassSword = new Sword("atGrassSword", ATGRASSSWORDMATERIAL);
		atDemonBloodSword = new Sword("atDemonBloodSword", ATDEMONBLOODSWORDMATERIAL);
		atAxeBass = new Sword("atAxeBass", ATAXEBASSMATERIAL);

		//ff
		ffTheMasamune = new Sword("ffTheMasamune", FFTHEMASAMUNEMATERIAL);
		ffBusterSword = new Sword("ffBusterSword", FFBUSTERSWORDMATERIAL);
		ffCaladbolg = new Sword("ffCaladbolg", FFCALADBOLGMATERIAL);

		//rotmg
		rotmgSwordoftheColossus = new Sword("rotmgSwordoftheColossus", ROTMGSWORDOFTHECOLOSSUSMATERIAL);
		rotmgCrystalSword = new Sword("rotmgCrystalSword", ROTMGCRYSTALSWORDMATERIAL);
		rotmgPixieEnchantedSword = new Sword("rotmgPixieEnchantedSword", ROTMGPIXIEENCHANTEDSWORDMATERIAL);
		rotmgSwordOfAcclaim = new Sword("rotmgSwordOfAcclaim", ROTMGSWORDOFACCLAIMMATERIAL);
		rotmgDemonBlade = new Sword("rotmgDemonBlade", ROTMGDEMONBLADEMATERIAL);
		rotmgSwordoftheMadGod = new Sword("rotmgSwordoftheMadGod", ROTMGSWORDOFTHEMADGODMATERIAL);
		rotmgIndomptable = new Sword("rotmgIndomptable", ROTMGINDOMPTABLEMATERIAL);
		rotmgPirateKingCutlass = new Sword("rotmgPirateKingCutlass", ROTMGPIRATEKINGCUTLASSMATERIAL);
		rotmgSwordofSplendor = new Sword("rotmgSwordofSplendor", ROTMGSWORDOFSPLENDORMATERIAL);
		rotmgSkysplitterSword = new Sword("rotmgSkysplitterSword", ROTMGSKYSPLITTERSWORDMATERIAL);
		rotmgArchonSword = new Sword("rotmgArchonSword", ROTMGARCHONSWORDMATERIAL);
		rotmgAncientStoneSword = new Sword("rotmgAncientStoneSword", ROTMGANCIENTSTONESWORDMATERIAL);
		rotmgDragonsoulSword = new Sword("rotmgDragonsoulSword", ROTMGDRAGONSOULSWORDMATERIAL);
		rotmgRavenheartSword = new Sword("rotmgRavenheartSword", ROTMGRAVENHEARTSWORDMATERIAL);

		//sc
		scFirangi = new Sword("scFirangi", SCFIRANGIMATERIAL);
		scCocytus = new Sword("scCocytus", SCCOCYTUSMATERIAL);
		scErlangBlade = new Sword("scErlangBlade", SCERLANGBLADEMATERIAL);
		scSoulEdgeNightmare = new Sword("scSoulEdgeNightmare", SCSOULEDGENIGHTMAREMATERIAL);
		scPhlegathon = new Sword("scPhlegathon", SCPHLEGATHONMATERIAL);
		scAcheron = new Sword("scAcheron", SCACHERONMATERIAL);
		scLethe = new Sword("scLethe", SCLETHEMATERIAL);
		scQueenGuard = new Sword("scQueenGuard", SCQUEENGUARDMATERIAL);
		scHolyAntler = new Sword("scHolyAntler", SCHOLYANTLERMATERIAL);
		scEpee = new Sword("scEpee", SCEPEEMATERIAL);
		scWarHammer = new Sword("scWarHammer", SCWARHAMMERMATERIAL);
		scKalutues = new Sword("scKalutues", SCKALUTUESMATERIAL);
		scEstoc = new Sword("scEstoc", SCESTOCMATERIAL);
		scFlambert2P = new Sword("scFlambert2P", SCFLAMBERT2PMATERIAL);
		scReiterpallasch = new Sword("scReiterpallasch", SCREITERPALLASCHMATERIAL);
		scFlambert = new Sword("scFlambert", SCFLAMBERTMATERIAL);
		scBlueCrystalRod = new Sword("scBlueCrystalRod", SCBLUECRYSTALRODMATERIAL);
		scFireBlade = new Sword("scFireBlade", SCFIREBLADEMATERIAL);
		scXiSword = new Sword("scXiSword", SCXISWORDMATERIAL);
		scOmegaSword2P = new Sword("scOmegaSword2P", SCOMEGASWORD2PMATERIAL);
		scOmegaSword = new Sword("scOmegaSword", SCOMEGASWORDMATERIAL);
		scOrichalcum = new Sword("scOrichalcum", SCORICHALCUMMATERIAL);
		scStiletto = new Sword("scStiletto", SCSTILETTOMATERIAL);
		scRequiem = new Sword("scRequiem", SCREQUIEMMATERIAL);
		scFaust = new Sword("scFaust", SCFAUSTMATERIAL);
		scFlamberge = new Sword("scFlamberge", SCFLAMBERGEMATERIAL);
		scSteelPaddle = new Sword("scSteelPaddle", SCSTEELPADDLEMATERIAL);
		scGlam = new Sword("scGlam", SCGLAMMATERIAL);
		scGreatBlade = new Sword("scGreatBlade", SCGREATBLADEMATERIAL);

		//rs
		rsBronzeSword = new Sword("rsBronzeSword", RSBRONZESWORDMATERIAL);
		rsIronSword = new Sword("rsIronSword", RSIRONSWORDMATERIAL);
		rsWhiteSword = new Sword("rsWhiteSword", RSWHITESWORDMATERIAL);
		rsBlackSword = new Sword("rsBlackSword", RSBLACKSWORDMATERIAL);
		rsSteelSword = new Sword("rsSteelSword", RSSTEELSWORDMATERIAL);
		rsMithrilSword = new Sword("rsMithrilSword", RSMITHRILSWORDMATERIAL);
		rsAdamantSword = new Sword("rsAdamantSword", RSADAMANTSWORDMATERIAL);
		rsRuneSword = new Sword("rsRuneSword", RSRUNESWORDMATERIAL);
		rsDragonSword = new Sword("rsDragonSword", RSDRAGONSWORDMATERIAL);
		rsBronzeBattleaxe = new Sword("rsBronzeBattleaxe", RSBRONZEBATTLEAXEMATERIAL);
		rsIronBattleaxe = new Sword("rsIronBattleaxe", RSIRONBATTLEAXEMATERIAL);
		rsSteelBattleaxe = new Sword("rsSteelBattleaxe", RSSTEELBATTLEAXEMATERIAL);
		rsBlackBattleaxe = new Sword("rsBlackBattleaxe", RSBLACKBATTLEAXEMATERIAL);
		rsWhiteBattleaxe = new Sword("rsWhiteBattleaxe", RSWHITEBATTLEAXEMATERIAL);
		rsMithrilBattleaxe = new Sword("rsMithrilBattleaxe", RSMITHRILBATTLEAXEMATERIAL);
		rsAdamantBattleaxe = new Sword("rsAdamantBattleaxe", RSADAMANTBATTLEAXEMATERIAL);
		rsRuneBattleaxe = new Sword("rsRuneBattleaxe", RSRUNEBATTLEAXEMATERIAL);
		rsDragonBattleaxe = new Sword("rsDragonBattleaxe", RSDRAGONBATTLEAXEMATERIAL);
		rsBronzeScimitar = new Sword("rsBronzeScimitar", RSBRONZESCIMITARMATERIAL);
		rsIronScimitar = new Sword("rsIronScimitar", RSIRONSCIMITARMATERIAL);
		rsBlackScimitar = new Sword("rsBlackScimitar", RSBLACKSCIMITARMATERIAL);
		rsWhiteScimitar = new Sword("rsWhiteScimitar", RSWHITESCIMITARMATERIAL);
		rsSteelScimitar = new Sword("rsSteelScimitar", RSSTEELSCIMITARMATERIAL);
		rsMithrilScimitar = new Sword("rsMithrilScimitar", RSMITHRILSCIMITARMATERIAL);
		rsAdamantScimitar = new Sword("rsAdamantScimitar", RSADAMANTSCIMITARMATERIAL);
		rsRuneScimitar = new Sword("rsRuneScimitar", RSRUNESCIMITARMATERIAL);
		rsDragonScimitar = new Sword("rsDragonScimitar", RSDRAGONSCIMITARMATERIAL);
		rsBronzeWarhammer = new Sword("rsBronzeWarhammer", RSBRONZEWARHAMMERMATERIAL);
		rsIronWarhammer = new Sword("rsIronWarhammer", RSIRONWARHAMMERMATERIAL);
		rsSteelWarhammer = new Sword("rsSteelWarhammer", RSSTEELWARHAMMERMATERIAL);
		rsBlackWarhammer = new Sword("rsBlackWarhammer", RSBLACKWARHAMMERMATERIAL);
		rsWhiteWarhammer = new Sword("rsWhiteWarhammer", RSWHITEWARHAMMERMATERIAL);
		rsMithrilWarhammer = new Sword("rsMithrilWarhammer", RSMITHRILWARHAMMERMATERIAL);
		rsAdamantWarhammer = new Sword("rsAdamantWarhammer", RSADAMANTWARHAMMERMATERIAL);
		rsRuneWarhammer = new Sword("rsRuneWarhammer", RSRUNEWARHAMMERMATERIAL);
		rsBronzeMace = new Sword("rsBronzeMace", RSBRONZEMACEMATERIAL);
		rsIronMace = new Sword("rsIronMace", RSIRONMACEMATERIAL);
		rsSteelMace = new Sword("rsSteelMace", RSSTEELMACEMATERIAL);
		rsBlackMace = new Sword("rsBlackMace", RSBLACKMACEMATERIAL);
		rsWhiteMace = new Sword("rsWhiteMace", RSWHITEMACEMATERIAL);
		rsMithrilMace = new Sword("rsMithrilMace", RSMITHRILMACEMATERIAL);
		rsAdamantMace = new Sword("rsAdamantMace", RSADAMANTMACEMATERIAL);
		rsRuneMace = new Sword("rsRuneMace", RSRUNEMACEMATERIAL);
		rsGraniteLongsword = new Sword("rsGraniteLongsword", RSGRANITELONGSWORDMATERIAL);
		rsGraniteHammer = new Sword("rsGraniteHammer", RSGRANITEHAMMERMATERIAL);
		rsGraniteMaul = new Sword("rsGraniteMaul", RSGRANITEMAULMATERIAL);
		rsElderMaul = new Sword("rsElderMaul", RSELDERMAULMATERIAL);
		rsToktzxilak = new Sword("rsToktzxilak", RSTOKTZXILAKMATERIAL);
		rsWolfsbane = new Sword("rsWolfsbane", RSWOLFSBANEMATERIAL);
		rsZamorakGodsword = new Sword("rsZamorakGodsword", RSZAMORAKGODSWORDMATERIAL);
		rsBandosGodsword = new Sword("rsBandosGodsword", RSBANDOSGODSWORDMATERIAL);
		rsArmadylGodsword = new Sword("rsArmadylGodsword", RSARMADYLGODSWORDMATERIAL);
		rsSaradominGodsword = new Sword("rsSaradominGodsword", RSSARADOMINGODSWORDMATERIAL);
		rsBarrelchestAnchor = new Sword("rsBarrelchestAnchor", RSBARRELCHESTANCHORMATERIAL);

		//dmc
		dmcRedQueen = new Sword("dmcRedQueen", DMCREDQUEENMATERIAL);
		dmcRebellion = new Sword("dmcRebellion", DMCREBELLIONMATERIAL);
		dmcYamato = new Sword("dmcYamato", DMCYAMATOMATERIAL);

		//pkmn
		pkmnHonedgeShiny = new Sword("pkmnHonedgeShiny", PKMNHONEDGESHINYMATERIAL);
		pkmnHonedge = new Sword("pkmnHonedge", PKMNHONEDGEMATERIAL);

		//kirby
		kirbyGalaxia = new Sword("kirbyGalaxia", KIRBYGALAXIAMATERIAL);
		kirbyKirbyUltraSword = new Sword("kirbyKirbyUltraSword", KIRBYKIRBYULTRASWORDMATERIAL);
		kirbyKirbySword = new Sword("kirbyKirbySword", KIRBYKIRBYSWORDMATERIAL);

		//fe
		feChromFalchion = new Sword("feChromFalchion", FECHROMFALCHIONMATERIAL);
		feFalchion = new Sword("feFalchion", FEFALCHIONMATERIAL);

		//kh
		khKeyblade = new Sword("khKeyblade", KHKEYBLADEMATERIAL);

		//bleach
		bleachZabimaru = new Sword("bleachZabimaru", BLEACHZABIMARUMATERIAL);
		bleachZangestsu = new Sword("bleachZangestsu", BLEACHZANGESTSUMATERIAL);

		//ds
		dsGreatswordofArtorias = new Sword("dsGreatswordofArtorias", DSGREATSWORDOFARTORIASMATERIAL);
		dsGreatLordGreatsword = new Sword("dsGreatLordGreatsword", DSGREATLORDGREATSWORDMATERIAL);
		dsAstoraGreatsword = new Sword("dsAstoraGreatsword", DSASTORAGREATSWORDMATERIAL);
		dsZweilhander = new Sword("dsZweilhander", DSZWEILHANDERMATERIAL);

		//myth
		mythDeathScythe = new Sword("mythDeathScythe", MYTHDEATHSCYTHEMATERIAL);
		mythTheDevilPitchfork = new Sword("mythTheDevilPitchfork", MYTHTHEDEVILPITCHFORKMATERIAL);

		//bayonetta
		bayonettaShuraba = new Sword("bayonettaShuraba", BAYONETTASHURABAMATERIAL);
		bayonettaAngelSlayer = new Sword("bayonettaAngelSlayer", BAYONETTAANGELSLAYERMATERIAL);

		//gow
		gowLeviathanUpgraded = new Sword("gowLeviathanUpgraded", GOWLEVIATHANUPGRADEDMATERIAL);
		gowLeviathan = new Sword("gowLeviathan", GOWLEVIATHANMATERIAL);
		gowBladeofOlympus = new Sword("gowBladeofOlympus", GOWBLADEOFOLYMPUSMATERIAL);
		gowBladeofChaos = new Sword("gowBladeofChaos", GOWBLADEOFCHAOSMATERIAL);

		//skyrim
		skyrimIronSword = new Sword("skyrimIronSword", SKYRIMIRONSWORDMATERIAL);
		skyrimIronWarhammer = new Sword("skyrimIronWarhammer", SKYRIMIRONWARHAMMERMATERIAL);
		skyrimSteelSword = new Sword("skyrimSteelSword", SKYRIMSTEELSWORDMATERIAL);
		skyrimSteelWarhammer = new Sword("skyrimSteelWarhammer", SKYRIMSTEELWARHAMMERMATERIAL);
		skyrimOrcishSword = new Sword("skyrimOrcishSword", SKYRIMORCISHSWORDMATERIAL);
		skyrimOrcishWarhammer = new Sword("skyrimOrcishWarhammer", SKYRIMORCISHWARHAMMERMATERIAL);
		skyrimDwarvenSword = new Sword("skyrimDwarvenSword", SKYRIMDWARVENSWORDMATERIAL);
		skyrimDwarvenWarhammer = new Sword("skyrimDwarvenWarhammer", SKYRIMDWARVENWARHAMMERMATERIAL);
		skyrimElvenSword = new Sword("skyrimElvenSword", SKYRIMELVENSWORDMATERIAL);
		skyrimElvenWarhammer = new Sword("skyrimElvenWarhammer", SKYRIMELVENWARHAMMERMATERIAL);
		skyrimGlassSword = new Sword("skyrimGlassSword", SKYRIMGLASSSWORDMATERIAL);
		skyrimGlassWarhammer = new Sword("skyrimGlassWarhammer", SKYRIMGLASSWARHAMMERMATERIAL);
		skyrimEbonySword = new Sword("skyrimEbonySword", SKYRIMEBONYSWORDMATERIAL);
		skyrimEbonyWarhammer = new Sword("skyrimEbonyWarhammer", SKYRIMEBONYWARHAMMERMATERIAL);
		skyrimDaedricSword = new Sword("skyrimDaedricSword", SKYRIMDAEDRICSWORDMATERIAL);
		skyrimDaedricWarhammer = new Sword("skyrimDaedricWarhammer", SKYRIMDAEDRICWARHAMMERMATERIAL);
		skyrimDragonboneSword = new Sword("skyrimDragonboneSword", SKYRIMDRAGONBONESWORDMATERIAL);
		skyrimDragonboneWarhammer = new Sword("skyrimDragonboneWarhammer", SKYRIMDRAGONBONEWARHAMMERMATERIAL);
		skyrimImperialSword = new Sword("skyrimImperialSword", SKYRIMIMPERIALSWORDMATERIAL);
		skyrimDawnbreaker = new Sword("skyrimDawnbreaker", SKYRIMDAWNBREAKERMATERIAL);
		skyrimAncientNordSword = new Sword("skyrimAncientNordSword", SKYRIMANCIENTNORDSWORDMATERIAL);
		skyrimChillrend = new Sword("skyrimChillrend", SKYRIMCHILLRENDMATERIAL);
		skyrimEbonyBlade = new Sword("skyrimEbonyBlade", SKYRIMEBONYBLADEMATERIAL);

		//mh
		mhChickenDecapitator = new Sword("mhChickenDecapitator", MHCHICKENDECAPITATORMATERIAL);
		mhGolemBlade = new Sword("mhGolemBlade", MHGOLEMBLADEMATERIAL);
		mhDefender = new Sword("mhDefender", MHDEFENDERMATERIAL);
		mhBlackBeltBlade = new Sword("mhBlackBeltBlade", MHBLACKBELTBLADEMATERIAL);
		mhWailingCleaver = new Sword("mhWailingCleaver", MHWAILINGCLEAVERMATERIAL);
		mhGaelicFlame = new Sword("mhGaelicFlame", MHGAELICFLAMEMATERIAL);
		mhBoneKatana = new Sword("mhBoneKatana", MHBONEKATANAMATERIAL);
		mhHellishSlasher = new Sword("mhHellishSlasher", MHHELLISHSLASHERMATERIAL);
		mhCentenarianDagger = new Sword("mhCentenarianDagger", MHCENTENARIANDAGGERMATERIAL);
		mhWyvernBladeBlood = new Sword("mhWyvernBladeBlood", MHWYVERNBLADEBLOODMATERIAL);
		mhWyvernBladeHolly = new Sword("mhWyvernBladeHolly", MHWYVERNBLADEHOLLYMATERIAL);
		mhWyvernBladePale = new Sword("mhWyvernBladePale", MHWYVERNBLADEPALEMATERIAL);
		mhWyvernBladeAzure = new Sword("mhWyvernBladeAzure", MHWYVERNBLADEAZUREMATERIAL);
		mhWyvernBladeLeaf = new Sword("mhWyvernBladeLeaf", MHWYVERNBLADELEAFMATERIAL);
		mhRathalosFlamesword = new Sword("mhRathalosFlamesword", MHRATHALOSFLAMESWORDMATERIAL);

		//terraria
		terrariaPalmWoodSword = new Sword("terrariaPalmWoodSword", TERRARIAPALMWOODSWORDMATERIAL);
		terrariaBorealWoodSword = new Sword("terrariaBorealWoodSword", TERRARIABOREALWOODSWORDMATERIAL);
		terrariaShadewoodSword = new Sword("terrariaShadewoodSword", TERRARIASHADEWOODSWORDMATERIAL);
		terrariaEbonwoodSword = new Sword("terrariaEbonwoodSword", TERRARIAEBONWOODSWORDMATERIAL);
		terrariaCopperShortsword = new Sword("terrariaCopperShortsword", TERRARIACOPPERSHORTSWORDMATERIAL);
		terrariaCopperBroadsword = new Sword("terrariaCopperBroadsword", TERRARIACOPPERBROADSWORDMATERIAL);
		terrariaTinShortsword = new Sword("terrariaTinShortsword", TERRARIATINSHORTSWORDMATERIAL);
		terrariaTinBroadsword = new Sword("terrariaTinBroadsword", TERRARIATINBROADSWORDMATERIAL);
		terrariaLeadShortsword = new Sword("terrariaLeadShortsword", TERRARIALEADSHORTSWORDMATERIAL);
		terrariaLeadBroadsword = new Sword("terrariaLeadBroadsword", TERRARIALEADBROADSWORDMATERIAL);
		terrariaSpear = new Sword("terrariaSpear", TERRARIASPEARMATERIAL);
		terrariaIronShortsword = new Sword("terrariaIronShortsword", TERRARIAIRONSHORTSWORDMATERIAL);
		terrariaIronBroadsword = new Sword("terrariaIronBroadsword", TERRARIAIRONBROADSWORDMATERIAL);
		terrariaSilverBroadsword = new Sword("terrariaSilverBroadsword", TERRARIASILVERBROADSWORDMATERIAL);
		terrariaSilverShortsword = new Sword("terrariaSilverShortsword", TERRARIASILVERSHORTSWORDMATERIAL);
		terrariaGoldShortsword = new Sword("terrariaGoldShortsword", TERRARIAGOLDSHORTSWORDMATERIAL);
		terrariaGoldBroadsword = new Sword("terrariaGoldBroadsword", TERRARIAGOLDBROADSWORDMATERIAL);
		terrariaTungstenBroadsword = new Sword("terrariaTungstenBroadsword", TERRARIATUNGSTENBROADSWORDMATERIAL);
		terrariaTungstenShortsword = new Sword("terrariaTungstenShortsword", TERRARIATUNGSTENSHORTSWORDMATERIAL);
		terrariaPlatinumShortsword = new Sword("terrariaPlatinumShortsword", TERRARIAPLATINUMSHORTSWORDMATERIAL);
		terrariaPlatinumBroadsword = new Sword("terrariaPlatinumBroadsword", TERRARIAPLATINUMBROADSWORDMATERIAL);
		terrariaMandibleBlade = new Sword("terrariaMandibleBlade", TERRARIAMANDIBLEBLADEMATERIAL);
		terrariaKatana = new Sword("terrariaKatana", TERRARIAKATANAMATERIAL);
		terrariaExoticScimitar = new Sword("terrariaExoticScimitar", TERRARIAEXOTICSCIMITARMATERIAL);
		terrariaMuramasa = new Sword("terrariaMuramasa", TERRARIAMURAMASAMATERIAL);
		terrariaFalconBlade = new Sword("terrariaFalconBlade", TERRARIAFALCONBLADEMATERIAL);
		terrariaBladeofGrass = new Sword("terrariaBladeofGrass", TERRARIABLADEOFGRASSMATERIAL);
		terrariaFieryGreatsword = new Sword("terrariaFieryGreatsword", TERRARIAFIERYGREATSWORDMATERIAL);
		terrariaBoneSword = new Sword("terrariaBoneSword", TERRARIABONESWORDMATERIAL);
		terrariaBloodButcherer = new Sword("terrariaBloodButcherer", TERRARIABLOODBUTCHERERMATERIAL);
		terrariaEnchantedSword = new Sword("terrariaEnchantedSword", TERRARIAENCHANTEDSWORDMATERIAL);
		terrariaStarfury = new Sword("terrariaStarfury", TERRARIASTARFURYMATERIAL);
		terrariaBeeKeeper = new Sword("terrariaBeeKeeper", TERRARIABEEKEEPERMATERIAL);
		terrariaIceBlade = new Sword("terrariaIceBlade", TERRARIAICEBLADEMATERIAL);
		terrariaNightEdge = new Sword("terrariaNightEdge", TERRARIANIGHTEDGEMATERIAL);
		terrariaArkhalis = new Sword("terrariaArkhalis", TERRARIAARKHALISMATERIAL);
		terrariaTrident = new Sword("terrariaTrident", TERRARIATRIDENTMATERIAL);
		terrariaTheRottedFork = new Sword("terrariaTheRottedFork", TERRARIATHEROTTEDFORKMATERIAL);
		terrariaWhitePhaseblade = new Sword("terrariaWhitePhaseblade", TERRARIAWHITEPHASEBLADEMATERIAL);
		terrariaYellowPhaseblade = new Sword("terrariaYellowPhaseblade", TERRARIAYELLOWPHASEBLADEMATERIAL);
		terrariaPurplePhaseblade = new Sword("terrariaPurplePhaseblade", TERRARIAPURPLEPHASEBLADEMATERIAL);
		terrariaGreenPhaseblade = new Sword("terrariaGreenPhaseblade", TERRARIAGREENPHASEBLADEMATERIAL);
		terrariaRedPhaseblade = new Sword("terrariaRedPhaseblade", TERRARIAREDPHASEBLADEMATERIAL);
		terrariaBluePhaseblade = new Sword("terrariaBluePhaseblade", TERRARIABLUEPHASEBLADEMATERIAL);
		terrariaLightBane = new Sword("terrariaLightBane", TERRARIALIGHTBANEMATERIAL);
		terrariaDarkLance = new Sword("terrariaDarkLance", TERRARIADARKLANCEMATERIAL);
		terrariaPurpleClubberfish = new Sword("terrariaPurpleClubberfish", TERRARIAPURPLECLUBBERFISHMATERIAL);
		terrariaCactusSword = new Sword("terrariaCactusSword", TERRARIACACTUSSWORDMATERIAL);
		terrariaSwordfish = new Sword("terrariaSwordfish", TERRARIASWORDFISHMATERIAL);

		//sw
		swYellowLightsaber = new Sword("swYellowLightsaber", SWYELLOWLIGHTSABERMATERIAL);
		swGreenLightsaber = new Sword("swGreenLightsaber", SWGREENLIGHTSABERMATERIAL);
		swBlueLightsaber = new Sword("swBlueLightsaber", SWBLUELIGHTSABERMATERIAL);
		swRedLightsaber = new Sword("swRedLightsaber", SWREDLIGHTSABERMATERIAL);
		swMaceWinduLightsaber = new Sword("swMaceWinduLightsaber", SWMACEWINDULIGHTSABERMATERIAL);
		swTheInquisitorLightsaber = new Sword("swTheInquisitorLightsaber", SWTHEINQUISITORLIGHTSABERMATERIAL);
		swDarthMaulLightsaber = new Sword("swDarthMaulLightsaber", SWDARTHMAULLIGHTSABERMATERIAL);
		swQuiGonJinnLightsaber = new Sword("swQuiGonJinnLightsaber", SWQUIGONJINNLIGHTSABERMATERIAL);
		swKyloRenLightsaber = new Sword("swKyloRenLightsaber", SWKYLORENLIGHTSABERMATERIAL);
		swCountDookuLightsaber = new Sword("swCountDookuLightsaber", SWCOUNTDOOKULIGHTSABERMATERIAL);
		swDarksaber = new Sword("swDarksaber", SWDARKSABERMATERIAL);

		//internet
		internetDemonoidPitchfork = new Sword("internetDemonoidPitchfork", INTERNETDEMONOIDPITCHFORKMATERIAL);

		//nh
		nhMagicbane = new Sword("nhMagicbane", NHMAGICBANEMATERIAL);
		nhAthame = new Sword("nhAthame", NHATHAMEMATERIAL);
		nhGrayswandir = new Sword("nhGrayswandir", NHGRAYSWANDIRMATERIAL);
		nhSilverSaber = new Sword("nhSilverSaber", NHSILVERSABERMATERIAL);

		//abcm
		abcmExcalibur = new Sword("abcmExcalibur", ABCMEXCALIBURMATERIAL);


	    //ASSIGN CREATIVE TAB===========================================================================================
		
		//lotr
		if (ModConfig.enabledItems.lotrenabled.lotrGimliBattleAxe && ModConfig.disableSeries.lotr) lotrGimliBattleAxe.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lotrenabled.lotrGimliLongAxe && ModConfig.disableSeries.lotr) lotrGimliLongAxe.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lotrenabled.lotrMorgulBlade && ModConfig.disableSeries.lotr) lotrMorgulBlade.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lotrenabled.lotrSting && ModConfig.disableSeries.lotr) lotrSting.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lotrenabled.lotrGlamdring && ModConfig.disableSeries.lotr) lotrGlamdring.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lotrenabled.lotrAnduril && ModConfig.disableSeries.lotr) lotrAnduril.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lotrenabled.lotrNarsil && ModConfig.disableSeries.lotr) lotrNarsil.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lotrenabled.lotrSauronMace && ModConfig.disableSeries.lotr) lotrSauronMace.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lotrenabled.lotrWitchKingSword && ModConfig.disableSeries.lotr) lotrWitchKingSword.setCreativeTab(tabHeroicArmory);

		//loz
		if (ModConfig.enabledItems.lozenabled.lozMasterSword && ModConfig.disableSeries.loz) lozMasterSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozMasterSwordII && ModConfig.disableSeries.loz) lozMasterSwordII.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozTemperedSword && ModConfig.disableSeries.loz) lozTemperedSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozMasterSwordIII && ModConfig.disableSeries.loz) lozMasterSwordIII.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozGoldenSword && ModConfig.disableSeries.loz) lozGoldenSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozFlameblade && ModConfig.disableSeries.loz) lozFlameblade.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozDarknutSwordTp && ModConfig.disableSeries.loz) lozDarknutSwordTp.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozGhirahimSword && ModConfig.disableSeries.loz) lozGhirahimSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozFierceDietySword && ModConfig.disableSeries.loz) lozFierceDietySword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozZeldaSword && ModConfig.disableSeries.loz) lozZeldaSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozBokoStick && ModConfig.disableSeries.loz) lozBokoStick.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozCaneofByrna && ModConfig.disableSeries.loz) lozCaneofByrna.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozMegatonHammer && ModConfig.disableSeries.loz) lozMegatonHammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozKokiriSwordMm && ModConfig.disableSeries.loz) lozKokiriSwordMm.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozKokiriSwordOoT && ModConfig.disableSeries.loz) lozKokiriSwordOoT.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozDemiseSword && ModConfig.disableSeries.loz) lozDemiseSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozGiantKnife && ModConfig.disableSeries.loz) lozGiantKnife.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozBiggoronSword && ModConfig.disableSeries.loz) lozBiggoronSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozPhantomGanonSword && ModConfig.disableSeries.loz) lozPhantomGanonSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozUltimateSword && ModConfig.disableSeries.loz) lozUltimateSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozRoyalGuardSword && ModConfig.disableSeries.loz) lozRoyalGuardSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozMagicSwordConcept && ModConfig.disableSeries.loz) lozMagicSwordConcept.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozMagicSword && ModConfig.disableSeries.loz) lozMagicSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozWhiteSword && ModConfig.disableSeries.loz) lozWhiteSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozWhiteSwordConcept && ModConfig.disableSeries.loz) lozWhiteSwordConcept.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozPicoriBlade && ModConfig.disableSeries.loz) lozPicoriBlade.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozRazorSword && ModConfig.disableSeries.loz) lozRazorSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozGreatFairySword && ModConfig.disableSeries.loz) lozGreatFairySword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozGoddessWhiteSword && ModConfig.disableSeries.loz) lozGoddessWhiteSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozGoddessSword && ModConfig.disableSeries.loz) lozGoddessSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozGildedSword && ModConfig.disableSeries.loz) lozGildedSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozSpikedBokoClub && ModConfig.disableSeries.loz) lozSpikedBokoClub.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.lozenabled.lozBokoClub && ModConfig.disableSeries.loz) lozBokoClub.setCreativeTab(tabHeroicArmory);

		//at
		if (ModConfig.enabledItems.atenabled.atJakeSword && ModConfig.disableSeries.at) atJakeSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.atenabled.atCrystalSword && ModConfig.disableSeries.at) atCrystalSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.atenabled.atNothung && ModConfig.disableSeries.at) atNothung.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.atenabled.atFinnSword && ModConfig.disableSeries.at) atFinnSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.atenabled.atSwordoftheDead && ModConfig.disableSeries.at) atSwordoftheDead.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.atenabled.atWishStarSword && ModConfig.disableSeries.at) atWishStarSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.atenabled.atFightKingSword && ModConfig.disableSeries.at) atFightKingSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.atenabled.atRootSword && ModConfig.disableSeries.at) atRootSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.atenabled.atScarlet && ModConfig.disableSeries.at) atScarlet.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.atenabled.atGrassSword && ModConfig.disableSeries.at) atGrassSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.atenabled.atDemonBloodSword && ModConfig.disableSeries.at) atDemonBloodSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.atenabled.atAxeBass && ModConfig.disableSeries.at) atAxeBass.setCreativeTab(tabHeroicArmory);

		//ff
		if (ModConfig.enabledItems.ffenabled.ffTheMasamune && ModConfig.disableSeries.ff) ffTheMasamune.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.ffenabled.ffBusterSword && ModConfig.disableSeries.ff) ffBusterSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.ffenabled.ffCaladbolg && ModConfig.disableSeries.ff) ffCaladbolg.setCreativeTab(tabHeroicArmory);

		//rotmg
		if (ModConfig.enabledItems.rotmgenabled.rotmgSwordoftheColossus && ModConfig.disableSeries.rotmg) rotmgSwordoftheColossus.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rotmgenabled.rotmgCrystalSword && ModConfig.disableSeries.rotmg) rotmgCrystalSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rotmgenabled.rotmgPixieEnchantedSword && ModConfig.disableSeries.rotmg) rotmgPixieEnchantedSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rotmgenabled.rotmgSwordOfAcclaim && ModConfig.disableSeries.rotmg) rotmgSwordOfAcclaim.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rotmgenabled.rotmgDemonBlade && ModConfig.disableSeries.rotmg) rotmgDemonBlade.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rotmgenabled.rotmgSwordoftheMadGod && ModConfig.disableSeries.rotmg) rotmgSwordoftheMadGod.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rotmgenabled.rotmgIndomptable && ModConfig.disableSeries.rotmg) rotmgIndomptable.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rotmgenabled.rotmgPirateKingCutlass && ModConfig.disableSeries.rotmg) rotmgPirateKingCutlass.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rotmgenabled.rotmgSwordofSplendor && ModConfig.disableSeries.rotmg) rotmgSwordofSplendor.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rotmgenabled.rotmgSkysplitterSword && ModConfig.disableSeries.rotmg) rotmgSkysplitterSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rotmgenabled.rotmgArchonSword && ModConfig.disableSeries.rotmg) rotmgArchonSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rotmgenabled.rotmgAncientStoneSword && ModConfig.disableSeries.rotmg) rotmgAncientStoneSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rotmgenabled.rotmgDragonsoulSword && ModConfig.disableSeries.rotmg) rotmgDragonsoulSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rotmgenabled.rotmgRavenheartSword && ModConfig.disableSeries.rotmg) rotmgRavenheartSword.setCreativeTab(tabHeroicArmory);

		//sc
		if (ModConfig.enabledItems.scenabled.scFirangi && ModConfig.disableSeries.sc) scFirangi.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scCocytus && ModConfig.disableSeries.sc) scCocytus.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scErlangBlade && ModConfig.disableSeries.sc) scErlangBlade.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scSoulEdgeNightmare && ModConfig.disableSeries.sc) scSoulEdgeNightmare.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scPhlegathon && ModConfig.disableSeries.sc) scPhlegathon.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scAcheron && ModConfig.disableSeries.sc) scAcheron.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scLethe && ModConfig.disableSeries.sc) scLethe.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scQueenGuard && ModConfig.disableSeries.sc) scQueenGuard.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scHolyAntler && ModConfig.disableSeries.sc) scHolyAntler.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scEpee && ModConfig.disableSeries.sc) scEpee.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scWarHammer && ModConfig.disableSeries.sc) scWarHammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scKalutues && ModConfig.disableSeries.sc) scKalutues.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scEstoc && ModConfig.disableSeries.sc) scEstoc.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scFlambert2P && ModConfig.disableSeries.sc) scFlambert2P.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scReiterpallasch && ModConfig.disableSeries.sc) scReiterpallasch.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scFlambert && ModConfig.disableSeries.sc) scFlambert.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scBlueCrystalRod && ModConfig.disableSeries.sc) scBlueCrystalRod.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scFireBlade && ModConfig.disableSeries.sc) scFireBlade.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scXiSword && ModConfig.disableSeries.sc) scXiSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scOmegaSword2P && ModConfig.disableSeries.sc) scOmegaSword2P.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scOmegaSword && ModConfig.disableSeries.sc) scOmegaSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scOrichalcum && ModConfig.disableSeries.sc) scOrichalcum.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scStiletto && ModConfig.disableSeries.sc) scStiletto.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scRequiem && ModConfig.disableSeries.sc) scRequiem.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scFaust && ModConfig.disableSeries.sc) scFaust.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scFlamberge && ModConfig.disableSeries.sc) scFlamberge.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scSteelPaddle && ModConfig.disableSeries.sc) scSteelPaddle.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scGlam && ModConfig.disableSeries.sc) scGlam.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.scenabled.scGreatBlade && ModConfig.disableSeries.sc) scGreatBlade.setCreativeTab(tabHeroicArmory);

		//rs
		if (ModConfig.enabledItems.rsenabled.rsBronzeSword && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsBronzeSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsIronSword && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsIronSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsWhiteSword && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsWhiteSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsBlackSword && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsBlackSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsSteelSword && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsSteelSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsMithrilSword && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) rsMithrilSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsAdamantSword && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) rsAdamantSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsRuneSword && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) rsRuneSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsDragonSword && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) rsDragonSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsBronzeBattleaxe && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsBronzeBattleaxe.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsIronBattleaxe && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsIronBattleaxe.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsSteelBattleaxe && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsSteelBattleaxe.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsBlackBattleaxe && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsBlackBattleaxe.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsWhiteBattleaxe && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsWhiteBattleaxe.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsMithrilBattleaxe && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) rsMithrilBattleaxe.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsAdamantBattleaxe && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) rsAdamantBattleaxe.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsRuneBattleaxe && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) rsRuneBattleaxe.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsDragonBattleaxe && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) rsDragonBattleaxe.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsBronzeScimitar && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsBronzeScimitar.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsIronScimitar && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsIronScimitar.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsBlackScimitar && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsBlackScimitar.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsWhiteScimitar && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsWhiteScimitar.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsSteelScimitar && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsSteelScimitar.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsMithrilScimitar && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) rsMithrilScimitar.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsAdamantScimitar && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) rsAdamantScimitar.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsRuneScimitar && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) rsRuneScimitar.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsDragonScimitar && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) rsDragonScimitar.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsBronzeWarhammer && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsBronzeWarhammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsIronWarhammer && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsIronWarhammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsSteelWarhammer && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsSteelWarhammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsBlackWarhammer && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsBlackWarhammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsWhiteWarhammer && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsWhiteWarhammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsMithrilWarhammer && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) rsMithrilWarhammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsAdamantWarhammer && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) rsAdamantWarhammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsRuneWarhammer && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) rsRuneWarhammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsBronzeMace && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) rsBronzeMace.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsIronMace && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsIronMace.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsSteelMace && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsSteelMace.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsBlackMace && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsBlackMace.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsWhiteMace && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) rsWhiteMace.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsMithrilMace && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) rsMithrilMace.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsAdamantMace && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) rsAdamantMace.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsRuneMace && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) rsRuneMace.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsGraniteLongsword && ModConfig.disableSeries.rs) rsGraniteLongsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsGraniteHammer && ModConfig.disableSeries.rs) rsGraniteHammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsGraniteMaul && ModConfig.disableSeries.rs) rsGraniteMaul.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsElderMaul && ModConfig.disableSeries.rs) rsElderMaul.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsToktzxilak && ModConfig.disableSeries.rs) rsToktzxilak.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsWolfsbane && ModConfig.disableSeries.rs) rsWolfsbane.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsZamorakGodsword && ModConfig.disableSeries.rs) rsZamorakGodsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsBandosGodsword && ModConfig.disableSeries.rs) rsBandosGodsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsArmadylGodsword && ModConfig.disableSeries.rs) rsArmadylGodsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsSaradominGodsword && ModConfig.disableSeries.rs) rsSaradominGodsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.rsenabled.rsBarrelchestAnchor && ModConfig.disableSeries.rs) rsBarrelchestAnchor.setCreativeTab(tabHeroicArmory);

		//dmc
		if (ModConfig.enabledItems.dmcenabled.dmcRedQueen && ModConfig.disableSeries.dmc) dmcRedQueen.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.dmcenabled.dmcRebellion && ModConfig.disableSeries.dmc) dmcRebellion.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.dmcenabled.dmcYamato && ModConfig.disableSeries.dmc) dmcYamato.setCreativeTab(tabHeroicArmory);

		//pkmn
		if (ModConfig.enabledItems.pkmnenabled.pkmnHonedgeShiny && ModConfig.disableSeries.pkmn) pkmnHonedgeShiny.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.pkmnenabled.pkmnHonedge && ModConfig.disableSeries.pkmn) pkmnHonedge.setCreativeTab(tabHeroicArmory);

		//kirby
		if (ModConfig.enabledItems.kirbyenabled.kirbyGalaxia && ModConfig.disableSeries.kirby) kirbyGalaxia.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.kirbyenabled.kirbyKirbyUltraSword && ModConfig.disableSeries.kirby) kirbyKirbyUltraSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.kirbyenabled.kirbyKirbySword && ModConfig.disableSeries.kirby) kirbyKirbySword.setCreativeTab(tabHeroicArmory);

		//fe
		if (ModConfig.enabledItems.feenabled.feChromFalchion && ModConfig.disableSeries.fe) feChromFalchion.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.feenabled.feFalchion && ModConfig.disableSeries.fe) feFalchion.setCreativeTab(tabHeroicArmory);

		//kh
		if (ModConfig.enabledItems.khenabled.khKeyblade && ModConfig.disableSeries.kh) khKeyblade.setCreativeTab(tabHeroicArmory);

		//bleach
		if (ModConfig.enabledItems.bleachenabled.bleachZabimaru && ModConfig.disableSeries.bleach) bleachZabimaru.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.bleachenabled.bleachZangestsu && ModConfig.disableSeries.bleach) bleachZangestsu.setCreativeTab(tabHeroicArmory);

		//ds
		if (ModConfig.enabledItems.dsenabled.dsGreatswordofArtorias && ModConfig.disableSeries.ds) dsGreatswordofArtorias.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.dsenabled.dsGreatLordGreatsword && ModConfig.disableSeries.ds) dsGreatLordGreatsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.dsenabled.dsAstoraGreatsword && ModConfig.disableSeries.ds) dsAstoraGreatsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.dsenabled.dsZweilhander && ModConfig.disableSeries.ds) dsZweilhander.setCreativeTab(tabHeroicArmory);

		//myth
		if (ModConfig.enabledItems.mythenabled.mythDeathScythe && ModConfig.disableSeries.myth) mythDeathScythe.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.mythenabled.mythTheDevilPitchfork && ModConfig.disableSeries.myth) mythTheDevilPitchfork.setCreativeTab(tabHeroicArmory);

		//bayonetta
		if (ModConfig.enabledItems.bayonettaenabled.bayonettaShuraba && ModConfig.disableSeries.bayonetta) bayonettaShuraba.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.bayonettaenabled.bayonettaAngelSlayer && ModConfig.disableSeries.bayonetta) bayonettaAngelSlayer.setCreativeTab(tabHeroicArmory);

		//gow
		if (ModConfig.enabledItems.gowenabled.gowLeviathanUpgraded && ModConfig.disableSeries.gow) gowLeviathanUpgraded.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.gowenabled.gowLeviathan && ModConfig.disableSeries.gow) gowLeviathan.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.gowenabled.gowBladeofOlympus && ModConfig.disableSeries.gow) gowBladeofOlympus.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.gowenabled.gowBladeofChaos && ModConfig.disableSeries.gow) gowBladeofChaos.setCreativeTab(tabHeroicArmory);

		//skyrim
		if (ModConfig.enabledItems.skyrimenabled.skyrimIronSword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) skyrimIronSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimIronWarhammer && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) skyrimIronWarhammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimSteelSword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) skyrimSteelSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimSteelWarhammer && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) skyrimSteelWarhammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimOrcishSword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) skyrimOrcishSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimOrcishWarhammer && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) skyrimOrcishWarhammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimDwarvenSword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) skyrimDwarvenSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimDwarvenWarhammer && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) skyrimDwarvenWarhammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimElvenSword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) skyrimElvenSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimElvenWarhammer && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) skyrimElvenWarhammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimGlassSword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) skyrimGlassSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimGlassWarhammer && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) skyrimGlassWarhammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimEbonySword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) skyrimEbonySword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimEbonyWarhammer && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) skyrimEbonyWarhammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimDaedricSword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) skyrimDaedricSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimDaedricWarhammer && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) skyrimDaedricWarhammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimDragonboneSword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) skyrimDragonboneSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimDragonboneWarhammer && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) skyrimDragonboneWarhammer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimImperialSword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) skyrimImperialSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimDawnbreaker && ModConfig.disableSeries.skyrim) skyrimDawnbreaker.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimAncientNordSword && ModConfig.disableSeries.skyrim) skyrimAncientNordSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimChillrend && ModConfig.disableSeries.skyrim) skyrimChillrend.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.skyrimenabled.skyrimEbonyBlade && ModConfig.disableSeries.skyrim) skyrimEbonyBlade.setCreativeTab(tabHeroicArmory);

		//mh
		if (ModConfig.enabledItems.mhenabled.mhChickenDecapitator && ModConfig.disableSeries.mh) mhChickenDecapitator.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.mhenabled.mhGolemBlade && ModConfig.disableSeries.mh) mhGolemBlade.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.mhenabled.mhDefender && ModConfig.disableSeries.mh) mhDefender.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.mhenabled.mhBlackBeltBlade && ModConfig.disableSeries.mh) mhBlackBeltBlade.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.mhenabled.mhWailingCleaver && ModConfig.disableSeries.mh) mhWailingCleaver.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.mhenabled.mhGaelicFlame && ModConfig.disableSeries.mh) mhGaelicFlame.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.mhenabled.mhBoneKatana && ModConfig.disableSeries.mh) mhBoneKatana.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.mhenabled.mhHellishSlasher && ModConfig.disableSeries.mh) mhHellishSlasher.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.mhenabled.mhCentenarianDagger && ModConfig.disableSeries.mh) mhCentenarianDagger.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.mhenabled.mhWyvernBladeBlood && ModConfig.disableSeries.mh) mhWyvernBladeBlood.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.mhenabled.mhWyvernBladeHolly && ModConfig.disableSeries.mh) mhWyvernBladeHolly.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.mhenabled.mhWyvernBladePale && ModConfig.disableSeries.mh) mhWyvernBladePale.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.mhenabled.mhWyvernBladeAzure && ModConfig.disableSeries.mh) mhWyvernBladeAzure.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.mhenabled.mhWyvernBladeLeaf && ModConfig.disableSeries.mh) mhWyvernBladeLeaf.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.mhenabled.mhRathalosFlamesword && ModConfig.disableSeries.mh) mhRathalosFlamesword.setCreativeTab(tabHeroicArmory);

		//terraria
		if (ModConfig.enabledItems.terrariaenabled.terrariaPalmWoodSword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) terrariaPalmWoodSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaBorealWoodSword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) terrariaBorealWoodSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaShadewoodSword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) terrariaShadewoodSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaEbonwoodSword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) terrariaEbonwoodSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaCopperShortsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) terrariaCopperShortsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaCopperBroadsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) terrariaCopperBroadsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaTinShortsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) terrariaTinShortsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaTinBroadsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) terrariaTinBroadsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaLeadShortsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) terrariaLeadShortsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaLeadBroadsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) terrariaLeadBroadsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaSpear && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) terrariaSpear.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaIronShortsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) terrariaIronShortsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaIronBroadsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) terrariaIronBroadsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaSilverBroadsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) terrariaSilverBroadsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaSilverShortsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) terrariaSilverShortsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaGoldShortsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) terrariaGoldShortsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaGoldBroadsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) terrariaGoldBroadsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaTungstenBroadsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic) terrariaTungstenBroadsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaTungstenShortsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic) terrariaTungstenShortsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaPlatinumShortsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic) terrariaPlatinumShortsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaPlatinumBroadsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic) terrariaPlatinumBroadsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaMandibleBlade && ModConfig.disableSeries.terraria) terrariaMandibleBlade.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaKatana && ModConfig.disableSeries.terraria) terrariaKatana.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaExoticScimitar && ModConfig.disableSeries.terraria) terrariaExoticScimitar.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaMuramasa && ModConfig.disableSeries.terraria) terrariaMuramasa.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaFalconBlade && ModConfig.disableSeries.terraria) terrariaFalconBlade.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaBladeofGrass && ModConfig.disableSeries.terraria) terrariaBladeofGrass.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaFieryGreatsword && ModConfig.disableSeries.terraria) terrariaFieryGreatsword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaBoneSword && ModConfig.disableSeries.terraria) terrariaBoneSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaBloodButcherer && ModConfig.disableSeries.terraria) terrariaBloodButcherer.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaEnchantedSword && ModConfig.disableSeries.terraria) terrariaEnchantedSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaStarfury && ModConfig.disableSeries.terraria) terrariaStarfury.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaBeeKeeper && ModConfig.disableSeries.terraria) terrariaBeeKeeper.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaIceBlade && ModConfig.disableSeries.terraria) terrariaIceBlade.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaNightEdge && ModConfig.disableSeries.terraria) terrariaNightEdge.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaArkhalis && ModConfig.disableSeries.terraria) terrariaArkhalis.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaTrident && ModConfig.disableSeries.terraria) terrariaTrident.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaTheRottedFork && ModConfig.disableSeries.terraria) terrariaTheRottedFork.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaWhitePhaseblade && ModConfig.disableSeries.terraria && ModConfig.disableSets.tech) terrariaWhitePhaseblade.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaYellowPhaseblade && ModConfig.disableSeries.terraria && ModConfig.disableSets.tech) terrariaYellowPhaseblade.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaPurplePhaseblade && ModConfig.disableSeries.terraria && ModConfig.disableSets.tech) terrariaPurplePhaseblade.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaGreenPhaseblade && ModConfig.disableSeries.terraria && ModConfig.disableSets.tech) terrariaGreenPhaseblade.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaRedPhaseblade && ModConfig.disableSeries.terraria && ModConfig.disableSets.tech) terrariaRedPhaseblade.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaBluePhaseblade && ModConfig.disableSeries.terraria && ModConfig.disableSets.tech) terrariaBluePhaseblade.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaLightBane && ModConfig.disableSeries.terraria) terrariaLightBane.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaDarkLance && ModConfig.disableSeries.terraria) terrariaDarkLance.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaPurpleClubberfish && ModConfig.disableSeries.terraria && ModConfig.disableSets.joke) terrariaPurpleClubberfish.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaCactusSword && ModConfig.disableSeries.terraria && ModConfig.disableSets.joke) terrariaCactusSword.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.terrariaenabled.terrariaSwordfish && ModConfig.disableSeries.terraria && ModConfig.disableSets.joke) terrariaSwordfish.setCreativeTab(tabHeroicArmory);

		//sw
		if (ModConfig.enabledItems.swenabled.swYellowLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) swYellowLightsaber.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.swenabled.swGreenLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) swGreenLightsaber.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.swenabled.swBlueLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) swBlueLightsaber.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.swenabled.swRedLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) swRedLightsaber.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.swenabled.swMaceWinduLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) swMaceWinduLightsaber.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.swenabled.swTheInquisitorLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) swTheInquisitorLightsaber.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.swenabled.swDarthMaulLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) swDarthMaulLightsaber.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.swenabled.swQuiGonJinnLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) swQuiGonJinnLightsaber.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.swenabled.swKyloRenLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) swKyloRenLightsaber.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.swenabled.swCountDookuLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) swCountDookuLightsaber.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.swenabled.swDarksaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) swDarksaber.setCreativeTab(tabHeroicArmory);

		//internet
		if (ModConfig.enabledItems.internetenabled.internetDemonoidPitchfork && ModConfig.disableSeries.internet) internetDemonoidPitchfork.setCreativeTab(tabHeroicArmory);

		//nh
		if (ModConfig.enabledItems.nhenabled.nhMagicbane && ModConfig.disableSeries.nh) nhMagicbane.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.nhenabled.nhAthame && ModConfig.disableSeries.nh) nhAthame.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.nhenabled.nhGrayswandir && ModConfig.disableSeries.nh) nhGrayswandir.setCreativeTab(tabHeroicArmory);
		if (ModConfig.enabledItems.nhenabled.nhSilverSaber && ModConfig.disableSeries.nh) nhSilverSaber.setCreativeTab(tabHeroicArmory);

		//abcm
		if (ModConfig.enabledItems.abcmenabled.abcmExcalibur && ModConfig.disableSeries.abcm) abcmExcalibur.setCreativeTab(tabHeroicArmory);

		
		//Loot Tables
		LootTableList.register(new ResourceLocation("heroicarmory", "loot"));
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {

	    //REGISTER ITEMS================================================================================================
	    
		//lotr
		event.getRegistry().registerAll(lotrGimliBattleAxe,lotrGimliLongAxe,lotrMorgulBlade,lotrSting,lotrGlamdring,lotrAnduril,lotrNarsil,lotrSauronMace,lotrWitchKingSword);

		//loz
		event.getRegistry().registerAll(lozMasterSword,lozMasterSwordII,lozTemperedSword,lozMasterSwordIII,lozGoldenSword,lozFlameblade,lozDarknutSwordTp,lozGhirahimSword,lozFierceDietySword,lozZeldaSword,lozBokoStick,lozCaneofByrna,lozMegatonHammer,lozKokiriSwordMm,lozKokiriSwordOoT,lozDemiseSword,lozGiantKnife,lozBiggoronSword,lozPhantomGanonSword,lozUltimateSword,lozRoyalGuardSword,lozMagicSwordConcept,lozMagicSword,lozWhiteSword,lozWhiteSwordConcept,lozPicoriBlade,lozRazorSword,lozGreatFairySword,lozGoddessWhiteSword,lozGoddessSword,lozGildedSword,lozSpikedBokoClub,lozBokoClub);

		//at
		event.getRegistry().registerAll(atJakeSword,atCrystalSword,atNothung,atFinnSword,atSwordoftheDead,atWishStarSword,atFightKingSword,atRootSword,atScarlet,atGrassSword,atDemonBloodSword,atAxeBass);

		//ff
		event.getRegistry().registerAll(ffTheMasamune,ffBusterSword,ffCaladbolg);

		//rotmg
		event.getRegistry().registerAll(rotmgSwordoftheColossus,rotmgCrystalSword,rotmgPixieEnchantedSword,rotmgSwordOfAcclaim,rotmgDemonBlade,rotmgSwordoftheMadGod,rotmgIndomptable,rotmgPirateKingCutlass,rotmgSwordofSplendor,rotmgSkysplitterSword,rotmgArchonSword,rotmgAncientStoneSword,rotmgDragonsoulSword,rotmgRavenheartSword);

		//sc
		event.getRegistry().registerAll(scFirangi,scCocytus,scErlangBlade,scSoulEdgeNightmare,scPhlegathon,scAcheron,scLethe,scQueenGuard,scHolyAntler,scEpee,scWarHammer,scKalutues,scEstoc,scFlambert2P,scReiterpallasch,scFlambert,scBlueCrystalRod,scFireBlade,scXiSword,scOmegaSword2P,scOmegaSword,scOrichalcum,scStiletto,scRequiem,scFaust,scFlamberge,scSteelPaddle,scGlam,scGreatBlade);

		//rs
		event.getRegistry().registerAll(rsBronzeSword,rsIronSword,rsWhiteSword,rsBlackSword,rsSteelSword,rsMithrilSword,rsAdamantSword,rsRuneSword,rsDragonSword,rsBronzeBattleaxe,rsIronBattleaxe,rsSteelBattleaxe,rsBlackBattleaxe,rsWhiteBattleaxe,rsMithrilBattleaxe,rsAdamantBattleaxe,rsRuneBattleaxe,rsDragonBattleaxe,rsBronzeScimitar,rsIronScimitar,rsBlackScimitar,rsWhiteScimitar,rsSteelScimitar,rsMithrilScimitar,rsAdamantScimitar,rsRuneScimitar,rsDragonScimitar,rsBronzeWarhammer,rsIronWarhammer,rsSteelWarhammer,rsBlackWarhammer,rsWhiteWarhammer,rsMithrilWarhammer,rsAdamantWarhammer,rsRuneWarhammer,rsBronzeMace,rsIronMace,rsSteelMace,rsBlackMace,rsWhiteMace,rsMithrilMace,rsAdamantMace,rsRuneMace,rsGraniteLongsword,rsGraniteHammer,rsGraniteMaul,rsElderMaul,rsToktzxilak,rsWolfsbane,rsZamorakGodsword,rsBandosGodsword,rsArmadylGodsword,rsSaradominGodsword,rsBarrelchestAnchor);

		//dmc
		event.getRegistry().registerAll(dmcRedQueen,dmcRebellion,dmcYamato);

		//pkmn
		event.getRegistry().registerAll(pkmnHonedgeShiny,pkmnHonedge);

		//kirby
		event.getRegistry().registerAll(kirbyGalaxia,kirbyKirbyUltraSword,kirbyKirbySword);

		//fe
		event.getRegistry().registerAll(feChromFalchion,feFalchion);

		//kh
		event.getRegistry().registerAll(khKeyblade);

		//bleach
		event.getRegistry().registerAll(bleachZabimaru,bleachZangestsu);

		//ds
		event.getRegistry().registerAll(dsGreatswordofArtorias,dsGreatLordGreatsword,dsAstoraGreatsword,dsZweilhander);

		//myth
		event.getRegistry().registerAll(mythDeathScythe,mythTheDevilPitchfork);

		//bayonetta
		event.getRegistry().registerAll(bayonettaShuraba,bayonettaAngelSlayer);

		//gow
		event.getRegistry().registerAll(gowLeviathanUpgraded,gowLeviathan,gowBladeofOlympus,gowBladeofChaos);

		//skyrim
		event.getRegistry().registerAll(skyrimIronSword,skyrimIronWarhammer,skyrimSteelSword,skyrimSteelWarhammer,skyrimOrcishSword,skyrimOrcishWarhammer,skyrimDwarvenSword,skyrimDwarvenWarhammer,skyrimElvenSword,skyrimElvenWarhammer,skyrimGlassSword,skyrimGlassWarhammer,skyrimEbonySword,skyrimEbonyWarhammer,skyrimDaedricSword,skyrimDaedricWarhammer,skyrimDragonboneSword,skyrimDragonboneWarhammer,skyrimImperialSword,skyrimDawnbreaker,skyrimAncientNordSword,skyrimChillrend,skyrimEbonyBlade);

		//mh
		event.getRegistry().registerAll(mhChickenDecapitator,mhGolemBlade,mhDefender,mhBlackBeltBlade,mhWailingCleaver,mhGaelicFlame,mhBoneKatana,mhHellishSlasher,mhCentenarianDagger,mhWyvernBladeBlood,mhWyvernBladeHolly,mhWyvernBladePale,mhWyvernBladeAzure,mhWyvernBladeLeaf,mhRathalosFlamesword);

		//terraria
		event.getRegistry().registerAll(terrariaPalmWoodSword,terrariaBorealWoodSword,terrariaShadewoodSword,terrariaEbonwoodSword,terrariaCopperShortsword,terrariaCopperBroadsword,terrariaTinShortsword,terrariaTinBroadsword,terrariaLeadShortsword,terrariaLeadBroadsword,terrariaSpear,terrariaIronShortsword,terrariaIronBroadsword,terrariaSilverBroadsword,terrariaSilverShortsword,terrariaGoldShortsword,terrariaGoldBroadsword,terrariaTungstenBroadsword,terrariaTungstenShortsword,terrariaPlatinumShortsword,terrariaPlatinumBroadsword,terrariaMandibleBlade,terrariaKatana,terrariaExoticScimitar,terrariaMuramasa,terrariaFalconBlade,terrariaBladeofGrass,terrariaFieryGreatsword,terrariaBoneSword,terrariaBloodButcherer,terrariaEnchantedSword,terrariaStarfury,terrariaBeeKeeper,terrariaIceBlade,terrariaNightEdge,terrariaArkhalis,terrariaTrident,terrariaTheRottedFork,terrariaWhitePhaseblade,terrariaYellowPhaseblade,terrariaPurplePhaseblade,terrariaGreenPhaseblade,terrariaRedPhaseblade,terrariaBluePhaseblade,terrariaLightBane,terrariaDarkLance,terrariaPurpleClubberfish,terrariaCactusSword,terrariaSwordfish);

		//sw
		event.getRegistry().registerAll(swYellowLightsaber,swGreenLightsaber,swBlueLightsaber,swRedLightsaber,swMaceWinduLightsaber,swTheInquisitorLightsaber,swDarthMaulLightsaber,swQuiGonJinnLightsaber,swKyloRenLightsaber,swCountDookuLightsaber,swDarksaber);

		//internet
		event.getRegistry().registerAll(internetDemonoidPitchfork);

		//nh
		event.getRegistry().registerAll(nhMagicbane,nhAthame,nhGrayswandir,nhSilverSaber);

		//abcm
		event.getRegistry().registerAll(abcmExcalibur);


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
		registerRender(lozSpikedBokoClub);
		registerRender(lozBokoClub);

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
		registerRender(atAxeBass);

		//ff
		registerRender(ffTheMasamune);
		registerRender(ffBusterSword);
		registerRender(ffCaladbolg);

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
		registerRender(scQueenGuard);
		registerRender(scHolyAntler);
		registerRender(scEpee);
		registerRender(scWarHammer);
		registerRender(scKalutues);
		registerRender(scEstoc);
		registerRender(scFlambert2P);
		registerRender(scReiterpallasch);
		registerRender(scFlambert);
		registerRender(scBlueCrystalRod);
		registerRender(scFireBlade);
		registerRender(scXiSword);
		registerRender(scOmegaSword2P);
		registerRender(scOmegaSword);
		registerRender(scOrichalcum);
		registerRender(scStiletto);
		registerRender(scRequiem);
		registerRender(scFaust);
		registerRender(scFlamberge);
		registerRender(scSteelPaddle);
		registerRender(scGlam);
		registerRender(scGreatBlade);

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
		registerRender(rsBarrelchestAnchor);

		//dmc
		registerRender(dmcRedQueen);
		registerRender(dmcRebellion);
		registerRender(dmcYamato);

		//pkmn
		registerRender(pkmnHonedgeShiny);
		registerRender(pkmnHonedge);

		//kirby
		registerRender(kirbyGalaxia);
		registerRender(kirbyKirbyUltraSword);
		registerRender(kirbyKirbySword);

		//fe
		registerRender(feChromFalchion);
		registerRender(feFalchion);

		//kh
		registerRender(khKeyblade);

		//bleach
		registerRender(bleachZabimaru);
		registerRender(bleachZangestsu);

		//ds
		registerRender(dsGreatswordofArtorias);
		registerRender(dsGreatLordGreatsword);
		registerRender(dsAstoraGreatsword);
		registerRender(dsZweilhander);

		//myth
		registerRender(mythDeathScythe);
		registerRender(mythTheDevilPitchfork);

		//bayonetta
		registerRender(bayonettaShuraba);
		registerRender(bayonettaAngelSlayer);

		//gow
		registerRender(gowLeviathanUpgraded);
		registerRender(gowLeviathan);
		registerRender(gowBladeofOlympus);
		registerRender(gowBladeofChaos);

		//skyrim
		registerRender(skyrimIronSword);
		registerRender(skyrimIronWarhammer);
		registerRender(skyrimSteelSword);
		registerRender(skyrimSteelWarhammer);
		registerRender(skyrimOrcishSword);
		registerRender(skyrimOrcishWarhammer);
		registerRender(skyrimDwarvenSword);
		registerRender(skyrimDwarvenWarhammer);
		registerRender(skyrimElvenSword);
		registerRender(skyrimElvenWarhammer);
		registerRender(skyrimGlassSword);
		registerRender(skyrimGlassWarhammer);
		registerRender(skyrimEbonySword);
		registerRender(skyrimEbonyWarhammer);
		registerRender(skyrimDaedricSword);
		registerRender(skyrimDaedricWarhammer);
		registerRender(skyrimDragonboneSword);
		registerRender(skyrimDragonboneWarhammer);
		registerRender(skyrimImperialSword);
		registerRender(skyrimDawnbreaker);
		registerRender(skyrimAncientNordSword);
		registerRender(skyrimChillrend);
		registerRender(skyrimEbonyBlade);

		//mh
		registerRender(mhChickenDecapitator);
		registerRender(mhGolemBlade);
		registerRender(mhDefender);
		registerRender(mhBlackBeltBlade);
		registerRender(mhWailingCleaver);
		registerRender(mhGaelicFlame);
		registerRender(mhBoneKatana);
		registerRender(mhHellishSlasher);
		registerRender(mhCentenarianDagger);
		registerRender(mhWyvernBladeBlood);
		registerRender(mhWyvernBladeHolly);
		registerRender(mhWyvernBladePale);
		registerRender(mhWyvernBladeAzure);
		registerRender(mhWyvernBladeLeaf);
		registerRender(mhRathalosFlamesword);

		//terraria
		registerRender(terrariaPalmWoodSword);
		registerRender(terrariaBorealWoodSword);
		registerRender(terrariaShadewoodSword);
		registerRender(terrariaEbonwoodSword);
		registerRender(terrariaCopperShortsword);
		registerRender(terrariaCopperBroadsword);
		registerRender(terrariaTinShortsword);
		registerRender(terrariaTinBroadsword);
		registerRender(terrariaLeadShortsword);
		registerRender(terrariaLeadBroadsword);
		registerRender(terrariaSpear);
		registerRender(terrariaIronShortsword);
		registerRender(terrariaIronBroadsword);
		registerRender(terrariaSilverBroadsword);
		registerRender(terrariaSilverShortsword);
		registerRender(terrariaGoldShortsword);
		registerRender(terrariaGoldBroadsword);
		registerRender(terrariaTungstenBroadsword);
		registerRender(terrariaTungstenShortsword);
		registerRender(terrariaPlatinumShortsword);
		registerRender(terrariaPlatinumBroadsword);
		registerRender(terrariaMandibleBlade);
		registerRender(terrariaKatana);
		registerRender(terrariaExoticScimitar);
		registerRender(terrariaMuramasa);
		registerRender(terrariaFalconBlade);
		registerRender(terrariaBladeofGrass);
		registerRender(terrariaFieryGreatsword);
		registerRender(terrariaBoneSword);
		registerRender(terrariaBloodButcherer);
		registerRender(terrariaEnchantedSword);
		registerRender(terrariaStarfury);
		registerRender(terrariaBeeKeeper);
		registerRender(terrariaIceBlade);
		registerRender(terrariaNightEdge);
		registerRender(terrariaArkhalis);
		registerRender(terrariaTrident);
		registerRender(terrariaTheRottedFork);
		registerRender(terrariaWhitePhaseblade);
		registerRender(terrariaYellowPhaseblade);
		registerRender(terrariaPurplePhaseblade);
		registerRender(terrariaGreenPhaseblade);
		registerRender(terrariaRedPhaseblade);
		registerRender(terrariaBluePhaseblade);
		registerRender(terrariaLightBane);
		registerRender(terrariaDarkLance);
		registerRender(terrariaPurpleClubberfish);
		registerRender(terrariaCactusSword);
		registerRender(terrariaSwordfish);

		//sw
		registerRender(swYellowLightsaber);
		registerRender(swGreenLightsaber);
		registerRender(swBlueLightsaber);
		registerRender(swRedLightsaber);
		registerRender(swMaceWinduLightsaber);
		registerRender(swTheInquisitorLightsaber);
		registerRender(swDarthMaulLightsaber);
		registerRender(swQuiGonJinnLightsaber);
		registerRender(swKyloRenLightsaber);
		registerRender(swCountDookuLightsaber);
		registerRender(swDarksaber);

		//internet
		registerRender(internetDemonoidPitchfork);

		//nh
		registerRender(nhMagicbane);
		registerRender(nhAthame);
		registerRender(nhGrayswandir);
		registerRender(nhSilverSaber);

		//abcm
		registerRender(abcmExcalibur);


	}
	
	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	//loot tables
	@SubscribeEvent
	public static void lootLoad(LootTableLoadEvent evt) {
		String name = evt.getName().toString();



		if (name.contains("chest")) {

            //return if not a minecraft chest
            if (ModConfig.includeModChests == false && name.contains("minecraft:") == false) {
                System.out.println("skipping loot table '" + name + "' because mod chests are disabled in config");
                return;
            }

            System.out.println("added loot to loot table '" + name + "'");

            ArrayList<LootEntryItem> entries = new ArrayList<LootEntryItem>();

            
			//lotr
			if (ModConfig.enabledItems.lotrenabled.lotrGimliBattleAxe && ModConfig.disableSeries.lotr) entries.add(new LootEntryItem(lotrGimliBattleAxe, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lotrGimliBattleAxe"));
			if (ModConfig.enabledItems.lotrenabled.lotrGimliLongAxe && ModConfig.disableSeries.lotr) entries.add(new LootEntryItem(lotrGimliLongAxe, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lotrGimliLongAxe"));
			if (ModConfig.enabledItems.lotrenabled.lotrMorgulBlade && ModConfig.disableSeries.lotr) entries.add(new LootEntryItem(lotrMorgulBlade, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lotrMorgulBlade"));
			if (ModConfig.enabledItems.lotrenabled.lotrSting && ModConfig.disableSeries.lotr) entries.add(new LootEntryItem(lotrSting, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lotrSting"));
			if (ModConfig.enabledItems.lotrenabled.lotrGlamdring && ModConfig.disableSeries.lotr) entries.add(new LootEntryItem(lotrGlamdring, (int) ceil(Math.pow(7, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lotrGlamdring"));
			if (ModConfig.enabledItems.lotrenabled.lotrAnduril && ModConfig.disableSeries.lotr) entries.add(new LootEntryItem(lotrAnduril, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lotrAnduril"));
			if (ModConfig.enabledItems.lotrenabled.lotrNarsil && ModConfig.disableSeries.lotr) entries.add(new LootEntryItem(lotrNarsil, (int) ceil(Math.pow(7, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lotrNarsil"));
			if (ModConfig.enabledItems.lotrenabled.lotrSauronMace && ModConfig.disableSeries.lotr) entries.add(new LootEntryItem(lotrSauronMace, (int) ceil(Math.pow(1, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lotrSauronMace"));
			if (ModConfig.enabledItems.lotrenabled.lotrWitchKingSword && ModConfig.disableSeries.lotr) entries.add(new LootEntryItem(lotrWitchKingSword, (int) ceil(Math.pow(6, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lotrWitchKingSword"));

			//loz
			if (ModConfig.enabledItems.lozenabled.lozMasterSword && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozMasterSword, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozMasterSword"));
			if (ModConfig.enabledItems.lozenabled.lozMasterSwordII && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozMasterSwordII, (int) ceil(Math.pow(6, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozMasterSwordII"));
			if (ModConfig.enabledItems.lozenabled.lozTemperedSword && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozTemperedSword, (int) ceil(Math.pow(6, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozTemperedSword"));
			if (ModConfig.enabledItems.lozenabled.lozMasterSwordIII && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozMasterSwordIII, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozMasterSwordIII"));
			if (ModConfig.enabledItems.lozenabled.lozGoldenSword && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozGoldenSword, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozGoldenSword"));
			if (ModConfig.enabledItems.lozenabled.lozFlameblade && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozFlameblade, (int) ceil(Math.pow(14, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozFlameblade"));
			if (ModConfig.enabledItems.lozenabled.lozDarknutSwordTp && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozDarknutSwordTp, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozDarknutSwordTp"));
			if (ModConfig.enabledItems.lozenabled.lozGhirahimSword && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozGhirahimSword, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozGhirahimSword"));
			if (ModConfig.enabledItems.lozenabled.lozFierceDietySword && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozFierceDietySword, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozFierceDietySword"));
			if (ModConfig.enabledItems.lozenabled.lozZeldaSword && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozZeldaSword, (int) ceil(Math.pow(15, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozZeldaSword"));
			if (ModConfig.enabledItems.lozenabled.lozBokoStick && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozBokoStick, (int) ceil(Math.pow(15, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozBokoStick"));
			if (ModConfig.enabledItems.lozenabled.lozCaneofByrna && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozCaneofByrna, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozCaneofByrna"));
			if (ModConfig.enabledItems.lozenabled.lozMegatonHammer && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozMegatonHammer, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozMegatonHammer"));
			if (ModConfig.enabledItems.lozenabled.lozKokiriSwordMm && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozKokiriSwordMm, (int) ceil(Math.pow(16, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozKokiriSwordMm"));
			if (ModConfig.enabledItems.lozenabled.lozKokiriSwordOoT && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozKokiriSwordOoT, (int) ceil(Math.pow(16, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozKokiriSwordOoT"));
			if (ModConfig.enabledItems.lozenabled.lozDemiseSword && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozDemiseSword, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozDemiseSword"));
			if (ModConfig.enabledItems.lozenabled.lozGiantKnife && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozGiantKnife, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozGiantKnife"));
			if (ModConfig.enabledItems.lozenabled.lozBiggoronSword && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozBiggoronSword, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozBiggoronSword"));
			if (ModConfig.enabledItems.lozenabled.lozPhantomGanonSword && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozPhantomGanonSword, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozPhantomGanonSword"));
			if (ModConfig.enabledItems.lozenabled.lozUltimateSword && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozUltimateSword, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozUltimateSword"));
			if (ModConfig.enabledItems.lozenabled.lozRoyalGuardSword && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozRoyalGuardSword, (int) ceil(Math.pow(15, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozRoyalGuardSword"));
			if (ModConfig.enabledItems.lozenabled.lozMagicSwordConcept && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozMagicSwordConcept, (int) ceil(Math.pow(7, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozMagicSwordConcept"));
			if (ModConfig.enabledItems.lozenabled.lozMagicSword && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozMagicSword, (int) ceil(Math.pow(7, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozMagicSword"));
			if (ModConfig.enabledItems.lozenabled.lozWhiteSword && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozWhiteSword, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozWhiteSword"));
			if (ModConfig.enabledItems.lozenabled.lozWhiteSwordConcept && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozWhiteSwordConcept, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozWhiteSwordConcept"));
			if (ModConfig.enabledItems.lozenabled.lozPicoriBlade && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozPicoriBlade, (int) ceil(Math.pow(14, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozPicoriBlade"));
			if (ModConfig.enabledItems.lozenabled.lozRazorSword && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozRazorSword, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozRazorSword"));
			if (ModConfig.enabledItems.lozenabled.lozGreatFairySword && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozGreatFairySword, (int) ceil(Math.pow(7, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozGreatFairySword"));
			if (ModConfig.enabledItems.lozenabled.lozGoddessWhiteSword && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozGoddessWhiteSword, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozGoddessWhiteSword"));
			if (ModConfig.enabledItems.lozenabled.lozGoddessSword && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozGoddessSword, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozGoddessSword"));
			if (ModConfig.enabledItems.lozenabled.lozGildedSword && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozGildedSword, (int) ceil(Math.pow(6, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozGildedSword"));
			if (ModConfig.enabledItems.lozenabled.lozSpikedBokoClub && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozSpikedBokoClub, (int) ceil(Math.pow(15, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozSpikedBokoClub"));
			if (ModConfig.enabledItems.lozenabled.lozBokoClub && ModConfig.disableSeries.loz) entries.add(new LootEntryItem(lozBokoClub, (int) ceil(Math.pow(18, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:lozBokoClub"));

			//at
			if (ModConfig.enabledItems.atenabled.atJakeSword && ModConfig.disableSeries.at) entries.add(new LootEntryItem(atJakeSword, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:atJakeSword"));
			if (ModConfig.enabledItems.atenabled.atCrystalSword && ModConfig.disableSeries.at) entries.add(new LootEntryItem(atCrystalSword, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:atCrystalSword"));
			if (ModConfig.enabledItems.atenabled.atNothung && ModConfig.disableSeries.at) entries.add(new LootEntryItem(atNothung, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:atNothung"));
			if (ModConfig.enabledItems.atenabled.atFinnSword && ModConfig.disableSeries.at) entries.add(new LootEntryItem(atFinnSword, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:atFinnSword"));
			if (ModConfig.enabledItems.atenabled.atSwordoftheDead && ModConfig.disableSeries.at) entries.add(new LootEntryItem(atSwordoftheDead, (int) ceil(Math.pow(11, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:atSwordoftheDead"));
			if (ModConfig.enabledItems.atenabled.atWishStarSword && ModConfig.disableSeries.at) entries.add(new LootEntryItem(atWishStarSword, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:atWishStarSword"));
			if (ModConfig.enabledItems.atenabled.atFightKingSword && ModConfig.disableSeries.at) entries.add(new LootEntryItem(atFightKingSword, (int) ceil(Math.pow(6, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:atFightKingSword"));
			if (ModConfig.enabledItems.atenabled.atRootSword && ModConfig.disableSeries.at) entries.add(new LootEntryItem(atRootSword, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:atRootSword"));
			if (ModConfig.enabledItems.atenabled.atScarlet && ModConfig.disableSeries.at) entries.add(new LootEntryItem(atScarlet, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:atScarlet"));
			if (ModConfig.enabledItems.atenabled.atGrassSword && ModConfig.disableSeries.at) entries.add(new LootEntryItem(atGrassSword, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:atGrassSword"));
			if (ModConfig.enabledItems.atenabled.atDemonBloodSword && ModConfig.disableSeries.at) entries.add(new LootEntryItem(atDemonBloodSword, (int) ceil(Math.pow(7, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:atDemonBloodSword"));
			if (ModConfig.enabledItems.atenabled.atAxeBass && ModConfig.disableSeries.at) entries.add(new LootEntryItem(atAxeBass, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:atAxeBass"));

			//ff
			if (ModConfig.enabledItems.ffenabled.ffTheMasamune && ModConfig.disableSeries.ff) entries.add(new LootEntryItem(ffTheMasamune, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:ffTheMasamune"));
			if (ModConfig.enabledItems.ffenabled.ffBusterSword && ModConfig.disableSeries.ff) entries.add(new LootEntryItem(ffBusterSword, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:ffBusterSword"));
			if (ModConfig.enabledItems.ffenabled.ffCaladbolg && ModConfig.disableSeries.ff) entries.add(new LootEntryItem(ffCaladbolg, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:ffCaladbolg"));

			//rotmg
			if (ModConfig.enabledItems.rotmgenabled.rotmgSwordoftheColossus && ModConfig.disableSeries.rotmg) entries.add(new LootEntryItem(rotmgSwordoftheColossus, (int) ceil(Math.pow(6, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rotmgSwordoftheColossus"));
			if (ModConfig.enabledItems.rotmgenabled.rotmgCrystalSword && ModConfig.disableSeries.rotmg) entries.add(new LootEntryItem(rotmgCrystalSword, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rotmgCrystalSword"));
			if (ModConfig.enabledItems.rotmgenabled.rotmgPixieEnchantedSword && ModConfig.disableSeries.rotmg) entries.add(new LootEntryItem(rotmgPixieEnchantedSword, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rotmgPixieEnchantedSword"));
			if (ModConfig.enabledItems.rotmgenabled.rotmgSwordOfAcclaim && ModConfig.disableSeries.rotmg) entries.add(new LootEntryItem(rotmgSwordOfAcclaim, (int) ceil(Math.pow(11, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rotmgSwordOfAcclaim"));
			if (ModConfig.enabledItems.rotmgenabled.rotmgDemonBlade && ModConfig.disableSeries.rotmg) entries.add(new LootEntryItem(rotmgDemonBlade, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rotmgDemonBlade"));
			if (ModConfig.enabledItems.rotmgenabled.rotmgSwordoftheMadGod && ModConfig.disableSeries.rotmg) entries.add(new LootEntryItem(rotmgSwordoftheMadGod, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rotmgSwordoftheMadGod"));
			if (ModConfig.enabledItems.rotmgenabled.rotmgIndomptable && ModConfig.disableSeries.rotmg) entries.add(new LootEntryItem(rotmgIndomptable, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rotmgIndomptable"));
			if (ModConfig.enabledItems.rotmgenabled.rotmgPirateKingCutlass && ModConfig.disableSeries.rotmg) entries.add(new LootEntryItem(rotmgPirateKingCutlass, (int) ceil(Math.pow(13, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rotmgPirateKingCutlass"));
			if (ModConfig.enabledItems.rotmgenabled.rotmgSwordofSplendor && ModConfig.disableSeries.rotmg) entries.add(new LootEntryItem(rotmgSwordofSplendor, (int) ceil(Math.pow(9, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rotmgSwordofSplendor"));
			if (ModConfig.enabledItems.rotmgenabled.rotmgSkysplitterSword && ModConfig.disableSeries.rotmg) entries.add(new LootEntryItem(rotmgSkysplitterSword, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rotmgSkysplitterSword"));
			if (ModConfig.enabledItems.rotmgenabled.rotmgArchonSword && ModConfig.disableSeries.rotmg) entries.add(new LootEntryItem(rotmgArchonSword, (int) ceil(Math.pow(14, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rotmgArchonSword"));
			if (ModConfig.enabledItems.rotmgenabled.rotmgAncientStoneSword && ModConfig.disableSeries.rotmg) entries.add(new LootEntryItem(rotmgAncientStoneSword, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rotmgAncientStoneSword"));
			if (ModConfig.enabledItems.rotmgenabled.rotmgDragonsoulSword && ModConfig.disableSeries.rotmg) entries.add(new LootEntryItem(rotmgDragonsoulSword, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rotmgDragonsoulSword"));
			if (ModConfig.enabledItems.rotmgenabled.rotmgRavenheartSword && ModConfig.disableSeries.rotmg) entries.add(new LootEntryItem(rotmgRavenheartSword, (int) ceil(Math.pow(17, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rotmgRavenheartSword"));

			//sc
			if (ModConfig.enabledItems.scenabled.scFirangi && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scFirangi, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scFirangi"));
			if (ModConfig.enabledItems.scenabled.scCocytus && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scCocytus, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scCocytus"));
			if (ModConfig.enabledItems.scenabled.scErlangBlade && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scErlangBlade, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scErlangBlade"));
			if (ModConfig.enabledItems.scenabled.scSoulEdgeNightmare && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scSoulEdgeNightmare, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scSoulEdgeNightmare"));
			if (ModConfig.enabledItems.scenabled.scPhlegathon && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scPhlegathon, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scPhlegathon"));
			if (ModConfig.enabledItems.scenabled.scAcheron && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scAcheron, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scAcheron"));
			if (ModConfig.enabledItems.scenabled.scLethe && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scLethe, (int) ceil(Math.pow(9, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scLethe"));
			if (ModConfig.enabledItems.scenabled.scQueenGuard && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scQueenGuard, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scQueenGuard"));
			if (ModConfig.enabledItems.scenabled.scHolyAntler && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scHolyAntler, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scHolyAntler"));
			if (ModConfig.enabledItems.scenabled.scEpee && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scEpee, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scEpee"));
			if (ModConfig.enabledItems.scenabled.scWarHammer && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scWarHammer, (int) ceil(Math.pow(9, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scWarHammer"));
			if (ModConfig.enabledItems.scenabled.scKalutues && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scKalutues, (int) ceil(Math.pow(9, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scKalutues"));
			if (ModConfig.enabledItems.scenabled.scEstoc && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scEstoc, (int) ceil(Math.pow(13, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scEstoc"));
			if (ModConfig.enabledItems.scenabled.scFlambert2P && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scFlambert2P, (int) ceil(Math.pow(13, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scFlambert2P"));
			if (ModConfig.enabledItems.scenabled.scReiterpallasch && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scReiterpallasch, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scReiterpallasch"));
			if (ModConfig.enabledItems.scenabled.scFlambert && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scFlambert, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scFlambert"));
			if (ModConfig.enabledItems.scenabled.scBlueCrystalRod && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scBlueCrystalRod, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scBlueCrystalRod"));
			if (ModConfig.enabledItems.scenabled.scFireBlade && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scFireBlade, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scFireBlade"));
			if (ModConfig.enabledItems.scenabled.scXiSword && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scXiSword, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scXiSword"));
			if (ModConfig.enabledItems.scenabled.scOmegaSword2P && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scOmegaSword2P, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scOmegaSword2P"));
			if (ModConfig.enabledItems.scenabled.scOmegaSword && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scOmegaSword, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scOmegaSword"));
			if (ModConfig.enabledItems.scenabled.scOrichalcum && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scOrichalcum, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scOrichalcum"));
			if (ModConfig.enabledItems.scenabled.scStiletto && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scStiletto, (int) ceil(Math.pow(9, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scStiletto"));
			if (ModConfig.enabledItems.scenabled.scRequiem && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scRequiem, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scRequiem"));
			if (ModConfig.enabledItems.scenabled.scFaust && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scFaust, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scFaust"));
			if (ModConfig.enabledItems.scenabled.scFlamberge && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scFlamberge, (int) ceil(Math.pow(7, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scFlamberge"));
			if (ModConfig.enabledItems.scenabled.scSteelPaddle && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scSteelPaddle, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scSteelPaddle"));
			if (ModConfig.enabledItems.scenabled.scGlam && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scGlam, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scGlam"));
			if (ModConfig.enabledItems.scenabled.scGreatBlade && ModConfig.disableSeries.sc) entries.add(new LootEntryItem(scGreatBlade, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:scGreatBlade"));

			//rs
			if (ModConfig.enabledItems.rsenabled.rsBronzeSword && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsBronzeSword, (int) ceil(Math.pow(20, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsBronzeSword"));
			if (ModConfig.enabledItems.rsenabled.rsIronSword && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsIronSword, (int) ceil(Math.pow(16, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsIronSword"));
			if (ModConfig.enabledItems.rsenabled.rsWhiteSword && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsWhiteSword, (int) ceil(Math.pow(13, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsWhiteSword"));
			if (ModConfig.enabledItems.rsenabled.rsBlackSword && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsBlackSword, (int) ceil(Math.pow(13, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsBlackSword"));
			if (ModConfig.enabledItems.rsenabled.rsSteelSword && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsSteelSword, (int) ceil(Math.pow(15, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsSteelSword"));
			if (ModConfig.enabledItems.rsenabled.rsMithrilSword && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) entries.add(new LootEntryItem(rsMithrilSword, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsMithrilSword"));
			if (ModConfig.enabledItems.rsenabled.rsAdamantSword && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) entries.add(new LootEntryItem(rsAdamantSword, (int) ceil(Math.pow(6, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsAdamantSword"));
			if (ModConfig.enabledItems.rsenabled.rsRuneSword && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) entries.add(new LootEntryItem(rsRuneSword, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsRuneSword"));
			if (ModConfig.enabledItems.rsenabled.rsDragonSword && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) entries.add(new LootEntryItem(rsDragonSword, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsDragonSword"));
			if (ModConfig.enabledItems.rsenabled.rsBronzeBattleaxe && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsBronzeBattleaxe, (int) ceil(Math.pow(20, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsBronzeBattleaxe"));
			if (ModConfig.enabledItems.rsenabled.rsIronBattleaxe && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsIronBattleaxe, (int) ceil(Math.pow(16, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsIronBattleaxe"));
			if (ModConfig.enabledItems.rsenabled.rsSteelBattleaxe && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsSteelBattleaxe, (int) ceil(Math.pow(13, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsSteelBattleaxe"));
			if (ModConfig.enabledItems.rsenabled.rsBlackBattleaxe && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsBlackBattleaxe, (int) ceil(Math.pow(13, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsBlackBattleaxe"));
			if (ModConfig.enabledItems.rsenabled.rsWhiteBattleaxe && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsWhiteBattleaxe, (int) ceil(Math.pow(15, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsWhiteBattleaxe"));
			if (ModConfig.enabledItems.rsenabled.rsMithrilBattleaxe && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) entries.add(new LootEntryItem(rsMithrilBattleaxe, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsMithrilBattleaxe"));
			if (ModConfig.enabledItems.rsenabled.rsAdamantBattleaxe && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) entries.add(new LootEntryItem(rsAdamantBattleaxe, (int) ceil(Math.pow(6, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsAdamantBattleaxe"));
			if (ModConfig.enabledItems.rsenabled.rsRuneBattleaxe && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) entries.add(new LootEntryItem(rsRuneBattleaxe, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsRuneBattleaxe"));
			if (ModConfig.enabledItems.rsenabled.rsDragonBattleaxe && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) entries.add(new LootEntryItem(rsDragonBattleaxe, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsDragonBattleaxe"));
			if (ModConfig.enabledItems.rsenabled.rsBronzeScimitar && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsBronzeScimitar, (int) ceil(Math.pow(20, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsBronzeScimitar"));
			if (ModConfig.enabledItems.rsenabled.rsIronScimitar && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsIronScimitar, (int) ceil(Math.pow(16, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsIronScimitar"));
			if (ModConfig.enabledItems.rsenabled.rsBlackScimitar && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsBlackScimitar, (int) ceil(Math.pow(13, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsBlackScimitar"));
			if (ModConfig.enabledItems.rsenabled.rsWhiteScimitar && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsWhiteScimitar, (int) ceil(Math.pow(13, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsWhiteScimitar"));
			if (ModConfig.enabledItems.rsenabled.rsSteelScimitar && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsSteelScimitar, (int) ceil(Math.pow(15, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsSteelScimitar"));
			if (ModConfig.enabledItems.rsenabled.rsMithrilScimitar && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) entries.add(new LootEntryItem(rsMithrilScimitar, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsMithrilScimitar"));
			if (ModConfig.enabledItems.rsenabled.rsAdamantScimitar && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) entries.add(new LootEntryItem(rsAdamantScimitar, (int) ceil(Math.pow(6, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsAdamantScimitar"));
			if (ModConfig.enabledItems.rsenabled.rsRuneScimitar && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) entries.add(new LootEntryItem(rsRuneScimitar, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsRuneScimitar"));
			if (ModConfig.enabledItems.rsenabled.rsDragonScimitar && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) entries.add(new LootEntryItem(rsDragonScimitar, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsDragonScimitar"));
			if (ModConfig.enabledItems.rsenabled.rsBronzeWarhammer && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsBronzeWarhammer, (int) ceil(Math.pow(20, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsBronzeWarhammer"));
			if (ModConfig.enabledItems.rsenabled.rsIronWarhammer && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsIronWarhammer, (int) ceil(Math.pow(16, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsIronWarhammer"));
			if (ModConfig.enabledItems.rsenabled.rsSteelWarhammer && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsSteelWarhammer, (int) ceil(Math.pow(13, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsSteelWarhammer"));
			if (ModConfig.enabledItems.rsenabled.rsBlackWarhammer && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsBlackWarhammer, (int) ceil(Math.pow(13, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsBlackWarhammer"));
			if (ModConfig.enabledItems.rsenabled.rsWhiteWarhammer && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsWhiteWarhammer, (int) ceil(Math.pow(15, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsWhiteWarhammer"));
			if (ModConfig.enabledItems.rsenabled.rsMithrilWarhammer && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) entries.add(new LootEntryItem(rsMithrilWarhammer, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsMithrilWarhammer"));
			if (ModConfig.enabledItems.rsenabled.rsAdamantWarhammer && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) entries.add(new LootEntryItem(rsAdamantWarhammer, (int) ceil(Math.pow(6, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsAdamantWarhammer"));
			if (ModConfig.enabledItems.rsenabled.rsRuneWarhammer && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) entries.add(new LootEntryItem(rsRuneWarhammer, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsRuneWarhammer"));
			if (ModConfig.enabledItems.rsenabled.rsBronzeMace && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) entries.add(new LootEntryItem(rsBronzeMace, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsBronzeMace"));
			if (ModConfig.enabledItems.rsenabled.rsIronMace && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsIronMace, (int) ceil(Math.pow(16, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsIronMace"));
			if (ModConfig.enabledItems.rsenabled.rsSteelMace && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsSteelMace, (int) ceil(Math.pow(13, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsSteelMace"));
			if (ModConfig.enabledItems.rsenabled.rsBlackMace && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsBlackMace, (int) ceil(Math.pow(13, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsBlackMace"));
			if (ModConfig.enabledItems.rsenabled.rsWhiteMace && ModConfig.disableSeries.rs && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(rsWhiteMace, (int) ceil(Math.pow(15, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsWhiteMace"));
			if (ModConfig.enabledItems.rsenabled.rsMithrilMace && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) entries.add(new LootEntryItem(rsMithrilMace, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsMithrilMace"));
			if (ModConfig.enabledItems.rsenabled.rsAdamantMace && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) entries.add(new LootEntryItem(rsAdamantMace, (int) ceil(Math.pow(6, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsAdamantMace"));
			if (ModConfig.enabledItems.rsenabled.rsRuneMace && ModConfig.disableSeries.rs && ModConfig.disableSets.generic) entries.add(new LootEntryItem(rsRuneMace, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsRuneMace"));
			if (ModConfig.enabledItems.rsenabled.rsGraniteLongsword && ModConfig.disableSeries.rs) entries.add(new LootEntryItem(rsGraniteLongsword, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsGraniteLongsword"));
			if (ModConfig.enabledItems.rsenabled.rsGraniteHammer && ModConfig.disableSeries.rs) entries.add(new LootEntryItem(rsGraniteHammer, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsGraniteHammer"));
			if (ModConfig.enabledItems.rsenabled.rsGraniteMaul && ModConfig.disableSeries.rs) entries.add(new LootEntryItem(rsGraniteMaul, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsGraniteMaul"));
			if (ModConfig.enabledItems.rsenabled.rsElderMaul && ModConfig.disableSeries.rs) entries.add(new LootEntryItem(rsElderMaul, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsElderMaul"));
			if (ModConfig.enabledItems.rsenabled.rsToktzxilak && ModConfig.disableSeries.rs) entries.add(new LootEntryItem(rsToktzxilak, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsToktzxilak"));
			if (ModConfig.enabledItems.rsenabled.rsWolfsbane && ModConfig.disableSeries.rs) entries.add(new LootEntryItem(rsWolfsbane, (int) ceil(Math.pow(16, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsWolfsbane"));
			if (ModConfig.enabledItems.rsenabled.rsZamorakGodsword && ModConfig.disableSeries.rs) entries.add(new LootEntryItem(rsZamorakGodsword, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsZamorakGodsword"));
			if (ModConfig.enabledItems.rsenabled.rsBandosGodsword && ModConfig.disableSeries.rs) entries.add(new LootEntryItem(rsBandosGodsword, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsBandosGodsword"));
			if (ModConfig.enabledItems.rsenabled.rsArmadylGodsword && ModConfig.disableSeries.rs) entries.add(new LootEntryItem(rsArmadylGodsword, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsArmadylGodsword"));
			if (ModConfig.enabledItems.rsenabled.rsSaradominGodsword && ModConfig.disableSeries.rs) entries.add(new LootEntryItem(rsSaradominGodsword, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsSaradominGodsword"));
			if (ModConfig.enabledItems.rsenabled.rsBarrelchestAnchor && ModConfig.disableSeries.rs) entries.add(new LootEntryItem(rsBarrelchestAnchor, (int) ceil(Math.pow(9, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:rsBarrelchestAnchor"));

			//dmc
			if (ModConfig.enabledItems.dmcenabled.dmcRedQueen && ModConfig.disableSeries.dmc) entries.add(new LootEntryItem(dmcRedQueen, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:dmcRedQueen"));
			if (ModConfig.enabledItems.dmcenabled.dmcRebellion && ModConfig.disableSeries.dmc) entries.add(new LootEntryItem(dmcRebellion, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:dmcRebellion"));
			if (ModConfig.enabledItems.dmcenabled.dmcYamato && ModConfig.disableSeries.dmc) entries.add(new LootEntryItem(dmcYamato, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:dmcYamato"));

			//pkmn
			if (ModConfig.enabledItems.pkmnenabled.pkmnHonedgeShiny && ModConfig.disableSeries.pkmn) entries.add(new LootEntryItem(pkmnHonedgeShiny, (int) ceil(Math.pow(1, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:pkmnHonedgeShiny"));
			if (ModConfig.enabledItems.pkmnenabled.pkmnHonedge && ModConfig.disableSeries.pkmn) entries.add(new LootEntryItem(pkmnHonedge, (int) ceil(Math.pow(11, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:pkmnHonedge"));

			//kirby
			if (ModConfig.enabledItems.kirbyenabled.kirbyGalaxia && ModConfig.disableSeries.kirby) entries.add(new LootEntryItem(kirbyGalaxia, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:kirbyGalaxia"));
			if (ModConfig.enabledItems.kirbyenabled.kirbyKirbyUltraSword && ModConfig.disableSeries.kirby) entries.add(new LootEntryItem(kirbyKirbyUltraSword, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:kirbyKirbyUltraSword"));
			if (ModConfig.enabledItems.kirbyenabled.kirbyKirbySword && ModConfig.disableSeries.kirby) entries.add(new LootEntryItem(kirbyKirbySword, (int) ceil(Math.pow(13, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:kirbyKirbySword"));

			//fe
			if (ModConfig.enabledItems.feenabled.feChromFalchion && ModConfig.disableSeries.fe) entries.add(new LootEntryItem(feChromFalchion, (int) ceil(Math.pow(9, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:feChromFalchion"));
			if (ModConfig.enabledItems.feenabled.feFalchion && ModConfig.disableSeries.fe) entries.add(new LootEntryItem(feFalchion, (int) ceil(Math.pow(9, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:feFalchion"));

			//kh
			if (ModConfig.enabledItems.khenabled.khKeyblade && ModConfig.disableSeries.kh) entries.add(new LootEntryItem(khKeyblade, (int) ceil(Math.pow(9, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:khKeyblade"));

			//bleach
			if (ModConfig.enabledItems.bleachenabled.bleachZabimaru && ModConfig.disableSeries.bleach) entries.add(new LootEntryItem(bleachZabimaru, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:bleachZabimaru"));
			if (ModConfig.enabledItems.bleachenabled.bleachZangestsu && ModConfig.disableSeries.bleach) entries.add(new LootEntryItem(bleachZangestsu, (int) ceil(Math.pow(9, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:bleachZangestsu"));

			//ds
			if (ModConfig.enabledItems.dsenabled.dsGreatswordofArtorias && ModConfig.disableSeries.ds) entries.add(new LootEntryItem(dsGreatswordofArtorias, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:dsGreatswordofArtorias"));
			if (ModConfig.enabledItems.dsenabled.dsGreatLordGreatsword && ModConfig.disableSeries.ds) entries.add(new LootEntryItem(dsGreatLordGreatsword, (int) ceil(Math.pow(6, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:dsGreatLordGreatsword"));
			if (ModConfig.enabledItems.dsenabled.dsAstoraGreatsword && ModConfig.disableSeries.ds) entries.add(new LootEntryItem(dsAstoraGreatsword, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:dsAstoraGreatsword"));
			if (ModConfig.enabledItems.dsenabled.dsZweilhander && ModConfig.disableSeries.ds) entries.add(new LootEntryItem(dsZweilhander, (int) ceil(Math.pow(6, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:dsZweilhander"));

			//myth
			if (ModConfig.enabledItems.mythenabled.mythDeathScythe && ModConfig.disableSeries.myth) entries.add(new LootEntryItem(mythDeathScythe, (int) ceil(Math.pow(1, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:mythDeathScythe"));
			if (ModConfig.enabledItems.mythenabled.mythTheDevilPitchfork && ModConfig.disableSeries.myth) entries.add(new LootEntryItem(mythTheDevilPitchfork, (int) ceil(Math.pow(1, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:mythTheDevilPitchfork"));

			//bayonetta
			if (ModConfig.enabledItems.bayonettaenabled.bayonettaShuraba && ModConfig.disableSeries.bayonetta) entries.add(new LootEntryItem(bayonettaShuraba, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:bayonettaShuraba"));
			if (ModConfig.enabledItems.bayonettaenabled.bayonettaAngelSlayer && ModConfig.disableSeries.bayonetta) entries.add(new LootEntryItem(bayonettaAngelSlayer, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:bayonettaAngelSlayer"));

			//gow
			if (ModConfig.enabledItems.gowenabled.gowLeviathanUpgraded && ModConfig.disableSeries.gow) entries.add(new LootEntryItem(gowLeviathanUpgraded, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:gowLeviathanUpgraded"));
			if (ModConfig.enabledItems.gowenabled.gowLeviathan && ModConfig.disableSeries.gow) entries.add(new LootEntryItem(gowLeviathan, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:gowLeviathan"));
			if (ModConfig.enabledItems.gowenabled.gowBladeofOlympus && ModConfig.disableSeries.gow) entries.add(new LootEntryItem(gowBladeofOlympus, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:gowBladeofOlympus"));
			if (ModConfig.enabledItems.gowenabled.gowBladeofChaos && ModConfig.disableSeries.gow) entries.add(new LootEntryItem(gowBladeofChaos, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:gowBladeofChaos"));

			//skyrim
			if (ModConfig.enabledItems.skyrimenabled.skyrimIronSword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(skyrimIronSword, (int) ceil(Math.pow(16, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimIronSword"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimIronWarhammer && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(skyrimIronWarhammer, (int) ceil(Math.pow(15, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimIronWarhammer"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimSteelSword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(skyrimSteelSword, (int) ceil(Math.pow(14, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimSteelSword"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimSteelWarhammer && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(skyrimSteelWarhammer, (int) ceil(Math.pow(13, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimSteelWarhammer"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimOrcishSword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) entries.add(new LootEntryItem(skyrimOrcishSword, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimOrcishSword"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimOrcishWarhammer && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) entries.add(new LootEntryItem(skyrimOrcishWarhammer, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimOrcishWarhammer"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimDwarvenSword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) entries.add(new LootEntryItem(skyrimDwarvenSword, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimDwarvenSword"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimDwarvenWarhammer && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) entries.add(new LootEntryItem(skyrimDwarvenWarhammer, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimDwarvenWarhammer"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimElvenSword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) entries.add(new LootEntryItem(skyrimElvenSword, (int) ceil(Math.pow(6, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimElvenSword"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimElvenWarhammer && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) entries.add(new LootEntryItem(skyrimElvenWarhammer, (int) ceil(Math.pow(6, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimElvenWarhammer"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimGlassSword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) entries.add(new LootEntryItem(skyrimGlassSword, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimGlassSword"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimGlassWarhammer && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) entries.add(new LootEntryItem(skyrimGlassWarhammer, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimGlassWarhammer"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimEbonySword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) entries.add(new LootEntryItem(skyrimEbonySword, (int) ceil(Math.pow(3, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimEbonySword"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimEbonyWarhammer && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) entries.add(new LootEntryItem(skyrimEbonyWarhammer, (int) ceil(Math.pow(3, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimEbonyWarhammer"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimDaedricSword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) entries.add(new LootEntryItem(skyrimDaedricSword, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimDaedricSword"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimDaedricWarhammer && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) entries.add(new LootEntryItem(skyrimDaedricWarhammer, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimDaedricWarhammer"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimDragonboneSword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) entries.add(new LootEntryItem(skyrimDragonboneSword, (int) ceil(Math.pow(1, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimDragonboneSword"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimDragonboneWarhammer && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic) entries.add(new LootEntryItem(skyrimDragonboneWarhammer, (int) ceil(Math.pow(1, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimDragonboneWarhammer"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimImperialSword && ModConfig.disableSeries.skyrim && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(skyrimImperialSword, (int) ceil(Math.pow(15, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimImperialSword"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimDawnbreaker && ModConfig.disableSeries.skyrim) entries.add(new LootEntryItem(skyrimDawnbreaker, (int) ceil(Math.pow(3, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimDawnbreaker"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimAncientNordSword && ModConfig.disableSeries.skyrim) entries.add(new LootEntryItem(skyrimAncientNordSword, (int) ceil(Math.pow(13, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimAncientNordSword"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimChillrend && ModConfig.disableSeries.skyrim) entries.add(new LootEntryItem(skyrimChillrend, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimChillrend"));
			if (ModConfig.enabledItems.skyrimenabled.skyrimEbonyBlade && ModConfig.disableSeries.skyrim) entries.add(new LootEntryItem(skyrimEbonyBlade, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:skyrimEbonyBlade"));

			//mh
			if (ModConfig.enabledItems.mhenabled.mhChickenDecapitator && ModConfig.disableSeries.mh) entries.add(new LootEntryItem(mhChickenDecapitator, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:mhChickenDecapitator"));
			if (ModConfig.enabledItems.mhenabled.mhGolemBlade && ModConfig.disableSeries.mh) entries.add(new LootEntryItem(mhGolemBlade, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:mhGolemBlade"));
			if (ModConfig.enabledItems.mhenabled.mhDefender && ModConfig.disableSeries.mh) entries.add(new LootEntryItem(mhDefender, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:mhDefender"));
			if (ModConfig.enabledItems.mhenabled.mhBlackBeltBlade && ModConfig.disableSeries.mh) entries.add(new LootEntryItem(mhBlackBeltBlade, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:mhBlackBeltBlade"));
			if (ModConfig.enabledItems.mhenabled.mhWailingCleaver && ModConfig.disableSeries.mh) entries.add(new LootEntryItem(mhWailingCleaver, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:mhWailingCleaver"));
			if (ModConfig.enabledItems.mhenabled.mhGaelicFlame && ModConfig.disableSeries.mh) entries.add(new LootEntryItem(mhGaelicFlame, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:mhGaelicFlame"));
			if (ModConfig.enabledItems.mhenabled.mhBoneKatana && ModConfig.disableSeries.mh) entries.add(new LootEntryItem(mhBoneKatana, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:mhBoneKatana"));
			if (ModConfig.enabledItems.mhenabled.mhHellishSlasher && ModConfig.disableSeries.mh) entries.add(new LootEntryItem(mhHellishSlasher, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:mhHellishSlasher"));
			if (ModConfig.enabledItems.mhenabled.mhCentenarianDagger && ModConfig.disableSeries.mh) entries.add(new LootEntryItem(mhCentenarianDagger, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:mhCentenarianDagger"));
			if (ModConfig.enabledItems.mhenabled.mhWyvernBladeBlood && ModConfig.disableSeries.mh) entries.add(new LootEntryItem(mhWyvernBladeBlood, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:mhWyvernBladeBlood"));
			if (ModConfig.enabledItems.mhenabled.mhWyvernBladeHolly && ModConfig.disableSeries.mh) entries.add(new LootEntryItem(mhWyvernBladeHolly, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:mhWyvernBladeHolly"));
			if (ModConfig.enabledItems.mhenabled.mhWyvernBladePale && ModConfig.disableSeries.mh) entries.add(new LootEntryItem(mhWyvernBladePale, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:mhWyvernBladePale"));
			if (ModConfig.enabledItems.mhenabled.mhWyvernBladeAzure && ModConfig.disableSeries.mh) entries.add(new LootEntryItem(mhWyvernBladeAzure, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:mhWyvernBladeAzure"));
			if (ModConfig.enabledItems.mhenabled.mhWyvernBladeLeaf && ModConfig.disableSeries.mh) entries.add(new LootEntryItem(mhWyvernBladeLeaf, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:mhWyvernBladeLeaf"));
			if (ModConfig.enabledItems.mhenabled.mhRathalosFlamesword && ModConfig.disableSeries.mh) entries.add(new LootEntryItem(mhRathalosFlamesword, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:mhRathalosFlamesword"));

			//terraria
			if (ModConfig.enabledItems.terrariaenabled.terrariaPalmWoodSword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(terrariaPalmWoodSword, (int) ceil(Math.pow(20, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaPalmWoodSword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaBorealWoodSword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(terrariaBorealWoodSword, (int) ceil(Math.pow(20, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaBorealWoodSword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaShadewoodSword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(terrariaShadewoodSword, (int) ceil(Math.pow(18, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaShadewoodSword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaEbonwoodSword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(terrariaEbonwoodSword, (int) ceil(Math.pow(18, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaEbonwoodSword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaCopperShortsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(terrariaCopperShortsword, (int) ceil(Math.pow(20, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaCopperShortsword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaCopperBroadsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(terrariaCopperBroadsword, (int) ceil(Math.pow(19, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaCopperBroadsword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaTinShortsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(terrariaTinShortsword, (int) ceil(Math.pow(17, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaTinShortsword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaTinBroadsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(terrariaTinBroadsword, (int) ceil(Math.pow(17, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaTinBroadsword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaLeadShortsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(terrariaLeadShortsword, (int) ceil(Math.pow(17, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaLeadShortsword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaLeadBroadsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(terrariaLeadBroadsword, (int) ceil(Math.pow(17, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaLeadBroadsword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaSpear && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(terrariaSpear, (int) ceil(Math.pow(16, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaSpear"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaIronShortsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(terrariaIronShortsword, (int) ceil(Math.pow(16, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaIronShortsword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaIronBroadsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(terrariaIronBroadsword, (int) ceil(Math.pow(16, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaIronBroadsword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaSilverBroadsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(terrariaSilverBroadsword, (int) ceil(Math.pow(16, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaSilverBroadsword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaSilverShortsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(terrariaSilverShortsword, (int) ceil(Math.pow(16, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaSilverShortsword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaGoldShortsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(terrariaGoldShortsword, (int) ceil(Math.pow(16, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaGoldShortsword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaGoldBroadsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic && ModConfig.disableSets.lowtier) entries.add(new LootEntryItem(terrariaGoldBroadsword, (int) ceil(Math.pow(16, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaGoldBroadsword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaTungstenBroadsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic) entries.add(new LootEntryItem(terrariaTungstenBroadsword, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaTungstenBroadsword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaTungstenShortsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic) entries.add(new LootEntryItem(terrariaTungstenShortsword, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaTungstenShortsword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaPlatinumShortsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic) entries.add(new LootEntryItem(terrariaPlatinumShortsword, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaPlatinumShortsword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaPlatinumBroadsword && ModConfig.disableSeries.terraria && ModConfig.disableSets.generic) entries.add(new LootEntryItem(terrariaPlatinumBroadsword, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaPlatinumBroadsword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaMandibleBlade && ModConfig.disableSeries.terraria) entries.add(new LootEntryItem(terrariaMandibleBlade, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaMandibleBlade"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaKatana && ModConfig.disableSeries.terraria) entries.add(new LootEntryItem(terrariaKatana, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaKatana"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaExoticScimitar && ModConfig.disableSeries.terraria) entries.add(new LootEntryItem(terrariaExoticScimitar, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaExoticScimitar"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaMuramasa && ModConfig.disableSeries.terraria) entries.add(new LootEntryItem(terrariaMuramasa, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaMuramasa"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaFalconBlade && ModConfig.disableSeries.terraria) entries.add(new LootEntryItem(terrariaFalconBlade, (int) ceil(Math.pow(8, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaFalconBlade"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaBladeofGrass && ModConfig.disableSeries.terraria) entries.add(new LootEntryItem(terrariaBladeofGrass, (int) ceil(Math.pow(7, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaBladeofGrass"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaFieryGreatsword && ModConfig.disableSeries.terraria) entries.add(new LootEntryItem(terrariaFieryGreatsword, (int) ceil(Math.pow(7, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaFieryGreatsword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaBoneSword && ModConfig.disableSeries.terraria) entries.add(new LootEntryItem(terrariaBoneSword, (int) ceil(Math.pow(7, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaBoneSword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaBloodButcherer && ModConfig.disableSeries.terraria) entries.add(new LootEntryItem(terrariaBloodButcherer, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaBloodButcherer"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaEnchantedSword && ModConfig.disableSeries.terraria) entries.add(new LootEntryItem(terrariaEnchantedSword, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaEnchantedSword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaStarfury && ModConfig.disableSeries.terraria) entries.add(new LootEntryItem(terrariaStarfury, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaStarfury"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaBeeKeeper && ModConfig.disableSeries.terraria) entries.add(new LootEntryItem(terrariaBeeKeeper, (int) ceil(Math.pow(7, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaBeeKeeper"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaIceBlade && ModConfig.disableSeries.terraria) entries.add(new LootEntryItem(terrariaIceBlade, (int) ceil(Math.pow(6, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaIceBlade"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaNightEdge && ModConfig.disableSeries.terraria) entries.add(new LootEntryItem(terrariaNightEdge, (int) ceil(Math.pow(6, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaNightEdge"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaArkhalis && ModConfig.disableSeries.terraria) entries.add(new LootEntryItem(terrariaArkhalis, (int) ceil(Math.pow(7, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaArkhalis"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaTrident && ModConfig.disableSeries.terraria) entries.add(new LootEntryItem(terrariaTrident, (int) ceil(Math.pow(7, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaTrident"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaTheRottedFork && ModConfig.disableSeries.terraria) entries.add(new LootEntryItem(terrariaTheRottedFork, (int) ceil(Math.pow(7, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaTheRottedFork"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaWhitePhaseblade && ModConfig.disableSeries.terraria && ModConfig.disableSets.tech) entries.add(new LootEntryItem(terrariaWhitePhaseblade, (int) ceil(Math.pow(7, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaWhitePhaseblade"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaYellowPhaseblade && ModConfig.disableSeries.terraria && ModConfig.disableSets.tech) entries.add(new LootEntryItem(terrariaYellowPhaseblade, (int) ceil(Math.pow(7, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaYellowPhaseblade"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaPurplePhaseblade && ModConfig.disableSeries.terraria && ModConfig.disableSets.tech) entries.add(new LootEntryItem(terrariaPurplePhaseblade, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaPurplePhaseblade"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaGreenPhaseblade && ModConfig.disableSeries.terraria && ModConfig.disableSets.tech) entries.add(new LootEntryItem(terrariaGreenPhaseblade, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaGreenPhaseblade"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaRedPhaseblade && ModConfig.disableSeries.terraria && ModConfig.disableSets.tech) entries.add(new LootEntryItem(terrariaRedPhaseblade, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaRedPhaseblade"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaBluePhaseblade && ModConfig.disableSeries.terraria && ModConfig.disableSets.tech) entries.add(new LootEntryItem(terrariaBluePhaseblade, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaBluePhaseblade"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaLightBane && ModConfig.disableSeries.terraria) entries.add(new LootEntryItem(terrariaLightBane, (int) ceil(Math.pow(7, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaLightBane"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaDarkLance && ModConfig.disableSeries.terraria) entries.add(new LootEntryItem(terrariaDarkLance, (int) ceil(Math.pow(7, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaDarkLance"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaPurpleClubberfish && ModConfig.disableSeries.terraria && ModConfig.disableSets.joke) entries.add(new LootEntryItem(terrariaPurpleClubberfish, (int) ceil(Math.pow(3, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaPurpleClubberfish"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaCactusSword && ModConfig.disableSeries.terraria && ModConfig.disableSets.joke) entries.add(new LootEntryItem(terrariaCactusSword, (int) ceil(Math.pow(12, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaCactusSword"));
			if (ModConfig.enabledItems.terrariaenabled.terrariaSwordfish && ModConfig.disableSeries.terraria && ModConfig.disableSets.joke) entries.add(new LootEntryItem(terrariaSwordfish, (int) ceil(Math.pow(3, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:terrariaSwordfish"));

			//sw
			if (ModConfig.enabledItems.swenabled.swYellowLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) entries.add(new LootEntryItem(swYellowLightsaber, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:swYellowLightsaber"));
			if (ModConfig.enabledItems.swenabled.swGreenLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) entries.add(new LootEntryItem(swGreenLightsaber, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:swGreenLightsaber"));
			if (ModConfig.enabledItems.swenabled.swBlueLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) entries.add(new LootEntryItem(swBlueLightsaber, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:swBlueLightsaber"));
			if (ModConfig.enabledItems.swenabled.swRedLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) entries.add(new LootEntryItem(swRedLightsaber, (int) ceil(Math.pow(5, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:swRedLightsaber"));
			if (ModConfig.enabledItems.swenabled.swMaceWinduLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) entries.add(new LootEntryItem(swMaceWinduLightsaber, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:swMaceWinduLightsaber"));
			if (ModConfig.enabledItems.swenabled.swTheInquisitorLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) entries.add(new LootEntryItem(swTheInquisitorLightsaber, (int) ceil(Math.pow(3, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:swTheInquisitorLightsaber"));
			if (ModConfig.enabledItems.swenabled.swDarthMaulLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) entries.add(new LootEntryItem(swDarthMaulLightsaber, (int) ceil(Math.pow(3, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:swDarthMaulLightsaber"));
			if (ModConfig.enabledItems.swenabled.swQuiGonJinnLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) entries.add(new LootEntryItem(swQuiGonJinnLightsaber, (int) ceil(Math.pow(4, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:swQuiGonJinnLightsaber"));
			if (ModConfig.enabledItems.swenabled.swKyloRenLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) entries.add(new LootEntryItem(swKyloRenLightsaber, (int) ceil(Math.pow(3, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:swKyloRenLightsaber"));
			if (ModConfig.enabledItems.swenabled.swCountDookuLightsaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) entries.add(new LootEntryItem(swCountDookuLightsaber, (int) ceil(Math.pow(3, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:swCountDookuLightsaber"));
			if (ModConfig.enabledItems.swenabled.swDarksaber && ModConfig.disableSeries.sw && ModConfig.disableSets.tech) entries.add(new LootEntryItem(swDarksaber, (int) ceil(Math.pow(2, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:swDarksaber"));

			//internet
			if (ModConfig.enabledItems.internetenabled.internetDemonoidPitchfork && ModConfig.disableSeries.internet) entries.add(new LootEntryItem(internetDemonoidPitchfork, (int) ceil(Math.pow(6, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:internetDemonoidPitchfork"));

			//nh
			if (ModConfig.enabledItems.nhenabled.nhMagicbane && ModConfig.disableSeries.nh) entries.add(new LootEntryItem(nhMagicbane, (int) ceil(Math.pow(3, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:nhMagicbane"));
			if (ModConfig.enabledItems.nhenabled.nhAthame && ModConfig.disableSeries.nh) entries.add(new LootEntryItem(nhAthame, (int) ceil(Math.pow(11, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:nhAthame"));
			if (ModConfig.enabledItems.nhenabled.nhGrayswandir && ModConfig.disableSeries.nh) entries.add(new LootEntryItem(nhGrayswandir, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:nhGrayswandir"));
			if (ModConfig.enabledItems.nhenabled.nhSilverSaber && ModConfig.disableSeries.nh) entries.add(new LootEntryItem(nhSilverSaber, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:nhSilverSaber"));

			//abcm
			if (ModConfig.enabledItems.abcmenabled.abcmExcalibur && ModConfig.disableSeries.abcm) entries.add(new LootEntryItem(abcmExcalibur, (int) ceil(Math.pow(10, ModConfig.rarityScale)), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:abcmExcalibur"));

			//Empty Item
			entries.add(new LootEntryItem(Items.BONE, (int) Math.round((2486 / ModConfig.lootChance) - 2486), 60, new LootFunction[0], new LootCondition[0], "heroicarmory:emptyItem"));


            LootEntry[] entriesArray = entries.toArray(new LootEntry[entries.size()]);

            LootPool pool = new LootPool(entriesArray, new LootCondition[0], new RandomValueRange(1), new RandomValueRange(1), "heroicarmorypool");

            evt.getTable().addPool(pool);

		}
	}

}