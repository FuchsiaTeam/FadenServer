package net.fuchsia.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fuchsia.client.objects.particles.BlossomParticle;
import net.fuchsia.client.overlay.InstrumentMusicOverlay;
import net.fuchsia.client.overlay.StatsOverlay;
import net.fuchsia.client.render.entity.NPCEntityRenderer;
import net.fuchsia.common.init.FadenCoreEntities;
import net.fuchsia.common.init.FadenParticles;
import net.fuchsia.common.init.blocks.FadenBuildingBlocks;
import net.minecraft.client.render.RenderLayer;

public class FadenClient implements ClientModInitializer {

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
        FadenCoreClient.SPLASHES.add("Blame Derpy!");
        FadenCoreClient.SPLASHES.add("Rabbit superiority!");
        FadenCoreClient.SPLASHES.add("NOT a Furry Mod!");
        FadenCoreClient.SPLASHES.add("Also try Wynncraft!");
    }
}
