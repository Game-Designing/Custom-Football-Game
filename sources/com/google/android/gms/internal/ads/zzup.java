package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzard
public final class zzup {

    /* renamed from: a */
    private final Object f29484a = new Object();
    @VisibleForTesting

    /* renamed from: b */
    private int f29485b;

    /* renamed from: c */
    private List<zzuo> f29486c = new LinkedList();

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005e, code lost:
        return r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzuo mo32280a(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f29484a
            monitor-enter(r0)
            java.util.List<com.google.android.gms.internal.ads.zzuo> r1 = r7.f29486c     // Catch:{ all -> 0x005f }
            int r1 = r1.size()     // Catch:{ all -> 0x005f }
            r2 = 0
            if (r1 != 0) goto L_0x0013
            java.lang.String r8 = "Queue empty"
            com.google.android.gms.internal.ads.zzbad.m26352a(r8)     // Catch:{ all -> 0x005f }
            monitor-exit(r0)     // Catch:{ all -> 0x005f }
            return r2
        L_0x0013:
            java.util.List<com.google.android.gms.internal.ads.zzuo> r1 = r7.f29486c     // Catch:{ all -> 0x005f }
            int r1 = r1.size()     // Catch:{ all -> 0x005f }
            r3 = 2
            r4 = 0
            if (r1 < r3) goto L_0x004a
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            java.util.List<com.google.android.gms.internal.ads.zzuo> r1 = r7.f29486c     // Catch:{ all -> 0x005f }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x005f }
            r3 = 0
        L_0x0029:
            boolean r5 = r1.hasNext()     // Catch:{ all -> 0x005f }
            if (r5 == 0) goto L_0x0043
            java.lang.Object r5 = r1.next()     // Catch:{ all -> 0x005f }
            com.google.android.gms.internal.ads.zzuo r5 = (com.google.android.gms.internal.ads.zzuo) r5     // Catch:{ all -> 0x005f }
            int r6 = r5.mo32263a()     // Catch:{ all -> 0x005f }
            if (r6 <= r8) goto L_0x0040
            r4 = r3
            r2 = r5
            r8 = r6
        L_0x0040:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x0043:
            java.util.List<com.google.android.gms.internal.ads.zzuo> r8 = r7.f29486c     // Catch:{ all -> 0x005f }
            r8.remove(r4)     // Catch:{ all -> 0x005f }
            monitor-exit(r0)     // Catch:{ all -> 0x005f }
            return r2
        L_0x004a:
            java.util.List<com.google.android.gms.internal.ads.zzuo> r1 = r7.f29486c     // Catch:{ all -> 0x005f }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x005f }
            com.google.android.gms.internal.ads.zzuo r1 = (com.google.android.gms.internal.ads.zzuo) r1     // Catch:{ all -> 0x005f }
            if (r8 == 0) goto L_0x005a
            java.util.List<com.google.android.gms.internal.ads.zzuo> r8 = r7.f29486c     // Catch:{ all -> 0x005f }
            r8.remove(r4)     // Catch:{ all -> 0x005f }
            goto L_0x005d
        L_0x005a:
            r1.mo32272f()     // Catch:{ all -> 0x005f }
        L_0x005d:
            monitor-exit(r0)     // Catch:{ all -> 0x005f }
            return r1
        L_0x005f:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005f }
            goto L_0x0063
        L_0x0062:
            throw r8
        L_0x0063:
            goto L_0x0062
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzup.mo32280a(boolean):com.google.android.gms.internal.ads.zzuo");
    }

    /* renamed from: a */
    public final boolean mo32281a(zzuo zzuo) {
        synchronized (this.f29484a) {
            if (this.f29486c.contains(zzuo)) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: b */
    public final boolean mo32282b(zzuo zzuo) {
        synchronized (this.f29484a) {
            Iterator it = this.f29486c.iterator();
            while (it.hasNext()) {
                zzuo zzuo2 = (zzuo) it.next();
                if (!zzk.zzlk().mo30177i().mo30220i()) {
                    if (zzuo != zzuo2 && zzuo2.mo32268c().equals(zzuo.mo32268c())) {
                        it.remove();
                        return true;
                    }
                } else if (!zzk.zzlk().mo30177i().mo30219h() && zzuo != zzuo2 && zzuo2.mo32270e().equals(zzuo.mo32270e())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: c */
    public final void mo32283c(zzuo zzuo) {
        synchronized (this.f29484a) {
            if (this.f29486c.size() >= 10) {
                int size = this.f29486c.size();
                StringBuilder sb = new StringBuilder(41);
                sb.append("Queue is full, current size = ");
                sb.append(size);
                zzbad.m26352a(sb.toString());
                this.f29486c.remove(0);
            }
            int i = this.f29485b;
            this.f29485b = i + 1;
            zzuo.mo32264a(i);
            zzuo.mo32276i();
            this.f29486c.add(zzuo);
        }
    }
}
