package net.fuchsia.common.init;

import json.jayson.faden.core.common.objects.music_instance.InstrumentedMusic;
import json.jayson.faden.core.common.quest.data.FadenCoreQuest;
import json.jayson.faden.core.registry.FadenCoreRegistry;
import net.fuchsia.common.quest.TestQuest;
import net.fuchsia.util.FadenIdentifier;
import net.minecraft.registry.Registry;

public class FadenQuests {

    public static FadenCoreQuest TEST = register("test", new TestQuest());

    public static FadenCoreQuest register(String name, FadenCoreQuest quest) {
        return Registry.register(FadenCoreRegistry.QUEST, FadenIdentifier.create(name), quest);
    }

    public static void init() {}

}
