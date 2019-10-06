package com.fyber.inneractive.sdk.util;

import android.content.Context;
import com.fyber.inneractive.sdk.util.C8014m.C8015a;

/* renamed from: com.fyber.inneractive.sdk.util.p */
public final class C8019p<ResultData> extends C8014m<ResultData> {
    public C8019p(Context context, C8015a<ResultData> aVar) {
        super(context, aVar);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067 A[SYNTHETIC, Splitter:B:19:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009a A[SYNTHETIC, Splitter:B:27:0x009a] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String mo24851a(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Failed closing local file: "
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "reading local file: "
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r1)
            r1 = 0
            android.content.Context r2 = r6.f16349a     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            java.io.FileInputStream r2 = r2.openFileInput(r7)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            int r3 = r2.available()     // Catch:{ Exception -> 0x0049 }
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x0049 }
            r2.read(r3)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x0049 }
            java.lang.String r5 = "UTF-8"
            r4.<init>(r3, r5)     // Catch:{ Exception -> 0x0049 }
            if (r2 == 0) goto L_0x0047
            r2.close()     // Catch:{ Exception -> 0x0032 }
        L_0x0031:
            goto L_0x0047
        L_0x0032:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r0 = r1.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18023d(r0)
            goto L_0x0031
        L_0x0047:
            r1 = r4
            goto L_0x0080
        L_0x0049:
            r3 = move-exception
            goto L_0x0050
        L_0x004b:
            r7 = move-exception
            r2 = r1
            goto L_0x0098
        L_0x004e:
            r3 = move-exception
            r2 = r1
        L_0x0050:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0097 }
            java.lang.String r5 = "Failed reading local file: "
            r4.<init>(r5)     // Catch:{ all -> 0x0097 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0097 }
            r4.append(r3)     // Catch:{ all -> 0x0097 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0097 }
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r3)     // Catch:{ all -> 0x0097 }
            if (r2 == 0) goto L_0x0080
            r2.close()     // Catch:{ Exception -> 0x006b }
        L_0x006a:
            goto L_0x0080
        L_0x006b:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r0 = r2.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18023d(r0)
            goto L_0x006a
        L_0x0080:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "local file "
            r0.<init>(r2)
            r0.append(r7)
            java.lang.String r7 = " read succesfully"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r7)
            return r1
        L_0x0097:
            r7 = move-exception
        L_0x0098:
            if (r2 == 0) goto L_0x00b2
            r2.close()     // Catch:{ Exception -> 0x009e }
            goto L_0x00b2
        L_0x009e:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r0 = r1.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18023d(r0)
        L_0x00b2:
            goto L_0x00b4
        L_0x00b3:
            throw r7
        L_0x00b4:
            goto L_0x00b3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.util.C8019p.mo24851a(java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final String mo24850a() {
        return null;
    }
}
