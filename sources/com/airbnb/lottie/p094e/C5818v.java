package com.airbnb.lottie.p094e;

/* renamed from: com.airbnb.lottie.e.v */
/* compiled from: MaskParser */
class C5818v {
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008b, code lost:
        if (r4.equals("a") != false) goto L_0x008f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00be  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.p089c.p091b.C5741g m10485a(android.util.JsonReader r11, com.airbnb.lottie.C5830g r12) throws java.io.IOException {
        /*
            r0 = 0
            r1 = 0
            r2 = 0
            r11.beginObject()
        L_0x0006:
            boolean r3 = r11.hasNext()
            if (r3 == 0) goto L_0x00c4
            java.lang.String r3 = r11.nextName()
            int r4 = r3.hashCode()
            r5 = 111(0x6f, float:1.56E-43)
            r6 = 0
            r7 = -1
            r8 = 2
            r9 = 1
            if (r4 == r5) goto L_0x003a
            r5 = 3588(0xe04, float:5.028E-42)
            if (r4 == r5) goto L_0x0030
            r5 = 3357091(0x3339a3, float:4.704286E-39)
            if (r4 == r5) goto L_0x0026
        L_0x0025:
            goto L_0x0044
        L_0x0026:
            java.lang.String r4 = "mode"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0025
            r4 = 0
            goto L_0x0045
        L_0x0030:
            java.lang.String r4 = "pt"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0025
            r4 = 1
            goto L_0x0045
        L_0x003a:
            java.lang.String r4 = "o"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0025
            r4 = 2
            goto L_0x0045
        L_0x0044:
            r4 = -1
        L_0x0045:
            if (r4 == 0) goto L_0x005c
            if (r4 == r9) goto L_0x0056
            if (r4 == r8) goto L_0x0050
            r11.skipValue()
            goto L_0x00c2
        L_0x0050:
            com.airbnb.lottie.c.a.d r2 = com.airbnb.lottie.p094e.C5800d.m10441d(r11, r12)
            goto L_0x00c2
        L_0x0056:
            com.airbnb.lottie.c.a.h r1 = com.airbnb.lottie.p094e.C5800d.m10444g(r11, r12)
            goto L_0x00c2
        L_0x005c:
            java.lang.String r4 = r11.nextString()
            int r5 = r4.hashCode()
            r10 = 97
            if (r5 == r10) goto L_0x0085
            r6 = 105(0x69, float:1.47E-43)
            if (r5 == r6) goto L_0x007b
            r6 = 115(0x73, float:1.61E-43)
            if (r5 == r6) goto L_0x0071
        L_0x0070:
            goto L_0x008e
        L_0x0071:
            java.lang.String r5 = "s"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0070
            r6 = 1
            goto L_0x008f
        L_0x007b:
            java.lang.String r5 = "i"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0070
            r6 = 2
            goto L_0x008f
        L_0x0085:
            java.lang.String r5 = "a"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0070
            goto L_0x008f
        L_0x008e:
            r6 = -1
        L_0x008f:
            if (r6 == 0) goto L_0x00be
            if (r6 == r9) goto L_0x00bb
            if (r6 == r8) goto L_0x00b3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Unknown mask mode "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r5 = ". Defaulting to Add."
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "LOTTIE"
            android.util.Log.w(r5, r4)
            com.airbnb.lottie.c.b.g$a r0 = com.airbnb.lottie.p089c.p091b.C5741g.C5742a.MaskModeAdd
            goto L_0x00c1
        L_0x00b3:
            java.lang.String r4 = "Animation contains intersect masks. They are not supported but will be treated like add masks."
            r12.mo18189a(r4)
            com.airbnb.lottie.c.b.g$a r0 = com.airbnb.lottie.p089c.p091b.C5741g.C5742a.MaskModeIntersect
            goto L_0x00c1
        L_0x00bb:
            com.airbnb.lottie.c.b.g$a r0 = com.airbnb.lottie.p089c.p091b.C5741g.C5742a.MaskModeSubtract
            goto L_0x00c1
        L_0x00be:
            com.airbnb.lottie.c.b.g$a r0 = com.airbnb.lottie.p089c.p091b.C5741g.C5742a.MaskModeAdd
        L_0x00c1:
        L_0x00c2:
            goto L_0x0006
        L_0x00c4:
            r11.endObject()
            com.airbnb.lottie.c.b.g r3 = new com.airbnb.lottie.c.b.g
            r3.<init>(r0, r1, r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p094e.C5818v.m10485a(android.util.JsonReader, com.airbnb.lottie.g):com.airbnb.lottie.c.b.g");
    }
}
