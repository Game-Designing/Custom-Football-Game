package com.smaato.soma.p256e;

import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.e.z */
/* compiled from: MillennialMediationInterstitial */
class C12364z implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12323A f38622a;

    C12364z(C12323A this$0) {
        this.f38622a = this$0;
    }

    public void run() {
        String c = C12323A.f38527a;
        StringBuilder sb = new StringBuilder();
        sb.append(C12323A.f38527a);
        sb.append("timed out to fill Ad.");
        C12146d.m39965a(new C12147e(c, sb.toString(), 1, C12143a.DEBUG));
        this.f38622a.f38529c.mo39590a(C12408ia.NETWORK_NO_FILL);
        this.f38622a.mo39737a();
    }
}
