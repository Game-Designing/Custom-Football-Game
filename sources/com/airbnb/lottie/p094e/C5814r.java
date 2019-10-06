package com.airbnb.lottie.p094e;

import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.p096g.C5831a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import p002b.p003c.p053g.p061f.C1274r;

/* renamed from: com.airbnb.lottie.e.r */
/* compiled from: KeyframeParser */
class C5814r {

    /* renamed from: a */
    private static final Interpolator f10088a = new LinearInterpolator();

    /* renamed from: b */
    private static C1274r<WeakReference<Interpolator>> f10089b;

    C5814r() {
    }

    /* renamed from: a */
    private static C1274r<WeakReference<Interpolator>> m10470a() {
        if (f10089b == null) {
            f10089b = new C1274r<>();
        }
        return f10089b;
    }

    /* renamed from: a */
    private static WeakReference<Interpolator> m10474a(int hash) {
        WeakReference<Interpolator> weakReference;
        synchronized (C5814r.class) {
            weakReference = (WeakReference) m10470a().mo9175b(hash);
        }
        return weakReference;
    }

    /* renamed from: a */
    private static void m10475a(int hash, WeakReference<Interpolator> interpolator) {
        synchronized (C5814r.class) {
            f10089b.mo9178c(hash, interpolator);
        }
    }

