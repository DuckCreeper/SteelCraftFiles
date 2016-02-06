package com.duckcreeper.steelcraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.duckcreeper.steelcraft.init.SteelCraftItems;

public class SteelTab extends CreativeTabs{

	public SteelTab(String label) {
		super(label);
		this.setBackgroundImageName("steel.png");

	}

	@Override
	public Item getTabIconItem() {
		return SteelCraftItems.steel_ingot;
	}

}
