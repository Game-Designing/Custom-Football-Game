package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;

/* renamed from: android.support.transition.a */
/* compiled from: AnimatorUtils */
class C0352a {

    /* renamed from: a */
    private static final C0359d f1222a;

    static {
        if (VERSION.SDK_INT >= 19) {
            f1222a = new C0357c();
        } else {
            f1222a = new C0354b();
        }
    }

    /* renamed from: a */
    static void m1879a(Animator animator, AnimatorListenerAdapter listener) {
        f1222a.mo4806a(animator, listener);
    }

    /* renamed from: a */
    static void m1878a(Animator animator) {
        f1222a.mo4805a(animator);
    }

    /* renamed from: b */
    static void m1880b(Animator animator) {
        f1222a.mo4807b(animator);
    }
}
