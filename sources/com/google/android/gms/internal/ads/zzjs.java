package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class zzjs implements zzkf {

    /* renamed from: a */
    private static final Pattern f28700a = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: b */
    private static final AtomicReference<byte[]> f28701b = new AtomicReference<>();

    /* renamed from: c */
    private final boolean f28702c;

    /* renamed from: d */
    private final int f28703d;

    /* renamed from: e */
    private final int f28704e;

    /* renamed from: f */
    private final String f28705f;

    /* renamed from: g */
    private final zzkn<String> f28706g;

    /* renamed from: h */
    private final HashMap<String, String> f28707h;

    /* renamed from: i */
    private final zzke f28708i;

    /* renamed from: j */
    private zzjq f28709j;

    /* renamed from: k */
    private HttpURLConnection f28710k;

    /* renamed from: l */
    private InputStream f28711l;

    /* renamed from: m */
    private boolean f28712m;

    /* renamed from: n */
    private long f28713n;

    /* renamed from: o */
    private long f28714o;

    /* renamed from: p */
    private long f28715p;

    /* renamed from: q */
    private long f28716q;

    public zzjs(String str, zzkn<String> zzkn, zzke zzke, int i, int i2, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.f28705f = str;
            this.f28706g = null;
            this.f28708i = null;
            this.f28707h = new HashMap<>();
            this.f28703d = i;
            this.f28704e = i2;
            this.f28702c = z;
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0093, code lost:
        if (r0 != 0) goto L_0x0097;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long mo28817a(com.google.android.gms.internal.ads.zzjq r21) throws com.google.android.gms.internal.ads.zzjx {
        /*
            r20 = this;
            r8 = r20
            r9 = r21
            java.lang.String r10 = "Unable to connect to "
            r8.f28709j = r9
            r11 = 0
            r8.f28716q = r11
            r8.f28715p = r11
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x0187 }
            android.net.Uri r0 = r9.f28690a     // Catch:{ IOException -> 0x0187 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0187 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0187 }
            long r13 = r9.f28692c     // Catch:{ IOException -> 0x0187 }
            long r5 = r9.f28693d     // Catch:{ IOException -> 0x0187 }
            int r0 = r9.f28695f     // Catch:{ IOException -> 0x0187 }
            r15 = 1
            r0 = r0 & r15
            r7 = 0
            if (r0 == 0) goto L_0x0027
            r0 = 1
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            boolean r1 = r8.f28702c     // Catch:{ IOException -> 0x0187 }
            if (r1 != 0) goto L_0x0038
            r1 = r20
            r3 = r13
            r7 = r0
            java.net.HttpURLConnection r0 = r1.m30511a(r2, r3, r5, r7)     // Catch:{ IOException -> 0x0187 }
            r0.connect()     // Catch:{ IOException -> 0x0187 }
            goto L_0x0076
        L_0x0038:
            r3 = r2
            r1 = 0
        L_0x003a:
            int r4 = r1 + 1
            r2 = 20
            if (r1 > r2) goto L_0x016a
            r1 = r20
            r2 = r3
            r17 = r3
            r16 = r4
            r3 = r13
            r18 = r5
            r15 = 0
            r7 = r0
            java.net.HttpURLConnection r1 = r1.m30511a(r2, r3, r5, r7)     // Catch:{ IOException -> 0x0187 }
            r1.setInstanceFollowRedirects(r15)     // Catch:{ IOException -> 0x0187 }
            r1.connect()     // Catch:{ IOException -> 0x0187 }
            int r2 = r1.getResponseCode()     // Catch:{ IOException -> 0x0187 }
            r3 = 300(0x12c, float:4.2E-43)
            if (r2 == r3) goto L_0x0112
            r3 = 301(0x12d, float:4.22E-43)
            if (r2 == r3) goto L_0x0112
            r3 = 302(0x12e, float:4.23E-43)
            if (r2 == r3) goto L_0x0112
            r3 = 303(0x12f, float:4.25E-43)
            if (r2 == r3) goto L_0x0112
            r3 = 307(0x133, float:4.3E-43)
            if (r2 == r3) goto L_0x0112
            r3 = 308(0x134, float:4.32E-43)
            if (r2 != r3) goto L_0x0075
            r2 = 1
            goto L_0x0113
        L_0x0075:
            r0 = r1
        L_0x0076:
            r8.f28710k = r0     // Catch:{ IOException -> 0x0187 }
            java.net.HttpURLConnection r0 = r8.f28710k     // Catch:{ IOException -> 0x00ee }
            int r0 = r0.getResponseCode()     // Catch:{ IOException -> 0x00ee }
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 < r1) goto L_0x00df
            r2 = 299(0x12b, float:4.19E-43)
            if (r0 > r2) goto L_0x00df
            java.net.HttpURLConnection r2 = r8.f28710k
            r2.getContentType()
            if (r0 != r1) goto L_0x0096
            long r0 = r9.f28692c
            int r2 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r2 == 0) goto L_0x0096
            goto L_0x0097
        L_0x0096:
            r0 = r11
        L_0x0097:
            r8.f28713n = r0
            int r0 = r9.f28695f
            r1 = 1
            r0 = r0 & r1
            if (r0 != 0) goto L_0x00bb
            java.net.HttpURLConnection r0 = r8.f28710k
            long r0 = m30510a(r0)
            long r2 = r9.f28693d
            r4 = -1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00ae
            goto L_0x00b8
        L_0x00ae:
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x00b7
            long r2 = r8.f28713n
            long r2 = r0 - r2
            goto L_0x00b8
        L_0x00b7:
            r2 = r4
        L_0x00b8:
            r8.f28714o = r2
            goto L_0x00bf
        L_0x00bb:
            long r0 = r9.f28693d
            r8.f28714o = r0
        L_0x00bf:
            java.net.HttpURLConnection r0 = r8.f28710k     // Catch:{ IOException -> 0x00d5 }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x00d5 }
            r8.f28711l = r0     // Catch:{ IOException -> 0x00d5 }
            r2 = 1
            r8.f28712m = r2
            com.google.android.gms.internal.ads.zzke r0 = r8.f28708i
            if (r0 == 0) goto L_0x00d2
            r0.mo31883a()
        L_0x00d2:
            long r0 = r8.f28714o
            return r0
        L_0x00d5:
            r0 = move-exception
            r20.m30512a()
            com.google.android.gms.internal.ads.zzjx r1 = new com.google.android.gms.internal.ads.zzjx
            r1.<init>(r0, r9)
            throw r1
        L_0x00df:
            java.net.HttpURLConnection r1 = r8.f28710k
            java.util.Map r1 = r1.getHeaderFields()
            r20.m30512a()
            com.google.android.gms.internal.ads.zzjy r2 = new com.google.android.gms.internal.ads.zzjy
            r2.<init>(r0, r1, r9)
            throw r2
        L_0x00ee:
            r0 = move-exception
            r20.m30512a()
            com.google.android.gms.internal.ads.zzjx r1 = new com.google.android.gms.internal.ads.zzjx
            android.net.Uri r2 = r9.f28690a
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x0109
            java.lang.String r2 = r10.concat(r2)
            goto L_0x010e
        L_0x0109:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r10)
        L_0x010e:
            r1.<init>(r2, r0, r9)
            throw r1
        L_0x0112:
            r2 = 1
        L_0x0113:
            java.lang.String r3 = "Location"
            java.lang.String r3 = r1.getHeaderField(r3)     // Catch:{ IOException -> 0x0187 }
            r1.disconnect()     // Catch:{ IOException -> 0x0187 }
            if (r3 == 0) goto L_0x0162
            java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x0187 }
            r4 = r17
            r1.<init>(r4, r3)     // Catch:{ IOException -> 0x0187 }
            java.lang.String r3 = r1.getProtocol()     // Catch:{ IOException -> 0x0187 }
            java.lang.String r4 = "https"
            boolean r4 = r4.equals(r3)     // Catch:{ IOException -> 0x0187 }
            if (r4 != 0) goto L_0x0157
            java.lang.String r4 = "http"
            boolean r4 = r4.equals(r3)     // Catch:{ IOException -> 0x0187 }
            if (r4 != 0) goto L_0x0157
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x0187 }
            java.lang.String r1 = "Unsupported protocol redirect: "
            java.lang.String r2 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x0187 }
            int r3 = r2.length()     // Catch:{ IOException -> 0x0187 }
            if (r3 == 0) goto L_0x014d
            java.lang.String r1 = r1.concat(r2)     // Catch:{ IOException -> 0x0187 }
            goto L_0x0153
        L_0x014d:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x0187 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0187 }
            r1 = r2
        L_0x0153:
            r0.<init>(r1)     // Catch:{ IOException -> 0x0187 }
            throw r0     // Catch:{ IOException -> 0x0187 }
        L_0x0157:
            r3 = r1
            r1 = r16
            r5 = r18
            r7 = 0
            r15 = 1
            goto L_0x003a
        L_0x0162:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x0187 }
            java.lang.String r1 = "Null location redirect"
            r0.<init>(r1)     // Catch:{ IOException -> 0x0187 }
            throw r0     // Catch:{ IOException -> 0x0187 }
        L_0x016a:
            r16 = r4
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x0187 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0187 }
            r2 = 31
            r1.<init>(r2)     // Catch:{ IOException -> 0x0187 }
            java.lang.String r2 = "Too many redirects: "
            r1.append(r2)     // Catch:{ IOException -> 0x0187 }
            r2 = r16
            r1.append(r2)     // Catch:{ IOException -> 0x0187 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0187 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0187 }
            throw r0     // Catch:{ IOException -> 0x0187 }
        L_0x0187:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzjx r1 = new com.google.android.gms.internal.ads.zzjx
            android.net.Uri r2 = r9.f28690a
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x019f
            java.lang.String r2 = r10.concat(r2)
            goto L_0x01a4
        L_0x019f:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r10)
        L_0x01a4:
            r1.<init>(r2, r0, r9)
            goto L_0x01a9
        L_0x01a8:
            throw r1
        L_0x01a9:
            goto L_0x01a8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjs.mo28817a(com.google.android.gms.internal.ads.zzjq):long");
    }

    public final int read(byte[] bArr, int i, int i2) throws zzjx {
        try {
            if (this.f28715p != this.f28713n) {
                byte[] bArr2 = (byte[]) f28701b.getAndSet(null);
                if (bArr2 == null) {
                    bArr2 = new byte[Opcodes.ACC_SYNTHETIC];
                }
                while (this.f28715p != this.f28713n) {
                    int read = this.f28711l.read(bArr2, 0, (int) Math.min(this.f28713n - this.f28715p, (long) bArr2.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.f28715p += (long) read;
                        if (this.f28708i != null) {
                            this.f28708i.mo31884a(read);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
                f28701b.set(bArr2);
            }
            if (this.f28714o != -1) {
                i2 = (int) Math.min((long) i2, this.f28714o - this.f28716q);
            }
            if (i2 == 0) {
                return -1;
            }
            int read2 = this.f28711l.read(bArr, i, i2);
            if (read2 == -1) {
                if (this.f28714o != -1) {
                    if (this.f28714o != this.f28716q) {
                        throw new EOFException();
                    }
                }
                return -1;
            }
            this.f28716q += (long) read2;
            if (this.f28708i != null) {
                this.f28708i.mo31884a(read2);
            }
            return read2;
        } catch (IOException e) {
            throw new zzjx(e, this.f28709j);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r2 > 2048) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() throws com.google.android.gms.internal.ads.zzjx {
        /*
            r8 = this;
            r0 = 0
            java.io.InputStream r1 = r8.f28711l     // Catch:{ all -> 0x0095 }
            if (r1 == 0) goto L_0x0083
            java.net.HttpURLConnection r1 = r8.f28710k     // Catch:{ all -> 0x0095 }
            long r2 = r8.f28714o     // Catch:{ all -> 0x0095 }
            r4 = -1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0012
            long r2 = r8.f28714o     // Catch:{ all -> 0x0095 }
            goto L_0x0017
        L_0x0012:
            long r2 = r8.f28714o     // Catch:{ all -> 0x0095 }
            long r6 = r8.f28716q     // Catch:{ all -> 0x0095 }
            long r2 = r2 - r6
        L_0x0017:
            int r6 = com.google.android.gms.internal.ads.zzkq.f28747a     // Catch:{ all -> 0x0095 }
            r7 = 19
            if (r6 == r7) goto L_0x0024
            int r6 = com.google.android.gms.internal.ads.zzkq.f28747a     // Catch:{ all -> 0x0095 }
            r7 = 20
            if (r6 != r7) goto L_0x0070
        L_0x0024:
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException -> 0x006e, Exception -> 0x006c }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0034
            int r2 = r1.read()     // Catch:{ IOException -> 0x006e, Exception -> 0x006c }
            r3 = -1
            if (r2 != r3) goto L_0x003a
            goto L_0x0070
        L_0x0034:
            r4 = 2048(0x800, double:1.0118E-320)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0070
        L_0x003a:
            java.lang.Class r2 = r1.getClass()     // Catch:{ IOException -> 0x006e, Exception -> 0x006c }
            java.lang.String r2 = r2.getName()     // Catch:{ IOException -> 0x006e, Exception -> 0x006c }
            java.lang.String r3 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r3 = r2.equals(r3)     // Catch:{ IOException -> 0x006e, Exception -> 0x006c }
            if (r3 != 0) goto L_0x0052
            java.lang.String r3 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r2 = r2.equals(r3)     // Catch:{ IOException -> 0x006e, Exception -> 0x006c }
            if (r2 == 0) goto L_0x006b
        L_0x0052:
            java.lang.Class r2 = r1.getClass()     // Catch:{ IOException -> 0x006e, Exception -> 0x006c }
            java.lang.Class r2 = r2.getSuperclass()     // Catch:{ IOException -> 0x006e, Exception -> 0x006c }
            java.lang.String r3 = "unexpectedEndOfInput"
            java.lang.Class[] r4 = new java.lang.Class[r0]     // Catch:{ IOException -> 0x006e, Exception -> 0x006c }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r4)     // Catch:{ IOException -> 0x006e, Exception -> 0x006c }
            r3 = 1
            r2.setAccessible(r3)     // Catch:{ IOException -> 0x006e, Exception -> 0x006c }
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ IOException -> 0x006e, Exception -> 0x006c }
            r2.invoke(r1, r3)     // Catch:{ IOException -> 0x006e, Exception -> 0x006c }
        L_0x006b:
            goto L_0x0070
        L_0x006c:
            r1 = move-exception
            goto L_0x0070
        L_0x006e:
            r1 = move-exception
        L_0x0070:
            java.io.InputStream r1 = r8.f28711l     // Catch:{ IOException -> 0x007a }
            r1.close()     // Catch:{ IOException -> 0x007a }
            r1 = 0
            r8.f28711l = r1     // Catch:{ all -> 0x0095 }
            goto L_0x0083
        L_0x007a:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzjx r2 = new com.google.android.gms.internal.ads.zzjx     // Catch:{ all -> 0x0095 }
            com.google.android.gms.internal.ads.zzjq r3 = r8.f28709j     // Catch:{ all -> 0x0095 }
            r2.<init>(r1, r3)     // Catch:{ all -> 0x0095 }
            throw r2     // Catch:{ all -> 0x0095 }
        L_0x0083:
            boolean r1 = r8.f28712m
            if (r1 == 0) goto L_0x0094
            r8.f28712m = r0
            com.google.android.gms.internal.ads.zzke r0 = r8.f28708i
            if (r0 == 0) goto L_0x0090
            r0.mo31885b()
        L_0x0090:
            r8.m30512a()
            return
        L_0x0094:
            return
        L_0x0095:
            r1 = move-exception
            boolean r2 = r8.f28712m
            if (r2 == 0) goto L_0x00a6
            r8.f28712m = r0
            com.google.android.gms.internal.ads.zzke r0 = r8.f28708i
            if (r0 == 0) goto L_0x00a3
            r0.mo31885b()
        L_0x00a3:
            r8.m30512a()
        L_0x00a6:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjs.close():void");
    }

    /* renamed from: a */
    private final HttpURLConnection m30511a(URL url, long j, long j2, boolean z) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f28703d);
        httpURLConnection.setReadTimeout(this.f28704e);
        httpURLConnection.setDoOutput(false);
        synchronized (this.f28707h) {
            for (Entry entry : this.f28707h.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        if (!(j == 0 && j2 == -1)) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            String sb2 = sb.toString();
            if (j2 != -1) {
                String valueOf = String.valueOf(sb2);
                long j3 = (j + j2) - 1;
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb3.append(valueOf);
                sb3.append(j3);
                sb2 = sb3.toString();
            }
            httpURLConnection.setRequestProperty("Range", sb2);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f28705f);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0046  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long m30510a(java.net.HttpURLConnection r10) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r10.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "]"
            java.lang.String r3 = "HttpDataSource"
            if (r1 != 0) goto L_0x0038
            long r4 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0016 }
            goto L_0x003a
        L_0x0016:
            r1 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r0)
            int r4 = r4.length()
            int r4 = r4 + 28
            r1.<init>(r4)
            java.lang.String r4 = "Unexpected Content-Length ["
            r1.append(r4)
            r1.append(r0)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r3, r1)
        L_0x0038:
            r4 = -1
        L_0x003a:
            java.lang.String r1 = "Content-Range"
            java.lang.String r10 = r10.getHeaderField(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 != 0) goto L_0x00ce
            java.util.regex.Pattern r1 = f28700a
            java.util.regex.Matcher r1 = r1.matcher(r10)
            boolean r6 = r1.find()
            if (r6 == 0) goto L_0x00ce
            r6 = 2
            java.lang.String r6 = r1.group(r6)     // Catch:{ NumberFormatException -> 0x00ac }
            long r6 = java.lang.Long.parseLong(r6)     // Catch:{ NumberFormatException -> 0x00ac }
            r8 = 1
            java.lang.String r1 = r1.group(r8)     // Catch:{ NumberFormatException -> 0x00ac }
            long r8 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x00ac }
            long r6 = r6 - r8
            r8 = 1
            long r6 = r6 + r8
            r8 = 0
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x0070
            r4 = r6
            goto L_0x00ce
        L_0x0070:
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x00ab
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00ac }
            java.lang.String r8 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ac }
            int r8 = r8.length()     // Catch:{ NumberFormatException -> 0x00ac }
            int r8 = r8 + 26
            java.lang.String r9 = java.lang.String.valueOf(r10)     // Catch:{ NumberFormatException -> 0x00ac }
            int r9 = r9.length()     // Catch:{ NumberFormatException -> 0x00ac }
            int r8 = r8 + r9
            r1.<init>(r8)     // Catch:{ NumberFormatException -> 0x00ac }
            java.lang.String r8 = "Inconsistent headers ["
            r1.append(r8)     // Catch:{ NumberFormatException -> 0x00ac }
            r1.append(r0)     // Catch:{ NumberFormatException -> 0x00ac }
            java.lang.String r0 = "] ["
            r1.append(r0)     // Catch:{ NumberFormatException -> 0x00ac }
            r1.append(r10)     // Catch:{ NumberFormatException -> 0x00ac }
            r1.append(r2)     // Catch:{ NumberFormatException -> 0x00ac }
            java.lang.String r0 = r1.toString()     // Catch:{ NumberFormatException -> 0x00ac }
            android.util.Log.w(r3, r0)     // Catch:{ NumberFormatException -> 0x00ac }
            long r0 = java.lang.Math.max(r4, r6)     // Catch:{ NumberFormatException -> 0x00ac }
            r4 = r0
        L_0x00ab:
            goto L_0x00ce
        L_0x00ac:
            r0 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = java.lang.String.valueOf(r10)
            int r1 = r1.length()
            int r1 = r1 + 27
            r0.<init>(r1)
            java.lang.String r1 = "Unexpected Content-Range ["
            r0.append(r1)
            r0.append(r10)
            r0.append(r2)
            java.lang.String r10 = r0.toString()
            android.util.Log.e(r3, r10)
        L_0x00ce:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjs.m30510a(java.net.HttpURLConnection):long");
    }

    /* renamed from: a */
    private final void m30512a() {
        HttpURLConnection httpURLConnection = this.f28710k;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.f28710k = null;
        }
    }
}
