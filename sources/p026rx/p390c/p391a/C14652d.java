package p026rx.p390c.p391a;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0120S.C0122a;
import p026rx.C0125T;
import p026rx.C14980ia;
import p026rx.p028h.C0135f;
import p026rx.p029i.C14978f;

/* renamed from: rx.c.a.d */
/* compiled from: BufferUntilSubscriber */
public final class C14652d<T> extends C0135f<T, T> {

    /* renamed from: b */
    static final C0125T f43624b = new C14646b();

    /* renamed from: c */
    final C14654b<T> f43625c;

    /* renamed from: d */
    private boolean f43626d;

    /* renamed from: rx.c.a.d$a */
    /* compiled from: BufferUntilSubscriber */
    static final class C14653a<T> implements C0122a<T> {

        /* renamed from: a */
        final C14654b<T> f43627a;

        public C14653a(C14654b<T> state) {
            this.f43627a = state;
        }

        /* renamed from: a */
        public void call(C14980ia<? super T> s) {
            if (this.f43627a.mo45809a(null, s)) {
                s.add(C14978f.m46781a(new C14649c(this)));
                boolean win = false;
                synchronized (this.f43627a.f43628a) {
                    if (!this.f43627a.f43629b) {
                        this.f43627a.f43629b = true;
                        win = true;
                    }
                }
                if (win) {
                    while (true) {
                        Object poll = this.f43627a.f43630c.poll();
                        Object o = poll;
                        if (poll != null) {
                            C14689m.m46323a((C0125T) this.f43627a.get(), o);
                        } else {
                            synchronized (this.f43627a.f43628a) {
                                if (this.f43627a.f43630c.isEmpty()) {
                                    this.f43627a.f43629b = false;
                                    return;
                                }
                            }
                        }
                    }
                }
            } else {
                s.onError(new IllegalStateException("Only one subscriber allowed!"));
            }
        }
    }

    /* renamed from: rx.c.a.d$b */
    /* compiled from: BufferUntilSubscriber */
    static final class C14654b<T> extends AtomicReference<C0125T<? super T>> {

        /* renamed from: a */
        final Object f43628a = new Object();

        /* renamed from: b */
        boolean f43629b;

        /* renamed from: c */
        final ConcurrentLinkedQueue<Object> f43630c = new ConcurrentLinkedQueue<>();

        C14654b() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo45809a(C0125T<? super T> expected, C0125T<? super T> next) {
            return compareAndSet(expected, next);
        }
    }

    /* renamed from: p */
    public static <T> C14652d<T> m46293p() {
        return new C14652d<>(new C14654b<>());
    }

    private C14652d(C14654b<T> state) {
        super(new C14653a(state));
        this.f43625c = state;
    }

    /* renamed from: f */
    private void m46292f(Object v) {
        synchronized (this.f43625c.f43628a) {
            this.f43625c.f43630c.add(v);
            if (this.f43625c.get() != null && !this.f43625c.f43629b) {
                this.f43626d = true;
                this.f43625c.f43629b = true;
            }
        }
        if (this.f43626d) {
            while (true) {
                Object poll = this.f43625c.f43630c.poll();
                Object o = poll;
                if (poll != null) {
                    C14689m.m46323a((C0125T) this.f43625c.get(), o);
                } else {
                    return;
                }
            }
        }
    }

    public void onCompleted() {
        if (this.f43626d) {
            ((C0125T) this.f43625c.get()).onCompleted();
        } else {
            m46292f(C14689m.m46320a());
        }
    }

    public void onError(Throwable e) {
        if (this.f43626d) {
            ((C0125T) this.f43625c.get()).onError(e);
        } else {
            m46292f(C14689m.m46321a(e));
        }
    }

    public void onNext(T t) {
        if (this.f43626d) {
            ((C0125T) this.f43625c.get()).onNext(t);
        } else {
            m46292f(C14689m.m46326d(t));
        }
    }
}
