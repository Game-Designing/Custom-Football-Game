package p002b.p003c.p053g.p061f;

import android.support.v4.util.Pair;

/* renamed from: b.c.g.f.l */
/* compiled from: Pair */
public class C1268l<F, S> {

    /* renamed from: a */
    public final F f4069a;

    /* renamed from: b */
    public final S f4070b;

    public C1268l(F first, S second) {
        this.f4069a = first;
        this.f4070b = second;
    }

    public boolean equals(Object o) {
        boolean z = false;
        if (!(o instanceof C1268l)) {
            return false;
        }
        Pair<?, ?> p = (C1268l) o;
        if (m5951a(p.f4069a, this.f4069a) && m5951a(p.f4070b, this.f4070b)) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m5951a(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public int hashCode() {
        F f = this.f4069a;
        int i = 0;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.f4070b;
        if (s != null) {
            i = s.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pair{");
        sb.append(String.valueOf(this.f4069a));
        sb.append(" ");
        sb.append(String.valueOf(this.f4070b));
        sb.append("}");
        return sb.toString();
    }
}
