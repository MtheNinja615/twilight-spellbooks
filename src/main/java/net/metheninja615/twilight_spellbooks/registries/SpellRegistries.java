package net.metheninja615.twilight_spellbooks.registries;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.metheninja615.twilight_spellbooks.TwilightSpellbooks;
import net.metheninja615.twilight_spellbooks.spells.SummonSlimeBeetles;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static io.redspace.ironsspellbooks.api.registry.SpellRegistry.SPELL_REGISTRY_KEY;

public class SpellRegistries {
    public static final DeferredRegister<AbstractSpell> SPELLS = DeferredRegister.create(SPELL_REGISTRY_KEY, TwilightSpellbooks.MODID);

    public static Supplier<AbstractSpell> registerSpell(AbstractSpell spell) {
        return SPELLS.register(spell.getSpellName(), () -> spell);
    }
    /***
     * * Nature
     */

    //Petal Step
    public static final Supplier<AbstractSpell> SummonSlimeBeetles = registerSpell(new SummonSlimeBeetles());
}
