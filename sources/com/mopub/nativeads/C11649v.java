package com.mopub.nativeads;

import android.util.Log;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.ads.listeners.InterstitialAdEventListener;
import com.mopub.common.MoPubReward;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubRewardedVideoManager;
import java.util.Map;
import java.util.Set;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.v */
/* compiled from: InMobiRewardedCustomEvent */
class C11649v extends InterstitialAdEventListener {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36246a;

    /* renamed from: b */
    final /* synthetic */ InMobiRewardedCustomEvent f36247b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38472a() {
        boolean[] zArr = f36246a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1932032682092795542L, "com/mopub/nativeads/InMobiRewardedCustomEvent$1", 68);
        f36246a = probes;
        return probes;
    }

    C11649v(InMobiRewardedCustomEvent this$0) {
        boolean[] a = m38472a();
        this.f36247b = this$0;
        a[0] = true;
    }

    public void onAdLoadSucceeded(InMobiInterstitial inMobiInterstitial) {
        boolean[] a = m38472a();
        super.onAdLoadSucceeded(inMobiInterstitial);
        a[1] = true;
        Log.v(InMobiRewardedCustomEvent.m38183d(), "Ad load succeeded");
        if (inMobiInterstitial == null) {
            a[2] = true;
        } else {
            InMobiRewardedCustomEvent inMobiRewardedCustomEvent = this.f36247b;
            a[3] = true;
            String a2 = InMobiRewardedCustomEvent.m38182a(inMobiRewardedCustomEvent);
            a[4] = true;
            MoPubRewardedVideoManager.onRewardedVideoLoadSuccess(InMobiRewardedCustomEvent.class, a2);
            a[5] = true;
        }
        a[6] = true;
    }

    public void onAdLoadFailed(InMobiInterstitial inMobiInterstitial, InMobiAdRequestStatus inMobiAdRequestStatus) {
        boolean[] a = m38472a();
        super.onAdLoadFailed(inMobiInterstitial, inMobiAdRequestStatus);
        a[7] = true;
        String d = InMobiRewardedCustomEvent.m38183d();
        StringBuilder sb = new StringBuilder();
        sb.append("Ad failed to load:");
        StatusCode statusCode = inMobiAdRequestStatus.getStatusCode();
        a[8] = true;
        sb.append(statusCode.toString());
        String sb2 = sb.toString();
        a[9] = true;
        Log.v(d, sb2);
        a[10] = true;
        if (inMobiAdRequestStatus.getStatusCode() == StatusCode.INTERNAL_ERROR) {
            InMobiRewardedCustomEvent inMobiRewardedCustomEvent = this.f36247b;
            a[11] = true;
            String adNetworkId = inMobiRewardedCustomEvent.getAdNetworkId();
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.INTERNAL_ERROR;
            a[12] = true;
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(InMobiRewardedCustomEvent.class, adNetworkId, moPubErrorCode);
            a[13] = true;
        } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.REQUEST_INVALID) {
            InMobiRewardedCustomEvent inMobiRewardedCustomEvent2 = this.f36247b;
            a[14] = true;
            String adNetworkId2 = inMobiRewardedCustomEvent2.getAdNetworkId();
            MoPubErrorCode moPubErrorCode2 = MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
            a[15] = true;
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(InMobiRewardedCustomEvent.class, adNetworkId2, moPubErrorCode2);
            a[16] = true;
        } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.NETWORK_UNREACHABLE) {
            InMobiRewardedCustomEvent inMobiRewardedCustomEvent3 = this.f36247b;
            a[17] = true;
            String adNetworkId3 = inMobiRewardedCustomEvent3.getAdNetworkId();
            MoPubErrorCode moPubErrorCode3 = MoPubErrorCode.NETWORK_INVALID_STATE;
            a[18] = true;
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(InMobiRewardedCustomEvent.class, adNetworkId3, moPubErrorCode3);
            a[19] = true;
        } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.NO_FILL) {
            InMobiRewardedCustomEvent inMobiRewardedCustomEvent4 = this.f36247b;
            a[20] = true;
            String adNetworkId4 = inMobiRewardedCustomEvent4.getAdNetworkId();
            MoPubErrorCode moPubErrorCode4 = MoPubErrorCode.NO_FILL;
            a[21] = true;
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(InMobiRewardedCustomEvent.class, adNetworkId4, moPubErrorCode4);
            a[22] = true;
        } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.REQUEST_TIMED_OUT) {
            InMobiRewardedCustomEvent inMobiRewardedCustomEvent5 = this.f36247b;
            a[23] = true;
            String adNetworkId5 = inMobiRewardedCustomEvent5.getAdNetworkId();
            MoPubErrorCode moPubErrorCode5 = MoPubErrorCode.NETWORK_TIMEOUT;
            a[24] = true;
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(InMobiRewardedCustomEvent.class, adNetworkId5, moPubErrorCode5);
            a[25] = true;
        } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.SERVER_ERROR) {
            InMobiRewardedCustomEvent inMobiRewardedCustomEvent6 = this.f36247b;
            a[26] = true;
            String adNetworkId6 = inMobiRewardedCustomEvent6.getAdNetworkId();
            MoPubErrorCode moPubErrorCode6 = MoPubErrorCode.SERVER_ERROR;
            a[27] = true;
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(InMobiRewardedCustomEvent.class, adNetworkId6, moPubErrorCode6);
            a[28] = true;
        } else {
            InMobiRewardedCustomEvent inMobiRewardedCustomEvent7 = this.f36247b;
            a[29] = true;
            String adNetworkId7 = inMobiRewardedCustomEvent7.getAdNetworkId();
            MoPubErrorCode moPubErrorCode7 = MoPubErrorCode.UNSPECIFIED;
            a[30] = true;
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(InMobiRewardedCustomEvent.class, adNetworkId7, moPubErrorCode7);
            a[31] = true;
        }
        a[32] = true;
    }

    public void onAdReceived(InMobiInterstitial inMobiInterstitial) {
        boolean[] a = m38472a();
        super.onAdReceived(inMobiInterstitial);
        a[33] = true;
        Log.d(InMobiRewardedCustomEvent.m38183d(), "InMobi Adserver responded with an Ad");
        a[34] = true;
    }

    public void onAdClicked(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
        boolean[] a = m38472a();
        super.onAdClicked(inMobiInterstitial, map);
        a[35] = true;
        Log.v(InMobiRewardedCustomEvent.m38183d(), "Ad interaction");
        InMobiRewardedCustomEvent inMobiRewardedCustomEvent = this.f36247b;
        a[36] = true;
        String a2 = InMobiRewardedCustomEvent.m38182a(inMobiRewardedCustomEvent);
        a[37] = true;
        MoPubRewardedVideoManager.onRewardedVideoClicked(InMobiRewardedCustomEvent.class, a2);
        a[38] = true;
    }

    public void onAdWillDisplay(InMobiInterstitial inMobiInterstitial) {
        boolean[] a = m38472a();
        super.onAdWillDisplay(inMobiInterstitial);
        a[39] = true;
        Log.d(InMobiRewardedCustomEvent.m38183d(), "Rewarded video ad will display.");
        a[40] = true;
    }

    public void onAdDisplayed(InMobiInterstitial inMobiInterstitial) {
        boolean[] a = m38472a();
        super.onAdDisplayed(inMobiInterstitial);
        a[41] = true;
        Log.v(InMobiRewardedCustomEvent.m38183d(), "Ad displayed");
        InMobiRewardedCustomEvent inMobiRewardedCustomEvent = this.f36247b;
        a[42] = true;
        String a2 = InMobiRewardedCustomEvent.m38182a(inMobiRewardedCustomEvent);
        a[43] = true;
        MoPubRewardedVideoManager.onRewardedVideoStarted(InMobiRewardedCustomEvent.class, a2);
        a[44] = true;
    }

    public void onAdDisplayFailed(InMobiInterstitial inMobiInterstitial) {
        boolean[] a = m38472a();
        super.onAdDisplayFailed(inMobiInterstitial);
        a[45] = true;
        Log.d(InMobiRewardedCustomEvent.m38183d(), "Rewarded video ad failed to display.");
        a[46] = true;
    }

    public void onAdDismissed(InMobiInterstitial inMobiInterstitial) {
        boolean[] a = m38472a();
        super.onAdDismissed(inMobiInterstitial);
        a[47] = true;
        Log.v(InMobiRewardedCustomEvent.m38183d(), "Ad dismissed");
        InMobiRewardedCustomEvent inMobiRewardedCustomEvent = this.f36247b;
        a[48] = true;
        String a2 = InMobiRewardedCustomEvent.m38182a(inMobiRewardedCustomEvent);
        a[49] = true;
        MoPubRewardedVideoManager.onRewardedVideoClosed(InMobiRewardedCustomEvent.class, a2);
        a[50] = true;
    }

    public void onUserLeftApplication(InMobiInterstitial inMobiInterstitial) {
        boolean[] a = m38472a();
        super.onUserLeftApplication(inMobiInterstitial);
        a[51] = true;
        Log.v(InMobiRewardedCustomEvent.m38183d(), "User left application");
        a[52] = true;
    }

    public void onRewardsUnlocked(InMobiInterstitial inMobiInterstitial, Map<Object, Object> rewards) {
        boolean[] a = m38472a();
        super.onRewardsUnlocked(inMobiInterstitial, rewards);
        a[53] = true;
        Log.d(InMobiRewardedCustomEvent.m38183d(), "InMobi Rewarded video onRewardActionCompleted.");
        if (rewards == null) {
            a[54] = true;
        } else {
            a[55] = true;
            Set keySet = rewards.keySet();
            a[56] = true;
            String key = "";
            String value = "";
            a[57] = true;
            for (Object next : keySet) {
                a[58] = true;
                a[59] = true;
                key = next.toString();
                a[60] = true;
                Object obj = rewards.get(key);
                a[61] = true;
                value = obj.toString();
                a[62] = true;
                StringBuilder sb = new StringBuilder();
                sb.append(key);
                sb.append(":");
                sb.append(value);
                Log.d("Rewards: ", sb.toString());
                a[63] = true;
            }
            a[64] = true;
            MoPubReward success = MoPubReward.success(key, Integer.parseInt(value));
            a[65] = true;
            MoPubRewardedVideoManager.onRewardedVideoCompleted(InMobiRewardedCustomEvent.class, null, success);
            a[66] = true;
        }
        a[67] = true;
    }
}
