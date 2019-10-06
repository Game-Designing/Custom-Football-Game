package com.mopub.nativeads;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.mb */
/* compiled from: SomaMopubVideoAdapter */
class C11624mb implements Runnable {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36194a;

    /* renamed from: b */
    final /* synthetic */ C11627nb f36195b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38454a() {
        boolean[] zArr = f36194a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6924880757858735819L, "com/mopub/nativeads/SomaMopubVideoAdapter$1$1", 2);
        f36194a = probes;
        return probes;
    }

    C11624mb(C11627nb this$1) {
        boolean[] a = m38454a();
        this.f36195b = this$1;
        a[0] = true;
    }

    public void run() {
        boolean[] a = m38454a();
        SomaMopubVideoAdapter.m38388a(this.f36195b.f36201b).onInterstitialLoaded();
        a[1] = true;
    }
}
