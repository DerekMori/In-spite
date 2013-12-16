package io.github.Nitralow.inspite.main;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderSpite extends WorldProvider {

	public void registerWorldChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerHell(InspiteMnain.flowerseverywhere, 0.1F, 0.5F);
	    this.dimensionId = InspiteMnain.DID;
	}
	public IChunkProvider createChunkProvider(){
		return new ChunkproviderSpite(this.worldObj, this.worldObj.getSeed(), true);
	}
	
	
	public String getDimensionName() {
		return "Jolly Dimension";
	}

}
