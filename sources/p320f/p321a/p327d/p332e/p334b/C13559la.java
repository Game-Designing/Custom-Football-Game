package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableGroupJoin.GroupJoinDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13193a;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13201c;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p336f.C13706c;
import p320f.p321a.p327d.p340j.C13748j;
import p320f.p321a.p343g.C13774a;
import p320f.p321a.p345i.C13792d;

/* renamed from: f.a.d.e.b.la */
/* compiled from: ObservableGroupJoin */
public final class C13559la<TLeft, TRight, TLeftEnd, TRightEnd, R> extends C13485a<TLeft, R> {

    /* renamed from: b */
    final C13802r<? extends TRight> f41253b;

    /* renamed from: c */
    final C13212n<? super TLeft, ? extends C13802r<TLeftEnd>> f41254c;

    /* renamed from: d */
    final C13212n<? super TRight, ? extends C13802r<TRightEnd>> f41255d;

    /* renamed from: e */
    final C13201c<? super TLeft, ? super C13797m<TRight>, ? extends R> f41256e;

    /* renamed from: f.a.d.e.b.la$a */
    /* compiled from: ObservableGroupJoin */
    static final class C13560a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements C13194b, C13561b {

        /* renamed from: a */
        static final Integer f41257a = Integer.valueOf(1);

        /* renamed from: b */
        static final Integer f41258b = Integer.valueOf(2);

        /* renamed from: c */
        static final Integer f41259c = Integer.valueOf(3);

        /* renamed from: d */
        static final Integer f41260d = Integer.valueOf(4);

        /* renamed from: e */
        final C13804t<? super R> f41261e;

        /* renamed from: f */
        final C13706c<Object> f41262f = new C13706c<>(C13797m.bufferSize());

        /* renamed from: g */
        final C13193a f41263g = new C13193a();

        /* renamed from: h */
        final Map<Integer, C13792d<TRight>> f41264h = new LinkedHashMap();

        /* renamed from: i */
        final Map<Integer, TRight> f41265i = new LinkedHashMap();

        /* renamed from: j */
        final AtomicReference<Throwable> f41266j = new AtomicReference<>();

        /* renamed from: k */
        final C13212n<? super TLeft, ? extends C13802r<TLeftEnd>> f41267k;

        /* renamed from: l */
        final C13212n<? super TRight, ? extends C13802r<TRightEnd>> f41268l;

        /* renamed from: m */
        final C13201c<? super TLeft, ? super C13797m<TRight>, ? extends R> f41269m;

        /* renamed from: n */
        final AtomicInteger f41270n;

        /* renamed from: o */
        int f41271o;

        /* renamed from: p */
        int f41272p;

        /* renamed from: q */
        volatile boolean f41273q;

        C13560a(C13804t<? super R> actual, C13212n<? super TLeft, ? extends C13802r<TLeftEnd>> leftEnd, C13212n<? super TRight, ? extends C13802r<TRightEnd>> rightEnd, C13201c<? super TLeft, ? super C13797m<TRight>, ? extends R> resultSelector) {
            this.f41261e = actual;
            this.f41267k = leftEnd;
            this.f41268l = rightEnd;
            this.f41269m = resultSelector;
            this.f41270n = new AtomicInteger(2);
        }

