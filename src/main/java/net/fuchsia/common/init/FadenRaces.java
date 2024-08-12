package net.fuchsia.common.init;

import net.fuchsia.common.objects.race.*;
import net.fuchsia.common.objects.race.LocathahRace;
import net.fuchsia.common.race.Race;

public class FadenRaces {

    public static Race HUMAN = register(new HumanRace());
    public static Race HARENGON = register(new HarengonRace());
    public static Race ELF = register(new ElfRace());
    public static Race TABAXI = register(new TabaxiRace());
    public static Race LOCATHAH = register(new LocathahRace());
    public static Race DWARF = register(new DwarfRace());

    public static Race register(Race race) {
        FadenCoreRaces.getRegistry().put(race.getIdentifier(), race);
        return FadenCoreRaces.getRegistry().get(race.getIdentifier());
    }

    public static void register() {}
}
