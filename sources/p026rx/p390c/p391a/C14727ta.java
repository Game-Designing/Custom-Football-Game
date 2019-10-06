package p026rx.p390c.p391a;

import p026rx.C0120S.C0123b;
import p026rx.C14980ia;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14541q;
import p026rx.p390c.p395e.C14900u;

/* renamed from: rx.c.a.ta */
/* compiled from: OperatorDistinctUntilChanged */
public final class C14727ta<T, U> implements C0123b<T, T>, C14541q<U, U, Boolean> {

    /* renamed from: a */
    final C0132p<? super T, ? extends U> f43817a;

    /* renamed from: b */
    final C14541q<? super U, ? super U, Boolean> f43818b = this;

    /* renamed from: rx.c.a.ta$a */
    /* compiled from: OperatorDistinctUntilChanged */
    static final class C14728a {

        /* renamed from: a */
        static final C14727ta<?, ?> f43819a = new C14727ta<>(C14900u.m46630b());
    }

    /* renamed from: a */
    public static <T> C14727ta<T, T> m46368a() {
        return C14728a.f43819a;
    }

    public C14727ta(C0132p<? super T, ? extends U> keySelector) {
        this.f43817a = keySelector;
    }

    public Boolean call(U t1, U t2) {
        return Boolean.valueOf(t1 == t2 || (t1 != null && t1.equals(t2)));
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super T> child) {
        return new C14724sa(this, child, child);
    }
}
