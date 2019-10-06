package com.smaato.soma.p239c.p242c;

import com.smaato.soma.interstitial.C12413e;
import com.smaato.soma.interstitial.C12424n;
import com.smaato.soma.p261j.C12448a;

/* renamed from: com.smaato.soma.c.c.h */
/* compiled from: InterstitialAdDispatcher */
class C12195h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12196i f38222a;

    C12195h(C12196i this$0) {
        this.f38222a = this$0;
    }

    public void run() {
        C12424n nVar = this.f38222a.f38224b;
        if (nVar == null) {
            return;
        }
        if (nVar instanceof C12413e) {
            ((C12413e) nVar).mo39913a();
        } else if (nVar instanceof C12448a) {
            ((C12448a) nVar).mo39974a();
        }
    }
}
