package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Log;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class zzsa implements zzrv {

    /* renamed from: a */
    private static final Pattern f29283a = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: b */
    private static final AtomicReference<byte[]> f29284b = new AtomicReference<>();

    /* renamed from: c */
    private final boolean f29285c;

    /* renamed from: d */
    private final int f29286d;

    /* renamed from: e */
    private final int f29287e;

    /* renamed from: f */
    private final String f29288f;

    /* renamed from: g */
    private final zzsv<String> f29289g = null;

    /* renamed from: h */
    private final zzsd f29290h;

    /* renamed from: i */
    private final zzsd f29291i;

    /* renamed from: j */
    private final zzsj<? super zzsa> f29292j;

    /* renamed from: k */
    private zzry f29293k;

    /* renamed from: l */
    private HttpURLConnection f29294l;

    /* renamed from: m */
    private InputStream f29295m;

    /* renamed from: n */
    private boolean f29296n;

    /* renamed from: o */
    private long f29297o;

    /* renamed from: p */
    private long f29298p;

    /* renamed from: q */
    private long f29299q;

    /* renamed from: r */
    private long f29300r;

    public zzsa(String str, zzsv<String> zzsv, zzsj<? super zzsa> zzsj, int i, int i2, boolean z, zzsd zzsd) {
        zzsk.m31079a(str);
        this.f29288f = str;
        this.f29292j = zzsj;
        this.f29291i = new zzsd();
        this.f29286d = i;
        this.f29287e = i2;
        this.f29285c = true;
        this.f29290h = null;
    }

    public final Uri getUri() {
        HttpURLConnection httpURLConnection = this.f29294l;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* renamed from: a */
    public final Map<String, List<String>> mo32180a() {
        HttpURLConnection httpURLConnection = this.f29294l;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0098, code lost:
        if (r0 != 0) goto L_0x009c;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long mo29017a(com.google.android.gms.internal.ads.zzry r25) throws com.google.android.gms.internal.ads.zzsb {
        /*
            r24 = this;
            r10 = r24
            r11 = r25
            java.lang.String r12 = "Unable to connect to "
            r10.f29293k = r11
            r13 = 0
            r10.f29300r = r13
            r10.f29299q = r13
            r15 = 1
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x019a }
            android.net.Uri r0 = r11.f29268a     // Catch:{ IOException -> 0x019a }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x019a }
            r2.<init>(r0)     // Catch:{ IOException -> 0x019a }
            byte[] r3 = r11.f29269b     // Catch:{ IOException -> 0x019a }
            long r8 = r11.f29271d     // Catch:{ IOException -> 0x019a }
            long r6 = r11.f29272e     // Catch:{ IOException -> 0x019a }
            boolean r0 = r11.mo32175a(r15)     // Catch:{ IOException -> 0x019a }
            boolean r1 = r10.f29285c     // Catch:{ IOException -> 0x019a }
            r4 = 0
            if (r1 != 0) goto L_0x0037
            r16 = 1
            r1 = r24
            r4 = r8
            r8 = r0
            r9 = r16
            java.net.HttpURLConnection r0 = r1.m31054a(r2, r3, r4, r6, r8, r9)     // Catch:{ IOException -> 0x019a }
            goto L_0x007a
        L_0x0037:
            r4 = r2
            r16 = r3
            r1 = 0
        L_0x003b:
            int r5 = r1 + 1
            r2 = 20
            if (r1 > r2) goto L_0x017d
            r17 = 0
            r1 = r24
            r2 = r4
            r3 = r16
            r19 = r4
            r18 = r5
            r4 = r8
            r20 = r6
            r22 = r8
            r8 = r0
            r9 = r17
            java.net.HttpURLConnection r1 = r1.m31054a(r2, r3, r4, r6, r8, r9)     // Catch:{ IOException -> 0x019a }
            int r2 = r1.getResponseCode()     // Catch:{ IOException -> 0x019a }
            r3 = 300(0x12c, float:4.2E-43)
            if (r2 == r3) goto L_0x0125
            r3 = 301(0x12d, float:4.22E-43)
            if (r2 == r3) goto L_0x0125
            r3 = 302(0x12e, float:4.23E-43)
            if (r2 == r3) goto L_0x0125
            r3 = 303(0x12f, float:4.25E-43)
            if (r2 == r3) goto L_0x0125
            if (r16 != 0) goto L_0x0079
            r3 = 307(0x133, float:4.3E-43)
            if (r2 == r3) goto L_0x0076
            r3 = 308(0x134, float:4.32E-43)
            if (r2 != r3) goto L_0x0079
        L_0x0076:
            r3 = 0
            goto L_0x0126
        L_0x0079:
            r0 = r1
        L_0x007a:
            r10.f29294l = r0     // Catch:{ IOException -> 0x019a }
            java.net.HttpURLConnection r0 = r10.f29294l     // Catch:{ IOException -> 0x0101 }
            int r0 = r0.getResponseCode()     // Catch:{ IOException -> 0x0101 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 < r1) goto L_0x00e5
            r2 = 299(0x12b, float:4.19E-43)
            if (r0 <= r2) goto L_0x008d
            goto L_0x00e5
        L_0x008d:
            java.net.HttpURLConnection r2 = r10.f29294l
            r2.getContentType()
            if (r0 != r1) goto L_0x009b
            long r0 = r11.f29271d
            int r2 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r2 == 0) goto L_0x009b
            goto L_0x009c
        L_0x009b:
            r0 = r13
        L_0x009c:
            r10.f29297o = r0
            boolean r0 = r11.mo32175a(r15)
            if (r0 != 0) goto L_0x00c2
            long r0 = r11.f29272e
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00af
            r10.f29298p = r0
            goto L_0x00c6
        L_0x00af:
            java.net.HttpURLConnection r0 = r10.f29294l
            long r0 = m31053a(r0)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00be
            long r2 = r10.f29297o
            long r2 = r0 - r2
            goto L_0x00bf
        L_0x00be:
        L_0x00bf:
            r10.f29298p = r2
            goto L_0x00c6
        L_0x00c2:
            long r0 = r11.f29272e
            r10.f29298p = r0
        L_0x00c6:
            java.net.HttpURLConnection r0 = r10.f29294l     // Catch:{ IOException -> 0x00db }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x00db }
            r10.f29295m = r0     // Catch:{ IOException -> 0x00db }
            r10.f29296n = r15
            com.google.android.gms.internal.ads.zzsj<? super com.google.android.gms.internal.ads.zzsa> r0 = r10.f29292j
            if (r0 == 0) goto L_0x00d8
            r0.mo30519a(r10, r11)
        L_0x00d8:
            long r0 = r10.f29298p
            return r0
        L_0x00db:
            r0 = move-exception
            r24.m31055b()
            com.google.android.gms.internal.ads.zzsb r1 = new com.google.android.gms.internal.ads.zzsb
            r1.<init>(r0, r11, r15)
            throw r1
        L_0x00e5:
            java.net.HttpURLConnection r1 = r10.f29294l
            java.util.Map r1 = r1.getHeaderFields()
            r24.m31055b()
            com.google.android.gms.internal.ads.zzsc r2 = new com.google.android.gms.internal.ads.zzsc
            r2.<init>(r0, r1, r11)
            r1 = 416(0x1a0, float:5.83E-43)
            if (r0 != r1) goto L_0x0100
            com.google.android.gms.internal.ads.zzrx r0 = new com.google.android.gms.internal.ads.zzrx
            r3 = 0
            r0.<init>(r3)
            r2.initCause(r0)
        L_0x0100:
            throw r2
        L_0x0101:
            r0 = move-exception
            r24.m31055b()
            com.google.android.gms.internal.ads.zzsb r1 = new com.google.android.gms.internal.ads.zzsb
            android.net.Uri r2 = r11.f29268a
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x011c
            java.lang.String r2 = r12.concat(r2)
            goto L_0x0121
        L_0x011c:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r12)
        L_0x0121:
            r1.<init>(r2, r0, r11, r15)
            throw r1
        L_0x0125:
            r3 = 0
        L_0x0126:
            r16 = 0
            java.lang.String r2 = "Location"
            java.lang.String r2 = r1.getHeaderField(r2)     // Catch:{ IOException -> 0x019a }
            r1.disconnect()     // Catch:{ IOException -> 0x019a }
            if (r2 == 0) goto L_0x0175
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x019a }
            r1 = r19
            r4.<init>(r1, r2)     // Catch:{ IOException -> 0x019a }
            java.lang.String r1 = r4.getProtocol()     // Catch:{ IOException -> 0x019a }
            java.lang.String r2 = "https"
            boolean r2 = r2.equals(r1)     // Catch:{ IOException -> 0x019a }
            if (r2 != 0) goto L_0x016b
            java.lang.String r2 = "http"
            boolean r2 = r2.equals(r1)     // Catch:{ IOException -> 0x019a }
            if (r2 != 0) goto L_0x016b
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x019a }
            java.lang.String r2 = "Unsupported protocol redirect: "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x019a }
            int r3 = r1.length()     // Catch:{ IOException -> 0x019a }
            if (r3 == 0) goto L_0x0162
            java.lang.String r1 = r2.concat(r1)     // Catch:{ IOException -> 0x019a }
            goto L_0x0167
        L_0x0162:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x019a }
            r1.<init>(r2)     // Catch:{ IOException -> 0x019a }
        L_0x0167:
            r0.<init>(r1)     // Catch:{ IOException -> 0x019a }
            throw r0     // Catch:{ IOException -> 0x019a }
        L_0x016b:
            r1 = r18
            r6 = r20
            r8 = r22
            goto L_0x003b
        L_0x0175:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x019a }
            java.lang.String r1 = "Null location redirect"
            r0.<init>(r1)     // Catch:{ IOException -> 0x019a }
            throw r0     // Catch:{ IOException -> 0x019a }
        L_0x017d:
            r18 = r5
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x019a }
            r1 = 31
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x019a }
            r2.<init>(r1)     // Catch:{ IOException -> 0x019a }
            java.lang.String r1 = "Too many redirects: "
            r2.append(r1)     // Catch:{ IOException -> 0x019a }
            r1 = r18
            r2.append(r1)     // Catch:{ IOException -> 0x019a }
            java.lang.String r1 = r2.toString()     // Catch:{ IOException -> 0x019a }
            r0.<init>(r1)     // Catch:{ IOException -> 0x019a }
            throw r0     // Catch:{ IOException -> 0x019a }
        L_0x019a:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzsb r1 = new com.google.android.gms.internal.ads.zzsb
            android.net.Uri r2 = r11.f29268a
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x01b2
            java.lang.String r2 = r12.concat(r2)
            goto L_0x01b7
        L_0x01b2:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r12)
        L_0x01b7:
            r1.<init>(r2, r0, r11, r15)
            goto L_0x01bc
        L_0x01bb:
            throw r1
        L_0x01bc:
            goto L_0x01bb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsa.mo29017a(com.google.android.gms.internal.ads.zzry):long");
    }

    public final int read(byte[] bArr, int i, int i2) throws zzsb {
        try {
            if (this.f29299q != this.f29297o) {
                byte[] bArr2 = (byte[]) f29284b.getAndSet(null);
                if (bArr2 == null) {
                    bArr2 = new byte[Opcodes.ACC_SYNTHETIC];
                }
                while (this.f29299q != this.f29297o) {
                    int read = this.f29295m.read(bArr2, 0, (int) Math.min(this.f29297o - this.f29299q, (long) bArr2.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.f29299q += (long) read;
                        if (this.f29292j != null) {
                            this.f29292j.mo30518a(this, read);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
                f29284b.set(bArr2);
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.f29298p != -1) {
                long j = this.f29298p - this.f29300r;
                if (j == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j);
            }
            int read2 = this.f29295m.read(bArr, i, i2);
            if (read2 != -1) {
                this.f29300r += (long) read2;
                if (this.f29292j != null) {
                    this.f29292j.mo30518a(this, read2);
                }
                return read2;
            } else if (this.f29298p == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new zzsb(e, this.f29293k, 2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
        if (r3 > 2048) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() throws com.google.android.gms.internal.ads.zzsb {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.f29295m     // Catch:{ all -> 0x0092 }
            if (r2 == 0) goto L_0x007e
            java.net.HttpURLConnection r2 = r9.f29294l     // Catch:{ all -> 0x0092 }
            long r3 = r9.f29298p     // Catch:{ all -> 0x0092 }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0013
            long r3 = r9.f29298p     // Catch:{ all -> 0x0092 }
            goto L_0x0018
        L_0x0013:
            long r3 = r9.f29298p     // Catch:{ all -> 0x0092 }
            long r7 = r9.f29300r     // Catch:{ all -> 0x0092 }
            long r3 = r3 - r7
        L_0x0018:
            int r7 = com.google.android.gms.internal.ads.zzsy.f29345a     // Catch:{ all -> 0x0092 }
            r8 = 19
            if (r7 == r8) goto L_0x0025
            int r7 = com.google.android.gms.internal.ads.zzsy.f29345a     // Catch:{ all -> 0x0092 }
            r8 = 20
            if (r7 != r8) goto L_0x006e
        L_0x0025:
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x006d }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0035
            int r3 = r2.read()     // Catch:{ Exception -> 0x006d }
            r4 = -1
            if (r3 != r4) goto L_0x003b
            goto L_0x006e
        L_0x0035:
            r5 = 2048(0x800, double:1.0118E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x006e
        L_0x003b:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x006d }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x006d }
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x006d }
            if (r4 != 0) goto L_0x0053
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x006d }
            if (r3 == 0) goto L_0x006c
        L_0x0053:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x006d }
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ Exception -> 0x006d }
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x006d }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x006d }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x006d }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x006d }
            r3.invoke(r2, r4)     // Catch:{ Exception -> 0x006d }
        L_0x006c:
            goto L_0x006e
        L_0x006d:
            r2 = move-exception
        L_0x006e:
            java.io.InputStream r2 = r9.f29295m     // Catch:{ IOException -> 0x0074 }
            r2.close()     // Catch:{ IOException -> 0x0074 }
            goto L_0x007e
        L_0x0074:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzsb r3 = new com.google.android.gms.internal.ads.zzsb     // Catch:{ all -> 0x0092 }
            com.google.android.gms.internal.ads.zzry r4 = r9.f29293k     // Catch:{ all -> 0x0092 }
            r5 = 3
            r3.<init>(r2, r4, r5)     // Catch:{ all -> 0x0092 }
            throw r3     // Catch:{ all -> 0x0092 }
        L_0x007e:
            r9.f29295m = r0
            r9.m31055b()
            boolean r0 = r9.f29296n
            if (r0 == 0) goto L_0x0091
            r9.f29296n = r1
            com.google.android.gms.internal.ads.zzsj<? super com.google.android.gms.internal.ads.zzsa> r0 = r9.f29292j
            if (r0 == 0) goto L_0x0091
            r0.mo30517a(r9)
            return
        L_0x0091:
            return
        L_0x0092:
            r2 = move-exception
            r9.f29295m = r0
            r9.m31055b()
            boolean r0 = r9.f29296n
            if (r0 == 0) goto L_0x00a5
            r9.f29296n = r1
            com.google.android.gms.internal.ads.zzsj<? super com.google.android.gms.internal.ads.zzsa> r0 = r9.f29292j
            if (r0 == 0) goto L_0x00a5
            r0.mo30517a(r9)
        L_0x00a5:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsa.close():void");
    }

    /* renamed from: a */
    private final HttpURLConnection m31054a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f29286d);
        httpURLConnection.setReadTimeout(this.f29287e);
        for (Entry entry : this.f29291i.mo32181a().entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
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
        httpURLConnection.setRequestProperty("User-Agent", this.f29288f);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0046  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long m31053a(java.net.HttpURLConnection r10) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r10.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "]"
            java.lang.String r3 = "DefaultHttpDataSource"
            if (r1 != 0) goto L_0x0038
            long r4 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0016 }
            goto L_0x003a
        L_0x0016:
            r1 = move-exception
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            int r1 = r1 + 28
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r1)
            java.lang.String r1 = "Unexpected Content-Length ["
            r4.append(r1)
            r4.append(r0)
            r4.append(r2)
            java.lang.String r1 = r4.toString()
            android.util.Log.e(r3, r1)
        L_0x0038:
            r4 = -1
        L_0x003a:
            java.lang.String r1 = "Content-Range"
            java.lang.String r10 = r10.getHeaderField(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 != 0) goto L_0x00ce
            java.util.regex.Pattern r1 = f29283a
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
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ac }
            int r1 = r1.length()     // Catch:{ NumberFormatException -> 0x00ac }
            int r1 = r1 + 26
            java.lang.String r8 = java.lang.String.valueOf(r10)     // Catch:{ NumberFormatException -> 0x00ac }
            int r8 = r8.length()     // Catch:{ NumberFormatException -> 0x00ac }
            int r1 = r1 + r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00ac }
            r8.<init>(r1)     // Catch:{ NumberFormatException -> 0x00ac }
            java.lang.String r1 = "Inconsistent headers ["
            r8.append(r1)     // Catch:{ NumberFormatException -> 0x00ac }
            r8.append(r0)     // Catch:{ NumberFormatException -> 0x00ac }
            java.lang.String r0 = "] ["
            r8.append(r0)     // Catch:{ NumberFormatException -> 0x00ac }
            r8.append(r10)     // Catch:{ NumberFormatException -> 0x00ac }
            r8.append(r2)     // Catch:{ NumberFormatException -> 0x00ac }
            java.lang.String r0 = r8.toString()     // Catch:{ NumberFormatException -> 0x00ac }
            android.util.Log.w(r3, r0)     // Catch:{ NumberFormatException -> 0x00ac }
            long r0 = java.lang.Math.max(r4, r6)     // Catch:{ NumberFormatException -> 0x00ac }
            r4 = r0
        L_0x00ab:
            goto L_0x00ce
        L_0x00ac:
            r0 = move-exception
            java.lang.String r0 = java.lang.String.valueOf(r10)
            int r0 = r0.length()
            int r0 = r0 + 27
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Unexpected Content-Range ["
            r1.append(r0)
            r1.append(r10)
            r1.append(r2)
            java.lang.String r10 = r1.toString()
            android.util.Log.e(r3, r10)
        L_0x00ce:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsa.m31053a(java.net.HttpURLConnection):long");
    }

    /* renamed from: b */
    private final void m31055b() {
        HttpURLConnection httpURLConnection = this.f29294l;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.f29294l = null;
        }
    }
}
