package com.mopub.nativeads;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.qb */
/* compiled from: SomaMopubVideoAdapter */
class C11636qb implements Runnable {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36221a;

    /* renamed from: b */
    final /* synthetic */ C11639rb f36222b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38463a() {
        boolean[] zArr = f36221a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6117269582612546832L, "com/mopub/nativeads/SomaMopubVideoAdapter$3$1", 2);
        f36221a = probes;
        return probes;
    }

    C11636qb(C11639rb this$1) {
        boolean[] a = m38463a();
        this.f36222b = this$1;
        a[0] = true;
    }

    public void run() {
        boolean[] a = m38463a();
        SomaMopubVideoAdapter.m38388a(this.f36222b.f36229b).onInterstitialClicked();
        a[1] = true;
    }
}
