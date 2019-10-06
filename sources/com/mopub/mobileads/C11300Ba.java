package com.mopub.mobileads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.ResultActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;

/* renamed from: com.mopub.mobileads.Ba */
/* compiled from: VastIconConfig */
class C11300Ba implements ResultActions {

    /* renamed from: a */
    final /* synthetic */ String f34695a;

    /* renamed from: b */
    final /* synthetic */ Context f34696b;

    /* renamed from: c */
    final /* synthetic */ C11302Ca f34697c;

    C11300Ba(C11302Ca this$0, String str, Context context) {
        this.f34697c = this$0;
        this.f34695a = str;
        this.f34696b = context;
    }

    public void urlHandlingSucceeded(String url, UrlAction urlAction) {
        if (urlAction == UrlAction.OPEN_IN_APP_BROWSER) {
            Bundle bundle = new Bundle();
            bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, url);
            if (!TextUtils.isEmpty(this.f34695a)) {
                bundle.putString(MoPubBrowser.DSP_CREATIVE_ID, this.f34695a);
            }
            try {
                Intents.startActivity(this.f34696b, Intents.getStartActivityIntent(this.f34696b, MoPubBrowser.class, bundle));
            } catch (IntentNotResolvableException e) {
                MoPubLog.log(SdkLogEvent.CUSTOM, e.getMessage());
            }
        }
    }

    public void urlHandlingFailed(String url, UrlAction lastFailedUrlAction) {
    }
}
