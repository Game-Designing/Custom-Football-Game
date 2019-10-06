package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector.OperatorWindowBoundaryCloseObserver;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector.OperatorWindowBoundaryOpenObserver;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector.WindowOperation;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13193a;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
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

/* renamed from: f.a.d.e.b.Fb */
/* compiled from: ObservableWindowBoundarySelector */
public final class C13346Fb<T, B, V> extends C13485a<T, C13797m<T>> {

    /* renamed from: b */
    final C13802r<B> f40572b;

    /* renamed from: c */
    final C13212n<? super B, ? extends C13802r<V>> f40573c;

    /* renamed from: d */
    final int f40574d;

    /* renamed from: f.a.d.e.b.Fb$a */
    /* compiled from: ObservableWindowBoundarySelector */
    static final class C13347a<T, V> extends C13767c<V> {

        /* renamed from: b */
        final C13349c<T, ?, V> f40575b;

        /* renamed from: c */
        final C13792d<T> f40576c;

        /* renamed from: d */
        boolean f40577d;

        C13347a(C13349c<T, ?, V> parent, C13792d<T> w) {
            this.f40575b = parent;
            this.f40576c = w;
        }

        public void onNext(V v) {
            if (!this.f40577d) {
                this.f40577d = true;
                dispose();
                this.f40575b.mo42398a(this);
            }
        }

        public void onError(Throwable t) {
            if (this.f40577d) {
                C13774a.m43836b(t);
                return;
            }
            this.f40577d = true;
            this.f40575b.mo42400a(t);
        }

        public void onComplete() {
            if (!this.f40577d) {
                this.f40577d = true;
                this.f40575b.mo42398a(this);
            }
        }
    }

    /* renamed from: f.a.d.e.b.Fb$b */
    /* compiled from: ObservableWindowBoundarySelector */
    static final class C13348b<T, B> extends C13767c<B> {

        /* renamed from: b */
        final C13349c<T, B, ?> f40578b;

        C13348b(C13349c<T, B, ?> parent) {
            this.f40578b = parent;
        }

        public void onNext(B t) {
            this.f40578b.mo42399a(t);
        }

        public void onError(Throwable t) {
            this.f40578b.mo42400a(t);
        }

        public void onComplete() {
            this.f40578b.onComplete();
        }
    }

    /* renamed from: f.a.d.e.b.Fb$c */
    /* compiled from: ObservableWindowBoundarySelector */
    static final class C13349c<T, B, V> extends C13291q<T, Object, C13797m<T>> implements C13194b {

        /* renamed from: g */
        final C13802r<B> f40579g;

        /* renamed from: h */
        final C13212n<? super B, ? extends C13802r<V>> f40580h;

        /* renamed from: i */
        final int f40581i;

        /* renamed from: j */
        final C13193a f40582j;

        /* renamed from: k */
        C13194b f40583k;

        /* renamed from: l */
        final AtomicReference<C13194b> f40584l = new AtomicReference<>();

        /* renamed from: m */
        final List<C13792d<T>> f40585m;

        /* renamed from: n */
        final AtomicLong f40586n = new AtomicLong();

