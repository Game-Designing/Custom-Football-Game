package p320f.p321a.p327d.p332e.p334b;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable;
import io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver;
import io.reactivex.internal.operators.observable.ObserverResourceWrapper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13805u;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13204f;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p330c.C13267b;
import p320f.p321a.p327d.p340j.C13753n;
import p320f.p321a.p341e.C13762a;
import p320f.p321a.p343g.C13774a;
import p320f.p321a.p344h.C13786c;

/* renamed from: f.a.d.e.b.Sa */
/* compiled from: ObservableReplay */
public final class C13430Sa<T> extends C13762a<T> implements C13267b<T>, C13194b {

    /* renamed from: a */
    static final C13432b f40848a = new C13445o();

    /* renamed from: b */
    final C13802r<T> f40849b;

    /* renamed from: c */
    final AtomicReference<C13440j<T>> f40850c;

    /* renamed from: d */
    final C13432b<T> f40851d;

    /* renamed from: e */
    final C13802r<T> f40852e;

    /* renamed from: f.a.d.e.b.Sa$a */
    /* compiled from: ObservableReplay */
    static abstract class C13431a<T> extends AtomicReference<C13436f> implements C13438h<T> {

        /* renamed from: a */
        C13436f f40853a;

        /* renamed from: b */
        int f40854b;

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public abstract void mo42468d();

