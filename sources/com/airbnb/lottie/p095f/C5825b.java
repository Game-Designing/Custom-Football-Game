package com.airbnb.lottie.p095f;

/* renamed from: com.airbnb.lottie.f.b */
/* compiled from: GammaEvaluator */
public class C5825b {
    /* renamed from: b */
    private static float m10499b(float linear) {
        if (linear <= 0.0031308f) {
            return 12.92f * linear;
        }
        return (float) ((Math.pow((double) linear, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    /* renamed from: a */
    private static float m10497a(float srgb) {
        return srgb <= 0.04045f ? srgb / 12.92f : (float) Math.pow((double) ((0.055f + srgb) / 1.055f), 2.4000000953674316d);
    }

    /* renamed from: a */
    public static int m10498a(float fraction, int startInt, int endInt) {
        int i = startInt;
        int i2 = endInt;
        float startA = ((float) ((i >> 24) & 255)) / 255.0f;
        float startG = ((float) ((i >> 8) & 255)) / 255.0f;
        float startB = ((float) (i & 255)) / 255.0f;
        float endA = ((float) ((i2 >> 24) & 255)) / 255.0f;
        float endR = ((float) ((i2 >> 16) & 255)) / 255.0f;
        float endG = ((float) ((i2 >> 8) & 255)) / 255.0f;
        float endB = ((float) (i2 & 255)) / 255.0f;
        float startR = m10497a(((float) ((i >> 16) & 255)) / 255.0f);
        float startG2 = m10497a(startG);
        float startB2 = m10497a(startB);
        float endR2 = m10497a(endR);
        return (Math.round((((endA - startA) * fraction) + startA) * 255.0f) << 24) | (Math.round(m10499b(((endR2 - startR) * fraction) + startR) * 255.0f) << 16) | (Math.round(m10499b(((m10497a(endG) - startG2) * fraction) + startG2) * 255.0f) << 8) | Math.round(m10499b(((m10497a(endB) - startB2) * fraction) + startB2) * 255.0f);
    }
}
