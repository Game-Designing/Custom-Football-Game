package p024io.realm.p355a;

import p024io.realm.C14000K;
import p024io.realm.C14052da;
import p024io.realm.C14065j;
import p026rx.C14980ia;

/* renamed from: io.realm.a.m */
/* compiled from: RealmObservableFactory */
class C14034m implements C14000K<C14052da<C14065j>> {

    /* renamed from: a */
    final /* synthetic */ C14980ia f42528a;

    /* renamed from: b */
    final /* synthetic */ C14036o f42529b;

    C14034m(C14036o this$1, C14980ia iaVar) {
        this.f42529b = this$1;
        this.f42528a = iaVar;
    }

    /* renamed from: a */
    public void mo43559a(C14052da<C14065j> daVar) {
        if (!this.f42528a.isUnsubscribed()) {
            this.f42528a.onNext(this.f42529b.f42534b);
        }
    }
}
