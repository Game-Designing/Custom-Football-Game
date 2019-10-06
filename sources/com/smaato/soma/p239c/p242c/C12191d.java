package com.smaato.soma.p239c.p242c;

import com.smaato.soma.interstitial.C12424n;

/* renamed from: com.smaato.soma.c.c.d */
/* compiled from: InterstitialAdDispatcher */
class C12191d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12196i f38218a;

    C12191d(C12196i this$0) {
        this.f38218a = this$0;
    }

    public void run() {
        C12424n nVar = this.f38218a.f38224b;
        if (nVar != null) {
            nVar.onWillShow();
        }
    }
}
