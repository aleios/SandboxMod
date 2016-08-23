package com.aleios.sandboxmod;

import com.aleios.item.ItemPortableCrafter;
import com.aleios.sandboxmod.gui.GuiFishery;
import com.aleios.sandboxmod.gui.GuiPortableCrafter;
import com.aleios.sandboxmod.init.ModItems;
import com.aleios.sandboxmod.inventory.ContainerFishery;
import com.aleios.sandboxmod.inventory.ContainerPortableCrafter;
import com.aleios.sandboxmod.tileentity.TileEntityFishery;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

	public enum GuiIDs
	{
		FISHERY,
		PORTABLECRAFTER
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		switch(GuiIDs.values()[ID])
		{
		case FISHERY:
			return new ContainerFishery(player.inventory, (TileEntityFishery)world.getTileEntity(x, y, z));
			
		case PORTABLECRAFTER:
		{
			ItemStack equippedItem = player.getCurrentEquippedItem();
			if(equippedItem != null && equippedItem.getItem() == ModItems.itemPortableCrafter)
			{
				return new ContainerPortableCrafter(player.inventory, world, x, y, z);
			}
			return null;
		}
		}
		throw new IllegalArgumentException("Could not find a GUI with ID: " + ID);
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		switch(GuiIDs.values()[ID])
		{
		case FISHERY:
			return new GuiFishery(player.inventory, (TileEntityFishery)world.getTileEntity(x, y, z));
		case PORTABLECRAFTER:
		{
			ItemStack equippedItem = player.getCurrentEquippedItem();
			if(equippedItem != null && equippedItem.getItem() == ModItems.itemPortableCrafter)
			{
				return new GuiPortableCrafter(player.inventory, world, x, y, z);
			}
			return null;
		}
		}
		throw new IllegalArgumentException("Could not find a GUI with ID: " + ID);
	}

}
