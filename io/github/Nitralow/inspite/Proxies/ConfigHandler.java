package io.github.Nitralow.inspite.Proxies;

import io.github.Nitralow.inspite.main.IDs;
import io.github.Nitralow.inspite.main.Names;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {
public static void init(File configFile) {
Configuration config = new Configuration(configFile);

config.load();

IDs.Sluge_actual = config.getBlock(Names.Insite_Sluge, IDs.Sluge).getInt();
IDs.Fudge_actual = config.getBlock(Names.Insite_Fudge, IDs.Fudge).getInt();
IDs.InspiteDimensionID_actual = config.getBlock(Names.Dimenstion, IDs.DID).getInt();
IDs.Frame_actual = config.getBlock(Names.Insite_Frame, IDs.Frame).getInt();
IDs.Pants_actual = config.getBlock(Names.Insite_pants, IDs.Pants).getInt();
IDs.Marchmellow_actual = config.getBlock(Names.Insite_Marchmellow, IDs.Marchmellow).getInt();

IDs.InspiteHelmet_actual = config.getItem(Names.PaperHelmet, IDs.PaperHelmet).getInt() - 256;
IDs.InspiteChestplate_actual = config.getItem(Names.PaperChestplate, IDs.PaperChestplate).getInt() - 256;
IDs.InspiteLeggings_actual = config.getItem(Names.PaperLeggings, IDs.PaperLeggings).getInt() - 256;
IDs.InspiteBoots_actual = config.getItem(Names.PaperBoots, IDs.PaperBoots).getInt() - 256;
IDs.InspiteMagicCnadycane_actual = config.getItem(Names.MagicCandycane, IDs.MagicCandycane).getInt() - 256;

config.save();
}
}