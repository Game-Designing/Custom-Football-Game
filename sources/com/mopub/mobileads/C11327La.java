package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.ResultActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;

/* renamed from: com.mopub.mobileads.La */
/* compiled from: VastVideoConfig */
class C11327La implements ResultActions {

    /* renamed from: a */
    final /* synthetic */ Context f34825a;

    /* renamed from: b */
    final /* synthetic */ Integer f34826b;

    /* renamed from: c */
    final /* synthetic */ VastVideoConfig f34827c;

    C11327La(VastVideoConfig this$0, Context context, Integer num) {
        this.f34827c = this$0;
        this.f34825a = context;
        this.f34826b = num;
    }

    public void urlHandlingSucceeded(String url, UrlAction urlAction) {
        String str = " not found. Did you declare it in your AndroidManifest.xml?";
        String str2 = "Activity ";
        if (urlAction == UrlAction.OPEN_IN_APP_BROWSER) {
            Bundle bundle = new Bundle();
            bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, url);
            bundle.putString(MoPubBrowser.DSP_CREATIVE_ID, this.f34827c.f35018B);
            Class clazz = MoPubBrowser.class;
            Intent intent = Intents.getStartActivityIntent(this.f34825a, clazz, bundle);
            try {
                if (this.f34825a instanceof Activity) {
                    Preconditions.checkNotNull(this.f34826b);
                    ((Activity) this.f34825a).startActivityForResult(intent, this.f34826b.intValue());
                    return;
                }
                Intents.startActivity(this.f34825a, intent);
            } catch (ActivityNotFoundException e) {
                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(clazz.getName());
                sb.append(str);
                MoPubLog.log(sdkLogEvent, sb.toString());
            } catch (IntentNotResolvableException e2) {
                SdkLogEvent sdkLogEvent2 = SdkLogEvent.CUSTOM;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append(clazz.getName());
                sb2.append(str);
                MoPubLog.log(sdkLogEvent2, sb2.toString());
            }
        }
    }

    public void urlHandlingFailed(String url, UrlAction lastFailedUrlAction) {
    }
}
