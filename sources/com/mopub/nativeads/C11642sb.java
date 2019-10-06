package com.mopub.nativeads;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.sb */
/* compiled from: SomaMopubVideoAdapter */
class C11642sb implements Runnable {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36233a;

    /* renamed from: b */
    final /* synthetic */ C11645tb f36234b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38467a() {
        boolean[] zArr = f36233a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2875433782983888533L, "com/mopub/nativeads/SomaMopubVideoAdapter$4$1", 2);
        f36233a = probes;
        return probes;
    }

    C11642sb(C11645tb this$1) {
        boolean[] a = m38467a();
        this.f36234b = this$1;
        a[0] = true;
    }

    public void run() {
        boolean[] a = m38467a();
        SomaMopubVideoAdapter.m38388a(this.f36234b.f36240b).onInterstitialDismissed();
        a[1] = true;
    }
}
