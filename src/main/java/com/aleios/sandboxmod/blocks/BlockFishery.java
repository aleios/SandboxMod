package com.aleios.sandboxmod.blocks;

import com.aleios.sandboxmod.tileentity.TileEntityFishery;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFishery extends BlockSandboxModTileEntity {

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileEntityFishery();
	}

}
