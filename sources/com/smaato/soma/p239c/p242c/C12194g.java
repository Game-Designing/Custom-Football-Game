package com.smaato.soma.p239c.p242c;

import com.smaato.soma.interstitial.C12424n;

/* renamed from: com.smaato.soma.c.c.g */
/* compiled from: InterstitialAdDispatcher */
class C12194g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12196i f38221a;

    C12194g(C12196i this$0) {
        this.f38221a = this$0;
    }

    public void run() {
        C12424n nVar = this.f38221a.f38224b;
        if (nVar != null) {
            nVar.onFailedToLoadAd();
        }
    }
}
