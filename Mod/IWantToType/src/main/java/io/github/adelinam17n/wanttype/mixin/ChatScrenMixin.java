package io.github.adelinam17n.wanttype.mixin;

import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyEvent;
import java.awt.im.InputContext;
import java.awt.im.spi.InputMethod;

@Mixin(ChatScreen.class)
public abstract class ChatScrenMixin extends Screen {
    @Unique private boolean hasRemovedInitChar = false;

    @Shadow protected EditBox input;

    protected ChatScrenMixin(Component component) {
        super(component);
    }

    @Inject(
            method = "init",
            at = @At("TAIL")
    )
    private void backSpaceAtInit(CallbackInfo ci) throws AWTException {
       // if(!GraphicsEnvironment.isHeadless()){
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(8);

        //}
    }

    @Inject(
            method = "onEdited",
            at = @At("HEAD")
    )
    private void removeFirstCharAtOnEdited(String value, CallbackInfo ci){
        if(!hasRemovedInitChar){
            char c = value.charAt(0);

            if(isLatinLetter(c) || !Character.isLetter(c)){
                hasRemovedInitChar = true;
                return;
            }

            hasRemovedInitChar = true;
            this.input.setValue("");
        }
    }

    @Unique
    private static boolean isLatinLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    static {
        System.setProperty("java.awt.headless", "false");
    }
}
