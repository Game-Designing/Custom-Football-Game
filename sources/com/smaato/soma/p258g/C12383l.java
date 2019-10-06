package com.smaato.soma.p258g;

import android.view.View;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.g.l */
/* compiled from: NativeAd */
class C12383l extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ View f38666a;

    /* renamed from: b */
    final /* synthetic */ C12389r f38667b;

    C12383l(C12389r this$0, View view) {
        this.f38667b = this$0;
        this.f38666a = view;
    }

    public Void process() {
        if (this.f38667b.m40723e(this.f38666a)) {
            this.f38667b.m40734k();
        }
        C12146d.m39965a(new C12147e("NATIVE", "fireViewedImpression called from Smaato SDK", 1, C12143a.DEBUG));
        return null;
    }
}
