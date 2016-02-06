package com.duckcreeper.steelcraft.gui;


import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.duckcreeper.steelcraft.gui.containers.ContainerSCTileEntity;

public class GuiSCTileEntity extends GuiContainer
{
	private static final ResourceLocation gui = new ResourceLocation("sc:textures/gui/basic_machine.png");
	
	 public GuiSCTileEntity(IInventory player, IInventory chest)
	    {
	        super(new ContainerSCTileEntity(player, chest, 184, 184));
	        this.allowUserInput = false;
	        xSize = 184;
	        ySize = 184;
	    }

//	@Override
//	protected void drawGuiContainerForegroundLayer(int par1, int par2)
//	{
//		this.fontRendererObj.drawString("Cabinet", (this.xSize / 2) - 44, 6, 4210752);
//		this.fontRendererObj.drawString("Inventory", 8, this.ySize - 94, 4210752);
//	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(gui);
		int x = (width - 184) / 2;
		int y = (height - 184) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, 184, 184);
	}
}
