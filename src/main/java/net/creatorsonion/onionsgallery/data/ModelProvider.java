package net.creatorsonion.onionsgallery.data;

import net.creatorsonion.onionsgallery.item.OnionsGalleryItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.moddingplayground.frame.api.toymaker.v0.model.uploader.ItemModelUploader;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataGenerator gen) {
        super(gen);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator gen) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator gen) {
        ItemModelUploader uploader = ItemModelUploader.of(gen);
        uploader.register(Models.GENERATED, OnionsGalleryItems.DESIGNERS_PAINTING);
    }
}
