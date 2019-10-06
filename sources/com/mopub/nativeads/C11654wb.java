package com.mopub.nativeads;

import android.content.Context;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p261j.C12446N;
import com.smaato.soma.p261j.C12486u;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.wb */
/* compiled from: SomaMopubVideoAdapter */
class C11654wb extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36255a;

    /* renamed from: b */
    final /* synthetic */ Context f36256b;

    /* renamed from: c */
    final /* synthetic */ Map f36257c;

    /* renamed from: d */
    final /* synthetic */ SomaMopubVideoAdapter f36258d;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38479a() {
        boolean[] zArr = f36255a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1579260704737542848L, "com/mopub/nativeads/SomaMopubVideoAdapter$6", 6);
        f36255a = probes;
        return probes;
    }

    C11654wb(SomaMopubVideoAdapter this$0, Context context, Map map) {
        boolean[] a = m38479a();
        this.f36258d = this$0;
        this.f36256b = context;
        this.f36257c = map;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38479a();
        SomaMopubVideoAdapter.m38389a(this.f36258d, new C12446N(this.f36256b));
        a[1] = true;
        SomaMopubVideoAdapter.m38393c(this.f36258d).mo39965a((C12486u) this.f36258d);
        a[2] = true;
        SomaMopubVideoAdapter somaMopubVideoAdapter = this.f36258d;
        SomaMopubVideoAdapter.m38390a(somaMopubVideoAdapter, this.f36257c, SomaMopubVideoAdapter.m38393c(somaMopubVideoAdapter).mo39967c());
        a[3] = true;
        SomaMopubVideoAdapter.m38393c(this.f36258d).mo39962a();
        a[4] = true;
        return null;
    }
}
