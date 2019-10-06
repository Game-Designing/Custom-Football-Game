package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.support.p000v4.view.C0646w;
import android.support.transition.C0334M.C0337c;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.transition.r */
/* compiled from: Fade */
public class C0389r extends C0393sa {

    /* renamed from: android.support.transition.r$a */
    /* compiled from: Fade */
    private static class C0390a extends AnimatorListenerAdapter {

        /* renamed from: a */
        private final View f1293a;

        /* renamed from: b */
        private boolean f1294b = false;

        C0390a(View view) {
            this.f1293a = view;
        }

        public void onAnimationStart(Animator animation) {
            if (C0646w.m2984r(this.f1293a) && this.f1293a.getLayerType() == 0) {
                this.f1294b = true;
                this.f1293a.setLayerType(2, null);
            }
        }

        public void onAnimationEnd(Animator animation) {
            C0375ka.m1931a(this.f1293a, 1.0f);
            if (this.f1294b) {
                this.f1293a.setLayerType(0, null);
            }
        }
    }

    public C0389r(int fadingMode) {
        mo4876a(fadingMode);
    }

    /* renamed from: c */
    public void mo4154c(C0347V transitionValues) {
        super.mo4154c(transitionValues);
        transitionValues.f1214a.put("android:fade:transitionAlpha", Float.valueOf(C0375ka.m1937c(transitionValues.f1215b)));
    }

    /* renamed from: a */
    private Animator m1988a(View view, float startAlpha, float endAlpha) {
        if (startAlpha == endAlpha) {
            return null;
        }
        C0375ka.m1931a(view, startAlpha);
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, C0375ka.f1248d, new float[]{endAlpha});
        anim.addListener(new C0390a(view));
        mo4750a((C0337c) new C0387q(this, view));
        return anim;
    }

    /* renamed from: a */
    public Animator mo4870a(ViewGroup sceneRoot, View view, C0347V startValues, C0347V endValues) {
        float startAlpha = m1987a(startValues, 0.0f);
        if (startAlpha == 1.0f) {
            startAlpha = 0.0f;
        }
        return m1988a(view, startAlpha, 1.0f);
    }

    /* renamed from: b */
    public Animator mo4871b(ViewGroup sceneRoot, View view, C0347V startValues, C0347V endValues) {
        C0375ka.m1939e(view);
        return m1988a(view, m1987a(startValues, 1.0f), 0.0f);
    }

    /* renamed from: a */
    private static float m1987a(C0347V startValues, float fallbackValue) {
        float startAlpha = fallbackValue;
        if (startValues == null) {
            return startAlpha;
        }
        Float startAlphaFloat = (Float) startValues.f1214a.get("android:fade:transitionAlpha");
        if (startAlphaFloat != null) {
            return startAlphaFloat.floatValue();
        }
        return startAlpha;
    }
}
