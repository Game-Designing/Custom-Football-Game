package com.airbnb.lottie.p089c.p091b;

import com.airbnb.lottie.p095f.C5825b;
import com.airbnb.lottie.p095f.C5828e;

/* renamed from: com.airbnb.lottie.c.b.c */
/* compiled from: GradientColor */
public class C5737c {

    /* renamed from: a */
    private final float[] f9859a;

    /* renamed from: b */
    private final int[] f9860b;

    public C5737c(float[] positions, int[] colors) {
        this.f9859a = positions;
        this.f9860b = colors;
    }

    /* renamed from: b */
    public float[] mo18002b() {
        return this.f9859a;
    }

    /* renamed from: a */
    public int[] mo18001a() {
        return this.f9860b;
    }

    /* renamed from: c */
    public int mo18003c() {
        return this.f9860b.length;
    }

    /* renamed from: a */
    public void mo18000a(C5737c gc1, C5737c gc2, float progress) {
        if (gc1.f9860b.length == gc2.f9860b.length) {
            for (int i = 0; i < gc1.f9860b.length; i++) {
                this.f9859a[i] = C5828e.m10533c(gc1.f9859a[i], gc2.f9859a[i], progress);
                this.f9860b[i] = C5825b.m10498a(progress, gc1.f9860b[i], gc2.f9860b[i]);
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot interpolate between gradients. Lengths vary (");
        sb.append(gc1.f9860b.length);
        sb.append(" vs ");
        sb.append(gc2.f9860b.length);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }
}
