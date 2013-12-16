package io.github.Nitralow.inspite.main;

import cpw.mods.fml.common.network.Player;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

public class Portal extends BlockPortal {

	public Portal(int par1) {
		super(par1);
		
		final int DID = 5;
	}
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if(entity.ridingEntity == null && entity.riddenByEntity == null && entity instanceof EntityPlayerMP){
			EntityPlayerMP player = (EntityPlayerMP) entity;
			ModLoader.getMinecraftServerInstance();
			MinecraftServer server = MinecraftServer.getServer();
			
			if(player.timeUntilPortal > 0){
				player.timeUntilPortal = 10;
			}else if(player.dimension != InspiteMnain.DID){
				player.timeUntilPortal = 10;
				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, InspiteMnain.DID, new TeleporterSpite(server.worldServerForDimension(InspiteMnain.DID)));
			}else{
				player.timeUntilPortal = 10;
				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterSpite(server.worldServerForDimension(0)));
	
			}
		}
	}
	public boolean tryToCreatePortal(World par1World, int par2, int par3, int par4)
    {
        byte b0 = 0;
        byte b1 = 0;

        if (par1World.getBlockId(par2 - 1, par3, par4) == InspiteMnain.Frame.blockID || par1World.getBlockId(par2 + 1, par3, par4) == InspiteMnain.Frame.blockID)
        {
            b0 = 1;
        }

        if (par1World.getBlockId(par2, par3, par4 - 1) == InspiteMnain.Frame.blockID || par1World.getBlockId(par2, par3, par4 + 1) == InspiteMnain.Frame.blockID)
        {
            b1 = 1;
        }

        if (b0 == b1)
        {
            return false;
        }
        else
        {
            if (par1World.isAirBlock(par2 - b0, par3, par4 - b1))
            {
                par2 -= b0;
                par4 -= b1;
            }

            int l;
            int i1;

            for (l = -1; l <= 2; ++l)
            {
                for (i1 = -1; i1 <= 3; ++i1)
                {
                    boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;

                    if (l != -1 && l != 2 || i1 != -1 && i1 != 3)
                    {
                        int j1 = par1World.getBlockId(par2 + b0 * l, par3 + i1, par4 + b1 * l);
                        boolean isAirBlock = par1World.isAirBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l);

                        if (flag)
                        {
                            if (j1 != InspiteMnain.Frame.blockID)
                            {
                                return false;
                            }
                          }
                        }
                }
            }
            return true;
        }
    }
	 public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5){
		 
	 }
}
