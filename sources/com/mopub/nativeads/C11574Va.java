package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.Va */
/* compiled from: SomaMopubAdapterInterstitial */
class C11574Va extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36069a;

    /* renamed from: b */
    final /* synthetic */ SomaMopubAdapterInterstitial f36070b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38397a() {
        boolean[] zArr = f36069a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-93966100516629005L, "com/mopub/nativeads/SomaMopubAdapterInterstitial$3", 3);
        f36069a = probes;
        return probes;
    }

    C11574Va(SomaMopubAdapterInterstitial this$0) {
        boolean[] a = m38397a();
        this.f36070b = this$0;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38397a();
        SomaMopubAdapterInterstitial.m38376b(this.f36070b).post(new C11572Ua(this));
        a[1] = true;
        return null;
    }
}
