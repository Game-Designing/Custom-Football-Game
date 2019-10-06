package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.Ra */
/* compiled from: SomaMopubAdapterInterstitial */
class C11565Ra extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36016a;

    /* renamed from: b */
    final /* synthetic */ SomaMopubAdapterInterstitial f36017b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38360a() {
        boolean[] zArr = f36016a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5891591760783735329L, "com/mopub/nativeads/SomaMopubAdapterInterstitial$1", 3);
        f36016a = probes;
        return probes;
    }

    C11565Ra(SomaMopubAdapterInterstitial this$0) {
        boolean[] a = m38360a();
        this.f36017b = this$0;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38360a();
        SomaMopubAdapterInterstitial.m38376b(this.f36017b).post(new C11564Qa(this));
        a[1] = true;
        return null;
    }
}
