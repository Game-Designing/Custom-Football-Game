package com.smaato.soma.p236a;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.widget.RelativeLayout.LayoutParams;
import com.moat.analytics.mobile.sma.MoatFactory;
import com.moat.analytics.mobile.sma.WebAdTracker;
import com.smaato.soma.C12037Ba.C12038a;
import com.smaato.soma.C12064Na;
import com.smaato.soma.C12066Oa;
import com.smaato.soma.C12150c;
import com.smaato.soma.C12369fa;
import com.smaato.soma.internal.extensions.Extension;
import com.smaato.soma.interstitial.C12428r;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.C12187c;
import com.smaato.soma.p239c.p241b.C12173m;
import com.smaato.soma.p239c.p241b.C12179s;
import com.smaato.soma.p239c.p243d.C12204a;
import com.smaato.soma.p239c.p246f.p249c.C12220d;
import com.smaato.soma.p239c.p251h.C12271e;
import com.smaato.soma.p239c.p252i.C12278d;
import com.smaato.soma.p239c.p252i.C12280f;
import com.smaato.soma.p239c.p252i.C12281g;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.smaato.soma.a.n */
/* compiled from: AbstractBannerPackage */
public abstract class C12125n {

    /* renamed from: a */
    private WebAdTracker f38018a;

    /* renamed from: b */
    private final Handler f38019b = new Handler();

    /* renamed from: c */
    public boolean f38020c = false;

    /* renamed from: d */
    private C12098c f38021d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public WebView f38022e = null;

    /* renamed from: f */
    private C12064Na f38023f = null;

    /* renamed from: g */
    private boolean f38024g = false;

    /* renamed from: h */
    private boolean f38025h = false;

    /* renamed from: i */
    private Context f38026i = null;

    /* renamed from: j */
    private Context f38027j = null;

    /* renamed from: k */
    private C12096a f38028k = null;

    /* renamed from: l */
    protected C12369fa f38029l = null;

    /* renamed from: m */
    private boolean f38030m = false;

    /* renamed from: n */
    private C12091B f38031n = new C12091B();

    /* renamed from: com.smaato.soma.a.n$a */
    /* compiled from: AbstractBannerPackage */
    private class C12126a {
        private C12126a() {
        }

        /* synthetic */ C12126a(C12125n x0, C12113b x1) {
            this();
        }

        @JavascriptInterface
        public void processJSON(String json) {
            new C12124m(this, json).execute();
        }
    }

    /* renamed from: com.smaato.soma.a.n$b */
    /* compiled from: AbstractBannerPackage */
    private class C12127b extends C12093D {

        /* renamed from: d */
        final C12271e f38033d;

        /* renamed from: e */
        private boolean f38034e;

        /* synthetic */ C12127b(C12125n x0, C12271e x1, C12094E x2, C12113b x3) {
            this(x1, x2);
        }

        private C12127b(C12271e loadingStateMachine, C12094E handler) {
            super(C12125n.this.mo39357h(), C12125n.this, handler);
            this.f38034e = false;
            this.f38033d = loadingStateMachine;
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            C12125n.this.f38020c = true;
            StringBuilder sb = new StringBuilder();
            sb.append("Page FAILED TO LOAD in AbstractBannerPackage... ");
            sb.append(this.f38033d.mo39655a());
            C12146d.m39965a(new C12147e("Banner_Package", sb.toString(), 1, C12143a.DEBUG));
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            StringBuilder sb = new StringBuilder();
            sb.append("Page started Loading... ");
            sb.append(this.f38033d.mo39655a());
            C12146d.m39965a(new C12147e("Banner_Package", sb.toString(), 1, C12143a.DEBUG));
            this.f38034e = false;
        }

