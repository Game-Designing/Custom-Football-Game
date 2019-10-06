package com.mopub.nativeads;

import android.util.Log;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.ads.listeners.InterstitialAdEventListener;
import com.mopub.mobileads.MoPubErrorCode;
import java.util.Map;
import java.util.Set;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.n */
/* compiled from: InMobiInterstitialCustomEvent */
class C11625n extends InterstitialAdEventListener {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36196a;

    /* renamed from: b */
    final /* synthetic */ InMobiInterstitialCustomEvent f36197b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38455a() {
        boolean[] zArr = f36196a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7341553326973637170L, "com/mopub/nativeads/InMobiInterstitialCustomEvent$1", 57);
        f36196a = probes;
        return probes;
    }

    C11625n(InMobiInterstitialCustomEvent this$0) {
        boolean[] a = m38455a();
        this.f36197b = this$0;
        a[0] = true;
    }

    public void onAdLoadSucceeded(InMobiInterstitial inMobiInterstitial) {
        boolean[] a = m38455a();
        super.onAdLoadSucceeded(inMobiInterstitial);
        a[1] = true;
        Log.d(InMobiInterstitialCustomEvent.m38164f(), "InMobi interstitial ad loaded successfully.");
        a[2] = true;
        if (InMobiInterstitialCustomEvent.m38163a(this.f36197b) == null) {
            a[3] = true;
        } else {
            a[4] = true;
            InMobiInterstitialCustomEvent.m38163a(this.f36197b).onInterstitialLoaded();
            a[5] = true;
        }
        a[6] = true;
    }

    public void onAdLoadFailed(InMobiInterstitial inMobiInterstitial, InMobiAdRequestStatus inMobiAdRequestStatus) {
        boolean[] a = m38455a();
        super.onAdLoadFailed(inMobiInterstitial, inMobiAdRequestStatus);
        a[7] = true;
        Log.d(InMobiInterstitialCustomEvent.m38164f(), "InMobi interstitial ad failed to load.");
        a[8] = true;
        if (InMobiInterstitialCustomEvent.m38163a(this.f36197b) == null) {
            a[9] = true;
        } else {
            a[10] = true;
            if (inMobiAdRequestStatus.getStatusCode() == StatusCode.INTERNAL_ERROR) {
                a[11] = true;
                InMobiInterstitialCustomEvent.m38163a(this.f36197b).onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
                a[12] = true;
            } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.REQUEST_INVALID) {
                a[13] = true;
                InMobiInterstitialCustomEvent.m38163a(this.f36197b).onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                a[14] = true;
            } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.NETWORK_UNREACHABLE) {
                a[15] = true;
                InMobiInterstitialCustomEvent.m38163a(this.f36197b).onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
                a[16] = true;
            } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.NO_FILL) {
                a[17] = true;
                InMobiInterstitialCustomEvent.m38163a(this.f36197b).onInterstitialFailed(MoPubErrorCode.NO_FILL);
                a[18] = true;
            } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.REQUEST_TIMED_OUT) {
                a[19] = true;
                InMobiInterstitialCustomEvent.m38163a(this.f36197b).onInterstitialFailed(MoPubErrorCode.NETWORK_TIMEOUT);
                a[20] = true;
            } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.SERVER_ERROR) {
                a[21] = true;
                InMobiInterstitialCustomEvent.m38163a(this.f36197b).onInterstitialFailed(MoPubErrorCode.SERVER_ERROR);
                a[22] = true;
            } else {
                InMobiInterstitialCustomEvent.m38163a(this.f36197b).onInterstitialFailed(MoPubErrorCode.UNSPECIFIED);
                a[23] = true;
            }
        }
        a[24] = true;
    }

    public void onAdReceived(InMobiInterstitial inMobiInterstitial) {
        boolean[] a = m38455a();
        super.onAdReceived(inMobiInterstitial);
        a[25] = true;
        Log.d(InMobiInterstitialCustomEvent.m38164f(), "InMobi Adserver responded with an Ad");
        a[26] = true;
    }

    public void onAdClicked(InMobiInterstitial inMobiInterstitial, Map<Object, Object> params) {
        boolean[] a = m38455a();
        super.onAdClicked(inMobiInterstitial, params);
        a[27] = true;
        Log.d(InMobiInterstitialCustomEvent.m38164f(), "InMobi interstitial interaction happening.");
        a[28] = true;
        if (InMobiInterstitialCustomEvent.m38163a(this.f36197b) == null) {
            a[29] = true;
        } else {
            a[30] = true;
            InMobiInterstitialCustomEvent.m38163a(this.f36197b).onInterstitialClicked();
            a[31] = true;
        }
        a[32] = true;
    }

    public void onAdWillDisplay(InMobiInterstitial inMobiInterstitial) {
        boolean[] a = m38455a();
        super.onAdWillDisplay(inMobiInterstitial);
        a[33] = true;
        Log.d(InMobiInterstitialCustomEvent.m38164f(), "Interstitial ad will display.");
        a[34] = true;
    }

    public void onAdDisplayed(InMobiInterstitial inMobiInterstitial) {
        boolean[] a = m38455a();
        super.onAdDisplayed(inMobiInterstitial);
        a[35] = true;
        Log.d(InMobiInterstitialCustomEvent.m38164f(), "InMobi interstitial show on screen.");
        a[36] = true;
        if (InMobiInterstitialCustomEvent.m38163a(this.f36197b) == null) {
            a[37] = true;
        } else {
            a[38] = true;
            InMobiInterstitialCustomEvent.m38163a(this.f36197b).onInterstitialShown();
            a[39] = true;
        }
        a[40] = true;
    }

    public void onAdDisplayFailed(InMobiInterstitial inMobiInterstitial) {
        boolean[] a = m38455a();
        super.onAdDisplayFailed(inMobiInterstitial);
        a[41] = true;
        Log.d(InMobiInterstitialCustomEvent.m38164f(), "Interstitial ad failed to display.");
        a[42] = true;
    }

    public void onAdDismissed(InMobiInterstitial inMobiInterstitial) {
        boolean[] a = m38455a();
        super.onAdDismissed(inMobiInterstitial);
        a[43] = true;
    }

    public void onUserLeftApplication(InMobiInterstitial inMobiInterstitial) {
        boolean[] a = m38455a();
        super.onUserLeftApplication(inMobiInterstitial);
        a[44] = true;
    }

    public void onRewardsUnlocked(InMobiInterstitial inMobiInterstitial, Map<Object, Object> rewards) {
        boolean[] a = m38455a();
        Log.d(InMobiInterstitialCustomEvent.m38164f(), "InMobi interstitial onRewardsUnlocked.");
        if (rewards == null) {
            a[45] = true;
        } else {
            a[46] = true;
            Set keySet = rewards.keySet();
            a[47] = true;
            a[48] = true;
            for (Object next : keySet) {
                a[50] = true;
                a[51] = true;
                String key = next.toString();
                a[52] = true;
                Object obj = rewards.get(key);
                a[53] = true;
                String value = obj.toString();
                a[54] = true;
                StringBuilder sb = new StringBuilder();
                sb.append(key);
                sb.append(":");
                sb.append(value);
                Log.d("Rewards: ", sb.toString());
                a[55] = true;
            }
            a[49] = true;
        }
        a[56] = true;
    }
}
