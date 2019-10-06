package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.MaybeSource;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13787i;
import p320f.p321a.C13794j;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;

/* renamed from: f.a.d.e.b.y */
/* compiled from: ObservableConcatWithMaybe */
public final class C13674y<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13794j<? extends T> f41678b;

    /* renamed from: f.a.d.e.b.y$a */
    /* compiled from: ObservableConcatWithMaybe */
    static final class C13675a<T> extends AtomicReference<C13194b> implements C13804t<T>, C13787i<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41679a;

        /* renamed from: b */
        C13794j<? extends T> f41680b;

        /* renamed from: c */
        boolean f41681c;

        C13675a(C13804t<? super T> actual, C13794j<? extends T> other) {
            this.f41679a = actual;
            this.f41680b = other;
        }

        public void onSubscribe(C13194b d) {
            if (C13218c.m43153c(this, d) && !this.f41681c) {
                this.f41679a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f41679a.onNext(t);
        }

        public void onSuccess(T t) {
            this.f41679a.onNext(t);
            this.f41679a.onComplete();
        }

        public void onError(Throwable e) {
            this.f41679a.onError(e);
        }

        public void onComplete() {
            if (this.f41681c) {
                this.f41679a.onComplete();
                return;
            }
            this.f41681c = true;
            C13218c.m43151a((AtomicReference<C13194b>) this, (C13194b) null);
            MaybeSource<? extends T> ms = this.f41680b;
            this.f41680b = null;
            ms.mo42790a(this);
        }

        public void dispose() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }
    }

    public C13674y(C13797m<T> source, C13794j<? extends T> other) {
        super(source);
        this.f41678b = other;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        this.f41005a.subscribe(new C13675a(observer, this.f41678b));
    }
}
