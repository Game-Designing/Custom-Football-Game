package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.ads.InMobiInterstitial.InterstitialAdListener2;
import com.inmobi.ads.listeners.InterstitialAdEventListener;
import com.inmobi.sdk.InMobiSdk;
import com.inmobi.sdk.InMobiSdk.LogLevel;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPubReward;
import com.mopub.mobileads.CustomEventRewardedVideo;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubRewardedVideoManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.json.JSONException;
import org.json.JSONObject;

public class InMobiRewardedCustomEvent extends CustomEventRewardedVideo implements InterstitialAdListener2 {

    /* renamed from: a */
    private static final String f35739a = InMobiRewardedCustomEvent.class.getSimpleName();

    /* renamed from: b */
    private static transient /* synthetic */ boolean[] f35740b;

    /* renamed from: c */
    private boolean f35741c = false;

    /* renamed from: d */
    private InMobiInterstitial f35742d;

    /* renamed from: e */
    private JSONObject f35743e;

    /* renamed from: f */
    private String f35744f;

    /* renamed from: g */
    private String f35745g;

    /* renamed from: e */
    private static /* synthetic */ boolean[] m38184e() {
        boolean[] zArr = f35740b;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6401763077670406768L, "com/mopub/nativeads/InMobiRewardedCustomEvent", 98);
        f35740b = probes;
        return probes;
    }

    public InMobiRewardedCustomEvent() {
        boolean[] e = m38184e();
        String str = "";
        this.f35744f = str;
        this.f35745g = str;
        e[0] = true;
    }

    /* renamed from: a */
    static /* synthetic */ String m38182a(InMobiRewardedCustomEvent x0) {
        boolean[] e = m38184e();
        String str = x0.f35745g;
        e[96] = true;
        return str;
    }

    /* renamed from: d */
    static /* synthetic */ String m38183d() {
        boolean[] e = m38184e();
        String str = f35739a;
        e[95] = true;
        return str;
    }

    static {
        boolean[] e = m38184e();
        e[97] = true;
    }

    /* access modifiers changed from: protected */
    public LifecycleListener getLifecycleListener() {
        m38184e()[1] = true;
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity activity, Map<String, Object> map, Map<String, String> serverExtras) throws Exception {
        boolean[] e = m38184e();
        try {
            this.f35743e = new JSONObject(serverExtras);
            e[2] = true;
        } catch (Exception e2) {
            e[3] = true;
            Log.e(f35739a, "Could not parse server parameters");
            e[4] = true;
            e2.printStackTrace();
            try {
                e[5] = true;
            } catch (JSONException e1) {
                e[8] = true;
                e1.printStackTrace();
                e[9] = true;
            }
        }
        this.f35744f = this.f35743e.getString("accountid");
        e[6] = true;
        this.f35745g = this.f35743e.getString("placementid");
        e[7] = true;
        JSONObject gdprJson = new JSONObject();
        e[10] = true;
        if (!InMobiGDPR.isConsentUpdated()) {
            e[11] = true;
        } else {
            try {
                e[12] = true;
                gdprJson.put(InMobiSdk.IM_GDPR_CONSENT_AVAILABLE, InMobiGDPR.m38160a());
                e[13] = true;
                gdprJson.put("gdpr", InMobiGDPR.m38161b());
                e[14] = true;
            } catch (JSONException e3) {
                e[15] = true;
                Log.d(f35739a, "Unable to set GDPR consent object");
                e[16] = true;
                Log.e(f35739a, e3.getMessage());
                e[17] = true;
            }
        }
        if (this.f35741c) {
            e[18] = true;
        } else {
            try {
                e[19] = true;
                InMobiSdk.init(activity, this.f35744f, gdprJson);
                this.f35741c = true;
                e[20] = true;
            } catch (Exception e4) {
                e[21] = true;
                e4.printStackTrace();
                this.f35741c = false;
                e[22] = true;
                return false;
            }
        }
        e[23] = true;
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36905b(Activity activity, Map<String, Object> map, Map<String, String> map2) throws Exception {
        boolean[] e = m38184e();
        InMobiSdk.setLogLevel(LogLevel.DEBUG);
        e[24] = true;
        this.f35742d = new InMobiInterstitial((Context) activity, Long.parseLong(getAdNetworkId()), (InterstitialAdEventListener) new C11649v(this));
        e[25] = true;
        Map<String, String> map3 = new HashMap<>();
        e[26] = true;
        map3.put("tp", "c_mopub");
        e[27] = true;
        map3.put("tp-ver", "5.7.1");
        e[28] = true;
        this.f35742d.setExtras(map3);
        e[29] = true;
        this.f35742d.load();
        e[30] = true;
    }

    /* access modifiers changed from: protected */
    public String getAdNetworkId() {
        boolean[] e = m38184e();
        String str = this.f35745g;
        e[31] = true;
        return str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36904b() {
        m38184e()[32] = true;
    }

    /* access modifiers changed from: protected */
    public boolean hasVideoAvailable() {
        boolean z;
        boolean[] e = m38184e();
        InMobiInterstitial inMobiInterstitial = this.f35742d;
        if (inMobiInterstitial == null) {
            e[33] = true;
        } else if (!inMobiInterstitial.isReady()) {
            e[34] = true;
        } else {
            e[35] = true;
            z = true;
            e[37] = true;
            return z;
        }
        z = false;
        e[36] = true;
        e[37] = true;
        return z;
    }

    /* access modifiers changed from: protected */
    public void showVideo() {
        boolean[] e = m38184e();
        if (hasVideoAvailable()) {
            e[38] = true;
            this.f35742d.show();
            e[39] = true;
        } else {
            MoPubRewardedVideoManager.onRewardedVideoPlaybackError(InMobiRewardedCustomEvent.class, this.f35745g, MoPubErrorCode.VIDEO_PLAYBACK_ERROR);
            e[40] = true;
        }
        e[41] = true;
    }

    public void onAdLoadFailed(InMobiInterstitial ad, InMobiAdRequestStatus status) {
        boolean[] e = m38184e();
        String str = f35739a;
        StringBuilder sb = new StringBuilder();
        sb.append("Ad failed to load:");
        StatusCode statusCode = status.getStatusCode();
        e[42] = true;
        sb.append(statusCode.toString());
        String sb2 = sb.toString();
        e[43] = true;
        Log.v(str, sb2);
        e[44] = true;
        if (status.getStatusCode() == StatusCode.INTERNAL_ERROR) {
            e[45] = true;
            String adNetworkId = getAdNetworkId();
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.INTERNAL_ERROR;
            e[46] = true;
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(InMobiRewardedCustomEvent.class, adNetworkId, moPubErrorCode);
            e[47] = true;
        } else if (status.getStatusCode() == StatusCode.REQUEST_INVALID) {
            e[48] = true;
            String adNetworkId2 = getAdNetworkId();
            MoPubErrorCode moPubErrorCode2 = MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
            e[49] = true;
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(InMobiRewardedCustomEvent.class, adNetworkId2, moPubErrorCode2);
            e[50] = true;
        } else if (status.getStatusCode() == StatusCode.NETWORK_UNREACHABLE) {
            e[51] = true;
            String adNetworkId3 = getAdNetworkId();
            MoPubErrorCode moPubErrorCode3 = MoPubErrorCode.NETWORK_INVALID_STATE;
            e[52] = true;
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(InMobiRewardedCustomEvent.class, adNetworkId3, moPubErrorCode3);
            e[53] = true;
        } else if (status.getStatusCode() == StatusCode.NO_FILL) {
            e[54] = true;
            String adNetworkId4 = getAdNetworkId();
            MoPubErrorCode moPubErrorCode4 = MoPubErrorCode.NO_FILL;
            e[55] = true;
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(InMobiRewardedCustomEvent.class, adNetworkId4, moPubErrorCode4);
            e[56] = true;
        } else if (status.getStatusCode() == StatusCode.REQUEST_TIMED_OUT) {
            e[57] = true;
            String adNetworkId5 = getAdNetworkId();
            MoPubErrorCode moPubErrorCode5 = MoPubErrorCode.NETWORK_TIMEOUT;
            e[58] = true;
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(InMobiRewardedCustomEvent.class, adNetworkId5, moPubErrorCode5);
            e[59] = true;
        } else if (status.getStatusCode() == StatusCode.SERVER_ERROR) {
            e[60] = true;
            String adNetworkId6 = getAdNetworkId();
            MoPubErrorCode moPubErrorCode6 = MoPubErrorCode.SERVER_ERROR;
            e[61] = true;
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(InMobiRewardedCustomEvent.class, adNetworkId6, moPubErrorCode6);
            e[62] = true;
        } else {
            e[63] = true;
            String adNetworkId7 = getAdNetworkId();
            MoPubErrorCode moPubErrorCode7 = MoPubErrorCode.UNSPECIFIED;
            e[64] = true;
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(InMobiRewardedCustomEvent.class, adNetworkId7, moPubErrorCode7);
            e[65] = true;
        }
        e[66] = true;
    }

    public void onAdReceived(InMobiInterstitial ad) {
        boolean[] e = m38184e();
        Log.d(f35739a, "InMobi Adserver responded with an Ad");
        e[67] = true;
    }

    public void onAdLoadSucceeded(InMobiInterstitial ad) {
        boolean[] e = m38184e();
        Log.v(f35739a, "Ad load succeeded");
        if (ad == null) {
            e[68] = true;
        } else {
            e[69] = true;
            MoPubRewardedVideoManager.onRewardedVideoLoadSuccess(InMobiRewardedCustomEvent.class, this.f35745g);
            e[70] = true;
        }
        e[71] = true;
    }

    public void onAdRewardActionCompleted(InMobiInterstitial ad, Map<Object, Object> rewards) {
        boolean[] e = m38184e();
        Log.d(f35739a, "InMobi Rewarded video onRewardActionCompleted.");
        if (rewards == null) {
            e[72] = true;
        } else {
            e[73] = true;
            Set keySet = rewards.keySet();
            e[74] = true;
            String key = "";
            String value = "";
            e[75] = true;
            for (Object next : keySet) {
                e[76] = true;
                e[77] = true;
                key = next.toString();
                e[78] = true;
                Object obj = rewards.get(key);
                e[79] = true;
                value = obj.toString();
                e[80] = true;
                StringBuilder sb = new StringBuilder();
                sb.append(key);
                sb.append(":");
                sb.append(value);
                Log.d("Rewards: ", sb.toString());
                e[81] = true;
            }
            e[82] = true;
            MoPubReward success = MoPubReward.success(key, Integer.parseInt(value));
            e[83] = true;
            MoPubRewardedVideoManager.onRewardedVideoCompleted(InMobiRewardedCustomEvent.class, null, success);
            e[84] = true;
        }
        e[85] = true;
    }

    public void onAdDisplayFailed(InMobiInterstitial ad) {
        boolean[] e = m38184e();
        Log.d(f35739a, "Rewarded video ad failed to display.");
        e[86] = true;
    }

    public void onAdWillDisplay(InMobiInterstitial ad) {
        boolean[] e = m38184e();
        Log.d(f35739a, "Rewarded video ad will display.");
        e[87] = true;
    }

    public void onAdDisplayed(InMobiInterstitial ad) {
        boolean[] e = m38184e();
        Log.v(f35739a, "Ad displayed");
        e[88] = true;
        MoPubRewardedVideoManager.onRewardedVideoStarted(InMobiRewardedCustomEvent.class, this.f35745g);
        e[89] = true;
    }

    public void onAdInteraction(InMobiInterstitial ad, Map<Object, Object> map) {
        boolean[] e = m38184e();
        Log.v(f35739a, "Ad interaction");
        e[90] = true;
        MoPubRewardedVideoManager.onRewardedVideoClicked(InMobiRewardedCustomEvent.class, this.f35745g);
        e[91] = true;
    }

    public void onAdDismissed(InMobiInterstitial ad) {
        boolean[] e = m38184e();
        Log.v(f35739a, "Ad dismissed");
        e[92] = true;
        MoPubRewardedVideoManager.onRewardedVideoClosed(InMobiRewardedCustomEvent.class, this.f35745g);
        e[93] = true;
    }

    public void onUserLeftApplication(InMobiInterstitial ad) {
        boolean[] e = m38184e();
        Log.v(f35739a, "User left application");
        e[94] = true;
    }
}
