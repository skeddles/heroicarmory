package heroicarmory;


import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

@Config(modid = Reference.MODID)
@Config.LangKey("heroicarmory.config.title")
public class ModConfig {

	@Comment("This number multiplies how much damage every weapon does. ")
	public static int damageScale = 1;

	@Comment("Hide futuristic weapons such as light sabers.")
	public static boolean hideTechItems = false;

	@Comment({"This is an example enum property.", "It will use a GuiConfigEntries.CycleValueEntry in the config GUI."})
	public static EnumExample exampleEnumProperty = EnumExample.VALUE_1;

	@Comment({"This an example Map field.", "It will be converted to a category containing a property for each key-value pair."})
	public static final Map<String, Boolean> exampleMapField = new HashMap<>();

	static {
		exampleMapField.put("foobar", true);
		exampleMapField.put("foobaz", true);
		exampleMapField.put("barbaz", false);
	}

	public static final Client client = new Client();
	
	@Name("Enable / Disable Items")
	public static final EnabledItems enabledItems = new EnabledItems();

	public enum EnumExample {
		VALUE_1,
		VALUE_2,
		VALUE_3,
		VALUE_4
	}
	
	public static class EnabledItems {
		
		@Comment("This is an example int property.")
		public int damageScale = 1;
		
		@Name("Realm of the Mad God")
		public final rotmgEnabled rotmgenabled = new rotmgEnabled();
		
		
		public static class rotmgEnabled {
			@Name("Ancient Stone Sword")
			public boolean rotmgAncientStoneSword = true;
		}
	}

	public static class Client {

		@Comment("This is an example int property.")
		public int damageScale = 1;

		@Comment("This is an example enum property in a subcategory of the main category.")
		public EnumExample exampleSubcategoryEnumProperty = EnumExample.VALUE_3;

		@Comment("This is an example enum property that uses an enum defined in a nested class.")
		public EnumExampleNested exampleNestedEnumProperty = EnumExampleNested.NESTED_2;

		public final HUDPos chunkEnergyHUDPos = new HUDPos(0, 0);

		public enum EnumExampleNested {
			NESTED_1,
			NESTED_2,
			NESTED_3,
			NESTED_4,
			NESTED_5
		}

		public static class HUDPos {
			public HUDPos(final int x, final int y) {
				this.x = x;
				this.y = y;
			}

			@Comment("The x coordinate")
			public int x;

			@Comment("The y coordinate")
			public int y;
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