package p320f.p321a;

import io.reactivex.MaybeObserver;
import io.reactivex.internal.observers.BlockingMultiObserver;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p331d.C13281g;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.h */
/* compiled from: Maybe */
public abstract class C13775h<T> implements C13794j<T> {
    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo42443b(C13787i<? super T> iVar);

    /* renamed from: b */
    public final T mo42791b() {
        BlockingMultiObserver<T> observer = new C13281g<>();
        mo42790a(observer);
        return observer.mo42323a();
    }

    /* renamed from: a */
    public final void mo42790a(C13787i<? super T> observer) {
        C13264b.m43226a(observer, "observer is null");
        MaybeObserver<? super T> observer2 = C13774a.m43820a(this, observer);
        C13264b.m43226a(observer2, "observer returned by the RxJavaPlugins hook is null");
        try {
            mo42443b(observer2);
        } catch (NullPointerException ex) {
            throw ex;
        } catch (Throwable ex2) {
            C13980a.m44462b(ex2);
            NullPointerException npe = new NullPointerException("subscribeActual failed");
            npe.initCause(ex2);
            throw npe;
        }
    }
}
