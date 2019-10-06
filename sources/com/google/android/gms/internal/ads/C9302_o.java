package com.google.android.gms.internal.ads;

import java.util.List;

/* renamed from: com.google.android.gms.internal.ads._o */
final class C9302_o extends C9240Xo {
    private C9302_o() {
        super();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final <L> List<L> mo28696a(Object obj, long j) {
        zzdoj c = m23406c(obj, j);
        if (c.mo29067t()) {
            return c;
        }
        int size = c.size();
        zzdoj b = c.mo28270b(size == 0 ? 10 : size << 1);
        C9132Sp.m22986a(obj, j, (Object) b);
        return b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo28698b(Object obj, long j) {
        m23406c(obj, j).mo29068u();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final <E> void mo28697a(Object obj, Object obj2, long j) {
        zzdoj c = m23406c(obj, j);
        zzdoj c2 = m23406c(obj2, j);
        int size = c.size();
        int size2 = c2.size();
        if (size > 0 && size2 > 0) {
            if (!c.mo29067t()) {
                c = c.mo28270b(size2 + size);
            }
            c.addAll(c2);
        }
        if (size > 0) {
            c2 = c;
        }
        C9132Sp.m22986a(obj, j, (Object) c2);
    }

    /* renamed from: c */
    private static <E> zzdoj<E> m23406c(Object obj, long j) {
        return (zzdoj) C9132Sp.m23009f(obj, j);
    }
}
