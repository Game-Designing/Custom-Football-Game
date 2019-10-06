package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observer;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.operators.observable.ObservableMergeWithSingle.MergeWithObserver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.C13812x;
import p320f.p321a.C13814z;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p330c.C13273h;
import p320f.p321a.p327d.p336f.C13706c;
import p320f.p321a.p327d.p340j.C13741c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.Ca */
/* compiled from: ObservableMergeWithSingle */
public final class C13323Ca<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13814z<? extends T> f40470b;

    /* renamed from: f.a.d.e.b.Ca$a */
    /* compiled from: ObservableMergeWithSingle */
    static final class C13324a<T> extends AtomicInteger implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f40471a;

        /* renamed from: b */
        final AtomicReference<C13194b> f40472b = new AtomicReference<>();

        /* renamed from: c */
        final C13325a<T> f40473c = new C13325a<>(this);

        /* renamed from: d */
        final C13741c f40474d = new C13741c();

        /* renamed from: e */
        volatile C13273h<T> f40475e;

        /* renamed from: f */
        T f40476f;

        /* renamed from: g */
        volatile boolean f40477g;

        /* renamed from: h */
        volatile boolean f40478h;

        /* renamed from: i */
        volatile int f40479i;

        /* renamed from: f.a.d.e.b.Ca$a$a */
        /* compiled from: ObservableMergeWithSingle */
        static final class C13325a<T> extends AtomicReference<C13194b> implements C13812x<T> {

            /* renamed from: a */
            final C13324a<T> f40480a;

            C13325a(C13324a<T> parent) {
                this.f40480a = parent;
            }

            public void onSubscribe(C13194b d) {
                C13218c.m43153c(this, d);
            }

            public void onSuccess(T t) {
                this.f40480a.mo42379a(t);
            }

            public void onError(Throwable e) {
                this.f40480a.mo42380a(e);
            }
        }

        C13324a(C13804t<? super T> actual) {
            this.f40471a = actual;
        }

        public void onSubscribe(C13194b d) {
            C13218c.m43153c(this.f40472b, d);
        }

        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                this.f40471a.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                mo42382c().offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            mo42381b();
        }

        public void onError(Throwable ex) {
            if (this.f40474d.mo42733a(ex)) {
                C13218c.m43150a(this.f40472b);
                mo42378a();
                return;
            }
            C13774a.m43836b(ex);
        }

        public void onComplete() {
            this.f40478h = true;
            mo42378a();
        }

        public void dispose() {
            this.f40477g = true;
            C13218c.m43150a(this.f40472b);
            C13218c.m43150a((AtomicReference<C13194b>) this.f40473c);
            if (getAndIncrement() == 0) {
                this.f40475e = null;
                this.f40476f = null;
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42379a(T value) {
            if (compareAndSet(0, 1)) {
                this.f40471a.onNext(value);
                this.f40479i = 2;
            } else {
                this.f40476f = value;
                this.f40479i = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            mo42381b();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42380a(Throwable ex) {
            if (this.f40474d.mo42733a(ex)) {
                C13218c.m43150a(this.f40472b);
                mo42378a();
                return;
            }
            C13774a.m43836b(ex);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public C13273h<T> mo42382c() {
            SimplePlainQueue<T> q = this.f40475e;
            if (q != null) {
                return q;
            }
            C13706c cVar = new C13706c(C13797m.bufferSize());
            this.f40475e = cVar;
            return cVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42378a() {
            if (getAndIncrement() == 0) {
                mo42381b();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42381b() {
            Observer<? super T> actual = this.f40471a;
            int missed = 1;
            while (!this.f40477g) {
                if (this.f40474d.get() != null) {
                    this.f40476f = null;
                    this.f40475e = null;
                    actual.onError(this.f40474d.mo42732a());
                    return;
                }
                int os = this.f40479i;
                boolean empty = true;
                if (os == 1) {
                    T v = this.f40476f;
                    this.f40476f = null;
                    this.f40479i = 2;
                    os = 2;
                    actual.onNext(v);
                }
                boolean d = this.f40478h;
                SimplePlainQueue<T> q = this.f40475e;
                Object poll = q != null ? q.poll() : null;
                if (poll != null) {
                    empty = false;
                }
                if (d && empty && os == 2) {
                    this.f40475e = null;
                    actual.onComplete();
                    return;
                } else if (empty) {
                    missed = addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                } else {
                    actual.onNext(poll);
                }
            }
            this.f40476f = null;
            this.f40475e = null;
        }
    }

    public C13323Ca(C13797m<T> source, C13814z<? extends T> other) {
        super(source);
        this.f40470b = other;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        MergeWithObserver<T> parent = new C13324a<>(observer);
        observer.onSubscribe(parent);
        this.f41005a.subscribe(parent);
        this.f40470b.mo43156a(parent.f40473c);
    }
}
