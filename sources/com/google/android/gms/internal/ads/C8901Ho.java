package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Ho */
final class C8901Ho {

    /* renamed from: a */
    private static final Class<?> f21219a = m22672c();

    /* renamed from: c */
    private static Class<?> m22672c() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static zzdno m22669a() {
        if (f21219a != null) {
            try {
                return m22670a("getEmptyRegistry");
            } catch (Exception e) {
            }
        }
        return zzdno.f28003d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0010  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.ads.zzdno m22671b() {
        /*
            java.lang.Class<?> r0 = f21219a
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = "loadGeneratedRegistry"
            com.google.android.gms.internal.ads.zzdno r0 = m22670a(r0)     // Catch:{ Exception -> 0x000c }
            goto L_0x000e
        L_0x000c:
            r0 = move-exception
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 != 0) goto L_0x0014
            com.google.android.gms.internal.ads.zzdno r0 = com.google.android.gms.internal.ads.zzdno.m29865a()
        L_0x0014:
            if (r0 != 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzdno r0 = m22669a()
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C8901Ho.m22671b():com.google.android.gms.internal.ads.zzdno");
    }

    /* renamed from: a */
    private static final zzdno m22670a(String str) throws Exception {
        return (zzdno) f21219a.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
