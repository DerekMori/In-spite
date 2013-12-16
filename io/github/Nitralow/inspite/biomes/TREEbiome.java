package io.github.Nitralow.inspite.biomes;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class TREEbiome extends BiomeGenBase {

	public TREEbiome(int par1) {
		super(par1);
        
		this.theBiomeDecorator.treesPerChunk = 1000;
        this.theBiomeDecorator.flowersPerChunk = 1000;
        this.theBiomeDecorator.grassPerChunk = 1000;
        this.theBiomeDecorator.mushroomsPerChunk = 1000;
        this.theBiomeDecorator.bigMushroomsPerChunk = 1000;
        this.topBlock = (byte)Block.grass.blockID;
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGiantZombie.class, 8, 4, 8));
    }
}
