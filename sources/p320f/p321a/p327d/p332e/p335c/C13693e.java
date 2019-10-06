package p320f.p321a.p327d.p332e.p335c;

import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13805u;
import p320f.p321a.C13810v;
import p320f.p321a.C13812x;
import p320f.p321a.C13814z;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;

/* renamed from: f.a.d.e.c.e */
/* compiled from: SingleObserveOn */
public final class C13693e<T> extends C13810v<T> {

    /* renamed from: a */
    final C13814z<T> f41715a;

    /* renamed from: b */
    final C13805u f41716b;

    /* renamed from: f.a.d.e.c.e$a */
    /* compiled from: SingleObserveOn */
    static final class C13694a<T> extends AtomicReference<C13194b> implements C13812x<T>, C13194b, Runnable {

        /* renamed from: a */
        final C13812x<? super T> f41717a;

        /* renamed from: b */
        final C13805u f41718b;

        /* renamed from: c */
        T f41719c;

        /* renamed from: d */
        Throwable f41720d;

        C13694a(C13812x<? super T> actual, C13805u scheduler) {
            this.f41717a = actual;
            this.f41718b = scheduler;
        }

        public void onSubscribe(C13194b d) {
            if (C13218c.m43153c(this, d)) {
                this.f41717a.onSubscribe(this);
            }
        }

        public void onSuccess(T value) {
            this.f41719c = value;
            C13218c.m43151a((AtomicReference<C13194b>) this, this.f41718b.mo42721a((Runnable) this));
        }

        public void onError(Throwable e) {
            this.f41720d = e;
            C13218c.m43151a((AtomicReference<C13194b>) this, this.f41718b.mo42721a((Runnable) this));
        }

        public void run() {
            Throwable ex = this.f41720d;
            if (ex != null) {
                this.f41717a.onError(ex);
            } else {
                this.f41717a.onSuccess(this.f41719c);
            }
        }

        public void dispose() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }
    }

    public C13693e(C13814z<T> source, C13805u scheduler) {
        this.f41715a = source;
        this.f41716b = scheduler;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42365b(C13812x<? super T> s) {
        this.f41715a.mo43156a(new C13694a(s, this.f41716b));
    }
}
