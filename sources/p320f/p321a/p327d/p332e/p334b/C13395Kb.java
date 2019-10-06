package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.ObservableSource;
import io.reactivex.internal.operators.observable.ObservableZip.ZipObserver;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p336f.C13706c;

/* renamed from: f.a.d.e.b.Kb */
/* compiled from: ObservableZip */
public final class C13395Kb<T, R> extends C13797m<R> {

    /* renamed from: a */
    final C13802r<? extends T>[] f40728a;

    /* renamed from: b */
    final Iterable<? extends C13802r<? extends T>> f40729b;

    /* renamed from: c */
    final C13212n<? super Object[], ? extends R> f40730c;

    /* renamed from: d */
    final int f40731d;

    /* renamed from: e */
    final boolean f40732e;

    /* renamed from: f.a.d.e.b.Kb$a */
    /* compiled from: ObservableZip */
    static final class C13396a<T, R> extends AtomicInteger implements C13194b {

        /* renamed from: a */
        final C13804t<? super R> f40733a;

        /* renamed from: b */
        final C13212n<? super Object[], ? extends R> f40734b;

        /* renamed from: c */
        final C13397b<T, R>[] f40735c;

        /* renamed from: d */
        final T[] f40736d;

        /* renamed from: e */
        final boolean f40737e;

        /* renamed from: f */
        volatile boolean f40738f;

        C13396a(C13804t<? super R> actual, C13212n<? super Object[], ? extends R> zipper, int count, boolean delayError) {
            this.f40733a = actual;
            this.f40734b = zipper;
            this.f40735c = new C13397b[count];
            this.f40736d = new Object[count];
            this.f40737e = delayError;
        }

        /* renamed from: a */
        public void mo42437a(C13802r<? extends T>[] sources, int bufferSize) {
            ZipObserver<T, R>[] s = this.f40735c;
            int len = s.length;
            for (int i = 0; i < len; i++) {
                s[i] = new C13397b<>(this, bufferSize);
            }
            lazySet(0);
            this.f40733a.onSubscribe(this);
            for (int i2 = 0; i2 < len && !this.f40738f; i2++) {
                sources[i2].subscribe(s[i2]);
            }
        }

