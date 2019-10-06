package com.smaato.soma.p239c.p241b;

import com.smaato.soma.C12142b;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p252i.C12280f;
import com.smaato.soma.p255d.C12316i;

/* renamed from: com.smaato.soma.c.b.j */
/* compiled from: MraidBridge */
class C12170j extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ String f38160a;

    /* renamed from: b */
    final /* synthetic */ C12173m f38161b;

    C12170j(C12173m this$0, String str) {
        this.f38161b = this$0;
        this.f38160a = str;
    }

    public Void process() {
        boolean isUrlValid = false;
        String str = "playVideo";
        if (!this.f38161b.mo39410a("play video")) {
            this.f38161b.m40008a(C12316i.AUTO_PLAY, this.f38160a, str);
        } else {
            if (!C12280f.m40428a((CharSequence) this.f38160a) && !this.f38160a.equalsIgnoreCase("about:blank")) {
                isUrlValid = C12142b.m39962a(this.f38160a, this.f38161b.mo39408a());
            }
            if (!isUrlValid || this.f38161b.f38166a == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Bad URL: ");
                sb.append(this.f38160a);
                C12146d.m39965a(new C12147e("Mraid_Bridge", sb.toString(), 1, C12143a.WARNING));
                this.f38161b.m40006a("Invalid url passed to playVideo()", str);
            } else {
                C12173m mVar = this.f38161b;
                mVar.m40001a(mVar.f38166a);
            }
        }
        return null;
    }
}
