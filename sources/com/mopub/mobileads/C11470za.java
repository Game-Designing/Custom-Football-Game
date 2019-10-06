package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.ResultActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Intents;

/* renamed from: com.mopub.mobileads.za */
/* compiled from: VastCompanionAdConfig */
class C11470za implements ResultActions {

    /* renamed from: a */
    final /* synthetic */ String f35454a;

    /* renamed from: b */
    final /* synthetic */ Context f35455b;

    /* renamed from: c */
    final /* synthetic */ int f35456c;

    /* renamed from: d */
    final /* synthetic */ VastCompanionAdConfig f35457d;

    C11470za(VastCompanionAdConfig this$0, String str, Context context, int i) {
        this.f35457d = this$0;
        this.f35454a = str;
        this.f35455b = context;
        this.f35456c = i;
    }

    public void urlHandlingSucceeded(String url, UrlAction urlAction) {
        if (urlAction == UrlAction.OPEN_IN_APP_BROWSER) {
            Bundle bundle = new Bundle();
            bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, url);
            if (!TextUtils.isEmpty(this.f35454a)) {
                bundle.putString(MoPubBrowser.DSP_CREATIVE_ID, this.f35454a);
            }
            Class clazz = MoPubBrowser.class;
            try {
                ((Activity) this.f35455b).startActivityForResult(Intents.getStartActivityIntent(this.f35455b, clazz, bundle), this.f35456c);
            } catch (ActivityNotFoundException e) {
                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("Activity ");
                sb.append(clazz.getName());
                sb.append(" not found. Did you declare it in your AndroidManifest.xml?");
                MoPubLog.log(sdkLogEvent, sb.toString());
            }
        }
    }

    public void urlHandlingFailed(String url, UrlAction lastFailedUrlAction) {
    }
}
