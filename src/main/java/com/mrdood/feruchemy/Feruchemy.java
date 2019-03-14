package com.mrdood.feruchemy;

import com.mrdood.feruchemy.items.BendalloyMind;
import com.mrdood.feruchemy.items.CadmiumMind;
import com.mrdood.feruchemy.items.CopperMind;
import com.mrdood.feruchemy.items.ElectrumMind;
import com.mrdood.feruchemy.items.GoldMind;
import com.mrdood.feruchemy.items.IronMind;
import com.mrdood.feruchemy.items.PewterMind;
import com.mrdood.feruchemy.items.SteelMind;
import com.mrdood.feruchemy.items.TinMind;
import com.mrdood.feruchemy.proxy.CommonProxy;
import com.mrdood.feruchemy.reference.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

@Mod(modid = Reference.MOD_ID,name=Reference.MOD_NAME,version=Reference.MOD_VERSION,acceptedMinecraftVersions=Reference.MC_VERSION,canBeDeactivated=true)
public class Feruchemy {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY,serverSide = Reference.SERVER_PROXY)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
		//item & block init/registration
		//config handling
		ModItems.steel_mind = new SteelMind("Speed",new PotionEffect(Potion.moveSlowdown.getId(),20,2), new PotionEffect(Potion.moveSpeed.getId(),20,2)).setUnlocalizedName("steel_mind").setCreativeTab(feruchemyMod).setTextureName("feruchemy:steel_mind");
		ModItems.iron_mind = new IronMind().setUnlocalizedName("iron_mind").setCreativeTab(feruchemyMod).setTextureName("feruchemy:iron_mind");
		ModItems.pewter_mind = new PewterMind("Strength",new PotionEffect(Potion.weakness.getId(),20,2), new PotionEffect(Potion.damageBoost.getId(),20,2)).setUnlocalizedName("pewter_mind").setCreativeTab(feruchemyMod).setTextureName("feruchemy:pewter_mind");
		ModItems.tin_mind = new TinMind("Sight",new PotionEffect(Potion.blindness.getId(),20,2), new PotionEffect(Potion.nightVision.getId(),300,2)).setUnlocalizedName("tin_mind").setCreativeTab(feruchemyMod).setTextureName("feruchemy:tin_mind");
		ModItems.copper_mind = new CopperMind().setUnlocalizedName("copper_mind").setCreativeTab(feruchemyMod).setTextureName("feruchemy:copper_mind");
		ModItems.electrum_mind = new ElectrumMind("Determination",new PotionEffect(Potion.digSlowdown.getId(),20,2), new PotionEffect(Potion.digSpeed.getId(),20,2)).setUnlocalizedName("electrum_mind").setCreativeTab(feruchemyMod).setTextureName("feruchemy:electrum_mind");
		ModItems.cadmium_mind = new CadmiumMind().setUnlocalizedName("cadmium_mind").setCreativeTab(feruchemyMod).setTextureName("feruchemy:cadmium_mind");
		ModItems.bendalloy_mind = new BendalloyMind().setUnlocalizedName("bendalloy_mind").setCreativeTab(feruchemyMod).setTextureName("feruchemy:bendalloy_mind");
		ModItems.gold_mind = new GoldMind("Health",new PotionEffect(Potion.poison.getId(),20,5),new PotionEffect(Potion.confusion.getId(),100,0), new PotionEffect(Potion.regeneration.getId(),20,5),10).setUnlocalizedName("gold_mind").setCreativeTab(feruchemyMod).setTextureName("feruchemy:gold_mind");
		
		ModItems.bendalloy_ingot = new Item().setUnlocalizedName("bendalloy_ingot").setCreativeTab(feruchemyMod).setTextureName("feruchemy:bendalloy_ingot");
		ModItems.bismuth_ingot = new Item().setUnlocalizedName("bismuth_ingot").setCreativeTab(feruchemyMod).setTextureName("feruchemy:bismuth_ingot");
		ModItems.cadmium_ingot = new Item().setUnlocalizedName("cadmium_ingot").setCreativeTab(feruchemyMod).setTextureName("feruchemy:cadmium_ingot");
		ModItems.copper_ingot = new Item().setUnlocalizedName("copper_ingot").setCreativeTab(feruchemyMod).setTextureName("feruchemy:copper_ingot");
		ModItems.electrum_ingot = new Item().setUnlocalizedName("electrum_ingot").setCreativeTab(feruchemyMod).setTextureName("feruchemy:electrum_ingot");
		ModItems.lead_ingot = new Item().setUnlocalizedName("lead_ingot").setCreativeTab(feruchemyMod).setTextureName("feruchemy:lead_ingot");
		ModItems.pewter_ingot = new Item().setUnlocalizedName("pewter_ingot").setCreativeTab(feruchemyMod).setTextureName("feruchemy:pewter_ingot");
		ModItems.silver_ingot = new Item().setUnlocalizedName("silver_ingot").setCreativeTab(feruchemyMod).setTextureName("feruchemy:silver_ingot");
		ModItems.steel_ingot = new Item().setUnlocalizedName("steel_ingot").setCreativeTab(feruchemyMod).setTextureName("feruchemy:steel_ingot");
		ModItems.tin_ingot = new Item().setUnlocalizedName("tin_ingot").setCreativeTab(feruchemyMod).setTextureName("feruchemy:tin_ingot");
		ModItems.tab_icon = new Item().setUnlocalizedName("icon").setTextureName("feruchemy:copper_mind");
		
		ModItems.bendalloy_lump = new Item().setUnlocalizedName("bendalloy_lump").setCreativeTab(feruchemyMod).setTextureName("feruchemy:bendalloy_lump");
		ModItems.electrum_lump = new Item().setUnlocalizedName("electrum_lump").setCreativeTab(feruchemyMod).setTextureName("feruchemy:electrum_lump");
		ModItems.pewter_lump = new Item().setUnlocalizedName("pewter_lump").setCreativeTab(feruchemyMod).setTextureName("feruchemy:pewter_lump");
		ModItems.steel_lump = new Item().setUnlocalizedName("steel_lump").setCreativeTab(feruchemyMod).setTextureName("feruchemy:steel_lump");
		ModItems.softened_bismuth = new Item().setUnlocalizedName("softened_bismuth").setCreativeTab(feruchemyMod).setTextureName("feruchemy:softened_bismuth");
		ModItems.softened_cadmium = new Item().setUnlocalizedName("softened_cadmium").setCreativeTab(feruchemyMod).setTextureName("feruchemy:softened_cadmium");
		ModItems.softened_gold = new Item().setUnlocalizedName("softened_gold").setCreativeTab(feruchemyMod).setTextureName("feruchemy:softened_gold");
		ModItems.softened_lead = new Item().setUnlocalizedName("softened_lead").setCreativeTab(feruchemyMod).setTextureName("feruchemy:softened_lead");
		ModItems.softened_silver = new Item().setUnlocalizedName("softened_silver").setCreativeTab(feruchemyMod).setTextureName("feruchemy:softened_silver");
		ModItems.softened_tin = new Item().setUnlocalizedName("softened_tin").setCreativeTab(feruchemyMod).setTextureName("feruchemy:softened_tin");
		ModItems.softened_iron = new Item().setUnlocalizedName("softened_iron").setCreativeTab(feruchemyMod).setTextureName("feruchemy:softened_iron");
		
		ModBlocks.bismuth_ore = new ModBlock(Material.rock,"bismuth_ore",3.0F,15.0F,1).setBlockTextureName("feruchemy:bismuth_ore");
		ModBlocks.cadmium_ore = new ModBlock(Material.rock,"cadmium_ore",3.0F,15.0F,1).setBlockTextureName("feruchemy:cadmium_ore");
		ModBlocks.copper_ore = new ModBlock(Material.rock,"copper_ore",3.0F,15.0F,0).setBlockTextureName("feruchemy:copper_ore");
		ModBlocks.lead_ore = new ModBlock(Material.rock,"lead_ore",5.0F,25.0F,2).setBlockTextureName("feruchemy:lead_ore");
		ModBlocks.silver_ore = new ModBlock(Material.rock,"silver_ore",5.0F,25.0F,2).setBlockTextureName("feruchemy:silver_ore");
		ModBlocks.tin_ore = new ModBlock(Material.rock,"tin_ore",3.0F,15.0F,0).setBlockTextureName("feruchemy:tin_ore");
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		//proxy, tileentity, gui, packet registering
		ItemRegistration.registerItems();
		ModCraftingManager.registerCrafting();
		GameRegistry.registerWorldGenerator(new FeruchemyOreGen(), 0);
		
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
	public static CreativeTabs feruchemyMod = new CreativeTabs("feruchemyMod"){
		@Override
		public Item getTabIconItem(){
			return new ItemStack(ModItems.tab_icon).getItem();
		}
	};
	
}
