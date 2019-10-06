package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ads.es */
final class C9415es {

    /* renamed from: A */
    public float f22227A;

    /* renamed from: B */
    public float f22228B;

    /* renamed from: C */
    public float f22229C;

    /* renamed from: D */
    public float f22230D;

    /* renamed from: E */
    public float f22231E;

    /* renamed from: F */
    public float f22232F;

    /* renamed from: G */
    public int f22233G;

    /* renamed from: H */
    public int f22234H;

    /* renamed from: I */
    public int f22235I;

    /* renamed from: J */
    public long f22236J;

    /* renamed from: K */
    public long f22237K;

    /* renamed from: L */
    public boolean f22238L;

    /* renamed from: M */
    public boolean f22239M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public String f22240N;

    /* renamed from: O */
    public zznw f22241O;

    /* renamed from: P */
    public int f22242P;

    /* renamed from: a */
    public String f22243a;

    /* renamed from: b */
    public int f22244b;

    /* renamed from: c */
    public int f22245c;

    /* renamed from: d */
    public int f22246d;

    /* renamed from: e */
    public boolean f22247e;

    /* renamed from: f */
    public byte[] f22248f;

    /* renamed from: g */
    public zznx f22249g;

    /* renamed from: h */
    public byte[] f22250h;

    /* renamed from: i */
    public zzne f22251i;

    /* renamed from: j */
    public int f22252j;

    /* renamed from: k */
    public int f22253k;

    /* renamed from: l */
    public int f22254l;

    /* renamed from: m */
    public int f22255m;

    /* renamed from: n */
    public int f22256n;

    /* renamed from: o */
    public byte[] f22257o;

    /* renamed from: p */
    public int f22258p;

    /* renamed from: q */
    public boolean f22259q;

    /* renamed from: r */
    public int f22260r;

    /* renamed from: s */
    public int f22261s;

    /* renamed from: t */
    public int f22262t;

    /* renamed from: u */
    public int f22263u;

    /* renamed from: v */
    public int f22264v;

    /* renamed from: w */
    public float f22265w;

    /* renamed from: x */
    public float f22266x;

    /* renamed from: y */
    public float f22267y;

    /* renamed from: z */
    public float f22268z;

    private C9415es() {
        this.f22252j = -1;
        this.f22253k = -1;
        this.f22254l = -1;
        this.f22255m = -1;
        this.f22256n = 0;
        this.f22257o = null;
        this.f22258p = -1;
        this.f22259q = false;
        this.f22260r = -1;
        this.f22261s = -1;
        this.f22262t = -1;
        this.f22263u = 1000;
        this.f22264v = 200;
        this.f22265w = -1.0f;
        this.f22266x = -1.0f;
        this.f22267y = -1.0f;
        this.f22268z = -1.0f;
        this.f22227A = -1.0f;
        this.f22228B = -1.0f;
        this.f22229C = -1.0f;
        this.f22230D = -1.0f;
        this.f22231E = -1.0f;
        this.f22232F = -1.0f;
        this.f22233G = 1;
        this.f22234H = -1;
        this.f22235I = 8000;
        this.f22236J = 0;
        this.f22237K = 0;
        this.f22239M = true;
        this.f22240N = "eng";
    }

