package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzcxk {

    /* renamed from: a */
    private final Clock f27531a;

    /* renamed from: b */
    private final Object f27532b = new Object();

    /* renamed from: c */
    private volatile int f27533c = C9563lm.f22724a;

    /* renamed from: d */
    private volatile long f27534d = 0;

    public zzcxk(Clock clock) {
        this.f27531a = clock;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m28945a(int r5, int r6) {
        /*
            r4 = this;
            r4.m28946d()
            com.google.android.gms.common.util.Clock r0 = r4.f27531a
            long r0 = r0.mo27935b()
            java.lang.Object r2 = r4.f27532b
            monitor-enter(r2)
            int r3 = r4.f27533c     // Catch:{ all -> 0x001e }
            if (r3 == r5) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            return
        L_0x0012:
            r4.f27533c = r6     // Catch:{ all -> 0x001e }
            int r5 = r4.f27533c     // Catch:{ all -> 0x001e }
            int r6 = com.google.android.gms.internal.ads.C9563lm.f22726c     // Catch:{ all -> 0x001e }
            if (r5 != r6) goto L_0x001c
            r4.f27534d = r0     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcxk.m28945a(int, int):void");
    }

    /* renamed from: d */
    private final void m28946d() {
        long b = this.f27531a.mo27935b();
        synchronized (this.f27532b) {
            if (this.f27533c == C9563lm.f22726c) {
                if (this.f27534d + ((Long) zzyt.m31536e().mo29599a(zzacu.f23943He)).longValue() <= b) {
                    this.f27533c = C9563lm.f22724a;
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo31281a(boolean z) {
        if (z) {
            m28945a(C9563lm.f22724a, C9563lm.f22725b);
        } else {
            m28945a(C9563lm.f22725b, C9563lm.f22724a);
        }
    }

    /* renamed from: a */
    public final boolean mo31282a() {
        boolean z;
        synchronized (this.f27532b) {
            m28946d();
            z = this.f27533c == C9563lm.f22725b;
        }
        return z;
    }

    /* renamed from: b */
    public final boolean mo31283b() {
        boolean z;
        synchronized (this.f27532b) {
            m28946d();
            z = this.f27533c == C9563lm.f22726c;
        }
        return z;
    }

    /* renamed from: c */
    public final void mo31284c() {
        m28945a(C9563lm.f22725b, C9563lm.f22726c);
    }
}
