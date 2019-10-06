package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Qs */
final class C9094Qs {

    /* renamed from: a */
    private int f21629a = 1000;

    /* renamed from: b */
    private int[] f21630b;

    /* renamed from: c */
    private long[] f21631c;

    /* renamed from: d */
    private int[] f21632d;

    /* renamed from: e */
    private int[] f21633e;

    /* renamed from: f */
    private long[] f21634f;

    /* renamed from: g */
    private zznx[] f21635g;

    /* renamed from: h */
    private zzlh[] f21636h;

    /* renamed from: i */
    private int f21637i;

    /* renamed from: j */
    private int f21638j;

    /* renamed from: k */
    private int f21639k;

    /* renamed from: l */
    private int f21640l;

    /* renamed from: m */
    private long f21641m;

    /* renamed from: n */
    private long f21642n;

    /* renamed from: o */
    private boolean f21643o;

    /* renamed from: p */
    private boolean f21644p;

    /* renamed from: q */
    private zzlh f21645q;

    public C9094Qs() {
        int i = this.f21629a;
        this.f21630b = new int[i];
        this.f21631c = new long[i];
        this.f21634f = new long[i];
        this.f21633e = new int[i];
        this.f21632d = new int[i];
        this.f21635g = new zznx[i];
        this.f21636h = new zzlh[i];
        this.f21641m = Long.MIN_VALUE;
        this.f21642n = Long.MIN_VALUE;
        this.f21644p = true;
        this.f21643o = true;
    }

    /* renamed from: b */
    public final void mo28556b() {
        this.f21638j = 0;
        this.f21639k = 0;
        this.f21640l = 0;
        this.f21637i = 0;
        this.f21643o = true;
    }

    /* renamed from: c */
    public final void mo28557c() {
        this.f21641m = Long.MIN_VALUE;
        this.f21642n = Long.MIN_VALUE;
    }

    /* renamed from: d */
    public final int mo28558d() {
        return this.f21638j + this.f21637i;
    }

    /* renamed from: e */
    public final synchronized boolean mo28559e() {
        return this.f21637i != 0;
    }

    /* renamed from: f */
    public final synchronized zzlh mo28560f() {
        return this.f21644p ? null : this.f21645q;
    }

