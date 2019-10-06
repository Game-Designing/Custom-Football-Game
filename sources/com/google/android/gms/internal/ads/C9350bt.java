package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;
import android.os.Handler;

@TargetApi(23)
/* renamed from: com.google.android.gms.internal.ads.bt */
final class C9350bt implements OnFrameRenderedListener {

    /* renamed from: a */
    private final /* synthetic */ zzth f22143a;

    private C9350bt(zzth zzth, MediaCodec mediaCodec) {
        this.f22143a = zzth;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        zzth zzth = this.f22143a;
        if (this == zzth.f29403za) {
            zzth.mo32232y();
        }
    }
}
