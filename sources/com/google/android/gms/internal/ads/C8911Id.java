package com.google.android.gms.internal.ads;

import android.media.MediaCodec.CryptoException;
import android.view.Surface;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.ads.Id */
final class C8911Id implements zzhh {

    /* renamed from: a */
    private WeakReference<zzhh> f21242a;

    /* renamed from: b */
    private final /* synthetic */ zzbdk f21243b;

    private C8911Id(zzbdk zzbdk) {
        this.f21243b = zzbdk;
        this.f21242a = new WeakReference<>(null);
    }

    /* renamed from: a */
    public final void mo28349a(zzhh zzhh) {
        this.f21242a = new WeakReference<>(zzhh);
    }

    /* renamed from: a */
    public final void mo28347a(int i, long j) {
        zzhh zzhh = (zzhh) this.f21242a.get();
        if (zzhh != null) {
            zzhh.mo28347a(i, j);
        }
    }

    /* renamed from: a */
    public final void mo28346a(int i, int i2, float f) {
        zzhh zzhh = (zzhh) this.f21242a.get();
        if (zzhh != null) {
            zzhh.mo28346a(i, i2, f);
        }
    }

    /* renamed from: a */
    public final void mo28348a(Surface surface) {
        zzhh zzhh = (zzhh) this.f21242a.get();
        if (zzhh != null) {
            zzhh.mo28348a(surface);
        }
    }

    /* renamed from: a */
    public final void mo28253a(zzgv zzgv) {
        this.f21243b.m26549a("DecoderInitializationError", zzgv.getMessage());
        zzhh zzhh = (zzhh) this.f21242a.get();
        if (zzhh != null) {
            zzhh.mo28253a(zzgv);
        }
    }

    /* renamed from: a */
    public final void mo28251a(CryptoException cryptoException) {
        this.f21243b.m26549a("CryptoError", cryptoException.getMessage());
        zzhh zzhh = (zzhh) this.f21242a.get();
        if (zzhh != null) {
            zzhh.mo28251a(cryptoException);
        }
    }

    /* renamed from: a */
    public final void mo28256a(String str, long j, long j2) {
        zzhh zzhh = (zzhh) this.f21242a.get();
        if (zzhh != null) {
            zzhh.mo28256a(str, j, j2);
        }
    }
}
