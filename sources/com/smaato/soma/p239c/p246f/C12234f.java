package com.smaato.soma.p239c.p246f;

import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p256e.C12331a;
import com.smaato.soma.p256e.C12351p.C12352a;

/* renamed from: com.smaato.soma.c.f.f */
/* compiled from: AdDownloader */
class C12234f implements C12352a {

    /* renamed from: a */
    final /* synthetic */ C12239k f38321a;

    C12234f(C12239k this$0) {
        this.f38321a = this$0;
    }

    public void onReadyToShow() {
        this.f38321a.m40253a("AdDowndloader_Med", "onReadyToShow");
    }

    public void onWillShow() {
        String str = "AdDowndloader_Med";
        try {
            if (this.f38321a.f38356y != null) {
                this.f38321a.f38356y.mo39739b();
                if (this.f38321a.f38357z != null && this.f38321a.f38357z.mo39796f() != null) {
                    C12146d.m39965a(new C12147e(str, "Impression Tracking triggered through onWillShow Interstitial", 1, C12143a.DEBUG));
                    this.f38321a.mo39605a(this.f38321a.f38357z.mo39796f());
                }
            }
        } catch (NoClassDefFoundError e) {
            this.f38321a.mo39606c();
        } catch (Exception e2) {
            C12146d.m39965a(new C12147e(str, "Please declare Mediation Networks dependent Activities in AndroidManifest.xml", 1, C12143a.ERROR));
            this.f38321a.mo39606c();
        }
    }

    public void onWillOpenLandingPage() {
        if (this.f38321a.f38357z != null && this.f38321a.f38357z.mo39792d() != null) {
            C12146d.m39965a(new C12147e("AdDowndloader_Med", "Click Tracking triggered through onWillOpenLandingPage ", 1, C12143a.DEBUG));
            C12239k kVar = this.f38321a;
            kVar.mo39605a(kVar.f38357z.mo39792d());
        }
    }

    public void onWillClose() {
        C12146d.m39965a(new C12147e("AdDowndloader_Med", "onWillClose", 1, C12143a.DEBUG));
    }

    public void onFailedToLoadAd() {
        C12146d.m39965a(new C12147e("AdDowndloader_Med", "onFailedToLoadAd", 1, C12143a.DEBUG));
    }

    public void onInterstitialLoaded() {
        C12146d.m39965a(new C12147e("AdDowndloader_Med", "onInterstitialLoaded successfully", 1, C12143a.DEBUG));
        onReadyToShow();
        this.f38321a.m40251a(C12331a.INTERSTITIAL);
        this.f38321a.m40262e();
    }

    /* renamed from: a */
    public void mo39590a(C12408ia errorCode) {
        StringBuilder sb = new StringBuilder();
        sb.append("onInterstitialFailed with ErrorCode");
        sb.append(errorCode);
        C12146d.m39965a(new C12147e("AdDowndloader_Med", sb.toString(), 1, C12143a.DEBUG));
        onFailedToLoadAd();
        this.f38321a.mo39606c();
    }

    public void onInterstitialShown() {
        C12146d.m39965a(new C12147e("AdDowndloader_Med", "onInterstitialShown successfully", 1, C12143a.DEBUG));
    }

    public void onInterstitialClicked() {
        if (this.f38321a.f38357z != null && this.f38321a.f38357z.mo39792d() != null) {
            C12239k kVar = this.f38321a;
            kVar.mo39605a(kVar.f38357z.mo39792d());
            C12146d.m39965a(new C12147e("AdDowndloader_Med", "Click Tracking triggered through onInterstitialClicked ", 1, C12143a.DEBUG));
        }
    }

    public void onInterstitialDismissed() {
        if (this.f38321a.f38354w != null) {
            this.f38321a.f38354w.mo39483c();
        }
    }
}
