package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* renamed from: android.support.design.widget.C */
/* compiled from: CollapsingToolbarLayout */
class C0233C implements AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ CollapsingToolbarLayout f872a;

    C0233C(CollapsingToolbarLayout this$0) {
        this.f872a = this$0;
    }

    public void onAnimationUpdate(ValueAnimator animator) {
        this.f872a.setScrimAlpha(((Integer) animator.getAnimatedValue()).intValue());
    }
}
