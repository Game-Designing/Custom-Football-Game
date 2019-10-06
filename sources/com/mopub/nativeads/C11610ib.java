package com.mopub.nativeads;

import android.view.View;
import com.smaato.soma.C12398ha;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.ib */
/* compiled from: SomaMopubNativeCustomEvent */
class C11610ib extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36160a;

    /* renamed from: b */
    final /* synthetic */ View f36161b;

    /* renamed from: c */
    final /* synthetic */ C11568a f36162c;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38430a() {
        boolean[] zArr = f36160a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1470378161546111528L, "com/mopub/nativeads/SomaMopubNativeCustomEvent$SmaatoForwardingNativeAd$6", 5);
        f36160a = probes;
        return probes;
    }

    C11610ib(C11568a this$0, View view) {
        boolean[] a = m38430a();
        this.f36162c = this$0;
        this.f36161b = view;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38430a();
        C11568a.m38384d(this.f36162c).mo39874d(this.f36161b);
        a[1] = true;
        C11568a.m38383c(this.f36162c).removeView(this.f36161b);
        a[2] = true;
        C11568a.m38385e(this.f36162c).clearOnClickListener(this.f36161b);
        a[3] = true;
        return null;
    }
}
