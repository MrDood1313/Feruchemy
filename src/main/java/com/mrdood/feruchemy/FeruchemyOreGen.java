package com.mrdood.feruchemy;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class FeruchemyOreGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int cX, int cZ, World world, IChunkProvider chunkGen,IChunkProvider chunkProv) {
		generateOre(ModBlocks.bismuth_ore,world,random,cX,cZ,6,10,8,5,50,Blocks.stone);
		generateOre(ModBlocks.cadmium_ore,world,random,cX,cZ,4,8,6,0,30,Blocks.stone);
		generateOre(ModBlocks.copper_ore,world,random,cX,cZ,5,10,11,0,70,Blocks.stone);
		generateOre(ModBlocks.lead_ore,world,random,cX,cZ,3,6,7,10,35,Blocks.stone);
		generateOre(ModBlocks.silver_ore,world,random,cX,cZ,3,6,4,10,35,Blocks.stone); 
		generateOre(ModBlocks.tin_ore,world,random,cX,cZ,5,10,11,0,70,Blocks.stone);
	}

	public void generateOre(Block block, World world, Random random, int cX, int cZ, int minVeinSize, int maxVeinSize,int chance, int miny, int maxy, Block generateIn) {
		int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
		int heightRange = maxy - miny;
		WorldGenMinable gen = new WorldGenMinable(block, veinSize, generateIn);

		for (int i = 0; i < chance; i++) {
			int xRand = cX * 16 + random.nextInt(16);
			int yRand = random.nextInt(heightRange);
			int zRand = cZ * 16 + random.nextInt(16);

			gen.generate(world, random, xRand, yRand, zRand);
		}
	}
}
