package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle.EqualObserver;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13810v;
import p320f.p321a.C13812x;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13202d;
import p320f.p321a.p327d.p328a.C13216a;
import p320f.p321a.p327d.p330c.C13266a;
import p320f.p321a.p327d.p336f.C13706c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.bb */
/* compiled from: ObservableSequenceEqualSingle */
public final class C13497bb<T> extends C13810v<Boolean> implements C13266a<Boolean> {

    /* renamed from: a */
    final C13802r<? extends T> f41055a;

    /* renamed from: b */
    final C13802r<? extends T> f41056b;

    /* renamed from: c */
    final C13202d<? super T, ? super T> f41057c;

    /* renamed from: d */
    final int f41058d;

    /* renamed from: f.a.d.e.b.bb$a */
    /* compiled from: ObservableSequenceEqualSingle */
    static final class C13498a<T> extends AtomicInteger implements C13194b {

        /* renamed from: a */
        final C13812x<? super Boolean> f41059a;

        /* renamed from: b */
        final C13202d<? super T, ? super T> f41060b;

        /* renamed from: c */
        final C13216a f41061c = new C13216a(2);

        /* renamed from: d */
        final C13802r<? extends T> f41062d;

        /* renamed from: e */
        final C13802r<? extends T> f41063e;

        /* renamed from: f */
        final C13499b<T>[] f41064f;

        /* renamed from: g */
        volatile boolean f41065g;

        /* renamed from: h */
        T f41066h;

        /* renamed from: i */
        T f41067i;

        C13498a(C13812x<? super Boolean> actual, int bufferSize, C13802r<? extends T> first, C13802r<? extends T> second, C13202d<? super T, ? super T> comparer) {
            this.f41059a = actual;
            this.f41062d = first;
            this.f41063e = second;
            this.f41060b = comparer;
            EqualObserver<T>[] as = new C13499b[2];
            this.f41064f = as;
            as[0] = new C13499b<>(this, 0, bufferSize);
            as[1] = new C13499b<>(this, 1, bufferSize);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo42537a(C13194b s, int index) {
            return this.f41061c.mo42273a(index, s);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42538b() {
            EqualObserver<T>[] as = this.f41064f;
            this.f41062d.subscribe(as[0]);
            this.f41063e.subscribe(as[1]);
        }

        public void dispose() {
            if (!this.f41065g) {
                this.f41065g = true;
                this.f41061c.dispose();
                if (getAndIncrement() == 0) {
                    EqualObserver<T>[] as = this.f41064f;
                    as[0].f41069b.clear();
                    as[1].f41069b.clear();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42536a(C13706c<T> q1, C13706c<T> q2) {
            this.f41065g = true;
            q1.clear();
            q2.clear();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42535a() {
            if (getAndIncrement() == 0) {
                int missed = 1;
                EqualObserver<T>[] as = this.f41064f;
                EqualObserver<T> s1 = as[0];
                SpscLinkedArrayQueue<T> q1 = s1.f41069b;
                EqualObserver<T> s2 = as[1];
                SpscLinkedArrayQueue<T> q2 = s2.f41069b;
                while (!this.f41065g) {
                    boolean d1 = s1.f41071d;
                    if (d1) {
                        Throwable e = s1.f41072e;
                        if (e != null) {
                            mo42536a((C13706c<T>) q1, (C13706c<T>) q2);
                            this.f41059a.onError(e);
                            return;
                        }
                    }
                    boolean d2 = s2.f41071d;
                    if (d2) {
                        Throwable e2 = s2.f41072e;
                        if (e2 != null) {
                            mo42536a((C13706c<T>) q1, (C13706c<T>) q2);
                            this.f41059a.onError(e2);
                            return;
                        }
                    }
                    if (this.f41066h == null) {
                        this.f41066h = q1.poll();
                    }
                    boolean e1 = this.f41066h == null;
                    if (this.f41067i == null) {
                        this.f41067i = q2.poll();
                    }
                    boolean e22 = this.f41067i == null;
                    if (d1 && d2 && e1 && e22) {
                        this.f41059a.onSuccess(Boolean.valueOf(true));
                        return;
                    } else if (!d1 || !d2 || e1 == e22) {
                        if (!e1 && !e22) {
                            try {
                                if (!this.f41060b.test(this.f41066h, this.f41067i)) {
                                    mo42536a((C13706c<T>) q1, (C13706c<T>) q2);
                                    this.f41059a.onSuccess(Boolean.valueOf(false));
                                    return;
                                }
                                this.f41066h = null;
                                this.f41067i = null;
                            } catch (Throwable ex) {
                                C13980a.m44462b(ex);
                                mo42536a((C13706c<T>) q1, (C13706c<T>) q2);
                                this.f41059a.onError(ex);
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
                        mo42536a((C13706c<T>) q1, (C13706c<T>) q2);
                        this.f41059a.onSuccess(Boolean.valueOf(false));
                        return;
                    }
                }
                q1.clear();
                q2.clear();
            }
        }
    }

    /* renamed from: f.a.d.e.b.bb$b */
    /* compiled from: ObservableSequenceEqualSingle */
    static final class C13499b<T> implements C13804t<T> {

        /* renamed from: a */
        final C13498a<T> f41068a;

        /* renamed from: b */
        final C13706c<T> f41069b;

        /* renamed from: c */
        final int f41070c;

        /* renamed from: d */
        volatile boolean f41071d;

        /* renamed from: e */
        Throwable f41072e;

        C13499b(C13498a<T> parent, int index, int bufferSize) {
            this.f41068a = parent;
            this.f41070c = index;
            this.f41069b = new C13706c<>(bufferSize);
        }

        public void onSubscribe(C13194b s) {
            this.f41068a.mo42537a(s, this.f41070c);
        }

        public void onNext(T t) {
            this.f41069b.offer(t);
            this.f41068a.mo42535a();
        }

        public void onError(Throwable t) {
            this.f41072e = t;
            this.f41071d = true;
            this.f41068a.mo42535a();
        }

        public void onComplete() {
            this.f41071d = true;
            this.f41068a.mo42535a();
        }
    }

    public C13497bb(C13802r<? extends T> first, C13802r<? extends T> second, C13202d<? super T, ? super T> comparer, int bufferSize) {
        this.f41055a = first;
        this.f41056b = second;
        this.f41057c = comparer;
        this.f41058d = bufferSize;
    }

    /* renamed from: b */
    public void mo42365b(C13812x<? super Boolean> s) {
        C13498a aVar = new C13498a(s, this.f41058d, this.f41055a, this.f41056b, this.f41057c);
        s.onSubscribe(aVar);
        aVar.mo42538b();
    }

    /* renamed from: a */
    public C13797m<Boolean> mo42316a() {
        return C13774a.m43821a((C13797m<T>) new C13489ab<T>(this.f41055a, this.f41056b, this.f41057c, this.f41058d));
    }
}
