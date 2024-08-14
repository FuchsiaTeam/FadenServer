package net.fuchsia.common.cape;

import json.jayson.faden.core.FadenCore;
import json.jayson.faden.core.common.cape.online.OnlineCape;
import json.jayson.faden.core.common.cape.online.OnlineCapeCache;
import json.jayson.faden.core.config.FadenCoreOptions;
import json.jayson.faden.core.util.FadenCoreOnlineUtil;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

import java.io.File;
import java.nio.file.Path;

@Deprecated
public class OnlineCapes {

    private static final Path CACHE_PATH = new File(FabricLoader.getInstance().getGameDir().toString() + "/faden/cache/client/online_capes.json").toPath();
    public static OnlineCapeCache ONLINE_CAPES = new OnlineCapeCache();

    public static void retrieve()  {
        if(FadenCoreOptions.getConfig().CUSTOM_CAPES) {
            ONLINE_CAPES = FadenCore.GSON.fromJson(FadenCoreOnlineUtil.getJSONDataOrCache("https://raw.githubusercontent.com/FuchsiaTeam/FadenData/main/online_capes.json", CACHE_PATH.toFile(), ""), OnlineCapeCache.class);
            for (OnlineCape onlineCape : ONLINE_CAPES.CAPES) {
                //FadenCoreCapes.registerOnlineCape(Identifier.of(onlineCape.id)).setTextureData(onlineCape.textureData);
            }
        }
    }

}
