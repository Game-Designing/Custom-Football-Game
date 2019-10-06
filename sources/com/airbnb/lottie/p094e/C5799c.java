package com.airbnb.lottie.p094e;

/* renamed from: com.airbnb.lottie.e.c */
/* compiled from: AnimatableTransformParser */
public class C5799c {
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c9  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.airbnb.lottie.p089c.p090a.C5731l m10433a(android.util.JsonReader r21, com.airbnb.lottie.C5830g r22) throws java.io.IOException {
        /*
            r0 = r21
            r1 = r22
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.util.JsonToken r9 = r21.peek()
            android.util.JsonToken r10 = android.util.JsonToken.BEGIN_OBJECT
            r11 = 1
            r12 = 0
            if (r9 != r10) goto L_0x0017
            r9 = 1
            goto L_0x0018
        L_0x0017:
            r9 = 0
        L_0x0018:
            if (r9 == 0) goto L_0x001d
            r21.beginObject()
        L_0x001d:
            boolean r10 = r21.hasNext()
            if (r10 == 0) goto L_0x00ed
            java.lang.String r10 = r21.nextName()
            r13 = -1
            int r14 = r10.hashCode()
            r15 = 97
            if (r14 == r15) goto L_0x0093
            r15 = 3242(0xcaa, float:4.543E-42)
            if (r14 == r15) goto L_0x0089
            r15 = 3656(0xe48, float:5.123E-42)
            if (r14 == r15) goto L_0x007f
            r15 = 3676(0xe5c, float:5.151E-42)
            if (r14 == r15) goto L_0x0075
            r15 = 111(0x6f, float:1.56E-43)
            if (r14 == r15) goto L_0x006b
            r15 = 112(0x70, float:1.57E-43)
            if (r14 == r15) goto L_0x0061
            r15 = 114(0x72, float:1.6E-43)
            if (r14 == r15) goto L_0x0057
            r15 = 115(0x73, float:1.61E-43)
            if (r14 == r15) goto L_0x004d
        L_0x004c:
            goto L_0x009d
        L_0x004d:
            java.lang.String r14 = "s"
            boolean r10 = r10.equals(r14)
            if (r10 == 0) goto L_0x004c
            r10 = 2
            goto L_0x009e
        L_0x0057:
            java.lang.String r14 = "r"
            boolean r10 = r10.equals(r14)
            if (r10 == 0) goto L_0x004c
            r10 = 4
            goto L_0x009e
        L_0x0061:
            java.lang.String r14 = "p"
            boolean r10 = r10.equals(r14)
            if (r10 == 0) goto L_0x004c
            r10 = 1
            goto L_0x009e
        L_0x006b:
            java.lang.String r14 = "o"
            boolean r10 = r10.equals(r14)
            if (r10 == 0) goto L_0x004c
            r10 = 5
            goto L_0x009e
        L_0x0075:
            java.lang.String r14 = "so"
            boolean r10 = r10.equals(r14)
            if (r10 == 0) goto L_0x004c
            r10 = 6
            goto L_0x009e
        L_0x007f:
            java.lang.String r14 = "rz"
            boolean r10 = r10.equals(r14)
            if (r10 == 0) goto L_0x004c
            r10 = 3
            goto L_0x009e
        L_0x0089:
            java.lang.String r14 = "eo"
            boolean r10 = r10.equals(r14)
            if (r10 == 0) goto L_0x004c
            r10 = 7
            goto L_0x009e
        L_0x0093:
            java.lang.String r14 = "a"
            boolean r10 = r10.equals(r14)
            if (r10 == 0) goto L_0x004c
            r10 = 0
            goto L_0x009e
        L_0x009d:
            r10 = -1
        L_0x009e:
            switch(r10) {
                case 0: goto L_0x00c9;
                case 1: goto L_0x00c3;
                case 2: goto L_0x00be;
                case 3: goto L_0x00b4;
                case 4: goto L_0x00b9;
                case 5: goto L_0x00af;
                case 6: goto L_0x00aa;
                case 7: goto L_0x00a5;
                default: goto L_0x00a1;
            }
        L_0x00a1:
            r21.skipValue()
            goto L_0x00eb
        L_0x00a5:
            com.airbnb.lottie.c.a.b r8 = com.airbnb.lottie.p094e.C5800d.m10435a(r0, r1, r12)
            goto L_0x00eb
        L_0x00aa:
            com.airbnb.lottie.c.a.b r7 = com.airbnb.lottie.p094e.C5800d.m10435a(r0, r1, r12)
            goto L_0x00eb
        L_0x00af:
            com.airbnb.lottie.c.a.d r6 = com.airbnb.lottie.p094e.C5800d.m10441d(r21, r22)
            goto L_0x00eb
        L_0x00b4:
            java.lang.String r10 = "Lottie doesn't support 3D layers."
            r1.mo18189a(r10)
        L_0x00b9:
            com.airbnb.lottie.c.a.b r5 = com.airbnb.lottie.p094e.C5800d.m10435a(r0, r1, r12)
            goto L_0x00eb
        L_0x00be:
            com.airbnb.lottie.c.a.g r4 = com.airbnb.lottie.p094e.C5800d.m10443f(r21, r22)
            goto L_0x00eb
        L_0x00c3:
            com.airbnb.lottie.c.a.m r3 = com.airbnb.lottie.p094e.C5797a.m10430b(r21, r22)
            goto L_0x00eb
        L_0x00c9:
            r21.beginObject()
        L_0x00cc:
            boolean r10 = r21.hasNext()
            if (r10 == 0) goto L_0x00e7
            java.lang.String r10 = r21.nextName()
            java.lang.String r13 = "k"
            boolean r10 = r10.equals(r13)
            if (r10 == 0) goto L_0x00e3
            com.airbnb.lottie.c.a.e r2 = com.airbnb.lottie.p094e.C5797a.m10429a(r21, r22)
            goto L_0x00cc
        L_0x00e3:
            r21.skipValue()
            goto L_0x00cc
        L_0x00e7:
            r21.endObject()
        L_0x00eb:
            goto L_0x001d
        L_0x00ed:
            if (r9 == 0) goto L_0x00f2
            r21.endObject()
        L_0x00f2:
            if (r2 != 0) goto L_0x0101
            java.lang.String r10 = "LOTTIE"
            java.lang.String r11 = "Layer has no transform property. You may be using an unsupported layer type such as a camera."
            android.util.Log.w(r10, r11)
            com.airbnb.lottie.c.a.e r10 = new com.airbnb.lottie.c.a.e
            r10.<init>()
            r2 = r10
        L_0x0101:
            if (r4 != 0) goto L_0x0110
            com.airbnb.lottie.c.a.g r10 = new com.airbnb.lottie.c.a.g
            com.airbnb.lottie.g.d r11 = new com.airbnb.lottie.g.d
            r12 = 1065353216(0x3f800000, float:1.0)
            r11.<init>(r12, r12)
            r10.<init>(r11)
            r4 = r10
        L_0x0110:
            if (r6 != 0) goto L_0x0118
            com.airbnb.lottie.c.a.d r10 = new com.airbnb.lottie.c.a.d
            r10.<init>()
            r6 = r10
        L_0x0118:
            com.airbnb.lottie.c.a.l r10 = new com.airbnb.lottie.c.a.l
            r13 = r10
            r14 = r2
            r15 = r3
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
            r13.<init>(r14, r15, r16, r17, r18, r19, r20)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p094e.C5799c.m10433a(android.util.JsonReader, com.airbnb.lottie.g):com.airbnb.lottie.c.a.l");
    }
}
