package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

/* renamed from: com.google.android.gms.internal.ads.Sq */
final class C9137Sq implements C9112Rq {
    private C9137Sq() {
    }

    /* renamed from: a */
    public final int mo28574a() {
        return MediaCodecList.getCodecCount();
    }

    /* renamed from: a */
    public final MediaCodecInfo mo28575a(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    /* renamed from: b */
    public final boolean mo28577b() {
        return false;
    }

    /* renamed from: a */
    public final boolean mo28576a(String str, CodecCapabilities codecCapabilities) {
        return "video/avc".equals(str);
    }
}
