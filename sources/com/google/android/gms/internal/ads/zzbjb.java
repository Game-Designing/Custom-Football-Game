package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;

@zzard
public class zzbjb extends C9600nf implements zzbje {

    /* renamed from: a */
    private final zzbiz f25411a;

    /* renamed from: b */
    private boolean f25412b;

    /* renamed from: c */
    private boolean f25413c;

    public zzbjb(Context context, zzbiz zzbiz) {
        super(context);
        zzk.zzlk().mo30174f();
        this.f25411a = zzbiz;
        super.setWebViewClient(zzbiz);
    }

    public final synchronized boolean isDestroyed() {
        return this.f25412b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo29038g(boolean z) {
    }

    public synchronized void destroy() {
        if (!this.f25412b) {
            this.f25412b = true;
            this.f25411a.mo30670a((zzbje) this);
            mo29038g(false);
            zzawz.m26003f("Initiating WebView self destruct sequence in 3...");
            zzawz.m26003f("Loading blank page in WebView, 2...");
            try {
                super.loadUrl("about:blank");
            } catch (UnsatisfiedLinkError e) {
                zzk.zzlk().mo30168a((Throwable) e, "AdWebViewImpl.loadUrlUnsafe");
                zzbad.m26360d("#007 Could not call remote method.", e);
            }
        }
    }

    /* renamed from: a */
    public final synchronized void mo30681a(zzbja zzbja) {
        zzawz.m26003f("Blank page loaded, 1...");
        mo28792y();
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    /* renamed from: y */
    public synchronized void mo28792y() {
        zzawz.m26003f("Destroying WebView!");
        m27069K();
        zzbbm.f25064a.execute(new C9644pf(this));
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!isDestroyed()) {
                    mo29038g(true);
                }
                m27069K();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    /* renamed from: K */
    private final synchronized void m27069K() {
        if (!this.f25413c) {
            this.f25413c = true;
            zzk.zzlk().mo30175g();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        return;
     */
    @android.annotation.TargetApi(19)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void evaluateJavascript(java.lang.String r2, android.webkit.ValueCallback<java.lang.String> r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.isDestroyed()     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0014
            java.lang.String r2 = "#004 The webview is destroyed. Ignoring action."
            com.google.android.gms.internal.ads.zzbad.m26359d(r2)     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0012
            r2 = 0
            r3.onReceiveValue(r2)     // Catch:{ all -> 0x0019 }
        L_0x0012:
            monitor-exit(r1)
            return
        L_0x0014:
            super.evaluateJavascript(r2, r3)     // Catch:{ all -> 0x0019 }
            monitor-exit(r1)
            return
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbjb.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    public synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            super.loadUrl(str);
        } else {
            zzbad.m26359d("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
        } else {
            zzbad.m26359d("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzbad.m26359d("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !isDestroyed() && super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            super.onDraw(canvas);
        }
    }

    public void onPause() {
        if (!isDestroyed()) {
            super.onPause();
        }
    }

    public void onResume() {
        if (!isDestroyed()) {
            super.onResume();
        }
    }

    public void stopLoading() {
        if (!isDestroyed()) {
            super.stopLoading();
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
    }

    public /* bridge */ /* synthetic */ void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo28724a(String str) {
        super.mo28724a(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: J */
    public final /* synthetic */ void mo30680J() {
        super.destroy();
    }
}
