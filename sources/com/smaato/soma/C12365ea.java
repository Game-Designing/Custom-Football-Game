package com.smaato.soma;

import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.C12187c;

/* renamed from: com.smaato.soma.ea */
/* compiled from: BaseView */
class C12365ea implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12064Na f38623a;

    /* renamed from: b */
    final /* synthetic */ C12370a f38624b;

    C12365ea(C12370a this$1, C12064Na na) {
        this.f38624b = this$1;
        this.f38623a = na;
    }

    public void run() {
        String str = "BaseView";
        try {
            C12369fa.this.setNextPackage(C12187c.m40092b().mo39466a(this.f38623a.mo39284b()));
            if (C12369fa.this.getNextPackage() != null) {
                C12369fa.this.getNextPackage().mo39349b(this.f38623a);
            } else {
                C12146d.m39965a(new C12147e(str, "getNextPackage() is Null handling Mediation Network InterstitialAd BaseView.onReceiveAd()", 1, C12143a.DEBUG));
            }
            C12369fa.this.getLoadingState().mo39662e();
        } catch (Exception e) {
            C12146d.m39965a(new C12147e(str, "Exception from Mediation Network InterstitialAd BaseView.onReceiveAd()", 1, C12143a.DEBUG));
        }
    }
}
