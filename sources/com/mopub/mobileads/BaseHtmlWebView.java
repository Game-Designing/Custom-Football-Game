package com.mopub.mobileads;

import android.content.Context;
import android.view.View;
import android.webkit.WebSettings;
import com.mopub.common.AdReport;
import com.mopub.common.Constants;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.network.Networking;

public class BaseHtmlWebView extends BaseWebView {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final ViewGestureDetector f34700c;

    public BaseHtmlWebView(Context context, AdReport adReport) {
        super(context);
        m37289c();
        getSettings().setJavaScriptEnabled(true);
        this.f34700c = new ViewGestureDetector(context, (View) this, adReport);
        enablePlugins(true);
        setBackgroundColor(0);
    }

    public void init() {
        mo36916b();
    }

    public void loadUrl(String url) {
        if (url != null) {
            if (url.startsWith("javascript:")) {
                super.loadUrl(url);
                return;
            }
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Loading url: ");
            sb.append(url);
            MoPubLog.log(sdkLogEvent, sb.toString());
        }
    }

    public void stopLoading() {
        if (this.f34706b) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append(BaseHtmlWebView.class.getSimpleName());
            sb.append("#stopLoading() called after destroy()");
            MoPubLog.log(sdkLogEvent, sb.toString());
            return;
        }
        WebSettings webSettings = getSettings();
        if (webSettings == null) {
            SdkLogEvent sdkLogEvent2 = SdkLogEvent.CUSTOM;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(BaseHtmlWebView.class.getSimpleName());
            sb2.append("#getSettings() returned null");
            MoPubLog.log(sdkLogEvent2, sb2.toString());
            return;
        }
        webSettings.setJavaScriptEnabled(false);
        super.stopLoading();
        webSettings.setJavaScriptEnabled(true);
    }

    /* renamed from: c */
    private void m37289c() {
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36915a(String htmlResponse) {
        StringBuilder sb = new StringBuilder();
        sb.append(Networking.getBaseUrlScheme());
        sb.append("://");
        sb.append(Constants.HOST);
        sb.append("/");
        loadDataWithBaseURL(sb.toString(), htmlResponse, "text/html", "utf-8", null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo36916b() {
        setOnTouchListener(new C11451t(this));
    }

    public void onResetUserClick() {
        ViewGestureDetector gestureDetector = this.f34700c;
        if (gestureDetector != null) {
            gestureDetector.onResetUserClick();
        }
    }

    public boolean wasClicked() {
        ViewGestureDetector gestureDetector = this.f34700c;
        return gestureDetector != null && gestureDetector.isClicked();
    }
}
