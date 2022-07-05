package dev.wildmonke.retromod;

import dev.wildmonke.retromod.effect.ModEffects;
import dev.wildmonke.retromod.init.BlockInit;
import dev.wildmonke.retromod.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.network.GeckoLibNetwork;


@Mod(RetroMod.MODID)
public class RetroMod {
    public static final String MODID = "retromod";

    public RetroMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
        ModEffects.MOD_EFFECTS.register(bus);

        GeckoLib.initialize();
    }

    public static final CreativeModeTab RETRO_TAB = new CreativeModeTab(MODID) {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.EXAMPLE_BLOCK_ITEM.get());
        }
    };
}
