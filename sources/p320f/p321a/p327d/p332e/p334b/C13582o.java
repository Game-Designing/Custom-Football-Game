package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableBufferExactBoundary.BufferBoundaryObserver;
import java.util.Collection;
import java.util.concurrent.Callable;
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

/* renamed from: f.a.d.e.b.o */
/* compiled from: ObservableBufferExactBoundary */
public final class C13582o<T, U extends Collection<? super T>, B> extends C13485a<T, U> {

    /* renamed from: b */
    final C13802r<B> f41338b;

    /* renamed from: c */
    final Callable<U> f41339c;

    /* renamed from: f.a.d.e.b.o$a */
    /* compiled from: ObservableBufferExactBoundary */
    static final class C13583a<T, U extends Collection<? super T>, B> extends C13767c<B> {

        /* renamed from: b */
        final C13584b<T, U, B> f41340b;

        C13583a(C13584b<T, U, B> parent) {
            this.f41340b = parent;
        }

        public void onNext(B b) {
            this.f41340b.mo42600d();
        }

        public void onError(Throwable t) {
            this.f41340b.onError(t);
        }

        public void onComplete() {
            this.f41340b.onComplete();
        }
    }

    /* renamed from: f.a.d.e.b.o$b */
    /* compiled from: ObservableBufferExactBoundary */
    static final class C13584b<T, U extends Collection<? super T>, B> extends C13291q<T, U, U> implements C13804t<T>, C13194b {

        /* renamed from: g */
        final Callable<U> f41341g;

        /* renamed from: h */
        final C13802r<B> f41342h;

        /* renamed from: i */
        C13194b f41343i;

        /* renamed from: j */
        C13194b f41344j;

        /* renamed from: k */
        U f41345k;

        C13584b(C13804t<? super U> actual, Callable<U> bufferSupplier, C13802r<B> boundary) {
            super(actual, new C13703a());
            this.f41341g = bufferSupplier;
            this.f41342h = boundary;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41343i, s)) {
                this.f41343i = s;
                try {
                    U call = this.f41341g.call();
                    C13264b.m43226a(call, "The buffer supplied is null");
                    this.f41345k = (Collection) call;
                    BufferBoundaryObserver<T, U, B> bs = new C13583a<>(this);
                    this.f41344j = bs;
                    this.f40393b.onSubscribe(this);
                    if (!this.f40395d) {
                        this.f41342h.subscribe(bs);
                    }
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    this.f40395d = true;
                    s.dispose();
                    C13219d.m43157a(e, this.f40393b);
                }
            }
        }

        public void onNext(T t) {
            synchronized (this) {
                U b = this.f41345k;
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
                U r0 = r4.f41345k     // Catch:{ all -> 0x0022 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r4)     // Catch:{ all -> 0x0022 }
                return
            L_0x0007:
                r1 = 0
                r4.f41345k = r1     // Catch:{ all -> 0x0022 }
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
            throw new UnsupportedOperationException("Method not decompiled: p320f.p321a.p327d.p332e.p334b.C13582o.C13584b.onComplete():void");
        }

        public void dispose() {
            if (!this.f40395d) {
                this.f40395d = true;
                this.f41344j.dispose();
                this.f41343i.dispose();
                if (mo42347b()) {
                    this.f40394c.clear();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo42600d() {
            try {
                U call = this.f41341g.call();
                C13264b.m43226a(call, "The buffer supplied is null");
                U next = (Collection) call;
                synchronized (this) {
                    U b = this.f41345k;
                    if (b != null) {
                        this.f41345k = next;
                        mo42344a(b, false, this);
                    }
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

    public C13582o(C13802r<T> source, C13802r<B> boundary, Callable<U> bufferSupplier) {
        super(source);
        this.f41338b = boundary;
        this.f41339c = bufferSupplier;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super U> t) {
        this.f41005a.subscribe(new C13584b(new C13770f(t), this.f41339c, this.f41338b));
    }
}
