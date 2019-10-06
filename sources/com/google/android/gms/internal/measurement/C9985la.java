package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.la */
final class C9985la extends C9976ia {
    private C9985la() {
        super();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32734a(Object obj, long j) {
        m32117b(obj, j).mo32545s();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final <E> void mo32735a(Object obj, Object obj2, long j) {
        zzuu b = m32117b(obj, j);
        zzuu b2 = m32117b(obj2, j);
        int size = b.size();
        int size2 = b2.size();
        if (size > 0 && size2 > 0) {
            if (!b.mo32546w()) {
                b = b.mo32721e(size2 + size);
            }
            b.addAll(b2);
        }
        if (size > 0) {
            b2 = b;
        }
        C9946_a.m31994a(obj, j, (Object) b2);
    }

    /* renamed from: b */
    private static <E> zzuu<E> m32117b(Object obj, long j) {
        return (zzuu) C9946_a.m32016f(obj, j);
    }
}
