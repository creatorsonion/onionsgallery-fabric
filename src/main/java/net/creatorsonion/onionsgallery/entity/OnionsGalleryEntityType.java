package net.creatorsonion.onionsgallery.entity;

import net.creatorsonion.onionsgallery.OnionsGallery;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public interface OnionsGalleryEntityType {
    EntityType<DesignersPaintingEntity> DESIGNERS_PAINTING = register("designers_painting",
        FabricEntityTypeBuilder.<DesignersPaintingEntity>create(SpawnGroup.MISC, DesignersPaintingEntity::new)
                               .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                               .trackRangeBlocks(10)
                               .trackedUpdateRate(Integer.MAX_VALUE)
    );

    private static <T extends Entity> EntityType<T> register(String id, FabricEntityTypeBuilder<T> entityType) {
        return Registry.register(Registry.ENTITY_TYPE, new Identifier(OnionsGallery.MOD_ID, id), entityType.build());
    }
}
