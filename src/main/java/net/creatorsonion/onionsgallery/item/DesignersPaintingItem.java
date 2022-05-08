package net.creatorsonion.onionsgallery.item;

import net.creatorsonion.onionsgallery.OnionsGallery;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.resource.language.I18n;
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
    public DesignersPaintingItem(EntityType<? extends AbstractDecorationEntity> type, Settings settings) {
        super(type, settings);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext ctx) {
        NbtCompound nbt = Optional.ofNullable(stack.getNbt()).orElseGet(NbtCompound::new);
        NbtCompound entityNbt = nbt.getCompound("EntityTag");
        String key = "painting.%s.%s".formatted(OnionsGallery.MOD_ID, entityNbt.getString("Motive"));
        if (I18n.hasTranslation(key)) tooltip.add(new TranslatableText(key).formatted(Formatting.GRAY));
    }
}
