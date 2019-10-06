package com.airbnb.lottie.p094e;

import android.graphics.Rect;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.p089c.p090a.C5731l;
import com.airbnb.lottie.p089c.p092c.C5766g;
import com.airbnb.lottie.p089c.p092c.C5766g.C5767a;
import com.airbnb.lottie.p089c.p092c.C5766g.C5768b;
import java.util.Collections;
import java.util.List;

/* renamed from: com.airbnb.lottie.e.t */
/* compiled from: LayerParser */
public class C5816t {
    /* renamed from: a */
    public static C5766g m10479a(C5830g composition) {
        C5830g gVar = composition;
        Rect bounds = composition.mo18186a();
        List emptyList = Collections.emptyList();
        C5767a aVar = C5767a.PreComp;
        List emptyList2 = Collections.emptyList();
        C5731l lVar = r3;
        C5731l lVar2 = new C5731l();
        C5766g gVar2 = new C5766g(emptyList, gVar, "__container", -1, aVar, -1, null, emptyList2, lVar, 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), null, null, Collections.emptyList(), C5768b.None, null);
        return gVar2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02a6  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.airbnb.lottie.p089c.p092c.C5766g m10478a(android.util.JsonReader r57, com.airbnb.lottie.C5830g r58) throws java.io.IOException {
        /*
            r15 = r58
            java.lang.String r0 = "UNSET"
            r1 = 0
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = -1
            r12 = 1065353216(0x3f800000, float:1.0)
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            com.airbnb.lottie.c.c.g$b r18 = com.airbnb.lottie.p089c.p092c.C5766g.C5768b.None
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            java.util.ArrayList r23 = new java.util.ArrayList
            r23.<init>()
            r37 = r23
            java.util.ArrayList r23 = new java.util.ArrayList
            r23.<init>()
            r38 = r23
            r57.beginObject()
            r54 = r1
            r40 = r2
            r41 = r3
            r43 = r5
            r44 = r6
            r45 = r7
            r46 = r8
            r47 = r9
            r48 = r10
            r39 = r12
            r50 = r13
            r11 = r17
            r51 = r18
            r52 = r19
            r55 = r20
            r56 = r21
            r53 = r22
            r13 = r0
        L_0x0055:
            boolean r0 = r57.hasNext()
            if (r0 == 0) goto L_0x03a5
            java.lang.String r0 = r57.nextName()
            int r1 = r0.hashCode()
            java.lang.String r2 = "nm"
            r3 = 1
            r4 = -1
            r5 = 0
            switch(r1) {
                case -995424086: goto L_0x0158;
                case -903568142: goto L_0x014d;
                case 104: goto L_0x0142;
                case 116: goto L_0x0137;
                case 119: goto L_0x012c;
                case 3177: goto L_0x0121;
                case 3233: goto L_0x0116;
                case 3367: goto L_0x010b;
                case 3432: goto L_0x0100;
                case 3519: goto L_0x00f7;
                case 3553: goto L_0x00eb;
                case 3664: goto L_0x00e0;
                case 3669: goto L_0x00d5;
                case 3679: goto L_0x00c9;
                case 3681: goto L_0x00bd;
                case 3684: goto L_0x00b2;
                case 3705: goto L_0x00a6;
                case 3712: goto L_0x009a;
                case 3717: goto L_0x008f;
                case 104415: goto L_0x0084;
                case 108390670: goto L_0x0079;
                case 1441620890: goto L_0x006d;
                default: goto L_0x006b;
            }
        L_0x006b:
            goto L_0x0162
        L_0x006d:
            java.lang.String r1 = "masksProperties"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 10
            goto L_0x0163
        L_0x0079:
            java.lang.String r1 = "refId"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 2
            goto L_0x0163
        L_0x0084:
            java.lang.String r1 = "ind"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 1
            goto L_0x0163
        L_0x008f:
            java.lang.String r1 = "ty"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 3
            goto L_0x0163
        L_0x009a:
            java.lang.String r1 = "tt"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 9
            goto L_0x0163
        L_0x00a6:
            java.lang.String r1 = "tm"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 20
            goto L_0x0163
        L_0x00b2:
            java.lang.String r1 = "sw"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 5
            goto L_0x0163
        L_0x00bd:
            java.lang.String r1 = "st"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 15
            goto L_0x0163
        L_0x00c9:
            java.lang.String r1 = "sr"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 14
            goto L_0x0163
        L_0x00d5:
            java.lang.String r1 = "sh"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 6
            goto L_0x0163
        L_0x00e0:
            java.lang.String r1 = "sc"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 7
            goto L_0x0163
        L_0x00eb:
            java.lang.String r1 = "op"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 19
            goto L_0x0163
        L_0x00f7:
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x006b
            r0 = 0
            goto L_0x0163
        L_0x0100:
            java.lang.String r1 = "ks"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 8
            goto L_0x0163
        L_0x010b:
            java.lang.String r1 = "ip"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 18
            goto L_0x0163
        L_0x0116:
            java.lang.String r1 = "ef"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 13
            goto L_0x0163
        L_0x0121:
            java.lang.String r1 = "cl"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 21
            goto L_0x0163
        L_0x012c:
            java.lang.String r1 = "w"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 16
            goto L_0x0163
        L_0x0137:
            java.lang.String r1 = "t"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 12
            goto L_0x0163
        L_0x0142:
            java.lang.String r1 = "h"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 17
            goto L_0x0163
        L_0x014d:
            java.lang.String r1 = "shapes"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 11
            goto L_0x0163
        L_0x0158:
            java.lang.String r1 = "parent"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r0 = 4
            goto L_0x0163
        L_0x0162:
            r0 = -1
        L_0x0163:
            switch(r0) {
                case 0: goto L_0x0394;
                case 1: goto L_0x0386;
                case 2: goto L_0x037b;
                case 3: goto L_0x035f;
                case 4: goto L_0x0351;
                case 5: goto L_0x033c;
                case 6: goto L_0x0326;
                case 7: goto L_0x0316;
                case 8: goto L_0x030a;
                case 9: goto L_0x02f8;
                case 10: goto L_0x02da;
                case 11: goto L_0x02b5;
                case 12: goto L_0x0250;
                case 13: goto L_0x01f1;
                case 14: goto L_0x01e2;
                case 15: goto L_0x01d3;
                case 16: goto L_0x01bd;
                case 17: goto L_0x01a7;
                case 18: goto L_0x0199;
                case 19: goto L_0x018a;
                case 20: goto L_0x017e;
                case 21: goto L_0x0171;
                default: goto L_0x0166;
            }
        L_0x0166:
            r10 = r57
            r8 = r37
            r9 = r38
            r57.skipValue()
            goto L_0x039f
        L_0x0171:
            java.lang.String r0 = r57.nextString()
            r10 = r57
            r11 = r0
            r8 = r37
            r9 = r38
            goto L_0x039f
        L_0x017e:
            r10 = r57
            com.airbnb.lottie.c.a.b r53 = com.airbnb.lottie.p094e.C5800d.m10435a(r10, r15, r5)
            r8 = r37
            r9 = r38
            goto L_0x039f
        L_0x018a:
            r10 = r57
            double r0 = r57.nextDouble()
            float r0 = (float) r0
            r16 = r0
            r8 = r37
            r9 = r38
            goto L_0x039f
        L_0x0199:
            r10 = r57
            double r0 = r57.nextDouble()
            float r0 = (float) r0
            r14 = r0
            r8 = r37
            r9 = r38
            goto L_0x039f
        L_0x01a7:
            r10 = r57
            int r0 = r57.nextInt()
            float r0 = (float) r0
            float r1 = com.airbnb.lottie.p095f.C5829f.m10534a()
            float r0 = r0 * r1
            int r0 = (int) r0
            r47 = r0
            r8 = r37
            r9 = r38
            goto L_0x039f
        L_0x01bd:
            r10 = r57
            int r0 = r57.nextInt()
            float r0 = (float) r0
            float r1 = com.airbnb.lottie.p095f.C5829f.m10534a()
            float r0 = r0 * r1
            int r0 = (int) r0
            r46 = r0
            r8 = r37
            r9 = r38
            goto L_0x039f
        L_0x01d3:
            r10 = r57
            double r0 = r57.nextDouble()
            float r0 = (float) r0
            r50 = r0
            r8 = r37
            r9 = r38
            goto L_0x039f
        L_0x01e2:
            r10 = r57
            double r0 = r57.nextDouble()
            float r0 = (float) r0
            r39 = r0
            r8 = r37
            r9 = r38
            goto L_0x039f
        L_0x01f1:
            r10 = r57
            r57.beginArray()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x01fb:
            boolean r1 = r57.hasNext()
            if (r1 == 0) goto L_0x0233
            r57.beginObject()
        L_0x0204:
            boolean r1 = r57.hasNext()
            if (r1 == 0) goto L_0x022f
            java.lang.String r1 = r57.nextName()
            int r3 = r1.hashCode()
            r6 = 3519(0xdbf, float:4.931E-42)
            if (r3 == r6) goto L_0x0217
        L_0x0216:
            goto L_0x021f
        L_0x0217:
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0216
            r1 = 0
            goto L_0x0220
        L_0x021f:
            r1 = -1
        L_0x0220:
            if (r1 == 0) goto L_0x0226
            r57.skipValue()
            goto L_0x022e
        L_0x0226:
            java.lang.String r1 = r57.nextString()
            r0.add(r1)
        L_0x022e:
            goto L_0x0204
        L_0x022f:
            r57.endObject()
            goto L_0x01fb
        L_0x0233:
            r57.endArray()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r15.mo18189a(r1)
            r8 = r37
            r9 = r38
            goto L_0x039f
        L_0x0250:
            r10 = r57
            r57.beginObject()
        L_0x0255:
            boolean r0 = r57.hasNext()
            if (r0 == 0) goto L_0x02ac
            java.lang.String r0 = r57.nextName()
            int r1 = r0.hashCode()
            r2 = 97
            if (r1 == r2) goto L_0x0276
            r2 = 100
            if (r1 == r2) goto L_0x026c
        L_0x026b:
            goto L_0x0280
        L_0x026c:
            java.lang.String r1 = "d"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x026b
            r0 = 0
            goto L_0x0281
        L_0x0276:
            java.lang.String r1 = "a"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x026b
            r0 = 1
            goto L_0x0281
        L_0x0280:
            r0 = -1
        L_0x0281:
            if (r0 == 0) goto L_0x02a6
            if (r0 == r3) goto L_0x0289
            r57.skipValue()
            goto L_0x02ab
        L_0x0289:
            r57.beginArray()
            boolean r0 = r57.hasNext()
            if (r0 == 0) goto L_0x0298
            com.airbnb.lottie.c.a.k r0 = com.airbnb.lottie.p094e.C5798b.m10431a(r57, r58)
            r56 = r0
        L_0x0298:
            boolean r0 = r57.hasNext()
            if (r0 == 0) goto L_0x02a2
            r57.skipValue()
            goto L_0x0298
        L_0x02a2:
            r57.endArray()
            goto L_0x02ab
        L_0x02a6:
            com.airbnb.lottie.c.a.j r55 = com.airbnb.lottie.p094e.C5800d.m10439b(r57, r58)
        L_0x02ab:
            goto L_0x0255
        L_0x02ac:
            r57.endObject()
            r8 = r37
            r9 = r38
            goto L_0x039f
        L_0x02b5:
            r10 = r57
            r57.beginArray()
        L_0x02ba:
            boolean r0 = r57.hasNext()
            if (r0 == 0) goto L_0x02d1
            com.airbnb.lottie.c.b.b r0 = com.airbnb.lottie.p094e.C5803g.m10448a(r57, r58)
            if (r0 == 0) goto L_0x02cc
            r9 = r38
            r9.add(r0)
            goto L_0x02ce
        L_0x02cc:
            r9 = r38
        L_0x02ce:
            r38 = r9
            goto L_0x02ba
        L_0x02d1:
            r9 = r38
            r57.endArray()
            r8 = r37
            goto L_0x039f
        L_0x02da:
            r10 = r57
            r9 = r38
            r57.beginArray()
        L_0x02e1:
            boolean r0 = r57.hasNext()
            if (r0 == 0) goto L_0x02f1
            com.airbnb.lottie.c.b.g r0 = com.airbnb.lottie.p094e.C5818v.m10485a(r57, r58)
            r8 = r37
            r8.add(r0)
            goto L_0x02e1
        L_0x02f1:
            r8 = r37
            r57.endArray()
            goto L_0x039f
        L_0x02f8:
            r10 = r57
            r8 = r37
            r9 = r38
            com.airbnb.lottie.c.c.g$b[] r0 = com.airbnb.lottie.p089c.p092c.C5766g.C5768b.values()
            int r1 = r57.nextInt()
            r51 = r0[r1]
            goto L_0x039f
        L_0x030a:
            r10 = r57
            r8 = r37
            r9 = r38
            com.airbnb.lottie.c.a.l r52 = com.airbnb.lottie.p094e.C5799c.m10433a(r57, r58)
            goto L_0x039f
        L_0x0316:
            r10 = r57
            r8 = r37
            r9 = r38
            java.lang.String r0 = r57.nextString()
            int r45 = android.graphics.Color.parseColor(r0)
            goto L_0x039f
        L_0x0326:
            r10 = r57
            r8 = r37
            r9 = r38
            int r0 = r57.nextInt()
            float r0 = (float) r0
            float r1 = com.airbnb.lottie.p095f.C5829f.m10534a()
            float r0 = r0 * r1
            int r0 = (int) r0
            r44 = r0
            goto L_0x039f
        L_0x033c:
            r10 = r57
            r8 = r37
            r9 = r38
            int r0 = r57.nextInt()
            float r0 = (float) r0
            float r1 = com.airbnb.lottie.p095f.C5829f.m10534a()
            float r0 = r0 * r1
            int r0 = (int) r0
            r43 = r0
            goto L_0x039f
        L_0x0351:
            r10 = r57
            r8 = r37
            r9 = r38
            int r0 = r57.nextInt()
            long r0 = (long) r0
            r48 = r0
            goto L_0x039f
        L_0x035f:
            r10 = r57
            r8 = r37
            r9 = r38
            int r0 = r57.nextInt()
            com.airbnb.lottie.c.c.g$a r1 = com.airbnb.lottie.p089c.p092c.C5766g.C5767a.Unknown
            int r1 = r1.ordinal()
            if (r0 >= r1) goto L_0x0378
            com.airbnb.lottie.c.c.g$a[] r1 = com.airbnb.lottie.p089c.p092c.C5766g.C5767a.values()
            r54 = r1[r0]
            goto L_0x039f
        L_0x0378:
            com.airbnb.lottie.c.c.g$a r54 = com.airbnb.lottie.p089c.p092c.C5766g.C5767a.Unknown
            goto L_0x039f
        L_0x037b:
            r10 = r57
            r8 = r37
            r9 = r38
            java.lang.String r40 = r57.nextString()
            goto L_0x039f
        L_0x0386:
            r10 = r57
            r8 = r37
            r9 = r38
            int r0 = r57.nextInt()
            long r0 = (long) r0
            r41 = r0
            goto L_0x039f
        L_0x0394:
            r10 = r57
            r8 = r37
            r9 = r38
            java.lang.String r13 = r57.nextString()
        L_0x039f:
            r37 = r8
            r38 = r9
            goto L_0x0055
        L_0x03a5:
            r10 = r57
            r8 = r37
            r9 = r38
            r57.endObject()
            float r37 = r14 / r39
            float r16 = r16 / r39
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r14 = r0
            r7 = 0
            int r0 = (r37 > r7 ? 1 : (r37 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x03d6
            com.airbnb.lottie.g.a r12 = new com.airbnb.lottie.g.a
            java.lang.Float r2 = java.lang.Float.valueOf(r7)
            java.lang.Float r3 = java.lang.Float.valueOf(r7)
            r4 = 0
            r5 = 0
            java.lang.Float r6 = java.lang.Float.valueOf(r37)
            r0 = r12
            r1 = r58
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r14.add(r0)
        L_0x03d6:
            int r0 = (r16 > r7 ? 1 : (r16 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x03dd
            r12 = r16
            goto L_0x03e2
        L_0x03dd:
            float r0 = r58.mo18195e()
            r12 = r0
        L_0x03e2:
            com.airbnb.lottie.g.a r16 = new com.airbnb.lottie.g.a
            r0 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r2 = java.lang.Float.valueOf(r0)
            java.lang.Float r3 = java.lang.Float.valueOf(r0)
            r4 = 0
            java.lang.Float r6 = java.lang.Float.valueOf(r12)
            r0 = r16
            r1 = r58
            r5 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r14.add(r0)
            com.airbnb.lottie.g.a r1 = new com.airbnb.lottie.g.a
            java.lang.Float r2 = java.lang.Float.valueOf(r7)
            java.lang.Float r3 = java.lang.Float.valueOf(r7)
            r5 = 2139095039(0x7f7fffff, float:3.4028235E38)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r7 = r1
            r6 = r8
            r8 = r58
            r38 = r9
            r9 = r2
            r10 = r3
            r2 = r11
            r11 = r4
            r3 = r13
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13)
            r14.add(r1)
            java.lang.String r4 = ".ai"
            boolean r4 = r3.endsWith(r4)
            if (r4 != 0) goto L_0x0432
            java.lang.String r4 = "ai"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L_0x0437
        L_0x0432:
            java.lang.String r4 = "Convert your Illustrator layers to shape layers."
            r15.mo18189a(r4)
        L_0x0437:
            com.airbnb.lottie.c.c.g r4 = new com.airbnb.lottie.c.c.g
            r13 = r4
            r5 = r14
            r14 = r38
            r15 = r58
            r16 = r3
            r17 = r41
            r19 = r54
            r20 = r48
            r22 = r40
            r23 = r6
            r24 = r52
            r25 = r43
            r26 = r44
            r27 = r45
            r28 = r39
            r29 = r50
            r30 = r46
            r31 = r47
            r32 = r55
            r33 = r56
            r34 = r5
            r35 = r51
            r36 = r53
            r13.<init>(r14, r15, r16, r17, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p094e.C5816t.m10478a(android.util.JsonReader, com.airbnb.lottie.g):com.airbnb.lottie.c.c.g");
    }
}
