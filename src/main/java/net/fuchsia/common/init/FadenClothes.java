package net.fuchsia.common.init;

import json.jayson.faden.core.common.objects.cloth.FadenCoreCloth;
import json.jayson.faden.core.registry.FadenCoreRegistry;
import net.fuchsia.util.FadenIdentifier;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

public class FadenClothes {

    public static FadenCoreCloth TEST_CLOTH = new FadenCoreCloth() {
        @Override
        public Pair<Identifier, Identifier> getTexture() {
            return new Pair<>(FadenIdentifier.create("cloth/test_cloth"), FadenIdentifier.create("cloth/test_cloth_wide"));
        }
    };

    public static void init() {
        Registry.register(FadenCoreRegistry.CLOTH, FadenIdentifier.create("test_cloth"), TEST_CLOTH);
    }

}
