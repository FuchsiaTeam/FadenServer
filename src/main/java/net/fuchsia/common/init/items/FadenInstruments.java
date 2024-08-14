package net.fuchsia.common.init.items;

import json.jayson.faden.core.common.objects.item.instrument.InstrumentItem;
import json.jayson.faden.core.common.objects.item.instrument.InstrumentType;
import net.fuchsia.common.init.FadenTabs;
import net.minecraft.item.Item;

import static net.fuchsia.common.init.items.FadenItems.registerItem;

public class FadenInstruments {

    public static Item LUTE = registerItem("lute", new InstrumentItem(new Item.Settings(), InstrumentType.LUTE), "instruments/lute/default", FadenTabs.FADEN_INSTRUMENTS);
    public static Item PANFLUTE = registerItem("panflute", new InstrumentItem(new Item.Settings(), InstrumentType.PAN_FLUTE), "instruments/panflute/default", FadenTabs.FADEN_INSTRUMENTS);
    public static Item HURDY = registerItem("hurdy_gurdy", new InstrumentItem(new Item.Settings(), InstrumentType.HURDY), "test", FadenTabs.FADEN_INSTRUMENTS);
    public static Item DRUM = registerItem("drum", new InstrumentItem(new Item.Settings(), InstrumentType.DRUM), "test", FadenTabs.FADEN_INSTRUMENTS);


    public static void init() {}

}
