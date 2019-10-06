package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observer;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13801q;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.wa */
/* compiled from: ObservableLift */
public final class C13658wa<R, T> extends C13485a<T, R> {

    /* renamed from: b */
    final C13801q<? extends R, ? super T> f41627b;

    public C13658wa(C13802r<T> source, C13801q<? extends R, ? super T> operator) {
        super(source);
        this.f41627b = operator;
    }

    public void subscribeActual(C13804t<? super R> s) {
        try {
            Observer<? super T> a = this.f41627b.mo43145a(s);
            StringBuilder sb = new StringBuilder();
            sb.append("Operator ");
            sb.append(this.f41627b);
            sb.append(" returned a null Observer");
            C13264b.m43226a(a, sb.toString());
            this.f41005a.subscribe((C13804t) a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable e2) {
            C13980a.m44462b(e2);
            C13774a.m43836b(e2);
            NullPointerException npe = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            npe.initCause(e2);
            throw npe;
        }
    }
}
