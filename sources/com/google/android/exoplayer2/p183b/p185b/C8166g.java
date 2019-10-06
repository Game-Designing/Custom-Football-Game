package com.google.android.exoplayer2.p183b.p185b;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.C8275d;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.C8122h;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.p183b.C8158b;
import com.google.android.exoplayer2.p183b.C8260g;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8263j;
import com.google.android.exoplayer2.p183b.C8267n;
import com.google.android.exoplayer2.p183b.C8268o;
import com.google.android.exoplayer2.p183b.C8268o.C8270b;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.p183b.C8272q.C8273a;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8527o;
import com.google.android.exoplayer2.util.C8531r;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.RemoteControlWriter;

/* renamed from: com.google.android.exoplayer2.b.b.g */
/* compiled from: MatroskaExtractor */
public final class C8166g implements C8260g {

    /* renamed from: a */
    public static final C8263j f16877a = C8159a.f16867a;

    /* renamed from: b */
    private static final byte[] f16878b = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, RemoteControlWriter.BLOCK_CMDOK, 45, 45, 62, RemoteControlWriter.BLOCK_CMDOK, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: c */
    private static final byte[] f16879c = {RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK};
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final byte[] f16880d = C8509F.m20472c("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* renamed from: e */
    private static final byte[] f16881e = {68, 105, 97, 108, 111, 103, 117, 101, 58, RemoteControlWriter.BLOCK_CMDOK, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* renamed from: f */
    private static final byte[] f16882f = {RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK};
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final UUID f16883g = new UUID(72057594037932032L, -9223371306706625679L);

    /* renamed from: A */
    private C8168b f16884A;

    /* renamed from: B */
    private boolean f16885B;

    /* renamed from: C */
    private int f16886C;

    /* renamed from: D */
    private long f16887D;

    /* renamed from: E */
    private boolean f16888E;

    /* renamed from: F */
    private long f16889F;

    /* renamed from: G */
    private long f16890G;

    /* renamed from: H */
    private long f16891H;

    /* renamed from: I */
    private C8527o f16892I;

    /* renamed from: J */
    private C8527o f16893J;

    /* renamed from: K */
    private boolean f16894K;

    /* renamed from: L */
    private int f16895L;

    /* renamed from: M */
    private long f16896M;

    /* renamed from: N */
    private long f16897N;

    /* renamed from: O */
    private int f16898O;

    /* renamed from: P */
    private int f16899P;

    /* renamed from: Q */
    private int[] f16900Q;

    /* renamed from: R */
    private int f16901R;

    /* renamed from: S */
    private int f16902S;

    /* renamed from: T */
    private int f16903T;

    /* renamed from: U */
    private int f16904U;

    /* renamed from: V */
    private boolean f16905V;

    /* renamed from: W */
    private boolean f16906W;

    /* renamed from: X */
    private boolean f16907X;

    /* renamed from: Y */
    private boolean f16908Y;

    /* renamed from: Z */
    private byte f16909Z;

    /* renamed from: aa */
    private int f16910aa;

    /* renamed from: ba */
    private int f16911ba;

    /* renamed from: ca */
    private int f16912ca;

    /* renamed from: da */
    private boolean f16913da;

    /* renamed from: ea */
    private boolean f16914ea;

    /* renamed from: fa */
    private C8262i f16915fa;

    /* renamed from: h */
    private final C8163d f16916h;

    /* renamed from: i */
    private final C8171i f16917i;

    /* renamed from: j */
    private final SparseArray<C8168b> f16918j;

    /* renamed from: k */
    private final boolean f16919k;

    /* renamed from: l */
    private final C8535t f16920l;

    /* renamed from: m */
    private final C8535t f16921m;

    /* renamed from: n */
    private final C8535t f16922n;

    /* renamed from: o */
    private final C8535t f16923o;

    /* renamed from: p */
    private final C8535t f16924p;

    /* renamed from: q */
    private final C8535t f16925q;

    /* renamed from: r */
    private final C8535t f16926r;

    /* renamed from: s */
    private final C8535t f16927s;

    /* renamed from: t */
    private final C8535t f16928t;

    /* renamed from: u */
    private ByteBuffer f16929u;

    /* renamed from: v */
    private long f16930v;

    /* renamed from: w */
    private long f16931w;

    /* renamed from: x */
    private long f16932x;

    /* renamed from: y */
    private long f16933y;

    /* renamed from: z */
    private long f16934z;

    /* renamed from: com.google.android.exoplayer2.b.b.g$a */
    /* compiled from: MatroskaExtractor */
    private final class C8167a implements C8164e {
        private C8167a() {
        }

        /* renamed from: b */
        public int mo25216b(int id) {
            switch (id) {
                case Opcodes.LXOR /*131*/:
                case Opcodes.L2I /*136*/:
                case Opcodes.IFLT /*155*/:
                case Opcodes.IF_ICMPEQ /*159*/:
                case Opcodes.ARETURN /*176*/:
                case Opcodes.PUTSTATIC /*179*/:
                case Opcodes.INVOKEDYNAMIC /*186*/:
                case 215:
                case 231:
                case 241:
                case 251:
                case 16980:
                case 17029:
                case 17143:
                case 18401:
                case 18408:
                case 20529:
                case 20530:
                case 21420:
                case 21432:
                case 21680:
                case 21682:
                case 21690:
                case 21930:
                case 21945:
                case 21946:
                case 21947:
                case 21948:
                case 21949:
                case 22186:
                case 22203:
                case 25188:
                case 30321:
                case 2352003:
                case 2807729:
                    return 2;
                case Opcodes.I2F /*134*/:
                case 17026:
                case 21358:
                case 2274716:
                    return 3;
                case Opcodes.IF_ICMPNE /*160*/:
                case Opcodes.FRETURN /*174*/:
                case Opcodes.INVOKESPECIAL /*183*/:
                case Opcodes.NEW /*187*/:
                case 224:
                case 225:
                case 18407:
                case 19899:
                case 20532:
                case 20533:
                case 21936:
                case 21968:
                case 25152:
                case 28032:
                case 30320:
                case 290298740:
                case 357149030:
                case 374648427:
                case 408125543:
                case 440786851:
                case 475249515:
                case 524531317:
                    return 1;
                case Opcodes.IF_ICMPLT /*161*/:
                case Opcodes.IF_ICMPGT /*163*/:
                case 16981:
                case 18402:
                case 21419:
                case 25506:
                case 30322:
                    return 4;
                case Opcodes.PUTFIELD /*181*/:
                case 17545:
                case 21969:
                case 21970:
                case 21971:
                case 21972:
                case 21973:
                case 21974:
                case 21975:
                case 21976:
                case 21977:
                case 21978:
                case 30323:
                case 30324:
                case 30325:
                    return 5;
                default:
                    return 0;
            }
        }

        /* renamed from: c */
        public boolean mo25217c(int id) {
            return id == 357149030 || id == 524531317 || id == 475249515 || id == 374648427;
        }

        /* renamed from: a */
        public void mo25214a(int id, long contentPosition, long contentSize) throws ParserException {
            C8166g.this.mo25222a(id, contentPosition, contentSize);
        }

        /* renamed from: a */
        public void mo25210a(int id) throws ParserException {
            C8166g.this.mo25218a(id);
        }

        /* renamed from: a */
        public void mo25213a(int id, long value) throws ParserException {
            C8166g.this.mo25221a(id, value);
        }

        /* renamed from: a */
        public void mo25211a(int id, double value) throws ParserException {
            C8166g.this.mo25219a(id, value);
        }

        /* renamed from: a */
        public void mo25215a(int id, String value) throws ParserException {
            C8166g.this.mo25223a(id, value);
        }

        /* renamed from: a */
        public void mo25212a(int id, int contentsSize, C8261h input) throws IOException, InterruptedException {
            C8166g.this.mo25220a(id, contentsSize, input);
        }
    }

    /* renamed from: com.google.android.exoplayer2.b.b.g$b */
    /* compiled from: MatroskaExtractor */
    private static final class C8168b {

        /* renamed from: A */
        public int f16936A;

        /* renamed from: B */
        public float f16937B;

        /* renamed from: C */
        public float f16938C;

        /* renamed from: D */
        public float f16939D;

        /* renamed from: E */
        public float f16940E;

        /* renamed from: F */
        public float f16941F;

        /* renamed from: G */
        public float f16942G;

        /* renamed from: H */
        public float f16943H;

        /* renamed from: I */
        public float f16944I;

        /* renamed from: J */
        public float f16945J;

        /* renamed from: K */
        public float f16946K;

        /* renamed from: L */
        public int f16947L;

        /* renamed from: M */
        public int f16948M;

        /* renamed from: N */
        public int f16949N;

        /* renamed from: O */
        public long f16950O;

        /* renamed from: P */
        public long f16951P;

        /* renamed from: Q */
        public C8169c f16952Q;

        /* renamed from: R */
        public boolean f16953R;

        /* renamed from: S */
        public boolean f16954S;
        /* access modifiers changed from: private */

        /* renamed from: T */
        public String f16955T;

        /* renamed from: U */
        public C8272q f16956U;

        /* renamed from: V */
        public int f16957V;

        /* renamed from: a */
        public String f16958a;

        /* renamed from: b */
        public String f16959b;

        /* renamed from: c */
        public int f16960c;

        /* renamed from: d */
        public int f16961d;

        /* renamed from: e */
        public int f16962e;

        /* renamed from: f */
        public boolean f16963f;

        /* renamed from: g */
        public byte[] f16964g;

        /* renamed from: h */
        public C8273a f16965h;

        /* renamed from: i */
        public byte[] f16966i;

        /* renamed from: j */
        public DrmInitData f16967j;

        /* renamed from: k */
        public int f16968k;

        /* renamed from: l */
        public int f16969l;

        /* renamed from: m */
        public int f16970m;

        /* renamed from: n */
        public int f16971n;

        /* renamed from: o */
        public int f16972o;

        /* renamed from: p */
        public int f16973p;

        /* renamed from: q */
        public float f16974q;

        /* renamed from: r */
        public float f16975r;

        /* renamed from: s */
        public float f16976s;

        /* renamed from: t */
        public byte[] f16977t;

        /* renamed from: u */
        public int f16978u;

        /* renamed from: v */
        public boolean f16979v;

        /* renamed from: w */
        public int f16980w;

        /* renamed from: x */
        public int f16981x;

        /* renamed from: y */
        public int f16982y;

        /* renamed from: z */
        public int f16983z;

        private C8168b() {
            this.f16968k = -1;
            this.f16969l = -1;
            this.f16970m = -1;
            this.f16971n = -1;
            this.f16972o = 0;
            this.f16973p = -1;
            this.f16974q = 0.0f;
            this.f16975r = 0.0f;
            this.f16976s = 0.0f;
            this.f16977t = null;
            this.f16978u = -1;
            this.f16979v = false;
            this.f16980w = -1;
            this.f16981x = -1;
            this.f16982y = -1;
            this.f16983z = 1000;
            this.f16936A = 200;
            this.f16937B = -1.0f;
            this.f16938C = -1.0f;
            this.f16939D = -1.0f;
            this.f16940E = -1.0f;
            this.f16941F = -1.0f;
            this.f16942G = -1.0f;
            this.f16943H = -1.0f;
            this.f16944I = -1.0f;
            this.f16945J = -1.0f;
            this.f16946K = -1.0f;
            this.f16947L = 1;
            this.f16948M = -1;
            this.f16949N = 8000;
            this.f16950O = 0;
            this.f16951P = 0;
            this.f16954S = true;
            this.f16955T = "eng";
        }

        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo25225a(com.google.android.exoplayer2.p183b.C8262i r29, int r30) throws com.google.android.exoplayer2.ParserException {
            /*
                r28 = this;
                r0 = r28
                r1 = -1
                r2 = -1
                r3 = 0
                java.lang.String r4 = r0.f16959b
                int r5 = r4.hashCode()
                r6 = 4
                r7 = 1
                r8 = 8
                r9 = 0
                r10 = 3
                r11 = 2
                r12 = -1
                switch(r5) {
                    case -2095576542: goto L_0x0159;
                    case -2095575984: goto L_0x014f;
                    case -1985379776: goto L_0x0144;
                    case -1784763192: goto L_0x0139;
                    case -1730367663: goto L_0x012e;
                    case -1482641358: goto L_0x0123;
                    case -1482641357: goto L_0x0118;
                    case -1373388978: goto L_0x010d;
                    case -933872740: goto L_0x0102;
                    case -538363189: goto L_0x00f7;
                    case -538363109: goto L_0x00ec;
                    case -425012669: goto L_0x00e0;
                    case -356037306: goto L_0x00d4;
                    case 62923557: goto L_0x00c8;
                    case 62923603: goto L_0x00bc;
                    case 62927045: goto L_0x00b0;
                    case 82338133: goto L_0x00a5;
                    case 82338134: goto L_0x009a;
                    case 99146302: goto L_0x008e;
                    case 444813526: goto L_0x0082;
                    case 542569478: goto L_0x0076;
                    case 725957860: goto L_0x006a;
                    case 738597099: goto L_0x005e;
                    case 855502857: goto L_0x0053;
                    case 1422270023: goto L_0x0047;
                    case 1809237540: goto L_0x003c;
                    case 1950749482: goto L_0x0030;
                    case 1950789798: goto L_0x0024;
                    case 1951062397: goto L_0x0018;
                    default: goto L_0x0016;
                }
            L_0x0016:
                goto L_0x0163
            L_0x0018:
                java.lang.String r5 = "A_OPUS"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 11
                goto L_0x0164
            L_0x0024:
                java.lang.String r5 = "A_FLAC"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 21
                goto L_0x0164
            L_0x0030:
                java.lang.String r5 = "A_EAC3"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 16
                goto L_0x0164
            L_0x003c:
                java.lang.String r5 = "V_MPEG2"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 2
                goto L_0x0164
            L_0x0047:
                java.lang.String r5 = "S_TEXT/UTF8"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 24
                goto L_0x0164
            L_0x0053:
                java.lang.String r5 = "V_MPEGH/ISO/HEVC"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 7
                goto L_0x0164
            L_0x005e:
                java.lang.String r5 = "S_TEXT/ASS"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 25
                goto L_0x0164
            L_0x006a:
                java.lang.String r5 = "A_PCM/INT/LIT"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 23
                goto L_0x0164
            L_0x0076:
                java.lang.String r5 = "A_DTS/EXPRESS"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 19
                goto L_0x0164
            L_0x0082:
                java.lang.String r5 = "V_THEORA"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 9
                goto L_0x0164
            L_0x008e:
                java.lang.String r5 = "S_HDMV/PGS"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 27
                goto L_0x0164
            L_0x009a:
                java.lang.String r5 = "V_VP9"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 1
                goto L_0x0164
            L_0x00a5:
                java.lang.String r5 = "V_VP8"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 0
                goto L_0x0164
            L_0x00b0:
                java.lang.String r5 = "A_DTS"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 18
                goto L_0x0164
            L_0x00bc:
                java.lang.String r5 = "A_AC3"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 15
                goto L_0x0164
            L_0x00c8:
                java.lang.String r5 = "A_AAC"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 12
                goto L_0x0164
            L_0x00d4:
                java.lang.String r5 = "A_DTS/LOSSLESS"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 20
                goto L_0x0164
            L_0x00e0:
                java.lang.String r5 = "S_VOBSUB"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 26
                goto L_0x0164
            L_0x00ec:
                java.lang.String r5 = "V_MPEG4/ISO/AVC"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 6
                goto L_0x0164
            L_0x00f7:
                java.lang.String r5 = "V_MPEG4/ISO/ASP"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 4
                goto L_0x0164
            L_0x0102:
                java.lang.String r5 = "S_DVBSUB"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 28
                goto L_0x0164
            L_0x010d:
                java.lang.String r5 = "V_MS/VFW/FOURCC"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 8
                goto L_0x0164
            L_0x0118:
                java.lang.String r5 = "A_MPEG/L3"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 14
                goto L_0x0164
            L_0x0123:
                java.lang.String r5 = "A_MPEG/L2"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 13
                goto L_0x0164
            L_0x012e:
                java.lang.String r5 = "A_VORBIS"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 10
                goto L_0x0164
            L_0x0139:
                java.lang.String r5 = "A_TRUEHD"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 17
                goto L_0x0164
            L_0x0144:
                java.lang.String r5 = "A_MS/ACM"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 22
                goto L_0x0164
            L_0x014f:
                java.lang.String r5 = "V_MPEG4/ISO/SP"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 3
                goto L_0x0164
            L_0x0159:
                java.lang.String r5 = "V_MPEG4/ISO/AP"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0016
                r4 = 5
                goto L_0x0164
            L_0x0163:
                r4 = -1
            L_0x0164:
                java.lang.String r5 = ". Setting mimeType to "
                java.lang.String r13 = "Unsupported PCM bit depth: "
                java.lang.String r14 = "MatroskaExtractor"
                switch(r4) {
                    case 0: goto L_0x02ff;
                    case 1: goto L_0x02fc;
                    case 2: goto L_0x02f9;
                    case 3: goto L_0x02eb;
                    case 4: goto L_0x02eb;
                    case 5: goto L_0x02eb;
                    case 6: goto L_0x02d7;
                    case 7: goto L_0x02c3;
                    case 8: goto L_0x02ad;
                    case 9: goto L_0x02aa;
                    case 10: goto L_0x029f;
                    case 11: goto L_0x025b;
                    case 12: goto L_0x0251;
                    case 13: goto L_0x024b;
                    case 14: goto L_0x0245;
                    case 15: goto L_0x0241;
                    case 16: goto L_0x023d;
                    case 17: goto L_0x0232;
                    case 18: goto L_0x022e;
                    case 19: goto L_0x022e;
                    case 20: goto L_0x022a;
                    case 21: goto L_0x0220;
                    case 22: goto L_0x01d2;
                    case 23: goto L_0x01a9;
                    case 24: goto L_0x01a5;
                    case 25: goto L_0x01a1;
                    case 26: goto L_0x0197;
                    case 27: goto L_0x0193;
                    case 28: goto L_0x0177;
                    default: goto L_0x016d;
                }
            L_0x016d:
                r9 = r29
                com.google.android.exoplayer2.ParserException r4 = new com.google.android.exoplayer2.ParserException
                java.lang.String r5 = "Unrecognized codec identifier."
                r4.<init>(r5)
                throw r4
            L_0x0177:
                java.lang.String r4 = "application/dvbsubs"
                byte[] r5 = new byte[r6]
                byte[] r6 = r0.f16966i
                byte r8 = r6[r9]
                r5[r9] = r8
                byte r8 = r6[r7]
                r5[r7] = r8
                byte r7 = r6[r11]
                r5[r11] = r7
                byte r6 = r6[r10]
                r5[r10] = r6
                java.util.List r3 = java.util.Collections.singletonList(r5)
                goto L_0x0302
            L_0x0193:
                java.lang.String r4 = "application/pgs"
                goto L_0x0302
            L_0x0197:
                java.lang.String r4 = "application/vobsub"
                byte[] r5 = r0.f16966i
                java.util.List r3 = java.util.Collections.singletonList(r5)
                goto L_0x0302
            L_0x01a1:
                java.lang.String r4 = "text/x-ssa"
                goto L_0x0302
            L_0x01a5:
                java.lang.String r4 = "application/x-subrip"
                goto L_0x0302
            L_0x01a9:
                java.lang.String r4 = "audio/raw"
                int r6 = r0.f16948M
                int r2 = com.google.android.exoplayer2.util.C8509F.m20470c(r6)
                if (r2 != 0) goto L_0x0302
                r2 = -1
                java.lang.String r4 = "audio/x-unknown"
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r13)
                int r7 = r0.f16948M
                r6.append(r7)
                r6.append(r5)
                r6.append(r4)
                java.lang.String r5 = r6.toString()
                com.google.android.exoplayer2.util.C8526n.m20534d(r14, r5)
                goto L_0x0302
            L_0x01d2:
                java.lang.String r4 = "audio/raw"
                com.google.android.exoplayer2.util.t r6 = new com.google.android.exoplayer2.util.t
                byte[] r7 = r0.f16966i
                r6.<init>(r7)
                boolean r6 = m18713b(r6)
                if (r6 == 0) goto L_0x0208
                int r6 = r0.f16948M
                int r2 = com.google.android.exoplayer2.util.C8509F.m20470c(r6)
                if (r2 != 0) goto L_0x0302
                r2 = -1
                java.lang.String r4 = "audio/x-unknown"
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r13)
                int r7 = r0.f16948M
                r6.append(r7)
                r6.append(r5)
                r6.append(r4)
                java.lang.String r5 = r6.toString()
                com.google.android.exoplayer2.util.C8526n.m20534d(r14, r5)
                goto L_0x0302
            L_0x0208:
                java.lang.String r4 = "audio/x-unknown"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "Non-PCM MS/ACM is unsupported. Setting mimeType to "
                r5.append(r6)
                r5.append(r4)
                java.lang.String r5 = r5.toString()
                com.google.android.exoplayer2.util.C8526n.m20534d(r14, r5)
                goto L_0x0302
            L_0x0220:
                java.lang.String r4 = "audio/flac"
                byte[] r5 = r0.f16966i
                java.util.List r3 = java.util.Collections.singletonList(r5)
                goto L_0x0302
            L_0x022a:
                java.lang.String r4 = "audio/vnd.dts.hd"
                goto L_0x0302
            L_0x022e:
                java.lang.String r4 = "audio/vnd.dts"
                goto L_0x0302
            L_0x0232:
                java.lang.String r4 = "audio/true-hd"
                com.google.android.exoplayer2.b.b.g$c r5 = new com.google.android.exoplayer2.b.b.g$c
                r5.<init>()
                r0.f16952Q = r5
                goto L_0x0302
            L_0x023d:
                java.lang.String r4 = "audio/eac3"
                goto L_0x0302
            L_0x0241:
                java.lang.String r4 = "audio/ac3"
                goto L_0x0302
            L_0x0245:
                java.lang.String r4 = "audio/mpeg"
                r1 = 4096(0x1000, float:5.74E-42)
                goto L_0x0302
            L_0x024b:
                java.lang.String r4 = "audio/mpeg-L2"
                r1 = 4096(0x1000, float:5.74E-42)
                goto L_0x0302
            L_0x0251:
                java.lang.String r4 = "audio/mp4a-latm"
                byte[] r5 = r0.f16966i
                java.util.List r3 = java.util.Collections.singletonList(r5)
                goto L_0x0302
            L_0x025b:
                java.lang.String r4 = "audio/opus"
                r1 = 5760(0x1680, float:8.071E-42)
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>(r10)
                r3 = r5
                byte[] r5 = r0.f16966i
                r3.add(r5)
                java.nio.ByteBuffer r5 = java.nio.ByteBuffer.allocate(r8)
                java.nio.ByteOrder r6 = java.nio.ByteOrder.nativeOrder()
                java.nio.ByteBuffer r5 = r5.order(r6)
                long r6 = r0.f16950O
                java.nio.ByteBuffer r5 = r5.putLong(r6)
                byte[] r5 = r5.array()
                r3.add(r5)
                java.nio.ByteBuffer r5 = java.nio.ByteBuffer.allocate(r8)
                java.nio.ByteOrder r6 = java.nio.ByteOrder.nativeOrder()
                java.nio.ByteBuffer r5 = r5.order(r6)
                long r6 = r0.f16951P
                java.nio.ByteBuffer r5 = r5.putLong(r6)
                byte[] r5 = r5.array()
                r3.add(r5)
                goto L_0x0302
            L_0x029f:
                java.lang.String r4 = "audio/vorbis"
                r1 = 8192(0x2000, float:1.14794E-41)
                byte[] r5 = r0.f16966i
                java.util.List r3 = m18712a(r5)
                goto L_0x0302
            L_0x02aa:
                java.lang.String r4 = "video/x-unknown"
                goto L_0x0302
            L_0x02ad:
                com.google.android.exoplayer2.util.t r4 = new com.google.android.exoplayer2.util.t
                byte[] r5 = r0.f16966i
                r4.<init>(r5)
                android.util.Pair r4 = m18710a(r4)
                java.lang.Object r5 = r4.first
                java.lang.String r5 = (java.lang.String) r5
                java.lang.Object r6 = r4.second
                r3 = r6
                java.util.List r3 = (java.util.List) r3
                r4 = r5
                goto L_0x0302
            L_0x02c3:
                java.lang.String r4 = "video/hevc"
                com.google.android.exoplayer2.util.t r5 = new com.google.android.exoplayer2.util.t
                byte[] r6 = r0.f16966i
                r5.<init>(r6)
                com.google.android.exoplayer2.video.k r5 = com.google.android.exoplayer2.video.C8557k.m20663a(r5)
                java.util.List<byte[]> r3 = r5.f18926a
                int r6 = r5.f18927b
                r0.f16957V = r6
                goto L_0x0302
            L_0x02d7:
                java.lang.String r4 = "video/avc"
                com.google.android.exoplayer2.util.t r5 = new com.google.android.exoplayer2.util.t
                byte[] r6 = r0.f16966i
                r5.<init>(r6)
                com.google.android.exoplayer2.video.h r5 = com.google.android.exoplayer2.video.C8554h.m20661a(r5)
                java.util.List<byte[]> r3 = r5.f18921a
                int r6 = r5.f18922b
                r0.f16957V = r6
                goto L_0x0302
            L_0x02eb:
                java.lang.String r4 = "video/mp4v-es"
                byte[] r5 = r0.f16966i
                if (r5 != 0) goto L_0x02f3
                r5 = 0
                goto L_0x02f7
            L_0x02f3:
                java.util.List r5 = java.util.Collections.singletonList(r5)
            L_0x02f7:
                r3 = r5
                goto L_0x0302
            L_0x02f9:
                java.lang.String r4 = "video/mpeg2"
                goto L_0x0302
            L_0x02fc:
                java.lang.String r4 = "video/x-vnd.on2.vp9"
                goto L_0x0302
            L_0x02ff:
                java.lang.String r4 = "video/x-vnd.on2.vp8"
            L_0x0302:
                r5 = 0
                boolean r6 = r0.f16954S
                r5 = r5 | r6
                boolean r6 = r0.f16953R
                if (r6 == 0) goto L_0x030b
                r9 = 2
            L_0x030b:
                r5 = r5 | r9
                boolean r6 = com.google.android.exoplayer2.util.C8529q.m20547f(r4)
                if (r6 == 0) goto L_0x0339
                r6 = 1
                java.lang.String r13 = java.lang.Integer.toString(r30)
                r15 = 0
                r16 = -1
                int r7 = r0.f16947L
                int r8 = r0.f16949N
                com.google.android.exoplayer2.drm.DrmInitData r9 = r0.f16967j
                java.lang.String r10 = r0.f16955T
                r14 = r4
                r17 = r1
                r18 = r7
                r19 = r8
                r20 = r2
                r21 = r3
                r22 = r9
                r23 = r5
                r24 = r10
                com.google.android.exoplayer2.Format r7 = com.google.android.exoplayer2.Format.m18249a(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
                goto L_0x04be
            L_0x0339:
                boolean r6 = com.google.android.exoplayer2.util.C8529q.m20549h(r4)
                if (r6 == 0) goto L_0x0431
                r6 = 2
                int r7 = r0.f16972o
                if (r7 != 0) goto L_0x0354
                int r7 = r0.f16970m
                if (r7 != r12) goto L_0x034a
                int r7 = r0.f16968k
            L_0x034a:
                r0.f16970m = r7
                int r7 = r0.f16971n
                if (r7 != r12) goto L_0x0352
                int r7 = r0.f16969l
            L_0x0352:
                r0.f16971n = r7
            L_0x0354:
                r7 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r8 = r0.f16970m
                if (r8 == r12) goto L_0x036a
                int r9 = r0.f16971n
                if (r9 == r12) goto L_0x036a
                int r10 = r0.f16969l
                int r10 = r10 * r8
                float r8 = (float) r10
                int r10 = r0.f16968k
                int r10 = r10 * r9
                float r9 = (float) r10
                float r8 = r8 / r9
                r7 = r8
            L_0x036a:
                r8 = 0
                boolean r9 = r0.f16979v
                if (r9 == 0) goto L_0x037f
                byte[] r9 = r28.m18714c()
                com.google.android.exoplayer2.video.ColorInfo r10 = new com.google.android.exoplayer2.video.ColorInfo
                int r11 = r0.f16980w
                int r12 = r0.f16982y
                int r13 = r0.f16981x
                r10.<init>(r11, r12, r13, r9)
                r8 = r10
            L_0x037f:
                r9 = -1
                java.lang.String r10 = r0.f16958a
                java.lang.String r11 = "htc_video_rotA-000"
                boolean r10 = r11.equals(r10)
                if (r10 == 0) goto L_0x038c
                r9 = 0
                goto L_0x03b2
            L_0x038c:
                java.lang.String r10 = r0.f16958a
                java.lang.String r11 = "htc_video_rotA-090"
                boolean r10 = r11.equals(r10)
                if (r10 == 0) goto L_0x0399
                r9 = 90
                goto L_0x03b2
            L_0x0399:
                java.lang.String r10 = r0.f16958a
                java.lang.String r11 = "htc_video_rotA-180"
                boolean r10 = r11.equals(r10)
                if (r10 == 0) goto L_0x03a6
                r9 = 180(0xb4, float:2.52E-43)
                goto L_0x03b2
            L_0x03a6:
                java.lang.String r10 = r0.f16958a
                java.lang.String r11 = "htc_video_rotA-270"
                boolean r10 = r11.equals(r10)
                if (r10 == 0) goto L_0x03b2
                r9 = 270(0x10e, float:3.78E-43)
            L_0x03b2:
                int r10 = r0.f16973p
                if (r10 != 0) goto L_0x0402
                float r10 = r0.f16974q
                r11 = 0
                int r10 = java.lang.Float.compare(r10, r11)
                if (r10 != 0) goto L_0x0402
                float r10 = r0.f16975r
                int r10 = java.lang.Float.compare(r10, r11)
                if (r10 != 0) goto L_0x0402
                float r10 = r0.f16976s
                int r10 = java.lang.Float.compare(r10, r11)
                if (r10 != 0) goto L_0x03d1
                r9 = 0
                goto L_0x0402
            L_0x03d1:
                float r10 = r0.f16975r
                r11 = 1119092736(0x42b40000, float:90.0)
                int r10 = java.lang.Float.compare(r10, r11)
                if (r10 != 0) goto L_0x03de
                r9 = 90
                goto L_0x0402
            L_0x03de:
                float r10 = r0.f16975r
                r11 = -1020002304(0xffffffffc3340000, float:-180.0)
                int r10 = java.lang.Float.compare(r10, r11)
                if (r10 == 0) goto L_0x0400
                float r10 = r0.f16975r
                r11 = 1127481344(0x43340000, float:180.0)
                int r10 = java.lang.Float.compare(r10, r11)
                if (r10 != 0) goto L_0x03f3
                goto L_0x0400
            L_0x03f3:
                float r10 = r0.f16975r
                r11 = -1028390912(0xffffffffc2b40000, float:-90.0)
                int r10 = java.lang.Float.compare(r10, r11)
                if (r10 != 0) goto L_0x0402
                r9 = 270(0x10e, float:3.78E-43)
                goto L_0x0402
            L_0x0400:
                r9 = 180(0xb4, float:2.52E-43)
            L_0x0402:
                java.lang.String r13 = java.lang.Integer.toString(r30)
                r16 = -1
                int r10 = r0.f16968k
                int r11 = r0.f16969l
                r20 = -1082130432(0xffffffffbf800000, float:-1.0)
                byte[] r12 = r0.f16977t
                int r14 = r0.f16978u
                com.google.android.exoplayer2.drm.DrmInitData r15 = r0.f16967j
                r25 = r14
                r14 = r4
                r27 = r15
                r15 = 0
                r17 = r1
                r18 = r10
                r19 = r11
                r21 = r3
                r22 = r9
                r23 = r7
                r24 = r12
                r26 = r8
                com.google.android.exoplayer2.Format r7 = com.google.android.exoplayer2.Format.m18247a(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
                goto L_0x04be
            L_0x0431:
                java.lang.String r6 = "application/x-subrip"
                boolean r6 = r6.equals(r4)
                if (r6 == 0) goto L_0x0448
                r6 = 3
                java.lang.String r7 = java.lang.Integer.toString(r30)
                java.lang.String r8 = r0.f16955T
                com.google.android.exoplayer2.drm.DrmInitData r9 = r0.f16967j
                com.google.android.exoplayer2.Format r7 = com.google.android.exoplayer2.Format.m18244a(r7, r4, r5, r8, r9)
                goto L_0x04be
            L_0x0448:
                java.lang.String r6 = "text/x-ssa"
                boolean r6 = r6.equals(r4)
                if (r6 == 0) goto L_0x0483
                r6 = 3
                java.util.ArrayList r7 = new java.util.ArrayList
                r7.<init>(r11)
                r3 = r7
                byte[] r7 = com.google.android.exoplayer2.p183b.p185b.C8166g.f16880d
                r3.add(r7)
                byte[] r7 = r0.f16966i
                r3.add(r7)
                java.lang.String r13 = java.lang.Integer.toString(r30)
                r15 = 0
                r16 = -1
                java.lang.String r7 = r0.f16955T
                r19 = -1
                com.google.android.exoplayer2.drm.DrmInitData r8 = r0.f16967j
                r21 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r14 = r4
                r17 = r5
                r18 = r7
                r20 = r8
                r23 = r3
                com.google.android.exoplayer2.Format r7 = com.google.android.exoplayer2.Format.m18251a(r13, r14, r15, r16, r17, r18, r19, r20, r21, r23)
                goto L_0x04be
            L_0x0483:
                java.lang.String r6 = "application/vobsub"
                boolean r6 = r6.equals(r4)
                if (r6 != 0) goto L_0x04a4
                java.lang.String r6 = "application/pgs"
                boolean r6 = r6.equals(r4)
                if (r6 != 0) goto L_0x04a4
                java.lang.String r6 = "application/dvbsubs"
                boolean r6 = r6.equals(r4)
                if (r6 == 0) goto L_0x049c
                goto L_0x04a4
            L_0x049c:
                com.google.android.exoplayer2.ParserException r6 = new com.google.android.exoplayer2.ParserException
                java.lang.String r7 = "Unexpected MIME type."
                r6.<init>(r7)
                throw r6
            L_0x04a4:
                r6 = 3
                java.lang.String r13 = java.lang.Integer.toString(r30)
                r15 = 0
                r16 = -1
                java.lang.String r7 = r0.f16955T
                com.google.android.exoplayer2.drm.DrmInitData r8 = r0.f16967j
                r14 = r4
                r17 = r5
                r18 = r3
                r19 = r7
                r20 = r8
                com.google.android.exoplayer2.Format r7 = com.google.android.exoplayer2.Format.m18252a(r13, r14, r15, r16, r17, r18, r19, r20)
            L_0x04be:
                int r8 = r0.f16960c
                r9 = r29
                com.google.android.exoplayer2.b.q r8 = r9.mo25351a(r8, r6)
                r0.f16956U = r8
                com.google.android.exoplayer2.b.q r8 = r0.f16956U
                r8.mo25340a(r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p183b.p185b.C8166g.C8168b.mo25225a(com.google.android.exoplayer2.b.i, int):void");
        }

        /* renamed from: a */
        public void mo25224a() {
            C8169c cVar = this.f16952Q;
            if (cVar != null) {
                cVar.mo25228a(this);
            }
        }

        /* renamed from: b */
        public void mo25226b() {
            C8169c cVar = this.f16952Q;
            if (cVar != null) {
                cVar.mo25227a();
            }
        }

        /* renamed from: c */
        private byte[] m18714c() {
            if (this.f16937B == -1.0f || this.f16938C == -1.0f || this.f16939D == -1.0f || this.f16940E == -1.0f || this.f16941F == -1.0f || this.f16942G == -1.0f || this.f16943H == -1.0f || this.f16944I == -1.0f || this.f16945J == -1.0f || this.f16946K == -1.0f) {
                return null;
            }
            byte[] hdrStaticInfoData = new byte[25];
            ByteBuffer hdrStaticInfo = ByteBuffer.wrap(hdrStaticInfoData);
            hdrStaticInfo.put(0);
            hdrStaticInfo.putShort((short) ((int) ((this.f16937B * 50000.0f) + 0.5f)));
            hdrStaticInfo.putShort((short) ((int) ((this.f16938C * 50000.0f) + 0.5f)));
            hdrStaticInfo.putShort((short) ((int) ((this.f16939D * 50000.0f) + 0.5f)));
            hdrStaticInfo.putShort((short) ((int) ((this.f16940E * 50000.0f) + 0.5f)));
            hdrStaticInfo.putShort((short) ((int) ((this.f16941F * 50000.0f) + 0.5f)));
            hdrStaticInfo.putShort((short) ((int) ((this.f16942G * 50000.0f) + 0.5f)));
            hdrStaticInfo.putShort((short) ((int) ((this.f16943H * 50000.0f) + 0.5f)));
            hdrStaticInfo.putShort((short) ((int) ((this.f16944I * 50000.0f) + 0.5f)));
            hdrStaticInfo.putShort((short) ((int) (this.f16945J + 0.5f)));
            hdrStaticInfo.putShort((short) ((int) (this.f16946K + 0.5f)));
            hdrStaticInfo.putShort((short) this.f16983z);
            hdrStaticInfo.putShort((short) this.f16936A);
            return hdrStaticInfoData;
        }

        /* renamed from: a */
        private static Pair<String, List<byte[]>> m18710a(C8535t buffer) throws ParserException {
            try {
                buffer.mo26120f(16);
                long compression = buffer.mo26124j();
                if (compression == 1482049860) {
                    return new Pair<>("video/3gpp", null);
                }
                if (compression == 826496599) {
                    int startOffset = buffer.mo26113c() + 20;
                    byte[] bufferData = buffer.f18861a;
                    for (int offset = startOffset; offset < bufferData.length - 4; offset++) {
                        if (bufferData[offset] == 0 && bufferData[offset + 1] == 0 && bufferData[offset + 2] == 1 && bufferData[offset + 3] == 15) {
                            return new Pair<>("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bufferData, offset, bufferData.length)));
                        }
                    }
                    throw new ParserException("Failed to find FourCC VC1 initialization data");
                }
                C8526n.m20534d("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair<>("video/x-unknown", null);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ParserException("Error parsing FourCC private data");
            }
        }

        /* renamed from: a */
        private static List<byte[]> m18712a(byte[] codecPrivate) throws ParserException {
            String str = "Error parsing vorbis codec private";
            try {
                if (codecPrivate[0] == 2) {
                    int offset = 1;
                    int vorbisInfoLength = 0;
                    while (codecPrivate[offset] == -1) {
                        vorbisInfoLength += 255;
                        offset++;
                    }
                    int offset2 = offset + 1;
                    int vorbisInfoLength2 = vorbisInfoLength + codecPrivate[offset];
                    int vorbisSkipLength = 0;
                    while (codecPrivate[offset2] == -1) {
                        vorbisSkipLength += 255;
                        offset2++;
                    }
                    int offset3 = offset2 + 1;
                    int vorbisSkipLength2 = vorbisSkipLength + codecPrivate[offset2];
                    if (codecPrivate[offset3] == 1) {
                        byte[] vorbisInfo = new byte[vorbisInfoLength2];
                        System.arraycopy(codecPrivate, offset3, vorbisInfo, 0, vorbisInfoLength2);
                        int offset4 = offset3 + vorbisInfoLength2;
                        if (codecPrivate[offset4] == 3) {
                            int offset5 = offset4 + vorbisSkipLength2;
                            if (codecPrivate[offset5] == 5) {
                                byte[] vorbisBooks = new byte[(codecPrivate.length - offset5)];
                                System.arraycopy(codecPrivate, offset5, vorbisBooks, 0, codecPrivate.length - offset5);
                                List<byte[]> initializationData = new ArrayList<>(2);
                                initializationData.add(vorbisInfo);
                                initializationData.add(vorbisBooks);
                                return initializationData;
                            }
                            throw new ParserException(str);
                        }
                        throw new ParserException(str);
                    }
                    throw new ParserException(str);
                }
                throw new ParserException(str);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ParserException(str);
            }
        }

        /* renamed from: b */
        private static boolean m18713b(C8535t buffer) throws ParserException {
            try {
                int formatTag = buffer.mo26126l();
                boolean z = true;
                if (formatTag == 1) {
                    return true;
                }
                if (formatTag != 65534) {
                    return false;
                }
                buffer.mo26118e(24);
                if (!(buffer.mo26127m() == C8166g.f16883g.getMostSignificantBits() && buffer.mo26127m() == C8166g.f16883g.getLeastSignificantBits())) {
                    z = false;
                }
                return z;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ParserException("Error parsing MS/ACM codec private");
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.b.b.g$c */
    /* compiled from: MatroskaExtractor */
    private static final class C8169c {

        /* renamed from: a */
        private final byte[] f16984a = new byte[10];

        /* renamed from: b */
        private boolean f16985b;

        /* renamed from: c */
        private int f16986c;

        /* renamed from: d */
        private int f16987d;

        /* renamed from: e */
        private long f16988e;

        /* renamed from: f */
        private int f16989f;

        /* renamed from: a */
        public void mo25227a() {
            this.f16985b = false;
        }

        /* renamed from: a */
        public void mo25230a(C8261h input, int blockFlags, int size) throws IOException, InterruptedException {
            if (!this.f16985b) {
                input.mo25241a(this.f16984a, 0, 10);
                input.mo25239a();
                if (C8122h.m18398b(this.f16984a) != 0) {
                    this.f16985b = true;
                    this.f16986c = 0;
                } else {
                    return;
                }
            }
            if (this.f16986c == 0) {
                this.f16989f = blockFlags;
                this.f16987d = 0;
            }
            this.f16987d += size;
        }

        /* renamed from: a */
        public void mo25229a(C8168b track, long timeUs) {
            if (this.f16985b) {
                int i = this.f16986c;
                this.f16986c = i + 1;
                if (i == 0) {
                    this.f16988e = timeUs;
                }
                if (this.f16986c >= 16) {
                    track.f16956U.mo25339a(this.f16988e, this.f16989f, this.f16987d, 0, track.f16965h);
                    this.f16986c = 0;
                }
            }
        }

        /* renamed from: a */
        public void mo25228a(C8168b track) {
            if (this.f16985b && this.f16986c > 0) {
                track.f16956U.mo25339a(this.f16988e, this.f16989f, this.f16987d, 0, track.f16965h);
                this.f16986c = 0;
            }
        }
    }

    /* renamed from: d */
    static /* synthetic */ C8260g[] m18688d() {
        return new C8260g[]{new C8166g()};
    }

    public C8166g() {
        this(0);
    }

    public C8166g(int flags) {
        this(new C8161c(), flags);
    }

    C8166g(C8163d reader, int flags) {
        this.f16931w = -1;
        this.f16932x = -9223372036854775807L;
        this.f16933y = -9223372036854775807L;
        this.f16934z = -9223372036854775807L;
        this.f16889F = -1;
        this.f16890G = -1;
        this.f16891H = -9223372036854775807L;
        this.f16916h = reader;
        this.f16916h.mo25207a((C8164e) new C8167a());
        this.f16919k = (flags & 1) == 0;
        this.f16917i = new C8171i();
        this.f16918j = new SparseArray<>();
        this.f16922n = new C8535t(4);
        this.f16923o = new C8535t(ByteBuffer.allocate(4).putInt(-1).array());
        this.f16924p = new C8535t(4);
        this.f16920l = new C8535t(C8531r.f18837a);
        this.f16921m = new C8535t(4);
        this.f16925q = new C8535t();
        this.f16926r = new C8535t();
        this.f16927s = new C8535t(8);
        this.f16928t = new C8535t();
    }

    /* renamed from: a */
    public boolean mo25204a(C8261h input) throws IOException, InterruptedException {
        return new C8170h().mo25231a(input);
    }

    /* renamed from: a */
    public void mo25203a(C8262i output) {
        this.f16915fa = output;
    }

    /* renamed from: a */
    public void mo25202a(long position, long timeUs) {
        this.f16891H = -9223372036854775807L;
        this.f16895L = 0;
        this.f16916h.reset();
        this.f16917i.mo25234b();
        m18690f();
        for (int i = 0; i < this.f16918j.size(); i++) {
            ((C8168b) this.f16918j.valueAt(i)).mo25226b();
        }
    }

    /* renamed from: a */
    public void mo25201a() {
    }

    /* renamed from: a */
    public int mo25200a(C8261h input, C8267n seekPosition) throws IOException, InterruptedException {
        this.f16913da = false;
        boolean continueReading = true;
        while (continueReading && !this.f16913da) {
            continueReading = this.f16916h.mo25208a(input);
            if (continueReading && m18683a(seekPosition, input.getPosition())) {
                return 1;
            }
        }
        if (continueReading) {
            return 0;
        }
        for (int i = 0; i < this.f16918j.size(); i++) {
            ((C8168b) this.f16918j.valueAt(i)).mo25224a();
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo25222a(int id, long contentPosition, long contentSize) throws ParserException {
        if (id == 160) {
            this.f16914ea = false;
        } else if (id == 174) {
            this.f16884A = new C8168b();
        } else if (id == 187) {
            this.f16894K = false;
        } else if (id == 19899) {
            this.f16886C = -1;
            this.f16887D = -1;
        } else if (id == 20533) {
            this.f16884A.f16963f = true;
        } else if (id == 21968) {
            this.f16884A.f16979v = true;
        } else if (id == 25152) {
        } else {
            if (id == 408125543) {
                long j = this.f16931w;
                if (j == -1 || j == contentPosition) {
                    this.f16931w = contentPosition;
                    this.f16930v = contentSize;
                    return;
                }
                throw new ParserException("Multiple Segment elements not supported");
            } else if (id == 475249515) {
                this.f16892I = new C8527o();
                this.f16893J = new C8527o();
            } else if (id != 524531317 || this.f16885B) {
            } else {
                if (!this.f16919k || this.f16889F == -1) {
                    this.f16915fa.mo25352a(new C8270b(this.f16934z));
                    this.f16885B = true;
                    return;
                }
                this.f16888E = true;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo25218a(int id) throws ParserException {
        if (id != 160) {
            if (id == 174) {
                if (m18684a(this.f16884A.f16959b)) {
                    C8168b bVar = this.f16884A;
                    bVar.mo25225a(this.f16915fa, bVar.f16960c);
                    SparseArray<C8168b> sparseArray = this.f16918j;
                    C8168b bVar2 = this.f16884A;
                    sparseArray.put(bVar2.f16960c, bVar2);
                }
                this.f16884A = null;
            } else if (id == 19899) {
                int i = this.f16886C;
                if (i != -1) {
                    long j = this.f16887D;
                    if (j != -1) {
                        if (i == 475249515) {
                            this.f16889F = j;
                        }
                    }
                }
                throw new ParserException("Mandatory element SeekID or SeekPosition not found");
            } else if (id == 25152) {
                C8168b bVar3 = this.f16884A;
                if (bVar3.f16963f) {
                    C8273a aVar = bVar3.f16965h;
                    if (aVar != null) {
                        bVar3.f16967j = new DrmInitData(new SchemeData(C8275d.f17531a, "video/webm", aVar.f17519b));
                    } else {
                        throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                    }
                }
            } else if (id == 28032) {
                C8168b bVar4 = this.f16884A;
                if (bVar4.f16963f && bVar4.f16964g != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
            } else if (id == 357149030) {
                if (this.f16932x == -9223372036854775807L) {
                    this.f16932x = 1000000;
                }
                long j2 = this.f16933y;
                if (j2 != -9223372036854775807L) {
                    this.f16934z = m18675a(j2);
                }
            } else if (id != 374648427) {
                if (id == 475249515 && !this.f16885B) {
                    this.f16915fa.mo25352a(m18689e());
                    this.f16885B = true;
                }
            } else if (this.f16918j.size() != 0) {
                this.f16915fa.mo25353g();
            } else {
                throw new ParserException("No valid tracks were found");
            }
        } else if (this.f16895L == 2) {
            if (!this.f16914ea) {
                this.f16903T |= 1;
            }
            m18676a((C8168b) this.f16918j.get(this.f16901R), this.f16896M);
            this.f16895L = 0;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo25221a(int id, long value) throws ParserException {
        String str = " not supported";
        if (id != 20529) {
            if (id != 20530) {
                boolean z = false;
                switch (id) {
                    case Opcodes.LXOR /*131*/:
                        this.f16884A.f16961d = (int) value;
                        return;
                    case Opcodes.L2I /*136*/:
                        C8168b bVar = this.f16884A;
                        if (value == 1) {
                            z = true;
                        }
                        bVar.f16954S = z;
                        return;
                    case Opcodes.IFLT /*155*/:
                        this.f16897N = m18675a(value);
                        return;
                    case Opcodes.IF_ICMPEQ /*159*/:
                        this.f16884A.f16947L = (int) value;
                        return;
                    case Opcodes.ARETURN /*176*/:
                        this.f16884A.f16968k = (int) value;
                        return;
                    case Opcodes.PUTSTATIC /*179*/:
                        this.f16892I.mo26090a(m18675a(value));
                        return;
                    case Opcodes.INVOKEDYNAMIC /*186*/:
                        this.f16884A.f16969l = (int) value;
                        return;
                    case 215:
                        this.f16884A.f16960c = (int) value;
                        return;
                    case 231:
                        this.f16891H = m18675a(value);
                        return;
                    case 241:
                        if (!this.f16894K) {
                            this.f16893J.mo26090a(value);
                            this.f16894K = true;
                            return;
                        }
                        return;
                    case 251:
                        this.f16914ea = true;
                        return;
                    case 16980:
                        if (value != 3) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ContentCompAlgo ");
                            sb.append(value);
                            sb.append(str);
                            throw new ParserException(sb.toString());
                        }
                        return;
                    case 17029:
                        if (value < 1 || value > 2) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("DocTypeReadVersion ");
                            sb2.append(value);
                            sb2.append(str);
                            throw new ParserException(sb2.toString());
                        }
                        return;
                    case 17143:
                        if (value != 1) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("EBMLReadVersion ");
                            sb3.append(value);
                            sb3.append(str);
                            throw new ParserException(sb3.toString());
                        }
                        return;
                    case 18401:
                        if (value != 5) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("ContentEncAlgo ");
                            sb4.append(value);
                            sb4.append(str);
                            throw new ParserException(sb4.toString());
                        }
                        return;
                    case 18408:
                        if (value != 1) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("AESSettingsCipherMode ");
                            sb5.append(value);
                            sb5.append(str);
                            throw new ParserException(sb5.toString());
                        }
                        return;
                    case 21420:
                        this.f16887D = this.f16931w + value;
                        return;
                    case 21432:
                        int layout = (int) value;
                        if (layout == 0) {
                            this.f16884A.f16978u = 0;
                            return;
                        } else if (layout == 1) {
                            this.f16884A.f16978u = 2;
                            return;
                        } else if (layout == 3) {
                            this.f16884A.f16978u = 1;
                            return;
                        } else if (layout == 15) {
                            this.f16884A.f16978u = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        this.f16884A.f16970m = (int) value;
                        return;
                    case 21682:
                        this.f16884A.f16972o = (int) value;
                        return;
                    case 21690:
                        this.f16884A.f16971n = (int) value;
                        return;
                    case 21930:
                        C8168b bVar2 = this.f16884A;
                        if (value == 1) {
                            z = true;
                        }
                        bVar2.f16953R = z;
                        return;
                    case 22186:
                        this.f16884A.f16950O = value;
                        return;
                    case 22203:
                        this.f16884A.f16951P = value;
                        return;
                    case 25188:
                        this.f16884A.f16948M = (int) value;
                        return;
                    case 30321:
                        int i = (int) value;
                        if (i == 0) {
                            this.f16884A.f16973p = 0;
                            return;
                        } else if (i == 1) {
                            this.f16884A.f16973p = 1;
                            return;
                        } else if (i == 2) {
                            this.f16884A.f16973p = 2;
                            return;
                        } else if (i == 3) {
                            this.f16884A.f16973p = 3;
                            return;
                        } else {
                            return;
                        }
                    case 2352003:
                        this.f16884A.f16962e = (int) value;
                        return;
                    case 2807729:
                        this.f16932x = value;
                        return;
                    default:
                        switch (id) {
                            case 21945:
                                int i2 = (int) value;
                                if (i2 == 1) {
                                    this.f16884A.f16982y = 2;
                                    return;
                                } else if (i2 == 2) {
                                    this.f16884A.f16982y = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                int i3 = (int) value;
                                if (i3 != 1) {
                                    if (i3 == 16) {
                                        this.f16884A.f16981x = 6;
                                        return;
                                    } else if (i3 == 18) {
                                        this.f16884A.f16981x = 7;
                                        return;
                                    } else if (!(i3 == 6 || i3 == 7)) {
                                        return;
                                    }
                                }
                                this.f16884A.f16981x = 3;
                                return;
                            case 21947:
                                C8168b bVar3 = this.f16884A;
                                bVar3.f16979v = true;
                                int i4 = (int) value;
                                if (i4 == 1) {
                                    bVar3.f16980w = 1;
                                    return;
                                } else if (i4 == 9) {
                                    bVar3.f16980w = 6;
                                    return;
                                } else if (i4 == 4 || i4 == 5 || i4 == 6 || i4 == 7) {
                                    this.f16884A.f16980w = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case 21948:
                                this.f16884A.f16983z = (int) value;
                                return;
                            case 21949:
                                this.f16884A.f16936A = (int) value;
                                return;
                            default:
                                return;
                        }
                }
            } else if (value != 1) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("ContentEncodingScope ");
                sb6.append(value);
                sb6.append(str);
                throw new ParserException(sb6.toString());
            }
        } else if (value != 0) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append("ContentEncodingOrder ");
            sb7.append(value);
            sb7.append(str);
            throw new ParserException(sb7.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo25219a(int id, double value) {
        if (id == 181) {
            this.f16884A.f16949N = (int) value;
        } else if (id != 17545) {
            switch (id) {
                case 21969:
                    this.f16884A.f16937B = (float) value;
                    return;
                case 21970:
                    this.f16884A.f16938C = (float) value;
                    return;
                case 21971:
                    this.f16884A.f16939D = (float) value;
                    return;
                case 21972:
                    this.f16884A.f16940E = (float) value;
                    return;
                case 21973:
                    this.f16884A.f16941F = (float) value;
                    return;
                case 21974:
                    this.f16884A.f16942G = (float) value;
                    return;
                case 21975:
                    this.f16884A.f16943H = (float) value;
                    return;
                case 21976:
                    this.f16884A.f16944I = (float) value;
                    return;
                case 21977:
                    this.f16884A.f16945J = (float) value;
                    return;
                case 21978:
                    this.f16884A.f16946K = (float) value;
                    return;
                default:
                    switch (id) {
                        case 30323:
                            this.f16884A.f16974q = (float) value;
                            return;
                        case 30324:
                            this.f16884A.f16975r = (float) value;
                            return;
                        case 30325:
                            this.f16884A.f16976s = (float) value;
                            return;
                        default:
                            return;
                    }
            }
        } else {
            this.f16933y = (long) value;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo25223a(int id, String value) throws ParserException {
        if (id == 134) {
            this.f16884A.f16959b = value;
        } else if (id != 17026) {
            if (id == 21358) {
                this.f16884A.f16958a = value;
            } else if (id == 2274716) {
                this.f16884A.f16955T = value;
            }
        } else if (!"webm".equals(value) && !"matroska".equals(value)) {
            StringBuilder sb = new StringBuilder();
            sb.append("DocType ");
            sb.append(value);
            sb.append(" not supported");
            throw new ParserException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01ff, code lost:
        throw new com.google.android.exoplayer2.ParserException("EBML lacing sample size out of range.");
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo25220a(int r23, int r24, com.google.android.exoplayer2.p183b.C8261h r25) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = 161(0xa1, float:2.26E-43)
            r5 = 4
            r6 = 163(0xa3, float:2.28E-43)
            r7 = 0
            r8 = 1
            if (r1 == r4) goto L_0x0094
            if (r1 == r6) goto L_0x0094
            r4 = 16981(0x4255, float:2.3795E-41)
            if (r1 == r4) goto L_0x0087
            r4 = 18402(0x47e2, float:2.5787E-41)
            if (r1 == r4) goto L_0x0077
            r4 = 21419(0x53ab, float:3.0014E-41)
            if (r1 == r4) goto L_0x0058
            r4 = 25506(0x63a2, float:3.5742E-41)
            if (r1 == r4) goto L_0x004b
            r4 = 30322(0x7672, float:4.249E-41)
            if (r1 != r4) goto L_0x0034
            com.google.android.exoplayer2.b.b.g$b r4 = r0.f16884A
            byte[] r5 = new byte[r2]
            r4.f16977t = r5
            byte[] r4 = r4.f16977t
            r3.readFully(r4, r7, r2)
            goto L_0x02b9
        L_0x0034:
            com.google.android.exoplayer2.ParserException r4 = new com.google.android.exoplayer2.ParserException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Unexpected id: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x004b:
            com.google.android.exoplayer2.b.b.g$b r4 = r0.f16884A
            byte[] r5 = new byte[r2]
            r4.f16966i = r5
            byte[] r4 = r4.f16966i
            r3.readFully(r4, r7, r2)
            goto L_0x02b9
        L_0x0058:
            com.google.android.exoplayer2.util.t r4 = r0.f16924p
            byte[] r4 = r4.f18861a
            java.util.Arrays.fill(r4, r7)
            com.google.android.exoplayer2.util.t r4 = r0.f16924p
            byte[] r4 = r4.f18861a
            int r5 = r5 - r2
            r3.readFully(r4, r5, r2)
            com.google.android.exoplayer2.util.t r4 = r0.f16924p
            r4.mo26118e(r7)
            com.google.android.exoplayer2.util.t r4 = r0.f16924p
            long r4 = r4.mo26133s()
            int r5 = (int) r4
            r0.f16886C = r5
            goto L_0x02b9
        L_0x0077:
            byte[] r4 = new byte[r2]
            r3.readFully(r4, r7, r2)
            com.google.android.exoplayer2.b.b.g$b r5 = r0.f16884A
            com.google.android.exoplayer2.b.q$a r6 = new com.google.android.exoplayer2.b.q$a
            r6.<init>(r8, r4, r7, r7)
            r5.f16965h = r6
            goto L_0x02b9
        L_0x0087:
            com.google.android.exoplayer2.b.b.g$b r4 = r0.f16884A
            byte[] r5 = new byte[r2]
            r4.f16964g = r5
            byte[] r4 = r4.f16964g
            r3.readFully(r4, r7, r2)
            goto L_0x02b9
        L_0x0094:
            int r4 = r0.f16895L
            r9 = 8
            if (r4 != 0) goto L_0x00b9
            com.google.android.exoplayer2.b.b.i r4 = r0.f16917i
            long r10 = r4.mo25233a(r3, r7, r8, r9)
            int r4 = (int) r10
            r0.f16901R = r4
            com.google.android.exoplayer2.b.b.i r4 = r0.f16917i
            int r4 = r4.mo25232a()
            r0.f16902S = r4
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.f16897N = r10
            r0.f16895L = r8
            com.google.android.exoplayer2.util.t r4 = r0.f16922n
            r4.mo26139y()
        L_0x00b9:
            android.util.SparseArray<com.google.android.exoplayer2.b.b.g$b> r4 = r0.f16918j
            int r10 = r0.f16901R
            java.lang.Object r4 = r4.get(r10)
            com.google.android.exoplayer2.b.b.g$b r4 = (com.google.android.exoplayer2.p183b.p185b.C8166g.C8168b) r4
            if (r4 != 0) goto L_0x00cf
            int r5 = r0.f16902S
            int r5 = r2 - r5
            r3.mo25248c(r5)
            r0.f16895L = r7
            return
        L_0x00cf:
            int r10 = r0.f16895L
            if (r10 != r8) goto L_0x0285
            r10 = 3
            r0.m18678a(r3, r10)
            com.google.android.exoplayer2.util.t r11 = r0.f16922n
            byte[] r11 = r11.f18861a
            r12 = 2
            byte r11 = r11[r12]
            r11 = r11 & 6
            int r11 = r11 >> r8
            r13 = 255(0xff, float:3.57E-43)
            if (r11 != 0) goto L_0x00fa
            r0.f16899P = r8
            int[] r5 = r0.f16900Q
            int[] r5 = m18685a(r5, r8)
            r0.f16900Q = r5
            int[] r5 = r0.f16900Q
            int r14 = r0.f16902S
            int r14 = r2 - r14
            int r14 = r14 - r10
            r5[r7] = r14
            goto L_0x0215
        L_0x00fa:
            if (r1 != r6) goto L_0x027d
            r0.m18678a(r3, r5)
            com.google.android.exoplayer2.util.t r14 = r0.f16922n
            byte[] r14 = r14.f18861a
            byte r14 = r14[r10]
            r14 = r14 & r13
            int r14 = r14 + r8
            r0.f16899P = r14
            int[] r14 = r0.f16900Q
            int r15 = r0.f16899P
            int[] r14 = m18685a(r14, r15)
            r0.f16900Q = r14
            if (r11 != r12) goto L_0x0124
            int r10 = r0.f16902S
            int r10 = r2 - r10
            int r10 = r10 - r5
            int r5 = r0.f16899P
            int r10 = r10 / r5
            int[] r14 = r0.f16900Q
            java.util.Arrays.fill(r14, r7, r5, r10)
            goto L_0x0215
        L_0x0124:
            if (r11 != r8) goto L_0x015f
            r5 = 0
            r10 = 4
            r14 = 0
        L_0x0129:
            int r15 = r0.f16899P
            int r6 = r15 + -1
            if (r14 >= r6) goto L_0x0152
            int[] r6 = r0.f16900Q
            r6[r14] = r7
        L_0x0133:
            int r10 = r10 + r8
            r0.m18678a(r3, r10)
            com.google.android.exoplayer2.util.t r6 = r0.f16922n
            byte[] r6 = r6.f18861a
            int r15 = r10 + -1
            byte r6 = r6[r15]
            r6 = r6 & r13
            int[] r15 = r0.f16900Q
            r16 = r15[r14]
            int r16 = r16 + r6
            r15[r14] = r16
            if (r6 == r13) goto L_0x0133
            r15 = r15[r14]
            int r5 = r5 + r15
            int r14 = r14 + 1
            r6 = 163(0xa3, float:2.28E-43)
            goto L_0x0129
        L_0x0152:
            int[] r6 = r0.f16900Q
            int r15 = r15 - r8
            int r14 = r0.f16902S
            int r14 = r2 - r14
            int r14 = r14 - r10
            int r14 = r14 - r5
            r6[r15] = r14
            goto L_0x0215
        L_0x015f:
            if (r11 != r10) goto L_0x0266
            r5 = 0
            r6 = 4
            r10 = 0
        L_0x0164:
            int r14 = r0.f16899P
            int r15 = r14 + -1
            if (r10 >= r15) goto L_0x0208
            int[] r14 = r0.f16900Q
            r14[r10] = r7
            int r6 = r6 + 1
            r0.m18678a(r3, r6)
            com.google.android.exoplayer2.util.t r14 = r0.f16922n
            byte[] r14 = r14.f18861a
            int r15 = r6 + -1
            byte r14 = r14[r15]
            if (r14 == 0) goto L_0x0200
            r14 = 0
            r16 = 0
            r12 = r16
        L_0x0183:
            if (r12 >= r9) goto L_0x01d0
            int r16 = 7 - r12
            int r16 = r8 << r16
            com.google.android.exoplayer2.util.t r7 = r0.f16922n
            byte[] r7 = r7.f18861a
            int r17 = r6 + -1
            byte r7 = r7[r17]
            r7 = r7 & r16
            if (r7 == 0) goto L_0x01cb
            int r7 = r6 + -1
            int r6 = r6 + r12
            r0.m18678a(r3, r6)
            com.google.android.exoplayer2.util.t r8 = r0.f16922n
            byte[] r8 = r8.f18861a
            int r18 = r7 + 1
            byte r7 = r8[r7]
            r7 = r7 & r13
            r8 = r16 ^ -1
            r7 = r7 & r8
            long r7 = (long) r7
            r14 = r7
            r7 = r18
        L_0x01ab:
            if (r7 >= r6) goto L_0x01bc
            long r14 = r14 << r9
            com.google.android.exoplayer2.util.t r8 = r0.f16922n
            byte[] r8 = r8.f18861a
            int r18 = r7 + 1
            byte r7 = r8[r7]
            r7 = r7 & r13
            long r7 = (long) r7
            long r14 = r14 | r7
            r7 = r18
            goto L_0x01ab
        L_0x01bc:
            if (r10 <= 0) goto L_0x01d0
            int r8 = r12 * 7
            int r8 = r8 + 6
            r18 = 1
            long r20 = r18 << r8
            long r20 = r20 - r18
            long r14 = r14 - r20
            goto L_0x01d0
        L_0x01cb:
            int r12 = r12 + 1
            r7 = 0
            r8 = 1
            goto L_0x0183
        L_0x01d0:
            r7 = -2147483648(0xffffffff80000000, double:NaN)
            int r12 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r12 < 0) goto L_0x01f8
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r12 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r12 > 0) goto L_0x01f8
            int r7 = (int) r14
            int[] r8 = r0.f16900Q
            if (r10 != 0) goto L_0x01e5
            r12 = r7
            goto L_0x01ea
        L_0x01e5:
            int r12 = r10 + -1
            r12 = r8[r12]
            int r12 = r12 + r7
        L_0x01ea:
            r8[r10] = r12
            int[] r8 = r0.f16900Q
            r8 = r8[r10]
            int r5 = r5 + r8
            int r10 = r10 + 1
            r7 = 0
            r8 = 1
            r12 = 2
            goto L_0x0164
        L_0x01f8:
            com.google.android.exoplayer2.ParserException r7 = new com.google.android.exoplayer2.ParserException
            java.lang.String r8 = "EBML lacing sample size out of range."
            r7.<init>(r8)
            throw r7
        L_0x0200:
            com.google.android.exoplayer2.ParserException r7 = new com.google.android.exoplayer2.ParserException
            java.lang.String r8 = "No valid varint length mask found"
            r7.<init>(r8)
            throw r7
        L_0x0208:
            int[] r7 = r0.f16900Q
            r8 = 1
            int r14 = r14 - r8
            int r8 = r0.f16902S
            int r8 = r2 - r8
            int r8 = r8 - r6
            int r8 = r8 - r5
            r7[r14] = r8
        L_0x0215:
            com.google.android.exoplayer2.util.t r5 = r0.f16922n
            byte[] r5 = r5.f18861a
            r6 = 0
            byte r7 = r5[r6]
            int r6 = r7 << 8
            r7 = 1
            byte r5 = r5[r7]
            r5 = r5 & r13
            r5 = r5 | r6
            long r6 = r0.f16891H
            long r12 = (long) r5
            long r12 = r0.m18675a(r12)
            long r6 = r6 + r12
            r0.f16896M = r6
            com.google.android.exoplayer2.util.t r6 = r0.f16922n
            byte[] r6 = r6.f18861a
            r7 = 2
            byte r6 = r6[r7]
            r6 = r6 & r9
            if (r6 != r9) goto L_0x0239
            r6 = 1
            goto L_0x023a
        L_0x0239:
            r6 = 0
        L_0x023a:
            int r8 = r4.f16961d
            if (r8 == r7) goto L_0x0250
            r8 = 163(0xa3, float:2.28E-43)
            if (r1 != r8) goto L_0x024e
            com.google.android.exoplayer2.util.t r8 = r0.f16922n
            byte[] r8 = r8.f18861a
            byte r8 = r8[r7]
            r7 = 128(0x80, float:1.794E-43)
            r8 = r8 & r7
            if (r8 != r7) goto L_0x024e
            goto L_0x0250
        L_0x024e:
            r7 = 0
            goto L_0x0251
        L_0x0250:
            r7 = 1
        L_0x0251:
            if (r7 == 0) goto L_0x0255
            r8 = 1
            goto L_0x0256
        L_0x0255:
            r8 = 0
        L_0x0256:
            if (r6 == 0) goto L_0x025b
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x025c
        L_0x025b:
            r9 = 0
        L_0x025c:
            r8 = r8 | r9
            r0.f16903T = r8
            r8 = 2
            r0.f16895L = r8
            r8 = 0
            r0.f16898O = r8
            goto L_0x0285
        L_0x0266:
            com.google.android.exoplayer2.ParserException r5 = new com.google.android.exoplayer2.ParserException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Unexpected lacing value: "
            r6.append(r7)
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L_0x027d:
            com.google.android.exoplayer2.ParserException r5 = new com.google.android.exoplayer2.ParserException
            java.lang.String r6 = "Lacing only supported in SimpleBlocks."
            r5.<init>(r6)
            throw r5
        L_0x0285:
            r5 = 163(0xa3, float:2.28E-43)
            if (r1 != r5) goto L_0x02b0
        L_0x0289:
            int r5 = r0.f16898O
            int r6 = r0.f16899P
            if (r5 >= r6) goto L_0x02ac
            int[] r6 = r0.f16900Q
            r5 = r6[r5]
            r0.m18679a(r3, r4, r5)
            long r5 = r0.f16896M
            int r7 = r0.f16898O
            int r8 = r4.f16962e
            int r7 = r7 * r8
            int r7 = r7 / 1000
            long r7 = (long) r7
            long r5 = r5 + r7
            r0.m18676a(r4, r5)
            int r7 = r0.f16898O
            r8 = 1
            int r7 = r7 + r8
            r0.f16898O = r7
            goto L_0x0289
        L_0x02ac:
            r5 = 0
            r0.f16895L = r5
            goto L_0x02b9
        L_0x02b0:
            r5 = 0
            int[] r6 = r0.f16900Q
            r5 = r6[r5]
            r0.m18679a(r3, r4, r5)
        L_0x02b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p183b.p185b.C8166g.mo25220a(int, int, com.google.android.exoplayer2.b.h):void");
    }

    /* renamed from: a */
    private void m18676a(C8168b track, long timeUs) {
        C8168b bVar = track;
        C8169c cVar = bVar.f16952Q;
        if (cVar != null) {
            cVar.mo25229a(bVar, timeUs);
        } else {
            long j = timeUs;
            if ("S_TEXT/UTF8".equals(bVar.f16959b)) {
                C8168b bVar2 = track;
                m18677a(bVar2, "%02d:%02d:%02d,%03d", 19, 1000, f16879c);
            } else {
                if ("S_TEXT/ASS".equals(bVar.f16959b)) {
                    C8168b bVar3 = track;
                    m18677a(bVar3, "%01d:%02d:%02d:%02d", 21, 10000, f16882f);
                }
            }
            bVar.f16956U.mo25339a(timeUs, this.f16903T, this.f16912ca, 0, bVar.f16965h);
        }
        this.f16913da = true;
        m18690f();
    }

    /* renamed from: f */
    private void m18690f() {
        this.f16904U = 0;
        this.f16912ca = 0;
        this.f16911ba = 0;
        this.f16905V = false;
        this.f16906W = false;
        this.f16908Y = false;
        this.f16910aa = 0;
        this.f16909Z = 0;
        this.f16907X = false;
        this.f16925q.mo26139y();
    }

    /* renamed from: a */
    private void m18678a(C8261h input, int requiredLength) throws IOException, InterruptedException {
        if (this.f16922n.mo26115d() < requiredLength) {
            if (this.f16922n.mo26111b() < requiredLength) {
                C8535t tVar = this.f16922n;
                byte[] bArr = tVar.f18861a;
                tVar.mo26109a(Arrays.copyOf(bArr, Math.max(bArr.length * 2, requiredLength)), this.f16922n.mo26115d());
            }
            C8535t tVar2 = this.f16922n;
            input.readFully(tVar2.f18861a, tVar2.mo26115d(), requiredLength - this.f16922n.mo26115d());
            this.f16922n.mo26116d(requiredLength);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:83:0x0210  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m18679a(com.google.android.exoplayer2.p183b.C8261h r18, com.google.android.exoplayer2.p183b.p185b.C8166g.C8168b r19, int r20) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            java.lang.String r4 = r2.f16959b
            java.lang.String r5 = "S_TEXT/UTF8"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x0018
            byte[] r4 = f16878b
            r0.m18680a(r1, r4, r3)
            return
        L_0x0018:
            java.lang.String r4 = r2.f16959b
            java.lang.String r5 = "S_TEXT/ASS"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x0028
            byte[] r4 = f16881e
            r0.m18680a(r1, r4, r3)
            return
        L_0x0028:
            com.google.android.exoplayer2.b.q r4 = r2.f16956U
            boolean r5 = r0.f16905V
            r6 = 4
            r7 = 2
            r8 = 1
            r9 = 0
            if (r5 != 0) goto L_0x017e
            boolean r5 = r2.f16963f
            if (r5 == 0) goto L_0x016f
            int r5 = r0.f16903T
            r10 = -1073741825(0xffffffffbfffffff, float:-1.9999999)
            r5 = r5 & r10
            r0.f16903T = r5
            boolean r5 = r0.f16906W
            r10 = 128(0x80, float:1.794E-43)
            if (r5 != 0) goto L_0x0068
            com.google.android.exoplayer2.util.t r5 = r0.f16922n
            byte[] r5 = r5.f18861a
            r1.readFully(r5, r9, r8)
            int r5 = r0.f16904U
            int r5 = r5 + r8
            r0.f16904U = r5
            com.google.android.exoplayer2.util.t r5 = r0.f16922n
            byte[] r5 = r5.f18861a
            byte r11 = r5[r9]
            r11 = r11 & r10
            if (r11 == r10) goto L_0x0060
            byte r5 = r5[r9]
            r0.f16909Z = r5
            r0.f16906W = r8
            goto L_0x0068
        L_0x0060:
            com.google.android.exoplayer2.ParserException r5 = new com.google.android.exoplayer2.ParserException
            java.lang.String r6 = "Extension bit is set in signal byte"
            r5.<init>(r6)
            throw r5
        L_0x0068:
            byte r5 = r0.f16909Z
            r5 = r5 & r8
            if (r5 != r8) goto L_0x006f
            r5 = 1
            goto L_0x0070
        L_0x006f:
            r5 = 0
        L_0x0070:
            if (r5 == 0) goto L_0x017a
            byte r11 = r0.f16909Z
            r11 = r11 & r7
            if (r11 != r7) goto L_0x0079
            r11 = 1
            goto L_0x007a
        L_0x0079:
            r11 = 0
        L_0x007a:
            int r12 = r0.f16903T
            r13 = 1073741824(0x40000000, float:2.0)
            r12 = r12 | r13
            r0.f16903T = r12
            boolean r12 = r0.f16907X
            if (r12 != 0) goto L_0x00bf
            com.google.android.exoplayer2.util.t r12 = r0.f16927s
            byte[] r12 = r12.f18861a
            r13 = 8
            r1.readFully(r12, r9, r13)
            int r12 = r0.f16904U
            int r12 = r12 + r13
            r0.f16904U = r12
            r0.f16907X = r8
            com.google.android.exoplayer2.util.t r12 = r0.f16922n
            byte[] r12 = r12.f18861a
            if (r11 == 0) goto L_0x009c
            goto L_0x009d
        L_0x009c:
            r10 = 0
        L_0x009d:
            r10 = r10 | r13
            byte r10 = (byte) r10
            r12[r9] = r10
            com.google.android.exoplayer2.util.t r10 = r0.f16922n
            r10.mo26118e(r9)
            com.google.android.exoplayer2.util.t r10 = r0.f16922n
            r4.mo25341a(r10, r8)
            int r10 = r0.f16912ca
            int r10 = r10 + r8
            r0.f16912ca = r10
            com.google.android.exoplayer2.util.t r10 = r0.f16927s
            r10.mo26118e(r9)
            com.google.android.exoplayer2.util.t r10 = r0.f16927s
            r4.mo25341a(r10, r13)
            int r10 = r0.f16912ca
            int r10 = r10 + r13
            r0.f16912ca = r10
        L_0x00bf:
            if (r11 == 0) goto L_0x017a
            boolean r10 = r0.f16908Y
            if (r10 != 0) goto L_0x00e0
            com.google.android.exoplayer2.util.t r10 = r0.f16922n
            byte[] r10 = r10.f18861a
            r1.readFully(r10, r9, r8)
            int r10 = r0.f16904U
            int r10 = r10 + r8
            r0.f16904U = r10
            com.google.android.exoplayer2.util.t r10 = r0.f16922n
            r10.mo26118e(r9)
            com.google.android.exoplayer2.util.t r10 = r0.f16922n
            int r10 = r10.mo26131q()
            r0.f16910aa = r10
            r0.f16908Y = r8
        L_0x00e0:
            int r10 = r0.f16910aa
            int r10 = r10 * 4
            com.google.android.exoplayer2.util.t r12 = r0.f16922n
            r12.mo26114c(r10)
            com.google.android.exoplayer2.util.t r12 = r0.f16922n
            byte[] r12 = r12.f18861a
            r1.readFully(r12, r9, r10)
            int r12 = r0.f16904U
            int r12 = r12 + r10
            r0.f16904U = r12
            int r12 = r0.f16910aa
            int r12 = r12 / r7
            int r12 = r12 + r8
            short r12 = (short) r12
            int r13 = r12 * 6
            int r13 = r13 + r7
            java.nio.ByteBuffer r14 = r0.f16929u
            if (r14 == 0) goto L_0x0107
            int r14 = r14.capacity()
            if (r14 >= r13) goto L_0x010d
        L_0x0107:
            java.nio.ByteBuffer r14 = java.nio.ByteBuffer.allocate(r13)
            r0.f16929u = r14
        L_0x010d:
            java.nio.ByteBuffer r14 = r0.f16929u
            r14.position(r9)
            java.nio.ByteBuffer r14 = r0.f16929u
            r14.putShort(r12)
            r14 = 0
            r15 = 0
        L_0x0119:
            int r6 = r0.f16910aa
            if (r15 >= r6) goto L_0x013e
            r6 = r14
            com.google.android.exoplayer2.util.t r9 = r0.f16922n
            int r14 = r9.mo26135u()
            int r9 = r15 % 2
            if (r9 != 0) goto L_0x0131
            java.nio.ByteBuffer r9 = r0.f16929u
            int r8 = r14 - r6
            short r8 = (short) r8
            r9.putShort(r8)
            goto L_0x0138
        L_0x0131:
            java.nio.ByteBuffer r8 = r0.f16929u
            int r9 = r14 - r6
            r8.putInt(r9)
        L_0x0138:
            int r15 = r15 + 1
            r6 = 4
            r8 = 1
            r9 = 0
            goto L_0x0119
        L_0x013e:
            int r8 = r0.f16904U
            int r8 = r3 - r8
            int r8 = r8 - r14
            int r6 = r6 % r7
            r9 = 1
            if (r6 != r9) goto L_0x014d
            java.nio.ByteBuffer r6 = r0.f16929u
            r6.putInt(r8)
            goto L_0x0159
        L_0x014d:
            java.nio.ByteBuffer r6 = r0.f16929u
            short r9 = (short) r8
            r6.putShort(r9)
            java.nio.ByteBuffer r6 = r0.f16929u
            r9 = 0
            r6.putInt(r9)
        L_0x0159:
            com.google.android.exoplayer2.util.t r6 = r0.f16928t
            java.nio.ByteBuffer r9 = r0.f16929u
            byte[] r9 = r9.array()
            r6.mo26109a(r9, r13)
            com.google.android.exoplayer2.util.t r6 = r0.f16928t
            r4.mo25341a(r6, r13)
            int r6 = r0.f16912ca
            int r6 = r6 + r13
            r0.f16912ca = r6
            goto L_0x017a
        L_0x016f:
            byte[] r5 = r2.f16964g
            if (r5 == 0) goto L_0x017a
            com.google.android.exoplayer2.util.t r6 = r0.f16925q
            int r8 = r5.length
            r6.mo26109a(r5, r8)
            goto L_0x017b
        L_0x017a:
        L_0x017b:
            r5 = 1
            r0.f16905V = r5
        L_0x017e:
            com.google.android.exoplayer2.util.t r5 = r0.f16925q
            int r5 = r5.mo26115d()
            int r3 = r3 + r5
            java.lang.String r5 = r2.f16959b
            java.lang.String r6 = "V_MPEG4/ISO/AVC"
            boolean r5 = r6.equals(r5)
            if (r5 != 0) goto L_0x01bf
            java.lang.String r5 = r2.f16959b
            java.lang.String r6 = "V_MPEGH/ISO/HEVC"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x019a
            goto L_0x01bf
        L_0x019a:
            com.google.android.exoplayer2.b.b.g$c r5 = r2.f16952Q
            if (r5 == 0) goto L_0x01b5
            com.google.android.exoplayer2.util.t r5 = r0.f16925q
            int r5 = r5.mo26115d()
            if (r5 != 0) goto L_0x01a9
            r16 = 1
            goto L_0x01ab
        L_0x01a9:
            r16 = 0
        L_0x01ab:
            com.google.android.exoplayer2.util.C8514e.m20490b(r16)
            com.google.android.exoplayer2.b.b.g$c r5 = r2.f16952Q
            int r6 = r0.f16903T
            r5.mo25230a(r1, r6, r3)
        L_0x01b5:
            int r5 = r0.f16904U
            if (r5 >= r3) goto L_0x0206
            int r5 = r3 - r5
            r0.m18674a(r1, r4, r5)
            goto L_0x01b5
        L_0x01bf:
            com.google.android.exoplayer2.util.t r5 = r0.f16921m
            byte[] r5 = r5.f18861a
            r6 = 0
            r5[r6] = r6
            r8 = 1
            r5[r8] = r6
            r5[r7] = r6
            int r6 = r2.f16957V
            int r7 = r2.f16957V
            r8 = 4
            int r7 = 4 - r7
        L_0x01d2:
            int r8 = r0.f16904U
            if (r8 >= r3) goto L_0x0205
            int r8 = r0.f16911ba
            if (r8 != 0) goto L_0x01fc
            r0.m18681a(r1, r5, r7, r6)
            com.google.android.exoplayer2.util.t r8 = r0.f16921m
            r9 = 0
            r8.mo26118e(r9)
            com.google.android.exoplayer2.util.t r8 = r0.f16921m
            int r8 = r8.mo26135u()
            r0.f16911ba = r8
            com.google.android.exoplayer2.util.t r8 = r0.f16920l
            r8.mo26118e(r9)
            com.google.android.exoplayer2.util.t r8 = r0.f16920l
            r9 = 4
            r4.mo25341a(r8, r9)
            int r8 = r0.f16912ca
            int r8 = r8 + r9
            r0.f16912ca = r8
            goto L_0x01d2
        L_0x01fc:
            int r9 = r0.m18674a(r1, r4, r8)
            int r8 = r8 - r9
            r0.f16911ba = r8
            goto L_0x01d2
        L_0x0205:
        L_0x0206:
            java.lang.String r5 = r2.f16959b
            java.lang.String r6 = "A_VORBIS"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0221
            com.google.android.exoplayer2.util.t r5 = r0.f16923o
            r6 = 0
            r5.mo26118e(r6)
            com.google.android.exoplayer2.util.t r5 = r0.f16923o
            r6 = 4
            r4.mo25341a(r5, r6)
            int r5 = r0.f16912ca
            int r5 = r5 + r6
            r0.f16912ca = r5
        L_0x0221:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p183b.p185b.C8166g.m18679a(com.google.android.exoplayer2.b.h, com.google.android.exoplayer2.b.b.g$b, int):void");
    }

    /* renamed from: a */
    private void m18680a(C8261h input, byte[] samplePrefix, int size) throws IOException, InterruptedException {
        int sizeWithPrefix = samplePrefix.length + size;
        if (this.f16926r.mo26111b() < sizeWithPrefix) {
            this.f16926r.f18861a = Arrays.copyOf(samplePrefix, sizeWithPrefix + size);
        } else {
            System.arraycopy(samplePrefix, 0, this.f16926r.f18861a, 0, samplePrefix.length);
        }
        input.readFully(this.f16926r.f18861a, samplePrefix.length, size);
        this.f16926r.mo26114c(sizeWithPrefix);
    }

    /* renamed from: a */
    private void m18677a(C8168b track, String timecodeFormat, int endTimecodeOffset, long lastTimecodeValueScalingFactor, byte[] emptyTimecode) {
        m18682a(this.f16926r.f18861a, this.f16897N, timecodeFormat, endTimecodeOffset, lastTimecodeValueScalingFactor, emptyTimecode);
        C8272q qVar = track.f16956U;
        C8535t tVar = this.f16926r;
        qVar.mo25341a(tVar, tVar.mo26115d());
        this.f16912ca += this.f16926r.mo26115d();
    }

    /* renamed from: a */
    private static void m18682a(byte[] subripSampleData, long durationUs, String timecodeFormat, int endTimecodeOffset, long lastTimecodeValueScalingFactor, byte[] emptyTimecode) {
        byte[] timeCodeData;
        if (durationUs == -9223372036854775807L) {
            timeCodeData = emptyTimecode;
            long j = durationUs;
            String str = timecodeFormat;
        } else {
            int hours = (int) (durationUs / 3600000000L);
            long durationUs2 = durationUs - (((long) (hours * 3600)) * 1000000);
            int minutes = (int) (durationUs2 / 60000000);
            long durationUs3 = durationUs2 - (((long) (minutes * 60)) * 1000000);
            int seconds = (int) (durationUs3 / 1000000);
            int lastValue = (int) ((durationUs3 - (((long) seconds) * 1000000)) / lastTimecodeValueScalingFactor);
            String str2 = timecodeFormat;
            timeCodeData = C8509F.m20472c(String.format(Locale.US, timecodeFormat, new Object[]{Integer.valueOf(hours), Integer.valueOf(minutes), Integer.valueOf(seconds), Integer.valueOf(lastValue)}));
        }
        byte[] bArr = subripSampleData;
        int i = endTimecodeOffset;
        System.arraycopy(timeCodeData, 0, subripSampleData, endTimecodeOffset, emptyTimecode.length);
    }

    /* renamed from: a */
    private void m18681a(C8261h input, byte[] target, int offset, int length) throws IOException, InterruptedException {
        int pendingStrippedBytes = Math.min(length, this.f16925q.mo26104a());
        input.readFully(target, offset + pendingStrippedBytes, length - pendingStrippedBytes);
        if (pendingStrippedBytes > 0) {
            this.f16925q.mo26110a(target, offset, pendingStrippedBytes);
        }
        this.f16904U += length;
    }

    /* renamed from: a */
    private int m18674a(C8261h input, C8272q output, int length) throws IOException, InterruptedException {
        int bytesRead;
        int strippedBytesLeft = this.f16925q.mo26104a();
        if (strippedBytesLeft > 0) {
            bytesRead = Math.min(length, strippedBytesLeft);
            output.mo25341a(this.f16925q, bytesRead);
        } else {
            bytesRead = output.mo25338a(input, length, false);
        }
        this.f16904U += bytesRead;
        this.f16912ca += bytesRead;
        return bytesRead;
    }

    /* renamed from: e */
    private C8268o m18689e() {
        if (!(this.f16931w == -1 || this.f16934z == -9223372036854775807L)) {
            C8527o oVar = this.f16892I;
            if (!(oVar == null || oVar.mo26088a() == 0)) {
                C8527o oVar2 = this.f16893J;
                if (oVar2 != null && oVar2.mo26088a() == this.f16892I.mo26088a()) {
                    int cuePointsSize = this.f16892I.mo26088a();
                    int[] sizes = new int[cuePointsSize];
                    long[] offsets = new long[cuePointsSize];
                    long[] durationsUs = new long[cuePointsSize];
                    long[] timesUs = new long[cuePointsSize];
                    for (int i = 0; i < cuePointsSize; i++) {
                        timesUs[i] = this.f16892I.mo26089a(i);
                        offsets[i] = this.f16931w + this.f16893J.mo26089a(i);
                    }
                    for (int i2 = 0; i2 < cuePointsSize - 1; i2++) {
                        sizes[i2] = (int) (offsets[i2 + 1] - offsets[i2]);
                        durationsUs[i2] = timesUs[i2 + 1] - timesUs[i2];
                    }
                    sizes[cuePointsSize - 1] = (int) ((this.f16931w + this.f16930v) - offsets[cuePointsSize - 1]);
                    durationsUs[cuePointsSize - 1] = this.f16934z - timesUs[cuePointsSize - 1];
                    this.f16892I = null;
                    this.f16893J = null;
                    return new C8158b(sizes, offsets, durationsUs, timesUs);
                }
            }
        }
        this.f16892I = null;
        this.f16893J = null;
        return new C8270b(this.f16934z);
    }

    /* renamed from: a */
    private boolean m18683a(C8267n seekPosition, long currentPosition) {
        if (this.f16888E) {
            this.f16890G = currentPosition;
            seekPosition.f17510a = this.f16889F;
            this.f16888E = false;
            return true;
        }
        if (this.f16885B) {
            long j = this.f16890G;
            if (j != -1) {
                seekPosition.f17510a = j;
                this.f16890G = -1;
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private long m18675a(long unscaledTimecode) throws ParserException {
        long j = this.f16932x;
        if (j != -9223372036854775807L) {
            return C8509F.m20471c(unscaledTimecode, j, 1000);
        }
        throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
    }

    /* renamed from: a */
    private static boolean m18684a(String codecId) {
        return "V_VP8".equals(codecId) || "V_VP9".equals(codecId) || "V_MPEG2".equals(codecId) || "V_MPEG4/ISO/SP".equals(codecId) || "V_MPEG4/ISO/ASP".equals(codecId) || "V_MPEG4/ISO/AP".equals(codecId) || "V_MPEG4/ISO/AVC".equals(codecId) || "V_MPEGH/ISO/HEVC".equals(codecId) || "V_MS/VFW/FOURCC".equals(codecId) || "V_THEORA".equals(codecId) || "A_OPUS".equals(codecId) || "A_VORBIS".equals(codecId) || "A_AAC".equals(codecId) || "A_MPEG/L2".equals(codecId) || "A_MPEG/L3".equals(codecId) || "A_AC3".equals(codecId) || "A_EAC3".equals(codecId) || "A_TRUEHD".equals(codecId) || "A_DTS".equals(codecId) || "A_DTS/EXPRESS".equals(codecId) || "A_DTS/LOSSLESS".equals(codecId) || "A_FLAC".equals(codecId) || "A_MS/ACM".equals(codecId) || "A_PCM/INT/LIT".equals(codecId) || "S_TEXT/UTF8".equals(codecId) || "S_TEXT/ASS".equals(codecId) || "S_VOBSUB".equals(codecId) || "S_HDMV/PGS".equals(codecId) || "S_DVBSUB".equals(codecId);
    }

    /* renamed from: a */
    private static int[] m18685a(int[] array, int length) {
        if (array == null) {
            return new int[length];
        }
        if (array.length >= length) {
            return array;
        }
        return new int[Math.max(array.length * 2, length)];
    }
}
