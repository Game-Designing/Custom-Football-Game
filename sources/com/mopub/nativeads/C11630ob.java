package com.mopub.nativeads;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.ob */
/* compiled from: SomaMopubVideoAdapter */
class C11630ob implements Runnable {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36208a;

    /* renamed from: b */
    final /* synthetic */ C11633pb f36209b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38459a() {
        boolean[] zArr = f36208a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4433076262707330820L, "com/mopub/nativeads/SomaMopubVideoAdapter$2$1", 2);
        f36208a = probes;
        return probes;
    }

    C11630ob(C11633pb this$1) {
        boolean[] a = m38459a();
        this.f36209b = this$1;
        a[0] = true;
    }

    public void run() {
        boolean[] a = m38459a();
        SomaMopubVideoAdapter.m38388a(this.f36209b.f36217b).onInterstitialShown();
        a[1] = true;
    }
}
