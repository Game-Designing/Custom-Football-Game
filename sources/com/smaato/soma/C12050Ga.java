package com.smaato.soma;

import com.smaato.soma.p238b.C12146d;

/* renamed from: com.smaato.soma.Ga */
/* compiled from: LoadingStateDelegateImp */
class C12050Ga implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12054Ia f37908a;

    C12050Ga(C12054Ia this$0) {
        this.f37908a = this$0;
    }

    public void run() {
        C12146d.m39966a((Object) new C12048Fa(this));
        if (this.f37908a.f37913a != null) {
            C12369fa tempBannerView = (C12369fa) this.f37908a.f37913a.get();
            if (tempBannerView != null && tempBannerView.getAdDownloader() != null) {
                tempBannerView.getAdDownloader().mo39256a();
            }
        }
    }
}
