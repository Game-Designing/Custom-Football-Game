package com.smaato.soma.p239c.p242c;

import com.smaato.soma.interstitial.C12424n;

/* renamed from: com.smaato.soma.c.c.f */
/* compiled from: InterstitialAdDispatcher */
class C12193f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12196i f38220a;

    C12193f(C12196i this$0) {
        this.f38220a = this$0;
    }

    public void run() {
        C12424n nVar = this.f38220a.f38224b;
        if (nVar != null) {
            nVar.onWillClose();
        }
    }
}
