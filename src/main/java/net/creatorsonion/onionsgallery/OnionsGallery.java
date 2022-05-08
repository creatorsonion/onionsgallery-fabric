package net.creatorsonion.onionsgallery;

import com.google.common.reflect.Reflection;
import net.creatorsonion.onionsgallery.entity.OnionsGalleryEntityType;
import net.creatorsonion.onionsgallery.entity.decoration.painting.OnionsGalleryPaintingMotive;
import net.creatorsonion.onionsgallery.item.OnionsGalleryItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OnionsGallery implements ModInitializer {
    public static final String MOD_ID   = "onionsgallery";
    public static final String MOD_NAME = "Onions' Gallery";
	public static final Logger LOGGER   = LoggerFactory.getLogger(MOD_ID);

	public static final ItemGroup ITEM_GROUP =
		FabricItemGroupBuilder.create(new Identifier(MOD_ID, "item_group"))
							  .icon(() -> new ItemStack(OnionsGalleryItems.DESIGNERS_PAINTING))
							  .appendItems(stacks -> {
								  for (PaintingMotive motive : OnionsGalleryPaintingMotive.getAll()) {
									  NbtCompound nbt = new NbtCompound();

									  NbtCompound nbtEntityTag = new NbtCompound();
									  Identifier id = Registry.PAINTING_MOTIVE.getId(motive);
									  nbtEntityTag.putString("Motive", id.toString());
									  nbt.put("EntityTag", nbtEntityTag);

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
