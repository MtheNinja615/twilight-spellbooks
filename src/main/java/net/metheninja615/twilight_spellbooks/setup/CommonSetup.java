package net.metheninja615.twilight_spellbooks.setup;

import net.metheninja615.twilight_spellbooks.TwilightSpellbooks;
import net.metheninja615.twilight_spellbooks.entities.mobs.SummonedSlimeBeetleMob;
import net.metheninja615.twilight_spellbooks.registries.EntityRegistries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = TwilightSpellbooks.MODID, bus = EventBusSubscriber.Bus.MOD)
public class CommonSetup {

    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(EntityRegistries.SUMMONED_SLIME_BEETLE.get(), SummonedSlimeBeetleMob.createAttributes().build());
    }
}
