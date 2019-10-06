package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.vungle.warren.model.Advertisement;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class zzhd extends zzgr {

    /* renamed from: G */
    private final zzhi f28492G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public final zzhh f28493H;

    /* renamed from: I */
    private final long f28494I;

    /* renamed from: J */
    private final int f28495J;

    /* renamed from: K */
    private final int f28496K;

    /* renamed from: L */
    private Surface f28497L;

    /* renamed from: M */
    private boolean f28498M;

    /* renamed from: N */
    private boolean f28499N;

    /* renamed from: O */
    private long f28500O;

    /* renamed from: P */
    private long f28501P;

    /* renamed from: Q */
    private int f28502Q;

    /* renamed from: R */
    private int f28503R;

    /* renamed from: S */
    private int f28504S;

    /* renamed from: T */
    private float f28505T;

    /* renamed from: U */
    private int f28506U;

    /* renamed from: V */
    private int f28507V;

    /* renamed from: W */
    private float f28508W;

    public zzhd(zzhn zzhn, int i, long j, Handler handler, zzhh zzhh, int i2) {
        this(zzhn, null, true, 1, 0, null, handler, zzhh, -1);
    }

    private zzhd(zzhn zzhn, zzhz zzhz, boolean z, int i, long j, zzhi zzhi, Handler handler, zzhh zzhh, int i2) {
        super(zzhn, null, true, handler, zzhh);
        this.f28495J = 1;
        this.f28494I = 0;
        this.f28492G = null;
        this.f28493H = zzhh;
        this.f28496K = -1;
        this.f28500O = -1;
        this.f28503R = -1;
        this.f28504S = -1;
        this.f28505T = -1.0f;
        this.f28506U = -1;
        this.f28507V = -1;
        this.f28508W = -1.0f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo31784a(String str) {
        return zzkl.m30544a(str).equals(Advertisement.KEY_VIDEO) && super.mo31784a(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31780a(long j, boolean z) {
        super.mo31780a(j, z);
        this.f28499N = false;
        if (z && this.f28494I > 0) {
            this.f28500O = (SystemClock.elapsedRealtime() * 1000) + this.f28494I;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31779a(long j) throws zzgd {
        super.mo31779a(j);
        this.f28499N = false;
        this.f28500O = -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final boolean mo31785d() {
        if (super.mo31785d() && (this.f28499N || !mo31801r() || mo31803t() == 2)) {
            this.f28500O = -1;
            return true;
        } else if (this.f28500O == -1) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() * 1000 < this.f28500O) {
                return true;
            }
            this.f28500O = -1;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final void mo31786e() {
        super.mo31786e();
        this.f28502Q = 0;
        this.f28501P = SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final void mo31787f() {
        this.f28500O = -1;
        m30335x();
        super.mo31787f();
    }

    /* renamed from: n */
    public final void mo31791n() {
        this.f28503R = -1;
        this.f28504S = -1;
        this.f28505T = -1.0f;
        this.f28506U = -1;
        this.f28507V = -1;
        this.f28508W = -1.0f;
        super.mo31791n();
    }

    /* renamed from: a */
    public final void mo31767a(int i, Object obj) throws zzgd {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (this.f28497L != surface) {
                this.f28497L = surface;
                this.f28498M = false;
                int c = mo31814c();
                if (c == 2 || c == 3) {
                    mo31802s();
                    mo31799p();
                }
            }
            return;
        }
        super.mo31767a(i, obj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public final boolean mo31800q() {
        if (super.mo31800q()) {
            Surface surface = this.f28497L;
            if (surface != null && surface.isValid()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31781a(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, MediaCrypto mediaCrypto) {
        mediaCodec.configure(mediaFormat, this.f28497L, mediaCrypto, 0);
        mediaCodec.setVideoScalingMode(this.f28495J);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31793a(zzhk zzhk) throws zzgd {
        super.mo31793a(zzhk);
        float f = zzhk.f28522a.f28514f;
        if (f == -1.0f) {
            f = 1.0f;
        }
        this.f28505T = f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31782a(zzhj zzhj, MediaFormat mediaFormat) {
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
        this.f28503R = i;
        if (z) {
            i2 = (mediaFormat.getInteger(str3) - mediaFormat.getInteger(str2)) + 1;
        } else {
            i2 = mediaFormat.getInteger("height");
        }
        this.f28504S = i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo31794a(MediaCodec mediaCodec, boolean z, zzhj zzhj, zzhj zzhj2) {
        return zzhj2.f28509a.equals(zzhj.f28509a) && (z || (zzhj.f28512d == zzhj2.f28512d && zzhj.f28513e == zzhj2.f28513e));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo31783a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, BufferInfo bufferInfo, int i, boolean z) {
        if (z) {
            zzkp.m30562a("skipVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            zzkp.m30561a();
            this.f28458b.f28423f++;
            return true;
        }
        long elapsedRealtime = (bufferInfo.presentationTimeUs - j) - ((SystemClock.elapsedRealtime() * 1000) - j2);
        long nanoTime = System.nanoTime() + (elapsedRealtime * 1000);
        if (elapsedRealtime < -30000) {
            zzkp.m30562a("dropVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            zzkp.m30561a();
            this.f28458b.f28424g++;
            this.f28502Q++;
            if (this.f28502Q == this.f28496K) {
                m30335x();
            }
            return true;
        } else if (!this.f28499N) {
            m30332a(mediaCodec, i);
            return true;
        } else if (mo31814c() != 3) {
            return false;
        } else {
            if (zzkq.f28747a >= 21) {
                if (elapsedRealtime < 50000) {
                    m30333v();
                    zzkp.m30562a("releaseOutputBufferTimed");
                    mediaCodec.releaseOutputBuffer(i, nanoTime);
                    zzkp.m30561a();
                    this.f28458b.f28422e++;
                    this.f28499N = true;
                    m30334w();
                    return true;
                }
            } else if (elapsedRealtime < 30000) {
                if (elapsedRealtime > 11000) {
                    try {
                        Thread.sleep((elapsedRealtime - 10000) / 1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                m30332a(mediaCodec, i);
                return true;
            }
            return false;
        }
    }

    /* renamed from: a */
    private final void m30332a(MediaCodec mediaCodec, int i) {
        m30333v();
        zzkp.m30562a("renderVideoBufferImmediate");
        mediaCodec.releaseOutputBuffer(i, true);
        zzkp.m30561a();
        this.f28458b.f28422e++;
        this.f28499N = true;
        m30334w();
    }

    /* renamed from: v */
    private final void m30333v() {
        if (this.f28467k != null && this.f28493H != null && (this.f28506U != this.f28503R || this.f28507V != this.f28504S || this.f28508W != this.f28505T)) {
            int i = this.f28503R;
            int i2 = this.f28504S;
            float f = this.f28505T;
            this.f28467k.post(new C9179Uq(this, i, i2, f));
            this.f28506U = i;
            this.f28507V = i2;
            this.f28508W = f;
        }
    }

    /* renamed from: w */
    private final void m30334w() {
        Handler handler = this.f28467k;
        if (handler != null && this.f28493H != null && !this.f28498M) {
            handler.post(new C9200Vq(this, this.f28497L));
            this.f28498M = true;
        }
    }

    /* renamed from: x */
    private final void m30335x() {
        if (this.f28467k != null && this.f28493H != null && this.f28502Q != 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f28467k.post(new C9221Wq(this, this.f28502Q, elapsedRealtime - this.f28501P));
            this.f28502Q = 0;
            this.f28501P = elapsedRealtime;
        }
    }
}
