package com.mrdood.feruchemy;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ItemRegistration {
	public static void registerItems(){
		GameRegistry.registerItem(ModItems.steel_mind, "steel_mind");
		GameRegistry.registerItem(ModItems.iron_mind, "iron_mind");
		GameRegistry.registerItem(ModItems.tin_mind, "tin_mind");
		GameRegistry.registerItem(ModItems.pewter_mind, "pewter_mind");
		
		GameRegistry.registerItem(ModItems.bendalloy_mind, "bendalloy_mind");
		GameRegistry.registerItem(ModItems.cadmium_mind, "cadmium_mind");
		GameRegistry.registerItem(ModItems.copper_mind, "copper_mind");
		GameRegistry.registerItem(ModItems.electrum_mind, "electrum_mind");
		GameRegistry.registerItem(ModItems.gold_mind, "gold_mind");
		
		GameRegistry.registerItem(ModItems.bendalloy_ingot, "bendalloy_ingot");
		GameRegistry.registerItem(ModItems.bismuth_ingot, "bismuth_ingot");
		GameRegistry.registerItem(ModItems.cadmium_ingot, "cadmium_ingot");
		GameRegistry.registerItem(ModItems.copper_ingot, "copper_ingot");
		GameRegistry.registerItem(ModItems.electrum_ingot, "electrum_ingot");
		GameRegistry.registerItem(ModItems.lead_ingot, "lead_ingot");
		GameRegistry.registerItem(ModItems.pewter_ingot, "pewter_ingot");
		GameRegistry.registerItem(ModItems.silver_ingot, "silver_ingot");
		GameRegistry.registerItem(ModItems.steel_ingot, "steel_ingot");
		GameRegistry.registerItem(ModItems.tin_ingot, "tin_ingot");
		
		GameRegistry.registerItem(ModItems.bendalloy_lump, "bendalloy_lump");
		GameRegistry.registerItem(ModItems.electrum_lump, "electrum_lump");
		GameRegistry.registerItem(ModItems.pewter_lump, "pewter_lump");
		GameRegistry.registerItem(ModItems.steel_lump,"steel_lump");
		GameRegistry.registerItem(ModItems.softened_bismuth, "softened_bismuth");
		GameRegistry.registerItem(ModItems.softened_cadmium, "softened_cadmium");
		GameRegistry.registerItem(ModItems.softened_gold, "softened_gold");
		GameRegistry.registerItem(ModItems.softened_lead, "softened_lead");
		GameRegistry.registerItem(ModItems.softened_silver, "softened_silver");
		GameRegistry.registerItem(ModItems.softened_tin, "softened_tin");
		GameRegistry.registerItem(ModItems.softened_iron, "softened_iron");
		GameRegistry.registerItem(ModItems.tab_icon,"tab_icon");
		
		GameRegistry.registerBlock(ModBlocks.copper_ore, "copper_ore");
		GameRegistry.registerBlock(ModBlocks.bismuth_ore, "bismuth_ore");
		GameRegistry.registerBlock(ModBlocks.cadmium_ore, "cadmium_ore");
		GameRegistry.registerBlock(ModBlocks.lead_ore, "lead_ore");
		GameRegistry.registerBlock(ModBlocks.silver_ore, "silver_ore");
		GameRegistry.registerBlock(ModBlocks.tin_ore, "tin_ore");
		
		OreDictionary.registerOre("oreBismuth", new ItemStack(ModBlocks.bismuth_ore));
		OreDictionary.registerOre("oreCadmium", new ItemStack(ModBlocks.cadmium_ore));
		OreDictionary.registerOre("oreCopper", new ItemStack(ModBlocks.copper_ore));
		OreDictionary.registerOre("oreLead", new ItemStack(ModBlocks.lead_ore));
		OreDictionary.registerOre("oreSilver", new ItemStack(ModBlocks.silver_ore));
		OreDictionary.registerOre("oreTin", new ItemStack(ModBlocks.tin_ore));
		
		OreDictionary.registerOre("ingotBendalloy", new ItemStack(ModItems.bendalloy_ingot));
		OreDictionary.registerOre("ingotBismuth", new ItemStack(ModItems.bismuth_ingot));
		OreDictionary.registerOre("ingotCadmium", new ItemStack(ModItems.cadmium_ingot));
		OreDictionary.registerOre("ingotCopper", new ItemStack(ModItems.copper_ingot));
		OreDictionary.registerOre("ingotElectrum", new ItemStack(ModItems.electrum_ingot));
		OreDictionary.registerOre("ingotLead", new ItemStack(ModItems.lead_ingot));
		OreDictionary.registerOre("ingotPewter", new ItemStack(ModItems.pewter_ingot));
		OreDictionary.registerOre("ingotSilver", new ItemStack(ModItems.silver_ingot));
		OreDictionary.registerOre("ingotSteel", new ItemStack(ModItems.steel_ingot));
		OreDictionary.registerOre("ingotTin", new ItemStack(ModItems.tin_ingot));
	}
}
