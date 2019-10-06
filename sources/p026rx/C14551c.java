package p026rx;

import p026rx.C0117M.C0118a;

/* renamed from: rx.c */
/* compiled from: Completable */
class C14551c implements C0118a {

    /* renamed from: a */
    final /* synthetic */ C0120S f43357a;

    C14551c(C0120S s) {
        this.f43357a = s;
    }

    /* renamed from: a */
    public void call(C14503O cs) {
        Subscriber<Object> subscriber = new C14527b<>(this, cs);
        cs.mo45688a(subscriber);
        this.f43357a.mo3640b((C14980ia<? super T>) subscriber);
    }
}
