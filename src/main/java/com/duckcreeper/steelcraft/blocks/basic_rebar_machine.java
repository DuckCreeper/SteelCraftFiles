package com.duckcreeper.steelcraft.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;

import com.duckcreeper.steelcraft.tileentity.SCTileEntity;

public class basic_rebar_machine extends BlockContainer{

	public basic_rebar_machine(Material materialIn) {
		super(materialIn);
	}
	
	@Override
	public int getRenderType() {
		return 3;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}
	
    public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	SCTileEntity tileEntity = (SCTileEntity) par1World.getTileEntity(null);
        return tileEntity.onBlockActivated(par1World, x, y, z, par5EntityPlayer);
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new SCTileEntity();
	}

}
