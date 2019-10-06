package com.airbnb.lottie.p089c.p091b;

import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p086a.C5678c;
import com.airbnb.lottie.p085a.p086a.C5696u;
import com.airbnb.lottie.p089c.p090a.C5720a;
import com.airbnb.lottie.p089c.p090a.C5721b;
import com.airbnb.lottie.p089c.p090a.C5723d;
import com.airbnb.lottie.p089c.p092c.C5762c;
import java.util.List;

/* renamed from: com.airbnb.lottie.c.b.q */
/* compiled from: ShapeStroke */
public class C5754q implements C5736b {

    /* renamed from: a */
    private final String f9936a;

    /* renamed from: b */
    private final C5721b f9937b;

    /* renamed from: c */
    private final List<C5721b> f9938c;

    /* renamed from: d */
    private final C5720a f9939d;

    /* renamed from: e */
    private final C5723d f9940e;

    /* renamed from: f */
    private final C5721b f9941f;

    /* renamed from: g */
    private final C5755a f9942g;

    /* renamed from: h */
    private final C5756b f9943h;

    /* renamed from: i */
    private final float f9944i;

    /* renamed from: com.airbnb.lottie.c.b.q$a */
    /* compiled from: ShapeStroke */
    public enum C5755a {
        Butt,
        Round,
        Unknown;

        /* renamed from: e */
        public Cap mo18072e() {
            int i = C5753p.f9934a[ordinal()];
            if (i == 1) {
                return Cap.BUTT;
            }
            if (i != 2) {
                return Cap.SQUARE;
            }
            return Cap.ROUND;
        }
    }

    /* renamed from: com.airbnb.lottie.c.b.q$b */
    /* compiled from: ShapeStroke */
    public enum C5756b {
        Miter,
        Round,
        Bevel;

        /* renamed from: e */
        public Join mo18073e() {
            int i = C5753p.f9935b[ordinal()];
            if (i == 1) {
                return Join.BEVEL;
            }
            if (i == 2) {
                return Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Join.ROUND;
        }
    }

    public C5754q(String name, C5721b offset, List<C5721b> lineDashPattern, C5720a color, C5723d opacity, C5721b width, C5755a capType, C5756b joinType, float miterLimit) {
        this.f9936a = name;
        this.f9937b = offset;
        this.f9938c = lineDashPattern;
        this.f9939d = color;
        this.f9940e = opacity;
        this.f9941f = width;
        this.f9942g = capType;
        this.f9943h = joinType;
        this.f9944i = miterLimit;
    }

    /* renamed from: a */
    public C5678c mo17986a(C5851x drawable, C5762c layer) {
        return new C5696u(drawable, layer, this);
    }

    /* renamed from: g */
    public String mo18069g() {
        return this.f9936a;
    }

    /* renamed from: b */
    public C5720a mo18064b() {
        return this.f9939d;
    }

    /* renamed from: h */
    public C5723d mo18070h() {
        return this.f9940e;
    }

    /* renamed from: i */
    public C5721b mo18071i() {
        return this.f9941f;
    }

    /* renamed from: e */
    public List<C5721b> mo18067e() {
        return this.f9938c;
    }

    /* renamed from: c */
    public C5721b mo18065c() {
        return this.f9937b;
    }

    /* renamed from: a */
    public C5755a mo18063a() {
        return this.f9942g;
    }

    /* renamed from: d */
    public C5756b mo18066d() {
        return this.f9943h;
    }

    /* renamed from: f */
    public float mo18068f() {
        return this.f9944i;
    }
}