        C13349c(C13804t<? super C13797m<T>> actual, C13802r<B> open, C13212n<? super B, ? extends C13802r<V>> close, int bufferSize) {
            super(actual, new C13703a());
            this.f40579g = open;
            this.f40580h = close;
            this.f40581i = bufferSize;
            this.f40582j = new C13193a();
            this.f40585m = new ArrayList();
            this.f40586n.lazySet(1);
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40583k, s)) {
                this.f40583k = s;
                this.f40393b.onSubscribe(this);
                if (!this.f40395d) {
                    OperatorWindowBoundaryOpenObserver<T, B> os = new C13348b<>(this);
                    if (this.f40584l.compareAndSet(null, os)) {
                        this.f40586n.getAndIncrement();
                        this.f40579g.subscribe(os);
                    }
                }
            }
        }

        public void onNext(T t) {
            if (mo42348c()) {
                Iterator it = this.f40585m.iterator();
                while (it.hasNext()) {
                    ((C13792d) it.next()).onNext(t);
                }
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
            mo42402e();
        }

        public void onError(Throwable t) {
            if (this.f40396e) {
                C13774a.m43836b(t);
                return;
            }
            this.f40397f = t;
            this.f40396e = true;
            if (mo42347b()) {
                mo42402e();
            }
            if (this.f40586n.decrementAndGet() == 0) {
                this.f40582j.dispose();
            }
            this.f40393b.onError(t);
        }

        public void onComplete() {
            if (!this.f40396e) {
                this.f40396e = true;
                if (mo42347b()) {
                    mo42402e();
                }
                if (this.f40586n.decrementAndGet() == 0) {
                    this.f40582j.dispose();
                }
                this.f40393b.onComplete();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42400a(Throwable t) {
            this.f40583k.dispose();
            this.f40582j.dispose();
            onError(t);
        }

        public void dispose() {
            this.f40395d = true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo42401d() {
            this.f40582j.dispose();
            C13218c.m43150a(this.f40584l);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo42402e() {
            MpscLinkedQueue<Object> q = (C13703a) this.f40394c;
            Observer<? super Observable<T>> a = this.f40393b;
            List<C13792d<T>> list = this.f40585m;
            int missed = 1;
            while (true) {
                boolean d = this.f40396e;
                Object o = q.poll();
                boolean empty = o == null;
                if (d && empty) {
                    mo42401d();
                    Throwable e = this.f40397f;
                    if (e != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((C13792d) it.next()).onError(e);
                        }
                    } else {
                        Iterator it2 = list.iterator();
                        while (it2.hasNext()) {
                            ((C13792d) it2.next()).onComplete();
                        }
                    }
                    list.clear();
                    return;
                } else if (empty) {
                    missed = mo42342a(-missed);
                    if (missed == 0) {
                        return;
                    }
                } else if (o instanceof C13350d) {
                    WindowOperation<T, B> wo = (C13350d) o;
                    if (wo.f40587a != null) {
                        if (list.remove(wo.f40587a)) {
                            wo.f40587a.onComplete();
                            if (this.f40586n.decrementAndGet() == 0) {
                                mo42401d();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.f40395d) {
                        UnicastSubject<T> w = C13792d.m43861a(this.f40581i);
                        list.add(w);
                        a.onNext(w);
                        try {
                            Object apply = this.f40580h.apply(wo.f40588b);
                            C13264b.m43226a(apply, "The ObservableSource supplied is null");
                            C13802r rVar = (C13802r) apply;
                            OperatorWindowBoundaryCloseObserver<T, V> cl = new C13347a<>(this, w);
                            if (this.f40582j.mo42252b(cl)) {
                                this.f40586n.getAndIncrement();
                                rVar.subscribe(cl);
                            }
                        } catch (Throwable e2) {
                            C13980a.m44462b(e2);
                            this.f40395d = true;
                            a.onError(e2);
                        }
                    }
                } else {
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        UnicastSubject<T> w2 = (C13792d) it3.next();
                        C13753n.m43780c(o);
                        w2.onNext(o);
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo42343a(C13804t<? super C13797m<T>> tVar, Object v) {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42399a(B b) {
            this.f40394c.offer(new C13350d(null, b));
            if (mo42347b()) {
                mo42402e();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42398a(C13347a<T, V> w) {
            this.f40582j.mo42253c(w);
            this.f40394c.offer(new C13350d(w.f40576c, null));
            if (mo42347b()) {
                mo42402e();
            }
        }
    }

    /* renamed from: f.a.d.e.b.Fb$d */
    /* compiled from: ObservableWindowBoundarySelector */
    static final class C13350d<T, B> {

        /* renamed from: a */
        final C13792d<T> f40587a;

        /* renamed from: b */
        final B f40588b;

        C13350d(C13792d<T> w, B open) {
            this.f40587a = w;
            this.f40588b = open;
        }
    }

    public C13346Fb(C13802r<T> source, C13802r<B> open, C13212n<? super B, ? extends C13802r<V>> close, int bufferSize) {
        super(source);
        this.f40572b = open;
        this.f40573c = close;
        this.f40574d = bufferSize;
    }

    public void subscribeActual(C13804t<? super C13797m<T>> t) {
        this.f41005a.subscribe(new C13349c(new C13770f(t), this.f40572b, this.f40573c, this.f40574d));
    }
}
