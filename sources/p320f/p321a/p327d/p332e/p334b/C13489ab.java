package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableSequenceEqual.EqualObserver;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13202d;
import p320f.p321a.p327d.p328a.C13216a;
import p320f.p321a.p327d.p336f.C13706c;

/* renamed from: f.a.d.e.b.ab */
/* compiled from: ObservableSequenceEqual */
public final class C13489ab<T> extends C13797m<Boolean> {

    /* renamed from: a */
    final C13802r<? extends T> f41018a;

    /* renamed from: b */
    final C13802r<? extends T> f41019b;

    /* renamed from: c */
    final C13202d<? super T, ? super T> f41020c;

    /* renamed from: d */
    final int f41021d;

    /* renamed from: f.a.d.e.b.ab$a */
    /* compiled from: ObservableSequenceEqual */
    static final class C13490a<T> extends AtomicInteger implements C13194b {

        /* renamed from: a */
        final C13804t<? super Boolean> f41022a;

        /* renamed from: b */
        final C13202d<? super T, ? super T> f41023b;

        /* renamed from: c */
        final C13216a f41024c = new C13216a(2);

        /* renamed from: d */
        final C13802r<? extends T> f41025d;

        /* renamed from: e */
        final C13802r<? extends T> f41026e;

        /* renamed from: f */
        final C13491b<T>[] f41027f;

        /* renamed from: g */
        volatile boolean f41028g;

        /* renamed from: h */
        T f41029h;

        /* renamed from: i */
        T f41030i;

        C13490a(C13804t<? super Boolean> actual, int bufferSize, C13802r<? extends T> first, C13802r<? extends T> second, C13202d<? super T, ? super T> comparer) {
            this.f41022a = actual;
            this.f41025d = first;
            this.f41026e = second;
            this.f41023b = comparer;
            EqualObserver<T>[] as = new C13491b[2];
            this.f41027f = as;
            as[0] = new C13491b<>(this, 0, bufferSize);
            as[1] = new C13491b<>(this, 1, bufferSize);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo42522a(C13194b s, int index) {
            return this.f41024c.mo42273a(index, s);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42523b() {
            EqualObserver<T>[] as = this.f41027f;
            this.f41025d.subscribe(as[0]);
            this.f41026e.subscribe(as[1]);
        }

        public void dispose() {
            if (!this.f41028g) {
                this.f41028g = true;
                this.f41024c.dispose();
                if (getAndIncrement() == 0) {
                    EqualObserver<T>[] as = this.f41027f;
                    as[0].f41032b.clear();
                    as[1].f41032b.clear();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42521a(C13706c<T> q1, C13706c<T> q2) {
            this.f41028g = true;
            q1.clear();
            q2.clear();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42520a() {
            if (getAndIncrement() == 0) {
                int missed = 1;
                EqualObserver<T>[] as = this.f41027f;
                EqualObserver<T> s1 = as[0];
                SpscLinkedArrayQueue<T> q1 = s1.f41032b;
                EqualObserver<T> s2 = as[1];
                SpscLinkedArrayQueue<T> q2 = s2.f41032b;
                while (!this.f41028g) {
                    boolean d1 = s1.f41034d;
                    if (d1) {
                        Throwable e = s1.f41035e;
                        if (e != null) {
                            mo42521a((C13706c<T>) q1, (C13706c<T>) q2);
                            this.f41022a.onError(e);
                            return;
                        }
                    }
                    boolean d2 = s2.f41034d;
                    if (d2) {
                        Throwable e2 = s2.f41035e;
                        if (e2 != null) {
                            mo42521a((C13706c<T>) q1, (C13706c<T>) q2);
                            this.f41022a.onError(e2);
                            return;
                        }
                    }
                    if (this.f41029h == null) {
                        this.f41029h = q1.poll();
                    }
                    boolean e1 = this.f41029h == null;
                    if (this.f41030i == null) {
                        this.f41030i = q2.poll();
                    }
                    boolean e22 = this.f41030i == null;
                    if (d1 && d2 && e1 && e22) {
                        this.f41022a.onNext(Boolean.valueOf(true));
                        this.f41022a.onComplete();
                        return;
                    } else if (!d1 || !d2 || e1 == e22) {
                        if (!e1 && !e22) {
                            try {
                                if (!this.f41023b.test(this.f41029h, this.f41030i)) {
                                    mo42521a((C13706c<T>) q1, (C13706c<T>) q2);
                                    this.f41022a.onNext(Boolean.valueOf(false));
                                    this.f41022a.onComplete();
                                    return;
                                }
                                this.f41029h = null;
                                this.f41030i = null;
                            } catch (Throwable ex) {
                                C13980a.m44462b(ex);
                                mo42521a((C13706c<T>) q1, (C13706c<T>) q2);
                                this.f41022a.onError(ex);
                                return;
                            }
                        }
                        if (e1 || e22) {
                            missed = addAndGet(-missed);
                            if (missed == 0) {
                                return;
                            }
                        }
                    } else {
                        mo42521a((C13706c<T>) q1, (C13706c<T>) q2);
                        this.f41022a.onNext(Boolean.valueOf(false));
                        this.f41022a.onComplete();
                        return;
                    }
                }
                q1.clear();
                q2.clear();
            }
        }
    }

    /* renamed from: f.a.d.e.b.ab$b */
    /* compiled from: ObservableSequenceEqual */
    static final class C13491b<T> implements C13804t<T> {

        /* renamed from: a */
        final C13490a<T> f41031a;

        /* renamed from: b */
        final C13706c<T> f41032b;

        /* renamed from: c */
        final int f41033c;

        /* renamed from: d */
        volatile boolean f41034d;

        /* renamed from: e */
        Throwable f41035e;

        C13491b(C13490a<T> parent, int index, int bufferSize) {
            this.f41031a = parent;
            this.f41033c = index;
            this.f41032b = new C13706c<>(bufferSize);
        }

        public void onSubscribe(C13194b s) {
            this.f41031a.mo42522a(s, this.f41033c);
        }

        public void onNext(T t) {
            this.f41032b.offer(t);
            this.f41031a.mo42520a();
        }

        public void onError(Throwable t) {
            this.f41035e = t;
            this.f41034d = true;
            this.f41031a.mo42520a();
        }

        public void onComplete() {
            this.f41034d = true;
            this.f41031a.mo42520a();
        }
    }

    public C13489ab(C13802r<? extends T> first, C13802r<? extends T> second, C13202d<? super T, ? super T> comparer, int bufferSize) {
        this.f41018a = first;
        this.f41019b = second;
        this.f41020c = comparer;
        this.f41021d = bufferSize;
    }

    public void subscribeActual(C13804t<? super Boolean> s) {
        C13490a aVar = new C13490a(s, this.f41021d, this.f41018a, this.f41019b, this.f41020c);
        s.onSubscribe(aVar);
        aVar.mo42523b();
    }
}
