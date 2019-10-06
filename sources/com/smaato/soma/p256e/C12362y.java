package com.smaato.soma.p256e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.millennialmedia.AppInfo;
import com.millennialmedia.InlineAd;
import com.millennialmedia.InlineAd.AdSize;
import com.millennialmedia.InlineAd.InlineAdMetadata;
import com.millennialmedia.InlineAd.InlineListener;
import com.millennialmedia.MMLog;
import com.millennialmedia.MMSDK;
import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p256e.C12345k.C12346a;
import java.util.Map;

/* renamed from: com.smaato.soma.e.y */
/* compiled from: MillennialMediationBanner */
public class C12362y extends C12345k {

    /* renamed from: a */
    private InlineAd f38616a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C12346a f38617b;

    /* renamed from: c */
    private LinearLayout f38618c;

    /* renamed from: d */
    private Handler f38619d;

    /* renamed from: e */
    private Runnable f38620e;

    /* renamed from: com.smaato.soma.e.y$a */
    /* compiled from: MillennialMediationBanner */
    class C12363a implements InlineListener {
        C12363a() {
        }
    }

    /* renamed from: a */
    public void mo39804a(Context context, C12346a mediationEventBannerListener, Map<String, String> map, C12360w mediationNetworkInfo) {
        String adunitid;
        this.f38617b = mediationEventBannerListener;
        this.f38616a = null;
        String[] placementIDS = null;
        if (!mo39805a(mediationNetworkInfo)) {
            this.f38617b.mo39597a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        try {
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
            this.f38618c = new LinearLayout(context);
            new LayoutParams(-1, -2).gravity = 1;
            if (placementIDS == null || placementIDS.length <= 0 || placementIDS[0] == null) {
                adunitid = mediationNetworkInfo.mo39782a();
            } else {
                adunitid = placementIDS[0];
            }
            this.f38616a = C12359v.m40618a().mo39777a(adunitid, (ViewGroup) this.f38618c);
            this.f38616a.setListener(new C12363a());
            int wt = 320;
            int ht = 50;
            if (mediationNetworkInfo.mo39802j() > 0 && mediationNetworkInfo.mo39794e() > 0) {
                wt = mediationNetworkInfo.mo39802j();
                ht = mediationNetworkInfo.mo39794e();
            }
            InlineAdMetadata inlineAdMetadata = new InlineAdMetadata().setAdSize(new AdSize(wt, ht));
            this.f38619d = new Handler(Looper.getMainLooper());
            this.f38620e = new C12361x(this);
            this.f38619d.postDelayed(this.f38620e, 7500);
            this.f38616a.request(inlineAdMetadata);
        } catch (NoClassDefFoundError e) {
            m40649b();
        } catch (Exception e2) {
            m40650c();
        }
    }

    /* renamed from: a */
    public void mo39740a() {
        String str = "MMediaBanner";
        try {
            this.f38616a = null;
            if (this.f38619d != null && this.f38620e != null) {
                this.f38619d.removeCallbacksAndMessages(null);
                this.f38619d = null;
                this.f38620e = null;
            }
        } catch (NoClassDefFoundError e) {
            C12146d.m39965a(new C12147e(str, "NoClassDefFoundError in invalidating MMSDKMMediaBanner", 1, C12143a.ERROR));
        } catch (Exception e2) {
            C12146d.m39965a(new C12147e(str, "Exception in invalidating MMSDKMMediaBanner", 1, C12143a.ERROR));
        }
    }

    /* renamed from: a */
    public boolean mo39805a(C12360w mediationNetworkInfo) {
        if (mediationNetworkInfo == null) {
            return false;
        }
        try {
            if (mediationNetworkInfo.mo39782a() == null || mediationNetworkInfo.mo39782a().isEmpty()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            C12146d.m39965a(new C12147e("MMediaBanner", "Mediation inputs are invalidMMediaBanner", 1, C12143a.DEBUG));
        }
    }

    /* renamed from: b */
    private void m40649b() {
        C12146d.m39965a(new C12147e("MMediaBanner", "MillennialMedia dependencies missing. Check configurations of MMediaBanner", 1, C12143a.ERROR));
        C12346a aVar = this.f38617b;
        if (aVar != null) {
            aVar.mo39597a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        }
        mo39740a();
    }

    /* renamed from: c */
    private void m40650c() {
        C12146d.m39965a(new C12147e("MMediaBanner", "Exception happened with Mediation inputs. Check in MMediaBanner", 1, C12143a.ERROR));
        C12346a aVar = this.f38617b;
        if (aVar != null) {
            aVar.mo39597a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        }
        mo39740a();
    }
}
