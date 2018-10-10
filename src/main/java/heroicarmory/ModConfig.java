package heroicarmory;

import heroicarmory.Reference;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.RequiresMcRestart;
import net.minecraftforge.common.config.Config.RequiresWorldRestart;
import net.minecraftforge.common.config.Config.RangeDouble;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

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

@Config(modid = Reference.MODID)
@Config.LangKey("heroicarmory.config.title")
public class ModConfig {

    //INCLUDE===========================================================================================================

	@Comment("Whether to generate items in chests added by mods. WARNING: This may cause duplicates in vanilla chests, so you may want to lower the loot chance.")
	@Name("Include mod chests")
	@RequiresWorldRestart
	public static boolean includeModChests = false;

    //SCALE=============================================================================================================

    @Name("Scale Damage")
	@Comment("This number multiplies how much damage every weapon does.")
	@RangeDouble(min = 0, max = 3)
	@RequiresMcRestart
	public static double damageScale = 1;

    @Name("Scale Rarity")
	@Comment("This number exponentially multiplies how rare weapons are to each other (0 means all are equal, 3 means rare weapons are extremely rare)")
	@RangeDouble(min = 0, max = 3)
	@RequiresWorldRestart
	public static double rarityScale = 1;

    @Name("Scale Loot Chance")
	@Comment("This is the percentage chance that you will find an item in each chest.")
	@RangeDouble(min = 0, max = 1)
	@RequiresWorldRestart
	public static double lootChance = 0.75;

    //DISABLE BY TYPE===================================================================================================

	@Comment("Disable items by various types")
	@RequiresMcRestart
	@Name("Disable By Type")
	public static final DisableSets disableSets = new DisableSets();

	public static class DisableSets {

		@Comment("Removes any futuristic weapons such as light sabers.")
		@Name("Include high tech weapons")
		@RequiresWorldRestart
		public boolean tech = true;

		@Comment("Removes all generic weapons (tiered/crafted items from other games)")
		@Name("Include generic weapons")
		@RequiresWorldRestart
		public boolean generic = true;

		@Comment("Removes any generic weapons that have an attack lower than diamond swords.")
		@Name("Include low-tier weapons")
		@RequiresWorldRestart
		public boolean lowtier = true;

		@Comment("Removes any silly weapons that don't really make sense as weapons.")
		@Name("Include joke weapons")
		@RequiresWorldRestart
		public boolean joke = true;
	}

    //DISABLE BY SERIES===================================================================================================

	@Comment("Disable items by their source series")
	@RequiresMcRestart
	@Name("Disable By Series")
	public static final DisableSeries disableSeries = new DisableSeries();

	public static class DisableSeries {

		
		@Name("Include Lord of the Rings")
		@Comment("Remove all Lord of the Rings items from drop tables / creative mode")
		public boolean lotr = true;

		@Name("Include Legend of Zelda")
		@Comment("Remove all Legend of Zelda items from drop tables / creative mode")
		public boolean loz = true;

		@Name("Include Adventure Time")
		@Comment("Remove all Adventure Time items from drop tables / creative mode")
		public boolean at = true;

		@Name("Include Final Fantasy")
		@Comment("Remove all Final Fantasy items from drop tables / creative mode")
		public boolean ff = true;

		@Name("Include Realm of the Mad God")
		@Comment("Remove all Realm of the Mad God items from drop tables / creative mode")
		public boolean rotmg = true;

		@Name("Include Soul Calibur")
		@Comment("Remove all Soul Calibur items from drop tables / creative mode")
		public boolean sc = true;

		@Name("Include Runescape")
		@Comment("Remove all Runescape items from drop tables / creative mode")
		public boolean rs = true;

		@Name("Include Devil May Cry")
		@Comment("Remove all Devil May Cry items from drop tables / creative mode")
		public boolean dmc = true;

		@Name("Include Pokemon")
		@Comment("Remove all Pokemon items from drop tables / creative mode")
		public boolean pkmn = true;

		@Name("Include Kirby")
		@Comment("Remove all Kirby items from drop tables / creative mode")
		public boolean kirby = true;

