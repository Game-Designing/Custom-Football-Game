package p026rx.p390c.p391a;

import p026rx.C0120S;
import p026rx.C0120S.C0123b;
import p026rx.C14980ia;
import p026rx.p399e.C14917f;
import rx.Subscriber;

/* renamed from: rx.c.a.Za */
/* compiled from: OperatorTakeUntil */
public final class C14638Za<T, E> implements C0123b<T, T> {

    /* renamed from: a */
    private final C0120S<? extends E> f43597a;

    public C14638Za(C0120S<? extends E> other) {
        this.f43597a = other;
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super T> child) {
        Subscriber<T> serial = new C14917f<>(child, false);
        C14633Xa xa = new C14633Xa(this, serial, false, serial);
        Subscriber<E> so = new C14635Ya<>(this, xa);
        serial.add(xa);
        serial.add(so);
        child.add(serial);
        this.f43597a.mo3640b((C14980ia<? super T>) so);
        return xa;
    }
}
