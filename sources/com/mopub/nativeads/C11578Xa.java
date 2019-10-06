package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.Xa */
/* compiled from: SomaMopubAdapterInterstitial */
class C11578Xa extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36100a;

    /* renamed from: b */
    final /* synthetic */ SomaMopubAdapterInterstitial f36101b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38407a() {
        boolean[] zArr = f36100a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1744201406610558933L, "com/mopub/nativeads/SomaMopubAdapterInterstitial$4", 3);
        f36100a = probes;
        return probes;
    }

    C11578Xa(SomaMopubAdapterInterstitial this$0) {
        boolean[] a = m38407a();
        this.f36101b = this$0;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38407a();
        SomaMopubAdapterInterstitial.m38376b(this.f36101b).post(new C11576Wa(this));
        a[1] = true;
        return null;
    }
}