		@Name("Include Fire Emblem")
		@Comment("Remove all Fire Emblem items from drop tables / creative mode")
		public boolean fe = true;

		@Name("Include Kingdom Hearts")
		@Comment("Remove all Kingdom Hearts items from drop tables / creative mode")
		public boolean kh = true;

		@Name("Include Bleach")
		@Comment("Remove all Bleach items from drop tables / creative mode")
		public boolean bleach = true;

		@Name("Include Dark Souls")
		@Comment("Remove all Dark Souls items from drop tables / creative mode")
		public boolean ds = true;

		@Name("Include Mythology")
		@Comment("Remove all Mythology items from drop tables / creative mode")
		public boolean myth = true;

		@Name("Include Bayonetta")
		@Comment("Remove all Bayonetta items from drop tables / creative mode")
		public boolean bayonetta = true;

		@Name("Include God of War")
		@Comment("Remove all God of War items from drop tables / creative mode")
		public boolean gow = true;

		@Name("Include Skyrim")
		@Comment("Remove all Skyrim items from drop tables / creative mode")
		public boolean skyrim = true;

		@Name("Include Monster Hunter")
		@Comment("Remove all Monster Hunter items from drop tables / creative mode")
		public boolean mh = true;

		@Name("Include Terraria")
		@Comment("Remove all Terraria items from drop tables / creative mode")
		public boolean terraria = true;

		@Name("Include Star Wars")
		@Comment("Remove all Star Wars items from drop tables / creative mode")
		public boolean sw = true;

		@Name("Include Internet")
		@Comment("Remove all Internet items from drop tables / creative mode")
		public boolean internet = true;

		@Name("Include Nethack")
		@Comment("Remove all Nethack items from drop tables / creative mode")
		public boolean nh = true;

		@Name("Include Merlin (ABC)")
		@Comment("Remove all Merlin (ABC) items from drop tables / creative mode")
		public boolean abcm = true;

	}

    //DISABLE INDIVIDUAL================================================================================================

	@Comment("Disable items one at a time from spawning / showing in creative mode")
	@RequiresMcRestart
	@Name("Disable Individual Items")
	public static final EnabledItems enabledItems = new EnabledItems();

	public static class EnabledItems {
		
		
		@Name("Lord of the Rings")
		public final lotrEnabled lotrenabled = new lotrEnabled();
		public static class lotrEnabled {

			@Name("Gimli's Battle Axe")
			public boolean lotrGimliBattleAxe = true;

			@Name("Gimli's Long Axe")
			public boolean lotrGimliLongAxe = true;

			@Name("Morgul Blade")
			public boolean lotrMorgulBlade = true;

			@Name("Sting")
			public boolean lotrSting = true;

			@Name("Glamdring")
			public boolean lotrGlamdring = true;

			@Name("Anduril")
			public boolean lotrAnduril = true;

			@Name("Narsil")
			public boolean lotrNarsil = true;

			@Name("Sauron's Mace")
			public boolean lotrSauronMace = true;

			@Name("Witch King's Sword")
			public boolean lotrWitchKingSword = true;
		}

		@Name("Legend of Zelda")
		public final lozEnabled lozenabled = new lozEnabled();
		public static class lozEnabled {

			@Name("Master Sword")
			public boolean lozMasterSword = true;

			@Name("Master Sword II")
			public boolean lozMasterSwordII = true;

			@Name("Tempered Sword")
			public boolean lozTemperedSword = true;

			@Name("Master Sword III")
			public boolean lozMasterSwordIII = true;

			@Name("Golden Sword")
			public boolean lozGoldenSword = true;

			@Name("Flameblade")
			public boolean lozFlameblade = true;

			@Name("Darknut Sword")
			public boolean lozDarknutSwordTp = true;

			@Name("Ghirahim Sword")
			public boolean lozGhirahimSword = true;

			@Name("Fierce Diety's Sword")
			public boolean lozFierceDietySword = true;

			@Name("Zelda's Sword")
			public boolean lozZeldaSword = true;

			@Name("Boko Stick")
			public boolean lozBokoStick = true;

			@Name("Cane of Byrna")
			public boolean lozCaneofByrna = true;

			@Name("Megaton Hammer")
			public boolean lozMegatonHammer = true;

