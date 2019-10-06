package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableJoin.JoinDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Iterator;
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
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p336f.C13706c;
import p320f.p321a.p327d.p340j.C13748j;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.sa */
/* compiled from: ObservableJoin */
public final class C13630sa<TLeft, TRight, TLeftEnd, TRightEnd, R> extends C13485a<TLeft, R> {

    /* renamed from: b */
    final C13802r<? extends TRight> f41488b;

    /* renamed from: c */
    final C13212n<? super TLeft, ? extends C13802r<TLeftEnd>> f41489c;

    /* renamed from: d */
    final C13212n<? super TRight, ? extends C13802r<TRightEnd>> f41490d;

    /* renamed from: e */
    final C13201c<? super TLeft, ? super TRight, ? extends R> f41491e;

    /* renamed from: f.a.d.e.b.sa$a */
    /* compiled from: ObservableJoin */
    static final class C13631a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements C13194b, C13561b {

        /* renamed from: a */
        static final Integer f41492a = Integer.valueOf(1);

        /* renamed from: b */
        static final Integer f41493b = Integer.valueOf(2);

        /* renamed from: c */
        static final Integer f41494c = Integer.valueOf(3);

        /* renamed from: d */
        static final Integer f41495d = Integer.valueOf(4);

        /* renamed from: e */
        final C13804t<? super R> f41496e;

        /* renamed from: f */
        final C13706c<Object> f41497f = new C13706c<>(C13797m.bufferSize());

        /* renamed from: g */
        final C13193a f41498g = new C13193a();

        /* renamed from: h */
        final Map<Integer, TLeft> f41499h = new LinkedHashMap();

        /* renamed from: i */
        final Map<Integer, TRight> f41500i = new LinkedHashMap();

        /* renamed from: j */
        final AtomicReference<Throwable> f41501j = new AtomicReference<>();

        /* renamed from: k */
        final C13212n<? super TLeft, ? extends C13802r<TLeftEnd>> f41502k;

        /* renamed from: l */
        final C13212n<? super TRight, ? extends C13802r<TRightEnd>> f41503l;

        /* renamed from: m */
        final C13201c<? super TLeft, ? super TRight, ? extends R> f41504m;

        /* renamed from: n */
        final AtomicInteger f41505n;

        /* renamed from: o */
        int f41506o;

        /* renamed from: p */
        int f41507p;

        /* renamed from: q */
        volatile boolean f41508q;

        C13631a(C13804t<? super R> actual, C13212n<? super TLeft, ? extends C13802r<TLeftEnd>> leftEnd, C13212n<? super TRight, ? extends C13802r<TRightEnd>> rightEnd, C13201c<? super TLeft, ? super TRight, ? extends R> resultSelector) {
            this.f41496e = actual;
            this.f41502k = leftEnd;
            this.f41503l = rightEnd;
            this.f41504m = resultSelector;
            this.f41505n = new AtomicInteger(2);
        }

