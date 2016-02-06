package com.duckcreeper.steelcraft.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class SCTileEntities {
	
	public static void register(){
		GameRegistry.registerTileEntity(SCTileEntity.class, "sctest");
	}

}
