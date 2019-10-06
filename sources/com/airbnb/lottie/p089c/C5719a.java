package com.airbnb.lottie.p089c;

import android.graphics.PointF;

/* renamed from: com.airbnb.lottie.c.a */
/* compiled from: CubicCurveData */
public class C5719a {

    /* renamed from: a */
    private final PointF f9826a;

    /* renamed from: b */
    private final PointF f9827b;

    /* renamed from: c */
    private final PointF f9828c;

    public C5719a() {
        this.f9826a = new PointF();
        this.f9827b = new PointF();
        this.f9828c = new PointF();
    }

    public C5719a(PointF controlPoint1, PointF controlPoint2, PointF vertex) {
        this.f9826a = controlPoint1;
        this.f9827b = controlPoint2;
        this.f9828c = vertex;
    }

    /* renamed from: a */
    public void mo17979a(float x, float y) {
        this.f9826a.set(x, y);
    }

    /* renamed from: a */
    public PointF mo17978a() {
        return this.f9826a;
    }

    /* renamed from: b */
    public void mo17981b(float x, float y) {
        this.f9827b.set(x, y);
    }

    /* renamed from: b */
    public PointF mo17980b() {
        return this.f9827b;
    }

    /* renamed from: c */
    public void mo17983c(float x, float y) {
        this.f9828c.set(x, y);
    }

    /* renamed from: c */
    public PointF mo17982c() {
        return this.f9828c;
    }
}
