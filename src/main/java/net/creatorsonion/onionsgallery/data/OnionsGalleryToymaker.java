package net.creatorsonion.onionsgallery.data;

import net.moddingplayground.frame.api.toymaker.v0.ToymakerEntrypoint;
import net.moddingplayground.frame.api.toymaker.v0.registry.generator.ItemModelGeneratorStore;

public class OnionsGalleryToymaker implements ToymakerEntrypoint {
    @Override
    public void onInitializeToymaker() {
        ItemModelGeneratorStore.register(ItemModelGenerator::new);
    }
}
