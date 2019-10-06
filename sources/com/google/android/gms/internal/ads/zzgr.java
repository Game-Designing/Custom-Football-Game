package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class zzgr extends zzhp {

    /* renamed from: A */
    private int f28452A;

    /* renamed from: B */
    private boolean f28453B;

    /* renamed from: C */
    private boolean f28454C;

    /* renamed from: D */
    private boolean f28455D;

    /* renamed from: E */
    private boolean f28456E;

    /* renamed from: F */
    private long f28457F;

    /* renamed from: b */
    public final zzga f28458b;

    /* renamed from: c */
    private final zzhz f28459c;

    /* renamed from: d */
    private final boolean f28460d;

    /* renamed from: e */
    private final zzhn f28461e;

    /* renamed from: f */
    private final zzhm f28462f;

    /* renamed from: g */
    private final zzhk f28463g;

    /* renamed from: h */
    private final List<Long> f28464h;

    /* renamed from: i */
    private final BufferInfo f28465i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final zzgw f28466j;

    /* renamed from: k */
    protected final Handler f28467k;

    /* renamed from: l */
    private zzhj f28468l;

    /* renamed from: m */
    private zzhw f28469m;

    /* renamed from: n */
    private MediaCodec f28470n;

    /* renamed from: o */
    private boolean f28471o;

    /* renamed from: p */
    private ByteBuffer[] f28472p;

    /* renamed from: q */
    private ByteBuffer[] f28473q;

    /* renamed from: r */
    private long f28474r;

    /* renamed from: s */
    private int f28475s;

    /* renamed from: t */
    private int f28476t;

    /* renamed from: u */
    private boolean f28477u;

    /* renamed from: v */
    private boolean f28478v;

    /* renamed from: w */
    private int f28479w;

    /* renamed from: x */
    private int f28480x;

    /* renamed from: y */
    private boolean f28481y;

    /* renamed from: z */
    private int f28482z;

    public zzgr(zzhn zzhn, zzhz zzhz, boolean z, Handler handler, zzgw zzgw) {
        zzkh.m30537b(zzkq.f28747a >= 16);
        this.f28461e = zzhn;
        this.f28459c = null;
        this.f28460d = true;
        this.f28467k = handler;
        this.f28466j = zzgw;
        this.f28458b = new zzga();
        this.f28462f = new zzhm(0);
        this.f28463g = new zzhk();
        this.f28464h = new ArrayList();
        this.f28465i = new BufferInfo();
        this.f28479w = 0;
        this.f28480x = 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo31783a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, BufferInfo bufferInfo, int i, boolean z) throws zzgd;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final int mo31795b(long j) throws zzgd {
        try {
            if (!this.f28461e.mo31774b(j)) {
                return 0;
            }
            for (int i = 0; i < this.f28461e.mo31775c(); i++) {
                if (mo31784a(this.f28461e.mo31769a(i).f28530a)) {
                    this.f28482z = i;
                    return 1;
                }
            }
            return -1;
        } catch (IOException e) {
            throw new zzgd((Throwable) e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo31784a(String str) {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo31780a(long j, boolean z) {
        this.f28461e.mo31776c(this.f28482z, j);
        this.f28452A = 0;
        this.f28453B = false;
        this.f28454C = false;
        this.f28455D = false;
        this.f28457F = j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzgc mo31778a(String str, boolean z) throws zzgz {
        return zzgx.m30326a(str, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo31781a(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, MediaCrypto mediaCrypto) {
        mediaCodec.configure(mediaFormat, null, mediaCrypto, 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public final void mo31799p() throws zzgd {
        MediaCrypto mediaCrypto;
        if (mo31800q()) {
            String str = this.f28468l.f28509a;
            boolean z = false;
            zzhw zzhw = this.f28469m;
            if (zzhw != null) {
                zzhz zzhz = this.f28459c;
                if (zzhz != null) {
                    if (!this.f28477u) {
                        zzhz.mo31833a(zzhw);
                        this.f28477u = true;
                    }
                    int state = this.f28459c.getState();
                    if (state == 0) {
                        throw new zzgd((Throwable) this.f28459c.mo31832a());
                    } else if (state == 3 || state == 4) {
                        mediaCrypto = this.f28459c.mo31835b();
                        z = this.f28459c.mo31834a(str);
                    } else {
                        return;
                    }
                } else {
                    throw new zzgd("Media requires a DrmSessionManager");
                }
            } else {
                mediaCrypto = null;
            }
            try {
                zzgc a = mo31778a(str, z);
                if (a != null) {
                    String str2 = a.f28432a;
                    this.f28471o = a.f28433b;
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        this.f28470n = MediaCodec.createByCodecName(str2);
                        mo31781a(this.f28470n, str2, this.f28468l.mo31806b(), mediaCrypto);
                        this.f28470n.start();
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        long j = elapsedRealtime2 - elapsedRealtime;
                        if (!(this.f28467k == null || this.f28466j == null)) {
                            Handler handler = this.f28467k;
                            C9071Pq pq = new C9071Pq(this, str2, elapsedRealtime2, j);
                            handler.post(pq);
                        }
                        this.f28472p = this.f28470n.getInputBuffers();
                        this.f28473q = this.f28470n.getOutputBuffers();
                        this.f28474r = mo31814c() == 3 ? SystemClock.elapsedRealtime() : -1;
                        this.f28475s = -1;
                        this.f28476t = -1;
                        this.f28456E = true;
                        this.f28458b.f28418a++;
                    } catch (Exception e) {
                        m30294a(new zzgv(this.f28468l, (Throwable) e, str2));
                        throw null;
                    }
                } else {
                    m30294a(new zzgv(this.f28468l, (Throwable) null, -49999));
                    throw null;
                }
            } catch (zzgz e2) {
                m30294a(new zzgv(this.f28468l, (Throwable) e2, -49998));
                throw null;
            }
        }
    }

    /* renamed from: a */
    private final void m30294a(zzgv zzgv) throws zzgd {
        Handler handler = this.f28467k;
        if (!(handler == null || this.f28466j == null)) {
            handler.post(new C9029Nq(this, zzgv));
        }
        throw new zzgd((Throwable) zzgv);
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public boolean mo31800q() {
        return this.f28470n == null && this.f28468l != null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public final boolean mo31801r() {
        return this.f28470n != null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public void mo31791n() {
        this.f28468l = null;
        this.f28469m = null;
        try {
            mo31802s();
            try {
                if (this.f28477u) {
                    this.f28459c.close();
                    this.f28477u = false;
                }
            } finally {
                this.f28461e.mo31773b(this.f28482z);
            }
        } catch (Throwable th) {
            if (this.f28477u) {
                this.f28459c.close();
                this.f28477u = false;
            }
            throw th;
        } finally {
            this.f28461e.mo31773b(this.f28482z);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public final void mo31802s() {
        if (this.f28470n != null) {
            this.f28474r = -1;
            this.f28475s = -1;
            this.f28476t = -1;
            this.f28455D = false;
            this.f28464h.clear();
            this.f28472p = null;
            this.f28473q = null;
            this.f28478v = false;
            this.f28481y = false;
            this.f28471o = false;
            this.f28479w = 0;
            this.f28480x = 0;
            this.f28458b.f28419b++;
            try {
                this.f28470n.stop();
                try {
                    this.f28470n.release();
                } finally {
                    this.f28470n = null;
                }
            } catch (Throwable th) {
                this.f28470n.release();
                throw th;
            } finally {
                this.f28470n = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public final void mo31798o() {
        this.f28461e.mo31770a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public long mo31790m() {
        return this.f28457F;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final long mo31796b() {
        return this.f28461e.mo31769a(this.f28482z).f28531b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public final long mo31797j() {
        long b = this.f28461e.mo31772b();
        return (b == -1 || b == -3) ? b : Math.max(b, mo31790m());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo31779a(long j) throws zzgd {
        this.f28457F = j;
        this.f28461e.mo31771a(j);
        this.f28452A = 0;
        this.f28453B = false;
        this.f28454C = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo31786e() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo31787f() {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x012c A[Catch:{ IOException -> 0x0135 }, LOOP:0: B:26:0x0060->B:71:0x012c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x011e A[EDGE_INSN: B:77:0x011e->B:66:0x011e ?: BREAK  , SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo31792a(long r18, long r20) throws com.google.android.gms.internal.ads.zzgd {
        /*
            r17 = this;
            r11 = r17
            com.google.android.gms.internal.ads.zzhn r0 = r11.f28461e     // Catch:{ IOException -> 0x0135 }
            r12 = r18
            boolean r0 = r0.mo31777c(r12)     // Catch:{ IOException -> 0x0135 }
            r15 = 1
            if (r0 == 0) goto L_0x0016
            int r0 = r11.f28452A     // Catch:{ IOException -> 0x0135 }
            if (r0 != 0) goto L_0x0013
            r0 = 1
            goto L_0x0017
        L_0x0013:
            int r0 = r11.f28452A     // Catch:{ IOException -> 0x0135 }
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            r11.f28452A = r0     // Catch:{ IOException -> 0x0135 }
            android.media.MediaCodec r0 = r11.f28470n     // Catch:{ IOException -> 0x0135 }
            if (r0 == 0) goto L_0x0033
            com.google.android.gms.internal.ads.zzhn r1 = r11.f28461e     // Catch:{ IOException -> 0x0135 }
            int r2 = r11.f28482z     // Catch:{ IOException -> 0x0135 }
            long r3 = r11.f28457F     // Catch:{ IOException -> 0x0135 }
            com.google.android.gms.internal.ads.zzhk r5 = r11.f28463g     // Catch:{ IOException -> 0x0135 }
            com.google.android.gms.internal.ads.zzhm r6 = r11.f28462f     // Catch:{ IOException -> 0x0135 }
            r7 = 1
            int r0 = r1.mo31768a(r2, r3, r5, r6, r7)     // Catch:{ IOException -> 0x0135 }
            r1 = -5
            if (r0 != r1) goto L_0x0033
            r17.m30296u()     // Catch:{ IOException -> 0x0135 }
        L_0x0033:
            com.google.android.gms.internal.ads.zzhj r0 = r11.f28468l     // Catch:{ IOException -> 0x0135 }
            if (r0 != 0) goto L_0x004f
            com.google.android.gms.internal.ads.zzhn r1 = r11.f28461e     // Catch:{ IOException -> 0x0135 }
            int r2 = r11.f28482z     // Catch:{ IOException -> 0x0135 }
            long r3 = r11.f28457F     // Catch:{ IOException -> 0x0135 }
            com.google.android.gms.internal.ads.zzhk r5 = r11.f28463g     // Catch:{ IOException -> 0x0135 }
            com.google.android.gms.internal.ads.zzhm r6 = r11.f28462f     // Catch:{ IOException -> 0x0135 }
            r7 = 0
            int r0 = r1.mo31768a(r2, r3, r5, r6, r7)     // Catch:{ IOException -> 0x0135 }
            r1 = -4
            if (r0 != r1) goto L_0x004f
            com.google.android.gms.internal.ads.zzhk r0 = r11.f28463g     // Catch:{ IOException -> 0x0135 }
            r11.mo31793a(r0)     // Catch:{ IOException -> 0x0135 }
        L_0x004f:
            android.media.MediaCodec r0 = r11.f28470n     // Catch:{ IOException -> 0x0135 }
            if (r0 != 0) goto L_0x005c
            boolean r0 = r17.mo31800q()     // Catch:{ IOException -> 0x0135 }
            if (r0 == 0) goto L_0x005c
            r17.mo31799p()     // Catch:{ IOException -> 0x0135 }
        L_0x005c:
            android.media.MediaCodec r0 = r11.f28470n     // Catch:{ IOException -> 0x0135 }
            if (r0 == 0) goto L_0x012f
        L_0x0060:
            boolean r0 = r11.f28454C     // Catch:{ IOException -> 0x0135 }
            if (r0 != 0) goto L_0x011b
            int r0 = r11.f28476t     // Catch:{ IOException -> 0x0135 }
            if (r0 >= 0) goto L_0x0075
            android.media.MediaCodec r0 = r11.f28470n     // Catch:{ IOException -> 0x0135 }
            android.media.MediaCodec$BufferInfo r1 = r11.f28465i     // Catch:{ IOException -> 0x0135 }
            r2 = 0
            int r0 = r0.dequeueOutputBuffer(r1, r2)     // Catch:{ IOException -> 0x0135 }
            r11.f28476t = r0     // Catch:{ IOException -> 0x0135 }
        L_0x0075:
            int r0 = r11.f28476t     // Catch:{ IOException -> 0x0135 }
            r1 = -2
            if (r0 != r1) goto L_0x008f
            com.google.android.gms.internal.ads.zzhj r0 = r11.f28468l     // Catch:{ IOException -> 0x0135 }
            android.media.MediaCodec r1 = r11.f28470n     // Catch:{ IOException -> 0x0135 }
            android.media.MediaFormat r1 = r1.getOutputFormat()     // Catch:{ IOException -> 0x0135 }
            r11.mo31782a(r0, r1)     // Catch:{ IOException -> 0x0135 }
            com.google.android.gms.internal.ads.zzga r0 = r11.f28458b     // Catch:{ IOException -> 0x0135 }
            int r1 = r0.f28420c     // Catch:{ IOException -> 0x0135 }
            int r1 = r1 + r15
            r0.f28420c = r1     // Catch:{ IOException -> 0x0135 }
            r14 = 1
            goto L_0x011c
        L_0x008f:
            int r0 = r11.f28476t     // Catch:{ IOException -> 0x0135 }
            r1 = -3
            if (r0 != r1) goto L_0x00a6
            android.media.MediaCodec r0 = r11.f28470n     // Catch:{ IOException -> 0x0135 }
            java.nio.ByteBuffer[] r0 = r0.getOutputBuffers()     // Catch:{ IOException -> 0x0135 }
            r11.f28473q = r0     // Catch:{ IOException -> 0x0135 }
            com.google.android.gms.internal.ads.zzga r0 = r11.f28458b     // Catch:{ IOException -> 0x0135 }
            int r1 = r0.f28421d     // Catch:{ IOException -> 0x0135 }
            int r1 = r1 + r15
            r0.f28421d = r1     // Catch:{ IOException -> 0x0135 }
            r14 = 1
            goto L_0x011c
        L_0x00a6:
            int r0 = r11.f28476t     // Catch:{ IOException -> 0x0135 }
            if (r0 < 0) goto L_0x011b
            android.media.MediaCodec$BufferInfo r0 = r11.f28465i     // Catch:{ IOException -> 0x0135 }
            int r0 = r0.flags     // Catch:{ IOException -> 0x0135 }
            r0 = r0 & 4
            if (r0 == 0) goto L_0x00c2
            int r0 = r11.f28480x     // Catch:{ IOException -> 0x0135 }
            r1 = 2
            if (r0 != r1) goto L_0x00be
            r17.mo31802s()     // Catch:{ IOException -> 0x0135 }
            r17.mo31799p()     // Catch:{ IOException -> 0x0135 }
            goto L_0x00c0
        L_0x00be:
            r11.f28454C = r15     // Catch:{ IOException -> 0x0135 }
        L_0x00c0:
            r14 = 0
            goto L_0x011c
        L_0x00c2:
            android.media.MediaCodec$BufferInfo r0 = r11.f28465i     // Catch:{ IOException -> 0x0135 }
            long r0 = r0.presentationTimeUs     // Catch:{ IOException -> 0x0135 }
            java.util.List<java.lang.Long> r2 = r11.f28464h     // Catch:{ IOException -> 0x0135 }
            int r2 = r2.size()     // Catch:{ IOException -> 0x0135 }
            r3 = 0
        L_0x00cd:
            r10 = -1
            if (r3 >= r2) goto L_0x00e5
            java.util.List<java.lang.Long> r4 = r11.f28464h     // Catch:{ IOException -> 0x0135 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ IOException -> 0x0135 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ IOException -> 0x0135 }
            long r4 = r4.longValue()     // Catch:{ IOException -> 0x0135 }
            int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r6 != 0) goto L_0x00e2
            r0 = r3
            goto L_0x00e6
        L_0x00e2:
            int r3 = r3 + 1
            goto L_0x00cd
        L_0x00e5:
            r0 = -1
        L_0x00e6:
            android.media.MediaCodec r6 = r11.f28470n     // Catch:{ IOException -> 0x0135 }
            java.nio.ByteBuffer[] r1 = r11.f28473q     // Catch:{ IOException -> 0x0135 }
            int r2 = r11.f28476t     // Catch:{ IOException -> 0x0135 }
            r7 = r1[r2]     // Catch:{ IOException -> 0x0135 }
            android.media.MediaCodec$BufferInfo r8 = r11.f28465i     // Catch:{ IOException -> 0x0135 }
            int r9 = r11.f28476t     // Catch:{ IOException -> 0x0135 }
            if (r0 == r10) goto L_0x00f8
            r16 = 1
            goto L_0x00fa
        L_0x00f8:
            r16 = 0
        L_0x00fa:
            r1 = r17
            r2 = r18
            r4 = r20
            r14 = -1
            r10 = r16
            boolean r1 = r1.mo31783a(r2, r4, r6, r7, r8, r9, r10)     // Catch:{ IOException -> 0x0135 }
            if (r1 == 0) goto L_0x011b
            if (r0 == r14) goto L_0x0111
            java.util.List<java.lang.Long> r1 = r11.f28464h     // Catch:{ IOException -> 0x0135 }
            r1.remove(r0)     // Catch:{ IOException -> 0x0135 }
            goto L_0x0117
        L_0x0111:
            android.media.MediaCodec$BufferInfo r0 = r11.f28465i     // Catch:{ IOException -> 0x0135 }
            long r0 = r0.presentationTimeUs     // Catch:{ IOException -> 0x0135 }
            r11.f28457F = r0     // Catch:{ IOException -> 0x0135 }
        L_0x0117:
            r11.f28476t = r14     // Catch:{ IOException -> 0x0135 }
            r14 = 1
            goto L_0x011c
        L_0x011b:
            r14 = 0
        L_0x011c:
            if (r14 != 0) goto L_0x012c
            boolean r0 = r11.m30295a(r15)     // Catch:{ IOException -> 0x0135 }
            if (r0 == 0) goto L_0x012f
        L_0x0124:
            r0 = 0
            boolean r1 = r11.m30295a(r0)     // Catch:{ IOException -> 0x0135 }
            if (r1 != 0) goto L_0x0124
            goto L_0x012f
        L_0x012c:
            r0 = 0
            goto L_0x0060
        L_0x012f:
            com.google.android.gms.internal.ads.zzga r0 = r11.f28458b     // Catch:{ IOException -> 0x0135 }
            r0.mo31763a()     // Catch:{ IOException -> 0x0135 }
            return
        L_0x0135:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzgd r1 = new com.google.android.gms.internal.ads.zzgd
            r1.<init>(r0)
            goto L_0x013d
        L_0x013c:
            throw r1
        L_0x013d:
            goto L_0x013c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgr.mo31792a(long, long):void");
    }

    /* renamed from: u */
    private final void m30296u() throws zzgd {
        this.f28474r = -1;
        this.f28475s = -1;
        this.f28476t = -1;
        this.f28456E = true;
        this.f28455D = false;
        this.f28464h.clear();
        if (zzkq.f28747a < 18 || this.f28480x != 0) {
            mo31802s();
            mo31799p();
        } else {
            this.f28470n.flush();
            this.f28481y = false;
        }
        if (this.f28478v && this.f28468l != null) {
            this.f28479w = 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:78:0x0122 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0123 A[SYNTHETIC, Splitter:B:79:0x0123] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m30295a(boolean r18) throws java.io.IOException, com.google.android.gms.internal.ads.zzgd {
        /*
            r17 = this;
            r1 = r17
            boolean r0 = r1.f28453B
            r2 = 0
            if (r0 != 0) goto L_0x0191
            int r0 = r1.f28480x
            r3 = 2
            if (r0 != r3) goto L_0x000e
            goto L_0x0191
        L_0x000e:
            int r0 = r1.f28475s
            if (r0 >= 0) goto L_0x002e
            android.media.MediaCodec r0 = r1.f28470n
            r4 = 0
            int r0 = r0.dequeueInputBuffer(r4)
            r1.f28475s = r0
            int r0 = r1.f28475s
            if (r0 >= 0) goto L_0x0021
            return r2
        L_0x0021:
            com.google.android.gms.internal.ads.zzhm r4 = r1.f28462f
            java.nio.ByteBuffer[] r5 = r1.f28472p
            r0 = r5[r0]
            r4.f28525b = r0
            java.nio.ByteBuffer r0 = r4.f28525b
            r0.clear()
        L_0x002e:
            int r0 = r1.f28480x
            r4 = -1
            r5 = 1
            if (r0 != r5) goto L_0x0045
            android.media.MediaCodec r6 = r1.f28470n
            int r7 = r1.f28475s
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 4
            r6.queueInputBuffer(r7, r8, r9, r10, r12)
            r1.f28475s = r4
            r1.f28480x = r3
            return r2
        L_0x0045:
            boolean r0 = r1.f28455D
            r6 = -2
            if (r0 == 0) goto L_0x004c
            r0 = -3
            goto L_0x008a
        L_0x004c:
            int r0 = r1.f28479w
            if (r0 != r5) goto L_0x0071
            r0 = 0
        L_0x0051:
            com.google.android.gms.internal.ads.zzhj r7 = r1.f28468l
            java.util.List<byte[]> r7 = r7.f28517i
            int r7 = r7.size()
            if (r0 >= r7) goto L_0x006f
            com.google.android.gms.internal.ads.zzhj r7 = r1.f28468l
            java.util.List<byte[]> r7 = r7.f28517i
            java.lang.Object r7 = r7.get(r0)
            byte[] r7 = (byte[]) r7
            com.google.android.gms.internal.ads.zzhm r8 = r1.f28462f
            java.nio.ByteBuffer r8 = r8.f28525b
            r8.put(r7)
            int r0 = r0 + 1
            goto L_0x0051
        L_0x006f:
            r1.f28479w = r3
        L_0x0071:
            com.google.android.gms.internal.ads.zzhn r7 = r1.f28461e
            int r8 = r1.f28482z
            long r9 = r1.f28457F
            com.google.android.gms.internal.ads.zzhk r11 = r1.f28463g
            com.google.android.gms.internal.ads.zzhm r12 = r1.f28462f
            r13 = 0
            int r0 = r7.mo31768a(r8, r9, r11, r12, r13)
            if (r18 == 0) goto L_0x008a
            int r7 = r1.f28452A
            if (r7 != r5) goto L_0x008a
            if (r0 != r6) goto L_0x008a
            r1.f28452A = r3
        L_0x008a:
            if (r0 != r6) goto L_0x008d
            return r2
        L_0x008d:
            r6 = -5
            if (r0 != r6) goto L_0x0094
            r17.m30296u()
            return r5
        L_0x0094:
            r6 = -4
            if (r0 != r6) goto L_0x00aa
            int r0 = r1.f28479w
            if (r0 != r3) goto L_0x00a4
            com.google.android.gms.internal.ads.zzhm r0 = r1.f28462f
            java.nio.ByteBuffer r0 = r0.f28525b
            r0.clear()
            r1.f28479w = r5
        L_0x00a4:
            com.google.android.gms.internal.ads.zzhk r0 = r1.f28463g
            r1.mo31793a(r0)
            return r5
        L_0x00aa:
            if (r0 != r4) goto L_0x00d5
            int r0 = r1.f28479w
            if (r0 != r3) goto L_0x00b9
            com.google.android.gms.internal.ads.zzhm r0 = r1.f28462f
            java.nio.ByteBuffer r0 = r0.f28525b
            r0.clear()
            r1.f28479w = r5
        L_0x00b9:
            r1.f28453B = r5
            android.media.MediaCodec r6 = r1.f28470n     // Catch:{ CryptoException -> 0x00cb }
            int r7 = r1.f28475s     // Catch:{ CryptoException -> 0x00cb }
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 4
            r6.queueInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x00cb }
            r1.f28475s = r4     // Catch:{ CryptoException -> 0x00cb }
            return r2
        L_0x00cb:
            r0 = move-exception
            r1.m30293a(r0)
            com.google.android.gms.internal.ads.zzgd r2 = new com.google.android.gms.internal.ads.zzgd
            r2.<init>(r0)
            throw r2
        L_0x00d5:
            boolean r0 = r1.f28456E
            if (r0 == 0) goto L_0x00f1
            com.google.android.gms.internal.ads.zzhm r0 = r1.f28462f
            boolean r0 = r0.mo31811b()
            if (r0 != 0) goto L_0x00ef
            com.google.android.gms.internal.ads.zzhm r0 = r1.f28462f
            java.nio.ByteBuffer r0 = r0.f28525b
            r0.clear()
            int r0 = r1.f28479w
            if (r0 != r3) goto L_0x00ee
            r1.f28479w = r5
        L_0x00ee:
            return r5
        L_0x00ef:
            r1.f28456E = r2
        L_0x00f1:
            com.google.android.gms.internal.ads.zzhm r0 = r1.f28462f
            boolean r0 = r0.mo31810a()
            boolean r3 = r1.f28477u
            if (r3 == 0) goto L_0x011b
            com.google.android.gms.internal.ads.zzhz r3 = r1.f28459c
            int r3 = r3.getState()
            if (r3 == 0) goto L_0x010f
            r6 = 4
            if (r3 == r6) goto L_0x011b
            if (r0 != 0) goto L_0x010d
            boolean r3 = r1.f28460d
            if (r3 != 0) goto L_0x011b
        L_0x010d:
            r3 = 1
            goto L_0x011c
        L_0x010f:
            com.google.android.gms.internal.ads.zzgd r0 = new com.google.android.gms.internal.ads.zzgd
            com.google.android.gms.internal.ads.zzhz r2 = r1.f28459c
            java.lang.Exception r2 = r2.mo31832a()
            r0.<init>(r2)
            throw r0
        L_0x011b:
            r3 = 0
        L_0x011c:
            r1.f28455D = r3
            boolean r3 = r1.f28455D
            if (r3 == 0) goto L_0x0123
            return r2
        L_0x0123:
            com.google.android.gms.internal.ads.zzhm r3 = r1.f28462f     // Catch:{ CryptoException -> 0x0187 }
            java.nio.ByteBuffer r3 = r3.f28525b     // Catch:{ CryptoException -> 0x0187 }
            int r9 = r3.position()     // Catch:{ CryptoException -> 0x0187 }
            com.google.android.gms.internal.ads.zzhm r3 = r1.f28462f     // Catch:{ CryptoException -> 0x0187 }
            int r3 = r3.f28526c     // Catch:{ CryptoException -> 0x0187 }
            int r3 = r9 - r3
            com.google.android.gms.internal.ads.zzhm r6 = r1.f28462f     // Catch:{ CryptoException -> 0x0187 }
            long r14 = r6.f28528e     // Catch:{ CryptoException -> 0x0187 }
            com.google.android.gms.internal.ads.zzhm r6 = r1.f28462f     // Catch:{ CryptoException -> 0x0187 }
            int r6 = r6.f28527d     // Catch:{ CryptoException -> 0x0187 }
            r7 = 134217728(0x8000000, float:3.85186E-34)
            r6 = r6 & r7
            if (r6 == 0) goto L_0x0140
            r6 = 1
            goto L_0x0141
        L_0x0140:
            r6 = 0
        L_0x0141:
            if (r6 == 0) goto L_0x014c
            java.util.List<java.lang.Long> r6 = r1.f28464h     // Catch:{ CryptoException -> 0x0187 }
            java.lang.Long r7 = java.lang.Long.valueOf(r14)     // Catch:{ CryptoException -> 0x0187 }
            r6.add(r7)     // Catch:{ CryptoException -> 0x0187 }
        L_0x014c:
            if (r0 == 0) goto L_0x0175
            com.google.android.gms.internal.ads.zzhm r0 = r1.f28462f     // Catch:{ CryptoException -> 0x0187 }
            com.google.android.gms.internal.ads.zzgb r0 = r0.f28524a     // Catch:{ CryptoException -> 0x0187 }
            android.media.MediaCodec$CryptoInfo r13 = r0.mo31764a()     // Catch:{ CryptoException -> 0x0187 }
            if (r3 != 0) goto L_0x0159
            goto L_0x0169
        L_0x0159:
            int[] r0 = r13.numBytesOfClearData     // Catch:{ CryptoException -> 0x0187 }
            if (r0 != 0) goto L_0x0161
            int[] r0 = new int[r5]     // Catch:{ CryptoException -> 0x0187 }
            r13.numBytesOfClearData = r0     // Catch:{ CryptoException -> 0x0187 }
        L_0x0161:
            int[] r0 = r13.numBytesOfClearData     // Catch:{ CryptoException -> 0x0187 }
            r6 = r0[r2]     // Catch:{ CryptoException -> 0x0187 }
            int r6 = r6 + r3
            r0[r2] = r6     // Catch:{ CryptoException -> 0x0187 }
        L_0x0169:
            android.media.MediaCodec r10 = r1.f28470n     // Catch:{ CryptoException -> 0x0187 }
            int r11 = r1.f28475s     // Catch:{ CryptoException -> 0x0187 }
            r12 = 0
            r16 = 0
            r10.queueSecureInputBuffer(r11, r12, r13, r14, r16)     // Catch:{ CryptoException -> 0x0187 }
            goto L_0x017f
        L_0x0175:
            android.media.MediaCodec r6 = r1.f28470n     // Catch:{ CryptoException -> 0x0187 }
            int r7 = r1.f28475s     // Catch:{ CryptoException -> 0x0187 }
            r8 = 0
            r12 = 0
            r10 = r14
            r6.queueInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x0187 }
        L_0x017f:
            r1.f28475s = r4     // Catch:{ CryptoException -> 0x0187 }
            r1.f28481y = r5     // Catch:{ CryptoException -> 0x0187 }
            r1.f28479w = r2     // Catch:{ CryptoException -> 0x0187 }
            return r5
        L_0x0187:
            r0 = move-exception
            r1.m30293a(r0)
            com.google.android.gms.internal.ads.zzgd r2 = new com.google.android.gms.internal.ads.zzgd
            r2.<init>(r0)
            throw r2
        L_0x0191:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgr.m30295a(boolean):boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo31793a(zzhk zzhk) throws zzgd {
        zzhj zzhj = this.f28468l;
        this.f28468l = zzhk.f28522a;
        this.f28469m = zzhk.f28523b;
        MediaCodec mediaCodec = this.f28470n;
        if (mediaCodec != null && mo31794a(mediaCodec, this.f28471o, zzhj, this.f28468l)) {
            this.f28478v = true;
            this.f28479w = 1;
        } else if (this.f28481y) {
            this.f28480x = 1;
        } else {
            mo31802s();
            mo31799p();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo31782a(zzhj zzhj, MediaFormat mediaFormat) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo31794a(MediaCodec mediaCodec, boolean z, zzhj zzhj, zzhj zzhj2) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public boolean mo31789l() {
        return this.f28454C;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo31785d() {
        if (this.f28468l != null && !this.f28455D) {
            if (this.f28452A == 0 && this.f28476t < 0) {
                if (SystemClock.elapsedRealtime() < this.f28474r + 1000) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public final int mo31803t() {
        return this.f28452A;
    }

    /* renamed from: a */
    private final void m30293a(CryptoException cryptoException) {
        Handler handler = this.f28467k;
        if (handler != null && this.f28466j != null) {
            handler.post(new C9050Oq(this, cryptoException));
        }
    }
}
