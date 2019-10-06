package com.smaato.soma.p261j;

import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.moat.analytics.mobile.sma.MoatFactory;
import com.moat.analytics.mobile.sma.WebAdTracker;
import com.smaato.soma.C12066Oa;
import com.smaato.soma.C12369fa;
import com.smaato.soma.C12507r;
import com.smaato.soma.interstitial.C12412d;
import com.smaato.soma.p236a.p237a.C12110a;
import com.smaato.soma.p239c.p243d.C12204a;
import com.smaato.soma.p239c.p246f.C12242n;
import com.smaato.soma.p239c.p253j.C12282a;
import com.smaato.soma.p239c.p253j.C12283b;
import java.util.Collection;

/* renamed from: com.smaato.soma.j.t */
/* compiled from: VASTAdActivity */
public class C12485t extends C12412d implements C12507r, C12436a {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WebAdTracker f38931c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C12435D f38932d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public RelativeLayout f38933e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Handler f38934f = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f38935g = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C12283b f38936h;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new C12471f(this).execute();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public boolean m41024i() {
        C12282a companionAd = this.f38932d.getVastAd().mo39691a();
        if (companionAd == null) {
            return false;
        }
        if (companionAd.mo39689f() == null && companionAd.mo39687d() == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m41011a(C12282a ad, Collection<C12204a> extensions) {
        String adHtml = null;
        if (ad.mo39689f() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("    <img style='display: inline; height: auto; max-width: 100%;' src='");
            sb.append(ad.mo39689f());
            sb.append("' />");
            adHtml = sb.toString();
        } else if (ad.mo39687d() != null) {
            adHtml = ad.mo39687d();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<!DOCTYPE html><html lang='en' style='height:100%;'>  <head>    <meta name='viewport' content='width=device-width,height=device-height,initial-scale=1.0'/>  </head>  <body style='margin: 0; padding: 0; background:black; min-height:100%; ");
        sb2.append(C12110a.m39907a());
        sb2.append("' onClick='Android.legacyExpand();' >    <div id='smaato-ad-container'>");
        sb2.append(adHtml);
        sb2.append(m41013a(extensions));
        sb2.append("    </div>  </body></html>");
        return sb2.toString();
    }

    /* renamed from: a */
    private static String m41013a(Collection<C12204a> extensions) {
        StringBuilder extensionScripts = new StringBuilder();
        if (extensions != null) {
            for (C12204a extension : extensions) {
                String script = extension.mo39511c();
                if (script != null) {
                    extensionScripts.append(script);
                }
            }
        }
        return extensionScripts.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo40015f() {
        new C12474i(this).execute();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41014a(WebView companionAdView, C12282a companionAd) {
        new C12242n().execute((String[]) companionAd.mo39685c().toArray(new String[companionAd.mo39685c().size()]));
        if (C12066Oa.m39873b()) {
            this.f38931c = MoatFactory.create().createWebAdTracker(companionAdView);
            this.f38931c.startTracking();
        }
    }

    public void onWillOpenLandingPage(C12369fa sender) {
    }

    public void onWillCloseLandingPage(C12369fa sender) {
    }

    /* renamed from: b */
    public void mo39957b() {
        new C12476k(this).execute();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo40014e() {
        if (this.f38932d != null) {
            this.f38936h = new C12283b(getBaseContext(), true);
            this.f38936h.setOnClickListener(new C12478m(this));
            RelativeLayout relativeLayout = this.f38933e;
            C12283b bVar = this.f38936h;
            relativeLayout.addView(bVar, bVar.getLayoutParams());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo39911c() {
        this.f38936h = new C12283b(getBaseContext(), false);
        this.f38936h.setOnClickListener(new C12480o(this));
        RelativeLayout relativeLayout = this.f38933e;
        C12283b bVar = this.f38936h;
        relativeLayout.addView(bVar, bVar.getLayoutParams());
    }

    public void onBackPressed() {
        new C12481p(this).execute();
    }

    /* renamed from: g */
    public void mo40016g() {
        C12435D d = this.f38932d;
        if (d != null && !d.mo39946l()) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        new C12482q(this).execute();
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        new C12483r(this).execute();
        super.onPause();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m41023h() {
        this.f38932d.getVideoAdDispatcher().mo39485e();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        new C12484s(this).execute();
        super.onDestroy();
    }
}
