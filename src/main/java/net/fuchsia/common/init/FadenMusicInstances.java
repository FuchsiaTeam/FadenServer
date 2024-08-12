package net.fuchsia.common.init;

import net.fuchsia.common.objects.music_instance.InstrumentedMusic;
import net.fuchsia.common.objects.songs.BurningMemoryMusic;
import net.fuchsia.common.objects.songs.TheMistMusic;
import net.fuchsia.util.FadenIdentifier;

public class FadenMusicInstances {

    public static InstrumentedMusic BURNING_MEMORY = FadenCoreMusicInstances.register(FadenIdentifier.create("burning_memory"), new BurningMemoryMusic());
    public static InstrumentedMusic THE_MIST = FadenCoreMusicInstances.register(FadenIdentifier.create("the_mist"), new TheMistMusic());

    public static void register() {}

}
