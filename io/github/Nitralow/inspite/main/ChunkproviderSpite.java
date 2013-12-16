package io.github.Nitralow.inspite.main;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.MapGenScatteredFeature;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType;
import net.minecraftforge.event.terraingen.TerrainGen;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;
//import static net.minecraftforge.event.terraingen.PopulateChunkEvent.EventType;

public class ChunkproviderSpite implements IChunkProvider {

	private Random random;
	
	private World worldObj;
	
	private final boolean mapfeaturesEnabled;
	
	
	public NoiseGeneratorOctaves noiseGen1;
	public NoiseGeneratorOctaves noiseGen2;
	public NoiseGeneratorOctaves noiseGen3;
	public NoiseGeneratorOctaves noiseGen4;
	public NoiseGeneratorOctaves noiseGen5;
	public NoiseGeneratorOctaves noiseGen6;
	public NoiseGeneratorOctaves mobSpwnerNoise;
	
	public double[] noiseArray;
	private double[] Stonenoise = new double[256];
	private MapGenBase CaveGenerator = new MapGenCaves();
	private MapGenStronghold strongholdGenerator = new MapGenStronghold();
	private MapGenScatteredFeature ScatteredFeatureGenerator  = new MapGenScatteredFeature();
	private MapGenRavine RavinsGenerator = new MapGenRavine();
	private MapGenMineshaft MineshaftGenertaor = new MapGenMineshaft();
	private MapGenVillage VillageGenerator = new MapGenVillage();
	
	private BiomeGenBase[] BiomesforGeneration;
	
	public double[] noise1;
	public double[] noise2;
	public double[] noise3;
	public double[] noise4;
	public double[] noise5;
	public double[] noise6;
	
	public float[] parabolicField;
	public int[][] field = new int[32][32]; 
	{
	
   
        CaveGenerator = TerrainGen.getModdedMapGen(CaveGenerator, CAVE);
        strongholdGenerator = (MapGenStronghold) TerrainGen.getModdedMapGen(strongholdGenerator, STRONGHOLD);
        ScatteredFeatureGenerator  = (MapGenScatteredFeature) TerrainGen.getModdedMapGen(ScatteredFeatureGenerator, SCATTERED_FEATURE);
        RavinsGenerator = (MapGenRavine) TerrainGen.getModdedMapGen(RavinsGenerator, RAVINE);
        MineshaftGenertaor = (MapGenMineshaft) TerrainGen.getModdedMapGen(MineshaftGenertaor, MINESHAFT);
	    VillageGenerator = (MapGenVillage) TerrainGen.getModdedMapGen(VillageGenerator, VILLAGE);
	}
	
	public ChunkproviderSpite(World worldObj, long seed, boolean features) {
		this.worldObj = worldObj;
		this.mapfeaturesEnabled = features;
		this.random = new Random(seed);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.random, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.random, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.random, 8);
		this.noiseGen4 = new NoiseGeneratorOctaves(this.random, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.random, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.random, 16);
		this.mobSpwnerNoise = new NoiseGeneratorOctaves(this.random, 8);

		NoiseGeneratorOctaves[] noiseGens = {noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5, noiseGen6, mobSpwnerNoise};
		noiseGens = TerrainGen.getModdedNoiseGenerators(worldObj, random, noiseGens);
		
