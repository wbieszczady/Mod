package dev.wildmonke.retromod.init;

import dev.wildmonke.retromod.BaseToolMaterial;
import net.minecraft.world.item.Tier;

public class ToolMaterialInit {
    private ToolMaterialInit() {

    }

    protected static final Tier PHASE = new BaseToolMaterial(16f, 500, 5, 5f, 2500, null); //null >>> () -> Ingredient.of(ItemInit.[item].get())
    protected static final Tier LYNCH = new BaseToolMaterial(16f, 500, 5, 5f, 2500, null);
    protected static final Tier SENTIENT = new BaseToolMaterial(16f, 500, 5, 5f, 2500, null);

}
