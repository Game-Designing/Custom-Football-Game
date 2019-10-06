package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.vs */
final class C9783vs {

    /* renamed from: a */
    private static final int[] f23346a = {zzsy.m31156b("isom"), zzsy.m31156b("iso2"), zzsy.m31156b("iso3"), zzsy.m31156b("iso4"), zzsy.m31156b("iso5"), zzsy.m31156b("iso6"), zzsy.m31156b("avc1"), zzsy.m31156b("hvc1"), zzsy.m31156b("hev1"), zzsy.m31156b("mp41"), zzsy.m31156b("mp42"), zzsy.m31156b("3g2a"), zzsy.m31156b("3g2b"), zzsy.m31156b("3gr6"), zzsy.m31156b("3gs6"), zzsy.m31156b("3ge6"), zzsy.m31156b("3gg6"), zzsy.m31156b("M4V "), zzsy.m31156b("M4A "), zzsy.m31156b("f4v "), zzsy.m31156b("kddi"), zzsy.m31156b("M4VP"), zzsy.m31156b("qt  "), zzsy.m31156b("MSNV")};

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c0, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c1, code lost:
        if (r5 == false) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c3, code lost:
        if (r0 != false) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c6, code lost:
        return true;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m24193a(com.google.android.gms.internal.ads.zzno r16) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r0 = r16
            long r1 = r16.getLength()
            r3 = 4096(0x1000, double:2.0237E-320)
            r5 = -1
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0014
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            goto L_0x0015
        L_0x0014:
            r1 = r3
        L_0x0015:
            int r2 = (int) r1
            com.google.android.gms.internal.ads.zzst r1 = new com.google.android.gms.internal.ads.zzst
            r3 = 64
            r1.<init>(r3)
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0022:
            if (r4 >= r2) goto L_0x00c0
            r7 = 8
            r1.mo32195a(r7)
            byte[] r8 = r1.f29334a
            r0.mo32046a(r8, r3, r7)
            long r8 = r1.mo32210j()
            int r10 = r1.mo32202d()
            r11 = 1
            r13 = 16
            int r14 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r14 != 0) goto L_0x004d
            byte[] r8 = r1.f29334a
            r0.mo32046a(r8, r7, r7)
            r1.mo32203d(r13)
            long r8 = r1.mo32213m()
            goto L_0x004f
        L_0x004d:
            r13 = 8
        L_0x004f:
            long r11 = (long) r13
            int r14 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r14 < 0) goto L_0x00c7
            int r4 = r4 + r13
            int r13 = com.google.android.gms.internal.ads.C9481hs.f22433B
            if (r10 == r13) goto L_0x0022
            int r13 = com.google.android.gms.internal.ads.C9481hs.f22451K
            if (r10 == r13) goto L_0x00bd
            int r13 = com.google.android.gms.internal.ads.C9481hs.f22455M
            if (r10 != r13) goto L_0x0062
            goto L_0x00bd
        L_0x0062:
            long r13 = (long) r4
            long r13 = r13 + r8
            long r13 = r13 - r11
            long r6 = (long) r2
            int r15 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r15 >= 0) goto L_0x00c0
            long r8 = r8 - r11
            int r6 = (int) r8
            int r4 = r4 + r6
            int r7 = com.google.android.gms.internal.ads.C9481hs.f22472a
            if (r10 != r7) goto L_0x00b6
            r7 = 8
            if (r6 < r7) goto L_0x00c7
            r1.mo32195a(r6)
            byte[] r7 = r1.f29334a
            r0.mo32046a(r7, r3, r6)
            int r6 = r6 / 4
            r7 = 0
        L_0x0080:
            if (r7 >= r6) goto L_0x00b2
            r8 = 1
            if (r7 != r8) goto L_0x008a
            r8 = 4
            r1.mo32201c(r8)
            goto L_0x00af
        L_0x008a:
            int r8 = r1.mo32202d()
            int r9 = r8 >>> 8
            java.lang.String r10 = "3gp"
            int r10 = com.google.android.gms.internal.ads.zzsy.m31156b(r10)
            if (r9 != r10) goto L_0x009a
            r8 = 1
            goto L_0x00aa
        L_0x009a:
            int[] r9 = f23346a
            int r10 = r9.length
            r11 = 0
        L_0x009e:
            if (r11 >= r10) goto L_0x00a9
            r12 = r9[r11]
            if (r12 != r8) goto L_0x00a6
            r8 = 1
            goto L_0x00aa
        L_0x00a6:
            int r11 = r11 + 1
            goto L_0x009e
        L_0x00a9:
            r8 = 0
        L_0x00aa:
            if (r8 == 0) goto L_0x00af
            r5 = 1
            goto L_0x00b2
        L_0x00af:
            int r7 = r7 + 1
            goto L_0x0080
        L_0x00b2:
            if (r5 == 0) goto L_0x00c7
            goto L_0x0022
        L_0x00b6:
            if (r6 == 0) goto L_0x00bb
            r0.mo32049c(r6)
        L_0x00bb:
            goto L_0x0022
        L_0x00bd:
            r0 = 1
            goto L_0x00c1
        L_0x00c0:
            r0 = 0
        L_0x00c1:
            if (r5 == 0) goto L_0x00c7
            if (r0 != 0) goto L_0x00c7
            r0 = 1
            return r0
        L_0x00c7:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9783vs.m24193a(com.google.android.gms.internal.ads.zzno):boolean");
    }
}
