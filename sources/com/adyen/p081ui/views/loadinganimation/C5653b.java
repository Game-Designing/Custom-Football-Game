package com.adyen.p081ui.views.loadinganimation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* renamed from: com.adyen.ui.views.loadinganimation.b */
/* compiled from: ThreeDotsLoadingAnimation */
class C5653b implements AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ int f9585a;

    /* renamed from: b */
    final /* synthetic */ C5654c f9586b;

    C5653b(C5654c this$0, int i) {
        this.f9586b = this$0;
        this.f9585a = i;
    }

    public void onAnimationUpdate(ValueAnimator animation) {
        this.f9586b.f9587f[this.f9585a] = ((Integer) animation.getAnimatedValue()).intValue();
        this.f9586b.invalidateSelf();
    }
}
