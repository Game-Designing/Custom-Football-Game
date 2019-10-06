package p026rx.p398d;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0120S;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.p390c.p395e.C14868d;
import p026rx.p390c.p395e.C14900u;

/* renamed from: rx.d.b */
/* compiled from: BlockingObservable */
public final class C14906b<T> {

    /* renamed from: a */
    static final Object f44216a = new Object();

    /* renamed from: b */
    static final Object f44217b = new Object();

    /* renamed from: c */
    static final Object f44218c = new Object();

    /* renamed from: d */
    private final C0120S<? extends T> f44219d;

    private C14906b(C0120S<? extends T> o) {
        this.f44219d = o;
    }

    /* renamed from: a */
    public static <T> C14906b<T> m46633a(C0120S<? extends T> o) {
        return new C14906b<>(o);
    }

    /* renamed from: a */
    public T mo46110a() {
        return m46634b(this.f44219d.mo3647d());
    }

    /* renamed from: a */
    public T mo46111a(T defaultValue) {
        return m46634b(this.f44219d.mo3669j(C14900u.m46630b()).mo3632b(defaultValue));
    }

    /* renamed from: b */
    private T m46634b(C0120S<? extends T> observable) {
        AtomicReference<T> returnItem = new AtomicReference<>();
        AtomicReference<Throwable> returnException = new AtomicReference<>();
        CountDownLatch latch = new CountDownLatch(1);
        C14868d.m46584a(latch, observable.mo3627a((C14980ia<? super T>) new C14905a<Object>(this, latch, returnException, returnItem)));
        if (returnException.get() == null) {
            return returnItem.get();
        }
        C14927a.m46677b((Throwable) returnException.get());
        throw null;
    }
}
