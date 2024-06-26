package net.fuchsia.common.quest.data;

import java.util.List;
import java.util.UUID;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public interface IQuest {

    Identifier id();
    int getMaxSteps();

    void setupQuestSteps();
    List<IQuestStep> getSteps();
    IQuestStep getCurrentStep(UUID player);
    void startQuest(UUID player);

    void finishQuest(PlayerEntity player);
}
