package com.facebook;

import android.util.Pair;
import com.facebook.C6814y.C6815a;
import com.facebook.GraphRequest.C6545b;
import com.facebook.GraphRequest.Callback;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.facebook.u */
/* compiled from: GraphRequest */
class C6810u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ArrayList f12525a;

    /* renamed from: b */
    final /* synthetic */ C6814y f12526b;

    C6810u(ArrayList arrayList, C6814y yVar) {
        this.f12525a = arrayList;
        this.f12526b = yVar;
    }

    public void run() {
        Iterator it = this.f12525a.iterator();
        while (it.hasNext()) {
            Pair<Callback, GraphResponse> pair = (Pair) it.next();
            ((C6545b) pair.first).mo9460a((C6817z) pair.second);
        }
        Iterator it2 = this.f12526b.mo20218g().iterator();
        while (it2.hasNext()) {
            ((C6815a) it2.next()).mo19866a(this.f12526b);
        }
    }
}
