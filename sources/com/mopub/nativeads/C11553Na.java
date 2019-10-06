package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.Na */
/* compiled from: SomaMopubAdapter */
class C11553Na extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f35914a;

    /* renamed from: b */
    final /* synthetic */ C11562Pa f35915b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38306a() {
        boolean[] zArr = f35914a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7125309551710116333L, "com/mopub/nativeads/SomaMopubAdapter$2$1", 4);
        f35914a = probes;
        return probes;
    }

    C11553Na(C11562Pa this$1) {
        boolean[] a = m38306a();
        this.f35915b = this$1;
        a[0] = true;
    }

    public Void process() throws Exception {
        boolean[] a = m38306a();
        SomaMopubAdapter.m38367a(this.f35915b.f36010c, "Banner Clicked", C12143a.DEBUG);
        a[1] = true;
        this.f35915b.f36009b.onBannerClicked();
        a[2] = true;
        return null;
    }
}
