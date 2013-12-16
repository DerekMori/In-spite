package io.github.Nitralow.inspite.main;

import io.github.Nitralow.inspite.renderer.PantsModel;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class Rendermarch extends TileEntitySpecialRenderer {

	private static final ResourceLocation textre = new ResourceLocation(InspiteMnain.modid, "textures/models/Marchmellow.png");   
	
	private marchModel model;
	
	public Rendermarch(){
		this.model = new marchModel(); 
	}
	
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);		
		this.bindTexture(textre);
		GL11.glPushMatrix();
		this.model.renderModel(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
