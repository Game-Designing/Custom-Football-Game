package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.WebViewCacheService.Config;
import com.mopub.mobileads.factories.CustomEventInterstitialFactory;
import java.util.Map;
import java.util.TreeMap;

public class CustomEventInterstitialAdapter implements CustomEventInterstitialListener {
    public static final int DEFAULT_INTERSTITIAL_TIMEOUT_DELAY = 30000;

    /* renamed from: a */
    private final MoPubInterstitial f34730a;

    /* renamed from: b */
    private boolean f34731b;

    /* renamed from: c */
    private C11303a f34732c;

    /* renamed from: d */
    private CustomEventInterstitial f34733d;

    /* renamed from: e */
    private Context f34734e;

    /* renamed from: f */
    private Map<String, Object> f34735f;

    /* renamed from: g */
    private Map<String, String> f34736g;

    /* renamed from: h */
    private long f34737h;

    /* renamed from: i */
    private final Handler f34738i = new Handler();

    /* renamed from: j */
    private final Runnable f34739j;

    /* renamed from: com.mopub.mobileads.CustomEventInterstitialAdapter$a */
    interface C11303a {
        void onCustomEventInterstitialClicked();

        void onCustomEventInterstitialDismissed();

        void onCustomEventInterstitialFailed(MoPubErrorCode moPubErrorCode);

        void onCustomEventInterstitialImpression();

        void onCustomEventInterstitialLoaded();

        void onCustomEventInterstitialShown();
    }

    public CustomEventInterstitialAdapter(MoPubInterstitial moPubInterstitial, String className, Map<String, String> serverExtras, long broadcastIdentifier, AdReport adReport) {
        Preconditions.checkNotNull(serverExtras);
        this.f34730a = moPubInterstitial;
        this.f34737h = broadcastIdentifier;
        this.f34734e = this.f34730a.getActivity();
        this.f34739j = new C11469z(this);
        SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("Attempting to invoke custom event: ");
        sb.append(className);
        MoPubLog.log(sdkLogEvent, sb.toString());
        try {
            this.f34733d = CustomEventInterstitialFactory.create(className);
            this.f34736g = new TreeMap(serverExtras);
            this.f34735f = this.f34730a.getLocalExtras();
            if (this.f34730a.getLocation() != null) {
                this.f34735f.put("location", this.f34730a.getLocation());
            }
            this.f34735f.put(DataKeys.BROADCAST_IDENTIFIER_KEY, Long.valueOf(broadcastIdentifier));
            this.f34735f.put(DataKeys.AD_REPORT_KEY, adReport);
        } catch (Exception exception) {
            MoPubLog.log(SdkLogEvent.CUSTOM_WITH_THROWABLE, "CustomEventInterstitialFactory.create() failed with exception", exception);
            this.f34730a.onCustomEventInterstitialFailed(MoPubErrorCode.ADAPTER_NOT_FOUND);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo36984d() {
        if (!mo36983c() && this.f34733d != null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "loadInterstitial()");
            this.f34738i.postDelayed(this.f34739j, (long) m37332g());
            try {
                this.f34733d.loadInterstitial(this.f34734e, this, this.f34735f, this.f34736g);
            } catch (Exception e) {
                onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo36985e() {
        if (!mo36983c() && this.f34733d != null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "showInterstitial()");
            try {
                this.f34733d.showInterstitial();
            } catch (Exception e) {
                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("showInterstitial() failed with code ");
                sb.append(MoPubErrorCode.INTERNAL_ERROR.getIntCode());
                sb.append(" and message ");
                sb.append(MoPubErrorCode.INTERNAL_ERROR);
                MoPubLog.log(sdkLogEvent, sb.toString());
                onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36980a() {
        CustomEventInterstitial customEventInterstitial = this.f34733d;
        if (customEventInterstitial != null) {
            try {
                customEventInterstitial.onInvalidate();
            } catch (Exception e) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Invalidating a custom event interstitial threw an exception.", e);
            }
        }
        this.f34733d = null;
        this.f34734e = null;
        this.f34736g = null;
        this.f34735f = null;
        this.f34732c = null;
        Config config = WebViewCacheService.popWebViewConfig(Long.valueOf(this.f34737h));
        if (config != null) {
            config.getWebView().destroy();
        }
        this.f34731b = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo36983c() {
        return this.f34731b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36981a(C11303a listener) {
        this.f34732c = listener;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo36982b() {
        CustomEventInterstitial customEventInterstitial = this.f34733d;
        if (customEventInterstitial == null) {
            return true;
        }
        return customEventInterstitial.mo36972e();
    }

    /* renamed from: f */
    private void m37331f() {
        this.f34738i.removeCallbacks(this.f34739j);
    }

    /* renamed from: g */
    private int m37332g() {
        MoPubInterstitial moPubInterstitial = this.f34730a;
        if (moPubInterstitial == null) {
            return 30000;
        }
        return moPubInterstitial.mo37061a(30000).intValue();
    }

    public void onInterstitialLoaded() {
        if (!mo36983c()) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "onInterstitialLoaded()");
            m37331f();
            C11303a aVar = this.f34732c;
            if (aVar != null) {
                aVar.onCustomEventInterstitialLoaded();
            }
        }
    }

    public void onInterstitialFailed(MoPubErrorCode errorCode) {
        if (!mo36983c()) {
            if (errorCode == null) {
                errorCode = MoPubErrorCode.UNSPECIFIED;
            }
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("onInterstitialFailed() failed with code ");
            sb.append(errorCode.getIntCode());
            sb.append(" and message ");
            sb.append(errorCode);
            MoPubLog.log(sdkLogEvent, sb.toString());
            if (this.f34732c != null) {
                m37331f();
                this.f34732c.onCustomEventInterstitialFailed(errorCode);
            }
        }
    }

    public void onInterstitialShown() {
        if (!mo36983c()) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "onInterstitialShown()");
            C11303a aVar = this.f34732c;
            if (aVar != null) {
                aVar.onCustomEventInterstitialShown();
            }
        }
    }

    public void onInterstitialClicked() {
        if (!mo36983c()) {
            C11303a aVar = this.f34732c;
            if (aVar != null) {
                aVar.onCustomEventInterstitialClicked();
            }
        }
    }

    public void onInterstitialImpression() {
        if (!mo36983c()) {
            C11303a aVar = this.f34732c;
            if (aVar != null) {
                aVar.onCustomEventInterstitialImpression();
            }
        }
    }

    public void onLeaveApplication() {
        onInterstitialClicked();
    }

    public void onInterstitialDismissed() {
        if (!mo36983c()) {
            C11303a aVar = this.f34732c;
            if (aVar != null) {
                aVar.onCustomEventInterstitialDismissed();
            }
        }
    }
}
