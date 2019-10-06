package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzbtb extends zzbts<zzbtf> {

    /* renamed from: b */
    private final ScheduledExecutorService f25849b;

    /* renamed from: c */
    private final Clock f25850c;

    /* renamed from: d */
    private long f25851d = -1;

    /* renamed from: e */
    private long f25852e = -1;

    /* renamed from: f */
    private boolean f25853f = false;

    /* renamed from: g */
    private ScheduledFuture<?> f25854g;

    public zzbtb(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.f25849b = scheduledExecutorService;
        this.f25850c = clock;
    }

    public final synchronized void onPause() {
        if (!this.f25853f) {
            if (this.f25854g == null || this.f25854g.isCancelled()) {
                this.f25852e = -1;
            } else {
                this.f25854g.cancel(true);
                this.f25852e = this.f25851d - this.f25850c.mo27934a();
            }
            this.f25853f = true;
        }
    }

    public final synchronized void onResume() {
        if (this.f25853f) {
            if (this.f25852e > 0 && this.f25854g.isCancelled()) {
                m27753a(this.f25852e);
            }
            this.f25853f = false;
        }
    }

    /* renamed from: G */
    public final synchronized void mo30890G() {
        this.f25853f = false;
        m27753a(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo30891b(int r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 > 0) goto L_0x0005
            monitor-exit(r6)
            return
        L_0x0005:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0044 }
            long r1 = (long) r7     // Catch:{ all -> 0x0044 }
            long r0 = r0.toMillis(r1)     // Catch:{ all -> 0x0044 }
            boolean r7 = r6.f25853f     // Catch:{ all -> 0x0044 }
            if (r7 == 0) goto L_0x0026
            long r2 = r6.f25852e     // Catch:{ all -> 0x0044 }
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x0020
            long r2 = r6.f25852e     // Catch:{ all -> 0x0044 }
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            long r0 = r6.f25852e     // Catch:{ all -> 0x0044 }
        L_0x0022:
            r6.f25852e = r0     // Catch:{ all -> 0x0044 }
            monitor-exit(r6)
            return
        L_0x0026:
            com.google.android.gms.common.util.Clock r7 = r6.f25850c     // Catch:{ all -> 0x0044 }
            long r2 = r7.mo27934a()     // Catch:{ all -> 0x0044 }
            long r4 = r6.f25851d     // Catch:{ all -> 0x0044 }
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x003f
            long r2 = r6.f25851d     // Catch:{ all -> 0x0044 }
            com.google.android.gms.common.util.Clock r7 = r6.f25850c     // Catch:{ all -> 0x0044 }
            long r4 = r7.mo27934a()     // Catch:{ all -> 0x0044 }
            long r2 = r2 - r4
            int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r7 <= 0) goto L_0x0042
        L_0x003f:
            r6.m27753a(r0)     // Catch:{ all -> 0x0044 }
        L_0x0042:
            monitor-exit(r6)
            return
        L_0x0044:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbtb.mo30891b(int):void");
    }

    /* renamed from: a */
    private final synchronized void m27753a(long j) {
        if (this.f25854g != null && !this.f25854g.isDone()) {
            this.f25854g.cancel(true);
        }
        this.f25851d = this.f25850c.mo27934a() + j;
        this.f25854g = this.f25849b.schedule(new C8935Jg(this), j, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    /* renamed from: H */
    public final void m27752H() {
        mo30895a(C8893Hg.f21205a);
    }
}
