package p026rx.p390c.p391a;

import java.util.Comparator;
import p026rx.p027b.C14541q;

/* renamed from: rx.c.a.nb */
/* compiled from: OperatorToObservableSortedList */
class C14697nb implements Comparator<T> {

    /* renamed from: a */
    final /* synthetic */ C14541q f43728a;

    /* renamed from: b */
    final /* synthetic */ C14705pb f43729b;

    C14697nb(C14705pb pbVar, C14541q qVar) {
        this.f43729b = pbVar;
        this.f43728a = qVar;
    }

    public int compare(T o1, T o2) {
        return ((Integer) this.f43728a.call(o1, o2)).intValue();
    }
}
