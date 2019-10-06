package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p183b.C8272q.C8273a;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;

/* renamed from: com.google.android.exoplayer2.source.t */
/* compiled from: SampleMetadataQueue */
final class C8403t {

    /* renamed from: a */
    private int f18312a = 1000;

    /* renamed from: b */
    private int[] f18313b;

    /* renamed from: c */
    private long[] f18314c;

    /* renamed from: d */
    private int[] f18315d;

    /* renamed from: e */
    private int[] f18316e;

    /* renamed from: f */
    private long[] f18317f;

    /* renamed from: g */
    private C8273a[] f18318g;

    /* renamed from: h */
    private Format[] f18319h;

    /* renamed from: i */
    private int f18320i;

    /* renamed from: j */
    private int f18321j;

    /* renamed from: k */
    private int f18322k;

    /* renamed from: l */
    private int f18323l;

    /* renamed from: m */
    private long f18324m;

    /* renamed from: n */
    private long f18325n;

    /* renamed from: o */
    private boolean f18326o;

    /* renamed from: p */
    private boolean f18327p;

    /* renamed from: q */
    private boolean f18328q;

    /* renamed from: r */
    private Format f18329r;

    /* renamed from: s */
    private int f18330s;

    /* renamed from: com.google.android.exoplayer2.source.t$a */
    /* compiled from: SampleMetadataQueue */
    public static final class C8404a {

        /* renamed from: a */
        public int f18331a;

        /* renamed from: b */
        public long f18332b;

        /* renamed from: c */
        public C8273a f18333c;
    }

    public C8403t() {
        int i = this.f18312a;
        this.f18313b = new int[i];
        this.f18314c = new long[i];
        this.f18317f = new long[i];
        this.f18316e = new int[i];
        this.f18315d = new int[i];
        this.f18318g = new C8273a[i];
        this.f18319h = new Format[i];
        this.f18324m = Long.MIN_VALUE;
        this.f18325n = Long.MIN_VALUE;
        this.f18328q = true;
        this.f18327p = true;
    }

    /* renamed from: a */
    public void mo25762a(boolean resetUpstreamFormat) {
        this.f18320i = 0;
        this.f18321j = 0;
        this.f18322k = 0;
        this.f18323l = 0;
        this.f18327p = true;
        this.f18324m = Long.MIN_VALUE;
        this.f18325n = Long.MIN_VALUE;
        this.f18326o = false;
        if (resetUpstreamFormat) {
            this.f18329r = null;
            this.f18328q = true;
        }
    }

    /* renamed from: f */
    public int mo25770f() {
        return this.f18321j + this.f18320i;
    }

    /* renamed from: a */
    public long mo25760a(int discardFromIndex) {
        int discardCount = mo25770f() - discardFromIndex;
        boolean z = false;
        C8514e.m20488a(discardCount >= 0 && discardCount <= this.f18320i - this.f18323l);
        this.f18320i -= discardCount;
        this.f18325n = Math.max(this.f18324m, m19937c(this.f18320i));
        if (discardCount == 0 && this.f18326o) {
            z = true;
        }
        this.f18326o = z;
        int i = this.f18320i;
        if (i == 0) {
            return 0;
        }
        int relativeLastWriteIndex = m19938d(i - 1);
        return this.f18314c[relativeLastWriteIndex] + ((long) this.f18315d[relativeLastWriteIndex]);
    }

    /* renamed from: d */
    public int mo25768d() {
        return this.f18321j + this.f18323l;
    }

    /* renamed from: g */
    public synchronized boolean mo25771g() {
        return this.f18323l != this.f18320i;
    }

    /* renamed from: e */
    public synchronized Format mo25769e() {
        return this.f18328q ? null : this.f18329r;
    }

    /* renamed from: c */
    public synchronized long mo25767c() {
        return this.f18325n;
    }

    /* renamed from: h */
    public synchronized boolean mo25772h() {
        return this.f18326o;
    }

