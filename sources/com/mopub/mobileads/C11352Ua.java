package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mopub.common.ExternalViewabilitySession.VideoEvent;

/* renamed from: com.mopub.mobileads.Ua */
/* compiled from: VastVideoViewController */
class C11352Ua implements OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ VastVideoViewController f34943a;

    C11352Ua(VastVideoViewController this$0) {
        this.f34943a = this$0;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int currentPosition;
        if (this.f34943a.f35074C) {
            currentPosition = this.f34943a.f35079H;
        } else {
            currentPosition = this.f34943a.mo37366i();
        }
        if (motionEvent.getAction() == 1) {
            this.f34943a.f35080I = true;
            if (!this.f34943a.f35074C) {
                this.f34943a.f35083g.recordVideoEvent(VideoEvent.AD_SKIPPED, this.f34943a.mo37366i());
            }
            this.f34943a.f35081e.handleClose(this.f34943a.mo36929b(), currentPosition);
            this.f34943a.mo36923a().onFinish();
        }
        return true;
    }
}
