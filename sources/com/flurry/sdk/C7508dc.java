package com.flurry.sdk;

/* renamed from: com.flurry.sdk.dc */
public final class C7508dc {

    /* renamed from: a */
    public static final String f14798a = C7508dc.class.getSimpleName();

    /* renamed from: b */
    private static C7508dc f14799b = null;

    /* renamed from: c */
    public boolean f14800c = false;

    private C7508dc() {
    }

    /* renamed from: a */
    public static synchronized C7508dc m16634a() {
        C7508dc dcVar;
        synchronized (C7508dc.class) {
            if (f14799b == null) {
                f14799b = new C7508dc();
            }
            dcVar = f14799b;
        }
        return dcVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
        return p019d.p020e.p021a.C7294e.m15872d() != null ? p019d.p020e.p021a.C7294e.m15872d() : com.flurry.sdk.C7412Lb.m16398a().mo23854c();
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String mo23946b() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f14800c     // Catch:{ all -> 0x001e }
            if (r0 != 0) goto L_0x0009
            r0 = 0
            monitor-exit(r1)
            return r0
        L_0x0009:
            java.lang.String r0 = p019d.p020e.p021a.C7294e.m15872d()     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x0015
            java.lang.String r0 = p019d.p020e.p021a.C7294e.m15872d()     // Catch:{ all -> 0x001e }
        L_0x0013:
            monitor-exit(r1)
            return r0
        L_0x0015:
            com.flurry.sdk.Lb r0 = com.flurry.sdk.C7412Lb.m16398a()     // Catch:{ all -> 0x001e }
            java.lang.String r0 = r0.mo23854c()     // Catch:{ all -> 0x001e }
            goto L_0x0013
        L_0x001e:
            r0 = move-exception
            monitor-exit(r1)
            goto L_0x0022
        L_0x0021:
            throw r0
        L_0x0022:
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7508dc.mo23946b():java.lang.String");
    }
}
