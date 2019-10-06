package com.google.android.gms.internal.ads;

import android.media.AudioAttributes.Builder;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class zzmh {

    /* renamed from: a */
    private static boolean f28844a = false;

    /* renamed from: b */
    private static boolean f28845b = false;

    /* renamed from: A */
    private int f28846A;

    /* renamed from: B */
    private int f28847B;

    /* renamed from: C */
    private long f28848C;

    /* renamed from: D */
    private long f28849D;

    /* renamed from: E */
    private boolean f28850E;

    /* renamed from: F */
    private long f28851F;

    /* renamed from: G */
    private Method f28852G;

    /* renamed from: H */
    private int f28853H;

    /* renamed from: I */
    private long f28854I;

    /* renamed from: J */
    private long f28855J;

    /* renamed from: K */
    private int f28856K;

    /* renamed from: L */
    private long f28857L;

    /* renamed from: M */
    private long f28858M;

    /* renamed from: N */
    private int f28859N;

    /* renamed from: O */
    private int f28860O;

    /* renamed from: P */
    private long f28861P;

    /* renamed from: Q */
    private long f28862Q;

    /* renamed from: R */
    private long f28863R;

    /* renamed from: S */
    private float f28864S;

    /* renamed from: T */
    private zzlx[] f28865T;

    /* renamed from: U */
    private ByteBuffer[] f28866U;

    /* renamed from: V */
    private ByteBuffer f28867V;

    /* renamed from: W */
    private ByteBuffer f28868W;

    /* renamed from: X */
    private byte[] f28869X;

    /* renamed from: Y */
    private int f28870Y;

    /* renamed from: Z */
    private int f28871Z;

    /* renamed from: aa */
    private boolean f28872aa;

    /* renamed from: ba */
    private boolean f28873ba;

    /* renamed from: c */
    private final zzlw f28874c = null;

    /* renamed from: ca */
    private int f28875ca;

    /* renamed from: d */
    private final C9051Or f28876d;

    /* renamed from: da */
    private boolean f28877da;

    /* renamed from: e */
    private final zzmx f28878e;

    /* renamed from: ea */
    private boolean f28879ea;

    /* renamed from: f */
    private final zzlx[] f28880f;

    /* renamed from: fa */
    private long f28881fa;

    /* renamed from: g */
    private final zzmn f28882g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final ConditionVariable f28883h;

    /* renamed from: i */
    private final long[] f28884i;

    /* renamed from: j */
    private final C8988Lr f28885j;

    /* renamed from: k */
    private final LinkedList<C9030Nr> f28886k;

    /* renamed from: l */
    private AudioTrack f28887l;

    /* renamed from: m */
    private int f28888m;

    /* renamed from: n */
    private int f28889n;

    /* renamed from: o */
    private int f28890o;

    /* renamed from: p */
    private int f28891p;

    /* renamed from: q */
    private int f28892q;

    /* renamed from: r */
    private boolean f28893r;

    /* renamed from: s */
    private int f28894s;

    /* renamed from: t */
    private long f28895t;

    /* renamed from: u */
    private zzln f28896u;

    /* renamed from: v */
    private zzln f28897v;

    /* renamed from: w */
    private long f28898w;

    /* renamed from: x */
    private long f28899x;

    /* renamed from: y */
    private ByteBuffer f28900y;

    /* renamed from: z */
    private int f28901z;

    public zzmh(zzlw zzlw, zzlx[] zzlxArr, zzmn zzmn) {
        this.f28882g = zzmn;
        this.f28883h = new ConditionVariable(true);
        if (zzsy.f29345a >= 18) {
            try {
                this.f28852G = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException e) {
            }
        }
        if (zzsy.f29345a >= 19) {
            this.f28885j = new C9009Mr();
        } else {
            this.f28885j = new C8988Lr(null);
        }
        this.f28876d = new C9051Or();
        this.f28878e = new zzmx();
        this.f28880f = new zzlx[(zzlxArr.length + 3)];
        this.f28880f[0] = new C9113Rr();
        zzlx[] zzlxArr2 = this.f28880f;
        zzlxArr2[1] = this.f28876d;
        System.arraycopy(zzlxArr, 0, zzlxArr2, 2, zzlxArr.length);
        this.f28880f[zzlxArr.length + 2] = this.f28878e;
        this.f28884i = new long[10];
        this.f28864S = 1.0f;
        this.f28860O = 0;
        this.f28892q = 3;
        this.f28875ca = 0;
        this.f28897v = zzln.f28809a;
        this.f28871Z = -1;
        this.f28865T = new zzlx[0];
        this.f28866U = new ByteBuffer[0];
        this.f28886k = new LinkedList<>();
    }

    /* renamed from: a */
    public final boolean mo31985a(String str) {
        zzlw zzlw = this.f28874c;
        return zzlw != null && zzlw.mo31963a(m30703b(str));
    }

    /* renamed from: a */
    public final long mo31979a(boolean z) {
        long j;
        long j2;
        if (!(m30707k() && this.f28860O != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.f28887l.getPlayState() == 3) {
            long b = this.f28885j.mo28440b();
            if (b != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.f28849D >= 30000) {
                    long[] jArr = this.f28884i;
                    int i = this.f28846A;
                    jArr[i] = b - nanoTime;
                    this.f28846A = (i + 1) % 10;
                    int i2 = this.f28847B;
                    if (i2 < 10) {
                        this.f28847B = i2 + 1;
                    }
                    this.f28849D = nanoTime;
                    this.f28848C = 0;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.f28847B;
                        if (i3 >= i4) {
                            break;
                        }
                        this.f28848C += this.f28884i[i3] / ((long) i4);
                        i3++;
                    }
                }
                if (!m30713q() && nanoTime - this.f28851F >= 500000) {
                    this.f28850E = this.f28885j.mo28442d();
                    String str = "AudioTrack";
                    if (this.f28850E) {
                        long e = this.f28885j.mo28443e() / 1000;
                        long f = this.f28885j.mo28444f();
                        if (e < this.f28862Q) {
                            this.f28850E = false;
                        } else {
                            String str2 = ", ";
                            if (Math.abs(e - nanoTime) > 5000000) {
                                StringBuilder sb = new StringBuilder(Opcodes.L2I);
                                sb.append("Spurious audio timestamp (system clock mismatch): ");
                                sb.append(f);
                                sb.append(str2);
                                sb.append(e);
                                sb.append(str2);
                                sb.append(nanoTime);
                                sb.append(str2);
                                sb.append(b);
                                Log.w(str, sb.toString());
                                this.f28850E = false;
                            } else if (Math.abs(m30701a(f) - b) > 5000000) {
                                StringBuilder sb2 = new StringBuilder(Opcodes.L2D);
                                sb2.append("Spurious audio timestamp (frame position mismatch): ");
                                sb2.append(f);
                                sb2.append(str2);
                                sb2.append(e);
                                sb2.append(str2);
                                sb2.append(nanoTime);
                                sb2.append(str2);
                                sb2.append(b);
                                Log.w(str, sb2.toString());
                                this.f28850E = false;
                            }
                        }
                    }
                    Method method = this.f28852G;
                    if (method != null && !this.f28893r) {
                        try {
                            this.f28863R = (((long) ((Integer) method.invoke(this.f28887l, null)).intValue()) * 1000) - this.f28895t;
                            this.f28863R = Math.max(this.f28863R, 0);
                            if (this.f28863R > 5000000) {
                                long j3 = this.f28863R;
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(j3);
                                Log.w(str, sb3.toString());
                                this.f28863R = 0;
                            }
                        } catch (Exception e2) {
                            this.f28852G = null;
                        }
                    }
                    this.f28851F = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.f28850E) {
            j = m30701a(this.f28885j.mo28444f() + m30704b(nanoTime2 - (this.f28885j.mo28443e() / 1000)));
        } else {
            if (this.f28847B == 0) {
                j = this.f28885j.mo28440b();
            } else {
                j = nanoTime2 + this.f28848C;
            }
            if (!z) {
                j -= this.f28863R;
            }
        }
        long j4 = this.f28861P;
        while (!this.f28886k.isEmpty() && j >= ((C9030Nr) this.f28886k.getFirst()).f21524c) {
            C9030Nr nr = (C9030Nr) this.f28886k.remove();
            this.f28897v = nr.f21522a;
            this.f28899x = nr.f21524c;
            this.f28898w = nr.f21523b - this.f28861P;
        }
        if (this.f28897v.f28810b == 1.0f) {
            j2 = (j + this.f28898w) - this.f28899x;
        } else if (!this.f28886k.isEmpty() || this.f28878e.mo32011h() < 1024) {
            long j5 = this.f28898w;
            double d = (double) this.f28897v.f28810b;
            double d2 = (double) (j - this.f28899x);
            Double.isNaN(d);
            Double.isNaN(d2);
            j2 = ((long) (d * d2)) + j5;
        } else {
            j2 = zzsy.m31148a(j - this.f28899x, this.f28878e.mo32010g(), this.f28878e.mo32011h()) + this.f28898w;
        }
        return j4 + j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0148  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo31984a(java.lang.String r8, int r9, int r10, int r11, int r12, int[] r13) throws com.google.android.gms.internal.ads.zzml {
        /*
            r7 = this;
            java.lang.String r12 = "audio/raw"
            boolean r12 = r12.equals(r8)
            r0 = 1
            r12 = r12 ^ r0
            if (r12 == 0) goto L_0x000f
            int r8 = m30703b(r8)
            goto L_0x0010
        L_0x000f:
            r8 = r11
        L_0x0010:
            r1 = 0
            if (r12 != 0) goto L_0x0051
            int r11 = com.google.android.gms.internal.ads.zzsy.m31155b(r11, r9)
            r7.f28853H = r11
            com.google.android.gms.internal.ads.Or r11 = r7.f28876d
            r11.mo28501a(r13)
            com.google.android.gms.internal.ads.zzlx[] r11 = r7.f28880f
            int r13 = r11.length
            r3 = r8
            r2 = r9
            r8 = 0
            r9 = 0
        L_0x0026:
            if (r8 >= r13) goto L_0x0048
            r4 = r11[r8]
            boolean r5 = r4.mo28503a(r10, r2, r3)     // Catch:{ zzly -> 0x0041 }
            r9 = r9 | r5
            boolean r5 = r4.mo28502a()
            if (r5 == 0) goto L_0x003e
            int r2 = r4.mo28507e()
            int r3 = r4.mo28508f()
        L_0x003e:
            int r8 = r8 + 1
            goto L_0x0026
        L_0x0041:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzml r9 = new com.google.android.gms.internal.ads.zzml
            r9.<init>(r8)
            throw r9
        L_0x0048:
            if (r9 == 0) goto L_0x004d
            r7.m30709m()
        L_0x004d:
            r11 = r9
            r9 = r2
            r8 = r3
            goto L_0x0052
        L_0x0051:
            r11 = 0
        L_0x0052:
            r13 = 252(0xfc, float:3.53E-43)
            r2 = 12
            switch(r9) {
                case 1: goto L_0x0089;
                case 2: goto L_0x0085;
                case 3: goto L_0x0082;
                case 4: goto L_0x007f;
                case 5: goto L_0x007c;
                case 6: goto L_0x0078;
                case 7: goto L_0x0075;
                case 8: goto L_0x0072;
                default: goto L_0x0059;
            }
        L_0x0059:
            com.google.android.gms.internal.ads.zzml r8 = new com.google.android.gms.internal.ads.zzml
            r10 = 38
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r10)
            java.lang.String r10 = "Unsupported channel count: "
            r11.append(r10)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r8.<init>(r9)
            throw r8
        L_0x0072:
            int r3 = com.google.android.gms.internal.ads.zzkt.f28758a
            goto L_0x008b
        L_0x0075:
            r3 = 1276(0x4fc, float:1.788E-42)
            goto L_0x008b
        L_0x0078:
            r3 = 252(0xfc, float:3.53E-43)
            goto L_0x008b
        L_0x007c:
            r3 = 220(0xdc, float:3.08E-43)
            goto L_0x008b
        L_0x007f:
            r3 = 204(0xcc, float:2.86E-43)
            goto L_0x008b
        L_0x0082:
            r3 = 28
            goto L_0x008b
        L_0x0085:
            r3 = 12
            goto L_0x008b
        L_0x0089:
            r3 = 4
        L_0x008b:
            int r4 = com.google.android.gms.internal.ads.zzsy.f29345a
            r5 = 23
            r6 = 5
            if (r4 > r5) goto L_0x00b3
            java.lang.String r4 = com.google.android.gms.internal.ads.zzsy.f29346b
            java.lang.String r5 = "foster"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00b3
            java.lang.String r4 = com.google.android.gms.internal.ads.zzsy.f29347c
            java.lang.String r5 = "NVIDIA"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00b3
            r4 = 3
            if (r9 == r4) goto L_0x00b2
            if (r9 == r6) goto L_0x00b2
            r13 = 7
            if (r9 == r13) goto L_0x00af
            goto L_0x00b3
        L_0x00af:
            int r13 = com.google.android.gms.internal.ads.zzkt.f28758a
            goto L_0x00b4
        L_0x00b2:
            goto L_0x00b4
        L_0x00b3:
            r13 = r3
        L_0x00b4:
            int r3 = com.google.android.gms.internal.ads.zzsy.f29345a
            r4 = 25
            if (r3 > r4) goto L_0x00ca
            java.lang.String r3 = com.google.android.gms.internal.ads.zzsy.f29346b
            java.lang.String r4 = "fugu"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00ca
            if (r12 == 0) goto L_0x00ca
            if (r9 != r0) goto L_0x00ca
            r13 = 12
        L_0x00ca:
            if (r11 != 0) goto L_0x00df
            boolean r11 = r7.m30707k()
            if (r11 == 0) goto L_0x00df
            int r11 = r7.f28890o
            if (r11 != r8) goto L_0x00df
            int r11 = r7.f28888m
            if (r11 != r10) goto L_0x00df
            int r11 = r7.f28889n
            if (r11 != r13) goto L_0x00df
            return
        L_0x00df:
            r7.mo31990d()
            r7.f28890o = r8
            r7.f28893r = r12
            r7.f28888m = r10
            r7.f28889n = r13
            r11 = 2
            if (r12 == 0) goto L_0x00ee
            goto L_0x00ef
        L_0x00ee:
            r8 = 2
        L_0x00ef:
            r7.f28891p = r8
            int r8 = com.google.android.gms.internal.ads.zzsy.m31155b(r11, r9)
            r7.f28856K = r8
            if (r12 == 0) goto L_0x0108
            int r8 = r7.f28891p
            if (r8 == r6) goto L_0x0105
            r9 = 6
            if (r8 != r9) goto L_0x0101
            goto L_0x0105
        L_0x0101:
            r8 = 49152(0xc000, float:6.8877E-41)
            goto L_0x013e
        L_0x0105:
            r8 = 20480(0x5000, float:2.8699E-41)
            goto L_0x013e
        L_0x0108:
            int r8 = r7.f28891p
            int r8 = android.media.AudioTrack.getMinBufferSize(r10, r13, r8)
            r9 = -2
            if (r8 == r9) goto L_0x0112
            goto L_0x0113
        L_0x0112:
            r0 = 0
        L_0x0113:
            com.google.android.gms.internal.ads.zzsk.m31082b(r0)
            int r9 = r8 << 2
            r10 = 250000(0x3d090, double:1.235164E-318)
            long r10 = r7.m30704b(r10)
            int r11 = (int) r10
            int r10 = r7.f28856K
            int r10 = r10 * r11
            long r0 = (long) r8
            r2 = 750000(0xb71b0, double:3.70549E-318)
            long r2 = r7.m30704b(r2)
            int r8 = r7.f28856K
            long r4 = (long) r8
            long r2 = r2 * r4
            long r0 = java.lang.Math.max(r0, r2)
            int r8 = (int) r0
            if (r9 >= r10) goto L_0x013a
            r8 = r10
            goto L_0x013e
        L_0x013a:
            if (r9 <= r8) goto L_0x013d
            goto L_0x013e
        L_0x013d:
            r8 = r9
        L_0x013e:
            r7.f28894s = r8
            if (r12 == 0) goto L_0x0148
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x0152
        L_0x0148:
            int r8 = r7.f28894s
            int r9 = r7.f28856K
            int r8 = r8 / r9
            long r8 = (long) r8
            long r8 = r7.m30701a(r8)
        L_0x0152:
            r7.f28895t = r8
            com.google.android.gms.internal.ads.zzln r8 = r7.f28897v
            r7.mo31980a(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmh.mo31984a(java.lang.String, int, int, int, int, int[]):void");
    }

    /* renamed from: m */
    private final void m30709m() {
        zzlx[] zzlxArr;
        ArrayList arrayList = new ArrayList();
        for (zzlx zzlx : this.f28880f) {
            if (zzlx.mo28502a()) {
                arrayList.add(zzlx);
            } else {
                zzlx.flush();
            }
        }
        int size = arrayList.size();
        this.f28865T = (zzlx[]) arrayList.toArray(new zzlx[size]);
        this.f28866U = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            zzlx zzlx2 = this.f28865T[i];
            zzlx2.flush();
            this.f28866U[i] = zzlx2.mo28506d();
        }
    }

    /* renamed from: b */
    public final void mo31987b() {
        this.f28873ba = true;
        if (m30707k()) {
            this.f28862Q = System.nanoTime() / 1000;
            this.f28887l.play();
        }
    }

    /* renamed from: f */
    public final void mo31992f() {
        if (this.f28860O == 1) {
            this.f28860O = 2;
        }
    }

    /* renamed from: a */
    public final boolean mo31986a(ByteBuffer byteBuffer, long j) throws zzmm, zzmp {
        int i;
        int i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j2 = j;
        ByteBuffer byteBuffer3 = this.f28867V;
        zzsk.m31080a(byteBuffer3 == null || byteBuffer2 == byteBuffer3);
        if (!m30707k()) {
            this.f28883h.block();
            if (this.f28877da) {
                AudioTrack audioTrack = new AudioTrack(new Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.f28889n).setEncoding(this.f28891p).setSampleRate(this.f28888m).build(), this.f28894s, 1, this.f28875ca);
                this.f28887l = audioTrack;
            } else {
                int i3 = this.f28875ca;
                if (i3 == 0) {
                    AudioTrack audioTrack2 = new AudioTrack(this.f28892q, this.f28888m, this.f28889n, this.f28891p, this.f28894s, 1);
                    this.f28887l = audioTrack2;
                } else {
                    AudioTrack audioTrack3 = new AudioTrack(this.f28892q, this.f28888m, this.f28889n, this.f28891p, this.f28894s, 1, i3);
                    this.f28887l = audioTrack3;
                }
            }
            int state = this.f28887l.getState();
            if (state == 1) {
                int audioSessionId = this.f28887l.getAudioSessionId();
                if (this.f28875ca != audioSessionId) {
                    this.f28875ca = audioSessionId;
                    this.f28882g.mo28548a(audioSessionId);
                }
                this.f28885j.mo28439a(this.f28887l, m30713q());
                m30711o();
                this.f28879ea = false;
                if (this.f28873ba) {
                    mo31987b();
                }
            } else {
                try {
                    this.f28887l.release();
                } catch (Exception e) {
                } finally {
                    this.f28887l = null;
                }
                throw new zzmm(state, this.f28888m, this.f28889n, this.f28894s);
            }
        }
        if (m30713q()) {
            if (this.f28887l.getPlayState() == 2) {
                this.f28879ea = false;
                return false;
            } else if (this.f28887l.getPlayState() == 1 && this.f28885j.mo28441c() != 0) {
                return false;
            }
        }
        boolean z = this.f28879ea;
        this.f28879ea = mo31993g();
        if (z && !this.f28879ea && this.f28887l.getPlayState() != 1) {
            this.f28882g.mo28549a(this.f28894s, zzkt.m30596a(this.f28895t), SystemClock.elapsedRealtime() - this.f28881fa);
        }
        if (this.f28867V == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.f28893r && this.f28859N == 0) {
                int i4 = this.f28891p;
                if (i4 == 7 || i4 == 8) {
                    i2 = zzmr.m30735a(byteBuffer);
                } else if (i4 == 5) {
                    i2 = zzlv.m30674a();
                } else if (i4 == 6) {
                    i2 = zzlv.m30675a(byteBuffer);
                } else {
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unexpected audio encoding: ");
                    sb.append(i4);
                    throw new IllegalStateException(sb.toString());
                }
                this.f28859N = i2;
            }
            if (this.f28896u != null) {
                if (!m30710n()) {
                    return false;
                }
                LinkedList<C9030Nr> linkedList = this.f28886k;
                C9030Nr nr = r11;
                C9030Nr nr2 = new C9030Nr(this.f28896u, Math.max(0, j2), m30701a(m30712p()), null);
                linkedList.add(nr);
                this.f28896u = null;
                m30709m();
            }
            if (this.f28860O == 0) {
                this.f28861P = Math.max(0, j2);
                this.f28860O = 1;
            } else {
                long a = this.f28861P + m30701a(this.f28893r ? this.f28855J : this.f28854I / ((long) this.f28853H));
                if (this.f28860O != 1) {
                    i = 2;
                } else if (Math.abs(a - j2) > 200000) {
                    StringBuilder sb2 = new StringBuilder(80);
                    sb2.append("Discontinuity detected [expected ");
                    sb2.append(a);
                    sb2.append(", got ");
                    sb2.append(j2);
                    sb2.append("]");
                    Log.e("AudioTrack", sb2.toString());
                    i = 2;
                    this.f28860O = 2;
                } else {
                    i = 2;
                }
                if (this.f28860O == i) {
                    this.f28861P += j2 - a;
                    this.f28860O = 1;
                    this.f28882g.mo28547a();
                }
            }
            if (this.f28893r) {
                this.f28855J += (long) this.f28859N;
            } else {
                this.f28854I += (long) byteBuffer.remaining();
            }
            this.f28867V = byteBuffer2;
        }
        if (this.f28893r) {
            m30705b(this.f28867V, j2);
        } else {
            m30706c(j2);
        }
        if (this.f28867V.hasRemaining()) {
            return false;
        }
        this.f28867V = null;
        return true;
    }

    /* renamed from: c */
    private final void m30706c(long j) throws zzmp {
        ByteBuffer byteBuffer;
        int length = this.f28865T.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.f28866U[i - 1];
            } else {
                byteBuffer = this.f28867V;
                if (byteBuffer == null) {
                    byteBuffer = zzlx.f28841a;
                }
            }
            if (i == length) {
                m30705b(byteBuffer, j);
            } else {
                zzlx zzlx = this.f28865T[i];
                zzlx.mo28500a(byteBuffer);
                ByteBuffer d = zzlx.mo28506d();
                this.f28866U[i] = d;
                if (d.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    private final boolean m30705b(ByteBuffer byteBuffer, long j) throws zzmp {
        int i;
        if (!byteBuffer.hasRemaining()) {
            return true;
        }
        ByteBuffer byteBuffer2 = this.f28868W;
        if (byteBuffer2 != null) {
            zzsk.m31080a(byteBuffer2 == byteBuffer);
        } else {
            this.f28868W = byteBuffer;
            if (zzsy.f29345a < 21) {
                int remaining = byteBuffer.remaining();
                byte[] bArr = this.f28869X;
                if (bArr == null || bArr.length < remaining) {
                    this.f28869X = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.f28869X, 0, remaining);
                byteBuffer.position(position);
                this.f28870Y = 0;
            }
        }
        int remaining2 = byteBuffer.remaining();
        if (zzsy.f29345a < 21) {
            int c = this.f28894s - ((int) (this.f28857L - (this.f28885j.mo28441c() * ((long) this.f28856K))));
            if (c > 0) {
                i = this.f28887l.write(this.f28869X, this.f28870Y, Math.min(remaining2, c));
                if (i > 0) {
                    this.f28870Y += i;
                    byteBuffer.position(byteBuffer.position() + i);
                }
            } else {
                i = 0;
            }
        } else if (this.f28877da) {
            zzsk.m31082b(j != -9223372036854775807L);
            AudioTrack audioTrack = this.f28887l;
            if (this.f28900y == null) {
                this.f28900y = ByteBuffer.allocate(16);
                this.f28900y.order(ByteOrder.BIG_ENDIAN);
                this.f28900y.putInt(1431633921);
            }
            if (this.f28901z == 0) {
                this.f28900y.putInt(4, remaining2);
                this.f28900y.putLong(8, j * 1000);
                this.f28900y.position(0);
                this.f28901z = remaining2;
            }
            int remaining3 = this.f28900y.remaining();
            if (remaining3 > 0) {
                int write = audioTrack.write(this.f28900y, remaining3, 1);
                if (write < 0) {
                    this.f28901z = 0;
                    i = write;
                } else if (write < remaining3) {
                    i = 0;
                }
            }
            int write2 = audioTrack.write(byteBuffer, remaining2, 1);
            if (write2 < 0) {
                this.f28901z = 0;
            } else {
                this.f28901z -= write2;
            }
            i = write2;
        } else {
            i = this.f28887l.write(byteBuffer, remaining2, 1);
        }
        this.f28881fa = SystemClock.elapsedRealtime();
        if (i >= 0) {
            if (!this.f28893r) {
                this.f28857L += (long) i;
            }
            if (i != remaining2) {
                return false;
            }
            if (this.f28893r) {
                this.f28858M += (long) this.f28859N;
            }
            this.f28868W = null;
            return true;
        }
        throw new zzmp(i);
    }

    /* renamed from: h */
    public final void mo31994h() throws zzmp {
        if (!this.f28872aa && m30707k() && m30710n()) {
            this.f28885j.mo28438a(m30712p());
            this.f28901z = 0;
            this.f28872aa = true;
        }
    }

    /* renamed from: n */
    private final boolean m30710n() throws zzmp {
        boolean z;
        if (this.f28871Z == -1) {
            this.f28871Z = this.f28893r ? this.f28865T.length : 0;
            z = true;
        } else {
            z = false;
        }
        while (true) {
            int i = this.f28871Z;
            zzlx[] zzlxArr = this.f28865T;
            if (i < zzlxArr.length) {
                zzlx zzlx = zzlxArr[i];
                if (z) {
                    zzlx.mo28505c();
                }
                m30706c(-9223372036854775807L);
                if (!zzlx.mo28504b()) {
                    return false;
                }
                this.f28871Z++;
                z = true;
            } else {
                ByteBuffer byteBuffer = this.f28868W;
                if (byteBuffer != null) {
                    m30705b(byteBuffer, -9223372036854775807L);
                    if (this.f28868W != null) {
                        return false;
                    }
                }
                this.f28871Z = -1;
                return true;
            }
        }
    }

    /* renamed from: e */
    public final boolean mo31991e() {
        return !m30707k() || (this.f28872aa && !mo31993g());
    }

    /* renamed from: g */
    public final boolean mo31993g() {
        if (m30707k()) {
            if (m30712p() <= this.f28885j.mo28441c()) {
                if (m30713q() && this.f28887l.getPlayState() == 2 && this.f28887l.getPlaybackHeadPosition() == 0) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final zzln mo31980a(zzln zzln) {
        if (this.f28893r) {
            this.f28897v = zzln.f28809a;
            return this.f28897v;
        }
        zzln zzln2 = new zzln(this.f28878e.mo32008a(zzln.f28810b), this.f28878e.mo32009b(zzln.f28811c));
        zzln zzln3 = this.f28896u;
        if (zzln3 == null) {
            if (!this.f28886k.isEmpty()) {
                zzln3 = ((C9030Nr) this.f28886k.getLast()).f21522a;
            } else {
                zzln3 = this.f28897v;
            }
        }
        if (!zzln2.equals(zzln3)) {
            if (m30707k()) {
                this.f28896u = zzln2;
            } else {
                this.f28897v = zzln2;
            }
        }
        return this.f28897v;
    }

    /* renamed from: i */
    public final zzln mo31995i() {
        return this.f28897v;
    }

    /* renamed from: a */
    public final void mo31983a(int i) {
        if (this.f28892q != i) {
            this.f28892q = i;
            if (!this.f28877da) {
                mo31990d();
                this.f28875ca = 0;
            }
        }
    }

    /* renamed from: b */
    public final void mo31988b(int i) {
        zzsk.m31082b(zzsy.f29345a >= 21);
        if (!this.f28877da || this.f28875ca != i) {
            this.f28877da = true;
            this.f28875ca = i;
            mo31990d();
        }
    }

    /* renamed from: j */
    public final void mo31996j() {
        if (this.f28877da) {
            this.f28877da = false;
            this.f28875ca = 0;
            mo31990d();
        }
    }

    /* renamed from: a */
    public final void mo31982a(float f) {
        if (this.f28864S != f) {
            this.f28864S = f;
            m30711o();
        }
    }

    /* renamed from: o */
    private final void m30711o() {
        if (m30707k()) {
            if (zzsy.f29345a >= 21) {
                this.f28887l.setVolume(this.f28864S);
                return;
            }
            AudioTrack audioTrack = this.f28887l;
            float f = this.f28864S;
            audioTrack.setStereoVolume(f, f);
        }
    }

    /* renamed from: a */
    public final void mo31981a() {
        this.f28873ba = false;
        if (m30707k()) {
            m30708l();
            this.f28885j.mo28437a();
        }
    }

    /* renamed from: d */
    public final void mo31990d() {
        if (m30707k()) {
            this.f28854I = 0;
            this.f28855J = 0;
            this.f28857L = 0;
            this.f28858M = 0;
            this.f28859N = 0;
            zzln zzln = this.f28896u;
            if (zzln != null) {
                this.f28897v = zzln;
                this.f28896u = null;
            } else if (!this.f28886k.isEmpty()) {
                this.f28897v = ((C9030Nr) this.f28886k.getLast()).f21522a;
            }
            this.f28886k.clear();
            this.f28898w = 0;
            this.f28899x = 0;
            this.f28867V = null;
            this.f28868W = null;
            int i = 0;
            while (true) {
                zzlx[] zzlxArr = this.f28865T;
                if (i >= zzlxArr.length) {
                    break;
                }
                zzlx zzlx = zzlxArr[i];
                zzlx.flush();
                this.f28866U[i] = zzlx.mo28506d();
                i++;
            }
            this.f28872aa = false;
            this.f28871Z = -1;
            this.f28900y = null;
            this.f28901z = 0;
            this.f28860O = 0;
            this.f28863R = 0;
            m30708l();
            if (this.f28887l.getPlayState() == 3) {
                this.f28887l.pause();
            }
            AudioTrack audioTrack = this.f28887l;
            this.f28887l = null;
            this.f28885j.mo28439a(null, false);
            this.f28883h.close();
            new C8967Kr(this, audioTrack).start();
        }
    }

    /* renamed from: c */
    public final void mo31989c() {
        mo31990d();
        for (zzlx reset : this.f28880f) {
            reset.reset();
        }
        this.f28875ca = 0;
        this.f28873ba = false;
    }

    /* renamed from: k */
    private final boolean m30707k() {
        return this.f28887l != null;
    }

    /* renamed from: a */
    private final long m30701a(long j) {
        return (j * 1000000) / ((long) this.f28888m);
    }

    /* renamed from: b */
    private final long m30704b(long j) {
        return (j * ((long) this.f28888m)) / 1000000;
    }

    /* renamed from: p */
    private final long m30712p() {
        return this.f28893r ? this.f28858M : this.f28857L / ((long) this.f28856K);
    }

    /* renamed from: l */
    private final void m30708l() {
        this.f28848C = 0;
        this.f28847B = 0;
        this.f28846A = 0;
        this.f28849D = 0;
        this.f28850E = false;
        this.f28851F = 0;
    }

    /* renamed from: q */
    private final boolean m30713q() {
        if (zzsy.f29345a < 23) {
            int i = this.f28891p;
            if (i == 5 || i == 6) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m30703b(java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1095064472: goto L_0x002a;
                case 187078296: goto L_0x0020;
                case 1504578661: goto L_0x0016;
                case 1505942594: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0034
        L_0x000c:
            java.lang.String r0 = "audio/vnd.dts.hd"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x000b
            r5 = 3
            goto L_0x0035
        L_0x0016:
            java.lang.String r0 = "audio/eac3"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x000b
            r5 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "audio/ac3"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x000b
            r5 = 0
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "audio/vnd.dts"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x000b
            r5 = 2
            goto L_0x0035
        L_0x0034:
            r5 = -1
        L_0x0035:
            if (r5 == 0) goto L_0x0045
            if (r5 == r4) goto L_0x0043
            if (r5 == r3) goto L_0x0041
            if (r5 == r2) goto L_0x003e
            return r1
        L_0x003e:
            r5 = 8
            return r5
        L_0x0041:
            r5 = 7
            return r5
        L_0x0043:
            r5 = 6
            return r5
        L_0x0045:
            r5 = 5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmh.m30703b(java.lang.String):int");
    }
}
