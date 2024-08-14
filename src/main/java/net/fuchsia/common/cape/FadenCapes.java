package net.fuchsia.common.cape;

import json.jayson.faden.core.common.cape.FadenCoreCape;
import json.jayson.faden.core.registry.FadenCoreRegistry;
import net.fuchsia.util.FadenIdentifier;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class FadenCapes {

    public static final FadenCoreCape FUCHSIA = register("fuchsia");
    public static final FadenCoreCape DEVELOPER = register("developer");
    public static final FadenCoreCape PIXEL_ARTIST = register("pixel_artist");
    public static final FadenCoreCape MUSIC_ARTIST = register("music_artist");
    public static final FadenCoreCape TRANSLATOR = register("translator");
    public static final FadenCoreCape STAFF = register("staff");
    public static final FadenCoreCape DONATOR = register("donator");
    public static final FadenCoreCape DATA = register("data");
    public static final FadenCoreCape BUILDER = register("builder");
    public static final FadenCoreCape DT10 = register("dt10");
    public static final FadenCoreCape SAKURA = register("sakura");
    public static final FadenCoreCape BLACKJACK = register("blackjack");

    public static FadenCoreCape register(String name) {
        return Registry.register(FadenCoreRegistry.CAPE, FadenIdentifier.create(name), new FadenCoreCape(Text.translatable("cape.faden." + name), Text.translatable("cape.faden." + name + ".description")));
    }

    public static void init() {}

}