			@Name("Kokiri Sword")
			public boolean lozKokiriSwordMm = true;

			@Name("Kokiri Sword")
			public boolean lozKokiriSwordOoT = true;

			@Name("Demise's Sword")
			public boolean lozDemiseSword = true;

			@Name("Giant's Knife")
			public boolean lozGiantKnife = true;

			@Name("Biggoron's Sword")
			public boolean lozBiggoronSword = true;

			@Name("Phantom Ganon's Sword")
			public boolean lozPhantomGanonSword = true;

			@Name("Ultimate Sword")
			public boolean lozUltimateSword = true;

			@Name("Royal Guard's Sword")
			public boolean lozRoyalGuardSword = true;

			@Name("Magic Sword")
			public boolean lozMagicSwordConcept = true;

			@Name("Magic Sword")
			public boolean lozMagicSword = true;

			@Name("White Sword")
			public boolean lozWhiteSword = true;

			@Name("White Sword")
			public boolean lozWhiteSwordConcept = true;

			@Name("Picori Blade")
			public boolean lozPicoriBlade = true;

			@Name("Razor Sword")
			public boolean lozRazorSword = true;

			@Name("Great Fairy's Sword")
			public boolean lozGreatFairySword = true;

			@Name("Goddess White Sword")
			public boolean lozGoddessWhiteSword = true;

			@Name("Goddess Sword")
			public boolean lozGoddessSword = true;

			@Name("Gilded Sword")
			public boolean lozGildedSword = true;

			@Name("Spiked Boko Club")
			public boolean lozSpikedBokoClub = true;

			@Name("Boko Club")
			public boolean lozBokoClub = true;
		}

		@Name("Adventure Time")
		public final atEnabled atenabled = new atEnabled();
		public static class atEnabled {

			@Name("Jake's Sword")
			public boolean atJakeSword = true;

			@Name("Crystal Sword")
			public boolean atCrystalSword = true;

			@Name("Nothung")
			public boolean atNothung = true;

			@Name("Finn Sword")
			public boolean atFinnSword = true;

			@Name("Sword of the Dead")
			public boolean atSwordoftheDead = true;

			@Name("Wish Star Sword")
			public boolean atWishStarSword = true;

			@Name("Fight King Sword")
			public boolean atFightKingSword = true;

			@Name("Root Sword")
			public boolean atRootSword = true;

			@Name("Scarlet")
			public boolean atScarlet = true;

			@Name("Grass Sword")
			public boolean atGrassSword = true;

			@Name("Demon Blood Sword")
			public boolean atDemonBloodSword = true;

			@Name("Axe Bass")
			public boolean atAxeBass = true;
		}

		@Name("Final Fantasy")
		public final ffEnabled ffenabled = new ffEnabled();
		public static class ffEnabled {

			@Name("The Masamune")
			public boolean ffTheMasamune = true;

			@Name("Buster Sword")
			public boolean ffBusterSword = true;

			@Name("Caladbolg")
			public boolean ffCaladbolg = true;
		}

		@Name("Realm of the Mad God")
		public final rotmgEnabled rotmgenabled = new rotmgEnabled();
		public static class rotmgEnabled {

			@Name("Sword of the Colossus")
			public boolean rotmgSwordoftheColossus = true;

			@Name("Crystal Sword")
			public boolean rotmgCrystalSword = true;

			@Name("Pixie-Enchanted Sword")
			public boolean rotmgPixieEnchantedSword = true;

			@Name("Sword Of Acclaim")
			public boolean rotmgSwordOfAcclaim = true;

			@Name("Demon Blade")
			public boolean rotmgDemonBlade = true;

			@Name("Sword of the Mad God")
			public boolean rotmgSwordoftheMadGod = true;

			@Name("Indomptable")
			public boolean rotmgIndomptable = true;

			@Name("Pirate King's Cutlass")
			public boolean rotmgPirateKingCutlass = true;

			@Name("Sword of Splendor")
			public boolean rotmgSwordofSplendor = true;

			@Name("Skysplitter Sword")
			public boolean rotmgSkysplitterSword = true;

