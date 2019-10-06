package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.cb */
/* compiled from: SomaMopubNativeCustomEvent */
class C11592cb extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36127a;

    /* renamed from: b */
    final /* synthetic */ C11568a f36128b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38416a() {
        boolean[] zArr = f36127a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3952680556016637964L, "com/mopub/nativeads/SomaMopubNativeCustomEvent$SmaatoForwardingNativeAd$1", 3);
        f36127a = probes;
        return probes;
    }

    C11592cb(C11568a this$0) {
        boolean[] a = m38416a();
        this.f36128b = this$0;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38416a();
        this.f36128b.mo37749c();
        a[1] = true;
        return null;
    }
}