    /* renamed from: a */
    public final synchronized long mo28551a() {
        return Math.max(this.f21641m, this.f21642n);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0023, code lost:
        return -3;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int mo28550a(com.google.android.gms.internal.ads.zzlj r5, com.google.android.gms.internal.ads.zznd r6, boolean r7, boolean r8, com.google.android.gms.internal.ads.zzlh r9, com.google.android.gms.internal.ads.zzqs r10) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.mo28559e()     // Catch:{ all -> 0x00a7 }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x0024
            if (r8 == 0) goto L_0x0012
            r5 = 4
            r6.mo32013a(r5)     // Catch:{ all -> 0x00a7 }
            monitor-exit(r4)
            return r3
        L_0x0012:
            com.google.android.gms.internal.ads.zzlh r6 = r4.f21645q     // Catch:{ all -> 0x00a7 }
            if (r6 == 0) goto L_0x0022
            if (r7 != 0) goto L_0x001c
            com.google.android.gms.internal.ads.zzlh r6 = r4.f21645q     // Catch:{ all -> 0x00a7 }
            if (r6 == r9) goto L_0x0022
        L_0x001c:
            com.google.android.gms.internal.ads.zzlh r6 = r4.f21645q     // Catch:{ all -> 0x00a7 }
            r5.f28805a = r6     // Catch:{ all -> 0x00a7 }
            monitor-exit(r4)
            return r1
        L_0x0022:
            monitor-exit(r4)
            return r2
        L_0x0024:
            if (r7 != 0) goto L_0x009d
            com.google.android.gms.internal.ads.zzlh[] r7 = r4.f21636h     // Catch:{ all -> 0x00a7 }
            int r8 = r4.f21639k     // Catch:{ all -> 0x00a7 }
            r7 = r7[r8]     // Catch:{ all -> 0x00a7 }
            if (r7 == r9) goto L_0x002f
            goto L_0x009d
        L_0x002f:
            java.nio.ByteBuffer r5 = r6.f28951c     // Catch:{ all -> 0x00a7 }
            r7 = 0
            r8 = 1
            if (r5 != 0) goto L_0x0038
            r5 = 1
            goto L_0x0039
        L_0x0038:
            r5 = 0
        L_0x0039:
            if (r5 == 0) goto L_0x003d
            monitor-exit(r4)
            return r2
        L_0x003d:
            long[] r5 = r4.f21634f     // Catch:{ all -> 0x00a7 }
            int r9 = r4.f21639k     // Catch:{ all -> 0x00a7 }
            r0 = r5[r9]     // Catch:{ all -> 0x00a7 }
            r6.f28952d = r0     // Catch:{ all -> 0x00a7 }
            int[] r5 = r4.f21633e     // Catch:{ all -> 0x00a7 }
            int r9 = r4.f21639k     // Catch:{ all -> 0x00a7 }
            r5 = r5[r9]     // Catch:{ all -> 0x00a7 }
            r6.mo32013a(r5)     // Catch:{ all -> 0x00a7 }
            int[] r5 = r4.f21632d     // Catch:{ all -> 0x00a7 }
            int r9 = r4.f21639k     // Catch:{ all -> 0x00a7 }
            r5 = r5[r9]     // Catch:{ all -> 0x00a7 }
            r10.f29172a = r5     // Catch:{ all -> 0x00a7 }
            long[] r5 = r4.f21631c     // Catch:{ all -> 0x00a7 }
            int r9 = r4.f21639k     // Catch:{ all -> 0x00a7 }
            r0 = r5[r9]     // Catch:{ all -> 0x00a7 }
            r10.f29173b = r0     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.internal.ads.zznx[] r5 = r4.f21635g     // Catch:{ all -> 0x00a7 }
            int r9 = r4.f21639k     // Catch:{ all -> 0x00a7 }
            r5 = r5[r9]     // Catch:{ all -> 0x00a7 }
            r10.f29175d = r5     // Catch:{ all -> 0x00a7 }
            long r0 = r4.f21641m     // Catch:{ all -> 0x00a7 }
            long r5 = r6.f28952d     // Catch:{ all -> 0x00a7 }
            long r5 = java.lang.Math.max(r0, r5)     // Catch:{ all -> 0x00a7 }
            r4.f21641m = r5     // Catch:{ all -> 0x00a7 }
            int r5 = r4.f21637i     // Catch:{ all -> 0x00a7 }
            int r5 = r5 - r8
            r4.f21637i = r5     // Catch:{ all -> 0x00a7 }
            int r5 = r4.f21639k     // Catch:{ all -> 0x00a7 }
            int r5 = r5 + r8
            r4.f21639k = r5     // Catch:{ all -> 0x00a7 }
            int r5 = r4.f21638j     // Catch:{ all -> 0x00a7 }
            int r5 = r5 + r8
            r4.f21638j = r5     // Catch:{ all -> 0x00a7 }
            int r5 = r4.f21639k     // Catch:{ all -> 0x00a7 }
            int r6 = r4.f21629a     // Catch:{ all -> 0x00a7 }
            if (r5 != r6) goto L_0x0087
            r4.f21639k = r7     // Catch:{ all -> 0x00a7 }
        L_0x0087:
            int r5 = r4.f21637i     // Catch:{ all -> 0x00a7 }
            if (r5 <= 0) goto L_0x0093
            long[] r5 = r4.f21631c     // Catch:{ all -> 0x00a7 }
            int r6 = r4.f21639k     // Catch:{ all -> 0x00a7 }
            r6 = r5[r6]     // Catch:{ all -> 0x00a7 }
            r5 = r6
            goto L_0x0099
        L_0x0093:
            long r5 = r10.f29173b     // Catch:{ all -> 0x00a7 }
            int r7 = r10.f29172a     // Catch:{ all -> 0x00a7 }
            long r7 = (long) r7     // Catch:{ all -> 0x00a7 }
            long r5 = r5 + r7
        L_0x0099:
            r10.f29174c = r5     // Catch:{ all -> 0x00a7 }
            monitor-exit(r4)
            return r3
        L_0x009d:
            com.google.android.gms.internal.ads.zzlh[] r6 = r4.f21636h     // Catch:{ all -> 0x00a7 }
            int r7 = r4.f21639k     // Catch:{ all -> 0x00a7 }
            r6 = r6[r7]     // Catch:{ all -> 0x00a7 }
            r5.f28805a = r6     // Catch:{ all -> 0x00a7 }
            monitor-exit(r4)
            return r1
        L_0x00a7:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9094Qs.mo28550a(com.google.android.gms.internal.ads.zzlj, com.google.android.gms.internal.ads.zznd, boolean, boolean, com.google.android.gms.internal.ads.zzlh, com.google.android.gms.internal.ads.zzqs):int");
    }

