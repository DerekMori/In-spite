package io.github.Nitralow.inspite.biomes;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class Under extends BiomeGenBase {
	public Under(int par1) {
		super(par1);

	        this.theBiomeDecorator.treesPerChunk = -100;
	        this.theBiomeDecorator.flowersPerChunk = -100;
	        this.theBiomeDecorator.grassPerChunk = -100;
	        this.theBiomeDecorator.mushroomsPerChunk = -100;
	        this.theBiomeDecorator.bigMushroomsPerChunk = -100;
	        this.topBlock = (byte)Block.cobblestone.blockID;
	        this.spawnableCreatureList.add(new SpawnListEntry(EntityGiantZombie.class, 8, 4, 8));
	    }
	}
