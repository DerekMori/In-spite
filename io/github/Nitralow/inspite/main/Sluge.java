package io.github.Nitralow.inspite.main;

import io.github.Nitralow.inspite.main.*;  

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class Sluge extends BlockFlower implements IPlantable {

	public Sluge(int id) {
		super(id, Material.grass);
		setHardness(0.2F)
		.setStepSound(soundGrassFootstep)
		.setTextureName(InspiteMnain.modid + ":" + "sluge");
		setLightOpacity(3);
		setLightValue(3);
	
	}
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Item.slimeBall.itemID;
    }
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.setInWeb();
   
    }
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    public int getRenderType()
    {
        return 1;
    }

}
