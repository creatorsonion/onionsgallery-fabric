package net.creatorsonion.onionsgallery.item;

import net.creatorsonion.onionsgallery.OnionsGallery;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public interface OnionsGalleryItems {
    Item DESIGNERS_PAINTING = register("designers_painting", new DesignersPaintingItem(EntityType.PAINTING,
        new FabricItemSettings().group(OnionsGallery.ITEM_GROUP)
                                .maxCount(16)
                                .rarity(Rarity.RARE))
    );

    private static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(OnionsGallery.MOD_ID, id), item);
    }
}
