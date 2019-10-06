package com.smaato.soma.p236a;

import com.smaato.soma.ExpandedBannerActivity;

/* renamed from: com.smaato.soma.a.a */
/* compiled from: AbstractBannerPackage */
class C12109a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12125n f37992a;

    C12109a(C12125n this$0) {
        this.f37992a = this$0;
    }

    public void run() {
        if (this.f37992a.f38022e.getRootView().getContext() instanceof ExpandedBannerActivity) {
            ((ExpandedBannerActivity) this.f37992a.f38022e.getRootView().getContext()).finish();
        }
        this.f37992a.f38029l.getBannerAnimatorHandler().sendMessage(this.f37992a.f38029l.getBannerAnimatorHandler().obtainMessage(102));
    }
}
