package com.smaato.soma.p239c.p242c;

/* renamed from: com.smaato.soma.c.c.n */
/* compiled from: VideoAdDispatcher */
class C12201n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12202o f38229a;

    C12201n(C12202o this$0) {
        this.f38229a = this$0;
    }

    public void run() {
        if (this.f38229a.m40113n() != null) {
            this.f38229a.m40113n().onRewardedVideoCompleted();
        }
    }
}
