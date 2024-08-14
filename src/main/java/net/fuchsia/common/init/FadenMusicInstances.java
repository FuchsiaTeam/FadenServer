package net.fuchsia.common.init;

import json.jayson.faden.core.common.objects.music_instance.InstrumentedMusic;
import json.jayson.faden.core.registry.FadenCoreRegistry;
import net.fuchsia.common.objects.songs.BurningMemoryMusic;
import net.fuchsia.common.objects.songs.TheMistMusic;
import net.fuchsia.util.FadenIdentifier;
import net.minecraft.registry.Registry;

public class FadenMusicInstances {

    public static InstrumentedMusic BURNING_MEMORY = register("burning_memory", new BurningMemoryMusic());
    public static InstrumentedMusic THE_MIST = register("the_mist", new TheMistMusic());

    public static InstrumentedMusic register(String name, InstrumentedMusic npc) {
        return Registry.register(FadenCoreRegistry.INSTRUMENTED_MUSIC, FadenIdentifier.create(name), npc);
    }

    public static void init() {}

}
