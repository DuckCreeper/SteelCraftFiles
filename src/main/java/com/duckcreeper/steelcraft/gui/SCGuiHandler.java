package com.duckcreeper.steelcraft.gui;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.duckcreeper.steelcraft.gui.containers.ContainerSCTileEntity;
import com.duckcreeper.steelcraft.tileentity.SCTileEntity;

public class SCGuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getTileEntity(new BlockPos(x, y, z));
		if (tile_entity instanceof SCTileEntity)
		{
			return new ContainerSCTileEntity(player.inventory, (SCTileEntity) tile_entity, x, y);
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getTileEntity(new BlockPos(x, y, z));
		if (tile_entity instanceof SCTileEntity)
		{
			return new GuiSCTileEntity(player.inventory, (SCTileEntity) tile_entity);
		}
		
		return null;
	}
	
}