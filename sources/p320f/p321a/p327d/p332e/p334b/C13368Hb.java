package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactBoundedObserver;
import io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowSkipObserver.SubjectWork;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13805u;
import p320f.p321a.C13805u.C13808c;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p330c.C13273h;
import p320f.p321a.p327d.p331d.C13291q;
import p320f.p321a.p327d.p336f.C13703a;
import p320f.p321a.p327d.p340j.C13753n;
import p320f.p321a.p342f.C13770f;
import p320f.p321a.p345i.C13792d;

/* renamed from: f.a.d.e.b.Hb */
/* compiled from: ObservableWindowTimed */
public final class C13368Hb<T> extends C13485a<T, C13797m<T>> {

    /* renamed from: b */
    final long f40637b;

    /* renamed from: c */
    final long f40638c;

    /* renamed from: d */
    final TimeUnit f40639d;

    /* renamed from: e */
    final C13805u f40640e;

    /* renamed from: f */
    final long f40641f;

    /* renamed from: g */
    final int f40642g;

    /* renamed from: h */
    final boolean f40643h;

    /* renamed from: f.a.d.e.b.Hb$a */
    /* compiled from: ObservableWindowTimed */
    static final class C13369a<T> extends C13291q<T, Object, C13797m<T>> implements C13194b {

        /* renamed from: g */
        final long f40644g;

        /* renamed from: h */
        final TimeUnit f40645h;

        /* renamed from: i */
        final C13805u f40646i;

        /* renamed from: j */
        final int f40647j;

        /* renamed from: k */
        final boolean f40648k;

        /* renamed from: l */
        final long f40649l;

        /* renamed from: m */
        final C13808c f40650m;

        /* renamed from: n */
        long f40651n;

        /* renamed from: o */
        long f40652o;

        /* renamed from: p */
        C13194b f40653p;

        /* renamed from: q */
        C13792d<T> f40654q;

        /* renamed from: r */
        volatile boolean f40655r;

        /* renamed from: s */
        final AtomicReference<C13194b> f40656s = new AtomicReference<>();

        /* renamed from: f.a.d.e.b.Hb$a$a */
        /* compiled from: ObservableWindowTimed */
        static final class C13370a implements Runnable {

            /* renamed from: a */
            final long f40657a;

            /* renamed from: b */
            final C13369a<?> f40658b;

            C13370a(long index, C13369a<?> parent) {
                this.f40657a = index;
                this.f40658b = parent;
            }

            public void run() {
                WindowExactBoundedObserver<?> p = this.f40658b;
                if (!p.f40395d) {
                    p.f40394c.offer(this);
                } else {
                    p.f40655r = true;
                    p.mo42414d();
                }
                if (p.mo42347b()) {
                    p.mo42415e();
                }
            }
        }

        C13369a(C13804t<? super C13797m<T>> actual, long timespan, TimeUnit unit, C13805u scheduler, int bufferSize, long maxSize, boolean restartTimerOnMaxSize) {
            super(actual, new C13703a());
            this.f40644g = timespan;
            this.f40645h = unit;
            this.f40646i = scheduler;
            this.f40647j = bufferSize;
            this.f40649l = maxSize;
            this.f40648k = restartTimerOnMaxSize;
            if (restartTimerOnMaxSize) {
                this.f40650m = scheduler.mo42242a();
            } else {
                this.f40650m = null;
            }
        }

        public void onSubscribe(C13194b s) {
            C13194b d;
            if (C13218c.m43149a(this.f40653p, s)) {
                this.f40653p = s;
                Observer<? super Observable<T>> a = this.f40393b;
                a.onSubscribe(this);
                if (!this.f40395d) {
                    UnicastSubject<T> w = C13792d.m43861a(this.f40647j);
                    this.f40654q = w;
                    a.onNext(w);
                    C13370a consumerIndexHolder = new C13370a(this.f40652o, this);
                    if (this.f40648k) {
                        C13808c cVar = this.f40650m;
                        long j = this.f40644g;
                        d = cVar.mo43151a(consumerIndexHolder, j, j, this.f40645h);
                    } else {
                        C13805u uVar = this.f40646i;
                        long j2 = this.f40644g;
                        d = uVar.mo42692a(consumerIndexHolder, j2, j2, this.f40645h);
                    }
                    C13218c.m43151a(this.f40656s, d);
                }
            }
        }

