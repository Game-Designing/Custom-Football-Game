package p320f.p321a.p327d.p332e.p333a;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import p320f.p321a.C13764f;
import p320f.p321a.C13773g;
import p320f.p321a.p327d.p339i.C13737b;
import p320f.p321a.p327d.p340j.C13742d;
import p363i.p368b.C14229b;
import p363i.p368b.C14230c;

/* renamed from: f.a.d.e.a.f */
/* compiled from: FlowableOnBackpressureLatest */
public final class C13304f<T> extends C13295a<T, T> {

    /* renamed from: f.a.d.e.a.f$a */
    /* compiled from: FlowableOnBackpressureLatest */
    static final class C13305a<T> extends AtomicInteger implements C13773g<T>, C14230c {

        /* renamed from: a */
        final C14229b<? super T> f40425a;

        /* renamed from: b */
        C14230c f40426b;

        /* renamed from: c */
        volatile boolean f40427c;

        /* renamed from: d */
        Throwable f40428d;

        /* renamed from: e */
        volatile boolean f40429e;

        /* renamed from: f */
        final AtomicLong f40430f = new AtomicLong();

        /* renamed from: g */
        final AtomicReference<T> f40431g = new AtomicReference<>();

        C13305a(C14229b<? super T> actual) {
            this.f40425a = actual;
        }

        /* renamed from: a */
        public void mo42355a(C14230c s) {
            if (C13737b.m43736a(this.f40426b, s)) {
                this.f40426b = s;
                this.f40425a.mo42355a(this);
                s.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            this.f40431g.lazySet(t);
            mo42360a();
        }

        public void onError(Throwable t) {
            this.f40428d = t;
            this.f40427c = true;
            mo42360a();
        }

        public void onComplete() {
            this.f40427c = true;
            mo42360a();
        }

        public void request(long n) {
            if (C13737b.m43735a(n)) {
                C13742d.m43750a(this.f40430f, n);
                mo42360a();
            }
        }

        public void cancel() {
            if (!this.f40429e) {
                this.f40429e = true;
                this.f40426b.cancel();
                if (getAndIncrement() == 0) {
                    this.f40431g.lazySet(null);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42360a() {
            boolean z;
            if (getAndIncrement() == 0) {
                Subscriber<? super T> a = this.f40425a;
                int missed = 1;
                AtomicLong r = this.f40430f;
                AtomicReference<T> q = this.f40431g;
                do {
                    long e = 0;
                    while (true) {
                        z = true;
                        if (e == r.get()) {
                            break;
                        }
                        boolean d = this.f40427c;
                        T v = q.getAndSet(null);
                        boolean empty = v == null;
                        if (!mo42361a(d, empty, a, q)) {
                            if (empty) {
                                break;
                            }
                            a.onNext(v);
                            e++;
                        } else {
                            return;
                        }
                    }
                    if (e == r.get()) {
                        boolean z2 = this.f40427c;
                        if (q.get() != null) {
                            z = false;
                        }
                        if (mo42361a(z2, z, a, q)) {
                            return;
                        }
                    }
                    if (e != 0) {
                        C13742d.m43751b(r, e);
                    }
                    missed = addAndGet(-missed);
                } while (missed != 0);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo42361a(boolean d, boolean empty, C14229b<?> a, AtomicReference<T> q) {
            if (this.f40429e) {
                q.lazySet(null);
                return true;
            }
            if (d) {
                Throwable e = this.f40428d;
                if (e != null) {
                    q.lazySet(null);
                    a.onError(e);
                    return true;
                } else if (empty) {
                    a.onComplete();
                    return true;
                }
            }
            return false;
        }
    }

    public C13304f(C13764f<T> source) {
        super(source);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42351b(C14229b<? super T> s) {
        this.f40399b.mo42780a((C13773g<? super T>) new C13305a<Object>(s));
    }
}
