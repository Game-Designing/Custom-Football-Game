package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableRefCount.ConnectionObserver;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13193a;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p325b.C13195c;
import p320f.p321a.p326c.C13204f;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p341e.C13762a;

/* renamed from: f.a.d.e.b.Oa */
/* compiled from: ObservableRefCount */
public final class C13414Oa<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13762a<? extends T> f40796b;

    /* renamed from: c */
    volatile C13193a f40797c = new C13193a();

    /* renamed from: d */
    final AtomicInteger f40798d = new AtomicInteger();

    /* renamed from: e */
    final ReentrantLock f40799e = new ReentrantLock();

    /* renamed from: f.a.d.e.b.Oa$a */
    /* compiled from: ObservableRefCount */
    final class C13415a extends AtomicReference<C13194b> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f40800a;

        /* renamed from: b */
        final C13193a f40801b;

        /* renamed from: c */
        final C13194b f40802c;

        C13415a(C13804t<? super T> subscriber, C13193a currentBase, C13194b resource) {
            this.f40800a = subscriber;
            this.f40801b = currentBase;
            this.f40802c = resource;
        }

        public void onSubscribe(C13194b s) {
            C13218c.m43153c(this, s);
        }

        public void onError(Throwable e) {
            mo42448a();
            this.f40800a.onError(e);
        }

        public void onNext(T t) {
            this.f40800a.onNext(t);
        }

        public void onComplete() {
            mo42448a();
            this.f40800a.onComplete();
        }

        public void dispose() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
            this.f40802c.dispose();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42448a() {
            C13414Oa.this.f40799e.lock();
            try {
                if (C13414Oa.this.f40797c == this.f40801b) {
                    if (C13414Oa.this.f40796b instanceof C13194b) {
                        ((C13194b) C13414Oa.this.f40796b).dispose();
                    }
                    C13414Oa.this.f40797c.dispose();
                    C13414Oa.this.f40797c = new C13193a();
                    C13414Oa.this.f40798d.set(0);
                }
            } finally {
                C13414Oa.this.f40799e.unlock();
            }
        }
    }

    /* renamed from: f.a.d.e.b.Oa$b */
    /* compiled from: ObservableRefCount */
    final class C13416b implements C13204f<C13194b> {

        /* renamed from: a */
        private final C13804t<? super T> f40804a;

        /* renamed from: b */
        private final AtomicBoolean f40805b;

        C13416b(C13804t<? super T> observer, AtomicBoolean writeLocked) {
            this.f40804a = observer;
            this.f40805b = writeLocked;
        }

        /* renamed from: a */
        public void accept(C13194b subscription) {
            try {
                C13414Oa.this.f40797c.mo42252b(subscription);
                C13414Oa.this.mo42447a(this.f40804a, C13414Oa.this.f40797c);
            } finally {
                C13414Oa.this.f40799e.unlock();
                this.f40805b.set(false);
            }
        }
    }

    /* renamed from: f.a.d.e.b.Oa$c */
    /* compiled from: ObservableRefCount */
    final class C13417c implements Runnable {

        /* renamed from: a */
        private final C13193a f40807a;

        C13417c(C13193a current) {
            this.f40807a = current;
        }

        public void run() {
            C13414Oa.this.f40799e.lock();
            try {
                if (C13414Oa.this.f40797c == this.f40807a && C13414Oa.this.f40798d.decrementAndGet() == 0) {
                    if (C13414Oa.this.f40796b instanceof C13194b) {
                        ((C13194b) C13414Oa.this.f40796b).dispose();
                    }
                    C13414Oa.this.f40797c.dispose();
                    C13414Oa.this.f40797c = new C13193a();
                }
            } finally {
                C13414Oa.this.f40799e.unlock();
            }
        }
    }

    public C13414Oa(C13762a<T> source) {
        super(source);
        this.f40796b = source;
    }

    public void subscribeActual(C13804t<? super T> subscriber) {
        this.f40799e.lock();
        if (this.f40798d.incrementAndGet() == 1) {
            AtomicBoolean writeLocked = new AtomicBoolean(true);
            try {
                this.f40796b.mo42408a(m43352a(subscriber, writeLocked));
            } finally {
                if (writeLocked.get()) {
                    this.f40799e.unlock();
                }
            }
        } else {
            try {
                mo42447a(subscriber, this.f40797c);
            } finally {
                this.f40799e.unlock();
            }
        }
    }

    /* renamed from: a */
    private C13204f<C13194b> m43352a(C13804t<? super T> observer, AtomicBoolean writeLocked) {
        return new C13416b(observer, writeLocked);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo42447a(C13804t<? super T> observer, C13193a currentBase) {
        ConnectionObserver s = new C13415a<>(observer, currentBase, m43351a(currentBase));
        observer.onSubscribe(s);
        this.f40796b.subscribe((C13804t<? super T>) s);
    }

    /* renamed from: a */
    private C13194b m43351a(C13193a current) {
        return C13195c.m43131a(new C13417c(current));
    }
}
