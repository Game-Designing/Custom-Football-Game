package com.fyber.inneractive.sdk.p180ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ProgressBar;

@TargetApi(11)
/* renamed from: com.fyber.inneractive.sdk.ui.IAsmoothProgressBar */
public class IAsmoothProgressBar extends ProgressBar {

    /* renamed from: a */
    private static final Interpolator f16286a = new AccelerateDecelerateInterpolator();

    /* renamed from: b */
    private ValueAnimator f16287b;

    /* renamed from: c */
    private ValueAnimator f16288c;

    public IAsmoothProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IAsmoothProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public synchronized void setProgress(int i) {
        if (!m18015a()) {
            super.setProgress(i);
            return;
        }
        if (this.f16287b != null) {
            this.f16287b.cancel();
        }
        if (this.f16287b == null) {
            this.f16287b = ValueAnimator.ofInt(new int[]{getProgress(), i});
            this.f16287b.setInterpolator(f16286a);
            this.f16287b.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IAsmoothProgressBar.super.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
        } else {
            this.f16287b.setIntValues(new int[]{getProgress(), i});
        }
        this.f16287b.start();
    }

    /* renamed from: a */
    private static boolean m18015a() {
        return VERSION.SDK_INT >= 11;
    }

    public synchronized void setSecondaryProgress(int i) {
        if (!m18015a()) {
            super.setSecondaryProgress(i);
            return;
        }
        if (this.f16288c != null) {
            this.f16288c.cancel();
        }
        if (this.f16288c == null) {
            this.f16288c = ValueAnimator.ofInt(new int[]{getProgress(), i});
            this.f16288c.setInterpolator(f16286a);
            this.f16288c.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IAsmoothProgressBar.super.setSecondaryProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
        } else {
            this.f16288c.setIntValues(new int[]{getProgress(), i});
        }
        this.f16288c.start();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f16287b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f16288c;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }
}
