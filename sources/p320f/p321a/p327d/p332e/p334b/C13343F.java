package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.Callable;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;

/* renamed from: f.a.d.e.b.F */
/* compiled from: ObservableDefer */
public final class C13343F<T> extends C13797m<T> {

    /* renamed from: a */
    final Callable<? extends C13802r<? extends T>> f40563a;

    public C13343F(Callable<? extends C13802r<? extends T>> supplier) {
        this.f40563a = supplier;
    }

    public void subscribeActual(C13804t<? super T> s) {
        try {
            Object call = this.f40563a.call();
            C13264b.m43226a(call, "null ObservableSource supplied");
            ((C13802r) call).subscribe(s);
        } catch (Throwable t) {
            C13980a.m44462b(t);
            C13219d.m43157a(t, s);
        }
    }
}
