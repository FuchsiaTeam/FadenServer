package net.fuchsia.common.init.items;

import json.jayson.faden.core.common.objects.item.TooltipTestItem;
import json.jayson.faden.core.common.objects.item.coin.CoinItem;
import json.jayson.faden.core.datagen.DataItemModel;
import json.jayson.faden.core.datagen.FadenCoreDataGen;
import json.jayson.faden.core.datagen.holders.FadenDataItem;
import net.fuchsia.util.FadenIdentifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;


public class FadenItems {

    public static CoinItem COPPER_COIN = registerItem("copper_coin", new CoinItem(new Item.Settings(), 1), "coins/copper_coin");
    public static CoinItem IRON_COIN = registerItem("iron_coin", new CoinItem(new Item.Settings(), 5), "coins/iron_coin");
    public static CoinItem ENDER_COIN = registerItem("ender_coin", new CoinItem(new Item.Settings(), 10), "coins/ender_coin");
    public static CoinItem SILVER_COIN = registerItem("silver_coin", new CoinItem(new Item.Settings(), 50), "coins/silver_coin");
    public static CoinItem GOLD_COIN = registerItem("gold_coin", new CoinItem(new Item.Settings(), 100), "coins/gold_coin");
    public static CoinItem AMETHYST_COIN = registerItem("amethyst_coin", new CoinItem(new Item.Settings(), 500), "coins/amethyst_coin");
    public static CoinItem NETHERITE_COIN = registerItem("netherite_coin", new CoinItem(new Item.Settings(), 1000), "coins/netherite_coin");
    public static CoinItem STAR_COIN = registerItem("star_coin", new CoinItem(new Item.Settings(), 64000), "coins/star_coin");
    public static Item TOOL_TIP_TEST = registerItem("tooltip_test_item", new TooltipTestItem(new Item.Settings()), "ingots/silver_ingot");

    public static Item SCROLL = registerItem("scroll", new Item(new Item.Settings()), "scroll/scroll");

    public static <T extends Item> T registerItem(String name, T item, String texture, DataItemModel itemModel, ItemGroup group) {
        T i = Registry.register(Registries.ITEM, FadenIdentifier.create(name), item);
        FadenCoreDataGen.ITEMS.add(new FadenDataItem(i, texture, itemModel, group));
        return i;
    }

    public static <T extends Item> T registerItem(String name, T item, String texture, DataItemModel itemModel) {
        T i = Registry.register(Registries.ITEM, FadenIdentifier.create(name), item);
        FadenCoreDataGen.ITEMS.add(new FadenDataItem(i, texture, itemModel, null));
        return i;
    }

    public static <T extends Item> T registerItem(String name, T item, String texture) {
        return registerItem(name, item, texture, DataItemModel.GENERATED);
    }

    public static <T extends Item> T registerItem(String name, T item, String texture, ItemGroup group) {
        return registerItem(name, item, texture, DataItemModel.GENERATED, group);
    }


    public static void init() {}

}
