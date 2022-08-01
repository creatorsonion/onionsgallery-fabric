package net.creatorsonion.onionsgallery;

import com.google.common.reflect.Reflection;
import net.creatorsonion.onionsgallery.client.OnionsGalleryClient;
import net.creatorsonion.onionsgallery.entity.OnionsGalleryEntityType;
import net.creatorsonion.onionsgallery.entity.decoration.painting.OnionsGalleryPaintingVariants;
import net.creatorsonion.onionsgallery.item.OnionsGalleryItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.decoration.painting.PaintingVariant;
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
								  for (PaintingVariant variant : OnionsGalleryPaintingVariants.getAll()) {
									  NbtCompound nbt = new NbtCompound();

									  NbtCompound nbtEntityTag = new NbtCompound();
									  Identifier id = Registry.PAINTING_VARIANT.getId(variant);
									  nbtEntityTag.putString("variant", id.toString());
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
			OnionsGalleryPaintingVariants.class,
			OnionsGalleryItems.class,
			OnionsGalleryEntityType.class,
				OnionsGalleryClient.class
		);

		LOGGER.info("Initialized {}", MOD_NAME);
	}
}
