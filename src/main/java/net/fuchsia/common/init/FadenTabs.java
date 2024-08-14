package net.fuchsia.common.init;

import json.jayson.faden.core.common.init.FadenCoreClothes;
import json.jayson.faden.core.common.init.items.FadenCoreGear;
import json.jayson.faden.core.common.objects.item.cloth.ClothItem;
import json.jayson.faden.core.common.objects.item.gear.bracelet.BraceletItem;
import json.jayson.faden.core.common.objects.item.gear.necklace.NecklaceItem;
import json.jayson.faden.core.datagen.FadenCoreDataGen;
import json.jayson.faden.core.datagen.holders.BuildingBlockDataEntry;
import json.jayson.faden.core.datagen.holders.FadenDataItem;
import net.fuchsia.common.init.blocks.FadenBuildingBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fuchsia.common.init.items.FadenCraftingItems;
import net.fuchsia.common.init.items.FadenGear;
import net.fuchsia.common.init.items.FadenInstruments;
import net.fuchsia.common.init.items.FadenItems;
import net.fuchsia.util.FadenIdentifier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class FadenTabs {

    public static final ItemGroup FADEN = Registry.register(Registries.ITEM_GROUP, FadenIdentifier.create("misc_tab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.faden.misc")).icon(() -> new ItemStack(FadenItems.COPPER_COIN)).entries((displayContext, entries) -> {
                for (FadenDataItem item : FadenCoreDataGen.ITEMS) {
                    if(item.group() == FadenTabs.FADEN) {
                        entries.add(item.item());
                    }
                }
            }).build());

    public static final ItemGroup FADEN_CLOTHES = Registry.register(Registries.ITEM_GROUP, FadenIdentifier.create("clothes_tab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.faden.clothes")).icon(() -> new ItemStack(FadenItems.AMETHYST_COIN)).entries((displayContext, entries) -> {
                for (ClothItem cloth : FadenCoreClothes.CLOTHES) {
                    entries.add(cloth);
                }
            }).build());

    public static final ItemGroup FADEN_GEAR = Registry.register(Registries.ITEM_GROUP, FadenIdentifier.create("gear_tab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.faden.gear")).icon(() -> new ItemStack(FadenGear.WARRIORS_BRACELET)).entries((displayContext, entries) -> {
                for (BraceletItem bracelet : FadenCoreGear.BRACELETS) {
                    entries.add(bracelet);
                }

                for (NecklaceItem necklace : FadenCoreGear.NECKLACES) {
                    entries.add(necklace);
                }
            }).build());

    public static final ItemGroup FADEN_BUILDING = Registry.register(Registries.ITEM_GROUP, FadenIdentifier.create("building_tab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.faden.building")).icon(() -> new ItemStack(FadenBuildingBlocks.GRANITE_BRICKS)).entries((displayContext, entries) -> {
                for (BuildingBlockDataEntry buildingBlock : FadenCoreDataGen.BLOCKS) {
                    entries.add(buildingBlock.block());
                }
            }).build());

    public static final ItemGroup FADEN_INSTRUMENTS = Registry.register(Registries.ITEM_GROUP, FadenIdentifier.create("instrument_tab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.faden.instruments")).icon(() -> new ItemStack(FadenInstruments.LUTE)).entries((displayContext, entries) -> {
                for (FadenDataItem item : FadenCoreDataGen.ITEMS) {
                    if(item.group() == FadenTabs.FADEN_INSTRUMENTS) {
                        entries.add(item.item());
                    }
                }
            }).build());

    public static final ItemGroup FADEN_CRAFTING = Registry.register(Registries.ITEM_GROUP, FadenIdentifier.create("crafting_tab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.faden.crafting")).icon(() -> new ItemStack(FadenCraftingItems.BROWN_CLOTH)).entries((displayContext, entries) -> {
                for (FadenDataItem item : FadenCoreDataGen.ITEMS) {
                    if(item.group() == FadenTabs.FADEN_CRAFTING) {
                        entries.add(item.item());
                    }
                }
            }).build());


    public static void init() {}

}
