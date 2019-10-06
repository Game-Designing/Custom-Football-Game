package com.mopub.common;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Drawables;
import com.mopub.mobileads.MoPubErrorCode;
import java.util.EnumSet;

/* renamed from: com.mopub.common.e */
/* compiled from: BrowserWebViewClient */
class C11244e extends WebViewClient {

    /* renamed from: a */
    private static final EnumSet<UrlAction> f34398a = EnumSet.of(UrlAction.HANDLE_PHONE_SCHEME, new UrlAction[]{UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK});
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MoPubBrowser f34399b;

    public C11244e(MoPubBrowser moPubBrowser) {
        this.f34399b = moPubBrowser;
    }

    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("MoPubBrowser error: ");
        sb.append(description);
        MoPubLog.log(sdkLogEvent, sb.toString());
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        return new Builder().withSupportedUrlActions(f34398a).withoutMoPubBrowser().withResultActions(new C11243d(this)).build().handleResolvedUrl(this.f34399b.getApplicationContext(), url, true, null);
    }

    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }

    public void onPageFinished(WebView view, String url) {
        Drawable backImageDrawable;
        Drawable forwardImageDrawable;
        super.onPageFinished(view, url);
        if (view.canGoBack()) {
            backImageDrawable = Drawables.LEFT_ARROW.createDrawable(this.f34399b);
        } else {
            backImageDrawable = Drawables.UNLEFT_ARROW.createDrawable(this.f34399b);
        }
        this.f34399b.getBackButton().setImageDrawable(backImageDrawable);
        if (view.canGoForward()) {
            forwardImageDrawable = Drawables.RIGHT_ARROW.createDrawable(this.f34399b);
        } else {
            forwardImageDrawable = Drawables.UNRIGHT_ARROW.createDrawable(this.f34399b);
        }
        this.f34399b.getForwardButton().setImageDrawable(forwardImageDrawable);
    }

    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
        Object[] objArr = new Object[1];
        objArr[0] = (detail == null || !detail.didCrash()) ? MoPubErrorCode.RENDER_PROCESS_GONE_UNSPECIFIED : MoPubErrorCode.RENDER_PROCESS_GONE_WITH_CRASH;
        MoPubLog.log(sdkLogEvent, objArr);
        this.f34399b.finish();
        return true;
    }
}
