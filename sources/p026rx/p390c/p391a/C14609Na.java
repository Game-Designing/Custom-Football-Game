package p026rx.p390c.p391a;

import p026rx.C0120S.C0123b;
import p026rx.C14980ia;

/* renamed from: rx.c.a.Na */
/* compiled from: OperatorSkip */
public final class C14609Na<T> implements C0123b<T, T> {

    /* renamed from: a */
    final int f43510a;

    public C14609Na(int n) {
        if (n >= 0) {
            this.f43510a = n;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("n >= 0 required but it was ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super T> child) {
        return new C14607Ma(this, child, child);
    }
}