			@Name("Archon Sword")
			public boolean rotmgArchonSword = true;

			@Name("Ancient Stone Sword")
			public boolean rotmgAncientStoneSword = true;

			@Name("Dragonsoul Sword")
			public boolean rotmgDragonsoulSword = true;

			@Name("Ravenheart Sword")
			public boolean rotmgRavenheartSword = true;
		}

		@Name("Soul Calibur")
		public final scEnabled scenabled = new scEnabled();
		public static class scEnabled {

			@Name("Firangi")
			public boolean scFirangi = true;

			@Name("Cocytus")
			public boolean scCocytus = true;

			@Name("Erlang's Blade")
			public boolean scErlangBlade = true;

			@Name("Soul Edge")
			public boolean scSoulEdgeNightmare = true;

			@Name("Phlegathon")
			public boolean scPhlegathon = true;

			@Name("Acheron")
			public boolean scAcheron = true;

			@Name("Lethe")
			public boolean scLethe = true;

			@Name("Queen's Guard")
			public boolean scQueenGuard = true;

			@Name("Holy Antler")
			public boolean scHolyAntler = true;

			@Name("Epee")
			public boolean scEpee = true;

			@Name("War Hammer")
			public boolean scWarHammer = true;

			@Name("Kalutues")
			public boolean scKalutues = true;

			@Name("Estoc")
			public boolean scEstoc = true;

			@Name("Flambert")
			public boolean scFlambert2P = true;

			@Name("Reiterpallasch")
			public boolean scReiterpallasch = true;

			@Name("Flambert")
			public boolean scFlambert = true;

			@Name("Blue Crystal Rod")
			public boolean scBlueCrystalRod = true;

			@Name("Fire Blade")
			public boolean scFireBlade = true;

			@Name("Xi Sword")
			public boolean scXiSword = true;

			@Name("Omega Sword")
			public boolean scOmegaSword2P = true;

			@Name("Omega Sword")
			public boolean scOmegaSword = true;

			@Name("Orichalcum")
			public boolean scOrichalcum = true;

			@Name("Stiletto")
			public boolean scStiletto = true;

			@Name("Requiem")
			public boolean scRequiem = true;

			@Name("Faust")
			public boolean scFaust = true;

			@Name("Flamberge")
			public boolean scFlamberge = true;

			@Name("Steel Paddle")
			public boolean scSteelPaddle = true;

			@Name("Glam")
			public boolean scGlam = true;

			@Name("Great Blade")
			public boolean scGreatBlade = true;
		}

		@Name("Runescape")
		public final rsEnabled rsenabled = new rsEnabled();
		public static class rsEnabled {

			@Name("Bronze Sword")
			public boolean rsBronzeSword = true;

			@Name("Iron Sword")
			public boolean rsIronSword = true;

			@Name("White Sword")
			public boolean rsWhiteSword = true;

			@Name("Black Sword")
			public boolean rsBlackSword = true;

			@Name("Steel Sword")
			public boolean rsSteelSword = true;

			@Name("Mithril Sword")
			public boolean rsMithrilSword = true;

			@Name("Adamant Sword")
			public boolean rsAdamantSword = true;

			@Name("Rune Sword")
			public boolean rsRuneSword = true;

			@Name("Dragon Sword")
			public boolean rsDragonSword = true;

			@Name("Bronze Battleaxe")
			public boolean rsBronzeBattleaxe = true;

			@Name("Iron Battleaxe")
			public boolean rsIronBattleaxe = true;

			@Name("Steel Battleaxe")
			public boolean rsSteelBattleaxe = true;

			@Name("Black Battleaxe")
			public boolean rsBlackBattleaxe = true;

			@Name("White Battleaxe")
			public boolean rsWhiteBattleaxe = true;

			@Name("Mithril Battleaxe")
			public boolean rsMithrilBattleaxe = true;

			@Name("Adamant Battleaxe")
			public boolean rsAdamantBattleaxe = true;

			@Name("Rune Battleaxe")
			public boolean rsRuneBattleaxe = true;

			@Name("Dragon Battleaxe")
			public boolean rsDragonBattleaxe = true;

			@Name("Bronze Scimitar")
			public boolean rsBronzeScimitar = true;

