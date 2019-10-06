package com.fyber.inneractive.sdk.p165f;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.fyber.inneractive.sdk.f.k */
public final class C7742k {

    /* renamed from: a */
    static ThreadPoolExecutor f15501a;

    /* renamed from: b */
    List<String> f15502b;

    /* renamed from: c */
    private boolean f15503c = false;

    public C7742k(boolean z) {
        this.f15503c = z;
    }

    /* renamed from: a */
    public final void mo24316a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        mo24318a((List<String>) arrayList);
    }

    /* renamed from: a */
    public final void mo24318a(List<String> list) {
        if (list != null && list.size() != 0) {
            m17166a();
            this.f15502b = list;
            try {
                f15501a.submit(new Runnable() {
                    public final void run() {
                        C7742k kVar = C7742k.this;
                        System.currentTimeMillis();
                        StringBuilder sb = new StringBuilder("Tracking request start GETting ");
                        sb.append(kVar.f15502b.size());
                        sb.append(" urls");
                        IAlog.m18021b(sb.toString());
                        for (String r2 : kVar.f15502b) {
                            try {
                                C7742k.f15501a.submit(new Runnable(r2) {

                                    /* renamed from: a */
                                    final /* synthetic */ String f15508a;

                                    {
                                        this.f15508a = r2;
                                    }

                                    public final void run() {
                                        C7742k.this.mo24317a(this.f15508a, null);
                                    }
                                });
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0095  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo24317a(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 0
            com.fyber.inneractive.sdk.f.b r3 = new com.fyber.inneractive.sdk.f.b     // Catch:{ Exception -> 0x0054 }
            boolean r4 = r5.f15503c     // Catch:{ Exception -> 0x0054 }
            r3.<init>(r6, r4)     // Catch:{ Exception -> 0x0054 }
            r3.f15439e = r7     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            r7 = 1000(0x3e8, float:1.401E-42)
            r3.f15437c = r7     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            r7 = 2500(0x9c4, float:3.503E-42)
            boolean r7 = r3.mo24296a(r7, r2)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            if (r7 == 0) goto L_0x0022
            r7 = 0
            r3.mo24297a(r7)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
        L_0x0022:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            java.lang.String r2 = "IAtrackingRequest: Hitting URL finished: "
            r7.<init>(r2)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            r7.append(r6)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            java.lang.String r6 = r7.toString()     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r6)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            java.lang.String r7 = "IAtrackingRequest: Hitting URL response code: "
            r6.<init>(r7)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            int r7 = r3.mo24300d()     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            r6.append(r7)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r6)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            r3.mo24301e()
            goto L_0x0077
        L_0x004c:
            r6 = move-exception
            goto L_0x0093
        L_0x004e:
            r6 = move-exception
            r2 = r3
            goto L_0x0055
        L_0x0051:
            r6 = move-exception
            r3 = r2
            goto L_0x0093
        L_0x0054:
            r6 = move-exception
        L_0x0055:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            java.lang.String r3 = "IAtrackingRequest: Hitting URL failed: "
            r7.<init>(r3)     // Catch:{ all -> 0x0051 }
            java.lang.String r3 = r6.getMessage()     // Catch:{ all -> 0x0051 }
            r7.append(r3)     // Catch:{ all -> 0x0051 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0051 }
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r7)     // Catch:{ all -> 0x0051 }
            int r7 = com.fyber.inneractive.sdk.util.IAlog.f16291a     // Catch:{ all -> 0x0051 }
            r3 = 3
            if (r7 > r3) goto L_0x0072
            r6.printStackTrace()     // Catch:{ all -> 0x0051 }
        L_0x0072:
            if (r2 == 0) goto L_0x0077
            r2.mo24301e()
        L_0x0077:
            long r6 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Url hit took "
            r2.<init>(r3)
            long r6 = r6 - r0
            r2.append(r6)
            java.lang.String r6 = " millis"
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r6)
            return
        L_0x0093:
            if (r3 == 0) goto L_0x0098
            r3.mo24301e()
        L_0x0098:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.p165f.C7742k.mo24317a(java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    static void m17166a() {
        if (f15501a == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue(100));
            f15501a = threadPoolExecutor;
        }
    }
}
