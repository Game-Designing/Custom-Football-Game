package com.smaato.soma.p256e;

import android.content.Context;
import android.os.Handler;
import com.facebook.C6787r;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p256e.C12345k.C12346a;
import java.util.Map;

/* renamed from: com.smaato.soma.e.c */
/* compiled from: FacebookMediationBanner */
public class C12333c extends C12345k {

    /* renamed from: a */
    private AdView f38550a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C12346a f38551b;

    /* renamed from: c */
    private Handler f38552c;

    /* renamed from: d */
    private Runnable f38553d;

    /* renamed from: com.smaato.soma.e.c$a */
    /* compiled from: FacebookMediationBanner */
    public class C12334a implements AdListener {
        public C12334a() {
        }
    }

    /* renamed from: a */
    public void mo39746a(Context context, C12346a mediationEventBannerListener, Map<String, String> map, C12360w mediationNetworkInfo) {
        try {
            this.f38551b = mediationEventBannerListener;
            if (!m40542a(mediationNetworkInfo)) {
                this.f38551b.mo39597a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
                return;
            }
            if (mediationNetworkInfo.mo39786b() != null && !C6787r.m13829s()) {
                C6787r.m13806a(mediationNetworkInfo.mo39786b());
            }
            AdSize adSize = AdSize.BANNER_320_50;
            if (mediationNetworkInfo.mo39802j() > 0 && mediationNetworkInfo.mo39794e() > 0) {
                adSize = m40540a(mediationNetworkInfo.mo39802j(), mediationNetworkInfo.mo39794e());
            }
            this.f38552c = new Handler();
            this.f38553d = new C12332b(this);
            this.f38552c.postDelayed(this.f38553d, 7500);
            this.f38550a = C12359v.m40618a().mo39774a(context, mediationNetworkInfo.mo39782a(), adSize);
            this.f38550a.setAdListener(new C12334a());
            this.f38550a.disableAutoRefresh();
            this.f38550a.loadAd();
        } catch (NoClassDefFoundError e) {
            m40543c();
        } catch (Exception e2) {
            m40544d();
        }
    }

    /* renamed from: a */
    public void mo39740a() {
        try {
            C12330E.m40539a(this.f38550a);
            if (!(this.f38552c == null || this.f38553d == null)) {
                this.f38552c.removeCallbacks(this.f38553d);
                this.f38552c.removeCallbacksAndMessages(null);
                this.f38552c = null;
                this.f38553d = null;
            }
            mo39747b();
        } catch (NoClassDefFoundError e) {
            m40543c();
        } catch (Exception e2) {
            m40544d();
        }
    }

    /* renamed from: b */
    public void mo39747b() {
        try {
            if (this.f38550a != null) {
                this.f38550a.destroy();
                this.f38550a = null;
            }
        } catch (NoClassDefFoundError e) {
            m40543c();
        } catch (Exception e2) {
            m40544d();
        }
    }

    /* renamed from: a */
    private AdSize m40540a(int width, int height) {
        if (height <= AdSize.BANNER_320_50.getHeight()) {
            return AdSize.BANNER_320_50;
        }
        if (height <= AdSize.BANNER_HEIGHT_90.getHeight()) {
            return AdSize.BANNER_HEIGHT_90;
        }
        if (height <= AdSize.RECTANGLE_HEIGHT_250.getHeight()) {
            return AdSize.RECTANGLE_HEIGHT_250;
        }
        return null;
    }

    /* renamed from: c */
    private void m40543c() {
        C12146d.m39965a(new C12147e("FacebookMediationBanner", "NoClassDefFoundError happened with Mediation. Check your configurations for FacebookMediationBanner", 1, C12143a.ERROR));
        this.f38551b.mo39597a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
    }

    /* renamed from: a */
    private boolean m40542a(C12360w mediationNetworkInfo) {
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

    /* renamed from: d */
    private void m40544d() {
        C12146d.m39965a(new C12147e("FacebookMediationBanner", "Exception happened with Mediation. Check inputs forFacebookMediationBanner", 1, C12143a.ERROR));
        this.f38551b.mo39597a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
    }
}
