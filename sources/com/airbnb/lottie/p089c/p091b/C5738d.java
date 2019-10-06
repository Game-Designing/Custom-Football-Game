package com.airbnb.lottie.p089c.p091b;

import android.graphics.Path.FillType;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p086a.C5678c;
import com.airbnb.lottie.p085a.p086a.C5683h;
import com.airbnb.lottie.p089c.p090a.C5721b;
import com.airbnb.lottie.p089c.p090a.C5722c;
import com.airbnb.lottie.p089c.p090a.C5723d;
import com.airbnb.lottie.p089c.p090a.C5725f;
import com.airbnb.lottie.p089c.p092c.C5762c;

/* renamed from: com.airbnb.lottie.c.b.d */
/* compiled from: GradientFill */
public class C5738d implements C5736b {

    /* renamed from: a */
    private final C5740f f9861a;

    /* renamed from: b */
    private final FillType f9862b;

    /* renamed from: c */
    private final C5722c f9863c;

    /* renamed from: d */
    private final C5723d f9864d;

    /* renamed from: e */
    private final C5725f f9865e;

    /* renamed from: f */
    private final C5725f f9866f;

    /* renamed from: g */
    private final String f9867g;

    /* renamed from: h */
    private final C5721b f9868h;

    /* renamed from: i */
    private final C5721b f9869i;

    public C5738d(String name, C5740f gradientType, FillType fillType, C5722c gradientColor, C5723d opacity, C5725f startPoint, C5725f endPoint, C5721b highlightLength, C5721b highlightAngle) {
        this.f9861a = gradientType;
        this.f9862b = fillType;
        this.f9863c = gradientColor;
        this.f9864d = opacity;
        this.f9865e = startPoint;
        this.f9866f = endPoint;
        this.f9867g = name;
        this.f9868h = highlightLength;
        this.f9869i = highlightAngle;
    }

    /* renamed from: e */
    public String mo18008e() {
        return this.f9867g;
    }

    /* renamed from: d */
    public C5740f mo18007d() {
        return this.f9861a;
    }

    /* renamed from: b */
    public FillType mo18005b() {
        return this.f9862b;
    }

    /* renamed from: c */
    public C5722c mo18006c() {
        return this.f9863c;
    }

    /* renamed from: f */
    public C5723d mo18009f() {
        return this.f9864d;
    }

    /* renamed from: g */
    public C5725f mo18010g() {
        return this.f9865e;
    }

    /* renamed from: a */
    public C5725f mo18004a() {
        return this.f9866f;
    }

    /* renamed from: a */
    public C5678c mo17986a(C5851x drawable, C5762c layer) {
        return new C5683h(drawable, layer, this);
    }
}
