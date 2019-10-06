package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

@zzard
/* renamed from: com.google.android.gms.internal.ads.je */
final class C9511je implements zzrv {

    /* renamed from: a */
    private static final Pattern f22591a = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: b */
    private static final AtomicReference<byte[]> f22592b = new AtomicReference<>();

    /* renamed from: c */
    private SSLSocketFactory f22593c = new C9533ke(this);

    /* renamed from: d */
    private final int f22594d;

    /* renamed from: e */
    private final int f22595e;

    /* renamed from: f */
    private final String f22596f;

    /* renamed from: g */
    private final zzsd f22597g;

    /* renamed from: h */
    private final zzsj<? super C9511je> f22598h;

    /* renamed from: i */
    private zzry f22599i;

    /* renamed from: j */
    private HttpURLConnection f22600j;

    /* renamed from: k */
    private InputStream f22601k;

    /* renamed from: l */
    private boolean f22602l;

    /* renamed from: m */
    private long f22603m;

    /* renamed from: n */
    private long f22604n;

    /* renamed from: o */
    private long f22605o;

    /* renamed from: p */
    private long f22606p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f22607q;

    /* renamed from: r */
    private Set<Socket> f22608r = new HashSet();

    C9511je(String str, zzsj<? super C9511je> zzsj, int i, int i2, int i3) {
        zzsk.m31079a(str);
        this.f22596f = str;
        this.f22598h = zzsj;
        this.f22597g = new zzsd();
        this.f22594d = i;
        this.f22595e = i2;
        this.f22607q = i3;
    }

