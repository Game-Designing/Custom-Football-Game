package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observer;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13805u;
import p320f.p321a.C13805u.C13808c;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p330c.C13269d;
import p320f.p321a.p327d.p330c.C13274i;
import p320f.p321a.p327d.p331d.C13276b;
import p320f.p321a.p327d.p336f.C13706c;
import p320f.p321a.p327d.p337g.C13730o;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.Ea */
/* compiled from: ObservableObserveOn */
public final class C13338Ea<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13805u f40538b;

    /* renamed from: c */
    final boolean f40539c;

    /* renamed from: d */
    final int f40540d;

    /* renamed from: f.a.d.e.b.Ea$a */
    /* compiled from: ObservableObserveOn */
    static final class C13339a<T> extends C13276b<T> implements C13804t<T>, Runnable {

        /* renamed from: a */
        final C13804t<? super T> f40541a;

        /* renamed from: b */
        final C13808c f40542b;

        /* renamed from: c */
        final boolean f40543c;

        /* renamed from: d */
        final int f40544d;

        /* renamed from: e */
        C13274i<T> f40545e;

        /* renamed from: f */
        C13194b f40546f;

        /* renamed from: g */
        Throwable f40547g;

        /* renamed from: h */
        volatile boolean f40548h;

        /* renamed from: i */
        volatile boolean f40549i;

        /* renamed from: j */
        int f40550j;

        /* renamed from: k */
        boolean f40551k;

        C13339a(C13804t<? super T> actual, C13808c worker, boolean delayError, int bufferSize) {
            this.f40541a = actual;
            this.f40542b = worker;
            this.f40543c = delayError;
            this.f40544d = bufferSize;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40546f, s)) {
                this.f40546f = s;
                if (s instanceof C13269d) {
                    QueueDisposable<T> qd = (C13269d) s;
                    int m = qd.mo42274a(7);
                    if (m == 1) {
                        this.f40550j = m;
                        this.f40545e = qd;
                        this.f40548h = true;
                        this.f40541a.onSubscribe(this);
                        mo42394c();
                        return;
                    } else if (m == 2) {
                        this.f40550j = m;
                        this.f40545e = qd;
                        this.f40541a.onSubscribe(this);
                        return;
                    }
                }
                this.f40545e = new C13706c(this.f40544d);
                this.f40541a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.f40548h) {
                if (this.f40550j != 2) {
                    this.f40545e.offer(t);
                }
                mo42394c();
            }
        }

        public void onError(Throwable t) {
            if (this.f40548h) {
                C13774a.m43836b(t);
                return;
            }
            this.f40547g = t;
            this.f40548h = true;
            mo42394c();
        }

        public void onComplete() {
            if (!this.f40548h) {
                this.f40548h = true;
                mo42394c();
            }
        }

        public void dispose() {
            if (!this.f40549i) {
                this.f40549i = true;
                this.f40546f.dispose();
                this.f40542b.dispose();
                if (getAndIncrement() == 0) {
                    this.f40545e.clear();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo42394c() {
            if (getAndIncrement() == 0) {
                this.f40542b.mo42694a((Runnable) this);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42393b() {
            int missed = 1;
            SimpleQueue<T> q = this.f40545e;
            Observer<? super T> a = this.f40541a;
            while (!mo42392a(this.f40548h, q.isEmpty(), a)) {
                while (true) {
                    boolean d = this.f40548h;
                    try {
                        T v = q.poll();
                        boolean empty = v == null;
                        if (!mo42392a(d, empty, a)) {
                            if (empty) {
                                missed = addAndGet(-missed);
                                if (missed == 0) {
                                    return;
                                }
                            } else {
                                a.onNext(v);
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable ex) {
                        C13980a.m44462b(ex);
                        this.f40546f.dispose();
                        q.clear();
                        a.onError(ex);
                        this.f40542b.dispose();
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42391a() {
            int missed = 1;
            while (!this.f40549i) {
                boolean d = this.f40548h;
                Throwable ex = this.f40547g;
                if (this.f40543c || !d || ex == null) {
                    this.f40541a.onNext(null);
                    if (d) {
                        Throwable ex2 = this.f40547g;
                        if (ex2 != null) {
                            this.f40541a.onError(ex2);
                        } else {
                            this.f40541a.onComplete();
                        }
                        this.f40542b.dispose();
                        return;
                    }
                    missed = addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                } else {
                    this.f40541a.onError(this.f40547g);
                    this.f40542b.dispose();
                    return;
                }
            }
        }

        public void run() {
            if (this.f40551k) {
                mo42391a();
            } else {
                mo42393b();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo42392a(boolean d, boolean empty, C13804t<? super T> a) {
            if (this.f40549i) {
                this.f40545e.clear();
                return true;
            }
            if (d) {
                Throwable e = this.f40547g;
                if (this.f40543c) {
                    if (empty) {
                        if (e != null) {
                            a.onError(e);
                        } else {
                            a.onComplete();
                        }
                        this.f40542b.dispose();
                        return true;
                    }
                } else if (e != null) {
                    this.f40545e.clear();
                    a.onError(e);
                    this.f40542b.dispose();
                    return true;
                } else if (empty) {
                    a.onComplete();
                    this.f40542b.dispose();
                    return true;
                }
            }
            return false;
        }

        /* renamed from: a */
        public int mo42274a(int mode) {
            if ((mode & 2) == 0) {
                return 0;
            }
            this.f40551k = true;
            return 2;
        }

        public T poll() throws Exception {
            return this.f40545e.poll();
        }

        public void clear() {
            this.f40545e.clear();
        }

        public boolean isEmpty() {
            return this.f40545e.isEmpty();
        }
    }

    public C13338Ea(C13802r<T> source, C13805u scheduler, boolean delayError, int bufferSize) {
        super(source);
        this.f40538b = scheduler;
        this.f40539c = delayError;
        this.f40540d = bufferSize;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        C13805u uVar = this.f40538b;
        if (uVar instanceof C13730o) {
            this.f41005a.subscribe(observer);
            return;
        }
        this.f41005a.subscribe(new C13339a(observer, uVar.mo42242a(), this.f40539c, this.f40540d));
    }
}
