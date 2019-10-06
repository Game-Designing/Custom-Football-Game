package p026rx.p390c.p391a;

import p026rx.C0120S.C0122a;
import p026rx.C0120S.C0123b;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.p400f.C14948s;
import rx.Subscriber;

/* renamed from: rx.c.a.F */
/* compiled from: OnSubscribeLift */
public final class C14576F<T, R> implements C0122a<R> {

    /* renamed from: a */
    final C0122a<T> f43425a;

    /* renamed from: b */
    final C0123b<? extends R, ? super T> f43426b;

    public C14576F(C0122a<T> parent, C0123b<? extends R, ? super T> operator) {
        this.f43425a = parent;
        this.f43426b = operator;
    }

    /* renamed from: a */
    public void call(C14980ia<? super R> o) {
        Subscriber<? super T> st;
        try {
            st = (C14980ia) C14948s.m46709a(this.f43426b).call(o);
            st.onStart();
            this.f43425a.call(st);
        } catch (Throwable e) {
            C14927a.m46678c(e);
            o.onError(e);
        }
    }
}
