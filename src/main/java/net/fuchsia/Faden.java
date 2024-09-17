package net.fuchsia;

import json.jayson.faden.core.FadenCore;
import json.jayson.faden.core.FadenCoreApi;
import json.jayson.faden.core.client.interfaces.IModelTransformation;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fuchsia.common.cape.FadenCapes;
import net.fuchsia.common.init.*;
import net.fuchsia.common.init.blocks.FadenBlocks;
import net.fuchsia.common.init.blocks.FadenBuildingBlocks;
import net.fuchsia.common.init.items.*;

import net.fabricmc.api.ModInitializer;
import net.fuchsia.common.objects.race.RaceCosmetics;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;

public class Faden implements ModInitializer, FadenCoreApi {
	public static final String MOD_ID = "faden";

	public static void init() {
		FadenNPCs.init();
		FadenRaces.init();
		RaceCosmetics.add();
		FadenSoundEvents.init();
		FadenItems.init();
		FadenTabs.init();
		FadenGear.init();
		FadenBlocks.init();
		//OnlineCapes.retrieve();
		FadenBuildingBlocks.init();
		FadenInstruments.init();
		FadenCraftingItems.init();
		FadenClothes.init();
		FadenMusicInstances.init();
		FadenCapes.init();
		FadenQuests.init();
	}

	@Override
	public void onInitialize() {
		init();
	}

	@Override
	public boolean enablePlayerData() {
		return true;
	}

	@Override
	public boolean enableQuests() {
		return true;
	}

	@Override
	public boolean enableItemValues() {
		return true;
	}
}