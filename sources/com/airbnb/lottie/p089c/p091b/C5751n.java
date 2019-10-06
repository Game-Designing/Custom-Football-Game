package com.airbnb.lottie.p089c.p091b;

import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p086a.C5678c;
import com.airbnb.lottie.p085a.p086a.C5679d;
import com.airbnb.lottie.p089c.p092c.C5762c;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.airbnb.lottie.c.b.n */
/* compiled from: ShapeGroup */
public class C5751n implements C5736b {

    /* renamed from: a */
    private final String f9929a;

    /* renamed from: b */
    private final List<C5736b> f9930b;

    public C5751n(String name, List<C5736b> items) {
        this.f9929a = name;
        this.f9930b = items;
    }

    /* renamed from: b */
    public String mo18058b() {
        return this.f9929a;
    }

    /* renamed from: a */
    public List<C5736b> mo18057a() {
        return this.f9930b;
    }

    /* renamed from: a */
    public C5678c mo17986a(C5851x drawable, C5762c layer) {
        return new C5679d(drawable, layer, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapeGroup{name='");
        sb.append(this.f9929a);
        sb.append("' Shapes: ");
        sb.append(Arrays.toString(this.f9930b.toArray()));
        sb.append('}');
        return sb.toString();
    }
}
