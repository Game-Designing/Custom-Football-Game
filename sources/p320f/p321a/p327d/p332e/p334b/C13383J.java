package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observer;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p340j.C13745g;

/* renamed from: f.a.d.e.b.J */
/* compiled from: ObservableDetach */
public final class C13383J<T> extends C13485a<T, T> {

    /* renamed from: f.a.d.e.b.J$a */
    /* compiled from: ObservableDetach */
    static final class C13384a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        C13804t<? super T> f40696a;

        /* renamed from: b */
        C13194b f40697b;

        C13384a(C13804t<? super T> actual) {
            this.f40696a = actual;
        }

        public void dispose() {
            C13194b s = this.f40697b;
            this.f40697b = C13745g.INSTANCE;
            this.f40696a = C13745g.m43755e();
            s.dispose();
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40697b, s)) {
                this.f40697b = s;
                this.f40696a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f40696a.onNext(t);
        }

        public void onError(Throwable t) {
            Observer<? super T> a = this.f40696a;
            this.f40697b = C13745g.INSTANCE;
            this.f40696a = C13745g.m43755e();
            a.onError(t);
        }

        public void onComplete() {
            Observer<? super T> a = this.f40696a;
            this.f40697b = C13745g.INSTANCE;
            this.f40696a = C13745g.m43755e();
            a.onComplete();
        }
    }

    public C13383J(C13802r<T> source) {
        super(source);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> s) {
        this.f41005a.subscribe(new C13384a(s));
    }
}
