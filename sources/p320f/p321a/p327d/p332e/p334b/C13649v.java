package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.fuseable.QueueDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13192b;
import p320f.p321a.C13198c;
import p320f.p321a.C13215d;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p330c.C13269d;
import p320f.p321a.p327d.p330c.C13274i;
import p320f.p321a.p327d.p336f.C13706c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.v */
/* compiled from: ObservableConcatMapCompletable */
public final class C13649v<T> extends C13192b {

    /* renamed from: a */
    final C13802r<T> f41581a;

    /* renamed from: b */
    final C13212n<? super T, ? extends C13215d> f41582b;

    /* renamed from: c */
    final int f41583c;

    /* renamed from: f.a.d.e.b.v$a */
    /* compiled from: ObservableConcatMapCompletable */
    static final class C13650a<T> extends AtomicInteger implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13198c f41584a;

        /* renamed from: b */
        final C13212n<? super T, ? extends C13215d> f41585b;

        /* renamed from: c */
        final C13651a f41586c;

        /* renamed from: d */
        final int f41587d;

        /* renamed from: e */
        C13274i<T> f41588e;

        /* renamed from: f */
        C13194b f41589f;

        /* renamed from: g */
        volatile boolean f41590g;

        /* renamed from: h */
        volatile boolean f41591h;

        /* renamed from: i */
        volatile boolean f41592i;

        /* renamed from: j */
        int f41593j;

        /* renamed from: f.a.d.e.b.v$a$a */
        /* compiled from: ObservableConcatMapCompletable */
        static final class C13651a extends AtomicReference<C13194b> implements C13198c {

            /* renamed from: a */
            final C13198c f41594a;

            /* renamed from: b */
            final C13650a<?> f41595b;

            C13651a(C13198c actual, C13650a<?> parent) {
                this.f41594a = actual;
                this.f41595b = parent;
            }

            public void onSubscribe(C13194b s) {
                C13218c.m43152b(this, s);
            }

            public void onError(Throwable t) {
                this.f41595b.dispose();
                this.f41594a.onError(t);
            }

            public void onComplete() {
                this.f41595b.mo42649b();
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public void mo42650a() {
                C13218c.m43150a((AtomicReference<C13194b>) this);
            }
        }

        C13650a(C13198c actual, C13212n<? super T, ? extends C13215d> mapper, int bufferSize) {
            this.f41584a = actual;
            this.f41585b = mapper;
            this.f41587d = bufferSize;
            this.f41586c = new C13651a(actual, this);
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41589f, s)) {
                this.f41589f = s;
                if (s instanceof C13269d) {
                    QueueDisposable<T> qd = (C13269d) s;
                    int m = qd.mo42274a(3);
                    if (m == 1) {
                        this.f41593j = m;
                        this.f41588e = qd;
                        this.f41592i = true;
                        this.f41584a.onSubscribe(this);
                        mo42648a();
                        return;
                    } else if (m == 2) {
                        this.f41593j = m;
                        this.f41588e = qd;
                        this.f41584a.onSubscribe(this);
                        return;
                    }
                }
                this.f41588e = new C13706c(this.f41587d);
                this.f41584a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.f41592i) {
                if (this.f41593j == 0) {
                    this.f41588e.offer(t);
                }
                mo42648a();
            }
        }

        public void onError(Throwable t) {
            if (this.f41592i) {
                C13774a.m43836b(t);
                return;
            }
            this.f41592i = true;
            dispose();
            this.f41584a.onError(t);
        }

        public void onComplete() {
            if (!this.f41592i) {
                this.f41592i = true;
                mo42648a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42649b() {
            this.f41590g = false;
            mo42648a();
        }

        public void dispose() {
            this.f41591h = true;
            this.f41586c.mo42650a();
            this.f41589f.dispose();
            if (getAndIncrement() == 0) {
                this.f41588e.clear();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42648a() {
            if (getAndIncrement() == 0) {
                while (!this.f41591h) {
                    if (!this.f41590g) {
                        boolean d = this.f41592i;
                        try {
                            T t = this.f41588e.poll();
                            boolean empty = t == null;
                            if (d && empty) {
                                this.f41591h = true;
                                this.f41584a.onComplete();
                                return;
                            } else if (!empty) {
                                try {
                                    Object apply = this.f41585b.apply(t);
                                    C13264b.m43226a(apply, "The mapper returned a null CompletableSource");
                                    C13215d c = (C13215d) apply;
                                    this.f41590g = true;
                                    c.mo42246a(this.f41586c);
                                } catch (Throwable ex) {
                                    C13980a.m44462b(ex);
                                    dispose();
                                    this.f41588e.clear();
                                    this.f41584a.onError(ex);
                                    return;
                                }
                            }
                        } catch (Throwable ex2) {
                            C13980a.m44462b(ex2);
                            dispose();
                            this.f41588e.clear();
                            this.f41584a.onError(ex2);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.f41588e.clear();
            }
        }
    }

    public C13649v(C13802r<T> source, C13212n<? super T, ? extends C13215d> mapper, int bufferSize) {
        this.f41581a = source;
        this.f41582b = mapper;
        this.f41583c = Math.max(8, bufferSize);
    }

    /* renamed from: b */
    public void mo42247b(C13198c observer) {
        this.f41581a.subscribe(new C13650a(observer, this.f41582b, this.f41583c));
    }
}
