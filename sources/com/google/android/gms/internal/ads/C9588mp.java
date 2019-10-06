package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.ads.mp */
final class C9588mp<T> implements C9822xp<T> {

    /* renamed from: a */
    private static final int[] f22769a = new int[0];

    /* renamed from: b */
    private static final Unsafe f22770b = C9132Sp.m23002d();

    /* renamed from: c */
    private final int[] f22771c;

    /* renamed from: d */
    private final Object[] f22772d;

    /* renamed from: e */
    private final int f22773e;

    /* renamed from: f */
    private final int f22774f;

    /* renamed from: g */
    private final zzdpk f22775g;

    /* renamed from: h */
    private final boolean f22776h;

    /* renamed from: i */
    private final boolean f22777i;

    /* renamed from: j */
    private final boolean f22778j;

    /* renamed from: k */
    private final boolean f22779k;

    /* renamed from: l */
    private final int[] f22780l;

    /* renamed from: m */
    private final int f22781m;

    /* renamed from: n */
    private final int f22782n;

    /* renamed from: o */
    private final C9632op f22783o;

    /* renamed from: p */
    private final C9240Xo f22784p;

    /* renamed from: q */
    private final C9049Op<?, ?> f22785q;

    /* renamed from: r */
    private final C8922Io<?> f22786r;

    /* renamed from: s */
    private final C9456gp f22787s;

