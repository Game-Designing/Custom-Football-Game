package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.transition.C0334M;
import android.support.transition.C0347V;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

/* renamed from: android.support.design.internal.i */
/* compiled from: TextScale */
public class C0223i extends C0334M {
    /* renamed from: c */
    public void mo4154c(C0347V transitionValues) {
        m1247d(transitionValues);
    }

    /* renamed from: a */
    public void mo4153a(C0347V transitionValues) {
        m1247d(transitionValues);
    }

    /* renamed from: d */
    private void m1247d(C0347V transitionValues) {
        View view = transitionValues.f1215b;
        if (view instanceof TextView) {
            String str = "android:textscale:scale";
            transitionValues.f1214a.put(str, Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    /* renamed from: a */
    public Animator mo4152a(ViewGroup sceneRoot, C0347V startValues, C0347V endValues) {
        if (!(startValues == null || endValues == null || !(startValues.f1215b instanceof TextView))) {
            View view = endValues.f1215b;
            if (view instanceof TextView) {
                TextView view2 = (TextView) view;
                Map<String, Object> startVals = startValues.f1214a;
                Map<String, Object> endVals = endValues.f1214a;
                String str = "android:textscale:scale";
                float f = 1.0f;
                float startSize = startVals.get(str) != null ? ((Float) startVals.get(str)).floatValue() : 1.0f;
                if (endVals.get(str) != null) {
                    f = ((Float) endVals.get(str)).floatValue();
                }
                float endSize = f;
                if (startSize == endSize) {
                    return null;
                }
                ValueAnimator animator = ValueAnimator.ofFloat(new float[]{startSize, endSize});
                animator.addUpdateListener(new C0222h(this, view2));
                return animator;
            }
        }
        return null;
    }
}
