package com.smaato.soma.p239c.p254k;

import android.view.ViewGroup;
import com.smaato.soma.C12398ha;

/* renamed from: com.smaato.soma.c.k.b */
/* compiled from: CustomWebView */
class C12287b extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12288c f38454a;

    C12287b(C12288c this$1) {
        this.f38454a = this$1;
    }

    public Void process() throws Exception {
        if (this.f38454a.f38455b >= 10 && !this.f38454a.f38459f.f38479a) {
            this.f38454a.f38459f.m40476b();
        } else if (this.f38454a.f38455b <= 0 && this.f38454a.f38459f.f38479a) {
            this.f38454a.f38459f.f38479a = false;
            ((ViewGroup) this.f38454a.f38459f.f38482d.getParent()).removeView(this.f38454a.f38459f.f38482d);
        }
        this.f38454a.f38456c = System.currentTimeMillis();
        return null;
    }
}
