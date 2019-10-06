package com.smaato.soma.p239c.p242c;

import com.smaato.soma.interstitial.C12424n;

/* renamed from: com.smaato.soma.c.c.c */
/* compiled from: InterstitialAdDispatcher */
class C12190c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12196i f38217a;

    C12190c(C12196i this$0) {
        this.f38217a = this$0;
    }

    public void run() {
        C12424n nVar = this.f38217a.f38224b;
        if (nVar != null) {
            nVar.onReadyToShow();
        }
    }
}
