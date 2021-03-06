package main.flowstoneenergy.blocks;

import main.flowstoneenergy.blocks.decorative.BlockAplite;
import main.flowstoneenergy.blocks.decorative.BlockStrongGlass;
import main.flowstoneenergy.blocks.decorative.BlockStrongGlassPane;
import main.flowstoneenergy.blocks.fluids.BlockFlowstone;
import main.flowstoneenergy.blocks.fluids.BlockFluidBlaze;
import main.flowstoneenergy.blocks.machines.BlockMachineBox;
import main.flowstoneenergy.blocks.machines.BlockMachineWorkbench;
import main.flowstoneenergy.blocks.machines.BlockMachines;
import main.flowstoneenergy.blocks.transport.BlockPipeFluid;
import main.flowstoneenergy.blocks.transport.BlockPipeItem;
import main.flowstoneenergy.blocks.upgrades.BlockUpgrades;
import main.flowstoneenergy.items.blocks.*;
import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegistry {

    //machines
    public static Block machineBox;
    public static Block machineWorkbench;
    public static Block machines;
    
    //decorative
    public static Block strongGlass;
    public static Block strongGlassPane;
    
    //other
    public static Block ingotStorage;
    public static Block aplite;
    public static Block upgrades;

    //pipes
    public static Block itemPipe;
    public static Block fluidPipe;

    //ores
    public static Block blockOres;
    
    //fluids
    public static Fluid flowstone;
    public static Block flowstoneBlock;
    public static Fluid fluidBlaze;
    public static Block fluidBlazeBlock;

    public static void registerBlocks() {
        //machines
        machineBox = new BlockMachineBox();
        GameRegistry.registerBlock(machineBox, machineBox.getUnlocalizedName());
        machineWorkbench = new BlockMachineWorkbench();
        GameRegistry.registerBlock(machineWorkbench, machineWorkbench.getUnlocalizedName());
        machines = new BlockMachines().setBlockName("blockMachines");
        GameRegistry.registerBlock(machines, ItemBlockMachines.class, "BlockMachines");
        
        //decorative
        strongGlass = new BlockStrongGlass();
        GameRegistry.registerBlock(strongGlass, strongGlass.getUnlocalizedName());
        strongGlassPane = new BlockStrongGlassPane();
        GameRegistry.registerBlock(strongGlassPane, strongGlassPane.getUnlocalizedName());

        //other
        ingotStorage = new BlockIngotStorage().setBlockName("blockIngotStorage");
        GameRegistry.registerBlock(ingotStorage, ItemBlockIngotStorage.class, "BlockIngotStorage");
        aplite = new BlockAplite().setBlockName("blockAplite");
        GameRegistry.registerBlock(aplite, ItemBlockAplite.class, "BlockAplite");
        upgrades = new BlockUpgrades().setBlockName("blockUpgrades");
        GameRegistry.registerBlock(upgrades, ItemBlockUpgrades.class, "BlockUpgrades");

        //items
        itemPipe = new BlockPipeItem();
        GameRegistry.registerBlock(itemPipe, itemPipe.getUnlocalizedName());
        fluidPipe = new BlockPipeFluid();
        GameRegistry.registerBlock(fluidPipe, fluidPipe.getUnlocalizedName());

        //ores
        blockOres = new BlockOres();
        GameRegistry.registerBlock(blockOres, ItemBlockOres.class, blockOres.getUnlocalizedName());
        
        //fluids
        flowstone = new Fluid("flowstone");
        FluidRegistry.registerFluid(flowstone);
        flowstoneBlock = new BlockFlowstone(flowstone);
        GameRegistry.registerBlock(flowstoneBlock, flowstoneBlock.getUnlocalizedName());
        flowstone.setUnlocalizedName(flowstoneBlock.getUnlocalizedName());

        fluidBlaze = new Fluid("fluidBlaze");
        FluidRegistry.registerFluid(fluidBlaze);
        fluidBlazeBlock = new BlockFluidBlaze(fluidBlaze);
        GameRegistry.registerBlock(fluidBlazeBlock, fluidBlazeBlock.getUnlocalizedName());
        fluidBlaze.setUnlocalizedName(fluidBlazeBlock.getUnlocalizedName());
    }
}
