package com.smaato.soma.p258g;

import com.moat.analytics.mobile.sma.NativeDisplayTracker.MoatUserInteractionType;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.g.m */
/* compiled from: NativeAd */
class C12384m extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12389r f38668a;

    C12384m(C12389r this$0) {
        this.f38668a = this$0;
    }

    public Void process() {
        C12389r rVar = this.f38668a;
        rVar.m40716b(rVar.f38685d.mo39525d());
        this.f38668a.m40697a(MoatUserInteractionType.CLICK);
        C12146d.m39965a(new C12147e("NATIVE", "recordClickImpression called from Smaato SDK", 1, C12143a.DEBUG));
        return null;
    }
}
