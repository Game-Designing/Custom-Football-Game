package android.support.p001v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v7.widget.W */
/* compiled from: DefaultItemAnimator */
class C1026W implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ArrayList f3430a;

    /* renamed from: b */
    final /* synthetic */ C1047da f3431b;

    C1026W(C1047da this$0, ArrayList arrayList) {
        this.f3431b = this$0;
        this.f3430a = arrayList;
    }

    public void run() {
        Iterator it = this.f3430a.iterator();
        while (it.hasNext()) {
            this.f3431b.mo8399a((C1048a) it.next());
        }
        this.f3430a.clear();
        this.f3431b.f3484o.remove(this.f3430a);
    }
}
