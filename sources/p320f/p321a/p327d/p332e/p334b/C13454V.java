package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.Callable;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;

/* renamed from: f.a.d.e.b.V */
/* compiled from: ObservableError */
public final class C13454V<T> extends C13797m<T> {

    /* renamed from: a */
    final Callable<? extends Throwable> f40907a;

    public C13454V(Callable<? extends Throwable> errorSupplier) {
        this.f40907a = errorSupplier;
    }

    public void subscribeActual(C13804t<? super T> s) {
        try {
            Object call = this.f40907a.call();
            C13264b.m43226a(call, "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
            t = (Throwable) call;
        } catch (Throwable th) {
            t = th;
            C13980a.m44462b(t);
        }
        C13219d.m43157a(t, s);
    }
}