        public void dispose() {
            if (!this.f40738f) {
                this.f40738f = true;
                mo42439b();
                if (getAndIncrement() == 0) {
                    mo42440c();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42436a() {
            mo42440c();
            mo42439b();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42439b() {
            for (ZipObserver<?, ?> zs : this.f40735c) {
                zs.mo42442a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo42440c() {
            for (ZipObserver<?, ?> zs : this.f40735c) {
                zs.f40740b.clear();
            }
        }

        /* renamed from: d */
        public void mo42441d() {
            if (getAndIncrement() == 0) {
                C13397b<T, R>[] bVarArr = this.f40735c;
                C13804t<? super R> tVar = this.f40733a;
                T[] os = this.f40736d;
                boolean delayError = this.f40737e;
                int missing = 1;
                while (true) {
                    int i = 0;
                    int emptyCount = 0;
                    for (C13397b<T, R> bVar : bVarArr) {
                        if (os[i] == null) {
                            boolean d = bVar.f40741c;
                            T v = bVar.f40740b.poll();
                            boolean empty = v == null;
                            boolean z = d;
                            C13397b<T, R> bVar2 = bVar;
                            if (!mo42438a(d, empty, tVar, delayError, bVar)) {
                                if (!empty) {
                                    os[i] = v;
                                } else {
                                    emptyCount++;
                                }
                                C13397b<T, R> bVar3 = bVar2;
                            } else {
                                return;
                            }
                        } else {
                            C13397b<T, R> bVar4 = bVar;
                            if (bVar4.f40741c && !delayError) {
                                Throwable ex = bVar4.f40742d;
                                if (ex != null) {
                                    mo42436a();
                                    tVar.onError(ex);
                                    return;
                                }
                            }
                        }
                        i++;
                    }
                    if (emptyCount != 0) {
                        missing = addAndGet(-missing);
                        if (missing == 0) {
                            return;
                        }
                    } else {
                        try {
                            R v2 = this.f40734b.apply(os.clone());
                            C13264b.m43226a(v2, "The zipper returned a null value");
                            tVar.onNext(v2);
                            Arrays.fill(os, null);
                        } catch (Throwable ex2) {
                            C13980a.m44462b(ex2);
                            mo42436a();
                            tVar.onError(ex2);
                            return;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo42438a(boolean d, boolean empty, C13804t<? super R> a, boolean delayError, C13397b<?, ?> source) {
            if (this.f40738f) {
                mo42436a();
                return true;
            }
            if (d) {
                if (!delayError) {
                    Throwable e = source.f40742d;
                    if (e != null) {
                        mo42436a();
                        a.onError(e);
                        return true;
                    } else if (empty) {
                        mo42436a();
                        a.onComplete();
                        return true;
                    }
                } else if (empty) {
                    Throwable e2 = source.f40742d;
                    mo42436a();
                    if (e2 != null) {
                        a.onError(e2);
                    } else {
                        a.onComplete();
                    }
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: f.a.d.e.b.Kb$b */
    /* compiled from: ObservableZip */
    static final class C13397b<T, R> implements C13804t<T> {

        /* renamed from: a */
        final C13396a<T, R> f40739a;

        /* renamed from: b */
        final C13706c<T> f40740b;

        /* renamed from: c */
        volatile boolean f40741c;

        /* renamed from: d */
        Throwable f40742d;

        /* renamed from: e */
        final AtomicReference<C13194b> f40743e = new AtomicReference<>();

        C13397b(C13396a<T, R> parent, int bufferSize) {
            this.f40739a = parent;
            this.f40740b = new C13706c<>(bufferSize);
        }

        public void onSubscribe(C13194b s) {
            C13218c.m43153c(this.f40743e, s);
        }

        public void onNext(T t) {
            this.f40740b.offer(t);
            this.f40739a.mo42441d();
        }

        public void onError(Throwable t) {
            this.f40742d = t;
            this.f40741c = true;
            this.f40739a.mo42441d();
        }

        public void onComplete() {
            this.f40741c = true;
            this.f40739a.mo42441d();
        }

        /* renamed from: a */
        public void mo42442a() {
            C13218c.m43150a(this.f40743e);
        }
    }

    public C13395Kb(C13802r<? extends T>[] sources, Iterable<? extends C13802r<? extends T>> sourcesIterable, C13212n<? super Object[], ? extends R> zipper, int bufferSize, boolean delayError) {
        this.f40728a = sources;
        this.f40729b = sourcesIterable;
        this.f40730c = zipper;
        this.f40731d = bufferSize;
        this.f40732e = delayError;
    }

    public void subscribeActual(C13804t<? super R> s) {
        C13802r<? extends T>[] rVarArr = this.f40728a;
        int count = 0;
        if (rVarArr == null) {
            rVarArr = new C13797m[8];
            Iterator it = this.f40729b.iterator();
            while (it.hasNext()) {
                ObservableSource<? extends T> p = (C13802r) it.next();
                if (count == rVarArr.length) {
                    C13802r<? extends T>[] rVarArr2 = new C13802r[((count >> 2) + count)];
                    System.arraycopy(rVarArr, 0, rVarArr2, 0, count);
                    rVarArr = rVarArr2;
                }
                int count2 = count + 1;
                rVarArr[count] = p;
                count = count2;
            }
        } else {
            count = rVarArr.length;
        }
        if (count == 0) {
            C13219d.m43156a(s);
        } else {
            new C13396a<>(s, this.f40730c, count, this.f40732e).mo42437a(rVarArr, this.f40731d);
        }
    }
}
