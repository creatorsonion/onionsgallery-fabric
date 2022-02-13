package net.creatorsonion.onionsgallery.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.painting.PaintingEntity;
import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class DesignersPaintingEntity extends PaintingEntity {

    public DesignersPaintingEntity(EntityType<? extends PaintingEntity> entityType, World world) {
        super(OnionsGalleryEntityType.DESIGNERS_PAINTING, world);
    }

    public DesignersPaintingEntity(World world, BlockPos pos, Direction direction) {
        super(world, pos, direction);
    }

    public DesignersPaintingEntity(World world, BlockPos pos, Direction direction, PaintingMotive motive) {
        super(world, pos, direction, motive);
    }
}
