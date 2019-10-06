package com.google.android.gms.common;

import android.content.Context;

/* renamed from: com.google.android.gms.common.a */
final class C8629a {

    /* renamed from: a */
    private static final Object f19541a = new Object();

    /* renamed from: b */
    private static Context f19542b;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized void m21107a(android.content.Context r2) {
        /*
            java.lang.Class<com.google.android.gms.common.a> r0 = com.google.android.gms.common.C8629a.class
            monitor-enter(r0)
            android.content.Context r1 = f19542b     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x0011
            if (r2 == 0) goto L_0x0018
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x001a }
            f19542b = r2     // Catch:{ all -> 0x001a }
            monitor-exit(r0)
            return
        L_0x0011:
            java.lang.String r2 = "GoogleCertificates"
            java.lang.String r1 = "GoogleCertificates has been initialized already"
            android.util.Log.w(r2, r1)     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r0)
            return
        L_0x001a:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.C8629a.m21107a(android.content.Context):void");
    }
}
