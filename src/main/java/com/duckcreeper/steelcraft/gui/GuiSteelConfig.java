package com.duckcreeper.steelcraft.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;

import com.duckcreeper.steelcraft.handler.ConfigurationHandler;

public class GuiSteelConfig extends GuiConfig
{
		public GuiSteelConfig(GuiScreen parent)
		{
			super(parent, new ConfigElement(ConfigurationHandler.config.getCategory(ConfigurationHandler.CATEGORY_SETTINGS)).getChildElements(), "sc", false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.config.toString()));
		}
	}

