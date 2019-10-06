package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class zzgn extends zzgr {
    /* access modifiers changed from: private */

    /* renamed from: G */
    public final zzgq f28448G;

    /* renamed from: H */
    private final zzhq f28449H;

    /* renamed from: I */
    private int f28450I;

    /* renamed from: J */
    private long f28451J;

    public zzgn(zzhn zzhn, Handler handler, zzgq zzgq) {
        this(zzhn, null, true, handler, zzgq);
    }

    private zzgn(zzhn zzhn, zzhz zzhz, boolean z, Handler handler, zzgq zzgq) {
        super(zzhn, null, true, handler, zzgq);
        this.f28448G = zzgq;
        this.f28450I = 0;
        this.f28449H = new zzhq();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final zzgc mo31778a(String str, boolean z) throws zzgz {
        if (zzkl.m30546c(str)) {
            return new zzgc("OMX.google.raw.decoder", true);
        }
        return super.mo31778a(str, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31781a(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, MediaCrypto mediaCrypto) {
        if ("OMX.google.raw.decoder".equals(str)) {
            String str2 = "mime";
            String string = mediaFormat.getString(str2);
            mediaFormat.setString(str2, "audio/raw");
            mediaCodec.configure(mediaFormat, null, mediaCrypto, 0);
            mediaFormat.setString(str2, string);
            return;
        }
        mediaCodec.configure(mediaFormat, null, mediaCrypto, 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public final boolean mo31788k() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo31784a(String str) {
        return zzkl.m30545b(str) && super.mo31784a(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31780a(long j, boolean z) {
        super.mo31780a(j, z);
        this.f28451J = Long.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31782a(zzhj zzhj, MediaFormat mediaFormat) {
        if (zzkl.m30546c(zzhj.f28509a)) {
            this.f28449H.mo31823a(zzhj.mo31806b(), 0);
        } else {
            this.f28449H.mo31823a(mediaFormat, 0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final void mo31786e() {
        super.mo31786e();
        this.f28449H.mo31826c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final void mo31787f() {
        this.f28449H.mo31825b();
        super.mo31787f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public final boolean mo31789l() {
        return super.mo31789l() && (!this.f28449H.mo31829f() || !this.f28449H.mo31830g());
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final boolean mo31785d() {
        return this.f28449H.mo31829f() || (super.mo31785d() && mo31803t() == 2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public final long mo31790m() {
        long a = this.f28449H.mo31821a(mo31789l());
        if (a == Long.MIN_VALUE) {
            this.f28451J = Math.max(this.f28451J, super.mo31790m());
        } else {
            this.f28451J = Math.max(this.f28451J, a);
        }
        return this.f28451J;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public final void mo31791n() {
        this.f28450I = 0;
        try {
            this.f28449H.mo31827d();
        } finally {
            super.mo31791n();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31779a(long j) throws zzgd {
        super.mo31779a(j);
        this.f28449H.mo31827d();
        this.f28451J = Long.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo31783a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, BufferInfo bufferInfo, int i, boolean z) throws zzgd {
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.f28458b.f28423f++;
            this.f28449H.mo31828e();
            return true;
        }
        if (!this.f28449H.mo31824a()) {
            try {
                if (this.f28450I != 0) {
                    this.f28449H.mo31819a(this.f28450I);
                } else {
                    this.f28450I = this.f28449H.mo31819a(0);
                }
                if (mo31814c() == 3) {
                    this.f28449H.mo31826c();
                }
            } catch (zzhu e) {
                Handler handler = this.f28467k;
                if (!(handler == null || this.f28448G == null)) {
                    handler.post(new C8987Lq(this, e));
                }
                throw new zzgd((Throwable) e);
            }
        }
        try {
            int a = this.f28449H.mo31820a(byteBuffer, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs);
            if ((a & 1) != 0) {
                this.f28451J = Long.MIN_VALUE;
            }
            if ((a & 2) == 0) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            this.f28458b.f28422e++;
            return true;
        } catch (zzhv e2) {
            Handler handler2 = this.f28467k;
            if (!(handler2 == null || this.f28448G == null)) {
                handler2.post(new C9008Mq(this, e2));
            }
            throw new zzgd((Throwable) e2);
        }
    }

    /* renamed from: a */
    public final void mo31767a(int i, Object obj) throws zzgd {
        if (i == 1) {
            this.f28449H.mo31822a(((Float) obj).floatValue());
        } else {
            super.mo31767a(i, obj);
        }
    }
}
