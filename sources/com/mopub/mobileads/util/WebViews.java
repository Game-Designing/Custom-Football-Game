package com.mopub.mobileads.util;

import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;

public class WebViews {
    public static void onPause(WebView webView, boolean isFinishing) {
        if (isFinishing) {
            webView.stopLoading();
            webView.loadUrl("");
        }
        webView.onPause();
    }

    public static void setDisableJSChromeClient(WebView webView) {
        webView.setWebChromeClient(new C11455a());
    }

    public static void manageWebCookies() {
        CookieManager cookieManager = CookieManager.getInstance();
        if (MoPub.canCollectPersonalInformation()) {
            cookieManager.setAcceptCookie(true);
            CookieManager.setAcceptFileSchemeCookies(true);
            return;
        }
        cookieManager.setAcceptCookie(false);
        CookieManager.setAcceptFileSchemeCookies(false);
        if (VERSION.SDK_INT >= 21) {
            cookieManager.removeSessionCookies(null);
            cookieManager.removeAllCookies(null);
            cookieManager.flush();
        } else {
            cookieManager.removeSessionCookie();
            cookieManager.removeAllCookie();
        }
    }

    public static void manageThirdPartyCookies(WebView webView) {
        Preconditions.checkNotNull(webView);
        CookieManager cookieManager = CookieManager.getInstance();
        if (VERSION.SDK_INT >= 21) {
            cookieManager.setAcceptThirdPartyCookies(webView, MoPub.canCollectPersonalInformation());
        }
    }
}
