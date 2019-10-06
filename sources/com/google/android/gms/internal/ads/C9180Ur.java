package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;

@TargetApi(24)
/* renamed from: com.google.android.gms.internal.ads.Ur */
final class C9180Ur {

    /* renamed from: a */
    private final CryptoInfo f21826a;

    /* renamed from: b */
    private final Pattern f21827b;

    private C9180Ur(CryptoInfo cryptoInfo) {
        this.f21826a = cryptoInfo;
        this.f21827b = new Pattern(0, 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m23130a(int i, int i2) {
        this.f21827b.set(i, i2);
        this.f21826a.setPattern(this.f21827b);
    }
}
