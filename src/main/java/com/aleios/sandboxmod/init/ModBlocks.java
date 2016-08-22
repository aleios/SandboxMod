package com.aleios.sandboxmod.init;

import com.aleios.sandboxmod.blocks.BlockFishery;
import com.aleios.sandboxmod.blocks.BlockInfiniteGenerator;
import com.aleios.sandboxmod.reference.Names;
import com.aleios.sandboxmod.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
	
	public static final Block blockInfiniteGenerator = new BlockInfiniteGenerator();
	public static final Block blockFishery = new BlockFishery();
	
	public static void init()
	{
		GameRegistry.registerBlock(blockInfiniteGenerator, Names.Blocks.BLOCK_INFINITEGENERATOR);
		GameRegistry.registerBlock(blockFishery, Names.Blocks.BLOCK_FISHERY);
	}
}
