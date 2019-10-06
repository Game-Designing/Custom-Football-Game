package com.smaato.soma.p256e;

import android.content.Context;
import android.view.View;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.LogLevel;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.MoPubView.BannerAdListener;
import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p256e.C12345k.C12346a;
import java.util.Map;

/* renamed from: com.smaato.soma.e.B */
/* compiled from: MoPubMediationBanner */
public class C12325B extends C12345k {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C12346a f38534a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MoPubView f38535b;

    /* renamed from: com.smaato.soma.e.B$a */
    /* compiled from: MoPubMediationBanner */
    public class C12326a implements BannerAdListener {
        public C12326a() {
        }

        public void onBannerLoaded(MoPubView moPubView) {
            C12146d.m39965a(new C12147e("MoPubMediationBanner", "MoPub banner ad loaded successfully. Showing ad...", 1, C12143a.DEBUG));
            if (C12325B.this.f38534a != null) {
                C12325B.this.f38534a.mo39596a((View) C12325B.this.f38535b);
            }
        }

        public void onBannerFailed(MoPubView moPubView, MoPubErrorCode moPubErrorCode) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("MoPub banner ad failed to load. moPubErrorCode:");
                sb.append(moPubErrorCode);
                C12146d.m39965a(new C12147e("MoPubMediationBanner", sb.toString(), 1, C12143a.DEBUG));
                if (C12325B.this.f38534a != null) {
                    C12325B.this.f38534a.mo39597a(C12408ia.NETWORK_NO_FILL);
                }
                C12325B.this.mo39740a();
            } catch (NoClassDefFoundError e) {
                C12325B.this.m40520c();
            } catch (Exception e2) {
                C12325B.this.m40522d();
            } finally {
                C12325B.this.mo39740a();
            }
        }

        public void onBannerClicked(MoPubView moPubView) {
            try {
                C12146d.m39965a(new C12147e("MoPubMediationBanner", "MoPub banner ad clicked.", 1, C12143a.DEBUG));
                if (C12325B.this.f38534a != null) {
                    C12325B.this.f38534a.onBannerClicked();
                }
            } catch (NoClassDefFoundError e) {
                C12325B.this.m40520c();
            } catch (Exception e2) {
                C12325B.this.m40522d();
            }
        }

        public void onBannerExpanded(MoPubView moPubView) {
        }

        public void onBannerCollapsed(MoPubView moPubView) {
            C12325B.this.mo39740a();
        }
    }

    /* renamed from: a */
    public void mo39741a(Context context, C12346a mediationEventBannerListener, Map<String, String> map, C12360w mediationNetworkInfo) {
        this.f38534a = mediationEventBannerListener;
        if (!m40518a(mediationNetworkInfo)) {
            this.f38534a.mo39597a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        try {
            if (this.f38535b == null) {
                this.f38535b = C12359v.m40618a().mo39781c(context);
            }
            if (C12146d.f38074a > 1) {
                MoPubLog.setLogLevel(LogLevel.DEBUG);
            } else {
                MoPubLog.setLogLevel(LogLevel.NONE);
            }
            this.f38535b.setBannerAdListener(new C12326a());
            this.f38535b.setAdUnitId(mediationNetworkInfo.mo39782a());
            this.f38535b.setTimeout(7500);
            this.f38535b.setAutorefreshEnabled(false);
            this.f38535b.loadAd();
        } catch (NoClassDefFoundError e) {
            m40520c();
        } catch (Exception e2) {
            m40522d();
        }
    }

    /* renamed from: a */
    public void mo39740a() {
        try {
            C12330E.m40539a(this.f38535b);
        } catch (NoClassDefFoundError e) {
        } catch (Exception e2) {
        } finally {
            mo39742b();
        }
    }

    /* renamed from: b */
    public void mo39742b() {
        try {
            if (this.f38535b != null) {
                this.f38535b.destroy();
                this.f38535b = null;
            }
        } catch (NoClassDefFoundError e) {
        } catch (Exception e2) {
        }
    }

    /* renamed from: a */
    private boolean m40518a(C12360w mediationNetworkInfo) {
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
    /* renamed from: c */
    public void m40520c() {
        C12146d.m39965a(new C12147e("MoPubMediationBanner", "Dependencies missing. Check configurations of MoPubMediationBanner", 1, C12143a.ERROR));
        this.f38534a.mo39597a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        mo39740a();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m40522d() {
        C12146d.m39965a(new C12147e("MoPubMediationBanner", "Exception happened with Mediation inputs. Check in MoPubMediationBanner", 1, C12143a.ERROR));
        this.f38534a.mo39597a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        mo39740a();
    }
}
