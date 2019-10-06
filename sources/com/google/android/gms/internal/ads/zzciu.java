package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzciu implements zzczc<zzciv, zzciw> {

    /* renamed from: a */
    private final Context f26673a;

    /* renamed from: b */
    private final String f26674b;

    /* renamed from: c */
    private final zzasm f26675c;

    /* renamed from: d */
    private final String f26676d;

    public zzciu(Context context, String str, zzasm zzasm, String str2) {
        this.f26673a = context;
        this.f26674b = str;
        this.f26675c = zzasm;
        this.f26676d = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r2 = new java.io.InputStreamReader(r6.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        com.google.android.gms.ads.internal.zzk.zzlg();
        r0 = com.google.android.gms.internal.ads.zzaxi.m26106a(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        com.google.android.gms.common.util.IOUtils.m22102a(r2);
        r10.mo30316a(r0);
        r5.f26679a = r12;
        r5.f26681c = r0;
        r5.f26680b = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x018b, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x01a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x019d, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzyt.m31536e().mo29599a(com.google.android.gms.internal.ads.zzacu.f24141ne)).booleanValue() == false) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01a8, code lost:
        throw new com.google.android.gms.internal.ads.zzcif("No Fill", 3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01a9, code lost:
        r5.f26682d = com.google.android.gms.ads.internal.zzk.zzln().mo27934a() - r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r6.disconnect();
        r1.f26675c.mo30048a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01bd, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01be, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01bf, code lost:
        r16 = r2;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzciw m28464a(java.lang.String r21, com.google.android.gms.internal.ads.zzasd r22, org.json.JSONObject r23, java.lang.String r24) throws com.google.android.gms.internal.ads.zzcif {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r0 = "Received error HTTP response code: "
            java.lang.String r2 = "doritos_v2"
            java.lang.String r3 = "doritos"
            java.lang.String r4 = ""
            com.google.android.gms.internal.ads.zzciw r5 = new com.google.android.gms.internal.ads.zzciw     // Catch:{ IOException -> 0x0254 }
            r5.<init>()     // Catch:{ IOException -> 0x0254 }
            java.lang.String r6 = "SDK version: "
            java.lang.String r7 = r1.f26674b     // Catch:{ IOException -> 0x0254 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ IOException -> 0x0254 }
            int r8 = r7.length()     // Catch:{ IOException -> 0x0254 }
            if (r8 == 0) goto L_0x0022
            java.lang.String r6 = r6.concat(r7)     // Catch:{ IOException -> 0x0254 }
            goto L_0x0028
        L_0x0022:
            java.lang.String r7 = new java.lang.String     // Catch:{ IOException -> 0x0254 }
            r7.<init>(r6)     // Catch:{ IOException -> 0x0254 }
            r6 = r7
        L_0x0028:
            com.google.android.gms.internal.ads.zzbad.m26357c(r6)     // Catch:{ IOException -> 0x0254 }
            java.lang.String r6 = "AdRequestServiceImpl: Sending request: "
            java.lang.String r7 = java.lang.String.valueOf(r21)     // Catch:{ IOException -> 0x0254 }
            int r8 = r7.length()     // Catch:{ IOException -> 0x0254 }
            if (r8 == 0) goto L_0x003c
            java.lang.String r6 = r6.concat(r7)     // Catch:{ IOException -> 0x0254 }
            goto L_0x0042
        L_0x003c:
            java.lang.String r7 = new java.lang.String     // Catch:{ IOException -> 0x0254 }
            r7.<init>(r6)     // Catch:{ IOException -> 0x0254 }
            r6 = r7
        L_0x0042:
            com.google.android.gms.internal.ads.zzbad.m26352a(r6)     // Catch:{ IOException -> 0x0254 }
            java.net.URL r6 = new java.net.URL     // Catch:{ IOException -> 0x0254 }
            r7 = r21
            r6.<init>(r7)     // Catch:{ IOException -> 0x0254 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ IOException -> 0x0254 }
            r7.<init>()     // Catch:{ IOException -> 0x0254 }
            com.google.android.gms.common.util.Clock r8 = com.google.android.gms.ads.internal.zzk.zzln()     // Catch:{ IOException -> 0x0254 }
            long r8 = r8.mo27934a()     // Catch:{ IOException -> 0x0254 }
            r10 = 0
            r11 = 0
        L_0x005c:
            com.google.android.gms.internal.ads.zzasm r12 = r1.f26675c     // Catch:{ IOException -> 0x0254 }
            r12.mo30049b()     // Catch:{ IOException -> 0x0254 }
            java.net.URLConnection r6 = r6.openConnection()     // Catch:{ IOException -> 0x0254 }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ IOException -> 0x0254 }
            com.google.android.gms.internal.ads.zzaxi r12 = com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x024a }
            android.content.Context r13 = r1.f26673a     // Catch:{ all -> 0x024a }
            java.lang.String r14 = r1.f26674b     // Catch:{ all -> 0x024a }
            r12.mo30233a(r13, r14, r10, r6)     // Catch:{ all -> 0x024a }
            boolean r12 = android.text.TextUtils.isEmpty(r24)     // Catch:{ all -> 0x024a }
            if (r12 != 0) goto L_0x0080
            java.lang.String r12 = "Cookie"
            r13 = r24
            r6.addRequestProperty(r12, r13)     // Catch:{ all -> 0x024a }
            goto L_0x0082
        L_0x0080:
            r13 = r24
        L_0x0082:
            boolean r12 = r22.mo30042d()     // Catch:{ all -> 0x024a }
            if (r12 == 0) goto L_0x00bf
            java.lang.String r12 = "pii"
            r14 = r23
            org.json.JSONObject r12 = r14.optJSONObject(r12)     // Catch:{ all -> 0x024a }
            if (r12 == 0) goto L_0x00b9
            java.lang.String r15 = r12.optString(r3, r4)     // Catch:{ all -> 0x024a }
            boolean r15 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x024a }
            if (r15 != 0) goto L_0x00a5
            java.lang.String r15 = "x-afma-drt-cookie"
            java.lang.String r10 = r12.optString(r3, r4)     // Catch:{ all -> 0x024a }
            r6.addRequestProperty(r15, r10)     // Catch:{ all -> 0x024a }
        L_0x00a5:
            java.lang.String r10 = r12.optString(r2, r4)     // Catch:{ all -> 0x024a }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x024a }
            if (r10 != 0) goto L_0x00c1
            java.lang.String r10 = "x-afma-drt-v2-cookie"
            java.lang.String r12 = r12.optString(r2, r4)     // Catch:{ all -> 0x024a }
            r6.addRequestProperty(r10, r12)     // Catch:{ all -> 0x024a }
            goto L_0x00c1
        L_0x00b9:
            java.lang.String r10 = "DSID signal does not exist."
            com.google.android.gms.internal.ads.zzawz.m26003f(r10)     // Catch:{ all -> 0x024a }
            goto L_0x00c1
        L_0x00bf:
            r14 = r23
        L_0x00c1:
            r10 = 1
            if (r22 == 0) goto L_0x00fa
            java.lang.String r15 = r22.mo30041c()     // Catch:{ all -> 0x024a }
            boolean r15 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x024a }
            if (r15 != 0) goto L_0x00fa
            r6.setDoOutput(r10)     // Catch:{ all -> 0x024a }
            java.lang.String r15 = r22.mo30041c()     // Catch:{ all -> 0x024a }
            byte[] r15 = r15.getBytes()     // Catch:{ all -> 0x024a }
            int r12 = r15.length     // Catch:{ all -> 0x024a }
            r6.setFixedLengthStreamingMode(r12)     // Catch:{ all -> 0x024a }
            java.io.BufferedOutputStream r12 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00f3 }
            java.io.OutputStream r10 = r6.getOutputStream()     // Catch:{ all -> 0x00f3 }
            r12.<init>(r10)     // Catch:{ all -> 0x00f3 }
            r12.write(r15)     // Catch:{ all -> 0x00ef }
            com.google.android.gms.common.util.IOUtils.m22102a(r12)     // Catch:{ all -> 0x024a }
            goto L_0x00fb
        L_0x00ef:
            r0 = move-exception
            r16 = r12
            goto L_0x00f6
        L_0x00f3:
            r0 = move-exception
            r16 = 0
        L_0x00f6:
            com.google.android.gms.common.util.IOUtils.m22102a(r16)     // Catch:{ all -> 0x024a }
            throw r0     // Catch:{ all -> 0x024a }
        L_0x00fa:
            r15 = 0
        L_0x00fb:
            com.google.android.gms.internal.ads.zzazx r10 = new com.google.android.gms.internal.ads.zzazx     // Catch:{ all -> 0x024a }
            r10.<init>()     // Catch:{ all -> 0x024a }
            r10.mo30319a(r6, r15)     // Catch:{ all -> 0x024a }
            int r12 = r6.getResponseCode()     // Catch:{ all -> 0x024a }
            java.util.Map r15 = r6.getHeaderFields()     // Catch:{ all -> 0x024a }
            java.util.Set r15 = r15.entrySet()     // Catch:{ all -> 0x024a }
            java.util.Iterator r15 = r15.iterator()     // Catch:{ all -> 0x024a }
        L_0x0113:
            boolean r17 = r15.hasNext()     // Catch:{ all -> 0x024a }
            if (r17 == 0) goto L_0x0158
            java.lang.Object r17 = r15.next()     // Catch:{ all -> 0x024a }
            java.util.Map$Entry r17 = (java.util.Map.Entry) r17     // Catch:{ all -> 0x024a }
            java.lang.Object r18 = r17.getKey()     // Catch:{ all -> 0x024a }
            r19 = r2
            r2 = r18
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x024a }
            java.lang.Object r17 = r17.getValue()     // Catch:{ all -> 0x024a }
            r18 = r3
            r3 = r17
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x024a }
            boolean r17 = r7.containsKey(r2)     // Catch:{ all -> 0x024a }
            if (r17 == 0) goto L_0x0147
            java.lang.Object r2 = r7.get(r2)     // Catch:{ all -> 0x024a }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x024a }
            r2.addAll(r3)     // Catch:{ all -> 0x024a }
            r3 = r18
            r2 = r19
            goto L_0x0113
        L_0x0147:
            r17 = r4
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x024a }
            r4.<init>(r3)     // Catch:{ all -> 0x024a }
            r7.put(r2, r4)     // Catch:{ all -> 0x024a }
            r4 = r17
            r3 = r18
            r2 = r19
            goto L_0x0113
        L_0x0158:
            r19 = r2
            r18 = r3
            r17 = r4
            r10.mo30318a(r6, r12)     // Catch:{ all -> 0x024a }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 300(0x12c, float:4.2E-43)
            if (r12 < r2) goto L_0x01c9
            if (r12 >= r3) goto L_0x01c9
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x01c2 }
            java.io.InputStream r0 = r6.getInputStream()     // Catch:{ all -> 0x01c2 }
            r2.<init>(r0)     // Catch:{ all -> 0x01c2 }
            com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x01be }
            java.lang.String r0 = com.google.android.gms.internal.ads.zzaxi.m26106a(r2)     // Catch:{ all -> 0x01be }
            com.google.android.gms.common.util.IOUtils.m22102a(r2)     // Catch:{ all -> 0x024a }
            r10.mo30316a(r0)     // Catch:{ all -> 0x024a }
            r5.f26679a = r12     // Catch:{ all -> 0x024a }
            r5.f26681c = r0     // Catch:{ all -> 0x024a }
            r5.f26680b = r7     // Catch:{ all -> 0x024a }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x024a }
            if (r0 == 0) goto L_0x01a9
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzacu.f24141ne     // Catch:{ all -> 0x024a }
            com.google.android.gms.internal.ads.zzacr r2 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ all -> 0x024a }
            java.lang.Object r0 = r2.mo29599a(r0)     // Catch:{ all -> 0x024a }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x024a }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x024a }
            if (r0 == 0) goto L_0x01a0
            goto L_0x01a9
        L_0x01a0:
            com.google.android.gms.internal.ads.zzcif r0 = new com.google.android.gms.internal.ads.zzcif     // Catch:{ all -> 0x024a }
            java.lang.String r2 = "No Fill"
            r3 = 3
            r0.<init>(r2, r3)     // Catch:{ all -> 0x024a }
            throw r0     // Catch:{ all -> 0x024a }
        L_0x01a9:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzk.zzln()     // Catch:{ all -> 0x024a }
            long r2 = r0.mo27934a()     // Catch:{ all -> 0x024a }
            long r2 = r2 - r8
            r5.f26682d = r2     // Catch:{ all -> 0x024a }
            r6.disconnect()     // Catch:{ IOException -> 0x0254 }
            com.google.android.gms.internal.ads.zzasm r0 = r1.f26675c     // Catch:{ IOException -> 0x0254 }
            r0.mo30048a()     // Catch:{ IOException -> 0x0254 }
            return r5
        L_0x01be:
            r0 = move-exception
            r16 = r2
            goto L_0x01c5
        L_0x01c2:
            r0 = move-exception
            r16 = 0
        L_0x01c5:
            com.google.android.gms.common.util.IOUtils.m22102a(r16)     // Catch:{ all -> 0x024a }
            throw r0     // Catch:{ all -> 0x024a }
        L_0x01c9:
            if (r12 < r3) goto L_0x0221
            r2 = 400(0x190, float:5.6E-43)
            if (r12 >= r2) goto L_0x0221
            java.lang.String r2 = "Location"
            java.lang.String r2 = r6.getHeaderField(r2)     // Catch:{ all -> 0x024a }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x024a }
            if (r3 != 0) goto L_0x0214
            java.net.URL r3 = new java.net.URL     // Catch:{ all -> 0x024a }
            r3.<init>(r2)     // Catch:{ all -> 0x024a }
            r2 = 1
            int r11 = r11 + r2
            com.google.android.gms.internal.ads.zzacj<java.lang.Integer> r2 = com.google.android.gms.internal.ads.zzacu.f24038Xd     // Catch:{ all -> 0x024a }
            com.google.android.gms.internal.ads.zzacr r4 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ all -> 0x024a }
            java.lang.Object r2 = r4.mo29599a(r2)     // Catch:{ all -> 0x024a }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x024a }
            int r2 = r2.intValue()     // Catch:{ all -> 0x024a }
            if (r11 > r2) goto L_0x0207
            r6.disconnect()     // Catch:{ IOException -> 0x0254 }
            com.google.android.gms.internal.ads.zzasm r2 = r1.f26675c     // Catch:{ IOException -> 0x0254 }
            r2.mo30048a()     // Catch:{ IOException -> 0x0254 }
            r6 = r3
            r4 = r17
            r3 = r18
            r2 = r19
            r10 = 0
            goto L_0x005c
        L_0x0207:
            java.lang.String r0 = "Too many redirects."
            com.google.android.gms.internal.ads.zzbad.m26359d(r0)     // Catch:{ all -> 0x024a }
            com.google.android.gms.internal.ads.zzcif r0 = new com.google.android.gms.internal.ads.zzcif     // Catch:{ all -> 0x024a }
            java.lang.String r2 = "Too many redirects"
            r0.<init>(r2)     // Catch:{ all -> 0x024a }
            throw r0     // Catch:{ all -> 0x024a }
        L_0x0214:
            java.lang.String r0 = "No location header to follow redirect."
            com.google.android.gms.internal.ads.zzbad.m26359d(r0)     // Catch:{ all -> 0x024a }
            com.google.android.gms.internal.ads.zzcif r0 = new com.google.android.gms.internal.ads.zzcif     // Catch:{ all -> 0x024a }
            java.lang.String r2 = "No location header to follow redirect"
            r0.<init>(r2)     // Catch:{ all -> 0x024a }
            throw r0     // Catch:{ all -> 0x024a }
        L_0x0221:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x024a }
            r3 = 46
            r2.<init>(r3)     // Catch:{ all -> 0x024a }
            r2.append(r0)     // Catch:{ all -> 0x024a }
            r2.append(r12)     // Catch:{ all -> 0x024a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x024a }
            com.google.android.gms.internal.ads.zzbad.m26359d(r2)     // Catch:{ all -> 0x024a }
            com.google.android.gms.internal.ads.zzcif r2 = new com.google.android.gms.internal.ads.zzcif     // Catch:{ all -> 0x024a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x024a }
            r4.<init>(r3)     // Catch:{ all -> 0x024a }
            r4.append(r0)     // Catch:{ all -> 0x024a }
            r4.append(r12)     // Catch:{ all -> 0x024a }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x024a }
            r2.<init>(r0)     // Catch:{ all -> 0x024a }
            throw r2     // Catch:{ all -> 0x024a }
        L_0x024a:
            r0 = move-exception
            r6.disconnect()     // Catch:{ IOException -> 0x0254 }
            com.google.android.gms.internal.ads.zzasm r2 = r1.f26675c     // Catch:{ IOException -> 0x0254 }
            r2.mo30048a()     // Catch:{ IOException -> 0x0254 }
            throw r0     // Catch:{ IOException -> 0x0254 }
        L_0x0254:
            r0 = move-exception
            java.lang.String r2 = "Error while connecting to ad server: "
            java.lang.String r3 = r0.getMessage()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x026a
            java.lang.String r2 = r2.concat(r3)
            goto L_0x0270
        L_0x026a:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r2)
            r2 = r3
        L_0x0270:
            com.google.android.gms.internal.ads.zzbad.m26359d(r2)
            com.google.android.gms.internal.ads.zzcif r2 = new com.google.android.gms.internal.ads.zzcif
            java.lang.String r3 = "Error connecting to ad server:"
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r4 = r0.length()
            if (r4 == 0) goto L_0x028a
            java.lang.String r0 = r3.concat(r0)
            goto L_0x028f
        L_0x028a:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
        L_0x028f:
            r3 = 2
            r2.<init>(r0, r3)
            goto L_0x0295
        L_0x0294:
            throw r2
        L_0x0295:
            goto L_0x0294
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzciu.m28464a(java.lang.String, com.google.android.gms.internal.ads.zzasd, org.json.JSONObject, java.lang.String):com.google.android.gms.internal.ads.zzciw");
    }

    public final /* synthetic */ Object apply(Object obj) throws Exception {
        zzciv zzciv = (zzciv) obj;
        return m28464a(zzciv.f26678b.mo30039a(), zzciv.f26678b, zzciv.f26677a, this.f26676d);
    }
}
