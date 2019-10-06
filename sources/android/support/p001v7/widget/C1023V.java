package android.support.p001v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v7.widget.V */
/* compiled from: DefaultItemAnimator */
class C1023V implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ArrayList f3422a;

    /* renamed from: b */
    final /* synthetic */ C1047da f3423b;

    C1023V(C1047da this$0, ArrayList arrayList) {
        this.f3423b = this$0;
        this.f3422a = arrayList;
    }

    public void run() {
        Iterator it = this.f3422a.iterator();
        while (it.hasNext()) {
            C1049b moveInfo = (C1049b) it.next();
            this.f3423b.mo8403b(moveInfo.f3495a, moveInfo.f3496b, moveInfo.f3497c, moveInfo.f3498d, moveInfo.f3499e);
        }
        this.f3422a.clear();
        this.f3423b.f3483n.remove(this.f3422a);
    }
}
