package com.airbnb.lottie.p089c.p091b;

import android.graphics.PointF;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p086a.C5678c;
import com.airbnb.lottie.p085a.p086a.C5693r;
import com.airbnb.lottie.p089c.p090a.C5721b;
import com.airbnb.lottie.p089c.p090a.C5725f;
import com.airbnb.lottie.p089c.p090a.C5732m;
import com.airbnb.lottie.p089c.p092c.C5762c;

/* renamed from: com.airbnb.lottie.c.b.j */
/* compiled from: RectangleShape */
public class C5747j implements C5736b {

    /* renamed from: a */
    private final String f9913a;

    /* renamed from: b */
    private final C5732m<PointF, PointF> f9914b;

    /* renamed from: c */
    private final C5725f f9915c;

    /* renamed from: d */
    private final C5721b f9916d;

    public C5747j(String name, C5732m<PointF, PointF> position, C5725f size, C5721b cornerRadius) {
        this.f9913a = name;
        this.f9914b = position;
        this.f9915c = size;
        this.f9916d = cornerRadius;
    }

    /* renamed from: b */
    public String mo18039b() {
        return this.f9913a;
    }

    /* renamed from: a */
    public C5721b mo18038a() {
        return this.f9916d;
    }

    /* renamed from: d */
    public C5725f mo18041d() {
        return this.f9915c;
    }

    /* renamed from: c */
    public C5732m<PointF, PointF> mo18040c() {
        return this.f9914b;
    }

    /* renamed from: a */
    public C5678c mo17986a(C5851x drawable, C5762c layer) {
        return new C5693r(drawable, layer, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RectangleShape{position=");
        sb.append(this.f9914b);
        sb.append(", size=");
        sb.append(this.f9915c);
        sb.append('}');
        return sb.toString();
    }
}
