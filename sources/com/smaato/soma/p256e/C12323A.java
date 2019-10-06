package com.smaato.soma.p256e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.millennialmedia.AppInfo;
import com.millennialmedia.InterstitialAd;
import com.millennialmedia.InterstitialAd.InterstitialListener;
import com.millennialmedia.MMLog;
import com.millennialmedia.MMSDK;
import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p256e.C12351p.C12352a;
import java.util.Map;

/* renamed from: com.smaato.soma.e.A */
/* compiled from: MillennialMediationInterstitial */
public class C12323A extends C12351p {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f38527a = "MillennialMediationInterstitial";

    /* renamed from: b */
    private InterstitialAd f38528b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C12352a f38529c;

    /* renamed from: d */
    private Context f38530d;

    /* renamed from: e */
    private Handler f38531e;

    /* renamed from: f */
    private Runnable f38532f;

    /* renamed from: com.smaato.soma.e.A$a */
    /* compiled from: MillennialMediationInterstitial */
    class C12324a implements InterstitialListener {
        C12324a() {
        }
    }

    /* renamed from: a */
    public void mo39738a(Context context, C12352a mediationEventInterstitialListener, Map<String, String> map, C12360w mediationNetworkInfo) {
        String adunitid;
        String[] placementIDS = null;
        try {
            this.f38529c = mediationEventInterstitialListener;
            this.f38530d = context;
            if (!m40510a(mediationNetworkInfo)) {
                this.f38529c.mo39590a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
                return;
            }
            if (C12146d.f38074a > 1) {
                MMLog.setLogLevel(1);
            } else {
                MMLog.setLogLevel(5);
            }
            AppInfo appInfo = new AppInfo().setMediator("Smaato");
            if (mediationNetworkInfo.mo39782a() != null) {
                placementIDS = mediationNetworkInfo.mo39782a().trim().split("\\s*;\\s*");
                if (placementIDS != null && placementIDS.length > 1) {
                    appInfo.setSiteId(placementIDS[1]);
                }
            }
            MMSDK.setAppInfo(appInfo);
            if (placementIDS == null || placementIDS.length <= 0 || placementIDS[0] == null) {
                adunitid = mediationNetworkInfo.mo39782a();
            } else {
                adunitid = placementIDS[0];
            }
            this.f38528b = C12359v.m40618a().mo39778a(adunitid);
            this.f38528b.setListener(new C12324a());
            this.f38531e = new Handler(Looper.getMainLooper());
            this.f38532f = new C12364z(this);
            this.f38531e.postDelayed(this.f38532f, 9000);
            this.f38528b.load(context, null);
        } catch (NoClassDefFoundError e) {
            m40512d();
        } catch (Exception e2) {
            m40513e();
        }
    }

    /* renamed from: b */
    public void mo39739b() {
        try {
            if (!this.f38528b.isReady() || this.f38530d == null) {
                C12146d.m39965a(new C12147e(f38527a, "Tried to show a Millennial interstitial ad even before it finished loading.", 1, C12143a.DEBUG));
            } else {
                this.f38528b.show(this.f38530d);
            }
        } catch (NoClassDefFoundError e) {
            m40512d();
        } catch (Exception e2) {
            m40513e();
        }
    }

    /* renamed from: a */
    public void mo39737a() {
        try {
            if (this.f38528b != null) {
                this.f38528b.setListener(null);
                this.f38528b = null;
            }
            if (this.f38531e != null && this.f38532f != null) {
                this.f38531e.removeCallbacksAndMessages(null);
                this.f38531e = null;
                this.f38532f = null;
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private boolean m40510a(C12360w mediationNetworkInfo) {
        if (mediationNetworkInfo == null) {
            return false;
        }
        try {
            if (mediationNetworkInfo.mo39782a() == null || mediationNetworkInfo.mo39782a().isEmpty()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            C12146d.m39965a(new C12147e(f38527a, "MMSDK inputs are inValid", 1, C12143a.DEBUG));
        }
    }

    /* renamed from: d */
    private void m40512d() {
        String str = f38527a;
        StringBuilder sb = new StringBuilder();
        sb.append("NoClassDefFoundError happened with MMedia Mediation. Check configurations for ");
        sb.append(f38527a);
        C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.ERROR));
        C12352a aVar = this.f38529c;
        if (aVar != null) {
            aVar.mo39590a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        }
        mo39737a();
    }

    /* renamed from: e */
    private void m40513e() {
        String str = f38527a;
        StringBuilder sb = new StringBuilder();
        sb.append("Exception happened with Mediation inputs. Check in ");
        sb.append(f38527a);
        C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.ERROR));
        C12352a aVar = this.f38529c;
        if (aVar != null) {
            aVar.mo39590a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        }
        mo39737a();
    }
}
