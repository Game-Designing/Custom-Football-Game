package com.mopub.nativeads;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.Ua */
/* compiled from: SomaMopubAdapterInterstitial */
class C11572Ua implements Runnable {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36066a;

    /* renamed from: b */
    final /* synthetic */ C11574Va f36067b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38396a() {
        boolean[] zArr = f36066a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3188246531575758637L, "com/mopub/nativeads/SomaMopubAdapterInterstitial$3$1", 2);
        f36066a = probes;
        return probes;
    }

    C11572Ua(C11574Va this$1) {
        boolean[] a = m38396a();
        this.f36067b = this$1;
        a[0] = true;
    }

    public void run() {
        boolean[] a = m38396a();
        SomaMopubAdapterInterstitial.m38371a(this.f36067b.f36070b).onInterstitialClicked();
        a[1] = true;
    }
}
