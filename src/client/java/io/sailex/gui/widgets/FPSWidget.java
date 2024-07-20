package io.sailex.gui.widgets;

import io.sailex.config.HudElement;
import io.sailex.config.HudEnhancerConfig;
import io.sailex.util.FPSElementRenderer;
import io.sailex.gui.hud.IHudElement;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

import java.util.Map;

public class FPSWidget extends AWidget {

    public FPSWidget(
            HudElement fps, Map<AWidget,
            IHudElement> widgetToHudElement, Map<String,
            HudElement> positionMap) {
        super(fps, Text.literal(HudEnhancerConfig.FPS));
        this.widgetToHudElement = widgetToHudElement;
        this.positionMap = positionMap;
    }

    @Override
    protected void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
        FPSElementRenderer.render(
                context,
                this.getX(), this.getY(), this.getWidth(), this.getHeight(),
                getColor(), isBackground(), isShadow(), isActive()
        );
    }

}
