package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.resource.DrawableConstants.ProgressBar;

public class ProgressBarDrawable extends BaseWidgetDrawable {

    /* renamed from: a */
    private final Paint f35375a = new Paint();

    /* renamed from: b */
    private final Paint f35376b;

    /* renamed from: c */
    private int f35377c;

    /* renamed from: d */
    private int f35378d;

    /* renamed from: e */
    private int f35379e;

    /* renamed from: f */
    private int f35380f;

    /* renamed from: g */
    private float f35381g;

    /* renamed from: h */
    private final int f35382h;

    public ProgressBarDrawable(Context context) {
        this.f35375a.setColor(-1);
        this.f35375a.setAlpha(128);
        this.f35375a.setStyle(ProgressBar.BACKGROUND_STYLE);
        this.f35375a.setAntiAlias(true);
        this.f35376b = new Paint();
        this.f35376b.setColor(ProgressBar.PROGRESS_COLOR);
        this.f35376b.setAlpha(255);
        this.f35376b.setStyle(ProgressBar.PROGRESS_STYLE);
        this.f35376b.setAntiAlias(true);
        this.f35382h = Dips.dipsToIntPixels(4.0f, context);
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(getBounds(), this.f35375a);
        Canvas canvas2 = canvas;
        canvas2.drawRect((float) getBounds().left, (float) getBounds().top, ((float) getBounds().right) * (((float) this.f35379e) / ((float) this.f35377c)), (float) getBounds().bottom, this.f35376b);
        int i = this.f35378d;
        if (i > 0 && i < this.f35377c) {
            float nuggetPosition = ((float) getBounds().right) * this.f35381g;
            canvas.drawRect(nuggetPosition, (float) getBounds().top, nuggetPosition + ((float) this.f35382h), (float) getBounds().bottom, this.f35376b);
        }
    }

    public void reset() {
        this.f35380f = 0;
    }

    public void setDurationAndSkipOffset(int duration, int skipOffset) {
        this.f35377c = duration;
        this.f35378d = skipOffset;
        this.f35381g = ((float) this.f35378d) / ((float) this.f35377c);
    }

    public void setProgress(int currentProgress) {
        int i = this.f35380f;
        if (currentProgress >= i) {
            this.f35379e = currentProgress;
            this.f35380f = currentProgress;
        } else if (currentProgress != 0) {
            MoPubLog.log(SdkLogEvent.CUSTOM, String.format("Progress not monotonically increasing: last = %d, current = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(currentProgress)}));
            forceCompletion();
        }
        invalidateSelf();
    }

    @VisibleForTesting
    public void forceCompletion() {
        this.f35379e = this.f35377c;
    }

    @Deprecated
    @VisibleForTesting
    public float getSkipRatio() {
        return this.f35381g;
    }

    @Deprecated
    @VisibleForTesting
    public int getCurrentProgress() {
        return this.f35379e;
    }
}
