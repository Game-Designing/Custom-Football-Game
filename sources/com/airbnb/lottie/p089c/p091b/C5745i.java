package com.airbnb.lottie.p089c.p091b;

import android.graphics.PointF;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p086a.C5678c;
import com.airbnb.lottie.p085a.p086a.C5692q;
import com.airbnb.lottie.p089c.p090a.C5721b;
import com.airbnb.lottie.p089c.p090a.C5732m;
import com.airbnb.lottie.p089c.p092c.C5762c;

/* renamed from: com.airbnb.lottie.c.b.i */
/* compiled from: PolystarShape */
public class C5745i implements C5736b {

    /* renamed from: a */
    private final String f9900a;

    /* renamed from: b */
    private final C5746a f9901b;

    /* renamed from: c */
    private final C5721b f9902c;

    /* renamed from: d */
    private final C5732m<PointF, PointF> f9903d;

    /* renamed from: e */
    private final C5721b f9904e;

    /* renamed from: f */
    private final C5721b f9905f;

    /* renamed from: g */
    private final C5721b f9906g;

    /* renamed from: h */
    private final C5721b f9907h;

    /* renamed from: i */
    private final C5721b f9908i;

    /* renamed from: com.airbnb.lottie.c.b.i$a */
    /* compiled from: PolystarShape */
    public enum C5746a {
        Star(1),
        Polygon(2);
        

        /* renamed from: d */
        private final int f9912d;

        private C5746a(int value) {
            this.f9912d = value;
        }

        /* renamed from: a */
        public static C5746a m10255a(int value) {
            C5746a[] values;
            for (C5746a type : values()) {
                if (type.f9912d == value) {
                    return type;
                }
            }
            return null;
        }
    }

    public C5745i(String name, C5746a type, C5721b points, C5732m<PointF, PointF> position, C5721b rotation, C5721b innerRadius, C5721b outerRadius, C5721b innerRoundedness, C5721b outerRoundedness) {
        this.f9900a = name;
        this.f9901b = type;
        this.f9902c = points;
        this.f9903d = position;
        this.f9904e = rotation;
        this.f9905f = innerRadius;
        this.f9906g = outerRadius;
        this.f9907h = innerRoundedness;
        this.f9908i = outerRoundedness;
    }

    /* renamed from: c */
    public String mo18031c() {
        return this.f9900a;
    }

    /* renamed from: i */
    public C5746a mo18037i() {
        return this.f9901b;
    }

    /* renamed from: f */
    public C5721b mo18034f() {
        return this.f9902c;
    }

    /* renamed from: g */
    public C5732m<PointF, PointF> mo18035g() {
        return this.f9903d;
    }

    /* renamed from: h */
    public C5721b mo18036h() {
        return this.f9904e;
    }

    /* renamed from: a */
    public C5721b mo18029a() {
        return this.f9905f;
    }

    /* renamed from: d */
    public C5721b mo18032d() {
        return this.f9906g;
    }

    /* renamed from: b */
    public C5721b mo18030b() {
        return this.f9907h;
    }

    /* renamed from: e */
    public C5721b mo18033e() {
        return this.f9908i;
    }

    /* renamed from: a */
    public C5678c mo17986a(C5851x drawable, C5762c layer) {
        return new C5692q(drawable, layer, this);
    }
}