        public void dispose() {
            if (!this.f41508q) {
                this.f41508q = true;
                mo42630a();
                if (getAndIncrement() == 0) {
                    this.f41497f.clear();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42630a() {
            this.f41498g.dispose();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42631a(C13804t<?> a) {
            Throwable ex = C13748j.m43762a(this.f41501j);
            this.f41499h.clear();
            this.f41500i.clear();
            a.onError(ex);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42632a(Throwable exc, C13804t<?> a, C13706c<?> q) {
            C13980a.m44462b(exc);
            C13748j.m43763a(this.f41501j, exc);
            q.clear();
            mo42630a();
            mo42631a(a);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42633b() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> q = this.f41497f;
                Observer<? super R> a = this.f41496e;
                int missed = 1;
                while (this.f41508q == 0) {
                    if (((Throwable) this.f41501j.get()) != null) {
                        q.clear();
                        mo42630a();
                        mo42631a((C13804t<?>) a);
                        return;
                    }
                    boolean d = this.f41505n.get() == 0;
                    Integer mode = (Integer) q.poll();
                    boolean empty = mode == null;
                    if (d && empty) {
                        this.f41499h.clear();
                        this.f41500i.clear();
                        this.f41498g.dispose();
                        a.onComplete();
                        return;
                    } else if (empty) {
                        missed = addAndGet(-missed);
                        if (missed == 0) {
                            return;
                        }
                    } else {
                        Object val = q.poll();
                        String str = "The resultSelector returned a null value";
                        if (mode == f41492a) {
                            Object obj = val;
                            int i = this.f41506o;
                            this.f41506o = i + 1;
                            int idx = i;
                            this.f41499h.put(Integer.valueOf(idx), obj);
                            try {
                                Object apply = this.f41502k.apply(obj);
                                C13264b.m43226a(apply, "The leftEnd returned a null ObservableSource");
                                C13802r rVar = (C13802r) apply;
                                C13562c end = new C13562c(this, true, idx);
                                this.f41498g.mo42252b(end);
                                rVar.subscribe(end);
                                if (((Throwable) this.f41501j.get()) != null) {
                                    q.clear();
                                    mo42630a();
                                    mo42631a((C13804t<?>) a);
                                    return;
                                }
                                Iterator it = this.f41500i.values().iterator();
                                while (it.hasNext()) {
                                    Iterator it2 = it;
                                    try {
                                        R w = this.f41504m.apply(obj, it.next());
                                        C13264b.m43226a(w, str);
                                        a.onNext(w);
                                        it = it2;
                                    } catch (Throwable exc) {
                                        mo42632a(exc, a, q);
                                        return;
                                    }
                                }
                            } catch (Throwable exc2) {
                                mo42632a(exc2, a, q);
                                return;
                            }
                        } else if (mode == f41493b) {
                            Object obj2 = val;
                            int i2 = this.f41507p;
                            this.f41507p = i2 + 1;
                            int idx2 = i2;
                            this.f41500i.put(Integer.valueOf(idx2), obj2);
                            try {
                                Object apply2 = this.f41503l.apply(obj2);
                                C13264b.m43226a(apply2, "The rightEnd returned a null ObservableSource");
                                C13802r rVar2 = (C13802r) apply2;
                                C13562c end2 = new C13562c(this, false, idx2);
                                this.f41498g.mo42252b(end2);
                                rVar2.subscribe(end2);
                                if (((Throwable) this.f41501j.get()) != null) {
                                    q.clear();
                                    mo42630a();
                                    mo42631a((C13804t<?>) a);
                                    return;
                                }
                                Iterator it3 = this.f41499h.values().iterator();
                                while (it3.hasNext()) {
                                    Iterator it4 = it3;
                                    try {
                                        R w2 = this.f41504m.apply(it3.next(), obj2);
                                        C13264b.m43226a(w2, str);
                                        a.onNext(w2);
                                        it3 = it4;
                                    } catch (Throwable exc3) {
                                        mo42632a(exc3, a, q);
                                        return;
                                    }
                                }
                            } catch (Throwable exc4) {
                                mo42632a(exc4, a, q);
                                return;
                            }
                        } else if (mode == f41494c) {
                            C13562c end3 = (C13562c) val;
                            this.f41499h.remove(Integer.valueOf(end3.f41276c));
                            this.f41498g.mo42250a((C13194b) end3);
                        } else {
                            C13562c end4 = (C13562c) val;
                            this.f41500i.remove(Integer.valueOf(end4.f41276c));
                            this.f41498g.mo42250a((C13194b) end4);
                        }
                    }
                }
                q.clear();
            }
        }

        /* renamed from: a */
        public void mo42581a(Throwable ex) {
            if (C13748j.m43763a(this.f41501j, ex)) {
                this.f41505n.decrementAndGet();
                mo42633b();
                return;
            }
            C13774a.m43836b(ex);
        }

        /* renamed from: a */
        public void mo42579a(C13563d sender) {
            this.f41498g.mo42253c(sender);
            this.f41505n.decrementAndGet();
            mo42633b();
        }

        /* renamed from: a */
        public void mo42584a(boolean isLeft, Object o) {
            synchronized (this) {
                this.f41497f.mo42689a(isLeft ? f41492a : f41493b, o);
            }
            mo42633b();
        }

        /* renamed from: a */
        public void mo42583a(boolean isLeft, C13562c index) {
            synchronized (this) {
                this.f41497f.mo42689a(isLeft ? f41494c : f41495d, index);
            }
            mo42633b();
        }

        /* renamed from: b */
        public void mo42586b(Throwable ex) {
            if (C13748j.m43763a(this.f41501j, ex)) {
                mo42633b();
            } else {
                C13774a.m43836b(ex);
            }
        }
    }

    public C13630sa(C13802r<TLeft> source, C13802r<? extends TRight> other, C13212n<? super TLeft, ? extends C13802r<TLeftEnd>> leftEnd, C13212n<? super TRight, ? extends C13802r<TRightEnd>> rightEnd, C13201c<? super TLeft, ? super TRight, ? extends R> resultSelector) {
        super(source);
        this.f41488b = other;
        this.f41489c = leftEnd;
        this.f41490d = rightEnd;
        this.f41491e = resultSelector;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super R> s) {
        JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> parent = new C13631a<>(s, this.f41489c, this.f41490d, this.f41491e);
        s.onSubscribe(parent);
        C13563d left = new C13563d(parent, true);
        parent.f41498g.mo42252b(left);
        C13563d right = new C13563d(parent, false);
        parent.f41498g.mo42252b(right);
        this.f41005a.subscribe(left);
        this.f41488b.subscribe(right);
    }
}
