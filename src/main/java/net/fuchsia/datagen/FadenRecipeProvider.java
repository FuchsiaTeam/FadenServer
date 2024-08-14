package net.fuchsia.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fuchsia.common.init.blocks.FadenBuildingBlocks;
import net.fuchsia.util.FadenIdentifier;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class FadenRecipeProvider extends json.jayson.faden.core.datagen.data.FadenRecipeProvider {
    public FadenRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        super.generate(exporter);
        fourByFour(FadenBuildingBlocks.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE, exporter);
        fourByFour(FadenBuildingBlocks.DIORITE_BRICKS, Blocks.POLISHED_DIORITE, exporter);
        fourByFour(FadenBuildingBlocks.GRANITE_BRICKS, Blocks.POLISHED_GRANITE, exporter);
        fourByFour(FadenBuildingBlocks.GRANITE_TILES, FadenBuildingBlocks.GRANITE_BRICKS, exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, FadenBuildingBlocks.GRANUD_TILES, 4)
                .input('R', FadenBuildingBlocks.GRANITE_BRICKS)
                .input('C', Blocks.MUD_BRICKS)
                .pattern("RC")
                .pattern("CR")
                .criterion(hasItem(FadenBuildingBlocks.GRANITE_BRICKS), conditionsFromItem(FadenBuildingBlocks.GRANITE_BRICKS))
                .criterion(hasItem(Blocks.MUD_BRICKS), conditionsFromItem(Blocks.MUD_BRICKS))
                .offerTo(exporter, FadenIdentifier.create(Registries.BLOCK.getId(FadenBuildingBlocks.GRANUD_TILES).getPath()));
    }

}
