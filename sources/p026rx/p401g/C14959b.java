package p026rx.p401g;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C14972ha;
import p026rx.Single;
import p026rx.exceptions.C14927a;
import p026rx.p390c.p395e.C14868d;

/* renamed from: rx.g.b */
/* compiled from: BlockingSingle */
public final class C14959b<T> {

    /* renamed from: a */
    private final Single<? extends T> f44288a;

    private C14959b(Single<? extends T> single) {
        this.f44288a = single;
    }

    /* renamed from: a */
    public static <T> C14959b<T> m46750a(Single<? extends T> single) {
        return new C14959b<>(single);
    }

    /* renamed from: a */
    public T mo46175a() {
        AtomicReference<T> returnItem = new AtomicReference<>();
        AtomicReference<Throwable> returnException = new AtomicReference<>();
        CountDownLatch latch = new CountDownLatch(1);
        C14868d.m46584a(latch, this.f44288a.mo3691a((C14972ha<? super T>) new C14958a<Object>(this, returnItem, latch, returnException)));
        Throwable throwable = (Throwable) returnException.get();
        if (throwable == null) {
            return returnItem.get();
        }
        C14927a.m46677b(throwable);
        throw null;
    }
}
