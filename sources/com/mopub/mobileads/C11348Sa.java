package com.mopub.mobileads;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.ImageView.ScaleType;
import com.mopub.common.ExternalViewabilitySession.VideoEvent;
import com.mopub.common.IntentActions;

/* renamed from: com.mopub.mobileads.Sa */
/* compiled from: VastVideoViewController */
class C11348Sa implements OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ VastVideoView f34937a;

    /* renamed from: b */
    final /* synthetic */ Context f34938b;

    /* renamed from: c */
    final /* synthetic */ VastVideoViewController f34939c;

    C11348Sa(VastVideoViewController this$0, VastVideoView vastVideoView, Context context) {
        this.f34939c = this$0;
        this.f34937a = vastVideoView;
        this.f34938b = context;
    }

    public void onCompletion(MediaPlayer mp) {
        this.f34939c.m37641s();
        this.f34939c.mo37369l();
        this.f34939c.mo36928a(false);
        this.f34939c.f35074C = true;
        if (this.f34939c.f35081e.isRewardedVideo()) {
            this.f34939c.mo36927a(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
        }
        if (!this.f34939c.f35075D && this.f34939c.f35081e.getRemainingProgressTrackerCount() == 0) {
            this.f34939c.f35083g.recordVideoEvent(VideoEvent.AD_COMPLETE, this.f34939c.mo37366i());
            this.f34939c.f35081e.handleComplete(this.f34939c.mo36929b(), this.f34939c.mo37366i());
        }
        this.f34937a.setVisibility(4);
        this.f34939c.f35087k.setVisibility(8);
        if (!this.f34939c.f35078G) {
            this.f34939c.f35098v.setVisibility(8);
        } else if (this.f34939c.f35086j.getDrawable() != null) {
            this.f34939c.f35086j.setScaleType(ScaleType.CENTER_CROP);
            this.f34939c.f35086j.setVisibility(0);
        }
        this.f34939c.f35084h.mo37343a();
        this.f34939c.f35085i.mo37343a();
        this.f34939c.f35089m.mo37336a();
        if (this.f34939c.f35091o != null) {
            if (this.f34938b.getResources().getConfiguration().orientation == 1) {
                this.f34939c.f35094r.setVisibility(0);
            } else {
                this.f34939c.f35093q.setVisibility(0);
            }
            this.f34939c.f35091o.mo37209a(this.f34938b, this.f34939c.f35079H);
        } else if (this.f34939c.f35086j.getDrawable() != null) {
            this.f34939c.f35086j.setVisibility(0);
        }
    }
}
