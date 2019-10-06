package android.support.p001v7.widget;

import android.view.animation.Interpolator;

/* renamed from: android.support.v7.widget.Ea */
/* compiled from: RecyclerView */
class C0926Ea implements Interpolator {
    C0926Ea() {
    }

    public float getInterpolation(float t) {
        float t2 = t - 1.0f;
        return (t2 * t2 * t2 * t2 * t2) + 1.0f;
    }
}
