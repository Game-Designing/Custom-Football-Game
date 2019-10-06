package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;

public class CtaButtonDrawable extends BaseWidgetDrawable {

    /* renamed from: a */
    private final Paint f35368a = new Paint();

    /* renamed from: b */
    private final Paint f35369b;

    /* renamed from: c */
    private final Paint f35370c;

    /* renamed from: d */
    private final RectF f35371d;

    /* renamed from: e */
    private final Rect f35372e;

    /* renamed from: f */
    private final int f35373f;

    /* renamed from: g */
    private String f35374g;

    public CtaButtonDrawable(Context context) {
        int outlineStrokeWidth = Dips.dipsToIntPixels(2.0f, context);
        float textSize = Dips.dipsToFloatPixels(15.0f, context);
        this.f35368a.setColor(CtaButton.BACKGROUND_COLOR);
        this.f35368a.setAlpha(51);
        this.f35368a.setStyle(CtaButton.BACKGROUND_STYLE);
        this.f35368a.setAntiAlias(true);
        this.f35369b = new Paint();
        this.f35369b.setColor(-1);
        this.f35369b.setAlpha(51);
        this.f35369b.setStyle(CtaButton.OUTLINE_STYLE);
        this.f35369b.setStrokeWidth((float) outlineStrokeWidth);
        this.f35369b.setAntiAlias(true);
        this.f35370c = new Paint();
        this.f35370c.setColor(-1);
        this.f35370c.setTextAlign(CtaButton.TEXT_ALIGN);
        this.f35370c.setTypeface(CtaButton.TEXT_TYPEFACE);
        this.f35370c.setTextSize(textSize);
        this.f35370c.setAntiAlias(true);
        this.f35372e = new Rect();
        this.f35374g = CtaButton.DEFAULT_CTA_TEXT;
        this.f35371d = new RectF();
        this.f35373f = Dips.dipsToIntPixels(6.0f, context);
    }

    public void draw(Canvas canvas) {
        this.f35371d.set(getBounds());
        RectF rectF = this.f35371d;
        int i = this.f35373f;
        canvas.drawRoundRect(rectF, (float) i, (float) i, this.f35368a);
        RectF rectF2 = this.f35371d;
        int i2 = this.f35373f;
        canvas.drawRoundRect(rectF2, (float) i2, (float) i2, this.f35369b);
        mo37527a(canvas, this.f35370c, this.f35372e, this.f35374g);
    }

    public void setCtaText(String ctaText) {
        this.f35374g = ctaText;
        invalidateSelf();
    }

    @Deprecated
    @VisibleForTesting
    public String getCtaText() {
        return this.f35374g;
    }
}
