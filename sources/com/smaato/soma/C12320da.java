package com.smaato.soma;

import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.C12187c;
import com.smaato.soma.p239c.p251h.C12271e.C12272a;

/* renamed from: com.smaato.soma.da */
/* compiled from: BaseView */
class C12320da implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12064Na f38523a;

    /* renamed from: b */
    final /* synthetic */ C12370a f38524b;

    C12320da(C12370a this$1, C12064Na na) {
        this.f38524b = this$1;
        this.f38523a = na;
    }

    public void run() {
        try {
            C12369fa.this.setNextPackage(C12187c.m40092b().mo39466a((C12431j) null));
            C12369fa.this.getNextPackage().mo39349b(this.f38523a);
            C12369fa.this.getLoadingState().mo39656a(C12272a.STATE_BANNERLOADING);
            C12369fa.this.getLoadingState().mo39661d();
        } catch (Exception e) {
            C12146d.m39965a(new C12147e("BaseView", "Exception from Mediation Network BannerAd  BaseView.onReceiveAd()", 1, C12143a.DEBUG));
        }
    }
}
