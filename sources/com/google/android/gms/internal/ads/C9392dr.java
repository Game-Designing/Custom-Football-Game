package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.dr */
final class C9392dr {

    /* renamed from: a */
    private int f22189a = 1000;

    /* renamed from: b */
    private long[] f22190b;

    /* renamed from: c */
    private int[] f22191c;

    /* renamed from: d */
    private int[] f22192d;

    /* renamed from: e */
    private long[] f22193e;

    /* renamed from: f */
    private byte[][] f22194f;

    /* renamed from: g */
    private int f22195g;

    /* renamed from: h */
    private int f22196h;

    /* renamed from: i */
    private int f22197i;

    /* renamed from: j */
    private int f22198j;

    public C9392dr() {
        int i = this.f22189a;
        this.f22190b = new long[i];
        this.f22193e = new long[i];
        this.f22192d = new int[i];
        this.f22191c = new int[i];
        this.f22194f = new byte[i][];
    }

    /* renamed from: a */
    public final void mo28915a() {
        this.f22196h = 0;
        this.f22197i = 0;
        this.f22198j = 0;
        this.f22195g = 0;
    }

    /* renamed from: a */
    public final synchronized boolean mo28917a(zzhm zzhm, C9414er erVar) {
        if (this.f22195g == 0) {
            return false;
        }
        zzhm.f28528e = this.f22193e[this.f22197i];
        zzhm.f28526c = this.f22191c[this.f22197i];
        zzhm.f28527d = this.f22192d[this.f22197i];
        erVar.f22225a = this.f22190b[this.f22197i];
        erVar.f22226b = this.f22194f[this.f22197i];
        return true;
    }

