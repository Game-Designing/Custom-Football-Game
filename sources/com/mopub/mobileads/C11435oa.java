package com.mopub.mobileads;

import android.view.View;
import com.mopub.common.IntentActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.common.util.JavaScriptWebViewCallbacks;
import com.mopub.mraid.MraidController.MraidListener;

/* renamed from: com.mopub.mobileads.oa */
/* compiled from: MraidActivity */
class C11435oa implements MraidListener {

    /* renamed from: a */
    final /* synthetic */ MraidActivity f35348a;

    C11435oa(MraidActivity this$0) {
        this.f35348a = this$0;
    }

    public void onLoaded(View view) {
        this.f35348a.f34879d.loadJavascript(JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getJavascript());
    }

    public void onFailedToLoad() {
        MoPubLog.log(AdLogEvent.CUSTOM, "MraidActivity failed to load. Finishing the activity");
        if (this.f35348a.mo37562a() != null) {
            MraidActivity mraidActivity = this.f35348a;
            BaseBroadcastReceiver.broadcastAction(mraidActivity, mraidActivity.mo37562a().longValue(), IntentActions.ACTION_INTERSTITIAL_FAIL);
        }
        this.f35348a.finish();
    }

    public void onRenderProcessGone(MoPubErrorCode errorCode) {
        AdLogEvent adLogEvent = AdLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("Finishing the activity due to a problem: ");
        sb.append(errorCode);
        MoPubLog.log(adLogEvent, sb.toString());
        this.f35348a.finish();
    }

    public void onClose() {
        MoPubLog.log(AdLogEvent.WILL_DISAPPEAR, new Object[0]);
        this.f35348a.f34879d.loadJavascript(JavaScriptWebViewCallbacks.WEB_VIEW_DID_CLOSE.getJavascript());
        this.f35348a.finish();
    }

    public void onExpand() {
    }

    public void onResize(boolean toOriginalSize) {
    }

    public void onOpen() {
        MoPubLog.log(AdLogEvent.DID_APPEAR, new Object[0]);
        if (this.f35348a.mo37562a() != null) {
            MraidActivity mraidActivity = this.f35348a;
            BaseBroadcastReceiver.broadcastAction(mraidActivity, mraidActivity.mo37562a().longValue(), IntentActions.ACTION_INTERSTITIAL_CLICK);
        }
    }
}
