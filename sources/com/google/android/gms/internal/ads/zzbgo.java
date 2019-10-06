package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

@zzard
public final class zzbgo extends zzbft implements zzsj<zzrv> {

    /* renamed from: d */
    private String f25311d;

    /* renamed from: e */
    private final zzbde f25312e;

    /* renamed from: f */
    private boolean f25313f;

    /* renamed from: g */
    private final C8891He f25314g = new C8891He();

    /* renamed from: h */
    private final zzbfl f25315h = new zzbfl();

    /* renamed from: i */
    private ByteBuffer f25316i;

    /* renamed from: j */
    private boolean f25317j;

    /* renamed from: k */
    private final Object f25318k = new Object();

    /* renamed from: l */
    private boolean f25319l;

    public zzbgo(zzbdf zzbdf, zzbde zzbde) {
        super(zzbdf);
        this.f25312e = zzbde;
    }

    /* renamed from: d */
    public final String mo30566d() {
        return this.f25311d;
    }

    /* renamed from: e */
    public final boolean mo30567e() {
        return this.f25319l;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final String mo30548b(String str) {
        String valueOf = String.valueOf("cache:");
        String valueOf2 = String.valueOf(super.mo30548b(str));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* renamed from: f */
    private final void m26762f() {
        int a = (int) this.f25314g.mo28310a();
        int a2 = (int) this.f25315h.mo30534a(this.f25316i);
        int position = this.f25316i.position();
        int round = Math.round(((float) a2) * (((float) position) / ((float) a)));
        boolean z = round > 0;
        int d = zzbfa.m26660d();
        int e = zzbfa.m26661e();
        String str = this.f25311d;
        mo30540a(str, mo30548b(str), position, a, (long) round, (long) a2, z, d, e);
    }

    /* JADX WARNING: type inference failed for: r1v31, types: [com.google.android.gms.internal.ads.zzbex] */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r9.f25319l = true;
        mo30542a(r10, r11, (long) ((int) r9.f25315h.mo30534a(r9.f25316i)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c5, code lost:
        if (r9.f25316i.remaining() > 0) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c7, code lost:
        m26762f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00cf, code lost:
        if (r9.f25313f != false) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d1, code lost:
        r12 = r1.mo27935b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d9, code lost:
        if ((r12 - r16) < r4) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00db, code lost:
        m26762f();
        r16 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e7, code lost:
        if ((r12 - r2) > (1000 * r6)) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ef, code lost:
        r12 = "downloadTimeout";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r1 = new java.lang.StringBuilder(49);
        r1.append("Timeout exceeded. Limit: ");
        r1.append(r6);
        r1.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x010e, code lost:
        throw new java.io.IOException(r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010f, code lost:
        r12 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r1 = r9.f25316i.limit();
        r3 = new java.lang.StringBuilder(35);
        r3.append("Precache abort at ");
        r3.append(r1);
        r3.append(" bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0134, code lost:
        throw new java.io.IOException(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x013a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x013b, code lost:
        r12 = r18;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo30546a(java.lang.String r22) {
        /*
            r21 = this;
            r9 = r21
            r10 = r22
            r9.f25311d = r10
            java.lang.String r11 = r21.mo30548b(r22)
            java.lang.String r12 = "error"
            r13 = 0
            com.google.android.gms.internal.ads.zzsa r0 = new com.google.android.gms.internal.ads.zzsa     // Catch:{ Exception -> 0x0140 }
            java.lang.String r2 = r9.f25278b     // Catch:{ Exception -> 0x0140 }
            r3 = 0
            com.google.android.gms.internal.ads.zzbde r1 = r9.f25312e     // Catch:{ Exception -> 0x0140 }
            int r5 = r1.f25150d     // Catch:{ Exception -> 0x0140 }
            com.google.android.gms.internal.ads.zzbde r1 = r9.f25312e     // Catch:{ Exception -> 0x0140 }
            int r6 = r1.f25152f     // Catch:{ Exception -> 0x0140 }
            r7 = 1
            r8 = 0
            r1 = r0
            r4 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0140 }
            com.google.android.gms.internal.ads.zzbde r1 = r9.f25312e     // Catch:{ Exception -> 0x0140 }
            boolean r1 = r1.f25156j     // Catch:{ Exception -> 0x0140 }
            if (r1 == 0) goto L_0x0036
            com.google.android.gms.internal.ads.zzbex r1 = new com.google.android.gms.internal.ads.zzbex     // Catch:{ Exception -> 0x0033 }
            android.content.Context r2 = r9.f25277a     // Catch:{ Exception -> 0x0033 }
            r3 = 0
            r1.<init>(r2, r0, r3, r3)     // Catch:{ Exception -> 0x0033 }
            r0 = r1
            goto L_0x0037
        L_0x0033:
            r0 = move-exception
            goto L_0x0143
        L_0x0036:
        L_0x0037:
            android.net.Uri r1 = android.net.Uri.parse(r22)     // Catch:{ Exception -> 0x0140 }
            com.google.android.gms.internal.ads.zzry r2 = new com.google.android.gms.internal.ads.zzry     // Catch:{ Exception -> 0x0140 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0140 }
            r0.mo29017a(r2)     // Catch:{ Exception -> 0x0140 }
            java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzbdf> r1 = r9.f25279c     // Catch:{ Exception -> 0x0140 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x0140 }
            com.google.android.gms.internal.ads.zzbdf r1 = (com.google.android.gms.internal.ads.zzbdf) r1     // Catch:{ Exception -> 0x0140 }
            if (r1 == 0) goto L_0x0051
            r1.mo28727a(r11, r9)     // Catch:{ Exception -> 0x0033 }
        L_0x0051:
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzk.zzln()     // Catch:{ Exception -> 0x0140 }
            long r2 = r1.mo27935b()     // Catch:{ Exception -> 0x0140 }
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r4 = com.google.android.gms.internal.ads.zzacu.f23926F     // Catch:{ Exception -> 0x0140 }
            com.google.android.gms.internal.ads.zzacr r5 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ Exception -> 0x0140 }
            java.lang.Object r4 = r5.mo29599a(r4)     // Catch:{ Exception -> 0x0140 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x0140 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x0140 }
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzacu.f23920E     // Catch:{ Exception -> 0x0140 }
            com.google.android.gms.internal.ads.zzacr r7 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ Exception -> 0x0140 }
            java.lang.Object r6 = r7.mo29599a(r6)     // Catch:{ Exception -> 0x0140 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ Exception -> 0x0140 }
            long r6 = r6.longValue()     // Catch:{ Exception -> 0x0140 }
            com.google.android.gms.internal.ads.zzbde r8 = r9.f25312e     // Catch:{ Exception -> 0x0140 }
            int r8 = r8.f25149c     // Catch:{ Exception -> 0x0140 }
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocate(r8)     // Catch:{ Exception -> 0x0140 }
            r9.f25316i = r8     // Catch:{ Exception -> 0x0140 }
            r8 = 8192(0x2000, float:1.14794E-41)
            byte[] r15 = new byte[r8]     // Catch:{ Exception -> 0x0140 }
            r16 = r2
        L_0x008a:
            java.nio.ByteBuffer r14 = r9.f25316i     // Catch:{ Exception -> 0x0140 }
            int r14 = r14.remaining()     // Catch:{ Exception -> 0x0140 }
            int r14 = java.lang.Math.min(r14, r8)     // Catch:{ Exception -> 0x0140 }
            int r14 = r0.read(r15, r13, r14)     // Catch:{ Exception -> 0x0140 }
            r8 = -1
            if (r14 != r8) goto L_0x00ac
            r1 = 1
            r9.f25319l = r1     // Catch:{ Exception -> 0x0033 }
            com.google.android.gms.internal.ads.zzbfl r0 = r9.f25315h     // Catch:{ Exception -> 0x0033 }
            java.nio.ByteBuffer r1 = r9.f25316i     // Catch:{ Exception -> 0x0033 }
            long r0 = r0.mo30534a(r1)     // Catch:{ Exception -> 0x0033 }
            int r1 = (int) r0     // Catch:{ Exception -> 0x0033 }
            long r0 = (long) r1     // Catch:{ Exception -> 0x0033 }
            r9.mo30542a(r10, r11, r0)     // Catch:{ Exception -> 0x0033 }
            goto L_0x00cb
        L_0x00ac:
            java.lang.Object r8 = r9.f25318k     // Catch:{ Exception -> 0x0140 }
            monitor-enter(r8)     // Catch:{ Exception -> 0x0140 }
            boolean r13 = r9.f25313f     // Catch:{ all -> 0x0135 }
            if (r13 != 0) goto L_0x00bc
            java.nio.ByteBuffer r13 = r9.f25316i     // Catch:{ all -> 0x0135 }
            r18 = r12
            r12 = 0
            r13.put(r15, r12, r14)     // Catch:{ all -> 0x013e }
            goto L_0x00be
        L_0x00bc:
            r18 = r12
        L_0x00be:
            monitor-exit(r8)     // Catch:{ all -> 0x013e }
            java.nio.ByteBuffer r8 = r9.f25316i     // Catch:{ Exception -> 0x013a }
            int r8 = r8.remaining()     // Catch:{ Exception -> 0x013a }
            if (r8 > 0) goto L_0x00cd
            r21.m26762f()     // Catch:{ Exception -> 0x013a }
        L_0x00cb:
            r1 = 1
            return r1
        L_0x00cd:
            boolean r8 = r9.f25313f     // Catch:{ Exception -> 0x013a }
            if (r8 != 0) goto L_0x010f
            long r12 = r1.mo27935b()     // Catch:{ Exception -> 0x013a }
            long r19 = r12 - r16
            int r8 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x00e0
            r21.m26762f()     // Catch:{ Exception -> 0x013a }
            r16 = r12
        L_0x00e0:
            long r12 = r12 - r2
            r19 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 * r6
            int r8 = (r12 > r19 ? 1 : (r12 == r19 ? 0 : -1))
            if (r8 > 0) goto L_0x00ef
            r12 = r18
            r8 = 8192(0x2000, float:1.14794E-41)
            r13 = 0
            goto L_0x008a
        L_0x00ef:
            java.lang.String r12 = "downloadTimeout"
            r0 = 49
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0033 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0033 }
            java.lang.String r0 = "Timeout exceeded. Limit: "
            r1.append(r0)     // Catch:{ Exception -> 0x0033 }
            r1.append(r6)     // Catch:{ Exception -> 0x0033 }
            java.lang.String r0 = " sec"
            r1.append(r0)     // Catch:{ Exception -> 0x0033 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0033 }
            java.io.IOException r1 = new java.io.IOException     // Catch:{ Exception -> 0x0033 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0033 }
            throw r1     // Catch:{ Exception -> 0x0033 }
        L_0x010f:
            java.lang.String r12 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0033 }
            java.nio.ByteBuffer r1 = r9.f25316i     // Catch:{ Exception -> 0x0033 }
            int r1 = r1.limit()     // Catch:{ Exception -> 0x0033 }
            r2 = 35
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0033 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0033 }
            java.lang.String r2 = "Precache abort at "
            r3.append(r2)     // Catch:{ Exception -> 0x0033 }
            r3.append(r1)     // Catch:{ Exception -> 0x0033 }
            java.lang.String r1 = " bytes"
            r3.append(r1)     // Catch:{ Exception -> 0x0033 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0033 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0033 }
            throw r0     // Catch:{ Exception -> 0x0033 }
        L_0x0135:
            r0 = move-exception
            r18 = r12
        L_0x0138:
            monitor-exit(r8)     // Catch:{ all -> 0x013e }
            throw r0     // Catch:{ Exception -> 0x013a }
        L_0x013a:
            r0 = move-exception
            r12 = r18
            goto L_0x0143
        L_0x013e:
            r0 = move-exception
            goto L_0x0138
        L_0x0140:
            r0 = move-exception
            r18 = r12
        L_0x0143:
            java.lang.Class r1 = r0.getClass()
            java.lang.String r1 = r1.getCanonicalName()
            java.lang.String r0 = r0.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            r3 = 1
            int r2 = r2 + r3
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r1)
            java.lang.String r1 = ":"
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = java.lang.String.valueOf(r22)
            int r1 = r1.length()
            int r1 = r1 + 34
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Failed to preload url "
            r2.append(r1)
            r2.append(r10)
            java.lang.String r1 = " Exception: "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzbad.m26359d(r1)
            r9.mo30545a(r10, r11, r12, r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgo.mo30546a(java.lang.String):boolean");
    }

    /* renamed from: b */
    public final void mo30549b() {
        this.f25313f = true;
    }

    /* renamed from: c */
    public final ByteBuffer mo30565c() {
        synchronized (this.f25318k) {
            if (this.f25316i != null && !this.f25317j) {
                this.f25316i.flip();
                this.f25317j = true;
            }
            this.f25313f = true;
        }
        return this.f25316i;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo30517a(Object obj) {
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo30518a(Object obj, int i) {
    }

    /* renamed from: a */
    public final /* synthetic */ void mo30519a(Object obj, zzry zzry) {
        zzrv zzrv = (zzrv) obj;
        if (zzrv instanceof zzsa) {
            this.f25314g.mo28311a((zzsa) zzrv);
        }
    }
}
