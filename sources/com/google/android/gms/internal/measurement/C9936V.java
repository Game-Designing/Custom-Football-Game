package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.V */
final class C9936V {

    /* renamed from: a */
    private static final Class<?> f30040a = m31931b();

    /* renamed from: b */
    private static Class<?> m31931b() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static zzub m31929a() {
        if (f30040a != null) {
            try {
                return m31930a("getEmptyRegistry");
            } catch (Exception e) {
            }
        }
        return zzub.f30264c;
    }

    /* renamed from: a */
    private static final zzub m31930a(String str) throws Exception {
        return (zzub) f30040a.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
