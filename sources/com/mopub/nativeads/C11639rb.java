package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.rb */
/* compiled from: SomaMopubVideoAdapter */
class C11639rb extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36228a;

    /* renamed from: b */
    final /* synthetic */ SomaMopubVideoAdapter f36229b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38465a() {
        boolean[] zArr = f36228a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8446662978548344486L, "com/mopub/nativeads/SomaMopubVideoAdapter$3", 3);
        f36228a = probes;
        return probes;
    }

    C11639rb(SomaMopubVideoAdapter this$0) {
        boolean[] a = m38465a();
        this.f36229b = this$0;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38465a();
        SomaMopubVideoAdapter.m38392b(this.f36229b).post(new C11636qb(this));
        a[1] = true;
        return null;
    }
}
