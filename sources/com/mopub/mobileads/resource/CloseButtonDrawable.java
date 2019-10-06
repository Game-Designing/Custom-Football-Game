package com.mopub.mobileads.resource;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.mopub.mobileads.resource.DrawableConstants.CloseButton;

public class CloseButtonDrawable extends BaseWidgetDrawable {

    /* renamed from: a */
    private final Paint f35366a;

    /* renamed from: b */
    private final float f35367b;

    public CloseButtonDrawable() {
        this(8.0f);
    }

    public CloseButtonDrawable(float strokeWidth) {
        this.f35367b = strokeWidth / 2.0f;
        this.f35366a = new Paint();
        this.f35366a.setColor(-1);
        this.f35366a.setStrokeWidth(strokeWidth);
        this.f35366a.setStrokeCap(CloseButton.STROKE_CAP);
    }

    public void draw(Canvas canvas) {
        int w = getBounds().width();
        int h = getBounds().height();
        float f = this.f35367b;
        Canvas canvas2 = canvas;
        canvas2.drawLine(f + 0.0f, ((float) h) - f, ((float) w) - f, f + 0.0f, this.f35366a);
        float f2 = this.f35367b;
        canvas2.drawLine(f2 + 0.0f, f2 + 0.0f, ((float) w) - f2, ((float) h) - f2, this.f35366a);
    }
}