    /* renamed from: g */
    public final synchronized long mo28561g() {
        if (!mo28559e()) {
            return -1;
        }
        int i = ((this.f21639k + this.f21637i) - 1) % this.f21629a;
        this.f21639k = (this.f21639k + this.f21637i) % this.f21629a;
        this.f21638j += this.f21637i;
        this.f21637i = 0;
        return this.f21631c[i] + ((long) this.f21632d[i]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0061, code lost:
        return -1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long mo28552a(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.mo28559e()     // Catch:{ all -> 0x0062 }
            r1 = -1
            if (r0 == 0) goto L_0x0060
            long[] r0 = r8.f21634f     // Catch:{ all -> 0x0062 }
            int r3 = r8.f21639k     // Catch:{ all -> 0x0062 }
            r3 = r0[r3]     // Catch:{ all -> 0x0062 }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0014
            goto L_0x0060
        L_0x0014:
            long r3 = r8.f21642n     // Catch:{ all -> 0x0062 }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x001e
            if (r11 != 0) goto L_0x001e
            monitor-exit(r8)
            return r1
        L_0x001e:
            r11 = 0
            int r0 = r8.f21639k     // Catch:{ all -> 0x0062 }
            r3 = -1
            r11 = -1
            r4 = 0
        L_0x0025:
            int r5 = r8.f21640l     // Catch:{ all -> 0x0062 }
            if (r0 == r5) goto L_0x0042
            long[] r5 = r8.f21634f     // Catch:{ all -> 0x0062 }
            r6 = r5[r0]     // Catch:{ all -> 0x0062 }
            int r5 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x0042
            int[] r5 = r8.f21633e     // Catch:{ all -> 0x0062 }
            r5 = r5[r0]     // Catch:{ all -> 0x0062 }
            r5 = r5 & 1
            if (r5 == 0) goto L_0x003a
            r11 = r4
        L_0x003a:
            int r0 = r0 + 1
            int r5 = r8.f21629a     // Catch:{ all -> 0x0062 }
            int r0 = r0 % r5
            int r4 = r4 + 1
            goto L_0x0025
        L_0x0042:
            if (r11 != r3) goto L_0x0046
            monitor-exit(r8)
            return r1
        L_0x0046:
            int r9 = r8.f21639k     // Catch:{ all -> 0x0062 }
            int r9 = r9 + r11
            int r10 = r8.f21629a     // Catch:{ all -> 0x0062 }
            int r9 = r9 % r10
            r8.f21639k = r9     // Catch:{ all -> 0x0062 }
            int r9 = r8.f21638j     // Catch:{ all -> 0x0062 }
            int r9 = r9 + r11
            r8.f21638j = r9     // Catch:{ all -> 0x0062 }
            int r9 = r8.f21637i     // Catch:{ all -> 0x0062 }
            int r9 = r9 - r11
            r8.f21637i = r9     // Catch:{ all -> 0x0062 }
            long[] r9 = r8.f21631c     // Catch:{ all -> 0x0062 }
            int r10 = r8.f21639k     // Catch:{ all -> 0x0062 }
            r10 = r9[r10]     // Catch:{ all -> 0x0062 }
            monitor-exit(r8)
            return r10
        L_0x0060:
            monitor-exit(r8)
            return r1
        L_0x0062:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x0066
        L_0x0065:
            throw r9
        L_0x0066:
            goto L_0x0065
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9094Qs.mo28552a(long, boolean):long");
    }

    /* renamed from: a */
    public final synchronized boolean mo28555a(zzlh zzlh) {
        if (zzlh == null) {
            this.f21644p = true;
            return false;
        }
        this.f21644p = false;
        if (zzsy.m31153a((Object) zzlh, (Object) this.f21645q)) {
            return false;
        }
        this.f21645q = zzlh;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ea, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo28554a(long r6, int r8, long r9, int r11, com.google.android.gms.internal.ads.zznx r12) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.f21643o     // Catch:{ all -> 0x00eb }
            r1 = 0
            if (r0 == 0) goto L_0x000e
            r0 = r8 & 1
            if (r0 != 0) goto L_0x000c
            monitor-exit(r5)
            return
        L_0x000c:
            r5.f21643o = r1     // Catch:{ all -> 0x00eb }
        L_0x000e:
            boolean r0 = r5.f21644p     // Catch:{ all -> 0x00eb }
            r2 = 1
            if (r0 != 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            com.google.android.gms.internal.ads.zzsk.m31082b(r0)     // Catch:{ all -> 0x00eb }
            r5.mo28553a(r6)     // Catch:{ all -> 0x00eb }
            long[] r0 = r5.f21634f     // Catch:{ all -> 0x00eb }
            int r3 = r5.f21640l     // Catch:{ all -> 0x00eb }
            r0[r3] = r6     // Catch:{ all -> 0x00eb }
            long[] r6 = r5.f21631c     // Catch:{ all -> 0x00eb }
            int r7 = r5.f21640l     // Catch:{ all -> 0x00eb }
            r6[r7] = r9     // Catch:{ all -> 0x00eb }
            int[] r6 = r5.f21632d     // Catch:{ all -> 0x00eb }
            int r7 = r5.f21640l     // Catch:{ all -> 0x00eb }
            r6[r7] = r11     // Catch:{ all -> 0x00eb }
            int[] r6 = r5.f21633e     // Catch:{ all -> 0x00eb }
            int r7 = r5.f21640l     // Catch:{ all -> 0x00eb }
            r6[r7] = r8     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zznx[] r6 = r5.f21635g     // Catch:{ all -> 0x00eb }
            int r7 = r5.f21640l     // Catch:{ all -> 0x00eb }
            r6[r7] = r12     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzlh[] r6 = r5.f21636h     // Catch:{ all -> 0x00eb }
            int r7 = r5.f21640l     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzlh r8 = r5.f21645q     // Catch:{ all -> 0x00eb }
            r6[r7] = r8     // Catch:{ all -> 0x00eb }
            int[] r6 = r5.f21630b     // Catch:{ all -> 0x00eb }
            int r7 = r5.f21640l     // Catch:{ all -> 0x00eb }
            r6[r7] = r1     // Catch:{ all -> 0x00eb }
            int r6 = r5.f21637i     // Catch:{ all -> 0x00eb }
            int r6 = r6 + r2
            r5.f21637i = r6     // Catch:{ all -> 0x00eb }
            int r6 = r5.f21637i     // Catch:{ all -> 0x00eb }
            int r7 = r5.f21629a     // Catch:{ all -> 0x00eb }
            if (r6 != r7) goto L_0x00dc
            int r6 = r5.f21629a     // Catch:{ all -> 0x00eb }
            int r6 = r6 + 1000
            int[] r7 = new int[r6]     // Catch:{ all -> 0x00eb }
            long[] r8 = new long[r6]     // Catch:{ all -> 0x00eb }
            long[] r9 = new long[r6]     // Catch:{ all -> 0x00eb }
            int[] r10 = new int[r6]     // Catch:{ all -> 0x00eb }
            int[] r11 = new int[r6]     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zznx[] r12 = new com.google.android.gms.internal.ads.zznx[r6]     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzlh[] r0 = new com.google.android.gms.internal.ads.zzlh[r6]     // Catch:{ all -> 0x00eb }
            int r2 = r5.f21629a     // Catch:{ all -> 0x00eb }
            int r3 = r5.f21639k     // Catch:{ all -> 0x00eb }
            int r2 = r2 - r3
            long[] r3 = r5.f21631c     // Catch:{ all -> 0x00eb }
            int r4 = r5.f21639k     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r8, r1, r2)     // Catch:{ all -> 0x00eb }
            long[] r3 = r5.f21634f     // Catch:{ all -> 0x00eb }
            int r4 = r5.f21639k     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r9, r1, r2)     // Catch:{ all -> 0x00eb }
            int[] r3 = r5.f21633e     // Catch:{ all -> 0x00eb }
            int r4 = r5.f21639k     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r10, r1, r2)     // Catch:{ all -> 0x00eb }
            int[] r3 = r5.f21632d     // Catch:{ all -> 0x00eb }
            int r4 = r5.f21639k     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r11, r1, r2)     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zznx[] r3 = r5.f21635g     // Catch:{ all -> 0x00eb }
            int r4 = r5.f21639k     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r12, r1, r2)     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzlh[] r3 = r5.f21636h     // Catch:{ all -> 0x00eb }
            int r4 = r5.f21639k     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r0, r1, r2)     // Catch:{ all -> 0x00eb }
            int[] r3 = r5.f21630b     // Catch:{ all -> 0x00eb }
            int r4 = r5.f21639k     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r7, r1, r2)     // Catch:{ all -> 0x00eb }
            int r3 = r5.f21639k     // Catch:{ all -> 0x00eb }
            long[] r4 = r5.f21631c     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r8, r2, r3)     // Catch:{ all -> 0x00eb }
            long[] r4 = r5.f21634f     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r9, r2, r3)     // Catch:{ all -> 0x00eb }
            int[] r4 = r5.f21633e     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r10, r2, r3)     // Catch:{ all -> 0x00eb }
            int[] r4 = r5.f21632d     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r11, r2, r3)     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zznx[] r4 = r5.f21635g     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r12, r2, r3)     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzlh[] r4 = r5.f21636h     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r0, r2, r3)     // Catch:{ all -> 0x00eb }
            int[] r4 = r5.f21630b     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r7, r2, r3)     // Catch:{ all -> 0x00eb }
            r5.f21631c = r8     // Catch:{ all -> 0x00eb }
            r5.f21634f = r9     // Catch:{ all -> 0x00eb }
            r5.f21633e = r10     // Catch:{ all -> 0x00eb }
            r5.f21632d = r11     // Catch:{ all -> 0x00eb }
            r5.f21635g = r12     // Catch:{ all -> 0x00eb }
            r5.f21636h = r0     // Catch:{ all -> 0x00eb }
            r5.f21630b = r7     // Catch:{ all -> 0x00eb }
            r5.f21639k = r1     // Catch:{ all -> 0x00eb }
            int r7 = r5.f21629a     // Catch:{ all -> 0x00eb }
            r5.f21640l = r7     // Catch:{ all -> 0x00eb }
            int r7 = r5.f21629a     // Catch:{ all -> 0x00eb }
            r5.f21637i = r7     // Catch:{ all -> 0x00eb }
            r5.f21629a = r6     // Catch:{ all -> 0x00eb }
            monitor-exit(r5)
            return
        L_0x00dc:
            int r6 = r5.f21640l     // Catch:{ all -> 0x00eb }
            int r6 = r6 + r2
            r5.f21640l = r6     // Catch:{ all -> 0x00eb }
            int r6 = r5.f21640l     // Catch:{ all -> 0x00eb }
            int r7 = r5.f21629a     // Catch:{ all -> 0x00eb }
            if (r6 != r7) goto L_0x00e9
            r5.f21640l = r1     // Catch:{ all -> 0x00eb }
        L_0x00e9:
            monitor-exit(r5)
            return
        L_0x00eb:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9094Qs.mo28554a(long, int, long, int, com.google.android.gms.internal.ads.zznx):void");
    }

    /* renamed from: a */
    public final synchronized void mo28553a(long j) {
        this.f21642n = Math.max(this.f21642n, j);
    }
}