    public final Uri getUri() {
        HttpURLConnection httpURLConnection = this.f22600j;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0150, code lost:
        if (r4 != 0) goto L_0x0156;
     */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0232 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00dd A[Catch:{ IOException -> 0x0253 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ea A[Catch:{ IOException -> 0x0253 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ec A[Catch:{ IOException -> 0x0253 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f2 A[Catch:{ IOException -> 0x0253 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0119 A[Catch:{ IOException -> 0x0253 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01f3 A[Catch:{ IOException -> 0x0253 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long mo29017a(com.google.android.gms.internal.ads.zzry r24) throws com.google.android.gms.internal.ads.zzsb {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            java.lang.String r3 = "Unable to connect to "
            r1.f22599i = r2
            r4 = 0
            r1.f22606p = r4
            r1.f22605o = r4
            r6 = 1
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x0253 }
            android.net.Uri r7 = r2.f29268a     // Catch:{ IOException -> 0x0253 }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x0253 }
            r0.<init>(r7)     // Catch:{ IOException -> 0x0253 }
            byte[] r7 = r2.f29269b     // Catch:{ IOException -> 0x0253 }
            long r8 = r2.f29271d     // Catch:{ IOException -> 0x0253 }
            long r10 = r2.f29272e     // Catch:{ IOException -> 0x0253 }
            boolean r12 = r2.mo32175a(r6)     // Catch:{ IOException -> 0x0253 }
            r14 = r7
            r7 = r0
            r0 = 0
        L_0x0028:
            int r15 = r0 + 1
            r6 = 20
            if (r0 > r6) goto L_0x023a
            java.net.URLConnection r0 = r7.openConnection()     // Catch:{ IOException -> 0x0253 }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x0253 }
            boolean r13 = r0 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ IOException -> 0x0253 }
            if (r13 == 0) goto L_0x0041
            r13 = r0
            javax.net.ssl.HttpsURLConnection r13 = (javax.net.ssl.HttpsURLConnection) r13     // Catch:{ IOException -> 0x0253 }
            javax.net.ssl.SSLSocketFactory r6 = r1.f22593c     // Catch:{ IOException -> 0x0253 }
            r13.setSSLSocketFactory(r6)     // Catch:{ IOException -> 0x0253 }
        L_0x0041:
            int r6 = r1.f22594d     // Catch:{ IOException -> 0x0253 }
            r0.setConnectTimeout(r6)     // Catch:{ IOException -> 0x0253 }
            int r6 = r1.f22595e     // Catch:{ IOException -> 0x0253 }
            r0.setReadTimeout(r6)     // Catch:{ IOException -> 0x0253 }
            com.google.android.gms.internal.ads.zzsd r6 = r1.f22597g     // Catch:{ IOException -> 0x0253 }
            java.util.Map r6 = r6.mo32181a()     // Catch:{ IOException -> 0x0253 }
            java.util.Set r6 = r6.entrySet()     // Catch:{ IOException -> 0x0253 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IOException -> 0x0253 }
        L_0x0059:
            boolean r13 = r6.hasNext()     // Catch:{ IOException -> 0x0253 }
            if (r13 == 0) goto L_0x0079
            java.lang.Object r13 = r6.next()     // Catch:{ IOException -> 0x0253 }
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13     // Catch:{ IOException -> 0x0253 }
            java.lang.Object r17 = r13.getKey()     // Catch:{ IOException -> 0x0253 }
            r4 = r17
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x0253 }
            java.lang.Object r5 = r13.getValue()     // Catch:{ IOException -> 0x0253 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0253 }
            r0.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x0253 }
            r4 = 0
            goto L_0x0059
        L_0x0079:
            r4 = -1
            r17 = 0
            int r6 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r6 != 0) goto L_0x0089
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0086
            goto L_0x0089
        L_0x0086:
            r16 = r8
            goto L_0x00d4
        L_0x0089:
            r6 = 27
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0253 }
            r13.<init>(r6)     // Catch:{ IOException -> 0x0253 }
            java.lang.String r6 = "bytes="
            r13.append(r6)     // Catch:{ IOException -> 0x0253 }
            r13.append(r8)     // Catch:{ IOException -> 0x0253 }
            java.lang.String r6 = "-"
            r13.append(r6)     // Catch:{ IOException -> 0x0253 }
            java.lang.String r6 = r13.toString()     // Catch:{ IOException -> 0x0253 }
            int r13 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00cd
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ IOException -> 0x0253 }
            long r19 = r8 + r10
            r21 = 1
            long r4 = r19 - r21
            java.lang.String r13 = java.lang.String.valueOf(r6)     // Catch:{ IOException -> 0x0253 }
            int r13 = r13.length()     // Catch:{ IOException -> 0x0253 }
            r16 = 20
            int r13 = r13 + 20
            r16 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0253 }
            r8.<init>(r13)     // Catch:{ IOException -> 0x0253 }
            r8.append(r6)     // Catch:{ IOException -> 0x0253 }
            r8.append(r4)     // Catch:{ IOException -> 0x0253 }
            java.lang.String r6 = r8.toString()     // Catch:{ IOException -> 0x0253 }
            goto L_0x00cf
        L_0x00cd:
            r16 = r8
        L_0x00cf:
            java.lang.String r4 = "Range"
            r0.setRequestProperty(r4, r6)     // Catch:{ IOException -> 0x0253 }
        L_0x00d4:
            java.lang.String r4 = "User-Agent"
            java.lang.String r5 = r1.f22596f     // Catch:{ IOException -> 0x0253 }
            r0.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x0253 }
            if (r12 != 0) goto L_0x00e4
            java.lang.String r4 = "Accept-Encoding"
            java.lang.String r5 = "identity"
            r0.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x0253 }
        L_0x00e4:
            r4 = 0
            r0.setInstanceFollowRedirects(r4)     // Catch:{ IOException -> 0x0253 }
            if (r14 == 0) goto L_0x00ec
            r4 = 1
            goto L_0x00ed
        L_0x00ec:
            r4 = 0
        L_0x00ed:
            r0.setDoOutput(r4)     // Catch:{ IOException -> 0x0253 }
            if (r14 == 0) goto L_0x010c
            java.lang.String r4 = "POST"
            r0.setRequestMethod(r4)     // Catch:{ IOException -> 0x0253 }
            int r4 = r14.length     // Catch:{ IOException -> 0x0253 }
            if (r4 == 0) goto L_0x010c
            int r4 = r14.length     // Catch:{ IOException -> 0x0253 }
            r0.setFixedLengthStreamingMode(r4)     // Catch:{ IOException -> 0x0253 }
            r0.connect()     // Catch:{ IOException -> 0x0253 }
            java.io.OutputStream r4 = r0.getOutputStream()     // Catch:{ IOException -> 0x0253 }
            r4.write(r14)     // Catch:{ IOException -> 0x0253 }
            r4.close()     // Catch:{ IOException -> 0x0253 }
            goto L_0x010f
        L_0x010c:
            r0.connect()     // Catch:{ IOException -> 0x0253 }
        L_0x010f:
            int r4 = r0.getResponseCode()     // Catch:{ IOException -> 0x0253 }
            r5 = 300(0x12c, float:4.2E-43)
            if (r4 == r5) goto L_0x01e3
            r5 = 301(0x12d, float:4.22E-43)
            if (r4 == r5) goto L_0x01e3
            r5 = 302(0x12e, float:4.23E-43)
            if (r4 == r5) goto L_0x01e3
            r5 = 303(0x12f, float:4.25E-43)
            if (r4 == r5) goto L_0x01e3
            if (r14 != 0) goto L_0x0134
            r5 = 307(0x133, float:4.3E-43)
            if (r4 == r5) goto L_0x012f
            r5 = 308(0x134, float:4.32E-43)
            if (r4 != r5) goto L_0x0134
        L_0x012f:
            r5 = 0
            r8 = 0
            goto L_0x01e6
        L_0x0134:
            r1.f22600j = r0     // Catch:{ IOException -> 0x0253 }
            java.net.HttpURLConnection r0 = r1.f22600j     // Catch:{ IOException -> 0x01bd }
            int r0 = r0.getResponseCode()     // Catch:{ IOException -> 0x01bd }
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 < r3) goto L_0x01a1
            r4 = 299(0x12b, float:4.19E-43)
            if (r0 <= r4) goto L_0x0148
            goto L_0x01a1
        L_0x0148:
            if (r0 != r3) goto L_0x0153
            long r4 = r2.f29271d
            r8 = 0
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x0155
            goto L_0x0156
        L_0x0153:
            r8 = 0
        L_0x0155:
            r4 = r8
        L_0x0156:
            r1.f22603m = r4
            r3 = 1
            boolean r0 = r2.mo32175a(r3)
            if (r0 != 0) goto L_0x017c
            long r3 = r2.f29272e
            r5 = -1
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x016a
            r1.f22604n = r3
            goto L_0x0180
        L_0x016a:
            java.net.HttpURLConnection r0 = r1.f22600j
            long r3 = m23710a(r0)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0178
            long r5 = r1.f22603m
            long r3 = r3 - r5
            goto L_0x0179
        L_0x0178:
            r3 = r5
        L_0x0179:
            r1.f22604n = r3
            goto L_0x0180
        L_0x017c:
            long r3 = r2.f29272e
            r1.f22604n = r3
        L_0x0180:
            java.net.HttpURLConnection r0 = r1.f22600j     // Catch:{ IOException -> 0x0196 }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x0196 }
            r1.f22601k = r0     // Catch:{ IOException -> 0x0196 }
            r3 = 1
            r1.f22602l = r3
            com.google.android.gms.internal.ads.zzsj<? super com.google.android.gms.internal.ads.je> r0 = r1.f22598h
            if (r0 == 0) goto L_0x0193
            r0.mo30519a(r1, r2)
        L_0x0193:
            long r2 = r1.f22604n
            return r2
        L_0x0196:
            r0 = move-exception
            r23.m23711a()
            com.google.android.gms.internal.ads.zzsb r3 = new com.google.android.gms.internal.ads.zzsb
            r4 = 1
            r3.<init>(r0, r2, r4)
            throw r3
        L_0x01a1:
            java.net.HttpURLConnection r3 = r1.f22600j
            java.util.Map r3 = r3.getHeaderFields()
            r23.m23711a()
            com.google.android.gms.internal.ads.zzsc r4 = new com.google.android.gms.internal.ads.zzsc
            r4.<init>(r0, r3, r2)
            r2 = 416(0x1a0, float:5.83E-43)
            if (r0 != r2) goto L_0x01bc
            com.google.android.gms.internal.ads.zzrx r0 = new com.google.android.gms.internal.ads.zzrx
            r5 = 0
            r0.<init>(r5)
            r4.initCause(r0)
        L_0x01bc:
            throw r4
        L_0x01bd:
            r0 = move-exception
            r23.m23711a()
            com.google.android.gms.internal.ads.zzsb r4 = new com.google.android.gms.internal.ads.zzsb
            android.net.Uri r5 = r2.f29268a
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x01d8
            java.lang.String r3 = r3.concat(r5)
            goto L_0x01de
        L_0x01d8:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r3)
            r3 = r5
        L_0x01de:
            r5 = 1
            r4.<init>(r3, r0, r2, r5)
            throw r4
        L_0x01e3:
            r5 = 0
            r8 = 0
        L_0x01e6:
            r14 = 0
            java.lang.String r4 = "Location"
            java.lang.String r4 = r0.getHeaderField(r4)     // Catch:{ IOException -> 0x0253 }
            r0.disconnect()     // Catch:{ IOException -> 0x0253 }
            if (r4 == 0) goto L_0x0232
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x0253 }
            r0.<init>(r7, r4)     // Catch:{ IOException -> 0x0253 }
            java.lang.String r4 = r0.getProtocol()     // Catch:{ IOException -> 0x0253 }
            java.lang.String r6 = "https"
            boolean r6 = r6.equals(r4)     // Catch:{ IOException -> 0x0253 }
            if (r6 != 0) goto L_0x0228
            java.lang.String r6 = "http"
            boolean r6 = r6.equals(r4)     // Catch:{ IOException -> 0x0253 }
            if (r6 != 0) goto L_0x0228
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x0253 }
            java.lang.String r5 = "Unsupported protocol redirect: "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x0253 }
            int r6 = r4.length()     // Catch:{ IOException -> 0x0253 }
            if (r6 == 0) goto L_0x021f
            java.lang.String r4 = r5.concat(r4)     // Catch:{ IOException -> 0x0253 }
            goto L_0x0224
        L_0x021f:
            java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x0253 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0253 }
        L_0x0224:
            r0.<init>(r4)     // Catch:{ IOException -> 0x0253 }
            throw r0     // Catch:{ IOException -> 0x0253 }
        L_0x0228:
            r7 = r0
            r4 = r8
            r0 = r15
            r8 = r16
            r6 = 1
            goto L_0x0028
        L_0x0232:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x0253 }
            java.lang.String r4 = "Null location redirect"
            r0.<init>(r4)     // Catch:{ IOException -> 0x0253 }
            throw r0     // Catch:{ IOException -> 0x0253 }
        L_0x023a:
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x0253 }
            r4 = 31
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0253 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x0253 }
            java.lang.String r4 = "Too many redirects: "
            r5.append(r4)     // Catch:{ IOException -> 0x0253 }
            r5.append(r15)     // Catch:{ IOException -> 0x0253 }
            java.lang.String r4 = r5.toString()     // Catch:{ IOException -> 0x0253 }
            r0.<init>(r4)     // Catch:{ IOException -> 0x0253 }
            throw r0     // Catch:{ IOException -> 0x0253 }
        L_0x0253:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzsb r4 = new com.google.android.gms.internal.ads.zzsb
            android.net.Uri r5 = r2.f29268a
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x026b
            java.lang.String r3 = r3.concat(r5)
            goto L_0x0271
        L_0x026b:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r3)
            r3 = r5
        L_0x0271:
            r5 = 1
            r4.<init>(r3, r0, r2, r5)
            goto L_0x0277
        L_0x0276:
            throw r4
        L_0x0277:
            goto L_0x0276
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9511je.mo29017a(com.google.android.gms.internal.ads.zzry):long");
    }

    public final int read(byte[] bArr, int i, int i2) throws zzsb {
        try {
            if (this.f22605o != this.f22603m) {
                byte[] bArr2 = (byte[]) f22592b.getAndSet(null);
                if (bArr2 == null) {
                    bArr2 = new byte[Opcodes.ACC_SYNTHETIC];
                }
                while (this.f22605o != this.f22603m) {
                    int read = this.f22601k.read(bArr2, 0, (int) Math.min(this.f22603m - this.f22605o, (long) bArr2.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.f22605o += (long) read;
                        if (this.f22598h != null) {
                            this.f22598h.mo30518a(this, read);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
                f22592b.set(bArr2);
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.f22604n != -1) {
                long j = this.f22604n - this.f22606p;
                if (j == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j);
            }
            int read2 = this.f22601k.read(bArr, i, i2);
            if (read2 != -1) {
                this.f22606p += (long) read2;
                if (this.f22598h != null) {
                    this.f22598h.mo30518a(this, read2);
                }
                return read2;
            } else if (this.f22604n == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new zzsb(e, this.f22599i, 2);
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
            java.io.InputStream r2 = r9.f22601k     // Catch:{ all -> 0x0096 }
            if (r2 == 0) goto L_0x007e
            java.net.HttpURLConnection r2 = r9.f22600j     // Catch:{ all -> 0x0096 }
            long r3 = r9.f22604n     // Catch:{ all -> 0x0096 }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0013
            long r3 = r9.f22604n     // Catch:{ all -> 0x0096 }
            goto L_0x0018
        L_0x0013:
            long r3 = r9.f22604n     // Catch:{ all -> 0x0096 }
            long r7 = r9.f22606p     // Catch:{ all -> 0x0096 }
            long r3 = r3 - r7
        L_0x0018:
            int r7 = com.google.android.gms.internal.ads.zzsy.f29345a     // Catch:{ all -> 0x0096 }
            r8 = 19
            if (r7 == r8) goto L_0x0025
            int r7 = com.google.android.gms.internal.ads.zzsy.f29345a     // Catch:{ all -> 0x0096 }
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
            java.io.InputStream r2 = r9.f22601k     // Catch:{ IOException -> 0x0074 }
            r2.close()     // Catch:{ IOException -> 0x0074 }
            goto L_0x007e
        L_0x0074:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzsb r3 = new com.google.android.gms.internal.ads.zzsb     // Catch:{ all -> 0x0096 }
            com.google.android.gms.internal.ads.zzry r4 = r9.f22599i     // Catch:{ all -> 0x0096 }
            r5 = 3
            r3.<init>(r2, r4, r5)     // Catch:{ all -> 0x0096 }
            throw r3     // Catch:{ all -> 0x0096 }
        L_0x007e:
            r9.f22601k = r0
            r9.m23711a()
            boolean r0 = r9.f22602l
            if (r0 == 0) goto L_0x0090
            r9.f22602l = r1
            com.google.android.gms.internal.ads.zzsj<? super com.google.android.gms.internal.ads.je> r0 = r9.f22598h
            if (r0 == 0) goto L_0x0090
            r0.mo30517a(r9)
        L_0x0090:
            java.util.Set<java.net.Socket> r0 = r9.f22608r
            r0.clear()
            return
        L_0x0096:
            r2 = move-exception
            r9.f22601k = r0
            r9.m23711a()
            boolean r0 = r9.f22602l
            if (r0 == 0) goto L_0x00a9
            r9.f22602l = r1
            com.google.android.gms.internal.ads.zzsj<? super com.google.android.gms.internal.ads.je> r0 = r9.f22598h
            if (r0 == 0) goto L_0x00a9
            r0.mo30517a(r9)
        L_0x00a9:
            java.util.Set<java.net.Socket> r0 = r9.f22608r
            r0.clear()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9511je.close():void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo29018a(int i) {
        this.f22607q = i;
        for (Socket socket : this.f22608r) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.f22607q);
                } catch (SocketException e) {
                    zzbad.m26358c("Failed to update receive buffer size.", e);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m23713a(Socket socket) {
        this.f22608r.add(socket);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0044  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long m23710a(java.net.HttpURLConnection r9) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r9.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "]"
            if (r1 != 0) goto L_0x0036
            long r3 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0014 }
            goto L_0x0038
        L_0x0014:
            r1 = move-exception
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            int r1 = r1 + 28
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            java.lang.String r1 = "Unexpected Content-Length ["
            r3.append(r1)
            r3.append(r0)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzbad.m26355b(r1)
        L_0x0036:
            r3 = -1
        L_0x0038:
            java.lang.String r1 = "Content-Range"
            java.lang.String r9 = r9.getHeaderField(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            if (r1 != 0) goto L_0x00cc
            java.util.regex.Pattern r1 = f22591a
            java.util.regex.Matcher r1 = r1.matcher(r9)
            boolean r5 = r1.find()
            if (r5 == 0) goto L_0x00cc
            r5 = 2
            java.lang.String r5 = r1.group(r5)     // Catch:{ NumberFormatException -> 0x00aa }
            long r5 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException -> 0x00aa }
            r7 = 1
            java.lang.String r1 = r1.group(r7)     // Catch:{ NumberFormatException -> 0x00aa }
            long r7 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x00aa }
            long r5 = r5 - r7
            r7 = 1
            long r5 = r5 + r7
            r7 = 0
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x006e
            r3 = r5
            goto L_0x00cc
        L_0x006e:
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x00a9
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00aa }
            int r1 = r1.length()     // Catch:{ NumberFormatException -> 0x00aa }
            int r1 = r1 + 26
            java.lang.String r7 = java.lang.String.valueOf(r9)     // Catch:{ NumberFormatException -> 0x00aa }
            int r7 = r7.length()     // Catch:{ NumberFormatException -> 0x00aa }
            int r1 = r1 + r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00aa }
            r7.<init>(r1)     // Catch:{ NumberFormatException -> 0x00aa }
            java.lang.String r1 = "Inconsistent headers ["
            r7.append(r1)     // Catch:{ NumberFormatException -> 0x00aa }
            r7.append(r0)     // Catch:{ NumberFormatException -> 0x00aa }
            java.lang.String r0 = "] ["
            r7.append(r0)     // Catch:{ NumberFormatException -> 0x00aa }
            r7.append(r9)     // Catch:{ NumberFormatException -> 0x00aa }
            r7.append(r2)     // Catch:{ NumberFormatException -> 0x00aa }
            java.lang.String r0 = r7.toString()     // Catch:{ NumberFormatException -> 0x00aa }
            com.google.android.gms.internal.ads.zzbad.m26359d(r0)     // Catch:{ NumberFormatException -> 0x00aa }
            long r0 = java.lang.Math.max(r3, r5)     // Catch:{ NumberFormatException -> 0x00aa }
            r3 = r0
        L_0x00a9:
            goto L_0x00cc
        L_0x00aa:
            r0 = move-exception
            java.lang.String r0 = java.lang.String.valueOf(r9)
            int r0 = r0.length()
            int r0 = r0 + 27
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Unexpected Content-Range ["
            r1.append(r0)
            r1.append(r9)
            r1.append(r2)
            java.lang.String r9 = r1.toString()
            com.google.android.gms.internal.ads.zzbad.m26355b(r9)
        L_0x00cc:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9511je.m23710a(java.net.HttpURLConnection):long");
    }

    /* renamed from: a */
    private final void m23711a() {
        HttpURLConnection httpURLConnection = this.f22600j;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzbad.m26356b("Unexpected error while disconnecting", e);
            }
            this.f22600j = null;
        }
    }
}
