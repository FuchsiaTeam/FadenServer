package net.fuchsia.common.init.items;

import json.jayson.faden.core.common.objects.item.gear.bracelet.BraceletItem;
import json.jayson.faden.core.common.objects.item.gear.necklace.NecklaceItem;
import json.jayson.faden.core.datagen.DataItemModel;
import json.jayson.faden.core.datagen.FadenCoreDataGen;
import json.jayson.faden.core.datagen.holders.FadenDataItem;
import net.fuchsia.common.objects.item.gear.bracelet.TestBracelet;
import net.fuchsia.common.objects.item.gear.bracelet.WarriorBracelet;
import net.fuchsia.common.objects.item.gear.necklace.FrogPendant;
import net.fuchsia.common.objects.item.gear.necklace.KingOFWaterNecklaceItem;
import net.fuchsia.util.FadenIdentifier;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static json.jayson.faden.core.common.init.items.FadenCoreGear.BRACELETS;
import static json.jayson.faden.core.common.init.items.FadenCoreGear.NECKLACES;


public class FadenGear {

    public static BraceletItem WARRIORS_BRACELET = registerBracelet("warriors_bracelet", new WarriorBracelet(new Item.Settings()), "ingots/silver_ingot");
    public static NecklaceItem KING_OF_WATER_NECKLACE = registerNecklace("king_of_water_necklace", new KingOFWaterNecklaceItem(new Item.Settings()), "ingots/silver_ingot");
    public static BraceletItem TEST_BRACELET = registerBracelet("test_bracelet", new TestBracelet(new Item.Settings()), "ingots/silver_ingot");
    public static NecklaceItem FROG_PENDANT = registerNecklace("frog_pendant", new FrogPendant(new Item.Settings()), "ingots/silver_ingot");


    public static <T extends BraceletItem> T registerBracelet(String name, T item, String texture, DataItemModel itemModel) {
        T i = Registry.register(Registries.ITEM, FadenIdentifier.create(name), item);
        FadenCoreDataGen.ITEMS.add(new FadenDataItem(i, texture, itemModel, null));
        BRACELETS.add(i);
        return i;
    }

    public static <T extends BraceletItem> T registerBracelet(String name, T item, String texture) {
        return registerBracelet(name, item, texture, DataItemModel.GENERATED);
    }

    public static <T extends NecklaceItem> T registerNecklace(String name, T item, String texture, DataItemModel itemModel) {
        T i = Registry.register(Registries.ITEM, FadenIdentifier.create(name), item);
        FadenCoreDataGen.ITEMS.add(new FadenDataItem(i, texture, itemModel, null));
        NECKLACES.add(i);
        return i;
    }

    public static <T extends NecklaceItem> T registerNecklace(String name, T item, String texture) {
        return registerNecklace(name, item, texture, DataItemModel.GENERATED);
    }

    public static void init() {}

}