        public void onNext(T t) {
            if (!this.f40655r) {
                if (mo42348c()) {
                    UnicastSubject<T> w = this.f40654q;
                    w.onNext(t);
                    long c = this.f40651n + 1;
                    if (c >= this.f40649l) {
                        this.f40652o++;
                        this.f40651n = 0;
                        w.onComplete();
                        UnicastSubject<T> w2 = C13792d.m43861a(this.f40647j);
                        this.f40654q = w2;
                        this.f40393b.onNext(w2);
                        if (this.f40648k) {
                            ((C13194b) this.f40656s.get()).dispose();
                            C13808c cVar = this.f40650m;
                            C13370a aVar = new C13370a(this.f40652o, this);
                            long j = this.f40644g;
                            C13218c.m43151a(this.f40656s, cVar.mo43151a(aVar, j, j, this.f40645h));
                        }
                    } else {
                        this.f40651n = c;
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
                mo42415e();
            }
        }

        public void onError(Throwable t) {
            this.f40397f = t;
            this.f40396e = true;
            if (mo42347b()) {
                mo42415e();
            }
            this.f40393b.onError(t);
            mo42414d();
        }

        public void onComplete() {
            this.f40396e = true;
            if (mo42347b()) {
                mo42415e();
            }
            this.f40393b.onComplete();
            mo42414d();
        }

        public void dispose() {
            this.f40395d = true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo42414d() {
            C13218c.m43150a(this.f40656s);
            C13808c w = this.f40650m;
            if (w != null) {
                w.dispose();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo42415e() {
            C13804t<? super V> tVar;
            C13703a aVar;
            C13703a aVar2 = (C13703a) this.f40394c;
            C13804t<? super V> tVar2 = this.f40393b;
            UnicastSubject<T> w = this.f40654q;
            int missed = 1;
            while (!this.f40655r) {
                boolean d = this.f40396e;
                Object o = aVar2.poll();
                boolean empty = o == null;
                boolean isHolder = o instanceof C13370a;
                if (d && (empty || isHolder)) {
                    this.f40654q = null;
                    aVar2.clear();
                    mo42414d();
                    Throwable err = this.f40397f;
                    if (err != null) {
                        w.onError(err);
                    } else {
                        w.onComplete();
                    }
                    return;
                } else if (empty) {
                    missed = mo42342a(-missed);
                    if (missed == 0) {
                        return;
                    }
                } else if (isHolder) {
                    C13370a consumerIndexHolder = (C13370a) o;
                    if (this.f40648k || this.f40652o == consumerIndexHolder.f40657a) {
                        w.onComplete();
                        this.f40651n = 0;
                        w = C13792d.m43861a(this.f40647j);
                        this.f40654q = w;
                        tVar2.onNext(w);
                    }
                } else {
                    C13753n.m43780c(o);
                    w.onNext(o);
                    long c = this.f40651n + 1;
                    if (c >= this.f40649l) {
                        this.f40652o++;
                        this.f40651n = 0;
                        w.onComplete();
                        w = C13792d.m43861a(this.f40647j);
                        this.f40654q = w;
                        this.f40393b.onNext(w);
                        if (this.f40648k) {
                            C13194b tm = (C13194b) this.f40656s.get();
                            tm.dispose();
                            C13808c cVar = this.f40650m;
                            aVar = aVar2;
                            tVar = tVar2;
                            C13370a aVar3 = new C13370a(this.f40652o, this);
                            long j = this.f40644g;
                            C13194b task = cVar.mo43151a(aVar3, j, j, this.f40645h);
                            if (!this.f40656s.compareAndSet(tm, task)) {
                                task.dispose();
                            }
                        } else {
                            aVar = aVar2;
                            tVar = tVar2;
                        }
                    } else {
                        aVar = aVar2;
                        tVar = tVar2;
                        this.f40651n = c;
                    }
                    aVar2 = aVar;
                    tVar2 = tVar;
                }
            }
            this.f40653p.dispose();
            aVar2.clear();
            mo42414d();
        }
    }

    /* renamed from: f.a.d.e.b.Hb$b */
    /* compiled from: ObservableWindowTimed */
    static final class C13371b<T> extends C13291q<T, Object, C13797m<T>> implements C13804t<T>, C13194b, Runnable {

        /* renamed from: g */
        static final Object f40659g = new Object();

        /* renamed from: h */
        final long f40660h;

        /* renamed from: i */
        final TimeUnit f40661i;

        /* renamed from: j */
        final C13805u f40662j;

        /* renamed from: k */
        final int f40663k;

        /* renamed from: l */
        C13194b f40664l;

        /* renamed from: m */
        C13792d<T> f40665m;

        /* renamed from: n */
        final AtomicReference<C13194b> f40666n = new AtomicReference<>();

        /* renamed from: o */
        volatile boolean f40667o;

        C13371b(C13804t<? super C13797m<T>> actual, long timespan, TimeUnit unit, C13805u scheduler, int bufferSize) {
            super(actual, new C13703a());
            this.f40660h = timespan;
            this.f40661i = unit;
            this.f40662j = scheduler;
            this.f40663k = bufferSize;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40664l, s)) {
                this.f40664l = s;
                this.f40665m = C13792d.m43861a(this.f40663k);
                Observer<? super Observable<T>> a = this.f40393b;
                a.onSubscribe(this);
                a.onNext(this.f40665m);
                if (!this.f40395d) {
                    C13805u uVar = this.f40662j;
                    long j = this.f40660h;
                    C13218c.m43151a(this.f40666n, uVar.mo42692a(this, j, j, this.f40661i));
                }
            }
        }

        public void onNext(T t) {
            if (!this.f40667o) {
                if (mo42348c()) {
                    this.f40665m.onNext(t);
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
                mo42418e();
            }
        }

        public void onError(Throwable t) {
            this.f40397f = t;
            this.f40396e = true;
            if (mo42347b()) {
                mo42418e();
            }
            mo42417d();
            this.f40393b.onError(t);
        }

        public void onComplete() {
            this.f40396e = true;
            if (mo42347b()) {
                mo42418e();
            }
            mo42417d();
            this.f40393b.onComplete();
        }

        public void dispose() {
            this.f40395d = true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo42417d() {
            C13218c.m43150a(this.f40666n);
        }

        public void run() {
            if (this.f40395d) {
                this.f40667o = true;
                mo42417d();
            }
            this.f40394c.offer(f40659g);
            if (mo42347b()) {
                mo42418e();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo42418e() {
            MpscLinkedQueue<Object> q = (C13703a) this.f40394c;
            Observer<? super Observable<T>> a = this.f40393b;
            UnicastSubject<T> w = this.f40665m;
            int missed = 1;
            while (true) {
                boolean term = this.f40667o;
                boolean d = this.f40396e;
                Object o = q.poll();
                if (!d || !(o == null || o == f40659g)) {
                    if (o == null) {
                        missed = mo42342a(-missed);
                        if (missed == 0) {
                            return;
                        }
                    } else if (o == f40659g) {
                        w.onComplete();
                        if (!term) {
                            w = C13792d.m43861a(this.f40663k);
                            this.f40665m = w;
                            a.onNext(w);
                        } else {
                            this.f40664l.dispose();
                        }
                    } else {
                        C13753n.m43780c(o);
                        w.onNext(o);
                    }
                }
            }
            this.f40665m = null;
            q.clear();
            mo42417d();
            Throwable err = this.f40397f;
            if (err != null) {
                w.onError(err);
            } else {
                w.onComplete();
            }
        }
    }

    /* renamed from: f.a.d.e.b.Hb$c */
    /* compiled from: ObservableWindowTimed */
    static final class C13372c<T> extends C13291q<T, Object, C13797m<T>> implements C13194b, Runnable {

        /* renamed from: g */
        final long f40668g;

        /* renamed from: h */
        final long f40669h;

        /* renamed from: i */
        final TimeUnit f40670i;

        /* renamed from: j */
        final C13808c f40671j;

        /* renamed from: k */
        final int f40672k;

        /* renamed from: l */
        final List<C13792d<T>> f40673l = new LinkedList();

        /* renamed from: m */
        C13194b f40674m;

        /* renamed from: n */
        volatile boolean f40675n;

        /* renamed from: f.a.d.e.b.Hb$c$a */
        /* compiled from: ObservableWindowTimed */
        final class C13373a implements Runnable {

            /* renamed from: a */
            private final C13792d<T> f40676a;

            C13373a(C13792d<T> w) {
                this.f40676a = w;
            }

            public void run() {
                C13372c.this.mo42420a(this.f40676a);
            }
        }

        /* renamed from: f.a.d.e.b.Hb$c$b */
        /* compiled from: ObservableWindowTimed */
        static final class C13374b<T> {

            /* renamed from: a */
            final C13792d<T> f40678a;

            /* renamed from: b */
            final boolean f40679b;

            C13374b(C13792d<T> w, boolean open) {
                this.f40678a = w;
                this.f40679b = open;
            }
        }

        C13372c(C13804t<? super C13797m<T>> actual, long timespan, long timeskip, TimeUnit unit, C13808c worker, int bufferSize) {
            super(actual, new C13703a());
            this.f40668g = timespan;
            this.f40669h = timeskip;
            this.f40670i = unit;
            this.f40671j = worker;
            this.f40672k = bufferSize;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40674m, s)) {
                this.f40674m = s;
                this.f40393b.onSubscribe(this);
                if (!this.f40395d) {
                    UnicastSubject<T> w = C13792d.m43861a(this.f40672k);
                    this.f40673l.add(w);
                    this.f40393b.onNext(w);
                    this.f40671j.mo42243a(new C13373a(w), this.f40668g, this.f40670i);
                    C13808c cVar = this.f40671j;
                    long j = this.f40669h;
                    cVar.mo43151a(this, j, j, this.f40670i);
                }
            }
        }

        public void onNext(T t) {
            if (mo42348c()) {
                Iterator it = this.f40673l.iterator();
                while (it.hasNext()) {
                    ((C13792d) it.next()).onNext(t);
                }
                if (mo42342a(-1) == 0) {
                    return;
                }
            } else {
                this.f40394c.offer(t);
                if (!mo42347b()) {
                    return;
                }
            }
            mo42422e();
        }

        public void onError(Throwable t) {
            this.f40397f = t;
            this.f40396e = true;
            if (mo42347b()) {
                mo42422e();
            }
            this.f40393b.onError(t);
            mo42421d();
        }

        public void onComplete() {
            this.f40396e = true;
            if (mo42347b()) {
                mo42422e();
            }
            this.f40393b.onComplete();
            mo42421d();
        }

        public void dispose() {
            this.f40395d = true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo42421d() {
            this.f40671j.dispose();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42420a(C13792d<T> w) {
            this.f40394c.offer(new C13374b(w, false));
            if (mo42347b()) {
                mo42422e();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo42422e() {
            MpscLinkedQueue<Object> q = (C13703a) this.f40394c;
            Observer<? super Observable<T>> a = this.f40393b;
            List<C13792d<T>> list = this.f40673l;
            int missed = 1;
            while (!this.f40675n) {
                boolean d = this.f40396e;
                Object v = q.poll();
                boolean empty = v == null;
                boolean sw = v instanceof C13374b;
                if (d && (empty || sw)) {
                    q.clear();
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
                    mo42421d();
                    list.clear();
                    return;
                } else if (empty) {
                    missed = mo42342a(-missed);
                    if (missed == 0) {
                        return;
                    }
                } else if (sw) {
                    SubjectWork<T> work = (C13374b) v;
                    if (!work.f40679b) {
                        list.remove(work.f40678a);
                        work.f40678a.onComplete();
                        if (list.isEmpty() && this.f40395d) {
                            this.f40675n = true;
                        }
                    } else if (!this.f40395d) {
                        UnicastSubject<T> w = C13792d.m43861a(this.f40672k);
                        list.add(w);
                        a.onNext(w);
                        this.f40671j.mo42243a(new C13373a(w), this.f40668g, this.f40670i);
                    }
                } else {
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        ((C13792d) it3.next()).onNext(v);
                    }
                }
            }
            this.f40674m.dispose();
            mo42421d();
            q.clear();
            list.clear();
        }

        public void run() {
            SubjectWork<T> sw = new C13374b<>(C13792d.m43861a(this.f40672k), true);
            if (!this.f40395d) {
                this.f40394c.offer(sw);
            }
            if (mo42347b()) {
                mo42422e();
            }
        }
    }

    public C13368Hb(C13802r<T> source, long timespan, long timeskip, TimeUnit unit, C13805u scheduler, long maxSize, int bufferSize, boolean restartTimerOnMaxSize) {
        super(source);
        this.f40637b = timespan;
        this.f40638c = timeskip;
        this.f40639d = unit;
        this.f40640e = scheduler;
        this.f40641f = maxSize;
        this.f40642g = bufferSize;
        this.f40643h = restartTimerOnMaxSize;
    }

    public void subscribeActual(C13804t<? super C13797m<T>> t) {
        C13770f fVar = new C13770f(t);
        long j = this.f40637b;
        long j2 = this.f40638c;
        if (j == j2) {
            long j3 = this.f40641f;
            if (j3 == Long.MAX_VALUE) {
                C13802r<T> rVar = this.f41005a;
                C13371b bVar = new C13371b(fVar, j, this.f40639d, this.f40640e, this.f40642g);
                rVar.subscribe(bVar);
                return;
            }
            C13802r<T> rVar2 = this.f41005a;
            C13369a aVar = new C13369a(fVar, j, this.f40639d, this.f40640e, this.f40642g, j3, this.f40643h);
            rVar2.subscribe(aVar);
            return;
        }
        C13802r<T> rVar3 = this.f41005a;
        C13372c cVar = new C13372c(fVar, j, j2, this.f40639d, this.f40640e.mo42242a(), this.f40642g);
        rVar3.subscribe(cVar);
    }
}
