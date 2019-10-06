package com.mopub.nativeads;

import android.util.Log;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mopub.mobileads.MoPubErrorCode;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.y */
/* compiled from: InneractiveInterstitialCustomEvent */
class C11658y implements RequestListener {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36265a;

    /* renamed from: b */
    final /* synthetic */ InneractiveInterstitialCustomEvent f36266b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38482a() {
        boolean[] zArr = f36265a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4175538669100872679L, "com/mopub/nativeads/InneractiveInterstitialCustomEvent$1", 11);
        f36265a = probes;
        return probes;
    }

    C11658y(InneractiveInterstitialCustomEvent this$0) {
        boolean[] a = m38482a();
        this.f36266b = this$0;
        a[0] = true;
    }

    public void onInneractiveSuccessfulAdRequest(InneractiveAdSpot adSpot) {
        boolean[] a = m38482a();
        Log.d(InneractiveMediationDefs.INNERACTIVE_MEDIATION_SAMPLE_APP_TAG, "IAInterstitialForMopub - inneractiveInterstitialLoaded");
        a[1] = true;
        InneractiveInterstitialCustomEvent.m38188a(this.f36266b).onInterstitialLoaded();
        a[2] = true;
    }

    public void onInneractiveFailedAdRequest(InneractiveAdSpot adSpot, InneractiveErrorCode errorCode) {
        boolean[] a = m38482a();
        StringBuilder sb = new StringBuilder();
        sb.append("Failed loading interstitial! with error: ");
        sb.append(errorCode);
        Log.d(InneractiveMediationDefs.IA_LOG_FOR_MOPUB_INTERSTITIAL, sb.toString());
        if (errorCode == InneractiveErrorCode.CONNECTION_ERROR) {
            a[3] = true;
            InneractiveInterstitialCustomEvent.m38188a(this.f36266b).onInterstitialFailed(MoPubErrorCode.NO_CONNECTION);
            a[4] = true;
        } else if (errorCode == InneractiveErrorCode.CONNECTION_TIMEOUT) {
            a[5] = true;
            InneractiveInterstitialCustomEvent.m38188a(this.f36266b).onInterstitialFailed(MoPubErrorCode.NETWORK_TIMEOUT);
            a[6] = true;
        } else if (errorCode == InneractiveErrorCode.NO_FILL) {
            a[7] = true;
            InneractiveInterstitialCustomEvent.m38188a(this.f36266b).onInterstitialFailed(MoPubErrorCode.NO_FILL);
            a[8] = true;
        } else {
            InneractiveInterstitialCustomEvent.m38188a(this.f36266b).onInterstitialFailed(MoPubErrorCode.SERVER_ERROR);
            a[9] = true;
        }
        a[10] = true;
    }
}
