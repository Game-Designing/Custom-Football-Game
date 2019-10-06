package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.bb */
/* compiled from: SomaMopubAdapterInterstitial */
class C11589bb extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36122a;

    /* renamed from: b */
    final /* synthetic */ SomaMopubAdapterInterstitial f36123b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38414a() {
        boolean[] zArr = f36122a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1431526126680797357L, "com/mopub/nativeads/SomaMopubAdapterInterstitial$7", 3);
        f36122a = probes;
        return probes;
    }

    C11589bb(SomaMopubAdapterInterstitial this$0) {
        boolean[] a = m38414a();
        this.f36123b = this$0;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38414a();
        SomaMopubAdapterInterstitial.m38376b(this.f36123b).post(new C11586ab(this));
        a[1] = true;
        return null;
    }
}
