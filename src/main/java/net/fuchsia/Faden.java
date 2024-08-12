package net.fuchsia;

import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fuchsia.common.cape.FadenCapes;
import net.fuchsia.common.init.*;
import net.fuchsia.common.init.blocks.FadenBlocks;
import net.fuchsia.common.init.blocks.FadenBuildingBlocks;
import net.fuchsia.common.init.items.*;

import net.fabricmc.api.ModInitializer;
import net.fuchsia.common.objects.CoinMap;
import net.fuchsia.common.objects.race.RaceCosmetics;
import net.minecraft.util.Identifier;

public class Faden implements ModInitializer {
	public static final String MOD_ID = "faden";

	public static void init() {
		FadenNPCs.register();
		FadenRaces.register();
		RaceCosmetics.add();
		FadenSoundEvents.register();
		FadenItems.register();
		FadenTabs.register();
		FadenGear.register();
		FadenBlocks.register();
		//OnlineCapes.retrieve();
		FadenBuildingBlocks.register();
		FadenInstruments.register();
		FadenCraftingItems.register();
		FadenClothes.register();
		FadenMusicInstances.register();
		FadenCapes.register();

		FadenCore.setupFadenAddon(MOD_ID, FadenItems.COPPER_COIN);
		CoinMap.reloadCoins();
	}

	@Override
	public void onInitialize() {
		init();
	}
}