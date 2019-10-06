package com.bumptech.glide;

import com.bumptech.glide.p103f.C5988e;
import com.bumptech.glide.p103f.C5990f;

/* renamed from: com.bumptech.glide.i */
/* compiled from: RequestBuilder */
class C6027i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C5988e f10667a;

    /* renamed from: b */
    final /* synthetic */ C6029k f10668b;

    C6027i(C6029k this$0, C5988e eVar) {
        this.f10668b = this$0;
        this.f10667a = eVar;
    }

    public void run() {
        if (!this.f10667a.isCancelled()) {
            C6029k kVar = this.f10668b;
            C5988e eVar = this.f10667a;
            kVar.mo18833a(eVar, (C5990f<TranscodeType>) eVar);
        }
    }
}
