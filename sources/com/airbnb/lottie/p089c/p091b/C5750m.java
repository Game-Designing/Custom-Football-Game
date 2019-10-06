package com.airbnb.lottie.p089c.p091b;

import android.graphics.Path.FillType;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p086a.C5678c;
import com.airbnb.lottie.p085a.p086a.C5682g;
import com.airbnb.lottie.p089c.p090a.C5720a;
import com.airbnb.lottie.p089c.p090a.C5723d;
import com.airbnb.lottie.p089c.p092c.C5762c;

/* renamed from: com.airbnb.lottie.c.b.m */
/* compiled from: ShapeFill */
public class C5750m implements C5736b {

    /* renamed from: a */
    private final boolean f9924a;

    /* renamed from: b */
    private final FillType f9925b;

    /* renamed from: c */
    private final String f9926c;

    /* renamed from: d */
    private final C5720a f9927d;

    /* renamed from: e */
    private final C5723d f9928e;

    public C5750m(String name, boolean fillEnabled, FillType fillType, C5720a color, C5723d opacity) {
        this.f9926c = name;
        this.f9924a = fillEnabled;
        this.f9925b = fillType;
        this.f9927d = color;
        this.f9928e = opacity;
    }

    /* renamed from: c */
    public String mo18054c() {
        return this.f9926c;
    }

    /* renamed from: a */
    public C5720a mo18052a() {
        return this.f9927d;
    }

    /* renamed from: d */
    public C5723d mo18055d() {
        return this.f9928e;
    }

    /* renamed from: b */
    public FillType mo18053b() {
        return this.f9925b;
    }

    /* renamed from: a */
    public C5678c mo17986a(C5851x drawable, C5762c layer) {
        return new C5682g(drawable, layer, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapeFill{color=, fillEnabled=");
        sb.append(this.f9924a);
        sb.append('}');
        return sb.toString();
    }
}
