package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C8096B;
import com.google.android.exoplayer2.C8362o;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p182a.C8107e;
import com.google.android.exoplayer2.source.C8393q.C8394a;
import com.google.android.exoplayer2.trackselection.C8432h;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8529q;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.source.l */
/* compiled from: ClippingMediaPeriod */
public final class C8381l implements C8393q, C8394a {

    /* renamed from: a */
    public final C8393q f18206a;

    /* renamed from: b */
    private C8394a f18207b;

    /* renamed from: c */
    private C8382a[] f18208c = new C8382a[0];

    /* renamed from: d */
    private long f18209d;

    /* renamed from: e */
    long f18210e;

    /* renamed from: f */
    long f18211f;

    /* renamed from: com.google.android.exoplayer2.source.l$a */
    /* compiled from: ClippingMediaPeriod */
    private final class C8382a implements C8408v {

        /* renamed from: a */
        public final C8408v f18212a;

        /* renamed from: b */
        private boolean f18213b;

        public C8382a(C8408v childStream) {
            this.f18212a = childStream;
        }

        /* renamed from: b */
        public void mo25698b() {
            this.f18213b = false;
        }

        public boolean isReady() {
            return !C8381l.this.mo25694f() && this.f18212a.isReady();
        }

        /* renamed from: a */
        public void mo25697a() throws IOException {
            this.f18212a.mo25697a();
        }

        /* renamed from: a */
        public int mo25696a(C8362o formatHolder, C8107e buffer, boolean requireFormat) {
            if (C8381l.this.mo25694f()) {
                return -3;
            }
            if (this.f18213b) {
                buffer.mo25024c(4);
                return -4;
            }
            int result = this.f18212a.mo25696a(formatHolder, buffer, requireFormat);
            if (result == -5) {
                Format format = formatHolder.f18117a;
                if (!(format.f16523w == 0 && format.f16524x == 0)) {
                    int i = 0;
                    int encoderDelay = C8381l.this.f18210e != 0 ? 0 : format.f16523w;
                    if (C8381l.this.f18211f == Long.MIN_VALUE) {
                        i = format.f16524x;
                    }
                    formatHolder.f18117a = format.mo25009a(encoderDelay, i);
                }
                return -5;
            }
            long j = C8381l.this.f18211f;
            if (j == Long.MIN_VALUE || ((result != -4 || buffer.f16556d < j) && (result != -3 || C8381l.this.mo25693e() != Long.MIN_VALUE))) {
                return result;
            }
            buffer.mo25020a();
            buffer.mo25024c(4);
            this.f18213b = true;
            return -4;
        }

        /* renamed from: a */
        public int mo25695a(long positionUs) {
            if (C8381l.this.mo25694f()) {
                return -3;
            }
            return this.f18212a.mo25695a(positionUs);
        }
    }

    public C8381l(C8393q mediaPeriod, boolean enableInitialDiscontinuity, long startUs, long endUs) {
        this.f18206a = mediaPeriod;
        this.f18209d = enableInitialDiscontinuity ? startUs : -9223372036854775807L;
        this.f18210e = startUs;
        this.f18211f = endUs;
    }

    /* renamed from: a */
    public void mo25686a(C8394a callback, long positionUs) {
        this.f18207b = callback;
        this.f18206a.mo25686a((C8394a) this, positionUs);
    }

    /* renamed from: c */
    public void mo25690c() throws IOException {
        this.f18206a.mo25690c();
    }

