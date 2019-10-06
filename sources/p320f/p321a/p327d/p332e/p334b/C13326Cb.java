package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import p024io.reactivex.exceptions.C13980a;
import p024io.reactivex.exceptions.CompositeException;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13204f;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.Cb */
/* compiled from: ObservableUsing */
public final class C13326Cb<T, D> extends C13797m<T> {

    /* renamed from: a */
    final Callable<? extends D> f40481a;

    /* renamed from: b */
    final C13212n<? super D, ? extends C13802r<? extends T>> f40482b;

    /* renamed from: c */
    final C13204f<? super D> f40483c;

    /* renamed from: d */
    final boolean f40484d;

    /* renamed from: f.a.d.e.b.Cb$a */
    /* compiled from: ObservableUsing */
    static final class C13327a<T, D> extends AtomicBoolean implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f40485a;

        /* renamed from: b */
        final D f40486b;

        /* renamed from: c */
        final C13204f<? super D> f40487c;

        /* renamed from: d */
        final boolean f40488d;

        /* renamed from: e */
        C13194b f40489e;

        C13327a(C13804t<? super T> actual, D resource, C13204f<? super D> disposer, boolean eager) {
            this.f40485a = actual;
            this.f40486b = resource;
            this.f40487c = disposer;
            this.f40488d = eager;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40489e, s)) {
                this.f40489e = s;
                this.f40485a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f40485a.onNext(t);
        }

        public void onError(Throwable t) {
            if (this.f40488d) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f40487c.accept(this.f40486b);
                    } catch (Throwable e) {
                        C13980a.m44462b(e);
                        t = new CompositeException(t, e);
                    }
                }
                this.f40489e.dispose();
                this.f40485a.onError(t);
                return;
            }
            this.f40485a.onError(t);
            this.f40489e.dispose();
            mo42383a();
        }

        public void onComplete() {
            if (this.f40488d) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f40487c.accept(this.f40486b);
                    } catch (Throwable e) {
                        C13980a.m44462b(e);
                        this.f40485a.onError(e);
                        return;
                    }
                }
                this.f40489e.dispose();
                this.f40485a.onComplete();
            } else {
                this.f40485a.onComplete();
                this.f40489e.dispose();
                mo42383a();
            }
        }

        public void dispose() {
            mo42383a();
            this.f40489e.dispose();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42383a() {
            if (compareAndSet(false, true)) {
                try {
                    this.f40487c.accept(this.f40486b);
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    C13774a.m43836b(e);
                }
            }
        }
    }

    public C13326Cb(Callable<? extends D> resourceSupplier, C13212n<? super D, ? extends C13802r<? extends T>> sourceSupplier, C13204f<? super D> disposer, boolean eager) {
        this.f40481a = resourceSupplier;
        this.f40482b = sourceSupplier;
        this.f40483c = disposer;
        this.f40484d = eager;
    }

    public void subscribeActual(C13804t<? super T> s) {
        try {
            D resource = this.f40481a.call();
            try {
                Object apply = this.f40482b.apply(resource);
                C13264b.m43226a(apply, "The sourceSupplier returned a null ObservableSource");
                ((C13802r) apply).subscribe(new C13327a<>(s, resource, this.f40483c, this.f40484d));
            } catch (Throwable ex) {
                C13980a.m44462b(ex);
                C13219d.m43157a((Throwable) new CompositeException(e, ex), s);
            }
        } catch (Throwable e) {
            C13980a.m44462b(e);
            C13219d.m43157a(e, s);
        }
    }
}
