package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

@TargetApi(21)
/* renamed from: com.google.android.gms.internal.ads.Tq */
final class C9158Tq implements C9112Rq {

    /* renamed from: a */
    private final int f21784a;

    /* renamed from: b */
    private MediaCodecInfo[] f21785b;

    public C9158Tq(boolean z) {
        this.f21784a = z ? 1 : 0;
    }

    /* renamed from: a */
    public final int mo28574a() {
        m23099c();
        return this.f21785b.length;
    }

    /* renamed from: a */
    public final MediaCodecInfo mo28575a(int i) {
        m23099c();
        return this.f21785b[i];
    }

    /* renamed from: b */
    public final boolean mo28577b() {
        return true;
    }

    /* renamed from: a */
    public final boolean mo28576a(String str, CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    /* renamed from: c */
    private final void m23099c() {
        if (this.f21785b == null) {
            this.f21785b = new MediaCodecList(this.f21784a).getCodecInfos();
        }
    }
}
