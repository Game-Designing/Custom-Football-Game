package com.smaato.soma.p239c.p241b;

import android.content.Intent;
import com.smaato.soma.C12142b;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.c.b.g */
/* compiled from: MraidBridge */
class C12167g extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ String f38148a;

    /* renamed from: b */
    final /* synthetic */ C12173m f38149b;

    C12167g(C12173m this$0, String str) {
        this.f38149b = this$0;
        this.f38148a = str;
    }

    public Void process() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("Opening URL ");
        sb.append(this.f38148a);
        sb.append(" in external browser.");
        C12146d.m39965a(new C12147e("Mraid_Bridge", sb.toString(), 1, C12143a.INFO));
        boolean isUrlValid = false;
        if (!this.f38149b.mo39411b(this.f38148a)) {
            isUrlValid = C12142b.m39962a(this.f38148a, this.f38149b.f38168c);
        } else if (!this.f38148a.equalsIgnoreCase("about:blank")) {
            isUrlValid = true;
            Intent intent = Intent.parseUri(this.f38148a, 1);
            intent.addFlags(268435456);
            this.f38149b.f38168c.startActivity(intent);
        }
        if (isUrlValid && this.f38149b.f38166a != null) {
            C12173m mVar = this.f38149b;
            mVar.m40001a(mVar.f38166a);
        }
        return null;
    }
}
