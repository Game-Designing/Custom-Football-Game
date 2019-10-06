package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.nb */
/* compiled from: SomaMopubVideoAdapter */
class C11627nb extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36200a;

    /* renamed from: b */
    final /* synthetic */ SomaMopubVideoAdapter f36201b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38456a() {
        boolean[] zArr = f36200a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7686625516275560774L, "com/mopub/nativeads/SomaMopubVideoAdapter$1", 3);
        f36200a = probes;
        return probes;
    }

    C11627nb(SomaMopubVideoAdapter this$0) {
        boolean[] a = m38456a();
        this.f36201b = this$0;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38456a();
        SomaMopubVideoAdapter.m38392b(this.f36201b).post(new C11624mb(this));
        a[1] = true;
        return null;
    }
}
