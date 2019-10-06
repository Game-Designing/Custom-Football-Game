package com.smaato.soma;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.smaato.soma.p236a.C12093D;
import com.smaato.soma.p236a.C12094E;
import com.smaato.soma.p236a.C12108P;
import com.smaato.soma.p236a.C12125n;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p242c.C12202o;
import com.smaato.soma.p261j.C12447O;
import java.lang.ref.WeakReference;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public class ExpandedBannerActivity extends Activity implements C12108P, C12094E {

    /* renamed from: a */
    public static WeakReference<C12125n> f37892a = null;

    /* renamed from: b */
    OnTouchListener f37893b = new C12496la(this);

    /* renamed from: c */
    private ImageButton f37894c = null;

    /* renamed from: d */
    private TextView f37895d = null;

    /* renamed from: e */
    private String f37896e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C12369fa f37897f = null;

    /* renamed from: g */
    private ImageButton f37898g = null;

    /* renamed from: h */
    private ImageButton f37899h = null;

    /* renamed from: i */
    private ImageButton f37900i = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public WebView f37901j = null;

    /* renamed from: k */
    private boolean f37902k = false;

    /* renamed from: l */
    private boolean f37903l = true;

    /* renamed from: m */
    private boolean f37904m = false;

    /* renamed from: n */
    private RelativeLayout f37905n = null;

    /* renamed from: d */
    public C12125n mo39249d() {
        if (f37892a == null) {
            C12125n dummyPackage = new C12498ma(this);
            WebView webView = new WebView(this);
            C12093D webViewClient = new C12093D(this, dummyPackage, this);
            webView.setWebViewClient(webViewClient);
            dummyPackage.mo39364o();
            dummyPackage.mo39344a(webView);
            webView.setWebChromeClient(dummyPackage.mo39362m());
            webView.getSettings().setJavaScriptEnabled(true);
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                String url = extras.getString("string_url", "");
                if (webViewClient.mo39322a(url)) {
                    finish();
                } else {
                    webView.loadUrl(url);
                }
            }
            f37892a = new WeakReference<>(dummyPackage);
        }
        return (C12125n) f37892a.get();
    }

    /* renamed from: e */
    public boolean mo39250e() {
        return this.f37902k;
    }

    /* renamed from: b */
    public void mo39247b(boolean isClosing) {
        this.f37902k = isClosing;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (!(f37892a == null || extras == null || !extras.containsKey("string_url"))) {
            f37892a.clear();
            f37892a = null;
        }
        C12125n currentPackage = mo39249d();
        if (currentPackage == null || currentPackage.mo39363n()) {
            finish();
            return;
        }
        mo39247b(false);
        if (getActionBar() != null) {
            getActionBar().hide();
        }
        this.f37897f = currentPackage.mo39355f();
        this.f37901j = currentPackage.mo39361l();
        WebView webView = this.f37901j;
        if (!(webView == null || webView.getParent() == null)) {
            ((ViewGroup) this.f37901j.getParent()).removeView(this.f37901j);
        }
        setContentView(C12060La.expanded_banner_activity);
        ((ViewGroup) findViewById(C12058Ka.webViewContainer)).addView(this.f37901j);
        m39821i();
        m39820h();
        currentPackage.mo39345a((C12108P) this);
        this.f37901j.setOnTouchListener(this.f37893b);
        this.f37901j.requestFocus(Opcodes.IXOR);
        currentPackage.mo39346a(new WeakReference<>(this));
        C12369fa faVar = this.f37897f;
        if (faVar != null) {
            faVar.f38632c = true;
        }
    }

    /* renamed from: i */
    private void m39821i() {
        findViewById(C12058Ka.closeButton).setOnClickListener(new C12500na(this));
        this.f37894c = (ImageButton) findViewById(C12058Ka.openButton);
        this.f37894c.setOnClickListener(new C12502oa(this));
        this.f37894c.setEnabled(false);
        this.f37895d = (TextView) findViewById(C12058Ka.titleView);
        this.f37895d.setText(C12062Ma.loading);
    }

    /* renamed from: h */
    private void m39820h() {
        this.f37899h = (ImageButton) findViewById(C12058Ka.goForwardButton);
        this.f37899h.setOnClickListener(new C12504pa(this));
        this.f37900i = (ImageButton) findViewById(C12058Ka.goBackwardButton);
        this.f37900i.setOnClickListener(new C12506qa(this));
        this.f37898g = (ImageButton) findViewById(C12058Ka.reloadButton);
        this.f37898g.setOnClickListener(new C12508ra(this));
    }

    /* renamed from: c */
    public void mo39248c() {
        try {
            C12447O.m40923b(Long.valueOf(m39819g()));
            mo39241a();
        } catch (Exception e) {
            C12146d.m39965a(new C12147e("ExpandedBannerActivity", "ExpandedBannerActivity cleanup failed", 1, C12143a.DEBUG));
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        WebView webView = this.f37901j;
        if (webView != null) {
            webView.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        WebView webView = this.f37901j;
        if (webView != null) {
            webView.onPause();
        }
        super.onPause();
    }

    public void onDestroy() {
        try {
            mo39246b();
            mo39249d().mo39346a(null);
            if (this.f37901j != null) {
                if (this.f37905n != null) {
                    this.f37905n.removeView(this.f37901j);
                }
                this.f37901j.setFocusable(true);
                this.f37901j.removeAllViews();
                this.f37901j.clearHistory();
            }
            System.gc();
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        C12146d.m39965a(new C12147e("ExpandedBannerActivity", "ExpandedBannerActivity onBackPressed() invoked", 1, C12143a.DEBUG));
        mo39248c();
    }

    /* renamed from: b */
    public void mo39246b() {
        if (!this.f37902k) {
            mo39247b(true);
            C12125n currentPackage = mo39249d();
            if (currentPackage != null && !currentPackage.mo39366q()) {
                C12369fa faVar = this.f37897f;
                if (faVar != null) {
                    this.f37897f.getBannerAnimatorHandler().sendMessage(faVar.getBannerAnimatorHandler().obtainMessage(102));
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo39241a() {
        C12146d.m39966a((Object) new C12510sa(this));
        C12125n currentPackage = mo39249d();
        if (currentPackage != null) {
            WebView tempViewToClear = currentPackage.mo39361l();
            if (tempViewToClear != null) {
                synchronized (tempViewToClear) {
                    new C12512ta(this, tempViewToClear).execute();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo39243a(String pageTitle) {
        this.f37896e = pageTitle;
    }

    /* renamed from: a */
    public void mo39242a(WebView view, int newProgress) {
        int i = 8;
        if (newProgress == 100) {
            boolean z = true;
            if (this.f37903l) {
                this.f37903l = false;
                if (view.canGoBack()) {
                    this.f37904m = true;
                }
            }
            this.f37894c.setEnabled(true);
            this.f37898g.setEnabled(true);
            if (!view.canGoBack() || (this.f37904m && !view.canGoBackOrForward(-2))) {
                z = false;
            }
            this.f37900i.setVisibility(z ? 0 : 8);
            ImageButton imageButton = this.f37899h;
            if (view.canGoForward()) {
                i = 0;
            }
            imageButton.setVisibility(i);
            String str = this.f37896e;
            if (str != null) {
                this.f37895d.setText(str);
            } else {
                this.f37895d.setText(view.getUrl());
            }
        } else {
            this.f37894c.setEnabled(false);
            this.f37898g.setEnabled(false);
            this.f37900i.setVisibility(8);
            this.f37899h.setVisibility(8);
            this.f37895d.setText(C12062Ma.loading);
        }
    }

    /* renamed from: a */
    public void mo39244a(boolean success) {
        C12125n currentPackage = mo39249d();
        if (currentPackage != null) {
            if (currentPackage.f38020c && !success) {
                currentPackage.mo39370u();
                currentPackage.mo39345a((C12108P) null);
            } else if (success) {
                TextView textView = this.f37895d;
                if (textView != null) {
                    textView.setText(C12062Ma.loading);
                }
                currentPackage.mo39345a((C12108P) null);
                mo39248c();
            }
            currentPackage.f38020c = false;
        }
    }

    /* renamed from: a */
    public void mo39245a(boolean isRedirectionSuccess, boolean shouldDispatchOnWillLeaveApp) {
        if (shouldDispatchOnWillLeaveApp) {
            m39818f();
        }
    }

    /* renamed from: g */
    private long m39819g() {
        return getIntent().getLongExtra("videoAdDispatcherCacheId", 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m39818f() {
        C12202o dispatcher = C12447O.m40921a(Long.valueOf(m39819g()));
        if (dispatcher != null) {
            dispatcher.mo39484d();
        }
    }
}
