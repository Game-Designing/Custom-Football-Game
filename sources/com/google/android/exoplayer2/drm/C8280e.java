package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.drm.e */
/* compiled from: FrameworkMediaCrypto */
public final class C8280e implements C8279d {

    /* renamed from: a */
    private final MediaCrypto f17546a;

    /* renamed from: b */
    private final boolean f17547b;

    /* renamed from: a */
    public MediaCrypto mo25409a() {
        return this.f17546a;
    }

    /* renamed from: a */
    public boolean mo25410a(String mimeType) {
        return !this.f17547b && this.f17546a.requiresSecureDecoderComponent(mimeType);
    }
}
