package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.ep */
final class C9412ep implements C9544kp {

    /* renamed from: a */
    private C9544kp[] f22224a;

    C9412ep(C9544kp... kpVarArr) {
        this.f22224a = kpVarArr;
    }

    /* renamed from: b */
    public final boolean mo28591b(Class<?> cls) {
        for (C9544kp b : this.f22224a) {
            if (b.mo28591b(cls)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final C9522jp mo28590a(Class<?> cls) {
        C9544kp[] kpVarArr;
        for (C9544kp kpVar : this.f22224a) {
            if (kpVar.mo28591b(cls)) {
                return kpVar.mo28590a(cls);
            }
        }
        String str = "No factory is available for message type: ";
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
