package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.Ta */
/* compiled from: SomaMopubAdapterInterstitial */
class C11570Ta extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36063a;

    /* renamed from: b */
    final /* synthetic */ SomaMopubAdapterInterstitial f36064b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38395a() {
        boolean[] zArr = f36063a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8987635492462437115L, "com/mopub/nativeads/SomaMopubAdapterInterstitial$2", 3);
        f36063a = probes;
        return probes;
    }

    C11570Ta(SomaMopubAdapterInterstitial this$0) {
        boolean[] a = m38395a();
        this.f36064b = this$0;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38395a();
        SomaMopubAdapterInterstitial.m38376b(this.f36064b).post(new C11567Sa(this));
        a[1] = true;
        return null;
    }
}
