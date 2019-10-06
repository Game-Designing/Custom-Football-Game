package p024io.realm.internal;

import p024io.realm.internal.C7336k.C7337a;

/* renamed from: io.realm.internal.o */
/* compiled from: RealmNotifier */
class C7343o implements C7337a<C7310a> {

    /* renamed from: a */
    final /* synthetic */ RealmNotifier f14330a;

    C7343o(RealmNotifier this$0) {
        this.f14330a = this$0;
    }

    /* renamed from: a */
    public void mo23567a(C7310a pair, Object observer) {
        if (this.f14330a.sharedRealm != null && !this.f14330a.sharedRealm.isClosed()) {
            pair.m15928a(observer);
        }
    }
}
