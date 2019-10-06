package com.smaato.soma.p239c.p254k;

import com.smaato.soma.p239c.p246f.p248b.C12214a;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.smaato.soma.c.k.n */
/* compiled from: CustomWebView */
class C12299n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f38475a;

    /* renamed from: b */
    final /* synthetic */ HashMap f38476b;

    /* renamed from: c */
    final /* synthetic */ C12301p f38477c;

    C12299n(C12301p this$0, List list, HashMap hashMap) {
        this.f38477c = this$0;
        this.f38475a = list;
        this.f38476b = hashMap;
    }

    public void run() {
        C12214a aVar = new C12214a(this.f38477c.f38483e.getSessionId());
        aVar.mo39545a(this.f38475a);
        aVar.execute(new HashMap[]{this.f38476b});
    }
}
