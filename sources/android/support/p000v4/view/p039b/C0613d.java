package android.support.p000v4.view.p039b;

import android.view.animation.Interpolator;

/* renamed from: android.support.v4.view.b.d */
/* compiled from: LookupTableInterpolator */
abstract class C0613d implements Interpolator {

    /* renamed from: a */
    private final float[] f1836a;

    /* renamed from: b */
    private final float f1837b = (1.0f / ((float) (this.f1836a.length - 1)));

    protected C0613d(float[] values) {
        this.f1836a = values;
    }

    public float getInterpolation(float input) {
        if (input >= 1.0f) {
            return 1.0f;
        }
        if (input <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f1836a;
        int position = Math.min((int) (((float) (fArr.length - 1)) * input), fArr.length - 2);
        float f = (float) position;
        float f2 = this.f1837b;
        float weight = (input - (f * f2)) / f2;
        float[] fArr2 = this.f1836a;
        return fArr2[position] + ((fArr2[position + 1] - fArr2[position]) * weight);
    }
}
