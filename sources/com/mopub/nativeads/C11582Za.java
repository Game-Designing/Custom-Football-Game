package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.Za */
/* compiled from: SomaMopubAdapterInterstitial */
class C11582Za extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36107a;

    /* renamed from: b */
    final /* synthetic */ SomaMopubAdapterInterstitial f36108b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38409a() {
        boolean[] zArr = f36107a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(121460602761896962L, "com/mopub/nativeads/SomaMopubAdapterInterstitial$5", 3);
        f36107a = probes;
        return probes;
    }

    C11582Za(SomaMopubAdapterInterstitial this$0) {
        boolean[] a = m38409a();
        this.f36108b = this$0;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38409a();
        SomaMopubAdapterInterstitial.m38376b(this.f36108b).post(new C11580Ya(this));
        a[1] = true;
        return null;
    }
}
