package com.smaato.soma.p236a;

import android.view.View;
import android.webkit.WebView;
import com.smaato.soma.C12369fa;
import com.smaato.soma.C12492ja;
import com.smaato.soma.C12507r;
import com.smaato.soma.interstitial.C12428r;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p260i.C12402c;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.smaato.soma.a.x */
/* compiled from: BannerAnimator */
public class C12137x {

    /* renamed from: a */
    private static C12137x f38056a = null;

    /* renamed from: b */
    private final String f38057b = "BannerAnimator";

    /* renamed from: c */
    private final int f38058c = 250;

    /* renamed from: d */
    private boolean f38059d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C12402c f38060e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f38061f = false;

    protected C12137x() {
    }

    /* renamed from: a */
    public static synchronized C12137x m39951a() {
        C12137x xVar;
        synchronized (C12137x.class) {
            if (f38056a == null) {
                f38056a = new C12137x();
            }
            xVar = f38056a;
        }
        return xVar;
    }

    /* renamed from: b */
    public final void mo39378b(C12125n currentPackage, C12369fa bannerView) {
        C12492ja.m41030a().mo40022a(System.currentTimeMillis());
        C12146d.m39966a((Object) new C12129p(this));
        if (bannerView == null || currentPackage == null) {
            C12146d.m39965a(new C12147e("BannerAnimator", "Unable to expand the view ...", 1, C12143a.WARNING));
            return;
        }
        C12507r mStateListenerReference = bannerView.getBannerStateListener();
        if (mStateListenerReference != null) {
            mStateListenerReference.onWillOpenLandingPage(bannerView);
        }
        View rootView = bannerView.getRootView();
        StringBuilder sb = new StringBuilder();
        sb.append("RootViewName: ");
        sb.append(rootView.getClass().getCanonicalName());
        C12146d.m39965a(new C12147e("BannerAnimator", sb.toString(), 1, C12143a.DEBUG));
        if ((rootView.findViewById(16908290) != null || (bannerView instanceof C12428r)) && currentPackage != null) {
            WebView webView = currentPackage.mo39361l();
            if (webView != null) {
                synchronized (webView) {
                    webView.bringToFront();
                    webView.requestFocus(Opcodes.IXOR);
                    webView.setOnKeyListener(new C12131r(this, currentPackage, bannerView));
                    new C12134u(this, webView, bannerView, currentPackage).execute();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo39376a(C12125n mCurrentPackage, C12369fa tempBannerView) {
        C12146d.m39966a((Object) new C12135v(this));
        if (!(mCurrentPackage == null || tempBannerView == null || tempBannerView.getRootView() == null || tempBannerView.getRootView().findViewById(16908290) == null || mCurrentPackage.mo39365p())) {
            new C12136w(this, mCurrentPackage, tempBannerView).execute();
        }
    }

    /* renamed from: b */
    public final boolean mo39379b() {
        return this.f38061f;
    }

    /* renamed from: a */
    public final void mo39377a(boolean googlePlayBanner) {
        this.f38061f = googlePlayBanner;
    }

    /* renamed from: c */
    public boolean mo39380c() {
        return this.f38059d;
    }
}
