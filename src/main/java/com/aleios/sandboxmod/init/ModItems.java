package com.aleios.sandboxmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import com.aleios.item.ItemPortableCrafter;
import com.aleios.sandboxmod.reference.Names;

public class ModItems
{
	
	public static final Item itemPortableCrafter = new ItemPortableCrafter();
	
	public static void init()
	{
		GameRegistry.registerItem(itemPortableCrafter, Names.Items.ITEM_PORTABLECRAFTER);
	}
}
