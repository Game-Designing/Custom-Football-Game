package com.mopub.nativeads;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.Wa */
/* compiled from: SomaMopubAdapterInterstitial */
class C11576Wa implements Runnable {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36098a;

    /* renamed from: b */
    final /* synthetic */ C11578Xa f36099b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38406a() {
        boolean[] zArr = f36098a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8833152405932011933L, "com/mopub/nativeads/SomaMopubAdapterInterstitial$4$1", 2);
        f36098a = probes;
        return probes;
    }

    C11576Wa(C11578Xa this$1) {
        boolean[] a = m38406a();
        this.f36099b = this$1;
        a[0] = true;
    }

    public void run() {
        boolean[] a = m38406a();
        SomaMopubAdapterInterstitial.m38371a(this.f36099b.f36101b).onInterstitialDismissed();
        a[1] = true;
    }
}
