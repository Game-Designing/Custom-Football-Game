package p026rx;

import p026rx.C0126V.C0127a;
import p026rx.p027b.C0128a;

/* renamed from: rx.Y */
/* compiled from: Single */
class C14511Y implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C14972ha f43322a;

    /* renamed from: b */
    final /* synthetic */ C0127a f43323b;

    /* renamed from: c */
    final /* synthetic */ C14512Z f43324c;

    C14511Y(C14512Z z, C14972ha haVar, C0127a aVar) {
        this.f43324c = z;
        this.f43322a = haVar;
        this.f43323b = aVar;
    }

    public void call() {
        SingleSubscriber<T> single = new C14510X<>(this);
        this.f43322a.mo46195b(single);
        this.f43324c.f43326b.mo3691a((C14972ha<? super T>) single);
    }
}
