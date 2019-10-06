package com.smaato.soma.p239c.p241b;

import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p254k.C12301p;

/* renamed from: com.smaato.soma.c.b.l */
/* compiled from: MraidBridge */
class C12172l extends C12398ha<Boolean> {

    /* renamed from: a */
    final /* synthetic */ String f38164a;

    /* renamed from: b */
    final /* synthetic */ C12173m f38165b;

    C12172l(C12173m this$0, String str) {
        this.f38165b = this$0;
        this.f38164a = str;
    }

    public Boolean process() throws Exception {
        boolean result = ((C12301p) this.f38165b.f38166a.mo39361l()).mo39721a();
        if (!result) {
            StringBuilder sb = new StringBuilder();
            sb.append("User Click not detected, escaping ");
            sb.append(this.f38164a);
            sb.append(" ...");
            C12146d.m39965a(new C12147e("Mraid_Bridge", sb.toString(), 1, C12143a.WARNING));
        }
        return Boolean.valueOf(result);
    }
}
