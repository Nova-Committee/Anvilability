package committee.nova.anvilability.mixin;

import committee.nova.anvilability.util.Utilities$;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class MixinItemStack {
    @Inject(method = "getRepairCost", at = @At("RETURN"), cancellable = true)
    public void inject$getRepairCost(CallbackInfoReturnable<Integer> cir) {
        if (cir.getReturnValueI() > 0 && !Utilities$.MODULE$.hasRepairCost((ItemStack) (Object) this))
            cir.setReturnValue(0);
    }

    @Inject(method = "setRepairCost", at = @At("HEAD"), cancellable = true)
    public void inject$setRepairCost(int cost, CallbackInfo ci) {
        if (!Utilities$.MODULE$.hasRepairCost((ItemStack) (Object) this)) ci.cancel();
    }
}
