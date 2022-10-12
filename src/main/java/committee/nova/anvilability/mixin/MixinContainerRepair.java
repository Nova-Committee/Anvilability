package committee.nova.anvilability.mixin;

import committee.nova.anvilability.util.Utilities$;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.ContainerRepair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ContainerRepair.class)
public abstract class MixinContainerRepair {
    @ModifyConstant(method = "updateRepairOutput", constant = @Constant(intValue = 40, ordinal = 1))
    public int modify$updateRepairOutput(int constant) {
        return Utilities$.MODULE$.getMaxLevel();
    }

    @Redirect(method = "updateRepairOutput", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantment;getMaxLevel()I"))
    public int redirect$updateRepairOutput(Enchantment instance) {
        return Utilities$.MODULE$.getMaxEnchantmentLevel(instance);
    }
}
