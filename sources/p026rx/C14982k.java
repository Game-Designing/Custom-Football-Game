package p026rx;

import p026rx.p027b.C0128a;
import p026rx.p400f.C14948s;

/* renamed from: rx.k */
/* compiled from: Completable */
class C14982k implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C0137ja f44335a;

    /* renamed from: b */
    final /* synthetic */ C14983l f44336b;

    C14982k(C14983l lVar, C0137ja jaVar) {
        this.f44336b = lVar;
        this.f44335a = jaVar;
    }

    public void call() {
        try {
            this.f44336b.f44338b.f44343e.call();
        } catch (Throwable e) {
            C14948s.m46719b(e);
        }
        this.f44335a.unsubscribe();
    }
}
