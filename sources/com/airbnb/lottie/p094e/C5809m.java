package com.airbnb.lottie.p094e;

/* renamed from: com.airbnb.lottie.e.m */
/* compiled from: GradientFillParser */
class C5809m {
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0118  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.p089c.p091b.C5738d m10459a(android.util.JsonReader r19, com.airbnb.lottie.C5830g r20) throws java.io.IOException {
        /*
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x0007:
            boolean r7 = r19.hasNext()
            if (r7 == 0) goto L_0x0123
            java.lang.String r7 = r19.nextName()
            int r8 = r7.hashCode()
            r9 = 101(0x65, float:1.42E-43)
            r10 = 0
            r11 = -1
            r12 = 1
            if (r8 == r9) goto L_0x0068
            r9 = 103(0x67, float:1.44E-43)
            if (r8 == r9) goto L_0x005e
            r9 = 111(0x6f, float:1.56E-43)
            if (r8 == r9) goto L_0x0054
            r9 = 3519(0xdbf, float:4.931E-42)
            if (r8 == r9) goto L_0x004a
            switch(r8) {
                case 114: goto L_0x0040;
                case 115: goto L_0x0036;
                case 116: goto L_0x002c;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x0072
        L_0x002c:
            java.lang.String r8 = "t"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x002b
            r7 = 3
            goto L_0x0073
        L_0x0036:
            java.lang.String r8 = "s"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x002b
            r7 = 4
            goto L_0x0073
        L_0x0040:
            java.lang.String r8 = "r"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x002b
            r7 = 6
            goto L_0x0073
        L_0x004a:
            java.lang.String r8 = "nm"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x002b
            r7 = 0
            goto L_0x0073
        L_0x0054:
            java.lang.String r8 = "o"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x002b
            r7 = 2
            goto L_0x0073
        L_0x005e:
            java.lang.String r8 = "g"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x002b
            r7 = 1
            goto L_0x0073
        L_0x0068:
            java.lang.String r8 = "e"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x002b
            r7 = 5
            goto L_0x0073
        L_0x0072:
            r7 = -1
        L_0x0073:
            switch(r7) {
                case 0: goto L_0x0118;
                case 1: goto L_0x00c1;
                case 2: goto L_0x00b7;
                case 3: goto L_0x00a5;
                case 4: goto L_0x009b;
                case 5: goto L_0x0091;
                case 6: goto L_0x007f;
                default: goto L_0x0076;
            }
        L_0x0076:
            r15 = r19
            r14 = r20
            r19.skipValue()
            goto L_0x0121
        L_0x007f:
            int r7 = r19.nextInt()
            if (r7 != r12) goto L_0x0088
            android.graphics.Path$FillType r7 = android.graphics.Path.FillType.WINDING
            goto L_0x008a
        L_0x0088:
            android.graphics.Path$FillType r7 = android.graphics.Path.FillType.EVEN_ODD
        L_0x008a:
            r6 = r7
            r15 = r19
            r14 = r20
            goto L_0x0121
        L_0x0091:
            com.airbnb.lottie.c.a.f r5 = com.airbnb.lottie.p094e.C5800d.m10442e(r19, r20)
            r15 = r19
            r14 = r20
            goto L_0x0121
        L_0x009b:
            com.airbnb.lottie.c.a.f r4 = com.airbnb.lottie.p094e.C5800d.m10442e(r19, r20)
            r15 = r19
            r14 = r20
            goto L_0x0121
        L_0x00a5:
            int r7 = r19.nextInt()
            if (r7 != r12) goto L_0x00ae
            com.airbnb.lottie.c.b.f r7 = com.airbnb.lottie.p089c.p091b.C5740f.Linear
            goto L_0x00b0
        L_0x00ae:
            com.airbnb.lottie.c.b.f r7 = com.airbnb.lottie.p089c.p091b.C5740f.Radial
        L_0x00b0:
            r3 = r7
            r15 = r19
            r14 = r20
            goto L_0x0121
        L_0x00b7:
            com.airbnb.lottie.c.a.d r2 = com.airbnb.lottie.p094e.C5800d.m10441d(r19, r20)
            r15 = r19
            r14 = r20
            goto L_0x0121
        L_0x00c1:
            r7 = -1
            r19.beginObject()
        L_0x00c5:
            boolean r8 = r19.hasNext()
            if (r8 == 0) goto L_0x0110
            java.lang.String r8 = r19.nextName()
            int r9 = r8.hashCode()
            r13 = 107(0x6b, float:1.5E-43)
            if (r9 == r13) goto L_0x00e6
            r13 = 112(0x70, float:1.57E-43)
            if (r9 == r13) goto L_0x00dc
        L_0x00db:
            goto L_0x00f0
        L_0x00dc:
            java.lang.String r9 = "p"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x00db
            r8 = 0
            goto L_0x00f1
        L_0x00e6:
            java.lang.String r9 = "k"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x00db
            r8 = 1
            goto L_0x00f1
        L_0x00f0:
            r8 = -1
        L_0x00f1:
            if (r8 == 0) goto L_0x0106
            if (r8 == r12) goto L_0x00fd
            r19.skipValue()
            r15 = r19
            r14 = r20
            goto L_0x010f
        L_0x00fd:
            r15 = r19
            r14 = r20
            com.airbnb.lottie.c.a.c r1 = com.airbnb.lottie.p094e.C5800d.m10436a(r15, r14, r7)
            goto L_0x010f
        L_0x0106:
            r15 = r19
            r14 = r20
            int r7 = r19.nextInt()
        L_0x010f:
            goto L_0x00c5
        L_0x0110:
            r15 = r19
            r14 = r20
            r19.endObject()
            goto L_0x0121
        L_0x0118:
            r15 = r19
            r14 = r20
            java.lang.String r0 = r19.nextString()
        L_0x0121:
            goto L_0x0007
        L_0x0123:
            r15 = r19
            r14 = r20
            com.airbnb.lottie.c.b.d r17 = new com.airbnb.lottie.c.b.d
            r16 = 0
            r18 = 0
            r7 = r17
            r8 = r0
            r9 = r3
            r10 = r6
            r11 = r1
            r12 = r2
            r13 = r4
            r14 = r5
            r15 = r16
            r16 = r18
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p094e.C5809m.m10459a(android.util.JsonReader, com.airbnb.lottie.g):com.airbnb.lottie.c.b.d");
    }
}
