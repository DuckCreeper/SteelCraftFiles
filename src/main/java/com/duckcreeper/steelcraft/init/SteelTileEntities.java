package com.duckcreeper.steelcraft.init;


import net.minecraftforge.fml.common.registry.GameRegistry;

import com.duckcreeper.steelcraft.tileentity.SCTileEntity;

public class SteelTileEntities 
{
	public static void register()
	{
		GameRegistry.registerTileEntity(SCTileEntity.class, "test_tile_entity");
	}

}
