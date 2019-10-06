package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.Callable;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13810v;
import p320f.p321a.C13812x;
import p320f.p321a.p326c.C13201c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;

/* renamed from: f.a.d.e.b.Na */
/* compiled from: ObservableReduceWithSingle */
public final class C13411Na<T, R> extends C13810v<R> {

    /* renamed from: a */
    final C13802r<T> f40782a;

    /* renamed from: b */
    final Callable<R> f40783b;

    /* renamed from: c */
    final C13201c<R, ? super T, R> f40784c;

    public C13411Na(C13802r<T> source, Callable<R> seedSupplier, C13201c<R, ? super T, R> reducer) {
        this.f40782a = source;
        this.f40783b = seedSupplier;
        this.f40784c = reducer;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42365b(C13812x<? super R> observer) {
        try {
            R seed = this.f40783b.call();
            C13264b.m43226a(seed, "The seedSupplier returned a null value");
            this.f40782a.subscribe(new C13407a(observer, this.f40784c, seed));
        } catch (Throwable ex) {
            C13980a.m44462b(ex);
            C13219d.m43158a(ex, observer);
        }
    }
}
