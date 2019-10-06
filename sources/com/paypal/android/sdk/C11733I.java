package com.paypal.android.sdk;

import android.net.Uri;
import java.util.Map;

/* renamed from: com.paypal.android.sdk.I */
public class C11733I implements C11714D {

    /* renamed from: a */
    private static int f36696a = 60000;

    /* renamed from: b */
    private static int f36697b = 60000;

    /* renamed from: c */
    private final C11745M f36698c = new C11745M(C11723Fa.m38821b());

    /* renamed from: d */
    private byte[] f36699d;

    /* renamed from: e */
    private Uri f36700e;

    /* renamed from: f */
    private Map f36701f;

    static {
        C11733I.class.getSimpleName();
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b6  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int mo38555a(byte[] r9) {
        /*
            r8 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x00ab }
            android.net.Uri r2 = r8.f36700e     // Catch:{ all -> 0x00ab }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00ab }
            r1.<init>(r2)     // Catch:{ all -> 0x00ab }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ all -> 0x00ab }
            javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch:{ all -> 0x00ab }
            int r2 = f36697b     // Catch:{ all -> 0x00a8 }
            r1.setReadTimeout(r2)     // Catch:{ all -> 0x00a8 }
            int r2 = f36696a     // Catch:{ all -> 0x00a8 }
            r1.setConnectTimeout(r2)     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "POST"
            r1.setRequestMethod(r2)     // Catch:{ all -> 0x00a8 }
            r2 = 1
            r1.setDoInput(r2)     // Catch:{ all -> 0x00a8 }
            r1.setDoOutput(r2)     // Catch:{ all -> 0x00a8 }
            com.paypal.android.sdk.M r2 = r8.f36698c     // Catch:{ all -> 0x00a8 }
            r1.setSSLSocketFactory(r2)     // Catch:{ all -> 0x00a8 }
            java.util.Map r2 = r8.f36701f     // Catch:{ all -> 0x00a8 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x00a8 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00a8 }
        L_0x0037:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00a8 }
            if (r3 == 0) goto L_0x0057
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00a8 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x00a8 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ all -> 0x00a8 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00a8 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x00a8 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00a8 }
            r1.setRequestProperty(r4, r3)     // Catch:{ all -> 0x00a8 }
            goto L_0x0037
        L_0x0057:
            int r2 = r9.length     // Catch:{ all -> 0x00a8 }
            r1.setFixedLengthStreamingMode(r2)     // Catch:{ all -> 0x00a8 }
            java.io.OutputStream r2 = r1.getOutputStream()     // Catch:{ all -> 0x00a8 }
            r2.write(r9)     // Catch:{ all -> 0x00a6 }
            r2.flush()     // Catch:{ all -> 0x00a6 }
            int r9 = r1.getResponseCode()     // Catch:{ all -> 0x00a6 }
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 0
            if (r9 != r3) goto L_0x0096
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ all -> 0x00a6 }
            java.io.InputStream r5 = r1.getInputStream()     // Catch:{ all -> 0x00a6 }
            r3.<init>(r5)     // Catch:{ all -> 0x00a6 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0093 }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0093 }
            r5.<init>()     // Catch:{ all -> 0x0093 }
        L_0x0080:
            int r6 = r3.read(r0)     // Catch:{ all -> 0x0093 }
            r7 = -1
            if (r6 == r7) goto L_0x008b
            r5.write(r0, r4, r6)     // Catch:{ all -> 0x0093 }
            goto L_0x0080
        L_0x008b:
            byte[] r0 = r5.toByteArray()     // Catch:{ all -> 0x0093 }
            r8.f36699d = r0     // Catch:{ all -> 0x0093 }
            r0 = r3
            goto L_0x009a
        L_0x0093:
            r9 = move-exception
            r0 = r3
            goto L_0x00ae
        L_0x0096:
            byte[] r3 = new byte[r4]     // Catch:{ all -> 0x00a6 }
            r8.f36699d = r3     // Catch:{ all -> 0x00a6 }
        L_0x009a:
            com.paypal.android.sdk.C11723Fa.m38815a(r0)
            com.paypal.android.sdk.C11723Fa.m38815a(r2)
            if (r1 == 0) goto L_0x00a5
            r1.disconnect()
        L_0x00a5:
            return r9
        L_0x00a6:
            r9 = move-exception
            goto L_0x00ae
        L_0x00a8:
            r9 = move-exception
            r2 = r0
            goto L_0x00ae
        L_0x00ab:
            r9 = move-exception
            r1 = r0
            r2 = r1
        L_0x00ae:
            com.paypal.android.sdk.C11723Fa.m38815a(r0)
            com.paypal.android.sdk.C11723Fa.m38815a(r2)
            if (r1 == 0) goto L_0x00b9
            r1.disconnect()
        L_0x00b9:
            goto L_0x00bb
        L_0x00ba:
            throw r9
        L_0x00bb:
            goto L_0x00ba
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.C11733I.mo38555a(byte[]):int");
    }

    /* renamed from: a */
    public final void mo38556a(Uri uri) {
        this.f36700e = uri;
    }

    /* renamed from: a */
    public final void mo38557a(Map map) {
        this.f36701f = map;
    }

    /* renamed from: a */
    public final byte[] mo38558a() {
        return this.f36699d;
    }
}
