package io.github.Nitralow.inspite.blocks;

import java.util.List;

import io.github.Nitralow.inspite.main.InspiteMnain;
import io.github.Nitralow.inspite.main.pantsTileentity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Pants extends BlockContainer {
	
	public Pants(int id) {
	 super(id, Material.rock);

	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new pantsTileentity();
	}
	
	@SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister icon) {
		this.blockIcon = icon.registerIcon(InspiteMnain.modid + ":" + "Pants");		
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