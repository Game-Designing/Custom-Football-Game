package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.Oa */
/* compiled from: SomaMopubAdapter */
class C11560Oa extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36005a;

    /* renamed from: b */
    final /* synthetic */ C11562Pa f36006b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38351a() {
        boolean[] zArr = f36005a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2719976331582804491L, "com/mopub/nativeads/SomaMopubAdapter$2$2", 3);
        f36005a = probes;
        return probes;
    }

    C11560Oa(C11562Pa this$1) {
        boolean[] a = m38351a();
        this.f36006b = this$1;
        a[0] = true;
    }

    public Void process() throws Exception {
        boolean[] a = m38351a();
        SomaMopubAdapter.m38367a(this.f36006b.f36010c, "Banner closed", C12143a.DEBUG);
        a[1] = true;
        return null;
    }
}
