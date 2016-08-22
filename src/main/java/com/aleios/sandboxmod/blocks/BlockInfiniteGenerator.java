package com.aleios.sandboxmod.blocks;

import com.aleios.sandboxmod.tileentity.TileEntityInfiniteGenerator;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockInfiniteGenerator extends BlockSandboxModTileEntity {

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileEntityInfiniteGenerator();
	}

}
