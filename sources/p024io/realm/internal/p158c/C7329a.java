package p024io.realm.internal.p158c;

import io.realm.internal.util.Pair;

/* renamed from: io.realm.internal.c.a */
/* compiled from: Pair */
public class C7329a<F, S> {

    /* renamed from: a */
    public F f14306a;

    /* renamed from: b */
    public S f14307b;

    public C7329a(F first, S second) {
        this.f14306a = first;
        this.f14307b = second;
    }

    public boolean equals(Object o) {
        boolean z = false;
        if (!(o instanceof C7329a)) {
            return false;
        }
        Pair<?, ?> p = (C7329a) o;
        if (m16122b(p.f14306a, this.f14306a) && m16122b(p.f14307b, this.f14307b)) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    private boolean m16122b(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public int hashCode() {
        F f = this.f14306a;
        int i = 0;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.f14307b;
        if (s != null) {
            i = s.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pair{");
        sb.append(String.valueOf(this.f14306a));
        sb.append(" ");
        sb.append(String.valueOf(this.f14307b));
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    public static <A, B> C7329a<A, B> m16121a(A a, B b) {
        return new C7329a<>(a, b);
    }
}
