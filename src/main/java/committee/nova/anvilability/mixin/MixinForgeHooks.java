package committee.nova.anvilability.mixin;

import committee.nova.anvilability.util.Utilities$;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ForgeHooks.class, remap = false)
public abstract class MixinForgeHooks {
    @Inject(method = "onAnvilRepair", at = @At("RETURN"), cancellable = true)
    private static void inject$onAnvilRepair(EntityPlayer player, ItemStack output, ItemStack left, ItemStack right, CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(Utilities$.MODULE$.getAnvilBreakChance(cir.getReturnValueF()));
    }
}
