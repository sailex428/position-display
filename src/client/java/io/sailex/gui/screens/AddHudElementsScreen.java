package io.sailex.gui.screens;

import io.sailex.util.TranslationKeys;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class AddHudElementsScreen extends AScreen {

    public AddHudElementsScreen() {
        super(Text.of("Add HUD Elements"));
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderScreenBackground(context, screenX, screenY);
        renderScreenTitle(context, screenX, screenY, TranslationKeys.ADD_HUD_SCREEN_WIDGETS);

        super.render(context, mouseX, mouseY, delta);
    }

}
