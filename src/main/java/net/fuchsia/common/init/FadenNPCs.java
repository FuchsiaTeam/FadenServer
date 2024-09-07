package net.fuchsia.common.init;

import json.jayson.faden.core.common.npc.NPC;
import json.jayson.faden.core.common.npc.NPCTexture;
import json.jayson.faden.core.common.race.Race;
import json.jayson.faden.core.registry.FadenCoreRegistry;
import json.jayson.faden.core.server.PlayerData;
import net.fuchsia.util.FadenIdentifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

import java.util.Optional;

public class FadenNPCs {
    public static NPC TEST = register("test", new NPC() {
        @Override
        public NPCTexture getTexture() {
            return new NPCTexture("black_harengon", true, Identifier.of("faden:skin/black/black_harengon_default"));
        }

        @Override
        public ActionResult interaction(PlayerEntity player, Vec3d hitPos, Hand hand) {
            FadenQuests.TEST.startQuest(player.getUuid());
            FadenQuests.TEST.checkAndRewardStep(player, FadenIdentifier.create("talk_to_npc_again"));
            FadenQuests.TEST.checkAndRewardStep(player, FadenIdentifier.create("talk_to_npc"));
            return ActionResult.CONSUME;
        }

        @Override
        public Optional<Race> getRace() {
            return Optional.of(FadenRaces.HARENGON);
        }

        @Override
        public String getRaceSub() {
            return "black";
        }

        @Override
        public PlayerData.RaceDataCosmetics getRaceCosmetics() {
            PlayerData.RaceDataCosmetics cosmetics = new PlayerData.RaceDataCosmetics();
            cosmetics.getHead().add("ear_0");
            return cosmetics;
        }
    });

    public static NPC TEST2 = register("test2", new NPC() {
        @Override
        public NPCTexture getTexture() {
            return new NPCTexture("black_harengon", true, Identifier.of("faden:skin/white/white_harengon_default"));
        }

        @Override
        public ActionResult interaction(PlayerEntity player, Vec3d hitPos, Hand hand) {
            FadenQuests.TEST.startQuest(player.getUuid());
            FadenQuests.TEST.checkAndRewardStep(player, FadenIdentifier.create("talk_to_npc_again"));
            FadenQuests.TEST.checkAndRewardStep(player, FadenIdentifier.create("talk_to_npc"));
            return ActionResult.CONSUME;
        }

        @Override
        public Optional<Race> getRace() {
            return Optional.of(FadenRaces.HARENGON);
        }

        @Override
        public String getRaceSub() {
            return "white";
        }

        @Override
        public PlayerData.RaceDataCosmetics getRaceCosmetics() {
            PlayerData.RaceDataCosmetics cosmetics = new PlayerData.RaceDataCosmetics();
            cosmetics.getHead().add("ear_0");
            return cosmetics;
        }
    });

    public static NPC register(String name, NPC npc) {
        return Registry.register(FadenCoreRegistry.NPC, FadenIdentifier.create(name), npc);
    }

    public static void init() {}
}
