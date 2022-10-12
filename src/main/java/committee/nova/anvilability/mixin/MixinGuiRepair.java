package committee.nova.anvilability.mixin;

import committee.nova.anvilability.util.Utilities$;
import net.minecraft.client.gui.GuiRepair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(GuiRepair.class)
public abstract class MixinGuiRepair {
    @ModifyConstant(method = "drawGuiContainerForegroundLayer", constant = @Constant(intValue = 40, ordinal = 0))
    private int modify$maxCost(int constant) {
        return Utilities$.MODULE$.getMaxLevel();
    }
}
