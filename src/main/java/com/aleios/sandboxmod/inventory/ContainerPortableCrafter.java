package com.aleios.sandboxmod.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

public class ContainerPortableCrafter extends net.minecraft.inventory.ContainerWorkbench {

	public ContainerPortableCrafter(InventoryPlayer playerInv, World world, int x, int y, int z)
	{
		super(playerInv, world, x, y, z);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		// TODO Auto-generated method stub
		return true;
	}

}
