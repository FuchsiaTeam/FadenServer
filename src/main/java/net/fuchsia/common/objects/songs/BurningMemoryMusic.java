package net.fuchsia.common.objects.songs;

import net.fuchsia.common.init.FadenSoundEvents;
import net.fuchsia.common.objects.item.instrument.InstrumentType;
import net.fuchsia.common.objects.music_instance.InstrumentedMusic;
import net.fuchsia.util.FadenCoreIdentifier;

public class BurningMemoryMusic extends InstrumentedMusic {

    public BurningMemoryMusic() {
        getInstrumentTypes().put(InstrumentType.LUTE, FadenSoundEvents.BURNING_MEMORY_LUTE);
        getInstrumentTypes().put(InstrumentType.HURDY, FadenSoundEvents.BURNING_MEMORY_HURTY);
        getInstrumentTypes().put(InstrumentType.PAN_FLUTE, FadenSoundEvents.BURNING_MEMORY_PANFLUTE);
        getInstrumentTypes().put(InstrumentType.DRUM, FadenSoundEvents.BURNING_MEMORY_DRUM);
        author = "Lucas Burnett";
        name = "Burning Memory";
    }

    @Override
    public String getId() {
        return FadenCoreIdentifier.create("burning_memory").toString();
    }
}
