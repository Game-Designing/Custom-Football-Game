package com.mopub.nativeads;

import android.util.Log;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.ads.listeners.BannerAdEventListener;
import com.mopub.mobileads.MoPubErrorCode;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.m */
/* compiled from: InMobiBannerCustomEvent */
class C11621m extends BannerAdEventListener {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36189a;

    /* renamed from: b */
    final /* synthetic */ InMobiBannerCustomEvent f36190b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38450a() {
        boolean[] zArr = f36189a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3074021786420431833L, "com/mopub/nativeads/InMobiBannerCustomEvent$1", 38);
        f36189a = probes;
        return probes;
    }

    C11621m(InMobiBannerCustomEvent this$0) {
        boolean[] a = m38450a();
        this.f36190b = this$0;
        a[0] = true;
    }

    public void onAdLoadSucceeded(InMobiBanner inMobiBanner) {
        boolean[] a = m38450a();
        super.onAdLoadSucceeded(inMobiBanner);
        a[1] = true;
        Log.d(InMobiBannerCustomEvent.m38157c(), "InMobi banner ad loaded successfully.");
        a[2] = true;
        if (InMobiBannerCustomEvent.m38155a(this.f36190b) == null) {
            a[3] = true;
        } else if (inMobiBanner != null) {
            a[4] = true;
            InMobiBannerCustomEvent.m38155a(this.f36190b).onBannerLoaded(inMobiBanner);
            a[5] = true;
        } else {
            InMobiBannerCustomEvent.m38155a(this.f36190b).onBannerFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
            a[6] = true;
        }
        a[7] = true;
    }

    public void onAdLoadFailed(InMobiBanner inMobiBanner, InMobiAdRequestStatus inMobiAdRequestStatus) {
        boolean[] a = m38450a();
        super.onAdLoadFailed(inMobiBanner, inMobiAdRequestStatus);
        a[8] = true;
        Log.v(InMobiBannerCustomEvent.m38157c(), "Ad failed to load");
        a[9] = true;
        if (InMobiBannerCustomEvent.m38155a(this.f36190b) == null) {
            a[10] = true;
        } else {
            a[11] = true;
            if (inMobiAdRequestStatus.getStatusCode() == StatusCode.INTERNAL_ERROR) {
                a[12] = true;
                InMobiBannerCustomEvent.m38155a(this.f36190b).onBannerFailed(MoPubErrorCode.INTERNAL_ERROR);
                a[13] = true;
            } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.REQUEST_INVALID) {
                a[14] = true;
                InMobiBannerCustomEvent.m38155a(this.f36190b).onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                a[15] = true;
            } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.NETWORK_UNREACHABLE) {
                a[16] = true;
                InMobiBannerCustomEvent.m38155a(this.f36190b).onBannerFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
                a[17] = true;
            } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.NO_FILL) {
                a[18] = true;
                InMobiBannerCustomEvent.m38155a(this.f36190b).onBannerFailed(MoPubErrorCode.NO_FILL);
                a[19] = true;
            } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.REQUEST_TIMED_OUT) {
                a[20] = true;
                InMobiBannerCustomEvent.m38155a(this.f36190b).onBannerFailed(MoPubErrorCode.NETWORK_TIMEOUT);
                a[21] = true;
            } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.SERVER_ERROR) {
                a[22] = true;
                InMobiBannerCustomEvent.m38155a(this.f36190b).onBannerFailed(MoPubErrorCode.SERVER_ERROR);
                a[23] = true;
            } else {
                InMobiBannerCustomEvent.m38155a(this.f36190b).onBannerFailed(MoPubErrorCode.UNSPECIFIED);
                a[24] = true;
            }
        }
        a[25] = true;
    }

    public void onAdClicked(InMobiBanner inMobiBanner, Map<Object, Object> map) {
        boolean[] a = m38450a();
        super.onAdClicked(inMobiBanner, map);
        a[26] = true;
        Log.v(InMobiBannerCustomEvent.m38157c(), "Ad interaction");
        a[27] = true;
        InMobiBannerCustomEvent.m38155a(this.f36190b).onBannerClicked();
        a[28] = true;
    }

    public void onAdDisplayed(InMobiBanner inMobiBanner) {
        boolean[] a = m38450a();
        super.onAdDisplayed(inMobiBanner);
        a[29] = true;
        Log.v(InMobiBannerCustomEvent.m38157c(), "Ad displayed");
        a[30] = true;
    }

    public void onAdDismissed(InMobiBanner inMobiBanner) {
        boolean[] a = m38450a();
        super.onAdDismissed(inMobiBanner);
        a[31] = true;
        Log.v(InMobiBannerCustomEvent.m38157c(), "Ad Dismissed");
        a[32] = true;
    }

    public void onUserLeftApplication(InMobiBanner inMobiBanner) {
        boolean[] a = m38450a();
        super.onUserLeftApplication(inMobiBanner);
        a[33] = true;
        Log.v(InMobiBannerCustomEvent.m38157c(), "User left applicaton");
        a[34] = true;
        InMobiBannerCustomEvent.m38155a(this.f36190b).onLeaveApplication();
        a[35] = true;
    }

    public void onRewardsUnlocked(InMobiBanner ad, Map<Object, Object> rewards) {
        boolean[] a = m38450a();
        super.onRewardsUnlocked(ad, rewards);
        a[36] = true;
        Log.v(InMobiBannerCustomEvent.m38157c(), "Ad rewarded");
        a[37] = true;
    }
}
