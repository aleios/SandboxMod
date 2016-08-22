package com.aleios.sandboxmod;

import com.aleios.sandboxmod.gui.GuiFishery;
import com.aleios.sandboxmod.inventory.ContainerFishery;
import com.aleios.sandboxmod.tileentity.TileEntityFishery;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

	public enum GuiIDs
	{
		FISHERY
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		switch(GuiIDs.values()[ID])
		{
		case FISHERY:
			return new ContainerFishery(player.inventory, (TileEntityFishery)world.getTileEntity(x, y, z));
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
		}
		throw new IllegalArgumentException("Could not find a GUI with ID: " + ID);
	}

}
