package com.smaato.soma.p256e;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.LogLevel;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubInterstitial.InterstitialAdListener;
import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p256e.C12351p.C12352a;
import java.util.Map;

/* renamed from: com.smaato.soma.e.D */
/* compiled from: MoPubMediationInterstitial */
public class C12328D extends C12351p {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f38538a = "MoPubMediationInterstitial";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C12352a f38539b;

    /* renamed from: c */
    private MoPubInterstitial f38540c;

    /* renamed from: d */
    private Handler f38541d;

    /* renamed from: e */
    private Runnable f38542e;

    /* renamed from: com.smaato.soma.e.D$a */
    /* compiled from: MoPubMediationInterstitial */
    private class C12329a implements InterstitialAdListener {
        private C12329a() {
        }

        /* synthetic */ C12329a(C12328D x0, C12327C x1) {
            this();
        }

        public void onInterstitialLoaded(MoPubInterstitial moPubInterstitial) {
            try {
                C12328D.this.m40532d();
                C12146d.m39965a(new C12147e(C12328D.f38538a, "MoPub interstitial ad loaded successfully.", 1, C12143a.DEBUG));
                if (C12328D.this.f38539b != null) {
                    C12328D.this.f38539b.onInterstitialLoaded();
                }
            } catch (NoClassDefFoundError e) {
                C12328D.this.m40534e();
            } catch (Exception e2) {
                C12328D.this.m40535f();
            }
        }

        public void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode) {
            if (moPubErrorCode != null) {
                String c = C12328D.f38538a;
                StringBuilder sb = new StringBuilder();
                sb.append("MoPub interstitial ad failed to load.moPubErrorCode");
                sb.append(moPubErrorCode);
                C12146d.m39965a(new C12147e(c, sb.toString(), 1, C12143a.DEBUG));
            }
            if (C12328D.this.f38539b != null) {
                C12328D.this.f38539b.mo39590a(C12408ia.NETWORK_NO_FILL);
            }
            C12328D.this.mo39737a();
        }

        public void onInterstitialShown(MoPubInterstitial moPubInterstitial) {
            C12146d.m39965a(new C12147e(C12328D.f38538a, "Showing MoPub interstitial ad.", 1, C12143a.DEBUG));
            if (C12328D.this.f38539b != null) {
                C12328D.this.f38539b.onInterstitialShown();
            }
        }

        public void onInterstitialClicked(MoPubInterstitial moPubInterstitial) {
            C12146d.m39965a(new C12147e(C12328D.f38538a, "MoPub interstitial ad clicked.", 1, C12143a.DEBUG));
            if (C12328D.this.f38539b != null) {
                C12328D.this.f38539b.onInterstitialClicked();
            }
        }

        public void onInterstitialDismissed(MoPubInterstitial moPubInterstitial) {
            if (C12328D.this.f38539b != null) {
                C12328D.this.f38539b.onInterstitialDismissed();
            }
            C12328D.this.mo39737a();
        }
    }

    /* renamed from: a */
    public void mo39744a(Context context, C12352a mediationEventInterstitialListener, Map<String, String> map, C12360w mediationNetworkInfo) {
        try {
            this.f38539b = mediationEventInterstitialListener;
            if (!m40528a(mediationNetworkInfo)) {
                this.f38539b.mo39590a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
                return;
            }
            if (this.f38540c == null) {
                this.f38540c = C12359v.m40618a().mo39779a((Activity) context, mediationNetworkInfo.mo39782a());
            }
            if (C12146d.f38074a > 1) {
                MoPubLog.setLogLevel(LogLevel.DEBUG);
            } else {
                MoPubLog.setLogLevel(LogLevel.NONE);
            }
            this.f38540c.setInterstitialAdListener(new C12329a(this, null));
            this.f38541d = new Handler();
            this.f38542e = new C12327C(this);
            this.f38541d.postDelayed(this.f38542e, 9000);
            this.f38540c.load();
        } catch (RuntimeException e) {
            m40534e();
        } catch (NoClassDefFoundError e2) {
            m40534e();
        } catch (Exception e3) {
            m40535f();
        }
    }

    /* renamed from: b */
    public void mo39739b() {
        try {
            if (this.f38540c.isReady()) {
                this.f38540c.show();
            } else {
                C12146d.m39965a(new C12147e(f38538a, "Tried to show a MoPub interstitial ad before it finished loading. Please try again.", 1, C12143a.ERROR));
            }
        } catch (NoClassDefFoundError e) {
            m40534e();
        } catch (Exception e2) {
            m40535f();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m40532d() {
        Handler handler = this.f38541d;
        if (handler != null) {
            handler.removeCallbacks(this.f38542e);
        }
        String str = f38538a;
        StringBuilder sb = new StringBuilder();
        sb.append(" cancelTimeout called in");
        sb.append(f38538a);
        C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.DEBUG));
    }

    /* renamed from: a */
    public void mo39737a() {
        try {
            if (this.f38540c != null) {
                this.f38540c.destroy();
                this.f38540c = null;
            }
            if (!(this.f38541d == null || this.f38542e == null)) {
                this.f38541d.removeCallbacks(this.f38542e);
                this.f38541d.removeCallbacksAndMessages(null);
                this.f38541d = null;
                this.f38542e = null;
            }
        } catch (NoClassDefFoundError e) {
        } catch (Exception e2) {
        }
    }

    /* renamed from: a */
    private boolean m40528a(C12360w mediationNetworkInfo) {
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
    public void m40534e() {
        String str = f38538a;
        StringBuilder sb = new StringBuilder();
        sb.append("Dependencies missing. Check configurations of ");
        sb.append(f38538a);
        C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.ERROR));
        this.f38539b.mo39590a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        mo39737a();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m40535f() {
        String str = f38538a;
        StringBuilder sb = new StringBuilder();
        sb.append("Exception happened with Mediation inputs. Check in ");
        sb.append(f38538a);
        C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.ERROR));
        this.f38539b.mo39590a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        mo39737a();
    }
}
