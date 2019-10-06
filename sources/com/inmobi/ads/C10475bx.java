package com.inmobi.ads;

import android.os.SystemClock;
import com.inmobi.ads.C10478c.C10481c;
import com.inmobi.ads.C10478c.C10489k;
import com.inmobi.commons.core.network.C10677d;
import com.inmobi.commons.core.network.C10679f;
import com.inmobi.commons.core.network.NetworkError;
import com.inmobi.commons.core.network.NetworkError.ErrorCode;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.p207a.C10299n;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.inmobi.ads.bx */
/* compiled from: VastResponse */
public final class C10475bx implements C10476by {

    /* renamed from: a */
    List<C10471bv> f31872a;

    /* renamed from: b */
    String f31873b;

    /* renamed from: c */
    String f31874c;

    /* renamed from: d */
    List<NativeTracker> f31875d;

    /* renamed from: e */
    List<C10468bt> f31876e;

    /* renamed from: f */
    int f31877f;

    /* renamed from: g */
    private String f31878g;

    /* renamed from: h */
    private C10468bt f31879h;

    /* renamed from: i */
    private C10489k f31880i;

    /* renamed from: j */
    private C10471bv f31881j;

    public C10475bx(C10489k kVar) {
        this.f31881j = null;
        this.f31872a = new ArrayList();
        this.f31875d = new ArrayList();
        this.f31876e = new ArrayList();
        this.f31880i = kVar;
        this.f31877f = 0;
    }

    private C10475bx(List<NativeTracker> list, C10489k kVar) {
        this(kVar);
        if (list.size() != 0) {
            this.f31875d = new ArrayList(list);
        }
    }

    public C10475bx(String str, String str2, String str3, List<NativeTracker> list, List<C10468bt> list2, C10489k kVar) {
        this(list, kVar);
        if (list2.size() != 0) {
            this.f31876e = new ArrayList(list2);
        }
        this.f31878g = str;
        this.f31872a.add(new C10471bv(str));
        this.f31873b = str2;
        this.f31874c = str3;
    }

