package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.internal.ads.zzpo.zza;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.gms.internal.ads.ks */
final class C9547ks {

    /* renamed from: a */
    private static final int f22695a = zzsy.m31156b("vide");

    /* renamed from: b */
    private static final int f22696b = zzsy.m31156b("soun");

    /* renamed from: c */
    private static final int f22697c = zzsy.m31156b(CommandHandler.TEXT);

    /* renamed from: d */
    private static final int f22698d = zzsy.m31156b("sbtl");

    /* renamed from: e */
    private static final int f22699e = zzsy.m31156b("subt");

    /* renamed from: f */
    private static final int f22700f = zzsy.m31156b("clcp");

    /* renamed from: g */
    private static final int f22701g = zzsy.m31156b("cenc");

    /* renamed from: h */
    private static final int f22702h = zzsy.m31156b("meta");

    /* JADX WARNING: Removed duplicated region for block: B:391:0x0771 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x0772  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzpa m23838a(com.google.android.gms.internal.ads.C9503is r43, com.google.android.gms.internal.ads.C9525js r44, long r45, com.google.android.gms.internal.ads.zzne r47, boolean r48) throws com.google.android.gms.internal.ads.zzlm {
        /*
            r0 = r43
            int r1 = com.google.android.gms.internal.ads.C9481hs.f22439E
            com.google.android.gms.internal.ads.is r1 = r0.mo29011e(r1)
            int r2 = com.google.android.gms.internal.ads.C9481hs.f22464S
            com.google.android.gms.internal.ads.js r2 = r1.mo29010d(r2)
            com.google.android.gms.internal.ads.zzst r2 = r2.f22630Qa
            r3 = 16
            r2.mo32199b(r3)
            int r2 = r2.mo32202d()
            int r4 = f22696b
            r5 = 4
            r6 = 3
            r8 = -1
            if (r2 != r4) goto L_0x0022
            r12 = 1
            goto L_0x0042
        L_0x0022:
            int r4 = f22695a
            if (r2 != r4) goto L_0x0028
            r12 = 2
            goto L_0x0042
        L_0x0028:
            int r4 = f22697c
            if (r2 == r4) goto L_0x0041
            int r4 = f22698d
            if (r2 == r4) goto L_0x0041
            int r4 = f22699e
            if (r2 == r4) goto L_0x0041
            int r4 = f22700f
            if (r2 != r4) goto L_0x0039
            goto L_0x0041
        L_0x0039:
            int r4 = f22702h
            if (r2 != r4) goto L_0x003f
            r12 = 4
            goto L_0x0042
        L_0x003f:
            r12 = -1
            goto L_0x0042
        L_0x0041:
            r12 = 3
        L_0x0042:
            r2 = 0
            if (r12 != r8) goto L_0x0047
            return r2
        L_0x0047:
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22459O
            com.google.android.gms.internal.ads.js r4 = r0.mo29010d(r4)
            com.google.android.gms.internal.ads.zzst r4 = r4.f22630Qa
            r10 = 8
            r4.mo32199b(r10)
            int r11 = r4.mo32202d()
            int r11 = com.google.android.gms.internal.ads.C9481hs.m23682b(r11)
            if (r11 != 0) goto L_0x0061
            r13 = 8
            goto L_0x0063
        L_0x0061:
            r13 = 16
        L_0x0063:
            r4.mo32201c(r13)
            int r13 = r4.mo32202d()
            r4.mo32201c(r5)
            int r14 = r4.mo32198b()
            if (r11 != 0) goto L_0x0076
            r15 = 4
            goto L_0x0078
        L_0x0076:
            r15 = 8
        L_0x0078:
            r9 = 0
        L_0x0079:
            if (r9 >= r15) goto L_0x0089
            byte[] r7 = r4.f29334a
            int r16 = r14 + r9
            byte r7 = r7[r16]
            if (r7 == r8) goto L_0x0086
            r7 = 0
            goto L_0x008a
        L_0x0086:
            int r9 = r9 + 1
            goto L_0x0079
        L_0x0089:
            r7 = 1
        L_0x008a:
            r16 = 0
            r18 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r7 == 0) goto L_0x0099
            r4.mo32201c(r15)
            r14 = r18
            goto L_0x00aa
        L_0x0099:
            if (r11 != 0) goto L_0x00a0
            long r14 = r4.mo32210j()
            goto L_0x00a4
        L_0x00a0:
            long r14 = r4.mo32213m()
        L_0x00a4:
            int r7 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r7 != 0) goto L_0x00aa
            r14 = r18
        L_0x00aa:
            r4.mo32201c(r3)
            int r7 = r4.mo32202d()
            int r9 = r4.mo32202d()
            r4.mo32201c(r5)
            int r11 = r4.mo32202d()
            int r4 = r4.mo32202d()
            r5 = -65536(0xffffffffffff0000, float:NaN)
            if (r7 != 0) goto L_0x00cf
            r3 = 65536(0x10000, float:9.18355E-41)
            if (r9 != r3) goto L_0x00cf
            if (r11 != r5) goto L_0x00cf
            if (r4 != 0) goto L_0x00cf
            r7 = 90
            goto L_0x00e8
        L_0x00cf:
            if (r7 != 0) goto L_0x00dc
            if (r9 != r5) goto L_0x00dc
            r3 = 65536(0x10000, float:9.18355E-41)
            if (r11 != r3) goto L_0x00dc
            if (r4 != 0) goto L_0x00dc
            r7 = 270(0x10e, float:3.78E-43)
            goto L_0x00e8
        L_0x00dc:
            if (r7 != r5) goto L_0x00e7
            if (r9 != 0) goto L_0x00e7
            if (r11 != 0) goto L_0x00e7
            if (r4 != r5) goto L_0x00e7
            r7 = 180(0xb4, float:2.52E-43)
            goto L_0x00e8
        L_0x00e7:
            r7 = 0
        L_0x00e8:
            com.google.android.gms.internal.ads.qs r3 = new com.google.android.gms.internal.ads.qs
            r3.<init>(r13, r14, r7)
            long r22 = r3.f22920b
            r4 = r44
            com.google.android.gms.internal.ads.zzst r4 = r4.f22630Qa
            r4.mo32199b(r10)
            int r5 = r4.mo32202d()
            int r5 = com.google.android.gms.internal.ads.C9481hs.m23682b(r5)
            if (r5 != 0) goto L_0x0107
            r5 = 8
            goto L_0x0109
        L_0x0107:
            r5 = 16
        L_0x0109:
            r4.mo32201c(r5)
            long r4 = r4.mo32210j()
            int r7 = (r22 > r18 ? 1 : (r22 == r18 ? 0 : -1))
            if (r7 != 0) goto L_0x0116
            goto L_0x0121
        L_0x0116:
            r24 = 1000000(0xf4240, double:4.940656E-318)
            r26 = r4
            long r13 = com.google.android.gms.internal.ads.zzsy.m31148a(r22, r24, r26)
            r18 = r13
        L_0x0121:
            int r7 = com.google.android.gms.internal.ads.C9481hs.f22441F
            com.google.android.gms.internal.ads.is r7 = r1.mo29011e(r7)
            int r9 = com.google.android.gms.internal.ads.C9481hs.f22443G
            com.google.android.gms.internal.ads.is r7 = r7.mo29011e(r9)
            int r9 = com.google.android.gms.internal.ads.C9481hs.f22463R
            com.google.android.gms.internal.ads.js r1 = r1.mo29010d(r9)
            com.google.android.gms.internal.ads.zzst r1 = r1.f22630Qa
            r1.mo32199b(r10)
            int r9 = r1.mo32202d()
            int r9 = com.google.android.gms.internal.ads.C9481hs.m23682b(r9)
            if (r9 != 0) goto L_0x0145
            r11 = 8
            goto L_0x0147
        L_0x0145:
            r11 = 16
        L_0x0147:
            r1.mo32201c(r11)
            long r13 = r1.mo32210j()
            if (r9 != 0) goto L_0x0152
            r9 = 4
            goto L_0x0154
        L_0x0152:
            r9 = 8
        L_0x0154:
            r1.mo32201c(r9)
            int r1 = r1.mo32208h()
            int r9 = r1 >> 10
            r9 = r9 & 31
            int r9 = r9 + 96
            char r9 = (char) r9
            int r11 = r1 >> 5
            r11 = r11 & 31
            int r11 = r11 + 96
            char r11 = (char) r11
            r1 = r1 & 31
            int r1 = r1 + 96
            char r1 = (char) r1
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r6)
            r15.append(r9)
            r15.append(r11)
            r15.append(r1)
            java.lang.String r1 = r15.toString()
            java.lang.Long r9 = java.lang.Long.valueOf(r13)
            android.util.Pair r1 = android.util.Pair.create(r9, r1)
            int r9 = com.google.android.gms.internal.ads.C9481hs.f22465T
            com.google.android.gms.internal.ads.js r7 = r7.mo29010d(r9)
            com.google.android.gms.internal.ads.zzst r7 = r7.f22630Qa
            int r9 = r3.f22919a
            int r11 = r3.f22921c
            java.lang.Object r13 = r1.second
            java.lang.String r13 = (java.lang.String) r13
            r14 = 12
            r7.mo32199b(r14)
            int r14 = r7.mo32202d()
            com.google.android.gms.internal.ads.ns r15 = new com.google.android.gms.internal.ads.ns
            r15.<init>(r14)
            r6 = 0
        L_0x01ad:
            if (r6 >= r14) goto L_0x06f7
            int r10 = r7.mo32198b()
            int r2 = r7.mo32202d()
            if (r2 <= 0) goto L_0x01bb
            r8 = 1
            goto L_0x01bc
        L_0x01bb:
            r8 = 0
        L_0x01bc:
            r44 = r14
            java.lang.String r14 = "childAtomSize should be positive"
            com.google.android.gms.internal.ads.zzsk.m31081a(r8, r14)
            int r8 = r7.mo32202d()
            r37 = r4
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22474b
            if (r8 == r4) goto L_0x0527
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22476c
            if (r8 == r4) goto L_0x0527
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22471Z
            if (r8 == r4) goto L_0x0527
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22495la
            if (r8 == r4) goto L_0x0527
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22478d
            if (r8 == r4) goto L_0x0527
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22480e
            if (r8 == r4) goto L_0x0527
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22482f
            if (r8 == r4) goto L_0x0527
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22452Ka
            if (r8 == r4) goto L_0x0527
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22454La
            if (r8 != r4) goto L_0x01f8
            r40 = r1
            r41 = r3
            r42 = r11
            r39 = r12
            r0 = -1
            goto L_0x0530
        L_0x01f8:
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22488i
            if (r8 == r4) goto L_0x0302
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22473aa
            if (r8 == r4) goto L_0x0302
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22498n
            if (r8 == r4) goto L_0x0302
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22502p
            if (r8 == r4) goto L_0x0302
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22506r
            if (r8 == r4) goto L_0x0302
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22512u
            if (r8 == r4) goto L_0x0302
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22508s
            if (r8 == r4) goto L_0x0302
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22510t
            if (r8 == r4) goto L_0x0302
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22521ya
            if (r8 == r4) goto L_0x0302
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22523za
            if (r8 == r4) goto L_0x0302
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22494l
            if (r8 == r4) goto L_0x0302
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22496m
            if (r8 == r4) goto L_0x0302
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22490j
            if (r8 == r4) goto L_0x0302
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22460Oa
            if (r8 != r4) goto L_0x0232
            goto L_0x0302
        L_0x0232:
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22491ja
            if (r8 == r4) goto L_0x026f
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22513ua
            if (r8 == r4) goto L_0x026f
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22515va
            if (r8 == r4) goto L_0x026f
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22517wa
            if (r8 == r4) goto L_0x026f
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22519xa
            if (r8 != r4) goto L_0x0247
            goto L_0x026f
        L_0x0247:
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22458Na
            if (r8 != r4) goto L_0x0264
            java.lang.String r4 = java.lang.Integer.toString(r9)
            java.lang.String r5 = "application/x-camera-motion"
            r8 = -1
            r14 = 0
            com.google.android.gms.internal.ads.zzlh r4 = com.google.android.gms.internal.ads.zzlh.m30630a(r4, r5, r14, r8, r14)
            r15.f22819b = r4
            r40 = r1
            r41 = r3
            r42 = r11
            r39 = r12
            r1 = 3
            goto L_0x06dd
        L_0x0264:
            r40 = r1
            r41 = r3
            r42 = r11
            r39 = r12
            r1 = 3
            goto L_0x06dd
        L_0x026f:
            int r4 = r10 + 8
            r5 = 8
            int r4 = r4 + r5
            r7.mo32199b(r4)
            int r14 = com.google.android.gms.internal.ads.C9481hs.f22491ja
            if (r8 != r14) goto L_0x028a
            java.lang.String r8 = "application/ttml+xml"
            r23 = r8
            r30 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r32 = 0
            goto L_0x02db
        L_0x028a:
            int r14 = com.google.android.gms.internal.ads.C9481hs.f22513ua
            if (r8 != r14) goto L_0x02aa
            int r8 = r2 + -8
            r14 = 8
            int r8 = r8 - r14
            byte[] r14 = new byte[r8]
            r4 = 0
            r7.mo32197a(r14, r4, r8)
            java.util.List r4 = java.util.Collections.singletonList(r14)
            java.lang.String r5 = "application/x-quicktime-tx3g"
            r32 = r4
            r23 = r5
            r30 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L_0x02db
        L_0x02aa:
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22515va
            if (r8 != r4) goto L_0x02ba
            java.lang.String r4 = "application/x-mp4-vtt"
            r23 = r4
            r30 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r32 = 0
            goto L_0x02db
        L_0x02ba:
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22517wa
            if (r8 != r4) goto L_0x02c8
            java.lang.String r4 = "application/ttml+xml"
            r23 = r4
            r30 = r16
            r32 = 0
            goto L_0x02db
        L_0x02c8:
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22519xa
            if (r8 != r4) goto L_0x02fc
            r4 = 1
            r15.f22821d = r4
            java.lang.String r4 = "application/x-mp4-cea-608"
            r23 = r4
            r30 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r32 = 0
        L_0x02db:
            java.lang.String r22 = java.lang.Integer.toString(r9)
            r24 = 0
            r25 = -1
            r26 = 0
            r28 = -1
            r29 = 0
            r27 = r13
            com.google.android.gms.internal.ads.zzlh r4 = com.google.android.gms.internal.ads.zzlh.m30628a(r22, r23, r24, r25, r26, r27, r28, r29, r30, r32)
            r15.f22819b = r4
            r40 = r1
            r41 = r3
            r42 = r11
            r39 = r12
            r1 = 3
            goto L_0x06dd
        L_0x02fc:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x0302:
            int r4 = r10 + 8
            r5 = 8
            int r4 = r4 + r5
            r7.mo32199b(r4)
            if (r48 == 0) goto L_0x0317
            int r4 = r7.mo32208h()
            r5 = 6
            r7.mo32201c(r5)
            goto L_0x031d
        L_0x0317:
            r4 = 8
            r7.mo32201c(r4)
            r4 = 0
        L_0x031d:
            if (r4 == 0) goto L_0x0350
            r5 = 1
            if (r4 != r5) goto L_0x0323
            goto L_0x0350
        L_0x0323:
            r5 = 2
            if (r4 != r5) goto L_0x0345
            r4 = 16
            r7.mo32201c(r4)
            long r4 = r7.mo32204e()
            double r4 = java.lang.Double.longBitsToDouble(r4)
            long r4 = java.lang.Math.round(r4)
            int r5 = (int) r4
            int r4 = r7.mo32212l()
            r22 = r4
            r4 = 20
            r7.mo32201c(r4)
            goto L_0x036a
        L_0x0345:
            r40 = r1
            r41 = r3
            r42 = r11
            r39 = r12
            r1 = 3
            goto L_0x06dd
        L_0x0350:
            int r5 = r7.mo32208h()
            r22 = r5
            r5 = 6
            r7.mo32201c(r5)
            int r5 = r7.mo32211k()
            r23 = r5
            r5 = 1
            if (r4 != r5) goto L_0x0368
            r4 = 16
            r7.mo32201c(r4)
        L_0x0368:
            r5 = r23
        L_0x036a:
            int r4 = r7.mo32198b()
            r23 = r5
            int r5 = com.google.android.gms.internal.ads.C9481hs.f22473aa
            if (r8 != r5) goto L_0x037b
            int r8 = m23835a(r7, r10, r2, r15, r6)
            r7.mo32199b(r4)
        L_0x037b:
            int r5 = com.google.android.gms.internal.ads.C9481hs.f22498n
            if (r8 != r5) goto L_0x0383
            java.lang.String r5 = "audio/ac3"
            goto L_0x03cd
        L_0x0383:
            int r5 = com.google.android.gms.internal.ads.C9481hs.f22502p
            if (r8 != r5) goto L_0x038a
            java.lang.String r5 = "audio/eac3"
            goto L_0x03cd
        L_0x038a:
            int r5 = com.google.android.gms.internal.ads.C9481hs.f22506r
            if (r8 != r5) goto L_0x0391
            java.lang.String r5 = "audio/vnd.dts"
            goto L_0x03cd
        L_0x0391:
            int r5 = com.google.android.gms.internal.ads.C9481hs.f22508s
            if (r8 == r5) goto L_0x03cb
            int r5 = com.google.android.gms.internal.ads.C9481hs.f22510t
            if (r8 != r5) goto L_0x039a
            goto L_0x03cb
        L_0x039a:
            int r5 = com.google.android.gms.internal.ads.C9481hs.f22512u
            if (r8 != r5) goto L_0x03a1
            java.lang.String r5 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x03cd
        L_0x03a1:
            int r5 = com.google.android.gms.internal.ads.C9481hs.f22521ya
            if (r8 != r5) goto L_0x03a8
            java.lang.String r5 = "audio/3gpp"
            goto L_0x03cd
        L_0x03a8:
            int r5 = com.google.android.gms.internal.ads.C9481hs.f22523za
            if (r8 != r5) goto L_0x03af
            java.lang.String r5 = "audio/amr-wb"
            goto L_0x03cd
        L_0x03af:
            int r5 = com.google.android.gms.internal.ads.C9481hs.f22494l
            if (r8 == r5) goto L_0x03c8
            int r5 = com.google.android.gms.internal.ads.C9481hs.f22496m
            if (r8 != r5) goto L_0x03b8
            goto L_0x03c8
        L_0x03b8:
            int r5 = com.google.android.gms.internal.ads.C9481hs.f22490j
            if (r8 != r5) goto L_0x03bf
            java.lang.String r5 = "audio/mpeg"
            goto L_0x03cd
        L_0x03bf:
            int r5 = com.google.android.gms.internal.ads.C9481hs.f22460Oa
            if (r8 != r5) goto L_0x03c6
            java.lang.String r5 = "audio/alac"
            goto L_0x03cd
        L_0x03c6:
            r5 = 0
            goto L_0x03cd
        L_0x03c8:
            java.lang.String r5 = "audio/raw"
            goto L_0x03cd
        L_0x03cb:
            java.lang.String r5 = "audio/vnd.dts.hd"
        L_0x03cd:
            r8 = r4
            r4 = r22
            r33 = r23
            r34 = 0
        L_0x03d4:
            r39 = r12
            int r12 = r8 - r10
            if (r12 >= r2) goto L_0x04e3
            r7.mo32199b(r8)
            int r12 = r7.mo32202d()
            if (r12 <= 0) goto L_0x03e7
            r40 = r1
            r1 = 1
            goto L_0x03ea
        L_0x03e7:
            r40 = r1
            r1 = 0
        L_0x03ea:
            com.google.android.gms.internal.ads.zzsk.m31081a(r1, r14)
            int r1 = r7.mo32202d()
            r41 = r3
            int r3 = com.google.android.gms.internal.ads.C9481hs.f22449J
            if (r1 == r3) goto L_0x046a
            if (r48 == 0) goto L_0x0400
            int r3 = com.google.android.gms.internal.ads.C9481hs.f22492k
            if (r1 != r3) goto L_0x0400
            r3 = 0
            goto L_0x046b
        L_0x0400:
            int r3 = com.google.android.gms.internal.ads.C9481hs.f22500o
            if (r1 != r3) goto L_0x0416
            int r1 = r8 + 8
            r7.mo32199b(r1)
            java.lang.String r1 = java.lang.Integer.toString(r9)
            r3 = 0
            com.google.android.gms.internal.ads.zzlh r1 = com.google.android.gms.internal.ads.zzlv.m30676a(r7, r1, r13, r3)
            r15.f22819b = r1
            r3 = 0
            goto L_0x0465
        L_0x0416:
            int r3 = com.google.android.gms.internal.ads.C9481hs.f22504q
            if (r1 != r3) goto L_0x042c
            int r1 = r8 + 8
            r7.mo32199b(r1)
            java.lang.String r1 = java.lang.Integer.toString(r9)
            r3 = 0
            com.google.android.gms.internal.ads.zzlh r1 = com.google.android.gms.internal.ads.zzlv.m30677b(r7, r1, r13, r3)
            r15.f22819b = r1
            r3 = 0
            goto L_0x0465
        L_0x042c:
            int r3 = com.google.android.gms.internal.ads.C9481hs.f22514v
            if (r1 != r3) goto L_0x0450
            java.lang.String r22 = java.lang.Integer.toString(r9)
            r24 = 0
            r25 = -1
            r26 = -1
            r29 = 0
            r30 = 0
            r31 = 0
            r23 = r5
            r27 = r4
            r28 = r33
            r32 = r13
            com.google.android.gms.internal.ads.zzlh r1 = com.google.android.gms.internal.ads.zzlh.m30627a(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            r15.f22819b = r1
            r3 = 0
            goto L_0x0465
        L_0x0450:
            int r3 = com.google.android.gms.internal.ads.C9481hs.f22460Oa
            if (r1 != r3) goto L_0x0464
            byte[] r1 = new byte[r12]
            r7.mo32199b(r8)
            r3 = 0
            r7.mo32197a(r1, r3, r12)
            r34 = r1
            r42 = r11
            r0 = -1
            goto L_0x04d6
        L_0x0464:
            r3 = 0
        L_0x0465:
            r42 = r11
            r0 = -1
            goto L_0x04d6
        L_0x046a:
            r3 = 0
        L_0x046b:
            int r3 = com.google.android.gms.internal.ads.C9481hs.f22449J
            if (r1 != r3) goto L_0x0473
            r1 = r8
            r42 = r11
            goto L_0x049f
        L_0x0473:
            int r1 = r7.mo32198b()
        L_0x0478:
            int r3 = r1 - r8
            if (r3 >= r12) goto L_0x049c
            r7.mo32199b(r1)
            int r3 = r7.mo32202d()
            if (r3 <= 0) goto L_0x0487
            r0 = 1
            goto L_0x0488
        L_0x0487:
            r0 = 0
        L_0x0488:
            com.google.android.gms.internal.ads.zzsk.m31081a(r0, r14)
            int r0 = r7.mo32202d()
            r42 = r11
            int r11 = com.google.android.gms.internal.ads.C9481hs.f22449J
            if (r0 != r11) goto L_0x0496
            goto L_0x049f
        L_0x0496:
            int r1 = r1 + r3
            r0 = r43
            r11 = r42
            goto L_0x0478
        L_0x049c:
            r42 = r11
            r1 = -1
        L_0x049f:
            r0 = -1
            if (r1 == r0) goto L_0x04d5
            android.util.Pair r1 = m23836a(r7, r1)
            java.lang.Object r3 = r1.first
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r1 = r1.second
            r34 = r1
            byte[] r34 = (byte[]) r34
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x04d4
            android.util.Pair r1 = com.google.android.gms.internal.ads.zzsl.m31085a(r34)
            java.lang.Object r4 = r1.first
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r5 = r3
            r33 = r4
            r4 = r1
            goto L_0x04d5
        L_0x04d4:
            r5 = r3
        L_0x04d5:
        L_0x04d6:
            int r8 = r8 + r12
            r0 = r43
            r12 = r39
            r1 = r40
            r3 = r41
            r11 = r42
            goto L_0x03d4
        L_0x04e3:
            r40 = r1
            r41 = r3
            r42 = r11
            r0 = -1
            com.google.android.gms.internal.ads.zzlh r1 = r15.f22819b
            if (r1 != 0) goto L_0x0524
            if (r5 == 0) goto L_0x0524
            java.lang.String r1 = "audio/raw"
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x04fb
            r29 = 2
            goto L_0x04fd
        L_0x04fb:
            r29 = -1
        L_0x04fd:
            java.lang.String r22 = java.lang.Integer.toString(r9)
            r24 = 0
            r25 = -1
            r26 = -1
            if (r34 != 0) goto L_0x050c
            r30 = 0
            goto L_0x0512
        L_0x050c:
            java.util.List r1 = java.util.Collections.singletonList(r34)
            r30 = r1
        L_0x0512:
            r31 = 0
            r32 = 0
            r23 = r5
            r27 = r4
            r28 = r33
            r33 = r13
            com.google.android.gms.internal.ads.zzlh r1 = com.google.android.gms.internal.ads.zzlh.m30626a(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            r15.f22819b = r1
        L_0x0524:
            r1 = 3
            goto L_0x06dd
        L_0x0527:
            r40 = r1
            r41 = r3
            r42 = r11
            r39 = r12
            r0 = -1
        L_0x0530:
            int r1 = r10 + 8
            r3 = 8
            int r1 = r1 + r3
            r7.mo32199b(r1)
            r1 = 16
            r7.mo32201c(r1)
            int r27 = r7.mo32208h()
            int r28 = r7.mo32208h()
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 50
            r7.mo32201c(r4)
            int r4 = r7.mo32198b()
            int r5 = com.google.android.gms.internal.ads.C9481hs.f22471Z
            if (r8 != r5) goto L_0x055d
            int r8 = m23835a(r7, r10, r2, r15, r6)
            r7.mo32199b(r4)
        L_0x055d:
            r3 = 0
            r23 = 0
            r30 = 0
            r32 = 1065353216(0x3f800000, float:1.0)
            r33 = 0
            r34 = -1
        L_0x056b:
            int r5 = r4 - r10
            if (r5 >= r2) goto L_0x06c1
            r7.mo32199b(r4)
            int r5 = r7.mo32198b()
            int r11 = r7.mo32202d()
            if (r11 != 0) goto L_0x0587
            int r12 = r7.mo32198b()
            int r12 = r12 - r10
            if (r12 == r2) goto L_0x0584
            goto L_0x0587
        L_0x0584:
            r1 = 3
            goto L_0x06c2
        L_0x0587:
            if (r11 <= 0) goto L_0x058b
            r12 = 1
            goto L_0x058c
        L_0x058b:
            r12 = 0
        L_0x058c:
            com.google.android.gms.internal.ads.zzsk.m31081a(r12, r14)
            int r12 = r7.mo32202d()
            int r0 = com.google.android.gms.internal.ads.C9481hs.f22445H
            if (r12 != r0) goto L_0x05be
            if (r23 != 0) goto L_0x059b
            r0 = 1
            goto L_0x059c
        L_0x059b:
            r0 = 0
        L_0x059c:
            com.google.android.gms.internal.ads.zzsk.m31082b(r0)
            int r5 = r5 + 8
            r7.mo32199b(r5)
            com.google.android.gms.internal.ads.zzta r0 = com.google.android.gms.internal.ads.zzta.m31161a(r7)
            java.util.List<byte[]> r5 = r0.f29354a
            int r12 = r0.f29355b
            r15.f22820c = r12
            if (r3 != 0) goto L_0x05b5
            float r0 = r0.f29358e
            r32 = r0
        L_0x05b5:
            java.lang.String r0 = "video/avc"
            r23 = r0
            r30 = r5
            r1 = 3
            goto L_0x06bb
        L_0x05be:
            int r0 = com.google.android.gms.internal.ads.C9481hs.f22447I
            if (r12 != r0) goto L_0x05e3
            if (r23 != 0) goto L_0x05c6
            r0 = 1
            goto L_0x05c7
        L_0x05c6:
            r0 = 0
        L_0x05c7:
            com.google.android.gms.internal.ads.zzsk.m31082b(r0)
            int r5 = r5 + 8
            r7.mo32199b(r5)
            com.google.android.gms.internal.ads.zztg r0 = com.google.android.gms.internal.ads.zztg.m31165a(r7)
            java.util.List<byte[]> r5 = r0.f29369a
            int r0 = r0.f29370b
            r15.f22820c = r0
            java.lang.String r0 = "video/hevc"
            r23 = r0
            r30 = r5
            r1 = 3
            goto L_0x06bb
        L_0x05e3:
            int r0 = com.google.android.gms.internal.ads.C9481hs.f22456Ma
            if (r12 != r0) goto L_0x05fd
            if (r23 != 0) goto L_0x05eb
            r0 = 1
            goto L_0x05ec
        L_0x05eb:
            r0 = 0
        L_0x05ec:
            com.google.android.gms.internal.ads.zzsk.m31082b(r0)
            int r0 = com.google.android.gms.internal.ads.C9481hs.f22452Ka
            if (r8 != r0) goto L_0x05f6
            java.lang.String r0 = "video/x-vnd.on2.vp8"
            goto L_0x05f8
        L_0x05f6:
            java.lang.String r0 = "video/x-vnd.on2.vp9"
        L_0x05f8:
            r23 = r0
            r1 = 3
            goto L_0x06bb
        L_0x05fd:
            int r0 = com.google.android.gms.internal.ads.C9481hs.f22484g
            if (r12 != r0) goto L_0x0610
            if (r23 != 0) goto L_0x0605
            r0 = 1
            goto L_0x0606
        L_0x0605:
            r0 = 0
        L_0x0606:
            com.google.android.gms.internal.ads.zzsk.m31082b(r0)
            java.lang.String r0 = "video/3gpp"
            r23 = r0
            r1 = 3
            goto L_0x06bb
        L_0x0610:
            int r0 = com.google.android.gms.internal.ads.C9481hs.f22449J
            if (r12 != r0) goto L_0x0634
            if (r23 != 0) goto L_0x0618
            r0 = 1
            goto L_0x0619
        L_0x0618:
            r0 = 0
        L_0x0619:
            com.google.android.gms.internal.ads.zzsk.m31082b(r0)
            android.util.Pair r0 = m23836a(r7, r5)
            java.lang.Object r5 = r0.first
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r0 = r0.second
            byte[] r0 = (byte[]) r0
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r30 = r0
            r23 = r5
            r1 = 3
            goto L_0x06bb
        L_0x0634:
            int r0 = com.google.android.gms.internal.ads.C9481hs.f22489ia
            if (r12 != r0) goto L_0x064f
            int r5 = r5 + 8
            r7.mo32199b(r5)
            int r0 = r7.mo32212l()
            int r3 = r7.mo32212l()
            float r0 = (float) r0
            float r3 = (float) r3
            float r32 = r0 / r3
            r1 = 3
            r3 = 1
            goto L_0x06bb
        L_0x064f:
            int r0 = com.google.android.gms.internal.ads.C9481hs.f22448Ia
            if (r12 != r0) goto L_0x0682
            int r0 = r5 + 8
        L_0x0656:
            int r12 = r0 - r5
            if (r12 >= r11) goto L_0x0679
            r7.mo32199b(r0)
            int r12 = r7.mo32202d()
            int r1 = r7.mo32202d()
            r22 = r3
            int r3 = com.google.android.gms.internal.ads.C9481hs.f22450Ja
            if (r1 != r3) goto L_0x0673
            byte[] r1 = r7.f29334a
            int r12 = r12 + r0
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r0, r12)
            goto L_0x067c
        L_0x0673:
            int r0 = r0 + r12
            r3 = r22
            r1 = 16
            goto L_0x0656
        L_0x0679:
            r22 = r3
            r0 = 0
        L_0x067c:
            r33 = r0
            r3 = r22
            r1 = 3
            goto L_0x06bb
        L_0x0682:
            r22 = r3
            int r0 = com.google.android.gms.internal.ads.C9481hs.f22446Ha
            if (r12 != r0) goto L_0x06b8
            int r0 = r7.mo32207g()
            r1 = 3
            r7.mo32201c(r1)
            if (r0 != 0) goto L_0x06b9
            int r0 = r7.mo32207g()
            if (r0 == 0) goto L_0x06b2
            r3 = 1
            if (r0 == r3) goto L_0x06ac
            r3 = 2
            if (r0 == r3) goto L_0x06a6
            if (r0 == r1) goto L_0x06a1
            goto L_0x06b9
        L_0x06a1:
            r3 = r22
            r34 = 3
            goto L_0x06bb
        L_0x06a6:
            r3 = r22
            r34 = 2
            goto L_0x06bb
        L_0x06ac:
            r3 = r22
            r34 = 1
            goto L_0x06bb
        L_0x06b2:
            r3 = r22
            r34 = 0
            goto L_0x06bb
        L_0x06b8:
            r1 = 3
        L_0x06b9:
            r3 = r22
        L_0x06bb:
            int r4 = r4 + r11
            r0 = -1
            r1 = 16
            goto L_0x056b
        L_0x06c1:
            r1 = 3
        L_0x06c2:
            if (r23 == 0) goto L_0x06dc
            java.lang.String r22 = java.lang.Integer.toString(r9)
            r24 = 0
            r25 = -1
            r26 = -1
            r29 = -1082130432(0xffffffffbf800000, float:-1.0)
            r35 = 0
            r36 = 0
            r31 = r42
            com.google.android.gms.internal.ads.zzlh r0 = com.google.android.gms.internal.ads.zzlh.m30625a(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            r15.f22819b = r0
        L_0x06dc:
        L_0x06dd:
            int r10 = r10 + r2
            r7.mo32199b(r10)
            int r6 = r6 + 1
            r0 = r43
            r14 = r44
            r4 = r37
            r12 = r39
            r1 = r40
            r3 = r41
            r11 = r42
            r2 = 0
            r8 = -1
            r10 = 8
            goto L_0x01ad
        L_0x06f7:
            r40 = r1
            r41 = r3
            r37 = r4
            r39 = r12
            int r0 = com.google.android.gms.internal.ads.C9481hs.f22461P
            r1 = r43
            com.google.android.gms.internal.ads.is r0 = r1.mo29011e(r0)
            if (r0 == 0) goto L_0x0767
            int r1 = com.google.android.gms.internal.ads.C9481hs.f22462Q
            com.google.android.gms.internal.ads.js r0 = r0.mo29010d(r1)
            if (r0 != 0) goto L_0x0713
            goto L_0x0767
        L_0x0713:
            com.google.android.gms.internal.ads.zzst r0 = r0.f22630Qa
            r1 = 8
            r0.mo32199b(r1)
            int r1 = r0.mo32202d()
            int r1 = com.google.android.gms.internal.ads.C9481hs.m23682b(r1)
            int r2 = r0.mo32212l()
            long[] r3 = new long[r2]
            long[] r4 = new long[r2]
            r5 = 0
        L_0x072b:
            if (r5 >= r2) goto L_0x0760
            r6 = 1
            if (r1 != r6) goto L_0x0736
            long r7 = r0.mo32213m()
            goto L_0x073a
        L_0x0736:
            long r7 = r0.mo32210j()
        L_0x073a:
            r3[r5] = r7
            if (r1 != r6) goto L_0x0743
            long r6 = r0.mo32204e()
            goto L_0x0748
        L_0x0743:
            int r6 = r0.mo32202d()
            long r6 = (long) r6
        L_0x0748:
            r4[r5] = r6
            short r6 = r0.mo32206f()
            r7 = 1
            if (r6 != r7) goto L_0x0758
            r6 = 2
            r0.mo32201c(r6)
            int r5 = r5 + 1
            goto L_0x072b
        L_0x0758:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported media rate."
            r0.<init>(r1)
            throw r0
        L_0x0760:
            android.util.Pair r0 = android.util.Pair.create(r3, r4)
            r1 = r0
            r0 = 0
            goto L_0x076c
        L_0x0767:
            r0 = 0
            android.util.Pair r1 = android.util.Pair.create(r0, r0)
        L_0x076c:
            com.google.android.gms.internal.ads.zzlh r2 = r15.f22819b
            if (r2 != 0) goto L_0x0772
            return r0
        L_0x0772:
            com.google.android.gms.internal.ads.zzpa r0 = new com.google.android.gms.internal.ads.zzpa
            int r11 = r41.f22919a
            r2 = r40
            java.lang.Object r2 = r2.first
            java.lang.Long r2 = (java.lang.Long) r2
            long r13 = r2.longValue()
            com.google.android.gms.internal.ads.zzlh r2 = r15.f22819b
            int r3 = r15.f22821d
            com.google.android.gms.internal.ads.zzpb[] r4 = r15.f22818a
            int r5 = r15.f22820c
            java.lang.Object r6 = r1.first
            r23 = r6
            long[] r23 = (long[]) r23
            java.lang.Object r1 = r1.second
            r24 = r1
            long[] r24 = (long[]) r24
            r10 = r0
            r12 = r39
            r15 = r37
            r17 = r18
            r19 = r2
            r20 = r3
            r21 = r4
            r22 = r5
            r10.<init>(r11, r12, r13, r15, r17, r19, r20, r21, r22, r23, r24)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9547ks.m23838a(com.google.android.gms.internal.ads.is, com.google.android.gms.internal.ads.js, long, com.google.android.gms.internal.ads.zzne, boolean):com.google.android.gms.internal.ads.zzpa");
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x04e2  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x04f2  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x04fa  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0215  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.C9804ws m23837a(com.google.android.gms.internal.ads.zzpa r41, com.google.android.gms.internal.ads.C9503is r42, com.google.android.gms.internal.ads.zznr r43) throws com.google.android.gms.internal.ads.zzlm {
        /*
            r0 = r41
            r1 = r42
            r2 = r43
            int r3 = com.google.android.gms.internal.ads.C9481hs.f22505qa
            com.google.android.gms.internal.ads.js r3 = r1.mo29010d(r3)
            if (r3 == 0) goto L_0x0014
            com.google.android.gms.internal.ads.os r4 = new com.google.android.gms.internal.ads.os
            r4.<init>(r3)
            goto L_0x0021
        L_0x0014:
            int r3 = com.google.android.gms.internal.ads.C9481hs.f22507ra
            com.google.android.gms.internal.ads.js r3 = r1.mo29010d(r3)
            if (r3 == 0) goto L_0x0517
            com.google.android.gms.internal.ads.ps r4 = new com.google.android.gms.internal.ads.ps
            r4.<init>(r3)
        L_0x0021:
            int r3 = r4.mo29090b()
            r5 = 0
            if (r3 != 0) goto L_0x0038
            com.google.android.gms.internal.ads.ws r0 = new com.google.android.gms.internal.ads.ws
            long[] r7 = new long[r5]
            int[] r8 = new int[r5]
            r9 = 0
            long[] r10 = new long[r5]
            int[] r11 = new int[r5]
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11)
            return r0
        L_0x0038:
            int r6 = com.google.android.gms.internal.ads.C9481hs.f22509sa
            com.google.android.gms.internal.ads.js r6 = r1.mo29010d(r6)
            r7 = 1
            if (r6 != 0) goto L_0x004b
            int r6 = com.google.android.gms.internal.ads.C9481hs.f22511ta
            com.google.android.gms.internal.ads.js r6 = r1.mo29010d(r6)
            r8 = 1
            goto L_0x004c
        L_0x004b:
            r8 = 0
        L_0x004c:
            com.google.android.gms.internal.ads.zzst r6 = r6.f22630Qa
            int r9 = com.google.android.gms.internal.ads.C9481hs.f22503pa
            com.google.android.gms.internal.ads.js r9 = r1.mo29010d(r9)
            com.google.android.gms.internal.ads.zzst r9 = r9.f22630Qa
            int r10 = com.google.android.gms.internal.ads.C9481hs.f22497ma
            com.google.android.gms.internal.ads.js r10 = r1.mo29010d(r10)
            com.google.android.gms.internal.ads.zzst r10 = r10.f22630Qa
            int r11 = com.google.android.gms.internal.ads.C9481hs.f22499na
            com.google.android.gms.internal.ads.js r11 = r1.mo29010d(r11)
            r12 = 0
            if (r11 == 0) goto L_0x006a
            com.google.android.gms.internal.ads.zzst r11 = r11.f22630Qa
            goto L_0x006b
        L_0x006a:
            r11 = r12
        L_0x006b:
            int r13 = com.google.android.gms.internal.ads.C9481hs.f22501oa
            com.google.android.gms.internal.ads.js r1 = r1.mo29010d(r13)
            if (r1 == 0) goto L_0x0076
            com.google.android.gms.internal.ads.zzst r1 = r1.f22630Qa
            goto L_0x0077
        L_0x0076:
            r1 = r12
        L_0x0077:
            com.google.android.gms.internal.ads.ls r13 = new com.google.android.gms.internal.ads.ls
            r13.<init>(r9, r6, r8)
            r6 = 12
            r10.mo32199b(r6)
            int r8 = r10.mo32212l()
            int r8 = r8 - r7
            int r9 = r10.mo32212l()
            int r14 = r10.mo32212l()
            if (r1 == 0) goto L_0x009b
            r1.mo32199b(r6)
            int r15 = r1.mo32212l()
            goto L_0x009c
        L_0x009b:
            r15 = 0
        L_0x009c:
            r16 = -1
            if (r11 == 0) goto L_0x00b4
            r11.mo32199b(r6)
            int r6 = r11.mo32212l()
            if (r6 <= 0) goto L_0x00b2
            int r12 = r11.mo32212l()
            int r16 = r12 + -1
            goto L_0x00b5
        L_0x00b2:
            r11 = r12
            goto L_0x00b5
        L_0x00b4:
            r6 = 0
        L_0x00b5:
            boolean r12 = r4.mo29089a()
            if (r12 == 0) goto L_0x00cf
            com.google.android.gms.internal.ads.zzlh r12 = r0.f29071f
            java.lang.String r12 = r12.f28784f
            java.lang.String r5 = "audio/raw"
            boolean r5 = r5.equals(r12)
            if (r5 == 0) goto L_0x00cf
            if (r8 != 0) goto L_0x00cf
            if (r15 != 0) goto L_0x00cf
            if (r6 != 0) goto L_0x00cf
            r5 = 1
            goto L_0x00d0
        L_0x00cf:
            r5 = 0
        L_0x00d0:
            r18 = 0
            if (r5 != 0) goto L_0x0215
            long[] r5 = new long[r3]
            int[] r12 = new int[r3]
            long[] r7 = new long[r3]
            r42 = r6
            int[] r6 = new int[r3]
            r0 = r42
            r27 = r10
            r10 = r14
            r25 = r15
            r2 = r16
            r21 = r18
            r23 = r21
            r42 = 0
            r15 = 0
            r16 = 0
            r26 = 0
            r14 = r9
            r9 = r8
            r8 = 0
        L_0x00f9:
            if (r8 >= r3) goto L_0x019e
            r28 = r21
            r21 = r42
        L_0x00ff:
            if (r21 != 0) goto L_0x0119
            boolean r21 = r13.mo29072a()
            com.google.android.gms.internal.ads.zzsk.m31082b(r21)
            r22 = r9
            r30 = r10
            long r9 = r13.f22739d
            r28 = r9
            int r9 = r13.f22738c
            r21 = r9
            r9 = r22
            r10 = r30
            goto L_0x00ff
        L_0x0119:
            r22 = r9
            r30 = r10
            if (r1 == 0) goto L_0x0133
        L_0x011f:
            if (r26 != 0) goto L_0x012e
            if (r25 <= 0) goto L_0x012e
            int r26 = r1.mo32212l()
            int r16 = r1.mo32202d()
            int r25 = r25 + -1
            goto L_0x011f
        L_0x012e:
            int r26 = r26 + -1
            r9 = r16
            goto L_0x0135
        L_0x0133:
            r9 = r16
        L_0x0135:
            r5[r8] = r28
            int r10 = r4.mo29091c()
            r12[r8] = r10
            r10 = r12[r8]
            if (r10 <= r15) goto L_0x0144
            r10 = r12[r8]
            r15 = r10
        L_0x0144:
            r16 = r3
            r10 = r4
            long r3 = (long) r9
            long r3 = r23 + r3
            r7[r8] = r3
            if (r11 != 0) goto L_0x0150
            r3 = 1
            goto L_0x0151
        L_0x0150:
            r3 = 0
        L_0x0151:
            r6[r8] = r3
            if (r8 != r2) goto L_0x0161
            r3 = 1
            r6[r8] = r3
            int r0 = r0 + -1
            if (r0 <= 0) goto L_0x0161
            int r2 = r11.mo32212l()
            int r2 = r2 - r3
        L_0x0161:
            r3 = r30
            r30 = r5
            long r4 = (long) r3
            long r23 = r23 + r4
            int r14 = r14 + -1
            if (r14 != 0) goto L_0x017b
            if (r22 <= 0) goto L_0x017b
            int r3 = r27.mo32212l()
            int r4 = r27.mo32212l()
            int r5 = r22 + -1
            r14 = r3
            r3 = r4
            goto L_0x017d
        L_0x017b:
            r5 = r22
        L_0x017d:
            r4 = r12[r8]
            r42 = r2
            r22 = r3
            long r2 = (long) r4
            long r2 = r28 + r2
            int r4 = r21 + -1
            int r8 = r8 + 1
            r39 = r2
            r2 = r42
            r42 = r4
            r4 = r10
            r3 = r16
            r10 = r22
            r21 = r39
            r16 = r9
            r9 = r5
            r5 = r30
            goto L_0x00f9
        L_0x019e:
            r16 = r3
            r30 = r5
            r22 = r9
            if (r26 != 0) goto L_0x01a8
            r2 = 1
            goto L_0x01a9
        L_0x01a8:
            r2 = 0
        L_0x01a9:
            com.google.android.gms.internal.ads.zzsk.m31080a(r2)
        L_0x01ac:
            if (r25 <= 0) goto L_0x01c0
            int r2 = r1.mo32212l()
            if (r2 != 0) goto L_0x01b6
            r2 = 1
            goto L_0x01b7
        L_0x01b6:
            r2 = 0
        L_0x01b7:
            com.google.android.gms.internal.ads.zzsk.m31080a(r2)
            r1.mo32202d()
            int r25 = r25 + -1
            goto L_0x01ac
        L_0x01c0:
            if (r0 != 0) goto L_0x01cc
            if (r14 != 0) goto L_0x01cc
            if (r42 != 0) goto L_0x01cc
            if (r22 == 0) goto L_0x01c9
            goto L_0x01cc
        L_0x01c9:
            r0 = r41
            goto L_0x020d
        L_0x01cc:
            r1 = r0
            r0 = r41
            int r2 = r0.f29066a
            r3 = 215(0xd7, float:3.01E-43)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Inconsistent stbl box for track "
            r4.append(r3)
            r4.append(r2)
            java.lang.String r2 = ": remainingSynchronizationSamples "
            r4.append(r2)
            r4.append(r1)
            java.lang.String r1 = ", remainingSamplesAtTimestampDelta "
            r4.append(r1)
            r4.append(r14)
            java.lang.String r1 = ", remainingSamplesInChunk "
            r4.append(r1)
            r1 = r42
            r4.append(r1)
            java.lang.String r1 = ", remainingTimestampDeltaChanges "
            r4.append(r1)
            r5 = r22
            r4.append(r5)
            java.lang.String r1 = r4.toString()
            java.lang.String r2 = "AtomParsers"
            android.util.Log.w(r2, r1)
        L_0x020d:
            r1 = r23
            r5 = r30
            r24 = r15
            goto L_0x02b9
        L_0x0215:
            r16 = r3
            r10 = r4
            int r1 = r13.f22736a
            long[] r2 = new long[r1]
            int[] r1 = new int[r1]
        L_0x021e:
            boolean r3 = r13.mo29072a()
            if (r3 == 0) goto L_0x022f
            int r3 = r13.f22737b
            long r4 = r13.f22739d
            r2[r3] = r4
            int r4 = r13.f22738c
            r1[r3] = r4
            goto L_0x021e
        L_0x022f:
            int r3 = r10.mo29091c()
            long r4 = (long) r14
            r6 = 8192(0x2000, float:1.14794E-41)
            int r6 = r6 / r3
            int r7 = r1.length
            r8 = 0
            r9 = 0
        L_0x023b:
            if (r8 >= r7) goto L_0x0247
            r10 = r1[r8]
            int r10 = com.google.android.gms.internal.ads.zzsy.m31145a(r10, r6)
            int r9 = r9 + r10
            int r8 = r8 + 1
            goto L_0x023b
        L_0x0247:
            long[] r7 = new long[r9]
            int[] r8 = new int[r9]
            long[] r10 = new long[r9]
            int[] r9 = new int[r9]
            r11 = 0
            r12 = 0
            r13 = 0
            r24 = 0
        L_0x0257:
            int r14 = r1.length
            if (r11 >= r14) goto L_0x0299
            r14 = r1[r11]
            r21 = r2[r11]
            r15 = r12
            r12 = r24
        L_0x0261:
            if (r14 <= 0) goto L_0x028f
            int r23 = java.lang.Math.min(r6, r14)
            r7[r13] = r21
            int r24 = r3 * r23
            r8[r13] = r24
            r25 = r1
            r1 = r8[r13]
            int r12 = java.lang.Math.max(r12, r1)
            r26 = r2
            long r1 = (long) r15
            long r1 = r1 * r4
            r10[r13] = r1
            r1 = 1
            r9[r13] = r1
            r1 = r8[r13]
            long r1 = (long) r1
            long r21 = r21 + r1
            int r15 = r15 + r23
            int r14 = r14 - r23
            int r13 = r13 + 1
            r1 = r25
            r2 = r26
            goto L_0x0261
        L_0x028f:
            r25 = r1
            r26 = r2
            int r11 = r11 + 1
            r24 = r12
            r12 = r15
            goto L_0x0257
        L_0x0299:
            com.google.android.gms.internal.ads.zzou r1 = new com.google.android.gms.internal.ads.zzou
            r27 = 0
            r21 = r1
            r22 = r7
            r23 = r8
            r25 = r10
            r26 = r9
            r21.<init>(r22, r23, r24, r25, r26)
            long[] r5 = r1.f29038a
            int[] r12 = r1.f29039b
            int r2 = r1.f29040c
            long[] r7 = r1.f29041d
            int[] r6 = r1.f29042e
            r24 = r2
            r1 = r18
        L_0x02b9:
            long[] r3 = r0.f29074i
            if (r3 == 0) goto L_0x04fa
            boolean r3 = r43.mo32059a()
            if (r3 == 0) goto L_0x02ca
            r42 = r5
            r32 = r6
            r11 = r12
            goto L_0x04ff
        L_0x02ca:
            long[] r3 = r0.f29074i
            int r4 = r3.length
            r10 = 1
            if (r4 != r10) goto L_0x035e
            int r4 = r0.f29067b
            if (r4 != r10) goto L_0x035e
            int r4 = r7.length
            r10 = 2
            if (r4 < r10) goto L_0x035e
            long[] r4 = r0.f29075j
            r10 = 0
            r13 = r4[r10]
            r25 = r3[r10]
            long r3 = r0.f29068c
            long r8 = r0.f29069d
            r27 = r3
            r29 = r8
            long r3 = com.google.android.gms.internal.ads.zzsy.m31148a(r25, r27, r29)
            long r3 = r3 + r13
            r8 = r7[r10]
            int r10 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r10 > 0) goto L_0x035e
            r8 = 1
            r9 = r7[r8]
            int r11 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r11 >= 0) goto L_0x035e
            int r9 = r7.length
            int r9 = r9 - r8
            r8 = r7[r9]
            int r10 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r10 >= 0) goto L_0x035e
            int r8 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r8 > 0) goto L_0x035e
            long r25 = r1 - r3
            r1 = 0
            r2 = r7[r1]
            long r27 = r13 - r2
            com.google.android.gms.internal.ads.zzlh r1 = r0.f29071f
            int r1 = r1.f28797s
            long r1 = (long) r1
            long r3 = r0.f29068c
            r29 = r1
            r31 = r3
            long r1 = com.google.android.gms.internal.ads.zzsy.m31148a(r27, r29, r31)
            com.google.android.gms.internal.ads.zzlh r3 = r0.f29071f
            int r3 = r3.f28797s
            long r3 = (long) r3
            long r8 = r0.f29068c
            r27 = r3
            r29 = r8
            long r3 = com.google.android.gms.internal.ads.zzsy.m31148a(r25, r27, r29)
            int r8 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r8 != 0) goto L_0x0333
            int r8 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r8 == 0) goto L_0x035e
        L_0x0333:
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r10 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r10 > 0) goto L_0x035e
            int r10 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r10 > 0) goto L_0x035e
            int r2 = (int) r1
            r1 = r43
            r1.f28977c = r2
            int r2 = (int) r3
            r1.f28978d = r2
            long r0 = r0.f29068c
            r2 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.gms.internal.ads.zzsy.m31152a(r7, r2, r0)
            com.google.android.gms.internal.ads.ws r0 = new com.google.android.gms.internal.ads.ws
            r21 = r0
            r22 = r5
            r23 = r12
            r25 = r7
            r26 = r6
            r21.<init>(r22, r23, r24, r25, r26)
            return r0
        L_0x035e:
            long[] r1 = r0.f29074i
            int r2 = r1.length
            r3 = 1
            if (r2 != r3) goto L_0x039a
            r17 = 0
            r2 = r1[r17]
            int r1 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r1 != 0) goto L_0x039a
            r1 = 0
        L_0x036d:
            int r2 = r7.length
            if (r1 >= r2) goto L_0x038a
            r2 = r7[r1]
            long[] r4 = r0.f29075j
            r8 = r4[r17]
            long r18 = r2 - r8
            r20 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r0.f29068c
            r22 = r2
            long r2 = com.google.android.gms.internal.ads.zzsy.m31148a(r18, r20, r22)
            r7[r1] = r2
            int r1 = r1 + 1
            r17 = 0
            goto L_0x036d
        L_0x038a:
            com.google.android.gms.internal.ads.ws r0 = new com.google.android.gms.internal.ads.ws
            r21 = r0
            r22 = r5
            r23 = r12
            r25 = r7
            r26 = r6
            r21.<init>(r22, r23, r24, r25, r26)
            return r0
        L_0x039a:
            int r1 = r0.f29067b
            r2 = 1
            if (r1 != r2) goto L_0x03a1
            r1 = 1
            goto L_0x03a2
        L_0x03a1:
            r1 = 0
        L_0x03a2:
            r2 = 0
            r3 = 0
            r4 = 0
            r8 = 0
        L_0x03a9:
            long[] r9 = r0.f29074i
            int r10 = r9.length
            r13 = -1
            if (r2 >= r10) goto L_0x03e2
            long[] r10 = r0.f29075j
            r42 = r12
            r11 = r10[r2]
            int r10 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r10 == 0) goto L_0x03dd
            r25 = r9[r2]
            long r9 = r0.f29068c
            long r13 = r0.f29069d
            r27 = r9
            r29 = r13
            long r9 = com.google.android.gms.internal.ads.zzsy.m31148a(r25, r27, r29)
            r13 = 1
            int r14 = com.google.android.gms.internal.ads.zzsy.m31157b(r7, r11, r13, r13)
            long r11 = r11 + r9
            r9 = 0
            int r10 = com.google.android.gms.internal.ads.zzsy.m31157b(r7, r11, r1, r9)
            int r9 = r10 - r14
            int r4 = r4 + r9
            if (r8 == r14) goto L_0x03da
            r8 = 1
            goto L_0x03db
        L_0x03da:
            r8 = 0
        L_0x03db:
            r3 = r3 | r8
            r8 = r10
        L_0x03dd:
            int r2 = r2 + 1
            r12 = r42
            goto L_0x03a9
        L_0x03e2:
            r42 = r12
            r2 = r16
            if (r4 == r2) goto L_0x03ea
            r2 = 1
            goto L_0x03eb
        L_0x03ea:
            r2 = 0
        L_0x03eb:
            r2 = r2 | r3
            if (r2 == 0) goto L_0x03f1
            long[] r3 = new long[r4]
            goto L_0x03f2
        L_0x03f1:
            r3 = r5
        L_0x03f2:
            if (r2 == 0) goto L_0x03f7
            int[] r12 = new int[r4]
            goto L_0x03f9
        L_0x03f7:
            r12 = r42
        L_0x03f9:
            if (r2 == 0) goto L_0x03fd
            r24 = 0
        L_0x03fd:
            if (r2 == 0) goto L_0x0402
            int[] r8 = new int[r4]
            goto L_0x0403
        L_0x0402:
            r8 = r6
        L_0x0403:
            long[] r4 = new long[r4]
            r28 = r24
            r9 = 0
            r10 = 0
        L_0x040b:
            long[] r11 = r0.f29074i
            int r15 = r11.length
            if (r9 >= r15) goto L_0x04c5
            long[] r15 = r0.f29075j
            r13 = r15[r9]
            r15 = r11[r9]
            r29 = -1
            int r11 = (r13 > r29 ? 1 : (r13 == r29 ? 0 : -1))
            if (r11 == 0) goto L_0x04a5
            r11 = r8
            r27 = r9
            long r8 = r0.f29068c
            r32 = r11
            r31 = r12
            long r11 = r0.f29069d
            r21 = r15
            r23 = r8
            r25 = r11
            long r8 = com.google.android.gms.internal.ads.zzsy.m31148a(r21, r23, r25)
            long r8 = r8 + r13
            r11 = 1
            int r12 = com.google.android.gms.internal.ads.zzsy.m31157b(r7, r13, r11, r11)
            r11 = 0
            int r8 = com.google.android.gms.internal.ads.zzsy.m31157b(r7, r8, r1, r11)
            if (r2 == 0) goto L_0x0456
            int r9 = r8 - r12
            java.lang.System.arraycopy(r5, r12, r3, r10, r9)
            r11 = r42
            r39 = r31
            r31 = r1
            r1 = r39
            java.lang.System.arraycopy(r11, r12, r1, r10, r9)
            r42 = r5
            r5 = r32
            java.lang.System.arraycopy(r6, r12, r5, r10, r9)
            goto L_0x0462
        L_0x0456:
            r11 = r42
            r42 = r5
            r5 = r32
            r39 = r31
            r31 = r1
            r1 = r39
        L_0x0462:
            r9 = r28
        L_0x0464:
            if (r12 >= r8) goto L_0x049e
            r23 = 1000000(0xf4240, double:4.940656E-318)
            r43 = r5
            r32 = r6
            long r5 = r0.f29069d
            r21 = r18
            r25 = r5
            long r5 = com.google.android.gms.internal.ads.zzsy.m31148a(r21, r23, r25)
            r21 = r7[r12]
            long r33 = r21 - r13
            r35 = 1000000(0xf4240, double:4.940656E-318)
            r21 = r13
            long r13 = r0.f29068c
            r37 = r13
            long r13 = com.google.android.gms.internal.ads.zzsy.m31148a(r33, r35, r37)
            long r5 = r5 + r13
            r4[r10] = r5
            if (r2 == 0) goto L_0x0493
            r5 = r1[r10]
            if (r5 <= r9) goto L_0x0493
            r9 = r11[r12]
        L_0x0493:
            int r10 = r10 + 1
            int r12 = r12 + 1
            r5 = r43
            r13 = r21
            r6 = r32
            goto L_0x0464
        L_0x049e:
            r43 = r5
            r32 = r6
            r28 = r9
            goto L_0x04b2
        L_0x04a5:
            r11 = r42
            r31 = r1
            r42 = r5
            r32 = r6
            r43 = r8
            r27 = r9
            r1 = r12
        L_0x04b2:
            long r18 = r18 + r15
            int r9 = r27 + 1
            r5 = r42
            r8 = r43
            r12 = r1
            r42 = r11
            r13 = r29
            r1 = r31
            r6 = r32
            goto L_0x040b
        L_0x04c5:
            r43 = r8
            r1 = r12
            r0 = 0
            r2 = 0
        L_0x04ca:
            r6 = r43
            int r5 = r6.length
            if (r0 >= r5) goto L_0x04e0
            if (r2 != 0) goto L_0x04e0
            r5 = r6[r0]
            r7 = 1
            r5 = r5 & r7
            if (r5 == 0) goto L_0x04d9
            r5 = 1
            goto L_0x04da
        L_0x04d9:
            r5 = 0
        L_0x04da:
            r2 = r2 | r5
            int r0 = r0 + 1
            r43 = r6
            goto L_0x04ca
        L_0x04e0:
            if (r2 == 0) goto L_0x04f2
            com.google.android.gms.internal.ads.ws r0 = new com.google.android.gms.internal.ads.ws
            r25 = r0
            r26 = r3
            r27 = r1
            r29 = r4
            r30 = r6
            r25.<init>(r26, r27, r28, r29, r30)
            return r0
        L_0x04f2:
            com.google.android.gms.internal.ads.zzlm r0 = new com.google.android.gms.internal.ads.zzlm
            java.lang.String r1 = "The edited sample sequence does not contain a sync sample."
            r0.<init>(r1)
            throw r0
        L_0x04fa:
            r42 = r5
            r32 = r6
            r11 = r12
        L_0x04ff:
            long r0 = r0.f29068c
            r2 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.gms.internal.ads.zzsy.m31152a(r7, r2, r0)
            com.google.android.gms.internal.ads.ws r0 = new com.google.android.gms.internal.ads.ws
            r21 = r0
            r22 = r42
            r23 = r11
            r25 = r7
            r26 = r32
            r21.<init>(r22, r23, r24, r25, r26)
            return r0
        L_0x0517:
            com.google.android.gms.internal.ads.zzlm r0 = new com.google.android.gms.internal.ads.zzlm
            java.lang.String r1 = "Track has no sample table size information"
            r0.<init>(r1)
            goto L_0x0520
        L_0x051f:
            throw r0
        L_0x0520:
            goto L_0x051f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9547ks.m23837a(com.google.android.gms.internal.ads.zzpa, com.google.android.gms.internal.ads.is, com.google.android.gms.internal.ads.zznr):com.google.android.gms.internal.ads.ws");
    }

    /* renamed from: a */
    public static zzpo m23839a(C9525js jsVar, boolean z) {
        if (z) {
            return null;
        }
        zzst zzst = jsVar.f22630Qa;
        zzst.mo32199b(8);
        while (zzst.mo32214n() >= 8) {
            int b = zzst.mo32198b();
            int d = zzst.mo32202d();
            if (zzst.mo32202d() == C9481hs.f22434Ba) {
                zzst.mo32199b(b);
                int i = b + d;
                zzst.mo32201c(12);
                while (true) {
                    if (zzst.mo32198b() >= i) {
                        break;
                    }
                    int b2 = zzst.mo32198b();
                    int d2 = zzst.mo32202d();
                    if (zzst.mo32202d() == C9481hs.f22436Ca) {
                        zzst.mo32199b(b2);
                        int i2 = b2 + d2;
                        zzst.mo32201c(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzst.mo32198b() < i2) {
                            zza a = C9720ss.m24080a(zzst);
                            if (a != null) {
                                arrayList.add(a);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new zzpo((List<? extends zza>) arrayList);
                        }
                    } else {
                        zzst.mo32201c(d2 - 8);
                    }
                }
                return null;
            }
            zzst.mo32201c(d - 8);
        }
        return null;
    }

    /* renamed from: a */
    private static Pair<String, byte[]> m23836a(zzst zzst, int i) {
        zzst.mo32199b(i + 8 + 4);
        zzst.mo32201c(1);
        m23834a(zzst);
        zzst.mo32201c(2);
        int g = zzst.mo32207g();
        if ((g & 128) != 0) {
            zzst.mo32201c(2);
        }
        if ((g & 64) != 0) {
            zzst.mo32201c(zzst.mo32208h());
        }
        if ((g & 32) != 0) {
            zzst.mo32201c(2);
        }
        zzst.mo32201c(1);
        m23834a(zzst);
        int g2 = zzst.mo32207g();
        String str = null;
        if (g2 == 32) {
            str = "video/mp4v-es";
        } else if (g2 == 33) {
            str = "video/avc";
        } else if (g2 != 35) {
            if (g2 != 64) {
                if (g2 == 107) {
                    return Pair.create("audio/mpeg", null);
                }
                if (g2 == 165) {
                    str = "audio/ac3";
                } else if (g2 != 166) {
                    switch (g2) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (g2) {
                                case Opcodes.RET /*169*/:
                                case Opcodes.IRETURN /*172*/:
                                    return Pair.create("audio/vnd.dts", null);
                                case Opcodes.TABLESWITCH /*170*/:
                                case Opcodes.LOOKUPSWITCH /*171*/:
                                    return Pair.create("audio/vnd.dts.hd", null);
                            }
                    }
                } else {
                    str = "audio/eac3";
                }
            }
            str = "audio/mp4a-latm";
        } else {
            str = "video/hevc";
        }
        zzst.mo32201c(12);
        zzst.mo32201c(1);
        int a = m23834a(zzst);
        byte[] bArr = new byte[a];
        zzst.mo32197a(bArr, 0, a);
        return Pair.create(str, bArr);
    }

