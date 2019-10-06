package com.google.android.gms.internal.ads;

import android.media.MediaCodec.CryptoException;
import android.view.Surface;

/* renamed from: com.google.android.gms.internal.ads.Xd */
final class C9229Xd implements zzhh {

    /* renamed from: a */
    private final /* synthetic */ zzbdq f21918a;

    C9229Xd(zzbdq zzbdq) {
        this.f21918a = zzbdq;
    }

    /* renamed from: a */
    public final void mo28347a(int i, long j) {
        StringBuilder sb = new StringBuilder(64);
        sb.append("Dropped frames. Count: ");
        sb.append(i);
        sb.append(" Elapsed: ");
        sb.append(j);
        zzbad.m26352a(sb.toString());
    }

    /* renamed from: a */
    public final void mo28346a(int i, int i2, float f) {
        this.f21918a.f25213w = i;
        this.f21918a.f25214x = i2;
        this.f21918a.f25215y = f;
        zzbdq zzbdq = this.f21918a;
        zzbdq.m26565a(zzbdq.f25213w, this.f21918a.f25214x, this.f21918a.f25215y);
    }

    /* renamed from: a */
    public final void mo28348a(Surface surface) {
    }

    /* renamed from: a */
    public final void mo28253a(zzgv zzgv) {
        this.f21918a.m26571b("DecoderInitializationError", zzgv.getMessage());
    }

    /* renamed from: a */
    public final void mo28251a(CryptoException cryptoException) {
        this.f21918a.m26571b("CryptoError", cryptoException.getMessage());
    }

    /* renamed from: a */
    public final void mo28256a(String str, long j, long j2) {
    }
}
