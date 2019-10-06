package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

@zzard
public final class zzbgg extends zzbft {

    /* renamed from: d */
    private String f25298d;

    /* renamed from: e */
    private final zzbde f25299e;

    /* renamed from: f */
    private boolean f25300f;

    /* renamed from: g */
    private final zzbfl f25301g = new zzbfl();

    /* renamed from: h */
    private ByteBuffer f25302h;

    /* renamed from: i */
    private boolean f25303i;

    /* renamed from: j */
    private final Object f25304j = new Object();

    /* renamed from: k */
    private boolean f25305k;

    public zzbgg(zzbdf zzbdf, zzbde zzbde) {
        super(zzbdf);
        this.f25299e = zzbde;
    }

    /* renamed from: d */
    public final String mo30558d() {
        return this.f25298d;
    }

    /* renamed from: e */
    public final boolean mo30559e() {
        return this.f25305k;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final String mo30548b(String str) {
        String valueOf = String.valueOf("cache:");
        String valueOf2 = String.valueOf(super.mo30548b(str));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* renamed from: f */
    private final void m26741f() {
        int position = this.f25302h.position();
        boolean z = position > 0;
        int b = zzbdk.m26550b();
        int c = zzbdk.m26551c();
        String str = this.f25298d;
        mo30541a(str, mo30548b(str), position, 0, z, b, c);
    }

    /* JADX WARNING: type inference failed for: r7v15, types: [com.google.android.gms.internal.ads.zzbeh] */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r1.f25305k = true;
        mo30542a(r2, r3, (long) ((int) r1.f25301g.mo30534a(r1.f25302h)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c3, code lost:
        if (r1.f25302h.remaining() > 0) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c5, code lost:
        m26741f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00cd, code lost:
        if (r1.f25300f != false) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00cf, code lost:
        r4 = r7.mo27935b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d7, code lost:
        if ((r4 - r16) < r10) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d9, code lost:
        m26741f();
        r16 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e5, code lost:
        if ((r4 - r8) > (1000 * r12)) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ed, code lost:
        r4 = "downloadTimeout";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r5 = new java.lang.StringBuilder(49);
        r5.append("Timeout exceeded. Limit: ");
        r5.append(r12);
        r5.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x010c, code lost:
        throw new java.io.IOException(r5.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010d, code lost:
        r4 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r5 = r1.f25302h.limit();
        r7 = new java.lang.StringBuilder(35);
        r7.append("Precache abort at ");
        r7.append(r5);
        r7.append(" bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0132, code lost:
        throw new java.io.IOException(r7.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0138, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0139, code lost:
        r4 = r18;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo30546a(java.lang.String r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r1.f25298d = r2
            java.lang.String r3 = r21.mo30548b(r22)
            java.lang.String r4 = "error"
            r5 = 0
            com.google.android.gms.internal.ads.zzjs r0 = new com.google.android.gms.internal.ads.zzjs     // Catch:{ Exception -> 0x013e }
            java.lang.String r8 = r1.f25278b     // Catch:{ Exception -> 0x013e }
            r9 = 0
            r10 = 0
            com.google.android.gms.internal.ads.zzbde r7 = r1.f25299e     // Catch:{ Exception -> 0x013e }
            int r11 = r7.f25150d     // Catch:{ Exception -> 0x013e }
            com.google.android.gms.internal.ads.zzbde r7 = r1.f25299e     // Catch:{ Exception -> 0x013e }
            int r12 = r7.f25152f     // Catch:{ Exception -> 0x013e }
            r13 = 1
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x013e }
            com.google.android.gms.internal.ads.zzbde r7 = r1.f25299e     // Catch:{ Exception -> 0x013e }
            boolean r7 = r7.f25156j     // Catch:{ Exception -> 0x013e }
            if (r7 == 0) goto L_0x0034
            com.google.android.gms.internal.ads.zzbeh r7 = new com.google.android.gms.internal.ads.zzbeh     // Catch:{ Exception -> 0x0031 }
            android.content.Context r8 = r1.f25277a     // Catch:{ Exception -> 0x0031 }
            r9 = 0
            r7.<init>(r8, r0, r9)     // Catch:{ Exception -> 0x0031 }
            r0 = r7
            goto L_0x0035
        L_0x0031:
            r0 = move-exception
            goto L_0x0141
        L_0x0034:
        L_0x0035:
            android.net.Uri r7 = android.net.Uri.parse(r22)     // Catch:{ Exception -> 0x013e }
            com.google.android.gms.internal.ads.zzjq r8 = new com.google.android.gms.internal.ads.zzjq     // Catch:{ Exception -> 0x013e }
            r8.<init>(r7)     // Catch:{ Exception -> 0x013e }
            r0.mo28817a(r8)     // Catch:{ Exception -> 0x013e }
            java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzbdf> r7 = r1.f25279c     // Catch:{ Exception -> 0x013e }
            java.lang.Object r7 = r7.get()     // Catch:{ Exception -> 0x013e }
            com.google.android.gms.internal.ads.zzbdf r7 = (com.google.android.gms.internal.ads.zzbdf) r7     // Catch:{ Exception -> 0x013e }
            if (r7 == 0) goto L_0x004f
            r7.mo28727a(r3, r1)     // Catch:{ Exception -> 0x0031 }
        L_0x004f:
            com.google.android.gms.common.util.Clock r7 = com.google.android.gms.ads.internal.zzk.zzln()     // Catch:{ Exception -> 0x013e }
            long r8 = r7.mo27935b()     // Catch:{ Exception -> 0x013e }
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r10 = com.google.android.gms.internal.ads.zzacu.f23926F     // Catch:{ Exception -> 0x013e }
            com.google.android.gms.internal.ads.zzacr r11 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ Exception -> 0x013e }
            java.lang.Object r10 = r11.mo29599a(r10)     // Catch:{ Exception -> 0x013e }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ Exception -> 0x013e }
            long r10 = r10.longValue()     // Catch:{ Exception -> 0x013e }
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r12 = com.google.android.gms.internal.ads.zzacu.f23920E     // Catch:{ Exception -> 0x013e }
            com.google.android.gms.internal.ads.zzacr r13 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ Exception -> 0x013e }
            java.lang.Object r12 = r13.mo29599a(r12)     // Catch:{ Exception -> 0x013e }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ Exception -> 0x013e }
            long r12 = r12.longValue()     // Catch:{ Exception -> 0x013e }
            com.google.android.gms.internal.ads.zzbde r14 = r1.f25299e     // Catch:{ Exception -> 0x013e }
            int r14 = r14.f25149c     // Catch:{ Exception -> 0x013e }
            java.nio.ByteBuffer r14 = java.nio.ByteBuffer.allocate(r14)     // Catch:{ Exception -> 0x013e }
            r1.f25302h = r14     // Catch:{ Exception -> 0x013e }
            r14 = 8192(0x2000, float:1.14794E-41)
            byte[] r15 = new byte[r14]     // Catch:{ Exception -> 0x013e }
            r16 = r8
        L_0x0088:
            java.nio.ByteBuffer r6 = r1.f25302h     // Catch:{ Exception -> 0x013e }
            int r6 = r6.remaining()     // Catch:{ Exception -> 0x013e }
            int r6 = java.lang.Math.min(r6, r14)     // Catch:{ Exception -> 0x013e }
            int r6 = r0.read(r15, r5, r6)     // Catch:{ Exception -> 0x013e }
            r14 = -1
            if (r6 != r14) goto L_0x00aa
            r6 = 1
            r1.f25305k = r6     // Catch:{ Exception -> 0x0031 }
            com.google.android.gms.internal.ads.zzbfl r0 = r1.f25301g     // Catch:{ Exception -> 0x0031 }
            java.nio.ByteBuffer r6 = r1.f25302h     // Catch:{ Exception -> 0x0031 }
            long r6 = r0.mo30534a(r6)     // Catch:{ Exception -> 0x0031 }
            int r0 = (int) r6     // Catch:{ Exception -> 0x0031 }
            long r6 = (long) r0     // Catch:{ Exception -> 0x0031 }
            r1.mo30542a(r2, r3, r6)     // Catch:{ Exception -> 0x0031 }
            goto L_0x00c9
        L_0x00aa:
            java.lang.Object r14 = r1.f25304j     // Catch:{ Exception -> 0x013e }
            monitor-enter(r14)     // Catch:{ Exception -> 0x013e }
            boolean r5 = r1.f25300f     // Catch:{ all -> 0x0133 }
            if (r5 != 0) goto L_0x00ba
            java.nio.ByteBuffer r5 = r1.f25302h     // Catch:{ all -> 0x0133 }
            r18 = r4
            r4 = 0
            r5.put(r15, r4, r6)     // Catch:{ all -> 0x013c }
            goto L_0x00bc
        L_0x00ba:
            r18 = r4
        L_0x00bc:
            monitor-exit(r14)     // Catch:{ all -> 0x013c }
            java.nio.ByteBuffer r4 = r1.f25302h     // Catch:{ Exception -> 0x0138 }
            int r4 = r4.remaining()     // Catch:{ Exception -> 0x0138 }
            if (r4 > 0) goto L_0x00cb
            r21.m26741f()     // Catch:{ Exception -> 0x0138 }
        L_0x00c9:
            r2 = 1
            return r2
        L_0x00cb:
            boolean r4 = r1.f25300f     // Catch:{ Exception -> 0x0138 }
            if (r4 != 0) goto L_0x010d
            long r4 = r7.mo27935b()     // Catch:{ Exception -> 0x0138 }
            long r19 = r4 - r16
            int r6 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r6 < 0) goto L_0x00de
            r21.m26741f()     // Catch:{ Exception -> 0x0138 }
            r16 = r4
        L_0x00de:
            long r4 = r4 - r8
            r19 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 * r12
            int r6 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r6 > 0) goto L_0x00ed
            r4 = r18
            r5 = 0
            r14 = 8192(0x2000, float:1.14794E-41)
            goto L_0x0088
        L_0x00ed:
            java.lang.String r4 = "downloadTimeout"
            r0 = 49
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0031 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r0 = "Timeout exceeded. Limit: "
            r5.append(r0)     // Catch:{ Exception -> 0x0031 }
            r5.append(r12)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r0 = " sec"
            r5.append(r0)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x0031 }
            java.io.IOException r5 = new java.io.IOException     // Catch:{ Exception -> 0x0031 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x0031 }
            throw r5     // Catch:{ Exception -> 0x0031 }
        L_0x010d:
            java.lang.String r4 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0031 }
            java.nio.ByteBuffer r5 = r1.f25302h     // Catch:{ Exception -> 0x0031 }
            int r5 = r5.limit()     // Catch:{ Exception -> 0x0031 }
            r6 = 35
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0031 }
            r7.<init>(r6)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r6 = "Precache abort at "
            r7.append(r6)     // Catch:{ Exception -> 0x0031 }
            r7.append(r5)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r5 = " bytes"
            r7.append(r5)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x0031 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0031 }
            throw r0     // Catch:{ Exception -> 0x0031 }
        L_0x0133:
            r0 = move-exception
            r18 = r4
        L_0x0136:
            monitor-exit(r14)     // Catch:{ all -> 0x013c }
            throw r0     // Catch:{ Exception -> 0x0138 }
        L_0x0138:
            r0 = move-exception
            r4 = r18
            goto L_0x0141
        L_0x013c:
            r0 = move-exception
            goto L_0x0136
        L_0x013e:
            r0 = move-exception
            r18 = r4
        L_0x0141:
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getCanonicalName()
            java.lang.String r0 = r0.getMessage()
            java.lang.String r6 = java.lang.String.valueOf(r5)
            int r6 = r6.length()
            r7 = 1
            int r6 = r6 + r7
            java.lang.String r7 = java.lang.String.valueOf(r0)
            int r7 = r7.length()
            int r6 = r6 + r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r6)
            r7.append(r5)
            java.lang.String r5 = ":"
            r7.append(r5)
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            java.lang.String r5 = java.lang.String.valueOf(r22)
            int r5 = r5.length()
            int r5 = r5 + 34
            java.lang.String r6 = java.lang.String.valueOf(r0)
            int r6 = r6.length()
            int r5 = r5 + r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "Failed to preload url "
            r6.append(r5)
            r6.append(r2)
            java.lang.String r5 = " Exception: "
            r6.append(r5)
            r6.append(r0)
            java.lang.String r5 = r6.toString()
            com.google.android.gms.internal.ads.zzbad.m26359d(r5)
            r1.mo30545a(r2, r3, r4, r0)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgg.mo30546a(java.lang.String):boolean");
    }

    /* renamed from: b */
    public final void mo30549b() {
        this.f25300f = true;
    }

    /* renamed from: c */
    public final ByteBuffer mo30557c() {
        synchronized (this.f25304j) {
            if (this.f25302h != null && !this.f25303i) {
                this.f25302h.flip();
                this.f25303i = true;
            }
            this.f25300f = true;
        }
        return this.f25302h;
    }
}
