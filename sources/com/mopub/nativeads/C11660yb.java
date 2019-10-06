package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.yb */
/* compiled from: SomaMopubVideoAdapter */
class C11660yb extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36268a;

    /* renamed from: b */
    final /* synthetic */ SomaMopubVideoAdapter f36269b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38483a() {
        boolean[] zArr = f36268a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2794940152736847509L, "com/mopub/nativeads/SomaMopubVideoAdapter$7", 3);
        f36268a = probes;
        return probes;
    }

    C11660yb(SomaMopubVideoAdapter this$0) {
        boolean[] a = m38483a();
        this.f36269b = this$0;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38483a();
        SomaMopubVideoAdapter.m38392b(this.f36269b).post(new C11657xb(this));
        a[1] = true;
        return null;
    }
}
