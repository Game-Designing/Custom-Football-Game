package p320f.p321a.p327d.p332e.p333a;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import p024io.reactivex.exceptions.C13980a;
import p024io.reactivex.exceptions.MissingBackpressureException;
import p320f.p321a.C13764f;
import p320f.p321a.C13773g;
import p320f.p321a.p326c.C13199a;
import p320f.p321a.p327d.p330c.C13273h;
import p320f.p321a.p327d.p336f.C13705b;
import p320f.p321a.p327d.p336f.C13706c;
import p320f.p321a.p327d.p339i.C13736a;
import p320f.p321a.p327d.p339i.C13737b;
import p320f.p321a.p327d.p340j.C13742d;
import p363i.p368b.C14229b;
import p363i.p368b.C14230c;

/* renamed from: f.a.d.e.a.c */
/* compiled from: FlowableOnBackpressureBuffer */
public final class C13298c<T> extends C13295a<T, T> {

    /* renamed from: c */
    final int f40403c;

    /* renamed from: d */
    final boolean f40404d;

    /* renamed from: e */
    final boolean f40405e;

    /* renamed from: f */
    final C13199a f40406f;

    /* renamed from: f.a.d.e.a.c$a */
    /* compiled from: FlowableOnBackpressureBuffer */
    static final class C13299a<T> extends C13736a<T> implements C13773g<T> {

        /* renamed from: a */
        final C14229b<? super T> f40407a;

        /* renamed from: b */
        final C13273h<T> f40408b;

        /* renamed from: c */
        final boolean f40409c;

        /* renamed from: d */
        final C13199a f40410d;

        /* renamed from: e */
        C14230c f40411e;

        /* renamed from: f */
        volatile boolean f40412f;

        /* renamed from: g */
        volatile boolean f40413g;

        /* renamed from: h */
        Throwable f40414h;

        /* renamed from: i */
        final AtomicLong f40415i = new AtomicLong();

        /* renamed from: j */
        boolean f40416j;

        C13299a(C14229b<? super T> actual, int bufferSize, boolean unbounded, boolean delayError, C13199a onOverflow) {
            SimplePlainQueue<T> q;
            this.f40407a = actual;
            this.f40410d = onOverflow;
            this.f40409c = delayError;
            if (unbounded) {
                q = new C13706c<>(bufferSize);
            } else {
                q = new C13705b<>(bufferSize);
            }
            this.f40408b = q;
        }

        /* renamed from: a */
        public void mo42355a(C14230c s) {
            if (C13737b.m43736a(this.f40411e, s)) {
                this.f40411e = s;
                this.f40407a.mo42355a(this);
                s.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            if (!this.f40408b.offer(t)) {
                this.f40411e.cancel();
                MissingBackpressureException ex = new MissingBackpressureException("Buffer is full");
                try {
                    this.f40410d.run();
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    ex.initCause(e);
                }
                onError(ex);
                return;
            }
            if (this.f40416j) {
                this.f40407a.onNext(null);
            } else {
                mo42354a();
            }
        }

        public void onError(Throwable t) {
            this.f40414h = t;
            this.f40413g = true;
            if (this.f40416j) {
                this.f40407a.onError(t);
            } else {
                mo42354a();
            }
        }

        public void onComplete() {
            this.f40413g = true;
            if (this.f40416j) {
                this.f40407a.onComplete();
            } else {
                mo42354a();
            }
        }

        public void request(long n) {
            if (!this.f40416j && C13737b.m43735a(n)) {
                C13742d.m43750a(this.f40415i, n);
                mo42354a();
            }
        }

        public void cancel() {
            if (!this.f40412f) {
                this.f40412f = true;
                this.f40411e.cancel();
                if (getAndIncrement() == 0) {
                    this.f40408b.clear();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42354a() {
            if (getAndIncrement() == 0) {
                int missed = 1;
                SimplePlainQueue<T> q = this.f40408b;
                Subscriber<? super T> a = this.f40407a;
                while (!mo42356a(this.f40413g, q.isEmpty(), a)) {
                    long r = this.f40415i.get();
                    long e = 0;
                    while (e != r) {
                        boolean d = this.f40413g;
                        T v = q.poll();
                        boolean empty = v == null;
                        if (!mo42356a(d, empty, a)) {
                            if (empty) {
                                break;
                            }
                            a.onNext(v);
                            e++;
                        } else {
                            return;
                        }
                    }
                    if (e != r || !mo42356a(this.f40413g, q.isEmpty(), a)) {
                        if (!(e == 0 || r == Long.MAX_VALUE)) {
                            this.f40415i.addAndGet(-e);
                        }
                        missed = addAndGet(-missed);
                        if (missed == 0) {
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo42356a(boolean d, boolean empty, C14229b<? super T> a) {
            if (this.f40412f) {
                this.f40408b.clear();
                return true;
            }
            if (d) {
                if (!this.f40409c) {
                    Throwable e = this.f40414h;
                    if (e != null) {
                        this.f40408b.clear();
                        a.onError(e);
                        return true;
                    } else if (empty) {
                        a.onComplete();
                        return true;
                    }
                } else if (empty) {
                    Throwable e2 = this.f40414h;
                    if (e2 != null) {
                        a.onError(e2);
                    } else {
                        a.onComplete();
                    }
                    return true;
                }
            }
            return false;
        }

        public T poll() throws Exception {
            return this.f40408b.poll();
        }

        public void clear() {
            this.f40408b.clear();
        }

        public boolean isEmpty() {
            return this.f40408b.isEmpty();
        }
    }

    public C13298c(C13764f<T> source, int bufferSize, boolean unbounded, boolean delayError, C13199a onOverflow) {
        super(source);
        this.f40403c = bufferSize;
        this.f40404d = unbounded;
        this.f40405e = delayError;
        this.f40406f = onOverflow;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42351b(C14229b<? super T> s) {
        C13764f<T> fVar = this.f40399b;
        C13299a aVar = new C13299a(s, this.f40403c, this.f40404d, this.f40405e, this.f40406f);
        fVar.mo42780a((C13773g<? super T>) aVar);
    }
}
