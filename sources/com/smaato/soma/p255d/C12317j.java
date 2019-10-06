package com.smaato.soma.p255d;

import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.d.j */
/* compiled from: Reporter */
class C12317j extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12316i f38518a;

    /* renamed from: b */
    final /* synthetic */ C12319l f38519b;

    C12317j(C12319l this$0, C12316i iVar) {
        this.f38519b = this$0;
        this.f38518a = iVar;
    }

    public Void process() throws Exception {
        int i = C12318k.f38520a[this.f38518a.ordinal()];
        if (i == 1) {
            C12146d.m39965a(new C12147e(C12319l.f38522b, "Uber Frequent Request Detected", 2, C12143a.WARNING));
        } else if (i == 2) {
            C12146d.m39965a(new C12147e(C12319l.f38522b, "Auto Click Detected", 2, C12143a.WARNING));
        } else if (i == 3 || i == 4 || i != 5) {
        }
        return null;
    }
}
