package kotlin;

import java.io.Serializable;

/* renamed from: kotlin.b */
/* compiled from: Tuples.kt */
public final class C14268b<A, B> implements Serializable {

    /* renamed from: a */
    private final A f43212a;

    /* renamed from: b */
    private final B f43213b;

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.p376c.p378b.C14281f.m45915a((java.lang.Object) r2.f43213b, (java.lang.Object) r3.f43213b) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof kotlin.C14268b
            if (r0 == 0) goto L_0x001d
            kotlin.b r3 = (kotlin.C14268b) r3
            A r0 = r2.f43212a
            A r1 = r3.f43212a
            boolean r0 = kotlin.p376c.p378b.C14281f.m45915a(r0, r1)
            if (r0 == 0) goto L_0x001d
            B r0 = r2.f43213b
            B r3 = r3.f43213b
            boolean r3 = kotlin.p376c.p378b.C14281f.m45915a(r0, r3)
            if (r3 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r3 = 0
            return r3
        L_0x001f:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.C14268b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        A a = this.f43212a;
        int i = 0;
        int hashCode = (a != null ? a.hashCode() : 0) * 31;
        B b = this.f43213b;
        if (b != null) {
            i = b.hashCode();
        }
        return hashCode + i;
    }

    public C14268b(A first, B second) {
        this.f43212a = first;
        this.f43213b = second;
    }

    /* renamed from: a */
    public final A mo44425a() {
        return this.f43212a;
    }

    /* renamed from: b */
    public final B mo44426b() {
        return this.f43213b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(this.f43212a);
        sb.append(", ");
        sb.append(this.f43213b);
        sb.append(')');
        return sb.toString();
    }
}