    private C9588mp(int[] iArr, Object[] objArr, int i, int i2, zzdpk zzdpk, boolean z, boolean z2, int[] iArr2, int i3, int i4, C9632op opVar, C9240Xo xo, C9049Op<?, ?> op, C8922Io<?> io, C9456gp gpVar) {
        this.f22771c = iArr;
        this.f22772d = objArr;
        this.f22773e = i;
        this.f22774f = i2;
        this.f22777i = zzdpk instanceof zzdob;
        this.f22778j = z;
        this.f22776h = io != null && io.mo28363a(zzdpk);
        this.f22779k = false;
        this.f22780l = iArr2;
        this.f22781m = i3;
        this.f22782n = i4;
        this.f22783o = opVar;
        this.f22784p = xo;
        this.f22785q = op;
        this.f22786r = io;
        this.f22775g = zzdpk;
        this.f22787s = gpVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:169:0x0396  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.ads.C9588mp<T> m23891a(java.lang.Class<T> r35, com.google.android.gms.internal.ads.C9522jp r36, com.google.android.gms.internal.ads.C9632op r37, com.google.android.gms.internal.ads.C9240Xo r38, com.google.android.gms.internal.ads.C9049Op<?, ?> r39, com.google.android.gms.internal.ads.C8922Io<?> r40, com.google.android.gms.internal.ads.C9456gp r41) {
        /*
            r0 = r36
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.C9759up
            if (r1 == 0) goto L_0x0461
            com.google.android.gms.internal.ads.up r0 = (com.google.android.gms.internal.ads.C9759up) r0
            int r1 = r0.mo28408c()
            int r2 = com.google.android.gms.internal.ads.zzdob.zze.f28079j
            r3 = 0
            if (r1 != r2) goto L_0x0013
            r11 = 1
            goto L_0x0014
        L_0x0013:
            r11 = 0
        L_0x0014:
            java.lang.String r1 = r0.mo29214d()
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
            int[] r8 = f22769a
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
            sun.misc.Unsafe r6 = f22770b
            java.lang.Object[] r17 = r0.mo29215e()
            com.google.android.gms.internal.ads.zzdpk r18 = r0.mo28407b()
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
            java.lang.reflect.Field r8 = m23895a(r7, r8)
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
            java.lang.reflect.Field r8 = m23895a(r7, r8)
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
            java.lang.reflect.Field r9 = m23895a(r7, r9)
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
            java.lang.reflect.Field r13 = m23895a(r7, r13)
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
            com.google.android.gms.internal.ads.mp r1 = new com.google.android.gms.internal.ads.mp
            com.google.android.gms.internal.ads.zzdpk r10 = r0.mo28407b()
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
            com.google.android.gms.internal.ads.Kp r0 = (com.google.android.gms.internal.ads.C8965Kp) r0
            r0.mo28408c()
            r0 = 0
            goto L_0x0469
        L_0x0468:
            throw r0
        L_0x0469:
            goto L_0x0468
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9588mp.m23891a(java.lang.Class, com.google.android.gms.internal.ads.jp, com.google.android.gms.internal.ads.op, com.google.android.gms.internal.ads.Xo, com.google.android.gms.internal.ads.Op, com.google.android.gms.internal.ads.Io, com.google.android.gms.internal.ads.gp):com.google.android.gms.internal.ads.mp");
    }

    /* renamed from: a */
    private static Field m23895a(Class<?> cls, String str) {
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

    /* renamed from: a */
    public final T mo29080a() {
        return this.f22783o.mo29113a(this.f22775g);
    }

    /* renamed from: b */
    public final boolean mo29086b(T t, T t2) {
        int length = this.f22771c.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                int d = m23916d(i);
                long j = (long) (d & 1048575);
                switch ((d & 267386880) >>> 20) {
                    case 0:
                        if (!m23915c(t, t2, i) || Double.doubleToLongBits(C9132Sp.m23006e(t, j)) != Double.doubleToLongBits(C9132Sp.m23006e(t2, j))) {
                            z = false;
                            break;
                        }
                    case 1:
                        if (!m23915c(t, t2, i) || Float.floatToIntBits(C9132Sp.m23001d(t, j)) != Float.floatToIntBits(C9132Sp.m23001d(t2, j))) {
                            z = false;
                            break;
                        }
                    case 2:
                        if (!m23915c(t, t2, i) || C9132Sp.m22992b(t, j) != C9132Sp.m22992b(t2, j)) {
                            z = false;
                            break;
                        }
                    case 3:
                        if (!m23915c(t, t2, i) || C9132Sp.m22992b(t, j) != C9132Sp.m22992b(t2, j)) {
                            z = false;
                            break;
                        }
                    case 4:
                        if (!m23915c(t, t2, i) || C9132Sp.m22976a((Object) t, j) != C9132Sp.m22976a((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 5:
                        if (!m23915c(t, t2, i) || C9132Sp.m22992b(t, j) != C9132Sp.m22992b(t2, j)) {
                            z = false;
                            break;
                        }
                    case 6:
                        if (!m23915c(t, t2, i) || C9132Sp.m22976a((Object) t, j) != C9132Sp.m22976a((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 7:
                        if (!m23915c(t, t2, i) || C9132Sp.m23000c(t, j) != C9132Sp.m23000c(t2, j)) {
                            z = false;
                            break;
                        }
                    case 8:
                        if (!m23915c(t, t2, i) || !C9864zp.m24400a(C9132Sp.m23009f(t, j), C9132Sp.m23009f(t2, j))) {
                            z = false;
                            break;
                        }
                    case 9:
                        if (!m23915c(t, t2, i) || !C9864zp.m24400a(C9132Sp.m23009f(t, j), C9132Sp.m23009f(t2, j))) {
                            z = false;
                            break;
                        }
                    case 10:
                        if (!m23915c(t, t2, i) || !C9864zp.m24400a(C9132Sp.m23009f(t, j), C9132Sp.m23009f(t2, j))) {
                            z = false;
                            break;
                        }
                    case 11:
                        if (!m23915c(t, t2, i) || C9132Sp.m22976a((Object) t, j) != C9132Sp.m22976a((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 12:
                        if (!m23915c(t, t2, i) || C9132Sp.m22976a((Object) t, j) != C9132Sp.m22976a((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 13:
                        if (!m23915c(t, t2, i) || C9132Sp.m22976a((Object) t, j) != C9132Sp.m22976a((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 14:
                        if (!m23915c(t, t2, i) || C9132Sp.m22992b(t, j) != C9132Sp.m22992b(t2, j)) {
                            z = false;
                            break;
                        }
                    case 15:
                        if (!m23915c(t, t2, i) || C9132Sp.m22976a((Object) t, j) != C9132Sp.m22976a((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 16:
                        if (!m23915c(t, t2, i) || C9132Sp.m22992b(t, j) != C9132Sp.m22992b(t2, j)) {
                            z = false;
                            break;
                        }
                    case 17:
                        if (!m23915c(t, t2, i) || !C9864zp.m24400a(C9132Sp.m23009f(t, j), C9132Sp.m23009f(t2, j))) {
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
                        z = C9864zp.m24400a(C9132Sp.m23009f(t, j), C9132Sp.m23009f(t2, j));
                        break;
                    case 50:
                        z = C9864zp.m24400a(C9132Sp.m23009f(t, j), C9132Sp.m23009f(t2, j));
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
                        long e = (long) (m23918e(i) & 1048575);
                        if (C9132Sp.m22976a((Object) t, e) != C9132Sp.m22976a((Object) t2, e) || !C9864zp.m24400a(C9132Sp.m23009f(t, j), C9132Sp.m23009f(t2, j))) {
                            z = false;
                            break;
                        }
                }
                if (!z) {
                    return false;
                }
                i += 3;
            } else if (!this.f22785q.mo28496d(t).equals(this.f22785q.mo28496d(t2))) {
                return false;
            } else {
                if (this.f22776h) {
                    return this.f22786r.mo28364b(t).equals(this.f22786r.mo28364b(t2));
                }
                return true;
            }
        }
    }

    /* renamed from: a */
    public final int mo29078a(T t) {
        int length = this.f22771c.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int d = m23916d(i2);
            int i3 = this.f22771c[i2];
            long j = (long) (1048575 & d);
            int i4 = 37;
            switch ((d & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + zzdod.m29912a(Double.doubleToLongBits(C9132Sp.m23006e(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(C9132Sp.m23001d(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzdod.m29912a(C9132Sp.m22992b(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzdod.m29912a(C9132Sp.m22992b(t, j));
                    break;
                case 4:
                    i = (i * 53) + C9132Sp.m22976a((Object) t, j);
                    break;
                case 5:
                    i = (i * 53) + zzdod.m29912a(C9132Sp.m22992b(t, j));
                    break;
                case 6:
                    i = (i * 53) + C9132Sp.m22976a((Object) t, j);
                    break;
                case 7:
                    i = (i * 53) + zzdod.m29913a(C9132Sp.m23000c(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) C9132Sp.m23009f(t, j)).hashCode();
                    break;
                case 9:
                    Object f = C9132Sp.m23009f(t, j);
                    if (f != null) {
                        i4 = f.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 10:
                    i = (i * 53) + C9132Sp.m23009f(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + C9132Sp.m22976a((Object) t, j);
                    break;
                case 12:
                    i = (i * 53) + C9132Sp.m22976a((Object) t, j);
                    break;
                case 13:
                    i = (i * 53) + C9132Sp.m22976a((Object) t, j);
                    break;
                case 14:
                    i = (i * 53) + zzdod.m29912a(C9132Sp.m22992b(t, j));
                    break;
                case 15:
                    i = (i * 53) + C9132Sp.m22976a((Object) t, j);
                    break;
                case 16:
                    i = (i * 53) + zzdod.m29912a(C9132Sp.m22992b(t, j));
                    break;
                case 17:
                    Object f2 = C9132Sp.m23009f(t, j);
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
                    i = (i * 53) + C9132Sp.m23009f(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + C9132Sp.m23009f(t, j).hashCode();
                    break;
                case 51:
                    if (!m23903a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzdod.m29912a(Double.doubleToLongBits(m23906b(t, j)));
                        break;
                    }
                case 52:
                    if (!m23903a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + Float.floatToIntBits(m23913c(t, j));
                        break;
                    }
                case 53:
                    if (!m23903a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzdod.m29912a(m23919e(t, j));
                        break;
                    }
                case 54:
                    if (!m23903a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzdod.m29912a(m23919e(t, j));
                        break;
                    }
                case 55:
                    if (!m23903a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + m23917d(t, j);
                        break;
                    }
                case 56:
                    if (!m23903a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzdod.m29912a(m23919e(t, j));
                        break;
                    }
                case 57:
                    if (!m23903a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + m23917d(t, j);
                        break;
                    }
                case 58:
                    if (!m23903a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzdod.m29913a(m23922f(t, j));
                        break;
                    }
                case 59:
                    if (!m23903a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + ((String) C9132Sp.m23009f(t, j)).hashCode();
                        break;
                    }
                case 60:
                    if (!m23903a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + C9132Sp.m23009f(t, j).hashCode();
                        break;
                    }
                case 61:
                    if (!m23903a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + C9132Sp.m23009f(t, j).hashCode();
                        break;
                    }
                case 62:
                    if (!m23903a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + m23917d(t, j);
                        break;
                    }
                case 63:
                    if (!m23903a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + m23917d(t, j);
                        break;
                    }
                case 64:
                    if (!m23903a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + m23917d(t, j);
                        break;
                    }
                case 65:
                    if (!m23903a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzdod.m29912a(m23919e(t, j));
                        break;
                    }
                case 66:
                    if (!m23903a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + m23917d(t, j);
                        break;
                    }
                case 67:
                    if (!m23903a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzdod.m29912a(m23919e(t, j));
                        break;
                    }
                case 68:
                    if (!m23903a(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + C9132Sp.m23009f(t, j).hashCode();
                        break;
                    }
            }
        }
        int hashCode = (i * 53) + this.f22785q.mo28496d(t).hashCode();
        if (this.f22776h) {
            return (hashCode * 53) + this.f22786r.mo28364b(t).hashCode();
        }
        return hashCode;
    }

    /* renamed from: a */
    public final void mo29083a(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.f22771c.length; i += 3) {
                int d = m23916d(i);
                long j = (long) (1048575 & d);
                int i2 = this.f22771c[i];
                switch ((d & 267386880) >>> 20) {
                    case 0:
                        if (!m23902a(t2, i)) {
                            break;
                        } else {
                            C9132Sp.m22982a((Object) t, j, C9132Sp.m23006e(t2, j));
                            m23909b(t, i);
                            break;
                        }
                    case 1:
                        if (!m23902a(t2, i)) {
                            break;
                        } else {
                            C9132Sp.m22983a((Object) t, j, C9132Sp.m23001d(t2, j));
                            m23909b(t, i);
                            break;
                        }
                    case 2:
                        if (!m23902a(t2, i)) {
                            break;
                        } else {
                            C9132Sp.m22985a((Object) t, j, C9132Sp.m22992b(t2, j));
                            m23909b(t, i);
                            break;
                        }
                    case 3:
                        if (!m23902a(t2, i)) {
                            break;
                        } else {
                            C9132Sp.m22985a((Object) t, j, C9132Sp.m22992b(t2, j));
                            m23909b(t, i);
                            break;
                        }
                    case 4:
                        if (!m23902a(t2, i)) {
                            break;
                        } else {
                            C9132Sp.m22984a((Object) t, j, C9132Sp.m22976a((Object) t2, j));
                            m23909b(t, i);
                            break;
                        }
                    case 5:
                        if (!m23902a(t2, i)) {
                            break;
                        } else {
                            C9132Sp.m22985a((Object) t, j, C9132Sp.m22992b(t2, j));
                            m23909b(t, i);
                            break;
                        }
                    case 6:
                        if (!m23902a(t2, i)) {
                            break;
                        } else {
                            C9132Sp.m22984a((Object) t, j, C9132Sp.m22976a((Object) t2, j));
                            m23909b(t, i);
                            break;
                        }
                    case 7:
                        if (!m23902a(t2, i)) {
                            break;
                        } else {
                            C9132Sp.m22987a((Object) t, j, C9132Sp.m23000c(t2, j));
                            m23909b(t, i);
                            break;
                        }
                    case 8:
                        if (!m23902a(t2, i)) {
                            break;
                        } else {
                            C9132Sp.m22986a((Object) t, j, C9132Sp.m23009f(t2, j));
                            m23909b(t, i);
                            break;
                        }
                    case 9:
                        m23901a(t, t2, i);
                        break;
                    case 10:
                        if (!m23902a(t2, i)) {
                            break;
                        } else {
                            C9132Sp.m22986a((Object) t, j, C9132Sp.m23009f(t2, j));
                            m23909b(t, i);
                            break;
                        }
                    case 11:
                        if (!m23902a(t2, i)) {
                            break;
                        } else {
                            C9132Sp.m22984a((Object) t, j, C9132Sp.m22976a((Object) t2, j));
                            m23909b(t, i);
                            break;
                        }
                    case 12:
                        if (!m23902a(t2, i)) {
                            break;
                        } else {
                            C9132Sp.m22984a((Object) t, j, C9132Sp.m22976a((Object) t2, j));
                            m23909b(t, i);
                            break;
                        }
                    case 13:
                        if (!m23902a(t2, i)) {
                            break;
                        } else {
                            C9132Sp.m22984a((Object) t, j, C9132Sp.m22976a((Object) t2, j));
                            m23909b(t, i);
                            break;
                        }
                    case 14:
                        if (!m23902a(t2, i)) {
                            break;
                        } else {
                            C9132Sp.m22985a((Object) t, j, C9132Sp.m22992b(t2, j));
                            m23909b(t, i);
                            break;
                        }
                    case 15:
                        if (!m23902a(t2, i)) {
                            break;
                        } else {
                            C9132Sp.m22984a((Object) t, j, C9132Sp.m22976a((Object) t2, j));
                            m23909b(t, i);
                            break;
                        }
                    case 16:
                        if (!m23902a(t2, i)) {
                            break;
                        } else {
                            C9132Sp.m22985a((Object) t, j, C9132Sp.m22992b(t2, j));
                            m23909b(t, i);
                            break;
                        }
                    case 17:
                        m23901a(t, t2, i);
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
                        this.f22784p.mo28697a(t, t2, j);
                        break;
                    case 50:
                        C9864zp.m24398a(this.f22787s, t, t2, j);
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
                        if (!m23903a(t2, i2, i)) {
                            break;
                        } else {
                            C9132Sp.m22986a((Object) t, j, C9132Sp.m23009f(t2, j));
                            m23910b(t, i2, i);
                            break;
                        }
                    case 60:
                        m23912b(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!m23903a(t2, i2, i)) {
                            break;
                        } else {
                            C9132Sp.m22986a((Object) t, j, C9132Sp.m23009f(t2, j));
                            m23910b(t, i2, i);
                            break;
                        }
                    case 68:
                        m23912b(t, t2, i);
                        break;
                }
            }
            if (!this.f22778j) {
                C9864zp.m24397a(this.f22785q, t, t2);
                if (this.f22776h) {
                    C9864zp.m24396a(this.f22786r, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    private final void m23901a(T t, T t2, int i) {
        long d = (long) (m23916d(i) & 1048575);
        if (m23902a(t2, i)) {
            Object f = C9132Sp.m23009f(t, d);
            Object f2 = C9132Sp.m23009f(t2, d);
            if (f == null || f2 == null) {
                if (f2 != null) {
                    C9132Sp.m22986a((Object) t, d, f2);
                    m23909b(t, i);
                }
                return;
            }
            C9132Sp.m22986a((Object) t, d, zzdod.m29916a(f, f2));
            m23909b(t, i);
        }
    }

    /* renamed from: b */
    private final void m23912b(T t, T t2, int i) {
        int d = m23916d(i);
        int i2 = this.f22771c[i];
        long j = (long) (d & 1048575);
        if (m23903a(t2, i2, i)) {
            Object f = C9132Sp.m23009f(t, j);
            Object f2 = C9132Sp.m23009f(t2, j);
            if (f == null || f2 == null) {
                if (f2 != null) {
                    C9132Sp.m22986a((Object) t, j, f2);
                    m23910b(t, i2, i);
                }
                return;
            }
            C9132Sp.m22986a((Object) t, j, zzdod.m29916a(f, f2));
            m23910b(t, i2, i);
        }
    }

    /* renamed from: b */
    public final int mo29085b(T t) {
        int i;
        int i2;
        long j;
        int i3;
        T t2 = t;
        int i4 = 267386880;
        if (this.f22778j) {
            Unsafe unsafe = f22770b;
            int i5 = 0;
            int i6 = 0;
            while (i5 < this.f22771c.length) {
                int d = m23916d(i5);
                int i7 = (d & i4) >>> 20;
                int i8 = this.f22771c[i5];
                long j2 = (long) (d & 1048575);
                if (i7 < zzdnv.DOUBLE_LIST_PACKED.mo31600e() || i7 > zzdnv.SINT64_LIST_PACKED.mo31600e()) {
                    i3 = 0;
                } else {
                    i3 = this.f22771c[i5 + 2] & 1048575;
                }
                switch (i7) {
                    case 0:
                        if (!m23902a(t2, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29707b(i8, 0.0d);
                            break;
                        }
                    case 1:
                        if (!m23902a(t2, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29708b(i8, 0.0f);
                            break;
                        }
                    case 2:
                        if (!m23902a(t2, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29722d(i8, C9132Sp.m22992b(t2, j2));
                            break;
                        }
                    case 3:
                        if (!m23902a(t2, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29729e(i8, C9132Sp.m22992b(t2, j2));
                            break;
                        }
                    case 4:
                        if (!m23902a(t2, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29709b(i8, C9132Sp.m22976a((Object) t2, j2));
                            break;
                        }
                    case 5:
                        if (!m23902a(t2, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29737g(i8, 0);
                            break;
                        }
                    case 6:
                        if (!m23902a(t2, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29728e(i8, 0);
                            break;
                        }
                    case 7:
                        if (!m23902a(t2, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29713b(i8, true);
                            break;
                        }
                    case 8:
                        if (!m23902a(t2, i5)) {
                            break;
                        } else {
                            Object f = C9132Sp.m23009f(t2, j2);
                            if (!(f instanceof zzdmr)) {
                                i6 += zzdni.m29712b(i8, (String) f);
                                break;
                            } else {
                                i6 += zzdni.m29718c(i8, (zzdmr) f);
                                break;
                            }
                        }
                    case 9:
                        if (!m23902a(t2, i5)) {
                            break;
                        } else {
                            i6 += C9864zp.m24384a(i8, C9132Sp.m23009f(t2, j2), m23892a(i5));
                            break;
                        }
                    case 10:
                        if (!m23902a(t2, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29718c(i8, (zzdmr) C9132Sp.m23009f(t2, j2));
                            break;
                        }
                    case 11:
                        if (!m23902a(t2, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29717c(i8, C9132Sp.m22976a((Object) t2, j2));
                            break;
                        }
                    case 12:
                        if (!m23902a(t2, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29736g(i8, C9132Sp.m22976a((Object) t2, j2));
                            break;
                        }
                    case 13:
                        if (!m23902a(t2, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29732f(i8, 0);
                            break;
                        }
                    case 14:
                        if (!m23902a(t2, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29740h(i8, 0);
                            break;
                        }
                    case 15:
                        if (!m23902a(t2, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29721d(i8, C9132Sp.m22976a((Object) t2, j2));
                            break;
                        }
                    case 16:
                        if (!m23902a(t2, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29733f(i8, C9132Sp.m22992b(t2, j2));
                            break;
                        }
                    case 17:
                        if (!m23902a(t2, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29720c(i8, (zzdpk) C9132Sp.m23009f(t2, j2), m23892a(i5));
                            break;
                        }
                    case 18:
                        i6 += C9864zp.m24430i(i8, m23896a((Object) t2, j2), false);
                        break;
                    case 19:
                        i6 += C9864zp.m24427h(i8, m23896a((Object) t2, j2), false);
                        break;
                    case 20:
                        i6 += C9864zp.m24387a(i8, m23896a((Object) t2, j2), false);
                        break;
                    case 21:
                        i6 += C9864zp.m24403b(i8, m23896a((Object) t2, j2), false);
                        break;
                    case 22:
                        i6 += C9864zp.m24417e(i8, m23896a((Object) t2, j2), false);
                        break;
                    case 23:
                        i6 += C9864zp.m24430i(i8, m23896a((Object) t2, j2), false);
                        break;
                    case 24:
                        i6 += C9864zp.m24427h(i8, m23896a((Object) t2, j2), false);
                        break;
                    case 25:
                        i6 += C9864zp.m24433j(i8, m23896a((Object) t2, j2), false);
                        break;
                    case 26:
                        i6 += C9864zp.m24385a(i8, m23896a((Object) t2, j2));
                        break;
                    case 27:
                        i6 += C9864zp.m24386a(i8, m23896a((Object) t2, j2), m23892a(i5));
                        break;
                    case 28:
                        i6 += C9864zp.m24401b(i8, m23896a((Object) t2, j2));
                        break;
                    case 29:
                        i6 += C9864zp.m24421f(i8, m23896a((Object) t2, j2), false);
                        break;
                    case 30:
                        i6 += C9864zp.m24413d(i8, m23896a((Object) t2, j2), false);
                        break;
                    case 31:
                        i6 += C9864zp.m24427h(i8, m23896a((Object) t2, j2), false);
                        break;
                    case 32:
                        i6 += C9864zp.m24430i(i8, m23896a((Object) t2, j2), false);
                        break;
                    case 33:
                        i6 += C9864zp.m24424g(i8, m23896a((Object) t2, j2), false);
                        break;
                    case 34:
                        i6 += C9864zp.m24409c(i8, m23896a((Object) t2, j2), false);
                        break;
                    case 35:
                        int g = C9864zp.m24425g((List) unsafe.getObject(t2, j2));
                        if (g > 0) {
                            if (this.f22779k) {
                                unsafe.putInt(t2, (long) i3, g);
                            }
                            i6 += zzdni.m29727e(i8) + zzdni.m29735g(g) + g;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        int f2 = C9864zp.m24422f((List) unsafe.getObject(t2, j2));
                        if (f2 > 0) {
                            if (this.f22779k) {
                                unsafe.putInt(t2, (long) i3, f2);
                            }
                            i6 += zzdni.m29727e(i8) + zzdni.m29735g(f2) + f2;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        int i9 = C9864zp.m24431i((List) unsafe.getObject(t2, j2));
                        if (i9 > 0) {
                            if (this.f22779k) {
                                unsafe.putInt(t2, (long) i3, i9);
                            }
                            i6 += zzdni.m29727e(i8) + zzdni.m29735g(i9) + i9;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        int j3 = C9864zp.m24434j((List) unsafe.getObject(t2, j2));
                        if (j3 > 0) {
                            if (this.f22779k) {
                                unsafe.putInt(t2, (long) i3, j3);
                            }
                            i6 += zzdni.m29727e(i8) + zzdni.m29735g(j3) + j3;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        int c = C9864zp.m24410c((List) unsafe.getObject(t2, j2));
                        if (c > 0) {
                            if (this.f22779k) {
                                unsafe.putInt(t2, (long) i3, c);
                            }
                            i6 += zzdni.m29727e(i8) + zzdni.m29735g(c) + c;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        int g2 = C9864zp.m24425g((List) unsafe.getObject(t2, j2));
                        if (g2 > 0) {
                            if (this.f22779k) {
                                unsafe.putInt(t2, (long) i3, g2);
                            }
                            i6 += zzdni.m29727e(i8) + zzdni.m29735g(g2) + g2;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        int f3 = C9864zp.m24422f((List) unsafe.getObject(t2, j2));
                        if (f3 > 0) {
                            if (this.f22779k) {
                                unsafe.putInt(t2, (long) i3, f3);
                            }
                            i6 += zzdni.m29727e(i8) + zzdni.m29735g(f3) + f3;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        int h = C9864zp.m24428h((List) unsafe.getObject(t2, j2));
                        if (h > 0) {
                            if (this.f22779k) {
                                unsafe.putInt(t2, (long) i3, h);
                            }
                            i6 += zzdni.m29727e(i8) + zzdni.m29735g(h) + h;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        int d2 = C9864zp.m24414d((List) unsafe.getObject(t2, j2));
                        if (d2 > 0) {
                            if (this.f22779k) {
                                unsafe.putInt(t2, (long) i3, d2);
                            }
                            i6 += zzdni.m29727e(i8) + zzdni.m29735g(d2) + d2;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        int b = C9864zp.m24404b((List) unsafe.getObject(t2, j2));
                        if (b > 0) {
                            if (this.f22779k) {
                                unsafe.putInt(t2, (long) i3, b);
                            }
                            i6 += zzdni.m29727e(i8) + zzdni.m29735g(b) + b;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        int f4 = C9864zp.m24422f((List) unsafe.getObject(t2, j2));
                        if (f4 > 0) {
                            if (this.f22779k) {
                                unsafe.putInt(t2, (long) i3, f4);
                            }
                            i6 += zzdni.m29727e(i8) + zzdni.m29735g(f4) + f4;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        int g3 = C9864zp.m24425g((List) unsafe.getObject(t2, j2));
                        if (g3 > 0) {
                            if (this.f22779k) {
                                unsafe.putInt(t2, (long) i3, g3);
                            }
                            i6 += zzdni.m29727e(i8) + zzdni.m29735g(g3) + g3;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        int e = C9864zp.m24418e((List) unsafe.getObject(t2, j2));
                        if (e > 0) {
                            if (this.f22779k) {
                                unsafe.putInt(t2, (long) i3, e);
                            }
                            i6 += zzdni.m29727e(i8) + zzdni.m29735g(e) + e;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        int a = C9864zp.m24388a((List) unsafe.getObject(t2, j2));
                        if (a > 0) {
                            if (this.f22779k) {
                                unsafe.putInt(t2, (long) i3, a);
                            }
                            i6 += zzdni.m29727e(i8) + zzdni.m29735g(a) + a;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        i6 += C9864zp.m24402b(i8, m23896a((Object) t2, j2), m23892a(i5));
                        break;
                    case 50:
                        i6 += this.f22787s.mo28966a(i8, C9132Sp.m23009f(t2, j2), m23908b(i5));
                        break;
                    case 51:
                        if (!m23903a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29707b(i8, 0.0d);
                            break;
                        }
                    case 52:
                        if (!m23903a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29708b(i8, 0.0f);
                            break;
                        }
                    case 53:
                        if (!m23903a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29722d(i8, m23919e(t2, j2));
                            break;
                        }
                    case 54:
                        if (!m23903a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29729e(i8, m23919e(t2, j2));
                            break;
                        }
                    case 55:
                        if (!m23903a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29709b(i8, m23917d(t2, j2));
                            break;
                        }
                    case 56:
                        if (!m23903a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29737g(i8, 0);
                            break;
                        }
                    case 57:
                        if (!m23903a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29728e(i8, 0);
                            break;
                        }
                    case 58:
                        if (!m23903a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29713b(i8, true);
                            break;
                        }
                    case 59:
                        if (!m23903a(t2, i8, i5)) {
                            break;
                        } else {
                            Object f5 = C9132Sp.m23009f(t2, j2);
                            if (!(f5 instanceof zzdmr)) {
                                i6 += zzdni.m29712b(i8, (String) f5);
                                break;
                            } else {
                                i6 += zzdni.m29718c(i8, (zzdmr) f5);
                                break;
                            }
                        }
                    case 60:
                        if (!m23903a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += C9864zp.m24384a(i8, C9132Sp.m23009f(t2, j2), m23892a(i5));
                            break;
                        }
                    case 61:
                        if (!m23903a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29718c(i8, (zzdmr) C9132Sp.m23009f(t2, j2));
                            break;
                        }
                    case 62:
                        if (!m23903a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29717c(i8, m23917d(t2, j2));
                            break;
                        }
                    case 63:
                        if (!m23903a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29736g(i8, m23917d(t2, j2));
                            break;
                        }
                    case 64:
                        if (!m23903a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29732f(i8, 0);
                            break;
                        }
                    case 65:
                        if (!m23903a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29740h(i8, 0);
                            break;
                        }
                    case 66:
                        if (!m23903a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29721d(i8, m23917d(t2, j2));
                            break;
                        }
                    case 67:
                        if (!m23903a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29733f(i8, m23919e(t2, j2));
                            break;
                        }
                    case 68:
                        if (!m23903a(t2, i8, i5)) {
                            break;
                        } else {
                            i6 += zzdni.m29720c(i8, (zzdpk) C9132Sp.m23009f(t2, j2), m23892a(i5));
                            break;
                        }
                }
                i5 += 3;
                i4 = 267386880;
            }
            return i6 + m23887a(this.f22785q, t2);
        }
        Unsafe unsafe2 = f22770b;
        int i10 = 0;
        int i11 = 0;
        int i12 = -1;
        int i13 = 0;
        while (i10 < this.f22771c.length) {
            int d3 = m23916d(i10);
            int[] iArr = this.f22771c;
            int i14 = iArr[i10];
            int i15 = (d3 & 267386880) >>> 20;
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
            } else if (!this.f22779k || i15 < zzdnv.DOUBLE_LIST_PACKED.mo31600e() || i15 > zzdnv.SINT64_LIST_PACKED.mo31600e()) {
                i2 = 0;
                i = 0;
            } else {
                i2 = this.f22771c[i10 + 2] & 1048575;
                i = 0;
            }
            long j4 = (long) (d3 & 1048575);
            switch (i15) {
                case 0:
                    j = 0;
                    if ((i13 & i) == 0) {
                        break;
                    } else {
                        i11 += zzdni.m29707b(i14, 0.0d);
                        break;
                    }
                case 1:
                    j = 0;
                    if ((i13 & i) == 0) {
                        break;
                    } else {
                        i11 += zzdni.m29708b(i14, 0.0f);
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i13 & i) == 0) {
                        break;
                    } else {
                        i11 += zzdni.m29722d(i14, unsafe2.getLong(t2, j4));
                        break;
                    }
                case 3:
                    j = 0;
                    if ((i13 & i) == 0) {
                        break;
                    } else {
                        i11 += zzdni.m29729e(i14, unsafe2.getLong(t2, j4));
                        break;
                    }
                case 4:
                    j = 0;
                    if ((i13 & i) == 0) {
                        break;
                    } else {
                        i11 += zzdni.m29709b(i14, unsafe2.getInt(t2, j4));
                        break;
                    }
                case 5:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        i11 += zzdni.m29737g(i14, 0);
                        break;
                    }
                case 6:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29728e(i14, 0);
                        j = 0;
                        break;
                    }
                case 7:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29713b(i14, true);
                        j = 0;
                        break;
                    }
                case 8:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        Object object = unsafe2.getObject(t2, j4);
                        if (!(object instanceof zzdmr)) {
                            i11 += zzdni.m29712b(i14, (String) object);
                            j = 0;
                            break;
                        } else {
                            i11 += zzdni.m29718c(i14, (zzdmr) object);
                            j = 0;
                            break;
                        }
                    }
                case 9:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += C9864zp.m24384a(i14, unsafe2.getObject(t2, j4), m23892a(i10));
                        j = 0;
                        break;
                    }
                case 10:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29718c(i14, (zzdmr) unsafe2.getObject(t2, j4));
                        j = 0;
                        break;
                    }
                case 11:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29717c(i14, unsafe2.getInt(t2, j4));
                        j = 0;
                        break;
                    }
                case 12:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29736g(i14, unsafe2.getInt(t2, j4));
                        j = 0;
                        break;
                    }
                case 13:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29732f(i14, 0);
                        j = 0;
                        break;
                    }
                case 14:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29740h(i14, 0);
                        j = 0;
                        break;
                    }
                case 15:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29721d(i14, unsafe2.getInt(t2, j4));
                        j = 0;
                        break;
                    }
                case 16:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29733f(i14, unsafe2.getLong(t2, j4));
                        j = 0;
                        break;
                    }
                case 17:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29720c(i14, (zzdpk) unsafe2.getObject(t2, j4), m23892a(i10));
                        j = 0;
                        break;
                    }
                case 18:
                    i11 += C9864zp.m24430i(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 19:
                    i11 += C9864zp.m24427h(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 20:
                    i11 += C9864zp.m24387a(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 21:
                    i11 += C9864zp.m24403b(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 22:
                    i11 += C9864zp.m24417e(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 23:
                    i11 += C9864zp.m24430i(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 24:
                    i11 += C9864zp.m24427h(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 25:
                    i11 += C9864zp.m24433j(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 26:
                    i11 += C9864zp.m24385a(i14, (List) unsafe2.getObject(t2, j4));
                    j = 0;
                    break;
                case 27:
                    i11 += C9864zp.m24386a(i14, (List) unsafe2.getObject(t2, j4), m23892a(i10));
                    j = 0;
                    break;
                case 28:
                    i11 += C9864zp.m24401b(i14, (List) unsafe2.getObject(t2, j4));
                    j = 0;
                    break;
                case 29:
                    i11 += C9864zp.m24421f(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 30:
                    i11 += C9864zp.m24413d(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 31:
                    i11 += C9864zp.m24427h(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 32:
                    i11 += C9864zp.m24430i(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 33:
                    i11 += C9864zp.m24424g(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 34:
                    i11 += C9864zp.m24409c(i14, (List) unsafe2.getObject(t2, j4), false);
                    j = 0;
                    break;
                case 35:
                    int g4 = C9864zp.m24425g((List) unsafe2.getObject(t2, j4));
                    if (g4 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f22779k) {
                            unsafe2.putInt(t2, (long) i2, g4);
                        }
                        i11 += zzdni.m29727e(i14) + zzdni.m29735g(g4) + g4;
                        j = 0;
                        break;
                    }
                case 36:
                    int f6 = C9864zp.m24422f((List) unsafe2.getObject(t2, j4));
                    if (f6 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f22779k) {
                            unsafe2.putInt(t2, (long) i2, f6);
                        }
                        i11 += zzdni.m29727e(i14) + zzdni.m29735g(f6) + f6;
                        j = 0;
                        break;
                    }
                case 37:
                    int i17 = C9864zp.m24431i((List) unsafe2.getObject(t2, j4));
                    if (i17 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f22779k) {
                            unsafe2.putInt(t2, (long) i2, i17);
                        }
                        i11 += zzdni.m29727e(i14) + zzdni.m29735g(i17) + i17;
                        j = 0;
                        break;
                    }
                case 38:
                    int j5 = C9864zp.m24434j((List) unsafe2.getObject(t2, j4));
                    if (j5 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f22779k) {
                            unsafe2.putInt(t2, (long) i2, j5);
                        }
                        i11 += zzdni.m29727e(i14) + zzdni.m29735g(j5) + j5;
                        j = 0;
                        break;
                    }
                case 39:
                    int c2 = C9864zp.m24410c((List) unsafe2.getObject(t2, j4));
                    if (c2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f22779k) {
                            unsafe2.putInt(t2, (long) i2, c2);
                        }
                        i11 += zzdni.m29727e(i14) + zzdni.m29735g(c2) + c2;
                        j = 0;
                        break;
                    }
                case 40:
                    int g5 = C9864zp.m24425g((List) unsafe2.getObject(t2, j4));
                    if (g5 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f22779k) {
                            unsafe2.putInt(t2, (long) i2, g5);
                        }
                        i11 += zzdni.m29727e(i14) + zzdni.m29735g(g5) + g5;
                        j = 0;
                        break;
                    }
                case 41:
                    int f7 = C9864zp.m24422f((List) unsafe2.getObject(t2, j4));
                    if (f7 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f22779k) {
                            unsafe2.putInt(t2, (long) i2, f7);
                        }
                        i11 += zzdni.m29727e(i14) + zzdni.m29735g(f7) + f7;
                        j = 0;
                        break;
                    }
                case 42:
                    int h2 = C9864zp.m24428h((List) unsafe2.getObject(t2, j4));
                    if (h2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f22779k) {
                            unsafe2.putInt(t2, (long) i2, h2);
                        }
                        i11 += zzdni.m29727e(i14) + zzdni.m29735g(h2) + h2;
                        j = 0;
                        break;
                    }
                case 43:
                    int d4 = C9864zp.m24414d((List) unsafe2.getObject(t2, j4));
                    if (d4 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f22779k) {
                            unsafe2.putInt(t2, (long) i2, d4);
                        }
                        i11 += zzdni.m29727e(i14) + zzdni.m29735g(d4) + d4;
                        j = 0;
                        break;
                    }
                case 44:
                    int b2 = C9864zp.m24404b((List) unsafe2.getObject(t2, j4));
                    if (b2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f22779k) {
                            unsafe2.putInt(t2, (long) i2, b2);
                        }
                        i11 += zzdni.m29727e(i14) + zzdni.m29735g(b2) + b2;
                        j = 0;
                        break;
                    }
                case 45:
                    int f8 = C9864zp.m24422f((List) unsafe2.getObject(t2, j4));
                    if (f8 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f22779k) {
                            unsafe2.putInt(t2, (long) i2, f8);
                        }
                        i11 += zzdni.m29727e(i14) + zzdni.m29735g(f8) + f8;
                        j = 0;
                        break;
                    }
                case 46:
                    int g6 = C9864zp.m24425g((List) unsafe2.getObject(t2, j4));
                    if (g6 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f22779k) {
                            unsafe2.putInt(t2, (long) i2, g6);
                        }
                        i11 += zzdni.m29727e(i14) + zzdni.m29735g(g6) + g6;
                        j = 0;
                        break;
                    }
                case 47:
                    int e2 = C9864zp.m24418e((List) unsafe2.getObject(t2, j4));
                    if (e2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f22779k) {
                            unsafe2.putInt(t2, (long) i2, e2);
                        }
                        i11 += zzdni.m29727e(i14) + zzdni.m29735g(e2) + e2;
                        j = 0;
                        break;
                    }
                case 48:
                    int a2 = C9864zp.m24388a((List) unsafe2.getObject(t2, j4));
                    if (a2 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.f22779k) {
                            unsafe2.putInt(t2, (long) i2, a2);
                        }
                        i11 += zzdni.m29727e(i14) + zzdni.m29735g(a2) + a2;
                        j = 0;
                        break;
                    }
                case 49:
                    i11 += C9864zp.m24402b(i14, (List) unsafe2.getObject(t2, j4), m23892a(i10));
                    j = 0;
                    break;
                case 50:
                    i11 += this.f22787s.mo28966a(i14, unsafe2.getObject(t2, j4), m23908b(i10));
                    j = 0;
                    break;
                case 51:
                    if (!m23903a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29707b(i14, 0.0d);
                        j = 0;
                        break;
                    }
                case 52:
                    if (!m23903a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29708b(i14, 0.0f);
                        j = 0;
                        break;
                    }
                case 53:
                    if (!m23903a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29722d(i14, m23919e(t2, j4));
                        j = 0;
                        break;
                    }
                case 54:
                    if (!m23903a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29729e(i14, m23919e(t2, j4));
                        j = 0;
                        break;
                    }
                case 55:
                    if (!m23903a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29709b(i14, m23917d(t2, j4));
                        j = 0;
                        break;
                    }
                case 56:
                    if (!m23903a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29737g(i14, 0);
                        j = 0;
                        break;
                    }
                case 57:
                    if (!m23903a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29728e(i14, 0);
                        j = 0;
                        break;
                    }
                case 58:
                    if (!m23903a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29713b(i14, true);
                        j = 0;
                        break;
                    }
                case 59:
                    if (!m23903a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        Object object2 = unsafe2.getObject(t2, j4);
                        if (!(object2 instanceof zzdmr)) {
                            i11 += zzdni.m29712b(i14, (String) object2);
                            j = 0;
                            break;
                        } else {
                            i11 += zzdni.m29718c(i14, (zzdmr) object2);
                            j = 0;
                            break;
                        }
                    }
                case 60:
                    if (!m23903a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += C9864zp.m24384a(i14, unsafe2.getObject(t2, j4), m23892a(i10));
                        j = 0;
                        break;
                    }
                case 61:
                    if (!m23903a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29718c(i14, (zzdmr) unsafe2.getObject(t2, j4));
                        j = 0;
                        break;
                    }
                case 62:
                    if (!m23903a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29717c(i14, m23917d(t2, j4));
                        j = 0;
                        break;
                    }
                case 63:
                    if (!m23903a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29736g(i14, m23917d(t2, j4));
                        j = 0;
                        break;
                    }
                case 64:
                    if (!m23903a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29732f(i14, 0);
                        j = 0;
                        break;
                    }
                case 65:
                    if (!m23903a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29740h(i14, 0);
                        j = 0;
                        break;
                    }
                case 66:
                    if (!m23903a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29721d(i14, m23917d(t2, j4));
                        j = 0;
                        break;
                    }
                case 67:
                    if (!m23903a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29733f(i14, m23919e(t2, j4));
                        j = 0;
                        break;
                    }
                case 68:
                    if (!m23903a(t2, i14, i10)) {
                        j = 0;
                        break;
                    } else {
                        i11 += zzdni.m29720c(i14, (zzdpk) unsafe2.getObject(t2, j4), m23892a(i10));
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
        int a3 = i11 + m23887a(this.f22785q, t2);
        if (this.f22776h) {
            a3 += this.f22786r.mo28364b(t2).mo28433h();
        }
        return a3;
    }

    /* renamed from: a */
    private static <UT, UB> int m23887a(C9049Op<UT, UB> op, T t) {
        return op.mo28494c(op.mo28496d(t));
    }

    /* renamed from: a */
    private static <E> List<E> m23896a(Object obj, long j) {
        return (List) C9132Sp.m23009f(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0553 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0554  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0583  */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x0a9b  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x0aa1  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo29081a(T r13, com.google.android.gms.internal.ads.C9435fq r14) throws java.io.IOException {
        /*
            r12 = this;
            int r0 = r14.mo28201a()
            int r1 = com.google.android.gms.internal.ads.zzdob.zze.f28082m
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x055a
            com.google.android.gms.internal.ads.Op<?, ?> r0 = r12.f22785q
            m23898a(r0, (T) r13, r14)
            boolean r0 = r12.f22776h
            if (r0 == 0) goto L_0x0033
            com.google.android.gms.internal.ads.Io<?> r0 = r12.f22786r
            com.google.android.gms.internal.ads.Lo r0 = r0.mo28364b(r13)
            boolean r1 = r0.mo28426b()
            if (r1 != 0) goto L_0x0033
            java.util.Iterator r0 = r0.mo28424a()
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            goto L_0x0034
        L_0x0033:
            r0 = r3
        L_0x0034:
            int[] r1 = r12.f22771c
            int r1 = r1.length
            int r1 = r1 + -3
        L_0x0039:
            if (r1 < 0) goto L_0x0551
            int r7 = r12.m23916d(r1)
            int[] r8 = r12.f22771c
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
            boolean r8 = r12.m23903a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r7)
            com.google.android.gms.internal.ads.xp r8 = r12.m23892a(r1)
            r14.mo28208a(r9, r7, r8)
            goto L_0x0547
        L_0x0067:
            boolean r8 = r12.m23903a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = m23919e(r13, r7)
            r14.mo28226e(r9, r7)
            goto L_0x0547
        L_0x0079:
            boolean r8 = r12.m23903a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = m23917d(r13, r7)
            r14.mo28228f(r9, r7)
            goto L_0x0547
        L_0x008b:
            boolean r8 = r12.m23903a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = m23919e(r13, r7)
            r14.mo28231g(r9, r7)
            goto L_0x0547
        L_0x009d:
            boolean r8 = r12.m23903a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = m23917d(r13, r7)
            r14.mo28220c(r9, r7)
            goto L_0x0547
        L_0x00af:
            boolean r8 = r12.m23903a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = m23917d(r13, r7)
            r14.mo28225e(r9, r7)
            goto L_0x0547
        L_0x00c1:
            boolean r8 = r12.m23903a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = m23917d(r13, r7)
            r14.mo28222d(r9, r7)
            goto L_0x0547
        L_0x00d3:
            boolean r8 = r12.m23903a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r7)
            com.google.android.gms.internal.ads.zzdmr r7 = (com.google.android.gms.internal.ads.zzdmr) r7
            r14.mo28206a(r9, r7)
            goto L_0x0547
        L_0x00e7:
            boolean r8 = r12.m23903a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r7)
            com.google.android.gms.internal.ads.xp r8 = r12.m23892a(r1)
            r14.mo28216b(r9, r7, r8)
            goto L_0x0547
        L_0x00fd:
            boolean r8 = r12.m23903a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r7)
            m23897a(r9, r7, r14)
            goto L_0x0547
        L_0x010f:
            boolean r8 = r12.m23903a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            boolean r7 = m23922f(r13, r7)
            r14.mo28213a(r9, r7)
            goto L_0x0547
        L_0x0121:
            boolean r8 = r12.m23903a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = m23917d(r13, r7)
            r14.mo28205a(r9, r7)
            goto L_0x0547
        L_0x0133:
            boolean r8 = r12.m23903a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = m23919e(r13, r7)
            r14.mo28223d(r9, r7)
            goto L_0x0547
        L_0x0145:
            boolean r8 = r12.m23903a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = m23917d(r13, r7)
            r14.mo28215b(r9, r7)
            goto L_0x0547
        L_0x0157:
            boolean r8 = r12.m23903a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = m23919e(r13, r7)
            r14.mo28233h(r9, r7)
            goto L_0x0547
        L_0x0169:
            boolean r8 = r12.m23903a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = m23919e(r13, r7)
            r14.mo28229f(r9, r7)
            goto L_0x0547
        L_0x017b:
            boolean r8 = r12.m23903a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            float r7 = m23913c(r13, r7)
            r14.mo28204a(r9, r7)
            goto L_0x0547
        L_0x018d:
            boolean r8 = r12.m23903a((T) r13, r9, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            double r7 = m23906b((T) r13, r7)
            r14.mo28203a(r9, r7)
            goto L_0x0547
        L_0x019f:
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r7)
            r12.m23899a(r14, r9, r7, r1)
            goto L_0x0547
        L_0x01ab:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.xp r9 = r12.m23892a(r1)
            com.google.android.gms.internal.ads.C9864zp.m24407b(r8, r7, r14, r9)
            goto L_0x0547
        L_0x01c1:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24420e(r8, r7, r14, r4)
            goto L_0x0547
        L_0x01d3:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24435j(r8, r7, r14, r4)
            goto L_0x0547
        L_0x01e5:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24426g(r8, r7, r14, r4)
            goto L_0x0547
        L_0x01f7:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24437l(r8, r7, r14, r4)
            goto L_0x0547
        L_0x0209:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24438m(r8, r7, r14, r4)
            goto L_0x0547
        L_0x021b:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24432i(r8, r7, r14, r4)
            goto L_0x0547
        L_0x022d:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24439n(r8, r7, r14, r4)
            goto L_0x0547
        L_0x023f:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24436k(r8, r7, r14, r4)
            goto L_0x0547
        L_0x0251:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24423f(r8, r7, r14, r4)
            goto L_0x0547
        L_0x0263:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24429h(r8, r7, r14, r4)
            goto L_0x0547
        L_0x0275:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24416d(r8, r7, r14, r4)
            goto L_0x0547
        L_0x0287:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24412c(r8, r7, r14, r4)
            goto L_0x0547
        L_0x0299:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24408b(r8, r7, r14, r4)
            goto L_0x0547
        L_0x02ab:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24395a(r8, r7, r14, r4)
            goto L_0x0547
        L_0x02bd:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24420e(r8, r7, r14, r5)
            goto L_0x0547
        L_0x02cf:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24435j(r8, r7, r14, r5)
            goto L_0x0547
        L_0x02e1:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24426g(r8, r7, r14, r5)
            goto L_0x0547
        L_0x02f3:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24437l(r8, r7, r14, r5)
            goto L_0x0547
        L_0x0305:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24438m(r8, r7, r14, r5)
            goto L_0x0547
        L_0x0317:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24432i(r8, r7, r14, r5)
            goto L_0x0547
        L_0x0329:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24406b(r8, r7, r14)
            goto L_0x0547
        L_0x033b:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.xp r9 = r12.m23892a(r1)
            com.google.android.gms.internal.ads.C9864zp.m24394a(r8, r7, r14, r9)
            goto L_0x0547
        L_0x0351:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24393a(r8, r7, r14)
            goto L_0x0547
        L_0x0363:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24439n(r8, r7, r14, r5)
            goto L_0x0547
        L_0x0375:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24436k(r8, r7, r14, r5)
            goto L_0x0547
        L_0x0387:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24423f(r8, r7, r14, r5)
            goto L_0x0547
        L_0x0399:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24429h(r8, r7, r14, r5)
            goto L_0x0547
        L_0x03ab:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24416d(r8, r7, r14, r5)
            goto L_0x0547
        L_0x03bd:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24412c(r8, r7, r14, r5)
            goto L_0x0547
        L_0x03cf:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24408b(r8, r7, r14, r5)
            goto L_0x0547
        L_0x03e1:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.C9864zp.m24395a(r8, r7, r14, r5)
            goto L_0x0547
        L_0x03f3:
            boolean r8 = r12.m23902a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r7)
            com.google.android.gms.internal.ads.xp r8 = r12.m23892a(r1)
            r14.mo28208a(r9, r7, r8)
            goto L_0x0547
        L_0x0409:
            boolean r8 = r12.m23902a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.ads.C9132Sp.m22992b(r13, r7)
            r14.mo28226e(r9, r7)
            goto L_0x0547
        L_0x041c:
            boolean r8 = r12.m23902a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.ads.C9132Sp.m22976a(r13, r7)
            r14.mo28228f(r9, r7)
            goto L_0x0547
        L_0x042f:
            boolean r8 = r12.m23902a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.ads.C9132Sp.m22992b(r13, r7)
            r14.mo28231g(r9, r7)
            goto L_0x0547
        L_0x0442:
            boolean r8 = r12.m23902a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.ads.C9132Sp.m22976a(r13, r7)
            r14.mo28220c(r9, r7)
            goto L_0x0547
        L_0x0455:
            boolean r8 = r12.m23902a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.ads.C9132Sp.m22976a(r13, r7)
            r14.mo28225e(r9, r7)
            goto L_0x0547
        L_0x0468:
            boolean r8 = r12.m23902a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.ads.C9132Sp.m22976a(r13, r7)
            r14.mo28222d(r9, r7)
            goto L_0x0547
        L_0x047b:
            boolean r8 = r12.m23902a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r7)
            com.google.android.gms.internal.ads.zzdmr r7 = (com.google.android.gms.internal.ads.zzdmr) r7
            r14.mo28206a(r9, r7)
            goto L_0x0547
        L_0x048f:
            boolean r8 = r12.m23902a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r7)
            com.google.android.gms.internal.ads.xp r8 = r12.m23892a(r1)
            r14.mo28216b(r9, r7, r8)
            goto L_0x0547
        L_0x04a5:
            boolean r8 = r12.m23902a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r7)
            m23897a(r9, r7, r14)
            goto L_0x0547
        L_0x04b7:
            boolean r8 = r12.m23902a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            boolean r7 = com.google.android.gms.internal.ads.C9132Sp.m23000c(r13, r7)
            r14.mo28213a(r9, r7)
            goto L_0x0547
        L_0x04ca:
            boolean r8 = r12.m23902a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.ads.C9132Sp.m22976a(r13, r7)
            r14.mo28205a(r9, r7)
            goto L_0x0547
        L_0x04dc:
            boolean r8 = r12.m23902a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.ads.C9132Sp.m22992b(r13, r7)
            r14.mo28223d(r9, r7)
            goto L_0x0547
        L_0x04ee:
            boolean r8 = r12.m23902a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.ads.C9132Sp.m22976a(r13, r7)
            r14.mo28215b(r9, r7)
            goto L_0x0547
        L_0x0500:
            boolean r8 = r12.m23902a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.ads.C9132Sp.m22992b(r13, r7)
            r14.mo28233h(r9, r7)
            goto L_0x0547
        L_0x0512:
            boolean r8 = r12.m23902a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.ads.C9132Sp.m22992b(r13, r7)
            r14.mo28229f(r9, r7)
            goto L_0x0547
        L_0x0524:
            boolean r8 = r12.m23902a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            float r7 = com.google.android.gms.internal.ads.C9132Sp.m23001d(r13, r7)
            r14.mo28204a(r9, r7)
            goto L_0x0547
        L_0x0536:
            boolean r8 = r12.m23902a((T) r13, r1)
            if (r8 == 0) goto L_0x0547
            r7 = r7 & r6
            long r7 = (long) r7
            double r7 = com.google.android.gms.internal.ads.C9132Sp.m23006e(r13, r7)
            r14.mo28203a(r9, r7)
        L_0x0547:
            int r1 = r1 + -3
            goto L_0x0039
        L_0x054b:
            com.google.android.gms.internal.ads.Io<?> r13 = r12.f22786r
            r13.mo28356a(r0)
            throw r3
        L_0x0551:
            if (r0 != 0) goto L_0x0554
            return
        L_0x0554:
            com.google.android.gms.internal.ads.Io<?> r13 = r12.f22786r
            r13.mo28359a(r14, r0)
            throw r3
        L_0x055a:
            boolean r0 = r12.f22778j
            if (r0 == 0) goto L_0x0aa7
            boolean r0 = r12.f22776h
            if (r0 == 0) goto L_0x057c
            com.google.android.gms.internal.ads.Io<?> r0 = r12.f22786r
            com.google.android.gms.internal.ads.Lo r0 = r0.mo28364b(r13)
            boolean r1 = r0.mo28426b()
            if (r1 != 0) goto L_0x057c
            java.util.Iterator r0 = r0.mo28430e()
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            goto L_0x057d
        L_0x057c:
            r0 = r3
        L_0x057d:
            int[] r1 = r12.f22771c
            int r1 = r1.length
            r7 = 0
        L_0x0581:
            if (r7 >= r1) goto L_0x0a99
            int r8 = r12.m23916d(r7)
            int[] r9 = r12.f22771c
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
            boolean r9 = r12.m23903a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r8)
            com.google.android.gms.internal.ads.xp r9 = r12.m23892a(r7)
            r14.mo28208a(r10, r8, r9)
            goto L_0x0a8f
        L_0x05af:
            boolean r9 = r12.m23903a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = m23919e(r13, r8)
            r14.mo28226e(r10, r8)
            goto L_0x0a8f
        L_0x05c1:
            boolean r9 = r12.m23903a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = m23917d(r13, r8)
            r14.mo28228f(r10, r8)
            goto L_0x0a8f
        L_0x05d3:
            boolean r9 = r12.m23903a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = m23919e(r13, r8)
            r14.mo28231g(r10, r8)
            goto L_0x0a8f
        L_0x05e5:
            boolean r9 = r12.m23903a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = m23917d(r13, r8)
            r14.mo28220c(r10, r8)
            goto L_0x0a8f
        L_0x05f7:
            boolean r9 = r12.m23903a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = m23917d(r13, r8)
            r14.mo28225e(r10, r8)
            goto L_0x0a8f
        L_0x0609:
            boolean r9 = r12.m23903a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = m23917d(r13, r8)
            r14.mo28222d(r10, r8)
            goto L_0x0a8f
        L_0x061b:
            boolean r9 = r12.m23903a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r8)
            com.google.android.gms.internal.ads.zzdmr r8 = (com.google.android.gms.internal.ads.zzdmr) r8
            r14.mo28206a(r10, r8)
            goto L_0x0a8f
        L_0x062f:
            boolean r9 = r12.m23903a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r8)
            com.google.android.gms.internal.ads.xp r9 = r12.m23892a(r7)
            r14.mo28216b(r10, r8, r9)
            goto L_0x0a8f
        L_0x0645:
            boolean r9 = r12.m23903a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r8)
            m23897a(r10, r8, r14)
            goto L_0x0a8f
        L_0x0657:
            boolean r9 = r12.m23903a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            boolean r8 = m23922f(r13, r8)
            r14.mo28213a(r10, r8)
            goto L_0x0a8f
        L_0x0669:
            boolean r9 = r12.m23903a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = m23917d(r13, r8)
            r14.mo28205a(r10, r8)
            goto L_0x0a8f
        L_0x067b:
            boolean r9 = r12.m23903a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = m23919e(r13, r8)
            r14.mo28223d(r10, r8)
            goto L_0x0a8f
        L_0x068d:
            boolean r9 = r12.m23903a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = m23917d(r13, r8)
            r14.mo28215b(r10, r8)
            goto L_0x0a8f
        L_0x069f:
            boolean r9 = r12.m23903a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = m23919e(r13, r8)
            r14.mo28233h(r10, r8)
            goto L_0x0a8f
        L_0x06b1:
            boolean r9 = r12.m23903a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = m23919e(r13, r8)
            r14.mo28229f(r10, r8)
            goto L_0x0a8f
        L_0x06c3:
            boolean r9 = r12.m23903a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            float r8 = m23913c(r13, r8)
            r14.mo28204a(r10, r8)
            goto L_0x0a8f
        L_0x06d5:
            boolean r9 = r12.m23903a((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            double r8 = m23906b((T) r13, r8)
            r14.mo28203a(r10, r8)
            goto L_0x0a8f
        L_0x06e7:
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r8)
            r12.m23899a(r14, r10, r8, r7)
            goto L_0x0a8f
        L_0x06f3:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.xp r10 = r12.m23892a(r7)
            com.google.android.gms.internal.ads.C9864zp.m24407b(r9, r8, r14, r10)
            goto L_0x0a8f
        L_0x0709:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24420e(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x071b:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24435j(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x072d:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24426g(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x073f:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24437l(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x0751:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24438m(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x0763:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24432i(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x0775:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24439n(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x0787:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24436k(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x0799:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24423f(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x07ab:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24429h(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x07bd:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24416d(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x07cf:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24412c(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x07e1:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24408b(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x07f3:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24395a(r9, r8, r14, r4)
            goto L_0x0a8f
        L_0x0805:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24420e(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x0817:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24435j(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x0829:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24426g(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x083b:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24437l(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x084d:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24438m(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x085f:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24432i(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x0871:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24406b(r9, r8, r14)
            goto L_0x0a8f
        L_0x0883:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.xp r10 = r12.m23892a(r7)
            com.google.android.gms.internal.ads.C9864zp.m24394a(r9, r8, r14, r10)
            goto L_0x0a8f
        L_0x0899:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24393a(r9, r8, r14)
            goto L_0x0a8f
        L_0x08ab:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24439n(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x08bd:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24436k(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x08cf:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24423f(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x08e1:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24429h(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x08f3:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24416d(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x0905:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24412c(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x0917:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24408b(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x0929:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.C9864zp.m24395a(r9, r8, r14, r5)
            goto L_0x0a8f
        L_0x093b:
            boolean r9 = r12.m23902a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r8)
            com.google.android.gms.internal.ads.xp r9 = r12.m23892a(r7)
            r14.mo28208a(r10, r8, r9)
            goto L_0x0a8f
        L_0x0951:
            boolean r9 = r12.m23902a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.ads.C9132Sp.m22992b(r13, r8)
            r14.mo28226e(r10, r8)
            goto L_0x0a8f
        L_0x0964:
            boolean r9 = r12.m23902a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.ads.C9132Sp.m22976a(r13, r8)
            r14.mo28228f(r10, r8)
            goto L_0x0a8f
        L_0x0977:
            boolean r9 = r12.m23902a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.ads.C9132Sp.m22992b(r13, r8)
            r14.mo28231g(r10, r8)
            goto L_0x0a8f
        L_0x098a:
            boolean r9 = r12.m23902a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.ads.C9132Sp.m22976a(r13, r8)
            r14.mo28220c(r10, r8)
            goto L_0x0a8f
        L_0x099d:
            boolean r9 = r12.m23902a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.ads.C9132Sp.m22976a(r13, r8)
            r14.mo28225e(r10, r8)
            goto L_0x0a8f
        L_0x09b0:
            boolean r9 = r12.m23902a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.ads.C9132Sp.m22976a(r13, r8)
            r14.mo28222d(r10, r8)
            goto L_0x0a8f
        L_0x09c3:
            boolean r9 = r12.m23902a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r8)
            com.google.android.gms.internal.ads.zzdmr r8 = (com.google.android.gms.internal.ads.zzdmr) r8
            r14.mo28206a(r10, r8)
            goto L_0x0a8f
        L_0x09d7:
            boolean r9 = r12.m23902a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r8)
            com.google.android.gms.internal.ads.xp r9 = r12.m23892a(r7)
            r14.mo28216b(r10, r8, r9)
            goto L_0x0a8f
        L_0x09ed:
            boolean r9 = r12.m23902a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r13, r8)
            m23897a(r10, r8, r14)
            goto L_0x0a8f
        L_0x09ff:
            boolean r9 = r12.m23902a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            boolean r8 = com.google.android.gms.internal.ads.C9132Sp.m23000c(r13, r8)
            r14.mo28213a(r10, r8)
            goto L_0x0a8f
        L_0x0a12:
            boolean r9 = r12.m23902a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.ads.C9132Sp.m22976a(r13, r8)
            r14.mo28205a(r10, r8)
            goto L_0x0a8f
        L_0x0a24:
            boolean r9 = r12.m23902a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.ads.C9132Sp.m22992b(r13, r8)
            r14.mo28223d(r10, r8)
            goto L_0x0a8f
        L_0x0a36:
            boolean r9 = r12.m23902a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.ads.C9132Sp.m22976a(r13, r8)
            r14.mo28215b(r10, r8)
            goto L_0x0a8f
        L_0x0a48:
            boolean r9 = r12.m23902a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.ads.C9132Sp.m22992b(r13, r8)
            r14.mo28233h(r10, r8)
            goto L_0x0a8f
        L_0x0a5a:
            boolean r9 = r12.m23902a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.ads.C9132Sp.m22992b(r13, r8)
            r14.mo28229f(r10, r8)
            goto L_0x0a8f
        L_0x0a6c:
            boolean r9 = r12.m23902a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            float r8 = com.google.android.gms.internal.ads.C9132Sp.m23001d(r13, r8)
            r14.mo28204a(r10, r8)
            goto L_0x0a8f
        L_0x0a7e:
            boolean r9 = r12.m23902a((T) r13, r7)
            if (r9 == 0) goto L_0x0a8f
            r8 = r8 & r6
            long r8 = (long) r8
            double r8 = com.google.android.gms.internal.ads.C9132Sp.m23006e(r13, r8)
            r14.mo28203a(r10, r8)
        L_0x0a8f:
            int r7 = r7 + 3
            goto L_0x0581
        L_0x0a93:
            com.google.android.gms.internal.ads.Io<?> r13 = r12.f22786r
            r13.mo28356a(r0)
            throw r3
        L_0x0a99:
            if (r0 != 0) goto L_0x0aa1
            com.google.android.gms.internal.ads.Op<?, ?> r0 = r12.f22785q
            m23898a(r0, (T) r13, r14)
            return
        L_0x0aa1:
            com.google.android.gms.internal.ads.Io<?> r13 = r12.f22786r
            r13.mo28359a(r14, r0)
            throw r3
        L_0x0aa7:
            r12.m23911b((T) r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9588mp.mo29081a(java.lang.Object, com.google.android.gms.internal.ads.fq):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:166:0x04b9  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x04bf  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m23911b(T r18, com.google.android.gms.internal.ads.C9435fq r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.f22776h
            if (r3 == 0) goto L_0x0022
            com.google.android.gms.internal.ads.Io<?> r3 = r0.f22786r
            com.google.android.gms.internal.ads.Lo r3 = r3.mo28364b(r1)
            boolean r5 = r3.mo28426b()
            if (r5 != 0) goto L_0x0022
            java.util.Iterator r3 = r3.mo28430e()
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            goto L_0x0023
        L_0x0022:
            r3 = 0
        L_0x0023:
            r5 = -1
            int[] r6 = r0.f22771c
            int r6 = r6.length
            sun.misc.Unsafe r7 = f22770b
            r8 = 0
            r5 = 0
            r9 = -1
            r10 = 0
        L_0x002e:
            if (r5 >= r6) goto L_0x04b7
            int r11 = r0.m23916d(r5)
            int[] r12 = r0.f22771c
            r13 = r12[r5]
            r14 = 267386880(0xff00000, float:2.3665827E-29)
            r14 = r14 & r11
            int r14 = r14 >>> 20
            boolean r15 = r0.f22778j
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
            boolean r4 = r0.m23903a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.ads.xp r9 = r0.m23892a(r5)
            r2.mo28208a(r13, r4, r9)
            goto L_0x04ab
        L_0x0085:
            boolean r4 = r0.m23903a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            long r11 = m23919e(r1, r11)
            r2.mo28226e(r13, r11)
            goto L_0x04ab
        L_0x0094:
            boolean r4 = r0.m23903a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            int r4 = m23917d(r1, r11)
            r2.mo28228f(r13, r4)
            goto L_0x04ab
        L_0x00a3:
            boolean r4 = r0.m23903a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            long r11 = m23919e(r1, r11)
            r2.mo28231g(r13, r11)
            goto L_0x04ab
        L_0x00b2:
            boolean r4 = r0.m23903a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            int r4 = m23917d(r1, r11)
            r2.mo28220c(r13, r4)
            goto L_0x04ab
        L_0x00c1:
            boolean r4 = r0.m23903a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            int r4 = m23917d(r1, r11)
            r2.mo28225e(r13, r4)
            goto L_0x04ab
        L_0x00d0:
            boolean r4 = r0.m23903a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            int r4 = m23917d(r1, r11)
            r2.mo28222d(r13, r4)
            goto L_0x04ab
        L_0x00df:
            boolean r4 = r0.m23903a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.ads.zzdmr r4 = (com.google.android.gms.internal.ads.zzdmr) r4
            r2.mo28206a(r13, r4)
            goto L_0x04ab
        L_0x00f0:
            boolean r4 = r0.m23903a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.ads.xp r9 = r0.m23892a(r5)
            r2.mo28216b(r13, r4, r9)
            goto L_0x04ab
        L_0x0103:
            boolean r4 = r0.m23903a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r7.getObject(r1, r11)
            m23897a(r13, r4, r2)
            goto L_0x04ab
        L_0x0112:
            boolean r4 = r0.m23903a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            boolean r4 = m23922f(r1, r11)
            r2.mo28213a(r13, r4)
            goto L_0x04ab
        L_0x0121:
            boolean r4 = r0.m23903a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            int r4 = m23917d(r1, r11)
            r2.mo28205a(r13, r4)
            goto L_0x04ab
        L_0x0130:
            boolean r4 = r0.m23903a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            long r11 = m23919e(r1, r11)
            r2.mo28223d(r13, r11)
            goto L_0x04ab
        L_0x013f:
            boolean r4 = r0.m23903a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            int r4 = m23917d(r1, r11)
            r2.mo28215b(r13, r4)
            goto L_0x04ab
        L_0x014e:
            boolean r4 = r0.m23903a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            long r11 = m23919e(r1, r11)
            r2.mo28233h(r13, r11)
            goto L_0x04ab
        L_0x015d:
            boolean r4 = r0.m23903a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            long r11 = m23919e(r1, r11)
            r2.mo28229f(r13, r11)
            goto L_0x04ab
        L_0x016c:
            boolean r4 = r0.m23903a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            float r4 = m23913c(r1, r11)
            r2.mo28204a(r13, r4)
            goto L_0x04ab
        L_0x017b:
            boolean r4 = r0.m23903a((T) r1, r13, r5)
            if (r4 == 0) goto L_0x04ab
            double r11 = m23906b((T) r1, r11)
            r2.mo28203a(r13, r11)
            goto L_0x04ab
        L_0x018a:
            java.lang.Object r4 = r7.getObject(r1, r11)
            r0.m23899a(r2, r13, r4, r5)
            goto L_0x04ab
        L_0x0193:
            int[] r4 = r0.f22771c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.xp r11 = r0.m23892a(r5)
            com.google.android.gms.internal.ads.C9864zp.m24407b(r4, r9, r2, r11)
            goto L_0x04ab
        L_0x01a9:
            int[] r9 = r0.f22771c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.ads.C9864zp.m24420e(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x01ba:
            int[] r9 = r0.f22771c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.ads.C9864zp.m24435j(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x01cb:
            int[] r9 = r0.f22771c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.ads.C9864zp.m24426g(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x01dc:
            int[] r9 = r0.f22771c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.ads.C9864zp.m24437l(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x01ed:
            int[] r9 = r0.f22771c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.ads.C9864zp.m24438m(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x01fe:
            int[] r9 = r0.f22771c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.ads.C9864zp.m24432i(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x020f:
            int[] r9 = r0.f22771c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.ads.C9864zp.m24439n(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x0220:
            int[] r9 = r0.f22771c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.ads.C9864zp.m24436k(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x0231:
            int[] r9 = r0.f22771c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.ads.C9864zp.m24423f(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x0242:
            int[] r9 = r0.f22771c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.ads.C9864zp.m24429h(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x0253:
            int[] r9 = r0.f22771c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.ads.C9864zp.m24416d(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x0264:
            int[] r9 = r0.f22771c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.ads.C9864zp.m24412c(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x0275:
            int[] r9 = r0.f22771c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.ads.C9864zp.m24408b(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x0286:
            int[] r9 = r0.f22771c
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.ads.C9864zp.m24395a(r9, r11, r2, r4)
            goto L_0x04ab
        L_0x0297:
            int[] r4 = r0.f22771c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.C9864zp.m24420e(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x02a8:
            int[] r4 = r0.f22771c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.C9864zp.m24435j(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x02b9:
            int[] r4 = r0.f22771c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.C9864zp.m24426g(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x02ca:
            int[] r4 = r0.f22771c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.C9864zp.m24437l(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x02db:
            int[] r4 = r0.f22771c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.C9864zp.m24438m(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x02ec:
            int[] r4 = r0.f22771c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.C9864zp.m24432i(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x02fd:
            int[] r4 = r0.f22771c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.C9864zp.m24406b(r4, r9, r2)
            goto L_0x04ab
        L_0x030e:
            int[] r4 = r0.f22771c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.xp r11 = r0.m23892a(r5)
            com.google.android.gms.internal.ads.C9864zp.m24394a(r4, r9, r2, r11)
            goto L_0x04ab
        L_0x0324:
            int[] r4 = r0.f22771c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.C9864zp.m24393a(r4, r9, r2)
            goto L_0x04ab
        L_0x0335:
            int[] r4 = r0.f22771c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.C9864zp.m24439n(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x0346:
            int[] r4 = r0.f22771c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.C9864zp.m24436k(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x0357:
            int[] r4 = r0.f22771c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.C9864zp.m24423f(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x0368:
            int[] r4 = r0.f22771c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.C9864zp.m24429h(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x0379:
            int[] r4 = r0.f22771c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.C9864zp.m24416d(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x038a:
            int[] r4 = r0.f22771c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.C9864zp.m24412c(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x039b:
            int[] r4 = r0.f22771c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.C9864zp.m24408b(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x03ac:
            int[] r4 = r0.f22771c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.C9864zp.m24395a(r4, r9, r2, r8)
            goto L_0x04ab
        L_0x03bd:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.ads.xp r9 = r0.m23892a(r5)
            r2.mo28208a(r13, r4, r9)
            goto L_0x04ab
        L_0x03cf:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            long r11 = r7.getLong(r1, r11)
            r2.mo28226e(r13, r11)
            goto L_0x04ab
        L_0x03dc:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r7.getInt(r1, r11)
            r2.mo28228f(r13, r4)
            goto L_0x04ab
        L_0x03e9:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            long r11 = r7.getLong(r1, r11)
            r2.mo28231g(r13, r11)
            goto L_0x04ab
        L_0x03f6:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r7.getInt(r1, r11)
            r2.mo28220c(r13, r4)
            goto L_0x04ab
        L_0x0403:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r7.getInt(r1, r11)
            r2.mo28225e(r13, r4)
            goto L_0x04ab
        L_0x0410:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r7.getInt(r1, r11)
            r2.mo28222d(r13, r4)
            goto L_0x04ab
        L_0x041d:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.ads.zzdmr r4 = (com.google.android.gms.internal.ads.zzdmr) r4
            r2.mo28206a(r13, r4)
            goto L_0x04ab
        L_0x042c:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.ads.xp r9 = r0.m23892a(r5)
            r2.mo28216b(r13, r4, r9)
            goto L_0x04ab
        L_0x043d:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r7.getObject(r1, r11)
            m23897a(r13, r4, r2)
            goto L_0x04ab
        L_0x0449:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            boolean r4 = com.google.android.gms.internal.ads.C9132Sp.m23000c(r1, r11)
            r2.mo28213a(r13, r4)
            goto L_0x04ab
        L_0x0456:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r7.getInt(r1, r11)
            r2.mo28205a(r13, r4)
            goto L_0x04ab
        L_0x0462:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            long r11 = r7.getLong(r1, r11)
            r2.mo28223d(r13, r11)
            goto L_0x04ab
        L_0x046e:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r7.getInt(r1, r11)
            r2.mo28215b(r13, r4)
            goto L_0x04ab
        L_0x047a:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            long r11 = r7.getLong(r1, r11)
            r2.mo28233h(r13, r11)
            goto L_0x04ab
        L_0x0486:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            long r11 = r7.getLong(r1, r11)
            r2.mo28229f(r13, r11)
            goto L_0x04ab
        L_0x0492:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            float r4 = com.google.android.gms.internal.ads.C9132Sp.m23001d(r1, r11)
            r2.mo28204a(r13, r4)
            goto L_0x04ab
        L_0x049f:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x04ab
            double r11 = com.google.android.gms.internal.ads.C9132Sp.m23006e(r1, r11)
            r2.mo28203a(r13, r11)
        L_0x04ab:
            int r5 = r5 + 3
            r9 = r15
            goto L_0x002e
        L_0x04b0:
            com.google.android.gms.internal.ads.Io<?> r1 = r0.f22786r
            r1.mo28356a(r3)
            r1 = 0
            throw r1
        L_0x04b7:
            if (r3 != 0) goto L_0x04bf
            com.google.android.gms.internal.ads.Op<?, ?> r3 = r0.f22785q
            m23898a(r3, (T) r1, r2)
            return
        L_0x04bf:
            com.google.android.gms.internal.ads.Io<?> r1 = r0.f22786r
            r1.mo28359a(r2, r3)
            r1 = 0
            goto L_0x04c7
        L_0x04c6:
            throw r1
        L_0x04c7:
            goto L_0x04c6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9588mp.m23911b(java.lang.Object, com.google.android.gms.internal.ads.fq):void");
    }

    /* renamed from: a */
    private final <K, V> void m23899a(C9435fq fqVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            this.f22787s.mo28969c(m23908b(i2));
            throw null;
        }
    }

    /* renamed from: a */
    private static <UT, UB> void m23898a(C9049Op<UT, UB> op, T t, C9435fq fqVar) throws IOException {
        op.mo28486a(op.mo28496d(t), fqVar);
    }

    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo29082a(T r11, com.google.android.gms.internal.ads.C9801wp r12, com.google.android.gms.internal.ads.zzdno r13) throws java.io.IOException {
        /*
            r10 = this;
            if (r13 == 0) goto L_0x060f
            com.google.android.gms.internal.ads.Op<?, ?> r7 = r10.f22785q
            com.google.android.gms.internal.ads.Io<?> r0 = r10.f22786r
            r8 = 0
            r9 = r8
        L_0x0009:
            int r1 = r12.mo28157n()     // Catch:{ all -> 0x05f8 }
            int r2 = r10.m23923g(r1)     // Catch:{ all -> 0x05f8 }
            if (r2 >= 0) goto L_0x0070
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x002e
            int r12 = r10.f22781m
        L_0x001a:
            int r13 = r10.f22782n
            if (r12 >= r13) goto L_0x0028
            int[] r13 = r10.f22780l
            r13 = r13[r12]
            r10.m23894a(r11, r13, (UB) r9, r7)
            int r12 = r12 + 1
            goto L_0x001a
        L_0x0028:
            if (r9 == 0) goto L_0x002d
            r7.mo28493b(r11, r9)
        L_0x002d:
            return
        L_0x002e:
            boolean r2 = r10.f22776h     // Catch:{ all -> 0x05f8 }
            if (r2 != 0) goto L_0x0034
            r2 = r8
            goto L_0x003b
        L_0x0034:
            com.google.android.gms.internal.ads.zzdpk r2 = r10.f22775g     // Catch:{ all -> 0x05f8 }
            java.lang.Object r1 = r0.mo28358a(r13, r2, r1)     // Catch:{ all -> 0x05f8 }
            r2 = r1
        L_0x003b:
            if (r2 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.Lo r4 = r0.mo28365c(r11)     // Catch:{ all -> 0x05f8 }
            r1 = r12
            r3 = r13
            r5 = r9
            r6 = r7
            r0.mo28357a(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x05f8 }
            throw r8
        L_0x004b:
            r7.mo28488a(r12)     // Catch:{ all -> 0x05f8 }
            if (r9 != 0) goto L_0x0054
            java.lang.Object r9 = r7.mo28497e(r11)     // Catch:{ all -> 0x05f8 }
        L_0x0054:
            boolean r1 = r7.mo28489a(r9, r12)     // Catch:{ all -> 0x05f8 }
            if (r1 != 0) goto L_0x0009
            int r12 = r10.f22781m
        L_0x005c:
            int r13 = r10.f22782n
            if (r12 >= r13) goto L_0x006a
            int[] r13 = r10.f22780l
            r13 = r13[r12]
            r10.m23894a(r11, r13, (UB) r9, r7)
            int r12 = r12 + 1
            goto L_0x005c
        L_0x006a:
            if (r9 == 0) goto L_0x006f
            r7.mo28493b(r11, r9)
        L_0x006f:
            return
        L_0x0070:
            int r3 = r10.m23916d(r2)     // Catch:{ all -> 0x05f8 }
            r4 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r3
            int r4 = r4 >>> 20
            r5 = 1048575(0xfffff, float:1.469367E-39)
            switch(r4) {
                case 0: goto L_0x05a1;
                case 1: goto L_0x0591;
                case 2: goto L_0x0581;
                case 3: goto L_0x0571;
                case 4: goto L_0x0561;
                case 5: goto L_0x0551;
                case 6: goto L_0x0541;
                case 7: goto L_0x0531;
                case 8: goto L_0x0529;
                case 9: goto L_0x04f3;
                case 10: goto L_0x04e3;
                case 11: goto L_0x04d3;
                case 12: goto L_0x04af;
                case 13: goto L_0x049f;
                case 14: goto L_0x048f;
                case 15: goto L_0x047f;
                case 16: goto L_0x046f;
                case 17: goto L_0x0439;
                case 18: goto L_0x042b;
                case 19: goto L_0x041d;
                case 20: goto L_0x040f;
                case 21: goto L_0x0401;
                case 22: goto L_0x03f3;
                case 23: goto L_0x03e5;
                case 24: goto L_0x03d7;
                case 25: goto L_0x03c9;
                case 26: goto L_0x03a6;
                case 27: goto L_0x0390;
                case 28: goto L_0x0382;
                case 29: goto L_0x0374;
                case 30: goto L_0x035e;
                case 31: goto L_0x0350;
                case 32: goto L_0x0342;
                case 33: goto L_0x0334;
                case 34: goto L_0x0326;
                case 35: goto L_0x0318;
                case 36: goto L_0x030a;
                case 37: goto L_0x02fc;
                case 38: goto L_0x02ee;
                case 39: goto L_0x02e0;
                case 40: goto L_0x02d2;
                case 41: goto L_0x02c4;
                case 42: goto L_0x02b6;
                case 43: goto L_0x02a8;
                case 44: goto L_0x0292;
                case 45: goto L_0x0284;
                case 46: goto L_0x0276;
                case 47: goto L_0x0268;
                case 48: goto L_0x025a;
                case 49: goto L_0x0245;
                case 50: goto L_0x0207;
                case 51: goto L_0x01f4;
                case 52: goto L_0x01e1;
                case 53: goto L_0x01ce;
                case 54: goto L_0x01bb;
                case 55: goto L_0x01a8;
                case 56: goto L_0x0195;
                case 57: goto L_0x0182;
                case 58: goto L_0x016f;
                case 59: goto L_0x0167;
                case 60: goto L_0x0131;
                case 61: goto L_0x0122;
                case 62: goto L_0x010f;
                case 63: goto L_0x00e8;
                case 64: goto L_0x00d5;
                case 65: goto L_0x00c2;
                case 66: goto L_0x00af;
                case 67: goto L_0x009c;
                case 68: goto L_0x0088;
                default: goto L_0x0080;
            }
        L_0x0080:
            if (r9 != 0) goto L_0x05b1
            java.lang.Object r9 = r7.mo28480a()     // Catch:{ zzdol -> 0x05cf }
            goto L_0x05b1
        L_0x0088:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.xp r5 = r10.m23892a(r2)     // Catch:{ zzdol -> 0x05cf }
            java.lang.Object r5 = r12.mo28131b(r5, r13)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23910b((T) r11, r1, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x009c:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            long r5 = r12.mo28134c()     // Catch:{ zzdol -> 0x05cf }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23910b((T) r11, r1, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x00af:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            int r5 = r12.mo28126a()     // Catch:{ zzdol -> 0x05cf }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23910b((T) r11, r1, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x00c2:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            long r5 = r12.mo28151k()     // Catch:{ zzdol -> 0x05cf }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23910b((T) r11, r1, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x00d5:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            int r5 = r12.mo28149j()     // Catch:{ zzdol -> 0x05cf }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23910b((T) r11, r1, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x00e8:
            int r4 = r12.mo28147i()     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.zzdog r6 = r10.m23914c(r2)     // Catch:{ zzdol -> 0x05cf }
            if (r6 == 0) goto L_0x0100
            boolean r6 = r6.mo28423a(r4)     // Catch:{ zzdol -> 0x05cf }
            if (r6 == 0) goto L_0x00f9
            goto L_0x0100
        L_0x00f9:
            java.lang.Object r9 = com.google.android.gms.internal.ads.C9864zp.m24391a(r1, r4, r9, r7)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0100:
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r5, r3)     // Catch:{ zzdol -> 0x05cf }
            r10.m23910b((T) r11, r1, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x010f:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            int r5 = r12.mo28145h()     // Catch:{ zzdol -> 0x05cf }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23910b((T) r11, r1, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0122:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.zzdmr r5 = r12.mo28161p()     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23910b((T) r11, r1, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0131:
            boolean r4 = r10.m23903a((T) r11, r1, r2)     // Catch:{ zzdol -> 0x05cf }
            if (r4 == 0) goto L_0x0150
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            java.lang.Object r5 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r11, r3)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.xp r6 = r10.m23892a(r2)     // Catch:{ zzdol -> 0x05cf }
            java.lang.Object r6 = r12.mo28127a(r6, r13)     // Catch:{ zzdol -> 0x05cf }
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzdod.m29916a(r5, r6)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0162
        L_0x0150:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.xp r5 = r10.m23892a(r2)     // Catch:{ zzdol -> 0x05cf }
            java.lang.Object r5 = r12.mo28127a(r5, r13)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23909b((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
        L_0x0162:
            r10.m23910b((T) r11, r1, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0167:
            r10.m23900a(r11, r3, r12)     // Catch:{ zzdol -> 0x05cf }
            r10.m23910b((T) r11, r1, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x016f:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            boolean r5 = r12.mo28154l()     // Catch:{ zzdol -> 0x05cf }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23910b((T) r11, r1, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0182:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            int r5 = r12.mo28142g()     // Catch:{ zzdol -> 0x05cf }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23910b((T) r11, r1, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0195:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            long r5 = r12.mo28138e()     // Catch:{ zzdol -> 0x05cf }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23910b((T) r11, r1, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x01a8:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            int r5 = r12.mo28140f()     // Catch:{ zzdol -> 0x05cf }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23910b((T) r11, r1, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x01bb:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            long r5 = r12.mo28130b()     // Catch:{ zzdol -> 0x05cf }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23910b((T) r11, r1, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x01ce:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            long r5 = r12.mo28136d()     // Catch:{ zzdol -> 0x05cf }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23910b((T) r11, r1, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x01e1:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            float r5 = r12.readFloat()     // Catch:{ zzdol -> 0x05cf }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23910b((T) r11, r1, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x01f4:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            double r5 = r12.readDouble()     // Catch:{ zzdol -> 0x05cf }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23910b((T) r11, r1, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0207:
            java.lang.Object r1 = r10.m23908b(r2)     // Catch:{ zzdol -> 0x05cf }
            int r2 = r10.m23916d(r2)     // Catch:{ zzdol -> 0x05cf }
            r2 = r2 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.lang.Object r4 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            if (r4 == 0) goto L_0x0231
            com.google.android.gms.internal.ads.gp r5 = r10.f22787s     // Catch:{ zzdol -> 0x05cf }
            boolean r5 = r5.mo28972f(r4)     // Catch:{ zzdol -> 0x05cf }
            if (r5 == 0) goto L_0x023a
            com.google.android.gms.internal.ads.gp r5 = r10.f22787s     // Catch:{ zzdol -> 0x05cf }
            java.lang.Object r5 = r5.mo28968b(r1)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.gp r6 = r10.f22787s     // Catch:{ zzdol -> 0x05cf }
            r6.mo28967a(r5, r4)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r2, r5)     // Catch:{ zzdol -> 0x05cf }
            r4 = r5
            goto L_0x023a
        L_0x0231:
            com.google.android.gms.internal.ads.gp r4 = r10.f22787s     // Catch:{ zzdol -> 0x05cf }
            java.lang.Object r4 = r4.mo28968b(r1)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r2, r4)     // Catch:{ zzdol -> 0x05cf }
        L_0x023a:
            com.google.android.gms.internal.ads.gp r2 = r10.f22787s     // Catch:{ zzdol -> 0x05cf }
            r2.mo28973g(r4)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.gp r2 = r10.f22787s     // Catch:{ zzdol -> 0x05cf }
            r2.mo28969c(r1)     // Catch:{ zzdol -> 0x05cf }
            throw r8
        L_0x0245:
            r1 = r3 & r5
            long r3 = (long) r1
            com.google.android.gms.internal.ads.xp r1 = r10.m23892a(r2)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.Xo r2 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            java.util.List r2 = r2.mo28696a(r11, r3)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28133b(r2, r1, r13)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x025a:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28128a(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0268:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28132b(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0276:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28143g(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0284:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28146h(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0292:
            com.google.android.gms.internal.ads.Xo r4 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            java.util.List r3 = r4.mo28696a(r11, r5)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28139e(r3)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.zzdog r2 = r10.m23914c(r2)     // Catch:{ zzdol -> 0x05cf }
            java.lang.Object r9 = com.google.android.gms.internal.ads.C9864zp.m24392a(r1, r3, r2, r9, r7)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x02a8:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28141f(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x02b6:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28148i(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x02c4:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28150j(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x02d2:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28162p(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x02e0:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28163q(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x02ee:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28158n(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x02fc:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28156m(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x030a:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28135c(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0318:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28137d(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0326:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28128a(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0334:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28132b(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0342:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28143g(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0350:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28146h(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x035e:
            com.google.android.gms.internal.ads.Xo r4 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzdol -> 0x05cf }
            java.util.List r3 = r4.mo28696a(r11, r5)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28139e(r3)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.zzdog r2 = r10.m23914c(r2)     // Catch:{ zzdol -> 0x05cf }
            java.lang.Object r9 = com.google.android.gms.internal.ads.C9864zp.m24392a(r1, r3, r2, r9, r7)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0374:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28141f(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0382:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28152k(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0390:
            com.google.android.gms.internal.ads.xp r1 = r10.m23892a(r2)     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.Xo r4 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            java.util.List r2 = r4.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28129a(r2, r1, r13)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x03a6:
            boolean r1 = m23921f(r3)     // Catch:{ zzdol -> 0x05cf }
            if (r1 == 0) goto L_0x03bb
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28153l(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x03bb:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28159o(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x03c9:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28148i(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x03d7:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28150j(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x03e5:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28162p(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x03f3:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28163q(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0401:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28158n(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x040f:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28156m(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x041d:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28135c(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x042b:
            com.google.android.gms.internal.ads.Xo r1 = r10.f22784p     // Catch:{ zzdol -> 0x05cf }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzdol -> 0x05cf }
            java.util.List r1 = r1.mo28696a(r11, r2)     // Catch:{ zzdol -> 0x05cf }
            r12.mo28137d(r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0439:
            boolean r1 = r10.m23902a((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            if (r1 == 0) goto L_0x045a
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzdol -> 0x05cf }
            java.lang.Object r1 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r11, r3)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.xp r2 = r10.m23892a(r2)     // Catch:{ zzdol -> 0x05cf }
            java.lang.Object r2 = r12.mo28131b(r2, r13)     // Catch:{ zzdol -> 0x05cf }
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzdod.m29916a(r1, r2)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x045a:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.xp r1 = r10.m23892a(r2)     // Catch:{ zzdol -> 0x05cf }
            java.lang.Object r1 = r12.mo28131b(r1, r13)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r1)     // Catch:{ zzdol -> 0x05cf }
            r10.m23909b((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x046f:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzdol -> 0x05cf }
            long r5 = r12.mo28134c()     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22985a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23909b((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x047f:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzdol -> 0x05cf }
            int r1 = r12.mo28126a()     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22984a(r11, r3, r1)     // Catch:{ zzdol -> 0x05cf }
            r10.m23909b((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x048f:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzdol -> 0x05cf }
            long r5 = r12.mo28151k()     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22985a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23909b((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x049f:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzdol -> 0x05cf }
            int r1 = r12.mo28149j()     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22984a(r11, r3, r1)     // Catch:{ zzdol -> 0x05cf }
            r10.m23909b((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x04af:
            int r4 = r12.mo28147i()     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.zzdog r6 = r10.m23914c(r2)     // Catch:{ zzdol -> 0x05cf }
            if (r6 == 0) goto L_0x04c7
            boolean r6 = r6.mo28423a(r4)     // Catch:{ zzdol -> 0x05cf }
            if (r6 == 0) goto L_0x04c0
            goto L_0x04c7
        L_0x04c0:
            java.lang.Object r9 = com.google.android.gms.internal.ads.C9864zp.m24391a(r1, r4, r9, r7)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x04c7:
            r1 = r3 & r5
            long r5 = (long) r1     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22984a(r11, r5, r4)     // Catch:{ zzdol -> 0x05cf }
            r10.m23909b((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x04d3:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzdol -> 0x05cf }
            int r1 = r12.mo28145h()     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22984a(r11, r3, r1)     // Catch:{ zzdol -> 0x05cf }
            r10.m23909b((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x04e3:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.zzdmr r1 = r12.mo28161p()     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r1)     // Catch:{ zzdol -> 0x05cf }
            r10.m23909b((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x04f3:
            boolean r1 = r10.m23902a((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            if (r1 == 0) goto L_0x0514
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzdol -> 0x05cf }
            java.lang.Object r1 = com.google.android.gms.internal.ads.C9132Sp.m23009f(r11, r3)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.xp r2 = r10.m23892a(r2)     // Catch:{ zzdol -> 0x05cf }
            java.lang.Object r2 = r12.mo28127a(r2, r13)     // Catch:{ zzdol -> 0x05cf }
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzdod.m29916a(r1, r2)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r1)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0514:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.xp r1 = r10.m23892a(r2)     // Catch:{ zzdol -> 0x05cf }
            java.lang.Object r1 = r12.mo28127a(r1, r13)     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22986a(r11, r3, r1)     // Catch:{ zzdol -> 0x05cf }
            r10.m23909b((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0529:
            r10.m23900a(r11, r3, r12)     // Catch:{ zzdol -> 0x05cf }
            r10.m23909b((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0531:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzdol -> 0x05cf }
            boolean r1 = r12.mo28154l()     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22987a(r11, r3, r1)     // Catch:{ zzdol -> 0x05cf }
            r10.m23909b((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0541:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzdol -> 0x05cf }
            int r1 = r12.mo28142g()     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22984a(r11, r3, r1)     // Catch:{ zzdol -> 0x05cf }
            r10.m23909b((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0551:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzdol -> 0x05cf }
            long r5 = r12.mo28138e()     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22985a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23909b((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0561:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzdol -> 0x05cf }
            int r1 = r12.mo28140f()     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22984a(r11, r3, r1)     // Catch:{ zzdol -> 0x05cf }
            r10.m23909b((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0571:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzdol -> 0x05cf }
            long r5 = r12.mo28130b()     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22985a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23909b((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0581:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzdol -> 0x05cf }
            long r5 = r12.mo28136d()     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22985a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23909b((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x0591:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzdol -> 0x05cf }
            float r1 = r12.readFloat()     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22983a(r11, r3, r1)     // Catch:{ zzdol -> 0x05cf }
            r10.m23909b((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x05a1:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzdol -> 0x05cf }
            double r5 = r12.readDouble()     // Catch:{ zzdol -> 0x05cf }
            com.google.android.gms.internal.ads.C9132Sp.m22982a(r11, r3, r5)     // Catch:{ zzdol -> 0x05cf }
            r10.m23909b((T) r11, r2)     // Catch:{ zzdol -> 0x05cf }
            goto L_0x0009
        L_0x05b1:
            boolean r1 = r7.mo28489a(r9, r12)     // Catch:{ zzdol -> 0x05cf }
            if (r1 != 0) goto L_0x05cd
            int r12 = r10.f22781m
        L_0x05b9:
            int r13 = r10.f22782n
            if (r12 >= r13) goto L_0x05c7
            int[] r13 = r10.f22780l
            r13 = r13[r12]
            r10.m23894a(r11, r13, (UB) r9, r7)
            int r12 = r12 + 1
            goto L_0x05b9
        L_0x05c7:
            if (r9 == 0) goto L_0x05cc
            r7.mo28493b(r11, r9)
        L_0x05cc:
            return
        L_0x05cd:
            goto L_0x0009
        L_0x05cf:
            r1 = move-exception
            r7.mo28488a(r12)     // Catch:{ all -> 0x05f8 }
            if (r9 != 0) goto L_0x05da
            java.lang.Object r1 = r7.mo28497e(r11)     // Catch:{ all -> 0x05f8 }
            r9 = r1
        L_0x05da:
            boolean r1 = r7.mo28489a(r9, r12)     // Catch:{ all -> 0x05f8 }
            if (r1 != 0) goto L_0x05f6
            int r12 = r10.f22781m
        L_0x05e2:
            int r13 = r10.f22782n
            if (r12 >= r13) goto L_0x05f0
            int[] r13 = r10.f22780l
            r13 = r13[r12]
            r10.m23894a(r11, r13, (UB) r9, r7)
            int r12 = r12 + 1
            goto L_0x05e2
        L_0x05f0:
            if (r9 == 0) goto L_0x05f5
            r7.mo28493b(r11, r9)
        L_0x05f5:
            return
        L_0x05f6:
            goto L_0x0009
        L_0x05f8:
            r12 = move-exception
            int r13 = r10.f22781m
        L_0x05fb:
            int r0 = r10.f22782n
            if (r13 >= r0) goto L_0x0609
            int[] r0 = r10.f22780l
            r0 = r0[r13]
            r10.m23894a(r11, r0, (UB) r9, r7)
            int r13 = r13 + 1
            goto L_0x05fb
        L_0x0609:
            if (r9 == 0) goto L_0x060e
            r7.mo28493b(r11, r9)
        L_0x060e:
            throw r12
        L_0x060f:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException
            r11.<init>()
            goto L_0x0616
        L_0x0615:
            throw r11
        L_0x0616:
            goto L_0x0615
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9588mp.mo29082a(java.lang.Object, com.google.android.gms.internal.ads.wp, com.google.android.gms.internal.ads.zzdno):void");
    }

    /* renamed from: e */
    private static zzdqu m23920e(Object obj) {
        zzdob zzdob = (zzdob) obj;
        zzdqu zzdqu = zzdob.zzhhd;
        if (zzdqu != zzdqu.m29974c()) {
            return zzdqu;
        }
        zzdqu d = zzdqu.m29975d();
        zzdob.zzhhd = d;
        return d;
    }

    /* renamed from: a */
    private final int m23889a(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, C9631oo ooVar) throws IOException {
        int i8;
        int i9;
        int i10;
        int i11;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i12 = i;
        int i13 = i2;
        int i14 = i3;
        int i15 = i5;
        int i16 = i6;
        long j3 = j2;
        C9631oo ooVar2 = ooVar;
        zzdoj zzdoj = (zzdoj) f22770b.getObject(t2, j3);
        if (!zzdoj.mo29067t()) {
            int size = zzdoj.size();
            zzdoj = zzdoj.mo28270b(size == 0 ? 10 : size << 1);
            f22770b.putObject(t2, j3, zzdoj);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i15 == 2) {
                    C8880Go go = (C8880Go) zzdoj;
                    int a = C9609no.m23962a(bArr2, i12, ooVar2);
                    int i17 = ooVar2.f22846a + a;
                    while (a < i17) {
                        go.mo28267a(C9609no.m23966c(bArr2, a));
                        a += 8;
                    }
                    if (a == i17) {
                        return a;
                    }
                    throw zzdok.m29928a();
                } else if (i15 == 1) {
                    C8880Go go2 = (C8880Go) zzdoj;
                    go2.mo28267a(C9609no.m23966c(bArr, i));
                    int i18 = i12 + 8;
                    while (i18 < i13) {
                        int a2 = C9609no.m23962a(bArr2, i18, ooVar2);
                        if (i14 != ooVar2.f22846a) {
                            return i18;
                        }
                        go2.mo28267a(C9609no.m23966c(bArr2, a2));
                        i18 = a2 + 8;
                    }
                    return i18;
                }
                break;
            case 19:
            case 36:
                if (i15 == 2) {
                    C9069Po po = (C9069Po) zzdoj;
                    int a3 = C9609no.m23962a(bArr2, i12, ooVar2);
                    int i19 = ooVar2.f22846a + a3;
                    while (a3 < i19) {
                        po.mo28520a(C9609no.m23968d(bArr2, a3));
                        a3 += 4;
                    }
                    if (a3 == i19) {
                        return a3;
                    }
                    throw zzdok.m29928a();
                } else if (i15 == 5) {
                    C9069Po po2 = (C9069Po) zzdoj;
                    po2.mo28520a(C9609no.m23968d(bArr, i));
                    int i20 = i12 + 4;
                    while (i20 < i13) {
                        int a4 = C9609no.m23962a(bArr2, i20, ooVar2);
                        if (i14 != ooVar2.f22846a) {
                            return i20;
                        }
                        po2.mo28520a(C9609no.m23968d(bArr2, a4));
                        i20 = a4 + 4;
                    }
                    return i20;
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i15 == 2) {
                    C9324ap apVar = (C9324ap) zzdoj;
                    int a5 = C9609no.m23962a(bArr2, i12, ooVar2);
                    int i21 = ooVar2.f22846a + a5;
                    while (a5 < i21) {
                        a5 = C9609no.m23964b(bArr2, a5, ooVar2);
                        apVar.mo28856a(ooVar2.f22847b);
                    }
                    if (a5 == i21) {
                        return a5;
                    }
                    throw zzdok.m29928a();
                } else if (i15 == 0) {
                    C9324ap apVar2 = (C9324ap) zzdoj;
                    int b = C9609no.m23964b(bArr2, i12, ooVar2);
                    apVar2.mo28856a(ooVar2.f22847b);
                    while (b < i13) {
                        int a6 = C9609no.m23962a(bArr2, b, ooVar2);
                        if (i14 != ooVar2.f22846a) {
                            return b;
                        }
                        b = C9609no.m23964b(bArr2, a6, ooVar2);
                        apVar2.mo28856a(ooVar2.f22847b);
                    }
                    return b;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i15 == 2) {
                    return C9609no.m23963a(bArr2, i12, zzdoj, ooVar2);
                }
                if (i15 == 0) {
                    return C9609no.m23955a(i3, bArr, i, i2, zzdoj, ooVar);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i15 == 2) {
                    C9324ap apVar3 = (C9324ap) zzdoj;
                    int a7 = C9609no.m23962a(bArr2, i12, ooVar2);
                    int i22 = ooVar2.f22846a + a7;
                    while (a7 < i22) {
                        apVar3.mo28856a(C9609no.m23965b(bArr2, a7));
                        a7 += 8;
                    }
                    if (a7 == i22) {
                        return a7;
                    }
                    throw zzdok.m29928a();
                } else if (i15 == 1) {
                    C9324ap apVar4 = (C9324ap) zzdoj;
                    apVar4.mo28856a(C9609no.m23965b(bArr, i));
                    int i23 = i12 + 8;
                    while (i23 < i13) {
                        int a8 = C9609no.m23962a(bArr2, i23, ooVar2);
                        if (i14 != ooVar2.f22846a) {
                            return i23;
                        }
                        apVar4.mo28856a(C9609no.m23965b(bArr2, a8));
                        i23 = a8 + 8;
                    }
                    return i23;
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i15 == 2) {
                    C9156To to = (C9156To) zzdoj;
                    int a9 = C9609no.m23962a(bArr2, i12, ooVar2);
                    int i24 = ooVar2.f22846a + a9;
                    while (a9 < i24) {
                        to.mo28619d(C9609no.m23961a(bArr2, a9));
                        a9 += 4;
                    }
                    if (a9 == i24) {
                        return a9;
                    }
                    throw zzdok.m29928a();
                } else if (i15 == 5) {
                    C9156To to2 = (C9156To) zzdoj;
                    to2.mo28619d(C9609no.m23961a(bArr, i));
                    int i25 = i12 + 4;
                    while (i25 < i13) {
                        int a10 = C9609no.m23962a(bArr2, i25, ooVar2);
                        if (i14 != ooVar2.f22846a) {
                            return i25;
                        }
                        to2.mo28619d(C9609no.m23961a(bArr2, a10));
                        i25 = a10 + 4;
                    }
                    return i25;
                }
                break;
            case 25:
            case 42:
                if (i15 == 2) {
                    C9653po poVar = (C9653po) zzdoj;
                    int a11 = C9609no.m23962a(bArr2, i12, ooVar2);
                    int i26 = ooVar2.f22846a + a11;
                    while (a11 < i26) {
                        a11 = C9609no.m23964b(bArr2, a11, ooVar2);
                        poVar.mo29122a(ooVar2.f22847b != 0);
                    }
                    if (a11 == i26) {
                        return a11;
                    }
                    throw zzdok.m29928a();
                } else if (i15 == 0) {
                    C9653po poVar2 = (C9653po) zzdoj;
                    int b2 = C9609no.m23964b(bArr2, i12, ooVar2);
                    poVar2.mo29122a(ooVar2.f22847b != 0);
                    while (b2 < i13) {
                        int a12 = C9609no.m23962a(bArr2, b2, ooVar2);
                        if (i14 != ooVar2.f22846a) {
                            return b2;
                        }
                        b2 = C9609no.m23964b(bArr2, a12, ooVar2);
                        poVar2.mo29122a(ooVar2.f22847b != 0);
                    }
                    return b2;
                }
                break;
            case 26:
                if (i15 == 2) {
                    String str = "";
                    if ((j & 536870912) == 0) {
                        int a13 = C9609no.m23962a(bArr2, i12, ooVar2);
                        int i27 = ooVar2.f22846a;
                        if (i27 >= 0) {
                            if (i27 == 0) {
                                zzdoj.add(str);
                            } else {
                                zzdoj.add(new String(bArr2, a13, i27, zzdod.f28084a));
                                a13 += i27;
                            }
                            while (i9 < i13) {
                                int a14 = C9609no.m23962a(bArr2, i9, ooVar2);
                                if (i14 != ooVar2.f22846a) {
                                    return i9;
                                }
                                i9 = C9609no.m23962a(bArr2, a14, ooVar2);
                                int i28 = ooVar2.f22846a;
                                if (i28 < 0) {
                                    throw zzdok.m29929b();
                                } else if (i28 == 0) {
                                    zzdoj.add(str);
                                } else {
                                    zzdoj.add(new String(bArr2, i9, i28, zzdod.f28084a));
                                    i9 += i28;
                                }
                            }
                            return i9;
                        }
                        throw zzdok.m29929b();
                    }
                    int a15 = C9609no.m23962a(bArr2, i12, ooVar2);
                    int i29 = ooVar2.f22846a;
                    if (i29 >= 0) {
                        if (i29 == 0) {
                            zzdoj.add(str);
                        } else {
                            int i30 = a15 + i29;
                            if (C9199Vp.m23151a(bArr2, a15, i30)) {
                                zzdoj.add(new String(bArr2, a15, i29, zzdod.f28084a));
                                a15 = i30;
                            } else {
                                throw zzdok.m29935h();
                            }
                        }
                        while (i8 < i13) {
                            int a16 = C9609no.m23962a(bArr2, i8, ooVar2);
                            if (i14 != ooVar2.f22846a) {
                                return i8;
                            }
                            i8 = C9609no.m23962a(bArr2, a16, ooVar2);
                            int i31 = ooVar2.f22846a;
                            if (i31 < 0) {
                                throw zzdok.m29929b();
                            } else if (i31 == 0) {
                                zzdoj.add(str);
                            } else {
                                int i32 = i8 + i31;
                                if (C9199Vp.m23151a(bArr2, i8, i32)) {
                                    zzdoj.add(new String(bArr2, i8, i31, zzdod.f28084a));
                                    i8 = i32;
                                } else {
                                    throw zzdok.m29935h();
                                }
                            }
                        }
                        return i8;
                    }
                    throw zzdok.m29929b();
                }
                break;
            case 27:
                if (i15 == 2) {
                    return C9609no.m23958a(m23892a(i16), i3, bArr, i, i2, zzdoj, ooVar);
                }
                break;
            case 28:
                if (i15 == 2) {
                    int a17 = C9609no.m23962a(bArr2, i12, ooVar2);
                    int i33 = ooVar2.f22846a;
                    if (i33 < 0) {
                        throw zzdok.m29929b();
                    } else if (i33 <= bArr2.length - a17) {
                        if (i33 == 0) {
                            zzdoj.add(zzdmr.f27972a);
                        } else {
                            zzdoj.add(zzdmr.m29653a(bArr2, a17, i33));
                            a17 += i33;
                        }
                        while (i10 < i13) {
                            int a18 = C9609no.m23962a(bArr2, i10, ooVar2);
                            if (i14 != ooVar2.f22846a) {
                                return i10;
                            }
                            i10 = C9609no.m23962a(bArr2, a18, ooVar2);
                            int i34 = ooVar2.f22846a;
                            if (i34 < 0) {
                                throw zzdok.m29929b();
                            } else if (i34 > bArr2.length - i10) {
                                throw zzdok.m29928a();
                            } else if (i34 == 0) {
                                zzdoj.add(zzdmr.f27972a);
                            } else {
                                zzdoj.add(zzdmr.m29653a(bArr2, i10, i34));
                                i10 += i34;
                            }
                        }
                        return i10;
                    } else {
                        throw zzdok.m29928a();
                    }
                }
                break;
            case 30:
            case 44:
                if (i15 == 2) {
                    i11 = C9609no.m23963a(bArr2, i12, zzdoj, ooVar2);
                } else if (i15 == 0) {
                    i11 = C9609no.m23955a(i3, bArr, i, i2, zzdoj, ooVar);
                }
                zzdob zzdob = (zzdob) t2;
                zzdqu zzdqu = zzdob.zzhhd;
                if (zzdqu == zzdqu.m29974c()) {
                    zzdqu = null;
                }
                zzdqu zzdqu2 = (zzdqu) C9864zp.m24392a(i4, zzdoj, m23914c(i16), zzdqu, this.f22785q);
                if (zzdqu2 != null) {
                    zzdob.zzhhd = zzdqu2;
                }
                return i11;
            case 33:
            case 47:
                if (i15 == 2) {
                    C9156To to3 = (C9156To) zzdoj;
                    int a19 = C9609no.m23962a(bArr2, i12, ooVar2);
                    int i35 = ooVar2.f22846a + a19;
                    while (a19 < i35) {
                        a19 = C9609no.m23962a(bArr2, a19, ooVar2);
                        to3.mo28619d(zzdnd.m29672e(ooVar2.f22846a));
                    }
                    if (a19 == i35) {
                        return a19;
                    }
                    throw zzdok.m29928a();
                } else if (i15 == 0) {
                    C9156To to4 = (C9156To) zzdoj;
                    int a20 = C9609no.m23962a(bArr2, i12, ooVar2);
                    to4.mo28619d(zzdnd.m29672e(ooVar2.f22846a));
                    while (a20 < i13) {
                        int a21 = C9609no.m23962a(bArr2, a20, ooVar2);
                        if (i14 != ooVar2.f22846a) {
                            return a20;
                        }
                        a20 = C9609no.m23962a(bArr2, a21, ooVar2);
                        to4.mo28619d(zzdnd.m29672e(ooVar2.f22846a));
                    }
                    return a20;
                }
                break;
            case 34:
            case 48:
                if (i15 == 2) {
                    C9324ap apVar5 = (C9324ap) zzdoj;
                    int a22 = C9609no.m23962a(bArr2, i12, ooVar2);
                    int i36 = ooVar2.f22846a + a22;
                    while (a22 < i36) {
                        a22 = C9609no.m23964b(bArr2, a22, ooVar2);
                        apVar5.mo28856a(zzdnd.m29670a(ooVar2.f22847b));
                    }
                    if (a22 == i36) {
                        return a22;
                    }
                    throw zzdok.m29928a();
                } else if (i15 == 0) {
                    C9324ap apVar6 = (C9324ap) zzdoj;
                    int b3 = C9609no.m23964b(bArr2, i12, ooVar2);
                    apVar6.mo28856a(zzdnd.m29670a(ooVar2.f22847b));
                    while (b3 < i13) {
                        int a23 = C9609no.m23962a(bArr2, b3, ooVar2);
                        if (i14 != ooVar2.f22846a) {
                            return b3;
                        }
                        b3 = C9609no.m23964b(bArr2, a23, ooVar2);
                        apVar6.mo28856a(zzdnd.m29670a(ooVar2.f22847b));
                    }
                    return b3;
                }
                break;
            case 49:
                if (i15 == 3) {
                    C9822xp a24 = m23892a(i16);
                    int i37 = (i14 & -8) | 4;
                    int a25 = C9609no.m23959a(a24, bArr, i, i2, i37, ooVar);
                    zzdoj.add(ooVar2.f22848c);
                    while (a25 < i13) {
                        int a26 = C9609no.m23962a(bArr2, a25, ooVar2);
                        if (i14 != ooVar2.f22846a) {
                            return a25;
                        }
                        a25 = C9609no.m23959a(a24, bArr, a26, i2, i37, ooVar);
                        zzdoj.add(ooVar2.f22848c);
                    }
                    return a25;
                }
                break;
        }
        return i12;
    }

    /* renamed from: a */
    private final <K, V> int m23890a(T t, byte[] bArr, int i, int i2, int i3, long j, C9631oo ooVar) throws IOException {
        Unsafe unsafe = f22770b;
        Object b = m23908b(i3);
        Object object = unsafe.getObject(t, j);
        if (this.f22787s.mo28972f(object)) {
            Object b2 = this.f22787s.mo28968b(b);
            this.f22787s.mo28967a(b2, object);
            unsafe.putObject(t, j, b2);
        }
        this.f22787s.mo28969c(b);
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01a4, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return r2;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int m23888a(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.ads.C9631oo r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = f22770b
            int[] r7 = r0.f22771c
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x0193;
                case 52: goto L_0x0183;
                case 53: goto L_0x0173;
                case 54: goto L_0x0173;
                case 55: goto L_0x0163;
                case 56: goto L_0x0152;
                case 57: goto L_0x0142;
                case 58: goto L_0x0129;
                case 59: goto L_0x00f5;
                case 60: goto L_0x00c6;
                case 61: goto L_0x00b9;
                case 62: goto L_0x0163;
                case 63: goto L_0x008b;
                case 64: goto L_0x0142;
                case 65: goto L_0x0152;
                case 66: goto L_0x0076;
                case 67: goto L_0x0061;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x01a8
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x01a8
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.android.gms.internal.ads.xp r2 = r0.m23892a(r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = com.google.android.gms.internal.ads.C9609no.m23959a(r2, r3, r4, r5, r6, r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004c
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004d
        L_0x004c:
            r15 = 0
        L_0x004d:
            if (r15 != 0) goto L_0x0056
            java.lang.Object r3 = r11.f22848c
            r12.putObject(r1, r9, r3)
            goto L_0x01a4
        L_0x0056:
            java.lang.Object r3 = r11.f22848c
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzdod.m29916a(r15, r3)
            r12.putObject(r1, r9, r3)
            goto L_0x01a4
        L_0x0061:
            if (r5 != 0) goto L_0x01a8
            int r2 = com.google.android.gms.internal.ads.C9609no.m23964b(r3, r4, r11)
            long r3 = r11.f22847b
            long r3 = com.google.android.gms.internal.ads.zzdnd.m29670a(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x01a4
        L_0x0076:
            if (r5 != 0) goto L_0x01a8
            int r2 = com.google.android.gms.internal.ads.C9609no.m23962a(r3, r4, r11)
            int r3 = r11.f22846a
            int r3 = com.google.android.gms.internal.ads.zzdnd.m29672e(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x01a4
        L_0x008b:
            if (r5 != 0) goto L_0x01a8
            int r3 = com.google.android.gms.internal.ads.C9609no.m23962a(r3, r4, r11)
            int r4 = r11.f22846a
            com.google.android.gms.internal.ads.zzdog r5 = r0.m23914c(r6)
            if (r5 == 0) goto L_0x00af
            boolean r5 = r5.mo28423a(r4)
            if (r5 == 0) goto L_0x00a0
            goto L_0x00af
        L_0x00a0:
            com.google.android.gms.internal.ads.zzdqu r1 = m23920e(r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.mo31648a(r2, r4)
            r2 = r3
            goto L_0x01a9
        L_0x00af:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x01a4
        L_0x00b9:
            if (r5 != r15) goto L_0x01a8
            int r2 = com.google.android.gms.internal.ads.C9609no.m23970e(r3, r4, r11)
            java.lang.Object r3 = r11.f22848c
            r12.putObject(r1, r9, r3)
            goto L_0x01a4
        L_0x00c6:
            if (r5 != r15) goto L_0x01a8
            com.google.android.gms.internal.ads.xp r2 = r0.m23892a(r6)
            r5 = r20
            int r2 = com.google.android.gms.internal.ads.C9609no.m23960a(r2, r3, r4, r5, r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00de
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00df
        L_0x00de:
            r15 = 0
        L_0x00df:
            if (r15 != 0) goto L_0x00e7
            java.lang.Object r3 = r11.f22848c
            r12.putObject(r1, r9, r3)
            goto L_0x00f0
        L_0x00e7:
            java.lang.Object r3 = r11.f22848c
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzdod.m29916a(r15, r3)
            r12.putObject(r1, r9, r3)
        L_0x00f0:
            r12.putInt(r1, r13, r8)
            goto L_0x01a9
        L_0x00f5:
            if (r5 != r15) goto L_0x01a8
            int r2 = com.google.android.gms.internal.ads.C9609no.m23962a(r3, r4, r11)
            int r4 = r11.f22846a
            if (r4 != 0) goto L_0x0105
            java.lang.String r3 = ""
            r12.putObject(r1, r9, r3)
            goto L_0x0124
        L_0x0105:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x0119
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.ads.C9199Vp.m23151a(r3, r2, r5)
            if (r5 == 0) goto L_0x0114
            goto L_0x0119
        L_0x0114:
            com.google.android.gms.internal.ads.zzdok r1 = com.google.android.gms.internal.ads.zzdok.m29935h()
            throw r1
        L_0x0119:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.ads.zzdod.f28084a
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
        L_0x0124:
            r12.putInt(r1, r13, r8)
            goto L_0x01a9
        L_0x0129:
            if (r5 != 0) goto L_0x01a8
            int r2 = com.google.android.gms.internal.ads.C9609no.m23964b(r3, r4, r11)
            long r3 = r11.f22847b
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0139
            r15 = 1
            goto L_0x013a
        L_0x0139:
            r15 = 0
        L_0x013a:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            r12.putObject(r1, r9, r3)
            goto L_0x01a4
        L_0x0142:
            if (r5 != r7) goto L_0x01a8
            int r2 = com.google.android.gms.internal.ads.C9609no.m23961a(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 4
            goto L_0x01a4
        L_0x0152:
            r2 = 1
            if (r5 != r2) goto L_0x01a8
            long r2 = com.google.android.gms.internal.ads.C9609no.m23965b(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 8
            goto L_0x01a4
        L_0x0163:
            if (r5 != 0) goto L_0x01a8
            int r2 = com.google.android.gms.internal.ads.C9609no.m23962a(r3, r4, r11)
            int r3 = r11.f22846a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x01a4
        L_0x0173:
            if (r5 != 0) goto L_0x01a8
            int r2 = com.google.android.gms.internal.ads.C9609no.m23964b(r3, r4, r11)
            long r3 = r11.f22847b
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x01a4
        L_0x0183:
            if (r5 != r7) goto L_0x01a8
            float r2 = com.google.android.gms.internal.ads.C9609no.m23968d(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 4
            goto L_0x01a4
        L_0x0193:
            r2 = 1
            if (r5 != r2) goto L_0x01a8
            double r2 = com.google.android.gms.internal.ads.C9609no.m23966c(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 8
        L_0x01a4:
            r12.putInt(r1, r13, r8)
            goto L_0x01a9
        L_0x01a8:
            r2 = r4
        L_0x01a9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9588mp.m23888a(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.ads.oo):int");
    }

    /* renamed from: a */
    private final C9822xp m23892a(int i) {
        int i2 = (i / 3) << 1;
        C9822xp xpVar = (C9822xp) this.f22772d[i2];
        if (xpVar != null) {
            return xpVar;
        }
        C9822xp a = C9717sp.m24069a().mo29169a((Class) this.f22772d[i2 + 1]);
        this.f22772d[i2] = a;
        return a;
    }

    /* renamed from: b */
    private final Object m23908b(int i) {
        return this.f22772d[(i / 3) << 1];
    }

    /* renamed from: c */
    private final zzdog m23914c(int i) {
        return (zzdog) this.f22772d[((i / 3) << 1) + 1];
    }

    /* JADX WARNING: type inference failed for: r32v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r12v0 */
    /* JADX WARNING: type inference failed for: r12v1, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r0v5, types: [int, byte] */
    /* JADX WARNING: type inference failed for: r5v0, types: [int] */
    /* JADX WARNING: type inference failed for: r12v2 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r26v0 */
    /* JADX WARNING: type inference failed for: r9v5 */
    /* JADX WARNING: type inference failed for: r0v9, types: [int] */
    /* JADX WARNING: type inference failed for: r1v12, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r12v4 */
    /* JADX WARNING: type inference failed for: r0v18, types: [int] */
    /* JADX WARNING: type inference failed for: r1v21, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r12v6 */
    /* JADX WARNING: type inference failed for: r20v1 */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r12v8 */
    /* JADX WARNING: type inference failed for: r26v1 */
    /* JADX WARNING: type inference failed for: r26v2 */
    /* JADX WARNING: type inference failed for: r2v12, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r5v7, types: [int] */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r12v11 */
    /* JADX WARNING: type inference failed for: r2v15, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r2v16, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r5v10, types: [int] */
    /* JADX WARNING: type inference failed for: r26v3 */
    /* JADX WARNING: type inference failed for: r12v13 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: type inference failed for: r26v4 */
    /* JADX WARNING: type inference failed for: r1v34, types: [int] */
    /* JADX WARNING: type inference failed for: r2v19, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: type inference failed for: r8v11 */
    /* JADX WARNING: type inference failed for: r26v5 */
    /* JADX WARNING: type inference failed for: r8v12 */
    /* JADX WARNING: type inference failed for: r12v14, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v20 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r12v15, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v21 */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: type inference failed for: r12v16, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v22 */
    /* JADX WARNING: type inference failed for: r8v15 */
    /* JADX WARNING: type inference failed for: r12v17, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v23 */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: type inference failed for: r12v18, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v24 */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: type inference failed for: r12v19, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v25 */
    /* JADX WARNING: type inference failed for: r8v18 */
    /* JADX WARNING: type inference failed for: r12v20, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v26 */
    /* JADX WARNING: type inference failed for: r8v19 */
    /* JADX WARNING: type inference failed for: r12v21, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v27 */
    /* JADX WARNING: type inference failed for: r8v20 */
    /* JADX WARNING: type inference failed for: r12v22, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v28 */
    /* JADX WARNING: type inference failed for: r8v21 */
    /* JADX WARNING: type inference failed for: r12v23, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v29 */
    /* JADX WARNING: type inference failed for: r8v22, types: [int] */
    /* JADX WARNING: type inference failed for: r12v24, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v30 */
    /* JADX WARNING: type inference failed for: r3v32 */
    /* JADX WARNING: type inference failed for: r8v23 */
    /* JADX WARNING: type inference failed for: r12v25, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v33 */
    /* JADX WARNING: type inference failed for: r8v24 */
    /* JADX WARNING: type inference failed for: r12v26 */
    /* JADX WARNING: type inference failed for: r12v27, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v34 */
    /* JADX WARNING: type inference failed for: r8v25 */
    /* JADX WARNING: type inference failed for: r12v28 */
    /* JADX WARNING: type inference failed for: r1v77, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r8v27 */
    /* JADX WARNING: type inference failed for: r12v29 */
    /* JADX WARNING: type inference failed for: r3v36 */
    /* JADX WARNING: type inference failed for: r12v30 */
    /* JADX WARNING: type inference failed for: r8v28 */
    /* JADX WARNING: type inference failed for: r26v6 */
    /* JADX WARNING: type inference failed for: r5v28 */
    /* JADX WARNING: type inference failed for: r3v37, types: [int] */
    /* JADX WARNING: type inference failed for: r5v29 */
    /* JADX WARNING: type inference failed for: r12v31 */
    /* JADX WARNING: type inference failed for: r3v38 */
    /* JADX WARNING: type inference failed for: r9v47 */
    /* JADX WARNING: type inference failed for: r26v7 */
    /* JADX WARNING: type inference failed for: r26v8 */
    /* JADX WARNING: type inference failed for: r26v9 */
    /* JADX WARNING: type inference failed for: r12v32 */
    /* JADX WARNING: type inference failed for: r12v33 */
    /* JADX WARNING: type inference failed for: r12v34 */
    /* JADX WARNING: type inference failed for: r12v35 */
    /* JADX WARNING: type inference failed for: r8v30 */
    /* JADX WARNING: type inference failed for: r12v36 */
    /* JADX WARNING: type inference failed for: r8v31 */
    /* JADX WARNING: type inference failed for: r12v37 */
    /* JADX WARNING: type inference failed for: r8v32 */
    /* JADX WARNING: type inference failed for: r12v38 */
    /* JADX WARNING: type inference failed for: r8v33 */
    /* JADX WARNING: type inference failed for: r12v39 */
    /* JADX WARNING: type inference failed for: r8v34 */
    /* JADX WARNING: type inference failed for: r12v40 */
    /* JADX WARNING: type inference failed for: r8v35 */
    /* JADX WARNING: type inference failed for: r12v41 */
    /* JADX WARNING: type inference failed for: r8v36 */
    /* JADX WARNING: type inference failed for: r12v42 */
    /* JADX WARNING: type inference failed for: r12v43 */
    /* JADX WARNING: type inference failed for: r8v37 */
    /* JADX WARNING: type inference failed for: r12v44 */
    /* JADX WARNING: type inference failed for: r8v38 */
    /* JADX WARNING: type inference failed for: r12v45 */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r0v5, types: [int, byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte[], code=null, for r32v0, types: [byte[]] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r12v2
      assigns: []
      uses: []
      mth insns count: 699
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 53 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int mo29079a(T r31, byte[] r32, int r33, int r34, int r35, com.google.android.gms.internal.ads.C9631oo r36) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r9 = r36
            sun.misc.Unsafe r10 = f22770b
            r16 = 0
            r0 = r33
            r1 = -1
            r2 = 0
            r3 = 0
            r6 = 0
            r7 = -1
        L_0x001b:
            r17 = 0
            if (r0 >= r13) goto L_0x0550
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002e
            int r0 = com.google.android.gms.internal.ads.C9609no.m23957a(r0, r12, r3, r9)
            int r3 = r9.f22846a
            r4 = r0
            r5 = r3
            goto L_0x0030
        L_0x002e:
            r5 = r0
            r4 = r3
        L_0x0030:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x003e
            int r2 = r2 / r8
            int r1 = r15.m23886a(r3, r2)
            r2 = r1
            goto L_0x0043
        L_0x003e:
            int r1 = r15.m23923g(r3)
            r2 = r1
        L_0x0043:
            r1 = -1
            if (r2 != r1) goto L_0x0052
            r25 = r3
            r2 = r4
            r26 = r5
            r27 = r10
            r19 = 0
            goto L_0x0496
        L_0x0052:
            int[] r1 = r15.f22771c
            int r19 = r2 + 1
            r8 = r1[r19]
            r19 = 267386880(0xff00000, float:2.3665827E-29)
            r19 = r8 & r19
            int r11 = r19 >>> 20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r5
            r5 = r8 & r19
            long r12 = (long) r5
            r5 = 17
            r21 = r8
            if (r11 > r5) goto L_0x0382
            int r5 = r2 + 2
            r1 = r1[r5]
            int r5 = r1 >>> 20
            r8 = 1
            int r23 = r8 << r5
            r1 = r1 & r19
            if (r1 == r7) goto L_0x008c
            r5 = -1
            if (r7 == r5) goto L_0x0084
            long r8 = (long) r7
            r10.putInt(r14, r8, r6)
        L_0x0084:
            long r6 = (long) r1
            int r6 = r10.getInt(r14, r6)
            r7 = r1
            goto L_0x008d
        L_0x008c:
            r5 = -1
        L_0x008d:
            r1 = 5
            switch(r11) {
                case 0: goto L_0x034d;
                case 1: goto L_0x0326;
                case 2: goto L_0x02fb;
                case 3: goto L_0x02fb;
                case 4: goto L_0x02d4;
                case 5: goto L_0x02a0;
                case 6: goto L_0x0278;
                case 7: goto L_0x0243;
                case 8: goto L_0x020f;
                case 9: goto L_0x01cc;
                case 10: goto L_0x01a4;
                case 11: goto L_0x02d4;
                case 12: goto L_0x015a;
                case 13: goto L_0x0278;
                case 14: goto L_0x02a0;
                case 15: goto L_0x012f;
                case 16: goto L_0x00f7;
                case 17: goto L_0x00a0;
                default: goto L_0x0091;
            }
        L_0x0091:
            r12 = r32
            r13 = r36
            r9 = r2
            r11 = r3
            r33 = r7
            r8 = r20
            r19 = -1
            r7 = r4
            goto L_0x0375
        L_0x00a0:
            r1 = 3
            if (r0 != r1) goto L_0x00e7
            int r0 = r3 << 3
            r8 = r0 | 4
            com.google.android.gms.internal.ads.xp r0 = r15.m23892a(r2)
            r1 = r32
            r9 = r2
            r2 = r4
            r11 = r3
            r3 = r34
            r4 = r8
            r8 = r20
            r19 = -1
            r5 = r36
            int r0 = com.google.android.gms.internal.ads.C9609no.m23959a(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r23
            if (r1 != 0) goto L_0x00ca
            r5 = r36
            java.lang.Object r1 = r5.f22848c
            r10.putObject(r14, r12, r1)
            goto L_0x00d9
        L_0x00ca:
            r5 = r36
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r5.f22848c
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzdod.m29916a(r1, r2)
            r10.putObject(r14, r12, r1)
        L_0x00d9:
            r6 = r6 | r23
            r12 = r32
            r13 = r34
            r3 = r8
            r2 = r9
            r1 = r11
            r11 = r35
            r9 = r5
            goto L_0x001b
        L_0x00e7:
            r5 = r36
            r9 = r2
            r11 = r3
            r8 = r20
            r19 = -1
            r12 = r32
            r13 = r5
            r33 = r7
            r7 = r4
            goto L_0x0375
        L_0x00f7:
            r5 = r36
            r9 = r2
            r11 = r3
            r8 = r20
            r19 = -1
            if (r0 != 0) goto L_0x0127
            r2 = r12
            r12 = r32
            int r13 = com.google.android.gms.internal.ads.C9609no.m23964b(r12, r4, r5)
            long r0 = r5.f22847b
            long r17 = com.google.android.gms.internal.ads.zzdnd.m29670a(r0)
            r0 = r10
            r1 = r31
            r33 = r13
            r13 = r5
            r4 = r17
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r0 = r33
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r13 = r34
            r11 = r35
            goto L_0x001b
        L_0x0127:
            r12 = r32
            r13 = r5
            r33 = r7
            r7 = r4
            goto L_0x0375
        L_0x012f:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r20
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != 0) goto L_0x0155
            int r0 = com.google.android.gms.internal.ads.C9609no.m23962a(r12, r4, r13)
            int r1 = r13.f22846a
            int r1 = com.google.android.gms.internal.ads.zzdnd.m29672e(r1)
            r10.putInt(r14, r2, r1)
            r6 = r6 | r23
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r13 = r34
            r11 = r35
            goto L_0x001b
        L_0x0155:
            r33 = r7
            r7 = r4
            goto L_0x0375
        L_0x015a:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r20
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != 0) goto L_0x019f
            int r0 = com.google.android.gms.internal.ads.C9609no.m23962a(r12, r4, r13)
            int r1 = r13.f22846a
            com.google.android.gms.internal.ads.zzdog r4 = r15.m23914c(r9)
            if (r4 == 0) goto L_0x0190
            boolean r4 = r4.mo28423a(r1)
            if (r4 == 0) goto L_0x017a
            goto L_0x0190
        L_0x017a:
            com.google.android.gms.internal.ads.zzdqu r2 = m23920e(r31)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.mo31648a(r8, r1)
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r13 = r34
            r11 = r35
            goto L_0x001b
        L_0x0190:
            r10.putInt(r14, r2, r1)
            r6 = r6 | r23
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r13 = r34
            r11 = r35
            goto L_0x001b
        L_0x019f:
            r33 = r7
            r7 = r4
            goto L_0x0375
        L_0x01a4:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r20
            r19 = -1
            r12 = r32
            r13 = r36
            r1 = 2
            if (r0 != r1) goto L_0x01c7
            int r0 = com.google.android.gms.internal.ads.C9609no.m23970e(r12, r4, r13)
            java.lang.Object r1 = r13.f22848c
            r10.putObject(r14, r2, r1)
            r6 = r6 | r23
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r13 = r34
            r11 = r35
            goto L_0x001b
        L_0x01c7:
            r33 = r7
            r7 = r4
            goto L_0x0375
        L_0x01cc:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r20
            r19 = -1
            r12 = r32
            r13 = r36
            r1 = 2
            if (r0 != r1) goto L_0x0208
            com.google.android.gms.internal.ads.xp r0 = r15.m23892a(r9)
            r5 = r34
            int r0 = com.google.android.gms.internal.ads.C9609no.m23960a(r0, r12, r4, r5, r13)
            r1 = r6 & r23
            if (r1 != 0) goto L_0x01ef
            java.lang.Object r1 = r13.f22848c
            r10.putObject(r14, r2, r1)
            goto L_0x01fd
        L_0x01ef:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r13.f22848c
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzdod.m29916a(r1, r4)
            r10.putObject(r14, r2, r1)
        L_0x01fd:
            r6 = r6 | r23
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r11 = r35
            r13 = r5
            goto L_0x001b
        L_0x0208:
            r5 = r34
            r33 = r7
            r7 = r4
            goto L_0x0375
        L_0x020f:
            r5 = r34
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r20
            r19 = -1
            r12 = r32
            r13 = r36
            r1 = 2
            if (r0 != r1) goto L_0x023e
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r21 & r0
            if (r0 != 0) goto L_0x022a
            int r0 = com.google.android.gms.internal.ads.C9609no.m23967c(r12, r4, r13)
            goto L_0x022e
        L_0x022a:
            int r0 = com.google.android.gms.internal.ads.C9609no.m23969d(r12, r4, r13)
        L_0x022e:
            java.lang.Object r1 = r13.f22848c
            r10.putObject(r14, r2, r1)
            r6 = r6 | r23
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r11 = r35
            r13 = r5
            goto L_0x001b
        L_0x023e:
            r33 = r7
            r7 = r4
            goto L_0x0375
        L_0x0243:
            r5 = r34
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r20
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != 0) goto L_0x0273
            int r0 = com.google.android.gms.internal.ads.C9609no.m23964b(r12, r4, r13)
            r33 = r0
            long r0 = r13.f22847b
            r20 = 0
            int r4 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r4 == 0) goto L_0x0262
            r0 = 1
            goto L_0x0263
        L_0x0262:
            r0 = 0
        L_0x0263:
            com.google.android.gms.internal.ads.C9132Sp.m22987a(r14, r2, r0)
            r6 = r6 | r23
            r0 = r33
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r11 = r35
            r13 = r5
            goto L_0x001b
        L_0x0273:
            r33 = r7
            r7 = r4
            goto L_0x0375
        L_0x0278:
            r5 = r34
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r20
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != r1) goto L_0x029b
            int r0 = com.google.android.gms.internal.ads.C9609no.m23961a(r12, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
            r6 = r6 | r23
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r11 = r35
            r13 = r5
            goto L_0x001b
        L_0x029b:
            r33 = r7
            r7 = r4
            goto L_0x0375
        L_0x02a0:
            r5 = r34
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r20
            r19 = -1
            r12 = r32
            r13 = r36
            r1 = 1
            if (r0 != r1) goto L_0x02cf
            long r17 = com.google.android.gms.internal.ads.C9609no.m23965b(r12, r4)
            r0 = r10
            r1 = r31
            r33 = r7
            r7 = r4
            r4 = r17
            r0.putLong(r1, r2, r4)
            int r0 = r7 + 8
            r6 = r6 | r23
            r7 = r33
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r13 = r34
            r11 = r35
            goto L_0x001b
        L_0x02cf:
            r33 = r7
            r7 = r4
            goto L_0x0375
        L_0x02d4:
            r9 = r2
            r11 = r3
            r33 = r7
            r2 = r12
            r8 = r20
            r19 = -1
            r12 = r32
            r13 = r36
            r7 = r4
            if (r0 != 0) goto L_0x0375
            int r0 = com.google.android.gms.internal.ads.C9609no.m23962a(r12, r7, r13)
            int r1 = r13.f22846a
            r10.putInt(r14, r2, r1)
            r6 = r6 | r23
            r7 = r33
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r13 = r34
            r11 = r35
            goto L_0x001b
        L_0x02fb:
            r9 = r2
            r11 = r3
            r33 = r7
            r2 = r12
            r8 = r20
            r19 = -1
            r12 = r32
            r13 = r36
            r7 = r4
            if (r0 != 0) goto L_0x0375
            int r7 = com.google.android.gms.internal.ads.C9609no.m23964b(r12, r7, r13)
            long r4 = r13.f22847b
            r0 = r10
            r1 = r31
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r0 = r7
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r7 = r33
            r13 = r34
            r11 = r35
            goto L_0x001b
        L_0x0326:
            r9 = r2
            r11 = r3
            r33 = r7
            r2 = r12
            r8 = r20
            r19 = -1
            r12 = r32
            r13 = r36
            r7 = r4
            if (r0 != r1) goto L_0x0375
            float r0 = com.google.android.gms.internal.ads.C9609no.m23968d(r12, r7)
            com.google.android.gms.internal.ads.C9132Sp.m22983a(r14, r2, r0)
            int r0 = r7 + 4
            r6 = r6 | r23
            r7 = r33
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r13 = r34
            r11 = r35
            goto L_0x001b
        L_0x034d:
            r9 = r2
            r11 = r3
            r33 = r7
            r2 = r12
            r8 = r20
            r19 = -1
            r12 = r32
            r13 = r36
            r7 = r4
            r1 = 1
            if (r0 != r1) goto L_0x0375
            double r0 = com.google.android.gms.internal.ads.C9609no.m23966c(r12, r7)
            com.google.android.gms.internal.ads.C9132Sp.m22982a(r14, r2, r0)
            int r0 = r7 + 8
            r6 = r6 | r23
            r7 = r33
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r13 = r34
            r11 = r35
            goto L_0x001b
        L_0x0375:
            r2 = r7
            r26 = r8
            r19 = r9
            r27 = r10
            r25 = r11
            r7 = r33
            goto L_0x0496
        L_0x0382:
            r5 = r3
            r18 = r7
            r8 = r20
            r19 = -1
            r7 = r4
            r28 = r12
            r12 = r32
            r13 = r9
            r9 = r2
            r2 = r28
            r1 = 27
            if (r11 != r1) goto L_0x03ec
            r1 = 2
            if (r0 != r1) goto L_0x03de
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.android.gms.internal.ads.zzdoj r0 = (com.google.android.gms.internal.ads.zzdoj) r0
            boolean r1 = r0.mo29067t()
            if (r1 != 0) goto L_0x03ba
            int r1 = r0.size()
            if (r1 != 0) goto L_0x03af
            r1 = 10
            goto L_0x03b1
        L_0x03af:
            int r1 = r1 << 1
        L_0x03b1:
            com.google.android.gms.internal.ads.zzdoj r0 = r0.mo28270b(r1)
            r10.putObject(r14, r2, r0)
            r11 = r0
            goto L_0x03bb
        L_0x03ba:
            r11 = r0
        L_0x03bb:
            com.google.android.gms.internal.ads.xp r0 = r15.m23892a(r9)
            r1 = r8
            r2 = r32
            r3 = r7
            r4 = r34
            r7 = r5
            r5 = r11
            r20 = r6
            r6 = r36
            int r0 = com.google.android.gms.internal.ads.C9609no.m23958a(r0, r1, r2, r3, r4, r5, r6)
            r11 = r35
            r1 = r7
            r3 = r8
            r2 = r9
            r9 = r13
            r7 = r18
            r6 = r20
            r13 = r34
            goto L_0x001b
        L_0x03de:
            r20 = r6
            r6 = r5
            r25 = r6
            r15 = r7
            r26 = r8
            r19 = r9
            r27 = r10
            goto L_0x0459
        L_0x03ec:
            r20 = r6
            r6 = r5
            r1 = 49
            if (r11 > r1) goto L_0x0441
            r5 = r21
            long r4 = (long) r5
            r1 = r0
            r0 = r30
            r33 = r1
            r1 = r31
            r23 = r2
            r2 = r32
            r3 = r7
            r21 = r4
            r4 = r34
            r5 = r8
            r25 = r6
            r15 = r7
            r7 = r33
            r26 = r8
            r8 = r9
            r19 = r9
            r27 = r10
            r9 = r21
            r12 = r23
            r14 = r36
            int r0 = r0.m23889a((T) r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 != r15) goto L_0x0427
            r2 = r0
            r7 = r18
            r6 = r20
            goto L_0x0496
        L_0x0427:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r9 = r36
            r7 = r18
            r2 = r19
            r6 = r20
            r1 = r25
            r3 = r26
            r10 = r27
            goto L_0x001b
        L_0x0441:
            r33 = r0
            r23 = r2
            r25 = r6
            r15 = r7
            r26 = r8
            r19 = r9
            r27 = r10
            r5 = r21
            r0 = 50
            if (r11 != r0) goto L_0x0473
            r7 = r33
            r0 = 2
            if (r7 == r0) goto L_0x045f
        L_0x0459:
            r2 = r15
            r7 = r18
            r6 = r20
            goto L_0x0496
        L_0x045f:
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r19
            r6 = r23
            r8 = r36
            r0.m23890a((T) r1, r2, r3, r4, r5, r6, r8)
            throw r17
        L_0x0473:
            r7 = r33
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r8 = r5
            r5 = r26
            r6 = r25
            r9 = r11
            r10 = r23
            r12 = r19
            r13 = r36
            int r0 = r0.m23888a((T) r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 != r15) goto L_0x0530
            r2 = r0
            r7 = r18
            r6 = r20
        L_0x0496:
            r8 = r35
            r9 = r26
            if (r9 != r8) goto L_0x04a6
            if (r8 != 0) goto L_0x049f
            goto L_0x04a6
        L_0x049f:
            r10 = r30
            r13 = r31
            r0 = r2
            goto L_0x055a
        L_0x04a6:
            r10 = r30
            boolean r0 = r10.f22776h
            if (r0 == 0) goto L_0x050a
            r11 = r36
            com.google.android.gms.internal.ads.zzdno r0 = r11.f22849d
            com.google.android.gms.internal.ads.zzdno r1 = com.google.android.gms.internal.ads.zzdno.m29866b()
            if (r0 == r1) goto L_0x0505
            com.google.android.gms.internal.ads.zzdpk r0 = r10.f22775g
            com.google.android.gms.internal.ads.zzdno r1 = r11.f22849d
            r12 = r25
            com.google.android.gms.internal.ads.zzdob$zzd r0 = r1.mo31590a(r0, r12)
            if (r0 != 0) goto L_0x04e4
            com.google.android.gms.internal.ads.zzdqu r4 = m23920e(r31)
            r0 = r9
            r1 = r32
            r3 = r34
            r5 = r36
            int r0 = com.google.android.gms.internal.ads.C9609no.m23956a(r0, r1, r2, r3, r4, r5)
            r14 = r31
            r13 = r34
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r2 = r19
            r10 = r27
            r12 = r32
            r11 = r8
            goto L_0x001b
        L_0x04e4:
            r13 = r31
            r0 = r13
            com.google.android.gms.internal.ads.zzdob$zzc r0 = (com.google.android.gms.internal.ads.zzdob.zzc) r0
            com.google.android.gms.internal.ads.Lo<java.lang.Object> r1 = r0.zzhhj
            boolean r1 = r1.mo28427c()
            if (r1 == 0) goto L_0x04fb
            com.google.android.gms.internal.ads.Lo<java.lang.Object> r1 = r0.zzhhj
            java.lang.Object r1 = r1.clone()
            com.google.android.gms.internal.ads.Lo r1 = (com.google.android.gms.internal.ads.C8985Lo) r1
            r0.zzhhj = r1
        L_0x04fb:
            com.google.android.gms.internal.ads.Lo<java.lang.Object> r0 = r0.zzhhj
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x0505:
            r13 = r31
            r12 = r25
            goto L_0x0510
        L_0x050a:
            r13 = r31
            r11 = r36
            r12 = r25
        L_0x0510:
            com.google.android.gms.internal.ads.zzdqu r4 = m23920e(r31)
            r0 = r9
            r1 = r32
            r3 = r34
            r5 = r36
            int r0 = com.google.android.gms.internal.ads.C9609no.m23956a(r0, r1, r2, r3, r4, r5)
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r14 = r13
            r2 = r19
            r10 = r27
            r12 = r32
            r13 = r34
            r11 = r8
            goto L_0x001b
        L_0x0530:
            r10 = r30
            r13 = r31
            r8 = r35
            r11 = r36
            r12 = r25
            r9 = r26
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r14 = r13
            r7 = r18
            r2 = r19
            r6 = r20
            r10 = r27
            r12 = r32
            r13 = r34
            r11 = r8
            goto L_0x001b
        L_0x0550:
            r20 = r6
            r18 = r7
            r27 = r10
            r8 = r11
            r13 = r14
            r10 = r15
            r9 = r3
        L_0x055a:
            r1 = -1
            if (r7 == r1) goto L_0x0563
            long r1 = (long) r7
            r3 = r27
            r3.putInt(r13, r1, r6)
        L_0x0563:
            int r1 = r10.f22781m
            r2 = r17
        L_0x0568:
            int r3 = r10.f22782n
            if (r1 >= r3) goto L_0x057a
            int[] r3 = r10.f22780l
            r3 = r3[r1]
            com.google.android.gms.internal.ads.Op<?, ?> r4 = r10.f22785q
            r10.m23894a(r13, r3, (UB) r2, r4)
            com.google.android.gms.internal.ads.zzdqu r2 = (com.google.android.gms.internal.ads.zzdqu) r2
            int r1 = r1 + 1
            goto L_0x0568
        L_0x057a:
            if (r2 == 0) goto L_0x0581
            com.google.android.gms.internal.ads.Op<?, ?> r1 = r10.f22785q
            r1.mo28493b(r13, r2)
        L_0x0581:
            if (r8 != 0) goto L_0x058d
            r1 = r34
            if (r0 != r1) goto L_0x0588
            goto L_0x0593
        L_0x0588:
            com.google.android.gms.internal.ads.zzdok r0 = com.google.android.gms.internal.ads.zzdok.m29934g()
            throw r0
        L_0x058d:
            r1 = r34
            if (r0 > r1) goto L_0x0594
            if (r9 != r8) goto L_0x0594
        L_0x0593:
            return r0
        L_0x0594:
            com.google.android.gms.internal.ads.zzdok r0 = com.google.android.gms.internal.ads.zzdok.m29934g()
            goto L_0x059a
        L_0x0599:
            throw r0
        L_0x059a:
            goto L_0x0599
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9588mp.mo29079a(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.oo):int");
    }

    /* JADX WARNING: type inference failed for: r29v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r12v0 */
    /* JADX WARNING: type inference failed for: r2v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r12v1, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r0v5, types: [int, byte] */
    /* JADX WARNING: type inference failed for: r17v0, types: [int] */
    /* JADX WARNING: type inference failed for: r12v2 */
    /* JADX WARNING: type inference failed for: r0v7, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r12v3 */
    /* JADX WARNING: type inference failed for: r2v7, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r5v3, types: [int] */
    /* JADX WARNING: type inference failed for: r12v5 */
    /* JADX WARNING: type inference failed for: r2v10, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r2v11, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r5v5, types: [int] */
    /* JADX WARNING: type inference failed for: r12v7 */
    /* JADX WARNING: type inference failed for: r1v13, types: [int] */
    /* JADX WARNING: type inference failed for: r2v14, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r17v1 */
    /* JADX WARNING: type inference failed for: r3v13, types: [int] */
    /* JADX WARNING: type inference failed for: r17v2 */
    /* JADX WARNING: type inference failed for: r12v8 */
    /* JADX WARNING: type inference failed for: r12v9 */
    /* JADX WARNING: type inference failed for: r12v10 */
    /* JADX WARNING: type inference failed for: r12v11 */
    /* JADX WARNING: type inference failed for: r12v12 */
    /* JADX WARNING: type inference failed for: r12v13 */
    /* JADX WARNING: type inference failed for: r12v14 */
    /* JADX WARNING: type inference failed for: r12v15 */
    /* JADX WARNING: type inference failed for: r12v16 */
    /* JADX WARNING: type inference failed for: r12v17 */
    /* JADX WARNING: type inference failed for: r12v18 */
    /* JADX WARNING: type inference failed for: r12v19 */
    /* JADX WARNING: type inference failed for: r12v20 */
    /* JADX WARNING: type inference failed for: r12v21 */
    /* JADX WARNING: type inference failed for: r12v22 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r0v5, types: [int, byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte[], code=null, for r29v0, types: [byte[]] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r12v2
      assigns: []
      uses: []
      mth insns count: 395
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 16 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo29084a(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.ads.C9631oo r32) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            boolean r0 = r15.f22778j
            if (r0 == 0) goto L_0x0357
            sun.misc.Unsafe r9 = f22770b
            r10 = -1
            r16 = 0
            r0 = r30
            r1 = -1
            r2 = 0
        L_0x0019:
            if (r0 >= r13) goto L_0x034d
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.ads.C9609no.m23957a(r0, r12, r3, r11)
            int r3 = r11.f22846a
            r8 = r0
            r17 = r3
            goto L_0x002e
        L_0x002b:
            r17 = r0
            r8 = r3
        L_0x002e:
            int r7 = r17 >>> 3
            r6 = r17 & 7
            if (r7 <= r1) goto L_0x003c
            int r2 = r2 / 3
            int r0 = r15.m23886a(r7, r2)
            r4 = r0
            goto L_0x0041
        L_0x003c:
            int r0 = r15.m23923g(r7)
            r4 = r0
        L_0x0041:
            if (r4 != r10) goto L_0x004f
            r24 = r7
            r2 = r8
            r18 = r9
            r19 = 0
            r26 = -1
            goto L_0x0316
        L_0x004f:
            int[] r0 = r15.f22771c
            int r1 = r4 + 1
            r5 = r0[r1]
            r0 = 267386880(0xff00000, float:2.3665827E-29)
            r0 = r0 & r5
            int r3 = r0 >>> 20
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r1 = (long) r0
            r0 = 17
            r10 = 2
            if (r3 > r0) goto L_0x0231
            r0 = 1
            switch(r3) {
                case 0: goto L_0x0214;
                case 1: goto L_0x01f6;
                case 2: goto L_0x01d5;
                case 3: goto L_0x01d5;
                case 4: goto L_0x01b8;
                case 5: goto L_0x0196;
                case 6: goto L_0x0179;
                case 7: goto L_0x0154;
                case 8: goto L_0x012e;
                case 9: goto L_0x00fc;
                case 10: goto L_0x00e0;
                case 11: goto L_0x01b8;
                case 12: goto L_0x00c3;
                case 13: goto L_0x0179;
                case 14: goto L_0x0196;
                case 15: goto L_0x00a2;
                case 16: goto L_0x0078;
                default: goto L_0x006c;
            }
        L_0x006c:
            r10 = r4
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            r26 = -1
            goto L_0x02e1
        L_0x0078:
            if (r6 != 0) goto L_0x0096
            int r6 = com.google.android.gms.internal.ads.C9609no.m23964b(r12, r8, r11)
            r19 = r1
            long r0 = r11.f22847b
            long r21 = com.google.android.gms.internal.ads.zzdnd.m29670a(r0)
            r0 = r9
            r2 = r19
            r1 = r28
            r10 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            r0 = r6
            r1 = r7
            r2 = r10
            r10 = -1
            goto L_0x0019
        L_0x0096:
            r10 = r4
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            r26 = -1
            goto L_0x02e1
        L_0x00a2:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x00b8
            int r0 = com.google.android.gms.internal.ads.C9609no.m23962a(r12, r8, r11)
            int r1 = r11.f22846a
            int r1 = com.google.android.gms.internal.ads.zzdnd.m29672e(r1)
            r9.putInt(r14, r2, r1)
            r1 = r7
            r2 = r10
            r10 = -1
            goto L_0x0019
        L_0x00b8:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            r26 = -1
            goto L_0x02e1
        L_0x00c3:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x00d5
            int r0 = com.google.android.gms.internal.ads.C9609no.m23962a(r12, r8, r11)
            int r1 = r11.f22846a
            r9.putInt(r14, r2, r1)
            r1 = r7
            r2 = r10
            r10 = -1
            goto L_0x0019
        L_0x00d5:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            r26 = -1
            goto L_0x02e1
        L_0x00e0:
            r2 = r1
            if (r6 != r10) goto L_0x00f1
            int r0 = com.google.android.gms.internal.ads.C9609no.m23970e(r12, r8, r11)
            java.lang.Object r1 = r11.f22848c
            r9.putObject(r14, r2, r1)
            r2 = r4
            r1 = r7
            r10 = -1
            goto L_0x0019
        L_0x00f1:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            goto L_0x02e1
        L_0x00fc:
            r2 = r1
            if (r6 != r10) goto L_0x0123
            com.google.android.gms.internal.ads.xp r0 = r15.m23892a(r4)
            int r0 = com.google.android.gms.internal.ads.C9609no.m23960a(r0, r12, r8, r13, r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x0114
            java.lang.Object r1 = r11.f22848c
            r9.putObject(r14, r2, r1)
            goto L_0x011e
        L_0x0114:
            java.lang.Object r5 = r11.f22848c
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzdod.m29916a(r1, r5)
            r9.putObject(r14, r2, r1)
        L_0x011e:
            r2 = r4
            r1 = r7
            r10 = -1
            goto L_0x0019
        L_0x0123:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            goto L_0x02e1
        L_0x012e:
            r2 = r1
            if (r6 != r10) goto L_0x0149
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x013b
            int r0 = com.google.android.gms.internal.ads.C9609no.m23967c(r12, r8, r11)
            goto L_0x013f
        L_0x013b:
            int r0 = com.google.android.gms.internal.ads.C9609no.m23969d(r12, r8, r11)
        L_0x013f:
            java.lang.Object r1 = r11.f22848c
            r9.putObject(r14, r2, r1)
            r2 = r4
            r1 = r7
            r10 = -1
            goto L_0x0019
        L_0x0149:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            goto L_0x02e1
        L_0x0154:
            r2 = r1
            if (r6 != 0) goto L_0x016e
            int r1 = com.google.android.gms.internal.ads.C9609no.m23964b(r12, r8, r11)
            long r5 = r11.f22847b
            r19 = 0
            int r8 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r8 == 0) goto L_0x0164
            goto L_0x0165
        L_0x0164:
            r0 = 0
        L_0x0165:
            com.google.android.gms.internal.ads.C9132Sp.m22987a(r14, r2, r0)
            r0 = r1
            r2 = r4
            r1 = r7
            r10 = -1
            goto L_0x0019
        L_0x016e:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            goto L_0x02e1
        L_0x0179:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x018b
            int r0 = com.google.android.gms.internal.ads.C9609no.m23961a(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
            r2 = r4
            r1 = r7
            r10 = -1
            goto L_0x0019
        L_0x018b:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            goto L_0x02e1
        L_0x0196:
            r2 = r1
            if (r6 != r0) goto L_0x01ac
            long r5 = com.google.android.gms.internal.ads.C9609no.m23965b(r12, r8)
            r0 = r9
            r1 = r28
            r10 = r4
            r4 = r5
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            r1 = r7
            r2 = r10
            r10 = -1
            goto L_0x0019
        L_0x01ac:
            r10 = r4
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            r26 = -1
            goto L_0x02e1
        L_0x01b8:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.ads.C9609no.m23962a(r12, r8, r11)
            int r1 = r11.f22846a
            r9.putInt(r14, r2, r1)
            r1 = r7
            r2 = r10
            r10 = -1
            goto L_0x0019
        L_0x01ca:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            r26 = -1
            goto L_0x02e1
        L_0x01d5:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x01eb
            int r6 = com.google.android.gms.internal.ads.C9609no.m23964b(r12, r8, r11)
            long r4 = r11.f22847b
            r0 = r9
            r1 = r28
            r0.putLong(r1, r2, r4)
            r0 = r6
            r1 = r7
            r2 = r10
            r10 = -1
            goto L_0x0019
        L_0x01eb:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            r26 = -1
            goto L_0x02e1
        L_0x01f6:
            r2 = r1
            r10 = r4
            r0 = 5
            if (r6 != r0) goto L_0x0209
            float r0 = com.google.android.gms.internal.ads.C9609no.m23968d(r12, r8)
            com.google.android.gms.internal.ads.C9132Sp.m22983a(r14, r2, r0)
            int r0 = r8 + 4
            r1 = r7
            r2 = r10
            r10 = -1
            goto L_0x0019
        L_0x0209:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            r26 = -1
            goto L_0x02e1
        L_0x0214:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x0226
            double r0 = com.google.android.gms.internal.ads.C9609no.m23966c(r12, r8)
            com.google.android.gms.internal.ads.C9132Sp.m22982a(r14, r2, r0)
            int r0 = r8 + 8
            r1 = r7
            r2 = r10
            r10 = -1
            goto L_0x0019
        L_0x0226:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            r26 = -1
            goto L_0x02e1
        L_0x0231:
            r0 = 27
            if (r3 != r0) goto L_0x027e
            if (r6 != r10) goto L_0x0273
            java.lang.Object r0 = r9.getObject(r14, r1)
            com.google.android.gms.internal.ads.zzdoj r0 = (com.google.android.gms.internal.ads.zzdoj) r0
            boolean r3 = r0.mo29067t()
            if (r3 != 0) goto L_0x0258
            int r3 = r0.size()
            if (r3 != 0) goto L_0x024d
            r3 = 10
            goto L_0x024f
        L_0x024d:
            int r3 = r3 << 1
        L_0x024f:
            com.google.android.gms.internal.ads.zzdoj r0 = r0.mo28270b(r3)
            r9.putObject(r14, r1, r0)
            r5 = r0
            goto L_0x0259
        L_0x0258:
            r5 = r0
        L_0x0259:
            com.google.android.gms.internal.ads.xp r0 = r15.m23892a(r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = com.google.android.gms.internal.ads.C9609no.m23958a(r0, r1, r2, r3, r4, r5, r6)
            r1 = r7
            r2 = r19
            r10 = -1
            goto L_0x0019
        L_0x0273:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            goto L_0x02e1
        L_0x027e:
            r19 = r4
            r0 = 49
            if (r3 > r0) goto L_0x02ca
            long r4 = (long) r5
            r0 = r27
            r20 = r1
            r1 = r28
            r2 = r29
            r10 = r3
            r3 = r8
            r22 = r4
            r4 = r31
            r5 = r17
            r30 = r6
            r6 = r7
            r24 = r7
            r7 = r30
            r15 = r8
            r8 = r19
            r18 = r9
            r25 = r10
            r26 = -1
            r9 = r22
            r11 = r25
            r12 = r20
            r14 = r32
            int r0 = r0.m23889a((T) r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 != r15) goto L_0x02b7
            r2 = r0
            goto L_0x0316
        L_0x02b7:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
            r10 = -1
            goto L_0x0019
        L_0x02ca:
            r20 = r1
            r25 = r3
            r30 = r6
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            r0 = 50
            r9 = r25
            if (r9 != r0) goto L_0x02f8
            r7 = r30
            if (r7 == r10) goto L_0x02e3
        L_0x02e1:
            r2 = r15
            goto L_0x0316
        L_0x02e3:
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r6 = r20
            r8 = r32
            r0.m23890a((T) r1, r2, r3, r4, r5, r6, r8)
            r0 = 0
            throw r0
        L_0x02f8:
            r7 = r30
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r8 = r5
            r5 = r17
            r6 = r24
            r10 = r20
            r12 = r19
            r13 = r32
            int r0 = r0.m23888a((T) r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 != r15) goto L_0x033a
            r2 = r0
        L_0x0316:
            com.google.android.gms.internal.ads.zzdqu r4 = m23920e(r28)
            r0 = r17
            r1 = r29
            r3 = r31
            r5 = r32
            int r0 = com.google.android.gms.internal.ads.C9609no.m23956a(r0, r1, r2, r3, r4, r5)
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
            r10 = -1
            goto L_0x0019
        L_0x033a:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
            r10 = -1
            goto L_0x0019
        L_0x034d:
            r4 = r31
            if (r0 != r4) goto L_0x0352
            return
        L_0x0352:
            com.google.android.gms.internal.ads.zzdok r0 = com.google.android.gms.internal.ads.zzdok.m29934g()
            throw r0
        L_0x0357:
            r4 = r13
            r5 = 0
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r6 = r32
            r0.mo29079a((T) r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9588mp.mo29084a(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.oo):void");
    }

    /* renamed from: d */
    public final void mo29088d(T t) {
        int i;
        int i2 = this.f22781m;
        while (true) {
            i = this.f22782n;
            if (i2 >= i) {
                break;
            }
            long d = (long) (m23916d(this.f22780l[i2]) & 1048575);
            Object f = C9132Sp.m23009f(t, d);
            if (f != null) {
                this.f22787s.mo28971e(f);
                C9132Sp.m22986a((Object) t, d, f);
            }
            i2++;
        }
        int length = this.f22780l.length;
        while (i < length) {
            this.f22784p.mo28698b(t, (long) this.f22780l[i]);
            i++;
        }
        this.f22785q.mo28481a((Object) t);
        if (this.f22776h) {
            this.f22786r.mo28362a((Object) t);
        }
    }

    /* renamed from: a */
    private final <UT, UB> UB m23894a(Object obj, int i, UB ub, C9049Op<UT, UB> op) {
        int i2 = this.f22771c[i];
        Object f = C9132Sp.m23009f(obj, (long) (m23916d(i) & 1048575));
        if (f == null) {
            return ub;
        }
        zzdog c = m23914c(i);
        if (c == null) {
            return ub;
        }
        m23893a(i, i2, this.f22787s.mo28973g(f), c, ub, op);
        throw null;
    }

    /* renamed from: a */
    private final <K, V, UT, UB> UB m23893a(int i, int i2, Map<K, V> map, zzdog zzdog, UB ub, C9049Op<UT, UB> op) {
        this.f22787s.mo28969c(m23908b(i));
        throw null;
    }

    /* renamed from: c */
    public final boolean mo29087c(T t) {
        int i;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.f22781m) {
                return !this.f22776h || this.f22786r.mo28364b(t).mo28429d();
            }
            int i5 = this.f22780l[i2];
            int i6 = this.f22771c[i5];
            int d = m23916d(i5);
            if (!this.f22778j) {
                int i7 = this.f22771c[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = f22770b.getInt(t, (long) i8);
                    i3 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & d) != 0) && !m23904a(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & d) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (m23903a(t, i6, i5) && !m23905a((Object) t, d, m23892a(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 == 50 && !this.f22787s.mo28970d(C9132Sp.m23009f(t, (long) (d & 1048575))).isEmpty()) {
                            this.f22787s.mo28969c(m23908b(i5));
                            throw null;
                        }
                    }
                }
                List list = (List) C9132Sp.m23009f(t, (long) (d & 1048575));
                if (!list.isEmpty()) {
                    C9822xp a = m23892a(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!a.mo29087c(list.get(i10))) {
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
            } else if (m23904a(t, i5, i4, i) && !m23905a((Object) t, d, m23892a(i5))) {
                return false;
            }
            i2++;
        }
    }

    /* renamed from: a */
    private static boolean m23905a(Object obj, int i, C9822xp xpVar) {
        return xpVar.mo29087c(C9132Sp.m23009f(obj, (long) (i & 1048575)));
    }

    /* renamed from: a */
    private static void m23897a(int i, Object obj, C9435fq fqVar) throws IOException {
        if (obj instanceof String) {
            fqVar.mo28209a(i, (String) obj);
        } else {
            fqVar.mo28206a(i, (zzdmr) obj);
        }
    }

    /* renamed from: a */
    private final void m23900a(Object obj, int i, C9801wp wpVar) throws IOException {
        if (m23921f(i)) {
            C9132Sp.m22986a(obj, (long) (i & 1048575), (Object) wpVar.mo28155m());
        } else if (this.f22777i) {
            C9132Sp.m22986a(obj, (long) (i & 1048575), (Object) wpVar.readString());
        } else {
            C9132Sp.m22986a(obj, (long) (i & 1048575), (Object) wpVar.mo28161p());
        }
    }

    /* renamed from: d */
    private final int m23916d(int i) {
        return this.f22771c[i + 1];
    }

    /* renamed from: e */
    private final int m23918e(int i) {
        return this.f22771c[i + 2];
    }

    /* renamed from: f */
    private static boolean m23921f(int i) {
        return (i & 536870912) != 0;
    }

    /* renamed from: b */
    private static <T> double m23906b(T t, long j) {
        return ((Double) C9132Sp.m23009f(t, j)).doubleValue();
    }

    /* renamed from: c */
    private static <T> float m23913c(T t, long j) {
        return ((Float) C9132Sp.m23009f(t, j)).floatValue();
    }

    /* renamed from: d */
    private static <T> int m23917d(T t, long j) {
        return ((Integer) C9132Sp.m23009f(t, j)).intValue();
    }

    /* renamed from: e */
    private static <T> long m23919e(T t, long j) {
        return ((Long) C9132Sp.m23009f(t, j)).longValue();
    }

    /* renamed from: f */
    private static <T> boolean m23922f(T t, long j) {
        return ((Boolean) C9132Sp.m23009f(t, j)).booleanValue();
    }

    /* renamed from: c */
    private final boolean m23915c(T t, T t2, int i) {
        return m23902a(t, i) == m23902a(t2, i);
    }

    /* renamed from: a */
    private final boolean m23904a(T t, int i, int i2, int i3) {
        if (this.f22778j) {
            return m23902a(t, i);
        }
        return (i2 & i3) != 0;
    }

    /* renamed from: a */
    private final boolean m23902a(T t, int i) {
        if (this.f22778j) {
            int d = m23916d(i);
            long j = (long) (d & 1048575);
            switch ((d & 267386880) >>> 20) {
                case 0:
                    return C9132Sp.m23006e(t, j) != 0.0d;
                case 1:
                    return C9132Sp.m23001d(t, j) != 0.0f;
                case 2:
                    return C9132Sp.m22992b(t, j) != 0;
                case 3:
                    return C9132Sp.m22992b(t, j) != 0;
                case 4:
                    return C9132Sp.m22976a((Object) t, j) != 0;
                case 5:
                    return C9132Sp.m22992b(t, j) != 0;
                case 6:
                    return C9132Sp.m22976a((Object) t, j) != 0;
                case 7:
                    return C9132Sp.m23000c(t, j);
                case 8:
                    Object f = C9132Sp.m23009f(t, j);
                    if (f instanceof String) {
                        return !((String) f).isEmpty();
                    }
                    if (f instanceof zzdmr) {
                        return !zzdmr.f27972a.equals(f);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return C9132Sp.m23009f(t, j) != null;
                case 10:
                    return !zzdmr.f27972a.equals(C9132Sp.m23009f(t, j));
                case 11:
                    return C9132Sp.m22976a((Object) t, j) != 0;
                case 12:
                    return C9132Sp.m22976a((Object) t, j) != 0;
                case 13:
                    return C9132Sp.m22976a((Object) t, j) != 0;
                case 14:
                    return C9132Sp.m22992b(t, j) != 0;
                case 15:
                    return C9132Sp.m22976a((Object) t, j) != 0;
                case 16:
                    return C9132Sp.m22992b(t, j) != 0;
                case 17:
                    return C9132Sp.m23009f(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int e = m23918e(i);
            return (C9132Sp.m22976a((Object) t, (long) (e & 1048575)) & (1 << (e >>> 20))) != 0;
        }
    }

    /* renamed from: b */
    private final void m23909b(T t, int i) {
        if (!this.f22778j) {
            int e = m23918e(i);
            long j = (long) (e & 1048575);
            C9132Sp.m22984a((Object) t, j, C9132Sp.m22976a((Object) t, j) | (1 << (e >>> 20)));
        }
    }

    /* renamed from: a */
    private final boolean m23903a(T t, int i, int i2) {
        return C9132Sp.m22976a((Object) t, (long) (m23918e(i2) & 1048575)) == i;
    }

    /* renamed from: b */
    private final void m23910b(T t, int i, int i2) {
        C9132Sp.m22984a((Object) t, (long) (m23918e(i2) & 1048575), i);
    }

    /* renamed from: g */
    private final int m23923g(int i) {
        if (i < this.f22773e || i > this.f22774f) {
            return -1;
        }
        return m23907b(i, 0);
    }

    /* renamed from: a */
    private final int m23886a(int i, int i2) {
        if (i < this.f22773e || i > this.f22774f) {
            return -1;
        }
        return m23907b(i, i2);
    }

    /* renamed from: b */
    private final int m23907b(int i, int i2) {
        int length = (this.f22771c.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.f22771c[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