    /* renamed from: a */
    static <T> C5831a<T> m10472a(JsonReader reader, C5830g composition, float scale, C5796K<T> valueParser, boolean animated) throws IOException {
        if (animated) {
            return m10473a(composition, reader, scale, valueParser);
        }
        return m10471a(reader, scale, valueParser);
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cf  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> com.airbnb.lottie.p096g.C5831a<T> m10473a(com.airbnb.lottie.C5830g r19, android.util.JsonReader r20, float r21, com.airbnb.lottie.p094e.C5796K<T> r22) throws java.io.IOException {
        /*
            r1 = r20
            r2 = r21
            r3 = r22
            r0 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r20.beginObject()
            r17 = r5
            r15 = r10
            r14 = r11
            r5 = r4
            r4 = r0
        L_0x0018:
            boolean r0 = r20.hasNext()
            if (r0 == 0) goto L_0x00d8
            java.lang.String r0 = r20.nextName()
            int r11 = r0.hashCode()
            r12 = 101(0x65, float:1.42E-43)
            r13 = 0
            r10 = 1
            if (r11 == r12) goto L_0x008f
            r12 = 111(0x6f, float:1.56E-43)
            if (r11 == r12) goto L_0x0085
            r12 = 3701(0xe75, float:5.186E-42)
            if (r11 == r12) goto L_0x007b
            r12 = 3707(0xe7b, float:5.195E-42)
            if (r11 == r12) goto L_0x0071
            r12 = 104(0x68, float:1.46E-43)
            if (r11 == r12) goto L_0x0067
            r12 = 105(0x69, float:1.47E-43)
            if (r11 == r12) goto L_0x005d
            r12 = 115(0x73, float:1.61E-43)
            if (r11 == r12) goto L_0x0053
            r12 = 116(0x74, float:1.63E-43)
            if (r11 == r12) goto L_0x0049
        L_0x0048:
            goto L_0x0099
        L_0x0049:
            java.lang.String r11 = "t"
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0048
            r0 = 0
            goto L_0x009a
        L_0x0053:
            java.lang.String r11 = "s"
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0048
            r0 = 1
            goto L_0x009a
        L_0x005d:
            java.lang.String r11 = "i"
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0048
            r0 = 4
            goto L_0x009a
        L_0x0067:
            java.lang.String r11 = "h"
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0048
            r0 = 5
            goto L_0x009a
        L_0x0071:
            java.lang.String r11 = "to"
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0048
            r0 = 6
            goto L_0x009a
        L_0x007b:
            java.lang.String r11 = "ti"
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0048
            r0 = 7
            goto L_0x009a
        L_0x0085:
            java.lang.String r11 = "o"
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0048
            r0 = 3
            goto L_0x009a
        L_0x008f:
            java.lang.String r11 = "e"
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0048
            r0 = 2
            goto L_0x009a
        L_0x0099:
            r0 = -1
        L_0x009a:
            switch(r0) {
                case 0: goto L_0x00cf;
                case 1: goto L_0x00c9;
                case 2: goto L_0x00c3;
                case 3: goto L_0x00bd;
                case 4: goto L_0x00b7;
                case 5: goto L_0x00ad;
                case 6: goto L_0x00a7;
                case 7: goto L_0x00a1;
                default: goto L_0x009d;
            }
        L_0x009d:
            r20.skipValue()
            goto L_0x00d6
        L_0x00a1:
            android.graphics.PointF r0 = com.airbnb.lottie.p094e.C5813q.m10464a(r20, r21)
            r14 = r0
            goto L_0x00d6
        L_0x00a7:
            android.graphics.PointF r0 = com.airbnb.lottie.p094e.C5813q.m10464a(r20, r21)
            r15 = r0
            goto L_0x00d6
        L_0x00ad:
            int r0 = r20.nextInt()
            if (r0 != r10) goto L_0x00b4
            r13 = 1
        L_0x00b4:
            r0 = r13
            r8 = r0
            goto L_0x00d6
        L_0x00b7:
            android.graphics.PointF r0 = com.airbnb.lottie.p094e.C5813q.m10464a(r20, r21)
            r5 = r0
            goto L_0x00d6
        L_0x00bd:
            android.graphics.PointF r0 = com.airbnb.lottie.p094e.C5813q.m10464a(r20, r21)
            r4 = r0
            goto L_0x00d6
        L_0x00c3:
            java.lang.Object r0 = r3.mo18142a(r1, r2)
            r7 = r0
            goto L_0x00d6
        L_0x00c9:
            java.lang.Object r0 = r3.mo18142a(r1, r2)
            r6 = r0
            goto L_0x00d6
        L_0x00cf:
            double r10 = r20.nextDouble()
            float r0 = (float) r10
            r17 = r0
        L_0x00d6:
            goto L_0x0018
        L_0x00d8:
            r20.endObject()
            if (r8 == 0) goto L_0x00e6
            r0 = r6
            android.view.animation.Interpolator r7 = f10088a
            r18 = r7
            r7 = r0
            r0 = r18
            goto L_0x014b
        L_0x00e6:
            if (r4 == 0) goto L_0x0149
            if (r5 == 0) goto L_0x0149
            float r0 = r4.x
            float r10 = -r2
            float r0 = com.airbnb.lottie.p095f.C5828e.m10523a(r0, r10, r2)
            r4.x = r0
            float r0 = r4.y
            r10 = 1120403456(0x42c80000, float:100.0)
            r11 = -1027080192(0xffffffffc2c80000, float:-100.0)
            float r0 = com.airbnb.lottie.p095f.C5828e.m10523a(r0, r11, r10)
            r4.y = r0
            float r0 = r5.x
            float r12 = -r2
            float r0 = com.airbnb.lottie.p095f.C5828e.m10523a(r0, r12, r2)
            r5.x = r0
            float r0 = r5.y
            float r0 = com.airbnb.lottie.p095f.C5828e.m10523a(r0, r11, r10)
            r5.y = r0
            float r0 = r4.x
            float r10 = r4.y
            float r11 = r5.x
            float r12 = r5.y
            int r10 = com.airbnb.lottie.p095f.C5829f.m10536a(r0, r10, r11, r12)
            java.lang.ref.WeakReference r11 = m10474a(r10)
            if (r11 == 0) goto L_0x0129
            java.lang.Object r0 = r11.get()
            r9 = r0
            android.view.animation.Interpolator r9 = (android.view.animation.Interpolator) r9
        L_0x0129:
            if (r11 == 0) goto L_0x012d
            if (r9 != 0) goto L_0x0147
        L_0x012d:
            float r0 = r4.x
            float r0 = r0 / r2
            float r12 = r4.y
            float r12 = r12 / r2
            float r13 = r5.x
            float r13 = r13 / r2
            float r1 = r5.y
            float r1 = r1 / r2
            android.view.animation.Interpolator r9 = android.support.p000v4.view.p039b.C0615f.m2854a(r0, r12, r13, r1)
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0146 }
            r0.<init>(r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0146 }
            m10475a(r10, r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0146 }
            goto L_0x0147
        L_0x0146:
            r0 = move-exception
        L_0x0147:
            r0 = r9
            goto L_0x014b
        L_0x0149:
            android.view.animation.Interpolator r0 = f10088a
        L_0x014b:
            com.airbnb.lottie.g.a r1 = new com.airbnb.lottie.g.a
            r16 = 0
            r10 = r1
            r11 = r19
            r12 = r6
            r13 = r7
            r9 = r14
            r14 = r0
            r2 = r15
            r15 = r17
            r10.<init>(r11, r12, r13, r14, r15, r16)
            r1.f10131i = r2
            r1.f10132j = r9
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p094e.C5814r.m10473a(com.airbnb.lottie.g, android.util.JsonReader, float, com.airbnb.lottie.e.K):com.airbnb.lottie.g.a");
    }

    /* renamed from: a */
    private static <T> C5831a<T> m10471a(JsonReader reader, float scale, C5796K<T> valueParser) throws IOException {
        return new C5831a<>(valueParser.mo18142a(reader, scale));
    }
}
