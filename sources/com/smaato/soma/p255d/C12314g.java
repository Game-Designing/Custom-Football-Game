package com.smaato.soma.p255d;

import android.os.Handler;
import com.smaato.soma.C12369fa;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p260i.C12406g;

/* renamed from: com.smaato.soma.d.g */
/* compiled from: BannerMeasurements */
class C12314g extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12369fa f38499a;

    /* renamed from: b */
    final /* synthetic */ C12315h f38500b;

    C12314g(C12315h this$0, C12369fa faVar) {
        this.f38500b = this$0;
        this.f38499a = faVar;
    }

    public Void process() throws Exception {
        Handler h = new Handler();
        if (!this.f38500b.m40498c(this.f38499a)) {
            h.postDelayed(new C12309b(this), 3000);
        }
        if (!this.f38500b.m40495b(this.f38499a)) {
            h.postDelayed(new C12311d(this), 3000);
        }
        C12369fa faVar = this.f38499a;
        if (faVar instanceof C12406g) {
            return null;
        }
        boolean isOnTop = this.f38500b.m40499d(faVar);
        if (!isOnTop) {
            h.postDelayed(new C12313f(this, isOnTop), 3000);
        }
        return null;
    }
}
