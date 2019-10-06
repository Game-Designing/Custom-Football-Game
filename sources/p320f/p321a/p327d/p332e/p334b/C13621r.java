package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.Callable;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13200b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.r */
/* compiled from: ObservableCollect */
public final class C13621r<T, U> extends C13485a<T, U> {

    /* renamed from: b */
    final Callable<? extends U> f41457b;

    /* renamed from: c */
    final C13200b<? super U, ? super T> f41458c;

    /* renamed from: f.a.d.e.b.r$a */
    /* compiled from: ObservableCollect */
    static final class C13622a<T, U> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super U> f41459a;

        /* renamed from: b */
        final C13200b<? super U, ? super T> f41460b;

        /* renamed from: c */
        final U f41461c;

        /* renamed from: d */
        C13194b f41462d;

        /* renamed from: e */
        boolean f41463e;

        C13622a(C13804t<? super U> actual, U u, C13200b<? super U, ? super T> collector) {
            this.f41459a = actual;
            this.f41460b = collector;
            this.f41461c = u;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41462d, s)) {
                this.f41462d = s;
                this.f41459a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f41462d.dispose();
        }

        public void onNext(T t) {
            if (!this.f41463e) {
                try {
                    this.f41460b.accept(this.f41461c, t);
                } catch (Throwable e) {
                    this.f41462d.dispose();
                    onError(e);
                }
            }
        }

        public void onError(Throwable t) {
            if (this.f41463e) {
                C13774a.m43836b(t);
                return;
            }
            this.f41463e = true;
            this.f41459a.onError(t);
        }

        public void onComplete() {
            if (!this.f41463e) {
                this.f41463e = true;
                this.f41459a.onNext(this.f41461c);
                this.f41459a.onComplete();
            }
        }
    }

    public C13621r(C13802r<T> source, Callable<? extends U> initialSupplier, C13200b<? super U, ? super T> collector) {
        super(source);
        this.f41457b = initialSupplier;
        this.f41458c = collector;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super U> t) {
        try {
            U u = this.f41457b.call();
            C13264b.m43226a(u, "The initialSupplier returned a null value");
            this.f41005a.subscribe(new C13622a(t, u, this.f41458c));
        } catch (Throwable e) {
            C13219d.m43157a(e, t);
        }
    }
}
