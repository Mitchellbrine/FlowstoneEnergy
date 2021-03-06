package main.flowstoneenergy.containers;

import main.flowstoneenergy.tileentities.machines.TileEntityMachineAutoCraftingTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;

public class ContainerMachineAutoCraftingTable extends Container {
    public ContainerMachineAutoCraftingTable(EntityPlayer player, TileEntityMachineAutoCraftingTable entity) {
        bindPlayerInventory(player.inventory);
        createSlots(entity, player);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.isUseableByPlayer(player);
    }

    private boolean isUseableByPlayer(EntityPlayer player) {
        return true;
    }

    private void createSlots(TileEntityMachineAutoCraftingTable tile, EntityPlayer player) {
        addSlotToContainer(new Slot(tile, 0, 31, 12));
        addSlotToContainer(new Slot(tile, 1, 49, 12));
        addSlotToContainer(new Slot(tile, 2, 67, 12));
        addSlotToContainer(new Slot(tile, 3, 31, 30));
        addSlotToContainer(new Slot(tile, 4, 49, 30));
        addSlotToContainer(new Slot(tile, 5, 67, 30));
        addSlotToContainer(new Slot(tile, 6, 31, 48));
        addSlotToContainer(new Slot(tile, 7, 49, 48));
        addSlotToContainer(new Slot(tile, 8, 67, 48));
        addSlotToContainer(new Slot(tile, 9, 122, 35));
    }

    private void bindPlayerInventory(InventoryPlayer inv) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(inv, i, 8 + i * 18, 142));
        }
    }

    @Override
    protected boolean mergeItemStack(ItemStack par1ItemStack, int par2, int par3, boolean par4) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 0) {
                if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (par2 >= 10 && par2 < 37) {
                if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
                    return null;
                }
            } else if (par2 >= 37 && par2 < 46) {
                if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack) null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }

}
