package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.p000v4.view.C0646w;
import android.view.View;

/* renamed from: android.support.design.widget.f */
/* compiled from: BaseTransientBottomBar */
class C0290f implements AnimatorUpdateListener {

    /* renamed from: a */
    private int f1090a = 0;

    /* renamed from: b */
    final /* synthetic */ C0307r f1091b;

    C0290f(C0307r this$0) {
        this.f1091b = this$0;
    }

    public void onAnimationUpdate(ValueAnimator animator) {
        int currentAnimatedIntValue = ((Integer) animator.getAnimatedValue()).intValue();
        if (C0307r.f1116b) {
            C0646w.m2965b((View) this.f1091b.f1119e, currentAnimatedIntValue - this.f1090a);
        } else {
            this.f1091b.f1119e.setTranslationY((float) currentAnimatedIntValue);
        }
        this.f1090a = currentAnimatedIntValue;
    }
}
