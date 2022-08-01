package net.creatorsonion.onionsgallery.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.painting.PaintingEntity;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.World;

public class DesignersPaintingEntity extends PaintingEntity {
    public DesignersPaintingEntity(EntityType<? extends DesignersPaintingEntity> entityType, World world) {
        super(entityType, world);
    }

    public DesignersPaintingEntity(World world, BlockPos pos, Direction direction, RegistryEntry<PaintingVariant> variant) {
        super(world, pos, direction, variant);
    }
}
