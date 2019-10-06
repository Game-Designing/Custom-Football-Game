package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier.BufferBoundaryObserver;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p331d.C13291q;
import p320f.p321a.p327d.p336f.C13703a;
import p320f.p321a.p342f.C13767c;
import p320f.p321a.p342f.C13770f;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.n */
/* compiled from: ObservableBufferBoundarySupplier */
public final class C13575n<T, U extends Collection<? super T>, B> extends C13485a<T, U> {

    /* renamed from: b */
    final Callable<? extends C13802r<B>> f41322b;

    /* renamed from: c */
    final Callable<U> f41323c;

    /* renamed from: f.a.d.e.b.n$a */
    /* compiled from: ObservableBufferBoundarySupplier */
    static final class C13576a<T, U extends Collection<? super T>, B> extends C13767c<B> {

        /* renamed from: b */
        final C13577b<T, U, B> f41324b;

        /* renamed from: c */
        boolean f41325c;

        C13576a(C13577b<T, U, B> parent) {
            this.f41324b = parent;
        }

        public void onNext(B b) {
            if (!this.f41325c) {
                this.f41325c = true;
                dispose();
                this.f41324b.mo42598e();
            }
        }

        public void onError(Throwable t) {
            if (this.f41325c) {
                C13774a.m43836b(t);
                return;
            }
            this.f41325c = true;
            this.f41324b.onError(t);
        }

        public void onComplete() {
            if (!this.f41325c) {
                this.f41325c = true;
                this.f41324b.mo42598e();
            }
        }
    }

    /* renamed from: f.a.d.e.b.n$b */
    /* compiled from: ObservableBufferBoundarySupplier */
    static final class C13577b<T, U extends Collection<? super T>, B> extends C13291q<T, U, U> implements C13804t<T>, C13194b {

        /* renamed from: g */
        final Callable<U> f41326g;

        /* renamed from: h */
        final Callable<? extends C13802r<B>> f41327h;

        /* renamed from: i */
        C13194b f41328i;

        /* renamed from: j */
        final AtomicReference<C13194b> f41329j = new AtomicReference<>();

        /* renamed from: k */
        U f41330k;

        C13577b(C13804t<? super U> actual, Callable<U> bufferSupplier, Callable<? extends C13802r<B>> boundarySupplier) {
            super(actual, new C13703a());
            this.f41326g = bufferSupplier;
            this.f41327h = boundarySupplier;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41328i, s)) {
                this.f41328i = s;
                Observer<? super U> actual = this.f40393b;
                try {
                    U call = this.f41326g.call();
                    C13264b.m43226a(call, "The buffer supplied is null");
                    this.f41330k = (Collection) call;
                    try {
                        Object call2 = this.f41327h.call();
                        C13264b.m43226a(call2, "The boundary ObservableSource supplied is null");
                        C13802r rVar = (C13802r) call2;
                        BufferBoundaryObserver<T, U, B> bs = new C13576a<>(this);
                        this.f41329j.set(bs);
                        actual.onSubscribe(this);
                        if (!this.f40395d) {
                            rVar.subscribe(bs);
                        }
                    } catch (Throwable ex) {
                        C13980a.m44462b(ex);
                        this.f40395d = true;
                        s.dispose();
                        C13219d.m43157a(ex, (C13804t<?>) actual);
                    }
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    this.f40395d = true;
                    s.dispose();
                    C13219d.m43157a(e, (C13804t<?>) actual);
                }
            }
        }

        public void onNext(T t) {
            synchronized (this) {
                U b = this.f41330k;
                if (b != null) {
                    b.add(t);
                }
            }
        }

        public void onError(Throwable t) {
            dispose();
            this.f40393b.onError(t);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            p320f.p321a.p327d.p340j.C13759r.m43798a(r4.f40394c, r4.f40393b, false, r4, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
            r4.f40394c.offer(r0);
            r4.f40396e = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (mo42347b() == false) goto L_0x0021;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r4 = this;
                monitor-enter(r4)
                U r0 = r4.f41330k     // Catch:{ all -> 0x0022 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r4)     // Catch:{ all -> 0x0022 }
                return
            L_0x0007:
                r1 = 0
                r4.f41330k = r1     // Catch:{ all -> 0x0022 }
                monitor-exit(r4)     // Catch:{ all -> 0x0022 }
                f.a.d.c.h<U> r1 = r4.f40394c
                r1.offer(r0)
                r1 = 1
                r4.f40396e = r1
                boolean r1 = r4.mo42347b()
                if (r1 == 0) goto L_0x0021
                f.a.d.c.h<U> r1 = r4.f40394c
                f.a.t<? super V> r2 = r4.f40393b
                r3 = 0
                p320f.p321a.p327d.p340j.C13759r.m43798a(r1, r2, r3, r4, r4)
            L_0x0021:
                return
            L_0x0022:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0022 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p320f.p321a.p327d.p332e.p334b.C13575n.C13577b.onComplete():void");
        }

        public void dispose() {
            if (!this.f40395d) {
                this.f40395d = true;
                this.f41328i.dispose();
                mo42597d();
                if (mo42347b()) {
                    this.f40394c.clear();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo42597d() {
            C13218c.m43150a(this.f41329j);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo42598e() {
            try {
                U call = this.f41326g.call();
                C13264b.m43226a(call, "The buffer supplied is null");
                U next = (Collection) call;
                try {
                    Object call2 = this.f41327h.call();
                    C13264b.m43226a(call2, "The boundary ObservableSource supplied is null");
                    ObservableSource<B> boundary = (C13802r) call2;
                    BufferBoundaryObserver<T, U, B> bs = new C13576a<>(this);
                    if (this.f41329j.compareAndSet((C13194b) this.f41329j.get(), bs)) {
                        synchronized (this) {
                            U b = this.f41330k;
                            if (b != null) {
                                this.f41330k = next;
                                boundary.subscribe(bs);
                                mo42344a(b, false, this);
                            }
                        }
                    }
                } catch (Throwable ex) {
                    C13980a.m44462b(ex);
                    this.f40395d = true;
                    this.f41328i.dispose();
                    this.f40393b.onError(ex);
                }
            } catch (Throwable e) {
                C13980a.m44462b(e);
                dispose();
                this.f40393b.onError(e);
            }
        }

        /* renamed from: a */
        public void mo42343a(C13804t<? super U> tVar, U v) {
            this.f40393b.onNext(v);
        }
    }

    public C13575n(C13802r<T> source, Callable<? extends C13802r<B>> boundarySupplier, Callable<U> bufferSupplier) {
        super(source);
        this.f41322b = boundarySupplier;
        this.f41323c = bufferSupplier;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super U> t) {
        this.f41005a.subscribe(new C13577b(new C13770f(t), this.f41323c, this.f41322b));
    }
}
