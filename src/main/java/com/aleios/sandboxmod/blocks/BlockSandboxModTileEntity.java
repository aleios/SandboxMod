package com.aleios.sandboxmod.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class BlockSandboxModTileEntity extends BlockContainer 
{

	public BlockSandboxModTileEntity()
	{
		super(Material.rock);
	}
	
	public BlockSandboxModTileEntity(Material material) 
	{
		super(material);
	}
}
