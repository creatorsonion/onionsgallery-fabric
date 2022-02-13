package net.creatorsonion.onionsgallery;

import com.google.common.reflect.Reflection;
import net.creatorsonion.onionsgallery.entity.OnionsGalleryEntityType;
import net.creatorsonion.onionsgallery.entity.decoration.painting.OnionsGalleryPaintingMotive;
import net.creatorsonion.onionsgallery.item.OnionsGalleryItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OnionsGallery implements ModInitializer {
    public static final String MOD_ID   = "onionsgallery";
    public static final String MOD_NAME = "Onions' Gallery";
	public static final Logger LOGGER   = LogManager.getLogger(MOD_ID);

	public static final String[] MOTIVES = {
		"fate", "glare", "tentacles", "bold_and_brash",
		"paradoxical", "forgotten_nostalgia", "melon", "fantasy_of_pearce",
		"ramen_and_rice", "poker_night", "steven", "ravenous",
		"portal_sunset", "explorer", "jebie"
	};

	public static final ItemGroup ITEM_GROUP =
		FabricItemGroupBuilder.create(new Identifier(MOD_ID, "item_group"))
							  .icon(() -> new ItemStack(OnionsGalleryItems.DESIGNERS_PAINTING))
							  .appendItems(stacks -> {
								  for (String motive : MOTIVES) {
									  NbtCompound nbt = new NbtCompound();
									  nbt.put("EntityTag", new NbtCompound());
									  NbtCompound entityTagNbt = nbt.getCompound("EntityTag");
									  entityTagNbt.putString("Motive", new Identifier(MOD_ID, motive).toString());
									  ItemStack item = new ItemStack(OnionsGalleryItems.DESIGNERS_PAINTING);
									  item.setNbt(nbt);
									  stacks.add(item);
								  }
							  })
							  .build();

	@SuppressWarnings("UnstableApiUsage")
	@Override
	public void onInitialize() {
		LOGGER.info("Initializing {}", MOD_NAME);

		Reflection.initialize(
			OnionsGalleryPaintingMotive.class,
			OnionsGalleryItems.class,
			OnionsGalleryEntityType.class
		);

		LOGGER.info("Initialized {}", MOD_NAME);
	}
}
