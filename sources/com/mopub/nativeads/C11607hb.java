package com.mopub.nativeads;

import android.view.View;
import com.smaato.soma.C12398ha;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.hb */
/* compiled from: SomaMopubNativeCustomEvent */
class C11607hb extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36155a;

    /* renamed from: b */
    final /* synthetic */ View f36156b;

    /* renamed from: c */
    final /* synthetic */ C11568a f36157c;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38429a() {
        boolean[] zArr = f36155a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8898502420339087998L, "com/mopub/nativeads/SomaMopubNativeCustomEvent$SmaatoForwardingNativeAd$5", 5);
        f36155a = probes;
        return probes;
    }

    C11607hb(C11568a this$0, View view) {
        boolean[] a = m38429a();
        this.f36157c = this$0;
        this.f36156b = view;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38429a();
        C11568a.m38383c(this.f36157c).addView(this.f36156b, this.f36157c);
        a[1] = true;
        C11568a.m38384d(this.f36157c).mo39872c(this.f36156b);
        a[2] = true;
        C11568a.m38385e(this.f36157c).setOnClickListener(this.f36156b, this.f36157c);
        a[3] = true;
        return null;
    }
}
