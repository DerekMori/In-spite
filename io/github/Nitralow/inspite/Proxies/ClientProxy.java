package io.github.Nitralow.inspite.Proxies;

import cpw.mods.fml.client.registry.RenderingRegistry;
import io.github.Nitralow.inspite.Proxies.*;

public class ClientProxy extends CommonProxy {
        
        @Override
        public void registerRenderers() {
                
        }
        @Override
        public int addArmor(String armor) {
        	return RenderingRegistry.addNewArmourRendererPrefix(armor);
        }
        
}
