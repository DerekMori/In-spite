package io.github.Nitralow.inspite.biomes;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class Flatplains extends BiomeGenBase {

	public Flatplains(int par1) {
		super(par1);
       
		this.theBiomeDecorator.treesPerChunk = -100;
        this.theBiomeDecorator.flowersPerChunk = -100;
        this.theBiomeDecorator.grassPerChunk = 1000;
        this.theBiomeDecorator.mushroomsPerChunk = -100;
        this.theBiomeDecorator.bigMushroomsPerChunk = -100;
        this.topBlock = (byte)Block.grass.blockID;
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGiantZombie.class, 8, 4, 8));
    }
}
