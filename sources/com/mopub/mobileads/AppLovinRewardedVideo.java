package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.applovin.adview.C5859e;
import com.integralads.avid.library.mopub.BuildConfig;
import com.mopub.common.DataKeys;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPub;
import com.mopub.common.MoPubReward;
import com.mopub.common.logging.MoPubLog;
import java.util.HashMap;
import java.util.Map;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7252b;
import p019d.p143b.p150d.C7253c;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7255e;
import p019d.p143b.p150d.C7260j;
import p019d.p143b.p150d.C7266p;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7268r;

public class AppLovinRewardedVideo extends CustomEventRewardedVideo implements C7254d, C7253c, C7252b, C7260j, C7255e {

    /* renamed from: a */
    private static final Map<String, C5859e> f34685a = new HashMap();

    /* renamed from: b */
    private boolean f34686b;

    /* renamed from: c */
    private C7267q f34687c;

    /* renamed from: d */
    private C5859e f34688d;

    /* renamed from: e */
    private Activity f34689e;

    /* renamed from: f */
    private boolean f34690f;

    /* renamed from: g */
    private MoPubReward f34691g;

    /* renamed from: h */
    private boolean f34692h;

    /* renamed from: i */
    private C7251a f34693i;

    /* renamed from: j */
    private String f34694j = "";

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity activity, Map<String, Object> map, Map<String, String> serverExtras) throws Exception {
        C7266p.m15793a(MoPub.canCollectPersonalInformation(), activity.getApplicationContext());
        MoPubLog.m37080d("Initializing AppLovin rewarded video...");
        if (this.f34686b) {
            return false;
        }
        this.f34687c = m37284a(serverExtras, activity);
        this.f34687c.mo23054b("MoPub-3.1.0");
        this.f34687c.mo23045a(BuildConfig.SDK_NAME);
        this.f34686b = true;
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36905b(Activity activity, Map<String, Object> localExtras, Map<String, String> serverExtras) throws Exception {
        String zoneId;
        this.f34689e = activity;
        String adMarkup = (String) serverExtras.get(DataKeys.ADM_KEY);
        boolean hasAdMarkup = !TextUtils.isEmpty(adMarkup);
        StringBuilder sb = new StringBuilder();
        sb.append("Requesting AppLovin banner with serverExtras: ");
        sb.append(serverExtras);
        sb.append(", localExtras: ");
        sb.append(localExtras);
        sb.append(" and has ad markup: ");
        sb.append(hasAdMarkup);
        MoPubLog.m37080d(sb.toString());
        if (hasAdMarkup) {
            zoneId = "token";
        } else {
            String zoneId2 = "zone_id";
            if (!TextUtils.isEmpty((CharSequence) serverExtras.get(zoneId2))) {
                this.f34694j = (String) serverExtras.get(zoneId2);
                zoneId = this.f34694j;
            } else {
                zoneId = "";
            }
        }
        this.f34688d = m37282a(zoneId, activity, this.f34687c);
        if (hasAdMarkup) {
            this.f34692h = true;
            this.f34687c.mo23037a().mo23014b(adMarkup, this);
            return;
        }
        this.f34688d.mo18317a((C7254d) this);
    }

    /* access modifiers changed from: protected */
    public void showVideo() {
        if (hasVideoAvailable()) {
            this.f34690f = false;
            this.f34691g = null;
            if (this.f34692h) {
                this.f34688d.mo18316a(this.f34693i, (Context) this.f34689e, (C7255e) this, (C7260j) this, (C7253c) this, (C7252b) this);
            } else {
                this.f34688d.mo18315a((Context) this.f34689e, (String) null, (C7255e) this, (C7260j) this, (C7253c) this, (C7252b) this);
            }
        } else {
            MoPubLog.m37080d("Failed to show an AppLovin rewarded video before one was loaded");
            MoPubRewardedVideoManager.onRewardedVideoPlaybackError(getClass(), getAdNetworkId(), MoPubErrorCode.VIDEO_PLAYBACK_ERROR);
        }
    }

    /* access modifiers changed from: protected */
    public boolean hasVideoAvailable() {
        boolean z = true;
        if (this.f34692h) {
            if (this.f34693i == null) {
                z = false;
            }
            return z;
        }
        C5859e eVar = this.f34688d;
        if (eVar == null || !eVar.mo18318a()) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public LifecycleListener getLifecycleListener() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getAdNetworkId() {
        return this.f34694j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36904b() {
    }

    public void adReceived(C7251a ad) {
        StringBuilder sb = new StringBuilder();
        sb.append("Rewarded video did load ad: ");
        sb.append(ad.mo22758b());
        MoPubLog.m37080d(sb.toString());
        if (this.f34692h) {
            this.f34693i = ad;
        }
        this.f34689e.runOnUiThread(new C11434o(this));
    }

    public void failedToReceiveAd(int errorCode) {
        StringBuilder sb = new StringBuilder();
        sb.append("Rewarded video failed to load with error: ");
        sb.append(errorCode);
        MoPubLog.m37080d(sb.toString());
        this.f34689e.runOnUiThread(new C11437p(this, errorCode));
    }

    public void adDisplayed(C7251a ad) {
        MoPubLog.m37080d("Rewarded video displayed");
        MoPubRewardedVideoManager.onRewardedVideoStarted(getClass(), getAdNetworkId());
    }

    public void adHidden(C7251a ad) {
        MoPubLog.m37080d("Rewarded video dismissed");
        if (this.f34690f && this.f34691g != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Rewarded");
            sb.append(this.f34691g.getAmount());
            sb.append(" ");
            sb.append(this.f34691g.getLabel());
            MoPubLog.m37080d(sb.toString());
            MoPubRewardedVideoManager.onRewardedVideoCompleted(getClass(), getAdNetworkId(), this.f34691g);
        }
        MoPubRewardedVideoManager.onRewardedVideoClosed(getClass(), getAdNetworkId());
    }

    public void adClicked(C7251a ad) {
        MoPubLog.m37080d("Rewarded video clicked");
        MoPubRewardedVideoManager.onRewardedVideoClicked(getClass(), getAdNetworkId());
    }

    public void videoPlaybackBegan(C7251a ad) {
        MoPubLog.m37080d("Rewarded video playback began");
    }

    public void videoPlaybackEnded(C7251a ad, double percentViewed, boolean fullyWatched) {
        StringBuilder sb = new StringBuilder();
        sb.append("Rewarded video playback ended at playback percent: ");
        sb.append(percentViewed);
        MoPubLog.m37080d(sb.toString());
        this.f34690f = fullyWatched;
    }

    public void userOverQuota(C7251a appLovinAd, Map map) {
        StringBuilder sb = new StringBuilder();
        sb.append("Rewarded video validation request for ad did exceed quota with response: ");
        sb.append(map);
        MoPubLog.m37080d(sb.toString());
    }

    public void validationRequestFailed(C7251a appLovinAd, int errorCode) {
        StringBuilder sb = new StringBuilder();
        sb.append("Rewarded video validation request for ad failed with error code: ");
        sb.append(errorCode);
        MoPubLog.m37080d(sb.toString());
    }

    public void userRewardRejected(C7251a appLovinAd, Map map) {
        StringBuilder sb = new StringBuilder();
        sb.append("Rewarded video validation request was rejected with response: ");
        sb.append(map);
        MoPubLog.m37080d(sb.toString());
    }

    public void userDeclinedToViewAd(C7251a appLovinAd) {
        MoPubLog.m37080d("User declined to view rewarded video");
        MoPubRewardedVideoManager.onRewardedVideoClosed(getClass(), getAdNetworkId());
    }

    public void userRewardVerified(C7251a appLovinAd, Map map) {
        String currency = (String) map.get("currency");
        int amount = (int) Double.parseDouble((String) map.get("amount"));
        StringBuilder sb = new StringBuilder();
        sb.append("Verified ");
        sb.append(amount);
        sb.append(" ");
        sb.append(currency);
        MoPubLog.m37080d(sb.toString());
        this.f34691g = MoPubReward.success(currency, amount);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static MoPubErrorCode m37285b(int applovinErrorCode) {
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
    private static C7267q m37284a(Map<String, String> serverExtras, Context context) {
        String sdkKey = serverExtras != null ? (String) serverExtras.get("sdk_key") : null;
        if (!TextUtils.isEmpty(sdkKey)) {
            return C7267q.m15795a(sdkKey, new C7268r(), context);
        }
        return C7267q.m15794a(context);
    }

    /* renamed from: a */
    private static C5859e m37282a(String zoneId, Activity activity, C7267q sdk) {
        C5859e incent;
        if (f34685a.containsKey(zoneId)) {
            return (C5859e) f34685a.get(zoneId);
        }
        if ("".equals(zoneId) || "token".equals(zoneId)) {
            incent = C5859e.m10668a((Context) activity);
        } else {
            incent = C5859e.m10670a(zoneId, sdk);
        }
        f34685a.put(zoneId, incent);
        return incent;
    }
}
