package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p345i.C13792d;

/* renamed from: f.a.d.e.b.Db */
/* compiled from: ObservableWindow */
public final class C13332Db<T> extends C13485a<T, C13797m<T>> {

    /* renamed from: b */
    final long f40503b;

    /* renamed from: c */
    final long f40504c;

    /* renamed from: d */
    final int f40505d;

    /* renamed from: f.a.d.e.b.Db$a */
    /* compiled from: ObservableWindow */
    static final class C13333a<T> extends AtomicInteger implements C13804t<T>, C13194b, Runnable {

        /* renamed from: a */
        final C13804t<? super C13797m<T>> f40506a;

        /* renamed from: b */
        final long f40507b;

        /* renamed from: c */
        final int f40508c;

        /* renamed from: d */
        long f40509d;

        /* renamed from: e */
        C13194b f40510e;

        /* renamed from: f */
        C13792d<T> f40511f;

        /* renamed from: g */
        volatile boolean f40512g;

        C13333a(C13804t<? super C13797m<T>> actual, long count, int capacityHint) {
            this.f40506a = actual;
            this.f40507b = count;
            this.f40508c = capacityHint;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40510e, s)) {
                this.f40510e = s;
                this.f40506a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            UnicastSubject<T> w = this.f40511f;
            if (w == null && !this.f40512g) {
                w = C13792d.m43862a(this.f40508c, (Runnable) this);
                this.f40511f = w;
                this.f40506a.onNext(w);
            }
            if (w != null) {
                w.onNext(t);
                long j = this.f40509d + 1;
                this.f40509d = j;
                if (j >= this.f40507b) {
                    this.f40509d = 0;
                    this.f40511f = null;
                    w.onComplete();
                    if (this.f40512g) {
                        this.f40510e.dispose();
                    }
                }
            }
        }

        public void onError(Throwable t) {
            UnicastSubject<T> w = this.f40511f;
            if (w != null) {
                this.f40511f = null;
                w.onError(t);
            }
            this.f40506a.onError(t);
        }

        public void onComplete() {
            UnicastSubject<T> w = this.f40511f;
            if (w != null) {
                this.f40511f = null;
                w.onComplete();
            }
            this.f40506a.onComplete();
        }

        public void dispose() {
            this.f40512g = true;
        }

        public void run() {
            if (this.f40512g) {
                this.f40510e.dispose();
            }
        }
    }

    /* renamed from: f.a.d.e.b.Db$b */
    /* compiled from: ObservableWindow */
    static final class C13334b<T> extends AtomicBoolean implements C13804t<T>, C13194b, Runnable {

        /* renamed from: a */
        final C13804t<? super C13797m<T>> f40513a;

        /* renamed from: b */
        final long f40514b;

        /* renamed from: c */
        final long f40515c;

        /* renamed from: d */
        final int f40516d;

        /* renamed from: e */
        final ArrayDeque<C13792d<T>> f40517e;

        /* renamed from: f */
        long f40518f;

        /* renamed from: g */
        volatile boolean f40519g;

        /* renamed from: h */
        long f40520h;

        /* renamed from: i */
        C13194b f40521i;

        /* renamed from: j */
        final AtomicInteger f40522j = new AtomicInteger();

        C13334b(C13804t<? super C13797m<T>> actual, long count, long skip, int capacityHint) {
            this.f40513a = actual;
            this.f40514b = count;
            this.f40515c = skip;
            this.f40516d = capacityHint;
            this.f40517e = new ArrayDeque<>();
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40521i, s)) {
                this.f40521i = s;
                this.f40513a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            ArrayDeque<C13792d<T>> arrayDeque = this.f40517e;
            long i = this.f40518f;
            long s = this.f40515c;
            if (i % s == 0 && !this.f40519g) {
                this.f40522j.getAndIncrement();
                UnicastSubject<T> w = C13792d.m43862a(this.f40516d, (Runnable) this);
                arrayDeque.offer(w);
                this.f40513a.onNext(w);
            }
            long c = this.f40520h + 1;
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                ((C13792d) it.next()).onNext(t);
            }
            if (c >= this.f40514b) {
                ((C13792d) arrayDeque.poll()).onComplete();
                if (!arrayDeque.isEmpty() || !this.f40519g) {
                    this.f40520h = c - s;
                } else {
                    this.f40521i.dispose();
                    return;
                }
            } else {
                this.f40520h = c;
            }
            this.f40518f = 1 + i;
        }

        public void onError(Throwable t) {
            ArrayDeque<C13792d<T>> arrayDeque = this.f40517e;
            while (!arrayDeque.isEmpty()) {
                ((C13792d) arrayDeque.poll()).onError(t);
            }
            this.f40513a.onError(t);
        }

        public void onComplete() {
            ArrayDeque<C13792d<T>> arrayDeque = this.f40517e;
            while (!arrayDeque.isEmpty()) {
                ((C13792d) arrayDeque.poll()).onComplete();
            }
            this.f40513a.onComplete();
        }

        public void dispose() {
            this.f40519g = true;
        }

        public void run() {
            if (this.f40522j.decrementAndGet() == 0 && this.f40519g) {
                this.f40521i.dispose();
            }
        }
    }

    public C13332Db(C13802r<T> source, long count, long skip, int capacityHint) {
        super(source);
        this.f40503b = count;
        this.f40504c = skip;
        this.f40505d = capacityHint;
    }

    public void subscribeActual(C13804t<? super C13797m<T>> t) {
        long j = this.f40503b;
        long j2 = this.f40504c;
        if (j == j2) {
            this.f41005a.subscribe(new C13333a(t, j, this.f40505d));
            return;
        }
        C13802r<T> rVar = this.f41005a;
        C13334b bVar = new C13334b(t, j, j2, this.f40505d);
        rVar.subscribe(bVar);
    }
}
