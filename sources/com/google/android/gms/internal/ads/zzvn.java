package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;

@zzard
public final class zzvn {

    /* renamed from: a */
    private final Runnable f29545a = new C8801Ct(this);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f29546b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public zzvu f29547c;

    /* renamed from: d */
    private Context f29548d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public zzvy f29549e;

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo32316a(android.content.Context r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Object r0 = r2.f29546b
            monitor-enter(r0)
            android.content.Context r1 = r2.f29548d     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x000c:
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0048 }
            r2.f29548d = r3     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzacu.f24170sd     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzacr r1 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.mo29599a(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0028
            r2.m31301b()     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0028:
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzacu.f24164rd     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzacr r1 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.mo29599a(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.Dt r3 = new com.google.android.gms.internal.ads.Dt     // Catch:{ all -> 0x0048 }
            r3.<init>(r2)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzuq r1 = com.google.android.gms.ads.internal.zzk.zzlj()     // Catch:{ all -> 0x0048 }
            r1.mo32286a(r3)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvn.mo32316a(android.content.Context):void");
    }

    /* renamed from: a */
    public final void mo32315a() {
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24176td)).booleanValue()) {
            synchronized (this.f29546b) {
                m31301b();
                zzk.zzlg();
                zzaxi.f24961a.removeCallbacks(this.f29545a);
                zzk.zzlg();
                zzaxi.f24961a.postDelayed(this.f29545a, ((Long) zzyt.m31536e().mo29599a(zzacu.f24182ud)).longValue());
            }
        }
    }

    /* renamed from: a */
    public final zzvs mo32314a(zzvv zzvv) {
        synchronized (this.f29546b) {
            if (this.f29549e == null) {
                zzvs zzvs = new zzvs();
                return zzvs;
            }
            try {
                zzvs a = this.f29549e.mo32326a(zzvv);
                return a;
            } catch (RemoteException e) {
                zzbad.m26356b("Unable to call into cache service.", e);
                return new zzvs();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m31301b() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f29546b
            monitor-enter(r0)
            android.content.Context r1 = r3.f29548d     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0023
            com.google.android.gms.internal.ads.zzvu r1 = r3.f29547c     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0023
        L_0x000c:
            com.google.android.gms.internal.ads.Et r1 = new com.google.android.gms.internal.ads.Et     // Catch:{ all -> 0x0025 }
            r1.<init>(r3)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.Ft r2 = new com.google.android.gms.internal.ads.Ft     // Catch:{ all -> 0x0025 }
            r2.<init>(r3)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzvu r1 = r3.m31297a(r1, r2)     // Catch:{ all -> 0x0025 }
            r3.f29547c = r1     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzvu r1 = r3.f29547c     // Catch:{ all -> 0x0025 }
            r1.checkAvailabilityAndConnect()     // Catch:{ all -> 0x0025 }
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0025:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvn.m31301b():void");
    }

    @VisibleForTesting
    /* renamed from: a */
    private final synchronized zzvu m31297a(BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzvu(this.f29548d, zzk.zzlu().mo30298b(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m31304c() {
        synchronized (this.f29546b) {
            if (this.f29547c != null) {
                if (this.f29547c.isConnected() || this.f29547c.isConnecting()) {
                    this.f29547c.disconnect();
                }
                this.f29547c = null;
                this.f29549e = null;
                Binder.flushPendingCommands();
            }
        }
    }
}
