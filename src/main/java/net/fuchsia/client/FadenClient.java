package net.fuchsia.client;

import json.jayson.faden.core.client.FadenCoreClient;
import json.jayson.faden.core.client.overlay.InstrumentMusicOverlay;
import json.jayson.faden.core.client.overlay.StatsOverlay;
import json.jayson.faden.core.client.render.entity.NPCEntityRenderer;
import json.jayson.faden.core.common.init.FadenCoreEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fuchsia.client.objects.particles.BlossomParticle;
import net.fuchsia.common.init.FadenParticles;
import net.fuchsia.common.init.blocks.FadenBuildingBlocks;
import net.minecraft.client.render.RenderLayer;

import java.util.ArrayList;

public class FadenClient implements ClientModInitializer {

    public static ArrayList<String> SPLASHES = new ArrayList<>();


    @Override
    public void onInitializeClient() {
        addSplashes();

        HudRenderCallback.EVENT.register(new StatsOverlay());
        HudRenderCallback.EVENT.register(new InstrumentMusicOverlay());

        EntityRendererRegistry.register(FadenCoreEntities.NPC, (context) -> new NPCEntityRenderer(context));
        setBlockRenderMaps();
        registerParticles();
    }

    public void registerParticles() {
        ParticleFactoryRegistry.getInstance().register(FadenParticles.BLOSSOM, BlossomParticle.Factory::new);
    }

    public void setBlockRenderMaps() {
        BlockRenderLayerMap.INSTANCE.putBlock(FadenBuildingBlocks.BLOSSOM_LANTERN, RenderLayer.getCutout());
    }

    private void addSplashes() {
        SPLASHES.add("Blame Derpy!");
        SPLASHES.add("Rabbit superiority!");
        SPLASHES.add("NOT a Furry Mod!");
        SPLASHES.add("Also try Wynncraft!");
    }
}
