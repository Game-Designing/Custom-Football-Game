package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

public final class zzrg extends zzrj {

    /* renamed from: f */
    private static final int[] f29226f = new int[0];

    /* renamed from: g */
    private final zzrn f29227g;

    /* renamed from: h */
    private final AtomicReference<zzrh> f29228h;

    public zzrg() {
        this(null);
    }

    private zzrg(zzrn zzrn) {
        this.f29227g = null;
        this.f29228h = new AtomicReference<>(new zzrh());
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01a0, code lost:
        if (r10 <= r15) goto L_0x01a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01d5  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzrm[] mo32156a(com.google.android.gms.internal.ads.zzlp[] r35, com.google.android.gms.internal.ads.zzrb[] r36, int[][][] r37) throws com.google.android.gms.internal.ads.zzku {
        /*
            r34 = this;
            r0 = r35
            int r1 = r0.length
            com.google.android.gms.internal.ads.zzrm[] r2 = new com.google.android.gms.internal.ads.zzrm[r1]
            r3 = r34
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.internal.ads.zzrh> r4 = r3.f29228h
            java.lang.Object r4 = r4.get()
            com.google.android.gms.internal.ads.zzrh r4 = (com.google.android.gms.internal.ads.zzrh) r4
            r6 = 0
            r7 = 0
        L_0x0012:
            r8 = 2
            if (r6 >= r1) goto L_0x0282
            r12 = r0[r6]
            int r12 = r12.mo31914d()
            if (r8 != r12) goto L_0x026c
            if (r7 != 0) goto L_0x025f
            r7 = r36[r6]
            r12 = r37[r6]
            int r13 = r4.f29233e
            int r14 = r4.f29234f
            int r15 = r4.f29235g
            int r10 = r4.f29238j
            int r8 = r4.f29239k
            boolean r5 = r4.f29240l
            boolean r9 = r4.f29236h
            boolean r11 = r4.f29237i
            r19 = r4
            r0 = 0
            r3 = 0
            r4 = 0
            r20 = 0
            r21 = -1
            r22 = -1
        L_0x0044:
            r23 = r1
            int r1 = r7.f29216b
            if (r3 >= r1) goto L_0x023b
            com.google.android.gms.internal.ads.zzra r1 = r7.mo32147a(r3)
            r24 = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r25 = r2
            int r2 = r1.f29212a
            r7.<init>(r2)
            r2 = 0
        L_0x005b:
            r26 = r6
            int r6 = r1.f29212a
            if (r2 >= r6) goto L_0x006d
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            r7.add(r6)
            int r2 = r2 + 1
            r6 = r26
            goto L_0x005b
        L_0x006d:
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r10 == r2) goto L_0x0154
            if (r8 != r2) goto L_0x0084
            r27 = r0
            r28 = r4
            r30 = r5
            r31 = r8
            r29 = r9
            r32 = r10
            r33 = r15
            goto L_0x0162
        L_0x0084:
            r6 = 0
        L_0x0086:
            r27 = r0
            int r0 = r1.f29212a
            if (r6 >= r0) goto L_0x011d
            com.google.android.gms.internal.ads.zzlh r0 = r1.mo32143a(r6)
            r28 = r4
            int r4 = r0.f28788j
            if (r4 <= 0) goto L_0x0101
            r29 = r9
            int r9 = r0.f28789k
            if (r9 <= 0) goto L_0x00fc
            if (r5 == 0) goto L_0x00b9
            if (r4 <= r9) goto L_0x00a5
            r30 = r5
            r5 = 1
            goto L_0x00a8
        L_0x00a5:
            r30 = r5
            r5 = 0
        L_0x00a8:
            if (r10 <= r8) goto L_0x00ae
            r31 = r8
            r8 = 1
            goto L_0x00b1
        L_0x00ae:
            r31 = r8
            r8 = 0
        L_0x00b1:
            if (r5 == r8) goto L_0x00bd
            r5 = r10
            r8 = r31
            goto L_0x00c0
        L_0x00b9:
            r30 = r5
            r31 = r8
        L_0x00bd:
            r8 = r10
            r5 = r31
        L_0x00c0:
            r32 = r10
            int r10 = r4 * r5
            r33 = r15
            int r15 = r9 * r8
            if (r10 < r15) goto L_0x00d5
            android.graphics.Point r5 = new android.graphics.Point
            int r4 = com.google.android.gms.internal.ads.zzsy.m31145a(r15, r4)
            r5.<init>(r8, r4)
            r4 = r5
            goto L_0x00de
        L_0x00d5:
            android.graphics.Point r4 = new android.graphics.Point
            int r8 = com.google.android.gms.internal.ads.zzsy.m31145a(r10, r9)
            r4.<init>(r8, r5)
        L_0x00de:
            int r5 = r0.f28788j
            int r0 = r0.f28789k
            int r8 = r5 * r0
            int r9 = r4.x
            float r9 = (float) r9
            r10 = 1065017672(0x3f7ae148, float:0.98)
            float r9 = r9 * r10
            int r9 = (int) r9
            if (r5 < r9) goto L_0x010b
            int r4 = r4.y
            float r4 = (float) r4
            float r4 = r4 * r10
            int r4 = (int) r4
            if (r0 < r4) goto L_0x010b
            if (r8 >= r2) goto L_0x010b
            r2 = r8
            goto L_0x010b
        L_0x00fc:
            r30 = r5
            r31 = r8
            goto L_0x0107
        L_0x0101:
            r30 = r5
            r31 = r8
            r29 = r9
        L_0x0107:
            r32 = r10
            r33 = r15
        L_0x010b:
            int r6 = r6 + 1
            r0 = r27
            r4 = r28
            r9 = r29
            r5 = r30
            r8 = r31
            r10 = r32
            r15 = r33
            goto L_0x0086
        L_0x011d:
            r28 = r4
            r30 = r5
            r31 = r8
            r29 = r9
            r32 = r10
            r33 = r15
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r2 == r0) goto L_0x0153
            int r0 = r7.size()
            r4 = 1
            int r0 = r0 - r4
        L_0x0134:
            if (r0 < 0) goto L_0x0153
            java.lang.Object r4 = r7.get(r0)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            com.google.android.gms.internal.ads.zzlh r4 = r1.mo32143a(r4)
            int r4 = r4.mo31943b()
            r5 = -1
            if (r4 == r5) goto L_0x014d
            if (r4 <= r2) goto L_0x0150
        L_0x014d:
            r7.remove(r0)
        L_0x0150:
            int r0 = r0 + -1
            goto L_0x0134
        L_0x0153:
            goto L_0x0163
        L_0x0154:
            r27 = r0
            r28 = r4
            r30 = r5
            r31 = r8
            r29 = r9
            r32 = r10
            r33 = r15
        L_0x0162:
        L_0x0163:
            r0 = r12[r3]
            r5 = r20
            r6 = r21
            r8 = r22
            r4 = r28
            r2 = 0
        L_0x016f:
            int r9 = r1.f29212a
            if (r2 >= r9) goto L_0x021b
            r9 = r0[r2]
            boolean r9 = m31018b(r9, r11)
            if (r9 == 0) goto L_0x0207
            com.google.android.gms.internal.ads.zzlh r9 = r1.mo32143a(r2)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r2)
            boolean r10 = r7.contains(r10)
            if (r10 == 0) goto L_0x01a7
            int r10 = r9.f28788j
            r15 = -1
            if (r10 == r15) goto L_0x0194
            if (r10 > r13) goto L_0x0191
            goto L_0x0194
        L_0x0191:
            r15 = r33
            goto L_0x01a9
        L_0x0194:
            int r10 = r9.f28789k
            if (r10 == r15) goto L_0x019a
            if (r10 > r14) goto L_0x0191
        L_0x019a:
            int r10 = r9.f28780b
            if (r10 == r15) goto L_0x01a3
            r15 = r33
            if (r10 > r15) goto L_0x01a9
            goto L_0x01a5
        L_0x01a3:
            r15 = r33
        L_0x01a5:
            r10 = 1
            goto L_0x01aa
        L_0x01a7:
            r15 = r33
        L_0x01a9:
            r10 = 0
        L_0x01aa:
            if (r10 != 0) goto L_0x01b6
            if (r29 == 0) goto L_0x01af
            goto L_0x01b6
        L_0x01af:
            r22 = r0
            r20 = r1
            r21 = r4
            goto L_0x020f
        L_0x01b6:
            if (r10 == 0) goto L_0x01bc
            r20 = r1
            r1 = 2
            goto L_0x01bf
        L_0x01bc:
            r20 = r1
            r1 = 1
        L_0x01bf:
            r21 = r4
            r4 = r0[r2]
            r22 = r0
            r0 = 0
            boolean r4 = m31018b(r4, r0)
            if (r4 == 0) goto L_0x01ce
            int r1 = r1 + 1000
        L_0x01ce:
            if (r1 <= r5) goto L_0x01d2
            r0 = 1
            goto L_0x01d3
        L_0x01d2:
            r0 = 0
        L_0x01d3:
            if (r1 != r5) goto L_0x01f6
            int r0 = r9.mo31943b()
            if (r0 == r6) goto L_0x01e4
            int r0 = r9.mo31943b()
            int r0 = m31016a(r0, r6)
            goto L_0x01ea
        L_0x01e4:
            int r0 = r9.f28780b
            int r0 = m31016a(r0, r8)
        L_0x01ea:
            if (r4 == 0) goto L_0x01f1
            if (r10 == 0) goto L_0x01f1
            if (r0 <= 0) goto L_0x01f5
            goto L_0x01f3
        L_0x01f1:
            if (r0 >= 0) goto L_0x01f5
        L_0x01f3:
            r0 = 1
            goto L_0x01f6
        L_0x01f5:
            r0 = 0
        L_0x01f6:
            if (r0 == 0) goto L_0x020f
            int r8 = r9.f28780b
            int r6 = r9.mo31943b()
            r5 = r1
            r27 = r2
            r4 = r20
            goto L_0x0211
        L_0x0207:
            r22 = r0
            r20 = r1
            r21 = r4
            r15 = r33
        L_0x020f:
            r4 = r21
        L_0x0211:
            int r2 = r2 + 1
            r33 = r15
            r1 = r20
            r0 = r22
            goto L_0x016f
        L_0x021b:
            r21 = r4
            r15 = r33
            int r3 = r3 + 1
            r20 = r5
            r22 = r8
            r1 = r23
            r7 = r24
            r2 = r25
            r0 = r27
            r9 = r29
            r5 = r30
            r8 = r31
            r10 = r32
            r21 = r6
            r6 = r26
            goto L_0x0044
        L_0x023b:
            r27 = r0
            r25 = r2
            r28 = r4
            r26 = r6
            if (r28 != 0) goto L_0x0248
            r16 = 0
            goto L_0x0253
        L_0x0248:
            com.google.android.gms.internal.ads.zzri r10 = new com.google.android.gms.internal.ads.zzri
            r1 = r27
            r0 = r28
            r10.<init>(r0, r1)
            r16 = r10
        L_0x0253:
            r25[r26] = r16
            r0 = r25[r26]
            if (r0 == 0) goto L_0x025d
            r7 = 1
            goto L_0x0267
        L_0x025d:
            r7 = 0
            goto L_0x0267
        L_0x025f:
            r23 = r1
            r25 = r2
            r19 = r4
            r26 = r6
        L_0x0267:
            r0 = r36[r26]
            int r0 = r0.f29216b
            goto L_0x0274
        L_0x026c:
            r23 = r1
            r25 = r2
            r19 = r4
            r26 = r6
        L_0x0274:
            int r6 = r26 + 1
            r3 = r34
            r0 = r35
            r4 = r19
            r1 = r23
            r2 = r25
            goto L_0x0012
        L_0x0282:
            r23 = r1
            r25 = r2
            r19 = r4
            r0 = 0
            r1 = 0
            r2 = 0
        L_0x028c:
            r3 = r23
            if (r0 >= r3) goto L_0x049c
            r4 = r35[r0]
            int r4 = r4.mo31914d()
            r5 = 3
            r6 = 1
            if (r4 == r6) goto L_0x03ee
            r6 = 2
            if (r4 == r6) goto L_0x03df
            if (r4 == r5) goto L_0x0325
            r4 = r35[r0]
            r4.mo31914d()
            r4 = r36[r0]
            r5 = r37[r0]
            r6 = r19
            boolean r7 = r6.f29237i
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x02b3:
            int r12 = r4.f29216b
            if (r8 >= r12) goto L_0x030d
            com.google.android.gms.internal.ads.zzra r12 = r4.mo32147a(r8)
            r13 = r5[r8]
            r14 = r11
            r11 = r10
            r10 = r9
            r9 = 0
        L_0x02c1:
            int r15 = r12.f29212a
            if (r9 >= r15) goto L_0x0303
            r15 = r13[r9]
            boolean r15 = m31018b(r15, r7)
            if (r15 == 0) goto L_0x02f8
            com.google.android.gms.internal.ads.zzlh r15 = r12.mo32143a(r9)
            int r15 = r15.f28802x
            r18 = 1
            r15 = r15 & 1
            if (r15 == 0) goto L_0x02db
            r15 = 1
            goto L_0x02dc
        L_0x02db:
            r15 = 0
        L_0x02dc:
            if (r15 == 0) goto L_0x02e0
            r15 = 2
            goto L_0x02e1
        L_0x02e0:
            r15 = 1
        L_0x02e1:
            r23 = r3
            r3 = r13[r9]
            r19 = r4
            r4 = 0
            boolean r3 = m31018b(r3, r4)
            if (r3 == 0) goto L_0x02f0
            int r15 = r15 + 1000
        L_0x02f0:
            if (r15 <= r14) goto L_0x02fc
            r11 = r9
            r10 = r12
            r14 = r15
            goto L_0x02fc
        L_0x02f8:
            r23 = r3
            r19 = r4
        L_0x02fc:
            int r9 = r9 + 1
            r4 = r19
            r3 = r23
            goto L_0x02c1
        L_0x0303:
            r23 = r3
            r19 = r4
            int r8 = r8 + 1
            r9 = r10
            r10 = r11
            r11 = r14
            goto L_0x02b3
        L_0x030d:
            r23 = r3
            if (r9 != 0) goto L_0x0313
            r3 = 0
            goto L_0x0318
        L_0x0313:
            com.google.android.gms.internal.ads.zzri r3 = new com.google.android.gms.internal.ads.zzri
            r3.<init>(r9, r10)
        L_0x0318:
            r25[r0] = r3
            r21 = r2
            r2 = 0
            r3 = -1
            r15 = 0
            r17 = 2
            r18 = 1
            goto L_0x0494
        L_0x0325:
            r23 = r3
            r6 = r19
            if (r2 != 0) goto L_0x03d4
            r2 = r36[r0]
            r3 = r37[r0]
            boolean r4 = r6.f29237i
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x0338:
            int r12 = r2.f29216b
            if (r7 >= r12) goto L_0x03b7
            com.google.android.gms.internal.ads.zzra r12 = r2.mo32147a(r7)
            r13 = r3[r7]
            r14 = r11
            r11 = r10
            r10 = r9
            r9 = 0
        L_0x0346:
            int r15 = r12.f29212a
            if (r9 >= r15) goto L_0x03ac
            r15 = r13[r9]
            boolean r15 = m31018b(r15, r4)
            if (r15 == 0) goto L_0x03a2
            com.google.android.gms.internal.ads.zzlh r15 = r12.mo32143a(r9)
            int r5 = r15.f28802x
            r18 = 1
            r5 = r5 & 1
            if (r5 == 0) goto L_0x0360
            r5 = 1
            goto L_0x0361
        L_0x0360:
            r5 = 0
        L_0x0361:
            int r8 = r15.f28802x
            r17 = 2
            r8 = r8 & 2
            if (r8 == 0) goto L_0x036b
            r8 = 1
            goto L_0x036c
        L_0x036b:
            r8 = 0
        L_0x036c:
            r21 = r2
            r2 = 0
            boolean r22 = m31017a(r15, r2)
            if (r22 == 0) goto L_0x037f
            if (r5 == 0) goto L_0x0379
            r8 = 6
            goto L_0x038f
        L_0x0379:
            if (r8 != 0) goto L_0x037d
            r8 = 5
            goto L_0x038f
        L_0x037d:
            r8 = 4
            goto L_0x038f
        L_0x037f:
            if (r5 == 0) goto L_0x0383
            r8 = 3
            goto L_0x038f
        L_0x0383:
            if (r8 == 0) goto L_0x03a6
            r2 = 0
            boolean r5 = m31017a(r15, r2)
            if (r5 == 0) goto L_0x038e
            r8 = 2
            goto L_0x038f
        L_0x038e:
            r8 = 1
        L_0x038f:
            r2 = r13[r9]
            r5 = 0
            boolean r2 = m31018b(r2, r5)
            if (r2 == 0) goto L_0x039a
            int r8 = r8 + 1000
        L_0x039a:
            if (r8 <= r14) goto L_0x03a6
            r14 = r8
            r11 = r9
            r10 = r12
            goto L_0x03a6
        L_0x03a2:
            r21 = r2
            r17 = 2
        L_0x03a6:
            int r9 = r9 + 1
            r2 = r21
            r5 = 3
            goto L_0x0346
        L_0x03ac:
            r21 = r2
            r17 = 2
            int r7 = r7 + 1
            r9 = r10
            r10 = r11
            r11 = r14
            r5 = 3
            goto L_0x0338
        L_0x03b7:
            r17 = 2
            if (r9 != 0) goto L_0x03bd
            r2 = 0
            goto L_0x03c2
        L_0x03bd:
            com.google.android.gms.internal.ads.zzri r2 = new com.google.android.gms.internal.ads.zzri
            r2.<init>(r9, r10)
        L_0x03c2:
            r25[r0] = r2
            r2 = r25[r0]
            if (r2 == 0) goto L_0x03ca
            r2 = 1
            goto L_0x03cb
        L_0x03ca:
            r2 = 0
        L_0x03cb:
            r21 = r2
            r2 = 0
            r3 = -1
            r15 = 0
            r18 = 1
            goto L_0x0494
        L_0x03d4:
            r17 = 2
            r21 = r2
            r2 = 0
            r3 = -1
            r15 = 0
            r18 = 1
            goto L_0x0494
        L_0x03df:
            r23 = r3
            r6 = r19
            r17 = 2
            r21 = r2
            r2 = 0
            r3 = -1
            r15 = 0
            r18 = 1
            goto L_0x0494
        L_0x03ee:
            r23 = r3
            r6 = r19
            r17 = 2
            if (r1 != 0) goto L_0x048d
            r1 = r36[r0]
            r3 = r37[r0]
            boolean r4 = r6.f29237i
            r5 = 0
            r7 = -1
            r8 = -1
            r9 = 0
        L_0x0404:
            int r10 = r1.f29216b
            if (r5 >= r10) goto L_0x046f
            com.google.android.gms.internal.ads.zzra r10 = r1.mo32147a(r5)
            r11 = r3[r5]
            r12 = r9
            r9 = r8
            r8 = r7
            r7 = 0
        L_0x0412:
            int r13 = r10.f29212a
            if (r7 >= r13) goto L_0x0461
            r13 = r11[r7]
            boolean r13 = m31018b(r13, r4)
            if (r13 == 0) goto L_0x0456
            com.google.android.gms.internal.ads.zzlh r13 = r10.mo32143a(r7)
            r14 = r11[r7]
            int r15 = r13.f28802x
            r18 = 1
            r15 = r15 & 1
            if (r15 == 0) goto L_0x042e
            r15 = 1
            goto L_0x042f
        L_0x042e:
            r15 = 0
        L_0x042f:
            r21 = r2
            r2 = 0
            boolean r13 = m31017a(r13, r2)
            if (r13 == 0) goto L_0x043e
            if (r15 == 0) goto L_0x043c
            r13 = 4
            goto L_0x0443
        L_0x043c:
            r13 = 3
            goto L_0x0443
        L_0x043e:
            if (r15 == 0) goto L_0x0442
            r13 = 2
            goto L_0x0443
        L_0x0442:
            r13 = 1
        L_0x0443:
            r15 = 0
            boolean r14 = m31018b(r14, r15)
            if (r14 == 0) goto L_0x044c
            int r13 = r13 + 1000
        L_0x044c:
            if (r13 <= r12) goto L_0x045c
            r8 = r5
            r9 = r7
            r12 = r13
            goto L_0x045c
        L_0x0456:
            r21 = r2
            r2 = 0
            r15 = 0
            r18 = 1
        L_0x045c:
            int r7 = r7 + 1
            r2 = r21
            goto L_0x0412
        L_0x0461:
            r21 = r2
            r2 = 0
            r15 = 0
            r18 = 1
            int r5 = r5 + 1
            r7 = r8
            r8 = r9
            r9 = r12
            r2 = r21
            goto L_0x0404
        L_0x046f:
            r21 = r2
            r2 = 0
            r15 = 0
            r18 = 1
            r3 = -1
            if (r7 != r3) goto L_0x047a
            r10 = r2
            goto L_0x0483
        L_0x047a:
            com.google.android.gms.internal.ads.zzra r1 = r1.mo32147a(r7)
            com.google.android.gms.internal.ads.zzri r10 = new com.google.android.gms.internal.ads.zzri
            r10.<init>(r1, r8)
        L_0x0483:
            r25[r0] = r10
            r1 = r25[r0]
            if (r1 == 0) goto L_0x048b
            r1 = 1
            goto L_0x0494
        L_0x048b:
            r1 = 0
            goto L_0x0494
        L_0x048d:
            r21 = r2
            r2 = 0
            r3 = -1
            r15 = 0
            r18 = 1
        L_0x0494:
            int r0 = r0 + 1
            r19 = r6
            r2 = r21
            goto L_0x028c
        L_0x049c:
            return r25
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrg.mo32156a(com.google.android.gms.internal.ads.zzlp[], com.google.android.gms.internal.ads.zzrb[], int[][][]):com.google.android.gms.internal.ads.zzrm[]");
    }

    /* renamed from: a */
    private static int m31016a(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    /* renamed from: b */
    private static boolean m31018b(int i, boolean z) {
        int i2 = i & 3;
        return i2 == 3 || (z && i2 == 2);
    }

    /* renamed from: a */
    private static boolean m31017a(zzlh zzlh, String str) {
        return str != null && TextUtils.equals(str, zzsy.m31158c(zzlh.f28803y));
    }
}
