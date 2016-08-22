package com.aleios.sandboxmod.init;

import com.aleios.sandboxmod.reference.Names;
import com.aleios.sandboxmod.tileentity.TileEntityFishery;
import com.aleios.sandboxmod.tileentity.TileEntityInfiniteGenerator;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities 
{
	public static void init()
	{
		GameRegistry.registerTileEntity(TileEntityInfiniteGenerator.class, Names.TileEntities.TILE_IFINITEGENERATOR);
		GameRegistry.registerTileEntity(TileEntityFishery.class, Names.TileEntities.TILE_FISHERY);
	}
}
