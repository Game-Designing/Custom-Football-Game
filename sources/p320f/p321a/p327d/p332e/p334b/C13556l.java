package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableBuffer.BufferExactObserver;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;

/* renamed from: f.a.d.e.b.l */
/* compiled from: ObservableBuffer */
public final class C13556l<T, U extends Collection<? super T>> extends C13485a<T, U> {

    /* renamed from: b */
    final int f41237b;

    /* renamed from: c */
    final int f41238c;

    /* renamed from: d */
    final Callable<U> f41239d;

    /* renamed from: f.a.d.e.b.l$a */
    /* compiled from: ObservableBuffer */
    static final class C13557a<T, U extends Collection<? super T>> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super U> f41240a;

        /* renamed from: b */
        final int f41241b;

        /* renamed from: c */
        final Callable<U> f41242c;

        /* renamed from: d */
        U f41243d;

        /* renamed from: e */
        int f41244e;

        /* renamed from: f */
        C13194b f41245f;

        C13557a(C13804t<? super U> actual, int count, Callable<U> bufferSupplier) {
            this.f41240a = actual;
            this.f41241b = count;
            this.f41242c = bufferSupplier;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo42577a() {
            try {
                U call = this.f41242c.call();
                C13264b.m43226a(call, "Empty buffer supplied");
                this.f41243d = (Collection) call;
                return true;
            } catch (Throwable t) {
                C13980a.m44462b(t);
                this.f41243d = null;
                C13194b bVar = this.f41245f;
                if (bVar == null) {
                    C13219d.m43157a(t, this.f41240a);
                } else {
                    bVar.dispose();
                    this.f41240a.onError(t);
                }
                return false;
            }
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41245f, s)) {
                this.f41245f = s;
                this.f41240a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f41245f.dispose();
        }

        public void onNext(T t) {
            U b = this.f41243d;
            if (b != null) {
                b.add(t);
                int i = this.f41244e + 1;
                this.f41244e = i;
                if (i >= this.f41241b) {
                    this.f41240a.onNext(b);
                    this.f41244e = 0;
                    mo42577a();
                }
            }
        }

        public void onError(Throwable t) {
            this.f41243d = null;
            this.f41240a.onError(t);
        }

        public void onComplete() {
            U b = this.f41243d;
            this.f41243d = null;
            if (b != null && !b.isEmpty()) {
                this.f41240a.onNext(b);
            }
            this.f41240a.onComplete();
        }
    }

    /* renamed from: f.a.d.e.b.l$b */
    /* compiled from: ObservableBuffer */
    static final class C13558b<T, U extends Collection<? super T>> extends AtomicBoolean implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super U> f41246a;

        /* renamed from: b */
        final int f41247b;

        /* renamed from: c */
        final int f41248c;

        /* renamed from: d */
        final Callable<U> f41249d;

        /* renamed from: e */
        C13194b f41250e;

        /* renamed from: f */
        final ArrayDeque<U> f41251f = new ArrayDeque<>();

        /* renamed from: g */
        long f41252g;

        C13558b(C13804t<? super U> actual, int count, int skip, Callable<U> bufferSupplier) {
            this.f41246a = actual;
            this.f41247b = count;
            this.f41248c = skip;
            this.f41249d = bufferSupplier;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41250e, s)) {
                this.f41250e = s;
                this.f41246a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f41250e.dispose();
        }

        public void onNext(T t) {
            long j = this.f41252g;
            this.f41252g = 1 + j;
            if (j % ((long) this.f41248c) == 0) {
                try {
                    U call = this.f41249d.call();
                    C13264b.m43226a(call, "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                    this.f41251f.offer((Collection) call);
                } catch (Throwable e) {
                    this.f41251f.clear();
                    this.f41250e.dispose();
                    this.f41246a.onError(e);
                    return;
                }
            }
            Iterator<U> it = this.f41251f.iterator();
            while (it.hasNext()) {
                U b = (Collection) it.next();
                b.add(t);
                if (this.f41247b <= b.size()) {
                    it.remove();
                    this.f41246a.onNext(b);
                }
            }
        }

        public void onError(Throwable t) {
            this.f41251f.clear();
            this.f41246a.onError(t);
        }

        public void onComplete() {
            while (!this.f41251f.isEmpty()) {
                this.f41246a.onNext(this.f41251f.poll());
            }
            this.f41246a.onComplete();
        }
    }

    public C13556l(C13802r<T> source, int count, int skip, Callable<U> bufferSupplier) {
        super(source);
        this.f41237b = count;
        this.f41238c = skip;
        this.f41239d = bufferSupplier;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super U> t) {
        int i = this.f41238c;
        int i2 = this.f41237b;
        if (i == i2) {
            BufferExactObserver<T, U> bes = new C13557a<>(t, i2, this.f41239d);
            if (bes.mo42577a()) {
                this.f41005a.subscribe(bes);
                return;
            }
            return;
        }
        this.f41005a.subscribe(new C13558b(t, i2, i, this.f41239d));
    }
}
