package net.fuchsia.common.objects.race;

import com.google.common.collect.Multimap;
import net.fuchsia.util.FadenIdentifier;
import json.jayson.faden.core.common.race.Race;
import json.jayson.faden.core.common.race.RaceModelType;
import json.jayson.faden.core.common.race.cosmetic.RaceCosmeticPalette;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.registry.entry.RegistryEntry;
import org.joml.Vector3f;

public class LocathahRace extends Race {

    public LocathahRace() {
        super(new String[]{"default"}, new Vector3f(1, 1, 1));
    }

    @Override
    public RaceCosmeticPalette getCosmeticPalette() {
        return new RaceCosmeticPalette();
    }

    @Override
    public RaceModelType getModelType() {
        return RaceModelType.BOTH;
    }

    @Override
    protected void addEntityAttributes(Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> modifiers) {
        modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(FadenIdentifier.create("health"), -8, EntityAttributeModifier.Operation.ADD_VALUE));
        modifiers.put(EntityAttributes.GENERIC_OXYGEN_BONUS, new EntityAttributeModifier(FadenIdentifier.create("oxygen"), 10, EntityAttributeModifier.Operation.ADD_VALUE));
        modifiers.put(EntityAttributes.GENERIC_BURNING_TIME, new EntityAttributeModifier(FadenIdentifier.create("burning_time"), -5, EntityAttributeModifier.Operation.ADD_VALUE));
        modifiers.put(EntityAttributes.GENERIC_WATER_MOVEMENT_EFFICIENCY, new EntityAttributeModifier(FadenIdentifier.create("water_efficiency"), 10, EntityAttributeModifier.Operation.ADD_VALUE));
        modifiers.put(EntityAttributes.PLAYER_SUBMERGED_MINING_SPEED, new EntityAttributeModifier(FadenIdentifier.create("water_mining"), 2.5, EntityAttributeModifier.Operation.ADD_VALUE));
        modifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(FadenIdentifier.create("attack_damage"), -4, EntityAttributeModifier.Operation.ADD_VALUE));
        modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(FadenIdentifier.create("speed"), -0.25f, EntityAttributeModifier.Operation.ADD_VALUE));
    }

    @Override
    public float waterMovementSpeed() {
        return 0.15F;
    }
}
