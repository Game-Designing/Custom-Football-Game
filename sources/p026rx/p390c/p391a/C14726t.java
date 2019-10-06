package p026rx.p390c.p391a;

import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C0125T;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.p027b.C0131o;
import p026rx.p399e.C14920i;

/* renamed from: rx.c.a.t */
/* compiled from: OnSubscribeDefer */
public final class C14726t<T> implements C0122a<T> {

    /* renamed from: a */
    final C0131o<? extends C0120S<? extends T>> f43816a;

    public C14726t(C0131o<? extends C0120S<? extends T>> observableFactory) {
        this.f43816a = observableFactory;
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> s) {
        try {
            ((C0120S) this.f43816a.call()).mo3640b(C14920i.m46653a(s));
        } catch (Throwable t) {
            C14927a.m46672a(t, (C0125T<?>) s);
        }
    }
}
