package main.flowstoneenergy.utils;

import main.flowstoneenergy.items.ItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class oreDictHandler {

	public static void registerOreDict() {
		//dusts
		OreDictionary.registerOre("dustCopper", new ItemStack(ItemRegistry.metaResourceDust, 1, 3));
		OreDictionary.registerOre("dustTin", new ItemStack(ItemRegistry.metaResourceDust, 1, 4));
		OreDictionary.registerOre("dustLead", new ItemStack(ItemRegistry.metaResourceDust, 1, 5));
		OreDictionary.registerOre("dustSilver", new ItemStack(ItemRegistry.metaResourceDust, 1, 6));

		//ingots
		OreDictionary.registerOre("ingotCopper", new ItemStack(ItemRegistry.metaResourceIngot, 1, 0));
		OreDictionary.registerOre("ingotTin", new ItemStack(ItemRegistry.metaResourceIngot, 1, 1));
		OreDictionary.registerOre("ingotLead", new ItemStack(ItemRegistry.metaResourceIngot, 1, 2));
		OreDictionary.registerOre("ingotSilver", new ItemStack(ItemRegistry.metaResourceIngot, 1, 3));
		OreDictionary.registerOre("ingotEnderium", new ItemStack(ItemRegistry.metaResourceIngot, 1, 4));

		//gears
		OreDictionary.registerOre("gearWood", new ItemStack(ItemRegistry.metaResourceGear, 1, 0));
		OreDictionary.registerOre("gearStone", new ItemStack(ItemRegistry.metaResourceGear, 1, 1));
		OreDictionary.registerOre("gearIron", new ItemStack(ItemRegistry.metaResourceGear, 1, 2));
		OreDictionary.registerOre("gearGold", new ItemStack(ItemRegistry.metaResourceGear, 1, 3));
		OreDictionary.registerOre("gearQuartz", new ItemStack(ItemRegistry.metaResourceGear, 1, 4));
		OreDictionary.registerOre("gearDiamond", new ItemStack(ItemRegistry.metaResourceGear, 1, 5));
		OreDictionary.registerOre("gearCopper", new ItemStack(ItemRegistry.metaResourceGear, 1, 6));
		OreDictionary.registerOre("gearTin", new ItemStack(ItemRegistry.metaResourceGear, 1, 7));
		OreDictionary.registerOre("gearLead", new ItemStack(ItemRegistry.metaResourceGear, 1, 8));
		OreDictionary.registerOre("gearSilver", new ItemStack(ItemRegistry.metaResourceGear, 1, 9));
	}
}