package com.mopub.nativeads;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.xb */
/* compiled from: SomaMopubVideoAdapter */
class C11657xb implements Runnable {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36263a;

    /* renamed from: b */
    final /* synthetic */ C11660yb f36264b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38481a() {
        boolean[] zArr = f36263a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7605926827303284980L, "com/mopub/nativeads/SomaMopubVideoAdapter$7$1", 5);
        f36263a = probes;
        return probes;
    }

    C11657xb(C11660yb this$1) {
        boolean[] a = m38481a();
        this.f36264b = this$1;
        a[0] = true;
    }

    public void run() {
        boolean[] a = m38481a();
        if (!SomaMopubVideoAdapter.m38393c(this.f36264b.f36269b).mo39972h()) {
            a[1] = true;
        } else {
            a[2] = true;
            SomaMopubVideoAdapter.m38393c(this.f36264b.f36269b).mo39973i();
            a[3] = true;
        }
        a[4] = true;
    }
}