			@Name("Iron Scimitar")
			public boolean rsIronScimitar = true;

			@Name("Black Scimitar")
			public boolean rsBlackScimitar = true;

			@Name("White Scimitar")
			public boolean rsWhiteScimitar = true;

			@Name("Steel Scimitar")
			public boolean rsSteelScimitar = true;

			@Name("Mithril Scimitar")
			public boolean rsMithrilScimitar = true;

			@Name("Adamant Scimitar")
			public boolean rsAdamantScimitar = true;

			@Name("Rune Scimitar")
			public boolean rsRuneScimitar = true;

			@Name("Dragon Scimitar")
			public boolean rsDragonScimitar = true;

			@Name("Bronze Warhammer")
			public boolean rsBronzeWarhammer = true;

			@Name("Iron Warhammer")
			public boolean rsIronWarhammer = true;

			@Name("Steel Warhammer")
			public boolean rsSteelWarhammer = true;

			@Name("Black Warhammer")
			public boolean rsBlackWarhammer = true;

			@Name("White Warhammer")
			public boolean rsWhiteWarhammer = true;

			@Name("Mithril Warhammer")
			public boolean rsMithrilWarhammer = true;

			@Name("Adamant Warhammer")
			public boolean rsAdamantWarhammer = true;

			@Name("Rune Warhammer")
			public boolean rsRuneWarhammer = true;

			@Name("Bronze Mace")
			public boolean rsBronzeMace = true;

			@Name("Iron Mace")
			public boolean rsIronMace = true;

			@Name("Steel Mace")
			public boolean rsSteelMace = true;

			@Name("Black Mace")
			public boolean rsBlackMace = true;

			@Name("White Mace")
			public boolean rsWhiteMace = true;

			@Name("Mithril Mace")
			public boolean rsMithrilMace = true;

			@Name("Adamant Mace")
			public boolean rsAdamantMace = true;

			@Name("Rune Mace")
			public boolean rsRuneMace = true;

			@Name("Granite Longsword")
			public boolean rsGraniteLongsword = true;

			@Name("Granite Hammer")
			public boolean rsGraniteHammer = true;

			@Name("Granite Maul")
			public boolean rsGraniteMaul = true;

			@Name("Elder Maul")
			public boolean rsElderMaul = true;

			@Name("Toktz-xil-ak")
			public boolean rsToktzxilak = true;

			@Name("Wolfsbane")
			public boolean rsWolfsbane = true;

			@Name("Zamorak Godsword")
			public boolean rsZamorakGodsword = true;

			@Name("Bandos Godsword")
			public boolean rsBandosGodsword = true;

			@Name("Armadyl Godsword")
			public boolean rsArmadylGodsword = true;

			@Name("Saradomin Godsword")
			public boolean rsSaradominGodsword = true;

			@Name("Barrelchest Anchor")
			public boolean rsBarrelchestAnchor = true;
		}

		@Name("Devil May Cry")
		public final dmcEnabled dmcenabled = new dmcEnabled();
		public static class dmcEnabled {

			@Name("Red Queen")
			public boolean dmcRedQueen = true;

			@Name("Rebellion")
			public boolean dmcRebellion = true;

			@Name("Yamato")
			public boolean dmcYamato = true;
		}

		@Name("Pokemon")
		public final pkmnEnabled pkmnenabled = new pkmnEnabled();
		public static class pkmnEnabled {

			@Name("Honedge")
			public boolean pkmnHonedgeShiny = true;

			@Name("Honedge")
			public boolean pkmnHonedge = true;
		}

		@Name("Kirby")
		public final kirbyEnabled kirbyenabled = new kirbyEnabled();
		public static class kirbyEnabled {

			@Name("Galaxia")
			public boolean kirbyGalaxia = true;

			@Name("Kirby's Ultra Sword")
			public boolean kirbyKirbyUltraSword = true;

			@Name("Kirby's Sword")
			public boolean kirbyKirbySword = true;
		}

		@Name("Fire Emblem")
		public final feEnabled feenabled = new feEnabled();
		public static class feEnabled {

			@Name("Chrom's Falchion")
			public boolean feChromFalchion = true;

