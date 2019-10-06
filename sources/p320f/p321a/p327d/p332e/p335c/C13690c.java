package p320f.p321a.p327d.p332e.p335c;

import java.util.concurrent.Callable;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13810v;
import p320f.p321a.C13812x;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;

/* renamed from: f.a.d.e.c.c */
/* compiled from: SingleError */
public final class C13690c<T> extends C13810v<T> {

    /* renamed from: a */
    final Callable<? extends Throwable> f41710a;

    public C13690c(Callable<? extends Throwable> errorSupplier) {
        this.f41710a = errorSupplier;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42365b(C13812x<? super T> s) {
        try {
            Object call = this.f41710a.call();
            C13264b.m43226a(call, "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
            e = (Throwable) call;
        } catch (Throwable th) {
            e = th;
            C13980a.m44462b(e);
        }
        C13219d.m43158a(e, s);
    }
}
