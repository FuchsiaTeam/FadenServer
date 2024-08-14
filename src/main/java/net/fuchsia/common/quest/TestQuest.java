package net.fuchsia.common.quest;

import json.jayson.faden.core.common.quest.data.FadenCoreQuest;
import json.jayson.faden.core.common.quest.data.IQuestStep;
import net.fuchsia.util.FadenIdentifier;
import org.jetbrains.annotations.Nullable;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TestQuest extends FadenCoreQuest {

    @Override
    public void setupQuestSteps() {
        getSteps().add(new IQuestStep() {
            @Override
            public Identifier id() {
                return FadenIdentifier.create("talk_to_npc");
            }

            @Override
            public void rewardAndFinish(PlayerEntity player) {
                player.sendMessage(Text.literal("Talked to Test NPC : Started Test Quest, talk again to finish"));
            }

            @Override
            public @Nullable Identifier nextStep() {
                return FadenIdentifier.create("talk_to_npc_again");
            }
        });

        getSteps().add(new IQuestStep() {
            @Override
            public Identifier id() {
                return FadenIdentifier.create("talk_to_npc_again");
            }

            @Override
            public void rewardAndFinish(PlayerEntity player) {
                player.sendMessage(Text.literal("Talked again to NPC"));
            }

            @Override
            public @Nullable Identifier nextStep() {
                return null;
            }
        });
    }

    @Override
    public void finishQuest(PlayerEntity player) {
        player.sendMessage(Text.literal("Finished Test Quest"));
    }
}
