package net.creatorsonion.paintingmod.entity;

import net.creatorsonion.paintingmod.PaintingMod;
import net.creatorsonion.paintingmod.entity.decoration.painting.DesignersPaintingEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PMEntityRegistry {
    public static final EntityType<DesignersPaintingEntity> DESIGNERS_PAINTING = register(
                "designers_painting",
                // Settings just copied from vanilla painting
                FabricEntityTypeBuilder.<DesignersPaintingEntity>create(SpawnGroup.MISC, DesignersPaintingEntity::new)
                        .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                        .trackRangeBlocks(10)
                        .trackedUpdateRate(2147483647)
    );

    private static EntityType register(String path, FabricEntityTypeBuilder<?> fabricEntityTypeBuilder) {
        return Registry.register(
                Registry.ENTITY_TYPE,
                new Identifier(PaintingMod.MOD_ID, path),
                fabricEntityTypeBuilder.build()
        );
    }
}
