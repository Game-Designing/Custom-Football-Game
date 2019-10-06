package p026rx.p390c.p391a;

import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;

/* renamed from: rx.c.a.j */
/* compiled from: EmptyObservableHolder */
public enum C14676j implements C0122a<Object> {
    INSTANCE;
    

    /* renamed from: b */
    static final C0120S<Object> f43680b = null;

    static {
        C14676j jVar;
        f43680b = C0120S.m648b((C0122a<T>) jVar);
    }

    /* renamed from: e */
    public static <T> C0120S<T> m46315e() {
        return f43680b;
    }

    /* renamed from: a */
    public void call(C14980ia<? super Object> child) {
        child.onCompleted();
    }
}