        public void dispose() {
            if (!this.f41273q) {
                this.f41273q = true;
                mo42578a();
                if (getAndIncrement() == 0) {
                    this.f41262f.clear();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42578a() {
            this.f41263g.dispose();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42580a(C13804t<?> a) {
            Throwable ex = C13748j.m43762a(this.f41266j);
            for (UnicastSubject<TRight> up : this.f41264h.values()) {
                up.onError(ex);
            }
            this.f41264h.clear();
            this.f41265i.clear();
            a.onError(ex);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42582a(Throwable exc, C13804t<?> a, C13706c<?> q) {
            C13980a.m44462b(exc);
            C13748j.m43763a(this.f41266j, exc);
            q.clear();
            mo42578a();
            mo42580a(a);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42585b() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> q = this.f41262f;
                Observer<? super R> a = this.f41261e;
                int missed = 1;
                while (this.f41273q == 0) {
                    if (((Throwable) this.f41266j.get()) != null) {
                        q.clear();
                        mo42578a();
                        mo42580a((C13804t<?>) a);
                        return;
                    }
                    boolean d = this.f41270n.get() == 0;
                    Integer mode = (Integer) q.poll();
                    boolean empty = mode == null;
                    if (d && empty) {
                        for (UnicastSubject<?> up : this.f41264h.values()) {
                            up.onComplete();
                        }
                        this.f41264h.clear();
                        this.f41265i.clear();
                        this.f41263g.dispose();
                        a.onComplete();
                        return;
                    } else if (empty) {
                        missed = addAndGet(-missed);
                        if (missed == 0) {
                            return;
                        }
                    } else {
                        Object val = q.poll();
                        if (mode == f41257a) {
                            Object obj = val;
                            UnicastSubject<TRight> up2 = C13792d.m43863b();
                            int i = this.f41271o;
                            this.f41271o = i + 1;
                            int idx = i;
                            this.f41264h.put(Integer.valueOf(idx), up2);
                            try {
                                Object apply = this.f41267k.apply(obj);
                                C13264b.m43226a(apply, "The leftEnd returned a null ObservableSource");
                                C13802r rVar = (C13802r) apply;
                                C13562c end = new C13562c(this, true, idx);
                                this.f41263g.mo42252b(end);
                                rVar.subscribe(end);
                                if (((Throwable) this.f41266j.get()) != null) {
                                    q.clear();
                                    mo42578a();
                                    mo42580a((C13804t<?>) a);
                                    return;
                                }
                                try {
                                    Object apply2 = this.f41269m.apply(obj, up2);
                                    C13264b.m43226a(apply2, "The resultSelector returned a null value");
                                    a.onNext(apply2);
                                    for (R w : this.f41265i.values()) {
                                        Object obj2 = apply2;
                                        up2.onNext(w);
                                        apply2 = obj2;
                                    }
                                    Object obj3 = apply2;
                                } catch (Throwable exc) {
                                    mo42582a(exc, a, q);
                                    return;
                                }
                            } catch (Throwable exc2) {
                                mo42582a(exc2, a, q);
                                return;
                            }
                        } else if (mode == f41258b) {
                            Object obj4 = val;
                            int i2 = this.f41272p;
                            this.f41272p = i2 + 1;
                            int idx2 = i2;
                            this.f41265i.put(Integer.valueOf(idx2), obj4);
                            try {
                                Object apply3 = this.f41268l.apply(obj4);
                                C13264b.m43226a(apply3, "The rightEnd returned a null ObservableSource");
                                ObservableSource<TRightEnd> p = (C13802r) apply3;
                                C13562c end2 = new C13562c(this, false, idx2);
                                this.f41263g.mo42252b(end2);
                                p.subscribe(end2);
                                if (((Throwable) this.f41266j.get()) != null) {
                                    q.clear();
                                    mo42578a();
                                    mo42580a((C13804t<?>) a);
                                    return;
                                }
                                for (UnicastSubject<TRight> up3 : this.f41264h.values()) {
                                    up3.onNext(obj4);
                                }
                            } catch (Throwable exc3) {
                                mo42582a(exc3, a, q);
                                return;
                            }
                        } else if (mode == f41259c) {
                            C13562c end3 = (C13562c) val;
                            UnicastSubject<TRight> up4 = (C13792d) this.f41264h.remove(Integer.valueOf(end3.f41276c));
                            this.f41263g.mo42250a((C13194b) end3);
                            if (up4 != null) {
                                up4.onComplete();
                            }
                        } else if (mode == f41260d) {
                            C13562c end4 = (C13562c) val;
                            this.f41265i.remove(Integer.valueOf(end4.f41276c));
                            this.f41263g.mo42250a((C13194b) end4);
                        }
                    }
                }
                q.clear();
            }
        }

        /* renamed from: a */
        public void mo42581a(Throwable ex) {
            if (C13748j.m43763a(this.f41266j, ex)) {
                this.f41270n.decrementAndGet();
                mo42585b();
                return;
            }
            C13774a.m43836b(ex);
        }

        /* renamed from: a */
        public void mo42579a(C13563d sender) {
            this.f41263g.mo42253c(sender);
            this.f41270n.decrementAndGet();
            mo42585b();
        }

        /* renamed from: a */
        public void mo42584a(boolean isLeft, Object o) {
            synchronized (this) {
                this.f41262f.mo42689a(isLeft ? f41257a : f41258b, o);
            }
            mo42585b();
        }

        /* renamed from: a */
        public void mo42583a(boolean isLeft, C13562c index) {
            synchronized (this) {
                this.f41262f.mo42689a(isLeft ? f41259c : f41260d, index);
            }
            mo42585b();
        }

        /* renamed from: b */
        public void mo42586b(Throwable ex) {
            if (C13748j.m43763a(this.f41266j, ex)) {
                mo42585b();
            } else {
                C13774a.m43836b(ex);
            }
        }
    }

    /* renamed from: f.a.d.e.b.la$b */
    /* compiled from: ObservableGroupJoin */
    interface C13561b {
        /* renamed from: a */
        void mo42579a(C13563d dVar);

        /* renamed from: a */
        void mo42581a(Throwable th);

        /* renamed from: a */
        void mo42583a(boolean z, C13562c cVar);

        /* renamed from: a */
        void mo42584a(boolean z, Object obj);

        /* renamed from: b */
        void mo42586b(Throwable th);
    }

    /* renamed from: f.a.d.e.b.la$c */
    /* compiled from: ObservableGroupJoin */
    static final class C13562c extends AtomicReference<C13194b> implements C13804t<Object>, C13194b {

        /* renamed from: a */
        final C13561b f41274a;

        /* renamed from: b */
        final boolean f41275b;

        /* renamed from: c */
        final int f41276c;

        C13562c(C13561b parent, boolean isLeft, int index) {
            this.f41274a = parent;
            this.f41275b = isLeft;
            this.f41276c = index;
        }

        public void dispose() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }

        public void onSubscribe(C13194b s) {
            C13218c.m43153c(this, s);
        }

        public void onNext(Object t) {
            if (C13218c.m43150a((AtomicReference<C13194b>) this)) {
                this.f41274a.mo42583a(this.f41275b, this);
            }
        }

        public void onError(Throwable t) {
            this.f41274a.mo42586b(t);
        }

        public void onComplete() {
            this.f41274a.mo42583a(this.f41275b, this);
        }
    }

    /* renamed from: f.a.d.e.b.la$d */
    /* compiled from: ObservableGroupJoin */
    static final class C13563d extends AtomicReference<C13194b> implements C13804t<Object>, C13194b {

        /* renamed from: a */
        final C13561b f41277a;

        /* renamed from: b */
        final boolean f41278b;

        C13563d(C13561b parent, boolean isLeft) {
            this.f41277a = parent;
            this.f41278b = isLeft;
        }

        public void dispose() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }

        public void onSubscribe(C13194b s) {
            C13218c.m43153c(this, s);
        }

        public void onNext(Object t) {
            this.f41277a.mo42584a(this.f41278b, t);
        }

        public void onError(Throwable t) {
            this.f41277a.mo42581a(t);
        }

        public void onComplete() {
            this.f41277a.mo42579a(this);
        }
    }

    public C13559la(C13802r<TLeft> source, C13802r<? extends TRight> other, C13212n<? super TLeft, ? extends C13802r<TLeftEnd>> leftEnd, C13212n<? super TRight, ? extends C13802r<TRightEnd>> rightEnd, C13201c<? super TLeft, ? super C13797m<TRight>, ? extends R> resultSelector) {
        super(source);
        this.f41253b = other;
        this.f41254c = leftEnd;
        this.f41255d = rightEnd;
        this.f41256e = resultSelector;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super R> s) {
        GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> parent = new C13560a<>(s, this.f41254c, this.f41255d, this.f41256e);
        s.onSubscribe(parent);
        C13563d left = new C13563d(parent, true);
        parent.f41263g.mo42252b(left);
        C13563d right = new C13563d(parent, false);
        parent.f41263g.mo42252b(right);
        this.f41005a.subscribe(left);
        this.f41253b.subscribe(right);
    }
}
