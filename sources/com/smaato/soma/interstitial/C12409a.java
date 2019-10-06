package com.smaato.soma.interstitial;

import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.smaato.soma.C12398ha;

/* renamed from: com.smaato.soma.interstitial.a */
/* compiled from: BaseActivity */
class C12409a extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12412d f38764a;

    C12409a(C12412d this$0) {
        this.f38764a = this$0;
    }

    public Void process() throws Exception {
        this.f38764a.mo40014e();
        C12412d dVar = this.f38764a;
        dVar.f38767a = new RelativeLayout(dVar);
        new LayoutParams(-1, -2).addRule(13);
        C12412d dVar2 = this.f38764a;
        dVar2.setContentView(dVar2.f38767a, new LayoutParams(-1, -1));
        return null;
    }
}
