package com.mopub.mobileads;

import android.webkit.WebView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mraid.MraidController;
import com.mopub.mraid.MraidWebViewClient;

/* renamed from: com.mopub.mobileads.na */
/* compiled from: MraidActivity */
class C11428na extends MraidWebViewClient {

    /* renamed from: b */
    final /* synthetic */ CustomEventInterstitialListener f35319b;

    /* renamed from: c */
    final /* synthetic */ MraidController f35320c;

    /* renamed from: d */
    final /* synthetic */ BaseWebView f35321d;

    C11428na(CustomEventInterstitialListener customEventInterstitialListener, MraidController mraidController, BaseWebView baseWebView) {
        this.f35319b = customEventInterstitialListener;
        this.f35320c = mraidController;
        this.f35321d = baseWebView;
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if ("mopub://failLoad".equals(url)) {
            MoPubLog.log(AdLogEvent.LOAD_FAILED, Integer.valueOf(MoPubErrorCode.VIDEO_CACHE_ERROR.getIntCode()), MoPubErrorCode.VIDEO_CACHE_ERROR);
            this.f35319b.onInterstitialFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
        }
        return true;
    }

    public void onPageFinished(WebView view, String url) {
        MoPubLog.log(AdLogEvent.LOAD_SUCCESS, new Object[0]);
        this.f35319b.onInterstitialLoaded();
        this.f35320c.onPreloadFinished(this.f35321d);
    }

    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        MoPubLog.log(AdLogEvent.LOAD_FAILED, Integer.valueOf(MoPubErrorCode.VIDEO_CACHE_ERROR.getIntCode()), MoPubErrorCode.VIDEO_CACHE_ERROR);
        this.f35319b.onInterstitialFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
    }
}
