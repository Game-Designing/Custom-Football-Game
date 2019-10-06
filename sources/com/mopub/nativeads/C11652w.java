package com.mopub.nativeads;

import android.util.Log;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.fyber.inneractive.sdk.external.InneractiveUnitController.AdDisplayError;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.w */
/* compiled from: InneractiveBannerCustomEvent */
class C11652w implements InneractiveAdViewEventsListener {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36252a;

    /* renamed from: b */
    final /* synthetic */ C11655x f36253b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38478a() {
        boolean[] zArr = f36252a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(31847051484149521L, "com/mopub/nativeads/InneractiveBannerCustomEvent$1$1", 15);
        f36252a = probes;
        return probes;
    }

    C11652w(C11655x this$1) {
        boolean[] a = m38478a();
        this.f36253b = this$1;
        a[0] = true;
    }

    public void onAdImpression(InneractiveAdSpot adSpot) {
        boolean[] a = m38478a();
        this.f36253b.f36261c.f35747c.onBannerImpression();
        a[1] = true;
        Log.d(InneractiveMediationDefs.INNERACTIVE_MEDIATION_SAMPLE_APP_TAG, "IABannerForMopub - onAdImpression");
        a[2] = true;
    }

    public void onAdClicked(InneractiveAdSpot adSpot) {
        boolean[] a = m38478a();
        Log.d(InneractiveMediationDefs.INNERACTIVE_MEDIATION_SAMPLE_APP_TAG, "IABannerForMopub - inneractiveBannerClicked");
        a[3] = true;
        this.f36253b.f36261c.f35747c.onBannerClicked();
        a[4] = true;
    }

    public void onAdWillCloseInternalBrowser(InneractiveAdSpot adSpot) {
        boolean[] a = m38478a();
        Log.d(InneractiveMediationDefs.INNERACTIVE_MEDIATION_SAMPLE_APP_TAG, "IABannerForMopub - inneractiveInternalBrowserDismissed");
        a[5] = true;
    }

    public void onAdWillOpenExternalApp(InneractiveAdSpot adSpot) {
        boolean[] a = m38478a();
        Log.d(InneractiveMediationDefs.INNERACTIVE_MEDIATION_SAMPLE_APP_TAG, "IABannerForMopub - inneractiveAdWillOpenExternalApp");
        a[6] = true;
    }

    public void onAdEnteredErrorState(InneractiveAdSpot adSpot, AdDisplayError error) {
        boolean[] a = m38478a();
        StringBuilder sb = new StringBuilder();
        sb.append("IABannerForMopub - onAdEnteredErrorState - ");
        a[7] = true;
        sb.append(error.getMessage());
        String sb2 = sb.toString();
        a[8] = true;
        Log.d(InneractiveMediationDefs.INNERACTIVE_MEDIATION_SAMPLE_APP_TAG, sb2);
        a[9] = true;
    }

    public void onAdExpanded(InneractiveAdSpot adSpot) {
        boolean[] a = m38478a();
        Log.d(InneractiveMediationDefs.INNERACTIVE_MEDIATION_SAMPLE_APP_TAG, "IABannerForMopub - inneractiveBannerExpanded");
        a[10] = true;
        this.f36253b.f36261c.f35747c.onBannerExpanded();
        a[11] = true;
    }

    public void onAdResized(InneractiveAdSpot adSpot) {
        boolean[] a = m38478a();
        Log.d(InneractiveMediationDefs.INNERACTIVE_MEDIATION_SAMPLE_APP_TAG, "IABannerForMopub - inneractiveBannerResized");
        a[12] = true;
    }

    public void onAdCollapsed(InneractiveAdSpot adSpot) {
        boolean[] a = m38478a();
        Log.d(InneractiveMediationDefs.INNERACTIVE_MEDIATION_SAMPLE_APP_TAG, "IABannerForMopub - inneractiveBannerCollapsed");
        a[13] = true;
        this.f36253b.f36261c.f35747c.onBannerCollapsed();
        a[14] = true;
    }
}
