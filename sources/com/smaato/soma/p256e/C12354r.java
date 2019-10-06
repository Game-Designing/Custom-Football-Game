package com.smaato.soma.p256e;

import android.content.Context;
import android.os.Handler;
import com.smaato.soma.C12408ia;
import com.smaato.soma.interstitial.C12428r;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p256e.C12351p.C12352a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.smaato.soma.e.r */
/* compiled from: MediationEventInterstitialAdapter */
public class C12354r implements C12352a {

    /* renamed from: a */
    private final C12428r f38592a;

    /* renamed from: b */
    private boolean f38593b;

    /* renamed from: c */
    private String f38594c;

    /* renamed from: d */
    private C12351p f38595d;

    /* renamed from: e */
    private Context f38596e;

    /* renamed from: f */
    private C12360w f38597f;

    /* renamed from: g */
    private final Handler f38598g = new Handler();

    /* renamed from: h */
    private final Runnable f38599h;

    /* renamed from: i */
    private final C12352a f38600i;

    /* renamed from: b */
    public C12351p mo39767b() {
        return this.f38595d;
    }

    public C12354r(C12428r interstitialBannerView, String className, C12360w mediationNetworkInfo, C12352a mediationEventInterstitialListener) {
        this.f38592a = interstitialBannerView;
        this.f38597f = mediationNetworkInfo;
        this.f38596e = this.f38592a.getContext();
        this.f38600i = mediationEventInterstitialListener;
        this.f38599h = new C12353q(this, className);
        StringBuilder sb = new StringBuilder();
        sb.append("Attempting to invoke custom event:");
        sb.append(className);
        String str = "MediationEventInterstitialAdapter";
        C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.DEBUG));
        try {
            if (m40605a(mediationNetworkInfo) && className != null) {
                if (!className.isEmpty()) {
                    this.f38594c = className;
                    this.f38595d = C12356t.m40614a(className);
                    return;
                }
            }
            mo39590a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Couldn't locate or instantiate custom event: ");
            sb2.append(className);
            C12146d.m39965a(new C12147e(str, sb2.toString(), 1, C12143a.DEBUG));
            mo39590a(C12408ia.ADAPTER_NOT_FOUND);
        }
    }

    /* renamed from: a */
    private boolean m40605a(C12360w mediationNetworkInfo) {
        if (!(mediationNetworkInfo == null || mediationNetworkInfo == null)) {
            try {
                if (mediationNetworkInfo.mo39801i() != null) {
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: f */
    public void mo39771f() {
        String str = "MediationEventInterstitialAdapter";
        if (mo39770e() || this.f38595d == null || this.f38594c == null || this.f38597f.mo39798g() == null || this.f38597f.mo39798g().isEmpty()) {
            mo39590a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
            mo39769d();
            return;
        }
        try {
            if (mo39768c() > 0) {
                this.f38598g.postDelayed(this.f38599h, (long) mo39768c());
            }
            Map i = this.f38597f.mo39801i();
            if (i == null) {
                i = new HashMap();
            }
            i.put("CUSTOM_WIDTH", String.valueOf(this.f38597f.mo39802j()));
            i.put("CUSTOM_HEIGHT", String.valueOf(this.f38597f.mo39794e()));
            this.f38595d.getClass().getMethod(this.f38597f.mo39798g(), new Class[]{Context.class, C12352a.class, Map.class}).invoke(this.f38595d, new Object[]{this.f38596e, this, i});
        } catch (RuntimeException e) {
            C12146d.m39965a(new C12147e(str, "Loading a custom event interstitial configuration exception.", 1, C12143a.DEBUG));
            mo39590a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
            mo39769d();
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Loading a custom event interstitial threw an exception.");
            sb.append(e2);
            C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.ERROR));
            mo39590a(C12408ia.GENERAL_ERROR);
            mo39769d();
        }
    }

    /* renamed from: d */
    public void mo39769d() {
        C12351p pVar = this.f38595d;
        if (pVar != null) {
            try {
                pVar.mo39737a();
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalidating a custom event interstitial threw an exception.");
                sb.append(e);
                C12146d.m39965a(new C12147e("MediationEventInterstitialAdapter", sb.toString(), 1, C12143a.ERROR));
            }
        }
        this.f38595d = null;
        this.f38596e = null;
        this.f38593b = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo39770e() {
        return this.f38593b;
    }

    /* renamed from: a */
    public void mo39766a() {
        this.f38598g.removeCallbacks(this.f38599h);
    }

    /* renamed from: c */
    public int mo39768c() {
        return 9000;
    }

    public void onReadyToShow() {
        C12146d.m39965a(new C12147e("MediationEventInterstitialAdapter", "onReadyToShow", 1, C12143a.DEBUG));
    }

    public void onWillShow() {
        C12146d.m39965a(new C12147e("MediationEventInterstitialAdapter", "onReadyToShow", 1, C12143a.DEBUG));
    }

    public void onWillOpenLandingPage() {
        C12146d.m39965a(new C12147e("MediationEventInterstitialAdapter", "onReadyToShow", 1, C12143a.DEBUG));
    }

    public void onWillClose() {
        C12146d.m39965a(new C12147e("MediationEventInterstitialAdapter", "onReadyToShow", 1, C12143a.DEBUG));
    }

    public void onFailedToLoadAd() {
        C12146d.m39965a(new C12147e("MediationEventInterstitialAdapter", "onReadyToShow", 1, C12143a.DEBUG));
    }

    public void onInterstitialLoaded() {
        if (!mo39770e()) {
            mo39766a();
            C12352a aVar = this.f38600i;
            if (aVar != null) {
                aVar.onInterstitialLoaded();
            }
        }
    }

    /* renamed from: a */
    public void mo39590a(C12408ia errorCode) {
        if (!mo39770e()) {
            if (this.f38600i != null) {
                if (errorCode == null) {
                    errorCode = C12408ia.UNSPECIFIED;
                }
                mo39766a();
                this.f38600i.mo39590a(errorCode);
            }
            mo39769d();
        }
    }

    public void onInterstitialShown() {
        if (!mo39770e()) {
            C12352a aVar = this.f38600i;
            if (aVar != null) {
                aVar.onInterstitialShown();
            }
        }
    }

    public void onInterstitialClicked() {
        if (!mo39770e()) {
            C12352a aVar = this.f38600i;
            if (aVar != null) {
                aVar.onInterstitialClicked();
            }
        }
    }

    public void onInterstitialDismissed() {
        if (!mo39770e()) {
            C12352a aVar = this.f38600i;
            if (aVar != null) {
                aVar.onInterstitialDismissed();
            }
        }
    }
}
