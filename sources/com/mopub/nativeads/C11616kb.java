package com.mopub.nativeads;

import android.view.View;
import com.smaato.soma.C12142b;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.kb */
/* compiled from: SomaMopubNativeCustomEvent */
class C11616kb extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36170a;

    /* renamed from: b */
    final /* synthetic */ View f36171b;

    /* renamed from: c */
    final /* synthetic */ C11568a f36172c;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38432a() {
        boolean[] zArr = f36170a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6699162011406602491L, "com/mopub/nativeads/SomaMopubNativeCustomEvent$SmaatoForwardingNativeAd$8", 8);
        f36170a = probes;
        return probes;
    }

    C11616kb(C11568a this$0, View view) {
        boolean[] a = m38432a();
        this.f36172c = this$0;
        this.f36171b = view;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38432a();
        this.f36172c.mo37749c();
        a[1] = true;
        if (this.f36172c.getClickDestinationUrl() == null) {
            a[2] = true;
        } else {
            a[3] = true;
            C12142b.m39962a(this.f36172c.getClickDestinationUrl(), C11568a.m38381a(this.f36172c));
            a[4] = true;
        }
        C11568a.m38384d(this.f36172c).mo39869b(this.f36171b);
        a[5] = true;
        C12146d.m39965a(new C12147e("SomaMopubNativeCustomEvent", "Smaato Native Ad clicked", 1, C12143a.DEBUG));
        a[6] = true;
        return null;
    }
}
