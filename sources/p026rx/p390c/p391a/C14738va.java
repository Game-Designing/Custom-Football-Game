package p026rx.p390c.p391a;

import p026rx.C0120S.C0123b;
import p026rx.C14980ia;
import p026rx.p027b.C0128a;
import p026rx.p029i.C14978f;
import p026rx.p399e.C14920i;

/* renamed from: rx.c.a.va */
/* compiled from: OperatorDoOnUnsubscribe */
public class C14738va<T> implements C0123b<T, T> {

    /* renamed from: a */
    private final C0128a f43843a;

    public C14738va(C0128a unsubscribe) {
        this.f43843a = unsubscribe;
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super T> child) {
        child.add(C14978f.m46781a(this.f43843a));
        return C14920i.m46653a(child);
    }
}
