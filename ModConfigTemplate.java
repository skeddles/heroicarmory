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

		/*{{DISABLESERIES}}*/
	}

    //DISABLE INDIVIDUAL================================================================================================

	@Comment("Disable items one at a time from spawning / showing in creative mode")
	@RequiresMcRestart
	@Name("Disable Individual Items")
	public static final EnabledItems enabledItems = new EnabledItems();

	public static class EnabledItems {
		
		/*{{ENABLEDITEMS}}*/
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