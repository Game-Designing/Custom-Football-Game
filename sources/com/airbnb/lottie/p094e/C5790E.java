package com.airbnb.lottie.p094e;

import com.airbnb.lottie.p089c.p091b.C5749l;

/* renamed from: com.airbnb.lottie.e.E */
/* compiled from: ShapeDataParser */
public class C5790E implements C5796K<C5749l> {

    /* renamed from: a */
    public static final C5790E f10081a = new C5790E();

    private C5790E() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005a, code lost:
        if (r4.equals("c") != false) goto L_0x005e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0076  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.airbnb.lottie.p089c.p091b.C5749l m10422a(android.util.JsonReader r17, float r18) throws java.io.IOException {
        /*
            r16 = this;
            android.util.JsonToken r0 = r17.peek()
            android.util.JsonToken r1 = android.util.JsonToken.BEGIN_ARRAY
            if (r0 != r1) goto L_0x000b
            r17.beginArray()
        L_0x000b:
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r17.beginObject()
        L_0x0012:
            boolean r4 = r17.hasNext()
            r5 = 0
            if (r4 == 0) goto L_0x007c
            java.lang.String r4 = r17.nextName()
            r6 = -1
            int r7 = r4.hashCode()
            r8 = 99
            r9 = 3
            r10 = 2
            r11 = 1
            if (r7 == r8) goto L_0x0054
            r5 = 105(0x69, float:1.47E-43)
            if (r7 == r5) goto L_0x004a
            r5 = 111(0x6f, float:1.56E-43)
            if (r7 == r5) goto L_0x0040
            r5 = 118(0x76, float:1.65E-43)
            if (r7 == r5) goto L_0x0036
        L_0x0035:
            goto L_0x005d
        L_0x0036:
            java.lang.String r5 = "v"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0035
            r5 = 1
            goto L_0x005e
        L_0x0040:
            java.lang.String r5 = "o"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0035
            r5 = 3
            goto L_0x005e
        L_0x004a:
            java.lang.String r5 = "i"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0035
            r5 = 2
            goto L_0x005e
        L_0x0054:
            java.lang.String r7 = "c"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x0035
            goto L_0x005e
        L_0x005d:
            r5 = -1
        L_0x005e:
            if (r5 == 0) goto L_0x0076
            if (r5 == r11) goto L_0x0071
            if (r5 == r10) goto L_0x006c
            if (r5 == r9) goto L_0x0067
            goto L_0x007b
        L_0x0067:
            java.util.List r3 = com.airbnb.lottie.p094e.C5813q.m10466b(r17, r18)
            goto L_0x007b
        L_0x006c:
            java.util.List r2 = com.airbnb.lottie.p094e.C5813q.m10466b(r17, r18)
            goto L_0x007b
        L_0x0071:
            java.util.List r1 = com.airbnb.lottie.p094e.C5813q.m10466b(r17, r18)
            goto L_0x007b
        L_0x0076:
            boolean r0 = r17.nextBoolean()
        L_0x007b:
            goto L_0x0012
        L_0x007c:
            r17.endObject()
            android.util.JsonToken r4 = r17.peek()
            android.util.JsonToken r6 = android.util.JsonToken.END_ARRAY
            if (r4 != r6) goto L_0x008a
            r17.endArray()
        L_0x008a:
            if (r1 == 0) goto L_0x011d
            if (r2 == 0) goto L_0x011d
            if (r3 == 0) goto L_0x011d
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L_0x00a5
            com.airbnb.lottie.c.b.l r4 = new com.airbnb.lottie.c.b.l
            android.graphics.PointF r6 = new android.graphics.PointF
            r6.<init>()
            java.util.List r7 = java.util.Collections.emptyList()
            r4.<init>(r6, r5, r7)
            return r4
        L_0x00a5:
            int r4 = r1.size()
            java.lang.Object r6 = r1.get(r5)
            android.graphics.PointF r6 = (android.graphics.PointF) r6
            r7 = r6
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>(r4)
            r9 = 1
        L_0x00b6:
            if (r9 >= r4) goto L_0x00e8
            java.lang.Object r10 = r1.get(r9)
            r6 = r10
            android.graphics.PointF r6 = (android.graphics.PointF) r6
            int r10 = r9 + -1
            java.lang.Object r10 = r1.get(r10)
            android.graphics.PointF r10 = (android.graphics.PointF) r10
            int r11 = r9 + -1
            java.lang.Object r11 = r3.get(r11)
            android.graphics.PointF r11 = (android.graphics.PointF) r11
            java.lang.Object r12 = r2.get(r9)
            android.graphics.PointF r12 = (android.graphics.PointF) r12
            android.graphics.PointF r13 = com.airbnb.lottie.p095f.C5828e.m10528a(r10, r11)
            android.graphics.PointF r14 = com.airbnb.lottie.p095f.C5828e.m10528a(r6, r12)
            com.airbnb.lottie.c.a r15 = new com.airbnb.lottie.c.a
            r15.<init>(r13, r14, r6)
            r8.add(r15)
            int r9 = r9 + 1
            goto L_0x00b6
        L_0x00e8:
            if (r0 == 0) goto L_0x0117
            java.lang.Object r9 = r1.get(r5)
            r6 = r9
            android.graphics.PointF r6 = (android.graphics.PointF) r6
            int r9 = r4 + -1
            java.lang.Object r9 = r1.get(r9)
            android.graphics.PointF r9 = (android.graphics.PointF) r9
            int r10 = r4 + -1
            java.lang.Object r10 = r3.get(r10)
            android.graphics.PointF r10 = (android.graphics.PointF) r10
            java.lang.Object r5 = r2.get(r5)
            android.graphics.PointF r5 = (android.graphics.PointF) r5
            android.graphics.PointF r11 = com.airbnb.lottie.p095f.C5828e.m10528a(r9, r10)
            android.graphics.PointF r12 = com.airbnb.lottie.p095f.C5828e.m10528a(r6, r5)
            com.airbnb.lottie.c.a r13 = new com.airbnb.lottie.c.a
            r13.<init>(r11, r12, r6)
            r8.add(r13)
        L_0x0117:
            com.airbnb.lottie.c.b.l r5 = new com.airbnb.lottie.c.b.l
            r5.<init>(r7, r0, r8)
            return r5
        L_0x011d:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Shape data was missing information."
            r4.<init>(r5)
            goto L_0x0126
        L_0x0125:
            throw r4
        L_0x0126:
            goto L_0x0125
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p094e.C5790E.m10422a(android.util.JsonReader, float):com.airbnb.lottie.c.b.l");
    }
}
