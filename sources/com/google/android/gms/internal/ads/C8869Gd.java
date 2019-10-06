package com.google.android.gms.internal.ads;

import android.media.MediaCodec.CryptoException;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.ads.Gd */
final class C8869Gd implements zzgq {

    /* renamed from: a */
    private WeakReference<zzgq> f20887a;

    /* renamed from: b */
    private final /* synthetic */ zzbdk f20888b;

    private C8869Gd(zzbdk zzbdk) {
        this.f20888b = zzbdk;
        this.f20887a = new WeakReference<>(null);
    }

    /* renamed from: a */
    public final void mo28252a(zzgq zzgq) {
        this.f20887a = new WeakReference<>(zzgq);
    }

    /* renamed from: a */
    public final void mo28254a(zzhu zzhu) {
        this.f20888b.m26549a("AudioTrackInitializationError", zzhu.getMessage());
        zzgq zzgq = (zzgq) this.f20887a.get();
        if (zzgq != null) {
            zzgq.mo28254a(zzhu);
        }
    }

    /* renamed from: a */
    public final void mo28255a(zzhv zzhv) {
        this.f20888b.m26549a("AudioTrackWriteError", zzhv.getMessage());
        zzgq zzgq = (zzgq) this.f20887a.get();
        if (zzgq != null) {
            zzgq.mo28255a(zzhv);
        }
    }

    /* renamed from: a */
    public final void mo28253a(zzgv zzgv) {
        this.f20888b.m26549a("DecoderInitializationError", zzgv.getMessage());
        zzgq zzgq = (zzgq) this.f20887a.get();
        if (zzgq != null) {
            zzgq.mo28253a(zzgv);
        }
    }

    /* renamed from: a */
    public final void mo28251a(CryptoException cryptoException) {
        this.f20888b.m26549a("CryptoError", cryptoException.getMessage());
        zzgq zzgq = (zzgq) this.f20887a.get();
        if (zzgq != null) {
            zzgq.mo28251a(cryptoException);
        }
    }

    /* renamed from: a */
    public final void mo28256a(String str, long j, long j2) {
        zzgq zzgq = (zzgq) this.f20887a.get();
        if (zzgq != null) {
            zzgq.mo28256a(str, j, j2);
        }
    }
}
