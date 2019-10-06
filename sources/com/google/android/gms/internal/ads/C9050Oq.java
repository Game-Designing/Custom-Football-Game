package com.google.android.gms.internal.ads;

import android.media.MediaCodec.CryptoException;

/* renamed from: com.google.android.gms.internal.ads.Oq */
final class C9050Oq implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ CryptoException f21556a;

    /* renamed from: b */
    private final /* synthetic */ zzgr f21557b;

    C9050Oq(zzgr zzgr, CryptoException cryptoException) {
        this.f21557b = zzgr;
        this.f21556a = cryptoException;
    }

    public final void run() {
        this.f21557b.f28466j.mo28251a(this.f21556a);
    }
}
