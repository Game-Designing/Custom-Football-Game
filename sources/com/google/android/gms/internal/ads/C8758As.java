package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

/* renamed from: com.google.android.gms.internal.ads.As */
final class C8758As implements C9867zs {
    private C8758As() {
    }

    /* renamed from: a */
    public final int mo28051a() {
        return MediaCodecList.getCodecCount();
    }

    /* renamed from: a */
    public final MediaCodecInfo mo28052a(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    /* renamed from: b */
    public final boolean mo28054b() {
        return false;
    }

    /* renamed from: a */
    public final boolean mo28053a(String str, CodecCapabilities codecCapabilities) {
        return "video/avc".equals(str);
    }
}