			@Name("Falchion")
			public boolean feFalchion = true;
		}

		@Name("Kingdom Hearts")
		public final khEnabled khenabled = new khEnabled();
		public static class khEnabled {

			@Name("Keyblade")
			public boolean khKeyblade = true;
		}

		@Name("Bleach")
		public final bleachEnabled bleachenabled = new bleachEnabled();
		public static class bleachEnabled {

			@Name("Zabimaru")
			public boolean bleachZabimaru = true;

			@Name("Zangestsu")
			public boolean bleachZangestsu = true;
		}

		@Name("Dark Souls")
		public final dsEnabled dsenabled = new dsEnabled();
		public static class dsEnabled {

			@Name("Greatsword of Artorias")
			public boolean dsGreatswordofArtorias = true;

			@Name("Great Lord Greatsword")
			public boolean dsGreatLordGreatsword = true;

			@Name("Astora Greatsword")
			public boolean dsAstoraGreatsword = true;

			@Name("Zweilhander")
			public boolean dsZweilhander = true;
		}

		@Name("Mythology")
		public final mythEnabled mythenabled = new mythEnabled();
		public static class mythEnabled {

			@Name("Death's Scythe")
			public boolean mythDeathScythe = true;

			@Name("The Devil's Pitchfork")
			public boolean mythTheDevilPitchfork = true;
		}

		@Name("Bayonetta")
		public final bayonettaEnabled bayonettaenabled = new bayonettaEnabled();
		public static class bayonettaEnabled {

			@Name("Shuraba")
			public boolean bayonettaShuraba = true;

			@Name("Angel Slayer")
			public boolean bayonettaAngelSlayer = true;
		}

		@Name("God of War")
		public final gowEnabled gowenabled = new gowEnabled();
		public static class gowEnabled {

			@Name("Leviathan")
			public boolean gowLeviathanUpgraded = true;

			@Name("Leviathan")
			public boolean gowLeviathan = true;

			@Name("Blade of Olympus")
			public boolean gowBladeofOlympus = true;

			@Name("Blade of Chaos")
			public boolean gowBladeofChaos = true;
		}

		@Name("Skyrim")
		public final skyrimEnabled skyrimenabled = new skyrimEnabled();
		public static class skyrimEnabled {

			@Name("Iron Sword")
			public boolean skyrimIronSword = true;

			@Name("Iron Warhammer")
			public boolean skyrimIronWarhammer = true;

			@Name("Steel Sword")
			public boolean skyrimSteelSword = true;

			@Name("Steel Warhammer")
			public boolean skyrimSteelWarhammer = true;

			@Name("Orcish Sword")
			public boolean skyrimOrcishSword = true;

			@Name("Orcish Warhammer")
			public boolean skyrimOrcishWarhammer = true;

			@Name("Dwarven Sword")
			public boolean skyrimDwarvenSword = true;

			@Name("Dwarven Warhammer")
			public boolean skyrimDwarvenWarhammer = true;

			@Name("Elven Sword")
			public boolean skyrimElvenSword = true;

			@Name("Elven Warhammer")
			public boolean skyrimElvenWarhammer = true;

			@Name("Glass Sword")
			public boolean skyrimGlassSword = true;

			@Name("Glass Warhammer")
			public boolean skyrimGlassWarhammer = true;

			@Name("Ebony Sword")
			public boolean skyrimEbonySword = true;

			@Name("Ebony Warhammer")
			public boolean skyrimEbonyWarhammer = true;

			@Name("Daedric Sword")
			public boolean skyrimDaedricSword = true;

			@Name("Daedric Warhammer")
			public boolean skyrimDaedricWarhammer = true;

			@Name("Dragonbone Sword")
			public boolean skyrimDragonboneSword = true;

			@Name("Dragonbone Warhammer")
			public boolean skyrimDragonboneWarhammer = true;

			@Name("Imperial Sword")
			public boolean skyrimImperialSword = true;

			@Name("Dawnbreaker")
			public boolean skyrimDawnbreaker = true;

			@Name("Ancient Nord Sword")
			public boolean skyrimAncientNordSword = true;

