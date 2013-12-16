package io.github.Nitralow.inspite.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PantsModel extends ModelBase
{
  //fields
    ModelRenderer Pant_Leg1_;
    ModelRenderer Pant_Leg2;
    ModelRenderer gount;
    ModelRenderer upperpice;
  
  public PantsModel()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Pant_Leg1_ = new ModelRenderer(this, 17, 17);
      Pant_Leg1_.addBox(0F, 0F, 0F, 4, 12, 4);
      Pant_Leg1_.setRotationPoint(2F, 24F, 2F);
      Pant_Leg1_.setTextureSize(64, 64);
      Pant_Leg1_.mirror = true;
      setRotation(Pant_Leg1_, 0F, 0F, 3.141593F);
      Pant_Leg2 = new ModelRenderer(this, 0, 17);
      Pant_Leg2.addBox(-4F, 0F, 0F, 4, 12, 4);
      Pant_Leg2.setRotationPoint(2F, 24F, -2F);
      Pant_Leg2.setTextureSize(64, 64);
      Pant_Leg2.mirror = true;
      setRotation(Pant_Leg2, 0F, 3.141593F, 3.141593F);
      gount = new ModelRenderer(this, 33, 0);
      gount.addBox(-2F, 0F, -2F, 4, 2, 4);
      gount.setRotationPoint(0F, 12F, 0F);
      gount.setTextureSize(64, 64);
      gount.mirror = true;
      setRotation(gount, 0F, 0F, 0F);
      upperpice = new ModelRenderer(this, 0, 0);
      upperpice.addBox(0F, 0F, 0F, 4, 3, 12);
      upperpice.setRotationPoint(2F, 12F, -6F);
      upperpice.setTextureSize(64, 64);
      upperpice.mirror = true;
      setRotation(upperpice, 0F, 0F, 3.141593F);
  }
	
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Pant_Leg1_.render(f5);
    Pant_Leg2.render(f5);
    gount.render(f5);
    upperpice.render(f5);
  }
  public void renderModel(float f) {
	    Pant_Leg1_.render(f);
	    Pant_Leg2.render(f);
	    gount.render(f);
	    upperpice.render(f);
	}
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
