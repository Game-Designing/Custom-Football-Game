package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.vb */
/* compiled from: SomaMopubVideoAdapter */
class C11651vb extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36250a;

    /* renamed from: b */
    final /* synthetic */ SomaMopubVideoAdapter f36251b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38477a() {
        boolean[] zArr = f36250a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3031463707887122990L, "com/mopub/nativeads/SomaMopubVideoAdapter$5", 3);
        f36250a = probes;
        return probes;
    }

    C11651vb(SomaMopubVideoAdapter this$0) {
        boolean[] a = m38477a();
        this.f36251b = this$0;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38477a();
        SomaMopubVideoAdapter.m38392b(this.f36251b).post(new C11648ub(this));
        a[1] = true;
        return null;
    }
}
