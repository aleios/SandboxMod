package com.aleios.sandboxmod.gui;

import com.aleios.sandboxmod.inventory.ContainerPortableCrafter;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiPortableCrafter extends GuiContainer
{
	
	ResourceLocation guiTex = new ResourceLocation("textures/gui/container/crafting_table.png");

	public GuiPortableCrafter(InventoryPlayer playerInv, World world, int x, int y, int z) {
		super(new ContainerPortableCrafter(playerInv, world, x, y, z));
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		mc.getTextureManager().bindTexture(guiTex);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
