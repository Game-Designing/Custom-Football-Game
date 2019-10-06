package com.smaato.soma.p256e;

import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.e.q */
/* compiled from: MediationEventInterstitialAdapter */
class C12353q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f38590a;

    /* renamed from: b */
    final /* synthetic */ C12354r f38591b;

    C12353q(C12354r this$0, String str) {
        this.f38591b = this$0;
        this.f38590a = str;
    }

    public void run() {
        StringBuilder sb = new StringBuilder();
        sb.append("Third-party network timed out.");
        sb.append(this.f38590a);
        C12146d.m39965a(new C12147e("MediationEventInterstitialAdapter", sb.toString(), 1, C12143a.DEBUG));
        this.f38591b.mo39590a(C12408ia.NETWORK_TIMEOUT);
        this.f38591b.mo39769d();
    }
}
