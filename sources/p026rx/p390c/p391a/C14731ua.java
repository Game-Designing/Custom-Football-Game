package p026rx.p390c.p391a;

import p026rx.C0120S.C0123b;
import p026rx.C14980ia;
import p026rx.p027b.C0128a;
import p026rx.p399e.C14920i;

/* renamed from: rx.c.a.ua */
/* compiled from: OperatorDoOnSubscribe */
public class C14731ua<T> implements C0123b<T, T> {

    /* renamed from: a */
    private final C0128a f43825a;

    public C14731ua(C0128a subscribe) {
        this.f43825a = subscribe;
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super T> child) {
        this.f43825a.call();
        return C14920i.m46653a(child);
    }
}
