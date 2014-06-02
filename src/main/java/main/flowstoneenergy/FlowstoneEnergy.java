package main.flowstoneenergy;

import main.flowstoneenergy.blocks.BlockRecipeRegistry;
import main.flowstoneenergy.blocks.BlockRegistry;
import main.flowstoneenergy.blocks.fluids.BucketRegistry;
import main.flowstoneenergy.blocks.fluids.FluidRecipeRegistry;
import main.flowstoneenergy.enchants.EnchantRandTeleHandler;
import main.flowstoneenergy.enchants.EnchantRegistry;
import main.flowstoneenergy.entities.FEEntityRegistry;
import main.flowstoneenergy.gui.CreativeTab;
import main.flowstoneenergy.gui.GuiHandler;
import main.flowstoneenergy.items.ItemRecipeRegistry;
import main.flowstoneenergy.items.ItemRegistry;
import main.flowstoneenergy.proxies.CommonProxy;
import main.flowstoneenergy.tileentities.TERegistry;
import main.flowstoneenergy.utils.BucketHandler;
import main.flowstoneenergy.utils.CapeEventHandler;
import main.flowstoneenergy.utils.GenerationHandler;
import main.flowstoneenergy.utils.OreDictHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class FlowstoneEnergy {
    public static CreativeTabs tab = new CreativeTab("FlowstoneEnergy");
    @Instance
    public static FlowstoneEnergy instance;
    Configuration config;

    @SidedProxy(clientSide = "main.flowstoneenergy.proxies.ClientProxy", serverSide = "main.flowstoneenergy.proxies.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());
        ConfigHandler.configOptions(config);

        MinecraftForge.EVENT_BUS.register(new EnchantRandTeleHandler());
        MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
        EnchantRegistry.registerEnchants();

        BlockRegistry.registerBlocks();
        ItemRegistry.registerItems();
        FluidRecipeRegistry.registerFluidRecipes();
        TERegistry.registerTileEntities();
        BucketRegistry.registerBucket();

        OreDictHandler.registerOreDict();
        GameRegistry.registerWorldGenerator(new GenerationHandler(), 2);
        NetworkRegistry.INSTANCE.registerGuiHandler(FlowstoneEnergy.instance, new GuiHandler());

        proxy.load();
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        if (event.getSide() == Side.CLIENT && ConfigHandler.capesOn) {
            MinecraftForge.EVENT_BUS.register(new CapeEventHandler());
        }
        FEEntityRegistry.init();
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        ItemRecipeRegistry.registerFullRecipes();
        BlockRecipeRegistry.registerFullRecipes();
    }
}
