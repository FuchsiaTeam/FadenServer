package net.fuchsia.common.init;

import json.jayson.faden.core.common.race.Race;
import json.jayson.faden.core.registry.FadenCoreRegistry;
import net.fuchsia.common.objects.race.*;
import net.fuchsia.common.objects.race.LocathahRace;
import net.fuchsia.util.FadenIdentifier;
import net.minecraft.registry.Registry;

public class FadenRaces {

    public static Race HUMAN = register("human", new HumanRace());
    public static Race HARENGON = register("harengon", new HarengonRace());
    public static Race ELF = register("elf", new ElfRace());
    public static Race TABAXI = register("tabaxi", new TabaxiRace());
    public static Race LOCATHAH = register("locathah", new LocathahRace());
    public static Race DWARF = register("dwarf", new DwarfRace());

    public static Race register(String name, Race race) {
        return Registry.register(FadenCoreRegistry.RACE, FadenIdentifier.create(name), race);
    }

    public static void init() {}
}
