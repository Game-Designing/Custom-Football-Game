package com.airbnb.lottie.p094e;

/* renamed from: com.airbnb.lottie.e.g */
/* compiled from: ContentModelParser */
class C5803g {
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00bc, code lost:
        if (r0.equals("gr") != false) goto L_0x00de;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0042 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.p089c.p091b.C5736b m10448a(android.util.JsonReader r8, com.airbnb.lottie.C5830g r9) throws java.io.IOException {
        /*
            r0 = 0
            r8.beginObject()
            r1 = 2
        L_0x0005:
            boolean r2 = r8.hasNext()
            r3 = 0
            r4 = -1
            r5 = 1
            if (r2 == 0) goto L_0x0046
            java.lang.String r2 = r8.nextName()
            int r6 = r2.hashCode()
            r7 = 100
            if (r6 == r7) goto L_0x0029
            r7 = 3717(0xe85, float:5.209E-42)
            if (r6 == r7) goto L_0x001f
        L_0x001e:
            goto L_0x0033
        L_0x001f:
            java.lang.String r6 = "ty"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x001e
            r2 = 0
            goto L_0x0034
        L_0x0029:
            java.lang.String r6 = "d"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x001e
            r2 = 1
            goto L_0x0034
        L_0x0033:
            r2 = -1
        L_0x0034:
            if (r2 == 0) goto L_0x0042
            if (r2 == r5) goto L_0x003c
            r8.skipValue()
            goto L_0x0041
        L_0x003c:
            int r1 = r8.nextInt()
        L_0x0041:
            goto L_0x0005
        L_0x0042:
            java.lang.String r0 = r8.nextString()
        L_0x0046:
            if (r0 != 0) goto L_0x004a
            r2 = 0
            return r2
        L_0x004a:
            r2 = 0
            int r6 = r0.hashCode()
            switch(r6) {
                case 3239: goto L_0x00d3;
                case 3270: goto L_0x00c9;
                case 3295: goto L_0x00bf;
                case 3307: goto L_0x00b6;
                case 3308: goto L_0x00ac;
                case 3488: goto L_0x00a1;
                case 3633: goto L_0x0096;
                case 3646: goto L_0x008b;
                case 3669: goto L_0x0081;
                case 3679: goto L_0x0076;
                case 3681: goto L_0x006b;
                case 3705: goto L_0x005f;
                case 3710: goto L_0x0054;
                default: goto L_0x0052;
            }
        L_0x0052:
            goto L_0x00dd
        L_0x0054:
            java.lang.String r3 = "tr"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0052
            r3 = 5
            goto L_0x00de
        L_0x005f:
            java.lang.String r3 = "tm"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0052
            r3 = 9
            goto L_0x00de
        L_0x006b:
            java.lang.String r3 = "st"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0052
            r3 = 1
            goto L_0x00de
        L_0x0076:
            java.lang.String r3 = "sr"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0052
            r3 = 10
            goto L_0x00de
        L_0x0081:
            java.lang.String r3 = "sh"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0052
            r3 = 6
            goto L_0x00de
        L_0x008b:
            java.lang.String r3 = "rp"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0052
            r3 = 12
            goto L_0x00de
        L_0x0096:
            java.lang.String r3 = "rc"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0052
            r3 = 8
            goto L_0x00de
        L_0x00a1:
            java.lang.String r3 = "mm"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0052
            r3 = 11
            goto L_0x00de
        L_0x00ac:
            java.lang.String r3 = "gs"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0052
            r3 = 2
            goto L_0x00de
        L_0x00b6:
            java.lang.String r5 = "gr"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x0052
            goto L_0x00de
        L_0x00bf:
            java.lang.String r3 = "gf"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0052
            r3 = 4
            goto L_0x00de
        L_0x00c9:
            java.lang.String r3 = "fl"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0052
            r3 = 3
            goto L_0x00de
        L_0x00d3:
            java.lang.String r3 = "el"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0052
            r3 = 7
            goto L_0x00de
        L_0x00dd:
            r3 = -1
        L_0x00de:
            switch(r3) {
                case 0: goto L_0x0139;
                case 1: goto L_0x0134;
                case 2: goto L_0x012f;
                case 3: goto L_0x012a;
                case 4: goto L_0x0125;
                case 5: goto L_0x0120;
                case 6: goto L_0x011b;
                case 7: goto L_0x0116;
                case 8: goto L_0x0111;
                case 9: goto L_0x010c;
                case 10: goto L_0x0107;
                case 11: goto L_0x00fd;
                case 12: goto L_0x00f8;
                default: goto L_0x00e1;
            }
        L_0x00e1:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unknown shape type "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "LOTTIE"
            android.util.Log.w(r4, r3)
            goto L_0x013e
        L_0x00f8:
            com.airbnb.lottie.c.b.k r2 = com.airbnb.lottie.p094e.C5788C.m10418a(r8, r9)
            goto L_0x013e
        L_0x00fd:
            com.airbnb.lottie.c.b.h r2 = com.airbnb.lottie.p094e.C5819w.m10486a(r8)
            java.lang.String r3 = "Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove()."
            r9.mo18189a(r3)
            goto L_0x013e
        L_0x0107:
            com.airbnb.lottie.c.b.i r2 = com.airbnb.lottie.p094e.C5786A.m10416a(r8, r9)
            goto L_0x013e
        L_0x010c:
            com.airbnb.lottie.c.b.r r2 = com.airbnb.lottie.p094e.C5795J.m10427a(r8, r9)
            goto L_0x013e
        L_0x0111:
            com.airbnb.lottie.c.b.j r2 = com.airbnb.lottie.p094e.C5787B.m10417a(r8, r9)
            goto L_0x013e
        L_0x0116:
            com.airbnb.lottie.c.b.a r2 = com.airbnb.lottie.p094e.C5801e.m10445a(r8, r9, r1)
            goto L_0x013e
        L_0x011b:
            com.airbnb.lottie.c.b.o r2 = com.airbnb.lottie.p094e.C5793H.m10425a(r8, r9)
            goto L_0x013e
        L_0x0120:
            com.airbnb.lottie.c.a.l r2 = com.airbnb.lottie.p094e.C5799c.m10433a(r8, r9)
            goto L_0x013e
        L_0x0125:
            com.airbnb.lottie.c.b.d r2 = com.airbnb.lottie.p094e.C5809m.m10459a(r8, r9)
            goto L_0x013e
        L_0x012a:
            com.airbnb.lottie.c.b.m r2 = com.airbnb.lottie.p094e.C5791F.m10423a(r8, r9)
            goto L_0x013e
        L_0x012f:
            com.airbnb.lottie.c.b.e r2 = com.airbnb.lottie.p094e.C5810n.m10460a(r8, r9)
            goto L_0x013e
        L_0x0134:
            com.airbnb.lottie.c.b.q r2 = com.airbnb.lottie.p094e.C5794I.m10426a(r8, r9)
            goto L_0x013e
        L_0x0139:
            com.airbnb.lottie.c.b.n r2 = com.airbnb.lottie.p094e.C5792G.m10424a(r8, r9)
        L_0x013e:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L_0x0148
            r8.skipValue()
            goto L_0x013e
        L_0x0148:
            r8.endObject()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p094e.C5803g.m10448a(android.util.JsonReader, com.airbnb.lottie.g):com.airbnb.lottie.c.b.b");
    }
}
