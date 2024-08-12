package net.fuchsia.common.quest;

import net.fuchsia.util.FadenIdentifier;
import org.jetbrains.annotations.Nullable;

import net.fuchsia.common.quest.data.FadenQuest;
import net.fuchsia.common.quest.data.IQuestStep;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TestQuest extends FadenQuest {

    @Override
    public Identifier id() {
        return FadenIdentifier.create("test_quest");
    }

    @Override
    public void setupQuestSteps() {
        getSteps().add(new IQuestStep() {
            @Override
            public Identifier id() {
                return FadenIdentifier.create("use_test_item");
            }

            @Override
            public void rewardAndFinish(PlayerEntity player) {
                player.sendMessage(Text.literal("USED TEST ITEM!"));
            }

            @Override
            public @Nullable Identifier nextStep() {
                return FadenIdentifier.create("use_coin");
            }
        });

        getSteps().add(new IQuestStep() {
            @Override
            public Identifier id() {
                return FadenIdentifier.create("use_coin");
            }

            @Override
            public void rewardAndFinish(PlayerEntity player) {
                player.sendMessage(Text.literal("USED USE_COIN!!"));
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
