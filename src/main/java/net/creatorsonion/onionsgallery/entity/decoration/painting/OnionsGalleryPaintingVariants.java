package net.creatorsonion.onionsgallery.entity.decoration.painting;

import net.creatorsonion.onionsgallery.OnionsGallery;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.List;

public interface OnionsGalleryPaintingVariants {
    PaintingVariant FATE = register("fate", 64, 32);
    PaintingVariant GLARE = register("glare", 64, 64);
    PaintingVariant TENTACLES = register("tentacles", 32, 16);
    PaintingVariant BOLD_AND_BRASH = register("bold_and_brash", 16, 16);
    PaintingVariant PARADOXICAL = register("paradoxical", 32, 32);
    PaintingVariant FORGOTTEN_NOSTALGIA = register("forgotten_nostalgia", 48, 48);
    PaintingVariant MELON = register("melon", 32, 32);
    PaintingVariant FANTASY_OF_PEARCE = register("fantasy_of_pearce", 16, 32);
    PaintingVariant RAMEN_AND_RICE = register("ramen_and_rice", 32, 32);
    PaintingVariant POKER_NIGHT = register("poker_night", 32, 16);
    PaintingVariant STEVEN = register("steven", 16, 16);
    PaintingVariant RAVENOUS = register("ravenous", 16, 32);
    PaintingVariant PORTAL_SUNSET = register("portal_sunset", 32, 32);
    PaintingVariant EXPLORER = register("explorer", 64, 64);
    PaintingVariant JEBIE = register("jebie", 16, 16);

    private static PaintingVariant register(String id, int width, int height) {
        return Registry.register(Registry.PAINTING_VARIANT, new Identifier(OnionsGallery.MOD_ID, id), new OnionsGalleryPaintingVariant(width, height));
    }

    static List<OnionsGalleryPaintingVariant> getAll() {
        return Registry.PAINTING_VARIANT.stream()
                                       .filter(OnionsGalleryPaintingVariant.class::isInstance)
                                       .map(OnionsGalleryPaintingVariant.class::cast)
                                       .toList();
    }
}
