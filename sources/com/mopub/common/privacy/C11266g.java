package com.mopub.common.privacy;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.mobileads.MoPubErrorCode;

/* renamed from: com.mopub.common.privacy.g */
/* compiled from: ConsentDialogLayout */
class C11266g extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ C11267h f34535a;

    C11266g(C11267h this$0) {
        this.f34535a = this$0;
    }

    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        if (this.f34535a.f34538q != null) {
            this.f34535a.f34538q.onLoadProgress(0);
        }
    }

    public void onPageFinished(WebView view, String url) {
        if (this.f34535a.f34538q != null) {
            this.f34535a.f34538q.onLoadProgress(C11267h.f34536o);
        }
        super.onPageFinished(view, url);
    }

    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
        Object[] objArr = new Object[1];
        objArr[0] = (detail == null || !detail.didCrash()) ? MoPubErrorCode.RENDER_PROCESS_GONE_UNSPECIFIED : MoPubErrorCode.RENDER_PROCESS_GONE_WITH_CRASH;
        MoPubLog.log(sdkLogEvent, objArr);
        return true;
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if ("mopub://consent?yes".equals(url)) {
            if (this.f34535a.f34539r != null) {
                this.f34535a.f34539r.onConsentClick(ConsentStatus.EXPLICIT_YES);
            }
            return true;
        } else if ("mopub://consent?no".equals(url)) {
            if (this.f34535a.f34539r != null) {
                this.f34535a.f34539r.onConsentClick(ConsentStatus.EXPLICIT_NO);
            }
            return true;
        } else if ("mopub://close".equals(url)) {
            if (this.f34535a.f34539r != null) {
                this.f34535a.f34539r.onCloseClick();
            }
            return true;
        } else {
            if (!TextUtils.isEmpty(url)) {
                try {
                    Context context = this.f34535a.getContext();
                    Uri parse = Uri.parse(url);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Cannot open native browser for ");
                    sb.append(url);
                    Intents.launchActionViewIntent(context, parse, sb.toString());
                    return true;
                } catch (IntentNotResolvableException e) {
                    MoPubLog.log(SdkLogEvent.CUSTOM, e.getMessage());
                }
            }
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}