			@Name("Chillrend")
			public boolean skyrimChillrend = true;

			@Name("Ebony Blade")
			public boolean skyrimEbonyBlade = true;
		}

		@Name("Monster Hunter")
		public final mhEnabled mhenabled = new mhEnabled();
		public static class mhEnabled {

			@Name("Chicken Decapitator")
			public boolean mhChickenDecapitator = true;

			@Name("Golem Blade")
			public boolean mhGolemBlade = true;

			@Name("Defender")
			public boolean mhDefender = true;

			@Name("Black Belt Blade")
			public boolean mhBlackBeltBlade = true;

			@Name("Wailing Cleaver")
			public boolean mhWailingCleaver = true;

			@Name("Gaelic Flame")
			public boolean mhGaelicFlame = true;

			@Name("Bone Katana")
			public boolean mhBoneKatana = true;

			@Name("Hellish Slasher")
			public boolean mhHellishSlasher = true;

			@Name("Centenarian Dagger")
			public boolean mhCentenarianDagger = true;

			@Name("Wyvern Blade Blood")
			public boolean mhWyvernBladeBlood = true;

			@Name("Wyvern Blade Holly")
			public boolean mhWyvernBladeHolly = true;

			@Name("Wyvern Blade Pale")
			public boolean mhWyvernBladePale = true;

			@Name("Wyvern Blade Azure")
			public boolean mhWyvernBladeAzure = true;

			@Name("Wyvern Blade Leaf")
			public boolean mhWyvernBladeLeaf = true;

			@Name("Rathalos Flamesword")
			public boolean mhRathalosFlamesword = true;
		}

		@Name("Terraria")
		public final terrariaEnabled terrariaenabled = new terrariaEnabled();
		public static class terrariaEnabled {

			@Name("Palm Wood Sword")
			public boolean terrariaPalmWoodSword = true;

			@Name("Boreal Wood Sword")
			public boolean terrariaBorealWoodSword = true;

			@Name("Shadewood Sword")
			public boolean terrariaShadewoodSword = true;

			@Name("Ebonwood Sword")
			public boolean terrariaEbonwoodSword = true;

			@Name("Copper Shortsword")
			public boolean terrariaCopperShortsword = true;

			@Name("Copper Broadsword")
			public boolean terrariaCopperBroadsword = true;

			@Name("Tin Shortsword")
			public boolean terrariaTinShortsword = true;

			@Name("Tin Broadsword")
			public boolean terrariaTinBroadsword = true;

			@Name("Lead Shortsword")
			public boolean terrariaLeadShortsword = true;

			@Name("Lead Broadsword")
			public boolean terrariaLeadBroadsword = true;

			@Name("Spear")
			public boolean terrariaSpear = true;

			@Name("Iron Shortsword")
			public boolean terrariaIronShortsword = true;

			@Name("Iron Broadsword")
			public boolean terrariaIronBroadsword = true;

			@Name("Silver Broadsword")
			public boolean terrariaSilverBroadsword = true;

			@Name("Silver Shortsword")
			public boolean terrariaSilverShortsword = true;

			@Name("Gold Shortsword")
			public boolean terrariaGoldShortsword = true;

			@Name("Gold Broadsword")
			public boolean terrariaGoldBroadsword = true;

			@Name("Tungsten Broadsword")
			public boolean terrariaTungstenBroadsword = true;

			@Name("Tungsten Shortsword")
			public boolean terrariaTungstenShortsword = true;

			@Name("Platinum Shortsword")
			public boolean terrariaPlatinumShortsword = true;

			@Name("Platinum Broadsword")
			public boolean terrariaPlatinumBroadsword = true;

			@Name("Mandible Blade")
			public boolean terrariaMandibleBlade = true;

			@Name("Katana")
			public boolean terrariaKatana = true;

			@Name("Exotic Scimitar")
			public boolean terrariaExoticScimitar = true;

			@Name("Muramasa")
			public boolean terrariaMuramasa = true;

			@Name("Falcon Blade")
			public boolean terrariaFalconBlade = true;

			@Name("Blade of Grass")
			public boolean terrariaBladeofGrass = true;

			@Name("Fiery Greatsword")
			public boolean terrariaFieryGreatsword = true;

