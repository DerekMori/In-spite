package io.github.Nitralow.inspite.main;

import io.github.Nitralow.inspite.Proxies.CommonProxy;
import io.github.Nitralow.inspite.Proxies.ConfigHandler;
import io.github.Nitralow.inspite.biomes.Flatplains;
import io.github.Nitralow.inspite.biomes.FlowerForest;
import io.github.Nitralow.inspite.biomes.TREEbiome;
import io.github.Nitralow.inspite.biomes.Under;
import io.github.Nitralow.inspite.blocks.March;
import io.github.Nitralow.inspite.blocks.Pants;
import io.github.Nitralow.inspite.blocks.marchTileentity;
import io.github.Nitralow.inspite.renderer.RenderPants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
//import cpw.mods.fml.common.Mod.Init;
//import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import io.github.Nitralow.inspite.main.IDs;
import io.github.Nitralow.inspite.main.Names;

@Mod(modid = "spite", name = "In-Spite", version = "0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class InspiteMnain {
	
	@Instance(value = "spite")
	public static InspiteMnain instance; 
	public static final String modid = "spite";
	public static final int DID = IDs.DID; 
	
	//Enum
	//public static EnumToolMaterial THis = EnumHelper.addToolMaterial("", harvestLevel, maxUses, efficiency, damage, enchantability)
	public static EnumArmorMaterial Paper = EnumHelper.addArmorMaterial("Paper", 126, new int[]{2, 5, 4, 1}, 1);
	
	//Creative tabs
    public static final CreativeTabs In_spiteBlocks = new Spitetab(12, "Spite Blocks");
    public static final CreativeTabs In_spiteItems = new SpitetabI(13, "Spite Items");

    //Create Items
    public static Item PaperHelmet;
    public static Item PaperChestplate;
    public static Item PaperLeggings;
    public static Item PaperBoots;
    public static Item MagicCandycane;
    
	//Create blocks
	public static Block pants;
	public static Block marchmellow;
	public static Block Portal;
	public static Block Frame;
	public static Block Fudge;
	public static Block Sluge;
	
	//Create Biomes
	public static BiomeGenBase Underthere;
	public static BiomeGenBase TREESSS;
	public static BiomeGenBase Flatplains;
	public static BiomeGenBase lumberjackdream;
	public static BiomeGenBase flowerseverywhere;
	
	@SidedProxy(clientSide="io.github.Nitralow.inspite.Proxies.ClientProxy",
	serverSide="io.github.Nitralow.inspite.Proxies.CommonProxy")
    public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit ( FMLPreInitializationEvent event ) {
	ConfigHandler.init(event.getSuggestedConfigurationFile());
	}{

    //block props
	pants = new Pants(IDs.Pants).setUnlocalizedName("Pants").setCreativeTab(this.In_spiteBlocks);
	marchmellow = new March(IDs.Marchmellow).setCreativeTab(this.In_spiteBlocks);
	Frame = new Frame(IDs.Frame).setCreativeTab(this.In_spiteBlocks).setUnlocalizedName("Frame");
	Portal = new Portal(IDs.Portal).setCreativeTab(this.In_spiteBlocks).setUnlocalizedName("Portal");
	Fudge = new Fudge(IDs.Fudge).setCreativeTab(this.In_spiteBlocks).setUnlocalizedName("fudge");
	Sluge = new Sluge(IDs.Sluge).setCreativeTab(this.In_spiteBlocks).setUnlocalizedName("Sluge");
	
	//Biomes props
	Underthere = new Under(70).setColor(5470985).setBiomeName("Underther").func_76733_a(13786898).setTemperatureRainfall(1.2F, 0.9F).setMinMaxHeight(0.2F, 0.4F);
	TREESSS = new TREEbiome(71).setColor(5470985).setBiomeName("TREE biome").func_76733_a(13786898).setTemperatureRainfall(1.2F, 0.9F).setMinMaxHeight(0.2F, 0.4F);
	Flatplains = new Flatplains(72).setColor(5470985).setBiomeName("Flat plains").func_76733_a(13786898).setTemperatureRainfall(2.2F, 0.9F).setMinMaxHeight(0.0F, 0.0F);
	lumberjackdream = new LJD(73).setColor(5470985).setBiomeName("Lumber Jack Dream").func_76733_a(13786898).setTemperatureRainfall(1.2F, 0.9F).setMinMaxHeight(0.2F, 0.4F);
	flowerseverywhere = new FlowerForest(74).setColor(5470985).setBiomeName("Flower Every where").func_76733_a(13786898).setTemperatureRainfall(1.2F, 0.9F).setMinMaxHeight(0.2F, 0.4F);
	

	//Item props
	PaperHelmet = new PaperH(IDs.PaperHelmet, Paper, 0).setCreativeTab(this.In_spiteItems).setUnlocalizedName("PaperH").setTextureName(InspiteMnain.modid + ":" + "WIP");
	PaperChestplate = new PaperC(IDs.PaperChestplate, Paper, 1).setCreativeTab(this.In_spiteItems).setUnlocalizedName("PaperC").setTextureName(InspiteMnain.modid + ":" + "WIP");
	PaperLeggings = new PaperL(IDs.PaperLeggings, Paper, 2).setCreativeTab(this.In_spiteItems).setUnlocalizedName("PaperL").setTextureName(InspiteMnain.modid + ":" + "WIP");
	PaperBoots = new PaperB(IDs.PaperBoots, Paper, 3).setCreativeTab(this.In_spiteItems).setUnlocalizedName("PaperB").setTextureName(InspiteMnain.modid + ":" + "WIP");
	MagicCandycane = new MagicCandycane(IDs.MagicCandycane).setCreativeTab(this.In_spiteItems).setUnlocalizedName("MagicCC");
	
	
	}
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenderers();
		proxy.registerTickHandler();

		
		//rendering 
		 GameRegistry.registerTileEntity(pantsTileentity.class, "Pants");
         ClientRegistry.bindTileEntitySpecialRenderer(pantsTileentity.class, new RenderPants());
        
		 GameRegistry.registerTileEntity(marchTileentity.class, "Marchmellow");
         ClientRegistry.bindTileEntitySpecialRenderer(marchTileentity.class, new Rendermarch());
        

	}

	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		
		//registering panta
		GameRegistry.registerBlock(pants, Names.Insite_pants);
		LanguageRegistry.addName(pants, Names.Insite_pants);
        GameRegistry.addRecipe(new ItemStack(pants, 4), new Object[]{"444", "4X4", "4X4", Character.valueOf('4'), new ItemStack(Item.leather, 1), Character.valueOf('X'), new ItemStack(Item.silk, 1) });

		
		GameRegistry.registerBlock(Frame, Names.Insite_Frame);
		LanguageRegistry.addName(Frame, Names.Insite_Frame);
		
        GameRegistry.addRecipe(new ItemStack(Frame, 4), new Object[]{"XXX", "444", "XXX", Character.valueOf('4'), new ItemStack(Block.obsidian, 1), Character.valueOf('X'), new ItemStack(Block.wood, 1) });
		
		GameRegistry.registerBlock(Portal, Names.Insite_portal);
		LanguageRegistry.addName(Portal, Names.Insite_portal);

		GameRegistry.addRecipe(new ItemStack(Portal, 4), new Object[]{"XXX", "444", "XXX", Character.valueOf('4'), new ItemStack(Frame, 1),});

		
	     //registering marchmellows
		 GameRegistry.registerBlock(marchmellow, Names.Insite_Marchmellow);
         LanguageRegistry.addName(marchmellow, Names.Insite_Marchmellow);
         
         GameRegistry.registerBlock(Sluge, Names.Insite_Sluge);
         LanguageRegistry.addName(Sluge, Names.Insite_Sluge);
         GameRegistry.addRecipe(new ItemStack(Sluge, 4), new Object[]{"XXX", "444", "XXX", Character.valueOf('4'), new ItemStack(Item.slimeBall, 1), Character.valueOf('X'), new ItemStack(Item.silk, 1) });

         
         GameRegistry.addRecipe(new ItemStack(marchmellow, 1), new Object[]{"XXX", "444", "XXX", Character.valueOf('4'), new ItemStack(Item.sugar, 1), });
         GameRegistry.addSmelting(Item.sugar.itemID, new ItemStack(marchmellow), 1.0f);
		
         //registering biomes
         GameRegistry.addBiome(Flatplains);
         GameRegistry.addBiome(TREESSS);
         GameRegistry.addBiome(Underthere);
         GameRegistry.addBiome(flowerseverywhere);
         GameRegistry.addBiome(lumberjackdream);
         
         //registering items
         LanguageRegistry.addName(PaperHelmet, Names.PaperHelmet);
         LanguageRegistry.addName(PaperChestplate, Names.PaperChestplate);
         LanguageRegistry.addName(PaperLeggings, Names.PaperLeggings);
         LanguageRegistry.addName(PaperBoots, Names.PaperBoots);
         
         //registerign Dimensions
         DimensionManager.registerProviderType(DID, WorldProviderSpite.class, false);
         DimensionManager.registerDimension(DID, DID);

	}

}
