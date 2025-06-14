package net.metheninja615.twilight_spellbooks.registries;

import net.metheninja615.twilight_spellbooks.TwilightSpellbooks;
import net.metheninja615.twilight_spellbooks.entities.mobs.SummonedSlimeBeetleMob;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EntityRegistries {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, TwilightSpellbooks.MODID);

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

    public static final DeferredHolder<EntityType<?>, EntityType<SummonedSlimeBeetleMob>> SUMMONED_SLIME_BEETLE =
            ENTITIES.register("summoned_slime_beetle", () -> EntityType.Builder.<SummonedSlimeBeetleMob>of(SummonedSlimeBeetleMob::new, MobCategory.CREATURE)

                    .sized(1.4F, 1.4F)
                    .clientTrackingRange(64)
                    .build(ResourceLocation.fromNamespaceAndPath(TwilightSpellbooks.MODID, "summoned_slime_beetle").toString()));
}
