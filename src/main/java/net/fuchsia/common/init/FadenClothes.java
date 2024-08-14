package net.fuchsia.common.init;

import json.jayson.faden.core.common.init.FadenCoreClothes;
import json.jayson.faden.core.common.objects.item.cloth.ClothItem;
import json.jayson.faden.core.datagen.DataItemModel;
import json.jayson.faden.core.datagen.FadenCoreDataGen;
import json.jayson.faden.core.datagen.holders.FadenDataItem;
import net.fuchsia.util.FadenIdentifier;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class FadenClothes {

    public static ClothItem TEST_CLOTH = registerItem("test_cloth", new ClothItem(new Item.Settings(), "test_cloth"), "ingots/silver_ingot");

    public static <T extends ClothItem> T registerItem(String name, T item, String texture, DataItemModel itemModel) {
        T i = Registry.register(Registries.ITEM, FadenIdentifier.create(name), item);
        FadenCoreDataGen.ITEMS.add(new FadenDataItem(i, texture, itemModel, null));
        FadenCoreClothes.CLOTHES.add(i);
        return i;
    }

    public static <T extends ClothItem> T registerItem(String name, T item, String texture) {
        return registerItem(name, item, texture, DataItemModel.GENERATED);
    }

    public static void init() {}

}