		this.noiseGen1 = noiseGens[0];
		this.noiseGen2 = noiseGens[1];
		this.noiseGen3 = noiseGens[2];
		this.noiseGen4 = noiseGens[3];
		this.noiseGen5 = noiseGens[4];
		this.noiseGen6 = noiseGens[5];
		this.mobSpwnerNoise = noiseGens[6];
	}
	

	@Override
	public boolean chunkExists(int i, int j) {

		return true;
	}

	@Override
	public Chunk provideChunk(int i, int j) {
		this.random.setSeed((long)i * 34187312L + (long)j * 132897987541L);
		
		byte[] bytearray = new byte[32768];
		
		this.generateTerrain(i, j, bytearray);
		this.BiomesforGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(BiomesforGeneration, i * 16, j * 16, 16, 16);
		this.replaceBlocksForBiome(i, j, bytearray, this.BiomesforGeneration);
		this.CaveGenerator.generate(this, this.worldObj, i, j, bytearray);
		this.RavinsGenerator.generate(this, this.worldObj, i, j, bytearray);
		
	     if(this.mapfeaturesEnabled){
	    	   this.MineshaftGenertaor.generate(this, this.worldObj, i, j, bytearray);
	    	   this.VillageGenerator.generate(this, this.worldObj, i, j, bytearray);
	    	   this.strongholdGenerator.generate(this, this.worldObj, i, j, bytearray);
	    	   this.ScatteredFeatureGenerator.generate(this, this.worldObj, i, j, bytearray);
		}
	     Chunk chunk = new Chunk(this.worldObj, bytearray, i, j);
	     byte[] byteArray2 = chunk.getBiomeArray();
	     
	     for(int k = 0; k < byteArray2.length; k++){
	         byteArray2[k] = (byte)this.BiomesforGeneration[k].biomeID;
	     }
	    chunk.generateSkylightMap();
	    return chunk;
	}

	public void replaceBlocksForBiome(int i, int j, byte[] bytearray,BiomeGenBase[] biomesforGeneration2) {
		ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, i, j, bytearray, BiomesforGeneration);
			MinecraftForge.EVENT_BUS.post(event);
		
		if(event.getResult()== Result.DENY)return;
		
		byte b = 63;
		double d = 0.03125D;
		this.Stonenoise = this.noiseGen4.generateNoiseOctaves(Stonenoise, i * 16, j * 16, 0, 16, 16, 1, d*2D, d*2D, d*2D);
			
		for(int x = 0; x < 16; x++){
			for(int z = 0; z<16; z++){
				BiomeGenBase biome = biomesforGeneration2[z + x*16];
				float temperature = biome.getFloatTemperature();
				int w = (int) (this.Stonenoise[z + x*16] / 3D + 3D + this.random.nextDouble() * 0.25D);
				int h = -1;
				byte b1 = biome.topBlock;
				byte b2 = biome.fillerBlock;	
				
				for(int k = 127; k >= 0; k--){
					int l = (z*16+x)*128+k;
					if(k <= 0 + this.random.nextInt(5)){
						bytearray[l] = (byte)Block.bedrock.blockID;
					}else{
						byte b3 = bytearray[1];
						if(b3 == 0){
							h = -1;
						}else if(b3 == Block.stone.blockID){
							if(j == -1){
								if(i <= 0){
									b1 = 0;
									b2 = (byte)Block.stone.blockID;
								}else if(k >= b -4 && k <= b + 1){
									b1 = biome.topBlock;
									b2 = biome.fillerBlock;		
								}
			                    if(k < b && b1 == 0){
			                    	if(temperature < 0.15F){
			                    		b1 = (byte)Block.ice.blockID;
			                    	}else{
			                    		b1 = (byte)Block.waterStill.blockID;

			                    	}
			                    	
			                    	j = i;
			                    	
			                    	if(k >= b-1){
			                    		bytearray[1] = b1;
			                    	}
			                    }else{
			                    	bytearray[1] = b2;
			                    }
							}else if(j > 0){
								j--;
								
								bytearray[1] = b2;
								
								if(j == 0 && b2 == Block.sand.blockID){
									j = this.random.nextInt(4);
									b2 = (byte)Block.sandStone.blockID;
								}
							}
									
						}
					}
				}
			}
		}
	}

	private void generateTerrain(int i, int j, byte[] bytearray) {
		byte b0 = 4;
	    byte b1 = 16;
	    byte b2 = 63;
	    byte b3 = 17;
	    
	    int k = b0 + 1;
	    int l = b0 + 1;
	    
	    this.BiomesforGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(BiomesforGeneration, i * 4 - 2, j * 4 -2, k + 5, l + 5);
	    this.noiseArray = this.initalizedNoiseField(/*TODO*/);
	    
	    for(int i1 = 0; i1 < b0; i1++){
	    	for(int j1 = 0; j1 < b0; j1++){
	    		for(int k1 = 0; k1 < b1; k1++){
	    			double d = 0.125D;
	    			double d1 = this.noiseArray[((i1 + 0) * 1 + j1 + 0) * b3 + k1 + 0];
	    			double d2 = this.noiseArray[((i1 + 0) * 1 + j1 + 1) * b3 + k1 + 0];
	    			double d3 = this.noiseArray[((i1 + 1) * 1 + j1 + 0) * b3 + k1 + 0];
	    			double d4 = this.noiseArray[((i1 + 1) * 1 + j1 + 1) * b3 + k1 + 0];
	    			double d5 = this.noiseArray[((i1 + 0) * 1 + j1 + 0) * b3 + k1 + 1] - d1 * d;
	    			double d6 = this.noiseArray[((i1 + 0) * 1 + j1 + 1) * b3 + k1 + 1] - d2 * d;
	    			double d7 = this.noiseArray[((i1 + 1) * 1 + j1 + 0) * b3 + k1 + 1] - d3 * d;
	    			double d8 = this.noiseArray[((i1 + 1) * 1 + j1 + 1) * b3 + k1 + 1] - d4 * d;

	    
	    		}
	    	}
	    }
	}

	private double[] initalizedNoiseField() {
		return null;
	}


	@Override
	public Chunk loadChunk(int i, int j) {
		return this.provideChunk(i, j);
	}

	@Override
	public void populate(IChunkProvider ichunkprovider, int i, int j) {
		BlockSand.fallInstantly = true;
		int k = i*16;
		int l = j*16;
		BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
		this.random.setSeed(this.worldObj.getSeed());
		long i1 = this.random.nextLong() / 2L * 2L + 1L;
		long j1 = this.random.nextLong() / 2L * 2L + 1L;
		this.random.setSeed((long)i*1l + (long)j*j1 ^ this.worldObj.getSeed());
		boolean flag = false;
		
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(ichunkprovider, worldObj, random, i, j, flag));
		
		if(mapfeaturesEnabled){
			this.MineshaftGenertaor.generateStructuresInChunk(this.worldObj, random, i, j);
			this.strongholdGenerator.generateStructuresInChunk(this.worldObj, random, i, j);
			this.ScatteredFeatureGenerator.generateStructuresInChunk(this.worldObj, random, i, j);
			flag = this.VillageGenerator.generateStructuresInChunk(this.worldObj, random, i, j);
		}
		int k1;
		int l1;
		int i2;
		
		if(biome != BiomeGenBase.frozenOcean && biome != BiomeGenBase.plains && !flag && this.random.nextInt(4) == 0 && TerrainGen.populate(ichunkprovider, this.worldObj, random, i, j, flag, EventType.LAKE)){
		    k1 = k + this.random.nextInt(16) + 8;
		    l1 = this.random.nextInt(this.random.nextInt(120) + 8);
		    i2 = l + this.random.nextInt(16) + 8;
		    (new WorldGenLakes(Block.waterStill.blockID)).generate(this.worldObj, this.random, k1, l1, i2);
		}
		
		if(TerrainGen.populate(ichunkprovider, worldObj, random, i, j, flag, EventType.LAVA) && !flag && this.random.nextInt(8)== 0){
		    k1 = k + this.random.nextInt(16) + 8;
		    l1 = this.random.nextInt(128);
		    i2 = l + this.random.nextInt(16) + 8;
		    if(11 < 63 || this.random.nextInt(10) == 0){
		    }
		    	(new WorldGenLakes(Block.lavaStill.blockID)).generate(this.worldObj, this.random, k1, l1, i2);
		}
		boolean doGen = TerrainGen.populate(ichunkprovider, worldObj, random, i, j, flag, EventType.DUNGEON);
		for(k1 = 0; doGen && k1 < 8; k1++){
			l1 = k + this.random.nextInt(16 + 16);
		    i2 = l + this.random.nextInt(56);
		    int j2 = l + this.random.nextInt(16) + 8;
		    if(11 < 63 || this.random.nextInt(10) == 0){
		    }
	    	(new WorldGenDungeons()).generate(this.worldObj, this.random, l1, i2, j2);
		}
		biome.decorate(worldObj, random, k, l);
		SpawnerAnimals.performWorldGenSpawning(worldObj, biome, k + 8, l + 8, 16, 16, random);
		
		k+=8;
		l+=8;
		
		doGen = TerrainGen.populate(ichunkprovider, worldObj, random, i, j, flag, EventType.ICE);
		for(k1 = 0; doGen && k1 < 16; k1++){
			for(l1 = 0; l1 < 16; l1++){
				i2 = this.worldObj.getPrecipitationHeight(k + k1, l + l1);
				
				if(this.worldObj.isBlockFreezable(k + k1, i2 - 1, l + l1)){
					this.worldObj.setBlock(k + k1, i2 - 1, l1 + 1, Block.ice.blockID, 0, 2);
				}
				if(this.worldObj.canSnowAt(k + k1, i2, l + l1)){
					this.worldObj.setBlock(k + k1, i2, l1 + 1, Block.snow.blockID, 0, 2);
				}
			}
		}
	    MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(ichunkprovider, worldObj, random, i, j, flag));
	    
	    BlockSand.fallInstantly = false;

		}

	@Override
	public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
		return true;
	}

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public boolean canSave() {
		return true;
	}

	@Override
	public String makeString() {
		return "RandomLevelSource";
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType enumcreaturetype, int i,int j, int k) {
		BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(i, k);
		return biome == null ? null :  (biome == BiomeGenBase.swampland && enumcreaturetype == EnumCreatureType.monster && this.ScatteredFeatureGenerator.hasStructureAt(i, j, k) ? this.ScatteredFeatureGenerator.getScatteredFeatureSpawnList() : biome.getSpawnableList(enumcreaturetype));
	}

	@Override
	public ChunkPosition findClosestStructure(World world, String s, int i,int j, int k) {
		return "Stronghold".equals(s) && this.strongholdGenerator != null ? this.strongholdGenerator.getNearestInstance(world, i, j, k): null;
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void recreateStructures(int i, int j) {
       if(this.mapfeaturesEnabled){
    	   this.MineshaftGenertaor.generate(this, this.worldObj, i, j, (byte[])null);
    	   this.VillageGenerator.generate(this, this.worldObj, i, j, (byte[])null);
    	   this.strongholdGenerator.generate(this, this.worldObj, i, j, (byte[])null);
    	   this.ScatteredFeatureGenerator.generate(this, this.worldObj, i, j, (byte[])null);
    	   
       }
	}

	@Override
	public void saveExtraData() {
        
	}

}
