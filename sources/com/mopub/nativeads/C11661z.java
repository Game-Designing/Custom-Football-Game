package com.mopub.nativeads;

import android.util.Log;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.fyber.inneractive.sdk.external.InneractiveUnitController.AdDisplayError;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.z */
/* compiled from: InneractiveInterstitialCustomEvent */
class C11661z implements InneractiveFullscreenAdEventsListener {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36270a;

    /* renamed from: b */
    final /* synthetic */ InneractiveInterstitialCustomEvent f36271b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38484a() {
        boolean[] zArr = f36270a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(369587153085540079L, "com/mopub/nativeads/InneractiveInterstitialCustomEvent$2", 13);
        f36270a = probes;
        return probes;
    }

    C11661z(InneractiveInterstitialCustomEvent this$0) {
        boolean[] a = m38484a();
        this.f36271b = this$0;
        a[0] = true;
    }

    public void onAdImpression(InneractiveAdSpot adSpot) {
        boolean[] a = m38484a();
        InneractiveInterstitialCustomEvent.m38188a(this.f36271b).onInterstitialShown();
        a[1] = true;
        InneractiveInterstitialCustomEvent.m38188a(this.f36271b).onInterstitialImpression();
        a[2] = true;
        Log.i(InneractiveMediationDefs.IA_LOG_FOR_MOPUB_INTERSTITIAL, "onAdImpression");
        a[3] = true;
    }

    public void onAdClicked(InneractiveAdSpot adSpot) {
        boolean[] a = m38484a();
        InneractiveInterstitialCustomEvent.m38188a(this.f36271b).onInterstitialClicked();
        a[4] = true;
        Log.i(InneractiveMediationDefs.IA_LOG_FOR_MOPUB_INTERSTITIAL, "onAdClicked");
        a[5] = true;
    }

    public void onAdWillOpenExternalApp(InneractiveAdSpot adSpot) {
        boolean[] a = m38484a();
        Log.d(InneractiveMediationDefs.IA_LOG_FOR_MOPUB_INTERSTITIAL, "inneractiveAdWillOpenExternalApp");
        a[6] = true;
    }

    public void onAdEnteredErrorState(InneractiveAdSpot adSpot, AdDisplayError error) {
        boolean[] a = m38484a();
        StringBuilder sb = new StringBuilder();
        sb.append("onAdEnteredErrorState - ");
        a[7] = true;
        sb.append(error.getMessage());
        String sb2 = sb.toString();
        a[8] = true;
        Log.i(InneractiveMediationDefs.IA_LOG_FOR_MOPUB_INTERSTITIAL, sb2);
        a[9] = true;
    }

    public void onAdWillCloseInternalBrowser(InneractiveAdSpot adSpot) {
        boolean[] a = m38484a();
        Log.d(InneractiveMediationDefs.IA_LOG_FOR_MOPUB_INTERSTITIAL, "inneractiveInternalBrowserDismissed");
        a[10] = true;
    }

    public void onAdDismissed(InneractiveAdSpot adSpot) {
        boolean[] a = m38484a();
        InneractiveInterstitialCustomEvent.m38188a(this.f36271b).onInterstitialDismissed();
        a[11] = true;
        Log.i(InneractiveMediationDefs.IA_LOG_FOR_MOPUB_INTERSTITIAL, "onAdDismissed");
        a[12] = true;
    }
}
