package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class zzth extends zzpe {

    /* renamed from: V */
    private static final int[] f29371V = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};

    /* renamed from: Aa */
    private long f29372Aa;

    /* renamed from: Ba */
    private int f29373Ba;

    /* renamed from: W */
    private final Context f29374W;

    /* renamed from: X */
    private final zztl f29375X;

    /* renamed from: Y */
    private final zzto f29376Y;

    /* renamed from: Z */
    private final long f29377Z;

    /* renamed from: aa */
    private final int f29378aa;

    /* renamed from: ba */
    private final boolean f29379ba;

    /* renamed from: ca */
    private final long[] f29380ca;

    /* renamed from: da */
    private zzlh[] f29381da;

    /* renamed from: ea */
    private zztj f29382ea;

    /* renamed from: fa */
    private Surface f29383fa;

    /* renamed from: ga */
    private Surface f29384ga;

    /* renamed from: ha */
    private int f29385ha;

    /* renamed from: ia */
    private boolean f29386ia;

    /* renamed from: ja */
    private long f29387ja;

    /* renamed from: ka */
    private long f29388ka;

    /* renamed from: la */
    private int f29389la;

    /* renamed from: ma */
    private int f29390ma;

    /* renamed from: na */
    private int f29391na;

    /* renamed from: oa */
    private float f29392oa;

    /* renamed from: pa */
    private int f29393pa;

    /* renamed from: qa */
    private int f29394qa;

    /* renamed from: ra */
    private int f29395ra;

    /* renamed from: sa */
    private float f29396sa;

    /* renamed from: ta */
    private int f29397ta;

    /* renamed from: ua */
    private int f29398ua;

    /* renamed from: va */
    private int f29399va;

    /* renamed from: wa */
    private float f29400wa;

    /* renamed from: xa */
    private boolean f29401xa;

    /* renamed from: ya */
    private int f29402ya;

    /* renamed from: za */
    C9350bt f29403za;

    public zzth(Context context, zzpg zzpg, long j, Handler handler, zztn zztn, int i) {
        this(context, zzpg, 0, null, false, handler, zztn, -1);
    }

    private zzth(Context context, zzpg zzpg, long j, zznj<Object> zznj, boolean z, Handler handler, zztn zztn, int i) {
        boolean z2 = false;
        super(2, zzpg, null, false);
        this.f29377Z = 0;
        this.f29378aa = -1;
        this.f29374W = context.getApplicationContext();
        this.f29375X = new zztl(context);
        this.f29376Y = new zzto(handler, zztn);
        if (zzsy.f29345a <= 22) {
            if ("foster".equals(zzsy.f29346b)) {
                if ("NVIDIA".equals(zzsy.f29347c)) {
                    z2 = true;
                }
            }
        }
        this.f29379ba = z2;
        this.f29380ca = new long[10];
        this.f29372Aa = -9223372036854775807L;
        this.f29387ja = -9223372036854775807L;
        this.f29393pa = -1;
        this.f29394qa = -1;
        this.f29396sa = -1.0f;
        this.f29392oa = -1.0f;
        this.f29385ha = 1;
        m31169D();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int mo31997a(zzpg zzpg, zzlh zzlh) throws zzpk {
        boolean z;
        String str = zzlh.f28784f;
        int i = 0;
        if (!zzsp.m31098b(str)) {
            return 0;
        }
        zzne zzne = zzlh.f28787i;
        if (zzne != null) {
            z = false;
            for (int i2 = 0; i2 < zzne.f28956c; i2++) {
                z |= zzne.mo32026a(i2).f28961e;
            }
        } else {
            z = false;
        }
        zzpd a = zzpg.mo29287a(str, z);
        if (a == null) {
            return 1;
        }
        boolean a2 = a.mo32076a(zzlh.f28781c);
        if (a2) {
            int i3 = zzlh.f28788j;
            if (i3 > 0) {
                int i4 = zzlh.f28789k;
                if (i4 > 0) {
                    if (zzsy.f29345a >= 21) {
                        a2 = a.mo32075a(i3, i4, (double) zzlh.f28790l);
                    } else {
                        a2 = i3 * i4 <= zzpi.m30914b();
                        if (!a2) {
                            int i5 = zzlh.f28788j;
                            int i6 = zzlh.f28789k;
                            String str2 = zzsy.f29349e;
                            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                            sb.append("FalseCheck [legacyFrameSize, ");
                            sb.append(i5);
                            sb.append("x");
                            sb.append(i6);
                            sb.append("] [");
                            sb.append(str2);
                            sb.append("]");
                            Log.d("MediaCodecVideoRenderer", sb.toString());
                        }
                    }
                }
            }
        }
        int i7 = a.f29081b ? 8 : 4;
        if (a.f29082c) {
            i = 16;
        }
        return (a2 ? 3 : 2) | i7 | i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31909a(boolean z) throws zzku {
        super.mo31909a(z);
        this.f29402ya = mo31928r().f28814b;
        this.f29401xa = this.f29402ya != 0;
        this.f29376Y.mo32240a(this.f29107U);
        this.f29375X.mo32235b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31910a(zzlh[] zzlhArr, long j) throws zzku {
        this.f29381da = zzlhArr;
        if (this.f29372Aa == -9223372036854775807L) {
            this.f29372Aa = j;
        } else {
            int i = this.f29373Ba;
            long[] jArr = this.f29380ca;
            if (i == jArr.length) {
                long j2 = jArr[i - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j2);
                Log.w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.f29373Ba = i + 1;
            }
            this.f29380ca[this.f29373Ba - 1] = j;
        }
        super.mo31910a(zzlhArr, j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31907a(long j, boolean z) throws zzku {
        super.mo31907a(j, z);
        m31168C();
        this.f29390ma = 0;
        int i = this.f29373Ba;
        if (i != 0) {
            this.f29372Aa = this.f29380ca[i - 1];
            this.f29373Ba = 0;
        }
        if (z) {
            m31167B();
        } else {
            this.f29387ja = -9223372036854775807L;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r9.f29383fa == r0) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        if (mo32084w() == null) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isReady() {
        /*
            r9 = this;
            boolean r0 = super.isReady()
            r1 = 1
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == 0) goto L_0x0021
            boolean r0 = r9.f29386ia
            if (r0 != 0) goto L_0x001e
            android.view.Surface r0 = r9.f29384ga
            if (r0 == 0) goto L_0x0018
            android.view.Surface r4 = r9.f29383fa
            if (r4 == r0) goto L_0x001e
        L_0x0018:
            android.media.MediaCodec r0 = r9.mo32084w()
            if (r0 != 0) goto L_0x0021
        L_0x001e:
            r9.f29387ja = r2
            return r1
        L_0x0021:
            long r4 = r9.f29387ja
            r0 = 0
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0029
            return r0
        L_0x0029:
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r6 = r9.f29387ja
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0034
            return r1
        L_0x0034:
            r9.f29387ja = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzth.isReady():boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public final void mo31925o() {
        super.mo31925o();
        this.f29389la = 0;
        this.f29388ka = SystemClock.elapsedRealtime();
        this.f29387ja = -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public final void mo31926p() {
        m31171F();
        super.mo31926p();
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public final void mo31927q() {
        this.f29393pa = -1;
        this.f29394qa = -1;
        this.f29396sa = -1.0f;
        this.f29392oa = -1.0f;
        this.f29372Aa = -9223372036854775807L;
        this.f29373Ba = 0;
        m31169D();
        m31168C();
        this.f29375X.mo32234a();
        this.f29403za = null;
        this.f29401xa = false;
        try {
            super.mo31927q();
        } finally {
            this.f29107U.mo32023a();
            this.f29376Y.mo32242b(this.f29107U);
        }
    }

    /* renamed from: a */
    public final void mo31905a(int i, Object obj) throws zzku {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                Surface surface2 = this.f29384ga;
                if (surface2 != null) {
                    surface = surface2;
                } else {
                    zzpd x = mo32085x();
                    if (x != null && m31177b(x.f29083d)) {
                        this.f29384ga = zztd.m31163a(this.f29374W, x.f29083d);
                        surface = this.f29384ga;
                    }
                }
            }
            if (this.f29383fa != surface) {
                this.f29383fa = surface;
                int state = getState();
                if (state == 1 || state == 2) {
                    MediaCodec w = mo32084w();
                    if (zzsy.f29345a < 23 || w == null || surface == null) {
                        mo32083u();
                        mo32082t();
                    } else {
                        w.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.f29384ga) {
                    m31169D();
                    m31168C();
                } else {
                    m31170E();
                    m31168C();
                    if (state == 2) {
                        m31167B();
                        return;
                    }
                }
                return;
            }
            if (!(surface == null || surface == this.f29384ga)) {
                m31170E();
                if (this.f29386ia) {
                    this.f29376Y.mo32238a(this.f29383fa);
                }
            }
        } else if (i == 4) {
            this.f29385ha = ((Integer) obj).intValue();
            MediaCodec w2 = mo32084w();
            if (w2 != null) {
                w2.setVideoScalingMode(this.f29385ha);
            }
        } else {
            super.mo31905a(i, obj);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo32081a(zzpd zzpd) {
        return this.f29383fa != null || m31177b(zzpd.f29083d);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x010f, code lost:
        r9 = null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo32002a(com.google.android.gms.internal.ads.zzpd r23, android.media.MediaCodec r24, com.google.android.gms.internal.ads.zzlh r25, android.media.MediaCrypto r26) throws com.google.android.gms.internal.ads.zzpk {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            com.google.android.gms.internal.ads.zzlh[] r4 = r0.f29381da
            int r5 = r3.f28788j
            int r6 = r3.f28789k
            int r7 = m31178c(r25)
            int r8 = r4.length
            r9 = -1
            r11 = 1
            if (r8 != r11) goto L_0x001e
            com.google.android.gms.internal.ads.zztj r4 = new com.google.android.gms.internal.ads.zztj
            r4.<init>(r5, r6, r7)
            goto L_0x0153
        L_0x001e:
            int r8 = r4.length
            r13 = r6
            r14 = r7
            r6 = 0
            r7 = r5
            r5 = 0
        L_0x0025:
            if (r5 >= r8) goto L_0x0057
            r15 = r4[r5]
            boolean r10 = r1.f29081b
            boolean r10 = m31175a(r10, r3, r15)
            if (r10 == 0) goto L_0x0054
            int r10 = r15.f28788j
            if (r10 == r9) goto L_0x003c
            int r10 = r15.f28789k
            if (r10 != r9) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r10 = 0
            goto L_0x003d
        L_0x003c:
            r10 = 1
        L_0x003d:
            r6 = r6 | r10
            int r10 = r15.f28788j
            int r7 = java.lang.Math.max(r7, r10)
            int r10 = r15.f28789k
            int r10 = java.lang.Math.max(r13, r10)
            int r13 = m31178c(r15)
            int r13 = java.lang.Math.max(r14, r13)
            r14 = r13
            r13 = r10
        L_0x0054:
            int r5 = r5 + 1
            goto L_0x0025
        L_0x0057:
            if (r6 == 0) goto L_0x014e
            r4 = 66
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "Resolutions unknown. Codec max resolution: "
            r5.append(r4)
            r5.append(r7)
            java.lang.String r4 = "x"
            r5.append(r4)
            r5.append(r13)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "MediaCodecVideoRenderer"
            android.util.Log.w(r6, r5)
            int r5 = r3.f28789k
            int r8 = r3.f28788j
            if (r5 <= r8) goto L_0x0082
            r5 = 1
            goto L_0x0083
        L_0x0082:
            r5 = 0
        L_0x0083:
            if (r5 == 0) goto L_0x0088
            int r8 = r3.f28789k
            goto L_0x008a
        L_0x0088:
            int r8 = r3.f28788j
        L_0x008a:
            if (r5 == 0) goto L_0x008f
            int r10 = r3.f28788j
            goto L_0x0091
        L_0x008f:
            int r10 = r3.f28789k
        L_0x0091:
            float r15 = (float) r10
            float r11 = (float) r8
            float r15 = r15 / r11
            int[] r11 = f29371V
            int r12 = r11.length
            r9 = 0
        L_0x0098:
            if (r9 >= r12) goto L_0x0111
            r16 = r12
            r12 = r11[r9]
            r17 = r11
            float r11 = (float) r12
            float r11 = r11 * r15
            int r11 = (int) r11
            if (r12 <= r8) goto L_0x010d
            if (r11 > r10) goto L_0x00ac
            r20 = r14
            goto L_0x010f
        L_0x00ac:
            r18 = r8
            int r8 = com.google.android.gms.internal.ads.zzsy.f29345a
            r19 = r10
            r10 = 21
            if (r8 < r10) goto L_0x00d6
            if (r5 == 0) goto L_0x00ba
            r8 = r11
            goto L_0x00bb
        L_0x00ba:
            r8 = r12
        L_0x00bb:
            if (r5 == 0) goto L_0x00be
            r11 = r12
        L_0x00be:
            android.graphics.Point r10 = r1.mo32073a(r8, r11)
            float r8 = r3.f28790l
            int r11 = r10.x
            int r12 = r10.y
            r20 = r14
            r21 = r15
            double r14 = (double) r8
            boolean r8 = r1.mo32075a(r11, r12, r14)
            if (r8 == 0) goto L_0x00d5
            r9 = r10
            goto L_0x0114
        L_0x00d5:
            goto L_0x00fe
        L_0x00d6:
            r20 = r14
            r21 = r15
            r8 = 16
            int r10 = com.google.android.gms.internal.ads.zzsy.m31145a(r12, r8)
            int r10 = r10 << 4
            int r8 = com.google.android.gms.internal.ads.zzsy.m31145a(r11, r8)
            int r8 = r8 << 4
            int r11 = r10 * r8
            int r12 = com.google.android.gms.internal.ads.zzpi.m30914b()
            if (r11 > r12) goto L_0x00fe
            android.graphics.Point r9 = new android.graphics.Point
            if (r5 == 0) goto L_0x00f6
            r11 = r8
            goto L_0x00f7
        L_0x00f6:
            r11 = r10
        L_0x00f7:
            if (r5 == 0) goto L_0x00fa
            r8 = r10
        L_0x00fa:
            r9.<init>(r11, r8)
            goto L_0x0114
        L_0x00fe:
            int r9 = r9 + 1
            r12 = r16
            r11 = r17
            r8 = r18
            r10 = r19
            r14 = r20
            r15 = r21
            goto L_0x0098
        L_0x010d:
            r20 = r14
        L_0x010f:
            r9 = 0
            goto L_0x0114
        L_0x0111:
            r20 = r14
            r9 = 0
        L_0x0114:
            if (r9 == 0) goto L_0x014c
            int r5 = r9.x
            int r7 = java.lang.Math.max(r7, r5)
            int r5 = r9.y
            int r13 = java.lang.Math.max(r13, r5)
            java.lang.String r5 = r3.f28784f
            int r5 = m31172a(r5, r7, r13)
            r14 = r20
            int r14 = java.lang.Math.max(r14, r5)
            r5 = 57
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r5)
            java.lang.String r5 = "Codec max resolution adjusted to: "
            r8.append(r5)
            r8.append(r7)
            r8.append(r4)
            r8.append(r13)
            java.lang.String r4 = r8.toString()
            android.util.Log.w(r6, r4)
            goto L_0x014e
        L_0x014c:
            r14 = r20
        L_0x014e:
            com.google.android.gms.internal.ads.zztj r4 = new com.google.android.gms.internal.ads.zztj
            r4.<init>(r7, r13, r14)
        L_0x0153:
            r0.f29382ea = r4
            com.google.android.gms.internal.ads.zztj r4 = r0.f29382ea
            boolean r5 = r0.f29379ba
            int r6 = r0.f29402ya
            android.media.MediaFormat r3 = r25.mo31938a()
            int r7 = r4.f29404a
            java.lang.String r8 = "max-width"
            r3.setInteger(r8, r7)
            int r7 = r4.f29405b
            java.lang.String r8 = "max-height"
            r3.setInteger(r8, r7)
            int r4 = r4.f29406c
            r7 = -1
            if (r4 == r7) goto L_0x0177
            java.lang.String r7 = "max-input-size"
            r3.setInteger(r7, r4)
        L_0x0177:
            if (r5 == 0) goto L_0x017f
            java.lang.String r4 = "auto-frc"
            r5 = 0
            r3.setInteger(r4, r5)
        L_0x017f:
            if (r6 == 0) goto L_0x018d
            java.lang.String r4 = "tunneled-playback"
            r5 = 1
            r3.setFeatureEnabled(r4, r5)
            java.lang.String r4 = "audio-session-id"
            r3.setInteger(r4, r6)
        L_0x018d:
            android.view.Surface r4 = r0.f29383fa
            if (r4 != 0) goto L_0x01ae
            boolean r4 = r1.f29083d
            boolean r4 = r0.m31177b(r4)
            com.google.android.gms.internal.ads.zzsk.m31082b(r4)
            android.view.Surface r4 = r0.f29384ga
            if (r4 != 0) goto L_0x01aa
            android.content.Context r4 = r0.f29374W
            boolean r1 = r1.f29083d
            com.google.android.gms.internal.ads.zztd r1 = com.google.android.gms.internal.ads.zztd.m31163a(r4, r1)
            r0.f29384ga = r1
        L_0x01aa:
            android.view.Surface r1 = r0.f29384ga
            r0.f29383fa = r1
        L_0x01ae:
            android.view.Surface r1 = r0.f29383fa
            r4 = 0
            r5 = 0
            r2.configure(r3, r1, r4, r5)
            int r1 = com.google.android.gms.internal.ads.zzsy.f29345a
            r3 = 23
            if (r1 < r3) goto L_0x01c6
            boolean r1 = r0.f29401xa
            if (r1 == 0) goto L_0x01c6
            com.google.android.gms.internal.ads.bt r1 = new com.google.android.gms.internal.ads.bt
            r1.<init>(r0, r2)
            r0.f29403za = r1
        L_0x01c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzth.mo32002a(com.google.android.gms.internal.ads.zzpd, android.media.MediaCodec, com.google.android.gms.internal.ads.zzlh, android.media.MediaCrypto):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public final void mo32083u() {
        try {
            super.mo32083u();
        } finally {
            Surface surface = this.f29384ga;
            if (surface != null) {
                if (this.f29383fa == surface) {
                    this.f29383fa = null;
                }
                this.f29384ga.release();
                this.f29384ga = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo32003a(String str, long j, long j2) {
        this.f29376Y.mo32241a(str, j, j2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo32005b(zzlh zzlh) throws zzku {
        super.mo32005b(zzlh);
        this.f29376Y.mo32239a(zzlh);
        float f = zzlh.f28792n;
        if (f == -1.0f) {
            f = 1.0f;
        }
        this.f29392oa = f;
        this.f29391na = m31180d(zzlh);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo32079a(zznd zznd) {
        if (zzsy.f29345a < 23 && this.f29401xa) {
            mo32232y();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo32001a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int i2;
        String str = "crop-right";
        String str2 = "crop-top";
        String str3 = "crop-bottom";
        String str4 = "crop-left";
        boolean z = mediaFormat.containsKey(str) && mediaFormat.containsKey(str4) && mediaFormat.containsKey(str3) && mediaFormat.containsKey(str2);
        if (z) {
            i = (mediaFormat.getInteger(str) - mediaFormat.getInteger(str4)) + 1;
        } else {
            i = mediaFormat.getInteger("width");
        }
        this.f29393pa = i;
        if (z) {
            i2 = (mediaFormat.getInteger(str3) - mediaFormat.getInteger(str2)) + 1;
        } else {
            i2 = mediaFormat.getInteger("height");
        }
        this.f29394qa = i2;
        this.f29396sa = this.f29392oa;
        if (zzsy.f29345a >= 21) {
            int i3 = this.f29391na;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.f29393pa;
                this.f29393pa = this.f29394qa;
                this.f29394qa = i4;
                this.f29396sa = 1.0f / this.f29396sa;
            }
        } else {
            this.f29395ra = this.f29391na;
        }
        mediaCodec.setVideoScalingMode(this.f29385ha);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo32080a(MediaCodec mediaCodec, boolean z, zzlh zzlh, zzlh zzlh2) {
        if (m31175a(z, zzlh, zzlh2)) {
            int i = zzlh2.f28788j;
            zztj zztj = this.f29382ea;
            if (i <= zztj.f29404a && zzlh2.f28789k <= zztj.f29405b && zzlh2.f28785g <= zztj.f29406c) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo32004a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        MediaCodec mediaCodec2 = mediaCodec;
        int i3 = i;
        long j4 = j3;
        while (true) {
            int i4 = this.f29373Ba;
            if (i4 == 0) {
                break;
            }
            long[] jArr = this.f29380ca;
            if (j4 < jArr[0]) {
                break;
            }
            this.f29372Aa = jArr[0];
            this.f29373Ba = i4 - 1;
            System.arraycopy(jArr, 1, jArr, 0, this.f29373Ba);
        }
        long j5 = j4 - this.f29372Aa;
        if (z) {
            m31173a(mediaCodec2, i3, j5);
            return true;
        }
        long j6 = j4 - j;
        if (this.f29383fa == this.f29384ga) {
            if (!m31179c(j6)) {
                return false;
            }
            m31173a(mediaCodec2, i3, j5);
            return true;
        } else if (!this.f29386ia) {
            if (zzsy.f29345a >= 21) {
                m31174a(mediaCodec, i, j5, System.nanoTime());
            } else {
                m31176b(mediaCodec2, i3, j5);
            }
            return true;
        } else if (getState() != 2) {
            return false;
        } else {
            long elapsedRealtime = j6 - ((SystemClock.elapsedRealtime() * 1000) - j2);
            long nanoTime = System.nanoTime();
            long a = this.f29375X.mo32233a(j4, (elapsedRealtime * 1000) + nanoTime);
            long j7 = (a - nanoTime) / 1000;
            if (m31179c(j7)) {
                zzsx.m31142a("dropVideoBuffer");
                mediaCodec2.releaseOutputBuffer(i3, false);
                zzsx.m31141a();
                zznc zznc = this.f29107U;
                zznc.f28948f++;
                this.f29389la++;
                this.f29390ma++;
                zznc.f28949g = Math.max(this.f29390ma, zznc.f28949g);
                if (this.f29389la == this.f29378aa) {
                    m31171F();
                }
                return true;
            }
            if (zzsy.f29345a >= 21) {
                if (j7 < 50000) {
                    m31174a(mediaCodec, i, j5, a);
                    return true;
                }
            } else if (j7 < 30000) {
                if (j7 > 11000) {
                    try {
                        Thread.sleep((j7 - 10000) / 1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                m31176b(mediaCodec2, i3, j5);
                return true;
            }
            return false;
        }
    }

    /* renamed from: a */
    private final void m31173a(MediaCodec mediaCodec, int i, long j) {
        zzsx.m31142a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzsx.m31141a();
        this.f29107U.f28947e++;
    }

    /* renamed from: b */
    private final void m31176b(MediaCodec mediaCodec, int i, long j) {
        m31166A();
        zzsx.m31142a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzsx.m31141a();
        this.f29107U.f28946d++;
        this.f29390ma = 0;
        mo32232y();
    }

    @TargetApi(21)
    /* renamed from: a */
    private final void m31174a(MediaCodec mediaCodec, int i, long j, long j2) {
        m31166A();
        zzsx.m31142a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzsx.m31141a();
        this.f29107U.f28946d++;
        this.f29390ma = 0;
        mo32232y();
    }

    /* renamed from: b */
    private final boolean m31177b(boolean z) {
        return zzsy.f29345a >= 23 && !this.f29401xa && (!z || zztd.m31164a(this.f29374W));
    }

    /* renamed from: B */
    private final void m31167B() {
        this.f29387ja = this.f29377Z > 0 ? SystemClock.elapsedRealtime() + this.f29377Z : -9223372036854775807L;
    }

    /* renamed from: C */
    private final void m31168C() {
        this.f29386ia = false;
        if (zzsy.f29345a >= 23 && this.f29401xa) {
            MediaCodec w = mo32084w();
            if (w != null) {
                this.f29403za = new C9350bt(this, w);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: y */
    public final void mo32232y() {
        if (!this.f29386ia) {
            this.f29386ia = true;
            this.f29376Y.mo32238a(this.f29383fa);
        }
    }

    /* renamed from: D */
    private final void m31169D() {
        this.f29397ta = -1;
        this.f29398ua = -1;
        this.f29400wa = -1.0f;
        this.f29399va = -1;
    }

    /* renamed from: A */
    private final void m31166A() {
        if (this.f29397ta != this.f29393pa || this.f29398ua != this.f29394qa || this.f29399va != this.f29395ra || this.f29400wa != this.f29396sa) {
            this.f29376Y.mo32236a(this.f29393pa, this.f29394qa, this.f29395ra, this.f29396sa);
            this.f29397ta = this.f29393pa;
            this.f29398ua = this.f29394qa;
            this.f29399va = this.f29395ra;
            this.f29400wa = this.f29396sa;
        }
    }

    /* renamed from: E */
    private final void m31170E() {
        if (this.f29397ta != -1 || this.f29398ua != -1) {
            this.f29376Y.mo32236a(this.f29393pa, this.f29394qa, this.f29395ra, this.f29396sa);
        }
    }

    /* renamed from: F */
    private final void m31171F() {
        if (this.f29389la > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f29376Y.mo32237a(this.f29389la, elapsedRealtime - this.f29388ka);
            this.f29389la = 0;
            this.f29388ka = elapsedRealtime;
        }
    }

    /* renamed from: c */
    private static boolean m31179c(long j) {
        return j < -30000;
    }

    /* renamed from: c */
    private static int m31178c(zzlh zzlh) {
        int i = zzlh.f28785g;
        if (i != -1) {
            return i;
        }
        return m31172a(zzlh.f28784f, zzlh.f28788j, zzlh.f28789k);
    }

    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m31172a(java.lang.String r7, int r8, int r9) {
        /*
            r0 = -1
            if (r8 == r0) goto L_0x008f
            if (r9 != r0) goto L_0x0007
            goto L_0x008f
        L_0x0007:
            int r1 = r7.hashCode()
            r2 = 5
            r3 = 1
            r4 = 3
            r5 = 4
            r6 = 2
            switch(r1) {
                case -1664118616: goto L_0x0046;
                case -1662541442: goto L_0x003c;
                case 1187890754: goto L_0x0032;
                case 1331836730: goto L_0x0028;
                case 1599127256: goto L_0x001e;
                case 1599127257: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0050
        L_0x0014:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0013
            r7 = 5
            goto L_0x0051
        L_0x001e:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0013
            r7 = 3
            goto L_0x0051
        L_0x0028:
            java.lang.String r1 = "video/avc"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0013
            r7 = 2
            goto L_0x0051
        L_0x0032:
            java.lang.String r1 = "video/mp4v-es"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0013
            r7 = 1
            goto L_0x0051
        L_0x003c:
            java.lang.String r1 = "video/hevc"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0013
            r7 = 4
            goto L_0x0051
        L_0x0046:
            java.lang.String r1 = "video/3gpp"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0013
            r7 = 0
            goto L_0x0051
        L_0x0050:
            r7 = -1
        L_0x0051:
            if (r7 == 0) goto L_0x0085
            if (r7 == r3) goto L_0x0085
            if (r7 == r6) goto L_0x0067
            if (r7 == r4) goto L_0x0062
            if (r7 == r5) goto L_0x005e
            if (r7 == r2) goto L_0x005e
            return r0
        L_0x005e:
            int r8 = r8 * r9
            goto L_0x0089
        L_0x0062:
            int r8 = r8 * r9
            r5 = 2
            goto L_0x0089
        L_0x0067:
            java.lang.String r7 = com.google.android.gms.internal.ads.zzsy.f29348d
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x0072
            return r0
        L_0x0072:
            r7 = 16
            int r8 = com.google.android.gms.internal.ads.zzsy.m31145a(r8, r7)
            int r7 = com.google.android.gms.internal.ads.zzsy.m31145a(r9, r7)
            int r8 = r8 * r7
            int r7 = r8 << 4
            int r8 = r7 << 4
            r5 = 2
            goto L_0x0089
        L_0x0085:
            int r8 = r8 * r9
            r5 = 2
        L_0x0089:
            int r8 = r8 * 3
            int r5 = r5 * 2
            int r8 = r8 / r5
            return r8
        L_0x008f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzth.m31172a(java.lang.String, int, int):int");
    }

    /* renamed from: a */
    private static boolean m31175a(boolean z, zzlh zzlh, zzlh zzlh2) {
        return zzlh.f28784f.equals(zzlh2.f28784f) && m31180d(zzlh) == m31180d(zzlh2) && (z || (zzlh.f28788j == zzlh2.f28788j && zzlh.f28789k == zzlh2.f28789k));
    }

    /* renamed from: d */
    private static int m31180d(zzlh zzlh) {
        int i = zzlh.f28791m;
        if (i == -1) {
            return 0;
        }
        return i;
    }
}
