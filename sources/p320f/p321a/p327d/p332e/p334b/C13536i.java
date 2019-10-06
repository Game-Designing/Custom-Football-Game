package p320f.p321a.p327d.p332e.p334b;

import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13214p;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.i */
/* compiled from: ObservableAny */
public final class C13536i<T> extends C13485a<T, Boolean> {

    /* renamed from: b */
    final C13214p<? super T> f41171b;

    /* renamed from: f.a.d.e.b.i$a */
    /* compiled from: ObservableAny */
    static final class C13537a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super Boolean> f41172a;

        /* renamed from: b */
        final C13214p<? super T> f41173b;

        /* renamed from: c */
        C13194b f41174c;

        /* renamed from: d */
        boolean f41175d;

        C13537a(C13804t<? super Boolean> actual, C13214p<? super T> predicate) {
            this.f41172a = actual;
            this.f41173b = predicate;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41174c, s)) {
                this.f41174c = s;
                this.f41172a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.f41175d) {
                try {
                    if (this.f41173b.test(t)) {
                        this.f41175d = true;
                        this.f41174c.dispose();
                        this.f41172a.onNext(Boolean.valueOf(true));
                        this.f41172a.onComplete();
                    }
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    this.f41174c.dispose();
                    onError(e);
                }
            }
        }

        public void onError(Throwable t) {
            if (this.f41175d) {
                C13774a.m43836b(t);
                return;
            }
            this.f41175d = true;
            this.f41172a.onError(t);
        }

        public void onComplete() {
            if (!this.f41175d) {
                this.f41175d = true;
                this.f41172a.onNext(Boolean.valueOf(false));
                this.f41172a.onComplete();
            }
        }

        public void dispose() {
            this.f41174c.dispose();
        }
    }

    public C13536i(C13802r<T> source, C13214p<? super T> predicate) {
        super(source);
        this.f41171b = predicate;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super Boolean> t) {
        this.f41005a.subscribe(new C13537a(t, this.f41171b));
    }
}
