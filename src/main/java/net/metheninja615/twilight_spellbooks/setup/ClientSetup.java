package net.metheninja615.twilight_spellbooks.setup;

import net.metheninja615.twilight_spellbooks.TwilightSpellbooks;
import net.metheninja615.twilight_spellbooks.registries.EntityRegistries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import twilightforest.client.renderer.entity.SlimeBeetleRenderer;

@EventBusSubscriber(modid = TwilightSpellbooks.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    @SubscribeEvent
    public static void rendererRegister(EntityRenderersEvent.RegisterRenderers event) {
       event.registerEntityRenderer(EntityRegistries.SUMMONED_SLIME_BEETLE.get(),SlimeBeetleRenderer::new);
    }
    }

