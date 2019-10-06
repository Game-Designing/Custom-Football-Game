package com.mopub.mobileads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Views;
import com.mopub.mobileads.util.WebViews;

public class BaseWebView extends WebView {

    /* renamed from: a */
    private static boolean f34705a = false;

    /* renamed from: b */
    protected boolean f34706b;

    public BaseWebView(Context context) {
        super(context.getApplicationContext());
        enablePlugins(false);
        mo36916b();
        WebViews.setDisableJSChromeClient(this);
        if (!f34705a) {
            m37309a(getContext());
            f34705a = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        WebViews.manageThirdPartyCookies(this);
    }

    public void destroy() {
        if (!this.f34706b) {
            this.f34706b = true;
            Views.removeFromParent(this);
            removeAllViews();
            super.destroy();
        }
    }

    public void enablePlugins(boolean enabled) {
        if (VERSION.SDK_INT < 18) {
            if (enabled) {
                getSettings().setPluginState(PluginState.ON);
            } else {
                getSettings().setPluginState(PluginState.OFF);
            }
        }
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: a */
    public void mo36943a() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setAppCacheEnabled(true);
        getSettings().setAppCachePath(getContext().getCacheDir().getAbsolutePath());
    }

    /* renamed from: b */
    private void mo36916b() {
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowContentAccess(false);
        getSettings().setAllowFileAccessFromFileURLs(false);
        getSettings().setAllowUniversalAccessFromFileURLs(false);
    }

    /* renamed from: a */
    private void m37309a(Context context) {
        if (VERSION.SDK_INT == 19) {
            WebView webView = new WebView(context.getApplicationContext());
            webView.setBackgroundColor(0);
            webView.loadDataWithBaseURL(null, "", "text/html", "UTF-8", null);
            LayoutParams params = new LayoutParams();
            params.width = 1;
            params.height = 1;
            params.type = 2005;
            params.flags = 16777240;
            params.format = -2;
            params.gravity = 8388659;
            ((WindowManager) context.getSystemService("window")).addView(webView, params);
        }
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    @VisibleForTesting
    public void setIsDestroyed(boolean isDestroyed) {
        this.f34706b = isDestroyed;
    }
}
