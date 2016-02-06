package com.duckcreeper.steelcraft;


import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.duckcreeper.steelcraft.gui.SCGuiHandler;
import com.duckcreeper.steelcraft.init.SteelAchievements;
import com.duckcreeper.steelcraft.init.SteelCraftBlocks;
import com.duckcreeper.steelcraft.init.SteelCraftItems;
import com.duckcreeper.steelcraft.init.SteelTileEntities;
import com.duckcreeper.steelcraft.proxy.CommonProxy;
import com.duckcreeper.steelcraft.tileentity.SCTileEntities;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERISION)
public class SteelMain {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final SteelTab tabSteel = new SteelTab("tabSteel");
	
    public static SteelMain instance = new SteelMain();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		SteelCraftBlocks.init();
		SteelCraftBlocks.register();
		SteelCraftItems.init();
		SteelCraftItems.register();	
		
		/** Achievement Registering */
		SteelAchievements.loadAchievements();
		SteelAchievements.registerPage();
		
		/** Tile Entites*/
		SCTileEntities.register();
	
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerRenders();
		GameRegistry.addRecipe(new ItemStack(SteelCraftBlocks.block_turbine, 4),
			"SIS", 
            "IBI",
            "SIS", 'I', Items.iron_ingot, 'S', SteelCraftItems.steel_ingot, 'B', new ItemStack(Items.dye, 1, 15) ); 
		
		GameRegistry.addRecipe(new ItemStack(SteelCraftItems.duck_bill_float),
			"SIR",
			"SIS",
			" S ", 'S', SteelCraftItems.steel_ingot, 'I', Items.iron_ingot, 'R', new ItemStack(Items.dye, 1, 1) );
		
		/** GUI Registering*/
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new SCGuiHandler());
		
		/** TileEntity Registering */
		SteelTileEntities.register();

	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}

}
