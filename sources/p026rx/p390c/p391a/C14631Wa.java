package p026rx.p390c.p391a;

import p026rx.C0120S.C0123b;
import p026rx.C14980ia;
import rx.Subscriber;

/* renamed from: rx.c.a.Wa */
/* compiled from: OperatorTake */
public final class C14631Wa<T> implements C0123b<T, T> {

    /* renamed from: a */
    final int f43580a;

    public C14631Wa(int limit) {
        if (limit >= 0) {
            this.f43580a = limit;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("limit >= 0 required but it was ");
        sb.append(limit);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super T> child) {
        Subscriber<T> parent = new C14629Va<>(this, child);
        if (this.f43580a == 0) {
            child.onCompleted();
            parent.unsubscribe();
        }
        child.add(parent);
        return parent;
    }
}
