package net.fuchsia.common.init.items;

import json.jayson.faden.core.common.objects.item.instrument.InstrumentItem;
import json.jayson.faden.core.common.objects.item.instrument.InstrumentType;
import json.jayson.faden.core.registry.FadenCoreRegistry;
import net.fuchsia.common.init.FadenTabs;
import net.fuchsia.util.FadenIdentifier;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;

import static net.fuchsia.common.init.items.FadenItems.registerItem;

public class FadenInstruments {


    public static InstrumentType LUTE_TYPE = registerType("lute", "lute");
    public static InstrumentType PANFLUTE_TYPE = registerType("panflute", "panflute");
    public static InstrumentType HURDY_TYPE = registerType("hurdy_gurdy", "hurdy_gurdy");
    public static InstrumentType DRUM_TYPE = registerType("drum", "drum");

    public static Item LUTE = registerItem("lute", new InstrumentItem(new Item.Settings(), LUTE_TYPE), "instruments/lute/default", FadenTabs.FADEN_INSTRUMENTS);
    public static Item PANFLUTE = registerItem("panflute", new InstrumentItem(new Item.Settings(), PANFLUTE_TYPE), "instruments/panflute/default", FadenTabs.FADEN_INSTRUMENTS);
    public static Item HURDY = registerItem("hurdy_gurdy", new InstrumentItem(new Item.Settings(), HURDY_TYPE), "test", FadenTabs.FADEN_INSTRUMENTS);
    public static Item DRUM = registerItem("drum", new InstrumentItem(new Item.Settings(), DRUM_TYPE), "test", FadenTabs.FADEN_INSTRUMENTS);

    private static InstrumentType registerType(String name, String typeId) {
        return Registry.register(FadenCoreRegistry.INSTRUMENT, FadenIdentifier.create(name), new InstrumentType(typeId));
    }

    public static void init() {}

}
