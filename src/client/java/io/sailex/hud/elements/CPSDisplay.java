package io.sailex.hud.elements;

import io.sailex.hud.util.AHudElement;
import io.sailex.hud.util.CPSTracker;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;

public class CPSDisplay extends AHudElement {

    private final CPSTracker cpsTracker;

    public CPSDisplay(int elementX, int elementY, int elementWidth, int elementHeight) {
        this.elementX = elementX;
        this.elementY = elementY;
        this.elementWidth = elementWidth;
        this.elementHeight = elementHeight;
        cpsTracker = new CPSTracker();
        cpsTracker.register();
    }

    @Override
    public void drawElement(DrawContext drawContext, ClientPlayerEntity player) {
        int textColor = 0xFFFFFF;

        drawContext.fill(elementX, elementY, elementX + elementWidth, elementY + elementHeight, 0x80000000);
        drawContext.drawText(client.textRenderer,  cpsTracker.getCPS() + " CPS", elementX + 5, elementY + 5, textColor, true);
    }
}
