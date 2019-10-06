package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observer;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13805u;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p336f.C13706c;

/* renamed from: f.a.d.e.b.hb */
/* compiled from: ObservableSkipLastTimed */
public final class C13534hb<T> extends C13485a<T, T> {

    /* renamed from: b */
    final long f41156b;

    /* renamed from: c */
    final TimeUnit f41157c;

    /* renamed from: d */
    final C13805u f41158d;

    /* renamed from: e */
    final int f41159e;

    /* renamed from: f */
    final boolean f41160f;

    /* renamed from: f.a.d.e.b.hb$a */
    /* compiled from: ObservableSkipLastTimed */
    static final class C13535a<T> extends AtomicInteger implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41161a;

        /* renamed from: b */
        final long f41162b;

        /* renamed from: c */
        final TimeUnit f41163c;

        /* renamed from: d */
        final C13805u f41164d;

        /* renamed from: e */
        final C13706c<Object> f41165e;

        /* renamed from: f */
        final boolean f41166f;

        /* renamed from: g */
        C13194b f41167g;

        /* renamed from: h */
        volatile boolean f41168h;

        /* renamed from: i */
        volatile boolean f41169i;

        /* renamed from: j */
        Throwable f41170j;

        C13535a(C13804t<? super T> actual, long time, TimeUnit unit, C13805u scheduler, int bufferSize, boolean delayError) {
            this.f41161a = actual;
            this.f41162b = time;
            this.f41163c = unit;
            this.f41164d = scheduler;
            this.f41165e = new C13706c<>(bufferSize);
            this.f41166f = delayError;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41167g, s)) {
                this.f41167g = s;
                this.f41161a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f41165e.mo42689a(Long.valueOf(this.f41164d.mo43147a(this.f41163c)), t);
            mo42564a();
        }

        public void onError(Throwable t) {
            this.f41170j = t;
            this.f41169i = true;
            mo42564a();
        }

        public void onComplete() {
            this.f41169i = true;
            mo42564a();
        }

        public void dispose() {
            if (!this.f41168h) {
                this.f41168h = true;
                this.f41167g.dispose();
                if (getAndIncrement() == 0) {
                    this.f41165e.clear();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42564a() {
            if (getAndIncrement() == 0) {
                int missed = 1;
                Observer<? super T> a = this.f41161a;
                SpscLinkedArrayQueue<Object> q = this.f41165e;
                boolean delayError = this.f41166f;
                TimeUnit unit = this.f41163c;
                C13805u scheduler = this.f41164d;
                long time = this.f41162b;
                while (!this.f41168h) {
                    boolean d = this.f41169i;
                    Long ts = (Long) q.mo42688a();
                    boolean empty = ts == null;
                    long now = scheduler.mo43147a(unit);
                    if (!empty && ts.longValue() > now - time) {
                        empty = true;
                    }
                    if (d) {
                        if (!delayError) {
                            Throwable e = this.f41170j;
                            if (e != null) {
                                this.f41165e.clear();
                                a.onError(e);
                                return;
                            } else if (empty) {
                                a.onComplete();
                                return;
                            }
                        } else if (empty) {
                            Throwable e2 = this.f41170j;
                            if (e2 != null) {
                                a.onError(e2);
                            } else {
                                a.onComplete();
                            }
                            return;
                        }
                    }
                    if (empty) {
                        missed = addAndGet(-missed);
                        if (missed == 0) {
                            return;
                        }
                    } else {
                        q.poll();
                        a.onNext(q.poll());
                    }
                }
                this.f41165e.clear();
            }
        }
    }

    public C13534hb(C13802r<T> source, long time, TimeUnit unit, C13805u scheduler, int bufferSize, boolean delayError) {
        super(source);
        this.f41156b = time;
        this.f41157c = unit;
        this.f41158d = scheduler;
        this.f41159e = bufferSize;
        this.f41160f = delayError;
    }

    public void subscribeActual(C13804t<? super T> t) {
        C13802r<T> rVar = this.f41005a;
        C13535a aVar = new C13535a(t, this.f41156b, this.f41157c, this.f41158d, this.f41159e, this.f41160f);
        rVar.subscribe(aVar);
    }
}
