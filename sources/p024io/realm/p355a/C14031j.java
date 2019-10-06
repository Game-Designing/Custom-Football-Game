package p024io.realm.p355a;

import p024io.realm.C14000K;
import p024io.realm.C14052da;
import p026rx.C14980ia;

/* renamed from: io.realm.a.j */
/* compiled from: RealmObservableFactory */
class C14031j implements C14000K<C14052da<E>> {

    /* renamed from: a */
    final /* synthetic */ C14980ia f42520a;

    /* renamed from: b */
    final /* synthetic */ C14033l f42521b;

    C14031j(C14033l this$1, C14980ia iaVar) {
        this.f42521b = this$1;
        this.f42520a = iaVar;
    }

    /* renamed from: a */
    public void mo43559a(C14052da<E> daVar) {
        if (!this.f42520a.isUnsubscribed()) {
            this.f42520a.onNext(this.f42521b.f42526b);
        }
    }
}
