package com.smaato.soma;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* renamed from: com.smaato.soma._a */
/* compiled from: ToasterBanner */
class C12088_a implements AnimatorListener {

    /* renamed from: a */
    final /* synthetic */ C12141ab f37957a;

    C12088_a(C12141ab this$1) {
        this.f37957a = this$1;
    }

    public void onAnimationStart(Animator animation) {
    }

    public void onAnimationRepeat(Animator animation) {
    }

    public void onAnimationEnd(Animator animation) {
        new C12087Za(this).execute();
    }

    public void onAnimationCancel(Animator animation) {
    }
}
