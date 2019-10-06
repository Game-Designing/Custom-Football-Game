package p019d.p143b.p144a.p147c;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.o */
class C7190o {

    /* renamed from: a */
    private static final Object f13649a = new JSONObject();

    /* renamed from: b */
    private final C7142c f13650b;

    /* renamed from: c */
    private final C7262l f13651c;

    C7190o(C7142c cVar) {
        this.f13650b = cVar;
        this.f13651c = cVar.mo23049b();
    }

    /* renamed from: a */
    private int m15365a(Throwable th) {
        if (th instanceof UnknownHostException) {
            return -103;
        }
        if (th instanceof SocketTimeoutException) {
            return -102;
        }
        if (!(th instanceof IOException)) {
            return th instanceof JSONException ? -104 : -1;
        }
        String message = th.getMessage();
        return (message == null || !message.toLowerCase(Locale.ENGLISH).contains("authentication challenge")) ? -100 : 401;
    }

    /* renamed from: a */
    private HttpURLConnection m15366a(String str, String str2, int i) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(i < 0 ? ((Integer) this.f13650b.mo23039a(C7196pb.f13907y)).intValue() : i);
        if (i < 0) {
            i = ((Integer) this.f13650b.mo23039a(C7196pb.f13664A)).intValue();
        }
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    /* renamed from: a */
    private static void m15367a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.String, code=T, for r5v0, types: [T, java.lang.String] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> void m15368a(T r5, int r6, java.lang.String r7, java.lang.String r8, T r9, p019d.p143b.p144a.p147c.C7198q<T> r10) throws org.json.JSONException {
        /*
            r4 = this;
            d.b.d.l r7 = r4.f13651c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            java.lang.String r1 = " received from from \""
            r0.append(r1)
            r0.append(r8)
            java.lang.String r1 = "\": "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ConnectionManager"
            r7.mo22918c(r1, r0)
            java.lang.String r7 = "\""
            r0 = 200(0xc8, float:2.8E-43)
            if (r6 < r0) goto L_0x00a8
            r0 = 300(0x12c, float:4.2E-43)
            if (r6 >= r0) goto L_0x00a8
            if (r5 == 0) goto L_0x0038
            int r0 = r5.length()
            r2 = 2
            if (r0 <= r2) goto L_0x0038
            r0 = 1
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            r2 = 204(0xcc, float:2.86E-43)
            if (r6 == r2) goto L_0x00a4
            if (r0 == 0) goto L_0x00a4
            boolean r0 = r9 instanceof java.lang.String     // Catch:{ JSONException -> 0x008a, SAXException -> 0x007f }
            if (r0 == 0) goto L_0x0045
        L_0x0043:
            r9 = r5
            goto L_0x00a4
        L_0x0045:
            boolean r0 = r9 instanceof p019d.p143b.p144a.p147c.C7217uc     // Catch:{ JSONException -> 0x008a, SAXException -> 0x007f }
            if (r0 == 0) goto L_0x0050
            d.b.a.c.c r0 = r4.f13650b     // Catch:{ JSONException -> 0x008a, SAXException -> 0x007f }
            d.b.a.c.uc r5 = p019d.p143b.p144a.p147c.C7221vc.m15602a(r5, r0)     // Catch:{ JSONException -> 0x008a, SAXException -> 0x007f }
            goto L_0x0043
        L_0x0050:
            boolean r0 = r9 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x008a, SAXException -> 0x007f }
            if (r0 == 0) goto L_0x005b
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x008a, SAXException -> 0x007f }
            r0.<init>(r5)     // Catch:{ JSONException -> 0x008a, SAXException -> 0x007f }
            r9 = r0
            goto L_0x00a4
        L_0x005b:
            d.b.d.l r5 = r4.f13651c     // Catch:{ JSONException -> 0x008a, SAXException -> 0x007f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x008a, SAXException -> 0x007f }
            r0.<init>()     // Catch:{ JSONException -> 0x008a, SAXException -> 0x007f }
            java.lang.String r2 = "Unable to handle '"
            r0.append(r2)     // Catch:{ JSONException -> 0x008a, SAXException -> 0x007f }
            java.lang.Class r2 = r9.getClass()     // Catch:{ JSONException -> 0x008a, SAXException -> 0x007f }
            java.lang.String r2 = r2.getName()     // Catch:{ JSONException -> 0x008a, SAXException -> 0x007f }
            r0.append(r2)     // Catch:{ JSONException -> 0x008a, SAXException -> 0x007f }
            java.lang.String r2 = "'"
            r0.append(r2)     // Catch:{ JSONException -> 0x008a, SAXException -> 0x007f }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x008a, SAXException -> 0x007f }
            r5.mo22916b(r1, r0)     // Catch:{ JSONException -> 0x008a, SAXException -> 0x007f }
            goto L_0x00a4
        L_0x007f:
            r5 = move-exception
            d.b.d.l r0 = r4.f13651c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid XML returned from \""
            goto L_0x0094
        L_0x008a:
            r5 = move-exception
            d.b.d.l r0 = r4.f13651c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid JSON returned from \""
        L_0x0094:
            r2.append(r3)
            r2.append(r8)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r0.mo22917b(r1, r7, r5)
        L_0x00a4:
            r10.mo22857a(r9, r6)
            goto L_0x00c7
        L_0x00a8:
            d.b.d.l r5 = r4.f13651c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r6)
            java.lang.String r0 = " error received from \""
            r9.append(r0)
            r9.append(r8)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r5.mo22916b(r1, r7)
            r10.mo22856a(r6)
        L_0x00c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p143b.p144a.p147c.C7190o.m15368a(java.lang.String, int, java.lang.String, java.lang.String, java.lang.Object, d.b.a.c.q):void");
    }

    /* renamed from: a */
    private void m15369a(String str, String str2, int i, long j) {
        C7262l lVar = this.f13651c;
        StringBuilder sb = new StringBuilder();
        sb.append("Successful ");
        sb.append(str);
        sb.append(" returned ");
        sb.append(i);
        sb.append(" in ");
        sb.append(((float) (System.currentTimeMillis() - j)) / 1000.0f);
        sb.append(" s over ");
        sb.append(C7202r.m15398a(this.f13650b));
        sb.append(" to \"");
        sb.append(str2);
        sb.append("\"");
        lVar.mo22920d("ConnectionManager", sb.toString());
    }

    /* renamed from: a */
    private void m15370a(String str, String str2, int i, long j, Throwable th) {
        C7262l lVar = this.f13651c;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed ");
        sb.append(str);
        sb.append(" returned ");
        sb.append(i);
        sb.append(" in ");
        sb.append(((float) (System.currentTimeMillis() - j)) / 1000.0f);
        sb.append(" s over ");
        sb.append(C7202r.m15398a(this.f13650b));
        sb.append(" to \"");
        sb.append(str2);
        sb.append("\"");
        lVar.mo22917b("ConnectionManager", sb.toString(), th);
    }

    /* renamed from: a */
    private static void m15371a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23214a(String str, C7198q<String> qVar) {
        mo23216a(str, "GET", -1, null, "", true, qVar);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x016f A[SYNTHETIC, Splitter:B:49:0x016f] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0173 A[Catch:{ Throwable -> 0x0177 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> void mo23215a(java.lang.String r19, java.lang.String r20, int r21, org.json.JSONObject r22, T r23, boolean r24, p019d.p143b.p144a.p147c.C7194p r25, p019d.p143b.p144a.p147c.C7198q<T> r26) {
        /*
            r18 = this;
            r8 = r18
            r0 = r19
            r9 = r20
            r10 = r23
            r7 = r25
            r11 = r26
            if (r0 == 0) goto L_0x01b2
            if (r9 == 0) goto L_0x01aa
            if (r11 == 0) goto L_0x01a2
            java.lang.String r1 = r19.toLowerCase()
            java.lang.String r2 = "http"
            boolean r1 = r1.startsWith(r2)
            java.lang.String r2 = "ConnectionManager"
            if (r1 != 0) goto L_0x0041
            d.b.d.l r1 = r8.f13651c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Requested postback submission to non HTTP endpoint "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = "; skipping..."
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.mo22921e(r2, r0)
            r0 = -900(0xfffffffffffffc7c, float:NaN)
            r11.mo22856a(r0)
            return
        L_0x0041:
            d.b.a.c.c r1 = r8.f13650b
            d.b.a.c.rb<java.lang.Boolean> r3 = p019d.p143b.p144a.p147c.C7196pb.f13758Tb
            java.lang.Object r1 = r1.mo23039a(r3)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x006a
            java.lang.String r1 = "https://"
            boolean r3 = r0.contains(r1)
            if (r3 != 0) goto L_0x006a
            d.b.a.c.c r3 = r8.f13650b
            d.b.d.l r3 = r3.mo23049b()
            java.lang.String r4 = "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting..."
            r3.mo22913a(r2, r4)
            java.lang.String r3 = "http://"
            java.lang.String r0 = r0.replace(r3, r1)
        L_0x006a:
            r12 = r0
            long r13 = java.lang.System.currentTimeMillis()
            r15 = 0
            d.b.d.l r0 = r8.f13651c     // Catch:{ Throwable -> 0x017c, all -> 0x0179 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x017c, all -> 0x0179 }
            r1.<init>()     // Catch:{ Throwable -> 0x017c, all -> 0x0179 }
            java.lang.String r3 = "Sending "
            r1.append(r3)     // Catch:{ Throwable -> 0x017c, all -> 0x0179 }
            r1.append(r9)     // Catch:{ Throwable -> 0x017c, all -> 0x0179 }
            java.lang.String r3 = " request to \""
            r1.append(r3)     // Catch:{ Throwable -> 0x017c, all -> 0x0179 }
            r1.append(r12)     // Catch:{ Throwable -> 0x017c, all -> 0x0179 }
            java.lang.String r3 = "\"..."
            r1.append(r3)     // Catch:{ Throwable -> 0x017c, all -> 0x0179 }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x017c, all -> 0x0179 }
            r0.mo22920d(r2, r1)     // Catch:{ Throwable -> 0x017c, all -> 0x0179 }
            r0 = r21
            java.net.HttpURLConnection r5 = r8.m15366a(r12, r9, r0)     // Catch:{ Throwable -> 0x017c, all -> 0x0179 }
            if (r22 == 0) goto L_0x00f6
            java.lang.String r0 = r22.toString()     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            d.b.d.l r1 = r8.f13651c     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            r3.<init>()     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            java.lang.String r4 = "Request to \""
            r3.append(r4)     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            r3.append(r12)     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            java.lang.String r4 = "\" is "
            r3.append(r4)     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            r3.append(r0)     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            r1.mo22918c(r2, r3)     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            java.lang.String r1 = "Content-Type"
            java.lang.String r2 = "application/json; charset=utf-8"
            r5.setRequestProperty(r1, r2)     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            r1 = 1
            r5.setDoOutput(r1)     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            java.lang.String r1 = "UTF-8"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            byte[] r1 = r0.getBytes(r1)     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            int r1 = r1.length     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            r5.setFixedLengthStreamingMode(r1)     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            java.io.OutputStream r3 = r5.getOutputStream()     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            java.lang.String r4 = "UTF8"
            r2.<init>(r3, r4)     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            r1.print(r0)     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            r1.close()     // Catch:{ Throwable -> 0x00f0, all -> 0x00ed }
            goto L_0x00f6
        L_0x00ed:
            r0 = move-exception
            goto L_0x019b
        L_0x00f0:
            r0 = move-exception
            r7 = r0
            r17 = r5
            goto L_0x0180
        L_0x00f6:
            int r0 = r5.getResponseCode()     // Catch:{ MalformedURLException -> 0x0168, Throwable -> 0x0163, all -> 0x015f }
            java.lang.String r16 = r5.getContentType()     // Catch:{ MalformedURLException -> 0x0168, Throwable -> 0x0163, all -> 0x015f }
            if (r0 <= 0) goto L_0x014c
            r1 = r18
            r2 = r20
            r3 = r12
            r4 = r0
            r17 = r5
            r5 = r13
            r1.m15369a(r2, r3, r4, r5)     // Catch:{ MalformedURLException -> 0x015d }
            java.io.InputStream r15 = r17.getInputStream()     // Catch:{ MalformedURLException -> 0x015d }
            if (r24 == 0) goto L_0x013e
            d.b.a.c.c r0 = r8.f13650b     // Catch:{ MalformedURLException -> 0x015d }
            java.lang.String r2 = p019d.p143b.p144a.p147c.C7202r.m15399a(r15, r0)     // Catch:{ MalformedURLException -> 0x015d }
            if (r7 == 0) goto L_0x012c
            if (r2 == 0) goto L_0x0124
            int r0 = r2.length()     // Catch:{ MalformedURLException -> 0x015d }
            long r0 = (long) r0     // Catch:{ MalformedURLException -> 0x015d }
            r7.m15380b(r0)     // Catch:{ MalformedURLException -> 0x015d }
        L_0x0124:
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ MalformedURLException -> 0x015d }
            long r0 = r0 - r13
            r7.m15378a(r0)     // Catch:{ MalformedURLException -> 0x015d }
        L_0x012c:
            int r3 = r17.getResponseCode()     // Catch:{ MalformedURLException -> 0x015d }
            r1 = r18
            r4 = r16
            r5 = r12
            r6 = r23
            r7 = r26
            r1.m15368a(r2, r3, r4, r5, r6, r7)     // Catch:{ MalformedURLException -> 0x015d }
            goto L_0x0191
        L_0x013e:
            if (r7 == 0) goto L_0x0148
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ MalformedURLException -> 0x015d }
            long r1 = r1 - r13
            r7.m15378a(r1)     // Catch:{ MalformedURLException -> 0x015d }
        L_0x0148:
            r11.mo22857a(r10, r0)     // Catch:{ MalformedURLException -> 0x015d }
            goto L_0x0191
        L_0x014c:
            r17 = r5
            r7 = 0
            r1 = r18
            r2 = r20
            r3 = r12
            r4 = r0
            r5 = r13
            r1.m15370a(r2, r3, r4, r5, r7)     // Catch:{ MalformedURLException -> 0x015d }
            r11.mo22856a(r0)     // Catch:{ MalformedURLException -> 0x015d }
            goto L_0x0191
        L_0x015d:
            r0 = move-exception
            goto L_0x016b
        L_0x015f:
            r0 = move-exception
            r17 = r5
            goto L_0x019b
        L_0x0163:
            r0 = move-exception
            r17 = r5
        L_0x0166:
            r7 = r0
            goto L_0x0180
        L_0x0168:
            r0 = move-exception
            r17 = r5
        L_0x016b:
            r0 = -901(0xfffffffffffffc7b, float:NaN)
            if (r24 == 0) goto L_0x0173
            r11.mo22856a(r0)     // Catch:{ Throwable -> 0x0177 }
            goto L_0x0191
        L_0x0173:
            r11.mo22857a(r10, r0)     // Catch:{ Throwable -> 0x0177 }
            goto L_0x0191
        L_0x0177:
            r0 = move-exception
            goto L_0x0166
        L_0x0179:
            r0 = move-exception
            r5 = r15
            goto L_0x019b
        L_0x017c:
            r0 = move-exception
            r7 = r0
            r17 = r15
        L_0x0180:
            int r0 = r8.m15365a(r7)     // Catch:{ all -> 0x0198 }
            r1 = r18
            r2 = r20
            r3 = r12
            r4 = r0
            r5 = r13
            r1.m15370a(r2, r3, r4, r5, r7)     // Catch:{ all -> 0x0198 }
            r11.mo22856a(r0)     // Catch:{ all -> 0x0198 }
        L_0x0191:
            m15367a(r15)
            m15371a(r17)
            return
        L_0x0198:
            r0 = move-exception
            r5 = r17
        L_0x019b:
            m15367a(r15)
            m15371a(r5)
            throw r0
        L_0x01a2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No callback specified"
            r0.<init>(r1)
            throw r0
        L_0x01aa:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No method specified"
            r0.<init>(r1)
            throw r0
        L_0x01b2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No endpoint specified"
            r0.<init>(r1)
            goto L_0x01bb
        L_0x01ba:
            throw r0
        L_0x01bb:
            goto L_0x01ba
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p143b.p144a.p147c.C7190o.mo23215a(java.lang.String, java.lang.String, int, org.json.JSONObject, java.lang.Object, boolean, d.b.a.c.p, d.b.a.c.q):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <T> void mo23216a(String str, String str2, int i, JSONObject jSONObject, T t, boolean z, C7198q<T> qVar) {
        mo23215a(str, str2, i, jSONObject, t, z, null, qVar);
    }
}
