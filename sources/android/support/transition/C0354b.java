package android.support.transition;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;

/* renamed from: android.support.transition.b */
/* compiled from: AnimatorUtilsApi14 */
class C0354b implements C0359d {

    /* renamed from: android.support.transition.b$a */
    /* compiled from: AnimatorUtilsApi14 */
    interface C0355a {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    C0354b() {
    }

    /* renamed from: a */
    public void mo4806a(Animator animator, AnimatorListenerAdapter listener) {
    }

    /* renamed from: a */
    public void mo4805a(Animator animator) {
        ArrayList<AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                AnimatorListener listener = (AnimatorListener) listeners.get(i);
                if (listener instanceof C0355a) {
                    ((C0355a) listener).onAnimationPause(animator);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo4807b(Animator animator) {
        ArrayList<AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                AnimatorListener listener = (AnimatorListener) listeners.get(i);
                if (listener instanceof C0355a) {
                    ((C0355a) listener).onAnimationResume(animator);
                }
            }
        }
    }
}
