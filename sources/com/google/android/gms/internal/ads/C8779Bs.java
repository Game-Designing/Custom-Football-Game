package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

@TargetApi(21)
/* renamed from: com.google.android.gms.internal.ads.Bs */
final class C8779Bs implements C9867zs {

    /* renamed from: a */
    private final int f20526a;

    /* renamed from: b */
    private MediaCodecInfo[] f20527b;

    public C8779Bs(boolean z) {
        this.f20526a = z ? 1 : 0;
    }

    /* renamed from: a */
    public final int mo28051a() {
        m22323c();
        return this.f20527b.length;
    }

    /* renamed from: a */
    public final MediaCodecInfo mo28052a(int i) {
        m22323c();
        return this.f20527b[i];
    }

    /* renamed from: b */
    public final boolean mo28054b() {
        return true;
    }

    /* renamed from: a */
    public final boolean mo28053a(String str, CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    /* renamed from: c */
    private final void m22323c() {
        if (this.f20527b == null) {
            this.f20527b = new MediaCodecList(this.f20526a).getCodecInfos();
        }
    }
}
