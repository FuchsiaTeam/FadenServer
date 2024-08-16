package net.fuchsia.common.objects.race;

import json.jayson.faden.core.common.race.Race;
import json.jayson.faden.core.common.race.RaceModelType;
import json.jayson.faden.core.common.race.cosmetic.RaceCosmetic;
import json.jayson.faden.core.common.race.cosmetic.RaceCosmeticPalette;
import json.jayson.faden.core.common.race.cosmetic.RaceCosmeticSlot;
import json.jayson.faden.core.server.PlayerData;
import net.fuchsia.util.FadenIdentifier;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TabaxiRace extends Race {

    public TabaxiRace() {
        super(new String[]{""}, new Vector3f(1, 1, 1));
    }

    @Override
    public RaceCosmeticPalette getCosmeticPalette() {
        return new RaceCosmeticPalette();
    }

    @Override
    public RaceModelType model() {
        return RaceModelType.BOTH;
    }

    @Override
    public PlayerData.RaceDataCosmetics randomizeCosmetics(String subId) {
        List<RaceCosmetic> ears = new ArrayList<>();
        List<RaceCosmetic> mouths = new ArrayList<>();
        getCosmeticPalette().getCosmetics(subId).stream()
                .filter(cosmetic -> cosmetic.getSlot() == RaceCosmeticSlot.HEAD)
                .forEach(cosmetic -> {
                    switch (cosmetic.getType()) {
                        case "ear" -> ears.add(cosmetic);
                        case "mouth" -> mouths.add(cosmetic);
                    }
                });

        Random random = new Random();
        PlayerData.RaceDataCosmetics dataCosmetics = new PlayerData.RaceDataCosmetics();
        if (!ears.isEmpty()) dataCosmetics.getHead().add(ears.get(random.nextInt(ears.size())).getId());
        if (!mouths.isEmpty()) dataCosmetics.getHead().add(mouths.get(random.nextInt(mouths.size())).getId());
        return dataCosmetics;
    }
}

