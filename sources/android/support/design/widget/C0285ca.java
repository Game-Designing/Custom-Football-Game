package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* renamed from: android.support.design.widget.ca */
/* compiled from: TextInputLayout */
class C0285ca implements AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ TextInputLayout f1086a;

    C0285ca(TextInputLayout this$0) {
        this.f1086a = this$0;
    }

    public void onAnimationUpdate(ValueAnimator animator) {
        this.f1086a.mCollapsingTextHelper.mo4166b(((Float) animator.getAnimatedValue()).floatValue());
    }
}
