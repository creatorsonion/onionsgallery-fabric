package net.creatorsonion.paintingmod.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.item.DecorationItem;
import net.minecraft.item.ItemStack;
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
