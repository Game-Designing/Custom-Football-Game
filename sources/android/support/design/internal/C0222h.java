package android.support.design.internal;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;

/* renamed from: android.support.design.internal.h */
/* compiled from: TextScale */
class C0222h implements AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ TextView f766a;

    /* renamed from: b */
    final /* synthetic */ C0223i f767b;

    C0222h(C0223i this$0, TextView textView) {
        this.f767b = this$0;
        this.f766a = textView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f766a.setScaleX(animatedValue);
        this.f766a.setScaleY(animatedValue);
    }
}
