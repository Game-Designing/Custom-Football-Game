package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.TimeUnit;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13805u;
import p320f.p321a.C13805u.C13808c;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p342f.C13770f;

/* renamed from: f.a.d.e.b.G */
/* compiled from: ObservableDelay */
public final class C13351G<T> extends C13485a<T, T> {

    /* renamed from: b */
    final long f40589b;

    /* renamed from: c */
    final TimeUnit f40590c;

    /* renamed from: d */
    final C13805u f40591d;

    /* renamed from: e */
    final boolean f40592e;

    /* renamed from: f.a.d.e.b.G$a */
    /* compiled from: ObservableDelay */
    static final class C13352a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f40593a;

        /* renamed from: b */
        final long f40594b;

        /* renamed from: c */
        final TimeUnit f40595c;

        /* renamed from: d */
        final C13808c f40596d;

        /* renamed from: e */
        final boolean f40597e;

        /* renamed from: f */
        C13194b f40598f;

        /* renamed from: f.a.d.e.b.G$a$a */
        /* compiled from: ObservableDelay */
        final class C13353a implements Runnable {
            C13353a() {
            }

            public void run() {
                try {
                    C13352a.this.f40593a.onComplete();
                } finally {
                    C13352a.this.f40596d.dispose();
                }
            }
        }

        /* renamed from: f.a.d.e.b.G$a$b */
        /* compiled from: ObservableDelay */
        final class C13354b implements Runnable {

            /* renamed from: a */
            private final Throwable f40600a;

            C13354b(Throwable throwable) {
                this.f40600a = throwable;
            }

            public void run() {
                try {
                    C13352a.this.f40593a.onError(this.f40600a);
                } finally {
                    C13352a.this.f40596d.dispose();
                }
            }
        }

        /* renamed from: f.a.d.e.b.G$a$c */
        /* compiled from: ObservableDelay */
        final class C13355c implements Runnable {

            /* renamed from: a */
            private final T f40602a;

            C13355c(T t) {
                this.f40602a = t;
            }

            public void run() {
                C13352a.this.f40593a.onNext(this.f40602a);
            }
        }

        C13352a(C13804t<? super T> actual, long delay, TimeUnit unit, C13808c w, boolean delayError) {
            this.f40593a = actual;
            this.f40594b = delay;
            this.f40595c = unit;
            this.f40596d = w;
            this.f40597e = delayError;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40598f, s)) {
                this.f40598f = s;
                this.f40593a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f40596d.mo42243a(new C13355c(t), this.f40594b, this.f40595c);
        }

        public void onError(Throwable t) {
            this.f40596d.mo42243a(new C13354b(t), this.f40597e ? this.f40594b : 0, this.f40595c);
        }

        public void onComplete() {
            this.f40596d.mo42243a(new C13353a(), this.f40594b, this.f40595c);
        }

        public void dispose() {
            this.f40598f.dispose();
            this.f40596d.dispose();
        }
    }

    public C13351G(C13802r<T> source, long delay, TimeUnit unit, C13805u scheduler, boolean delayError) {
        super(source);
        this.f40589b = delay;
        this.f40590c = unit;
        this.f40591d = scheduler;
        this.f40592e = delayError;
    }

    public void subscribeActual(C13804t<? super T> t) {
        C13804t<? super T> tVar;
        if (this.f40592e) {
            tVar = t;
        } else {
            tVar = new C13770f<>(t);
        }
        C13808c w = this.f40591d.mo42242a();
        C13802r<T> rVar = this.f41005a;
        C13352a aVar = new C13352a(tVar, this.f40589b, this.f40590c, w, this.f40592e);
        rVar.subscribe(aVar);
    }
}
