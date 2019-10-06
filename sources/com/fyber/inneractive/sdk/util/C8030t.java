package com.fyber.inneractive.sdk.util;

import android.content.Context;
import com.fyber.inneractive.sdk.util.C8014m.C8015a;

/* renamed from: com.fyber.inneractive.sdk.util.t */
public final class C8030t<ResultData> extends C8014m<ResultData> {

    /* renamed from: c */
    private int f16370c = 3;

    /* renamed from: d */
    private String f16371d = null;

    public C8030t(Context context, C8015a<ResultData> aVar, String str) {
        super(context, aVar);
        this.f16371d = str;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0098, code lost:
        if (r2 != null) goto L_0x006e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a3  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String mo24851a(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            com.fyber.inneractive.sdk.f.b r2 = new com.fyber.inneractive.sdk.f.b     // Catch:{ Exception -> 0x0077, all -> 0x0074 }
            java.lang.String r3 = r6.f16371d     // Catch:{ Exception -> 0x0077, all -> 0x0074 }
            r2.<init>(r7, r3)     // Catch:{ Exception -> 0x0077, all -> 0x0074 }
            int r3 = r6.f16370c     // Catch:{ Exception -> 0x0072 }
            int r3 = r3 * 1000
            r2.f15437c = r3     // Catch:{ Exception -> 0x0072 }
            int r3 = r6.f16370c     // Catch:{ Exception -> 0x0072 }
            int r3 = r3 * 1000
            boolean r3 = r2.mo24296a(r3, r1)     // Catch:{ Exception -> 0x0072 }
            if (r3 == 0) goto L_0x006e
            r3 = 1
            boolean r3 = r2.mo24297a(r3)     // Catch:{ Exception -> 0x0072 }
            if (r3 == 0) goto L_0x006e
            int r3 = r2.mo24300d()     // Catch:{ Exception -> 0x0072 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L_0x0051
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0072 }
            java.lang.String r3 = "successfully got remote file: "
            r1.<init>(r3)     // Catch:{ Exception -> 0x0072 }
            r1.append(r7)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0072 }
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r1)     // Catch:{ Exception -> 0x0072 }
            java.lang.StringBuffer r1 = r2.f15438d     // Catch:{ Exception -> 0x0072 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0072 }
            java.lang.String r3 = "Last-Modified"
            java.lang.String r3 = r2.mo24295a(r3)     // Catch:{ Exception -> 0x0072 }
            r6.f16371d = r3     // Catch:{ Exception -> 0x0072 }
            r2.mo24301e()
            return r1
        L_0x0051:
            int r3 = r2.mo24300d()     // Catch:{ Exception -> 0x0072 }
            r4 = 304(0x130, float:4.26E-43)
            if (r3 != r4) goto L_0x006e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0072 }
            java.lang.String r4 = "Remote file not modified "
            r3.<init>(r4)     // Catch:{ Exception -> 0x0072 }
            r3.append(r7)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0072 }
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r3)     // Catch:{ Exception -> 0x0072 }
            r2.mo24301e()
            return r1
        L_0x006e:
            r2.mo24301e()
            goto L_0x009b
        L_0x0072:
            r1 = move-exception
            goto L_0x007b
        L_0x0074:
            r7 = move-exception
            r2 = r1
            goto L_0x00a1
        L_0x0077:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L_0x007b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a0 }
            java.lang.String r4 = "Failed getting remote file "
            r3.<init>(r4)     // Catch:{ all -> 0x00a0 }
            r3.append(r7)     // Catch:{ all -> 0x00a0 }
            java.lang.String r7 = ": "
            r3.append(r7)     // Catch:{ all -> 0x00a0 }
            java.lang.String r7 = r1.getMessage()     // Catch:{ all -> 0x00a0 }
            r3.append(r7)     // Catch:{ all -> 0x00a0 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x00a0 }
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r7)     // Catch:{ all -> 0x00a0 }
            if (r2 == 0) goto L_0x009b
            goto L_0x006e
        L_0x009b:
            java.lang.String r7 = r0.toString()
            return r7
        L_0x00a0:
            r7 = move-exception
        L_0x00a1:
            if (r2 == 0) goto L_0x00a6
            r2.mo24301e()
        L_0x00a6:
            goto L_0x00a8
        L_0x00a7:
            throw r7
        L_0x00a8:
            goto L_0x00a7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.util.C8030t.mo24851a(java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final String mo24850a() {
        return this.f16371d;
    }
}
