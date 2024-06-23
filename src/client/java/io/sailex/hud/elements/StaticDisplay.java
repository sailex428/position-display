package io.sailex.hud.elements;

import io.sailex.hud.util.AHudElement;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;

public class StaticDisplay extends AHudElement {

    private final String content;

    public StaticDisplay(int elementX, int elementY, int elementWidth, int elementHeight, String content) {
        this.elementX = elementX;
        this.elementY = elementY;
        this.elementWidth = elementWidth;
        this.elementHeight = elementHeight;
        this.content = content;
    }

    @Override
    public void drawElement(DrawContext drawContext, ClientPlayerEntity player) {
        int textColor = 0xFFFFFF;

        drawContext.fill(elementX, elementY, elementX + elementWidth, elementY + elementHeight, 0x80000000);
        drawContext.drawText(client.textRenderer, content, elementX + 5, elementY + 5, textColor, true);
    }

}
