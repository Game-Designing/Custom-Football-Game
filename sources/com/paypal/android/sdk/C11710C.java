package com.paypal.android.sdk;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.paypal.android.sdk.C */
public class C11710C extends C11736J {

    /* renamed from: a */
    private static final String f36599a = C11710C.class.getSimpleName();

    /* renamed from: b */
    private Handler f36600b;

    /* renamed from: c */
    private String f36601c;

    /* renamed from: d */
    private String f36602d;

    /* renamed from: e */
    private String f36603e;

    /* renamed from: f */
    private C11858p f36604f;

    public C11710C(String str, String str2, String str3, C11858p pVar, Handler handler) {
        this.f36600b = handler;
        this.f36601c = str;
        this.f36602d = str2;
        this.f36603e = str3;
        this.f36604f = pVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00a7, code lost:
        if (r11 != null) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00a9, code lost:
        r11.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00cb, code lost:
        if (r11 == null) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ce, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d5  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m38742a(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = ""
            r1 = 1
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r3.<init>(r11)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.net.URLConnection r11 = r3.openConnection()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r4 = 60000(0xea60, float:8.4078E-41)
            r11.setReadTimeout(r4)     // Catch:{ Exception -> 0x00b5 }
            r11.setConnectTimeout(r4)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r4 = "GET"
            r11.setRequestMethod(r4)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r4 = "User-Agent"
            java.lang.String r5 = "%s/%s/%s/%s/Android"
            r6 = 4
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x00b5 }
            r7 = 0
            com.paypal.android.sdk.p r8 = r10.f36604f     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r8 = r8.mo38832a()     // Catch:{ Exception -> 0x00b5 }
            r6[r7] = r8     // Catch:{ Exception -> 0x00b5 }
            com.paypal.android.sdk.p r7 = r10.f36604f     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r7 = r7.mo38834b()     // Catch:{ Exception -> 0x00b5 }
            r6[r1] = r7     // Catch:{ Exception -> 0x00b5 }
            r7 = 2
            java.lang.String r8 = r10.f36603e     // Catch:{ Exception -> 0x00b5 }
            r6[r7] = r8     // Catch:{ Exception -> 0x00b5 }
            r7 = 3
            java.lang.String r8 = r10.f36602d     // Catch:{ Exception -> 0x00b5 }
            r6[r7] = r8     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r5 = java.lang.String.format(r5, r6)     // Catch:{ Exception -> 0x00b5 }
            r11.setRequestProperty(r4, r5)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r4 = "Accept-Language"
            java.lang.String r5 = "en-us"
            r11.setRequestProperty(r4, r5)     // Catch:{ Exception -> 0x00b5 }
            int r4 = r11.getResponseCode()     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r5 = f36599a     // Catch:{ Exception -> 0x00b5 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r7 = "\nSending 'GET' request to URL : "
            r6.<init>(r7)     // Catch:{ Exception -> 0x00b5 }
            r6.append(r3)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r3 = r6.toString()     // Catch:{ Exception -> 0x00b5 }
            com.paypal.android.sdk.C11754P.m38931a(r5, r3)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r3 = f36599a     // Catch:{ Exception -> 0x00b5 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r6 = "Response Code : "
            r5.<init>(r6)     // Catch:{ Exception -> 0x00b5 }
            r5.append(r4)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x00b5 }
            com.paypal.android.sdk.C11754P.m38931a(r3, r4)     // Catch:{ Exception -> 0x00b5 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00b5 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00b5 }
            java.io.InputStream r5 = r11.getInputStream()     // Catch:{ Exception -> 0x00b5 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00b5 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00b5 }
        L_0x0085:
            java.lang.String r2 = r3.readLine()     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            if (r2 == 0) goto L_0x009b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            r4.<init>()     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            r4.append(r0)     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            r4.append(r2)     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            goto L_0x0085
        L_0x009b:
            java.lang.String r2 = f36599a     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            java.lang.String r4 = r0.toString()     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            com.paypal.android.sdk.C11754P.m38931a(r2, r4)     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            com.paypal.android.sdk.C11723Fa.m38815a(r3)
            if (r11 == 0) goto L_0x00ce
        L_0x00a9:
            r11.disconnect()
            goto L_0x00ce
        L_0x00ad:
            r0 = move-exception
            r2 = r3
            goto L_0x00d0
        L_0x00b0:
            r2 = move-exception
            r9 = r3
            r3 = r2
            r2 = r9
            goto L_0x00bd
        L_0x00b5:
            r3 = move-exception
            goto L_0x00bd
        L_0x00b7:
            r0 = move-exception
            r11 = r2
            goto L_0x00d0
        L_0x00ba:
            r11 = move-exception
            r3 = r11
            r11 = r2
        L_0x00bd:
            android.os.Handler r4 = r10.f36600b     // Catch:{ all -> 0x00cf }
            android.os.Handler r5 = r10.f36600b     // Catch:{ all -> 0x00cf }
            android.os.Message r1 = android.os.Message.obtain(r5, r1, r3)     // Catch:{ all -> 0x00cf }
            r4.sendMessage(r1)     // Catch:{ all -> 0x00cf }
            com.paypal.android.sdk.C11723Fa.m38815a(r2)
            if (r11 == 0) goto L_0x00ce
            goto L_0x00a9
        L_0x00ce:
            return r0
        L_0x00cf:
            r0 = move-exception
        L_0x00d0:
            com.paypal.android.sdk.C11723Fa.m38815a(r2)
            if (r11 == 0) goto L_0x00d8
            r11.disconnect()
        L_0x00d8:
            goto L_0x00da
        L_0x00d9:
            throw r0
        L_0x00da:
            goto L_0x00d9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.C11710C.m38742a(java.lang.String):java.lang.String");
    }

    public void run() {
        Handler handler = this.f36600b;
        if (handler != null) {
            try {
                handler.sendMessage(Message.obtain(handler, 20, this.f36601c));
                String a = m38742a(this.f36601c);
                C11754P.m38931a(f36599a, String.format("%s/%s/%s/%s/Android", new Object[]{this.f36604f.mo38832a(), this.f36604f.mo38834b(), this.f36603e, this.f36602d}));
                this.f36600b.sendMessage(Message.obtain(this.f36600b, 22, a.toString()));
            } catch (Exception e) {
                this.f36600b.sendMessage(Message.obtain(this.f36600b, 21, e));
            } catch (Throwable th) {
                C11739K.m38870a().mo38580b(this);
                throw th;
            }
            C11739K.m38870a().mo38580b(this);
        }
    }
}
