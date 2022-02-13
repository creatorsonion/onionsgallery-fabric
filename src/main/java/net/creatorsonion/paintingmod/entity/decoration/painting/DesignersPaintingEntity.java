//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.creatorsonion.paintingmod.entity.decoration.painting;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

import net.creatorsonion.paintingmod.entity.PMEntityRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.entity.decoration.painting.PaintingEntity;
import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.PaintingSpawnS2CPacket;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DesignersPaintingEntity extends PaintingEntity {

    public DesignersPaintingEntity(EntityType<? extends PaintingEntity> entityType, World world) {
        super(PMEntityRegistry.DESIGNERS_PAINTING, world);
    }

    public DesignersPaintingEntity(World world, BlockPos pos, Direction direction) {
        super(world, pos, direction);
    }

    public DesignersPaintingEntity(World world, BlockPos pos, Direction direction, PaintingMotive motive) {
        super(world, pos, direction, motive);
    }
}
