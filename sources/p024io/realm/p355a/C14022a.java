package p024io.realm.p355a;

import p024io.realm.C14000K;
import p026rx.C14980ia;

/* renamed from: io.realm.a.a */
/* compiled from: RealmObservableFactory */
class C14022a implements C14000K<E> {

    /* renamed from: a */
    final /* synthetic */ C14980ia f42501a;

    /* renamed from: b */
    final /* synthetic */ C14024c f42502b;

    C14022a(C14024c this$1, C14980ia iaVar) {
        this.f42502b = this$1;
        this.f42501a = iaVar;
    }

    /* renamed from: a */
    public void mo43559a(E object) {
        if (!this.f42501a.isUnsubscribed()) {
            this.f42501a.onNext(object);
        }
    }
}
