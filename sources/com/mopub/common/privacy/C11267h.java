package com.mopub.common.privacy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout.LayoutParams;
import com.mopub.common.CloseableLayout;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;

/* renamed from: com.mopub.common.privacy.h */
/* compiled from: ConsentDialogLayout */
class C11267h extends CloseableLayout {

    /* renamed from: o */
    static int f34536o = 101;

    /* renamed from: p */
    private final WebView f34537p = m37148d();
    /* access modifiers changed from: private */

    /* renamed from: q */
    public C11269b f34538q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public C11268a f34539r;

    /* renamed from: s */
    private final WebViewClient f34540s = new C11266g(this);

    /* renamed from: com.mopub.common.privacy.h$a */
    /* compiled from: ConsentDialogLayout */
    interface C11268a {
        void onCloseClick();

        void onConsentClick(ConsentStatus consentStatus);
    }

    /* renamed from: com.mopub.common.privacy.h$b */
    /* compiled from: ConsentDialogLayout */
    interface C11269b {
        void onLoadProgress(int i);
    }

    public C11267h(Context context) {
        super(context);
    }

    public C11267h(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public C11267h(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36777a(String htmlData, C11269b listener) {
        Preconditions.checkNotNull(htmlData);
        this.f34538q = listener;
        m37146a(this.f34537p);
        WebView webView = this.f34537p;
        StringBuilder sb = new StringBuilder();
        sb.append("https://");
        sb.append(Constants.HOST);
        sb.append("/");
        webView.loadDataWithBaseURL(sb.toString(), htmlData, "text/html", "UTF-8", null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36776a(C11268a consentListener) {
        Preconditions.checkNotNull(consentListener);
        this.f34539r = consentListener;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: d */
    private WebView m37148d() {
        WebView webView = new WebView(getContext());
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        WebSettings webSettings = webView.getSettings();
        webSettings.setSupportZoom(false);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setAppCachePath(getContext().getCacheDir().getAbsolutePath());
        webSettings.setAllowFileAccess(false);
        webSettings.setAllowContentAccess(false);
        if (VERSION.SDK_INT >= 16) {
            webSettings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (VERSION.SDK_INT >= 17) {
            webView.setId(View.generateViewId());
        }
        setCloseVisible(false);
        addView(webView, new LayoutParams(-1, -1));
        return webView;
    }

    /* renamed from: a */
    private void m37146a(WebView webView) {
        webView.setWebViewClient(this.f34540s);
        setOnCloseListener(new C11265f(this));
    }
}
