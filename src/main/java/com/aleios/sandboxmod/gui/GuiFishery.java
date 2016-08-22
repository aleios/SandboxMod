package com.aleios.sandboxmod.gui;

import com.aleios.sandboxmod.inventory.ContainerFishery;
import com.aleios.sandboxmod.tileentity.TileEntityFishery;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;

public class GuiFishery extends GuiSandboxMod {

	public GuiFishery(InventoryPlayer playerInv, TileEntityFishery te) {
		super(new ContainerFishery(playerInv, te), "fisheryGui", te);
	}

}
