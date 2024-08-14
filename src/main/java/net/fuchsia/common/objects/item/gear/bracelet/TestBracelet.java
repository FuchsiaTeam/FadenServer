package net.fuchsia.common.objects.item.gear.bracelet;

import json.jayson.faden.core.FadenCore;
import json.jayson.faden.core.common.init.FadenCoreDataComponents;
import json.jayson.faden.core.common.objects.item.ItemTier;
import json.jayson.faden.core.common.objects.item.gear.bracelet.BraceletItem;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TestBracelet extends BraceletItem {
    public TestBracelet(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setStackInHand(hand, randomize(user.getStackInHand(hand), user, ItemTier.MYTHIC));
        return super.use(world, user, hand);
    }

    @Override
    public ItemStack randomize(ItemStack itemStack, PlayerEntity player, ItemTier itemTier) {
        itemStack.set(DataComponentTypes.MAX_DAMAGE, FadenCore.RANDOM.nextInt(50 + (int)(50.0f * itemTier.getDurabilityMultiplier()), (int)(500.0f * itemTier.getDurabilityMultiplier())));
        itemStack.set(DataComponentTypes.DAMAGE, 0);
        itemStack.set(FadenCoreDataComponents.ITEM_TIER, itemTier.name());
        itemStack.set(FadenCoreDataComponents.DAMAGE_INCREASE_VALUE, FadenCore.RANDOM.nextFloat() * (itemTier.getSellValueMultiplier() * 3f));
        itemStack.set(FadenCoreDataComponents.DAMAGE_INCREASE_PERCENTAGE, FadenCore.RANDOM.nextFloat() * (itemTier.getSellValueMultiplier() * 3f));
        itemStack.set(FadenCoreDataComponents.JUMP_INCREASE_PERCENTAGE, FadenCore.RANDOM.nextFloat() * (itemTier.getSellValueMultiplier() * 3f));
        itemStack.set(FadenCoreDataComponents.JUMP_INCREASE_VALUE, FadenCore.RANDOM.nextFloat() * (itemTier.getSellValueMultiplier() * 3f));
        itemStack.set(FadenCoreDataComponents.FREE_WATER_MOVEMENT, true);
        itemStack.set(FadenCoreDataComponents.FALL_DAMAGE_DECREASE_PERCENTAGE, FadenCore.RANDOM.nextFloat(0, 100));
        return itemStack;
    }
}
