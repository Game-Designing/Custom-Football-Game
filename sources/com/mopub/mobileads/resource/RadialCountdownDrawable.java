package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Numbers;
import com.mopub.mobileads.resource.DrawableConstants.RadialCountdown;

public class RadialCountdownDrawable extends BaseWidgetDrawable {

    /* renamed from: a */
    private final Paint f35383a = new Paint();

    /* renamed from: b */
    private final Paint f35384b;

    /* renamed from: c */
    private final Paint f35385c;

    /* renamed from: d */
    private Rect f35386d;

    /* renamed from: e */
    private int f35387e;

    /* renamed from: f */
    private int f35388f;

    /* renamed from: g */
    private float f35389g;

    public RadialCountdownDrawable(Context context) {
        int circleStrokeWidth = Dips.dipsToIntPixels(3.0f, context);
        float textSizePixels = Dips.dipsToFloatPixels(18.0f, context);
        this.f35383a.setColor(-1);
        this.f35383a.setAlpha(128);
        this.f35383a.setStyle(RadialCountdown.BACKGROUND_STYLE);
        this.f35383a.setStrokeWidth((float) circleStrokeWidth);
        this.f35383a.setAntiAlias(true);
        this.f35384b = new Paint();
        this.f35384b.setColor(-1);
        this.f35384b.setAlpha(255);
        this.f35384b.setStyle(RadialCountdown.PROGRESS_STYLE);
        this.f35384b.setStrokeWidth((float) circleStrokeWidth);
        this.f35384b.setAntiAlias(true);
        this.f35385c = new Paint();
        this.f35385c.setColor(-1);
        this.f35385c.setTextAlign(RadialCountdown.TEXT_ALIGN);
        this.f35385c.setTextSize(textSizePixels);
        this.f35385c.setAntiAlias(true);
        this.f35386d = new Rect();
    }

    public void draw(Canvas canvas) {
        int centerX = getBounds().centerX();
        int centerY = getBounds().centerY();
        canvas.drawCircle((float) centerX, (float) centerY, (float) Math.min(centerX, centerY), this.f35383a);
        mo37527a(canvas, this.f35385c, this.f35386d, String.valueOf(this.f35388f));
        canvas.drawArc(new RectF(getBounds()), -90.0f, this.f35389g, false, this.f35384b);
    }

    public void setInitialCountdown(int initialCountdownMilliseconds) {
        this.f35387e = initialCountdownMilliseconds;
    }

    public void updateCountdownProgress(int currentProgressMilliseconds) {
        this.f35388f = (int) Numbers.convertMillisecondsToSecondsRoundedUp((long) (this.f35387e - currentProgressMilliseconds));
        this.f35389g = (((float) currentProgressMilliseconds) * 360.0f) / ((float) this.f35387e);
        invalidateSelf();
    }

    @Deprecated
    @VisibleForTesting
    public int getInitialCountdownMilliseconds() {
        return this.f35387e;
    }
}
