package com.airbnb.lottie;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* renamed from: com.airbnb.lottie.r */
/* compiled from: LottieDrawable */
class C5845r implements AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ C5851x f10163a;

    C5845r(C5851x this$0) {
        this.f10163a = this$0;
    }

    public void onAnimationUpdate(ValueAnimator animation) {
        if (this.f10163a.f10187o != null) {
            this.f10163a.f10187o.mo18083a(this.f10163a.f10176d.mo18175k());
        }
    }
}
