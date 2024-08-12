package net.fuchsia.common.objects.item.gear.necklace;

import net.fuchsia.FadenCore;
import net.fuchsia.common.init.FadenCoreDataComponents;
import net.fuchsia.common.objects.item.ItemTier;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FrogPendant extends NecklaceItem {

    public FrogPendant(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setStackInHand(hand, randomize(user.getStackInHand(hand), user, ItemTier.LEGENDARY));
        return super.use(world, user, hand);
    }

    @Override
    public ItemStack randomize(ItemStack itemStack, PlayerEntity player, ItemTier itemTier) {
        itemStack.set(DataComponentTypes.MAX_DAMAGE, FadenCore.RANDOM.nextInt(10 + (int)(100.0f * itemTier.getDurabilityMultiplier()), (int)(375.0f * itemTier.getDurabilityMultiplier())));
        itemStack.set(DataComponentTypes.DAMAGE, 0);
        itemStack.set(FadenCoreDataComponents.JUMP_INCREASE_VALUE, FadenCore.RANDOM.nextFloat(0.001f, 0.05f) * itemTier.getDurabilityMultiplier());
        itemStack.set(FadenCoreDataComponents.ITEM_TIER, itemTier.name());
        itemStack.set(FadenCoreDataComponents.FREE_WATER_MOVEMENT, true);
        itemStack.set(FadenCoreDataComponents.FALL_DAMAGE_DECREASE_PERCENTAGE, 50f);
        itemStack.set(FadenCoreDataComponents.FALL_DAMAGE_DECREASE_BLOCKS, 8f);
        return itemStack;
    }
}
