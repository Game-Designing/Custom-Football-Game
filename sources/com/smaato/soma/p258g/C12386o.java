package com.smaato.soma.p258g;

import com.smaato.soma.C12064Na;
import com.smaato.soma.C12322e;
import com.smaato.soma.C12367f;

/* renamed from: com.smaato.soma.g.o */
/* compiled from: NativeAd */
class C12386o implements C12367f {

    /* renamed from: a */
    final /* synthetic */ C12387p f38671a;

    C12386o(C12387p this$1) {
        this.f38671a = this$1;
    }

    public void onReceiveAd(C12322e sender, C12064Na receivedBanner) {
        new C12385n(this, receivedBanner).execute();
    }
}
