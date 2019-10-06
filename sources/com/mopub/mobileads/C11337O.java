package com.mopub.mobileads;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;

/* renamed from: com.mopub.mobileads.O */
/* compiled from: MoPubActivity */
class C11337O extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ CustomEventInterstitialListener f34888a;

    C11337O(CustomEventInterstitialListener customEventInterstitialListener) {
        this.f34888a = customEventInterstitialListener;
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if ("mopub://finishLoad".equals(url)) {
            this.f34888a.onInterstitialLoaded();
        } else if ("mopub://failLoad".equals(url)) {
            this.f34888a.onInterstitialFailed(null);
        }
        return true;
    }
}
