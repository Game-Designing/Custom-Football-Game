package com.smaato.soma.p256e;

import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.e.C */
/* compiled from: MoPubMediationInterstitial */
class C12327C implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12328D f38537a;

    C12327C(C12328D this$0) {
        this.f38537a = this$0;
    }

    public void run() {
        String c = C12328D.f38538a;
        StringBuilder sb = new StringBuilder();
        sb.append(C12328D.f38538a);
        sb.append("timed out to fill Ad.");
        C12146d.m39965a(new C12147e(c, sb.toString(), 1, C12143a.DEBUG));
        this.f38537a.f38539b.mo39590a(C12408ia.NETWORK_NO_FILL);
        this.f38537a.mo39737a();
    }
}
