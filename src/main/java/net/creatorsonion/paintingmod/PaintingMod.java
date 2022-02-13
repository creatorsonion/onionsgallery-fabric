package net.creatorsonion.paintingmod;

import com.google.common.reflect.Reflection;
import net.creatorsonion.paintingmod.entity.PMEntityRegistry;
import net.creatorsonion.paintingmod.entity.decoration.painting.PMPaintingMotive;
import net.creatorsonion.paintingmod.inventory.PMItemGroupRegistry;
import net.creatorsonion.paintingmod.item.PMItemRegistry;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaintingMod implements ModInitializer {
    public static final String MOD_ID   = "paintingmod";
    public static final String MOD_NAME = "Painting Mod";

	public static final String[] MOTIVES = {"fate", "glare", "tentacles", "bold_and_brash",
		"paradoxical", "forgotten_nostalgia", "melon", "fantasy_of_pearce",
		"ramen_and_rice", "poker_night", "steven", "ravenous",
		"portal_sunset", "explorer", "jebie"};

    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@SuppressWarnings("UnstableApiUsage")
	@Override
	public void onInitialize() {
		LOGGER.info("Initializing {}", MOD_NAME);

		// TODO: Use a loop for these
		Reflection.initialize(PMPaintingMotive.class);
		Reflection.initialize(PMItemGroupRegistry.class);
		Reflection.initialize(PMItemRegistry.class);
		Reflection.initialize(PMEntityRegistry.class);

		LOGGER.info("Initialized {}", MOD_NAME);
	}
}
