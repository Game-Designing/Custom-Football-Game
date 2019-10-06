package com.google.android.gms.internal.ads;

import android.content.Context;

@zzard
public final class zzavf implements zzue {

    /* renamed from: a */
    private final Context f24857a;

    /* renamed from: b */
    private final Object f24858b;

    /* renamed from: c */
    private String f24859c;

    /* renamed from: d */
    private boolean f24860d;

    public zzavf(Context context, String str) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.f24857a = context;
        this.f24859c = str;
        this.f24860d = false;
        this.f24858b = new Object();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        return;
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo30119f(boolean r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzavg r0 = com.google.android.gms.ads.internal.zzk.zzme()
            android.content.Context r1 = r3.f24857a
            boolean r0 = r0.mo30134f(r1)
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.Object r0 = r3.f24858b
            monitor-enter(r0)
            boolean r1 = r3.f24860d     // Catch:{ all -> 0x003f }
            if (r1 != r4) goto L_0x0016
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x0016:
            r3.f24860d = r4     // Catch:{ all -> 0x003f }
            java.lang.String r4 = r3.f24859c     // Catch:{ all -> 0x003f }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x003f }
            if (r4 == 0) goto L_0x0022
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x0022:
            boolean r4 = r3.f24860d     // Catch:{ all -> 0x003f }
            if (r4 == 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzavg r4 = com.google.android.gms.ads.internal.zzk.zzme()     // Catch:{ all -> 0x003f }
            android.content.Context r1 = r3.f24857a     // Catch:{ all -> 0x003f }
            java.lang.String r2 = r3.f24859c     // Catch:{ all -> 0x003f }
            r4.mo30122a(r1, r2)     // Catch:{ all -> 0x003f }
            goto L_0x003d
        L_0x0032:
            com.google.android.gms.internal.ads.zzavg r4 = com.google.android.gms.ads.internal.zzk.zzme()     // Catch:{ all -> 0x003f }
            android.content.Context r1 = r3.f24857a     // Catch:{ all -> 0x003f }
            java.lang.String r2 = r3.f24859c     // Catch:{ all -> 0x003f }
            r4.mo30126b(r1, r2)     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzavf.mo30119f(boolean):void");
    }

    /* renamed from: a */
    public final void mo28694a(zzud zzud) {
        mo30119f(zzud.f29465m);
    }

    /* renamed from: C */
    public final String mo30118C() {
        return this.f24859c;
    }
}
