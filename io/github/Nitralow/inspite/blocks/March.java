package io.github.Nitralow.inspite.blocks;

import java.util.List;

import io.github.Nitralow.inspite.main.InspiteMnain;
import io.github.Nitralow.inspite.main.pantsTileentity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class March extends BlockContainer {
	
	public March(int id) {
		 super(id, Material.rock);

		setHardness(2.0F);
setResistance(10.0F);
setLightValue(0.0F);
setUnlocalizedName("Thing");
setTextureName(InspiteMnain.modid + ":" + "March");
setStepSound(Block.soundGravelFootstep);
setLightOpacity(0);
setCreativeTab(CreativeTabs.tabBlock);
setBlockBounds(0.0F,0.0F,0.0F,1.0F,1.5F,1.0F);
MinecraftForge.setBlockHarvestLevel(this, "spade", 0);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new marchTileentity();
	}
	
	@SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister icon) {
		this.blockIcon = icon.registerIcon(InspiteMnain.modid + ":" + "WIP");		
	}

	@SideOnly(Side.CLIENT)
	public void addinformation(ItemStack itemsatck, EntityPlayer player, List datalist, boolean boul){
		datalist.add("Mmmmm...");
		datalist.add("Marchmellow");
		datalist.add(player.experienceLevel);
	}
	
	public int getRenderType(){
		return -1;
	}
	public boolean isOpaqueCude(){
		return false;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}
	
}