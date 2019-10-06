package com.mopub.mobileads;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mopub.common.ExternalViewabilitySession.VideoEvent;
import com.mopub.common.IntentActions;

/* renamed from: com.mopub.mobileads.Pa */
/* compiled from: VastVideoViewController */
class C11340Pa implements OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ Activity f34891a;

    /* renamed from: b */
    final /* synthetic */ VastVideoViewController f34892b;

    C11340Pa(VastVideoViewController this$0, Activity activity) {
        this.f34892b = this$0;
        this.f34891a = activity;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.f34892b.m37637q()) {
            this.f34892b.f35083g.recordVideoEvent(VideoEvent.AD_CLICK_THRU, this.f34892b.mo37366i());
            this.f34892b.f35080I = true;
            this.f34892b.mo36927a(IntentActions.ACTION_INTERSTITIAL_CLICK);
            this.f34892b.f35081e.handleClickForResult(this.f34891a, this.f34892b.f35074C ? this.f34892b.f35079H : this.f34892b.mo37366i(), 1);
        }
        return true;
    }
}
