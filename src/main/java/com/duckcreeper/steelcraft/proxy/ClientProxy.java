package com.duckcreeper.steelcraft.proxy;

import com.duckcreeper.steelcraft.init.SteelCraftBlocks;
import com.duckcreeper.steelcraft.init.SteelCraftItems;


public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders()
	{
		SteelCraftItems.registerRenders();
		SteelCraftBlocks.registerRenders();
	}
}
