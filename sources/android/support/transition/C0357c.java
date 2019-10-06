package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: android.support.transition.c */
/* compiled from: AnimatorUtilsApi19 */
class C0357c implements C0359d {
    C0357c() {
    }

    /* renamed from: a */
    public void mo4806a(Animator animator, AnimatorListenerAdapter listener) {
        animator.addPauseListener(listener);
    }

    /* renamed from: a */
    public void mo4805a(Animator animator) {
        animator.pause();
    }

    /* renamed from: b */
    public void mo4807b(Animator animator) {
        animator.resume();
    }
}
