package com.mopub.nativeads;

import com.mopub.mobileads.MoPubErrorCode;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.Ya */
/* compiled from: SomaMopubAdapterInterstitial */
class C11580Ya implements Runnable {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36103a;

    /* renamed from: b */
    final /* synthetic */ C11582Za f36104b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38408a() {
        boolean[] zArr = f36103a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3558281902548252056L, "com/mopub/nativeads/SomaMopubAdapterInterstitial$5$1", 2);
        f36103a = probes;
        return probes;
    }

    C11580Ya(C11582Za this$1) {
        boolean[] a = m38408a();
        this.f36104b = this$1;
        a[0] = true;
    }

    public void run() {
        boolean[] a = m38408a();
        SomaMopubAdapterInterstitial.m38371a(this.f36104b.f36108b).onInterstitialFailed(MoPubErrorCode.NO_FILL);
        a[1] = true;
    }
}
