package com.mopub.mobileads;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.mopub.common.ExternalViewabilitySession.VideoEvent;

/* renamed from: com.mopub.mobileads.Ta */
/* compiled from: VastVideoViewController */
class C11350Ta implements OnErrorListener {

    /* renamed from: a */
    final /* synthetic */ VastVideoViewController f34941a;

    C11350Ta(VastVideoViewController this$0) {
        this.f34941a = this$0;
    }

    public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
        this.f34941a.f35083g.recordVideoEvent(VideoEvent.RECORD_AD_ERROR, this.f34941a.mo37366i());
        this.f34941a.m37641s();
        this.f34941a.mo37369l();
        this.f34941a.mo36930b(false);
        this.f34941a.f35075D = true;
        this.f34941a.f35081e.handleError(this.f34941a.mo36929b(), VastErrorCode.GENERAL_LINEAR_AD_ERROR, this.f34941a.mo37366i());
        return false;
    }
}
