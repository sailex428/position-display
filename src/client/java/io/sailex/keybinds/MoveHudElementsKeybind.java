package io.sailex.keybinds;

import io.sailex.gui.screens.MoveHudElementsScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class MoveHudElementsKeybind {

    public MoveHudElementsKeybind(MoveHudElementsScreen screen) {
        this.screen = screen;
    }

    private final MoveHudElementsScreen screen;
    private KeyBinding keyBinding;

    public void register() {
        keyBinding =  KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "position-display.EditHudElements",
                        GLFW.GLFW_KEY_H,
                        "EditHudElements"
                )
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (keyBinding.wasPressed()) {
                if (client.currentScreen == null) {
                    client.setScreen(screen);
                    return;
                }
                if (client.currentScreen instanceof MoveHudElementsScreen) {
                    client.setScreen(null);
                }
            }
        });
    }

}