package p320f.p321a.p327d.p332e.p335c;

import io.reactivex.internal.operators.single.SingleSubscribeOn.SubscribeOnObserver;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13805u;
import p320f.p321a.C13810v;
import p320f.p321a.C13812x;
import p320f.p321a.C13814z;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13225j;

/* renamed from: f.a.d.e.c.f */
/* compiled from: SingleSubscribeOn */
public final class C13695f<T> extends C13810v<T> {

    /* renamed from: a */
    final C13814z<? extends T> f41721a;

    /* renamed from: b */
    final C13805u f41722b;

    /* renamed from: f.a.d.e.c.f$a */
    /* compiled from: SingleSubscribeOn */
    static final class C13696a<T> extends AtomicReference<C13194b> implements C13812x<T>, C13194b, Runnable {

        /* renamed from: a */
        final C13812x<? super T> f41723a;

        /* renamed from: b */
        final C13225j f41724b = new C13225j();

        /* renamed from: c */
        final C13814z<? extends T> f41725c;

        C13696a(C13812x<? super T> actual, C13814z<? extends T> source) {
            this.f41723a = actual;
            this.f41725c = source;
        }

        public void onSubscribe(C13194b d) {
            C13218c.m43153c(this, d);
        }

        public void onSuccess(T value) {
            this.f41723a.onSuccess(value);
        }

        public void onError(Throwable e) {
            this.f41723a.onError(e);
        }

        public void dispose() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
            this.f41724b.dispose();
        }

        public void run() {
            this.f41725c.mo43156a(this);
        }
    }

    public C13695f(C13814z<? extends T> source, C13805u scheduler) {
        this.f41721a = source;
        this.f41722b = scheduler;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42365b(C13812x<? super T> s) {
        SubscribeOnObserver<T> parent = new C13696a<>(s, this.f41721a);
        s.onSubscribe(parent);
        parent.f41724b.mo42287a(this.f41722b.mo42721a((Runnable) parent));
    }
}
