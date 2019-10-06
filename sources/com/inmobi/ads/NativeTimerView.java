package com.inmobi.ads;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.inmobi.commons.core.utilities.p225b.C10692c;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class NativeTimerView extends View {

    /* renamed from: a */
    long f31360a;

    /* renamed from: b */
    long f31361b;

    /* renamed from: c */
    ValueAnimator f31362c;

    /* renamed from: d */
    private Bitmap f31363d;

    /* renamed from: e */
    private Canvas f31364e;

    /* renamed from: f */
    private RectF f31365f;

    /* renamed from: g */
    private RectF f31366g;

    /* renamed from: h */
    private Rect f31367h;

    /* renamed from: i */
    private Paint f31368i;

    /* renamed from: j */
    private Paint f31369j;

    /* renamed from: k */
    private Paint f31370k;

    /* renamed from: l */
    private Paint f31371l;

    /* renamed from: m */
    private Paint f31372m;

    /* renamed from: n */
    private float f31373n;

    /* renamed from: o */
    private C10328b f31374o;

    /* renamed from: com.inmobi.ads.NativeTimerView$a */
    public static class C10327a implements AnimatorUpdateListener {

        /* renamed from: a */
        public WeakReference<NativeTimerView> f31375a;

        public C10327a(NativeTimerView nativeTimerView) {
            this.f31375a = new WeakReference<>(nativeTimerView);
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            NativeTimerView nativeTimerView = (NativeTimerView) this.f31375a.get();
            if (nativeTimerView != null) {
                int visibility = nativeTimerView.getVisibility();
                if (visibility != 4 && visibility != 8) {
                    nativeTimerView.mo33860a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                } else if (((double) ((Float) valueAnimator.getAnimatedValue()).floatValue()) >= 1.0d) {
                    nativeTimerView.m33698b();
                }
            }
        }
    }

    /* renamed from: com.inmobi.ads.NativeTimerView$b */
    interface C10328b {
        /* renamed from: a */
        void mo33867a();
    }

    public NativeTimerView(Context context) {
        this(context, null);
    }

    public NativeTimerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NativeTimerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f31360a = 0;
        this.f31368i = new Paint();
        this.f31368i.setAntiAlias(true);
        this.f31368i.setColor(-723724);
        this.f31372m = new Paint();
        this.f31372m.setAntiAlias(true);
        this.f31372m.setColor(CtaButton.BACKGROUND_COLOR);
        this.f31372m.setTextAlign(Align.CENTER);
        this.f31372m.setAntiAlias(true);
        this.f31367h = new Rect();
        this.f31369j = new Paint();
        this.f31369j.setAntiAlias(true);
        this.f31369j.setColor(CtaButton.BACKGROUND_COLOR);
        this.f31370k = new Paint();
        this.f31370k.setAntiAlias(true);
        this.f31370k.setColor(0);
        this.f31370k.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.f31371l = new Paint();
        this.f31371l.setStyle(Style.STROKE);
        this.f31371l.setAntiAlias(true);
        this.f31371l.setColor(CtaButton.BACKGROUND_COLOR);
    }

    public void setTimerEventsListener(C10328b bVar) {
        this.f31374o = bVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!(i == i3 && i2 == i4)) {
            this.f31363d = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            this.f31363d.eraseColor(0);
            this.f31364e = new Canvas(this.f31363d);
        }
        super.onSizeChanged(i, i2, i3, i4);
        float a = (float) C10692c.m35103a((int) (((float) getWidth()) * 4.0f * 0.007f));
        float a2 = (float) C10692c.m35103a((int) (((float) getWidth()) * 14.0f * 0.007f));
        float a3 = (float) C10692c.m35103a((int) (((float) getWidth()) * 5.0f * 0.007f));
        float a4 = (float) C10692c.m35103a((int) (((float) getWidth()) * 1.5f * 0.007f));
        this.f31365f = new RectF(a3, a3, ((float) getWidth()) - a3, ((float) getHeight()) - a3);
        RectF rectF = this.f31365f;
        this.f31366g = new RectF(rectF.left + a, rectF.top + a, rectF.right - a, rectF.bottom - a);
        this.f31371l.setStrokeWidth(a4);
        this.f31372m.setTextSize(a2);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f31364e.drawColor(0, Mode.CLEAR);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int min = Math.min(width, height);
        int a = C10692c.m35103a((int) (((float) getWidth()) * 7.0f * 0.007f));
        float f = (float) width;
        float f2 = (float) height;
        canvas.drawCircle(f, f2, (float) min, this.f31368i);
        canvas.drawCircle(f, f2, (float) (min - a), this.f31371l);
        ValueAnimator valueAnimator = this.f31362c;
        if (valueAnimator != null) {
            int currentPlayTime = (int) (this.f31360a - (valueAnimator.getCurrentPlayTime() / 1000));
            if (((double) ((Float) this.f31362c.getAnimatedValue()).floatValue()) >= 1.0d) {
                currentPlayTime = 0;
            }
            Paint paint = this.f31372m;
            Rect rect = this.f31367h;
            String valueOf = String.valueOf(currentPlayTime);
            paint.getTextBounds(valueOf, 0, valueOf.length(), rect);
            canvas.drawText(valueOf, (float) (getWidth() / 2), ((float) (getHeight() / 2)) + (((paint.descent() - paint.ascent()) / 2.0f) - paint.descent()), paint);
            if (((double) ((Float) this.f31362c.getAnimatedValue()).floatValue()) >= 1.0d) {
                m33698b();
            }
        }
        float f3 = this.f31373n;
        if (f3 > 0.0f) {
            this.f31364e.drawArc(this.f31365f, 270.0f, f3, true, this.f31369j);
            this.f31364e.drawOval(this.f31366g, this.f31370k);
        }
        canvas.drawBitmap(this.f31363d, 0.0f, 0.0f, null);
    }

    public void setTimerValue(long j) {
        this.f31360a = j;
    }

    /* renamed from: a */
    public final void mo33859a() {
        this.f31362c = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f31362c.setDuration(TimeUnit.SECONDS.toMillis(this.f31360a));
        this.f31362c.setInterpolator(new LinearInterpolator());
        this.f31362c.addUpdateListener(new C10327a(this));
        this.f31362c.start();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo33860a(float f) {
        this.f31373n = f * 360.0f;
        invalidate();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m33698b() {
        C10328b bVar = this.f31374o;
        if (bVar != null) {
            bVar.mo33867a();
            this.f31362c.cancel();
            this.f31362c = null;
        }
    }
}
