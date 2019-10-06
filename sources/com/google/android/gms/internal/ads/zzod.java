package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzne.zza;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.RemoteControlWriter;

public final class zzod implements zznn {

    /* renamed from: a */
    private static final zznq f28983a = new C9371cs();

    /* renamed from: b */
    private static final byte[] f28984b = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, RemoteControlWriter.BLOCK_CMDOK, 45, 45, 62, RemoteControlWriter.BLOCK_CMDOK, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: c */
    private static final byte[] f28985c = {RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK, RemoteControlWriter.BLOCK_CMDOK};
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final UUID f28986d = new UUID(72057594037932032L, -9223371306706625679L);

    /* renamed from: A */
    private long f28987A;

    /* renamed from: B */
    private boolean f28988B;

    /* renamed from: C */
    private long f28989C;

    /* renamed from: D */
    private long f28990D;

    /* renamed from: E */
    private long f28991E;

    /* renamed from: F */
    private zzsn f28992F;

    /* renamed from: G */
    private zzsn f28993G;

    /* renamed from: H */
    private boolean f28994H;

    /* renamed from: I */
    private int f28995I;

    /* renamed from: J */
    private long f28996J;

    /* renamed from: K */
    private long f28997K;

    /* renamed from: L */
    private int f28998L;

    /* renamed from: M */
    private int f28999M;

    /* renamed from: N */
    private int[] f29000N;

    /* renamed from: O */
    private int f29001O;

    /* renamed from: P */
    private int f29002P;

    /* renamed from: Q */
    private int f29003Q;

    /* renamed from: R */
    private int f29004R;

    /* renamed from: S */
    private boolean f29005S;

    /* renamed from: T */
    private boolean f29006T;

    /* renamed from: U */
    private boolean f29007U;

    /* renamed from: V */
    private boolean f29008V;

    /* renamed from: W */
    private byte f29009W;

    /* renamed from: X */
    private int f29010X;

    /* renamed from: Y */
    private int f29011Y;

    /* renamed from: Z */
    private int f29012Z;

    /* renamed from: aa */
    private boolean f29013aa;

    /* renamed from: ba */
    private boolean f29014ba;

    /* renamed from: ca */
    private zznp f29015ca;

    /* renamed from: e */
    private final C9327as f29016e;

    /* renamed from: f */
    private final C9459gs f29017f;

    /* renamed from: g */
    private final SparseArray<C9415es> f29018g;

    /* renamed from: h */
    private final boolean f29019h;

    /* renamed from: i */
    private final zzst f29020i;

    /* renamed from: j */
    private final zzst f29021j;

    /* renamed from: k */
    private final zzst f29022k;

    /* renamed from: l */
    private final zzst f29023l;

    /* renamed from: m */
    private final zzst f29024m;

    /* renamed from: n */
    private final zzst f29025n;

    /* renamed from: o */
    private final zzst f29026o;

    /* renamed from: p */
    private final zzst f29027p;

    /* renamed from: q */
    private final zzst f29028q;

    /* renamed from: r */
    private ByteBuffer f29029r;

    /* renamed from: s */
    private long f29030s;

    /* renamed from: t */
    private long f29031t;

    /* renamed from: u */
    private long f29032u;

    /* renamed from: v */
    private long f29033v;

    /* renamed from: w */
    private long f29034w;

    /* renamed from: x */
    private C9415es f29035x;

    /* renamed from: y */
    private boolean f29036y;

    /* renamed from: z */
    private int f29037z;

    public zzod() {
        this(0);
    }

    private zzod(int i) {
        this(new C9264Yr(), 0);
    }

    private zzod(C9327as asVar, int i) {
        this.f29031t = -1;
        this.f29032u = -9223372036854775807L;
        this.f29033v = -9223372036854775807L;
        this.f29034w = -9223372036854775807L;
        this.f28989C = -1;
        this.f28990D = -1;
        this.f28991E = -9223372036854775807L;
        this.f29016e = asVar;
        this.f29016e.mo28801a((C9349bs) new C9393ds(this, null));
        this.f29019h = true;
        this.f29017f = new C9459gs();
        this.f29018g = new SparseArray<>();
        this.f29022k = new zzst(4);
        this.f29023l = new zzst(ByteBuffer.allocate(4).putInt(-1).array());
        this.f29024m = new zzst(4);
        this.f29020i = new zzst(zzsq.f29316a);
        this.f29021j = new zzst(4);
        this.f29025n = new zzst();
        this.f29026o = new zzst();
        this.f29027p = new zzst(8);
        this.f29028q = new zzst();
    }

    /* renamed from: a */
    public final boolean mo32058a(zzno zzno) throws IOException, InterruptedException {
        return new C9437fs().mo28955a(zzno);
    }

    /* renamed from: a */
    public final void mo32057a(zznp zznp) {
        this.f29015ca = zznp;
    }

    /* renamed from: a */
    public final void mo32056a(long j, long j2) {
        this.f28991E = -9223372036854775807L;
        this.f28995I = 0;
        this.f29016e.reset();
        this.f29017f.mo28980a();
        m30847c();
    }

    /* renamed from: a */
    public final void mo32055a() {
    }

    /* renamed from: a */
    public final int mo32054a(zzno zzno, zznt zznt) throws IOException, InterruptedException {
        boolean z;
        this.f29013aa = false;
        boolean z2 = true;
        while (z2 && !this.f29013aa) {
            z2 = this.f29016e.mo28802a(zzno);
            if (z2) {
                long position = zzno.getPosition();
                if (this.f28988B) {
                    this.f28990D = position;
                    zznt.f28979a = this.f28989C;
                    this.f28988B = false;
                    z = true;
                } else {
                    if (this.f29036y) {
                        long j = this.f28990D;
                        if (j != -1) {
                            zznt.f28979a = j;
                            this.f28990D = -1;
                            z = true;
                        }
                    }
                    z = false;
                }
                if (z) {
                    return 1;
                }
            }
        }
        if (z2) {
            return 0;
        }
        return -1;
    }

