package com.smaato.soma.p256e;

import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.e.b */
/* compiled from: FacebookMediationBanner */
class C12332b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12333c f38549a;

    C12332b(C12333c this$0) {
        this.f38549a = this$0;
    }

    public void run() {
        C12146d.m39965a(new C12147e("FacebookMediationBanner", "FacebookMediationBannertimed out to fill Ad.", 1, C12143a.DEBUG));
        this.f38549a.mo39740a();
        this.f38549a.f38551b.mo39597a(C12408ia.NETWORK_NO_FILL);
    }
}
