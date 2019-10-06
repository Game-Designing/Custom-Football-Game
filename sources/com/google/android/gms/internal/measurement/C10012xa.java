package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.measurement.xa */
final class C10012xa<T> implements C9906Fa<T> {

    /* renamed from: a */
    private static final int[] f30184a = new int[0];

    /* renamed from: b */
    private static final Unsafe f30185b = C9946_a.m32009d();

    /* renamed from: c */
    private final int[] f30186c;

    /* renamed from: d */
    private final Object[] f30187d;

    /* renamed from: e */
    private final int f30188e;

    /* renamed from: f */
    private final int f30189f;

    /* renamed from: g */
    private final zzvv f30190g;

    /* renamed from: h */
    private final boolean f30191h;

    /* renamed from: i */
    private final boolean f30192i;

    /* renamed from: j */
    private final boolean f30193j;

    /* renamed from: k */
    private final boolean f30194k;

    /* renamed from: l */
    private final int[] f30195l;

    /* renamed from: m */
    private final int f30196m;

    /* renamed from: n */
    private final int f30197n;

    /* renamed from: o */
    private final C10016za f30198o;

    /* renamed from: p */
    private final C9976ia f30199p;

    /* renamed from: q */
    private final C9939Wa<?, ?> f30200q;

    /* renamed from: r */
    private final C9938W<?> f30201r;

    /* renamed from: s */
    private final C10000ra f30202s;

