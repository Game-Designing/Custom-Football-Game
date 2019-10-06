package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p019d.p273h.p285d.p287b.C12971c;
import p019d.p273h.p285d.p295h.C12999b;
import p019d.p273h.p285d.p295h.C13001d;
import p019d.p273h.p285d.p295h.C13003f;
import p019d.p273h.p285d.p295h.C13004g;

public class OpenUrlActivity extends Activity {

    /* renamed from: a */
    private static final int f33029a = C13004g.m42439a();

    /* renamed from: b */
    private static final int f33030b = C13004g.m42439a();

    /* renamed from: c */
    private WebView f33031c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C10877y f33032d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ProgressBar f33033e;

    /* renamed from: f */
    boolean f33034f;

    /* renamed from: g */
    private RelativeLayout f33035g;

    /* renamed from: h */
    private String f33036h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Handler f33037i = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f33038j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final Runnable f33039k = new C10856ia(this);

    /* renamed from: com.ironsource.sdk.controller.OpenUrlActivity$a */
    private class C10826a extends WebViewClient {
        private C10826a() {
        }

        /* synthetic */ C10826a(OpenUrlActivity x0, C10854ha x1) {
            this();
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            OpenUrlActivity.this.f33033e.setVisibility(0);
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            OpenUrlActivity.this.f33033e.setVisibility(4);
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            List<String> searchKeys = C13001d.m42395g().mo41906e();
            if (searchKeys != null && !searchKeys.isEmpty()) {
                for (String key : searchKeys) {
                    if (url.contains(key)) {
                        try {
                            OpenUrlActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                            OpenUrlActivity.this.f33032d.mo35503i();
                        } catch (Exception ex) {
                            StringBuilder errorMessage = new StringBuilder();
                            if (ex instanceof ActivityNotFoundException) {
                                errorMessage.append("no activity to handle url");
                            } else {
                                errorMessage.append("activity failed to open with unspecified reason");
                            }
                            OpenUrlActivity.this.f33032d.mo35476b(errorMessage.toString(), url);
                        }
                        OpenUrlActivity.this.finish();
                        return true;
                    }
                }
            }
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C13003f.m42438c("OpenUrlActivity", "onCreate()");
        try {
            this.f33032d = C12971c.m42271a((Activity) this).mo41839b();
            m35410d();
            m35411e();
            Bundle bundle = getIntent().getExtras();
            this.f33036h = bundle.getString(C10877y.f33147e);
            this.f33034f = bundle.getBoolean(C10877y.f33148f);
            this.f33038j = getIntent().getBooleanExtra("immersive", false);
            if (this.f33038j) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new C10854ha(this));
                runOnUiThread(this.f33039k);
            }
            this.f33035g = new RelativeLayout(this);
            setContentView(this.f33035g, new LayoutParams(-1, -1));
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m35406b();
    }

    /* renamed from: b */
    private void m35406b() {
        if (this.f33031c == null) {
            this.f33031c = new WebView(getApplicationContext());
            this.f33031c.setId(f33029a);
            this.f33031c.getSettings().setJavaScriptEnabled(true);
            this.f33031c.setWebViewClient(new C10826a(this, null));
            mo35385a(this.f33036h);
        }
        if (findViewById(f33029a) == null) {
            this.f33035g.addView(this.f33031c, new RelativeLayout.LayoutParams(-1, -1));
        }
        m35404a();
        C10877y yVar = this.f33032d;
        if (yVar != null) {
            yVar.mo35472a(true, "secondary");
        }
    }

    /* renamed from: a */
    private void m35404a() {
        if (this.f33033e == null) {
            if (VERSION.SDK_INT >= 11) {
                this.f33033e = new ProgressBar(new ContextThemeWrapper(this, 16973939));
            } else {
                this.f33033e = new ProgressBar(this);
            }
            this.f33033e.setId(f33030b);
        }
        if (findViewById(f33030b) == null) {
            RelativeLayout.LayoutParams progressBarLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            progressBarLayoutParams.addRule(13);
            this.f33033e.setLayoutParams(progressBarLayoutParams);
            this.f33033e.setVisibility(4);
            this.f33035g.addView(this.f33033e);
        }
    }

    /* renamed from: f */
    private void m35413f() {
        C10877y yVar = this.f33032d;
        if (yVar != null) {
            yVar.mo35472a(false, "secondary");
            if (this.f33035g != null) {
                ViewGroup parent = (ViewGroup) this.f33031c.getParent();
                if (parent != null) {
                    if (parent.findViewById(f33029a) != null) {
                        parent.removeView(this.f33031c);
                    }
                    if (parent.findViewById(f33030b) != null) {
                        parent.removeView(this.f33033e);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private void m35408c() {
        WebView webView = this.f33031c;
        if (webView != null) {
            webView.destroy();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        m35413f();
    }

    /* renamed from: a */
    public void mo35385a(String url) {
        this.f33031c.stopLoading();
        this.f33031c.clearHistory();
        try {
            this.f33031c.loadUrl(url);
        } catch (Throwable e) {
            StringBuilder sb = new StringBuilder();
            sb.append("OpenUrlActivity:: loadUrl: ");
            sb.append(e.toString());
            C13003f.m42437b("OpenUrlActivity", sb.toString());
            C12999b bVar = new C12999b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
            sb2.append(e.getStackTrace()[0].getMethodName());
            bVar.execute(new String[]{sb2.toString()});
        }
    }

    /* renamed from: d */
    private void m35410d() {
        requestWindowFeature(1);
    }

    /* renamed from: e */
    private void m35411e() {
        getWindow().setFlags(Opcodes.ACC_ABSTRACT, Opcodes.ACC_ABSTRACT);
    }

    public void onBackPressed() {
        if (this.f33031c.canGoBack()) {
            this.f33031c.goBack();
        } else {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m35408c();
    }

    public void finish() {
        if (this.f33034f) {
            this.f33032d.mo35475b("secondaryClose");
        }
        super.finish();
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (this.f33038j && hasFocus) {
            runOnUiThread(this.f33039k);
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this.f33038j && (keyCode == 25 || keyCode == 24)) {
            this.f33037i.postDelayed(this.f33039k, 500);
        }
        return super.onKeyDown(keyCode, event);
    }
}
