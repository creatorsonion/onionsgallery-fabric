package net.creatorsonion.onionsgallery.data;

import net.moddingplayground.toymaker.api.ToymakerEntrypoint;
import net.moddingplayground.toymaker.api.registry.generator.ItemModelGeneratorStore;

public class OnionsGalleryToymaker implements ToymakerEntrypoint {
    @Override
    public void onInitializeToymaker() {
        ItemModelGeneratorStore.register(ItemModelGenerator::new);
    }
}
