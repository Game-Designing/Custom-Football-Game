package com.mopub.nativeads;

import com.smaato.soma.p238b.C12143a;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.Sa */
/* compiled from: SomaMopubAdapterInterstitial */
class C11567Sa implements Runnable {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36029a;

    /* renamed from: b */
    final /* synthetic */ C11570Ta f36030b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38365a() {
        boolean[] zArr = f36029a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-372885874226361875L, "com/mopub/nativeads/SomaMopubAdapterInterstitial$2$1", 3);
        f36029a = probes;
        return probes;
    }

    C11567Sa(C11570Ta this$1) {
        boolean[] a = m38365a();
        this.f36030b = this$1;
        a[0] = true;
    }

    public void run() {
        boolean[] a = m38365a();
        SomaMopubAdapterInterstitial.m38372a(this.f36030b.f36064b, "onWillShow ", C12143a.ERROR);
        a[1] = true;
        SomaMopubAdapterInterstitial.m38371a(this.f36030b.f36064b).onInterstitialShown();
        a[2] = true;
    }
}
