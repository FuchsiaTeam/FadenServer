package net.fuchsia.common.objects.item.gear;

import json.jayson.faden.core.common.objects.cloth.FadenCoreCloth;
import json.jayson.faden.core.common.objects.item.IClothItem;
import json.jayson.faden.core.common.slot.ClothSlot;
import net.fuchsia.common.init.FadenClothes;
import net.minecraft.item.Item;

public class TestClothItem extends Item implements IClothItem {
    public TestClothItem(Settings settings) {
        super(settings);
    }

    @Override
    public FadenCoreCloth getCloth() {
        return FadenClothes.TEST_CLOTH;
    }

    @Override
    public ClothSlot getClothType() {
        return ClothSlot.CHEST;
    }
}
