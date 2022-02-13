package net.creatorsonion.paintingmod;

import com.google.common.reflect.Reflection;
import net.creatorsonion.paintingmod.entity.PMEntityRegistry;
import net.creatorsonion.paintingmod.entity.decoration.painting.PMPaintingMotive;
import net.creatorsonion.paintingmod.item.PMItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaintingMod implements ModInitializer {
    public static final String MOD_ID   = "paintingmod";
    public static final String MOD_NAME = "Painting Mod";
	public static final Logger LOGGER   = LogManager.getLogger(MOD_ID);

	public static final String[] MOTIVES = {
		"fate", "glare", "tentacles", "bold_and_brash",
		"paradoxical", "forgotten_nostalgia", "melon", "fantasy_of_pearce",
		"ramen_and_rice", "poker_night", "steven", "ravenous",
		"portal_sunset", "explorer", "jebie"
	};

	public static final ItemGroup ITEM_GROUP =
		FabricItemGroupBuilder.create(new Identifier(MOD_ID, "general"))
							  .icon(() -> new ItemStack(Items.PAINTING))
							  .appendItems(stacks -> {
								  for (String motive: MOTIVES) {
									  NbtCompound nbtCompound = new NbtCompound();
									  nbtCompound.put("EntityTag", new NbtCompound());
									  nbtCompound.getCompound("EntityTag").putString("Motive", MOD_ID +":"+motive);
									  ItemStack item = new ItemStack(PMItemRegistry.DESIGNERS_PAINTING);
									  item.setNbt(nbtCompound);
									  stacks.add(item);
								  }
							  })
							  .build();

	@SuppressWarnings("UnstableApiUsage")
	@Override
	public void onInitialize() {
		LOGGER.info("Initializing {}", MOD_NAME);

		Reflection.initialize(
			PMPaintingMotive.class,
			PMItemRegistry.class,
			PMEntityRegistry.class
		);

		LOGGER.info("Initialized {}", MOD_NAME);
	}
}
