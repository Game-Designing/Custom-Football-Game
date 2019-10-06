package p026rx.p390c.p391a;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import p026rx.C0120S.C0123b;
import p026rx.C14508U;
import p026rx.C14513a;
import p026rx.C14513a.C14517d;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.exceptions.MissingBackpressureException;
import p026rx.p027b.C0128a;
import p026rx.p390c.p395e.C14866c;
import p026rx.p390c.p395e.C14866c.C14867a;
import rx.internal.operators.OperatorOnBackpressureBuffer.BufferSubscriber;

/* renamed from: rx.c.a.Ba */
/* compiled from: OperatorOnBackpressureBuffer */
public class C14560Ba<T> implements C0123b<T, T> {

    /* renamed from: a */
    private final Long f43390a = null;

    /* renamed from: b */
    private final C0128a f43391b = null;

    /* renamed from: c */
    private final C14517d f43392c = C14513a.f43328b;

    /* renamed from: rx.c.a.Ba$a */
    /* compiled from: OperatorOnBackpressureBuffer */
    static final class C14561a<T> extends C14980ia<T> implements C14867a {

        /* renamed from: a */
        private final ConcurrentLinkedQueue<Object> f43393a = new ConcurrentLinkedQueue<>();

        /* renamed from: b */
        private final AtomicLong f43394b;

        /* renamed from: c */
        private final C14980ia<? super T> f43395c;

        /* renamed from: d */
        private final AtomicBoolean f43396d = new AtomicBoolean(false);

        /* renamed from: e */
        private final C14866c f43397e;

        /* renamed from: f */
        private final C0128a f43398f;

        /* renamed from: g */
        private final C14517d f43399g;

        public C14561a(C14980ia<? super T> child, Long capacity, C0128a onOverflow, C14517d overflowStrategy) {
            this.f43395c = child;
            this.f43394b = capacity != null ? new AtomicLong(capacity.longValue()) : null;
            this.f43398f = onOverflow;
            this.f43397e = new C14866c(this);
            this.f43399g = overflowStrategy;
        }

        public void onStart() {
            request(Long.MAX_VALUE);
        }

        public void onCompleted() {
            if (!this.f43396d.get()) {
                this.f43397e.mo46075b();
            }
        }

        public void onError(Throwable e) {
            if (!this.f43396d.get()) {
                this.f43397e.mo46074a(e);
            }
        }

        public void onNext(T t) {
            if (m46199b()) {
                this.f43393a.offer(C14689m.m46326d(t));
                this.f43397e.mo46073a();
            }
        }

        public boolean accept(Object value) {
            return C14689m.m46323a(this.f43395c, value);
        }

        /* renamed from: a */
        public void mo45737a(Throwable exception) {
            if (exception != null) {
                this.f43395c.onError(exception);
            } else {
                this.f43395c.onCompleted();
            }
        }

        public Object peek() {
            return this.f43393a.peek();
        }

        public Object poll() {
            Object value = this.f43393a.poll();
            AtomicLong atomicLong = this.f43394b;
            if (!(atomicLong == null || value == null)) {
                atomicLong.incrementAndGet();
            }
            return value;
        }

        /* renamed from: b */
        private boolean m46199b() {
            long currCapacity;
            if (this.f43394b == null) {
                return true;
            }
            do {
                currCapacity = this.f43394b.get();
                if (currCapacity <= 0) {
                    boolean hasCapacity = false;
                    try {
                        hasCapacity = this.f43399g.mo45715a() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.f43396d.compareAndSet(false, true)) {
                            unsubscribe();
                            this.f43395c.onError(e);
                        }
                    }
                    C0128a aVar = this.f43398f;
                    if (aVar != null) {
                        try {
                            aVar.call();
                        } catch (Throwable e2) {
                            C14927a.m46678c(e2);
                            this.f43397e.mo46074a(e2);
                            return false;
                        }
                    }
                    if (!hasCapacity) {
                        return false;
                    }
                }
            } while (!this.f43394b.compareAndSet(currCapacity, currCapacity - 1));
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C14508U mo45736a() {
            return this.f43397e;
        }
    }

    /* renamed from: rx.c.a.Ba$b */
    /* compiled from: OperatorOnBackpressureBuffer */
    static final class C14562b {

        /* renamed from: a */
        static final C14560Ba<?> f43400a = new C14560Ba<>();
    }

    /* renamed from: a */
    public static <T> C14560Ba<T> m46197a() {
        return C14562b.f43400a;
    }

    C14560Ba() {
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super T> child) {
        BufferSubscriber<T> parent = new C14561a<>(child, this.f43390a, this.f43391b, this.f43392c);
        child.add(parent);
        child.setProducer(parent.mo45736a());
        return parent;
    }
}