    /* renamed from: a */
    public final String mo34195a() {
        return this.f31874c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String mo34198b() {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r0 = r1.f31878g
            if (r0 == 0) goto L_0x0007
            return r0
        L_0x0007:
            com.inmobi.ads.cache.C10517d.m34431a()
            java.util.List r0 = com.inmobi.ads.cache.C10517d.m34438d()
            boolean r2 = r0.isEmpty()
            r3 = 0
            if (r2 != 0) goto L_0x0033
            java.util.List<com.inmobi.ads.bv> r2 = r1.f31872a
            java.util.Iterator r2 = r2.iterator()
        L_0x001c:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0033
            java.lang.Object r4 = r2.next()
            com.inmobi.ads.bv r4 = (com.inmobi.ads.C10471bv) r4
            java.lang.String r5 = r4.f31854a
            boolean r5 = r0.contains(r5)
            if (r5 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            goto L_0x001c
        L_0x0033:
            r4 = r3
        L_0x0034:
            if (r4 == 0) goto L_0x0041
            r1.f31881j = r4
            java.lang.String r0 = r4.f31854a
            r1.f31878g = r0
            java.lang.String r0 = r1.f31878g
            return r0
        L_0x0041:
            java.util.List<com.inmobi.ads.bv> r0 = r1.f31872a
            java.util.Iterator r2 = r0.iterator()
            r5 = 4611686018427387904(0x4000000000000000, double:2.0)
            com.inmobi.ads.c$k r0 = r1.f31880i
            long r7 = r0.f31960b
            double r7 = (double) r7
            java.lang.Double.isNaN(r7)
            double r7 = r7 * r5
            r5 = 4697254411347427328(0x4130000000000000, double:1048576.0)
            double r7 = r7 / r5
            long r9 = r0.f31961c
            double r9 = (double) r9
            r15 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.Double.isNaN(r9)
            double r9 = r9 * r15
            double r5 = r9 / r5
        L_0x0064:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x00da
            java.lang.Object r0 = r2.next()
            r13 = r0
            com.inmobi.ads.bv r13 = (com.inmobi.ads.C10471bv) r13
            java.lang.String r0 = r1.f31873b
            java.lang.String r9 = ":"
            java.lang.String[] r0 = r0.split(r9)
            r9 = 1
            r9 = r0[r9]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x008b }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x008b }
            int r9 = r9 * 60
            r10 = 2
            r0 = r0[r10]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x008b }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x008b }
            int r9 = r9 + r0
            goto L_0x0099
        L_0x008b:
            r0 = move-exception
            r9 = 0
            com.inmobi.commons.core.a.a r10 = com.inmobi.commons.core.p218a.C10621a.m34854a()
            com.inmobi.commons.core.e.a r11 = new com.inmobi.commons.core.e.a
            r11.<init>(r0)
            r10.mo34423a(r11)
        L_0x0099:
            int r0 = r13.f31855b
            double r10 = (double) r0
            java.lang.Double.isNaN(r10)
            double r10 = r10 * r15
            double r14 = (double) r9
            java.lang.Double.isNaN(r14)
            double r10 = r10 * r14
            r14 = 4665729213955833856(0x40c0000000000000, double:8192.0)
            double r14 = r10 / r14
            r13.f31856c = r14
            r9 = 0
            r11 = r7
            r18 = r14
            r15 = r13
            r13 = r18
            boolean r0 = m34287a(r9, r11, r13)
            if (r0 == 0) goto L_0x00c6
            r13 = r18
            com.inmobi.ads.bv r4 = m34284a(r4, r15, r13)
            r15 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L_0x0064
        L_0x00c6:
            r13 = r18
            r9 = r7
            r11 = r5
            boolean r0 = m34287a(r9, r11, r13)
            if (r0 == 0) goto L_0x00d7
            r10 = r18
            com.inmobi.ads.bv r0 = m34288b(r3, r15, r10)
            r3 = r0
        L_0x00d7:
            r15 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L_0x0064
        L_0x00da:
            r1.m34285a(r4, r3)
            java.lang.String r0 = r1.f31878g
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x01df
            com.inmobi.ads.c$k r0 = r1.f31880i
            com.inmobi.ads.c$c r0 = r0.f31962d
            boolean r2 = r0.f31921a
            if (r2 != 0) goto L_0x01dc
            java.util.List<com.inmobi.ads.bv> r2 = r1.f31872a
            int r2 = r2.size()
            if (r2 != 0) goto L_0x00f9
            goto L_0x01dc
        L_0x00f9:
            java.util.concurrent.CountDownLatch r2 = new java.util.concurrent.CountDownLatch
            java.util.List<com.inmobi.ads.bv> r9 = r1.f31872a
            int r9 = r9.size()
            r2.<init>(r9)
            r1.m34286a(r0, r2)     // Catch:{ Exception -> 0x014d }
            int r0 = r0.f31922b     // Catch:{ Exception -> 0x014d }
            long r9 = (long) r0     // Catch:{ Exception -> 0x014d }
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x014d }
            r2.await(r9, r0)     // Catch:{ Exception -> 0x014d }
            java.util.List<com.inmobi.ads.bv> r0 = r1.f31872a
            java.util.Iterator r0 = r0.iterator()
        L_0x0116:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0146
            java.lang.Object r2 = r0.next()
            com.inmobi.ads.bv r2 = (com.inmobi.ads.C10471bv) r2
            double r13 = r2.f31856c
            r9 = 0
            r11 = r7
            r15 = r13
            boolean r9 = m34287a(r9, r11, r13)
            if (r9 == 0) goto L_0x0136
            r13 = r15
            com.inmobi.ads.bv r4 = m34284a(r4, r2, r13)
            goto L_0x0116
        L_0x0136:
            r13 = r15
            r9 = r7
            r11 = r5
            boolean r9 = m34287a(r9, r11, r13)
            if (r9 == 0) goto L_0x0145
            r9 = r15
            com.inmobi.ads.bv r2 = m34288b(r3, r2, r9)
            r3 = r2
        L_0x0145:
            goto L_0x0116
        L_0x0146:
            r1.m34285a(r4, r3)
            goto L_0x01df
        L_0x014b:
            r0 = move-exception
            goto L_0x019e
        L_0x014d:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x014b }
            java.lang.String r9 = "SDK encountered an unexpected error in getting vast header response; "
            r2.<init>(r9)     // Catch:{ all -> 0x014b }
            java.lang.String r9 = r0.getMessage()     // Catch:{ all -> 0x014b }
            r2.append(r9)     // Catch:{ all -> 0x014b }
            com.inmobi.commons.core.a.a r2 = com.inmobi.commons.core.p218a.C10621a.m34854a()     // Catch:{ all -> 0x014b }
            com.inmobi.commons.core.e.a r9 = new com.inmobi.commons.core.e.a     // Catch:{ all -> 0x014b }
            r9.<init>(r0)     // Catch:{ all -> 0x014b }
            r2.mo34423a(r9)     // Catch:{ all -> 0x014b }
            java.util.List<com.inmobi.ads.bv> r0 = r1.f31872a
            java.util.Iterator r0 = r0.iterator()
        L_0x016e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0146
            java.lang.Object r2 = r0.next()
            com.inmobi.ads.bv r2 = (com.inmobi.ads.C10471bv) r2
            double r13 = r2.f31856c
            r9 = 0
            r11 = r7
            r15 = r13
            boolean r9 = m34287a(r9, r11, r13)
            if (r9 == 0) goto L_0x018e
            r13 = r15
            com.inmobi.ads.bv r4 = m34284a(r4, r2, r13)
            goto L_0x016e
        L_0x018e:
            r13 = r15
            r9 = r7
            r11 = r5
            boolean r9 = m34287a(r9, r11, r13)
            if (r9 == 0) goto L_0x019d
            r9 = r15
            com.inmobi.ads.bv r2 = m34288b(r3, r2, r9)
            r3 = r2
        L_0x019d:
            goto L_0x016e
        L_0x019e:
            java.util.List<com.inmobi.ads.bv> r2 = r1.f31872a
            java.util.Iterator r2 = r2.iterator()
        L_0x01a4:
            boolean r9 = r2.hasNext()
            if (r9 == 0) goto L_0x01d8
            java.lang.Object r9 = r2.next()
            r15 = r9
            com.inmobi.ads.bv r15 = (com.inmobi.ads.C10471bv) r15
            double r13 = r15.f31856c
            r9 = 0
            r11 = r7
            r16 = r13
            boolean r9 = m34287a(r9, r11, r13)
            if (r9 == 0) goto L_0x01c7
            r13 = r16
            com.inmobi.ads.bv r4 = m34284a(r4, r15, r13)
            goto L_0x01a4
        L_0x01c7:
            r13 = r16
            r9 = r7
            r11 = r5
            boolean r9 = m34287a(r9, r11, r13)
            if (r9 == 0) goto L_0x01d7
            r9 = r16
            com.inmobi.ads.bv r3 = m34288b(r3, r15, r9)
        L_0x01d7:
            goto L_0x01a4
        L_0x01d8:
            r1.m34285a(r4, r3)
            throw r0
        L_0x01dc:
            java.lang.String r0 = r1.f31878g
            return r0
        L_0x01df:
            java.lang.String r0 = r1.f31878g
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10475bx.mo34198b():java.lang.String");
    }

    /* renamed from: a */
    private void m34286a(C10481c cVar, CountDownLatch countDownLatch) {
        for (C10471bv bwVar : this.f31872a) {
            C10472bw bwVar2 = new C10472bw(bwVar, cVar.f31922b, countDownLatch);
            bwVar2.f31868c = SystemClock.elapsedRealtime();
            C10472bw.f31859d.execute(new Runnable() {
                public final void run() {
                    C10472bw bwVar;
                    try {
                        C10677d a = new C10679f(C10472bw.this.f31866a).mo34500a();
                        if (a == null) {
                            return;
                        }
                        if (a.mo34510a()) {
                            C10472bw.this.mo34192a(a);
                            return;
                        }
                        bwVar = C10472bw.this;
                        try {
                            C10299n.m33566a().mo33663a(bwVar.f31866a.mo34509g());
                            C10299n.m33566a().mo33664b(a.mo34513c());
                            C10299n.m33566a().mo33665c(SystemClock.elapsedRealtime() - bwVar.f31868c);
                            if (bwVar.f31867b.get() != null) {
                                double d = (double) a.f32592c;
                                Double.isNaN(d);
                                ((C10471bv) bwVar.f31867b.get()).f31856c = (d * 1.0d) / 1048576.0d;
                            }
                            bwVar.mo34191a();
                        } catch (Exception e) {
                            new StringBuilder("Handling Vast Media Header Request success encountered an unexpected error: ").append(e.getMessage());
                            C10621a.m34854a().mo34423a(new C10658a(e));
                            bwVar.mo34191a();
                        }
                    } catch (Exception e2) {
                        C10472bw.f31860e;
                        new StringBuilder("Network request failed with unexpected error: ").append(e2.getMessage());
                        NetworkError networkError = new NetworkError(ErrorCode.UNKNOWN_ERROR, "Network request failed with unknown error");
                        C10677d dVar = new C10677d();
                        dVar.f32591b = networkError;
                        C10472bw.this.mo34192a(dVar);
                    } catch (Throwable th) {
                        bwVar.mo34191a();
                        throw th;
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private static boolean m34287a(double d, double d2, double d3) {
        return d3 > d && d3 <= d2;
    }

    /* renamed from: a */
    private static C10471bv m34284a(C10471bv bvVar, C10471bv bvVar2, double d) {
        return (bvVar != null && d <= bvVar.f31856c) ? bvVar : bvVar2;
    }

    /* renamed from: b */
    private static C10471bv m34288b(C10471bv bvVar, C10471bv bvVar2, double d) {
        return (bvVar != null && d >= bvVar.f31856c) ? bvVar : bvVar2;
    }

    /* renamed from: a */
    private void m34285a(C10471bv bvVar, C10471bv bvVar2) {
        if (bvVar != null) {
            this.f31881j = bvVar;
            this.f31878g = bvVar.f31854a;
            return;
        }
        if (bvVar2 != null) {
            this.f31881j = bvVar2;
            this.f31878g = bvVar2.f31854a;
        }
    }

    /* renamed from: c */
    public final List<C10471bv> mo34199c() {
        return this.f31872a;
    }

    /* renamed from: d */
    public final List<NativeTracker> mo34200d() {
        return this.f31875d;
    }

    /* renamed from: e */
    public final List<C10468bt> mo34201e() {
        return this.f31876e;
    }

    /* renamed from: a */
    public final void mo34197a(C10468bt btVar) {
        this.f31879h = btVar;
    }

    /* renamed from: f */
    public final C10468bt mo34202f() {
        return this.f31879h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34196a(NativeTracker nativeTracker) {
        this.f31875d.add(nativeTracker);
    }
}
