package com.mopub.mobileads;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.Builder;
import java.util.EnumSet;

/* renamed from: com.mopub.mobileads.G */
/* compiled from: HtmlWebViewClient */
class C11310G extends WebViewClient {

    /* renamed from: a */
    private final EnumSet<UrlAction> f34747a = EnumSet.of(UrlAction.HANDLE_MOPUB_SCHEME, new UrlAction[]{UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.HANDLE_PHONE_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK});

    /* renamed from: b */
    private final Context f34748b;

    /* renamed from: c */
    private final String f34749c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final HtmlWebViewListener f34750d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final BaseHtmlWebView f34751e;

    /* renamed from: f */
    private final String f34752f;

    C11310G(HtmlWebViewListener htmlWebViewListener, BaseHtmlWebView htmlWebView, String clickthrough, String dspCreativeId) {
        this.f34750d = htmlWebViewListener;
        this.f34751e = htmlWebView;
        this.f34752f = clickthrough;
        this.f34749c = dspCreativeId;
        this.f34748b = htmlWebView.getContext();
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        new Builder().withDspCreativeId(this.f34749c).withSupportedUrlActions(this.f34747a).withResultActions(new C11308F(this)).withMoPubSchemeListener(new C11306E(this)).build().handleUrl(this.f34748b, url, this.f34751e.wasClicked());
        return true;
    }
}
