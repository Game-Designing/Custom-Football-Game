package com.mopub.common;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.mopub.common.util.Drawables;
import com.mopub.mobileads.BaseWebView;
import com.mopub.mobileads.util.WebViews;

public class MoPubBrowser extends Activity {
    public static final String DESTINATION_URL_KEY = "URL";
    public static final String DSP_CREATIVE_ID = "mopub-dsp-creative-id";
    public static final int MOPUB_BROWSER_REQUEST_CODE = 1;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WebView f34341a;

    /* renamed from: b */
    private ImageButton f34342b;

    /* renamed from: c */
    private ImageButton f34343c;

    /* renamed from: d */
    private ImageButton f34344d;

    /* renamed from: e */
    private ImageButton f34345e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f34346f;

    public ImageButton getBackButton() {
        return this.f34342b;
    }

    public ImageButton getCloseButton() {
        return this.f34345e;
    }

    public ImageButton getForwardButton() {
        return this.f34343c;
    }

    public ImageButton getRefreshButton() {
        return this.f34344d;
    }

    public WebView getWebView() {
        return this.f34341a;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setResult(-1);
        this.f34346f = getWindow().requestFeature(2);
        if (this.f34346f) {
            getWindow().setFeatureInt(2, -1);
        }
        setContentView(m37027b());
        m37030d();
        m37029c();
        m37026a();
    }

    /* renamed from: d */
    private void m37030d() {
        WebSettings webSettings = this.f34341a.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);
        this.f34341a.loadUrl(getIntent().getStringExtra(DESTINATION_URL_KEY));
        this.f34341a.setWebViewClient(new C11244e(this));
    }

    /* renamed from: c */
    private void m37029c() {
        this.f34342b.setBackgroundColor(0);
        this.f34342b.setOnClickListener(new C11280q(this));
        this.f34343c.setBackgroundColor(0);
        this.f34343c.setOnClickListener(new C11281r(this));
        this.f34344d.setBackgroundColor(0);
        this.f34344d.setOnClickListener(new C11282s(this));
        this.f34345e.setBackgroundColor(0);
        this.f34345e.setOnClickListener(new C11283t(this));
    }

    /* renamed from: a */
    private void m37026a() {
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
        this.f34341a.setWebChromeClient(null);
        WebViews.onPause(this.f34341a, isFinishing());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
        this.f34341a.setWebChromeClient(new C11284u(this));
        this.f34341a.onResume();
    }

    public void finish() {
        ((ViewGroup) getWindow().getDecorView()).removeAllViews();
        super.finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f34341a.destroy();
        this.f34341a = null;
    }

    /* renamed from: b */
    private View m37027b() {
        LinearLayout moPubBrowserView = new LinearLayout(this);
        moPubBrowserView.setLayoutParams(new LayoutParams(-1, -1));
        moPubBrowserView.setOrientation(1);
        RelativeLayout outerLayout = new RelativeLayout(this);
        outerLayout.setLayoutParams(new LayoutParams(-1, -2));
        moPubBrowserView.addView(outerLayout);
        LinearLayout innerLayout = new LinearLayout(this);
        innerLayout.setId(1);
        RelativeLayout.LayoutParams innerLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        innerLayoutParams.addRule(12);
        innerLayout.setLayoutParams(innerLayoutParams);
        innerLayout.setBackgroundDrawable(Drawables.BACKGROUND.createDrawable(this));
        outerLayout.addView(innerLayout);
        this.f34342b = m37025a(Drawables.UNLEFT_ARROW.createDrawable(this));
        this.f34343c = m37025a(Drawables.UNRIGHT_ARROW.createDrawable(this));
        this.f34344d = m37025a(Drawables.REFRESH.createDrawable(this));
        this.f34345e = m37025a(Drawables.CLOSE.createDrawable(this));
        innerLayout.addView(this.f34342b);
        innerLayout.addView(this.f34343c);
        innerLayout.addView(this.f34344d);
        innerLayout.addView(this.f34345e);
        this.f34341a = new BaseWebView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(2, 1);
        this.f34341a.setLayoutParams(layoutParams);
        outerLayout.addView(this.f34341a);
        return moPubBrowserView;
    }

    /* renamed from: a */
    private ImageButton m37025a(Drawable drawable) {
        ImageButton imageButton = new ImageButton(this);
        LayoutParams layoutParams = new LayoutParams(-2, -2, 1.0f);
        layoutParams.gravity = 16;
        imageButton.setLayoutParams(layoutParams);
        imageButton.setImageDrawable(drawable);
        return imageButton;
    }
}
