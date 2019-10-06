package com.google.android.gms.internal.measurement;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

public abstract class zztq {

    /* renamed from: a */
    int f30252a;

    /* renamed from: b */
    private int f30253b;

    /* renamed from: c */
    private boolean f30254c;

    /* renamed from: a */
    static zztq m32402a(byte[] bArr, int i, int i2, boolean z) {
        C9930S s = new C9930S(bArr, i, i2, false);
        try {
            s.mo32618a(i2);
            return s;
        } catch (zzuv e) {
            throw new IllegalArgumentException(e);
        }
    }

    private zztq() {
        this.f30252a = 100;
        this.f30253b = MoPubClientPositioning.NO_REPEAT;
        this.f30254c = false;
    }
}
