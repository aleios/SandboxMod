package com.aleios.sandboxmod.blocks;

import com.aleios.sandboxmod.GuiHandler;
import com.aleios.sandboxmod.SandboxMod;
import com.aleios.sandboxmod.tileentity.TileEntityFishery;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFishery extends BlockSandboxModTileEntity {

	public BlockFishery()
	{
		setBlockName("Fishery");
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileEntityFishery();
	}
	
	
	@Override 
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote && !player.isSneaking())
		{
			player.openGui(SandboxMod.getMod(), GuiHandler.GuiIDs.FISHERY.ordinal(), world, x, y, z);
		}
		return true;
	}

}
