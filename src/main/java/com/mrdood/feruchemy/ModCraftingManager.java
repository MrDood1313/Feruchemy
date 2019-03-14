package com.mrdood.feruchemy;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModCraftingManager {
	public static void registerCrafting(){
		
		//mind recipies
		String[] ingots = {"ingotBendalloy","ingotCadmium","ingotCopper","ingotElectrum","ingotGold","ingotIron","ingotPewter","ingotSteel","ingotTin"};
		Item[] mindList = {ModItems.bendalloy_mind,ModItems.cadmium_mind,ModItems.copper_mind,ModItems.electrum_mind,ModItems.gold_mind,ModItems.iron_mind,ModItems.pewter_mind,ModItems.steel_mind,ModItems.tin_mind};
		for(int i=0;i<ingots.length;i++){
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mindList[i],1,0),
					" x ",
					"x x",
					" x ",
					'x',ingots[i]
			));
		}
		
		//special ingot recipes
		
		//bendalloy lump
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bendalloy_lump,8), new Object[]{
				ModItems.softened_bismuth,
				ModItems.softened_bismuth,
				ModItems.softened_bismuth,
				ModItems.softened_bismuth,
				ModItems.softened_lead,
				ModItems.softened_lead,
				ModItems.softened_tin,
				ModItems.softened_cadmium
		});
		
		//electrum lump
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.electrum_lump,2), new Object[]{
				ModItems.softened_gold,
				ModItems.softened_silver
		});
		
		//pewter lump
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pewter_lump,9), new Object[]{
				ModItems.softened_lead,
				ModItems.softened_tin,
				ModItems.softened_tin,
				ModItems.softened_tin,
				ModItems.softened_tin,
				ModItems.softened_tin,
				ModItems.softened_tin,
				ModItems.softened_tin,
				ModItems.softened_tin,
		});
		
		//steel lump
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.steel_lump,1), new Object[]{
				ModItems.softened_iron,
				Items.coal,
				Items.coal
		});
		
		//softened ingots (smelting)
		Item[] sIngot = {ModItems.softened_tin,ModItems.softened_lead,ModItems.softened_bismuth,ModItems.softened_silver,ModItems.softened_cadmium,ModItems.softened_gold,ModItems.softened_iron}; 
		String[] vIngot = {"ingotTin","ingotLead","ingotBismuth","ingotSilver","ingotCadmium","ingotGold","ingotIron"};
		Item[] aIngot = {ModItems.tin_ingot,ModItems.lead_ingot,ModItems.bismuth_ingot,ModItems.silver_ingot,ModItems.cadmium_ingot,Items.gold_ingot,Items.iron_ingot};
		for(int i=0;i<sIngot.length;i++){
			GameRegistry.addSmelting(OreDictionary.getOres(vIngot[i]).get(0), new ItemStack(sIngot[i]), 10.0F);
			GameRegistry.addShapelessRecipe(new ItemStack(aIngot[i]), new Object[]{
					sIngot[i],
					Items.snowball
			});
		}
		
		
		
		GameRegistry.addSmelting(new ItemStack(ModItems.bendalloy_lump), new ItemStack(ModItems.bendalloy_ingot), 30.0F);
		GameRegistry.addSmelting(new ItemStack(ModItems.electrum_lump), new ItemStack(ModItems.electrum_ingot), 30.0F);
		GameRegistry.addSmelting(new ItemStack(ModItems.pewter_lump), new ItemStack(ModItems.pewter_ingot), 30.0F);
		GameRegistry.addSmelting(new ItemStack(ModItems.steel_lump), new ItemStack(ModItems.steel_ingot), 30.0F);
		
		//Block Smelting
		Block[] ores = {ModBlocks.bismuth_ore,ModBlocks.cadmium_ore,ModBlocks.copper_ore,ModBlocks.lead_ore,ModBlocks.silver_ore,ModBlocks.tin_ore};
		Item[] oIngot = {ModItems.bismuth_ingot,ModItems.cadmium_ingot,ModItems.copper_ingot,ModItems.lead_ingot,ModItems.silver_ingot,ModItems.tin_ingot};
		
		for(int i=0;i<ores.length;i++){
			GameRegistry.addSmelting(new ItemStack(ores[i]), new ItemStack(oIngot[i]), 50.0F);
		}
	}
}