        public void onPageFinished(WebView viewFinished, String url) {
            if (!this.f38034e) {
                this.f38034e = true;
                new C12128o(this, viewFinished).execute();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo39339a(C12064Na na, int i, int i2, boolean z);

    /* renamed from: a */
    public final void mo39340a() {
        this.f38019b.removeCallbacksAndMessages(null);
        C12146d.m39966a((Object) new C12113b(this));
        if (mo39362m() != null) {
            mo39362m().mo39326a();
            WebView tempViewToClear = mo39361l();
            if (tempViewToClear != null) {
                synchronized (tempViewToClear) {
                    new C12114c(this, tempViewToClear).execute();
                }
            }
            if (mo39360k() != null) {
                mo39360k().mo39449d();
            }
            mo39349b((C12064Na) null);
            this.f38031n.mo39320a(null);
        }
    }

    /* renamed from: b */
    public final void mo39348b() {
        C12146d.m39966a((Object) new C12115d(this));
        mo39362m().mo39326a();
    }

    /* renamed from: a */
    public final void mo39341a(Context context, C12369fa tempBannerView, C12271e mLoadingStateMachine, Handler handler) {
        mo39342a(context, tempBannerView, mLoadingStateMachine, handler, m39910a(context, tempBannerView.getHeight()), -1);
    }

    /* renamed from: a */
    public void mo39342a(Context context, C12369fa adView, C12271e loadingStateMachine, Handler handler, int height, int width) {
        C12146d.m39966a((Object) new C12116e(this));
        adView.setVisibility(0);
        m39915a(adView);
        mo39350b(new WeakReference<>(context));
        if (mo39354e() != null) {
            WebView baseView = m39918w();
            if (C12066Oa.m39873b()) {
                this.f38018a = MoatFactory.create().createWebAdTracker(baseView);
            }
            mo39344a(baseView);
            String htmlPage = m39913a(adView, height, width, loadingStateMachine);
            if (mo39365p()) {
                this.f38031n.mo39318a(mo39357h(), adView, mo39361l());
            }
            mo39364o();
            mo39361l().setWebChromeClient(mo39362m());
            mo39343a(handler, mo39357h(), this);
            m39917v();
            mo39361l().loadDataWithBaseURL(null, htmlPage, "text/html", "UTF-8", null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo39343a(Handler handler, Context context, C12125n abstractBannerPackage) {
        this.f38031n.mo39319a(handler, context, abstractBannerPackage);
    }

    /* renamed from: a */
    private String m39913a(C12369fa bannerView, int bannerHeight, int width, C12271e mLoadingState) {
        String htmlPage;
        C12146d.m39966a((Object) new C12117f(this));
        if (width > 0) {
            htmlPage = m39916b(mo39354e(), width, bannerHeight, true);
        } else if (bannerView instanceof C12038a) {
            htmlPage = m39916b(mo39354e(), (C12220d.m40201i().mo39565n() * 70) / 100, C12220d.m40201i().mo39563l(), false);
        } else if (bannerView.getAdSettings().mo39880a() == C12150c.INTERSTITIAL_PORTRAIT) {
            htmlPage = m39916b(mo39354e(), C12220d.m40201i().mo39565n(), C12220d.m40201i().mo39563l(), true);
        } else if (bannerView.getAdSettings().mo39880a() == C12150c.INTERSTITIAL_LANDSCAPE) {
            htmlPage = m39916b(mo39354e(), C12220d.m40201i().mo39563l(), C12220d.m40201i().mo39565n(), true);
        } else {
            htmlPage = m39916b(mo39354e(), bannerView.getWidth(), bannerHeight, false);
        }
        mo39361l().setWebViewClient(new C12127b(this, mLoadingState, new C12118g(this, bannerView), null));
        return htmlPage;
    }

    /* renamed from: p */
    public boolean mo39365p() {
        return (mo39354e() == null || mo39354e().mo39286c() == null || !mo39354e().mo39286c().contains("mraid.js")) ? false : true;
    }

    /* renamed from: b */
    private String m39916b(C12064Na receivedBanner, int width, int height, boolean isFullScreen) {
        if (mo39354e() == null || mo39354e().mo39286c() == null) {
            return mo39339a(receivedBanner, width, height, isFullScreen);
        }
        return this.f38031n.mo39316a(receivedBanner, mo39357h());
    }

    /* renamed from: a */
    private int m39910a(Context context, int currentHeight) {
        C12146d.m39966a((Object) new C12119h(this));
        int result = currentHeight;
        int minimalHeight = C12278d.m40415a().mo39671a(context);
        if (result < minimalHeight) {
            return minimalHeight;
        }
        return result;
    }

    /* renamed from: w */
    private WebView m39918w() {
        LayoutParams webViewParams;
        C12146d.m39966a((Object) new C12120i(this));
        StringBuilder sb = new StringBuilder();
        sb.append("SDK_INT = ");
        sb.append(VERSION.SDK_INT);
        C12146d.m39965a(new C12147e("SOMA", sb.toString(), 1, C12143a.DEBUG));
        WebView baseView = C12187c.m40092b().mo39465a(mo39357h(), mo39354e(), mo39355f());
        baseView.clearCache(true);
        baseView.setFocusable(true);
        try {
            baseView.getSettings().setRenderPriority(RenderPriority.HIGH);
        } catch (Exception e) {
        }
        baseView.getSettings().setCacheMode(-1);
        if (mo39355f() != null) {
            baseView.setBackgroundColor(mo39355f().getBackgroundColor());
        }
        WebSettings settings = baseView.getSettings();
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setJavaScriptEnabled(true);
        if (VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setPluginState(PluginState.ON);
        settings.setUseWideViewPort(false);
        if (mo39355f().getAdSettings().mo39880a() == C12150c.MEDIUMRECTANGLE && (mo39355f() instanceof C12038a)) {
            webViewParams = new LayoutParams(C12278d.m40415a().mo39670a(300), C12278d.m40415a().mo39670a(250));
        } else if (mo39355f().getAdSettings().mo39880a() == C12150c.INTERSTITIAL_PORTRAIT && (mo39355f() instanceof C12038a)) {
            webViewParams = new LayoutParams(C12278d.m40415a().mo39670a(320), C12278d.m40415a().mo39670a(480));
        } else if (mo39355f().getAdSettings().mo39880a() == C12150c.INTERSTITIAL_LANDSCAPE && (mo39355f() instanceof C12038a)) {
            webViewParams = new LayoutParams(C12278d.m40415a().mo39670a(480), C12278d.m40415a().mo39670a(320));
        } else if (mo39355f() instanceof C12428r) {
            webViewParams = new LayoutParams(-1, -1);
        } else {
            webViewParams = new LayoutParams(-2, -2);
        }
        baseView.setLayoutParams(webViewParams);
        baseView.setVerticalScrollBarEnabled(false);
        baseView.setHorizontalScrollBarEnabled(false);
        return baseView;
    }

    /* renamed from: l */
    public final WebView mo39361l() {
        return this.f38022e;
    }

    /* renamed from: a */
    public final void mo39344a(WebView webView) {
        this.f38022e = webView;
    }

    /* renamed from: e */
    public final C12064Na mo39354e() {
        return this.f38023f;
    }

    /* renamed from: b */
    public final void mo39349b(C12064Na receivedBanner) {
        this.f38023f = receivedBanner;
    }

    /* renamed from: h */
    public final Context mo39357h() {
        return this.f38026i;
    }

    /* renamed from: b */
    public final void mo39350b(WeakReference<Context> contextWeakReference) {
        if (contextWeakReference != null && contextWeakReference.get() != null) {
            this.f38026i = (Context) contextWeakReference.get();
            if (mo39359j() != null) {
                mo39359j().mo39409a((Context) contextWeakReference.get());
            }
            if (mo39360k() != null) {
                mo39360k().mo39431a((Context) contextWeakReference.get());
            }
        }
    }

    /* renamed from: s */
    public final void mo39368s() {
        if (mo39360k() != null) {
            mo39360k().mo39456k();
        }
    }

    /* renamed from: j */
    public final C12173m mo39359j() {
        return this.f38031n.mo39315a();
    }

    /* renamed from: f */
    public C12369fa mo39355f() {
        return this.f38029l;
    }

    /* renamed from: k */
    public final C12179s mo39360k() {
        return this.f38031n.mo39321b();
    }

    /* renamed from: q */
    public boolean mo39366q() {
        return this.f38025h;
    }

    /* renamed from: b */
    public void mo39351b(boolean isOrmmaCloseMsgSent) {
        this.f38025h = isOrmmaCloseMsgSent;
    }

    /* renamed from: g */
    public Context mo39356g() {
        return this.f38027j;
    }

    /* renamed from: a */
    public void mo39346a(WeakReference<Context> browserContext) {
        if (browserContext != null) {
            this.f38027j = (Context) browserContext.get();
        }
    }

    /* renamed from: m */
    public C12096a mo39362m() {
        return this.f38028k;
    }

    /* renamed from: a */
    public void mo39345a(C12108P chromeClientDelegate) {
        C12096a aVar = this.f38028k;
        if (aVar != null) {
            aVar.mo39327a(chromeClientDelegate);
        }
    }

    /* renamed from: a */
    private void m39914a(C12096a mWebChromeClient) {
        this.f38028k = mWebChromeClient;
    }

    /* renamed from: o */
    public void mo39364o() {
        m39914a(new C12095F(this).mo39325a());
    }

    /* renamed from: a */
    private void m39915a(C12369fa mBannerView) {
        this.f38029l = mBannerView;
    }

    @SuppressLint({"JavascriptInterface"})
    /* renamed from: v */
    private void m39917v() {
        mo39361l().addJavascriptInterface(mo39359j(), "Android");
        mo39361l().addJavascriptInterface(new C12126a(this, null), "HTMLOUT");
        Object additionalJsInterface = mo39352c();
        String additionalJSInterfaceName = mo39353d();
        if (additionalJsInterface != null && additionalJSInterfaceName != null) {
            mo39361l().addJavascriptInterface(additionalJsInterface, additionalJSInterfaceName);
        }
    }

    /* renamed from: r */
    public void mo39367r() {
        C12146d.m39966a((Object) new C12121j(this));
        if (mo39355f() != null) {
            Handler handler = mo39355f().getBannerAnimatorHandler();
            handler.dispatchMessage(handler.obtainMessage(104));
        }
    }

    /* renamed from: u */
    public void mo39370u() {
        this.f38020c = true;
        String str = "Banner_Package";
        C12146d.m39965a(new C12147e(str, "Page FAILED TO LOAD... at showPageFailed ", 1, C12143a.DEBUG));
        this.f38022e.loadDataWithBaseURL(null, "<html><head><title>Page not available</title></head><body bgcolor='#FFFFFF' style='height:100%;width:100%'><h2>Page not available</h2>Closing in <span id='seconds'>3</span> seconds...<script>var timeout = 3;setInterval(function(){if (timeout > 0){document.getElementById('seconds').innerText = '' + (--timeout);}}, 1000);</script></body></html>", "text/html", "utf-8", null);
        this.f38029l.getBannerState().mo39643d();
        try {
            this.f38019b.postDelayed(new C12109a(this), 3000);
        } catch (ActivityNotFoundException e) {
            C12146d.m39965a(new C12147e(str, "Please declare com.smaato.soma.ExpandedBannerActivity in your AndroidManifest.xml. ActivityNotFoundException", 0, C12143a.ERROR));
        } catch (Exception e2) {
            C12146d.m39965a(new C12147e(str, "Exception inside Internal Browser", 0, C12143a.ERROR));
        }
    }

    /* renamed from: a */
    static String m39912a(C12064Na banner) {
        StringBuilder extensionScripts = new StringBuilder();
        List<Extension> extensions = banner.mo39289f();
        if (!C12281g.m40430a(extensions)) {
            Iterator it = extensions.iterator();
            while (it.hasNext()) {
                String script = ((C12204a) it.next()).mo39511c();
                if (!C12280f.m40428a((CharSequence) script)) {
                    extensionScripts.append(script);
                }
            }
        }
        return extensionScripts.toString();
    }

    /* renamed from: i */
    public WebAdTracker mo39358i() {
        return this.f38018a;
    }

    /* renamed from: t */
    public void mo39369t() {
        this.f38018a = null;
    }

    /* renamed from: n */
    public boolean mo39363n() {
        return this.f38030m;
    }

    /* renamed from: a */
    public void mo39347a(boolean hasBeenRedirected) {
        this.f38030m = hasBeenRedirected;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Object mo39352c() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo39353d() {
        return null;
    }
}
