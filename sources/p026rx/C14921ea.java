package p026rx;

import p026rx.Single.C0124a;

/* renamed from: rx.ea */
/* compiled from: Single */
class C14921ea implements C0124a<T> {

    /* renamed from: a */
    final /* synthetic */ Single f44240a;

    C14921ea(Single single) {
        this.f44240a = single;
    }

    /* renamed from: a */
    public void call(C14972ha<? super T> child) {
        SingleSubscriber<Single<? extends T>> parent = new C14909da<>(this, child);
        child.mo46195b(parent);
        this.f44240a.mo3691a((C14972ha<? super T>) parent);
    }
}
