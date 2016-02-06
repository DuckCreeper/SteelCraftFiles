package com.duckcreeper.steelcraft.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.duckcreeper.steelcraft.init.SteelCraftBlocks;
import com.duckcreeper.steelcraft.init.SteelCraftItems;

public class rebar_maker extends BlockSC  {

	
	public rebar_maker() {
        super(Material.cloth);

		
	}
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
	{
		if(this == SteelCraftBlocks.rebar_maker_table)
		{
			worldIn.destroyBlock(pos.north(), false);
		}
		else
		{
			worldIn.destroyBlock(pos.south(), false);
		}
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		return worldIn.isAirBlock(pos) && worldIn.isAirBlock(pos.up());
	}
	
	@Override
	public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) 
	{
		if(this == SteelCraftBlocks.rebar_maker_table)
		{
			world.setBlockState(pos.north(), SteelCraftBlocks.rebar_maker_base.getDefaultState().withProperty(FACING, placer.getHorizontalFacing()));
		}
		return super.onBlockPlaced(world, pos, facing, hitX, hitY, hitZ, meta, placer);
	}
	
	
	
	
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return SteelCraftItems.itemrebar1;
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos)
	{
		return new ItemStack(SteelCraftItems.itemrebar1);
	}
}

