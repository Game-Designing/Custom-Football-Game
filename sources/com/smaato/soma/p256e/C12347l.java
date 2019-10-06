package com.smaato.soma.p256e;

import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.e.l */
/* compiled from: MediationEventBannerAdapter */
class C12347l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12348m f38578a;

    C12347l(C12348m this$0) {
        this.f38578a = this$0;
    }

    public void run() {
        C12146d.m39965a(new C12147e("MediationEventBannerAdapter", "Third-party network timed out to fill Ad.", 1, C12143a.DEBUG));
        this.f38578a.mo39597a(C12408ia.NETWORK_TIMEOUT);
        this.f38578a.mo39760b();
    }
}
