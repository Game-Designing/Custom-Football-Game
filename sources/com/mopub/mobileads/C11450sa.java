package com.mopub.mobileads;

import android.view.View;
import com.mopub.common.IntentActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.JavaScriptWebViewCallbacks;
import com.mopub.mraid.MraidController.MraidListener;

/* renamed from: com.mopub.mobileads.sa */
/* compiled from: RewardedMraidActivity */
class C11450sa implements MraidListener {

    /* renamed from: a */
    final /* synthetic */ boolean f35417a;

    /* renamed from: b */
    final /* synthetic */ RewardedMraidActivity f35418b;

    C11450sa(RewardedMraidActivity this$0, boolean z) {
        this.f35418b = this$0;
        this.f35417a = z;
    }

    public void onLoaded(View view) {
        this.f35418b.f34921g.loadJavascript(JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getJavascript());
    }

    public void onFailedToLoad() {
        MoPubLog.log(SdkLogEvent.CUSTOM, "RewardedMraidActivity failed to load. Finishing the activity");
        RewardedMraidActivity rewardedMraidActivity = this.f35418b;
        BaseBroadcastReceiver.broadcastAction(rewardedMraidActivity, rewardedMraidActivity.mo37562a().longValue(), IntentActions.ACTION_INTERSTITIAL_FAIL);
        this.f35418b.finish();
    }

    public void onRenderProcessGone(MoPubErrorCode errorCode) {
        SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("Finishing the activity due to a problem: ");
        sb.append(errorCode);
        MoPubLog.log(sdkLogEvent, sb.toString());
        this.f35418b.finish();
    }

    public void onClose() {
        this.f35418b.f34921g.loadJavascript(JavaScriptWebViewCallbacks.WEB_VIEW_DID_CLOSE.getJavascript());
        this.f35418b.finish();
    }

    public void onExpand() {
    }

    public void onResize(boolean toOriginalSize) {
    }

    public void onOpen() {
        if (this.f35417a) {
            this.f35418b.f34921g.showPlayableCloseButton();
        }
        RewardedMraidActivity rewardedMraidActivity = this.f35418b;
        BaseBroadcastReceiver.broadcastAction(rewardedMraidActivity, rewardedMraidActivity.mo37562a().longValue(), IntentActions.ACTION_INTERSTITIAL_CLICK);
    }
}
