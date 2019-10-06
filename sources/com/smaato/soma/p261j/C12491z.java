package com.smaato.soma.p261j;

import com.moat.analytics.mobile.sma.MoatAdEvent;
import com.moat.analytics.mobile.sma.MoatAdEventType;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p239c.p252i.C12279e;
import java.util.Vector;

/* renamed from: com.smaato.soma.j.z */
/* compiled from: VASTView */
class C12491z extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12435D f38948a;

    C12491z(C12435D this$0) {
        this.f38948a = this$0;
    }

    public Void process() throws Exception {
        if (this.f38948a.f38836q != null) {
            this.f38948a.f38836q.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_COMPLETE));
        }
        this.f38948a.f38832m = true;
        new C12279e().execute(new Vector[]{this.f38948a.f38820a.mo39692a("complete")});
        this.f38948a.f38823d.mo39494i();
        if (this.f38948a.f38822c != null) {
            this.f38948a.f38822c.mo39957b();
        }
        return null;
    }
}
