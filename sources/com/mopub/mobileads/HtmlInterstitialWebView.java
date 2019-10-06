package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;

public class HtmlInterstitialWebView extends BaseHtmlWebView {

    /* renamed from: d */
    private Handler f34791d = new Handler();

    /* renamed from: com.mopub.mobileads.HtmlInterstitialWebView$a */
    static class C11317a implements HtmlWebViewListener {

        /* renamed from: a */
        private final CustomEventInterstitialListener f34792a;

        public C11317a(CustomEventInterstitialListener customEventInterstitialListener) {
            this.f34792a = customEventInterstitialListener;
        }

        public void onLoaded(BaseHtmlWebView mHtmlWebView) {
            this.f34792a.onInterstitialLoaded();
        }

        public void onFailed(MoPubErrorCode errorCode) {
            this.f34792a.onInterstitialFailed(errorCode);
        }

        public void onClicked() {
            this.f34792a.onInterstitialClicked();
        }

        public void onCollapsed() {
        }
    }

    public HtmlInterstitialWebView(Context context, AdReport adReport) {
        super(context, adReport);
    }

    public void init(CustomEventInterstitialListener customEventInterstitialListener, String clickthroughUrl, String dspCreativeId) {
        super.init();
        setWebViewClient(new C11310G(new C11317a(customEventInterstitialListener), this, clickthroughUrl, dspCreativeId));
    }
}
