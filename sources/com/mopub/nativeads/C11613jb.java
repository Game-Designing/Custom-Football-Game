package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.jb */
/* compiled from: SomaMopubNativeCustomEvent */
class C11613jb extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36166a;

    /* renamed from: b */
    final /* synthetic */ C11568a f36167b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38431a() {
        boolean[] zArr = f36166a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4844557087440677390L, "com/mopub/nativeads/SomaMopubNativeCustomEvent$SmaatoForwardingNativeAd$7", 4);
        f36166a = probes;
        return probes;
    }

    C11613jb(C11568a this$0) {
        boolean[] a = m38431a();
        this.f36167b = this$0;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38431a();
        C11568a.m38383c(this.f36167b).destroy();
        a[1] = true;
        C11568a.m38384d(this.f36167b).mo39868b();
        a[2] = true;
        return null;
    }
}
