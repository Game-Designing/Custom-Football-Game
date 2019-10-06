package com.airbnb.lottie.p089c;

import android.support.v4.util.Pair;
import p002b.p003c.p053g.p061f.C1268l;

/* renamed from: com.airbnb.lottie.c.h */
/* compiled from: MutablePair */
public class C5779h<T> {

    /* renamed from: a */
    T f10066a;

    /* renamed from: b */
    T f10067b;

    /* renamed from: a */
    public void mo18128a(T first, T second) {
        this.f10066a = first;
        this.f10067b = second;
    }

    public boolean equals(Object o) {
        boolean z = false;
        if (!(o instanceof C1268l)) {
            return false;
        }
        Pair<?, ?> p = (C1268l) o;
        if (m10398b(p.f4069a, this.f10066a) && m10398b(p.f4070b, this.f10067b)) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    private static boolean m10398b(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public int hashCode() {
        T t = this.f10066a;
        int i = 0;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f10067b;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pair{");
        sb.append(String.valueOf(this.f10066a));
        sb.append(" ");
        sb.append(String.valueOf(this.f10067b));
        sb.append("}");
        return sb.toString();
    }
}
