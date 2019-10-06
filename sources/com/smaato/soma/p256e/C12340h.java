package com.smaato.soma.p256e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p256e.C12345k.C12346a;
import java.util.Map;

/* renamed from: com.smaato.soma.e.h */
/* compiled from: GooglePlayMediationBanner */
public class C12340h extends C12345k {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C12346a f38566a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AdView f38567b;

    /* renamed from: c */
    private Handler f38568c;

    /* renamed from: d */
    private Runnable f38569d;

    /* renamed from: com.smaato.soma.e.h$a */
    /* compiled from: GooglePlayMediationBanner */
    public class C12341a extends AdListener {
        public C12341a() {
        }

        public void onAdClosed() {
        }

        public void onAdFailedToLoad(int errorCode) {
            try {
                C12146d.m39965a(new C12147e("GooglePlayMediationBanner", "Google Play Services banner ad failed to load.", 1, C12143a.DEBUG));
                if (C12340h.this.f38566a != null) {
                    C12340h.this.f38566a.mo39597a(C12408ia.NETWORK_NO_FILL);
                }
                if (C12340h.this.f38567b != null) {
                    C12340h.this.f38567b.pause();
                }
                C12340h.this.mo39740a();
            } catch (NoClassDefFoundError e) {
                C12340h.this.m40565c();
            } catch (Exception e2) {
                C12340h.this.m40567d();
            }
        }

        public void onAdLeftApplication() {
            C12340h.this.mo39740a();
        }

        public void onAdLoaded() {
            try {
                C12340h.this.m40564b();
                C12146d.m39965a(new C12147e("GooglePlayMediationBanner", "Google Play Services banner ad loaded successfully. Showing ad...", 1, C12143a.DEBUG));
                if (C12340h.this.f38566a != null) {
                    C12340h.this.f38566a.mo39596a((View) C12340h.this.f38567b);
                }
            } catch (NoClassDefFoundError e) {
                C12340h.this.m40565c();
            } catch (Exception e2) {
                C12340h.this.m40567d();
            }
        }

        public void onAdOpened() {
            C12146d.m39965a(new C12147e("GooglePlayMediationBanner", "Google Play Services banner ad clicked.", 1, C12143a.DEBUG));
            if (C12340h.this.f38566a != null) {
                C12340h.this.f38566a.onBannerClicked();
            }
        }
    }

    /* renamed from: a */
    public void mo39755a(Context context, C12346a mediationEventBannerListener, Map<String, String> map, C12360w mediationNetworkInfo) {
        this.f38566a = mediationEventBannerListener;
        if (!m40562a(mediationNetworkInfo)) {
            this.f38566a.mo39597a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        try {
            this.f38567b = C12359v.m40618a().mo39776a(context);
            this.f38567b.setAdListener(new C12341a());
            this.f38567b.setAdUnitId(mediationNetworkInfo.mo39782a());
            AdSize adSize = AdSize.BANNER;
            if (mediationNetworkInfo.mo39802j() > 0 && mediationNetworkInfo.mo39794e() > 0) {
                adSize = mo39754a(mediationNetworkInfo.mo39802j(), mediationNetworkInfo.mo39794e());
            }
            if (adSize == null) {
                adSize = AdSize.BANNER;
            }
            this.f38567b.setAdSize(adSize);
            AdRequest adRequest = new Builder().setRequestAgent("Smaato").build();
            this.f38568c = new Handler();
            this.f38569d = new C12339g(this);
            this.f38568c.postDelayed(this.f38569d, 7500);
            this.f38567b.loadAd(adRequest);
        } catch (NoClassDefFoundError e) {
            m40565c();
        } catch (Exception e2) {
            m40567d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m40564b() {
        Handler handler = this.f38568c;
        if (handler != null) {
            Runnable runnable = this.f38569d;
            if (runnable != null) {
                handler.removeCallbacks(runnable);
                this.f38568c.removeCallbacksAndMessages(null);
                this.f38568c = null;
                this.f38569d = null;
            }
        }
        C12146d.m39965a(new C12147e("GooglePlayMediationBanner", "cancel Timeout called inGooglePlayMediationBanner", 1, C12143a.DEBUG));
    }

    /* renamed from: a */
    public void mo39740a() {
        try {
            C12330E.m40539a(this.f38567b);
            if (this.f38567b != null) {
                this.f38567b.destroy();
            }
            if (!(this.f38568c == null || this.f38569d == null)) {
                this.f38568c.removeCallbacks(this.f38569d);
                this.f38568c.removeCallbacksAndMessages(null);
                this.f38568c = null;
                this.f38569d = null;
            }
        } catch (NoClassDefFoundError e) {
            m40565c();
        } catch (Exception e2) {
            m40567d();
        }
    }

    /* renamed from: a */
    private boolean m40562a(C12360w mediationNetworkInfo) {
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

    /* renamed from: a */
    public AdSize mo39754a(int width, int height) {
        if (width <= AdSize.BANNER.getWidth() && height <= AdSize.BANNER.getHeight()) {
            return AdSize.BANNER;
        }
        if (width <= AdSize.MEDIUM_RECTANGLE.getWidth() && height <= AdSize.MEDIUM_RECTANGLE.getHeight()) {
            return AdSize.MEDIUM_RECTANGLE;
        }
        if (width <= AdSize.FULL_BANNER.getWidth() && height <= AdSize.FULL_BANNER.getHeight()) {
            return AdSize.FULL_BANNER;
        }
        if (width > AdSize.LEADERBOARD.getWidth() || height > AdSize.LEADERBOARD.getHeight()) {
            return null;
        }
        return AdSize.LEADERBOARD;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m40565c() {
        C12146d.m39965a(new C12147e("GooglePlayMediationBanner", "NoClassDefFoundError happened with Mediation. Check your configurations for GooglePlayMediationBanner", 1, C12143a.ERROR));
        this.f38566a.mo39597a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        mo39740a();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m40567d() {
        C12146d.m39965a(new C12147e("GooglePlayMediationBanner", "Exception happened with Mediation. Check inputs forGooglePlayMediationBanner", 1, C12143a.ERROR));
        this.f38566a.mo39597a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        mo39740a();
    }
}
