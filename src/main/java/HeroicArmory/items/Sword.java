package heroicarmory.items;

import net.minecraft.item.ItemSword;

public class Sword extends ItemSword {

	public Sword(String name, ToolMaterial material) {
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}

}