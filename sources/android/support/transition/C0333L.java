package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: android.support.transition.L */
/* compiled from: Transition */
class C0333L extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ C0334M f1158a;

    C0333L(C0334M this$0) {
        this.f1158a = this$0;
    }

    public void onAnimationEnd(Animator animation) {
        this.f1158a.mo4754a();
        animation.removeListener(this);
    }
}