    /* JADX WARNING: Removed duplicated region for block: B:162:0x043a  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0506  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo28931a(com.google.android.gms.internal.ads.zznp r30, int r31) throws com.google.android.gms.internal.ads.zzlm {
        /*
            r29 = this;
            r0 = r29
            java.lang.String r1 = r0.f22243a
            int r2 = r1.hashCode()
            r3 = 8
            r4 = 1
            r5 = 2
            r6 = 0
            r7 = 3
            r8 = -1
            switch(r2) {
                case -2095576542: goto L_0x014b;
                case -2095575984: goto L_0x0141;
                case -1985379776: goto L_0x0136;
                case -1784763192: goto L_0x012b;
                case -1730367663: goto L_0x0120;
                case -1482641358: goto L_0x0115;
                case -1482641357: goto L_0x010a;
                case -1373388978: goto L_0x00ff;
                case -933872740: goto L_0x00f4;
                case -538363189: goto L_0x00e9;
                case -538363109: goto L_0x00de;
                case -425012669: goto L_0x00d2;
                case -356037306: goto L_0x00c6;
                case 62923557: goto L_0x00ba;
                case 62923603: goto L_0x00ae;
                case 62927045: goto L_0x00a2;
                case 82338133: goto L_0x0097;
                case 82338134: goto L_0x008c;
                case 99146302: goto L_0x0080;
                case 444813526: goto L_0x0074;
                case 542569478: goto L_0x0068;
                case 725957860: goto L_0x005c;
                case 855502857: goto L_0x0051;
                case 1422270023: goto L_0x0045;
                case 1809237540: goto L_0x003a;
                case 1950749482: goto L_0x002e;
                case 1950789798: goto L_0x0022;
                case 1951062397: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0155
        L_0x0016:
            java.lang.String r2 = "A_OPUS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 11
            goto L_0x0156
        L_0x0022:
            java.lang.String r2 = "A_FLAC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 21
            goto L_0x0156
        L_0x002e:
            java.lang.String r2 = "A_EAC3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 16
            goto L_0x0156
        L_0x003a:
            java.lang.String r2 = "V_MPEG2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 2
            goto L_0x0156
        L_0x0045:
            java.lang.String r2 = "S_TEXT/UTF8"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 24
            goto L_0x0156
        L_0x0051:
            java.lang.String r2 = "V_MPEGH/ISO/HEVC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 7
            goto L_0x0156
        L_0x005c:
            java.lang.String r2 = "A_PCM/INT/LIT"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 23
            goto L_0x0156
        L_0x0068:
            java.lang.String r2 = "A_DTS/EXPRESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 19
            goto L_0x0156
        L_0x0074:
            java.lang.String r2 = "V_THEORA"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 9
            goto L_0x0156
        L_0x0080:
            java.lang.String r2 = "S_HDMV/PGS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 26
            goto L_0x0156
        L_0x008c:
            java.lang.String r2 = "V_VP9"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 1
            goto L_0x0156
        L_0x0097:
            java.lang.String r2 = "V_VP8"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 0
            goto L_0x0156
        L_0x00a2:
            java.lang.String r2 = "A_DTS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 18
            goto L_0x0156
        L_0x00ae:
            java.lang.String r2 = "A_AC3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 15
            goto L_0x0156
        L_0x00ba:
            java.lang.String r2 = "A_AAC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 12
            goto L_0x0156
        L_0x00c6:
            java.lang.String r2 = "A_DTS/LOSSLESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 20
            goto L_0x0156
        L_0x00d2:
            java.lang.String r2 = "S_VOBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 25
            goto L_0x0156
        L_0x00de:
            java.lang.String r2 = "V_MPEG4/ISO/AVC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 6
            goto L_0x0156
        L_0x00e9:
            java.lang.String r2 = "V_MPEG4/ISO/ASP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 4
            goto L_0x0156
        L_0x00f4:
            java.lang.String r2 = "S_DVBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 27
            goto L_0x0156
        L_0x00ff:
            java.lang.String r2 = "V_MS/VFW/FOURCC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 8
            goto L_0x0156
        L_0x010a:
            java.lang.String r2 = "A_MPEG/L3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 14
            goto L_0x0156
        L_0x0115:
            java.lang.String r2 = "A_MPEG/L2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 13
            goto L_0x0156
        L_0x0120:
            java.lang.String r2 = "A_VORBIS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 10
            goto L_0x0156
        L_0x012b:
            java.lang.String r2 = "A_TRUEHD"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 17
            goto L_0x0156
        L_0x0136:
            java.lang.String r2 = "A_MS/ACM"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 22
            goto L_0x0156
        L_0x0141:
            java.lang.String r2 = "V_MPEG4/ISO/SP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 3
            goto L_0x0156
        L_0x014b:
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0014
            r1 = 5
            goto L_0x0156
        L_0x0155:
            r1 = -1
        L_0x0156:
            java.lang.String r2 = "audio/raw"
            r9 = 4096(0x1000, float:5.74E-42)
            java.lang.String r10 = "video/x-unknown"
            java.lang.String r11 = "audio/x-unknown"
            java.lang.String r12 = "MatroskaExtractor"
            r13 = 0
            switch(r1) {
                case 0: goto L_0x03c1;
                case 1: goto L_0x03b7;
                case 2: goto L_0x03ad;
                case 3: goto L_0x039a;
                case 4: goto L_0x039a;
                case 5: goto L_0x039a;
                case 6: goto L_0x037f;
                case 7: goto L_0x0364;
                case 8: goto L_0x0341;
                case 9: goto L_0x0338;
                case 10: goto L_0x0325;
                case 11: goto L_0x02da;
                case 12: goto L_0x02ca;
                case 13: goto L_0x02be;
                case 14: goto L_0x02b2;
                case 15: goto L_0x02a7;
                case 16: goto L_0x029c;
                case 17: goto L_0x0291;
                case 18: goto L_0x0286;
                case 19: goto L_0x0286;
                case 20: goto L_0x027b;
                case 21: goto L_0x026b;
                case 22: goto L_0x01f8;
                case 23: goto L_0x01b5;
                case 24: goto L_0x01aa;
                case 25: goto L_0x019a;
                case 26: goto L_0x018f;
                case 27: goto L_0x016c;
                default: goto L_0x0164;
            }
        L_0x0164:
            com.google.android.gms.internal.ads.zzlm r1 = new com.google.android.gms.internal.ads.zzlm
            java.lang.String r2 = "Unrecognized codec identifier."
            r1.<init>(r2)
            throw r1
        L_0x016c:
            r1 = 4
            byte[] r1 = new byte[r1]
            byte[] r2 = r0.f22250h
            byte r3 = r2[r6]
            r1[r6] = r3
            byte r3 = r2[r4]
            r1[r4] = r3
            byte r3 = r2[r5]
            r1[r5] = r3
            byte r2 = r2[r7]
            r1[r7] = r2
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r2 = "application/dvbsubs"
            r15 = r2
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x018f:
            java.lang.String r2 = "application/pgs"
            r15 = r2
            r1 = r13
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x019a:
            byte[] r1 = r0.f22250h
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r2 = "application/vobsub"
            r15 = r2
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x01aa:
            java.lang.String r2 = "application/x-subrip"
            r15 = r2
            r1 = r13
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x01b5:
            int r1 = r0.f22234H
            int r1 = com.google.android.gms.internal.ads.zzsy.m31144a(r1)
            if (r1 != 0) goto L_0x01f0
            int r1 = r0.f22234H
            java.lang.String r2 = java.lang.String.valueOf(r11)
            int r2 = r2.length()
            int r2 = r2 + 60
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unsupported PCM bit depth: "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = ". Setting mimeType to "
            r3.append(r1)
            r3.append(r11)
            java.lang.String r1 = r3.toString()
            android.util.Log.w(r12, r1)
            r15 = r11
            r1 = r13
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x01f0:
            r21 = r1
            r15 = r2
            r1 = r13
            r18 = -1
            goto L_0x03ca
        L_0x01f8:
            com.google.android.gms.internal.ads.zzst r1 = new com.google.android.gms.internal.ads.zzst
            byte[] r3 = r0.f22250h
            r1.<init>(r3)
            boolean r1 = m23563b(r1)
            if (r1 == 0) goto L_0x0248
            int r1 = r0.f22234H
            int r1 = com.google.android.gms.internal.ads.zzsy.m31144a(r1)
            if (r1 != 0) goto L_0x0240
            int r1 = r0.f22234H
            java.lang.String r2 = java.lang.String.valueOf(r11)
            int r2 = r2.length()
            int r2 = r2 + 60
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unsupported PCM bit depth: "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = ". Setting mimeType to "
            r3.append(r1)
            r3.append(r11)
            java.lang.String r1 = r3.toString()
            android.util.Log.w(r12, r1)
            r15 = r11
            r1 = r13
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x0240:
            r21 = r1
            r15 = r2
            r1 = r13
            r18 = -1
            goto L_0x03ca
        L_0x0248:
            java.lang.String r1 = "Non-PCM MS/ACM is unsupported. Setting mimeType to "
            java.lang.String r2 = java.lang.String.valueOf(r11)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x025a
            java.lang.String r1 = r1.concat(r2)
            goto L_0x0260
        L_0x025a:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r1 = r2
        L_0x0260:
            android.util.Log.w(r12, r1)
            r15 = r11
            r1 = r13
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x026b:
            byte[] r1 = r0.f22250h
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r2 = "audio/x-flac"
            r15 = r2
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x027b:
            java.lang.String r2 = "audio/vnd.dts.hd"
            r15 = r2
            r1 = r13
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x0286:
            java.lang.String r2 = "audio/vnd.dts"
            r15 = r2
            r1 = r13
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x0291:
            java.lang.String r2 = "audio/true-hd"
            r15 = r2
            r1 = r13
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x029c:
            java.lang.String r2 = "audio/eac3"
            r15 = r2
            r1 = r13
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x02a7:
            java.lang.String r2 = "audio/ac3"
            r15 = r2
            r1 = r13
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x02b2:
            java.lang.String r2 = "audio/mpeg"
            r15 = r2
            r1 = r13
            r18 = 4096(0x1000, float:5.74E-42)
            r21 = -1
            goto L_0x03ca
        L_0x02be:
            java.lang.String r2 = "audio/mpeg-L2"
            r15 = r2
            r1 = r13
            r18 = 4096(0x1000, float:5.74E-42)
            r21 = -1
            goto L_0x03ca
        L_0x02ca:
            byte[] r1 = r0.f22250h
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r2 = "audio/mp4a-latm"
            r15 = r2
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x02da:
            r1 = 5760(0x1680, float:8.071E-42)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r7)
            byte[] r9 = r0.f22250h
            r2.add(r9)
            java.nio.ByteBuffer r9 = java.nio.ByteBuffer.allocate(r3)
            java.nio.ByteOrder r10 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r9 = r9.order(r10)
            long r10 = r0.f22236J
            java.nio.ByteBuffer r9 = r9.putLong(r10)
            byte[] r9 = r9.array()
            r2.add(r9)
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r3)
            java.nio.ByteOrder r9 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r3 = r3.order(r9)
            long r9 = r0.f22237K
            java.nio.ByteBuffer r3 = r3.putLong(r9)
            byte[] r3 = r3.array()
            r2.add(r3)
            java.lang.String r3 = "audio/opus"
            r1 = r2
            r15 = r3
            r18 = 5760(0x1680, float:8.071E-42)
            r21 = -1
            goto L_0x03ca
        L_0x0325:
            r1 = 8192(0x2000, float:1.14794E-41)
            byte[] r2 = r0.f22250h
            java.util.List r2 = m23562a(r2)
            java.lang.String r3 = "audio/vorbis"
            r1 = r2
            r15 = r3
            r18 = 8192(0x2000, float:1.14794E-41)
            r21 = -1
            goto L_0x03ca
        L_0x0338:
            r15 = r10
            r1 = r13
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x0341:
            com.google.android.gms.internal.ads.zzst r1 = new com.google.android.gms.internal.ads.zzst
            byte[] r2 = r0.f22250h
            r1.<init>(r2)
            java.util.List r1 = m23561a(r1)
            if (r1 == 0) goto L_0x0357
            java.lang.String r2 = "video/wvc1"
            r15 = r2
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x0357:
            java.lang.String r2 = "Unsupported FourCC. Setting mimeType to video/x-unknown"
            android.util.Log.w(r12, r2)
            r15 = r10
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x0364:
            com.google.android.gms.internal.ads.zzst r1 = new com.google.android.gms.internal.ads.zzst
            byte[] r2 = r0.f22250h
            r1.<init>(r2)
            com.google.android.gms.internal.ads.zztg r1 = com.google.android.gms.internal.ads.zztg.m31165a(r1)
            java.util.List<byte[]> r2 = r1.f29369a
            int r1 = r1.f29370b
            r0.f22242P = r1
            java.lang.String r1 = "video/hevc"
            r15 = r1
            r1 = r2
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x037f:
            com.google.android.gms.internal.ads.zzst r1 = new com.google.android.gms.internal.ads.zzst
            byte[] r2 = r0.f22250h
            r1.<init>(r2)
            com.google.android.gms.internal.ads.zzta r1 = com.google.android.gms.internal.ads.zzta.m31161a(r1)
            java.util.List<byte[]> r2 = r1.f29354a
            int r1 = r1.f29355b
            r0.f22242P = r1
            java.lang.String r1 = "video/avc"
            r15 = r1
            r1 = r2
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x039a:
            byte[] r1 = r0.f22250h
            if (r1 != 0) goto L_0x03a1
            r1 = r13
            goto L_0x03a5
        L_0x03a1:
            java.util.List r1 = java.util.Collections.singletonList(r1)
        L_0x03a5:
            java.lang.String r2 = "video/mp4v-es"
            r15 = r2
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x03ad:
            java.lang.String r2 = "video/mpeg2"
            r15 = r2
            r1 = r13
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x03b7:
            java.lang.String r2 = "video/x-vnd.on2.vp9"
            r15 = r2
            r1 = r13
            r18 = -1
            r21 = -1
            goto L_0x03ca
        L_0x03c1:
            java.lang.String r2 = "video/x-vnd.on2.vp8"
            r15 = r2
            r1 = r13
            r18 = -1
            r21 = -1
        L_0x03ca:
            boolean r2 = r0.f22239M
            r2 = r2 | r6
            boolean r3 = r0.f22238L
            if (r3 == 0) goto L_0x03d3
            r3 = 2
            goto L_0x03d4
        L_0x03d3:
            r3 = 0
        L_0x03d4:
            r2 = r2 | r3
            boolean r3 = com.google.android.gms.internal.ads.zzsp.m31097a(r15)
            if (r3 == 0) goto L_0x03ff
            java.lang.String r14 = java.lang.Integer.toString(r31)
            r16 = 0
            r17 = -1
            int r3 = r0.f22233G
            int r5 = r0.f22235I
            com.google.android.gms.internal.ads.zzne r6 = r0.f22251i
            java.lang.String r7 = r0.f22240N
            r19 = r3
            r20 = r5
            r22 = r1
            r23 = r6
            r24 = r2
            r25 = r7
            com.google.android.gms.internal.ads.zzlh r1 = com.google.android.gms.internal.ads.zzlh.m30626a(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r7 = 1
            goto L_0x0588
        L_0x03ff:
            boolean r3 = com.google.android.gms.internal.ads.zzsp.m31098b(r15)
            if (r3 == 0) goto L_0x0530
            int r2 = r0.f22256n
            if (r2 != 0) goto L_0x041a
            int r2 = r0.f22254l
            if (r2 != r8) goto L_0x0410
            int r2 = r0.f22252j
        L_0x0410:
            r0.f22254l = r2
            int r2 = r0.f22255m
            if (r2 != r8) goto L_0x0418
            int r2 = r0.f22253k
        L_0x0418:
            r0.f22255m = r2
        L_0x041a:
            int r2 = r0.f22254l
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r2 == r8) goto L_0x0433
            int r4 = r0.f22255m
            if (r4 == r8) goto L_0x0433
            int r7 = r0.f22253k
            int r7 = r7 * r2
            float r2 = (float) r7
            int r7 = r0.f22252j
            int r7 = r7 * r4
            float r4 = (float) r7
            float r2 = r2 / r4
            r24 = r2
            goto L_0x0435
        L_0x0433:
            r24 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0435:
            boolean r2 = r0.f22259q
            if (r2 == 0) goto L_0x0506
            float r2 = r0.f22265w
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x04f6
            float r2 = r0.f22266x
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x04f6
            float r2 = r0.f22267y
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x04f6
            float r2 = r0.f22268z
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x04f6
            float r2 = r0.f22227A
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x04f6
            float r2 = r0.f22228B
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x04f6
            float r2 = r0.f22229C
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x04f6
            float r2 = r0.f22230D
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x04f6
            float r2 = r0.f22231E
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x04f6
            float r2 = r0.f22232F
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x0479
            goto L_0x04f6
        L_0x0479:
            r2 = 25
            byte[] r13 = new byte[r2]
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r13)
            r2.put(r6)
            float r3 = r0.f22265w
            r4 = 1195593728(0x47435000, float:50000.0)
            float r3 = r3 * r4
            r6 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r6
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            float r3 = r0.f22266x
            float r3 = r3 * r4
            float r3 = r3 + r6
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            float r3 = r0.f22267y
            float r3 = r3 * r4
            float r3 = r3 + r6
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            float r3 = r0.f22268z
            float r3 = r3 * r4
            float r3 = r3 + r6
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            float r3 = r0.f22227A
            float r3 = r3 * r4
            float r3 = r3 + r6
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            float r3 = r0.f22228B
            float r3 = r3 * r4
            float r3 = r3 + r6
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            float r3 = r0.f22229C
            float r3 = r3 * r4
            float r3 = r3 + r6
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            float r3 = r0.f22230D
            float r3 = r3 * r4
            float r3 = r3 + r6
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            float r3 = r0.f22231E
            float r3 = r3 + r6
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            float r3 = r0.f22232F
            float r3 = r3 + r6
            int r3 = (int) r3
            short r3 = (short) r3
            r2.putShort(r3)
            int r3 = r0.f22263u
            short r3 = (short) r3
            r2.putShort(r3)
            int r3 = r0.f22264v
            short r3 = (short) r3
            r2.putShort(r3)
            goto L_0x04f7
        L_0x04f6:
        L_0x04f7:
            com.google.android.gms.internal.ads.zztb r2 = new com.google.android.gms.internal.ads.zztb
            int r3 = r0.f22260r
            int r4 = r0.f22262t
            int r6 = r0.f22261s
            r2.<init>(r3, r4, r6, r13)
            r27 = r2
            goto L_0x0508
        L_0x0506:
            r27 = r13
        L_0x0508:
            java.lang.String r14 = java.lang.Integer.toString(r31)
            r16 = 0
            r17 = -1
            int r2 = r0.f22252j
            int r3 = r0.f22253k
            r21 = -1082130432(0xffffffffbf800000, float:-1.0)
            r23 = -1
            byte[] r4 = r0.f22257o
            int r6 = r0.f22258p
            com.google.android.gms.internal.ads.zzne r7 = r0.f22251i
            r19 = r2
            r20 = r3
            r22 = r1
            r25 = r4
            r26 = r6
            r28 = r7
            com.google.android.gms.internal.ads.zzlh r1 = com.google.android.gms.internal.ads.zzlh.m30625a(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            r7 = 2
            goto L_0x0588
        L_0x0530:
            java.lang.String r3 = "application/x-subrip"
            boolean r3 = r3.equals(r15)
            if (r3 == 0) goto L_0x0550
            java.lang.String r14 = java.lang.Integer.toString(r31)
            r16 = 0
            r17 = -1
            java.lang.String r1 = r0.f22240N
            com.google.android.gms.internal.ads.zzne r3 = r0.f22251i
            r18 = r2
            r19 = r1
            r20 = r3
            com.google.android.gms.internal.ads.zzlh r1 = com.google.android.gms.internal.ads.zzlh.m30629a(r14, r15, r16, r17, r18, r19, r20)
            goto L_0x0588
        L_0x0550:
            java.lang.String r2 = "application/vobsub"
            boolean r2 = r2.equals(r15)
            if (r2 != 0) goto L_0x0571
            java.lang.String r2 = "application/pgs"
            boolean r2 = r2.equals(r15)
            if (r2 != 0) goto L_0x0571
            java.lang.String r2 = "application/dvbsubs"
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x0569
            goto L_0x0571
        L_0x0569:
            com.google.android.gms.internal.ads.zzlm r1 = new com.google.android.gms.internal.ads.zzlm
            java.lang.String r2 = "Unexpected MIME type."
            r1.<init>(r2)
            throw r1
        L_0x0571:
            java.lang.String r14 = java.lang.Integer.toString(r31)
            r16 = 0
            r17 = -1
            java.lang.String r2 = r0.f22240N
            com.google.android.gms.internal.ads.zzne r3 = r0.f22251i
            r18 = r1
            r19 = r2
            r20 = r3
            com.google.android.gms.internal.ads.zzlh r1 = com.google.android.gms.internal.ads.zzlh.m30631a(r14, r15, r16, r17, r18, r19, r20)
        L_0x0588:
            int r2 = r0.f22244b
            r3 = r30
            com.google.android.gms.internal.ads.zznw r2 = r3.mo28295b(r2, r7)
            r0.f22241O = r2
            com.google.android.gms.internal.ads.zznw r2 = r0.f22241O
            r2.mo32063a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9415es.mo28931a(com.google.android.gms.internal.ads.zznp, int):void");
    }

    /* renamed from: a */
    private static List<byte[]> m23561a(zzst zzst) throws zzlm {
        try {
            zzst.mo32201c(16);
            if (zzst.mo32216p() != 826496599) {
                return null;
            }
            byte[] bArr = zzst.f29334a;
            for (int b = zzst.mo32198b() + 20; b < bArr.length - 4; b++) {
                if (bArr[b] == 0 && bArr[b + 1] == 0 && bArr[b + 2] == 1 && bArr[b + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, b, bArr.length));
                }
            }
            throw new zzlm("Failed to find FourCC VC1 initialization data");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzlm("Error parsing FourCC VC1 codec private");
        }
    }

    /* renamed from: a */
    private static List<byte[]> m23562a(byte[] bArr) throws zzlm {
        String str = "Error parsing vorbis codec private";
        try {
            if (bArr[0] == 2) {
                int i = 1;
                int i2 = 0;
                while (bArr[i] == -1) {
                    i2 += 255;
                    i++;
                }
                int i3 = i + 1;
                int i4 = i2 + bArr[i];
                int i5 = 0;
                while (bArr[i3] == -1) {
                    i5 += 255;
                    i3++;
                }
                int i6 = i3 + 1;
                int i7 = i5 + bArr[i3];
                if (bArr[i6] == 1) {
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, i6, bArr2, 0, i4);
                    int i8 = i6 + i4;
                    if (bArr[i8] == 3) {
                        int i9 = i8 + i7;
                        if (bArr[i9] == 5) {
                            byte[] bArr3 = new byte[(bArr.length - i9)];
                            System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw new zzlm(str);
                    }
                    throw new zzlm(str);
                }
                throw new zzlm(str);
            }
            throw new zzlm(str);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzlm(str);
        }
    }

    /* renamed from: b */
    private static boolean m23563b(zzst zzst) throws zzlm {
        try {
            int o = zzst.mo32215o();
            if (o == 1) {
                return true;
            }
            if (o != 65534) {
                return false;
            }
            zzst.mo32199b(24);
            if (zzst.mo32204e() == zzod.f28986d.getMostSignificantBits() && zzst.mo32204e() == zzod.f28986d.getLeastSignificantBits()) {
                return true;
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzlm("Error parsing MS/ACM codec private");
        }
    }

    /* synthetic */ C9415es(C9371cs csVar) {
        this();
    }
}
