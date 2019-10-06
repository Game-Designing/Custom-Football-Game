package com.smaato.soma.p258g;

import com.smaato.soma.C12367f;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.g.p */
/* compiled from: NativeAd */
class C12387p extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12374c f38672a;

    /* renamed from: b */
    final /* synthetic */ C12389r f38673b;

    C12387p(C12389r this$0, C12374c cVar) {
        this.f38673b = this$0;
        this.f38672a = cVar;
    }

    public Void process() {
        if (this.f38672a == null) {
            C12146d.m39965a(new C12147e("NATIVE", "NativeAdListener cannot be null !", 1, C12143a.ERROR));
        }
        this.f38673b.mo39871c().mo39884a("icon,image,title,txt");
        this.f38673b.f38688g.mo39602a((C12367f) new C12386o(this));
        this.f38673b.f38688g.mo39256a();
        return null;
    }
}
