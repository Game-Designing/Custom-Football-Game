package com.smaato.soma.p256e;

import android.content.Context;
import com.facebook.C6787r;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p256e.C12351p.C12352a;
import java.util.Map;

/* renamed from: com.smaato.soma.e.e */
/* compiled from: FacebookMediationInterstitial */
public class C12336e extends C12351p {

    /* renamed from: a */
    private static String f38556a = "FacebookMediationInterstitial";

    /* renamed from: b */
    private InterstitialAd f38557b;

    /* renamed from: c */
    private C12352a f38558c;

    /* renamed from: d */
    InterstitialAdListener f38559d = new C12335d(this);

    /* renamed from: a */
    public void mo39748a(Context context, C12352a mediationEventInterstitialListener, Map<String, String> map, C12360w mediationNetworkInfo) {
        this.f38558c = mediationEventInterstitialListener;
        if (!m40548a(mediationNetworkInfo)) {
            this.f38558c.mo39590a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        if (mediationNetworkInfo.mo39786b() != null && !C6787r.m13829s()) {
            C6787r.m13806a(mediationNetworkInfo.mo39786b());
        }
        this.f38557b = C12359v.m40618a().mo39775a(context, mediationNetworkInfo.mo39782a());
        this.f38557b.setAdListener(this.f38559d);
        this.f38557b.loadAd();
    }

    /* renamed from: b */
    public void mo39739b() {
        InterstitialAd interstitialAd = this.f38557b;
        if (interstitialAd == null || !interstitialAd.isAdLoaded()) {
            C12146d.m39965a(new C12147e(f38556a, "Tried to show a Facebook interstitial ad before it finished loading. Please try again.", 1, C12143a.DEBUG));
            return;
        }
        this.f38557b.show();
    }

    /* renamed from: a */
    public void mo39737a() {
        try {
            if (this.f38557b != null) {
                this.f38557b.setAdListener(null);
                this.f38557b.destroy();
                this.f38557b = null;
            }
        } catch (NoClassDefFoundError e) {
            m40549c();
        } catch (Exception e2) {
            m40550d();
        }
    }

    /* renamed from: a */
    private boolean m40548a(C12360w mediationNetworkInfo) {
        if (mediationNetworkInfo == null) {
            return false;
        }
        try {
            if (mediationNetworkInfo.mo39782a() == null || mediationNetworkInfo.mo39782a().isEmpty()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: c */
    private void m40549c() {
        String str = f38556a;
        StringBuilder sb = new StringBuilder();
        sb.append("NoClassDefFoundError happened with Google Mediation. Check configurations for ");
        sb.append(f38556a);
        C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.ERROR));
        this.f38558c.mo39590a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        mo39737a();
    }

    /* renamed from: d */
    private void m40550d() {
        String str = f38556a;
        StringBuilder sb = new StringBuilder();
        sb.append("Exception happened with Mediation inputs. Check in ");
        sb.append(f38556a);
        C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.ERROR));
        this.f38558c.mo39590a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        mo39737a();
    }
}
