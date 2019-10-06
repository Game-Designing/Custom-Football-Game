package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.Fq */
final class C8861Fq implements C9244Xs {

    /* renamed from: a */
    private final Map<String, List<zzr<?>>> f20873a = new HashMap();

    /* renamed from: b */
    private final zzd f20874b;

    C8861Fq(zzd zzd) {
        this.f20874b = zzd;
    }

    /* renamed from: a */
    public final void mo28245a(zzr<?> zzr, zzy<?> zzy) {
        List<zzr> list;
        zzc zzc = zzy.f29745b;
        if (zzc == null || zzc.mo31083a()) {
            mo28244a(zzr);
            return;
        }
        String s = zzr.mo32134s();
        synchronized (this) {
            list = (List) this.f20873a.remove(s);
        }
        if (list != null) {
            if (zzag.f24300b) {
                zzag.m24969c("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), s);
            }
            for (zzr a : list) {
                this.f20874b.f27713e.mo29405a(a, zzy);
            }
        }
    }

    /* renamed from: a */
    public final synchronized void mo28244a(zzr<?> zzr) {
        String s = zzr.mo32134s();
        List list = (List) this.f20873a.remove(s);
        if (list != null && !list.isEmpty()) {
            if (zzag.f24300b) {
                zzag.m24969c("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), s);
            }
            zzr zzr2 = (zzr) list.remove(0);
            this.f20873a.put(s, list);
            zzr2.mo32123a((C9244Xs) this);
            try {
                this.f20874b.f27711c.put(zzr2);
            } catch (InterruptedException e) {
                zzag.m24968b("Couldn't add request to queue. %s", e.toString());
                Thread.currentThread().interrupt();
                this.f20874b.mo31335a();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        return false;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean m22543b(com.google.android.gms.internal.ads.zzr<?> r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = r6.mo32134s()     // Catch:{ all -> 0x0052 }
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzr<?>>> r1 = r5.f20873a     // Catch:{ all -> 0x0052 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x0052 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x003a
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzr<?>>> r1 = r5.f20873a     // Catch:{ all -> 0x0052 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0052 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0052 }
            if (r1 != 0) goto L_0x001e
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0052 }
            r1.<init>()     // Catch:{ all -> 0x0052 }
        L_0x001e:
            java.lang.String r4 = "waiting-for-response"
            r6.mo32126a(r4)     // Catch:{ all -> 0x0052 }
            r1.add(r6)     // Catch:{ all -> 0x0052 }
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzr<?>>> r6 = r5.f20873a     // Catch:{ all -> 0x0052 }
            r6.put(r0, r1)     // Catch:{ all -> 0x0052 }
            boolean r6 = com.google.android.gms.internal.ads.zzag.f24300b     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0038
            java.lang.String r6 = "Request for cacheKey=%s is in flight, putting on hold."
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
            r1[r3] = r0     // Catch:{ all -> 0x0052 }
            com.google.android.gms.internal.ads.zzag.m24966a(r6, r1)     // Catch:{ all -> 0x0052 }
        L_0x0038:
            monitor-exit(r5)
            return r2
        L_0x003a:
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzr<?>>> r1 = r5.f20873a     // Catch:{ all -> 0x0052 }
            r4 = 0
            r1.put(r0, r4)     // Catch:{ all -> 0x0052 }
            r6.mo32123a(r5)     // Catch:{ all -> 0x0052 }
            boolean r6 = com.google.android.gms.internal.ads.zzag.f24300b     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0050
            java.lang.String r6 = "new request, sending to network %s"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
            r1[r3] = r0     // Catch:{ all -> 0x0052 }
            com.google.android.gms.internal.ads.zzag.m24966a(r6, r1)     // Catch:{ all -> 0x0052 }
        L_0x0050:
            monitor-exit(r5)
            return r3
        L_0x0052:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C8861Fq.m22543b(com.google.android.gms.internal.ads.zzr):boolean");
    }
}
