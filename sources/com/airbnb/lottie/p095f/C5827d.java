package com.airbnb.lottie.p095f;

/* renamed from: com.airbnb.lottie.f.d */
/* compiled from: MeanCalculator */
public class C5827d {

    /* renamed from: a */
    private float f10103a;

    /* renamed from: b */
    private int f10104b;

    /* renamed from: a */
    public void mo18185a(float number) {
        this.f10103a += number;
        this.f10104b++;
        int i = this.f10104b;
        if (i == Integer.MAX_VALUE) {
            this.f10103a /= 2.0f;
            this.f10104b = i / 2;
        }
    }
}
