package main.flowstoneenergy.items.tools.electrum;

import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import net.minecraft.item.ItemAxe;

public class ItemAxeElectrum extends ItemAxe {
	public ItemAxeElectrum(ToolMaterial material) {
		super(material);
		this.setCreativeTab(FlowstoneEnergy.tab);
		this.setUnlocalizedName(ModInfo.MODID + ".electrum.axe");
		this.setTextureName(ModInfo.MODID + ":tools/electrumAxe");
	}
}
