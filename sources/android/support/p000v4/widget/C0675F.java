package android.support.p000v4.widget;

import android.view.animation.Interpolator;

/* renamed from: android.support.v4.widget.F */
/* compiled from: ViewDragHelper */
class C0675F implements Interpolator {
    C0675F() {
    }

    public float getInterpolation(float t) {
        float t2 = t - 1.0f;
        return (t2 * t2 * t2 * t2 * t2) + 1.0f;
    }
}
