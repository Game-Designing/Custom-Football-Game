package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: android.support.design.widget.U */
/* compiled from: StateListAnimator */
class C0273U extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ C0274V f1062a;

    C0273U(C0274V this$0) {
        this.f1062a = this$0;
    }

    public void onAnimationEnd(Animator animator) {
        C0274V v = this.f1062a;
        if (v.f1065c == animator) {
            v.f1065c = null;
        }
    }
}