    private C10012xa(int[] iArr, Object[] objArr, int i, int i2, zzvv zzvv, boolean z, boolean z2, int[] iArr2, int i3, int i4, C10016za zaVar, C9976ia iaVar, C9939Wa<?, ?> wa, C9938W<?> w, C10000ra raVar) {
        this.f30186c = iArr;
        this.f30187d = objArr;
        this.f30188e = i;
        this.f30189f = i2;
        this.f30192i = zzvv instanceof zzuo;
        this.f30193j = z;
        this.f30191h = w != null && w.mo32664a(zzvv);
        this.f30194k = false;
        this.f30195l = iArr2;
        this.f30196m = i3;
        this.f30197n = i4;
        this.f30198o = zaVar;
        this.f30199p = iaVar;
        this.f30200q = wa;
        this.f30201r = w;
        this.f30190g = zzvv;
        this.f30202s = raVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:169:0x0396  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.measurement.C10012xa<T> m32215a(java.lang.Class<T> r35, com.google.android.gms.internal.measurement.C10006ua r36, com.google.android.gms.internal.measurement.C10016za r37, com.google.android.gms.internal.measurement.C9976ia r38, com.google.android.gms.internal.measurement.C9939Wa<?, ?> r39, com.google.android.gms.internal.measurement.C9938W<?> r40, com.google.android.gms.internal.measurement.C10000ra r41) {
        /*
            r0 = r36
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.C9904Ea
            if (r1 == 0) goto L_0x0461
            com.google.android.gms.internal.measurement.Ea r0 = (com.google.android.gms.internal.measurement.C9904Ea) r0
            int r1 = r0.mo32551h()
            int r2 = com.google.android.gms.internal.measurement.zzuo.zze.f30337j
            r3 = 0
            if (r1 != r2) goto L_0x0013
            r11 = 1
            goto L_0x0014
        L_0x0013:
            r11 = 0
        L_0x0014:
            java.lang.String r1 = r0.mo32547a()
            int r2 = r1.length()
            char r5 = r1.charAt(r3)
            r7 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r7) goto L_0x003f
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            r8 = r5
            r5 = 1
            r9 = 13
        L_0x002c:
            int r10 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r7) goto L_0x003c
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r9
            r8 = r8 | r5
            int r9 = r9 + 13
            r5 = r10
            goto L_0x002c
        L_0x003c:
            int r5 = r5 << r9
            r5 = r5 | r8
            goto L_0x0040
        L_0x003f:
            r10 = 1
        L_0x0040:
            int r8 = r10 + 1
            char r9 = r1.charAt(r10)
            if (r9 < r7) goto L_0x0060
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x004d:
            int r12 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x005d
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r10
            r9 = r9 | r8
            int r10 = r10 + 13
            r8 = r12
            goto L_0x004d
        L_0x005d:
            int r8 = r8 << r10
            r9 = r9 | r8
            goto L_0x0061
        L_0x0060:
            r12 = r8
        L_0x0061:
            if (r9 != 0) goto L_0x0076
            int[] r8 = f30184a
            r15 = r8
            r8 = 0
            r9 = 0
            r10 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            goto L_0x01b0
        L_0x0076:
            int r8 = r12 + 1
            char r9 = r1.charAt(r12)
            if (r9 < r7) goto L_0x0096
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0082:
            int r12 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x0092
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r10
            r9 = r9 | r8
            int r10 = r10 + 13
            r8 = r12
            goto L_0x0082
        L_0x0092:
            int r8 = r8 << r10
            r8 = r8 | r9
            r9 = r8
            goto L_0x0097
        L_0x0096:
            r12 = r8
        L_0x0097:
            int r8 = r12 + 1
            char r10 = r1.charAt(r12)
            if (r10 < r7) goto L_0x00b7
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00a4:
            int r13 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x00b4
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r12
            r10 = r10 | r8
            int r12 = r12 + 13
            r8 = r13
            goto L_0x00a4
        L_0x00b4:
            int r8 = r8 << r12
            r10 = r10 | r8
            goto L_0x00b8
        L_0x00b7:
            r13 = r8
        L_0x00b8:
            int r8 = r13 + 1
            char r12 = r1.charAt(r13)
            if (r12 < r7) goto L_0x00d9
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00c5:
            int r14 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x00d5
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r13
            r12 = r12 | r8
            int r13 = r13 + 13
            r8 = r14
            goto L_0x00c5
        L_0x00d5:
            int r8 = r8 << r13
            r8 = r8 | r12
            r12 = r8
            goto L_0x00da
        L_0x00d9:
            r14 = r8
        L_0x00da:
            int r8 = r14 + 1
            char r13 = r1.charAt(r14)
            if (r13 < r7) goto L_0x00fb
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00e7:
            int r15 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x00f7
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r14
            r13 = r13 | r8
            int r14 = r14 + 13
            r8 = r15
            goto L_0x00e7
        L_0x00f7:
            int r8 = r8 << r14
            r8 = r8 | r13
            r13 = r8
            goto L_0x00fc
        L_0x00fb:
            r15 = r8
        L_0x00fc:
            int r8 = r15 + 1
            char r14 = r1.charAt(r15)
            if (r14 < r7) goto L_0x011f
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0109:
            int r16 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x011a
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r15
            r14 = r14 | r8
            int r15 = r15 + 13
            r8 = r16
            goto L_0x0109
        L_0x011a:
            int r8 = r8 << r15
            r8 = r8 | r14
            r14 = r8
            r8 = r16
        L_0x011f:
            int r15 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x0143
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x012c:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r7) goto L_0x013e
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r8 = r8 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x012c
        L_0x013e:
            int r15 = r15 << r16
            r8 = r8 | r15
            r15 = r17
        L_0x0143:
            int r16 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r7) goto L_0x0170
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r17 = 13
            r34 = r16
            r16 = r15
            r15 = r34
        L_0x0156:
            int r18 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r7) goto L_0x0169
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r17
            r16 = r16 | r15
            int r17 = r17 + 13
            r15 = r18
            goto L_0x0156
        L_0x0169:
            int r15 = r15 << r17
            r15 = r16 | r15
            r3 = r18
            goto L_0x0172
        L_0x0170:
            r3 = r16
        L_0x0172:
            int r16 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r7) goto L_0x019e
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r17 = 13
            r34 = r16
            r16 = r3
            r3 = r34
        L_0x0185:
            int r18 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r7) goto L_0x0198
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r17
            r16 = r16 | r3
            int r17 = r17 + 13
            r3 = r18
            goto L_0x0185
        L_0x0198:
            int r3 = r3 << r17
            r3 = r16 | r3
            r16 = r18
        L_0x019e:
            int r17 = r3 + r8
            int r15 = r17 + r15
            int[] r15 = new int[r15]
            int r17 = r9 << 1
            int r10 = r17 + r10
            r34 = r16
            r16 = r9
            r9 = r12
            r12 = r34
        L_0x01b0:
            sun.misc.Unsafe r6 = f30185b
            java.lang.Object[] r17 = r0.mo32548b()
            com.google.android.gms.internal.measurement.zzvv r18 = r0.mo32549f()
            java.lang.Class r7 = r18.getClass()
            int r4 = r14 * 3
            int[] r4 = new int[r4]
            r18 = 1
            int r14 = r14 << 1
            java.lang.Object[] r14 = new java.lang.Object[r14]
            int r20 = r3 + r8
            r22 = r3
            r23 = r20
            r8 = 0
            r21 = 0
        L_0x01d3:
            if (r12 >= r2) goto L_0x0438
            int r24 = r12 + 1
            char r12 = r1.charAt(r12)
            r25 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r12 < r2) goto L_0x0209
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
            r34 = r24
            r24 = r12
            r12 = r34
        L_0x01ec:
            int r27 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r2) goto L_0x0202
            r2 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r26
            r24 = r24 | r2
            int r26 = r26 + 13
            r12 = r27
            r2 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01ec
        L_0x0202:
            int r2 = r12 << r26
            r12 = r24 | r2
            r2 = r27
            goto L_0x020b
        L_0x0209:
            r2 = r24
        L_0x020b:
            int r24 = r2 + 1
            char r2 = r1.charAt(r2)
            r26 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r3) goto L_0x0240
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r27 = 13
            r34 = r24
            r24 = r2
            r2 = r34
        L_0x0223:
            int r28 = r2 + 1
            char r2 = r1.charAt(r2)
            if (r2 < r3) goto L_0x0239
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r27
            r24 = r24 | r2
            int r27 = r27 + 13
            r2 = r28
            r3 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0223
        L_0x0239:
            int r2 = r2 << r27
            r2 = r24 | r2
            r3 = r28
            goto L_0x0242
        L_0x0240:
            r3 = r24
        L_0x0242:
            r24 = r11
            r11 = r2 & 255(0xff, float:3.57E-43)
            r27 = r13
            r13 = r2 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0252
            int r13 = r8 + 1
            r15[r8] = r21
            r8 = r13
        L_0x0252:
            r13 = 51
            r30 = r8
            if (r11 < r13) goto L_0x02f8
            int r13 = r3 + 1
            char r3 = r1.charAt(r3)
            r8 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r8) goto L_0x0281
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r32 = 13
        L_0x0267:
            int r33 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r8) goto L_0x027c
            r8 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r32
            r3 = r3 | r8
            int r32 = r32 + 13
            r13 = r33
            r8 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0267
        L_0x027c:
            int r8 = r13 << r32
            r3 = r3 | r8
            r13 = r33
        L_0x0281:
            int r8 = r11 + -51
            r32 = r13
            r13 = 9
            if (r8 == r13) goto L_0x02a7
            r13 = 17
            if (r8 != r13) goto L_0x028f
            goto L_0x02a7
        L_0x028f:
            r13 = 12
            if (r8 != r13) goto L_0x02a5
            r8 = r5 & 1
            r13 = 1
            if (r8 != r13) goto L_0x02a5
            int r8 = r21 / 3
            int r8 = r8 << r13
            int r8 = r8 + r13
            int r13 = r10 + 1
            r10 = r17[r10]
            r14[r8] = r10
            r10 = r13
            r13 = 1
            goto L_0x02b4
        L_0x02a5:
            r13 = 1
            goto L_0x02b4
        L_0x02a7:
            int r8 = r21 / 3
            r13 = 1
            int r8 = r8 << r13
            int r8 = r8 + r13
            int r18 = r10 + 1
            r10 = r17[r10]
            r14[r8] = r10
            r10 = r18
        L_0x02b4:
            int r3 = r3 << r13
            r8 = r17[r3]
            boolean r13 = r8 instanceof java.lang.reflect.Field
            if (r13 == 0) goto L_0x02be
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
            goto L_0x02c6
        L_0x02be:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = m32216a(r7, r8)
            r17[r3] = r8
        L_0x02c6:
            r13 = r9
            long r8 = r6.objectFieldOffset(r8)
            int r9 = (int) r8
            int r3 = r3 + 1
            r8 = r17[r3]
            r28 = r9
            boolean r9 = r8 instanceof java.lang.reflect.Field
            if (r9 == 0) goto L_0x02d9
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
            goto L_0x02e1
        L_0x02d9:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = m32216a(r7, r8)
            r17[r3] = r8
        L_0x02e1:
            long r8 = r6.objectFieldOffset(r8)
            int r3 = (int) r8
            r31 = r1
            r8 = r3
            r1 = r7
            r19 = r10
            r9 = r28
            r10 = r32
            r3 = 0
            r18 = 1
            r28 = r13
            goto L_0x0400
        L_0x02f8:
            r13 = r9
            int r8 = r10 + 1
            r9 = r17[r10]
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = m32216a(r7, r9)
            r10 = 9
            if (r11 == r10) goto L_0x0380
            r10 = 17
            if (r11 != r10) goto L_0x0310
            r28 = r13
            r13 = 1
            goto L_0x0383
        L_0x0310:
            r10 = 27
            if (r11 == r10) goto L_0x0370
            r10 = 49
            if (r11 != r10) goto L_0x031b
            r28 = r13
            goto L_0x0372
        L_0x031b:
            r10 = 12
            if (r11 == r10) goto L_0x035a
            r10 = 30
            if (r11 == r10) goto L_0x035a
            r10 = 44
            if (r11 != r10) goto L_0x0328
            goto L_0x035a
        L_0x0328:
            r10 = 50
            if (r11 != r10) goto L_0x0356
            int r10 = r22 + 1
            r15[r22] = r21
            int r22 = r21 / 3
            r18 = 1
            int r22 = r22 << 1
            int r28 = r8 + 1
            r8 = r17[r8]
            r14[r22] = r8
            r8 = r2 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x034e
            int r22 = r22 + 1
            int r8 = r28 + 1
            r28 = r17[r28]
            r14[r22] = r28
            r22 = r10
            r28 = r13
            r13 = 1
            goto L_0x038d
        L_0x034e:
            r22 = r10
            r8 = r28
            r28 = r13
            r13 = 1
            goto L_0x038d
        L_0x0356:
            r28 = r13
            r13 = 1
            goto L_0x038d
        L_0x035a:
            r10 = r5 & 1
            r28 = r13
            r13 = 1
            if (r10 != r13) goto L_0x036e
            int r10 = r21 / 3
            int r10 = r10 << r13
            int r10 = r10 + r13
            int r13 = r8 + 1
            r8 = r17[r8]
            r14[r10] = r8
            r8 = r13
            r13 = 1
            goto L_0x038d
        L_0x036e:
            r13 = 1
            goto L_0x038d
        L_0x0370:
            r28 = r13
        L_0x0372:
            int r10 = r21 / 3
            r13 = 1
            int r10 = r10 << r13
            int r10 = r10 + r13
            int r18 = r8 + 1
            r8 = r17[r8]
            r14[r10] = r8
            r8 = r18
            goto L_0x038d
        L_0x0380:
            r28 = r13
            r13 = 1
        L_0x0383:
            int r10 = r21 / 3
            int r10 = r10 << r13
            int r10 = r10 + r13
            java.lang.Class r18 = r9.getType()
            r14[r10] = r18
        L_0x038d:
            long r9 = r6.objectFieldOffset(r9)
            int r9 = (int) r9
            r10 = r5 & 1
            if (r10 != r13) goto L_0x03e7
            r10 = 17
            if (r11 > r10) goto L_0x03e7
            int r10 = r3 + 1
            char r3 = r1.charAt(r3)
            r13 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r13) goto L_0x03c0
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r19 = 13
        L_0x03a9:
            int r29 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r13) goto L_0x03bb
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r19
            r3 = r3 | r10
            int r19 = r19 + 13
            r10 = r29
            goto L_0x03a9
        L_0x03bb:
            int r10 = r10 << r19
            r3 = r3 | r10
            r10 = r29
        L_0x03c0:
            r18 = 1
            int r19 = r16 << 1
            int r29 = r3 / 32
            int r19 = r19 + r29
            r13 = r17[r19]
            r31 = r1
            boolean r1 = r13 instanceof java.lang.reflect.Field
            if (r1 == 0) goto L_0x03d4
            java.lang.reflect.Field r13 = (java.lang.reflect.Field) r13
            goto L_0x03dc
        L_0x03d4:
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = m32216a(r7, r13)
            r17[r19] = r13
        L_0x03dc:
            r1 = r7
            r19 = r8
            long r7 = r6.objectFieldOffset(r13)
            int r8 = (int) r7
            int r3 = r3 % 32
            goto L_0x03f2
        L_0x03e7:
            r31 = r1
            r1 = r7
            r19 = r8
            r18 = 1
            r10 = r3
            r3 = 0
            r8 = 0
        L_0x03f2:
            r7 = 18
            if (r11 < r7) goto L_0x0400
            r7 = 49
            if (r11 > r7) goto L_0x0400
            int r7 = r23 + 1
            r15[r23] = r9
            r23 = r7
        L_0x0400:
            int r7 = r21 + 1
            r4[r21] = r12
            int r12 = r7 + 1
            r13 = r2 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x040d
            r13 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x040e
        L_0x040d:
            r13 = 0
        L_0x040e:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0415
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0416
        L_0x0415:
            r2 = 0
        L_0x0416:
            r2 = r2 | r13
            int r11 = r11 << 20
            r2 = r2 | r11
            r2 = r2 | r9
            r4[r7] = r2
            int r21 = r12 + 1
            int r2 = r3 << 20
            r2 = r2 | r8
            r4[r12] = r2
            r7 = r1
            r12 = r10
            r10 = r19
            r11 = r24
            r2 = r25
            r3 = r26
            r13 = r27
            r9 = r28
            r8 = r30
            r1 = r31
            goto L_0x01d3
        L_0x0438:
            r26 = r3
            r28 = r9
            r24 = r11
            r27 = r13
            com.google.android.gms.internal.measurement.xa r1 = new com.google.android.gms.internal.measurement.xa
            com.google.android.gms.internal.measurement.zzvv r10 = r0.mo32549f()
            r12 = 0
            r5 = r1
            r6 = r4
            r7 = r14
            r8 = r28
            r9 = r27
            r13 = r15
            r14 = r26
            r15 = r20
            r16 = r37
            r17 = r38
            r18 = r39
            r19 = r40
            r20 = r41
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r1
        L_0x0461:
            com.google.android.gms.internal.measurement.Sa r0 = (com.google.android.gms.internal.measurement.C9931Sa) r0
            r0.mo32551h()
            r0 = 0
            goto L_0x0469
        L_0x0468:
            throw r0
        L_0x0469:
            goto L_0x0468
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C10012xa.m32215a(java.lang.Class, com.google.android.gms.internal.measurement.ua, com.google.android.gms.internal.measurement.za, com.google.android.gms.internal.measurement.ia, com.google.android.gms.internal.measurement.Wa, com.google.android.gms.internal.measurement.W, com.google.android.gms.internal.measurement.ra):com.google.android.gms.internal.measurement.xa");
    }

    /* renamed from: a */
    private static Field m32216a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    /* renamed from: b */
    public final boolean mo32556b(T t, T t2) {
        int length = this.f30186c.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                int c = m32233c(i);
                long j = (long) (c & 1048575);
                switch ((c & 267386880) >>> 20) {
                    case 0:
                        if (!m32234c(t, t2, i) || Double.doubleToLongBits(C9946_a.m32013e(t, j)) != Double.doubleToLongBits(C9946_a.m32013e(t2, j))) {
                            z = false;
                            break;
                        }
                    case 1:
                        if (!m32234c(t, t2, i) || Float.floatToIntBits(C9946_a.m32008d(t, j)) != Float.floatToIntBits(C9946_a.m32008d(t2, j))) {
                            z = false;
                            break;
                        }
                    case 2:
                        if (!m32234c(t, t2, i) || C9946_a.m31999b(t, j) != C9946_a.m31999b(t2, j)) {
                            z = false;
                            break;
                        }
                    case 3:
                        if (!m32234c(t, t2, i) || C9946_a.m31999b(t, j) != C9946_a.m31999b(t2, j)) {
                            z = false;
                            break;
                        }
                    case 4:
                        if (!m32234c(t, t2, i) || C9946_a.m31986a((Object) t, j) != C9946_a.m31986a((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 5:
                        if (!m32234c(t, t2, i) || C9946_a.m31999b(t, j) != C9946_a.m31999b(t2, j)) {
                            z = false;
                            break;
                        }
                    case 6:
                        if (!m32234c(t, t2, i) || C9946_a.m31986a((Object) t, j) != C9946_a.m31986a((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 7:
                        if (!m32234c(t, t2, i) || C9946_a.m32007c(t, j) != C9946_a.m32007c(t2, j)) {
                            z = false;
                            break;
                        }
                    case 8:
                        if (!m32234c(t, t2, i) || !C9910Ha.m31803a(C9946_a.m32016f(t, j), C9946_a.m32016f(t2, j))) {
                            z = false;
                            break;
                        }
                    case 9:
                        if (!m32234c(t, t2, i) || !C9910Ha.m31803a(C9946_a.m32016f(t, j), C9946_a.m32016f(t2, j))) {
                            z = false;
                            break;
                        }
                    case 10:
                        if (!m32234c(t, t2, i) || !C9910Ha.m31803a(C9946_a.m32016f(t, j), C9946_a.m32016f(t2, j))) {
                            z = false;
                            break;
                        }
                    case 11:
                        if (!m32234c(t, t2, i) || C9946_a.m31986a((Object) t, j) != C9946_a.m31986a((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 12:
                        if (!m32234c(t, t2, i) || C9946_a.m31986a((Object) t, j) != C9946_a.m31986a((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 13:
                        if (!m32234c(t, t2, i) || C9946_a.m31986a((Object) t, j) != C9946_a.m31986a((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 14:
                        if (!m32234c(t, t2, i) || C9946_a.m31999b(t, j) != C9946_a.m31999b(t2, j)) {
                            z = false;
                            break;
                        }
                    case 15:
                        if (!m32234c(t, t2, i) || C9946_a.m31986a((Object) t, j) != C9946_a.m31986a((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 16:
                        if (!m32234c(t, t2, i) || C9946_a.m31999b(t, j) != C9946_a.m31999b(t2, j)) {
                            z = false;
                            break;
                        }
                    case 17:
                        if (!m32234c(t, t2, i) || !C9910Ha.m31803a(C9946_a.m32016f(t, j), C9946_a.m32016f(t2, j))) {
                            z = false;
                            break;
                        }
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        z = C9910Ha.m31803a(C9946_a.m32016f(t, j), C9946_a.m32016f(t2, j));
                        break;
                    case 50:
                        z = C9910Ha.m31803a(C9946_a.m32016f(t, j), C9946_a.m32016f(t2, j));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long d = (long) (m32235d(i) & 1048575);
                        if (C9946_a.m31986a((Object) t, d) != C9946_a.m31986a((Object) t2, d) || !C9910Ha.m31803a(C9946_a.m32016f(t, j), C9946_a.m32016f(t2, j))) {
                            z = false;
                            break;
                        }
                }
                if (!z) {
                    return false;
                }
                i += 3;
            } else if (!this.f30200q.mo32670b(t).equals(this.f30200q.mo32670b(t2))) {
                return false;
            } else {
                if (this.f30191h) {
                    return this.f30201r.mo32662a((Object) t).equals(this.f30201r.mo32662a((Object) t2));
                }
                return true;
            }
        }
    }

    /* renamed from: a */
    public final int mo32552a(T t) {
        int length = this.f30186c.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int c = m32233c(i2);
            int i3 = this.f30186c[i2];
            long j = (long) (1048575 & c);
            int i4 = 37;
            switch ((c & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + zzuq.m32537a(Double.doubleToLongBits(C9946_a.m32013e(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(C9946_a.m32008d(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzuq.m32537a(C9946_a.m31999b(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzuq.m32537a(C9946_a.m31999b(t, j));
                    break;
                case 4:
                    i = (i * 53) + C9946_a.m31986a((Object) t, j);
                    break;
                case 5:
                    i = (i * 53) + zzuq.m32537a(C9946_a.m31999b(t, j));
                    break;
                case 6:
                    i = (i * 53) + C9946_a.m31986a((Object) t, j);
                    break;
                case 7:
                    i = (i * 53) + zzuq.m32538a(C9946_a.m32007c(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) C9946_a.m32016f(t, j)).hashCode();
                    break;
                case 9:
                    Object f = C9946_a.m32016f(t, j);
                    if (f != null) {
                        i4 = f.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 10:
                    i = (i * 53) + C9946_a.m32016f(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + C9946_a.m31986a((Object) t, j);
                    break;
                case 12:
                    i = (i * 53) + C9946_a.m31986a((Object) t, j);
                    break;
                case 13:
                    i = (i * 53) + C9946_a.m31986a((Object) t, j);
                    break;
                case 14:
                    i = (i * 53) + zzuq.m32537a(C9946_a.m31999b(t, j));
                    break;
                case 15:
                    i = (i * 53) + C9946_a.m31986a((Object) t, j);
                    break;
                case 16:
                    i = (i * 53) + zzuq.m32537a(C9946_a.m31999b(t, j));
                    break;
                case 17:
                    Object f2 = C9946_a.m32016f(t, j);
                    if (f2 != null) {
                        i4 = f2.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = (i * 53) + C9946_a.m32016f(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + C9946_a.m32016f(t, j).hashCode();
                    break;
                case 51:
                    if (!m32223a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzuq.m32537a(Double.doubleToLongBits(m32226b(t, j)));
                        break;
                    }
                case 52:
                    if (!m32223a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + Float.floatToIntBits(m32232c(t, j));
                        break;
                    }
                case 53:
                    if (!m32223a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzuq.m32537a(m32237e(t, j));
                        break;
                    }
                case 54:
                    if (!m32223a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzuq.m32537a(m32237e(t, j));
                        break;
                    }
                case 55:
                    if (!m32223a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + m32236d(t, j);
                        break;
                    }
                case 56:
                    if (!m32223a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzuq.m32537a(m32237e(t, j));
                        break;
                    }
                case 57:
                    if (!m32223a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + m32236d(t, j);
                        break;
                    }
                case 58:
                    if (!m32223a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzuq.m32538a(m32238f(t, j));
                        break;
                    }
                case 59:
                    if (!m32223a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + ((String) C9946_a.m32016f(t, j)).hashCode();
                        break;
                    }
                case 60:
                    if (!m32223a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + C9946_a.m32016f(t, j).hashCode();
                        break;
                    }
                case 61:
                    if (!m32223a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + C9946_a.m32016f(t, j).hashCode();
                        break;
                    }
                case 62:
                    if (!m32223a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + m32236d(t, j);
                        break;
                    }
                case 63:
                    if (!m32223a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + m32236d(t, j);
                        break;
                    }
                case 64:
                    if (!m32223a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + m32236d(t, j);
                        break;
                    }
                case 65:
                    if (!m32223a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzuq.m32537a(m32237e(t, j));
                        break;
                    }
                case 66:
                    if (!m32223a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + m32236d(t, j);
                        break;
                    }
                case 67:
                    if (!m32223a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzuq.m32537a(m32237e(t, j));
                        break;
                    }
                case 68:
                    if (!m32223a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + C9946_a.m32016f(t, j).hashCode();
                        break;
                    }
            }
        }
        int hashCode = (i * 53) + this.f30200q.mo32670b(t).hashCode();
        if (this.f30191h) {
            return (hashCode * 53) + this.f30201r.mo32662a((Object) t).hashCode();
        }
        return hashCode;
    }

    /* renamed from: a */
    public final void mo32554a(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.f30186c.length; i += 3) {
                int c = m32233c(i);
                long j = (long) (1048575 & c);
                int i2 = this.f30186c[i];
                switch ((c & 267386880) >>> 20) {
                    case 0:
                        if (!m32222a(t2, i)) {
                            break;
                        } else {
                            C9946_a.m31990a((Object) t, j, C9946_a.m32013e(t2, j));
                            m32228b(t, i);
                            break;
                        }
                    case 1:
                        if (!m32222a(t2, i)) {
                            break;
                        } else {
                            C9946_a.m31991a((Object) t, j, C9946_a.m32008d(t2, j));
                            m32228b(t, i);
                            break;
                        }
                    case 2:
                        if (!m32222a(t2, i)) {
                            break;
                        } else {
                            C9946_a.m31993a((Object) t, j, C9946_a.m31999b(t2, j));
                            m32228b(t, i);
                            break;
                        }
                    case 3:
                        if (!m32222a(t2, i)) {
                            break;
                        } else {
                            C9946_a.m31993a((Object) t, j, C9946_a.m31999b(t2, j));
                            m32228b(t, i);
                            break;
                        }
                    case 4:
                        if (!m32222a(t2, i)) {
                            break;
                        } else {
                            C9946_a.m31992a((Object) t, j, C9946_a.m31986a((Object) t2, j));
                            m32228b(t, i);
                            break;
                        }
                    case 5:
                        if (!m32222a(t2, i)) {
                            break;
                        } else {
                            C9946_a.m31993a((Object) t, j, C9946_a.m31999b(t2, j));
                            m32228b(t, i);
                            break;
                        }
                    case 6:
                        if (!m32222a(t2, i)) {
                            break;
                        } else {
                            C9946_a.m31992a((Object) t, j, C9946_a.m31986a((Object) t2, j));
                            m32228b(t, i);
                            break;
                        }
                    case 7:
                        if (!m32222a(t2, i)) {
                            break;
                        } else {
                            C9946_a.m31995a((Object) t, j, C9946_a.m32007c(t2, j));
                            m32228b(t, i);
                            break;
                        }
                    case 8:
                        if (!m32222a(t2, i)) {
                            break;
                        } else {
                            C9946_a.m31994a((Object) t, j, C9946_a.m32016f(t2, j));
                            m32228b(t, i);
                            break;
                        }
                    case 9:
                        m32221a(t, t2, i);
                        break;
                    case 10:
                        if (!m32222a(t2, i)) {
                            break;
                        } else {
                            C9946_a.m31994a((Object) t, j, C9946_a.m32016f(t2, j));
                            m32228b(t, i);
                            break;
                        }
                    case 11:
                        if (!m32222a(t2, i)) {
                            break;
                        } else {
                            C9946_a.m31992a((Object) t, j, C9946_a.m31986a((Object) t2, j));
                            m32228b(t, i);
                            break;
                        }
                    case 12:
                        if (!m32222a(t2, i)) {
                            break;
                        } else {
                            C9946_a.m31992a((Object) t, j, C9946_a.m31986a((Object) t2, j));
                            m32228b(t, i);
                            break;
                        }
                    case 13:
                        if (!m32222a(t2, i)) {
                            break;
                        } else {
                            C9946_a.m31992a((Object) t, j, C9946_a.m31986a((Object) t2, j));
                            m32228b(t, i);
                            break;
                        }
                    case 14:
                        if (!m32222a(t2, i)) {
                            break;
                        } else {
                            C9946_a.m31993a((Object) t, j, C9946_a.m31999b(t2, j));
                            m32228b(t, i);
                            break;
                        }
                    case 15:
                        if (!m32222a(t2, i)) {
                            break;
                        } else {
                            C9946_a.m31992a((Object) t, j, C9946_a.m31986a((Object) t2, j));
                            m32228b(t, i);
                            break;
                        }
                    case 16:
                        if (!m32222a(t2, i)) {
                            break;
                        } else {
                            C9946_a.m31993a((Object) t, j, C9946_a.m31999b(t2, j));
                            m32228b(t, i);
                            break;
                        }
                    case 17:
                        m32221a(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.f30199p.mo32735a(t, t2, j);
                        break;
                    case 50:
                        C9910Ha.m31801a(this.f30202s, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!m32223a(t2, i2, i)) {
                            break;
                        } else {
                            C9946_a.m31994a((Object) t, j, C9946_a.m32016f(t2, j));
                            m32229b(t, i2, i);
                            break;
                        }
                    case 60:
                        m32231b(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!m32223a(t2, i2, i)) {
                            break;
                        } else {
                            C9946_a.m31994a((Object) t, j, C9946_a.m32016f(t2, j));
                            m32229b(t, i2, i);
                            break;
                        }
                    case 68:
                        m32231b(t, t2, i);
                        break;
                }
            }
            if (!this.f30193j) {
                C9910Ha.m31800a(this.f30200q, t, t2);
                if (this.f30191h) {
                    C9910Ha.m31799a(this.f30201r, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    private final void m32221a(T t, T t2, int i) {
        long c = (long) (m32233c(i) & 1048575);
        if (m32222a(t2, i)) {
            Object f = C9946_a.m32016f(t, c);
            Object f2 = C9946_a.m32016f(t2, c);
            if (f == null || f2 == null) {
                if (f2 != null) {
                    C9946_a.m31994a((Object) t, c, f2);
                    m32228b(t, i);
                }
                return;
            }
            C9946_a.m31994a((Object) t, c, zzuq.m32541a(f, f2));
            m32228b(t, i);
        }
    }

    /* renamed from: b */
    private final void m32231b(T t, T t2, int i) {
        int c = m32233c(i);
        int i2 = this.f30186c[i];
        long j = (long) (c & 1048575);
        if (m32223a(t2, i2, i)) {
            Object f = C9946_a.m32016f(t, j);
            Object f2 = C9946_a.m32016f(t2, j);
            if (f == null || f2 == null) {
                if (f2 != null) {
                    C9946_a.m31994a((Object) t, j, f2);
                    m32229b(t, i2, i);
                }
                return;
            }
            C9946_a.m31994a((Object) t, j, zzuq.m32541a(f, f2));
            m32229b(t, i2, i);
        }
    }

    /* renamed from: b */
    public final int mo32555b(T t) {
        int i;
        int i2;
        long j;
        int i3;
        T t2 = t;
        int i4 = 267386880;
        if (this.f30193j) {
            Unsafe unsafe = f30185b;
            int i5 = 0;
            int i6 = 0;
            while (i5 < this.f30186c.length) {
                int c = m32233c(i5);
                int i7 = (c & i4) >>> 20;
                int i8 = this.f30186c[i5];
                long j2 = (long) (c & 1048575);
                if (i7 < zzui.DOUBLE_LIST_PACKED.mo32891e() || i7 > zzui.SINT64_LIST_PACKED.mo32891e()) {
                    i3 = 0;
                } else {
                    i3 = this.f30186c[i5 + 2] & 1048575;
                }
                switch (i7) {
                    case 0:
                        if (!m32222a(t2, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32412b(i8, 0.0d);
                            break;
                        }
                    case 1:
                        if (!m32222a(t2, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32413b(i8, 0.0f);
                            break;
                        }
                    case 2:
                        if (!m32222a(t2, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32426d(i8, C9946_a.m31999b(t2, j2));
                            break;
                        }
                    case 3:
                        if (!m32222a(t2, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32430e(i8, C9946_a.m31999b(t2, j2));
                            break;
                        }
                    case 4:
                        if (!m32222a(t2, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32433f(i8, C9946_a.m31986a((Object) t2, j2));
                            break;
                        }
                    case 5:
                        if (!m32222a(t2, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32438g(i8, 0);
                            break;
                        }
                    case 6:
                        if (!m32222a(t2, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32445i(i8, 0);
                            break;
                        }
                    case 7:
                        if (!m32222a(t2, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32418b(i8, true);
                            break;
                        }
                    case 8:
                        if (!m32222a(t2, i5)) {
                            break;
                        } else {
                            Object f = C9946_a.m32016f(t2, j2);
                            if (!(f instanceof zzte)) {
                                i6 += zztv.m32417b(i8, (String) f);
                                break;
                            } else {
                                i6 += zztv.m32423c(i8, (zzte) f);
                                break;
                            }
                        }
                    case 9:
                        if (!m32222a(t2, i5)) {
                            break;
                        } else {
                            i6 += C9910Ha.m31789a(i8, C9946_a.m32016f(t2, j2), m32214a(i5));
                            break;
                        }
                    case 10:
                        if (!m32222a(t2, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32423c(i8, (zzte) C9946_a.m32016f(t2, j2));
                            break;
                        }
                    case 11:
                        if (!m32222a(t2, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32437g(i8, C9946_a.m31986a((Object) t2, j2));
                            break;
                        }
                    case 12:
                        if (!m32222a(t2, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32450k(i8, C9946_a.m31986a((Object) t2, j2));
                            break;
                        }
                    case 13:
                        if (!m32222a(t2, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32448j(i8, 0);
                            break;
                        }
                    case 14:
                        if (!m32222a(t2, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32442h(i8, 0);
                            break;
                        }
                    case 15:
                        if (!m32222a(t2, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32441h(i8, C9946_a.m31986a((Object) t2, j2));
                            break;
                        }
                    case 16:
                        if (!m32222a(t2, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32434f(i8, C9946_a.m31999b(t2, j2));
                            break;
                        }
                    case 17:
                        if (!m32222a(t2, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32425c(i8, (zzvv) C9946_a.m32016f(t2, j2), m32214a(i5));
                            break;
                        }
                    case 18:
                        i6 += C9910Ha.m31833i(i8, m32217a((Object) t2, j2), false);
                        break;
                    case 19:
                        i6 += C9910Ha.m31830h(i8, m32217a((Object) t2, j2), false);
                        break;
                    case 20:
                        i6 += C9910Ha.m31792a(i8, m32217a((Object) t2, j2), false);
                        break;
                    case 21:
                        i6 += C9910Ha.m31806b(i8, m32217a((Object) t2, j2), false);
                        break;
                    case 22:
                        i6 += C9910Ha.m31820e(i8, m32217a((Object) t2, j2), false);
                        break;
                    case 23:
                        i6 += C9910Ha.m31833i(i8, m32217a((Object) t2, j2), false);
                        break;
                    case 24:
                        i6 += C9910Ha.m31830h(i8, m32217a((Object) t2, j2), false);
                        break;
                    case 25:
                        i6 += C9910Ha.m31836j(i8, m32217a((Object) t2, j2), false);
                        break;
                    case 26:
                        i6 += C9910Ha.m31790a(i8, m32217a((Object) t2, j2));
                        break;
                    case 27:
                        i6 += C9910Ha.m31791a(i8, m32217a((Object) t2, j2), m32214a(i5));
                        break;
                    case 28:
                        i6 += C9910Ha.m31804b(i8, m32217a((Object) t2, j2));
                        break;
                    case 29:
                        i6 += C9910Ha.m31824f(i8, m32217a((Object) t2, j2), false);
                        break;
                    case 30:
                        i6 += C9910Ha.m31816d(i8, m32217a((Object) t2, j2), false);
                        break;
                    case 31:
                        i6 += C9910Ha.m31830h(i8, m32217a((Object) t2, j2), false);
                        break;
                    case 32:
                        i6 += C9910Ha.m31833i(i8, m32217a((Object) t2, j2), false);
                        break;
                    case 33:
                        i6 += C9910Ha.m31827g(i8, m32217a((Object) t2, j2), false);
                        break;
                    case 34:
                        i6 += C9910Ha.m31812c(i8, m32217a((Object) t2, j2), false);
                        break;
                    case 35:
                        int g = C9910Ha.m31828g((List) unsafe.getObject(t2, j2));
                        if (g > 0) {
                            if (this.f30194k) {
                                unsafe.putInt(t2, (long) i3, g);
                            }
                            i6 += zztv.m32429e(i8) + zztv.m32436g(g) + g;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        int f2 = C9910Ha.m31825f((List) unsafe.getObject(t2, j2));
                        if (f2 > 0) {
                            if (this.f30194k) {
                                unsafe.putInt(t2, (long) i3, f2);
                            }
                            i6 += zztv.m32429e(i8) + zztv.m32436g(f2) + f2;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        int i9 = C9910Ha.m31834i((List) unsafe.getObject(t2, j2));
                        if (i9 > 0) {
                            if (this.f30194k) {
                                unsafe.putInt(t2, (long) i3, i9);
                            }
                            i6 += zztv.m32429e(i8) + zztv.m32436g(i9) + i9;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        int j3 = C9910Ha.m31837j((List) unsafe.getObject(t2, j2));
                        if (j3 > 0) {
                            if (this.f30194k) {
                                unsafe.putInt(t2, (long) i3, j3);
                            }
                            i6 += zztv.m32429e(i8) + zztv.m32436g(j3) + j3;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        int c2 = C9910Ha.m31813c((List) unsafe.getObject(t2, j2));
                        if (c2 > 0) {
                            if (this.f30194k) {
                                unsafe.putInt(t2, (long) i3, c2);
                            }
                            i6 += zztv.m32429e(i8) + zztv.m32436g(c2) + c2;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        int g2 = C9910Ha.m31828g((List) unsafe.getObject(t2, j2));
                        if (g2 > 0) {
                            if (this.f30194k) {
                                unsafe.putInt(t2, (long) i3, g2);
                            }
                            i6 += zztv.m32429e(i8) + zztv.m32436g(g2) + g2;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        int f3 = C9910Ha.m31825f((List) unsafe.getObject(t2, j2));
                        if (f3 > 0) {
                            if (this.f30194k) {
                                unsafe.putInt(t2, (long) i3, f3);
                            }
                            i6 += zztv.m32429e(i8) + zztv.m32436g(f3) + f3;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        int h = C9910Ha.m31831h((List) unsafe.getObject(t2, j2));
                        if (h > 0) {
                            if (this.f30194k) {
                                unsafe.putInt(t2, (long) i3, h);
                            }
                            i6 += zztv.m32429e(i8) + zztv.m32436g(h) + h;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        int d = C9910Ha.m31817d((List) unsafe.getObject(t2, j2));
                        if (d > 0) {
                            if (this.f30194k) {
                                unsafe.putInt(t2, (long) i3, d);
                            }
                            i6 += zztv.m32429e(i8) + zztv.m32436g(d) + d;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        int b = C9910Ha.m31807b((List) unsafe.getObject(t2, j2));
                        if (b > 0) {
                            if (this.f30194k) {
                                unsafe.putInt(t2, (long) i3, b);
                            }
                            i6 += zztv.m32429e(i8) + zztv.m32436g(b) + b;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        int f4 = C9910Ha.m31825f((List) unsafe.getObject(t2, j2));
                        if (f4 > 0) {
                            if (this.f30194k) {
                                unsafe.putInt(t2, (long) i3, f4);
                            }
                            i6 += zztv.m32429e(i8) + zztv.m32436g(f4) + f4;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        int g3 = C9910Ha.m31828g((List) unsafe.getObject(t2, j2));
                        if (g3 > 0) {
                            if (this.f30194k) {
                                unsafe.putInt(t2, (long) i3, g3);
                            }
                            i6 += zztv.m32429e(i8) + zztv.m32436g(g3) + g3;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        int e = C9910Ha.m31821e((List) unsafe.getObject(t2, j2));
                        if (e > 0) {
                            if (this.f30194k) {
                                unsafe.putInt(t2, (long) i3, e);
                            }
                            i6 += zztv.m32429e(i8) + zztv.m32436g(e) + e;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        int a = C9910Ha.m31793a((List) unsafe.getObject(t2, j2));
                        if (a > 0) {
                            if (this.f30194k) {
                                unsafe.putInt(t2, (long) i3, a);
                            }
                            i6 += zztv.m32429e(i8) + zztv.m32436g(a) + a;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        i6 += C9910Ha.m31805b(i8, m32217a((Object) t2, j2), m32214a(i5));
                        break;
                    case 50:
                        i6 += this.f30202s.mo32750a(i8, C9946_a.m32016f(t2, j2), m32227b(i5));
                        break;
                    case 51:
                        if (!m32223a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32412b(i8, 0.0d);
                            break;
                        }
                    case 52:
                        if (!m32223a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32413b(i8, 0.0f);
                            break;
                        }
                    case 53:
                        if (!m32223a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32426d(i8, m32237e(t2, j2));
                            break;
                        }
                    case 54:
                        if (!m32223a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32430e(i8, m32237e(t2, j2));
                            break;
                        }
                    case 55:
                        if (!m32223a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32433f(i8, m32236d(t2, j2));
                            break;
                        }
                    case 56:
                        if (!m32223a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32438g(i8, 0);
                            break;
                        }
                    case 57:
                        if (!m32223a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32445i(i8, 0);
                            break;
                        }
                    case 58:
                        if (!m32223a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32418b(i8, true);
                            break;
                        }
                    case 59:
                        if (!m32223a(t2, i8, i5)) {
                            break;
                        } else {
                            Object f5 = C9946_a.m32016f(t2, j2);
                            if (!(f5 instanceof zzte)) {
                                i6 += zztv.m32417b(i8, (String) f5);
                                break;
                            } else {
                                i6 += zztv.m32423c(i8, (zzte) f5);
                                break;
                            }
                        }
                    case 60:
                        if (!m32223a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += C9910Ha.m31789a(i8, C9946_a.m32016f(t2, j2), m32214a(i5));
                            break;
                        }
                    case 61:
                        if (!m32223a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32423c(i8, (zzte) C9946_a.m32016f(t2, j2));
                            break;
                        }
                    case 62:
                        if (!m32223a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32437g(i8, m32236d(t2, j2));
                            break;
                        }
                    case 63:
                        if (!m32223a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32450k(i8, m32236d(t2, j2));
                            break;
                        }
                    case 64:
                        if (!m32223a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32448j(i8, 0);
                            break;
                        }
                    case 65:
                        if (!m32223a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32442h(i8, 0);
                            break;
                        }
                    case 66:
                        if (!m32223a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32441h(i8, m32236d(t2, j2));
                            break;
                        }
                    case 67:
                        if (!m32223a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32434f(i8, m32237e(t2, j2));
                            break;
                        }
                    case 68:
                        if (!m32223a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zztv.m32425c(i8, (zzvv) C9946_a.m32016f(t2, j2), m32214a(i5));
                            break;
                        }
                }
                i5 += 3;
                i4 = 267386880;
            }
            return i6 + m32213a(this.f30200q, t2);
        }
        Unsafe unsafe2 = f30185b;
        int i10 = 0;
        int i11 = 0;
        int i12 = -1;
        int i13 = 0;
        while (i10 < this.f30186c.length) {
            int c3 = m32233c(i10);
            int[] iArr = this.f30186c;
            int i14 = iArr[i10];
            int i15 = (c3 & 267386880) >>> 20;
            if (i15 <= 17) {
                i2 = iArr[i10 + 2];
                int i16 = i2 & 1048575;
                i = 1 << (i2 >>> 20);
                if (i16 != i12) {
                    i13 = unsafe2.getInt(t2, (long) i16);
                } else {
                    i16 = i12;
                }
                i12 = i16;
            } else if (!this.f30194k || i15 < zzui.DOUBLE_LIST_PACKED.mo32891e() || i15 > zzui.SINT64_LIST_PACKED.mo32891e()) {
                i2 = 0;
                i = 0;
            } else {
                i2 = this.f30186c[i10 + 2] & 1048575;
                i = 0;
            }
            long j4 = (long) (c3 & 1048575);
            switch (i15) {
                case 0:
                    j = 0;
                    if ((i13 & i) == 0) {
                        break;
                    } else {
                        i11 += zztv.m32412b(i14, 0.0d);
                        break;
                    }
                case 1:
                    j = 0;
                    if ((i13 & i) == 0) {
                        break;
                    } else {
                        i11 += zztv.m32413b(i14, 0.0f);
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i13 & i) == 0) {
                        break;
                    } else {
                        i11 += zztv.m32426d(i14, unsafe2.getLong(t2, j4));
                        break;
                    }
                case 3:
                    j = 0;
                    if ((i13 & i) == 0) {
                        break;
                    } else {
                        i11 += zztv.m32430e(i14, unsafe2.getLong(t2, j4));
                        break;
                    }
                case 4:
                    j = 0;
                    if ((i13 & i) == 0) {
                        break;
                    } else {
                        i11 += zztv.m32433f(i14, unsafe2.getInt(t2, j4));
                        break;
                    }
                case 5:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        i11 += zztv.m32438g(i14, 0);
                        break;
                    }
                case 6:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32445i(i14, 0);
                        j = 0;
                        break;
                    }
                case 7:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32418b(i14, true);
                        j = 0;
                        break;
                    }
                case 8:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        Object object = unsafe2.getObject(t2, j4);
                        if (!(object instanceof zzte)) {
                            i11 += zztv.m32417b(i14, (String) object);
                            j = 0;
                            break;
                        } else {
                            i11 += zztv.m32423c(i14, (zzte) object);
                            j = 0;
                            break;
                        }
                    }
                case 9:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += C9910Ha.m31789a(i14, unsafe2.getObject(t2, j4), m32214a(i10));
                        j = 0;
                        break;
                    }
                case 10:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32423c(i14, (zzte) unsafe2.getObject(t2, j4));
                        j = 0;
                        break;
                    }
                case 11:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32437g(i14, unsafe2.getInt(t2, j4));
                        j = 0;
                        break;
                    }
                case 12:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32450k(i14, unsafe2.getInt(t2, j4));
                        j = 0;
                        break;
                    }
                case 13:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32448j(i14, 0);
                        j = 0;
                        break;
                    }
                case 14:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32442h(i14, 0);
                        j = 0;
                        break;
                    }
                case 15:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32441h(i14, unsafe2.getInt(t2, j4));
                        j = 0;
                        break;
                    }
                case 16:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32434f(i14, unsafe2.getLong(t2, j4));
                        j = 0;
                        break;
                    }
                case 17:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32425c(i14, (zzvv) unsafe2.getObject(t2, j4), m32214a(i10));
                        j = 0;
                        break;
                    }
                case 18:
                    i11 += C9910Ha.m31833i(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 19:
                    i11 += C9910Ha.m31830h(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 20:
                    i11 += C9910Ha.m31792a(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 21:
                    i11 += C9910Ha.m31806b(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 22:
                    i11 += C9910Ha.m31820e(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 23:
                    i11 += C9910Ha.m31833i(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 24:
                    i11 += C9910Ha.m31830h(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 25:
                    i11 += C9910Ha.m31836j(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 26:
                    i11 += C9910Ha.m31790a(i14, (List) unsafe2.getObject(t2, j4));
                    j = 0;
                    break;
                case 27:
                    i11 += C9910Ha.m31791a(i14, (List) unsafe2.getObject(t2, j4), m32214a(i10));
                    j = 0;
                    break;
                case 28:
                    i11 += C9910Ha.m31804b(i14, (List) unsafe2.getObject(t2, j4));
                    j = 0;
                    break;
                case 29:
                    i11 += C9910Ha.m31824f(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 30:
                    i11 += C9910Ha.m31816d(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 31:
                    i11 += C9910Ha.m31830h(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 32:
                    i11 += C9910Ha.m31833i(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 33:
                    i11 += C9910Ha.m31827g(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 34:
                    i11 += C9910Ha.m31812c(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 35:
                    int g4 = C9910Ha.m31828g((List) unsafe2.getObject(t2, j4));
                    if (g4 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f30194k) {
                            unsafe2.putInt(t2, (long) i2, g4);
                        }
                        i11 += zztv.m32429e(i14) + zztv.m32436g(g4) + g4;
                        j = 0;
                        break;
                    }
                case 36:
                    int f6 = C9910Ha.m31825f((List) unsafe2.getObject(t2, j4));
                    if (f6 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f30194k) {
                            unsafe2.putInt(t2, (long) i2, f6);
                        }
                        i11 += zztv.m32429e(i14) + zztv.m32436g(f6) + f6;
                        j = 0;
                        break;
                    }
                case 37:
                    int i17 = C9910Ha.m31834i((List) unsafe2.getObject(t2, j4));
                    if (i17 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f30194k) {
                            unsafe2.putInt(t2, (long) i2, i17);
                        }
                        i11 += zztv.m32429e(i14) + zztv.m32436g(i17) + i17;
                        j = 0;
                        break;
                    }
                case 38:
                    int j5 = C9910Ha.m31837j((List) unsafe2.getObject(t2, j4));
                    if (j5 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f30194k) {
                            unsafe2.putInt(t2, (long) i2, j5);
                        }
                        i11 += zztv.m32429e(i14) + zztv.m32436g(j5) + j5;
                        j = 0;
                        break;
                    }
                case 39:
                    int c4 = C9910Ha.m31813c((List) unsafe2.getObject(t2, j4));
                    if (c4 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f30194k) {
                            unsafe2.putInt(t2, (long) i2, c4);
                        }
                        i11 += zztv.m32429e(i14) + zztv.m32436g(c4) + c4;
                        j = 0;
                        break;
                    }
                case 40:
                    int g5 = C9910Ha.m31828g((List) unsafe2.getObject(t2, j4));
                    if (g5 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f30194k) {
                            unsafe2.putInt(t2, (long) i2, g5);
                        }
                        i11 += zztv.m32429e(i14) + zztv.m32436g(g5) + g5;
                        j = 0;
                        break;
                    }
                case 41:
                    int f7 = C9910Ha.m31825f((List) unsafe2.getObject(t2, j4));
                    if (f7 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f30194k) {
                            unsafe2.putInt(t2, (long) i2, f7);
                        }
                        i11 += zztv.m32429e(i14) + zztv.m32436g(f7) + f7;
                        j = 0;
                        break;
                    }
                case 42:
                    int h2 = C9910Ha.m31831h((List) unsafe2.getObject(t2, j4));
                    if (h2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f30194k) {
                            unsafe2.putInt(t2, (long) i2, h2);
                        }
                        i11 += zztv.m32429e(i14) + zztv.m32436g(h2) + h2;
                        j = 0;
                        break;
                    }
                case 43:
                    int d2 = C9910Ha.m31817d((List) unsafe2.getObject(t2, j4));
                    if (d2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f30194k) {
                            unsafe2.putInt(t2, (long) i2, d2);
                        }
                        i11 += zztv.m32429e(i14) + zztv.m32436g(d2) + d2;
                        j = 0;
                        break;
                    }
                case 44:
                    int b2 = C9910Ha.m31807b((List) unsafe2.getObject(t2, j4));
                    if (b2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f30194k) {
                            unsafe2.putInt(t2, (long) i2, b2);
                        }
                        i11 += zztv.m32429e(i14) + zztv.m32436g(b2) + b2;
                        j = 0;
                        break;
                    }
                case 45:
                    int f8 = C9910Ha.m31825f((List) unsafe2.getObject(t2, j4));
                    if (f8 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f30194k) {
                            unsafe2.putInt(t2, (long) i2, f8);
                        }
                        i11 += zztv.m32429e(i14) + zztv.m32436g(f8) + f8;
                        j = 0;
                        break;
                    }
                case 46:
                    int g6 = C9910Ha.m31828g((List) unsafe2.getObject(t2, j4));
                    if (g6 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f30194k) {
                            unsafe2.putInt(t2, (long) i2, g6);
                        }
                        i11 += zztv.m32429e(i14) + zztv.m32436g(g6) + g6;
                        j = 0;
                        break;
                    }
                case 47:
                    int e2 = C9910Ha.m31821e((List) unsafe2.getObject(t2, j4));
                    if (e2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f30194k) {
                            unsafe2.putInt(t2, (long) i2, e2);
                        }
                        i11 += zztv.m32429e(i14) + zztv.m32436g(e2) + e2;
                        j = 0;
                        break;
                    }
                case 48:
                    int a2 = C9910Ha.m31793a((List) unsafe2.getObject(t2, j4));
                    if (a2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f30194k) {
                            unsafe2.putInt(t2, (long) i2, a2);
                        }
                        i11 += zztv.m32429e(i14) + zztv.m32436g(a2) + a2;
                        j = 0;
                        break;
                    }
                case 49:
                    i11 += C9910Ha.m31805b(i14, (List) unsafe2.getObject(t2, j4), m32214a(i10));
                    j = 0;
                    break;
                case 50:
                    i11 += this.f30202s.mo32750a(i14, unsafe2.getObject(t2, j4), m32227b(i10));
                    j = 0;
                    break;
                case 51:
                    if (!m32223a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32412b(i14, 0.0d);
                        j = 0;
                        break;
                    }
                case 52:
                    if (!m32223a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32413b(i14, 0.0f);
                        j = 0;
                        break;
                    }
                case 53:
                    if (!m32223a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32426d(i14, m32237e(t2, j4));
                        j = 0;
                        break;
                    }
                case 54:
                    if (!m32223a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32430e(i14, m32237e(t2, j4));
                        j = 0;
                        break;
                    }
                case 55:
                    if (!m32223a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32433f(i14, m32236d(t2, j4));
                        j = 0;
                        break;
                    }
                case 56:
                    if (!m32223a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32438g(i14, 0);
                        j = 0;
                        break;
                    }
                case 57:
                    if (!m32223a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32445i(i14, 0);
                        j = 0;
                        break;
                    }
                case 58:
                    if (!m32223a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32418b(i14, true);
                        j = 0;
                        break;
                    }
                case 59:
                    if (!m32223a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        Object object2 = unsafe2.getObject(t2, j4);
                        if (!(object2 instanceof zzte)) {
                            i11 += zztv.m32417b(i14, (String) object2);
                            j = 0;
                            break;
                        } else {
                            i11 += zztv.m32423c(i14, (zzte) object2);
                            j = 0;
                            break;
                        }
                    }
                case 60:
                    if (!m32223a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += C9910Ha.m31789a(i14, unsafe2.getObject(t2, j4), m32214a(i10));
                        j = 0;
                        break;
                    }
                case 61:
                    if (!m32223a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32423c(i14, (zzte) unsafe2.getObject(t2, j4));
                        j = 0;
                        break;
                    }
                case 62:
                    if (!m32223a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32437g(i14, m32236d(t2, j4));
                        j = 0;
                        break;
                    }
                case 63:
                    if (!m32223a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32450k(i14, m32236d(t2, j4));
                        j = 0;
                        break;
                    }
                case 64:
                    if (!m32223a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32448j(i14, 0);
                        j = 0;
                        break;
                    }
                case 65:
                    if (!m32223a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32442h(i14, 0);
                        j = 0;
                        break;
                    }
                case 66:
                    if (!m32223a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32441h(i14, m32236d(t2, j4));
                        j = 0;
                        break;
                    }
                case 67:
                    if (!m32223a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32434f(i14, m32237e(t2, j4));
                        j = 0;
                        break;
                    }
                case 68:
                    if (!m32223a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zztv.m32425c(i14, (zzvv) unsafe2.getObject(t2, j4), m32214a(i10));
                        j = 0;
                        break;
                    }
                default:
                    j = 0;
                    break;
            }
            i10 += 3;
            long j6 = j;
        }
        int a3 = i11 + m32213a(this.f30200q, t2);
        if (this.f30191h) {
            a3 += this.f30201r.mo32662a((Object) t2).mo32693h();
        }
        return a3;
    }

    /* renamed from: a */
    private static <UT, UB> int m32213a(C9939Wa<UT, UB> wa, T t) {
        return wa.mo32667a(wa.mo32670b(t));
    }

    /* renamed from: a */
    private static <E> List<E> m32217a(Object obj, long j) {
        return (List) C9946_a.m32016f(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0553 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0554  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0583  */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x0a9b  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x0aa1  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo32553a(T r13, com.google.android.gms.internal.measurement.C9986lb r14) throws java.io.IOException {
        /*
            r12 = this;
            int r0 = r14.mo32632b()
            int r1 = com.google.android.gms.internal.measurement.zzuo.zze.f30340m
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x055a
            com.google.android.gms.internal.measurement.Wa<?, ?> r0 = r12.f30200q
            m32219a(r0, (T) r13, r14)
            boolean r0 = r12.f30191h
            if (r0 == 0) goto L_0x0033
            com.google.android.gms.internal.measurement.W<?> r0 = r12.f30201r
            com.google.android.gms.internal.measurement.Z r0 = r0.mo32662a(r13)
            boolean r1 = r0.mo32686b()
            if (r1 != 0) goto L_0x0033
            java.util.Iterator r0 = r0.mo32684a()
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            goto L_0x0034
        L_0x0033:
            r0 = r3
        L_0x0034:
            int[] r1 = r12.f30186c
            int r1 = r1.length
            int r1 = r1 + -3
        L_0x0039:
            if (r1 < 0) goto L_0x0551
            int r7 = r12.m32233c(r1)
            int[] r8 = r12.f30186c
            r9 = r8[r1]
            if (r0 != 0) goto L_0x054b
            r10 = r7 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x0536;
                case 1: goto L_0x0524;
                case 2: goto L_0x0512;
                case 3: goto L_0x0500;
                case 4: goto L_0x04ee;
                case 5: goto L_0x04dc;
                case 6: goto L_0x04ca;
                case 7: goto L_0x04b7;
                case 8: goto L_0x04a5;
                case 9: goto L_0x048f;
                case 10: goto L_0x047b;
                case 11: goto L_0x0468;
                case 12: goto L_0x0455;
                case 13: goto L_0x0442;
                case 14: goto L_0x042f;
                case 15: goto L_0x041c;
                case 16: goto L_0x0409;
                case 17: goto L_0x03f3;
                case 18: goto L_0x03e1;
                case 19: goto L_0x03cf;
                case 20: goto L_0x03bd;
                case 21: goto L_0x03ab;
                case 22: goto L_0x0399;
                case 23: goto L_0x0387;
                case 24: goto L_0x0375;
                case 25: goto L_0x0363;
                case 26: goto L_0x0351;
                case 27: goto L_0x033b;
                case 28: goto L_0x0329;
                case 29: goto L_0x0317;
                case 30: goto L_0x0305;
                case 31: goto L_0x02f3;
                case 32: goto L_0x02e1;
                case 33: goto L_0x02cf;
                case 34: goto L_0x02bd;
                case 35: goto L_0x02ab;
                case 36: goto L_0x0299;
                case 37: goto L_0x0287;
                case 38: goto L_0x0275;
                case 39: goto L_0x0263;
                case 40: goto L_0x0251;
                case 41: goto L_0x023f;
                case 42: goto L_0x022d;
                case 43: goto L_0x021b;
                case 44: goto L_0x0209;
                case 45: goto L_0x01f7;
                case 46: goto L_0x01e5;
                case 47: goto L_0x01d3;
                case 48: goto L_0x01c1;
                case 49: goto L_0x01ab;
                case 50: goto L_0x019f;
                case 51: goto L_0x018d;
                case 52: goto L_0x017b;
                case 53: goto L_0x0169;
                case 54: goto L_0x0157;
                case 55: goto L_0x0145;
                case 56: goto L_0x0133;
                case 57: goto L_0x0121;
                case 58: goto L_0x010f;
                case 59: goto L_0x00fd;
                case 60: goto L_0x00e7;
                case 61: goto L_0x00d3;
                case 62: goto L_0x00c1;
                case 63: goto L_0x00af;
                case 64: goto L_0x009d;
                case 65: goto L_0x008b;
                case 66: goto L_0x0079;
                case 67: goto L_0x0067;
                case 68: goto L_0x0051;
                default: goto L_0x004f;
            }
        L_0x004f:
            goto L_0x0547
        L_0x0051:
            boolean r8 = r12.m32223a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r7)
            com.google.android.gms.internal.measurement.Fa r8 = r12.m32214a(r1)
            r14.mo32636b(r9, r7, r8)
            goto L_0x0547
        L_0x0067:
            boolean r8 = r12.m32223a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = m32237e(r13, r7)
            r14.mo32623a(r9, r7)
            goto L_0x0547
        L_0x0079:
            boolean r8 = r12.m32223a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = m32236d(r13, r7)
            r14.mo32640c(r9, r7)
            goto L_0x0547
        L_0x008b:
            boolean r8 = r12.m32223a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = m32237e(r13, r7)
            r14.mo32644d(r9, r7)
            goto L_0x0547
        L_0x009d:
            boolean r8 = r12.m32223a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = m32236d(r13, r7)
            r14.mo32649f(r9, r7)
            goto L_0x0547
        L_0x00af:
            boolean r8 = r12.m32223a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = m32236d(r13, r7)
            r14.mo32622a(r9, r7)
            goto L_0x0547
        L_0x00c1:
            boolean r8 = r12.m32223a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = m32236d(r13, r7)
            r14.mo32646e(r9, r7)
            goto L_0x0547
        L_0x00d3:
            boolean r8 = r12.m32223a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r7)
            com.google.android.gms.internal.measurement.zzte r7 = (com.google.android.gms.internal.measurement.zzte) r7
            r14.mo32624a(r9, r7)
            goto L_0x0547
        L_0x00e7:
            boolean r8 = r12.m32223a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r7)
            com.google.android.gms.internal.measurement.Fa r8 = r12.m32214a(r1)
            r14.mo32626a(r9, r7, r8)
            goto L_0x0547
        L_0x00fd:
            boolean r8 = r12.m32223a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r7)
            m32218a(r9, r7, r14)
            goto L_0x0547
        L_0x010f:
            boolean r8 = r12.m32223a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            boolean r7 = m32238f(r13, r7)
            r14.mo32631a(r9, r7)
            goto L_0x0547
        L_0x0121:
            boolean r8 = r12.m32223a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = m32236d(r13, r7)
            r14.mo32643d(r9, r7)
            goto L_0x0547
        L_0x0133:
            boolean r8 = r12.m32223a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = m32237e(r13, r7)
            r14.mo32635b(r9, r7)
            goto L_0x0547
        L_0x0145:
            boolean r8 = r12.m32223a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = m32236d(r13, r7)
            r14.mo32634b(r9, r7)
            goto L_0x0547
        L_0x0157:
            boolean r8 = r12.m32223a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = m32237e(r13, r7)
            r14.mo32641c(r9, r7)
            goto L_0x0547
        L_0x0169:
            boolean r8 = r12.m32223a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = m32237e(r13, r7)
            r14.mo32647e(r9, r7)
            goto L_0x0547
        L_0x017b:
            boolean r8 = r12.m32223a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            float r7 = m32232c(r13, r7)
            r14.mo32621a(r9, r7)
            goto L_0x0547
        L_0x018d:
            boolean r8 = r12.m32223a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            double r7 = m32226b((T) r13, r7)
            r14.mo32620a(r9, r7)
            goto L_0x0547
        L_0x019f:
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r7)
            r12.m32220a(r14, r9, r7, r1)
            goto L_0x0547
        L_0x01ab:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.Fa r9 = r12.m32214a(r1)
            com.google.android.gms.internal.measurement.C9910Ha.m31810b(r8, r7, r14, r9)
            goto L_0x0547
        L_0x01c1:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31823e(r8, r7, r14, r4)
            goto L_0x0547
        L_0x01d3:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31838j(r8, r7, r14, r4)
            goto L_0x0547
        L_0x01e5:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31829g(r8, r7, r14, r4)
            goto L_0x0547
        L_0x01f7:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31840l(r8, r7, r14, r4)
            goto L_0x0547
        L_0x0209:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31841m(r8, r7, r14, r4)
            goto L_0x0547
        L_0x021b:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31835i(r8, r7, r14, r4)
            goto L_0x0547
        L_0x022d:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31842n(r8, r7, r14, r4)
            goto L_0x0547
        L_0x023f:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31839k(r8, r7, r14, r4)
            goto L_0x0547
        L_0x0251:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31826f(r8, r7, r14, r4)
            goto L_0x0547
        L_0x0263:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31832h(r8, r7, r14, r4)
            goto L_0x0547
        L_0x0275:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31819d(r8, r7, r14, r4)
            goto L_0x0547
        L_0x0287:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31815c(r8, r7, r14, r4)
            goto L_0x0547
        L_0x0299:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31811b(r8, r7, r14, r4)
            goto L_0x0547
        L_0x02ab:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31798a(r8, r7, r14, r4)
            goto L_0x0547
        L_0x02bd:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31823e(r8, r7, r14, r5)
            goto L_0x0547
        L_0x02cf:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31838j(r8, r7, r14, r5)
            goto L_0x0547
        L_0x02e1:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31829g(r8, r7, r14, r5)
            goto L_0x0547
        L_0x02f3:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31840l(r8, r7, r14, r5)
            goto L_0x0547
        L_0x0305:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31841m(r8, r7, r14, r5)
            goto L_0x0547
        L_0x0317:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31835i(r8, r7, r14, r5)
            goto L_0x0547
        L_0x0329:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31809b(r8, r7, r14)
            goto L_0x0547
        L_0x033b:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.Fa r9 = r12.m32214a(r1)
            com.google.android.gms.internal.measurement.C9910Ha.m31797a(r8, r7, r14, r9)
            goto L_0x0547
        L_0x0351:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31796a(r8, r7, r14)
            goto L_0x0547
        L_0x0363:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31842n(r8, r7, r14, r5)
            goto L_0x0547
        L_0x0375:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31839k(r8, r7, r14, r5)
            goto L_0x0547
        L_0x0387:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31826f(r8, r7, r14, r5)
            goto L_0x0547
        L_0x0399:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31832h(r8, r7, r14, r5)
            goto L_0x0547
        L_0x03ab:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31819d(r8, r7, r14, r5)
            goto L_0x0547
        L_0x03bd:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31815c(r8, r7, r14, r5)
            goto L_0x0547
        L_0x03cf:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31811b(r8, r7, r14, r5)
            goto L_0x0547
        L_0x03e1:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.C9910Ha.m31798a(r8, r7, r14, r5)
            goto L_0x0547
        L_0x03f3:
            boolean r8 = r12.m32222a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r7)
            com.google.android.gms.internal.measurement.Fa r8 = r12.m32214a(r1)
            r14.mo32636b(r9, r7, r8)
            goto L_0x0547
        L_0x0409:
            boolean r8 = r12.m32222a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.measurement.C9946_a.m31999b(r13, r7)
            r14.mo32623a(r9, r7)
            goto L_0x0547
        L_0x041c:
            boolean r8 = r12.m32222a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.measurement.C9946_a.m31986a(r13, r7)
            r14.mo32640c(r9, r7)
            goto L_0x0547
        L_0x042f:
            boolean r8 = r12.m32222a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.measurement.C9946_a.m31999b(r13, r7)
            r14.mo32644d(r9, r7)
            goto L_0x0547
        L_0x0442:
            boolean r8 = r12.m32222a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.measurement.C9946_a.m31986a(r13, r7)
            r14.mo32649f(r9, r7)
            goto L_0x0547
        L_0x0455:
            boolean r8 = r12.m32222a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.measurement.C9946_a.m31986a(r13, r7)
            r14.mo32622a(r9, r7)
            goto L_0x0547
        L_0x0468:
            boolean r8 = r12.m32222a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.measurement.C9946_a.m31986a(r13, r7)
            r14.mo32646e(r9, r7)
            goto L_0x0547
        L_0x047b:
            boolean r8 = r12.m32222a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r7)
            com.google.android.gms.internal.measurement.zzte r7 = (com.google.android.gms.internal.measurement.zzte) r7
            r14.mo32624a(r9, r7)
            goto L_0x0547
        L_0x048f:
            boolean r8 = r12.m32222a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r7)
            com.google.android.gms.internal.measurement.Fa r8 = r12.m32214a(r1)
            r14.mo32626a(r9, r7, r8)
            goto L_0x0547
        L_0x04a5:
            boolean r8 = r12.m32222a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r7)
            m32218a(r9, r7, r14)
            goto L_0x0547
        L_0x04b7:
            boolean r8 = r12.m32222a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            boolean r7 = com.google.android.gms.internal.measurement.C9946_a.m32007c(r13, r7)
            r14.mo32631a(r9, r7)
            goto L_0x0547
        L_0x04ca:
            boolean r8 = r12.m32222a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.measurement.C9946_a.m31986a(r13, r7)
            r14.mo32643d(r9, r7)
            goto L_0x0547
        L_0x04dc:
            boolean r8 = r12.m32222a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.measurement.C9946_a.m31999b(r13, r7)
            r14.mo32635b(r9, r7)
            goto L_0x0547
        L_0x04ee:
            boolean r8 = r12.m32222a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.measurement.C9946_a.m31986a(r13, r7)
            r14.mo32634b(r9, r7)
            goto L_0x0547
        L_0x0500:
            boolean r8 = r12.m32222a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.measurement.C9946_a.m31999b(r13, r7)
            r14.mo32641c(r9, r7)
            goto L_0x0547
        L_0x0512:
            boolean r8 = r12.m32222a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.measurement.C9946_a.m31999b(r13, r7)
            r14.mo32647e(r9, r7)
            goto L_0x0547
        L_0x0524:
            boolean r8 = r12.m32222a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            float r7 = com.google.android.gms.internal.measurement.C9946_a.m32008d(r13, r7)
            r14.mo32621a(r9, r7)
            goto L_0x0547
        L_0x0536:
            boolean r8 = r12.m32222a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            double r7 = com.google.android.gms.internal.measurement.C9946_a.m32013e(r13, r7)
            r14.mo32620a(r9, r7)
        L_0x0547:
            int r1 = r1 + -3
            goto L_0x0039
        L_0x054b:
            com.google.android.gms.internal.measurement.W<?> r13 = r12.f30201r
            r13.mo32661a(r0)
            throw r3
        L_0x0551:
            if (r0 != 0) goto L_0x0554
            return
        L_0x0554:
            com.google.android.gms.internal.measurement.W<?> r13 = r12.f30201r
            r13.mo32663a(r14, r0)
            throw r3
        L_0x055a:
            boolean r0 = r12.f30193j
            if (r0 == 0) goto L_0x0aa7
            boolean r0 = r12.f30191h
            if (r0 == 0) goto L_0x057c
            com.google.android.gms.internal.measurement.W<?> r0 = r12.f30201r
            com.google.android.gms.internal.measurement.Z r0 = r0.mo32662a(r13)
            boolean r1 = r0.mo32686b()
            if (r1 != 0) goto L_0x057c
            java.util.Iterator r0 = r0.mo32690e()
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            goto L_0x057d
        L_0x057c:
            r0 = r3
        L_0x057d:
            int[] r1 = r12.f30186c
            int r1 = r1.length
            r7 = 0
        L_0x0581:
            if (r7 >= r1) goto L_0x0a99
            int r8 = r12.m32233c(r7)
            int[] r9 = r12.f30186c
            r10 = r9[r7]
            if (r0 != 0) goto L_0x0a93
            r11 = r8 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0a7e;
                case 1: goto L_0x0a6c;
                case 2: goto L_0x0a5a;
                case 3: goto L_0x0a48;
                case 4: goto L_0x0a36;
                case 5: goto L_0x0a24;
                case 6: goto L_0x0a12;
                case 7: goto L_0x09ff;
                case 8: goto L_0x09ed;
                case 9: goto L_0x09d7;
                case 10: goto L_0x09c3;
                case 11: goto L_0x09b0;
                case 12: goto L_0x099d;
                case 13: goto L_0x098a;
                case 14: goto L_0x0977;
                case 15: goto L_0x0964;
                case 16: goto L_0x0951;
                case 17: goto L_0x093b;
                case 18: goto L_0x0929;
                case 19: goto L_0x0917;
                case 20: goto L_0x0905;
                case 21: goto L_0x08f3;
                case 22: goto L_0x08e1;
                case 23: goto L_0x08cf;
                case 24: goto L_0x08bd;
                case 25: goto L_0x08ab;
                case 26: goto L_0x0899;
                case 27: goto L_0x0883;
                case 28: goto L_0x0871;
                case 29: goto L_0x085f;
                case 30: goto L_0x084d;
                case 31: goto L_0x083b;
                case 32: goto L_0x0829;
                case 33: goto L_0x0817;
                case 34: goto L_0x0805;
                case 35: goto L_0x07f3;
                case 36: goto L_0x07e1;
                case 37: goto L_0x07cf;
                case 38: goto L_0x07bd;
                case 39: goto L_0x07ab;
                case 40: goto L_0x0799;
                case 41: goto L_0x0787;
                case 42: goto L_0x0775;
                case 43: goto L_0x0763;
                case 44: goto L_0x0751;
                case 45: goto L_0x073f;
                case 46: goto L_0x072d;
                case 47: goto L_0x071b;
                case 48: goto L_0x0709;
                case 49: goto L_0x06f3;
                case 50: goto L_0x06e7;
                case 51: goto L_0x06d5;
                case 52: goto L_0x06c3;
                case 53: goto L_0x06b1;
                case 54: goto L_0x069f;
                case 55: goto L_0x068d;
                case 56: goto L_0x067b;
                case 57: goto L_0x0669;
                case 58: goto L_0x0657;
                case 59: goto L_0x0645;
                case 60: goto L_0x062f;
                case 61: goto L_0x061b;
                case 62: goto L_0x0609;
                case 63: goto L_0x05f7;
                case 64: goto L_0x05e5;
                case 65: goto L_0x05d3;
                case 66: goto L_0x05c1;
                case 67: goto L_0x05af;
                case 68: goto L_0x0599;
                default: goto L_0x0597;
            }
        L_0x0597:
            goto L_0x0a8f
        L_0x0599:
            boolean r9 = r12.m32223a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r8)
            com.google.android.gms.internal.measurement.Fa r9 = r12.m32214a(r7)
            r14.mo32636b(r10, r8, r9)
            goto L_0x0a8f
        L_0x05af:
            boolean r9 = r12.m32223a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = m32237e(r13, r8)
            r14.mo32623a(r10, r8)
            goto L_0x0a8f
        L_0x05c1:
            boolean r9 = r12.m32223a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = m32236d(r13, r8)
            r14.mo32640c(r10, r8)
            goto L_0x0a8f
        L_0x05d3:
            boolean r9 = r12.m32223a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = m32237e(r13, r8)
            r14.mo32644d(r10, r8)
            goto L_0x0a8f
        L_0x05e5:
            boolean r9 = r12.m32223a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = m32236d(r13, r8)
            r14.mo32649f(r10, r8)
            goto L_0x0a8f
        L_0x05f7:
            boolean r9 = r12.m32223a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = m32236d(r13, r8)
            r14.mo32622a(r10, r8)
            goto L_0x0a8f
        L_0x0609:
            boolean r9 = r12.m32223a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = m32236d(r13, r8)
            r14.mo32646e(r10, r8)
            goto L_0x0a8f
        L_0x061b:
            boolean r9 = r12.m32223a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r8)
            com.google.android.gms.internal.measurement.zzte r8 = (com.google.android.gms.internal.measurement.zzte) r8
            r14.mo32624a(r10, r8)
            goto L_0x0a8f
        L_0x062f:
            boolean r9 = r12.m32223a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r8)
            com.google.android.gms.internal.measurement.Fa r9 = r12.m32214a(r7)
            r14.mo32626a(r10, r8, r9)
            goto L_0x0a8f
        L_0x0645:
            boolean r9 = r12.m32223a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r8)
            m32218a(r10, r8, r14)
            goto L_0x0a8f
        L_0x0657:
            boolean r9 = r12.m32223a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            boolean r8 = m32238f(r13, r8)
            r14.mo32631a(r10, r8)
            goto L_0x0a8f
        L_0x0669:
            boolean r9 = r12.m32223a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = m32236d(r13, r8)
            r14.mo32643d(r10, r8)
            goto L_0x0a8f
        L_0x067b:
            boolean r9 = r12.m32223a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = m32237e(r13, r8)
            r14.mo32635b(r10, r8)
            goto L_0x0a8f
        L_0x068d:
            boolean r9 = r12.m32223a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = m32236d(r13, r8)
            r14.mo32634b(r10, r8)
            goto L_0x0a8f
        L_0x069f:
            boolean r9 = r12.m32223a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = m32237e(r13, r8)
            r14.mo32641c(r10, r8)
            goto L_0x0a8f
        L_0x06b1:
            boolean r9 = r12.m32223a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = m32237e(r13, r8)
            r14.mo32647e(r10, r8)
            goto L_0x0a8f
        L_0x06c3:
            boolean r9 = r12.m32223a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            float r8 = m32232c(r13, r8)
            r14.mo32621a(r10, r8)
            goto L_0x0a8f
        L_0x06d5:
            boolean r9 = r12.m32223a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            double r8 = m32226b((T) r13, r8)
            r14.mo32620a(r10, r8)
            goto L_0x0a8f
        L_0x06e7:
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r8)
            r12.m32220a(r14, r10, r8, r7)
            goto L_0x0a8f
        L_0x06f3:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.Fa r10 = r12.m32214a(r7)
            com.google.android.gms.internal.measurement.C9910Ha.m31810b(r9, r8, r14, r10)
            goto L_0x0a8f
        L_0x0709:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31823e(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x071b:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31838j(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x072d:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31829g(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x073f:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31840l(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x0751:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31841m(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x0763:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31835i(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x0775:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31842n(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x0787:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31839k(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x0799:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31826f(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x07ab:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31832h(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x07bd:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31819d(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x07cf:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31815c(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x07e1:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31811b(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x07f3:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31798a(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x0805:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31823e(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x0817:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31838j(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x0829:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31829g(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x083b:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31840l(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x084d:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31841m(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x085f:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31835i(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x0871:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31809b(r9, r8, r14)
            goto L_0x0a8f
        L_0x0883:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.Fa r10 = r12.m32214a(r7)
            com.google.android.gms.internal.measurement.C9910Ha.m31797a(r9, r8, r14, r10)
            goto L_0x0a8f
        L_0x0899:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31796a(r9, r8, r14)
            goto L_0x0a8f
        L_0x08ab:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31842n(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x08bd:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31839k(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x08cf:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31826f(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x08e1:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31832h(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x08f3:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31819d(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x0905:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31815c(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x0917:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31811b(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x0929:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C9910Ha.m31798a(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x093b:
            boolean r9 = r12.m32222a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r8)
            com.google.android.gms.internal.measurement.Fa r9 = r12.m32214a(r7)
            r14.mo32636b(r10, r8, r9)
            goto L_0x0a8f
        L_0x0951:
            boolean r9 = r12.m32222a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.measurement.C9946_a.m31999b(r13, r8)
            r14.mo32623a(r10, r8)
            goto L_0x0a8f
        L_0x0964:
            boolean r9 = r12.m32222a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.C9946_a.m31986a(r13, r8)
            r14.mo32640c(r10, r8)
            goto L_0x0a8f
        L_0x0977:
            boolean r9 = r12.m32222a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.measurement.C9946_a.m31999b(r13, r8)
            r14.mo32644d(r10, r8)
            goto L_0x0a8f
        L_0x098a:
            boolean r9 = r12.m32222a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.C9946_a.m31986a(r13, r8)
            r14.mo32649f(r10, r8)
            goto L_0x0a8f
        L_0x099d:
            boolean r9 = r12.m32222a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.C9946_a.m31986a(r13, r8)
            r14.mo32622a(r10, r8)
            goto L_0x0a8f
        L_0x09b0:
            boolean r9 = r12.m32222a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.C9946_a.m31986a(r13, r8)
            r14.mo32646e(r10, r8)
            goto L_0x0a8f
        L_0x09c3:
            boolean r9 = r12.m32222a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r8)
            com.google.android.gms.internal.measurement.zzte r8 = (com.google.android.gms.internal.measurement.zzte) r8
            r14.mo32624a(r10, r8)
            goto L_0x0a8f
        L_0x09d7:
            boolean r9 = r12.m32222a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r8)
            com.google.android.gms.internal.measurement.Fa r9 = r12.m32214a(r7)
            r14.mo32626a(r10, r8, r9)
            goto L_0x0a8f
        L_0x09ed:
            boolean r9 = r12.m32222a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.C9946_a.m32016f(r13, r8)
            m32218a(r10, r8, r14)
            goto L_0x0a8f
        L_0x09ff:
            boolean r9 = r12.m32222a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            boolean r8 = com.google.android.gms.internal.measurement.C9946_a.m32007c(r13, r8)
            r14.mo32631a(r10, r8)
            goto L_0x0a8f
        L_0x0a12:
            boolean r9 = r12.m32222a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.C9946_a.m31986a(r13, r8)
            r14.mo32643d(r10, r8)
            goto L_0x0a8f
        L_0x0a24:
            boolean r9 = r12.m32222a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.measurement.C9946_a.m31999b(r13, r8)
            r14.mo32635b(r10, r8)
            goto L_0x0a8f
        L_0x0a36:
            boolean r9 = r12.m32222a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.C9946_a.m31986a(r13, r8)
            r14.mo32634b(r10, r8)
            goto L_0x0a8f
        L_0x0a48:
            boolean r9 = r12.m32222a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.measurement.C9946_a.m31999b(r13, r8)
            r14.mo32641c(r10, r8)
            goto L_0x0a8f
        L_0x0a5a:
            boolean r9 = r12.m32222a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.measurement.C9946_a.m31999b(r13, r8)
            r14.mo32647e(r10, r8)
            goto L_0x0a8f
        L_0x0a6c:
            boolean r9 = r12.m32222a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            float r8 = com.google.android.gms.internal.measurement.C9946_a.m32008d(r13, r8)
            r14.mo32621a(r10, r8)
            goto L_0x0a8f
        L_0x0a7e:
            boolean r9 = r12.m32222a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            double r8 = com.google.android.gms.internal.measurement.C9946_a.m32013e(r13, r8)
            r14.mo32620a(r10, r8)
        L_0x0a8f:
            int r7 = r7 + 3
            goto L_0x0581
        L_0x0a93:
            com.google.android.gms.internal.measurement.W<?> r13 = r12.f30201r
            r13.mo32661a(r0)
            throw r3
        L_0x0a99:
            if (r0 != 0) goto L_0x0aa1
            com.google.android.gms.internal.measurement.Wa<?, ?> r0 = r12.f30200q
            m32219a(r0, (T) r13, r14)
            return
        L_0x0aa1:
            com.google.android.gms.internal.measurement.W<?> r13 = r12.f30201r
            r13.mo32663a(r14, r0)
            throw r3
        L_0x0aa7:
            r12.m32230b((T) r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C10012xa.mo32553a(java.lang.Object, com.google.android.gms.internal.measurement.lb):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:166:0x04b9  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x04bf  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m32230b(T r18, com.google.android.gms.internal.measurement.C9986lb r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.f30191h
            if (r3 == 0) goto L_0x0022
            com.google.android.gms.internal.measurement.W<?> r3 = r0.f30201r
            com.google.android.gms.internal.measurement.Z r3 = r3.mo32662a(r1)
            boolean r5 = r3.mo32686b()
            if (r5 != 0) goto L_0x0022
            java.util.Iterator r3 = r3.mo32690e()
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            goto L_0x0023
        L_0x0022:
            r3 = 0
        L_0x0023:
            r5 = -1
            int[] r6 = r0.f30186c
            int r6 = r6.length
            sun.misc.Unsafe r7 = f30185b
            r8 = 0
            r5 = 0
            r9 = -1
            r10 = 0
        L_0x002e:
            if (r5 >= r6) goto L_0x04b7
            int r11 = r0.m32233c(r5)
            int[] r12 = r0.f30186c
            r13 = r12[r5]
            r14 = 267386880(0xff00000, float:2.3665827E-29)
            r14 = r14 & r11
            int r14 = r14 >>> 20
            boolean r15 = r0.f30193j
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r4 = 1
            if (r15 != 0) goto L_0x0063
            r15 = 17
            if (r14 > r15) goto L_0x0063
            int r15 = r5 + 2
            r12 = r12[r15]
            r15 = r12 & r16
            if (r15 == r9) goto L_0x005d
            long r9 = (long) r15
            int r10 = r7.getInt(r1, r9)
            goto L_0x005e
        L_0x005d:
            r15 = r9
        L_0x005e:
            int r9 = r12 >>> 20
            int r9 = r4 << r9
            goto L_0x0065
        L_0x0063:
            r15 = r9
            r9 = 0
        L_0x0065:
            if (r3 != 0) goto L_0x04b0
            r11 = r11 & r16
            long r11 = (long) r11
            switch(r14) {
                case 0: goto L_0x049f;
                case 1: goto L_0x0492;
                case 2: goto L_0x0486;
                case 3: goto L_0x047a;
                case 4: goto L_0x046e;
                case 5: goto L_0x0462;
                case 6: goto L_0x0456;
                case 7: goto L_0x0449;
                case 8: goto L_0x043d;
                case 9: goto L_0x042c;
                case 10: goto L_0x041d;
                case 11: goto L_0x0410;
                case 12: goto L_0x0403;
                case 13: goto L_0x03f6;
                case 14: goto L_0x03e9;
                case 15: goto L_0x03dc;
                case 16: goto L_0x03cf;
                case 17: goto L_0x03bd;
                case 18: goto L_0x03ac;
                case 19: goto L_0x039b;
                case 20: goto L_0x038a;
                case 21: goto L_0x0379;
                case 22: goto L_0x0368;
                case 23: goto L_0x0357;
                case 24: goto L_0x0346;
                case 25: goto L_0x0335;
                case 26: goto L_0x0324;
                case 27: goto L_0x030e;
                case 28: goto L_0x02fd;
                case 29: goto L_0x02ec;
                case 30: goto L_0x02db;
                case 31: goto L_0x02ca;
                case 32: goto L_0x02b9;
                case 33: goto L_0x02a8;
                case 34: goto L_0x0297;
                case 35: goto L_0x0286;
                case 36: goto L_0x0275;
                case 37: goto L_0x0264;
                case 38: goto L_0x0253;
                case 39: goto L_0x0242;
                case 40: goto L_0x0231;
                case 41: goto L_0x0220;
                case 42: goto L_0x020f;
                case 43: goto L_0x01fe;
                case 44: goto L_0x01ed;
                case 45: goto L_0x01dc;
                case 46: goto L_0x01cb;
                case 47: goto L_0x01ba;
                case 48: goto L_0x01a9;
                case 49: goto L_0x0193;
                case 50: goto L_0x018a;
                case 51: goto L_0x017b;
                case 52: goto L_0x016c;
                case 53: goto L_0x015d;
                case 54: goto L_0x014e;
                case 55: goto L_0x013f;
                case 56: goto L_0x0130;
                case 57: goto L_0x0121;
                case 58: goto L_0x0112;
                case 59: goto L_0x0103;
                case 60: goto L_0x00f0;
                case 61: goto L_0x00df;
                case 62: goto L_0x00d0;
                case 63: goto L_0x00c1;
                case 64: goto L_0x00b2;
                case 65: goto L_0x00a3;
                case 66: goto L_0x0094;
                case 67: goto L_0x0085;
                case 68: goto L_0x0071;
                default: goto L_0x006f;
            }
        L_0x006f:
            goto L_0x04ab
        L_0x0071:
            boolean r4 = r0.m32223a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.measurement.Fa r9 = r0.m32214a(r5)
            r2.mo32636b(r13, r4, r9)
            goto L_0x04ab
        L_0x0085:
            boolean r4 = r0.m32223a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            long r11 = m32237e(r1, r11)
            r2.mo32623a(r13, r11)
            goto L_0x04ab
        L_0x0094:
            boolean r4 = r0.m32223a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            int r4 = m32236d(r1, r11)
            r2.mo32640c(r13, r4)
            goto L_0x04ab
        L_0x00a3:
            boolean r4 = r0.m32223a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            long r11 = m32237e(r1, r11)
            r2.mo32644d(r13, r11)
            goto L_0x04ab
        L_0x00b2:
            boolean r4 = r0.m32223a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            int r4 = m32236d(r1, r11)
            r2.mo32649f(r13, r4)
            goto L_0x04ab
        L_0x00c1:
            boolean r4 = r0.m32223a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            int r4 = m32236d(r1, r11)
            r2.mo32622a(r13, r4)
            goto L_0x04ab
        L_0x00d0:
            boolean r4 = r0.m32223a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            int r4 = m32236d(r1, r11)
            r2.mo32646e(r13, r4)
            goto L_0x04ab
        L_0x00df:
            boolean r4 = r0.m32223a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.measurement.zzte r4 = (com.google.android.gms.internal.measurement.zzte) r4
            r2.mo32624a(r13, r4)
            goto L_0x04ab
        L_0x00f0:
            boolean r4 = r0.m32223a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.measurement.Fa r9 = r0.m32214a(r5)
            r2.mo32626a(r13, r4, r9)
            goto L_0x04ab
        L_0x0103:
            boolean r4 = r0.m32223a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r7.getObject(r1, r11)
            m32218a(r13, r4, r2)
            goto L_0x04ab
        L_0x0112:
            boolean r4 = r0.m32223a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            boolean r4 = m32238f(r1, r11)
            r2.mo32631a(r13, r4)
            goto L_0x04ab
        L_0x0121:
            boolean r4 = r0.m32223a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            int r4 = m32236d(r1, r11)
            r2.mo32643d(r13, r4)
            goto L_0x04ab
        L_0x0130:
            boolean r4 = r0.m32223a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            long r11 = m32237e(r1, r11)
            r2.mo32635b(r13, r11)
            goto L_0x04ab
        L_0x013f:
            boolean r4 = r0.m32223a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            int r4 = m32236d(r1, r11)
            r2.mo32634b(r13, r4)
            goto L_0x04ab
        L_0x014e:
            boolean r4 = r0.m32223a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            long r11 = m32237e(r1, r11)
            r2.mo32641c(r13, r11)
            goto L_0x04ab
        L_0x015d:
            boolean r4 = r0.m32223a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            long r11 = m32237e(r1, r11)
            r2.mo32647e(r13, r11)
            goto L_0x04ab
        L_0x016c:
            boolean r4 = r0.m32223a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            float r4 = m32232c(r1, r11)
            r2.mo32621a(r13, r4)
            goto L_0x04ab
        L_0x017b:
            boolean r4 = r0.m32223a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            double r11 = m32226b((T) r1, r11)
            r2.mo32620a(r13, r11)
            goto L_0x04ab
        L_0x018a:
            java.lang.Object r4 = r7.getObject(r1, r11)
            r0.m32220a(r2, r13, r4, r5)
            goto L_0x04ab
        L_0x0193:
            int[] r4 = r0.f30186c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.Fa r11 = r0.m32214a(r5)
            com.google.android.gms.internal.measurement.C9910Ha.m31810b(r4, r9, r2, r11)
            goto L_0x04ab
        L_0x01a9:
            int[] r9 = r0.f30186c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.C9910Ha.m31823e(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x01ba:
            int[] r9 = r0.f30186c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.C9910Ha.m31838j(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x01cb:
            int[] r9 = r0.f30186c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.C9910Ha.m31829g(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x01dc:
            int[] r9 = r0.f30186c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.C9910Ha.m31840l(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x01ed:
            int[] r9 = r0.f30186c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.C9910Ha.m31841m(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x01fe:
            int[] r9 = r0.f30186c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.C9910Ha.m31835i(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x020f:
            int[] r9 = r0.f30186c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.C9910Ha.m31842n(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x0220:
            int[] r9 = r0.f30186c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.C9910Ha.m31839k(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x0231:
            int[] r9 = r0.f30186c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.C9910Ha.m31826f(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x0242:
            int[] r9 = r0.f30186c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.C9910Ha.m31832h(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x0253:
            int[] r9 = r0.f30186c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.C9910Ha.m31819d(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x0264:
            int[] r9 = r0.f30186c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.C9910Ha.m31815c(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x0275:
            int[] r9 = r0.f30186c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.C9910Ha.m31811b(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x0286:
            int[] r9 = r0.f30186c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.C9910Ha.m31798a(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x0297:
            int[] r4 = r0.f30186c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.C9910Ha.m31823e(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x02a8:
            int[] r4 = r0.f30186c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.C9910Ha.m31838j(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x02b9:
            int[] r4 = r0.f30186c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.C9910Ha.m31829g(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x02ca:
            int[] r4 = r0.f30186c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.C9910Ha.m31840l(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x02db:
            int[] r4 = r0.f30186c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.C9910Ha.m31841m(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x02ec:
            int[] r4 = r0.f30186c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.C9910Ha.m31835i(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x02fd:
            int[] r4 = r0.f30186c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.C9910Ha.m31809b(r4, r9, r2)
            goto L_0x04ab
        L_0x030e:
            int[] r4 = r0.f30186c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.Fa r11 = r0.m32214a(r5)
            com.google.android.gms.internal.measurement.C9910Ha.m31797a(r4, r9, r2, r11)
            goto L_0x04ab
        L_0x0324:
            int[] r4 = r0.f30186c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.C9910Ha.m31796a(r4, r9, r2)
            goto L_0x04ab
        L_0x0335:
            int[] r4 = r0.f30186c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.C9910Ha.m31842n(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x0346:
            int[] r4 = r0.f30186c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.C9910Ha.m31839k(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x0357:
            int[] r4 = r0.f30186c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.C9910Ha.m31826f(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x0368:
            int[] r4 = r0.f30186c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.C9910Ha.m31832h(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x0379:
            int[] r4 = r0.f30186c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.C9910Ha.m31819d(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x038a:
            int[] r4 = r0.f30186c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.C9910Ha.m31815c(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x039b:
            int[] r4 = r0.f30186c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.C9910Ha.m31811b(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x03ac:
            int[] r4 = r0.f30186c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.C9910Ha.m31798a(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x03bd:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.measurement.Fa r9 = r0.m32214a(r5)
            r2.mo32636b(r13, r4, r9)
            goto L_0x04ab
        L_0x03cf:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            long r11 = r7.getLong(r1, r11)
            r2.mo32623a(r13, r11)
            goto L_0x04ab
        L_0x03dc:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r7.getInt(r1, r11)
            r2.mo32640c(r13, r4)
            goto L_0x04ab
        L_0x03e9:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            long r11 = r7.getLong(r1, r11)
            r2.mo32644d(r13, r11)
            goto L_0x04ab
        L_0x03f6:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r7.getInt(r1, r11)
            r2.mo32649f(r13, r4)
            goto L_0x04ab
        L_0x0403:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r7.getInt(r1, r11)
            r2.mo32622a(r13, r4)
            goto L_0x04ab
        L_0x0410:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r7.getInt(r1, r11)
            r2.mo32646e(r13, r4)
            goto L_0x04ab
        L_0x041d:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.measurement.zzte r4 = (com.google.android.gms.internal.measurement.zzte) r4
            r2.mo32624a(r13, r4)
            goto L_0x04ab
        L_0x042c:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.measurement.Fa r9 = r0.m32214a(r5)
            r2.mo32626a(r13, r4, r9)
            goto L_0x04ab
        L_0x043d:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r7.getObject(r1, r11)
            m32218a(r13, r4, r2)
            goto L_0x04ab
        L_0x0449:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            boolean r4 = com.google.android.gms.internal.measurement.C9946_a.m32007c(r1, r11)
            r2.mo32631a(r13, r4)
            goto L_0x04ab
        L_0x0456:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r7.getInt(r1, r11)
            r2.mo32643d(r13, r4)
            goto L_0x04ab
        L_0x0462:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            long r11 = r7.getLong(r1, r11)
            r2.mo32635b(r13, r11)
            goto L_0x04ab
        L_0x046e:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r7.getInt(r1, r11)
            r2.mo32634b(r13, r4)
            goto L_0x04ab
        L_0x047a:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            long r11 = r7.getLong(r1, r11)
            r2.mo32641c(r13, r11)
            goto L_0x04ab
        L_0x0486:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            long r11 = r7.getLong(r1, r11)
            r2.mo32647e(r13, r11)
            goto L_0x04ab
        L_0x0492:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            float r4 = com.google.android.gms.internal.measurement.C9946_a.m32008d(r1, r11)
            r2.mo32621a(r13, r4)
            goto L_0x04ab
        L_0x049f:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            double r11 = com.google.android.gms.internal.measurement.C9946_a.m32013e(r1, r11)
            r2.mo32620a(r13, r11)
        L_0x04ab:
            int r5 = r5 + 3
            r9 = r15
            goto L_0x002e
        L_0x04b0:
            com.google.android.gms.internal.measurement.W<?> r1 = r0.f30201r
            r1.mo32661a(r3)
            r1 = 0
            throw r1
        L_0x04b7:
            if (r3 != 0) goto L_0x04bf
            com.google.android.gms.internal.measurement.Wa<?, ?> r3 = r0.f30200q
            m32219a(r3, (T) r1, r2)
            return
        L_0x04bf:
            com.google.android.gms.internal.measurement.W<?> r1 = r0.f30201r
            r1.mo32663a(r2, r3)
            r1 = 0
            goto L_0x04c7
        L_0x04c6:
            throw r1
        L_0x04c7:
            goto L_0x04c6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C10012xa.m32230b(java.lang.Object, com.google.android.gms.internal.measurement.lb):void");
    }

    /* renamed from: a */
    private final <K, V> void m32220a(C9986lb lbVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            this.f30202s.mo32754e(m32227b(i2));
            throw null;
        }
    }

    /* renamed from: a */
    private static <UT, UB> void m32219a(C9939Wa<UT, UB> wa, T t, C9986lb lbVar) throws IOException {
        wa.mo32668a(wa.mo32670b(t), lbVar);
    }

    /* renamed from: a */
    private final C9906Fa m32214a(int i) {
        int i2 = (i / 3) << 1;
        C9906Fa fa = (C9906Fa) this.f30187d[i2];
        if (fa != null) {
            return fa;
        }
        C9906Fa a = C9902Da.m31767a().mo32533a((Class) this.f30187d[i2 + 1]);
        this.f30187d[i2] = a;
        return a;
    }

    /* renamed from: b */
    private final Object m32227b(int i) {
        return this.f30187d[(i / 3) << 1];
    }

    /* renamed from: d */
    public final void mo32558d(T t) {
        int i;
        int i2 = this.f30196m;
        while (true) {
            i = this.f30197n;
            if (i2 >= i) {
                break;
            }
            long c = (long) (m32233c(this.f30195l[i2]) & 1048575);
            Object f = C9946_a.m32016f(t, c);
            if (f != null) {
                this.f30202s.mo32753d(f);
                C9946_a.m31994a((Object) t, c, f);
            }
            i2++;
        }
        int length = this.f30195l.length;
        while (i < length) {
            this.f30199p.mo32734a(t, (long) this.f30195l[i]);
            i++;
        }
        this.f30200q.mo32674d(t);
        if (this.f30191h) {
            this.f30201r.mo32666c(t);
        }
    }

    /* renamed from: c */
    public final boolean mo32557c(T t) {
        int i;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.f30196m) {
                return !this.f30191h || this.f30201r.mo32662a((Object) t).mo32689d();
            }
            int i5 = this.f30195l[i2];
            int i6 = this.f30186c[i5];
            int c = m32233c(i5);
            if (!this.f30193j) {
                int i7 = this.f30186c[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = f30185b.getInt(t, (long) i8);
                    i3 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & c) != 0) && !m32224a(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & c) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (m32223a(t, i6, i5) && !m32225a((Object) t, c, m32214a(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 == 50 && !this.f30202s.mo32752a(C9946_a.m32016f(t, (long) (c & 1048575))).isEmpty()) {
                            this.f30202s.mo32754e(m32227b(i5));
                            throw null;
                        }
                    }
                }
                List list = (List) C9946_a.m32016f(t, (long) (c & 1048575));
                if (!list.isEmpty()) {
                    C9906Fa a = m32214a(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!a.mo32557c(list.get(i10))) {
                            z = false;
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (m32224a(t, i5, i4, i) && !m32225a((Object) t, c, m32214a(i5))) {
                return false;
            }
            i2++;
        }
    }

    /* renamed from: a */
    private static boolean m32225a(Object obj, int i, C9906Fa fa) {
        return fa.mo32557c(C9946_a.m32016f(obj, (long) (i & 1048575)));
    }

    /* renamed from: a */
    private static void m32218a(int i, Object obj, C9986lb lbVar) throws IOException {
        if (obj instanceof String) {
            lbVar.mo32627a(i, (String) obj);
        } else {
            lbVar.mo32624a(i, (zzte) obj);
        }
    }

    /* renamed from: c */
    private final int m32233c(int i) {
        return this.f30186c[i + 1];
    }

    /* renamed from: d */
    private final int m32235d(int i) {
        return this.f30186c[i + 2];
    }

    /* renamed from: b */
    private static <T> double m32226b(T t, long j) {
        return ((Double) C9946_a.m32016f(t, j)).doubleValue();
    }

    /* renamed from: c */
    private static <T> float m32232c(T t, long j) {
        return ((Float) C9946_a.m32016f(t, j)).floatValue();
    }

    /* renamed from: d */
    private static <T> int m32236d(T t, long j) {
        return ((Integer) C9946_a.m32016f(t, j)).intValue();
    }

    /* renamed from: e */
    private static <T> long m32237e(T t, long j) {
        return ((Long) C9946_a.m32016f(t, j)).longValue();
    }

    /* renamed from: f */
    private static <T> boolean m32238f(T t, long j) {
        return ((Boolean) C9946_a.m32016f(t, j)).booleanValue();
    }

    /* renamed from: c */
    private final boolean m32234c(T t, T t2, int i) {
        return m32222a(t, i) == m32222a(t2, i);
    }

    /* renamed from: a */
    private final boolean m32224a(T t, int i, int i2, int i3) {
        if (this.f30193j) {
            return m32222a(t, i);
        }
        return (i2 & i3) != 0;
    }

    /* renamed from: a */
    private final boolean m32222a(T t, int i) {
        if (this.f30193j) {
            int c = m32233c(i);
            long j = (long) (c & 1048575);
            switch ((c & 267386880) >>> 20) {
                case 0:
                    return C9946_a.m32013e(t, j) != 0.0d;
                case 1:
                    return C9946_a.m32008d(t, j) != 0.0f;
                case 2:
                    return C9946_a.m31999b(t, j) != 0;
                case 3:
                    return C9946_a.m31999b(t, j) != 0;
                case 4:
                    return C9946_a.m31986a((Object) t, j) != 0;
                case 5:
                    return C9946_a.m31999b(t, j) != 0;
                case 6:
                    return C9946_a.m31986a((Object) t, j) != 0;
                case 7:
                    return C9946_a.m32007c(t, j);
                case 8:
                    Object f = C9946_a.m32016f(t, j);
                    if (f instanceof String) {
                        return !((String) f).isEmpty();
                    }
                    if (f instanceof zzte) {
                        return !zzte.f30248a.equals(f);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return C9946_a.m32016f(t, j) != null;
                case 10:
                    return !zzte.f30248a.equals(C9946_a.m32016f(t, j));
                case 11:
                    return C9946_a.m31986a((Object) t, j) != 0;
                case 12:
                    return C9946_a.m31986a((Object) t, j) != 0;
                case 13:
                    return C9946_a.m31986a((Object) t, j) != 0;
                case 14:
                    return C9946_a.m31999b(t, j) != 0;
                case 15:
                    return C9946_a.m31986a((Object) t, j) != 0;
                case 16:
                    return C9946_a.m31999b(t, j) != 0;
                case 17:
                    return C9946_a.m32016f(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int d = m32235d(i);
            return (C9946_a.m31986a((Object) t, (long) (d & 1048575)) & (1 << (d >>> 20))) != 0;
        }
    }

    /* renamed from: b */
    private final void m32228b(T t, int i) {
        if (!this.f30193j) {
            int d = m32235d(i);
            long j = (long) (d & 1048575);
            C9946_a.m31992a((Object) t, j, C9946_a.m31986a((Object) t, j) | (1 << (d >>> 20)));
        }
    }

    /* renamed from: a */
    private final boolean m32223a(T t, int i, int i2) {
        return C9946_a.m31986a((Object) t, (long) (m32235d(i2) & 1048575)) == i;
    }

    /* renamed from: b */
    private final void m32229b(T t, int i, int i2) {
        C9946_a.m31992a((Object) t, (long) (m32235d(i2) & 1048575), i);
    }
}