    /* renamed from: i */
    public synchronized void mo25773i() {
        this.f18323l = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0022, code lost:
        return -3;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int mo25759a(com.google.android.exoplayer2.C8362o r7, com.google.android.exoplayer2.p182a.C8107e r8, boolean r9, boolean r10, com.google.android.exoplayer2.Format r11, com.google.android.exoplayer2.source.C8403t.C8404a r12) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.mo25771g()     // Catch:{ all -> 0x006f }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x0029
            if (r10 != 0) goto L_0x0023
            boolean r0 = r6.f18326o     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x0011
            goto L_0x0023
        L_0x0011:
            com.google.android.exoplayer2.Format r0 = r6.f18329r     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x0021
            if (r9 != 0) goto L_0x001b
            com.google.android.exoplayer2.Format r0 = r6.f18329r     // Catch:{ all -> 0x006f }
            if (r0 == r11) goto L_0x0021
        L_0x001b:
            com.google.android.exoplayer2.Format r0 = r6.f18329r     // Catch:{ all -> 0x006f }
            r7.f18117a = r0     // Catch:{ all -> 0x006f }
            monitor-exit(r6)
            return r1
        L_0x0021:
            monitor-exit(r6)
            return r2
        L_0x0023:
            r0 = 4
            r8.mo25024c(r0)     // Catch:{ all -> 0x006f }
            monitor-exit(r6)
            return r3
        L_0x0029:
            int r0 = r6.f18323l     // Catch:{ all -> 0x006f }
            int r0 = r6.m19938d(r0)     // Catch:{ all -> 0x006f }
            if (r9 != 0) goto L_0x0067
            com.google.android.exoplayer2.Format[] r4 = r6.f18319h     // Catch:{ all -> 0x006f }
            r4 = r4[r0]     // Catch:{ all -> 0x006f }
            if (r4 == r11) goto L_0x0038
            goto L_0x0067
        L_0x0038:
            boolean r1 = r8.mo25033g()     // Catch:{ all -> 0x006f }
            if (r1 == 0) goto L_0x0040
            monitor-exit(r6)
            return r2
        L_0x0040:
            long[] r1 = r6.f18317f     // Catch:{ all -> 0x006f }
            r4 = r1[r0]     // Catch:{ all -> 0x006f }
            r8.f16556d = r4     // Catch:{ all -> 0x006f }
            int[] r1 = r6.f18316e     // Catch:{ all -> 0x006f }
            r1 = r1[r0]     // Catch:{ all -> 0x006f }
            r8.mo25024c(r1)     // Catch:{ all -> 0x006f }
            int[] r1 = r6.f18315d     // Catch:{ all -> 0x006f }
            r1 = r1[r0]     // Catch:{ all -> 0x006f }
            r12.f18331a = r1     // Catch:{ all -> 0x006f }
            long[] r1 = r6.f18314c     // Catch:{ all -> 0x006f }
            r4 = r1[r0]     // Catch:{ all -> 0x006f }
            r12.f18332b = r4     // Catch:{ all -> 0x006f }
            com.google.android.exoplayer2.b.q$a[] r1 = r6.f18318g     // Catch:{ all -> 0x006f }
            r1 = r1[r0]     // Catch:{ all -> 0x006f }
            r12.f18333c = r1     // Catch:{ all -> 0x006f }
            int r1 = r6.f18323l     // Catch:{ all -> 0x006f }
            int r1 = r1 + 1
            r6.f18323l = r1     // Catch:{ all -> 0x006f }
            monitor-exit(r6)
            return r3
        L_0x0067:
            com.google.android.exoplayer2.Format[] r2 = r6.f18319h     // Catch:{ all -> 0x006f }
            r2 = r2[r0]     // Catch:{ all -> 0x006f }
            r7.f18117a = r2     // Catch:{ all -> 0x006f }
            monitor-exit(r6)
            return r1
        L_0x006f:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.C8403t.mo25759a(com.google.android.exoplayer2.o, com.google.android.exoplayer2.a.e, boolean, boolean, com.google.android.exoplayer2.Format, com.google.android.exoplayer2.source.t$a):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
        return -1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int mo25758a(long r9, boolean r11, boolean r12) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.f18323l     // Catch:{ all -> 0x003a }
            int r0 = r8.m19938d(r0)     // Catch:{ all -> 0x003a }
            boolean r1 = r8.mo25771g()     // Catch:{ all -> 0x003a }
            r7 = -1
            if (r1 == 0) goto L_0x0038
            long[] r1 = r8.f18317f     // Catch:{ all -> 0x003a }
            r2 = r1[r0]     // Catch:{ all -> 0x003a }
            int r1 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r1 < 0) goto L_0x0038
            long r1 = r8.f18325n     // Catch:{ all -> 0x003a }
            int r3 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x001f
            if (r12 != 0) goto L_0x001f
            goto L_0x0038
        L_0x001f:
            int r1 = r8.f18320i     // Catch:{ all -> 0x003a }
            int r2 = r8.f18323l     // Catch:{ all -> 0x003a }
            int r3 = r1 - r2
            r1 = r8
            r2 = r0
            r4 = r9
            r6 = r11
            int r1 = r1.m19935a(r2, r3, r4, r6)     // Catch:{ all -> 0x003a }
            if (r1 != r7) goto L_0x0031
            monitor-exit(r8)
            return r7
        L_0x0031:
            int r2 = r8.f18323l     // Catch:{ all -> 0x003a }
            int r2 = r2 + r1
            r8.f18323l = r2     // Catch:{ all -> 0x003a }
            monitor-exit(r8)
            return r1
        L_0x0038:
            monitor-exit(r8)
            return r7
        L_0x003a:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.C8403t.mo25758a(long, boolean, boolean):int");
    }

    /* renamed from: a */
    public synchronized int mo25757a() {
        int skipCount;
        skipCount = this.f18320i - this.f18323l;
        this.f18323l = this.f18320i;
        return skipCount;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        return -1;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized long mo25766b(long r10, boolean r12, boolean r13) {
        /*
            r9 = this;
            monitor-enter(r9)
            int r0 = r9.f18320i     // Catch:{ all -> 0x0039 }
            r1 = -1
            if (r0 == 0) goto L_0x0037
            long[] r0 = r9.f18317f     // Catch:{ all -> 0x0039 }
            int r3 = r9.f18322k     // Catch:{ all -> 0x0039 }
            r3 = r0[r3]     // Catch:{ all -> 0x0039 }
            int r0 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0012
            goto L_0x0037
        L_0x0012:
            if (r13 == 0) goto L_0x0020
            int r0 = r9.f18323l     // Catch:{ all -> 0x0039 }
            int r3 = r9.f18320i     // Catch:{ all -> 0x0039 }
            if (r0 == r3) goto L_0x0020
            int r0 = r9.f18323l     // Catch:{ all -> 0x0039 }
            int r0 = r0 + 1
            r5 = r0
            goto L_0x0023
        L_0x0020:
            int r0 = r9.f18320i     // Catch:{ all -> 0x0039 }
            r5 = r0
        L_0x0023:
            int r4 = r9.f18322k     // Catch:{ all -> 0x0039 }
            r3 = r9
            r6 = r10
            r8 = r12
            int r0 = r3.m19935a(r4, r5, r6, r8)     // Catch:{ all -> 0x0039 }
            r3 = -1
            if (r0 != r3) goto L_0x0031
            monitor-exit(r9)
            return r1
        L_0x0031:
            long r1 = r9.m19936b(r0)     // Catch:{ all -> 0x0039 }
            monitor-exit(r9)
            return r1
        L_0x0037:
            monitor-exit(r9)
            return r1
        L_0x0039:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.C8403t.mo25766b(long, boolean, boolean):long");
    }

    /* renamed from: b */
    public synchronized long mo25765b() {
        if (this.f18320i == 0) {
            return -1;
        }
        return m19936b(this.f18320i);
    }

    /* renamed from: a */
    public synchronized boolean mo25764a(Format format) {
        if (format == null) {
            this.f18328q = true;
            return false;
        }
        this.f18328q = false;
        if (C8509F.m20455a((Object) format, (Object) this.f18329r)) {
            return false;
        }
        this.f18329r = format;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00e5, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo25761a(long r17, int r19, long r20, int r22, com.google.android.exoplayer2.p183b.C8272q.C8273a r23) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            monitor-enter(r16)
            boolean r0 = r1.f18327p     // Catch:{ all -> 0x00e6 }
            r4 = 0
            if (r0 == 0) goto L_0x0012
            r0 = r19 & 1
            if (r0 != 0) goto L_0x0010
            monitor-exit(r16)
            return
        L_0x0010:
            r1.f18327p = r4     // Catch:{ all -> 0x00e6 }
        L_0x0012:
            boolean r0 = r1.f18328q     // Catch:{ all -> 0x00e6 }
            r5 = 1
            if (r0 != 0) goto L_0x0019
            r0 = 1
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            com.google.android.exoplayer2.util.C8514e.m20490b(r0)     // Catch:{ all -> 0x00e6 }
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r19 & r0
            if (r0 == 0) goto L_0x0025
            r0 = 1
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            r1.f18326o = r0     // Catch:{ all -> 0x00e6 }
            long r6 = r1.f18325n     // Catch:{ all -> 0x00e6 }
            long r6 = java.lang.Math.max(r6, r2)     // Catch:{ all -> 0x00e6 }
            r1.f18325n = r6     // Catch:{ all -> 0x00e6 }
            int r0 = r1.f18320i     // Catch:{ all -> 0x00e6 }
            int r0 = r1.m19938d(r0)     // Catch:{ all -> 0x00e6 }
            long[] r6 = r1.f18317f     // Catch:{ all -> 0x00e6 }
            r6[r0] = r2     // Catch:{ all -> 0x00e6 }
            long[] r6 = r1.f18314c     // Catch:{ all -> 0x00e6 }
            r6[r0] = r20     // Catch:{ all -> 0x00e6 }
            int[] r6 = r1.f18315d     // Catch:{ all -> 0x00e6 }
            r6[r0] = r22     // Catch:{ all -> 0x00e6 }
            int[] r6 = r1.f18316e     // Catch:{ all -> 0x00e6 }
            r6[r0] = r19     // Catch:{ all -> 0x00e6 }
            com.google.android.exoplayer2.b.q$a[] r6 = r1.f18318g     // Catch:{ all -> 0x00e6 }
            r6[r0] = r23     // Catch:{ all -> 0x00e6 }
            com.google.android.exoplayer2.Format[] r6 = r1.f18319h     // Catch:{ all -> 0x00e6 }
            com.google.android.exoplayer2.Format r7 = r1.f18329r     // Catch:{ all -> 0x00e6 }
            r6[r0] = r7     // Catch:{ all -> 0x00e6 }
            int[] r6 = r1.f18313b     // Catch:{ all -> 0x00e6 }
            int r7 = r1.f18330s     // Catch:{ all -> 0x00e6 }
            r6[r0] = r7     // Catch:{ all -> 0x00e6 }
            int r6 = r1.f18320i     // Catch:{ all -> 0x00e6 }
            int r6 = r6 + r5
            r1.f18320i = r6     // Catch:{ all -> 0x00e6 }
            int r5 = r1.f18320i     // Catch:{ all -> 0x00e6 }
            int r6 = r1.f18312a     // Catch:{ all -> 0x00e6 }
            if (r5 != r6) goto L_0x00e4
            int r5 = r1.f18312a     // Catch:{ all -> 0x00e6 }
            int r5 = r5 + 1000
            int[] r6 = new int[r5]     // Catch:{ all -> 0x00e6 }
            long[] r7 = new long[r5]     // Catch:{ all -> 0x00e6 }
            long[] r8 = new long[r5]     // Catch:{ all -> 0x00e6 }
            int[] r9 = new int[r5]     // Catch:{ all -> 0x00e6 }
            int[] r10 = new int[r5]     // Catch:{ all -> 0x00e6 }
            com.google.android.exoplayer2.b.q$a[] r11 = new com.google.android.exoplayer2.p183b.C8272q.C8273a[r5]     // Catch:{ all -> 0x00e6 }
            com.google.android.exoplayer2.Format[] r12 = new com.google.android.exoplayer2.Format[r5]     // Catch:{ all -> 0x00e6 }
            int r13 = r1.f18312a     // Catch:{ all -> 0x00e6 }
            int r14 = r1.f18322k     // Catch:{ all -> 0x00e6 }
            int r13 = r13 - r14
            long[] r14 = r1.f18314c     // Catch:{ all -> 0x00e6 }
            int r15 = r1.f18322k     // Catch:{ all -> 0x00e6 }
            java.lang.System.arraycopy(r14, r15, r7, r4, r13)     // Catch:{ all -> 0x00e6 }
            long[] r14 = r1.f18317f     // Catch:{ all -> 0x00e6 }
            int r15 = r1.f18322k     // Catch:{ all -> 0x00e6 }
            java.lang.System.arraycopy(r14, r15, r8, r4, r13)     // Catch:{ all -> 0x00e6 }
            int[] r14 = r1.f18316e     // Catch:{ all -> 0x00e6 }
            int r15 = r1.f18322k     // Catch:{ all -> 0x00e6 }
            java.lang.System.arraycopy(r14, r15, r9, r4, r13)     // Catch:{ all -> 0x00e6 }
            int[] r14 = r1.f18315d     // Catch:{ all -> 0x00e6 }
            int r15 = r1.f18322k     // Catch:{ all -> 0x00e6 }
            java.lang.System.arraycopy(r14, r15, r10, r4, r13)     // Catch:{ all -> 0x00e6 }
            com.google.android.exoplayer2.b.q$a[] r14 = r1.f18318g     // Catch:{ all -> 0x00e6 }
            int r15 = r1.f18322k     // Catch:{ all -> 0x00e6 }
            java.lang.System.arraycopy(r14, r15, r11, r4, r13)     // Catch:{ all -> 0x00e6 }
            com.google.android.exoplayer2.Format[] r14 = r1.f18319h     // Catch:{ all -> 0x00e6 }
            int r15 = r1.f18322k     // Catch:{ all -> 0x00e6 }
            java.lang.System.arraycopy(r14, r15, r12, r4, r13)     // Catch:{ all -> 0x00e6 }
            int[] r14 = r1.f18313b     // Catch:{ all -> 0x00e6 }
            int r15 = r1.f18322k     // Catch:{ all -> 0x00e6 }
            java.lang.System.arraycopy(r14, r15, r6, r4, r13)     // Catch:{ all -> 0x00e6 }
            int r14 = r1.f18322k     // Catch:{ all -> 0x00e6 }
            long[] r15 = r1.f18314c     // Catch:{ all -> 0x00e6 }
            java.lang.System.arraycopy(r15, r4, r7, r13, r14)     // Catch:{ all -> 0x00e6 }
            long[] r15 = r1.f18317f     // Catch:{ all -> 0x00e6 }
            java.lang.System.arraycopy(r15, r4, r8, r13, r14)     // Catch:{ all -> 0x00e6 }
            int[] r15 = r1.f18316e     // Catch:{ all -> 0x00e6 }
            java.lang.System.arraycopy(r15, r4, r9, r13, r14)     // Catch:{ all -> 0x00e6 }
            int[] r15 = r1.f18315d     // Catch:{ all -> 0x00e6 }
            java.lang.System.arraycopy(r15, r4, r10, r13, r14)     // Catch:{ all -> 0x00e6 }
            com.google.android.exoplayer2.b.q$a[] r15 = r1.f18318g     // Catch:{ all -> 0x00e6 }
            java.lang.System.arraycopy(r15, r4, r11, r13, r14)     // Catch:{ all -> 0x00e6 }
            com.google.android.exoplayer2.Format[] r15 = r1.f18319h     // Catch:{ all -> 0x00e6 }
            java.lang.System.arraycopy(r15, r4, r12, r13, r14)     // Catch:{ all -> 0x00e6 }
            int[] r15 = r1.f18313b     // Catch:{ all -> 0x00e6 }
            java.lang.System.arraycopy(r15, r4, r6, r13, r14)     // Catch:{ all -> 0x00e6 }
            r1.f18314c = r7     // Catch:{ all -> 0x00e6 }
            r1.f18317f = r8     // Catch:{ all -> 0x00e6 }
            r1.f18316e = r9     // Catch:{ all -> 0x00e6 }
            r1.f18315d = r10     // Catch:{ all -> 0x00e6 }
            r1.f18318g = r11     // Catch:{ all -> 0x00e6 }
            r1.f18319h = r12     // Catch:{ all -> 0x00e6 }
            r1.f18313b = r6     // Catch:{ all -> 0x00e6 }
            r1.f18322k = r4     // Catch:{ all -> 0x00e6 }
            int r4 = r1.f18312a     // Catch:{ all -> 0x00e6 }
            r1.f18320i = r4     // Catch:{ all -> 0x00e6 }
            r1.f18312a = r5     // Catch:{ all -> 0x00e6 }
        L_0x00e4:
            monitor-exit(r16)
            return
        L_0x00e6:
            r0 = move-exception
            monitor-exit(r16)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.C8403t.mo25761a(long, int, long, int, com.google.android.exoplayer2.b.q$a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        return r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo25763a(long r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.f18320i     // Catch:{ all -> 0x004b }
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0010
            long r3 = r8.f18324m     // Catch:{ all -> 0x004b }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x000e
            r1 = 1
        L_0x000e:
            monitor-exit(r8)
            return r1
        L_0x0010:
            long r3 = r8.f18324m     // Catch:{ all -> 0x004b }
            int r0 = r8.f18323l     // Catch:{ all -> 0x004b }
            long r5 = r8.m19937c(r0)     // Catch:{ all -> 0x004b }
            long r3 = java.lang.Math.max(r3, r5)     // Catch:{ all -> 0x004b }
            int r0 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r0 < 0) goto L_0x0022
            monitor-exit(r8)
            return r1
        L_0x0022:
            int r0 = r8.f18320i     // Catch:{ all -> 0x004b }
            int r1 = r8.f18320i     // Catch:{ all -> 0x004b }
            int r1 = r1 - r2
            int r1 = r8.m19938d(r1)     // Catch:{ all -> 0x004b }
        L_0x002b:
            int r5 = r8.f18323l     // Catch:{ all -> 0x004b }
            if (r0 <= r5) goto L_0x0043
            long[] r5 = r8.f18317f     // Catch:{ all -> 0x004b }
            r6 = r5[r1]     // Catch:{ all -> 0x004b }
            int r5 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r5 < 0) goto L_0x0043
            int r0 = r0 + -1
            int r1 = r1 + -1
            r5 = -1
            if (r1 != r5) goto L_0x002b
            int r5 = r8.f18312a     // Catch:{ all -> 0x004b }
            int r1 = r5 + -1
            goto L_0x002b
        L_0x0043:
            int r5 = r8.f18321j     // Catch:{ all -> 0x004b }
            int r5 = r5 + r0
            r8.mo25760a(r5)     // Catch:{ all -> 0x004b }
            monitor-exit(r8)
            return r2
        L_0x004b:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x004f
        L_0x004e:
            throw r9
        L_0x004f:
            goto L_0x004e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.C8403t.mo25763a(long):boolean");
    }

    /* renamed from: a */
    private int m19935a(int relativeStartIndex, int length, long timeUs, boolean keyframe) {
        int sampleCountToTarget = -1;
        int searchIndex = relativeStartIndex;
        for (int i = 0; i < length && this.f18317f[searchIndex] <= timeUs; i++) {
            if (!keyframe || (this.f18316e[searchIndex] & 1) != 0) {
                sampleCountToTarget = i;
            }
            searchIndex++;
            if (searchIndex == this.f18312a) {
                searchIndex = 0;
            }
        }
        return sampleCountToTarget;
    }

    /* renamed from: b */
    private long m19936b(int discardCount) {
        this.f18324m = Math.max(this.f18324m, m19937c(discardCount));
        this.f18320i -= discardCount;
        this.f18321j += discardCount;
        this.f18322k += discardCount;
        int i = this.f18322k;
        int i2 = this.f18312a;
        if (i >= i2) {
            this.f18322k = i - i2;
        }
        this.f18323l -= discardCount;
        if (this.f18323l < 0) {
            this.f18323l = 0;
        }
        if (this.f18320i != 0) {
            return this.f18314c[this.f18322k];
        }
        int i3 = this.f18322k;
        if (i3 == 0) {
            i3 = this.f18312a;
        }
        int relativeLastDiscardIndex = i3 - 1;
        return this.f18314c[relativeLastDiscardIndex] + ((long) this.f18315d[relativeLastDiscardIndex]);
    }

    /* renamed from: c */
    private long m19937c(int length) {
        if (length == 0) {
            return Long.MIN_VALUE;
        }
        long largestTimestampUs = Long.MIN_VALUE;
        int relativeSampleIndex = m19938d(length - 1);
        for (int i = 0; i < length; i++) {
            largestTimestampUs = Math.max(largestTimestampUs, this.f18317f[relativeSampleIndex]);
            if ((this.f18316e[relativeSampleIndex] & 1) != 0) {
                break;
            }
            relativeSampleIndex--;
            if (relativeSampleIndex == -1) {
                relativeSampleIndex = this.f18312a - 1;
            }
        }
        return largestTimestampUs;
    }

    /* renamed from: d */
    private int m19938d(int offset) {
        int relativeIndex = this.f18322k + offset;
        int i = this.f18312a;
        return relativeIndex < i ? relativeIndex : relativeIndex - i;
    }
}
