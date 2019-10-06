package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.p000v4.view.C0646w;
import android.view.View;

/* renamed from: android.support.design.widget.p */
/* compiled from: BaseTransientBottomBar */
class C0305p implements AnimatorUpdateListener {

    /* renamed from: a */
    private int f1111a = this.f1112b;

    /* renamed from: b */
    final /* synthetic */ int f1112b;

    /* renamed from: c */
    final /* synthetic */ C0307r f1113c;

    C0305p(C0307r this$0, int i) {
        this.f1113c = this$0;
        this.f1112b = i;
    }

    public void onAnimationUpdate(ValueAnimator animator) {
        int currentAnimatedIntValue = ((Integer) animator.getAnimatedValue()).intValue();
        if (C0307r.f1116b) {
            C0646w.m2965b((View) this.f1113c.f1119e, currentAnimatedIntValue - this.f1111a);
        } else {
            this.f1113c.f1119e.setTranslationY((float) currentAnimatedIntValue);
        }
        this.f1111a = currentAnimatedIntValue;
    }
}
