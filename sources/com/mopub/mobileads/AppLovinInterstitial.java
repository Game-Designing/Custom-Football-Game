package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.applovin.adview.C5860f;
import com.applovin.adview.C5861g;
import com.applovin.sdk.AppLovinAd;
import com.integralads.avid.library.mopub.BuildConfig;
import com.mopub.common.DataKeys;
import com.mopub.common.MoPub;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7252b;
import p019d.p143b.p150d.C7253c;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7257g;
import p019d.p143b.p150d.C7260j;
import p019d.p143b.p150d.C7266p;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7268r;

public class AppLovinInterstitial extends CustomEventInterstitial implements C7254d, C7253c, C7252b, C7260j {

    /* renamed from: b */
    private static final Handler f34676b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private static final Map<String, Queue<C7251a>> f34677c = new HashMap();

    /* renamed from: d */
    private static final Object f34678d = new Object();

    /* renamed from: e */
    private C7267q f34679e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CustomEventInterstitialListener f34680f;

    /* renamed from: g */
    private Context f34681g;

    /* renamed from: h */
    private String f34682h;

    /* renamed from: i */
    private boolean f34683i;

    /* renamed from: j */
    private C7251a f34684j;

    public void loadInterstitial(Context context, CustomEventInterstitialListener listener, Map<String, Object> localExtras, Map<String, String> serverExtras) {
        C7266p.m15793a(MoPub.canCollectPersonalInformation(), context);
        this.f34680f = listener;
        this.f34681g = context;
        this.f34679e = m37278a(serverExtras, context);
        this.f34679e.mo23054b("MoPub-3.1.0");
        this.f34679e.mo23045a(BuildConfig.SDK_NAME);
        String adMarkup = (String) serverExtras.get(DataKeys.ADM_KEY);
        boolean hasAdMarkup = !TextUtils.isEmpty(adMarkup);
        StringBuilder sb = new StringBuilder();
        sb.append("Requesting AppLovin interstitial with serverExtras: ");
        sb.append(serverExtras);
        sb.append(", localExtras: ");
        sb.append(localExtras);
        sb.append(" and has adMarkup: ");
        sb.append(hasAdMarkup);
        MoPubLog.m37080d(sb.toString());
        if (hasAdMarkup) {
            this.f34683i = true;
            this.f34679e.mo23037a().mo23014b(adMarkup, this);
            return;
        }
        String serverExtrasZoneId = (String) serverExtras.get("zone_id");
        this.f34682h = !TextUtils.isEmpty(serverExtrasZoneId) ? serverExtrasZoneId : "";
        C7251a preloadedAd = m37277a(this.f34682h);
        if (preloadedAd != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Found preloaded ad for zone: {");
            sb2.append(this.f34682h);
            sb2.append("}");
            MoPubLog.m37080d(sb2.toString());
            adReceived(preloadedAd);
        } else if (!TextUtils.isEmpty(this.f34682h)) {
            this.f34679e.mo23037a().mo23010a(this.f34682h, (C7254d) this);
        } else {
            this.f34679e.mo23037a().mo23008a(C7257g.f14096c, (C7254d) this);
        }
    }

    public void showInterstitial() {
        C7251a preloadedAd;
        if (!this.f34683i || this.f34684j == null) {
            preloadedAd = m37277a(this.f34682h);
        } else {
            preloadedAd = this.f34684j;
        }
        if (preloadedAd != null) {
            C5861g interstitialAd = C5860f.m10676a(this.f34679e, this.f34681g);
            interstitialAd.mo18323a((C7253c) this);
            interstitialAd.mo18322a((C7252b) this);
            interstitialAd.mo18324a((C7260j) this);
            interstitialAd.mo18320a(preloadedAd);
            return;
        }
        MoPubLog.m37080d("Failed to show an AppLovin interstitial before one was loaded");
        CustomEventInterstitialListener customEventInterstitialListener = this.f34680f;
        if (customEventInterstitialListener != null) {
            customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
        }
    }

    public void onInvalidate() {
    }

    public void adReceived(C7251a ad) {
        StringBuilder sb = new StringBuilder();
        sb.append("Interstitial did load ad: ");
        sb.append(ad.mo22758b());
        MoPubLog.m37080d(sb.toString());
        if (this.f34683i) {
            this.f34684j = ad;
        } else {
            m37279a(ad, this.f34682h);
        }
        m37280a((Runnable) new C11424m(this));
    }

    public void failedToReceiveAd(int errorCode) {
        StringBuilder sb = new StringBuilder();
        sb.append("Interstitial failed to load with error: ");
        sb.append(errorCode);
        MoPubLog.m37080d(sb.toString());
        m37280a((Runnable) new C11427n(this, errorCode));
    }

    public void adDisplayed(C7251a appLovinAd) {
        MoPubLog.m37080d("Interstitial displayed");
        CustomEventInterstitialListener customEventInterstitialListener = this.f34680f;
        if (customEventInterstitialListener != null) {
            customEventInterstitialListener.onInterstitialShown();
        }
    }

    public void adHidden(C7251a appLovinAd) {
        MoPubLog.m37080d("Interstitial dismissed");
        CustomEventInterstitialListener customEventInterstitialListener = this.f34680f;
        if (customEventInterstitialListener != null) {
            customEventInterstitialListener.onInterstitialDismissed();
        }
    }

    public void adClicked(C7251a appLovinAd) {
        MoPubLog.m37080d("Interstitial clicked");
        CustomEventInterstitialListener customEventInterstitialListener = this.f34680f;
        if (customEventInterstitialListener != null) {
            customEventInterstitialListener.onLeaveApplication();
        }
    }

    public void videoPlaybackBegan(C7251a ad) {
        MoPubLog.m37080d("Interstitial video playback began");
    }

    public void videoPlaybackEnded(C7251a ad, double percentViewed, boolean fullyWatched) {
        StringBuilder sb = new StringBuilder();
        sb.append("Interstitial video playback ended at playback percent: ");
        sb.append(percentViewed);
        MoPubLog.m37080d(sb.toString());
    }

    /* renamed from: a */
    private static C7251a m37277a(String zoneId) {
        C7251a preloadedAd;
        synchronized (f34678d) {
            preloadedAd = null;
            Queue<AppLovinAd> preloadedAds = (Queue) f34677c.get(zoneId);
            if (preloadedAds != null && !preloadedAds.isEmpty()) {
                preloadedAd = (C7251a) preloadedAds.poll();
            }
        }
        return preloadedAd;
    }

    /* renamed from: a */
    private static void m37279a(C7251a ad, String zoneId) {
        synchronized (f34678d) {
            Queue queue = (Queue) f34677c.get(zoneId);
            if (queue == null) {
                queue = new LinkedList();
                f34677c.put(zoneId, queue);
            }
            queue.offer(ad);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static MoPubErrorCode m37281b(int applovinErrorCode) {
        if (applovinErrorCode == 204) {
            return MoPubErrorCode.NETWORK_NO_FILL;
        }
        if (applovinErrorCode == -1) {
            return MoPubErrorCode.UNSPECIFIED;
        }
        if (applovinErrorCode == -103) {
            return MoPubErrorCode.NO_CONNECTION;
        }
        if (applovinErrorCode == -102) {
            return MoPubErrorCode.NETWORK_TIMEOUT;
        }
        return MoPubErrorCode.UNSPECIFIED;
    }

    /* renamed from: a */
    private static C7267q m37278a(Map<String, String> serverExtras, Context context) {
        String sdkKey = serverExtras != null ? (String) serverExtras.get("sdk_key") : null;
        if (!TextUtils.isEmpty(sdkKey)) {
            return C7267q.m15795a(sdkKey, new C7268r(), context);
        }
        return C7267q.m15794a(context);
    }

    /* renamed from: a */
    private static void m37280a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f34676b.post(runnable);
        }
    }
}
