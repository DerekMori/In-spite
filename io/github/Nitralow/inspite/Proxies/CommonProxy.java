package io.github.Nitralow.inspite.Proxies;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {
		
        public void registerRenderers() {
        	
        }
        public void registerTickHandler() {
        	TickRegistry.registerTickHandler(new InspiteTickHandler(), Side.SERVER);
        }
        public int addArmor(String armor) {
        	return RenderingRegistry.addNewArmourRendererPrefix(armor);
        }
}