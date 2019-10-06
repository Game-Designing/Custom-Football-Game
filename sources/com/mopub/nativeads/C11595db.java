package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.db */
/* compiled from: SomaMopubNativeCustomEvent */
class C11595db extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36132a;

    /* renamed from: b */
    final /* synthetic */ C11568a f36133b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38417a() {
        boolean[] zArr = f36132a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3457995156959089318L, "com/mopub/nativeads/SomaMopubNativeCustomEvent$SmaatoForwardingNativeAd$2", 3);
        f36132a = probes;
        return probes;
    }

    C11595db(C11568a this$0) {
        boolean[] a = m38417a();
        this.f36133b = this$0;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38417a();
        this.f36133b.mo37750d();
        a[1] = true;
        return null;
    }
}
