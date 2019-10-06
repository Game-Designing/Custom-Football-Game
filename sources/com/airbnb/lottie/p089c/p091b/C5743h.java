package com.airbnb.lottie.p089c.p091b;

import com.airbnb.lottie.C5718c;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p086a.C5678c;
import com.airbnb.lottie.p085a.p086a.C5688m;
import com.airbnb.lottie.p089c.p092c.C5762c;

/* renamed from: com.airbnb.lottie.c.b.h */
/* compiled from: MergePaths */
public class C5743h implements C5736b {

    /* renamed from: a */
    private final String f9892a;

    /* renamed from: b */
    private final C5744a f9893b;

    /* renamed from: com.airbnb.lottie.c.b.h$a */
    /* compiled from: MergePaths */
    public enum C5744a {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        /* renamed from: a */
        public static C5744a m10244a(int id) {
            if (id == 1) {
                return Merge;
            }
            if (id == 2) {
                return Add;
            }
            if (id == 3) {
                return Subtract;
            }
            if (id == 4) {
                return Intersect;
            }
            if (id != 5) {
                return Merge;
            }
            return ExcludeIntersections;
        }
    }

    public C5743h(String name, C5744a mode) {
        this.f9892a = name;
        this.f9893b = mode;
    }

    /* renamed from: b */
    public String mo18027b() {
        return this.f9892a;
    }

    /* renamed from: a */
    public C5744a mo18026a() {
        return this.f9893b;
    }

    /* renamed from: a */
    public C5678c mo17986a(C5851x drawable, C5762c layer) {
        if (drawable.mo18242c()) {
            return new C5688m(this);
        }
        C5718c.m10179d("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MergePaths{mode=");
        sb.append(this.f9893b);
        sb.append('}');
        return sb.toString();
    }
}
