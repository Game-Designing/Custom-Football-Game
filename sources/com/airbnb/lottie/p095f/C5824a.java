package com.airbnb.lottie.p095f;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.airbnb.lottie.f.a */
/* compiled from: BaseLottieAnimator */
public abstract class C5824a extends ValueAnimator {

    /* renamed from: a */
    private final Set<AnimatorUpdateListener> f10092a = new CopyOnWriteArraySet();

    /* renamed from: b */
    private final Set<AnimatorListener> f10093b = new CopyOnWriteArraySet();

    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public void setStartDelay(long startDelay) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    public ValueAnimator setDuration(long duration) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    public void setInterpolator(TimeInterpolator value) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    public void addUpdateListener(AnimatorUpdateListener listener) {
        this.f10092a.add(listener);
    }

    public void removeUpdateListener(AnimatorUpdateListener listener) {
        this.f10092a.remove(listener);
    }

    public void removeAllUpdateListeners() {
        this.f10092a.clear();
    }

    public void addListener(AnimatorListener listener) {
        this.f10093b.add(listener);
    }

    public void removeListener(AnimatorListener listener) {
        this.f10093b.remove(listener);
    }

    public void removeAllListeners() {
        this.f10093b.clear();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo18150b(boolean isReverse) {
        for (AnimatorListener listener : this.f10093b) {
            if (VERSION.SDK_INT >= 26) {
                listener.onAnimationStart(this, isReverse);
            } else {
                listener.onAnimationStart(this);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo18149b() {
        for (AnimatorListener listener : this.f10093b) {
            listener.onAnimationRepeat(this);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo18146a(boolean isReverse) {
        for (AnimatorListener listener : this.f10093b) {
            if (VERSION.SDK_INT >= 26) {
                listener.onAnimationEnd(this, isReverse);
            } else {
                listener.onAnimationEnd(this);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo18145a() {
        for (AnimatorListener listener : this.f10093b) {
            listener.onAnimationCancel(this);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo18151c() {
        for (AnimatorUpdateListener listener : this.f10092a) {
            listener.onAnimationUpdate(this);
        }
    }
}
