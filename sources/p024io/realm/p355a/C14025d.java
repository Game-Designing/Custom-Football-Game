package p024io.realm.p355a;

import p024io.realm.C14000K;
import p024io.realm.C14065j;
import p026rx.C14980ia;

/* renamed from: io.realm.a.d */
/* compiled from: RealmObservableFactory */
class C14025d implements C14000K<C14065j> {

    /* renamed from: a */
    final /* synthetic */ C14980ia f42509a;

    /* renamed from: b */
    final /* synthetic */ C14027f f42510b;

    C14025d(C14027f this$1, C14980ia iaVar) {
        this.f42510b = this$1;
        this.f42509a = iaVar;
    }

    /* renamed from: a */
    public void mo43559a(C14065j object) {
        if (!this.f42509a.isUnsubscribed()) {
            this.f42509a.onNext(object);
        }
    }
}
