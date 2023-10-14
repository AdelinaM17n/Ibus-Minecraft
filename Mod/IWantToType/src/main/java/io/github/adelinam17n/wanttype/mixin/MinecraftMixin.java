package io.github.adelinam17n.wanttype.mixin;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(
            method = "<clinit>", at = @At("TAIL")
    )
    private static void setHeadlessAtClinit(CallbackInfo ci){
        System.setProperty("java.awt.headless", "false");
    }
}
