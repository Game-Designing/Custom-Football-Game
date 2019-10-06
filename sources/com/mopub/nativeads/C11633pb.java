package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.pb */
/* compiled from: SomaMopubVideoAdapter */
class C11633pb extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36216a;

    /* renamed from: b */
    final /* synthetic */ SomaMopubVideoAdapter f36217b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38461a() {
        boolean[] zArr = f36216a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8371696100288919160L, "com/mopub/nativeads/SomaMopubVideoAdapter$2", 3);
        f36216a = probes;
        return probes;
    }

    C11633pb(SomaMopubVideoAdapter this$0) {
        boolean[] a = m38461a();
        this.f36217b = this$0;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38461a();
        SomaMopubVideoAdapter.m38392b(this.f36217b).post(new C11630ob(this));
        a[1] = true;
        return null;
    }
}
