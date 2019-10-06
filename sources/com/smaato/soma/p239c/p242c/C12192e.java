package com.smaato.soma.p239c.p242c;

import com.smaato.soma.interstitial.C12424n;

/* renamed from: com.smaato.soma.c.c.e */
/* compiled from: InterstitialAdDispatcher */
class C12192e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12196i f38219a;

    C12192e(C12196i this$0) {
        this.f38219a = this$0;
    }

    public void run() {
        C12424n nVar = this.f38219a.f38224b;
        if (nVar != null) {
            nVar.onWillOpenLandingPage();
        }
    }
}
