package com.aleios.sandboxmod.gui;

import com.aleios.sandboxmod.reference.Reference;
import com.aleios.sandboxmod.utility.Log;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public abstract class GuiSandboxMod extends GuiContainer {

	private final ResourceLocation guiTex;
	private final IInventory inventory;
	
	public GuiSandboxMod(Container container, String guiTexture, IInventory inventory) {
		// TODO Auto-generated constructor stub
		super(container);
		
		guiTex = new ResourceLocation(Reference.MOD_LOWER_ID + ":textures/gui/" + guiTexture + ".png" );
		this.inventory = inventory;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		// TODO Auto-generated method stub
		mc.getTextureManager().bindTexture(guiTex);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
