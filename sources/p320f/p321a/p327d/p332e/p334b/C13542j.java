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

/* renamed from: f.a.d.e.b.j */
/* compiled from: ObservableAnySingle */
public final class C13542j<T> extends C13810v<Boolean> implements C13266a<Boolean> {

    /* renamed from: a */
    final C13802r<T> f41188a;

    /* renamed from: b */
    final C13214p<? super T> f41189b;

    /* renamed from: f.a.d.e.b.j$a */
    /* compiled from: ObservableAnySingle */
    static final class C13543a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13812x<? super Boolean> f41190a;

        /* renamed from: b */
        final C13214p<? super T> f41191b;

        /* renamed from: c */
        C13194b f41192c;

        /* renamed from: d */
        boolean f41193d;

        C13543a(C13812x<? super Boolean> actual, C13214p<? super T> predicate) {
            this.f41190a = actual;
            this.f41191b = predicate;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41192c, s)) {
                this.f41192c = s;
                this.f41190a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.f41193d) {
                try {
                    if (this.f41191b.test(t)) {
                        this.f41193d = true;
                        this.f41192c.dispose();
                        this.f41190a.onSuccess(Boolean.valueOf(true));
                    }
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    this.f41192c.dispose();
                    onError(e);
                }
            }
        }

        public void onError(Throwable t) {
            if (this.f41193d) {
                C13774a.m43836b(t);
                return;
            }
            this.f41193d = true;
            this.f41190a.onError(t);
        }

        public void onComplete() {
            if (!this.f41193d) {
                this.f41193d = true;
                this.f41190a.onSuccess(Boolean.valueOf(false));
            }
        }

        public void dispose() {
            this.f41192c.dispose();
        }
    }

    public C13542j(C13802r<T> source, C13214p<? super T> predicate) {
        this.f41188a = source;
        this.f41189b = predicate;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42365b(C13812x<? super Boolean> t) {
        this.f41188a.subscribe(new C13543a(t, this.f41189b));
    }

    /* renamed from: a */
    public C13797m<Boolean> mo42316a() {
        return C13774a.m43821a((C13797m<T>) new C13536i<T>(this.f41188a, this.f41189b));
    }
}
