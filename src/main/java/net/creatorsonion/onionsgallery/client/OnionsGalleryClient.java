package net.creatorsonion.onionsgallery.client;

import net.creatorsonion.onionsgallery.client.render.DesignersPaintingEntityRenderer;
import net.creatorsonion.onionsgallery.entity.OnionsGalleryEntityType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class OnionsGalleryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(OnionsGalleryEntityType.DESIGNERS_PAINTING, DesignersPaintingEntityRenderer::new);
    }
}
