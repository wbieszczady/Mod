package dev.wildmonke.retromod.entity.client.armor;

import dev.wildmonke.retromod.items.LynchArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class LynchArmorRenderer extends GeoArmorRenderer<LynchArmorItem> {
    public LynchArmorRenderer() {
            super(new LynchArmorModel());

            this.headBone = "armorHead";
            this.bodyBone = "armorBody";
            this.rightArmBone = "armorRightArm";
            this.leftArmBone = "armorLeftArm";
            this.rightLegBone = "armorLeftLeg";
            this.leftLegBone = "armorRightLeg";
            this.rightBootBone = "armorLeftBoot";
            this.leftBootBone = "armorRightBoot";
    }
}
