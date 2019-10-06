package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class zzjg implements zzid {

    /* renamed from: A */
    private int f28647A;

    /* renamed from: B */
    private int f28648B;

    /* renamed from: C */
    private long f28649C;

    /* renamed from: D */
    private boolean f28650D;

    /* renamed from: E */
    private boolean f28651E;

    /* renamed from: F */
    private zzif f28652F;

    /* renamed from: a */
    private final C9634or f28653a;

    /* renamed from: b */
    private final C9677qr f28654b;

    /* renamed from: c */
    private final zzkm f28655c;

    /* renamed from: d */
    private final zzkm f28656d;

    /* renamed from: e */
    private final zzkm f28657e;

    /* renamed from: f */
    private long f28658f;

    /* renamed from: g */
    private long f28659g;

    /* renamed from: h */
    private long f28660h;

    /* renamed from: i */
    private long f28661i;

    /* renamed from: j */
    private C9740tr f28662j;

    /* renamed from: k */
    private C9740tr f28663k;

    /* renamed from: l */
    private C9740tr f28664l;

    /* renamed from: m */
    private boolean f28665m;

    /* renamed from: n */
    private int f28666n;

    /* renamed from: o */
    private long f28667o;

    /* renamed from: p */
    private boolean f28668p;

    /* renamed from: q */
    private long f28669q;

    /* renamed from: r */
    private long f28670r;

    /* renamed from: s */
    private int f28671s;

    /* renamed from: t */
    private long f28672t;

    /* renamed from: u */
    private zzkk f28673u;

    /* renamed from: v */
    private zzkk f28674v;

    /* renamed from: w */
    private boolean f28675w;

    /* renamed from: x */
    private int f28676x;

    /* renamed from: y */
    private int f28677y;

    /* renamed from: z */
    private int f28678z;

    public zzjg() {
        this(new C9568lr());
    }

    private zzjg(C9634or orVar) {
        this.f28658f = -1;
        this.f28659g = -1;
        this.f28660h = 1000000;
        this.f28661i = -1;
        this.f28669q = -1;
        this.f28670r = -1;
        this.f28671s = 0;
        this.f28672t = -1;
        this.f28653a = orVar;
        this.f28653a.mo29069a((C9656pr) new C9719sr(this));
        this.f28654b = new C9677qr();
        this.f28655c = new zzkm(4);
        this.f28656d = new zzkm(ByteBuffer.allocate(4).putInt(-1).array());
        this.f28657e = new zzkm(4);
    }

    /* renamed from: a */
    public final void mo31857a(zzif zzif) {
        this.f28652F = zzif;
    }

    /* renamed from: a */
    public final void mo31856a() {
        this.f28672t = -1;
        this.f28677y = 0;
        this.f28653a.reset();
        this.f28654b.mo29147a();
    }

    /* renamed from: a */
    public final int mo31855a(zzie zzie, zzij zzij) throws IOException, InterruptedException {
        boolean z;
        this.f28650D = false;
        boolean z2 = true;
        while (z2 && !this.f28650D) {
            z2 = this.f28653a.mo29070a(zzie);
            if (z2) {
                long position = zzie.getPosition();
                if (this.f28668p) {
                    this.f28670r = position;
                    zzij.f28617a = this.f28669q;
                    this.f28671s = 1;
                    this.f28668p = false;
                    z = true;
                } else {
                    if (this.f28671s == 2) {
                        long j = this.f28670r;
                        if (j != -1) {
                            zzij.f28617a = j;
                            this.f28670r = -1;
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

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo31871a(int i, long j, long j2) throws zzhl {
        if (i == 160) {
            this.f28651E = false;
        } else if (i == 174) {
            this.f28662j = new C9740tr();
        } else if (i == 187) {
            this.f28675w = false;
        } else if (i == 19899) {
            this.f28666n = -1;
            this.f28667o = -1;
        } else if (i == 20533) {
            this.f28662j.f23037d = true;
        } else if (i == 25152) {
        } else {
            if (i != 408125543) {
                if (i != 475249515) {
                    if (i == 524531317 && this.f28671s == 0 && this.f28669q != -1) {
                        this.f28668p = true;
                    }
                    return;
                }
                this.f28673u = new zzkk();
                this.f28674v = new zzkk();
            } else if (this.f28658f == -1) {
                this.f28658f = j;
                this.f28659g = j2;
            } else {
                throw new zzhl("Multiple Segment elements not supported");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo31867a(int i) throws zzhl {
        zzhj zzhj;
        zzhj zzhj2;
        int i2;
        if (i != 160) {
            if (i == 174) {
                C9740tr trVar = this.f28662j;
                if (trVar.f23035b != -1) {
                    int i3 = trVar.f23036c;
                    if (i3 != -1) {
                        if ((i3 != 2 || this.f28663k == null) && (this.f28662j.f23036c != 1 || this.f28664l == null)) {
                            C9740tr trVar2 = this.f28662j;
                            String str = "Unable to build format";
                            if (trVar2.f23036c != 2 || !m30487a(trVar2.f23034a)) {
                                C9740tr trVar3 = this.f28662j;
                                if (trVar3.f23036c == 1 && m30487a(trVar3.f23034a)) {
                                    this.f28664l = this.f28662j;
                                    C9740tr trVar4 = this.f28664l;
                                    trVar4.f23046m = this.f28652F.mo31860c(trVar4.f23035b);
                                    C9740tr trVar5 = this.f28664l;
                                    zzip zzip = trVar5.f23046m;
                                    if (trVar5 != null) {
                                        if ("V_VP8".equals(trVar5.f23034a)) {
                                            long j = this.f28661i;
                                            C9740tr trVar6 = this.f28664l;
                                            zzhj = zzhj.m30358a("video/x-vnd.on2.vp8", -1, j, trVar6.f23039f, trVar6.f23040g, null);
                                            zzip.mo31847a(zzhj);
                                        }
                                    }
                                    C9740tr trVar7 = this.f28664l;
                                    if (trVar7 != null) {
                                        if ("V_VP9".equals(trVar7.f23034a)) {
                                            long j2 = this.f28661i;
                                            C9740tr trVar8 = this.f28664l;
                                            zzhj = zzhj.m30358a("video/x-vnd.on2.vp9", -1, j2, trVar8.f23039f, trVar8.f23040g, null);
                                            zzip.mo31847a(zzhj);
                                        }
                                    }
                                    throw new zzhl(str);
                                }
                            } else {
                                this.f28663k = this.f28662j;
                                C9740tr trVar9 = this.f28663k;
                                trVar9.f23046m = this.f28652F.mo31860c(trVar9.f23035b);
                                C9740tr trVar10 = this.f28663k;
                                zzip zzip2 = trVar10.f23046m;
                                if (trVar10 != null) {
                                    if ("A_VORBIS".equals(trVar10.f23034a)) {
                                        long j3 = this.f28661i;
                                        C9740tr trVar11 = this.f28663k;
                                        zzhj2 = zzhj.m30360b("audio/vorbis", Opcodes.ACC_ANNOTATION, j3, trVar11.f23041h, trVar11.f23042i, m30488b());
                                        zzip2.mo31847a(zzhj2);
                                    }
                                }
                                C9740tr trVar12 = this.f28663k;
                                if (trVar12 != null) {
                                    if ("A_OPUS".equals(trVar12.f23034a)) {
                                        ArrayList arrayList = new ArrayList(3);
                                        arrayList.add(this.f28663k.f23043j);
                                        arrayList.add(ByteBuffer.allocate(64).putLong(this.f28663k.f23044k).array());
                                        arrayList.add(ByteBuffer.allocate(64).putLong(this.f28663k.f23045l).array());
                                        long j4 = this.f28661i;
                                        C9740tr trVar13 = this.f28663k;
                                        zzhj2 = zzhj.m30360b("audio/opus", 5760, j4, trVar13.f23041h, trVar13.f23042i, arrayList);
                                        zzip2.mo31847a(zzhj2);
                                    }
                                }
                                throw new zzhl(str);
                            }
                            this.f28662j = null;
                            return;
                        }
                        this.f28662j = null;
                        return;
                    }
                }
                throw new zzhl("Mandatory element TrackNumber or TrackType not found");
            } else if (i == 19899) {
                int i4 = this.f28666n;
                if (i4 != -1) {
                    long j5 = this.f28667o;
                    if (j5 != -1) {
                        if (i4 == 475249515) {
                            this.f28669q = j5;
                        }
                        return;
                    }
                }
                throw new zzhl("Mandatory element SeekID or SeekPosition not found");
            } else if (i == 25152) {
                C9740tr trVar14 = this.f28662j;
                if (trVar14.f23037d) {
                    byte[] bArr = trVar14.f23038e;
                    if (bArr != null) {
                        if (!this.f28665m) {
                            this.f28652F.mo31858a((zzhw) new zzhy("video/webm", bArr));
                            this.f28665m = true;
                        }
                        return;
                    }
                    throw new zzhl("Encrypted Track found but ContentEncKeyID was not found");
                }
                throw new zzhl("Found an unsupported ContentEncoding");
            } else if (i != 374648427) {
                if (i == 475249515 && this.f28671s != 2) {
                    zzif zzif = this.f28652F;
                    if (this.f28658f == -1) {
                        throw new zzhl("Segment start/end offsets unknown");
                    } else if (this.f28661i != -1) {
                        zzkk zzkk = this.f28673u;
                        if (zzkk == null || this.f28674v == null || zzkk.mo31886a() == 0 || this.f28673u.mo31886a() != this.f28674v.mo31886a()) {
                            throw new zzhl("Invalid/missing cue points");
                        }
                        int a = this.f28673u.mo31886a();
                        int[] iArr = new int[a];
                        long[] jArr = new long[a];
                        long[] jArr2 = new long[a];
                        long[] jArr3 = new long[a];
                        int i5 = 0;
                        for (int i6 = 0; i6 < a; i6++) {
                            jArr3[i6] = this.f28673u.mo31887a(i6);
                            jArr[i6] = this.f28658f + this.f28674v.mo31887a(i6);
                        }
                        while (true) {
                            i2 = a - 1;
                            if (i5 >= i2) {
                                break;
                            }
                            int i7 = i5 + 1;
                            iArr[i5] = (int) (jArr[i7] - jArr[i5]);
                            jArr2[i5] = jArr3[i7] - jArr3[i5];
                            i5 = i7;
                        }
                        iArr[i2] = (int) ((this.f28658f + this.f28659g) - jArr[i2]);
                        jArr2[i2] = this.f28661i - jArr3[i2];
                        this.f28673u = null;
                        this.f28674v = null;
                        zzif.mo31859a((zzio) new zzia(iArr, jArr, jArr2, jArr3));
                        this.f28671s = 2;
                    } else {
                        throw new zzhl("Duration unknown");
                    }
                }
            } else if (this.f28664l == null && this.f28663k == null) {
                throw new zzhl("No valid tracks were found");
            } else {
                this.f28652F.mo31861f();
            }
        } else if (this.f28677y == 2) {
            if (!this.f28651E) {
                this.f28648B |= 1;
            }
            C9740tr trVar15 = this.f28663k;
            if (trVar15 == null || this.f28647A != trVar15.f23035b) {
                trVar15 = this.f28664l;
            }
            m30486a(trVar15.f23046m);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo31870a(int i, long j) throws zzhl {
        String str = " not supported";
        switch (i) {
            case Opcodes.LXOR /*131*/:
                this.f28662j.f23036c = (int) j;
                return;
            case Opcodes.IF_ICMPEQ /*159*/:
                this.f28662j.f23041h = (int) j;
                return;
            case Opcodes.ARETURN /*176*/:
                this.f28662j.f23039f = (int) j;
                return;
            case Opcodes.PUTSTATIC /*179*/:
                this.f28673u.mo31888a(m30485a(j));
                return;
            case Opcodes.INVOKEDYNAMIC /*186*/:
                this.f28662j.f23040g = (int) j;
                return;
            case 215:
                this.f28662j.f23035b = (int) j;
                return;
            case 231:
                this.f28672t = m30485a(j);
                return;
            case 241:
                if (!this.f28675w) {
                    this.f28674v.mo31888a(j);
                    this.f28675w = true;
                }
                return;
            case 251:
                this.f28651E = true;
                return;
            case 17029:
                if (j < 1 || j > 2) {
                    StringBuilder sb = new StringBuilder(53);
                    sb.append("DocTypeReadVersion ");
                    sb.append(j);
                    sb.append(str);
                    throw new zzhl(sb.toString());
                }
                return;
            case 17143:
                if (j != 1) {
                    StringBuilder sb2 = new StringBuilder(50);
                    sb2.append("EBMLReadVersion ");
                    sb2.append(j);
                    sb2.append(str);
                    throw new zzhl(sb2.toString());
                }
                return;
            case 18401:
                if (j != 5) {
                    StringBuilder sb3 = new StringBuilder(49);
                    sb3.append("ContentEncAlgo ");
                    sb3.append(j);
                    sb3.append(str);
                    throw new zzhl(sb3.toString());
                }
                return;
            case 18408:
                if (j != 1) {
                    StringBuilder sb4 = new StringBuilder(56);
                    sb4.append("AESSettingsCipherMode ");
                    sb4.append(j);
                    sb4.append(str);
                    throw new zzhl(sb4.toString());
                }
                return;
            case 20529:
                if (j != 0) {
                    StringBuilder sb5 = new StringBuilder(55);
                    sb5.append("ContentEncodingOrder ");
                    sb5.append(j);
                    sb5.append(str);
                    throw new zzhl(sb5.toString());
                }
                return;
            case 20530:
                if (j != 1) {
                    StringBuilder sb6 = new StringBuilder(55);
                    sb6.append("ContentEncodingScope ");
                    sb6.append(j);
                    sb6.append(str);
                    throw new zzhl(sb6.toString());
                }
                return;
            case 20531:
                if (j != 1) {
                    StringBuilder sb7 = new StringBuilder(54);
                    sb7.append("ContentEncodingType ");
                    sb7.append(j);
                    sb7.append(str);
                    throw new zzhl(sb7.toString());
                }
                return;
            case 21420:
                this.f28667o = j + this.f28658f;
                return;
            case 22186:
                this.f28662j.f23044k = j;
                return;
            case 22203:
                this.f28662j.f23045l = j;
                return;
            case 2807729:
                this.f28660h = j;
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo31868a(int i, double d) {
        if (i == 181) {
            this.f28662j.f23042i = (int) d;
        } else if (i == 17545) {
            this.f28661i = m30485a((long) d);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo31872a(int i, String str) throws zzhl {
        if (i == 134) {
            this.f28662j.f23034a = str;
        } else if (i == 17026 && !"webm".equals(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new zzhl(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0095, code lost:
        if (r9.f23035b != r10) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b1, code lost:
        if (r4.f23035b != r0.f28647A) goto L_0x00b3;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo31869a(int r17, int r18, com.google.android.gms.internal.ads.zzie r19) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = 161(0xa1, float:2.26E-43)
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 4
            r7 = 0
            if (r1 == r4) goto L_0x006d
            if (r1 == r5) goto L_0x006d
            r4 = 18402(0x47e2, float:2.5787E-41)
            if (r1 == r4) goto L_0x0061
            r4 = 21419(0x53ab, float:3.0014E-41)
            if (r1 == r4) goto L_0x0043
            r4 = 25506(0x63a2, float:3.5742E-41)
            if (r1 != r4) goto L_0x002a
            com.google.android.gms.internal.ads.tr r1 = r0.f28662j
            byte[] r4 = new byte[r2]
            r1.f23043j = r4
            byte[] r1 = r1.f23043j
            r3.readFully(r1, r7, r2)
            return
        L_0x002a:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 26
            r3.<init>(r4)
            java.lang.String r4 = "Unexpected id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x0043:
            com.google.android.gms.internal.ads.zzkm r1 = r0.f28657e
            byte[] r1 = r1.f28743a
            java.util.Arrays.fill(r1, r7)
            com.google.android.gms.internal.ads.zzkm r1 = r0.f28657e
            byte[] r1 = r1.f28743a
            int r6 = r6 - r2
            r3.readFully(r1, r6, r2)
            com.google.android.gms.internal.ads.zzkm r1 = r0.f28657e
            r1.mo31890a(r7)
            com.google.android.gms.internal.ads.zzkm r1 = r0.f28657e
            long r1 = r1.mo31899g()
            int r2 = (int) r1
            r0.f28666n = r2
            return
        L_0x0061:
            com.google.android.gms.internal.ads.tr r1 = r0.f28662j
            byte[] r4 = new byte[r2]
            r1.f23038e = r4
            byte[] r1 = r1.f23038e
            r3.readFully(r1, r7, r2)
            return
        L_0x006d:
            int r4 = r0.f28677y
            r8 = 1
            if (r4 != 0) goto L_0x0085
            com.google.android.gms.internal.ads.qr r4 = r0.f28654b
            long r9 = r4.mo29146a(r3, r7, r8)
            int r4 = (int) r9
            r0.f28647A = r4
            com.google.android.gms.internal.ads.qr r4 = r0.f28654b
            int r4 = r4.mo29148b()
            r0.f28676x = r4
            r0.f28677y = r8
        L_0x0085:
            com.google.android.gms.internal.ads.tr r4 = r0.f28663k
            if (r4 == 0) goto L_0x0097
            com.google.android.gms.internal.ads.tr r9 = r0.f28664l
            if (r9 == 0) goto L_0x0097
            int r4 = r4.f23035b
            int r10 = r0.f28647A
            if (r4 == r10) goto L_0x0097
            int r4 = r9.f23035b
            if (r4 != r10) goto L_0x00b3
        L_0x0097:
            com.google.android.gms.internal.ads.tr r4 = r0.f28663k
            if (r4 == 0) goto L_0x00a5
            com.google.android.gms.internal.ads.tr r9 = r0.f28664l
            if (r9 != 0) goto L_0x00a5
            int r4 = r4.f23035b
            int r9 = r0.f28647A
            if (r4 != r9) goto L_0x00b3
        L_0x00a5:
            com.google.android.gms.internal.ads.tr r4 = r0.f28663k
            if (r4 != 0) goto L_0x00bd
            com.google.android.gms.internal.ads.tr r4 = r0.f28664l
            if (r4 == 0) goto L_0x00bd
            int r4 = r4.f23035b
            int r9 = r0.f28647A
            if (r4 == r9) goto L_0x00bd
        L_0x00b3:
            int r1 = r0.f28676x
            int r1 = r2 - r1
            r3.mo31840a(r1)
            r0.f28677y = r7
            return
        L_0x00bd:
            com.google.android.gms.internal.ads.tr r4 = r0.f28663k
            if (r4 == 0) goto L_0x00c8
            int r9 = r0.f28647A
            int r10 = r4.f23035b
            if (r9 != r10) goto L_0x00c8
            goto L_0x00ca
        L_0x00c8:
            com.google.android.gms.internal.ads.tr r4 = r0.f28664l
        L_0x00ca:
            com.google.android.gms.internal.ads.zzip r9 = r4.f23046m
            int r10 = r0.f28677y
            if (r10 != r8) goto L_0x0177
            com.google.android.gms.internal.ads.zzkm r10 = r0.f28655c
            byte[] r10 = r10.f28743a
            boolean r11 = r4.f23037d
            r12 = 3
            if (r11 == 0) goto L_0x00db
            r11 = 4
            goto L_0x00dc
        L_0x00db:
            r11 = 3
        L_0x00dc:
            r3.readFully(r10, r7, r11)
            int r13 = r0.f28676x
            int r13 = r13 + r11
            r0.f28676x = r13
            byte r11 = r10[r7]
            r13 = 8
            int r11 = r11 << r13
            byte r14 = r10[r8]
            r14 = r14 & 255(0xff, float:3.57E-43)
            r11 = r11 | r14
            long r14 = r0.f28672t
            long r6 = (long) r11
            long r6 = r0.m30485a(r6)
            long r14 = r14 + r6
            r0.f28649C = r14
            r7 = 2
            byte r6 = r10[r7]
            r6 = r6 & 6
            int r6 = r6 >> r8
            if (r6 != 0) goto L_0x015e
            byte r6 = r10[r7]
            r6 = r6 & r13
            if (r6 != r13) goto L_0x0107
            r6 = 1
            goto L_0x0108
        L_0x0107:
            r6 = 0
        L_0x0108:
            r11 = 128(0x80, float:1.794E-43)
            if (r1 != r5) goto L_0x0113
            byte r14 = r10[r7]
            r14 = r14 & r11
            if (r14 != r11) goto L_0x0113
            r14 = 1
            goto L_0x0114
        L_0x0113:
            r14 = 0
        L_0x0114:
            boolean r15 = r4.f23037d
            if (r15 == 0) goto L_0x012f
            byte r15 = r10[r12]
            r15 = r15 & r11
            if (r15 == r11) goto L_0x0127
            byte r10 = r10[r12]
            r10 = r10 & r8
            if (r10 != r8) goto L_0x0125
            r10 = 1
            goto L_0x0130
        L_0x0125:
            r10 = 0
            goto L_0x0130
        L_0x0127:
            com.google.android.gms.internal.ads.zzhl r1 = new com.google.android.gms.internal.ads.zzhl
            java.lang.String r2 = "Extension bit is set in signal byte"
            r1.<init>(r2)
            throw r1
        L_0x012f:
            r10 = 0
        L_0x0130:
            if (r6 == 0) goto L_0x0135
            r6 = 134217728(0x8000000, float:3.85186E-34)
            goto L_0x0136
        L_0x0135:
            r6 = 0
        L_0x0136:
            r6 = r6 | r14
            if (r10 == 0) goto L_0x013b
            r11 = 2
            goto L_0x013c
        L_0x013b:
            r11 = 0
        L_0x013c:
            r6 = r6 | r11
            r0.f28648B = r6
            int r6 = r0.f28676x
            int r6 = r2 - r6
            r0.f28678z = r6
            if (r10 == 0) goto L_0x015b
            com.google.android.gms.internal.ads.zzkm r6 = r0.f28655c
            byte[] r10 = r6.f28743a
            r11 = 0
            r10[r11] = r13
            r6.mo31890a(r11)
            com.google.android.gms.internal.ads.zzkm r6 = r0.f28655c
            r9.mo31848a(r6, r8)
            int r6 = r0.f28678z
            int r6 = r6 + r8
            r0.f28678z = r6
        L_0x015b:
            r0.f28677y = r7
            goto L_0x0177
        L_0x015e:
            com.google.android.gms.internal.ads.zzhl r1 = new com.google.android.gms.internal.ads.zzhl
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 38
            r2.<init>(r3)
            java.lang.String r3 = "Lacing mode not supported: "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0177:
            int r6 = r0.f28676x
            if (r6 >= r2) goto L_0x0185
            int r7 = r2 - r6
            int r7 = r9.mo31844a(r3, r7)
            int r6 = r6 + r7
            r0.f28676x = r6
            goto L_0x0177
        L_0x0185:
            java.lang.String r2 = r4.f23034a
            java.lang.String r3 = "A_VORBIS"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x01a0
            com.google.android.gms.internal.ads.zzkm r2 = r0.f28656d
            r3 = 0
            r2.mo31890a(r3)
            com.google.android.gms.internal.ads.zzkm r2 = r0.f28656d
            r3 = 4
            r9.mo31848a(r2, r3)
            int r2 = r0.f28678z
            int r2 = r2 + r3
            r0.f28678z = r2
        L_0x01a0:
            if (r1 != r5) goto L_0x01a5
            r0.m30486a(r9)
        L_0x01a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjg.mo31869a(int, int, com.google.android.gms.internal.ads.zzie):void");
    }

    /* renamed from: a */
    private final void m30486a(zzip zzip) {
        zzip.mo28863a(this.f28649C, this.f28648B, this.f28678z, 0, null);
        this.f28677y = 0;
        this.f28650D = true;
    }

    /* renamed from: b */
    private final ArrayList<byte[]> m30488b() throws zzhl {
        String str = "Error parsing vorbis codec private";
        try {
            byte[] bArr = this.f28663k.f23043j;
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
                            ArrayList<byte[]> arrayList = new ArrayList<>(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw new zzhl(str);
                    }
                    throw new zzhl(str);
                }
                throw new zzhl(str);
            }
            throw new zzhl(str);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzhl(str);
        }
    }

    /* renamed from: a */
    private final long m30485a(long j) {
        return TimeUnit.NANOSECONDS.toMicros(j * this.f28660h);
    }

    /* renamed from: a */
    private static boolean m30487a(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str);
    }
}
