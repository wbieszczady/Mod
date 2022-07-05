package dev.wildmonke.retromod.effect;

import dev.wildmonke.retromod.RetroMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOD_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, RetroMod.MODID);

    public static final RegistryObject<MobEffect> PHASE = MOD_EFFECTS.register("phase", () -> new PhaseEffect(MobEffectCategory.BENEFICIAL, 3124687));
    public static final RegistryObject<MobEffect> LYNCH = MOD_EFFECTS.register("lynch", () -> new LynchEffect(MobEffectCategory.BENEFICIAL, 3124687));
    public static final RegistryObject<MobEffect> SENTIENT = MOD_EFFECTS.register("sentient", () -> new SentientEffect(MobEffectCategory.BENEFICIAL, 14270531));


    public static void register(IEventBus eventBus) {
        MOD_EFFECTS.register(eventBus);
    }
}
