package com.smaato.soma.p239c.p246f;

import com.smaato.soma.p236a.p237a.C12112c;
import com.smaato.soma.p239c.p246f.p248b.C12214a;
import java.util.HashMap;

/* renamed from: com.smaato.soma.c.f.m */
/* compiled from: BeaconRequest */
class C12241m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ HashMap f38359a;

    /* renamed from: b */
    final /* synthetic */ C12242n f38360b;

    C12241m(C12242n this$0, HashMap hashMap) {
        this.f38360b = this$0;
        this.f38359a = hashMap;
    }

    public void run() {
        C12214a aVar = new C12214a(this.f38360b.f38362b.getSessionId());
        aVar.mo39544a(C12112c.f38000c);
        aVar.execute(new HashMap[]{this.f38359a});
    }
}
