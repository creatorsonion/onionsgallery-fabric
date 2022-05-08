package net.creatorsonion.onionsgallery.data;

import net.creatorsonion.onionsgallery.OnionsGallery;
import net.creatorsonion.onionsgallery.item.OnionsGalleryItems;
import net.moddingplayground.frame.api.toymaker.v0.generator.model.item.AbstractItemModelGenerator;

public class ItemModelGenerator extends AbstractItemModelGenerator {
    public ItemModelGenerator() {
        super(OnionsGallery.MOD_ID);
    }

    @Override
    public void generate() {
        this.add(OnionsGalleryItems.DESIGNERS_PAINTING);
    }
}