    /* renamed from: b */
    public final synchronized long mo28918b() {
        this.f22195g--;
        int i = this.f22197i;
        this.f22197i = i + 1;
        this.f22196h++;
        if (this.f22197i == this.f22189a) {
            this.f22197i = 0;
        }
        if (this.f22195g > 0) {
            return this.f22190b[this.f22197i];
        }
        return ((long) this.f22191c[i]) + this.f22190b[i];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006a, code lost:
        return -1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long mo28914a(long r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            int r0 = r9.f22195g     // Catch:{ all -> 0x006b }
            r1 = -1
            if (r0 == 0) goto L_0x0069
            long[] r0 = r9.f22193e     // Catch:{ all -> 0x006b }
            int r3 = r9.f22197i     // Catch:{ all -> 0x006b }
            r3 = r0[r3]     // Catch:{ all -> 0x006b }
            int r0 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0012
            goto L_0x0069
        L_0x0012:
            int r0 = r9.f22198j     // Catch:{ all -> 0x006b }
            if (r0 != 0) goto L_0x0019
            int r0 = r9.f22189a     // Catch:{ all -> 0x006b }
            goto L_0x001b
        L_0x0019:
            int r0 = r9.f22198j     // Catch:{ all -> 0x006b }
        L_0x001b:
            int r0 = r0 + -1
            long[] r3 = r9.f22193e     // Catch:{ all -> 0x006b }
            r4 = r3[r0]     // Catch:{ all -> 0x006b }
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0027
            monitor-exit(r9)
            return r1
        L_0x0027:
            r0 = 0
            int r3 = r9.f22197i     // Catch:{ all -> 0x006b }
            r4 = -1
            r0 = -1
            r5 = 0
        L_0x002e:
            int r6 = r9.f22198j     // Catch:{ all -> 0x006b }
            if (r3 == r6) goto L_0x004b
            long[] r6 = r9.f22193e     // Catch:{ all -> 0x006b }
            r7 = r6[r3]     // Catch:{ all -> 0x006b }
            int r6 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r6 > 0) goto L_0x004b
            int[] r6 = r9.f22192d     // Catch:{ all -> 0x006b }
            r6 = r6[r3]     // Catch:{ all -> 0x006b }
            r6 = r6 & 1
            if (r6 == 0) goto L_0x0043
            r0 = r5
        L_0x0043:
            int r3 = r3 + 1
            int r6 = r9.f22189a     // Catch:{ all -> 0x006b }
            int r3 = r3 % r6
            int r5 = r5 + 1
            goto L_0x002e
        L_0x004b:
            if (r0 != r4) goto L_0x004f
            monitor-exit(r9)
            return r1
        L_0x004f:
            int r10 = r9.f22195g     // Catch:{ all -> 0x006b }
            int r10 = r10 - r0
            r9.f22195g = r10     // Catch:{ all -> 0x006b }
            int r10 = r9.f22197i     // Catch:{ all -> 0x006b }
            int r10 = r10 + r0
            int r11 = r9.f22189a     // Catch:{ all -> 0x006b }
            int r10 = r10 % r11
            r9.f22197i = r10     // Catch:{ all -> 0x006b }
            int r10 = r9.f22196h     // Catch:{ all -> 0x006b }
            int r10 = r10 + r0
            r9.f22196h = r10     // Catch:{ all -> 0x006b }
            long[] r10 = r9.f22190b     // Catch:{ all -> 0x006b }
            int r11 = r9.f22197i     // Catch:{ all -> 0x006b }
            r0 = r10[r11]     // Catch:{ all -> 0x006b }
            monitor-exit(r9)
            return r0
        L_0x0069:
            monitor-exit(r9)
            return r1
        L_0x006b:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x006f
        L_0x006e:
            throw r10
        L_0x006f:
            goto L_0x006e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9392dr.mo28914a(long):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00a4, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo28916a(long r4, int r6, long r7, int r9, byte[] r10) {
        /*
            r3 = this;
            monitor-enter(r3)
            long[] r0 = r3.f22193e     // Catch:{ all -> 0x00a5 }
            int r1 = r3.f22198j     // Catch:{ all -> 0x00a5 }
            r0[r1] = r4     // Catch:{ all -> 0x00a5 }
            long[] r4 = r3.f22190b     // Catch:{ all -> 0x00a5 }
            int r5 = r3.f22198j     // Catch:{ all -> 0x00a5 }
            r4[r5] = r7     // Catch:{ all -> 0x00a5 }
            int[] r4 = r3.f22191c     // Catch:{ all -> 0x00a5 }
            int r5 = r3.f22198j     // Catch:{ all -> 0x00a5 }
            r4[r5] = r9     // Catch:{ all -> 0x00a5 }
            int[] r4 = r3.f22192d     // Catch:{ all -> 0x00a5 }
            int r5 = r3.f22198j     // Catch:{ all -> 0x00a5 }
            r4[r5] = r6     // Catch:{ all -> 0x00a5 }
            byte[][] r4 = r3.f22194f     // Catch:{ all -> 0x00a5 }
            int r5 = r3.f22198j     // Catch:{ all -> 0x00a5 }
            r4[r5] = r10     // Catch:{ all -> 0x00a5 }
            int r4 = r3.f22195g     // Catch:{ all -> 0x00a5 }
            int r4 = r4 + 1
            r3.f22195g = r4     // Catch:{ all -> 0x00a5 }
            int r4 = r3.f22195g     // Catch:{ all -> 0x00a5 }
            int r5 = r3.f22189a     // Catch:{ all -> 0x00a5 }
            r6 = 0
            if (r4 != r5) goto L_0x0095
            int r4 = r3.f22189a     // Catch:{ all -> 0x00a5 }
            int r4 = r4 + 1000
            long[] r5 = new long[r4]     // Catch:{ all -> 0x00a5 }
            long[] r7 = new long[r4]     // Catch:{ all -> 0x00a5 }
            int[] r8 = new int[r4]     // Catch:{ all -> 0x00a5 }
            int[] r9 = new int[r4]     // Catch:{ all -> 0x00a5 }
            byte[][] r10 = new byte[r4][]     // Catch:{ all -> 0x00a5 }
            int r0 = r3.f22189a     // Catch:{ all -> 0x00a5 }
            int r1 = r3.f22197i     // Catch:{ all -> 0x00a5 }
            int r0 = r0 - r1
            long[] r1 = r3.f22190b     // Catch:{ all -> 0x00a5 }
            int r2 = r3.f22197i     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r1, r2, r5, r6, r0)     // Catch:{ all -> 0x00a5 }
            long[] r1 = r3.f22193e     // Catch:{ all -> 0x00a5 }
            int r2 = r3.f22197i     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r1, r2, r7, r6, r0)     // Catch:{ all -> 0x00a5 }
            int[] r1 = r3.f22192d     // Catch:{ all -> 0x00a5 }
            int r2 = r3.f22197i     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r1, r2, r8, r6, r0)     // Catch:{ all -> 0x00a5 }
            int[] r1 = r3.f22191c     // Catch:{ all -> 0x00a5 }
            int r2 = r3.f22197i     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r1, r2, r9, r6, r0)     // Catch:{ all -> 0x00a5 }
            byte[][] r1 = r3.f22194f     // Catch:{ all -> 0x00a5 }
            int r2 = r3.f22197i     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r1, r2, r10, r6, r0)     // Catch:{ all -> 0x00a5 }
            int r1 = r3.f22197i     // Catch:{ all -> 0x00a5 }
            long[] r2 = r3.f22190b     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r2, r6, r5, r0, r1)     // Catch:{ all -> 0x00a5 }
            long[] r2 = r3.f22193e     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r2, r6, r7, r0, r1)     // Catch:{ all -> 0x00a5 }
            int[] r2 = r3.f22192d     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r2, r6, r8, r0, r1)     // Catch:{ all -> 0x00a5 }
            int[] r2 = r3.f22191c     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r2, r6, r9, r0, r1)     // Catch:{ all -> 0x00a5 }
            byte[][] r2 = r3.f22194f     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r2, r6, r10, r0, r1)     // Catch:{ all -> 0x00a5 }
            r3.f22190b = r5     // Catch:{ all -> 0x00a5 }
            r3.f22193e = r7     // Catch:{ all -> 0x00a5 }
            r3.f22192d = r8     // Catch:{ all -> 0x00a5 }
            r3.f22191c = r9     // Catch:{ all -> 0x00a5 }
            r3.f22194f = r10     // Catch:{ all -> 0x00a5 }
            r3.f22197i = r6     // Catch:{ all -> 0x00a5 }
            int r5 = r3.f22189a     // Catch:{ all -> 0x00a5 }
            r3.f22198j = r5     // Catch:{ all -> 0x00a5 }
            int r5 = r3.f22189a     // Catch:{ all -> 0x00a5 }
            r3.f22195g = r5     // Catch:{ all -> 0x00a5 }
            r3.f22189a = r4     // Catch:{ all -> 0x00a5 }
            monitor-exit(r3)
            return
        L_0x0095:
            int r4 = r3.f22198j     // Catch:{ all -> 0x00a5 }
            int r4 = r4 + 1
            r3.f22198j = r4     // Catch:{ all -> 0x00a5 }
            int r4 = r3.f22198j     // Catch:{ all -> 0x00a5 }
            int r5 = r3.f22189a     // Catch:{ all -> 0x00a5 }
            if (r4 != r5) goto L_0x00a3
            r3.f22198j = r6     // Catch:{ all -> 0x00a5 }
        L_0x00a3:
            monitor-exit(r3)
            return
        L_0x00a5:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9392dr.mo28916a(long, int, long, int, byte[]):void");
    }
}
