package com.google.android.gms.internal.ads;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLSocketFactory;

public final class zzat extends zzaj {

    /* renamed from: a */
    private final zzav f24807a;

    /* renamed from: b */
    private final SSLSocketFactory f24808b;

    public zzat() {
        this(null);
    }

    private zzat(zzav zzav) {
        this(null, null);
    }

    private zzat(zzav zzav, SSLSocketFactory sSLSocketFactory) {
        this.f24807a = null;
        this.f24808b = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0137  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzar mo28471b(com.google.android.gms.internal.ads.zzr<?> r7, java.util.Map<java.lang.String, java.lang.String> r8) throws java.io.IOException, com.google.android.gms.internal.ads.zza {
        /*
            r6 = this;
            java.lang.String r0 = r7.mo32131g()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r1.putAll(r8)
            java.util.Map r8 = r7.mo29244e()
            r1.putAll(r8)
            com.google.android.gms.internal.ads.zzav r8 = r6.f24807a
            if (r8 == 0) goto L_0x003b
            java.lang.String r8 = r8.mo30117a(r0)
            if (r8 != 0) goto L_0x003a
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r8 = "URL blocked by rewriter: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.length()
            if (r1 == 0) goto L_0x0030
            java.lang.String r8 = r8.concat(r0)
            goto L_0x0036
        L_0x0030:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r8)
            r8 = r0
        L_0x0036:
            r7.<init>(r8)
            throw r7
        L_0x003a:
            goto L_0x003c
        L_0x003b:
            r8 = r0
        L_0x003c:
            java.net.URL r0 = new java.net.URL
            r0.<init>(r8)
            java.net.URLConnection r8 = r0.openConnection()
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8
            boolean r2 = java.net.HttpURLConnection.getFollowRedirects()
            r8.setInstanceFollowRedirects(r2)
            int r2 = r7.mo32138w()
            r8.setConnectTimeout(r2)
            r8.setReadTimeout(r2)
            r2 = 0
            r8.setUseCaches(r2)
            r3 = 1
            r8.setDoInput(r3)
            java.lang.String r0 = r0.getProtocol()
            java.lang.String r4 = "https"
            r4.equals(r0)
            java.util.Set r0 = r1.keySet()     // Catch:{ all -> 0x0134 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0134 }
        L_0x0078:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x0134 }
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x0134 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0134 }
            java.lang.Object r5 = r1.get(r4)     // Catch:{ all -> 0x0134 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0134 }
            r8.setRequestProperty(r4, r5)     // Catch:{ all -> 0x0134 }
            goto L_0x0078
        L_0x008e:
            int r0 = r7.mo32130f()     // Catch:{ all -> 0x0134 }
            switch(r0) {
                case -1: goto L_0x00d3;
                case 0: goto L_0x00cd;
                case 1: goto L_0x00c4;
                case 2: goto L_0x00bb;
                case 3: goto L_0x00b5;
                case 4: goto L_0x00af;
                case 5: goto L_0x00a9;
                case 6: goto L_0x00a3;
                case 7: goto L_0x009a;
                default: goto L_0x0096;
            }     // Catch:{ all -> 0x0134 }
        L_0x0096:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0134 }
            goto L_0x012e
        L_0x009a:
            java.lang.String r0 = "PATCH"
            r8.setRequestMethod(r0)     // Catch:{ all -> 0x0134 }
            m25771a(r8, r7)     // Catch:{ all -> 0x0134 }
            goto L_0x00d7
        L_0x00a3:
            java.lang.String r0 = "TRACE"
            r8.setRequestMethod(r0)     // Catch:{ all -> 0x0134 }
            goto L_0x00d7
        L_0x00a9:
            java.lang.String r0 = "OPTIONS"
            r8.setRequestMethod(r0)     // Catch:{ all -> 0x0134 }
            goto L_0x00d7
        L_0x00af:
            java.lang.String r0 = "HEAD"
            r8.setRequestMethod(r0)     // Catch:{ all -> 0x0134 }
            goto L_0x00d7
        L_0x00b5:
            java.lang.String r0 = "DELETE"
            r8.setRequestMethod(r0)     // Catch:{ all -> 0x0134 }
            goto L_0x00d7
        L_0x00bb:
            java.lang.String r0 = "PUT"
            r8.setRequestMethod(r0)     // Catch:{ all -> 0x0134 }
            m25771a(r8, r7)     // Catch:{ all -> 0x0134 }
            goto L_0x00d7
        L_0x00c4:
            java.lang.String r0 = "POST"
            r8.setRequestMethod(r0)     // Catch:{ all -> 0x0134 }
            m25771a(r8, r7)     // Catch:{ all -> 0x0134 }
            goto L_0x00d7
        L_0x00cd:
            java.lang.String r0 = "GET"
            r8.setRequestMethod(r0)     // Catch:{ all -> 0x0134 }
            goto L_0x00d7
        L_0x00d3:
        L_0x00d7:
            int r0 = r8.getResponseCode()     // Catch:{ all -> 0x0134 }
            r1 = -1
            if (r0 == r1) goto L_0x0126
            int r7 = r7.mo32130f()     // Catch:{ all -> 0x0134 }
            r1 = 4
            if (r7 == r1) goto L_0x00f7
            r7 = 100
            if (r7 > r0) goto L_0x00ed
            r7 = 200(0xc8, float:2.8E-43)
            if (r0 < r7) goto L_0x00f7
        L_0x00ed:
            r7 = 204(0xcc, float:2.86E-43)
            if (r0 == r7) goto L_0x00f7
            r7 = 304(0x130, float:4.26E-43)
            if (r0 == r7) goto L_0x00f7
            r7 = 1
            goto L_0x00f8
        L_0x00f7:
            r7 = 0
        L_0x00f8:
            if (r7 != 0) goto L_0x010b
            com.google.android.gms.internal.ads.zzar r7 = new com.google.android.gms.internal.ads.zzar     // Catch:{ all -> 0x0134 }
            java.util.Map r1 = r8.getHeaderFields()     // Catch:{ all -> 0x0134 }
            java.util.List r1 = m25770a(r1)     // Catch:{ all -> 0x0134 }
            r7.<init>(r0, r1)     // Catch:{ all -> 0x0134 }
            r8.disconnect()
            return r7
        L_0x010b:
            com.google.android.gms.internal.ads.zzar r7 = new com.google.android.gms.internal.ads.zzar     // Catch:{ all -> 0x0123 }
            java.util.Map r1 = r8.getHeaderFields()     // Catch:{ all -> 0x0123 }
            java.util.List r1 = m25770a(r1)     // Catch:{ all -> 0x0123 }
            int r2 = r8.getContentLength()     // Catch:{ all -> 0x0123 }
            com.google.android.gms.internal.ads.vb r4 = new com.google.android.gms.internal.ads.vb     // Catch:{ all -> 0x0123 }
            r4.<init>(r8)     // Catch:{ all -> 0x0123 }
            r7.<init>(r0, r1, r2, r4)     // Catch:{ all -> 0x0123 }
            return r7
        L_0x0123:
            r7 = move-exception
            r2 = 1
            goto L_0x0135
        L_0x0126:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x0134 }
            java.lang.String r0 = "Could not retrieve response code from HttpUrlConnection."
            r7.<init>(r0)     // Catch:{ all -> 0x0134 }
            throw r7     // Catch:{ all -> 0x0134 }
        L_0x012e:
            java.lang.String r0 = "Unknown method type."
            r7.<init>(r0)     // Catch:{ all -> 0x0134 }
            throw r7     // Catch:{ all -> 0x0134 }
        L_0x0134:
            r7 = move-exception
        L_0x0135:
            if (r2 != 0) goto L_0x013a
            r8.disconnect()
        L_0x013a:
            goto L_0x013c
        L_0x013b:
            throw r7
        L_0x013c:
            goto L_0x013b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzat.mo28471b(com.google.android.gms.internal.ads.zzr, java.util.Map):com.google.android.gms.internal.ads.zzar");
    }

    /* renamed from: a */
    private static List<zzl> m25770a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String zzl : (List) entry.getValue()) {
                    arrayList.add(new zzl((String) entry.getKey(), zzl));
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static InputStream m25772b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException e) {
            return httpURLConnection.getErrorStream();
        }
    }

    /* renamed from: a */
    private static void m25771a(HttpURLConnection httpURLConnection, zzr<?> zzr) throws IOException, zza {
        byte[] u = zzr.mo29245u();
        if (u != null) {
            httpURLConnection.setDoOutput(true);
            String str = "Content-Type";
            if (!httpURLConnection.getRequestProperties().containsKey(str)) {
                String str2 = "application/x-www-form-urlencoded; charset=";
                String valueOf = String.valueOf("UTF-8");
                httpURLConnection.setRequestProperty(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(u);
            dataOutputStream.close();
        }
    }
}
