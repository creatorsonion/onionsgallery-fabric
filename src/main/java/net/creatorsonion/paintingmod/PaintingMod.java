package net.creatorsonion.paintingmod;

import com.google.common.reflect.Reflection;
import net.creatorsonion.paintingmod.entity.decoration.painting.PMPaintingMotive;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaintingMod implements ModInitializer {
    public static final String MOD_ID   = "paintingmod";
    public static final String MOD_NAME = "Painting Mod";

    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@SuppressWarnings("UnstableApiUsage")
	@Override
	public void onInitialize() {
		LOGGER.info("Initializing {}", MOD_NAME);

		Reflection.initialize(PMPaintingMotive.class);

		LOGGER.info("Initialized {}", MOD_NAME);
	}
}
