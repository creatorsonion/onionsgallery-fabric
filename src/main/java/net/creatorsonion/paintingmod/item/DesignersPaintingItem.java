package net.creatorsonion.paintingmod.item;

import net.creatorsonion.paintingmod.entity.PMEntityRegistry;
import net.creatorsonion.paintingmod.entity.decoration.painting.DesignersPaintingEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.item.DecorationItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class DesignersPaintingItem extends DecorationItem {

    private String motive = "jebie";

    public DesignersPaintingItem(EntityType<? extends AbstractDecorationEntity> entityType, Settings settings, String motive) {
        super(entityType, settings);
        this.motive = motive;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        tooltip.add( new TranslatableText("item.painting_mod.motive."+itemStack.getOrCreateNbt().getCompound("Entity").getString("Motive").formatted(Formatting.AQUA) ));
    }
}
