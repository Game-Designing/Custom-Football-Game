package com.mopub.nativeads;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.Qa */
/* compiled from: SomaMopubAdapterInterstitial */
class C11564Qa implements Runnable {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36014a;

    /* renamed from: b */
    final /* synthetic */ C11565Ra f36015b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38359a() {
        boolean[] zArr = f36014a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3664415674032416961L, "com/mopub/nativeads/SomaMopubAdapterInterstitial$1$1", 2);
        f36014a = probes;
        return probes;
    }

    C11564Qa(C11565Ra this$1) {
        boolean[] a = m38359a();
        this.f36015b = this$1;
        a[0] = true;
    }

    public void run() {
        boolean[] a = m38359a();
        SomaMopubAdapterInterstitial.m38371a(this.f36015b.f36017b).onInterstitialLoaded();
        a[1] = true;
    }
}
