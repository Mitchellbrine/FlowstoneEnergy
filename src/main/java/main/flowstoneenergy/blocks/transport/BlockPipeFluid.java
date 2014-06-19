package main.flowstoneenergy.blocks.transport;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.flowstoneenergy.FlowstoneEnergy;
import main.flowstoneenergy.ModInfo;
import main.flowstoneenergy.blocks.machines.BlockMachineBox;
import main.flowstoneenergy.tileentities.transport.TileEntityItemPipe;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Millsy on 16/06/14.
 */
public class BlockPipeFluid extends BlockMachineBox {

    public BlockPipeFluid() {
        this.setLightOpacity(0);
        this.setBlockName(ModInfo.MODID + ".fluid.pipe");
        this.setBlockTextureName(ModInfo.MODID + ":transport/fluidPipe");
        this.setHardness(7);
        this.setCreativeTab(FlowstoneEnergy.blockTab);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.blockIcon = icon.registerIcon(ModInfo.MODID + ":machines/machine_Side");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int var2) {
        return new TileEntityItemPipe();
    }
}