package net.creatorsonion.onionsgallery.item;

import net.creatorsonion.onionsgallery.OnionsGallery;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.item.DecorationItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;
import java.util.Optional;

public class DesignersPaintingItem extends DecorationItem {
    public DesignersPaintingItem(EntityType<? extends AbstractDecorationEntity> entityType, Settings settings) {
        super(entityType, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext ctx) {
        NbtCompound nbt = Optional.ofNullable(stack.getNbt()).orElseGet(NbtCompound::new);
        NbtCompound entityNbt = nbt.getCompound("EntityTag");
        tooltip.add(new TranslatableText("painting.%s.%s".formatted(OnionsGallery.MOD_ID, entityNbt.getString("Motive"))).formatted(Formatting.GRAY));
    }
}
