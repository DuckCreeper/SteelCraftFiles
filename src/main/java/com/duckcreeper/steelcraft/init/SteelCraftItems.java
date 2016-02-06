package com.duckcreeper.steelcraft.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.duckcreeper.steelcraft.Reference;
import com.duckcreeper.steelcraft.SteelMain;
import com.duckcreeper.steelcraft.items.ItemPlacer;


public class SteelCraftItems {
	
	public static Item steel_ingot;
	public static Item duck_bill_float;
	public static Item itemrebar1;
	
	public static void init()
	{
		steel_ingot = new Item().setUnlocalizedName("steel_ingot").setCreativeTab(SteelMain.tabSteel);
		duck_bill_float = new Item().setUnlocalizedName("duck_bill_float").setCreativeTab(SteelMain.tabSteel);
		itemrebar1 = new ItemPlacer(SteelCraftBlocks.rebar_maker_table).setUnlocalizedName("itemrebar1");
		
	}
	
	public static void register()
	{
		GameRegistry.registerItem(steel_ingot, steel_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(duck_bill_float, duck_bill_float.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemrebar1, itemrebar1.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		registerRender(steel_ingot);
		registerRender(duck_bill_float);
		registerRender(itemrebar1);
	}
	
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
