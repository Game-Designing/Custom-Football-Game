package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observer;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13805u;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p336f.C13706c;

/* renamed from: f.a.d.e.b.qb */
/* compiled from: ObservableTakeLastTimed */
public final class C13619qb<T> extends C13485a<T, T> {

    /* renamed from: b */
    final long f41441b;

    /* renamed from: c */
    final long f41442c;

    /* renamed from: d */
    final TimeUnit f41443d;

    /* renamed from: e */
    final C13805u f41444e;

    /* renamed from: f */
    final int f41445f;

    /* renamed from: g */
    final boolean f41446g;

    /* renamed from: f.a.d.e.b.qb$a */
    /* compiled from: ObservableTakeLastTimed */
    static final class C13620a<T> extends AtomicBoolean implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41447a;

        /* renamed from: b */
        final long f41448b;

        /* renamed from: c */
        final long f41449c;

        /* renamed from: d */
        final TimeUnit f41450d;

        /* renamed from: e */
        final C13805u f41451e;

        /* renamed from: f */
        final C13706c<Object> f41452f;

        /* renamed from: g */
        final boolean f41453g;

        /* renamed from: h */
        C13194b f41454h;

        /* renamed from: i */
        volatile boolean f41455i;

        /* renamed from: j */
        Throwable f41456j;

        C13620a(C13804t<? super T> actual, long count, long time, TimeUnit unit, C13805u scheduler, int bufferSize, boolean delayError) {
            this.f41447a = actual;
            this.f41448b = count;
            this.f41449c = time;
            this.f41450d = unit;
            this.f41451e = scheduler;
            this.f41452f = new C13706c<>(bufferSize);
            this.f41453g = delayError;
        }

        public void onSubscribe(C13194b d) {
            if (C13218c.m43149a(this.f41454h, d)) {
                this.f41454h = d;
                this.f41447a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            SpscLinkedArrayQueue<Object> q = this.f41452f;
            long now = this.f41451e.mo43147a(this.f41450d);
            long time = this.f41449c;
            long c = this.f41448b;
            boolean unbounded = c == Long.MAX_VALUE;
            q.mo42689a(Long.valueOf(now), t);
            while (!q.isEmpty()) {
                if (((Long) q.mo42688a()).longValue() <= now - time || (!unbounded && ((long) (q.mo42690b() >> 1)) > c)) {
                    q.poll();
                    q.poll();
                } else {
                    return;
                }
            }
        }

        public void onError(Throwable t) {
            this.f41456j = t;
            mo42626a();
        }

        public void onComplete() {
            mo42626a();
        }

        public void dispose() {
            if (!this.f41455i) {
                this.f41455i = true;
                this.f41454h.dispose();
                if (compareAndSet(false, true)) {
                    this.f41452f.clear();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42626a() {
            if (compareAndSet(false, true)) {
                Observer<? super T> a = this.f41447a;
                SpscLinkedArrayQueue<Object> q = this.f41452f;
                boolean delayError = this.f41453g;
                while (!this.f41455i) {
                    if (!delayError) {
                        Throwable ex = this.f41456j;
                        if (ex != null) {
                            q.clear();
                            a.onError(ex);
                            return;
                        }
                    }
                    Object ts = q.poll();
                    if (ts == null) {
                        Throwable ex2 = this.f41456j;
                        if (ex2 != null) {
                            a.onError(ex2);
                        } else {
                            a.onComplete();
                        }
                        return;
                    }
                    T o = q.poll();
                    if (((Long) ts).longValue() >= this.f41451e.mo43147a(this.f41450d) - this.f41449c) {
                        a.onNext(o);
                    }
                }
                q.clear();
            }
        }
    }

    public C13619qb(C13802r<T> source, long count, long time, TimeUnit unit, C13805u scheduler, int bufferSize, boolean delayError) {
        super(source);
        this.f41441b = count;
        this.f41442c = time;
        this.f41443d = unit;
        this.f41444e = scheduler;
        this.f41445f = bufferSize;
        this.f41446g = delayError;
    }

    public void subscribeActual(C13804t<? super T> t) {
        C13802r<T> rVar = this.f41005a;
        C13620a aVar = new C13620a(t, this.f41441b, this.f41442c, this.f41443d, this.f41444e, this.f41445f, this.f41446g);
        rVar.subscribe(aVar);
    }
}
