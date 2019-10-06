package p320f.p321a.p327d.p332e.p334b;

import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13810v;
import p320f.p321a.C13812x;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13214p;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p330c.C13266a;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.g */
/* compiled from: ObservableAllSingle */
public final class C13523g<T> extends C13810v<Boolean> implements C13266a<Boolean> {

    /* renamed from: a */
    final C13802r<T> f41127a;

    /* renamed from: b */
    final C13214p<? super T> f41128b;

    /* renamed from: f.a.d.e.b.g$a */
    /* compiled from: ObservableAllSingle */
    static final class C13524a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13812x<? super Boolean> f41129a;

        /* renamed from: b */
        final C13214p<? super T> f41130b;

        /* renamed from: c */
        C13194b f41131c;

        /* renamed from: d */
        boolean f41132d;

        C13524a(C13812x<? super Boolean> actual, C13214p<? super T> predicate) {
            this.f41129a = actual;
            this.f41130b = predicate;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41131c, s)) {
                this.f41131c = s;
                this.f41129a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.f41132d) {
                try {
                    if (!this.f41130b.test(t)) {
                        this.f41132d = true;
                        this.f41131c.dispose();
                        this.f41129a.onSuccess(Boolean.valueOf(false));
                    }
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    this.f41131c.dispose();
                    onError(e);
                }
            }
        }

        public void onError(Throwable t) {
            if (this.f41132d) {
                C13774a.m43836b(t);
                return;
            }
            this.f41132d = true;
            this.f41129a.onError(t);
        }

        public void onComplete() {
            if (!this.f41132d) {
                this.f41132d = true;
                this.f41129a.onSuccess(Boolean.valueOf(true));
            }
        }

        public void dispose() {
            this.f41131c.dispose();
        }
    }

    public C13523g(C13802r<T> source, C13214p<? super T> predicate) {
        this.f41127a = source;
        this.f41128b = predicate;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42365b(C13812x<? super Boolean> t) {
        this.f41127a.subscribe(new C13524a(t, this.f41128b));
    }

    /* renamed from: a */
    public C13797m<Boolean> mo42316a() {
        return C13774a.m43821a((C13797m<T>) new C13518f<T>(this.f41127a, this.f41128b));
    }
}
