package p320f.p321a.p327d.p332e.p334b;

import p024io.reactivex.exceptions.C13980a;
import p024io.reactivex.exceptions.CompositeException;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13199a;
import p320f.p321a.p326c.C13204f;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.O */
/* compiled from: ObservableDoOnEach */
public final class C13412O<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13204f<? super T> f40785b;

    /* renamed from: c */
    final C13204f<? super Throwable> f40786c;

    /* renamed from: d */
    final C13199a f40787d;

    /* renamed from: e */
    final C13199a f40788e;

    /* renamed from: f.a.d.e.b.O$a */
    /* compiled from: ObservableDoOnEach */
    static final class C13413a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f40789a;

        /* renamed from: b */
        final C13204f<? super T> f40790b;

        /* renamed from: c */
        final C13204f<? super Throwable> f40791c;

        /* renamed from: d */
        final C13199a f40792d;

        /* renamed from: e */
        final C13199a f40793e;

        /* renamed from: f */
        C13194b f40794f;

        /* renamed from: g */
        boolean f40795g;

        C13413a(C13804t<? super T> actual, C13204f<? super T> onNext, C13204f<? super Throwable> onError, C13199a onComplete, C13199a onAfterTerminate) {
            this.f40789a = actual;
            this.f40790b = onNext;
            this.f40791c = onError;
            this.f40792d = onComplete;
            this.f40793e = onAfterTerminate;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40794f, s)) {
                this.f40794f = s;
                this.f40789a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f40794f.dispose();
        }

        public void onNext(T t) {
            if (!this.f40795g) {
                try {
                    this.f40790b.accept(t);
                    this.f40789a.onNext(t);
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    this.f40794f.dispose();
                    onError(e);
                }
            }
        }

        public void onError(Throwable t) {
            if (this.f40795g) {
                C13774a.m43836b(t);
                return;
            }
            this.f40795g = true;
            try {
                this.f40791c.accept(t);
            } catch (Throwable e) {
                C13980a.m44462b(e);
                t = new CompositeException(t, e);
            }
            this.f40789a.onError(t);
            try {
                this.f40793e.run();
            } catch (Throwable e2) {
                C13980a.m44462b(e2);
                C13774a.m43836b(e2);
            }
        }

        public void onComplete() {
            if (!this.f40795g) {
                try {
                    this.f40792d.run();
                    this.f40795g = true;
                    this.f40789a.onComplete();
                    try {
                        this.f40793e.run();
                    } catch (Throwable e) {
                        C13980a.m44462b(e);
                        C13774a.m43836b(e);
                    }
                } catch (Throwable e2) {
                    C13980a.m44462b(e2);
                    onError(e2);
                }
            }
        }
    }

    public C13412O(C13802r<T> source, C13204f<? super T> onNext, C13204f<? super Throwable> onError, C13199a onComplete, C13199a onAfterTerminate) {
        super(source);
        this.f40785b = onNext;
        this.f40786c = onError;
        this.f40787d = onComplete;
        this.f40788e = onAfterTerminate;
    }

    public void subscribeActual(C13804t<? super T> t) {
        C13802r<T> rVar = this.f41005a;
        C13413a aVar = new C13413a(t, this.f40785b, this.f40786c, this.f40787d, this.f40788e);
        rVar.subscribe(aVar);
    }
}
