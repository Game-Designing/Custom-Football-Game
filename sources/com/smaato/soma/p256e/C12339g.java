package com.smaato.soma.p256e;

import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.e.g */
/* compiled from: GooglePlayMediationBanner */
class C12339g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12340h f38565a;

    C12339g(C12340h this$0) {
        this.f38565a = this$0;
    }

    public void run() {
        if (this.f38565a.f38567b != null) {
            this.f38565a.f38567b.pause();
        }
        C12146d.m39965a(new C12147e("GooglePlayMediationBanner", "GooglePlayMediationBannertimed out to fill Ad.", 1, C12143a.DEBUG));
        this.f38565a.f38566a.mo39597a(C12408ia.NETWORK_NO_FILL);
        this.f38565a.mo39740a();
    }
}
