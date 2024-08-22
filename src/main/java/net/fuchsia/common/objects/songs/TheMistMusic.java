package net.fuchsia.common.objects.songs;

import json.jayson.faden.core.common.objects.item.instrument.InstrumentType;
import json.jayson.faden.core.common.objects.music_instance.InstrumentedMusic;
import net.fuchsia.common.init.FadenSoundEvents;
import net.fuchsia.common.init.items.FadenInstruments;
import net.fuchsia.util.FadenIdentifier;

public class TheMistMusic extends InstrumentedMusic {

    public TheMistMusic() {
        getInstrumentTypes().put(FadenInstruments.LUTE_TYPE, FadenSoundEvents.THE_MIST_LUTE);
        getInstrumentTypes().put(FadenInstruments.HURDY_TYPE, FadenSoundEvents.THE_MIST_HURTY);
        getInstrumentTypes().put(FadenInstruments.PANFLUTE_TYPE, FadenSoundEvents.THE_MIST_PANFLUTE);
        getInstrumentTypes().put(FadenInstruments.DRUM_TYPE, FadenSoundEvents.THE_MIST_DRUM);
        author = "Lucas Burnett";
        name = "The Mist";
    }

    @Override
    public String getId() {
        return FadenIdentifier.create("the_mist").toString();
    }

}
