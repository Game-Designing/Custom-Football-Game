package com.airbnb.lottie.p089c.p091b;

import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p086a.C5678c;
import com.airbnb.lottie.p085a.p086a.C5695t;
import com.airbnb.lottie.p089c.p090a.C5727h;
import com.airbnb.lottie.p089c.p092c.C5762c;

/* renamed from: com.airbnb.lottie.c.b.o */
/* compiled from: ShapePath */
public class C5752o implements C5736b {

    /* renamed from: a */
    private final String f9931a;

    /* renamed from: b */
    private final int f9932b;

    /* renamed from: c */
    private final C5727h f9933c;

    public C5752o(String name, int index, C5727h shapePath) {
        this.f9931a = name;
        this.f9932b = index;
        this.f9933c = shapePath;
    }

    /* renamed from: a */
    public String mo18060a() {
        return this.f9931a;
    }

    /* renamed from: b */
    public C5727h mo18061b() {
        return this.f9933c;
    }

    /* renamed from: a */
    public C5678c mo17986a(C5851x drawable, C5762c layer) {
        return new C5695t(drawable, layer, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapePath{name=");
        sb.append(this.f9931a);
        sb.append(", index=");
        sb.append(this.f9932b);
        sb.append('}');
        return sb.toString();
    }
}
