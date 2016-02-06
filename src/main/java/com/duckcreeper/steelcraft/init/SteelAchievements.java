package com.duckcreeper.steelcraft.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class SteelAchievements
{
	public static Achievement installMod;
//	public static Achievement EngineerTrainee;
	
	public static AchievementPage page;
	
	public static void loadAchievements()
	{
		installMod = new Achievement("achievement.sc_install", "sc_install", 0, 0, new ItemStack(SteelCraftItems.steel_ingot), null).setSpecial();
		installMod.registerStat();
		
//		EngineerTrainee = new Achievement("achievement.sc_trainee", "sc_trainee", 3, 0, new ItemStack(SteelCraftBlocks.steelOre), installMod).func_180788_c();
	
		page = new AchievementPage("SteelCraft", installMod);
	}
	
	public static void registerPage()
	{
		AchievementPage.registerAchievementPage(page);
	}

}
