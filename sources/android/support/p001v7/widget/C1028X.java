package android.support.p001v7.widget;

import android.support.p001v7.widget.RecyclerView.C1000w;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v7.widget.X */
/* compiled from: DefaultItemAnimator */
class C1028X implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ArrayList f3433a;

    /* renamed from: b */
    final /* synthetic */ C1047da f3434b;

    C1028X(C1047da this$0, ArrayList arrayList) {
        this.f3434b = this$0;
        this.f3433a = arrayList;
    }

    public void run() {
        Iterator it = this.f3433a.iterator();
        while (it.hasNext()) {
            this.f3434b.mo8407t((C1000w) it.next());
        }
        this.f3433a.clear();
        this.f3434b.f3482m.remove(this.f3433a);
    }
}
