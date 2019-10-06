package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;

public class HtmlBannerWebView extends BaseHtmlWebView {
    public static final String EXTRA_AD_CLICK_DATA = "com.mopub.intent.extra.AD_CLICK_DATA";

    /* renamed from: com.mopub.mobileads.HtmlBannerWebView$a */
    static class C11316a implements HtmlWebViewListener {

        /* renamed from: a */
        private final CustomEventBannerListener f34787a;

        public C11316a(CustomEventBannerListener customEventBannerListener) {
            this.f34787a = customEventBannerListener;
        }

        public void onLoaded(BaseHtmlWebView htmlWebView) {
            this.f34787a.onBannerLoaded(htmlWebView);
        }

        public void onFailed(MoPubErrorCode errorCode) {
            this.f34787a.onBannerFailed(errorCode);
        }

        public void onClicked() {
            this.f34787a.onBannerClicked();
        }

        public void onCollapsed() {
            this.f34787a.onBannerCollapsed();
        }
    }

    public HtmlBannerWebView(Context context, AdReport adReport) {
        super(context, adReport);
    }

    public void init(CustomEventBannerListener customEventBannerListener, String clickthroughUrl, String dspCreativeId) {
        super.init();
        setWebViewClient(new C11310G(new C11316a(customEventBannerListener), this, clickthroughUrl, dspCreativeId));
    }
}
