package io.github.Nitralow.inspite.Proxies;

import io.github.Nitralow.inspite.main.InspiteMnain;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class InspiteTickHandler implements ITickHandler {

	    public void onPlayerTick(EntityPlayer player) {
		if (player.getCurrentItemOrArmor(4) != null){
			ItemStack helmet = player.getCurrentItemOrArmor(4);
			
			if (helmet.getItem() == InspiteMnain.PaperHelmet) {
				player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 40 , 2));			
				
			}
		}
		if (player.getCurrentItemOrArmor(3) != null){
			ItemStack chestplate = player.getCurrentItemOrArmor(3);
			
			if (chestplate.getItem() == InspiteMnain.PaperChestplate) {
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.getId(), 40 , 3));			
				
			}
		}
		if (player.getCurrentItemOrArmor(2) != null){
			ItemStack leggins = player.getCurrentItemOrArmor(2);
			
			if (leggins.getItem() == InspiteMnain.PaperLeggings) {
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 40 , 2));			
				
			}
			if (player.getCurrentItemOrArmor(1) != null){
				ItemStack boots = player.getCurrentItemOrArmor(1);
				
		    if (boots.getItem() == InspiteMnain.PaperBoots) {
		    	player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 40, 4));
		    	player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 40, 4));

		    }
			}
		}
		}
	

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}
}