package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary.WindowBoundaryInnerObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p330c.C13273h;
import p320f.p321a.p327d.p331d.C13291q;
import p320f.p321a.p327d.p336f.C13703a;
import p320f.p321a.p327d.p340j.C13753n;
import p320f.p321a.p342f.C13767c;
import p320f.p321a.p342f.C13770f;
import p320f.p321a.p343g.C13774a;
import p320f.p321a.p345i.C13792d;

/* renamed from: f.a.d.e.b.Eb */
/* compiled from: ObservableWindowBoundary */
public final class C13340Eb<T, B> extends C13485a<T, C13797m<T>> {

    /* renamed from: b */
    final C13802r<B> f40552b;

    /* renamed from: c */
    final int f40553c;

    /* renamed from: f.a.d.e.b.Eb$a */
    /* compiled from: ObservableWindowBoundary */
    static final class C13341a<T, B> extends C13767c<B> {

        /* renamed from: b */
        final C13342b<T, B> f40554b;

        /* renamed from: c */
        boolean f40555c;

        C13341a(C13342b<T, B> parent) {
            this.f40554b = parent;
        }

        public void onNext(B b) {
            if (!this.f40555c) {
                this.f40554b.mo42397e();
            }
        }

        public void onError(Throwable t) {
            if (this.f40555c) {
                C13774a.m43836b(t);
                return;
            }
            this.f40555c = true;
            this.f40554b.onError(t);
        }

        public void onComplete() {
            if (!this.f40555c) {
                this.f40555c = true;
                this.f40554b.onComplete();
            }
        }
    }

    /* renamed from: f.a.d.e.b.Eb$b */
    /* compiled from: ObservableWindowBoundary */
    static final class C13342b<T, B> extends C13291q<T, Object, C13797m<T>> implements C13194b {

        /* renamed from: g */
        static final Object f40556g = new Object();

        /* renamed from: h */
        final C13802r<B> f40557h;

        /* renamed from: i */
        final int f40558i;

        /* renamed from: j */
        C13194b f40559j;

        /* renamed from: k */
        final AtomicReference<C13194b> f40560k = new AtomicReference<>();

        /* renamed from: l */
        C13792d<T> f40561l;

        /* renamed from: m */
        final AtomicLong f40562m = new AtomicLong();

        C13342b(C13804t<? super C13797m<T>> actual, C13802r<B> other, int bufferSize) {
            super(actual, new C13703a());
            this.f40557h = other;
            this.f40558i = bufferSize;
            this.f40562m.lazySet(1);
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40559j, s)) {
                this.f40559j = s;
                Observer<? super Observable<T>> a = this.f40393b;
                a.onSubscribe(this);
                if (!this.f40395d) {
                    UnicastSubject<T> w = C13792d.m43861a(this.f40558i);
                    this.f40561l = w;
                    a.onNext(w);
                    WindowBoundaryInnerObserver<T, B> inner = new C13341a<>(this);
                    if (this.f40560k.compareAndSet(null, inner)) {
                        this.f40562m.getAndIncrement();
                        this.f40557h.subscribe(inner);
                    }
                }
            }
        }

        public void onNext(T t) {
            if (mo42348c()) {
                this.f40561l.onNext(t);
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
            mo42396d();
        }

        public void onError(Throwable t) {
            if (this.f40396e) {
                C13774a.m43836b(t);
                return;
            }
            this.f40397f = t;
            this.f40396e = true;
            if (mo42347b()) {
                mo42396d();
            }
            if (this.f40562m.decrementAndGet() == 0) {
                C13218c.m43150a(this.f40560k);
            }
            this.f40393b.onError(t);
        }

        public void onComplete() {
            if (!this.f40396e) {
                this.f40396e = true;
                if (mo42347b()) {
                    mo42396d();
                }
                if (this.f40562m.decrementAndGet() == 0) {
                    C13218c.m43150a(this.f40560k);
                }
                this.f40393b.onComplete();
            }
        }

        public void dispose() {
            this.f40395d = true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo42396d() {
            MpscLinkedQueue<Object> q = (C13703a) this.f40394c;
            Observer<? super Observable<T>> a = this.f40393b;
            int missed = 1;
            UnicastSubject<T> w = this.f40561l;
            while (true) {
                boolean d = this.f40396e;
                Object o = q.poll();
                boolean empty = o == null;
                if (d && empty) {
                    C13218c.m43150a(this.f40560k);
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
                } else if (o == f40556g) {
                    w.onComplete();
                    if (this.f40562m.decrementAndGet() == 0) {
                        C13218c.m43150a(this.f40560k);
                        return;
                    } else if (!this.f40395d) {
                        w = C13792d.m43861a(this.f40558i);
                        this.f40562m.getAndIncrement();
                        this.f40561l = w;
                        a.onNext(w);
                    }
                } else {
                    C13753n.m43780c(o);
                    w.onNext(o);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo42397e() {
            this.f40394c.offer(f40556g);
            if (mo42347b()) {
                mo42396d();
            }
        }
    }

    public C13340Eb(C13802r<T> source, C13802r<B> other, int bufferSize) {
        super(source);
        this.f40552b = other;
        this.f40553c = bufferSize;
    }

    public void subscribeActual(C13804t<? super C13797m<T>> t) {
        this.f41005a.subscribe(new C13342b(new C13770f(t), this.f40552b, this.f40553c));
    }
}
