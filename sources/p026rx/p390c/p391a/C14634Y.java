package p026rx.p390c.p391a;

import p026rx.C0120S;
import p026rx.C14972ha;
import p026rx.C14980ia;
import p026rx.Single.C0124a;
import rx.Subscriber;

/* renamed from: rx.c.a.Y */
/* compiled from: OnSubscribeSingle */
public class C14634Y<T> implements C0124a<T> {

    /* renamed from: a */
    private final C0120S<T> f43588a;

    public C14634Y(C0120S<T> observable) {
        this.f43588a = observable;
    }

    /* renamed from: a */
    public void call(C14972ha<? super T> child) {
        Subscriber<T> parent = new C14632X<>(this, child);
        child.mo46195b(parent);
        this.f43588a.mo3640b((C14980ia<? super T>) parent);
    }

    /* renamed from: a */
    public static <T> C14634Y<T> m46278a(C0120S<T> observable) {
        return new C14634Y<>(observable);
    }
}
