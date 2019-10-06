package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;

@zzard
public final class zzuq {

    /* renamed from: a */
    private final Object f29487a = new Object();

    /* renamed from: b */
    private C9763ut f29488b = null;

    /* renamed from: c */
    private boolean f29489c = false;

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo32285a(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f29487a
            monitor-enter(r0)
            boolean r1 = r4.f29489c     // Catch:{ all -> 0x003c }
            if (r1 != 0) goto L_0x003a
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.m22107a()     // Catch:{ all -> 0x003c }
            if (r1 != 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return
        L_0x000f:
            r1 = 0
            android.content.Context r2 = r5.getApplicationContext()     // Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x0017
            r2 = r5
        L_0x0017:
            boolean r3 = r2 instanceof android.app.Application     // Catch:{ all -> 0x003c }
            if (r3 == 0) goto L_0x001e
            r1 = r2
            android.app.Application r1 = (android.app.Application) r1     // Catch:{ all -> 0x003c }
        L_0x001e:
            if (r1 != 0) goto L_0x0027
            java.lang.String r5 = "Can not cast Context to Application"
            com.google.android.gms.internal.ads.zzbad.m26359d(r5)     // Catch:{ all -> 0x003c }
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return
        L_0x0027:
            com.google.android.gms.internal.ads.ut r2 = r4.f29488b     // Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x0032
            com.google.android.gms.internal.ads.ut r2 = new com.google.android.gms.internal.ads.ut     // Catch:{ all -> 0x003c }
            r2.<init>()     // Catch:{ all -> 0x003c }
            r4.f29488b = r2     // Catch:{ all -> 0x003c }
        L_0x0032:
            com.google.android.gms.internal.ads.ut r2 = r4.f29488b     // Catch:{ all -> 0x003c }
            r2.mo29218a(r1, r5)     // Catch:{ all -> 0x003c }
            r5 = 1
            r4.f29489c = r5     // Catch:{ all -> 0x003c }
        L_0x003a:
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return
        L_0x003c:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuq.mo32285a(android.content.Context):void");
    }

    /* renamed from: a */
    public final void mo32286a(zzut zzut) {
        synchronized (this.f29487a) {
            if (PlatformVersion.m22107a()) {
                if (this.f29488b == null) {
                    this.f29488b = new C9763ut();
                }
                this.f29488b.mo29219a(zzut);
            }
        }
    }

    /* renamed from: a */
    public final Activity mo32284a() {
        synchronized (this.f29487a) {
            if (!PlatformVersion.m22107a()) {
                return null;
            }
            if (this.f29488b == null) {
                return null;
            }
            Activity a = this.f29488b.mo29217a();
            return a;
        }
    }

    /* renamed from: b */
    public final Context mo32287b() {
        synchronized (this.f29487a) {
            if (!PlatformVersion.m22107a()) {
                return null;
            }
            if (this.f29488b == null) {
                return null;
            }
            Context b = this.f29488b.mo29220b();
            return b;
        }
    }
}
