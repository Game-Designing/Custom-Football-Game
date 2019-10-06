package com.airbnb.lottie.p089c.p091b;

import android.graphics.PointF;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p086a.C5678c;
import com.airbnb.lottie.p085a.p086a.C5681f;
import com.airbnb.lottie.p089c.p090a.C5725f;
import com.airbnb.lottie.p089c.p090a.C5732m;
import com.airbnb.lottie.p089c.p092c.C5762c;

/* renamed from: com.airbnb.lottie.c.b.a */
/* compiled from: CircleShape */
public class C5735a implements C5736b {

    /* renamed from: a */
    private final String f9855a;

    /* renamed from: b */
    private final C5732m<PointF, PointF> f9856b;

    /* renamed from: c */
    private final C5725f f9857c;

    /* renamed from: d */
    private final boolean f9858d;

    public C5735a(String name, C5732m<PointF, PointF> position, C5725f size, boolean isReversed) {
        this.f9855a = name;
        this.f9856b = position;
        this.f9857c = size;
        this.f9858d = isReversed;
    }

    /* renamed from: a */
    public C5678c mo17986a(C5851x drawable, C5762c layer) {
        return new C5681f(drawable, layer, this);
    }

    /* renamed from: a */
    public String mo17996a() {
        return this.f9855a;
    }

    /* renamed from: b */
    public C5732m<PointF, PointF> mo17997b() {
        return this.f9856b;
    }

    /* renamed from: c */
    public C5725f mo17998c() {
        return this.f9857c;
    }

    /* renamed from: d */
    public boolean mo17999d() {
        return this.f9858d;
    }
}