    /* renamed from: a */
    private static int m23835a(zzst zzst, int i, int i2, C9613ns nsVar, int i3) {
        Object obj;
        zzst zzst2 = zzst;
        int b = zzst.mo32198b();
        while (true) {
            boolean z = false;
            if (b - i >= i2) {
                return 0;
            }
            zzst.mo32199b(b);
            int d = zzst.mo32202d();
            zzsk.m31081a(d > 0, "childAtomSize should be positive");
            if (zzst.mo32202d() == C9481hs.f22467V) {
                int i4 = b + 8;
                Pair pair = null;
                Object obj2 = null;
                Object obj3 = null;
                boolean z2 = false;
                while (i4 - b < d) {
                    zzst.mo32199b(i4);
                    int d2 = zzst.mo32202d();
                    int d3 = zzst.mo32202d();
                    if (d3 == C9481hs.f22475ba) {
                        obj2 = Integer.valueOf(zzst.mo32202d());
                    } else if (d3 == C9481hs.f22468W) {
                        zzst.mo32201c(4);
                        z2 = zzst.mo32202d() == f22701g;
                    } else if (d3 == C9481hs.f22469X) {
                        int i5 = i4 + 8;
                        while (true) {
                            if (i5 - i4 >= d2) {
                                obj = null;
                                break;
                            }
                            zzst.mo32199b(i5);
                            int d4 = zzst.mo32202d();
                            if (zzst.mo32202d() == C9481hs.f22470Y) {
                                zzst.mo32201c(6);
                                boolean z3 = zzst.mo32207g() == 1;
                                int g = zzst.mo32207g();
                                byte[] bArr = new byte[16];
                                zzst.mo32197a(bArr, 0, 16);
                                obj = new zzpb(z3, g, bArr);
                            } else {
                                i5 += d4;
                            }
                        }
                        obj3 = obj;
                    }
                    i4 += d2;
                }
                if (z2) {
                    zzsk.m31081a(obj2 != null, "frma atom is mandatory");
                    if (obj3 != null) {
                        z = true;
                    }
                    zzsk.m31081a(z, "schi->tenc atom is mandatory");
                    pair = Pair.create(obj2, obj3);
                }
                if (pair != null) {
                    nsVar.f22818a[i3] = (zzpb) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            C9613ns nsVar2 = nsVar;
            b += d;
        }
    }

    /* renamed from: a */
    private static int m23834a(zzst zzst) {
        int g = zzst.mo32207g();
        int i = g & Opcodes.LAND;
        while ((g & 128) == 128) {
            g = zzst.mo32207g();
            i = (i << 7) | (g & Opcodes.LAND);
        }
        return i;
    }
}
