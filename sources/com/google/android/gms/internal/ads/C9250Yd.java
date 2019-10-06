package com.google.android.gms.internal.ads;

import android.media.MediaCodec.CryptoException;

/* renamed from: com.google.android.gms.internal.ads.Yd */
final class C9250Yd implements zzgq {

    /* renamed from: a */
    private final /* synthetic */ zzbdq f21942a;

    C9250Yd(zzbdq zzbdq) {
        this.f21942a = zzbdq;
    }

    /* renamed from: a */
    public final void mo28254a(zzhu zzhu) {
        this.f21942a.m26571b("AudioTrackInitializationError", zzhu.getMessage());
    }

    /* renamed from: a */
    public final void mo28255a(zzhv zzhv) {
        this.f21942a.m26571b("AudioTrackWriteError", zzhv.getMessage());
    }

    /* renamed from: a */
    public final void mo28253a(zzgv zzgv) {
        this.f21942a.m26571b("DecoderInitializationError", zzgv.getMessage());
    }

    /* renamed from: a */
    public final void mo28251a(CryptoException cryptoException) {
        this.f21942a.m26571b("CryptoError", cryptoException.getMessage());
    }

    /* renamed from: a */
    public final void mo28256a(String str, long j, long j2) {
    }
}
