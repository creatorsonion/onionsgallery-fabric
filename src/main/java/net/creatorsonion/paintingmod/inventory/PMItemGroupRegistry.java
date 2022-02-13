package net.creatorsonion.paintingmod.inventory;

import net.creatorsonion.paintingmod.PaintingMod;
import net.creatorsonion.paintingmod.item.PMItemRegistry;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class PMItemGroupRegistry {
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(PaintingMod.MOD_ID, "general"))
            .icon(() -> new ItemStack(Items.PAINTING))
            .appendItems(stacks -> {
                for (String motive: PaintingMod.MOTIVES) {
                    NbtCompound nbtCompound = new NbtCompound();
                    nbtCompound.put("EntityTag", new NbtCompound());
                    nbtCompound.getCompound("EntityTag").putString("Motive", PaintingMod.MOD_ID+":"+motive);
                    ItemStack item = new ItemStack(PMItemRegistry.DESIGNERS_PAINTING);
                    item.setNbt(nbtCompound);
                    stacks.add(item);
                }
            })
            .build();
}
