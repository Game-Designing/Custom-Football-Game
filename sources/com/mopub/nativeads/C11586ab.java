package com.mopub.nativeads;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.ab */
/* compiled from: SomaMopubAdapterInterstitial */
class C11586ab implements Runnable {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36115a;

    /* renamed from: b */
    final /* synthetic */ C11589bb f36116b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38412a() {
        boolean[] zArr = f36115a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6034332036614564437L, "com/mopub/nativeads/SomaMopubAdapterInterstitial$7$1", 5);
        f36115a = probes;
        return probes;
    }

    C11586ab(C11589bb this$1) {
        boolean[] a = m38412a();
        this.f36116b = this$1;
        a[0] = true;
    }

    public void run() {
        boolean[] a = m38412a();
        if (!SomaMopubAdapterInterstitial.m38377c(this.f36116b.f36123b).mo39917d()) {
            a[1] = true;
        } else {
            a[2] = true;
            SomaMopubAdapterInterstitial.m38377c(this.f36116b.f36123b).mo39921g();
            a[3] = true;
        }
        a[4] = true;
    }
}
