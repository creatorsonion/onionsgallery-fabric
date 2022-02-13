package net.creatorsonion.onionsgallery.entity.decoration.painting;

import net.creatorsonion.onionsgallery.OnionsGallery;
import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class OnionsGalleryPaintingMotive extends PaintingMotive {
    public static final PaintingMotive FATE = register("fate", 64, 32);
    public static final PaintingMotive GLARE = register("glare", 64, 64);
    public static final PaintingMotive TENTACLES = register("tentacles", 32, 16);
    public static final PaintingMotive BOLD_AND_BRASH = register("bold_and_brash", 16, 16);
    public static final PaintingMotive PARADOXICAL = register("paradoxical", 32, 32);
    public static final PaintingMotive FORGOTTEN_NOSTALGIA = register("forgotten_nostalgia", 48, 48);
    public static final PaintingMotive MELON = register("melon", 32, 32);
    public static final PaintingMotive FANTASY_OF_PEARCE = register("fantasy_of_pearce", 16, 32);
    public static final PaintingMotive RAMEN_AND_RICE = register("ramen_and_rice", 32, 32);
    public static final PaintingMotive POKER_NIGHT = register("poker_night", 32, 16);
    public static final PaintingMotive STEVEN = register("steven", 16, 16);
    public static final PaintingMotive RAVENOUS = register("ravenous", 16, 32);
    public static final PaintingMotive PORTAL_SUNSET = register("portal_sunset", 32, 32);
    public static final PaintingMotive EXPLORER = register("explorer", 64, 64);
    public static final PaintingMotive JEBIE = register("jebie", 16, 16);

    public OnionsGalleryPaintingMotive(int width, int height) {
        super(width, height);
    }

    private static PaintingMotive register(String id, int width, int height) {
        return Registry.register(Registry.PAINTING_MOTIVE, new Identifier(OnionsGallery.MOD_ID, id), new OnionsGalleryPaintingMotive(width, height));
    }
}
