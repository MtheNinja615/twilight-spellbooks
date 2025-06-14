package net.metheninja615.twilight_spellbooks.spells;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.events.SpellSummonEvent;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import net.metheninja615.twilight_spellbooks.TwilightSpellbooks;
import net.metheninja615.twilight_spellbooks.entities.mobs.SummonedSlimeBeetleMob;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForge;

import java.util.List;
import java.util.Optional;

@AutoSpellConfig
public class SummonSlimeBeetles extends AbstractSpell {
    private final ResourceLocation spellId =  ResourceLocation.fromNamespaceAndPath(TwilightSpellbooks.MODID, "summon_slime_beetles");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.hp", getSlimeBeetleHealth(spellLevel, null)),
                Component.translatable("ui.irons_spellbooks.damage", getSlimeBeetleDamage(spellLevel, null))
        );
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.RARE)
            .setSchoolResource(SchoolRegistry.NATURE_RESOURCE)
            .setMaxLevel(10)
            .setCooldownSeconds(280)
            .build();

    public SummonSlimeBeetles() {
        this.manaCostPerLevel = 10;
        this.baseSpellPower = 4;
        this.spellPowerPerLevel = 1;
        this.castTime = 20;
        this.baseManaCost = 50;
    }

    @Override
    public CastType getCastType() {
        return CastType.LONG;
    }

    @Override
    public DefaultConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public ResourceLocation getSpellResource() {
        return spellId;
    }

    @Override
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(SoundEvents.SPIDER_AMBIENT);
    }

    @Override
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        int summonTime = 100;

        SummonedSlimeBeetleMob slime_beetle = new SummonedSlimeBeetleMob(world, entity);
        slime_beetle.setPos(entity.position());

        slime_beetle.getAttributes().getInstance(Attributes.ATTACK_DAMAGE).setBaseValue(getSlimeBeetleDamage(spellLevel, entity));
        slime_beetle.getAttributes().getInstance(Attributes.MAX_HEALTH).setBaseValue(getSlimeBeetleHealth(spellLevel, entity));
        slime_beetle.setHealth(slime_beetle.getMaxHealth());
        var event = NeoForge.EVENT_BUS.post(new SpellSummonEvent<SummonedSlimeBeetleMob>(entity, slime_beetle, this.spellId, spellLevel));
        world.addFreshEntity(event.getCreature());

        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }

    private float getSlimeBeetleHealth(int spellLevel, LivingEntity caster) {
        return 50 + spellLevel * 4;
    }

    private float getSlimeBeetleDamage(int spellLevel, LivingEntity caster) {
        return getSpellPower(spellLevel, caster);
    }


}
