package com.aleios.sandboxmod.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotFishery extends Slot {

	public SlotFishery(IInventory inventory, int inventoryIndex, int x, int y) {
		super(inventory, inventoryIndex, x, y);
		// TODO Auto-generated constructor stub
	}
	
    @Override
    public boolean isItemValid(ItemStack stack){
        return inventory.isItemValidForSlot(getSlotIndex(), stack);
    }

}