    /* renamed from: d */
    public TrackGroupArray mo25692d() {
        return this.f18206a.mo25692d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005d, code lost:
        if (r1 > r3) goto L_0x0060;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006a  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo25684a(com.google.android.exoplayer2.trackselection.C8432h[] r10, boolean[] r11, com.google.android.exoplayer2.source.C8408v[] r12, boolean[] r13, long r14) {
        /*
            r9 = this;
            int r0 = r12.length
            com.google.android.exoplayer2.source.l$a[] r0 = new com.google.android.exoplayer2.source.C8381l.C8382a[r0]
            r9.f18208c = r0
            int r0 = r12.length
            com.google.android.exoplayer2.source.v[] r0 = new com.google.android.exoplayer2.source.C8408v[r0]
            r1 = 0
        L_0x0009:
            int r2 = r12.length
            r8 = 0
            if (r1 >= r2) goto L_0x0022
            com.google.android.exoplayer2.source.l$a[] r2 = r9.f18208c
            r3 = r12[r1]
            com.google.android.exoplayer2.source.l$a r3 = (com.google.android.exoplayer2.source.C8381l.C8382a) r3
            r2[r1] = r3
            r3 = r2[r1]
            if (r3 == 0) goto L_0x001d
            r2 = r2[r1]
            com.google.android.exoplayer2.source.v r8 = r2.f18212a
        L_0x001d:
            r0[r1] = r8
            int r1 = r1 + 1
            goto L_0x0009
        L_0x0022:
            com.google.android.exoplayer2.source.q r1 = r9.f18206a
            r2 = r10
            r3 = r11
            r4 = r0
            r5 = r13
            r6 = r14
            long r1 = r1.mo25684a(r2, r3, r4, r5, r6)
            boolean r3 = r9.mo25694f()
            if (r3 == 0) goto L_0x0042
            long r3 = r9.f18210e
            int r5 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0042
            boolean r3 = m19788a(r3, r10)
            if (r3 == 0) goto L_0x0042
            r3 = r1
            goto L_0x0047
        L_0x0042:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0047:
            r9.f18209d = r3
            int r3 = (r1 > r14 ? 1 : (r1 == r14 ? 0 : -1))
            if (r3 == 0) goto L_0x0062
            long r3 = r9.f18210e
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x0060
            long r3 = r9.f18211f
            r5 = -9223372036854775808
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0062
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r3 = 0
            goto L_0x0063
        L_0x0062:
            r3 = 1
        L_0x0063:
            com.google.android.exoplayer2.util.C8514e.m20490b(r3)
            r3 = 0
        L_0x0067:
            int r4 = r12.length
            if (r3 >= r4) goto L_0x0095
            r4 = r0[r3]
            if (r4 != 0) goto L_0x0073
            com.google.android.exoplayer2.source.l$a[] r4 = r9.f18208c
            r4[r3] = r8
            goto L_0x008c
        L_0x0073:
            r4 = r12[r3]
            if (r4 == 0) goto L_0x0081
            com.google.android.exoplayer2.source.l$a[] r4 = r9.f18208c
            r4 = r4[r3]
            com.google.android.exoplayer2.source.v r4 = r4.f18212a
            r5 = r0[r3]
            if (r4 == r5) goto L_0x008c
        L_0x0081:
            com.google.android.exoplayer2.source.l$a[] r4 = r9.f18208c
            com.google.android.exoplayer2.source.l$a r5 = new com.google.android.exoplayer2.source.l$a
            r6 = r0[r3]
            r5.<init>(r6)
            r4[r3] = r5
        L_0x008c:
            com.google.android.exoplayer2.source.l$a[] r4 = r9.f18208c
            r4 = r4[r3]
            r12[r3] = r4
            int r3 = r3 + 1
            goto L_0x0067
        L_0x0095:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.C8381l.mo25684a(com.google.android.exoplayer2.trackselection.h[], boolean[], com.google.android.exoplayer2.source.v[], boolean[], long):long");
    }

    /* renamed from: a */
    public void mo25685a(long positionUs, boolean toKeyframe) {
        this.f18206a.mo25685a(positionUs, toKeyframe);
    }

    /* renamed from: c */
    public void mo25691c(long positionUs) {
        this.f18206a.mo25691c(positionUs);
    }

    /* renamed from: b */
    public long mo25687b() {
        if (mo25694f()) {
            long initialDiscontinuityUs = this.f18209d;
            this.f18209d = -9223372036854775807L;
            long childDiscontinuityUs = mo25687b();
            return childDiscontinuityUs != -9223372036854775807L ? childDiscontinuityUs : initialDiscontinuityUs;
        }
        long discontinuityUs = this.f18206a.mo25687b();
        if (discontinuityUs == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = true;
        C8514e.m20490b(discontinuityUs >= this.f18210e);
        long j = this.f18211f;
        if (j != Long.MIN_VALUE && discontinuityUs > j) {
            z = false;
        }
        C8514e.m20490b(z);
        return discontinuityUs;
    }

    /* renamed from: e */
    public long mo25693e() {
        long bufferedPositionUs = this.f18206a.mo25693e();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j = this.f18211f;
            if (j == Long.MIN_VALUE || bufferedPositionUs < j) {
                return bufferedPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r0 > r3) goto L_0x0035;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo25682a(long r9) {
        /*
            r8 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8.f18209d = r0
            com.google.android.exoplayer2.source.l$a[] r0 = r8.f18208c
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x000c:
            if (r3 >= r1) goto L_0x0018
            r4 = r0[r3]
            if (r4 == 0) goto L_0x0015
            r4.mo25698b()
        L_0x0015:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0018:
            com.google.android.exoplayer2.source.q r0 = r8.f18206a
            long r0 = r0.mo25682a(r9)
            int r3 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r3 == 0) goto L_0x0034
            long r3 = r8.f18210e
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x0035
            long r3 = r8.f18211f
            r5 = -9223372036854775808
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0034
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0035
        L_0x0034:
            r2 = 1
        L_0x0035:
            com.google.android.exoplayer2.util.C8514e.m20490b(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.C8381l.mo25682a(long):long");
    }

    /* renamed from: a */
    public long mo25683a(long positionUs, C8096B seekParameters) {
        long j = this.f18210e;
        if (positionUs == j) {
            return j;
        }
        return this.f18206a.mo25683a(positionUs, m19789b(positionUs, seekParameters));
    }

    /* renamed from: a */
    public long mo25681a() {
        long nextLoadPositionUs = this.f18206a.mo25681a();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j = this.f18211f;
            if (j == Long.MIN_VALUE || nextLoadPositionUs < j) {
                return nextLoadPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    /* renamed from: b */
    public boolean mo25689b(long positionUs) {
        return this.f18206a.mo25689b(positionUs);
    }

    /* renamed from: a */
    public void mo25488a(C8393q mediaPeriod) {
        this.f18207b.mo25488a(this);
    }

    /* renamed from: b */
    public void mo25491a(C8393q source) {
        this.f18207b.mo25491a(this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public boolean mo25694f() {
        return this.f18209d != -9223372036854775807L;
    }

    /* renamed from: b */
    private C8096B m19789b(long positionUs, C8096B seekParameters) {
        long toleranceBeforeUs = C8509F.m20467b(seekParameters.f16477f, 0, positionUs - this.f18210e);
        long j = seekParameters.f16478g;
        long j2 = this.f18211f;
        long toleranceAfterUs = C8509F.m20467b(j, 0, j2 == Long.MIN_VALUE ? Long.MAX_VALUE : j2 - positionUs);
        if (toleranceBeforeUs == seekParameters.f16477f && toleranceAfterUs == seekParameters.f16478g) {
            return seekParameters;
        }
        return new C8096B(toleranceBeforeUs, toleranceAfterUs);
    }

    /* renamed from: a */
    private static boolean m19788a(long startUs, C8432h[] selections) {
        if (startUs != 0) {
            for (C8432h trackSelection : selections) {
                if (trackSelection != null && !C8529q.m20547f(trackSelection.mo25836e().f16507g)) {
                    return true;
                }
            }
        }
        return false;
    }
}
