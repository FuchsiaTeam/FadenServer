package net.fuchsia.common.cape;

import net.fabricmc.loader.api.FabricLoader;
import net.fuchsia.FadenCore;
import net.fuchsia.common.cape.online.OnlineCape;
import net.fuchsia.common.cape.online.OnlineCapeCache;
import net.fuchsia.config.FadenCoreOptions;
import net.fuchsia.util.FadenCoreOnlineUtil;
import net.minecraft.util.Identifier;

import java.io.File;
import java.nio.file.Path;

public class OnlineCapes {

    private static final Path CACHE_PATH = new File(FabricLoader.getInstance().getGameDir().toString() + "/faden/cache/client/online_capes.json").toPath();
    public static OnlineCapeCache ONLINE_CAPES = new OnlineCapeCache();

    public static void retrieve()  {
        if(FadenCoreOptions.getConfig().CUSTOM_CAPES) {
            ONLINE_CAPES = FadenCore.GSON.fromJson(FadenCoreOnlineUtil.getJSONDataOrCache("https://raw.githubusercontent.com/FuchsiaTeam/FadenData/main/online_capes.json", CACHE_PATH.toFile(), FadenCore.CHECKSUMS.online_capes), OnlineCapeCache.class);
            for (OnlineCape onlineCape : ONLINE_CAPES.CAPES) {
                FadenCoreCapes.registerOnlineCape(Identifier.of(onlineCape.id)).setTextureData(onlineCape.textureData);
            }
        }
    }

}
