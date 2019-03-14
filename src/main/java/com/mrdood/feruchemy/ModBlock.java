package com.mrdood.feruchemy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlock extends Block{

	protected ModBlock(Material arg0,String name,float hardness,float resist,int harvestLevel) {
		super(arg0);
		this.setCreativeTab(Feruchemy.feruchemyMod);
		this.setHardness(hardness);
		this.setBlockName(name);
		this.setResistance(resist);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", harvestLevel);
		// TODO Auto-generated constructor stub
	}

}
