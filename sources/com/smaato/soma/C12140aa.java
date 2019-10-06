package com.smaato.soma;

import com.smaato.soma.p239c.p251h.C12266b.C12267a;
import com.smaato.soma.p239c.p252i.C12277c;

/* renamed from: com.smaato.soma.aa */
/* compiled from: BaseView */
class C12140aa extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12369fa f38063a;

    C12140aa(C12369fa this$0) {
        this.f38063a = this$0;
    }

    public Void process() {
        if (C12277c.m40409a().mo39666b() && this.f38063a.getBannerState().mo39638a() != C12267a.STATE_BANNEREXPANDED) {
            this.f38063a.mo39226f();
            C12277c.m40409a().mo39668d();
        }
        new Thread(new C12086Z(this, this.f38063a.getLoadingState().mo39663f())).start();
        return null;
    }
}
