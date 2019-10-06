package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.ObservableSource;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany.WithLatestFromObserver;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p340j.C13741c;
import p320f.p321a.p327d.p340j.C13750k;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.Jb */
/* compiled from: ObservableWithLatestFromMany */
public final class C13387Jb<T, R> extends C13485a<T, R> {

    /* renamed from: b */
    final C13802r<?>[] f40704b;

    /* renamed from: c */
    final Iterable<? extends C13802r<?>> f40705c;

    /* renamed from: d */
    final C13212n<? super Object[], R> f40706d;

    /* renamed from: f.a.d.e.b.Jb$a */
    /* compiled from: ObservableWithLatestFromMany */
    final class C13388a implements C13212n<T, R> {
        C13388a() {
        }

        public R apply(T t) throws Exception {
            R apply = C13387Jb.this.f40706d.apply(new Object[]{t});
            C13264b.m43226a(apply, "The combiner returned a null value");
            return apply;
        }
    }

    /* renamed from: f.a.d.e.b.Jb$b */
    /* compiled from: ObservableWithLatestFromMany */
    static final class C13389b<T, R> extends AtomicInteger implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super R> f40708a;

        /* renamed from: b */
        final C13212n<? super Object[], R> f40709b;

        /* renamed from: c */
        final C13390c[] f40710c;

        /* renamed from: d */
        final AtomicReferenceArray<Object> f40711d;

        /* renamed from: e */
        final AtomicReference<C13194b> f40712e;

        /* renamed from: f */
        final C13741c f40713f;

        /* renamed from: g */
        volatile boolean f40714g;

        C13389b(C13804t<? super R> actual, C13212n<? super Object[], R> combiner, int n) {
            this.f40708a = actual;
            this.f40709b = combiner;
            C13390c[] s = new C13390c[n];
            for (int i = 0; i < n; i++) {
                s[i] = new C13390c(this, i);
            }
            this.f40710c = s;
            this.f40711d = new AtomicReferenceArray<>(n);
            this.f40712e = new AtomicReference<>();
            this.f40713f = new C13741c();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42433a(C13802r<?>[] others, int n) {
            C13390c[] observers = this.f40710c;
            AtomicReference<C13194b> atomicReference = this.f40712e;
            for (int i = 0; i < n && !C13218c.m43148a((C13194b) atomicReference.get()) && !this.f40714g; i++) {
                others[i].subscribe(observers[i]);
            }
        }

        public void onSubscribe(C13194b d) {
            C13218c.m43153c(this.f40712e, d);
        }

        public void onNext(T t) {
            if (!this.f40714g) {
                AtomicReferenceArray<Object> ara = this.f40711d;
                int n = ara.length();
                Object[] objects = new Object[(n + 1)];
                objects[0] = t;
                int i = 0;
                while (i < n) {
                    Object o = ara.get(i);
                    if (o != null) {
                        objects[i + 1] = o;
                        i++;
                    } else {
                        return;
                    }
                }
                try {
                    R v = this.f40709b.apply(objects);
                    C13264b.m43226a(v, "combiner returned a null value");
                    C13750k.m43764a(this.f40708a, v, (AtomicInteger) this, this.f40713f);
                } catch (Throwable ex) {
                    C13980a.m44462b(ex);
                    dispose();
                    onError(ex);
                }
            }
        }

        public void onError(Throwable t) {
            if (this.f40714g) {
                C13774a.m43836b(t);
                return;
            }
            this.f40714g = true;
            mo42429a(-1);
            C13750k.m43765a(this.f40708a, t, (AtomicInteger) this, this.f40713f);
        }

        public void onComplete() {
            if (!this.f40714g) {
                this.f40714g = true;
                mo42429a(-1);
                C13750k.m43766a(this.f40708a, (AtomicInteger) this, this.f40713f);
            }
        }

        public void dispose() {
            C13218c.m43150a(this.f40712e);
            for (C13390c s : this.f40710c) {
                s.mo42434a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42430a(int index, Object o) {
            this.f40711d.set(index, o);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42431a(int index, Throwable t) {
            this.f40714g = true;
            C13218c.m43150a(this.f40712e);
            mo42429a(index);
            C13750k.m43765a(this.f40708a, t, (AtomicInteger) this, this.f40713f);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42432a(int index, boolean nonEmpty) {
            if (!nonEmpty) {
                this.f40714g = true;
                mo42429a(index);
                C13750k.m43766a(this.f40708a, (AtomicInteger) this, this.f40713f);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42429a(int index) {
            C13390c[] observers = this.f40710c;
            for (int i = 0; i < observers.length; i++) {
                if (i != index) {
                    observers[i].mo42434a();
                }
            }
        }
    }

    /* renamed from: f.a.d.e.b.Jb$c */
    /* compiled from: ObservableWithLatestFromMany */
    static final class C13390c extends AtomicReference<C13194b> implements C13804t<Object> {

        /* renamed from: a */
        final C13389b<?, ?> f40715a;

        /* renamed from: b */
        final int f40716b;

        /* renamed from: c */
        boolean f40717c;

        C13390c(C13389b<?, ?> parent, int index) {
            this.f40715a = parent;
            this.f40716b = index;
        }

        public void onSubscribe(C13194b d) {
            C13218c.m43153c(this, d);
        }

        public void onNext(Object t) {
            if (!this.f40717c) {
                this.f40717c = true;
            }
            this.f40715a.mo42430a(this.f40716b, t);
        }

        public void onError(Throwable t) {
            this.f40715a.mo42431a(this.f40716b, t);
        }

        public void onComplete() {
            this.f40715a.mo42432a(this.f40716b, this.f40717c);
        }

        /* renamed from: a */
        public void mo42434a() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }
    }

    public C13387Jb(C13802r<T> source, C13802r<?>[] otherArray, C13212n<? super Object[], R> combiner) {
        super(source);
        this.f40704b = otherArray;
        this.f40705c = null;
        this.f40706d = combiner;
    }

    public C13387Jb(C13802r<T> source, Iterable<? extends C13802r<?>> otherIterable, C13212n<? super Object[], R> combiner) {
        super(source);
        this.f40704b = null;
        this.f40705c = otherIterable;
        this.f40706d = combiner;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super R> s) {
        C13802r<?>[] rVarArr = this.f40704b;
        int n = 0;
        if (rVarArr == null) {
            rVarArr = new C13802r[8];
            try {
                Iterator it = this.f40705c.iterator();
                while (it.hasNext()) {
                    ObservableSource<?> p = (C13802r) it.next();
                    if (n == rVarArr.length) {
                        rVarArr = (C13802r[]) Arrays.copyOf(rVarArr, (n >> 1) + n);
                    }
                    int n2 = n + 1;
                    try {
                        rVarArr[n] = p;
                        n = n2;
                    } catch (Throwable th) {
                        ex = th;
                        int i = n2;
                        C13980a.m44462b(ex);
                        C13219d.m43157a(ex, s);
                        return;
                    }
                }
            } catch (Throwable th2) {
                ex = th2;
                C13980a.m44462b(ex);
                C13219d.m43157a(ex, s);
                return;
            }
        } else {
            n = rVarArr.length;
        }
        if (n == 0) {
            new C13666xa(this.f41005a, new C13388a()).subscribeActual(s);
            return;
        }
        WithLatestFromObserver<T, R> parent = new C13389b<>(s, this.f40706d, n);
        s.onSubscribe(parent);
        parent.mo42433a(rVarArr, n);
        this.f41005a.subscribe(parent);
    }
}
