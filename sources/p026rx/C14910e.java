package p026rx;

import p026rx.C0117M.C0118a;

/* renamed from: rx.e */
/* compiled from: Completable */
class C14910e implements C0118a {

    /* renamed from: a */
    final /* synthetic */ Single f44224a;

    C14910e(Single single) {
        this.f44224a = single;
    }

    /* renamed from: a */
    public void call(C14503O s) {
        SingleSubscriber<Object> te = new C14904d<>(this, s);
        s.mo45688a(te);
        this.f44224a.mo3691a((C14972ha<? super T>) te);
    }
}
