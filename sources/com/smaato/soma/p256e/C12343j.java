package com.smaato.soma.p256e;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;
import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p256e.C12351p.C12352a;
import java.util.Map;

/* renamed from: com.smaato.soma.e.j */
/* compiled from: GooglePlayMediationInterstitial */
public class C12343j extends C12351p {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f38572a = "GooglePlayMediationInterstitial";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C12352a f38573b;

    /* renamed from: c */
    private InterstitialAd f38574c;

    /* renamed from: d */
    private Handler f38575d;

    /* renamed from: e */
    private Runnable f38576e;

    /* renamed from: com.smaato.soma.e.j$a */
    /* compiled from: GooglePlayMediationInterstitial */
    private class C12344a extends AdListener {
        private C12344a() {
        }

        /* synthetic */ C12344a(C12343j x0, C12342i x1) {
            this();
        }

        public void onAdClosed() {
            if (C12343j.this.f38573b != null) {
                C12343j.this.f38573b.onInterstitialDismissed();
            }
            C12343j.this.mo39737a();
        }

        public void onAdFailedToLoad(int errorCode) {
            try {
                C12146d.m39965a(new C12147e(C12343j.f38572a, "Google Play Services interstitial ad failed to load.", 1, C12143a.DEBUG));
                if (C12343j.this.f38573b != null) {
                    C12343j.this.f38573b.mo39590a(C12408ia.NETWORK_NO_FILL);
                }
                C12343j.this.mo39737a();
            } catch (NoClassDefFoundError e) {
                C12343j.this.m40580e();
            } catch (Exception e2) {
                C12343j.this.m40581f();
            }
        }

        public void onAdLeftApplication() {
            if (C12343j.this.f38573b != null) {
                C12343j.this.f38573b.onInterstitialClicked();
            }
        }

        public void onAdLoaded() {
            try {
                C12343j.this.m40578d();
                C12146d.m39965a(new C12147e(C12343j.f38572a, "Google Play Services interstitial ad loaded successfully.", 1, C12143a.DEBUG));
                if (C12343j.this.f38573b != null) {
                    C12343j.this.f38573b.onInterstitialLoaded();
                }
            } catch (NoClassDefFoundError e) {
                C12343j.this.m40580e();
            } catch (Exception e2) {
                C12343j.this.m40581f();
            }
        }

        public void onAdOpened() {
            C12146d.m39965a(new C12147e(C12343j.f38572a, "Showing Google Play Services interstitial ad.", 1, C12143a.DEBUG));
            if (C12343j.this.f38573b != null) {
                C12343j.this.f38573b.onInterstitialShown();
            }
        }
    }

    /* renamed from: a */
    public void mo39757a(Context context, C12352a mediationEventInterstitialListener, Map<String, String> map, C12360w mediationNetworkInfo) {
        try {
            this.f38573b = mediationEventInterstitialListener;
            if (!m40574a(mediationNetworkInfo)) {
                this.f38573b.mo39590a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
                return;
            }
            this.f38574c = C12359v.m40618a().mo39780b(context);
            this.f38574c.setAdListener(new C12344a(this, null));
            this.f38574c.setAdUnitId(mediationNetworkInfo.mo39782a());
            AdRequest adRequest = new Builder().setRequestAgent("Smaato").build();
            this.f38575d = new Handler();
            this.f38576e = new C12342i(this);
            this.f38575d.postDelayed(this.f38576e, 9000);
            this.f38574c.loadAd(adRequest);
        } catch (NoClassDefFoundError e) {
            m40580e();
        } catch (Exception e2) {
            m40581f();
        }
    }

    /* renamed from: b */
    public void mo39739b() {
        try {
            if (this.f38574c.isLoaded()) {
                this.f38574c.show();
            } else {
                C12146d.m39965a(new C12147e(f38572a, "Tried to show a Google Play Services interstitial ad before it finished loading. Please try again.", 1, C12143a.DEBUG));
            }
        } catch (NoClassDefFoundError e) {
            m40580e();
        } catch (Exception e2) {
            m40581f();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m40578d() {
        Handler handler = this.f38575d;
        if (handler != null) {
            handler.removeCallbacks(this.f38576e);
        }
        String str = f38572a;
        StringBuilder sb = new StringBuilder();
        sb.append(" cancelTimeout called in");
        sb.append(f38572a);
        C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.DEBUG));
    }

    /* renamed from: a */
    public void mo39737a() {
        try {
            if (!(this.f38575d == null || this.f38576e == null)) {
                this.f38575d.removeCallbacks(this.f38576e);
                this.f38575d.removeCallbacksAndMessages(null);
                this.f38575d = null;
                this.f38576e = null;
            }
        } catch (NoClassDefFoundError e) {
            m40580e();
        } catch (Exception e2) {
            m40581f();
        }
    }

    /* renamed from: a */
    private boolean m40574a(C12360w mediationNetworkInfo) {
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

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m40580e() {
        String str = f38572a;
        StringBuilder sb = new StringBuilder();
        sb.append("NoClassDefFoundError happened with Google Mediation. Check configurations for ");
        sb.append(f38572a);
        C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.ERROR));
        this.f38573b.mo39590a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        mo39737a();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m40581f() {
        String str = f38572a;
        StringBuilder sb = new StringBuilder();
        sb.append("Exception happened with Mediation inputs. Check in ");
        sb.append(f38572a);
        C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.ERROR));
        this.f38573b.mo39590a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        mo39737a();
    }
}
