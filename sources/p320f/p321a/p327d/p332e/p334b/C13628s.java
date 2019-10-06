package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.Callable;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13810v;
import p320f.p321a.C13812x;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13200b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p330c.C13266a;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.s */
/* compiled from: ObservableCollectSingle */
public final class C13628s<T, U> extends C13810v<U> implements C13266a<U> {

    /* renamed from: a */
    final C13802r<T> f41480a;

    /* renamed from: b */
    final Callable<? extends U> f41481b;

    /* renamed from: c */
    final C13200b<? super U, ? super T> f41482c;

    /* renamed from: f.a.d.e.b.s$a */
    /* compiled from: ObservableCollectSingle */
    static final class C13629a<T, U> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13812x<? super U> f41483a;

        /* renamed from: b */
        final C13200b<? super U, ? super T> f41484b;

        /* renamed from: c */
        final U f41485c;

        /* renamed from: d */
        C13194b f41486d;

        /* renamed from: e */
        boolean f41487e;

        C13629a(C13812x<? super U> actual, U u, C13200b<? super U, ? super T> collector) {
            this.f41483a = actual;
            this.f41484b = collector;
            this.f41485c = u;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41486d, s)) {
                this.f41486d = s;
                this.f41483a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f41486d.dispose();
        }

        public void onNext(T t) {
            if (!this.f41487e) {
                try {
                    this.f41484b.accept(this.f41485c, t);
                } catch (Throwable e) {
                    this.f41486d.dispose();
                    onError(e);
                }
            }
        }

        public void onError(Throwable t) {
            if (this.f41487e) {
                C13774a.m43836b(t);
                return;
            }
            this.f41487e = true;
            this.f41483a.onError(t);
        }

        public void onComplete() {
            if (!this.f41487e) {
                this.f41487e = true;
                this.f41483a.onSuccess(this.f41485c);
            }
        }
    }

    public C13628s(C13802r<T> source, Callable<? extends U> initialSupplier, C13200b<? super U, ? super T> collector) {
        this.f41480a = source;
        this.f41481b = initialSupplier;
        this.f41482c = collector;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42365b(C13812x<? super U> t) {
        try {
            U u = this.f41481b.call();
            C13264b.m43226a(u, "The initialSupplier returned a null value");
            this.f41480a.subscribe(new C13629a(t, u, this.f41482c));
        } catch (Throwable e) {
            C13219d.m43158a(e, t);
        }
    }

    /* renamed from: a */
    public C13797m<U> mo42316a() {
        return C13774a.m43821a((C13797m<T>) new C13621r<T>(this.f41480a, this.f41481b, this.f41482c));
    }
}
