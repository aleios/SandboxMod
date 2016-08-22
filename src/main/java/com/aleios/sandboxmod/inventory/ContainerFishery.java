package com.aleios.sandboxmod.inventory;

import com.aleios.sandboxmod.tileentity.TileEntityFishery;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class ContainerFishery extends ContainerSandboxMod 
{
	private final TileEntityFishery te;
	
	public ContainerFishery(InventoryPlayer playerInv, TileEntityFishery te)
	{
		addSlotToContainer(new SlotFishery(te, 0, 80, 40));
		
		addPlayerSlots(playerInv, 8, 84);
		this.te = te;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		// TODO Auto-generated method stub
		return te.isUseableByPlayer(player);
	}
	
	@Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex){
        ItemStack itemstack = null;
        Slot slot = (Slot)inventorySlots.get(slotIndex);

        if(slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            //From here change accordingly...
            if(slotIndex == 0)
            {
	            if(!mergeItemStack(itemstack1, 1, 37, true)) {
	                return null;
	            }
            }
            else
            {
            	return null;
            }

            if(itemstack1.stackSize == 0) {
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }

            if(itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
}