			@Name("Bone Sword")
			public boolean terrariaBoneSword = true;

			@Name("Blood Butcherer")
			public boolean terrariaBloodButcherer = true;

			@Name("Enchanted Sword")
			public boolean terrariaEnchantedSword = true;

			@Name("Starfury")
			public boolean terrariaStarfury = true;

			@Name("Bee Keeper")
			public boolean terrariaBeeKeeper = true;

			@Name("Ice Blade")
			public boolean terrariaIceBlade = true;

			@Name("Night's Edge")
			public boolean terrariaNightEdge = true;

			@Name("Arkhalis")
			public boolean terrariaArkhalis = true;

			@Name("Trident")
			public boolean terrariaTrident = true;

			@Name("The Rotted Fork")
			public boolean terrariaTheRottedFork = true;

			@Name("White Phaseblade")
			public boolean terrariaWhitePhaseblade = true;

			@Name("Yellow Phaseblade")
			public boolean terrariaYellowPhaseblade = true;

			@Name("Purple Phaseblade")
			public boolean terrariaPurplePhaseblade = true;

			@Name("Green Phaseblade")
			public boolean terrariaGreenPhaseblade = true;

			@Name("Red Phaseblade")
			public boolean terrariaRedPhaseblade = true;

			@Name("Blue Phaseblade")
			public boolean terrariaBluePhaseblade = true;

			@Name("Light's Bane")
			public boolean terrariaLightBane = true;

			@Name("Dark Lance")
			public boolean terrariaDarkLance = true;

			@Name("Purple Clubberfish")
			public boolean terrariaPurpleClubberfish = true;

			@Name("Cactus Sword")
			public boolean terrariaCactusSword = true;

			@Name("Swordfish")
			public boolean terrariaSwordfish = true;
		}

		@Name("Star Wars")
		public final swEnabled swenabled = new swEnabled();
		public static class swEnabled {

			@Name("Yellow Lightsaber")
			public boolean swYellowLightsaber = true;

			@Name("Green Lightsaber")
			public boolean swGreenLightsaber = true;

			@Name("Blue Lightsaber")
			public boolean swBlueLightsaber = true;

			@Name("Red Lightsaber")
			public boolean swRedLightsaber = true;

			@Name("Mace Windu's Lightsaber")
			public boolean swMaceWinduLightsaber = true;

			@Name("The Inquisitor's Lightsaber")
			public boolean swTheInquisitorLightsaber = true;

			@Name("Darth Maul's Lightsaber")
			public boolean swDarthMaulLightsaber = true;

			@Name("Qui Gon Jinn's Lightsaber")
			public boolean swQuiGonJinnLightsaber = true;

			@Name("Kylo Ren's Lightsaber")
			public boolean swKyloRenLightsaber = true;

			@Name("Count Dooku's Lightsaber")
			public boolean swCountDookuLightsaber = true;

			@Name("Darksaber")
			public boolean swDarksaber = true;
		}

		@Name("Internet")
		public final internetEnabled internetenabled = new internetEnabled();
		public static class internetEnabled {

			@Name("Demonoid's Pitchfork")
			public boolean internetDemonoidPitchfork = true;
		}

		@Name("Nethack")
		public final nhEnabled nhenabled = new nhEnabled();
		public static class nhEnabled {

			@Name("Magicbane")
			public boolean nhMagicbane = true;

			@Name("Athame")
			public boolean nhAthame = true;

			@Name("Grayswandir")
			public boolean nhGrayswandir = true;

			@Name("Silver Saber")
			public boolean nhSilverSaber = true;
		}

		@Name("Merlin (ABC)")
		public final abcmEnabled abcmenabled = new abcmEnabled();
		public static class abcmEnabled {

			@Name("Excalibur")
			public boolean abcmExcalibur = true;
		}

	}

	@Mod.EventBusSubscriber(modid = Reference.MODID)
	private static class EventHandler {

		/**
		 * Inject the new values and save to the config file when the config has been changed from the GUI.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(Reference.MODID)) {
				ConfigManager.sync(Reference.MODID, Config.Type.INSTANCE);
			}
		}
	}
}