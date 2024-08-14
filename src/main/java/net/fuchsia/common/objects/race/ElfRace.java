package net.fuchsia.common.objects.race;

import json.jayson.faden.core.common.race.Race;
import json.jayson.faden.core.common.race.RaceModelType;
import json.jayson.faden.core.common.race.cosmetic.RaceCosmeticPalette;
import net.fuchsia.util.FadenIdentifier;
import org.joml.Vector3f;

public class ElfRace extends Race {

    public ElfRace() {
        super(new String[]{"pale", "drow"}, new Vector3f(0.95f, 0.95f, 0.95f));
    }

    @Override
    public RaceCosmeticPalette getCosmeticPalette() {
        return RaceCosmetics.ELF;
    }

    @Override
    public RaceModelType model() {
        return RaceModelType.SLIM;
    }

}
