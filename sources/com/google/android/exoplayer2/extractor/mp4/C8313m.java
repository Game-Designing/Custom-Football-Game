package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.util.C8509F;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.extractor.mp4.m */
/* compiled from: Sniffer */
final class C8313m {

    /* renamed from: a */
    private static final int[] f17861a = {C8509F.m20464b("isom"), C8509F.m20464b("iso2"), C8509F.m20464b("iso3"), C8509F.m20464b("iso4"), C8509F.m20464b("iso5"), C8509F.m20464b("iso6"), C8509F.m20464b("avc1"), C8509F.m20464b("hvc1"), C8509F.m20464b("hev1"), C8509F.m20464b("mp41"), C8509F.m20464b("mp42"), C8509F.m20464b("3g2a"), C8509F.m20464b("3g2b"), C8509F.m20464b("3gr6"), C8509F.m20464b("3gs6"), C8509F.m20464b("3ge6"), C8509F.m20464b("3gg6"), C8509F.m20464b("M4V "), C8509F.m20464b("M4A "), C8509F.m20464b("f4v "), C8509F.m20464b("kddi"), C8509F.m20464b("M4VP"), C8509F.m20464b("qt  "), C8509F.m20464b("MSNV")};

    /* renamed from: a */
    public static boolean m19422a(C8261h input) throws IOException, InterruptedException {
        return m19423a(input, true);
    }

    /* renamed from: b */
    public static boolean m19424b(C8261h input) throws IOException, InterruptedException {
        return m19423a(input, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e5, code lost:
        r9 = true;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m19423a(com.google.android.exoplayer2.p183b.C8261h r23, boolean r24) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r0 = r23
            long r1 = r23.getLength()
            r3 = 4096(0x1000, double:2.0237E-320)
            r5 = -1
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0014
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r3 = r1
        L_0x0014:
            int r4 = (int) r3
            com.google.android.exoplayer2.util.t r3 = new com.google.android.exoplayer2.util.t
            r7 = 64
            r3.<init>(r7)
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x001f:
            r11 = 0
            if (r7 >= r4) goto L_0x00e7
            r12 = 8
            r3.mo26114c(r12)
            byte[] r13 = r3.f18861a
            r0.mo25241a(r13, r11, r12)
            long r13 = r3.mo26133s()
            int r15 = r3.mo26119f()
            r16 = 1
            r10 = 8
            int r19 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r19 != 0) goto L_0x004d
            r12 = 16
            byte[] r11 = r3.f18861a
            r0.mo25241a(r11, r10, r10)
            r11 = 16
            r3.mo26116d(r11)
            long r13 = r3.mo26127m()
            goto L_0x0064
        L_0x004d:
            r19 = 0
            int r11 = (r13 > r19 ? 1 : (r13 == r19 ? 0 : -1))
            if (r11 != 0) goto L_0x0064
            long r19 = r23.getLength()
            int r11 = (r19 > r5 ? 1 : (r19 == r5 ? 0 : -1))
            if (r11 == 0) goto L_0x0064
            long r21 = r23.mo25245b()
            long r21 = r19 - r21
            long r10 = (long) r12
            long r13 = r21 + r10
        L_0x0064:
            int r10 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x0070
            long r10 = (long) r7
            long r10 = r10 + r13
            int r19 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r19 <= 0) goto L_0x0070
            r10 = 0
            return r10
        L_0x0070:
            r10 = 0
            long r5 = (long) r12
            int r11 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r11 >= 0) goto L_0x0077
            return r10
        L_0x0077:
            int r7 = r7 + r12
            int r5 = com.google.android.exoplayer2.extractor.mp4.C8290c.f17608B
            if (r15 != r5) goto L_0x008b
            int r5 = (int) r13
            int r4 = r4 + r5
            r5 = -1
            int r10 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x001f
            long r10 = (long) r4
            int r16 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r16 <= 0) goto L_0x001f
            int r4 = (int) r1
            goto L_0x001f
        L_0x008b:
            r5 = -1
            int r10 = com.google.android.exoplayer2.extractor.mp4.C8290c.f17626K
            if (r15 == r10) goto L_0x00e4
            int r10 = com.google.android.exoplayer2.extractor.mp4.C8290c.f17630M
            if (r15 != r10) goto L_0x0097
            r10 = 0
            goto L_0x00e5
        L_0x0097:
            long r10 = (long) r7
            long r10 = r10 + r13
            long r5 = (long) r12
            long r10 = r10 - r5
            long r5 = (long) r4
            int r21 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r21 < 0) goto L_0x00a2
            r10 = 0
            goto L_0x00e8
        L_0x00a2:
            long r5 = (long) r12
            long r5 = r13 - r5
            int r6 = (int) r5
            int r7 = r7 + r6
            int r5 = com.google.android.exoplayer2.extractor.mp4.C8290c.f17654a
            if (r15 != r5) goto L_0x00db
            r5 = 8
            if (r6 >= r5) goto L_0x00b1
            r5 = 0
            return r5
        L_0x00b1:
            r5 = 0
            r3.mo26114c(r6)
            byte[] r10 = r3.f18861a
            r0.mo25241a(r10, r5, r6)
            int r5 = r6 / 4
            r10 = 0
        L_0x00bd:
            if (r10 >= r5) goto L_0x00d6
            r11 = 1
            if (r10 != r11) goto L_0x00c7
            r11 = 4
            r3.mo26120f(r11)
            goto L_0x00d3
        L_0x00c7:
            int r11 = r3.mo26119f()
            boolean r11 = m19421a(r11)
            if (r11 == 0) goto L_0x00d3
            r8 = 1
            goto L_0x00d6
        L_0x00d3:
            int r10 = r10 + 1
            goto L_0x00bd
        L_0x00d6:
            if (r8 != 0) goto L_0x00da
            r10 = 0
            return r10
        L_0x00da:
            goto L_0x00e0
        L_0x00db:
            if (r6 == 0) goto L_0x00da
            r0.mo25240a(r6)
        L_0x00e0:
            r5 = -1
            goto L_0x001f
        L_0x00e4:
            r10 = 0
        L_0x00e5:
            r9 = 1
            goto L_0x00e8
        L_0x00e7:
            r10 = 0
        L_0x00e8:
            if (r8 == 0) goto L_0x00f1
            r5 = r24
            if (r5 != r9) goto L_0x00f3
            r18 = 1
            goto L_0x00f5
        L_0x00f1:
            r5 = r24
        L_0x00f3:
            r18 = 0
        L_0x00f5:
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.C8313m.m19423a(com.google.android.exoplayer2.b.h, boolean):boolean");
    }

    /* renamed from: a */
    private static boolean m19421a(int brand) {
        if ((brand >>> 8) == C8509F.m20464b("3gp")) {
            return true;
        }
        for (int compatibleBrand : f17861a) {
            if (compatibleBrand == brand) {
                return true;
            }
        }
        return false;
    }
}
