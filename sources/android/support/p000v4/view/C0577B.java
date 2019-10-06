package android.support.p000v4.view;

import android.view.animation.Interpolator;

/* renamed from: android.support.v4.view.B */
/* compiled from: ViewPager */
class C0577B implements Interpolator {
    C0577B() {
    }

    public float getInterpolation(float t) {
        float t2 = t - 1.0f;
        return (t2 * t2 * t2 * t2 * t2) + 1.0f;
    }
}
