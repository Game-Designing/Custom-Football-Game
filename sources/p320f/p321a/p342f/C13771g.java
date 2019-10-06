package p320f.p321a.p342f;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13198c;
import p320f.p321a.C13787i;
import p320f.p321a.C13804t;
import p320f.p321a.C13812x;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p330c.C13269d;

/* renamed from: f.a.f.g */
/* compiled from: TestObserver */
public class C13771g<T> extends C13765a<T, C13771g<T>> implements C13804t<T>, C13194b, C13787i<T>, C13812x<T>, C13198c {

    /* renamed from: i */
    private final C13804t<? super T> f41896i;

    /* renamed from: j */
    private final AtomicReference<C13194b> f41897j;

    /* renamed from: k */
    private C13269d<T> f41898k;

    /* renamed from: f.a.f.g$a */
    /* compiled from: TestObserver */
    enum C13772a implements C13804t<Object> {
        INSTANCE;

        public void onSubscribe(C13194b d) {
        }

        public void onNext(Object t) {
        }

        public void onError(Throwable t) {
        }

        public void onComplete() {
        }
    }

    public C13771g() {
        this(C13772a.INSTANCE);
    }

    public C13771g(C13804t<? super T> actual) {
        this.f41897j = new AtomicReference<>();
        this.f41896i = actual;
    }

    public void onSubscribe(C13194b s) {
        this.f41881e = Thread.currentThread();
        if (s == null) {
            this.f41879c.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!this.f41897j.compareAndSet(null, s)) {
            s.dispose();
            if (this.f41897j.get() != C13218c.DISPOSED) {
                List<Throwable> list = this.f41879c;
                StringBuilder sb = new StringBuilder();
                sb.append("onSubscribe received multiple subscriptions: ");
                sb.append(s);
                list.add(new IllegalStateException(sb.toString()));
            }
        } else {
            int i = this.f41883g;
            if (i != 0 && (s instanceof C13269d)) {
                this.f41898k = (C13269d) s;
                int m = this.f41898k.mo42274a(i);
                this.f41884h = m;
                if (m == 1) {
                    this.f41882f = true;
                    this.f41881e = Thread.currentThread();
                    while (true) {
                        try {
                            Object poll = this.f41898k.poll();
                            Object obj = poll;
                            if (poll == null) {
                                break;
                            }
                            this.f41878b.add(obj);
                        } catch (Throwable ex) {
                            this.f41879c.add(ex);
                        }
                    }
                    this.f41880d++;
                    this.f41897j.lazySet(C13218c.DISPOSED);
                    return;
                }
            }
            this.f41896i.onSubscribe(s);
        }
    }

    public void onNext(T t) {
        if (!this.f41882f) {
            this.f41882f = true;
            if (this.f41897j.get() == null) {
                this.f41879c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f41881e = Thread.currentThread();
        if (this.f41884h == 2) {
            while (true) {
                try {
                    Object poll = this.f41898k.poll();
                    Object obj = poll;
                    if (poll == null) {
                        break;
                    }
                    this.f41878b.add(obj);
                } catch (Throwable ex) {
                    this.f41879c.add(ex);
                    this.f41898k.dispose();
                }
            }
            return;
        }
        this.f41878b.add(t);
        if (t == null) {
            this.f41879c.add(new NullPointerException("onNext received a null value"));
        }
        this.f41896i.onNext(t);
    }

    public void onError(Throwable t) {
        if (!this.f41882f) {
            this.f41882f = true;
            if (this.f41897j.get() == null) {
                this.f41879c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f41881e = Thread.currentThread();
            if (t == null) {
                this.f41879c.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f41879c.add(t);
            }
            this.f41896i.onError(t);
        } finally {
            this.f41877a.countDown();
        }
    }

    public void onComplete() {
        if (!this.f41882f) {
            this.f41882f = true;
            if (this.f41897j.get() == null) {
                this.f41879c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f41881e = Thread.currentThread();
            this.f41880d++;
            this.f41896i.onComplete();
        } finally {
            this.f41877a.countDown();
        }
    }

    public final void dispose() {
        C13218c.m43150a(this.f41897j);
    }

    public void onSuccess(T value) {
        onNext(value);
        onComplete();
    }
}
