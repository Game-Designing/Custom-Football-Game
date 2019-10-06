package com.smaato.soma.p239c.p241b;

import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p255d.C12316i;

/* renamed from: com.smaato.soma.c.b.f */
/* compiled from: MraidBridge */
class C12166f extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ String f38146a;

    /* renamed from: b */
    final /* synthetic */ C12173m f38147b;

    C12166f(C12173m this$0, String str) {
        this.f38147b = this$0;
        this.f38146a = str;
    }

    public Void process() throws Exception {
        if (this.f38146a == null || !this.f38147b.mo39410a("redirection")) {
            this.f38147b.m40008a(C12316i.AUTO_REDIRECT, this.f38146a, "open");
            StringBuilder sb = new StringBuilder();
            sb.append("Opening URL ");
            sb.append(this.f38146a);
            sb.append(" in external browser.");
            sb.append(" failed. User click not detected ...");
            C12146d.m39965a(new C12147e("Mraid_Bridge", sb.toString(), 1, C12143a.WARNING));
        } else {
            this.f38147b.m40012c(this.f38146a);
        }
        return null;
    }
}