    /* renamed from: b */
    static int m30845b(int i) {
        switch (i) {
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
            case 2352003:
            case 2807729:
                return 2;
            case Opcodes.I2F /*134*/:
            case 17026:
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
                return 5;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    static boolean m30843a(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32070a(int i, long j, long j2) throws zzlm {
        if (i == 160) {
            this.f29014ba = false;
        } else if (i == 174) {
            this.f29035x = new C9415es(null);
        } else if (i == 187) {
            this.f28994H = false;
        } else if (i == 19899) {
            this.f29037z = -1;
            this.f28987A = -1;
        } else if (i != 20533) {
            if (i == 21968) {
                this.f29035x.f22259q = true;
            } else if (i == 25152) {
            } else {
                if (i == 408125543) {
                    long j3 = this.f29031t;
                    if (j3 == -1 || j3 == j) {
                        this.f29031t = j;
                        this.f29030s = j2;
                        return;
                    }
                    throw new zzlm("Multiple Segment elements not supported");
                } else if (i == 475249515) {
                    this.f28992F = new zzsn();
                    this.f28993G = new zzsn();
                } else if (i == 524531317 && !this.f29036y) {
                    if (!this.f29019h || this.f28989C == -1) {
                        this.f29015ca.mo28289a(new zznv(this.f29034w));
                        this.f29036y = true;
                        return;
                    }
                    this.f28988B = true;
                }
            }
        } else {
            this.f29035x.f22247e = true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo32072c(int i) throws zzlm {
        zznu zznu;
        int i2;
        int i3 = 0;
        if (i != 160) {
            if (i != 174) {
                if (i == 19899) {
                    int i4 = this.f29037z;
                    if (i4 != -1) {
                        long j = this.f28987A;
                        if (j != -1) {
                            if (i4 == 475249515) {
                                this.f28989C = j;
                                return;
                            }
                        }
                    }
                    throw new zzlm("Mandatory element SeekID or SeekPosition not found");
                } else if (i == 25152) {
                    C9415es esVar = this.f29035x;
                    if (esVar.f22247e) {
                        zznx zznx = esVar.f22249g;
                        if (zznx != null) {
                            esVar.f22251i = new zzne(new zza(zzkt.f28759b, "video/webm", zznx.f28982b));
                            return;
                        }
                        throw new zzlm("Encrypted Track found but ContentEncKeyID was not found");
                    }
                } else if (i == 28032) {
                    C9415es esVar2 = this.f29035x;
                    if (esVar2.f22247e && esVar2.f22248f != null) {
                        throw new zzlm("Combining encryption and compression is not supported");
                    }
                } else if (i == 357149030) {
                    if (this.f29032u == -9223372036854775807L) {
                        this.f29032u = 1000000;
                    }
                    long j2 = this.f29033v;
                    if (j2 != -9223372036854775807L) {
                        this.f29034w = m30839a(j2);
                        return;
                    }
                } else if (i != 374648427) {
                    if (i == 475249515 && !this.f29036y) {
                        zznp zznp = this.f29015ca;
                        if (!(this.f29031t == -1 || this.f29034w == -9223372036854775807L)) {
                            zzsn zzsn = this.f28992F;
                            if (!(zzsn == null || zzsn.mo32190a() == 0)) {
                                zzsn zzsn2 = this.f28993G;
                                if (zzsn2 != null && zzsn2.mo32190a() == this.f28992F.mo32190a()) {
                                    int a = this.f28992F.mo32190a();
                                    int[] iArr = new int[a];
                                    long[] jArr = new long[a];
                                    long[] jArr2 = new long[a];
                                    long[] jArr3 = new long[a];
                                    for (int i5 = 0; i5 < a; i5++) {
                                        jArr3[i5] = this.f28992F.mo32191a(i5);
                                        jArr[i5] = this.f29031t + this.f28993G.mo32191a(i5);
                                    }
                                    while (true) {
                                        i2 = a - 1;
                                        if (i3 >= i2) {
                                            break;
                                        }
                                        int i6 = i3 + 1;
                                        iArr[i3] = (int) (jArr[i6] - jArr[i3]);
                                        jArr2[i3] = jArr3[i6] - jArr3[i3];
                                        i3 = i6;
                                    }
                                    iArr[i2] = (int) ((this.f29031t + this.f29030s) - jArr[i2]);
                                    jArr2[i2] = this.f29034w - jArr3[i2];
                                    this.f28992F = null;
                                    this.f28993G = null;
                                    zznu = new zznl(iArr, jArr, jArr2, jArr3);
                                    zznp.mo28289a(zznu);
                                    this.f29036y = true;
                                    return;
                                }
                            }
                        }
                        this.f28992F = null;
                        this.f28993G = null;
                        zznu = new zznv(this.f29034w);
                        zznp.mo28289a(zznu);
                        this.f29036y = true;
                        return;
                    }
                } else if (this.f29018g.size() != 0) {
                    this.f29015ca.mo28301f();
                } else {
                    throw new zzlm("No valid tracks were found");
                }
                return;
            }
            String str = this.f29035x.f22243a;
            if ("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) {
                i3 = 1;
            }
            if (i3 != 0) {
                C9415es esVar3 = this.f29035x;
                esVar3.mo28931a(this.f29015ca, esVar3.f22244b);
                SparseArray<C9415es> sparseArray = this.f29018g;
                C9415es esVar4 = this.f29035x;
                sparseArray.put(esVar4.f22244b, esVar4);
            }
            this.f29035x = null;
        } else if (this.f28995I == 2) {
            if (!this.f29014ba) {
                this.f29003Q |= 1;
            }
            m30840a((C9415es) this.f29018g.get(this.f29001O), this.f28996J);
            this.f28995I = 0;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32069a(int i, long j) throws zzlm {
        String str = " not supported";
        if (i != 20529) {
            if (i != 20530) {
                boolean z = false;
                switch (i) {
                    case Opcodes.LXOR /*131*/:
                        this.f29035x.f22245c = (int) j;
                        return;
                    case Opcodes.L2I /*136*/:
                        C9415es esVar = this.f29035x;
                        if (j == 1) {
                            z = true;
                        }
                        esVar.f22238L = z;
                        return;
                    case Opcodes.IFLT /*155*/:
                        this.f28997K = m30839a(j);
                        return;
                    case Opcodes.IF_ICMPEQ /*159*/:
                        this.f29035x.f22233G = (int) j;
                        return;
                    case Opcodes.ARETURN /*176*/:
                        this.f29035x.f22252j = (int) j;
                        return;
                    case Opcodes.PUTSTATIC /*179*/:
                        this.f28992F.mo32192a(m30839a(j));
                        return;
                    case Opcodes.INVOKEDYNAMIC /*186*/:
                        this.f29035x.f22253k = (int) j;
                        return;
                    case 215:
                        this.f29035x.f22244b = (int) j;
                        return;
                    case 231:
                        this.f28991E = m30839a(j);
                        return;
                    case 241:
                        if (!this.f28994H) {
                            this.f28993G.mo32192a(j);
                            this.f28994H = true;
                            return;
                        }
                        break;
                    case 251:
                        this.f29014ba = true;
                        return;
                    case 16980:
                        if (j != 3) {
                            StringBuilder sb = new StringBuilder(50);
                            sb.append("ContentCompAlgo ");
                            sb.append(j);
                            sb.append(str);
                            throw new zzlm(sb.toString());
                        }
                        break;
                    case 17029:
                        if (j < 1 || j > 2) {
                            StringBuilder sb2 = new StringBuilder(53);
                            sb2.append("DocTypeReadVersion ");
                            sb2.append(j);
                            sb2.append(str);
                            throw new zzlm(sb2.toString());
                        }
                    case 17143:
                        if (j != 1) {
                            StringBuilder sb3 = new StringBuilder(50);
                            sb3.append("EBMLReadVersion ");
                            sb3.append(j);
                            sb3.append(str);
                            throw new zzlm(sb3.toString());
                        }
                        break;
                    case 18401:
                        if (j != 5) {
                            StringBuilder sb4 = new StringBuilder(49);
                            sb4.append("ContentEncAlgo ");
                            sb4.append(j);
                            sb4.append(str);
                            throw new zzlm(sb4.toString());
                        }
                        break;
                    case 18408:
                        if (j != 1) {
                            StringBuilder sb5 = new StringBuilder(56);
                            sb5.append("AESSettingsCipherMode ");
                            sb5.append(j);
                            sb5.append(str);
                            throw new zzlm(sb5.toString());
                        }
                        break;
                    case 21420:
                        this.f28987A = j + this.f29031t;
                        return;
                    case 21432:
                        int i2 = (int) j;
                        if (i2 == 0) {
                            this.f29035x.f22258p = 0;
                            return;
                        } else if (i2 == 1) {
                            this.f29035x.f22258p = 2;
                            return;
                        } else if (i2 == 3) {
                            this.f29035x.f22258p = 1;
                            return;
                        } else if (i2 == 15) {
                            this.f29035x.f22258p = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        this.f29035x.f22254l = (int) j;
                        return;
                    case 21682:
                        this.f29035x.f22256n = (int) j;
                        return;
                    case 21690:
                        this.f29035x.f22255m = (int) j;
                        return;
                    case 21930:
                        C9415es esVar2 = this.f29035x;
                        if (j == 1) {
                            z = true;
                        }
                        esVar2.f22239M = z;
                        return;
                    case 22186:
                        this.f29035x.f22236J = j;
                        return;
                    case 22203:
                        this.f29035x.f22237K = j;
                        return;
                    case 25188:
                        this.f29035x.f22234H = (int) j;
                        return;
                    case 2352003:
                        this.f29035x.f22246d = (int) j;
                        return;
                    case 2807729:
                        this.f29032u = j;
                        return;
                    default:
                        switch (i) {
                            case 21945:
                                int i3 = (int) j;
                                if (i3 == 1) {
                                    this.f29035x.f22262t = 2;
                                    return;
                                } else if (i3 == 2) {
                                    this.f29035x.f22262t = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                int i4 = (int) j;
                                if (i4 != 1) {
                                    if (i4 == 16) {
                                        this.f29035x.f22261s = 6;
                                        return;
                                    } else if (i4 == 18) {
                                        this.f29035x.f22261s = 7;
                                        return;
                                    } else if (!(i4 == 6 || i4 == 7)) {
                                        return;
                                    }
                                }
                                this.f29035x.f22261s = 3;
                                return;
                            case 21947:
                                C9415es esVar3 = this.f29035x;
                                esVar3.f22259q = true;
                                int i5 = (int) j;
                                if (i5 == 1) {
                                    esVar3.f22260r = 1;
                                    return;
                                } else if (i5 == 9) {
                                    esVar3.f22260r = 6;
                                    return;
                                } else if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                    this.f29035x.f22260r = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case 21948:
                                this.f29035x.f22263u = (int) j;
                                return;
                            case 21949:
                                this.f29035x.f22264v = (int) j;
                                break;
                        }
                }
            } else if (j != 1) {
                StringBuilder sb6 = new StringBuilder(55);
                sb6.append("ContentEncodingScope ");
                sb6.append(j);
                sb6.append(str);
                throw new zzlm(sb6.toString());
            }
        } else if (j != 0) {
            StringBuilder sb7 = new StringBuilder(55);
            sb7.append("ContentEncodingOrder ");
            sb7.append(j);
            sb7.append(str);
            throw new zzlm(sb7.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32067a(int i, double d) {
        if (i == 181) {
            this.f29035x.f22235I = (int) d;
        } else if (i != 17545) {
            switch (i) {
                case 21969:
                    this.f29035x.f22265w = (float) d;
                    return;
                case 21970:
                    this.f29035x.f22266x = (float) d;
                    return;
                case 21971:
                    this.f29035x.f22267y = (float) d;
                    return;
                case 21972:
                    this.f29035x.f22268z = (float) d;
                    return;
                case 21973:
                    this.f29035x.f22227A = (float) d;
                    return;
                case 21974:
                    this.f29035x.f22228B = (float) d;
                    return;
                case 21975:
                    this.f29035x.f22229C = (float) d;
                    return;
                case 21976:
                    this.f29035x.f22230D = (float) d;
                    return;
                case 21977:
                    this.f29035x.f22231E = (float) d;
                    return;
                case 21978:
                    this.f29035x.f22232F = (float) d;
                    break;
            }
        } else {
            this.f29033v = (long) d;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32071a(int i, String str) throws zzlm {
        if (i != 134) {
            if (i != 17026) {
                if (i == 2274716) {
                    this.f29035x.f22240N = str;
                }
            } else if (!"webm".equals(str) && !"matroska".equals(str)) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
                sb.append("DocType ");
                sb.append(str);
                sb.append(" not supported");
                throw new zzlm(sb.toString());
            }
            return;
        }
        this.f29035x.f22243a = str;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x020a, code lost:
        throw new com.google.android.gms.internal.ads.zzlm("EBML lacing sample size out of range.");
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo32068a(int r20, int r21, com.google.android.gms.internal.ads.zzno r22) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = 161(0xa1, float:2.26E-43)
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 4
            r7 = 0
            r8 = 1
            if (r1 == r4) goto L_0x0091
            if (r1 == r5) goto L_0x0091
            r4 = 16981(0x4255, float:2.3795E-41)
            if (r1 == r4) goto L_0x0085
            r4 = 18402(0x47e2, float:2.5787E-41)
            if (r1 == r4) goto L_0x0076
            r4 = 21419(0x53ab, float:3.0014E-41)
            if (r1 == r4) goto L_0x0058
            r4 = 25506(0x63a2, float:3.5742E-41)
            if (r1 == r4) goto L_0x004c
            r4 = 30322(0x7672, float:4.249E-41)
            if (r1 != r4) goto L_0x0033
            com.google.android.gms.internal.ads.es r1 = r0.f29035x
            byte[] r4 = new byte[r2]
            r1.f22257o = r4
            byte[] r1 = r1.f22257o
            r3.readFully(r1, r7, r2)
            return
        L_0x0033:
            com.google.android.gms.internal.ads.zzlm r2 = new com.google.android.gms.internal.ads.zzlm
            r3 = 26
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Unexpected id: "
            r4.append(r3)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r2.<init>(r1)
            throw r2
        L_0x004c:
            com.google.android.gms.internal.ads.es r1 = r0.f29035x
            byte[] r4 = new byte[r2]
            r1.f22250h = r4
            byte[] r1 = r1.f22250h
            r3.readFully(r1, r7, r2)
            return
        L_0x0058:
            com.google.android.gms.internal.ads.zzst r1 = r0.f29024m
            byte[] r1 = r1.f29334a
            java.util.Arrays.fill(r1, r7)
            com.google.android.gms.internal.ads.zzst r1 = r0.f29024m
            byte[] r1 = r1.f29334a
            int r6 = r6 - r2
            r3.readFully(r1, r6, r2)
            com.google.android.gms.internal.ads.zzst r1 = r0.f29024m
            r1.mo32199b(r7)
            com.google.android.gms.internal.ads.zzst r1 = r0.f29024m
            long r1 = r1.mo32210j()
            int r2 = (int) r1
            r0.f29037z = r2
            return
        L_0x0076:
            byte[] r1 = new byte[r2]
            r3.readFully(r1, r7, r2)
            com.google.android.gms.internal.ads.es r2 = r0.f29035x
            com.google.android.gms.internal.ads.zznx r3 = new com.google.android.gms.internal.ads.zznx
            r3.<init>(r8, r1)
            r2.f22249g = r3
            return
        L_0x0085:
            com.google.android.gms.internal.ads.es r1 = r0.f29035x
            byte[] r4 = new byte[r2]
            r1.f22248f = r4
            byte[] r1 = r1.f22248f
            r3.readFully(r1, r7, r2)
            return
        L_0x0091:
            int r4 = r0.f28995I
            r9 = 8
            if (r4 != 0) goto L_0x00b6
            com.google.android.gms.internal.ads.gs r4 = r0.f29017f
            long r10 = r4.mo28979a(r3, r7, r8, r9)
            int r4 = (int) r10
            r0.f29001O = r4
            com.google.android.gms.internal.ads.gs r4 = r0.f29017f
            int r4 = r4.mo28981b()
            r0.f29002P = r4
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.f28997K = r10
            r0.f28995I = r8
            com.google.android.gms.internal.ads.zzst r4 = r0.f29022k
            r4.mo32209i()
        L_0x00b6:
            android.util.SparseArray<com.google.android.gms.internal.ads.es> r4 = r0.f29018g
            int r10 = r0.f29001O
            java.lang.Object r4 = r4.get(r10)
            com.google.android.gms.internal.ads.es r4 = (com.google.android.gms.internal.ads.C9415es) r4
            if (r4 != 0) goto L_0x00cc
            int r1 = r0.f29002P
            int r1 = r2 - r1
            r3.mo32045a(r1)
            r0.f28995I = r7
            return
        L_0x00cc:
            int r10 = r0.f28995I
            if (r10 != r8) goto L_0x0290
            r10 = 3
            r0.m30841a(r3, r10)
            com.google.android.gms.internal.ads.zzst r11 = r0.f29022k
            byte[] r11 = r11.f29334a
            r12 = 2
            byte r11 = r11[r12]
            r11 = r11 & 6
            int r11 = r11 >> r8
            r13 = 255(0xff, float:3.57E-43)
            if (r11 != 0) goto L_0x00f6
            r0.f28999M = r8
            int[] r6 = r0.f29000N
            int[] r6 = m30844a(r6, r8)
            r0.f29000N = r6
            int[] r6 = r0.f29000N
            int r11 = r0.f29002P
            int r2 = r2 - r11
            int r2 = r2 - r10
            r6[r7] = r2
            goto L_0x021f
        L_0x00f6:
            if (r1 != r5) goto L_0x0288
            r0.m30841a(r3, r6)
            com.google.android.gms.internal.ads.zzst r14 = r0.f29022k
            byte[] r14 = r14.f29334a
            byte r14 = r14[r10]
            r14 = r14 & r13
            int r14 = r14 + r8
            r0.f28999M = r14
            int[] r14 = r0.f29000N
            int r15 = r0.f28999M
            int[] r14 = m30844a(r14, r15)
            r0.f29000N = r14
            if (r11 != r12) goto L_0x011f
            int r10 = r0.f29002P
            int r2 = r2 - r10
            int r2 = r2 - r6
            int r6 = r0.f28999M
            int r2 = r2 / r6
            int[] r10 = r0.f29000N
            java.util.Arrays.fill(r10, r7, r6, r2)
            goto L_0x021f
        L_0x011f:
            if (r11 != r8) goto L_0x0159
            r6 = 0
            r10 = 4
            r11 = 0
        L_0x0126:
            int r14 = r0.f28999M
            int r15 = r14 + -1
            if (r6 >= r15) goto L_0x014d
            int[] r14 = r0.f29000N
            r14[r6] = r7
        L_0x0130:
            int r10 = r10 + r8
            r0.m30841a(r3, r10)
            com.google.android.gms.internal.ads.zzst r14 = r0.f29022k
            byte[] r14 = r14.f29334a
            int r15 = r10 + -1
            byte r14 = r14[r15]
            r14 = r14 & r13
            int[] r15 = r0.f29000N
            r16 = r15[r6]
            int r16 = r16 + r14
            r15[r6] = r16
            if (r14 == r13) goto L_0x0130
            r14 = r15[r6]
            int r11 = r11 + r14
            int r6 = r6 + 1
            goto L_0x0126
        L_0x014d:
            int[] r6 = r0.f29000N
            int r14 = r14 - r8
            int r15 = r0.f29002P
            int r2 = r2 - r15
            int r2 = r2 - r10
            int r2 = r2 - r11
            r6[r14] = r2
            goto L_0x021f
        L_0x0159:
            if (r11 != r10) goto L_0x026f
            r6 = 0
            r10 = 4
            r11 = 0
        L_0x0160:
            int r14 = r0.f28999M
            int r15 = r14 + -1
            if (r6 >= r15) goto L_0x0213
            int[] r14 = r0.f29000N
            r14[r6] = r7
            int r10 = r10 + 1
            r0.m30841a(r3, r10)
            com.google.android.gms.internal.ads.zzst r14 = r0.f29022k
            byte[] r14 = r14.f29334a
            int r15 = r10 + -1
            byte r14 = r14[r15]
            if (r14 == 0) goto L_0x020b
            r16 = 0
            r14 = 0
        L_0x017c:
            if (r14 >= r9) goto L_0x01d6
            int r18 = 7 - r14
            int r18 = r8 << r18
            com.google.android.gms.internal.ads.zzst r5 = r0.f29022k
            byte[] r5 = r5.f29334a
            byte r5 = r5[r15]
            r5 = r5 & r18
            if (r5 == 0) goto L_0x01cc
            int r10 = r10 + r14
            r0.m30841a(r3, r10)
            com.google.android.gms.internal.ads.zzst r5 = r0.f29022k
            byte[] r5 = r5.f29334a
            int r16 = r15 + 1
            byte r5 = r5[r15]
            r5 = r5 & r13
            r15 = r18 ^ -1
            r5 = r5 & r15
            long r7 = (long) r5
            r5 = r16
            r16 = r7
        L_0x01a2:
            if (r5 >= r10) goto L_0x01b9
            long r7 = r16 << r9
            com.google.android.gms.internal.ads.zzst r15 = r0.f29022k
            byte[] r15 = r15.f29334a
            int r16 = r5 + 1
            byte r5 = r15[r5]
            r5 = r5 & r13
            long r12 = (long) r5
            long r7 = r7 | r12
            r5 = r16
            r12 = 2
            r13 = 255(0xff, float:3.57E-43)
            r16 = r7
            goto L_0x01a2
        L_0x01b9:
            if (r6 <= 0) goto L_0x01c9
            int r14 = r14 * 7
            int r14 = r14 + 6
            r7 = 1
            long r12 = r7 << r14
            long r12 = r12 - r7
            long r16 = r16 - r12
            r7 = r16
            goto L_0x01d8
        L_0x01c9:
            r7 = r16
            goto L_0x01d8
        L_0x01cc:
            int r14 = r14 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r7 = 0
            r8 = 1
            r12 = 2
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x017c
        L_0x01d6:
            r7 = r16
        L_0x01d8:
            r12 = -2147483648(0xffffffff80000000, double:NaN)
            int r5 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r5 < 0) goto L_0x0203
            r12 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r5 > 0) goto L_0x0203
            int r5 = (int) r7
            int[] r7 = r0.f29000N
            if (r6 != 0) goto L_0x01ec
            goto L_0x01f1
        L_0x01ec:
            int r8 = r6 + -1
            r8 = r7[r8]
            int r5 = r5 + r8
        L_0x01f1:
            r7[r6] = r5
            int[] r5 = r0.f29000N
            r5 = r5[r6]
            int r11 = r11 + r5
            int r6 = r6 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r7 = 0
            r8 = 1
            r12 = 2
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x0160
        L_0x0203:
            com.google.android.gms.internal.ads.zzlm r1 = new com.google.android.gms.internal.ads.zzlm
            java.lang.String r2 = "EBML lacing sample size out of range."
            r1.<init>(r2)
            throw r1
        L_0x020b:
            com.google.android.gms.internal.ads.zzlm r1 = new com.google.android.gms.internal.ads.zzlm
            java.lang.String r2 = "No valid varint length mask found"
            r1.<init>(r2)
            throw r1
        L_0x0213:
            int[] r5 = r0.f29000N
            r6 = 1
            int r14 = r14 - r6
            int r6 = r0.f29002P
            int r2 = r2 - r6
            int r2 = r2 - r10
            int r2 = r2 - r11
            r5[r14] = r2
        L_0x021f:
            com.google.android.gms.internal.ads.zzst r2 = r0.f29022k
            byte[] r2 = r2.f29334a
            r5 = 0
            byte r6 = r2[r5]
            int r5 = r6 << 8
            r6 = 1
            byte r2 = r2[r6]
            r6 = 255(0xff, float:3.57E-43)
            r2 = r2 & r6
            r2 = r2 | r5
            long r5 = r0.f28991E
            long r7 = (long) r2
            long r7 = r0.m30839a(r7)
            long r5 = r5 + r7
            r0.f28996J = r5
            com.google.android.gms.internal.ads.zzst r2 = r0.f29022k
            byte[] r2 = r2.f29334a
            r5 = 2
            byte r2 = r2[r5]
            r2 = r2 & r9
            if (r2 != r9) goto L_0x0245
            r2 = 1
            goto L_0x0246
        L_0x0245:
            r2 = 0
        L_0x0246:
            int r6 = r4.f22245c
            if (r6 == r5) goto L_0x025c
            r6 = 163(0xa3, float:2.28E-43)
            if (r1 != r6) goto L_0x025a
            com.google.android.gms.internal.ads.zzst r6 = r0.f29022k
            byte[] r6 = r6.f29334a
            byte r6 = r6[r5]
            r5 = 128(0x80, float:1.794E-43)
            r6 = r6 & r5
            if (r6 != r5) goto L_0x025a
            goto L_0x025c
        L_0x025a:
            r5 = 0
            goto L_0x025d
        L_0x025c:
            r5 = 1
        L_0x025d:
            if (r2 == 0) goto L_0x0263
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0264
        L_0x0263:
            r7 = 0
        L_0x0264:
            r2 = r5 | r7
            r0.f29003Q = r2
            r2 = 2
            r0.f28995I = r2
            r2 = 0
            r0.f28998L = r2
            goto L_0x0290
        L_0x026f:
            com.google.android.gms.internal.ads.zzlm r1 = new com.google.android.gms.internal.ads.zzlm
            r2 = 36
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unexpected lacing value: "
            r3.append(r2)
            r3.append(r11)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L_0x0288:
            com.google.android.gms.internal.ads.zzlm r1 = new com.google.android.gms.internal.ads.zzlm
            java.lang.String r2 = "Lacing only supported in SimpleBlocks."
            r1.<init>(r2)
            throw r1
        L_0x0290:
            r2 = 163(0xa3, float:2.28E-43)
            if (r1 != r2) goto L_0x02bb
        L_0x0294:
            int r1 = r0.f28998L
            int r2 = r0.f28999M
            if (r1 >= r2) goto L_0x02b7
            int[] r2 = r0.f29000N
            r1 = r2[r1]
            r0.m30842a(r3, r4, r1)
            long r1 = r0.f28996J
            int r5 = r0.f28998L
            int r6 = r4.f22246d
            int r5 = r5 * r6
            int r5 = r5 / 1000
            long r5 = (long) r5
            long r1 = r1 + r5
            r0.m30840a(r4, r1)
            int r1 = r0.f28998L
            r2 = 1
            int r1 = r1 + r2
            r0.f28998L = r1
            goto L_0x0294
        L_0x02b7:
            r1 = 0
            r0.f28995I = r1
            return
        L_0x02bb:
            r1 = 0
            int[] r2 = r0.f29000N
            r1 = r2[r1]
            r0.m30842a(r3, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzod.mo32068a(int, int, com.google.android.gms.internal.ads.zzno):void");
    }

    /* renamed from: a */
    private final void m30840a(C9415es esVar, long j) {
        byte[] bArr;
        if ("S_TEXT/UTF8".equals(esVar.f22243a)) {
            byte[] bArr2 = this.f29026o.f29334a;
            long j2 = this.f28997K;
            if (j2 == -9223372036854775807L) {
                bArr = f28985c;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (((long) i) * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - ((long) (60000000 * i2));
                int i3 = (int) (j4 / 1000000);
                int i4 = (int) ((j4 - ((long) (1000000 * i3))) / 1000);
                bArr = zzsy.m31159d(String.format(Locale.US, "%02d:%02d:%02d,%03d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}));
            }
            System.arraycopy(bArr, 0, bArr2, 19, 12);
            zznw zznw = esVar.f22241O;
            zzst zzst = this.f29026o;
            zznw.mo32064a(zzst, zzst.mo32200c());
            this.f29012Z += this.f29026o.mo32200c();
        }
        esVar.f22241O.mo32062a(j, this.f29003Q, this.f29012Z, 0, esVar.f22249g);
        this.f29013aa = true;
        m30847c();
    }

    /* renamed from: c */
    private final void m30847c() {
        this.f29004R = 0;
        this.f29012Z = 0;
        this.f29011Y = 0;
        this.f29005S = false;
        this.f29006T = false;
        this.f29008V = false;
        this.f29010X = 0;
        this.f29009W = 0;
        this.f29007U = false;
        this.f29025n.mo32209i();
    }

    /* renamed from: a */
    private final void m30841a(zzno zzno, int i) throws IOException, InterruptedException {
        if (this.f29022k.mo32200c() < i) {
            if (this.f29022k.mo32194a() < i) {
                zzst zzst = this.f29022k;
                byte[] bArr = zzst.f29334a;
                zzst.mo32196a(Arrays.copyOf(bArr, Math.max(bArr.length << 1, i)), this.f29022k.mo32200c());
            }
            zzst zzst2 = this.f29022k;
            zzno.readFully(zzst2.f29334a, zzst2.mo32200c(), i - this.f29022k.mo32200c());
            this.f29022k.mo32203d(i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x020d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m30842a(com.google.android.gms.internal.ads.zzno r10, com.google.android.gms.internal.ads.C9415es r11, int r12) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r9 = this;
            java.lang.String r0 = r11.f22243a
            java.lang.String r1 = "S_TEXT/UTF8"
            boolean r0 = r1.equals(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0038
            byte[] r11 = f28984b
            int r11 = r11.length
            int r11 = r11 + r12
            com.google.android.gms.internal.ads.zzst r0 = r9.f29026o
            int r0 = r0.mo32194a()
            if (r0 >= r11) goto L_0x0023
            com.google.android.gms.internal.ads.zzst r0 = r9.f29026o
            byte[] r2 = f28984b
            int r3 = r11 + r12
            byte[] r2 = java.util.Arrays.copyOf(r2, r3)
            r0.f29334a = r2
        L_0x0023:
            com.google.android.gms.internal.ads.zzst r0 = r9.f29026o
            byte[] r0 = r0.f29334a
            byte[] r2 = f28984b
            int r2 = r2.length
            r10.readFully(r0, r2, r12)
            com.google.android.gms.internal.ads.zzst r10 = r9.f29026o
            r10.mo32199b(r1)
            com.google.android.gms.internal.ads.zzst r10 = r9.f29026o
            r10.mo32203d(r11)
            return
        L_0x0038:
            com.google.android.gms.internal.ads.zznw r0 = r11.f22241O
            boolean r2 = r9.f29005S
            r3 = 2
            r4 = 1
            if (r2 != 0) goto L_0x0181
            boolean r2 = r11.f22247e
            if (r2 == 0) goto L_0x0173
            int r2 = r9.f29003Q
            r5 = -1073741825(0xffffffffbfffffff, float:-1.9999999)
            r2 = r2 & r5
            r9.f29003Q = r2
            boolean r2 = r9.f29006T
            r5 = 128(0x80, float:1.794E-43)
            if (r2 != 0) goto L_0x0076
            com.google.android.gms.internal.ads.zzst r2 = r9.f29022k
            byte[] r2 = r2.f29334a
            r10.readFully(r2, r1, r4)
            int r2 = r9.f29004R
            int r2 = r2 + r4
            r9.f29004R = r2
            com.google.android.gms.internal.ads.zzst r2 = r9.f29022k
            byte[] r2 = r2.f29334a
            byte r6 = r2[r1]
            r6 = r6 & r5
            if (r6 == r5) goto L_0x006e
            byte r2 = r2[r1]
            r9.f29009W = r2
            r9.f29006T = r4
            goto L_0x0076
        L_0x006e:
            com.google.android.gms.internal.ads.zzlm r10 = new com.google.android.gms.internal.ads.zzlm
            java.lang.String r11 = "Extension bit is set in signal byte"
            r10.<init>(r11)
            throw r10
        L_0x0076:
            byte r2 = r9.f29009W
            r6 = r2 & 1
            if (r6 != r4) goto L_0x017e
            r2 = r2 & r3
            if (r2 != r3) goto L_0x0081
            r2 = 1
            goto L_0x0082
        L_0x0081:
            r2 = 0
        L_0x0082:
            int r6 = r9.f29003Q
            r7 = 1073741824(0x40000000, float:2.0)
            r6 = r6 | r7
            r9.f29003Q = r6
            boolean r6 = r9.f29007U
            if (r6 != 0) goto L_0x00c7
            com.google.android.gms.internal.ads.zzst r6 = r9.f29027p
            byte[] r6 = r6.f29334a
            r7 = 8
            r10.readFully(r6, r1, r7)
            int r6 = r9.f29004R
            int r6 = r6 + r7
            r9.f29004R = r6
            r9.f29007U = r4
            com.google.android.gms.internal.ads.zzst r6 = r9.f29022k
            byte[] r6 = r6.f29334a
            if (r2 == 0) goto L_0x00a4
            goto L_0x00a5
        L_0x00a4:
            r5 = 0
        L_0x00a5:
            r5 = r5 | r7
            byte r5 = (byte) r5
            r6[r1] = r5
            com.google.android.gms.internal.ads.zzst r5 = r9.f29022k
            r5.mo32199b(r1)
            com.google.android.gms.internal.ads.zzst r5 = r9.f29022k
            r0.mo32064a(r5, r4)
            int r5 = r9.f29012Z
            int r5 = r5 + r4
            r9.f29012Z = r5
            com.google.android.gms.internal.ads.zzst r5 = r9.f29027p
            r5.mo32199b(r1)
            com.google.android.gms.internal.ads.zzst r5 = r9.f29027p
            r0.mo32064a(r5, r7)
            int r5 = r9.f29012Z
            int r5 = r5 + r7
            r9.f29012Z = r5
        L_0x00c7:
            if (r2 == 0) goto L_0x017e
            boolean r2 = r9.f29008V
            if (r2 != 0) goto L_0x00e8
            com.google.android.gms.internal.ads.zzst r2 = r9.f29022k
            byte[] r2 = r2.f29334a
            r10.readFully(r2, r1, r4)
            int r2 = r9.f29004R
            int r2 = r2 + r4
            r9.f29004R = r2
            com.google.android.gms.internal.ads.zzst r2 = r9.f29022k
            r2.mo32199b(r1)
            com.google.android.gms.internal.ads.zzst r2 = r9.f29022k
            int r2 = r2.mo32207g()
            r9.f29010X = r2
            r9.f29008V = r4
        L_0x00e8:
            int r2 = r9.f29010X
            int r2 = r2 << r3
            com.google.android.gms.internal.ads.zzst r5 = r9.f29022k
            r5.mo32195a(r2)
            com.google.android.gms.internal.ads.zzst r5 = r9.f29022k
            byte[] r5 = r5.f29334a
            r10.readFully(r5, r1, r2)
            int r5 = r9.f29004R
            int r5 = r5 + r2
            r9.f29004R = r5
            int r2 = r9.f29010X
            int r2 = r2 / r3
            int r2 = r2 + r4
            short r2 = (short) r2
            int r5 = r2 * 6
            int r5 = r5 + r3
            java.nio.ByteBuffer r6 = r9.f29029r
            if (r6 == 0) goto L_0x010e
            int r6 = r6.capacity()
            if (r6 >= r5) goto L_0x0114
        L_0x010e:
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.allocate(r5)
            r9.f29029r = r6
        L_0x0114:
            java.nio.ByteBuffer r6 = r9.f29029r
            r6.position(r1)
            java.nio.ByteBuffer r6 = r9.f29029r
            r6.putShort(r2)
            r2 = 0
            r6 = 0
        L_0x0121:
            int r7 = r9.f29010X
            if (r2 >= r7) goto L_0x0144
            com.google.android.gms.internal.ads.zzst r7 = r9.f29022k
            int r7 = r7.mo32212l()
            int r8 = r2 % 2
            if (r8 != 0) goto L_0x0139
            java.nio.ByteBuffer r8 = r9.f29029r
            int r6 = r7 - r6
            short r6 = (short) r6
            r8.putShort(r6)
            goto L_0x0140
        L_0x0139:
            java.nio.ByteBuffer r8 = r9.f29029r
            int r6 = r7 - r6
            r8.putInt(r6)
        L_0x0140:
            int r2 = r2 + 1
            r6 = r7
            goto L_0x0121
        L_0x0144:
            int r2 = r9.f29004R
            int r2 = r12 - r2
            int r2 = r2 - r6
            int r7 = r7 % r3
            if (r7 != r4) goto L_0x0152
            java.nio.ByteBuffer r6 = r9.f29029r
            r6.putInt(r2)
            goto L_0x015d
        L_0x0152:
            java.nio.ByteBuffer r6 = r9.f29029r
            short r2 = (short) r2
            r6.putShort(r2)
            java.nio.ByteBuffer r2 = r9.f29029r
            r2.putInt(r1)
        L_0x015d:
            com.google.android.gms.internal.ads.zzst r2 = r9.f29028q
            java.nio.ByteBuffer r6 = r9.f29029r
            byte[] r6 = r6.array()
            r2.mo32196a(r6, r5)
            com.google.android.gms.internal.ads.zzst r2 = r9.f29028q
            r0.mo32064a(r2, r5)
            int r2 = r9.f29012Z
            int r2 = r2 + r5
            r9.f29012Z = r2
            goto L_0x017e
        L_0x0173:
            byte[] r2 = r11.f22248f
            if (r2 == 0) goto L_0x017e
            com.google.android.gms.internal.ads.zzst r5 = r9.f29025n
            int r6 = r2.length
            r5.mo32196a(r2, r6)
            goto L_0x017f
        L_0x017e:
        L_0x017f:
            r9.f29005S = r4
        L_0x0181:
            com.google.android.gms.internal.ads.zzst r2 = r9.f29025n
            int r2 = r2.mo32200c()
            int r12 = r12 + r2
            java.lang.String r2 = r11.f22243a
            java.lang.String r5 = "V_MPEG4/ISO/AVC"
            boolean r2 = r5.equals(r2)
            r5 = 4
            if (r2 != 0) goto L_0x01a8
            java.lang.String r2 = r11.f22243a
            java.lang.String r6 = "V_MPEGH/ISO/HEVC"
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L_0x019e
            goto L_0x01a8
        L_0x019e:
            int r2 = r9.f29004R
            if (r2 >= r12) goto L_0x0203
            int r2 = r12 - r2
            r9.m30838a(r10, r0, r2)
            goto L_0x019e
        L_0x01a8:
            com.google.android.gms.internal.ads.zzst r2 = r9.f29021j
            byte[] r2 = r2.f29334a
            r2[r1] = r1
            r2[r4] = r1
            r2[r3] = r1
            int r3 = r11.f22242P
            int r4 = 4 - r3
        L_0x01b6:
            int r6 = r9.f29004R
            if (r6 >= r12) goto L_0x0202
            int r6 = r9.f29011Y
            if (r6 != 0) goto L_0x01f9
            com.google.android.gms.internal.ads.zzst r6 = r9.f29025n
            int r6 = r6.mo32214n()
            int r6 = java.lang.Math.min(r3, r6)
            int r7 = r4 + r6
            int r8 = r3 - r6
            r10.readFully(r2, r7, r8)
            if (r6 <= 0) goto L_0x01d7
            com.google.android.gms.internal.ads.zzst r7 = r9.f29025n
            r7.mo32197a(r2, r4, r6)
        L_0x01d7:
            int r6 = r9.f29004R
            int r6 = r6 + r3
            r9.f29004R = r6
            com.google.android.gms.internal.ads.zzst r6 = r9.f29021j
            r6.mo32199b(r1)
            com.google.android.gms.internal.ads.zzst r6 = r9.f29021j
            int r6 = r6.mo32212l()
            r9.f29011Y = r6
            com.google.android.gms.internal.ads.zzst r6 = r9.f29020i
            r6.mo32199b(r1)
            com.google.android.gms.internal.ads.zzst r6 = r9.f29020i
            r0.mo32064a(r6, r5)
            int r6 = r9.f29012Z
            int r6 = r6 + r5
            r9.f29012Z = r6
            goto L_0x01b6
        L_0x01f9:
            int r7 = r9.m30838a(r10, r0, r6)
            int r6 = r6 - r7
            r9.f29011Y = r6
            goto L_0x01b6
        L_0x0202:
        L_0x0203:
            java.lang.String r10 = r11.f22243a
            java.lang.String r11 = "A_VORBIS"
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x021c
            com.google.android.gms.internal.ads.zzst r10 = r9.f29023l
            r10.mo32199b(r1)
            com.google.android.gms.internal.ads.zzst r10 = r9.f29023l
            r0.mo32064a(r10, r5)
            int r10 = r9.f29012Z
            int r10 = r10 + r5
            r9.f29012Z = r10
        L_0x021c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzod.m30842a(com.google.android.gms.internal.ads.zzno, com.google.android.gms.internal.ads.es, int):void");
    }

    /* renamed from: a */
    private final int m30838a(zzno zzno, zznw zznw, int i) throws IOException, InterruptedException {
        int i2;
        int n = this.f29025n.mo32214n();
        if (n > 0) {
            i2 = Math.min(i, n);
            zznw.mo32064a(this.f29025n, i2);
        } else {
            i2 = zznw.mo32061a(zzno, i, false);
        }
        this.f29004R += i2;
        this.f29012Z += i2;
        return i2;
    }

    /* renamed from: a */
    private final long m30839a(long j) throws zzlm {
        long j2 = this.f29032u;
        if (j2 != -9223372036854775807L) {
            return zzsy.m31148a(j, j2, 1000);
        }
        throw new zzlm("Can't scale timecode prior to timecodeScale being set.");
    }

    /* renamed from: a */
    private static int[] m30844a(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        if (iArr.length >= i) {
            return iArr;
        }
        return new int[Math.max(iArr.length << 1, i)];
    }
}
