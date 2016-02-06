package com.duckcreeper.steelcraft.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.duckcreeper.steelcraft.Reference;
import com.duckcreeper.steelcraft.SteelMain;
import com.duckcreeper.steelcraft.blocks.BlockCraft;
import com.duckcreeper.steelcraft.blocks.basic_rebar_machine;
import com.duckcreeper.steelcraft.blocks.rebar;
import com.duckcreeper.steelcraft.blocks.rebar_maker;
import com.duckcreeper.steelcraft.tileentity.SCTileEntity;

public class SteelCraftBlocks {
	
	public static Block block_turbine;
	public static Block furnace;
	public static Block concrete;
	public static Block rebar;
	public static Block rebar_maker;
	public static Block rebar_maker_table;
	public static Block rebar_maker_base;
	public static Block basic_rebar_machine;
	
	public static void init()
	{
		block_turbine = new BlockCraft(Material.iron).setUnlocalizedName("block_turbine").setCreativeTab(SteelMain.tabSteel);
		concrete = new BlockCraft(Material.ground).setUnlocalizedName("concrete").setCreativeTab(SteelMain.tabSteel);
		furnace = new BlockCraft(Material.ground).setUnlocalizedName("furnace").setCreativeTab(SteelMain.tabSteel);
		rebar = new rebar(Material.ground).setUnlocalizedName("rebar").setCreativeTab(SteelMain.tabSteel);
		basic_rebar_machine = new basic_rebar_machine(Material.ground).setUnlocalizedName("basic_rebar_machine").setCreativeTab(SteelMain.tabSteel);
		
		rebar_maker_table = new rebar_maker().setUnlocalizedName("rebar_maker_table").setCreativeTab(SteelMain.tabSteel);
		rebar_maker_base = new rebar_maker().setUnlocalizedName("rebar_maker_base").setCreativeTab(SteelMain.tabSteel);
		

	}


	public static void register()
	{
		GameRegistry.registerBlock(block_turbine, block_turbine.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(furnace, furnace.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(concrete, concrete.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(rebar, rebar.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(rebar_maker_table, rebar_maker_table.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(rebar_maker_base, rebar_maker_base.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(basic_rebar_machine, basic_rebar_machine.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		registerRender(block_turbine);
		registerRender(furnace);
		registerRender(concrete);
		registerRender(rebar);
		registerRender(rebar_maker_base);
		registerRender(rebar_maker_table);
		registerRender(basic_rebar_machine);
		
		
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
