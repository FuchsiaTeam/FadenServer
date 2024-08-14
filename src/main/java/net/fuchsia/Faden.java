package net.fuchsia;

import json.jayson.faden.core.FadenCore;
import net.fuchsia.common.cape.FadenCapes;
import net.fuchsia.common.init.*;
import net.fuchsia.common.init.blocks.FadenBlocks;
import net.fuchsia.common.init.blocks.FadenBuildingBlocks;
import net.fuchsia.common.init.items.*;

import net.fabricmc.api.ModInitializer;
import net.fuchsia.common.objects.race.RaceCosmetics;

public class Faden implements ModInitializer {
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
		FadenCore.setupFadenAddon(MOD_ID);
	}

	@Override
	public void onInitialize() {
		init();
	}
}