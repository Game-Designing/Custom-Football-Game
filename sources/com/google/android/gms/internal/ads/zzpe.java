package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class zzpe extends zzks {

    /* renamed from: i */
    private static final byte[] f29086i = zzsy.m31160e("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");

    /* renamed from: A */
    private boolean f29087A;

    /* renamed from: B */
    private boolean f29088B;

    /* renamed from: C */
    private boolean f29089C;

    /* renamed from: D */
    private boolean f29090D;

    /* renamed from: E */
    private boolean f29091E;

    /* renamed from: F */
    private ByteBuffer[] f29092F;

    /* renamed from: G */
    private ByteBuffer[] f29093G;

    /* renamed from: H */
    private long f29094H;

    /* renamed from: I */
    private int f29095I;

    /* renamed from: J */
    private int f29096J;

    /* renamed from: K */
    private boolean f29097K;

    /* renamed from: L */
    private boolean f29098L;

    /* renamed from: M */
    private int f29099M;

    /* renamed from: N */
    private int f29100N;

    /* renamed from: O */
    private boolean f29101O;

    /* renamed from: P */
    private boolean f29102P;

    /* renamed from: Q */
    private boolean f29103Q;

    /* renamed from: R */
    private boolean f29104R;

    /* renamed from: S */
    private boolean f29105S;

    /* renamed from: T */
    private boolean f29106T;

    /* renamed from: U */
    protected zznc f29107U;

    /* renamed from: j */
    private final zzpg f29108j;

    /* renamed from: k */
    private final zznj<Object> f29109k;

    /* renamed from: l */
    private final boolean f29110l;

    /* renamed from: m */
    private final zznd f29111m;

    /* renamed from: n */
    private final zznd f29112n;

    /* renamed from: o */
    private final zzlj f29113o;

    /* renamed from: p */
    private final List<Long> f29114p;

    /* renamed from: q */
    private final BufferInfo f29115q;

    /* renamed from: r */
    private zzlh f29116r;

    /* renamed from: s */
    private zznh<Object> f29117s;

    /* renamed from: t */
    private zznh<Object> f29118t;

    /* renamed from: u */
    private MediaCodec f29119u;

    /* renamed from: v */
    private zzpd f29120v;

    /* renamed from: w */
    private boolean f29121w;

    /* renamed from: x */
    private boolean f29122x;

    /* renamed from: y */
    private boolean f29123y;

    /* renamed from: z */
    private boolean f29124z;

    public zzpe(int i, zzpg zzpg, zznj<Object> zznj, boolean z) {
        super(i);
        zzsk.m31082b(zzsy.f29345a >= 16);
        zzsk.m31078a(zzpg);
        this.f29108j = zzpg;
        this.f29109k = zznj;
        this.f29110l = z;
        this.f29111m = new zznd(0);
        this.f29112n = new zznd(0);
        this.f29113o = new zzlj();
        this.f29114p = new ArrayList();
        this.f29115q = new BufferInfo();
        this.f29099M = 0;
        this.f29100N = 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo31997a(zzpg zzpg, zzlh zzlh) throws zzpk;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo32002a(zzpd zzpd, MediaCodec mediaCodec, zzlh zzlh, MediaCrypto mediaCrypto) throws zzpk;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo32004a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzku;

    /* renamed from: m */
    public final int mo31923m() {
        return 4;
    }

    /* renamed from: a */
    public final int mo31955a(zzlh zzlh) throws zzku {
        try {
            return mo31997a(this.f29108j, zzlh);
        } catch (zzpk e) {
            throw zzku.m30599a(e, mo31924n());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzpd mo32000a(zzpg zzpg, zzlh zzlh, boolean z) throws zzpk {
        return zzpg.mo29287a(zzlh.f28784f, z);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0113, code lost:
        if ("tilapia".equals(com.google.android.gms.internal.ads.zzsy.f29346b) != false) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0161, code lost:
        if ("OMX.amlogic.avc.decoder.awesome.secure".equals(r0) != false) goto L_0x0163;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01a1 A[Catch:{ Exception -> 0x0217 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01a6 A[Catch:{ Exception -> 0x0217 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x016d  */
    /* renamed from: t */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo32082t() throws com.google.android.gms.internal.ads.zzku {
        /*
            r11 = this;
            android.media.MediaCodec r0 = r11.f29119u
            if (r0 != 0) goto L_0x0223
            com.google.android.gms.internal.ads.zzlh r0 = r11.f29116r
            if (r0 != 0) goto L_0x000a
            goto L_0x0223
        L_0x000a:
            com.google.android.gms.internal.ads.zznh<java.lang.Object> r1 = r11.f29118t
            r11.f29117s = r1
            java.lang.String r1 = r0.f28784f
            com.google.android.gms.internal.ads.zznh<java.lang.Object> r1 = r11.f29117s
            if (r1 == 0) goto L_0x003b
            int r0 = r1.getState()
            if (r0 == 0) goto L_0x002c
            r1 = 3
            if (r0 == r1) goto L_0x0021
            r1 = 4
            if (r0 == r1) goto L_0x0021
            return
        L_0x0021:
            com.google.android.gms.internal.ads.zznh<java.lang.Object> r0 = r11.f29117s
            r0.mo32037b()
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x002c:
            com.google.android.gms.internal.ads.zznh<java.lang.Object> r0 = r11.f29117s
            com.google.android.gms.internal.ads.zzni r0 = r0.mo32036a()
            int r1 = r11.mo31924n()
            com.google.android.gms.internal.ads.zzku r0 = com.google.android.gms.internal.ads.zzku.m30599a(r0, r1)
            throw r0
        L_0x003b:
            com.google.android.gms.internal.ads.zzpd r1 = r11.f29120v
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x006c
            com.google.android.gms.internal.ads.zzpg r1 = r11.f29108j     // Catch:{ zzpk -> 0x005d }
            com.google.android.gms.internal.ads.zzpd r0 = r11.mo32000a(r1, r0, r3)     // Catch:{ zzpk -> 0x005d }
            r11.f29120v = r0     // Catch:{ zzpk -> 0x005d }
            com.google.android.gms.internal.ads.zzpd r0 = r11.f29120v
            if (r0 == 0) goto L_0x004f
            goto L_0x006c
        L_0x004f:
            com.google.android.gms.internal.ads.zzpf r0 = new com.google.android.gms.internal.ads.zzpf
            com.google.android.gms.internal.ads.zzlh r1 = r11.f29116r
            r4 = -49999(0xffffffffffff3cb1, float:NaN)
            r0.<init>(r1, r2, r3, r4)
            r11.m30879a(r0)
            throw r2
        L_0x005d:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzpf r1 = new com.google.android.gms.internal.ads.zzpf
            com.google.android.gms.internal.ads.zzlh r4 = r11.f29116r
            r5 = -49998(0xffffffffffff3cb2, float:NaN)
            r1.<init>(r4, r0, r3, r5)
            r11.m30879a(r1)
            throw r2
        L_0x006c:
            com.google.android.gms.internal.ads.zzpd r0 = r11.f29120v
            boolean r0 = r11.mo32081a(r0)
            if (r0 != 0) goto L_0x0075
            return
        L_0x0075:
            com.google.android.gms.internal.ads.zzpd r0 = r11.f29120v
            java.lang.String r0 = r0.f29080a
            com.google.android.gms.internal.ads.zzlh r1 = r11.f29116r
            int r4 = com.google.android.gms.internal.ads.zzsy.f29345a
            r5 = 21
            r10 = 1
            if (r4 >= r5) goto L_0x0094
            java.util.List<byte[]> r1 = r1.f28786h
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0094
            java.lang.String r1 = "OMX.MTK.VIDEO.DECODER.AVC"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0094
            r1 = 1
            goto L_0x0095
        L_0x0094:
            r1 = 0
        L_0x0095:
            r11.f29121w = r1
            int r1 = com.google.android.gms.internal.ads.zzsy.f29345a
            r4 = 19
            r6 = 18
            if (r1 < r6) goto L_0x00d3
            if (r1 != r6) goto L_0x00b2
            java.lang.String r1 = "OMX.SEC.avc.dec"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x00d3
            java.lang.String r1 = "OMX.SEC.avc.dec.secure"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x00d3
        L_0x00b2:
            int r1 = com.google.android.gms.internal.ads.zzsy.f29345a
            if (r1 != r4) goto L_0x00d1
            java.lang.String r1 = com.google.android.gms.internal.ads.zzsy.f29348d
            java.lang.String r7 = "SM-G800"
            boolean r1 = r1.startsWith(r7)
            if (r1 == 0) goto L_0x00d1
            java.lang.String r1 = "OMX.Exynos.avc.dec"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x00d3
            java.lang.String r1 = "OMX.Exynos.avc.dec.secure"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00d1
            goto L_0x00d3
        L_0x00d1:
            r1 = 0
            goto L_0x00d4
        L_0x00d3:
            r1 = 1
        L_0x00d4:
            r11.f29122x = r1
            int r1 = com.google.android.gms.internal.ads.zzsy.f29345a
            r7 = 24
            if (r1 >= r7) goto L_0x0117
            java.lang.String r1 = "OMX.Nvidia.h264.decode"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x00ed
            java.lang.String r1 = "OMX.Nvidia.h264.decode.secure"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0117
        L_0x00ed:
            java.lang.String r1 = com.google.android.gms.internal.ads.zzsy.f29346b
            java.lang.String r7 = "flounder"
            boolean r1 = r7.equals(r1)
            if (r1 != 0) goto L_0x0115
            java.lang.String r1 = com.google.android.gms.internal.ads.zzsy.f29346b
            java.lang.String r7 = "flounder_lte"
            boolean r1 = r7.equals(r1)
            if (r1 != 0) goto L_0x0115
            java.lang.String r1 = com.google.android.gms.internal.ads.zzsy.f29346b
            java.lang.String r7 = "grouper"
            boolean r1 = r7.equals(r1)
            if (r1 != 0) goto L_0x0115
            java.lang.String r1 = com.google.android.gms.internal.ads.zzsy.f29346b
            java.lang.String r7 = "tilapia"
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L_0x0117
        L_0x0115:
            r1 = 1
            goto L_0x0118
        L_0x0117:
            r1 = 0
        L_0x0118:
            r11.f29123y = r1
            int r1 = com.google.android.gms.internal.ads.zzsy.f29345a
            r7 = 17
            if (r1 > r7) goto L_0x0133
            java.lang.String r1 = "OMX.rk.video_decoder.avc"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0131
            java.lang.String r1 = "OMX.allwinner.video.decoder.avc"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0133
        L_0x0131:
            r1 = 1
            goto L_0x0134
        L_0x0133:
            r1 = 0
        L_0x0134:
            r11.f29124z = r1
            int r1 = com.google.android.gms.internal.ads.zzsy.f29345a
            r7 = 23
            if (r1 > r7) goto L_0x0145
            java.lang.String r1 = "OMX.google.vorbis.decoder"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0163
        L_0x0145:
            int r1 = com.google.android.gms.internal.ads.zzsy.f29345a
            if (r1 > r4) goto L_0x0165
            java.lang.String r1 = com.google.android.gms.internal.ads.zzsy.f29346b
            java.lang.String r4 = "hb2000"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0165
            java.lang.String r1 = "OMX.amlogic.avc.decoder.awesome"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0163
            java.lang.String r1 = "OMX.amlogic.avc.decoder.awesome.secure"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0165
        L_0x0163:
            r1 = 1
            goto L_0x0166
        L_0x0165:
            r1 = 0
        L_0x0166:
            r11.f29087A = r1
            int r1 = com.google.android.gms.internal.ads.zzsy.f29345a
            if (r1 != r5) goto L_0x0177
            java.lang.String r1 = "OMX.google.aac.decoder"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0177
            r1 = 1
            goto L_0x0178
        L_0x0177:
            r1 = 0
        L_0x0178:
            r11.f29088B = r1
            com.google.android.gms.internal.ads.zzlh r1 = r11.f29116r
            int r4 = com.google.android.gms.internal.ads.zzsy.f29345a
            if (r4 > r6) goto L_0x018e
            int r1 = r1.f28796r
            if (r1 != r10) goto L_0x018e
            java.lang.String r1 = "OMX.MTK.AUDIO.DECODER.MP3"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x018e
            r1 = 1
            goto L_0x018f
        L_0x018e:
            r1 = 0
        L_0x018f:
            r11.f29089C = r1
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0217 }
            java.lang.String r1 = "createCodec:"
            java.lang.String r6 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0217 }
            int r7 = r6.length()     // Catch:{ Exception -> 0x0217 }
            if (r7 == 0) goto L_0x01a6
            java.lang.String r1 = r1.concat(r6)     // Catch:{ Exception -> 0x0217 }
            goto L_0x01ac
        L_0x01a6:
            java.lang.String r6 = new java.lang.String     // Catch:{ Exception -> 0x0217 }
            r6.<init>(r1)     // Catch:{ Exception -> 0x0217 }
            r1 = r6
        L_0x01ac:
            com.google.android.gms.internal.ads.zzsx.m31142a(r1)     // Catch:{ Exception -> 0x0217 }
            android.media.MediaCodec r1 = android.media.MediaCodec.createByCodecName(r0)     // Catch:{ Exception -> 0x0217 }
            r11.f29119u = r1     // Catch:{ Exception -> 0x0217 }
            com.google.android.gms.internal.ads.zzsx.m31141a()     // Catch:{ Exception -> 0x0217 }
            java.lang.String r1 = "configureCodec"
            com.google.android.gms.internal.ads.zzsx.m31142a(r1)     // Catch:{ Exception -> 0x0217 }
            com.google.android.gms.internal.ads.zzpd r1 = r11.f29120v     // Catch:{ Exception -> 0x0217 }
            android.media.MediaCodec r6 = r11.f29119u     // Catch:{ Exception -> 0x0217 }
            com.google.android.gms.internal.ads.zzlh r7 = r11.f29116r     // Catch:{ Exception -> 0x0217 }
            r11.mo32002a(r1, r6, r7, r2)     // Catch:{ Exception -> 0x0217 }
            com.google.android.gms.internal.ads.zzsx.m31141a()     // Catch:{ Exception -> 0x0217 }
            java.lang.String r1 = "startCodec"
            com.google.android.gms.internal.ads.zzsx.m31142a(r1)     // Catch:{ Exception -> 0x0217 }
            android.media.MediaCodec r1 = r11.f29119u     // Catch:{ Exception -> 0x0217 }
            r1.start()     // Catch:{ Exception -> 0x0217 }
            com.google.android.gms.internal.ads.zzsx.m31141a()     // Catch:{ Exception -> 0x0217 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0217 }
            long r8 = r6 - r4
            r4 = r11
            r5 = r0
            r4.mo32003a(r5, r6, r8)     // Catch:{ Exception -> 0x0217 }
            android.media.MediaCodec r1 = r11.f29119u     // Catch:{ Exception -> 0x0217 }
            java.nio.ByteBuffer[] r1 = r1.getInputBuffers()     // Catch:{ Exception -> 0x0217 }
            r11.f29092F = r1     // Catch:{ Exception -> 0x0217 }
            android.media.MediaCodec r1 = r11.f29119u     // Catch:{ Exception -> 0x0217 }
            java.nio.ByteBuffer[] r1 = r1.getOutputBuffers()     // Catch:{ Exception -> 0x0217 }
            r11.f29093G = r1     // Catch:{ Exception -> 0x0217 }
            int r0 = r11.getState()
            r1 = 2
            if (r0 != r1) goto L_0x0201
            long r0 = android.os.SystemClock.elapsedRealtime()
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 + r2
            goto L_0x0206
        L_0x0201:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0206:
            r11.f29094H = r0
            r0 = -1
            r11.f29095I = r0
            r11.f29096J = r0
            r11.f29106T = r10
            com.google.android.gms.internal.ads.zznc r0 = r11.f29107U
            int r1 = r0.f28943a
            int r1 = r1 + r10
            r0.f28943a = r1
            return
        L_0x0217:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzpf r4 = new com.google.android.gms.internal.ads.zzpf
            com.google.android.gms.internal.ads.zzlh r5 = r11.f29116r
            r4.<init>(r5, r1, r3, r0)
            r11.m30879a(r4)
            throw r2
        L_0x0223:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpe.mo32082t():void");
    }

    /* renamed from: a */
    private final void m30879a(zzpf zzpf) throws zzku {
        throw zzku.m30599a(zzpf, mo31924n());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo32081a(zzpd zzpd) {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public final MediaCodec mo32084w() {
        return this.f29119u;
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public final zzpd mo32085x() {
        return this.f29120v;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo31909a(boolean z) throws zzku {
        this.f29107U = new zznc();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo31907a(long j, boolean z) throws zzku {
        this.f29103Q = false;
        this.f29104R = false;
        if (this.f29119u != null) {
            this.f29094H = -9223372036854775807L;
            this.f29095I = -1;
            this.f29096J = -1;
            this.f29106T = true;
            this.f29105S = false;
            this.f29097K = false;
            this.f29114p.clear();
            this.f29090D = false;
            this.f29091E = false;
            if (this.f29122x || (this.f29087A && this.f29102P)) {
                mo32083u();
                mo32082t();
            } else if (this.f29100N != 0) {
                mo32083u();
                mo32082t();
            } else {
                this.f29119u.flush();
                this.f29101O = false;
            }
            if (this.f29098L && this.f29116r != null) {
                this.f29099M = 1;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public void mo31927q() {
        this.f29116r = null;
        try {
            mo32083u();
            try {
                if (this.f29117s != null) {
                    this.f29109k.mo32040a(this.f29117s);
                }
                try {
                    if (!(this.f29118t == null || this.f29118t == this.f29117s)) {
                        this.f29109k.mo32040a(this.f29118t);
                    }
                } finally {
                    this.f29117s = null;
                    this.f29118t = null;
                }
            } catch (Throwable th) {
                if (!(this.f29118t == null || this.f29118t == this.f29117s)) {
                    this.f29109k.mo32040a(this.f29118t);
                }
                throw th;
            } finally {
                this.f29117s = null;
                this.f29118t = null;
            }
        } catch (Throwable th2) {
            try {
                if (!(this.f29118t == null || this.f29118t == this.f29117s)) {
                    this.f29109k.mo32040a(this.f29118t);
                }
                throw th2;
            } finally {
                this.f29117s = null;
                this.f29118t = null;
            }
        } finally {
            this.f29117s = null;
            this.f29118t = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public void mo32083u() {
        this.f29094H = -9223372036854775807L;
        this.f29095I = -1;
        this.f29096J = -1;
        this.f29105S = false;
        this.f29097K = false;
        this.f29114p.clear();
        this.f29092F = null;
        this.f29093G = null;
        this.f29120v = null;
        this.f29098L = false;
        this.f29101O = false;
        this.f29121w = false;
        this.f29122x = false;
        this.f29123y = false;
        this.f29124z = false;
        this.f29087A = false;
        this.f29089C = false;
        this.f29090D = false;
        this.f29091E = false;
        this.f29102P = false;
        this.f29099M = 0;
        this.f29100N = 0;
        this.f29111m.f28951c = null;
        MediaCodec mediaCodec = this.f29119u;
        if (mediaCodec != null) {
            this.f29107U.f28944b++;
            try {
                mediaCodec.stop();
                try {
                    this.f29119u.release();
                    this.f29119u = null;
                    zznh<Object> zznh = this.f29117s;
                    if (zznh != null && this.f29118t != zznh) {
                        try {
                            this.f29109k.mo32040a(zznh);
                        } finally {
                            this.f29117s = null;
                        }
                    }
                } catch (Throwable th) {
                    this.f29119u = null;
                    zznh<Object> zznh2 = this.f29117s;
                    if (!(zznh2 == null || this.f29118t == zznh2)) {
                        this.f29109k.mo32040a(zznh2);
                    }
                    throw th;
                } finally {
                    this.f29117s = null;
                }
            } catch (Throwable th2) {
                this.f29119u = null;
                zznh<Object> zznh3 = this.f29117s;
                if (!(zznh3 == null || this.f29118t == zznh3)) {
                    try {
                        this.f29109k.mo32040a(zznh3);
                    } finally {
                        this.f29117s = null;
                    }
                }
                throw th2;
            } finally {
                this.f29117s = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public void mo31925o() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public void mo31926p() {
    }

    /* renamed from: a */
    public final void mo31952a(long j, long j2) throws zzku {
        if (this.f29104R) {
            mo32007v();
            return;
        }
        if (this.f29116r == null) {
            this.f29112n.mo32012a();
            int a = mo31904a(this.f29113o, this.f29112n, true);
            if (a == -5) {
                mo32005b(this.f29113o.f28805a);
            } else if (a == -4) {
                zzsk.m31082b(this.f29112n.mo32016c());
                this.f29103Q = true;
                m30882z();
                return;
            } else {
                return;
            }
        }
        mo32082t();
        if (this.f29119u != null) {
            zzsx.m31142a("drainAndFeed");
            do {
            } while (m30880b(j, j2));
            do {
            } while (mo32232y());
            zzsx.m31141a();
        } else {
            mo31912b(j);
            this.f29112n.mo32012a();
            int a2 = mo31904a(this.f29113o, this.f29112n, false);
            if (a2 == -5) {
                mo32005b(this.f29113o.f28805a);
            } else if (a2 == -4) {
                zzsk.m31082b(this.f29112n.mo32016c());
                this.f29103Q = true;
                m30882z();
            }
        }
        this.f29107U.mo32023a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x014e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x014f  */
    /* renamed from: y */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean mo32232y() throws com.google.android.gms.internal.ads.zzku {
        /*
            r14 = this;
            android.media.MediaCodec r0 = r14.f29119u
            r1 = 0
            if (r0 == 0) goto L_0x01dc
            int r2 = r14.f29100N
            r3 = 2
            if (r2 == r3) goto L_0x01dc
            boolean r2 = r14.f29103Q
            if (r2 == 0) goto L_0x0010
            goto L_0x01dc
        L_0x0010:
            int r2 = r14.f29095I
            if (r2 >= 0) goto L_0x002c
            r4 = 0
            int r0 = r0.dequeueInputBuffer(r4)
            r14.f29095I = r0
            int r0 = r14.f29095I
            if (r0 >= 0) goto L_0x0021
            return r1
        L_0x0021:
            com.google.android.gms.internal.ads.zznd r2 = r14.f29111m
            java.nio.ByteBuffer[] r4 = r14.f29092F
            r0 = r4[r0]
            r2.f28951c = r0
            r2.mo32012a()
        L_0x002c:
            int r0 = r14.f29100N
            r2 = -1
            r4 = 1
            if (r0 != r4) goto L_0x0049
            boolean r0 = r14.f29124z
            if (r0 != 0) goto L_0x0046
            r14.f29102P = r4
            android.media.MediaCodec r5 = r14.f29119u
            int r6 = r14.f29095I
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 4
            r5.queueInputBuffer(r6, r7, r8, r9, r11)
            r14.f29095I = r2
        L_0x0046:
            r14.f29100N = r3
            return r1
        L_0x0049:
            boolean r0 = r14.f29090D
            if (r0 == 0) goto L_0x006b
            r14.f29090D = r1
            com.google.android.gms.internal.ads.zznd r0 = r14.f29111m
            java.nio.ByteBuffer r0 = r0.f28951c
            byte[] r1 = f29086i
            r0.put(r1)
            android.media.MediaCodec r5 = r14.f29119u
            int r6 = r14.f29095I
            r7 = 0
            byte[] r0 = f29086i
            int r8 = r0.length
            r9 = 0
            r11 = 0
            r5.queueInputBuffer(r6, r7, r8, r9, r11)
            r14.f29095I = r2
            r14.f29101O = r4
            return r4
        L_0x006b:
            boolean r0 = r14.f29105S
            if (r0 == 0) goto L_0x0073
            r0 = -4
            r5 = 0
            goto L_0x00ab
        L_0x0073:
            int r0 = r14.f29099M
            if (r0 != r4) goto L_0x0098
            r0 = 0
        L_0x0078:
            com.google.android.gms.internal.ads.zzlh r5 = r14.f29116r
            java.util.List<byte[]> r5 = r5.f28786h
            int r5 = r5.size()
            if (r0 >= r5) goto L_0x0096
            com.google.android.gms.internal.ads.zzlh r5 = r14.f29116r
            java.util.List<byte[]> r5 = r5.f28786h
            java.lang.Object r5 = r5.get(r0)
            byte[] r5 = (byte[]) r5
            com.google.android.gms.internal.ads.zznd r6 = r14.f29111m
            java.nio.ByteBuffer r6 = r6.f28951c
            r6.put(r5)
            int r0 = r0 + 1
            goto L_0x0078
        L_0x0096:
            r14.f29099M = r3
        L_0x0098:
            com.google.android.gms.internal.ads.zznd r0 = r14.f29111m
            java.nio.ByteBuffer r0 = r0.f28951c
            int r0 = r0.position()
            com.google.android.gms.internal.ads.zzlj r5 = r14.f29113o
            com.google.android.gms.internal.ads.zznd r6 = r14.f29111m
            int r5 = r14.mo31904a(r5, r6, r1)
            r13 = r5
            r5 = r0
            r0 = r13
        L_0x00ab:
            r6 = -3
            if (r0 != r6) goto L_0x00af
            return r1
        L_0x00af:
            r6 = -5
            if (r0 != r6) goto L_0x00c5
            int r0 = r14.f29099M
            if (r0 != r3) goto L_0x00bd
            com.google.android.gms.internal.ads.zznd r0 = r14.f29111m
            r0.mo32012a()
            r14.f29099M = r4
        L_0x00bd:
            com.google.android.gms.internal.ads.zzlj r0 = r14.f29113o
            com.google.android.gms.internal.ads.zzlh r0 = r0.f28805a
            r14.mo32005b(r0)
            return r4
        L_0x00c5:
            com.google.android.gms.internal.ads.zznd r0 = r14.f29111m
            boolean r0 = r0.mo32016c()
            if (r0 == 0) goto L_0x0102
            int r0 = r14.f29099M
            if (r0 != r3) goto L_0x00d8
            com.google.android.gms.internal.ads.zznd r0 = r14.f29111m
            r0.mo32012a()
            r14.f29099M = r4
        L_0x00d8:
            r14.f29103Q = r4
            boolean r0 = r14.f29101O
            if (r0 != 0) goto L_0x00e2
            r14.m30882z()
            return r1
        L_0x00e2:
            boolean r0 = r14.f29124z     // Catch:{ CryptoException -> 0x00f8 }
            if (r0 != 0) goto L_0x00f6
            r14.f29102P = r4     // Catch:{ CryptoException -> 0x00f8 }
            android.media.MediaCodec r5 = r14.f29119u     // Catch:{ CryptoException -> 0x00f8 }
            int r6 = r14.f29095I     // Catch:{ CryptoException -> 0x00f8 }
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 4
            r5.queueInputBuffer(r6, r7, r8, r9, r11)     // Catch:{ CryptoException -> 0x00f8 }
            r14.f29095I = r2     // Catch:{ CryptoException -> 0x00f8 }
        L_0x00f6:
            return r1
        L_0x00f8:
            r0 = move-exception
            int r1 = r14.mo31924n()
            com.google.android.gms.internal.ads.zzku r0 = com.google.android.gms.internal.ads.zzku.m30599a(r0, r1)
            throw r0
        L_0x0102:
            boolean r0 = r14.f29106T
            if (r0 == 0) goto L_0x011a
            com.google.android.gms.internal.ads.zznd r0 = r14.f29111m
            boolean r0 = r0.mo32018d()
            if (r0 != 0) goto L_0x011a
            com.google.android.gms.internal.ads.zznd r0 = r14.f29111m
            r0.mo32012a()
            int r0 = r14.f29099M
            if (r0 != r3) goto L_0x0119
            r14.f29099M = r4
        L_0x0119:
            return r4
        L_0x011a:
            r14.f29106T = r1
            com.google.android.gms.internal.ads.zznd r0 = r14.f29111m
            boolean r0 = r0.mo32025e()
            com.google.android.gms.internal.ads.zznh<java.lang.Object> r3 = r14.f29117s
            if (r3 == 0) goto L_0x0147
            int r3 = r3.getState()
            if (r3 == 0) goto L_0x0138
            r6 = 4
            if (r3 == r6) goto L_0x0147
            if (r0 != 0) goto L_0x0136
            boolean r3 = r14.f29110l
            if (r3 != 0) goto L_0x0147
        L_0x0136:
            r3 = 1
            goto L_0x0148
        L_0x0138:
            com.google.android.gms.internal.ads.zznh<java.lang.Object> r0 = r14.f29117s
            com.google.android.gms.internal.ads.zzni r0 = r0.mo32036a()
            int r1 = r14.mo31924n()
            com.google.android.gms.internal.ads.zzku r0 = com.google.android.gms.internal.ads.zzku.m30599a(r0, r1)
            throw r0
        L_0x0147:
            r3 = 0
        L_0x0148:
            r14.f29105S = r3
            boolean r3 = r14.f29105S
            if (r3 == 0) goto L_0x014f
            return r1
        L_0x014f:
            boolean r3 = r14.f29121w
            if (r3 == 0) goto L_0x0169
            if (r0 != 0) goto L_0x0169
            com.google.android.gms.internal.ads.zznd r3 = r14.f29111m
            java.nio.ByteBuffer r3 = r3.f28951c
            com.google.android.gms.internal.ads.zzsq.m31101a(r3)
            com.google.android.gms.internal.ads.zznd r3 = r14.f29111m
            java.nio.ByteBuffer r3 = r3.f28951c
            int r3 = r3.position()
            if (r3 != 0) goto L_0x0167
            return r4
        L_0x0167:
            r14.f29121w = r1
        L_0x0169:
            com.google.android.gms.internal.ads.zznd r3 = r14.f29111m     // Catch:{ CryptoException -> 0x01d2 }
            long r10 = r3.f28952d     // Catch:{ CryptoException -> 0x01d2 }
            com.google.android.gms.internal.ads.zznd r3 = r14.f29111m     // Catch:{ CryptoException -> 0x01d2 }
            boolean r3 = r3.mo32015b()     // Catch:{ CryptoException -> 0x01d2 }
            if (r3 == 0) goto L_0x017e
            java.util.List<java.lang.Long> r3 = r14.f29114p     // Catch:{ CryptoException -> 0x01d2 }
            java.lang.Long r6 = java.lang.Long.valueOf(r10)     // Catch:{ CryptoException -> 0x01d2 }
            r3.add(r6)     // Catch:{ CryptoException -> 0x01d2 }
        L_0x017e:
            com.google.android.gms.internal.ads.zznd r3 = r14.f29111m     // Catch:{ CryptoException -> 0x01d2 }
            java.nio.ByteBuffer r3 = r3.f28951c     // Catch:{ CryptoException -> 0x01d2 }
            r3.flip()     // Catch:{ CryptoException -> 0x01d2 }
            com.google.android.gms.internal.ads.zznd r3 = r14.f29111m     // Catch:{ CryptoException -> 0x01d2 }
            r14.mo32079a(r3)     // Catch:{ CryptoException -> 0x01d2 }
            if (r0 == 0) goto L_0x01b2
            com.google.android.gms.internal.ads.zznd r0 = r14.f29111m     // Catch:{ CryptoException -> 0x01d2 }
            com.google.android.gms.internal.ads.zzmz r0 = r0.f28950b     // Catch:{ CryptoException -> 0x01d2 }
            android.media.MediaCodec$CryptoInfo r9 = r0.mo32019a()     // Catch:{ CryptoException -> 0x01d2 }
            if (r5 != 0) goto L_0x0197
            goto L_0x01a7
        L_0x0197:
            int[] r0 = r9.numBytesOfClearData     // Catch:{ CryptoException -> 0x01d2 }
            if (r0 != 0) goto L_0x019f
            int[] r0 = new int[r4]     // Catch:{ CryptoException -> 0x01d2 }
            r9.numBytesOfClearData = r0     // Catch:{ CryptoException -> 0x01d2 }
        L_0x019f:
            int[] r0 = r9.numBytesOfClearData     // Catch:{ CryptoException -> 0x01d2 }
            r3 = r0[r1]     // Catch:{ CryptoException -> 0x01d2 }
            int r3 = r3 + r5
            r0[r1] = r3     // Catch:{ CryptoException -> 0x01d2 }
        L_0x01a7:
            android.media.MediaCodec r6 = r14.f29119u     // Catch:{ CryptoException -> 0x01d2 }
            int r7 = r14.f29095I     // Catch:{ CryptoException -> 0x01d2 }
            r8 = 0
            r12 = 0
            r6.queueSecureInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x01d2 }
            goto L_0x01c3
        L_0x01b2:
            android.media.MediaCodec r6 = r14.f29119u     // Catch:{ CryptoException -> 0x01d2 }
            int r7 = r14.f29095I     // Catch:{ CryptoException -> 0x01d2 }
            r8 = 0
            com.google.android.gms.internal.ads.zznd r0 = r14.f29111m     // Catch:{ CryptoException -> 0x01d2 }
            java.nio.ByteBuffer r0 = r0.f28951c     // Catch:{ CryptoException -> 0x01d2 }
            int r9 = r0.limit()     // Catch:{ CryptoException -> 0x01d2 }
            r12 = 0
            r6.queueInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x01d2 }
        L_0x01c3:
            r14.f29095I = r2     // Catch:{ CryptoException -> 0x01d2 }
            r14.f29101O = r4     // Catch:{ CryptoException -> 0x01d2 }
            r14.f29099M = r1     // Catch:{ CryptoException -> 0x01d2 }
            com.google.android.gms.internal.ads.zznc r0 = r14.f29107U     // Catch:{ CryptoException -> 0x01d2 }
            int r1 = r0.f28945c     // Catch:{ CryptoException -> 0x01d2 }
            int r1 = r1 + r4
            r0.f28945c = r1     // Catch:{ CryptoException -> 0x01d2 }
            return r4
        L_0x01d2:
            r0 = move-exception
            int r1 = r14.mo31924n()
            com.google.android.gms.internal.ads.zzku r0 = com.google.android.gms.internal.ads.zzku.m30599a(r0, r1)
            throw r0
        L_0x01dc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpe.mo32232y():boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32003a(String str, long j, long j2) {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0077, code lost:
        if (r5.f28789k == r0.f28789k) goto L_0x007b;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo32005b(com.google.android.gms.internal.ads.zzlh r5) throws com.google.android.gms.internal.ads.zzku {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzlh r0 = r4.f29116r
            r4.f29116r = r5
            com.google.android.gms.internal.ads.zzlh r5 = r4.f29116r
            com.google.android.gms.internal.ads.zzne r5 = r5.f28787i
            r1 = 0
            if (r0 != 0) goto L_0x000d
            r2 = r1
            goto L_0x000f
        L_0x000d:
            com.google.android.gms.internal.ads.zzne r2 = r0.f28787i
        L_0x000f:
            boolean r5 = com.google.android.gms.internal.ads.zzsy.m31153a(r5, r2)
            r2 = 1
            r5 = r5 ^ r2
            if (r5 == 0) goto L_0x004d
            com.google.android.gms.internal.ads.zzlh r5 = r4.f29116r
            com.google.android.gms.internal.ads.zzne r5 = r5.f28787i
            if (r5 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zznj<java.lang.Object> r5 = r4.f29109k
            if (r5 == 0) goto L_0x003b
            android.os.Looper r1 = android.os.Looper.myLooper()
            com.google.android.gms.internal.ads.zzlh r3 = r4.f29116r
            com.google.android.gms.internal.ads.zzne r3 = r3.f28787i
            com.google.android.gms.internal.ads.zznh r5 = r5.mo32039a(r1, r3)
            r4.f29118t = r5
            com.google.android.gms.internal.ads.zznh<java.lang.Object> r5 = r4.f29118t
            com.google.android.gms.internal.ads.zznh<java.lang.Object> r1 = r4.f29117s
            if (r5 != r1) goto L_0x004d
            com.google.android.gms.internal.ads.zznj<java.lang.Object> r1 = r4.f29109k
            r1.mo32040a(r5)
            goto L_0x004d
        L_0x003b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Media requires a DrmSessionManager"
            r5.<init>(r0)
            int r0 = r4.mo31924n()
            com.google.android.gms.internal.ads.zzku r5 = com.google.android.gms.internal.ads.zzku.m30599a(r5, r0)
            throw r5
        L_0x004b:
            r4.f29118t = r1
        L_0x004d:
            com.google.android.gms.internal.ads.zznh<java.lang.Object> r5 = r4.f29118t
            com.google.android.gms.internal.ads.zznh<java.lang.Object> r1 = r4.f29117s
            if (r5 != r1) goto L_0x007e
            android.media.MediaCodec r5 = r4.f29119u
            if (r5 == 0) goto L_0x007e
            com.google.android.gms.internal.ads.zzpd r1 = r4.f29120v
            boolean r1 = r1.f29081b
            com.google.android.gms.internal.ads.zzlh r3 = r4.f29116r
            boolean r5 = r4.mo32080a(r5, r1, r0, r3)
            if (r5 == 0) goto L_0x007e
            r4.f29098L = r2
            r4.f29099M = r2
            boolean r5 = r4.f29123y
            if (r5 == 0) goto L_0x007a
            com.google.android.gms.internal.ads.zzlh r5 = r4.f29116r
            int r1 = r5.f28788j
            int r3 = r0.f28788j
            if (r1 != r3) goto L_0x007a
            int r5 = r5.f28789k
            int r0 = r0.f28789k
            if (r5 != r0) goto L_0x007a
            goto L_0x007b
        L_0x007a:
            r2 = 0
        L_0x007b:
            r4.f29090D = r2
            return
        L_0x007e:
            boolean r5 = r4.f29101O
            if (r5 == 0) goto L_0x0085
            r4.f29100N = r2
            return
        L_0x0085:
            r4.mo32083u()
            r4.mo32082t()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpe.mo32005b(com.google.android.gms.internal.ads.zzlh):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32001a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzku {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32079a(zznd zznd) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo32080a(MediaCodec mediaCodec, boolean z, zzlh zzlh, zzlh zzlh2) {
        return false;
    }

    /* renamed from: b */
    public boolean mo31953b() {
        return this.f29104R;
    }

    public boolean isReady() {
        return this.f29116r != null && !this.f29105S && (mo31929s() || this.f29096J >= 0 || (this.f29094H != -9223372036854775807L && SystemClock.elapsedRealtime() < this.f29094H));
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x011c  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m30880b(long r18, long r20) throws com.google.android.gms.internal.ads.zzku {
        /*
            r17 = this;
            r13 = r17
            int r0 = r13.f29096J
            r14 = -1
            r15 = 1
            r12 = 0
            if (r0 >= 0) goto L_0x00e6
            boolean r0 = r13.f29088B
            r1 = 0
            if (r0 == 0) goto L_0x002b
            boolean r0 = r13.f29102P
            if (r0 == 0) goto L_0x002b
            android.media.MediaCodec r0 = r13.f29119u     // Catch:{ IllegalStateException -> 0x001f }
            android.media.MediaCodec$BufferInfo r3 = r13.f29115q     // Catch:{ IllegalStateException -> 0x001f }
            int r0 = r0.dequeueOutputBuffer(r3, r1)     // Catch:{ IllegalStateException -> 0x001f }
            r13.f29096J = r0     // Catch:{ IllegalStateException -> 0x001f }
            goto L_0x0036
        L_0x001f:
            r0 = move-exception
            r17.m30882z()
            boolean r0 = r13.f29104R
            if (r0 == 0) goto L_0x002a
            r17.mo32083u()
        L_0x002a:
            return r12
        L_0x002b:
            android.media.MediaCodec r0 = r13.f29119u
            android.media.MediaCodec$BufferInfo r3 = r13.f29115q
            int r0 = r0.dequeueOutputBuffer(r3, r1)
            r13.f29096J = r0
        L_0x0036:
            int r0 = r13.f29096J
            if (r0 < 0) goto L_0x0096
            boolean r1 = r13.f29091E
            if (r1 == 0) goto L_0x0048
            r13.f29091E = r12
            android.media.MediaCodec r1 = r13.f29119u
            r1.releaseOutputBuffer(r0, r12)
            r13.f29096J = r14
            return r15
        L_0x0048:
            android.media.MediaCodec$BufferInfo r1 = r13.f29115q
            int r2 = r1.flags
            r2 = r2 & 4
            if (r2 == 0) goto L_0x0056
            r17.m30882z()
            r13.f29096J = r14
            return r12
        L_0x0056:
            java.nio.ByteBuffer[] r2 = r13.f29093G
            r0 = r2[r0]
            if (r0 == 0) goto L_0x006b
            int r1 = r1.offset
            r0.position(r1)
            android.media.MediaCodec$BufferInfo r1 = r13.f29115q
            int r2 = r1.offset
            int r1 = r1.size
            int r2 = r2 + r1
            r0.limit(r2)
        L_0x006b:
            android.media.MediaCodec$BufferInfo r0 = r13.f29115q
            long r0 = r0.presentationTimeUs
            java.util.List<java.lang.Long> r2 = r13.f29114p
            int r2 = r2.size()
            r3 = 0
        L_0x0076:
            if (r3 >= r2) goto L_0x0092
            java.util.List<java.lang.Long> r4 = r13.f29114p
            java.lang.Object r4 = r4.get(r3)
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r6 != 0) goto L_0x008f
            java.util.List<java.lang.Long> r0 = r13.f29114p
            r0.remove(r3)
            r0 = 1
            goto L_0x0093
        L_0x008f:
            int r3 = r3 + 1
            goto L_0x0076
        L_0x0092:
            r0 = 0
        L_0x0093:
            r13.f29097K = r0
            goto L_0x00e6
        L_0x0096:
            r1 = -2
            if (r0 != r1) goto L_0x00c8
            android.media.MediaCodec r0 = r13.f29119u
            android.media.MediaFormat r0 = r0.getOutputFormat()
            boolean r1 = r13.f29123y
            if (r1 == 0) goto L_0x00b9
            java.lang.String r1 = "width"
            int r1 = r0.getInteger(r1)
            r2 = 32
            if (r1 != r2) goto L_0x00b9
            java.lang.String r1 = "height"
            int r1 = r0.getInteger(r1)
            if (r1 != r2) goto L_0x00b9
            r13.f29091E = r15
            goto L_0x00c7
        L_0x00b9:
            boolean r1 = r13.f29089C
            if (r1 == 0) goto L_0x00c2
            java.lang.String r1 = "channel-count"
            r0.setInteger(r1, r15)
        L_0x00c2:
            android.media.MediaCodec r1 = r13.f29119u
            r13.mo32001a(r1, r0)
        L_0x00c7:
            return r15
        L_0x00c8:
            r1 = -3
            if (r0 != r1) goto L_0x00d5
            android.media.MediaCodec r0 = r13.f29119u
            java.nio.ByteBuffer[] r0 = r0.getOutputBuffers()
            r13.f29093G = r0
            return r15
        L_0x00d5:
            boolean r0 = r13.f29124z
            if (r0 == 0) goto L_0x00e5
            boolean r0 = r13.f29103Q
            if (r0 != 0) goto L_0x00e2
            int r0 = r13.f29100N
            r1 = 2
            if (r0 != r1) goto L_0x00e5
        L_0x00e2:
            r17.m30882z()
        L_0x00e5:
            return r12
        L_0x00e6:
            boolean r0 = r13.f29088B
            if (r0 == 0) goto L_0x0120
            boolean r0 = r13.f29102P
            if (r0 == 0) goto L_0x0120
            android.media.MediaCodec r6 = r13.f29119u     // Catch:{ IllegalStateException -> 0x0112 }
            java.nio.ByteBuffer[] r0 = r13.f29093G     // Catch:{ IllegalStateException -> 0x0112 }
            int r1 = r13.f29096J     // Catch:{ IllegalStateException -> 0x0112 }
            r7 = r0[r1]     // Catch:{ IllegalStateException -> 0x0112 }
            int r8 = r13.f29096J     // Catch:{ IllegalStateException -> 0x0112 }
            android.media.MediaCodec$BufferInfo r0 = r13.f29115q     // Catch:{ IllegalStateException -> 0x0112 }
            int r9 = r0.flags     // Catch:{ IllegalStateException -> 0x0112 }
            android.media.MediaCodec$BufferInfo r0 = r13.f29115q     // Catch:{ IllegalStateException -> 0x0112 }
            long r10 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0112 }
            boolean r0 = r13.f29097K     // Catch:{ IllegalStateException -> 0x0112 }
            r1 = r17
            r2 = r18
            r4 = r20
            r16 = 0
            r12 = r0
            boolean r0 = r1.mo32004a(r2, r4, r6, r7, r8, r9, r10, r12)     // Catch:{ IllegalStateException -> 0x0110 }
            goto L_0x013c
        L_0x0110:
            r0 = move-exception
            goto L_0x0115
        L_0x0112:
            r0 = move-exception
            r16 = 0
        L_0x0115:
            r17.m30882z()
            boolean r0 = r13.f29104R
            if (r0 == 0) goto L_0x011f
            r17.mo32083u()
        L_0x011f:
            return r16
        L_0x0120:
            r16 = 0
            android.media.MediaCodec r6 = r13.f29119u
            java.nio.ByteBuffer[] r0 = r13.f29093G
            int r8 = r13.f29096J
            r7 = r0[r8]
            android.media.MediaCodec$BufferInfo r0 = r13.f29115q
            int r9 = r0.flags
            long r10 = r0.presentationTimeUs
            boolean r12 = r13.f29097K
            r1 = r17
            r2 = r18
            r4 = r20
            boolean r0 = r1.mo32004a(r2, r4, r6, r7, r8, r9, r10, r12)
        L_0x013c:
            if (r0 == 0) goto L_0x0145
            android.media.MediaCodec$BufferInfo r0 = r13.f29115q
            long r0 = r0.presentationTimeUs
            r13.f29096J = r14
            return r15
        L_0x0145:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpe.m30880b(long, long):boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public void mo32007v() throws zzku {
    }

    /* renamed from: z */
    private final void m30882z() throws zzku {
        if (this.f29100N == 2) {
            mo32083u();
            mo32082t();
            return;
        }
        this.f29104R = true;
        mo32007v();
    }
}
