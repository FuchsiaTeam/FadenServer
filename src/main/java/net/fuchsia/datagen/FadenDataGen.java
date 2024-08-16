package net.fuchsia.datagen;

import json.jayson.faden.core.datagen.FadenCoreDataGen;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import json.jayson.faden.core.datagen.asset.*;
import json.jayson.faden.core.datagen.data.*;
import net.fuchsia.Faden;

public class FadenDataGen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FadenCoreDataGen.MOD_ID = Faden.MOD_ID;
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(FadenDataModelProvider::new);
        pack.addProvider(FadenItemTagProvider::new);
        pack.addProvider(FadenBlockTagProvider::new);
        pack.addProvider(FadenLootTableProvider::new);
        pack.addProvider(FadenLanguageProvider::new);
        pack.addProvider(FadenRecipeProvider::new);
    }

}
