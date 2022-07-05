package dev.wildmonke.retromod.items;


import dev.wildmonke.retromod.effect.ModEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class SentientSword extends SwordItem {


    public SentientSword(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {

        if(Screen.hasShiftDown()) {
            components.add(Component.literal("Right click to enter a Sentient's Rage!").withStyle(ChatFormatting.GOLD));
        } else {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.YELLOW));
        }



        super.appendHoverText(stack, level, components, flag);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker.hasEffect(ModEffects.SENTIENT.get()) == true ) {
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 8), attacker);
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            player.getCooldowns().addCooldown(this, 400);


            //Phase
            player.removeEffect(MobEffects.MOVEMENT_SPEED);
            player.removeEffect(MobEffects.NIGHT_VISION);
            player.removeEffect(MobEffects.GLOWING);
            player.removeEffect(MobEffects.ABSORPTION);
            player.removeEffect(ModEffects.PHASE.get());


            //Lynch
            player.removeEffect(MobEffects.HEALTH_BOOST);
            player.removeEffect(MobEffects.REGENERATION);
            player.removeEffect(ModEffects.LYNCH.get());


            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 1));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1));
            player.addEffect(new MobEffectInstance(MobEffects.LUCK, 200, 3));
            player.addEffect(new MobEffectInstance(ModEffects.SENTIENT.get(), 200, 0));

            double xd = player.getX();
            double yd = player.getY();
            double zd = player.getZ();

            level.addParticle(ParticleTypes.LARGE_SMOKE, xd, yd, zd, 0.0d, 0.0d, 0.0d);
            level.playSound((Player)null, xd, yd, zd, SoundEvents.LIGHTNING_BOLT_IMPACT, SoundSource.PLAYERS, 1.0F, 1.0F);
        }

        return super.use(level, player, hand);

    }




}

