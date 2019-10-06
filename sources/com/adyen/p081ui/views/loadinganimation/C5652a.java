package com.adyen.p081ui.views.loadinganimation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import java.util.HashMap;
import java.util.Map.Entry;

/* renamed from: com.adyen.ui.views.loadinganimation.a */
/* compiled from: Animation */
public abstract class C5652a extends Drawable implements Animatable {

    /* renamed from: a */
    private static final Rect f9580a = new Rect();

    /* renamed from: b */
    private HashMap<ValueAnimator, AnimatorUpdateListener> f9581b = new HashMap<>();

    /* renamed from: c */
    private int f9582c = 255;

    /* renamed from: d */
    private Rect f9583d = f9580a;

    /* renamed from: e */
    private Paint f9584e = new Paint();

    /* renamed from: a */
    public abstract void mo17845a(Canvas canvas, Paint paint);

    /* renamed from: c */
    public abstract HashMap<ValueAnimator, AnimatorUpdateListener> mo17847c();

    public C5652a() {
        this.f9584e.setColor(-1);
        this.f9584e.setStyle(Style.FILL);
        this.f9584e.setAntiAlias(true);
    }

    /* renamed from: a */
    public void mo17844a(int color) {
        this.f9584e.setColor(color);
    }

    public void setAlpha(int alpha) {
        this.f9582c = alpha;
    }

    public int getAlpha() {
        return this.f9582c;
    }

    public int getOpacity() {
        return -1;
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void draw(Canvas canvas) {
        mo17845a(canvas, this.f9584e);
    }

    public void start() {
        if (m9974d()) {
            this.f9581b = mo17847c();
        }
        if (!m9975e()) {
            m9976f();
            invalidateSelf();
        }
    }

    /* renamed from: f */
    private void m9976f() {
        HashMap<ValueAnimator, AnimatorUpdateListener> hashMap = this.f9581b;
        if (hashMap != null) {
            for (Entry<ValueAnimator, AnimatorUpdateListener> entry : hashMap.entrySet()) {
                AnimatorUpdateListener updateListener = (AnimatorUpdateListener) entry.getValue();
                ValueAnimator animator = (ValueAnimator) entry.getKey();
                if (updateListener != null) {
                    animator.addUpdateListener(updateListener);
                }
                animator.start();
            }
        }
    }

    public void stop() {
        HashMap<ValueAnimator, AnimatorUpdateListener> hashMap = this.f9581b;
        if (hashMap != null) {
            for (ValueAnimator animator : hashMap.keySet()) {
                if (animator != null && animator.isStarted()) {
                    animator.removeAllUpdateListeners();
                    animator.end();
                }
            }
        }
    }

    /* renamed from: e */
    private boolean m9975e() {
        return !m9974d() && ((ValueAnimator) this.f9581b.keySet().iterator().next()).isStarted();
    }

    public boolean isRunning() {
        return !m9974d() && ((ValueAnimator) this.f9581b.keySet().iterator().next()).isRunning();
    }

    /* renamed from: d */
    private boolean m9974d() {
        HashMap<ValueAnimator, AnimatorUpdateListener> hashMap = this.f9581b;
        return hashMap == null || hashMap.keySet().isEmpty();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        this.f9583d = new Rect(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    /* renamed from: b */
    public int mo17846b() {
        return this.f9583d.width();
    }

    /* renamed from: a */
    public int mo17843a() {
        return this.f9583d.height();
    }
}
