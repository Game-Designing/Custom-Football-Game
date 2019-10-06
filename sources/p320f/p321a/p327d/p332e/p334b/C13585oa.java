package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13192b;
import p320f.p321a.C13198c;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p330c.C13266a;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.oa */
/* compiled from: ObservableIgnoreElementsCompletable */
public final class C13585oa<T> extends C13192b implements C13266a<T> {

    /* renamed from: a */
    final C13802r<T> f41346a;

    /* renamed from: f.a.d.e.b.oa$a */
    /* compiled from: ObservableIgnoreElementsCompletable */
    static final class C13586a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13198c f41347a;

        /* renamed from: b */
        C13194b f41348b;

        C13586a(C13198c t) {
            this.f41347a = t;
        }

        public void onSubscribe(C13194b s) {
            this.f41348b = s;
            this.f41347a.onSubscribe(this);
        }

        public void onNext(T t) {
        }

        public void onError(Throwable e) {
            this.f41347a.onError(e);
        }

        public void onComplete() {
            this.f41347a.onComplete();
        }

        public void dispose() {
            this.f41348b.dispose();
        }
    }

    public C13585oa(C13802r<T> source) {
        this.f41346a = source;
    }

    /* renamed from: b */
    public void mo42247b(C13198c t) {
        this.f41346a.subscribe(new C13586a(t));
    }

    /* renamed from: a */
    public C13797m<T> mo42316a() {
        return C13774a.m43821a((C13797m<T>) new C13578na<T>(this.f41346a));
    }
}
