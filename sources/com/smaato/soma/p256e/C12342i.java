package com.smaato.soma.p256e;

import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.e.i */
/* compiled from: GooglePlayMediationInterstitial */
class C12342i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12343j f38571a;

    C12342i(C12343j this$0) {
        this.f38571a = this$0;
    }

    public void run() {
        String c = C12343j.f38572a;
        StringBuilder sb = new StringBuilder();
        sb.append(C12343j.f38572a);
        sb.append("timed out to fill Ad.");
        C12146d.m39965a(new C12147e(c, sb.toString(), 1, C12143a.DEBUG));
        this.f38571a.f38573b.mo39590a(C12408ia.NETWORK_NO_FILL);
        this.f38571a.mo39737a();
    }
}
