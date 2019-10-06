package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableCreate.CreateEmitter;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13799o;
import p320f.p321a.C13800p;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.C */
/* compiled from: ObservableCreate */
public final class C13321C<T> extends C13797m<T> {

    /* renamed from: a */
    final C13800p<T> f40468a;

    /* renamed from: f.a.d.e.b.C$a */
    /* compiled from: ObservableCreate */
    static final class C13322a<T> extends AtomicReference<C13194b> implements C13799o<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f40469a;

        C13322a(C13804t<? super T> observer) {
            this.f40469a = observer;
        }

        public void onNext(T t) {
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            if (!mo42373a()) {
                this.f40469a.onNext(t);
            }
        }

        public void onError(Throwable t) {
            if (!mo42374a(t)) {
                C13774a.m43836b(t);
            }
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        public boolean mo42374a(Throwable t) {
            if (t == null) {
                t = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (mo42373a()) {
                return false;
            }
            try {
                this.f40469a.onError(t);
                dispose();
                return true;
            } catch (Throwable th) {
                dispose();
                throw th;
            }
        }

        public void onComplete() {
            if (!mo42373a()) {
                try {
                    this.f40469a.onComplete();
                } finally {
                    dispose();
                }
            }
        }

        public void dispose() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }

        /* renamed from: a */
        public boolean mo42373a() {
            return C13218c.m43148a((C13194b) get());
        }
    }

    public C13321C(C13800p<T> source) {
        this.f40468a = source;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        CreateEmitter<T> parent = new C13322a<>(observer);
        observer.onSubscribe(parent);
        try {
            this.f40468a.mo22289a(parent);
        } catch (Throwable ex) {
            C13980a.m44462b(ex);
            parent.onError(ex);
        }
    }
}
