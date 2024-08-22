package net.fuchsia.common.objects.songs;

import json.jayson.faden.core.common.objects.item.instrument.InstrumentType;
import json.jayson.faden.core.common.objects.music_instance.InstrumentedMusic;
import net.fuchsia.common.init.FadenSoundEvents;
import net.fuchsia.common.init.items.FadenInstruments;
import net.fuchsia.util.FadenIdentifier;

public class BurningMemoryMusic extends InstrumentedMusic {

    public BurningMemoryMusic() {
        getInstrumentTypes().put(FadenInstruments.LUTE_TYPE, FadenSoundEvents.BURNING_MEMORY_LUTE);
        getInstrumentTypes().put(FadenInstruments.HURDY_TYPE, FadenSoundEvents.BURNING_MEMORY_HURTY);
        getInstrumentTypes().put(FadenInstruments.PANFLUTE_TYPE, FadenSoundEvents.BURNING_MEMORY_PANFLUTE);
        getInstrumentTypes().put(FadenInstruments.DRUM_TYPE, FadenSoundEvents.BURNING_MEMORY_DRUM);
        author = "Lucas Burnett";
        name = "Burning Memory";
    }

    @Override
    public String getId() {
        return FadenIdentifier.create("burning_memory").toString();
    }
}
