package com.smaato.soma.p256e;

import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.e.x */
/* compiled from: MillennialMediationBanner */
class C12361x implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12362y f38615a;

    C12361x(C12362y this$0) {
        this.f38615a = this$0;
    }

    public void run() {
        C12146d.m39965a(new C12147e("MMediaBanner", "MMediaBannertimed out to fill Ad.", 1, C12143a.DEBUG));
        if (this.f38615a.f38617b != null) {
            this.f38615a.f38617b.mo39597a(C12408ia.NETWORK_NO_FILL);
        }
        this.f38615a.mo39740a();
    }
}
