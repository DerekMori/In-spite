package io.github.Nitralow.inspite.main;

import java.util.Random;

import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TeleporterSpite extends Teleporter {
	
	private final WorldServer  worldServerInsteance;
	private final Random random;

	public TeleporterSpite(WorldServer par1WorldServer) {
		super(par1WorldServer);
		
		this.worldServerInsteance = par1WorldServer;
		this.random = new Random(par1WorldServer.getSeed());
	}

}
