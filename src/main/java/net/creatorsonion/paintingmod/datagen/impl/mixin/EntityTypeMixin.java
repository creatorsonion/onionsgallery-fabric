package net.creatorsonion.paintingmod.datagen.impl.mixin;

import net.creatorsonion.paintingmod.datagen.impl.ObjectLootTableAccess;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(EntityType.class)
public abstract class EntityTypeMixin implements ObjectLootTableAccess {
    @Shadow public abstract Identifier getLootTableId();

    @Override
    public Identifier getLootTableIdForDataGeneration() {
        return this.getLootTableId();
    }
}
