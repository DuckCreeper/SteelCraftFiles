package com.duckcreeper.steelcraft.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler 
{
	public static Configuration config;
	
	public static final String CATEGORY_RECIPE_SETTINGS = "recipe-settings";
	public static final String CATEGORY_API = "recipe-api";
	public static final String CATEGORY_SETTINGS = "settings";
	
	public static String[] items = {};
	public static boolean canDisplay = true;

	public static void init(File file)
	{
		if (config == null)
		{
			config = new Configuration(file);
			loadConfig(false);
		}
	}
	
	public static void loadConfig(boolean shouldChange)
	{

		canDisplay = config.getBoolean("welcome_message", CATEGORY_SETTINGS, canDisplay, "Enabled or disable the welcome message");
		items = config.getStringList("custom-recipes", CATEGORY_API, items, "Insert custom recipes here");
		config.addCustomCategoryComment(CATEGORY_RECIPE_SETTINGS, "Enabled or disable the default recipes");
		config.addCustomCategoryComment(CATEGORY_API, "RecipeAPI Configuration. How to use: http://mrcrayfishs-furniture-mod.wikia.com/wiki/Configuration");
		updateEnabledRecipes();

		if (config.hasChanged() && shouldChange)
		{
			
		}
		config.save();
	}
	
	private static void updateEnabledRecipes()
	{
		
	}
}
