package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.tb */
/* compiled from: SomaMopubVideoAdapter */
class C11645tb extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36239a;

    /* renamed from: b */
    final /* synthetic */ SomaMopubVideoAdapter f36240b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38469a() {
        boolean[] zArr = f36239a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2547624799731698972L, "com/mopub/nativeads/SomaMopubVideoAdapter$4", 3);
        f36239a = probes;
        return probes;
    }

    C11645tb(SomaMopubVideoAdapter this$0) {
        boolean[] a = m38469a();
        this.f36240b = this$0;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38469a();
        SomaMopubVideoAdapter.m38392b(this.f36240b).post(new C11642sb(this));
        a[1] = true;
        return null;
    }
}