        C13431a() {
            C13436f n = new C13436f(null);
            this.f40853a = n;
            set(n);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final void mo42460a(C13436f n) {
            this.f40853a.set(n);
            this.f40853a = n;
            this.f40854b++;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public final void mo42467c() {
            C13436f next = (C13436f) ((C13436f) get()).get();
            this.f40854b--;
            mo42465b(next);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public final void mo42465b(C13436f n) {
            set(n);
        }

        /* renamed from: a */
        public final void mo42461a(T value) {
            C13753n.m43785g(value);
            mo42460a(new C13436f(mo42464b((Object) value)));
            mo42468d();
        }

        /* renamed from: a */
        public final void mo42462a(Throwable e) {
            mo42460a(new C13436f(mo42464b(C13753n.m43776a(e))));
            mo42469e();
        }

        /* renamed from: a */
        public final void mo42458a() {
            mo42460a(new C13436f(mo42464b(C13753n.m43782e())));
            mo42469e();
        }

        /* renamed from: a */
        public final void mo42459a(C13434d<T> output) {
            if (output.getAndIncrement() == 0) {
                int missed = 1;
                do {
                    C13436f node = (C13436f) output.mo42472a();
                    if (node == null) {
                        node = mo42463b();
                        output.f40858c = node;
                    }
                    while (!output.mo42473b()) {
                        C13436f v = (C13436f) node.get();
                        if (v == null) {
                            output.f40858c = node;
                            missed = output.addAndGet(-missed);
                        } else if (C13753n.m43777a(mo42466c(v.f40862a), output.f40857b)) {
                            output.f40858c = null;
                            return;
                        } else {
                            node = v;
                        }
                    }
                    return;
                } while (missed != 0);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public Object mo42464b(Object value) {
            return value;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public Object mo42466c(Object value) {
            return value;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo42469e() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C13436f mo42463b() {
            return (C13436f) get();
        }
    }

    /* renamed from: f.a.d.e.b.Sa$b */
    /* compiled from: ObservableReplay */
    interface C13432b<T> {
        C13438h<T> call();
    }

    /* renamed from: f.a.d.e.b.Sa$c */
    /* compiled from: ObservableReplay */
    static final class C13433c<R> implements C13204f<C13194b> {

        /* renamed from: a */
        private final C13408Mb<R> f40855a;

        C13433c(C13408Mb<R> srw) {
            this.f40855a = srw;
        }

        /* renamed from: a */
        public void accept(C13194b r) {
            this.f40855a.mo42445a(r);
        }
    }

    /* renamed from: f.a.d.e.b.Sa$d */
    /* compiled from: ObservableReplay */
    static final class C13434d<T> extends AtomicInteger implements C13194b {

        /* renamed from: a */
        final C13440j<T> f40856a;

        /* renamed from: b */
        final C13804t<? super T> f40857b;

        /* renamed from: c */
        Object f40858c;

        /* renamed from: d */
        volatile boolean f40859d;

        C13434d(C13440j<T> parent, C13804t<? super T> child) {
            this.f40856a = parent;
            this.f40857b = child;
        }

        /* renamed from: b */
        public boolean mo42473b() {
            return this.f40859d;
        }

        public void dispose() {
            if (!this.f40859d) {
                this.f40859d = true;
                this.f40856a.mo42477b(this);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public <U> U mo42472a() {
            return this.f40858c;
        }
    }

    /* renamed from: f.a.d.e.b.Sa$e */
    /* compiled from: ObservableReplay */
    static final class C13435e<R, U> extends C13797m<R> {

        /* renamed from: a */
        private final Callable<? extends C13762a<U>> f40860a;

        /* renamed from: b */
        private final C13212n<? super C13797m<U>, ? extends C13802r<R>> f40861b;

        C13435e(Callable<? extends C13762a<U>> connectableFactory, C13212n<? super C13797m<U>, ? extends C13802r<R>> selector) {
            this.f40860a = connectableFactory;
            this.f40861b = selector;
        }

        /* access modifiers changed from: protected */
        public void subscribeActual(C13804t<? super R> child) {
            try {
                Object call = this.f40860a.call();
                C13264b.m43226a(call, "The connectableFactory returned a null ConnectableObservable");
                ConnectableObservable<U> co = (C13762a) call;
                Object apply = this.f40861b.apply(co);
                C13264b.m43226a(apply, "The selector returned a null ObservableSource");
                ObservableSource<R> observable = (C13802r) apply;
                ObserverResourceWrapper<R> srw = new C13408Mb<>(child);
                observable.subscribe(srw);
                co.mo42408a(new C13433c(srw));
            } catch (Throwable e) {
                C13980a.m44462b(e);
                C13219d.m43157a(e, child);
            }
        }
    }

    /* renamed from: f.a.d.e.b.Sa$f */
    /* compiled from: ObservableReplay */
    static final class C13436f extends AtomicReference<C13436f> {

        /* renamed from: a */
        final Object f40862a;

        C13436f(Object value) {
            this.f40862a = value;
        }
    }

    /* renamed from: f.a.d.e.b.Sa$g */
    /* compiled from: ObservableReplay */
    static final class C13437g<T> extends C13762a<T> {

        /* renamed from: a */
        private final C13762a<T> f40863a;

        /* renamed from: b */
        private final C13797m<T> f40864b;

        C13437g(C13762a<T> co, C13797m<T> observable) {
            this.f40863a = co;
            this.f40864b = observable;
        }

        /* renamed from: a */
        public void mo42408a(C13204f<? super C13194b> connection) {
            this.f40863a.mo42408a(connection);
        }

        /* access modifiers changed from: protected */
        public void subscribeActual(C13804t<? super T> observer) {
            this.f40864b.subscribe(observer);
        }
    }

    /* renamed from: f.a.d.e.b.Sa$h */
    /* compiled from: ObservableReplay */
    interface C13438h<T> {
        /* renamed from: a */
        void mo42458a();

        /* renamed from: a */
        void mo42459a(C13434d<T> dVar);

        /* renamed from: a */
        void mo42461a(T t);

        /* renamed from: a */
        void mo42462a(Throwable th);
    }

    /* renamed from: f.a.d.e.b.Sa$i */
    /* compiled from: ObservableReplay */
    static final class C13439i<T> implements C13432b<T> {

        /* renamed from: a */
        private final int f40865a;

        C13439i(int bufferSize) {
            this.f40865a = bufferSize;
        }

        public C13438h<T> call() {
            return new C13444n(this.f40865a);
        }
    }

    /* renamed from: f.a.d.e.b.Sa$j */
    /* compiled from: ObservableReplay */
    static final class C13440j<T> extends AtomicReference<C13194b> implements C13804t<T>, C13194b {

        /* renamed from: a */
        static final C13434d[] f40866a = new C13434d[0];

        /* renamed from: b */
        static final C13434d[] f40867b = new C13434d[0];

        /* renamed from: c */
        final C13438h<T> f40868c;

        /* renamed from: d */
        boolean f40869d;

        /* renamed from: e */
        final AtomicReference<C13434d[]> f40870e = new AtomicReference<>(f40866a);

        /* renamed from: f */
        final AtomicBoolean f40871f = new AtomicBoolean();

        C13440j(C13438h<T> buffer) {
            this.f40868c = buffer;
        }

        /* renamed from: a */
        public boolean mo42474a() {
            return this.f40870e.get() == f40867b;
        }

        public void dispose() {
            this.f40870e.set(f40867b);
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo42475a(C13434d<T> producer) {
            C13434d[] c;
            C13434d[] u;
            do {
                c = (C13434d[]) this.f40870e.get();
                if (c == f40867b) {
                    return false;
                }
                int len = c.length;
                u = new C13434d[(len + 1)];
                System.arraycopy(c, 0, u, 0, len);
                u[len] = producer;
            } while (!this.f40870e.compareAndSet(c, u));
            return true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42477b(C13434d<T> producer) {
            C13434d[] c;
            C13434d[] u;
            do {
                c = (C13434d[]) this.f40870e.get();
                int len = c.length;
                if (len != 0) {
                    int j = -1;
                    int i = 0;
                    while (true) {
                        if (i >= len) {
                            break;
                        } else if (c[i].equals(producer)) {
                            j = i;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (j >= 0) {
                        if (len == 1) {
                            u = f40866a;
                        } else {
                            C13434d[] u2 = new C13434d[(len - 1)];
                            System.arraycopy(c, 0, u2, 0, j);
                            System.arraycopy(c, j + 1, u2, j, (len - j) - 1);
                            u = u2;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.f40870e.compareAndSet(c, u));
        }

        public void onSubscribe(C13194b p) {
            if (C13218c.m43153c(this, p)) {
                mo42476b();
            }
        }

        public void onNext(T t) {
            if (!this.f40869d) {
                this.f40868c.mo42461a(t);
                mo42476b();
            }
        }

        public void onError(Throwable e) {
            if (!this.f40869d) {
                this.f40869d = true;
                this.f40868c.mo42462a(e);
                mo42478c();
                return;
            }
            C13774a.m43836b(e);
        }

        public void onComplete() {
            if (!this.f40869d) {
                this.f40869d = true;
                this.f40868c.mo42458a();
                mo42478c();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42476b() {
            for (InnerDisposable<T> rp : (C13434d[]) this.f40870e.get()) {
                this.f40868c.mo42459a((C13434d<T>) rp);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo42478c() {
            for (InnerDisposable<T> rp : (C13434d[]) this.f40870e.getAndSet(f40867b)) {
                this.f40868c.mo42459a((C13434d<T>) rp);
            }
        }
    }

    /* renamed from: f.a.d.e.b.Sa$k */
    /* compiled from: ObservableReplay */
    static final class C13441k<T> implements C13802r<T> {

        /* renamed from: a */
        private final AtomicReference<C13440j<T>> f40872a;

        /* renamed from: b */
        private final C13432b<T> f40873b;

        C13441k(AtomicReference<C13440j<T>> curr, C13432b<T> bufferFactory) {
            this.f40872a = curr;
            this.f40873b = bufferFactory;
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void subscribe(p320f.p321a.C13804t<? super T> r6) {
            /*
                r5 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference<f.a.d.e.b.Sa$j<T>> r0 = r5.f40872a
                java.lang.Object r0 = r0.get()
                f.a.d.e.b.Sa$j r0 = (p320f.p321a.p327d.p332e.p334b.C13430Sa.C13440j) r0
                if (r0 != 0) goto L_0x0020
                f.a.d.e.b.Sa$b<T> r1 = r5.f40873b
                f.a.d.e.b.Sa$h r1 = r1.call()
                f.a.d.e.b.Sa$j r2 = new f.a.d.e.b.Sa$j
                r2.<init>(r1)
                java.util.concurrent.atomic.AtomicReference<f.a.d.e.b.Sa$j<T>> r3 = r5.f40872a
                r4 = 0
                boolean r3 = r3.compareAndSet(r4, r2)
                if (r3 != 0) goto L_0x001f
                goto L_0x0000
            L_0x001f:
                r0 = r2
            L_0x0020:
                f.a.d.e.b.Sa$d r1 = new f.a.d.e.b.Sa$d
                r1.<init>(r0, r6)
                r6.onSubscribe(r1)
                r0.mo42475a(r1)
                boolean r2 = r1.mo42473b()
                if (r2 == 0) goto L_0x0035
                r0.mo42477b(r1)
                return
            L_0x0035:
                f.a.d.e.b.Sa$h<T> r2 = r0.f40868c
                r2.mo42459a(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p320f.p321a.p327d.p332e.p334b.C13430Sa.C13441k.subscribe(f.a.t):void");
        }
    }

    /* renamed from: f.a.d.e.b.Sa$l */
    /* compiled from: ObservableReplay */
    static final class C13442l<T> implements C13432b<T> {

        /* renamed from: a */
        private final int f40874a;

        /* renamed from: b */
        private final long f40875b;

        /* renamed from: c */
        private final TimeUnit f40876c;

        /* renamed from: d */
        private final C13805u f40877d;

        C13442l(int bufferSize, long maxAge, TimeUnit unit, C13805u scheduler) {
            this.f40874a = bufferSize;
            this.f40875b = maxAge;
            this.f40876c = unit;
            this.f40877d = scheduler;
        }

        public C13438h<T> call() {
            C13443m mVar = new C13443m(this.f40874a, this.f40875b, this.f40876c, this.f40877d);
            return mVar;
        }
    }

    /* renamed from: f.a.d.e.b.Sa$m */
    /* compiled from: ObservableReplay */
    static final class C13443m<T> extends C13431a<T> {

        /* renamed from: c */
        final C13805u f40878c;

        /* renamed from: d */
        final long f40879d;

        /* renamed from: e */
        final TimeUnit f40880e;

        /* renamed from: f */
        final int f40881f;

        C13443m(int limit, long maxAge, TimeUnit unit, C13805u scheduler) {
            this.f40878c = scheduler;
            this.f40881f = limit;
            this.f40879d = maxAge;
            this.f40880e = unit;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public Object mo42464b(Object value) {
            return new C13786c(value, this.f40878c.mo43147a(this.f40880e), this.f40880e);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public Object mo42466c(Object value) {
            return ((C13786c) value).mo42797b();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo42468d() {
            long timeLimit = this.f40878c.mo43147a(this.f40880e) - this.f40879d;
            C13436f prev = (C13436f) get();
            C13436f next = (C13436f) prev.get();
            int e = 0;
            while (next != null) {
                int i = this.f40854b;
                if (i <= this.f40881f) {
                    if (((C13786c) next.f40862a).mo42796a() > timeLimit) {
                        break;
                    }
                    e++;
                    this.f40854b--;
                    prev = next;
                    next = (C13436f) next.get();
                } else {
                    e++;
                    this.f40854b = i - 1;
                    prev = next;
                    next = (C13436f) next.get();
                }
            }
            if (e != 0) {
                mo42465b(prev);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo42469e() {
            long timeLimit = this.f40878c.mo43147a(this.f40880e) - this.f40879d;
            C13436f prev = (C13436f) get();
            C13436f next = (C13436f) prev.get();
            int e = 0;
            while (next != null && this.f40854b > 1 && ((C13786c) next.f40862a).mo42796a() <= timeLimit) {
                e++;
                this.f40854b--;
                prev = next;
                next = (C13436f) next.get();
            }
            if (e != 0) {
                mo42465b(prev);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C13436f mo42463b() {
            long timeLimit = this.f40878c.mo43147a(this.f40880e) - this.f40879d;
            C13436f prev = (C13436f) get();
            for (C13436f next = (C13436f) prev.get(); next != null; next = (C13436f) next.get()) {
                Timed<?> v = (C13786c) next.f40862a;
                if (C13753n.m43781d(v.mo42797b()) || C13753n.m43784f(v.mo42797b()) || v.mo42796a() > timeLimit) {
                    break;
                }
                prev = next;
            }
            return prev;
        }
    }

    /* renamed from: f.a.d.e.b.Sa$n */
    /* compiled from: ObservableReplay */
    static final class C13444n<T> extends C13431a<T> {

        /* renamed from: c */
        final int f40882c;

        C13444n(int limit) {
            this.f40882c = limit;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo42468d() {
            if (this.f40854b > this.f40882c) {
                mo42467c();
            }
        }
    }

    /* renamed from: f.a.d.e.b.Sa$o */
    /* compiled from: ObservableReplay */
    static final class C13445o implements C13432b<Object> {
        C13445o() {
        }

        public C13438h<Object> call() {
            return new C13446p(16);
        }
    }

    /* renamed from: f.a.d.e.b.Sa$p */
    /* compiled from: ObservableReplay */
    static final class C13446p<T> extends ArrayList<Object> implements C13438h<T> {

        /* renamed from: a */
        volatile int f40883a;

        C13446p(int capacityHint) {
            super(capacityHint);
        }

        /* renamed from: a */
        public void mo42461a(T value) {
            C13753n.m43785g(value);
            add(value);
            this.f40883a++;
        }

        /* renamed from: a */
        public void mo42462a(Throwable e) {
            add(C13753n.m43776a(e));
            this.f40883a++;
        }

        /* renamed from: a */
        public void mo42458a() {
            add(C13753n.m43782e());
            this.f40883a++;
        }

        /* renamed from: a */
        public void mo42459a(C13434d<T> output) {
            if (output.getAndIncrement() == 0) {
                Observer<? super T> child = output.f40857b;
                int missed = 1;
                while (!output.mo42473b()) {
                    int sourceIndex = this.f40883a;
                    Integer destinationIndexObject = (Integer) output.mo42472a();
                    int destinationIndex = destinationIndexObject != null ? destinationIndexObject.intValue() : 0;
                    while (destinationIndex < sourceIndex) {
                        if (!C13753n.m43777a(get(destinationIndex), child) && !output.mo42473b()) {
                            destinationIndex++;
                        } else {
                            return;
                        }
                    }
                    output.f40858c = Integer.valueOf(destinationIndex);
                    missed = output.addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static <U, R> C13797m<R> m43371a(Callable<? extends C13762a<U>> connectableFactory, C13212n<? super C13797m<U>, ? extends C13802r<R>> selector) {
        return C13774a.m43821a((C13797m<T>) new C13435e<T>(connectableFactory, selector));
    }

    /* renamed from: a */
    public static <T> C13762a<T> m43365a(C13762a<T> co, C13805u scheduler) {
        return C13774a.m43817a((C13762a<T>) new C13437g<T>(co, co.observeOn(scheduler)));
    }

    /* renamed from: a */
    public static <T> C13762a<T> m43366a(C13802r<? extends T> source) {
        return m43370a(source, f40848a);
    }

    /* renamed from: a */
    public static <T> C13762a<T> m43367a(C13802r<T> source, int bufferSize) {
        if (bufferSize == Integer.MAX_VALUE) {
            return m43366a(source);
        }
        return m43370a(source, (C13432b<T>) new C13439i<T>(bufferSize));
    }

    /* renamed from: a */
    public static <T> C13762a<T> m43368a(C13802r<T> source, long maxAge, TimeUnit unit, C13805u scheduler) {
        return m43369a(source, maxAge, unit, scheduler, MoPubClientPositioning.NO_REPEAT);
    }

    /* renamed from: a */
    public static <T> C13762a<T> m43369a(C13802r<T> source, long maxAge, TimeUnit unit, C13805u scheduler, int bufferSize) {
        C13442l lVar = new C13442l(bufferSize, maxAge, unit, scheduler);
        return m43370a(source, (C13432b<T>) lVar);
    }

    /* renamed from: a */
    static <T> C13762a<T> m43370a(C13802r<T> source, C13432b<T> bufferFactory) {
        AtomicReference<ReplayObserver<T>> curr = new AtomicReference<>();
        return C13774a.m43817a((C13762a<T>) new C13430Sa<T>(new C13441k<>(curr, bufferFactory), source, curr, bufferFactory));
    }

    private C13430Sa(C13802r<T> onSubscribe, C13802r<T> source, AtomicReference<C13440j<T>> current, C13432b<T> bufferFactory) {
        this.f40852e = onSubscribe;
        this.f40849b = source;
        this.f40850c = current;
        this.f40851d = bufferFactory;
    }

    public void dispose() {
        this.f40850c.lazySet(null);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        this.f40852e.subscribe(observer);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo42408a(p320f.p321a.p326c.C13204f<? super p320f.p321a.p325b.C13194b> r7) {
        /*
            r6 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<f.a.d.e.b.Sa$j<T>> r0 = r6.f40850c
            java.lang.Object r0 = r0.get()
            f.a.d.e.b.Sa$j r0 = (p320f.p321a.p327d.p332e.p334b.C13430Sa.C13440j) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.mo42474a()
            if (r1 == 0) goto L_0x0025
        L_0x0010:
            f.a.d.e.b.Sa$b<T> r1 = r6.f40851d
            f.a.d.e.b.Sa$h r1 = r1.call()
            f.a.d.e.b.Sa$j r2 = new f.a.d.e.b.Sa$j
            r2.<init>(r1)
            java.util.concurrent.atomic.AtomicReference<f.a.d.e.b.Sa$j<T>> r3 = r6.f40850c
            boolean r3 = r3.compareAndSet(r0, r2)
            if (r3 != 0) goto L_0x0024
            goto L_0x0000
        L_0x0024:
            r0 = r2
        L_0x0025:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f40871f
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0039
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f40871f
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x0039
            r1 = 1
            goto L_0x003a
        L_0x0039:
            r1 = 0
        L_0x003a:
            r7.accept(r0)     // Catch:{ Throwable -> 0x0047 }
            if (r1 == 0) goto L_0x0046
            f.a.r<T> r2 = r6.f40849b
            r2.subscribe(r0)
        L_0x0046:
            return
        L_0x0047:
            r4 = move-exception
            if (r1 == 0) goto L_0x004f
            java.util.concurrent.atomic.AtomicBoolean r5 = r0.f40871f
            r5.compareAndSet(r2, r3)
        L_0x004f:
            p024io.reactivex.exceptions.C13980a.m44462b(r4)
            java.lang.RuntimeException r2 = p320f.p321a.p327d.p340j.C13748j.m43761a(r4)
            goto L_0x0058
        L_0x0057:
            throw r2
        L_0x0058:
            goto L_0x0057
        */
        throw new UnsupportedOperationException("Method not decompiled: p320f.p321a.p327d.p332e.p334b.C13430Sa.mo42408a(f.a.c.f):void");
    }
}
