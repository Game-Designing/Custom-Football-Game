package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.pa */
final class C9996pa implements C10008va {

    /* renamed from: a */
    private C10008va[] f30156a;

    C9996pa(C10008va... vaVarArr) {
        this.f30156a = vaVarArr;
    }

    /* renamed from: b */
    public final boolean mo32718b(Class<?> cls) {
        for (C10008va b : this.f30156a) {
            if (b.mo32718b(cls)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final C10006ua mo32717a(Class<?> cls) {
        C10008va[] vaVarArr;
        for (C10008va vaVar : this.f30156a) {
            if (vaVar.mo32718b(cls)) {
                return vaVar.mo32717a(cls);
            }
        }
        String str = "No factory is available for message type: ";
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
