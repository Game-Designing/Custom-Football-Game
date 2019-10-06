package com.smaato.soma;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* renamed from: com.smaato.soma.Wa */
/* compiled from: ToasterBanner */
class C12081Wa implements AnimatorListener {

    /* renamed from: a */
    final /* synthetic */ int f37947a;

    /* renamed from: b */
    final /* synthetic */ C12083Xa f37948b;

    C12081Wa(C12083Xa this$1, int i) {
        this.f37948b = this$1;
        this.f37947a = i;
    }

    public void onAnimationStart(Animator animation) {
    }

    public void onAnimationRepeat(Animator animation) {
    }

    public void onAnimationEnd(Animator animation) {
        new C12079Va(this).execute();
    }

    public void onAnimationCancel(Animator animation) {
    }
}
