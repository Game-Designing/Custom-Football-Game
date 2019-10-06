package com.mopub.nativeads;

import com.mopub.mobileads.MoPubErrorCode;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.ub */
/* compiled from: SomaMopubVideoAdapter */
class C11648ub implements Runnable {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36244a;

    /* renamed from: b */
    final /* synthetic */ C11651vb f36245b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38471a() {
        boolean[] zArr = f36244a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8263598023200140448L, "com/mopub/nativeads/SomaMopubVideoAdapter$5$1", 2);
        f36244a = probes;
        return probes;
    }

    C11648ub(C11651vb this$1) {
        boolean[] a = m38471a();
        this.f36245b = this$1;
        a[0] = true;
    }

    public void run() {
        boolean[] a = m38471a();
        SomaMopubVideoAdapter.m38388a(this.f36245b.f36251b).onInterstitialFailed(MoPubErrorCode.NO_FILL);
        a[1] = true;
    }
}
