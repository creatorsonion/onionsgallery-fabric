package net.creatorsonion.paintingmod.item;

import net.creatorsonion.paintingmod.PaintingMod;
import net.creatorsonion.paintingmod.inventory.PMItemGroupRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class PMItemRegistry {
    private static final FabricItemSettings PAINTING_SETTINGS =
            new FabricItemSettings()
                    .group(PMItemGroupRegistry.ITEM_GROUP)
                    .maxCount(16)
                    .rarity(Rarity.RARE);

    public static final Item DESIGNERS_PAINTING = register("designers_painting", new DesignersPaintingItem(EntityType.PAINTING, PAINTING_SETTINGS, PaintingMod.MOTIVES[0]));
    //public static final Item DESIGNERS_PAINTING = register("designers_painting", new DesignersPaintingItem(PMEntityRegistry.DESIGNERS_PAINTING, PAINTING_SETTINGS, PaintingMod.MOTIVES[0]));

    private static Item register(String path, Item item) {
        Registry.register(Registry.ITEM, new Identifier(PaintingMod.MOD_ID, path), item);
        return item;
    }
}
