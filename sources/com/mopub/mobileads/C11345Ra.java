package com.mopub.mobileads;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

/* renamed from: com.mopub.mobileads.Ra */
/* compiled from: VastVideoViewController */
class C11345Ra implements OnPreparedListener {

    /* renamed from: a */
    final /* synthetic */ VastVideoView f34908a;

    /* renamed from: b */
    final /* synthetic */ VastVideoViewController f34909b;

    C11345Ra(VastVideoViewController this$0, VastVideoView vastVideoView) {
        this.f34909b = this$0;
        this.f34908a = vastVideoView;
    }

    public void onPrepared(MediaPlayer mp) {
        VastVideoViewController vastVideoViewController = this.f34909b;
        vastVideoViewController.f35079H = vastVideoViewController.f35082f.getDuration();
        this.f34909b.f35083g.onVideoPrepared(this.f34909b.getLayout(), this.f34909b.f35079H);
        this.f34909b.m37634p();
        if (this.f34909b.f35091o == null || this.f34909b.f35078G) {
            this.f34908a.prepareBlurredLastVideoFrame(this.f34909b.f35086j, this.f34909b.f35081e.getDiskMediaFileUrl());
        }
        this.f34909b.f35087k.calibrateAndMakeVisible(this.f34909b.mo37367j(), this.f34909b.f35102z);
        this.f34909b.f35088l.calibrateAndMakeVisible(this.f34909b.f35102z);
        this.f34909b.f35077F = true;
    }
}
