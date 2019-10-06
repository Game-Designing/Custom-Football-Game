package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import com.smaato.soma.p258g.C12374c;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.lb */
/* compiled from: SomaMopubNativeCustomEvent */
class C11620lb extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36187a;

    /* renamed from: b */
    final /* synthetic */ C11568a f36188b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38449a() {
        boolean[] zArr = f36187a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2419181010670543469L, "com/mopub/nativeads/SomaMopubNativeCustomEvent$SmaatoForwardingNativeAd$9", 3);
        f36187a = probes;
        return probes;
    }

    C11620lb(C11568a this$0) {
        boolean[] a = m38449a();
        this.f36188b = this$0;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38449a();
        C11568a.m38384d(this.f36188b).mo39863a((C12374c) this.f36188b);
        a[1] = true;
        return null;
    }
}
