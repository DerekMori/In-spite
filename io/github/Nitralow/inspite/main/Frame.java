package io.github.Nitralow.inspite.main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Frame extends Block {

	public Frame(int par1) {
		super(par1, Material.rock);
	
	setLightOpacity(8);
	setLightValue(9);
	setStepSound(soundSnowFootstep);
	}

}
