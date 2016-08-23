package com.aleios.item;

import com.aleios.sandboxmod.GuiHandler;
import com.aleios.sandboxmod.SandboxMod;
import com.aleios.sandboxmod.reference.Names;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPortableCrafter extends ItemSandboxMod
{
	public ItemPortableCrafter()
	{
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setUnlocalizedName(Names.Items.ITEM_PORTABLECRAFTER);
	}
	
	@Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if(world.isRemote)
        {
        	return player.getCurrentEquippedItem();
        }
        else
        {
        	player.openGui(SandboxMod.getMod(), GuiHandler.GuiIDs.PORTABLECRAFTER.ordinal(), world, 0, 0, 0);
        	return player.getCurrentEquippedItem();
        }
    }
}
