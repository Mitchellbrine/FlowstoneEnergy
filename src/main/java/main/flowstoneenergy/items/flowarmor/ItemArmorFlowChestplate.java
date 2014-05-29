package main.flowstoneenergy.items.flowarmor;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import net.minecraft.item.ItemArmor;

public class ItemArmorFlowChestplate extends ItemArmor {

    public ItemArmorFlowChestplate(ArmorMaterial material, int renderIndex, int armorType) {
        super(material, renderIndex, armorType);
	    this.setCreativeTab(FlowstoneEnergy.tab);
        this.setUnlocalizedName(ModInfo.MODID + ".flow.chestplate");
        this.setTextureName(ModInfo.MODID + ":armor/flowChestplate");
    }
}