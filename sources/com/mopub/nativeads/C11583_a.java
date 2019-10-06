package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads._a */
/* compiled from: SomaMopubAdapterInterstitial */
class C11583_a extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36109a;

    /* renamed from: b */
    final /* synthetic */ Map f36110b;

    /* renamed from: c */
    final /* synthetic */ SomaMopubAdapterInterstitial f36111c;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38410a() {
        boolean[] zArr = f36109a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6020953461319894233L, "com/mopub/nativeads/SomaMopubAdapterInterstitial$6", 4);
        f36109a = probes;
        return probes;
    }

    C11583_a(SomaMopubAdapterInterstitial this$0, Map map) {
        boolean[] a = m38410a();
        this.f36111c = this$0;
        this.f36110b = map;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38410a();
        SomaMopubAdapterInterstitial somaMopubAdapterInterstitial = this.f36111c;
        SomaMopubAdapterInterstitial.m38373a(somaMopubAdapterInterstitial, this.f36110b, SomaMopubAdapterInterstitial.m38377c(somaMopubAdapterInterstitial).getAdSettings());
        a[1] = true;
        SomaMopubAdapterInterstitial.m38377c(this.f36111c).mo39256a();
        a[2] = true;
        return null;
    }
}
