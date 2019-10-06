package com.mopub.nativeads;

import android.util.Log;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.fyber.inneractive.sdk.external.VideoContentListener;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.A */
/* compiled from: InneractiveInterstitialCustomEvent */
class C11510A implements VideoContentListener {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f35586a;

    /* renamed from: b */
    final /* synthetic */ InneractiveInterstitialCustomEvent f35587b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38087a() {
        boolean[] zArr = f35586a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7956944149875816954L, "com/mopub/nativeads/InneractiveInterstitialCustomEvent$3", 4);
        f35586a = probes;
        return probes;
    }

    C11510A(InneractiveInterstitialCustomEvent this$0) {
        boolean[] a = m38087a();
        this.f35587b = this$0;
        a[0] = true;
    }

    public void onProgress(int totalDurationInMsec, int positionInMsec) {
        boolean[] a = m38087a();
        StringBuilder sb = new StringBuilder();
        sb.append("Interstitial: Got video content progress: total time = ");
        sb.append(totalDurationInMsec);
        sb.append(" position = ");
        sb.append(positionInMsec);
        Log.d(InneractiveMediationDefs.IA_LOG_FOR_MOPUB_INTERSTITIAL, sb.toString());
        a[1] = true;
    }

    public void onCompleted() {
        boolean[] a = m38087a();
        Log.d(InneractiveMediationDefs.IA_LOG_FOR_MOPUB_INTERSTITIAL, "Interstitial: Got video content completed event");
        a[2] = true;
    }

    public void onPlayerError() {
        boolean[] a = m38087a();
        Log.d(InneractiveMediationDefs.IA_LOG_FOR_ADMOB_INTERSTITIAL, "Interstitial: Got video content play error event");
        a[3] = true;
    }
}
