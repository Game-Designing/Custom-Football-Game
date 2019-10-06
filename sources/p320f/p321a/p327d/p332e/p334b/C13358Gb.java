package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier.WindowBoundaryInnerObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p330c.C13273h;
import p320f.p321a.p327d.p331d.C13291q;
import p320f.p321a.p327d.p336f.C13703a;
import p320f.p321a.p327d.p340j.C13753n;
import p320f.p321a.p342f.C13767c;
import p320f.p321a.p342f.C13770f;
import p320f.p321a.p343g.C13774a;
import p320f.p321a.p345i.C13792d;

/* renamed from: f.a.d.e.b.Gb */
/* compiled from: ObservableWindowBoundarySupplier */
public final class C13358Gb<T, B> extends C13485a<T, C13797m<T>> {

    /* renamed from: b */
    final Callable<? extends C13802r<B>> f40608b;

    /* renamed from: c */
    final int f40609c;

    /* renamed from: f.a.d.e.b.Gb$a */
    /* compiled from: ObservableWindowBoundarySupplier */
    static final class C13359a<T, B> extends C13767c<B> {

        /* renamed from: b */
        final C13360b<T, B> f40610b;

        /* renamed from: c */
        boolean f40611c;

        C13359a(C13360b<T, B> parent) {
            this.f40610b = parent;
        }

        public void onNext(B b) {
            if (!this.f40611c) {
                this.f40611c = true;
                dispose();
                this.f40610b.mo42407e();
            }
        }

        public void onError(Throwable t) {
            if (this.f40611c) {
                C13774a.m43836b(t);
                return;
            }
            this.f40611c = true;
            this.f40610b.onError(t);
        }

        public void onComplete() {
            if (!this.f40611c) {
                this.f40611c = true;
                this.f40610b.onComplete();
            }
        }
    }

    /* renamed from: f.a.d.e.b.Gb$b */
    /* compiled from: ObservableWindowBoundarySupplier */
    static final class C13360b<T, B> extends C13291q<T, Object, C13797m<T>> implements C13194b {

        /* renamed from: g */
        static final Object f40612g = new Object();

        /* renamed from: h */
        final Callable<? extends C13802r<B>> f40613h;

        /* renamed from: i */
        final int f40614i;

        /* renamed from: j */
        C13194b f40615j;

        /* renamed from: k */
        final AtomicReference<C13194b> f40616k = new AtomicReference<>();

        /* renamed from: l */
        C13792d<T> f40617l;

        /* renamed from: m */
        final AtomicLong f40618m = new AtomicLong();

        C13360b(C13804t<? super C13797m<T>> actual, Callable<? extends C13802r<B>> other, int bufferSize) {
            super(actual, new C13703a());
            this.f40613h = other;
            this.f40614i = bufferSize;
            this.f40618m.lazySet(1);
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40615j, s)) {
                this.f40615j = s;
                Observer<? super Observable<T>> a = this.f40393b;
                a.onSubscribe(this);
                if (!this.f40395d) {
                    try {
                        Object call = this.f40613h.call();
                        C13264b.m43226a(call, "The first window ObservableSource supplied is null");
                        ObservableSource<B> p = (C13802r) call;
                        UnicastSubject<T> w = C13792d.m43861a(this.f40614i);
                        this.f40617l = w;
                        a.onNext(w);
                        WindowBoundaryInnerObserver<T, B> inner = new C13359a<>(this);
                        if (this.f40616k.compareAndSet(null, inner)) {
                            this.f40618m.getAndIncrement();
                            p.subscribe(inner);
                        }
                    } catch (Throwable e) {
                        C13980a.m44462b(e);
                        s.dispose();
                        a.onError(e);
                    }
                }
            }
        }

        public void onNext(T t) {
            if (mo42348c()) {
                this.f40617l.onNext(t);
                if (mo42342a(-1) == 0) {
                    return;
                }
            } else {
                C13273h<U> hVar = this.f40394c;
                C13753n.m43785g(t);
                hVar.offer(t);
                if (!mo42347b()) {
                    return;
                }
            }
            mo42406d();
        }

        public void onError(Throwable t) {
            if (this.f40396e) {
                C13774a.m43836b(t);
                return;
            }
            this.f40397f = t;
            this.f40396e = true;
            if (mo42347b()) {
                mo42406d();
            }
            if (this.f40618m.decrementAndGet() == 0) {
                C13218c.m43150a(this.f40616k);
            }
            this.f40393b.onError(t);
        }

        public void onComplete() {
            if (!this.f40396e) {
                this.f40396e = true;
                if (mo42347b()) {
                    mo42406d();
                }
                if (this.f40618m.decrementAndGet() == 0) {
                    C13218c.m43150a(this.f40616k);
                }
                this.f40393b.onComplete();
            }
        }

        public void dispose() {
            this.f40395d = true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo42406d() {
            MpscLinkedQueue<Object> q = (C13703a) this.f40394c;
            Observer<? super Observable<T>> a = this.f40393b;
            int missed = 1;
            UnicastSubject<T> w = this.f40617l;
            while (true) {
                boolean d = this.f40396e;
                Object o = q.poll();
                boolean empty = o == null;
                if (d && empty) {
                    C13218c.m43150a(this.f40616k);
                    Throwable e = this.f40397f;
                    if (e != null) {
                        w.onError(e);
                    } else {
                        w.onComplete();
                    }
                    return;
                } else if (empty) {
                    missed = mo42342a(-missed);
                    if (missed == 0) {
                        return;
                    }
                } else if (o == f40612g) {
                    w.onComplete();
                    if (this.f40618m.decrementAndGet() == 0) {
                        C13218c.m43150a(this.f40616k);
                        return;
                    } else if (!this.f40395d) {
                        try {
                            Object call = this.f40613h.call();
                            C13264b.m43226a(call, "The ObservableSource supplied is null");
                            ObservableSource<B> p = (C13802r) call;
                            w = C13792d.m43861a(this.f40614i);
                            this.f40618m.getAndIncrement();
                            this.f40617l = w;
                            a.onNext(w);
                            WindowBoundaryInnerObserver<T, B> b = new C13359a<>(this);
                            AtomicReference<C13194b> atomicReference = this.f40616k;
                            if (atomicReference.compareAndSet(atomicReference.get(), b)) {
                                p.subscribe(b);
                            }
                        } catch (Throwable e2) {
                            C13980a.m44462b(e2);
                            C13218c.m43150a(this.f40616k);
                            a.onError(e2);
                            return;
                        }
                    }
                } else {
                    C13753n.m43780c(o);
                    w.onNext(o);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo42407e() {
            this.f40394c.offer(f40612g);
            if (mo42347b()) {
                mo42406d();
            }
        }
    }

    public C13358Gb(C13802r<T> source, Callable<? extends C13802r<B>> other, int bufferSize) {
        super(source);
        this.f40608b = other;
        this.f40609c = bufferSize;
    }

    public void subscribeActual(C13804t<? super C13797m<T>> t) {
        this.f41005a.subscribe(new C13360b(new C13770f(t), this.f40608b, this.f40609c));
    }
}
