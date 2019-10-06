package p320f.p321a.p327d.p332e.p335c;

import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13810v;
import p320f.p321a.C13812x;
import p320f.p321a.C13814z;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13204f;

/* renamed from: f.a.d.e.c.b */
/* compiled from: SingleDoOnSuccess */
public final class C13688b<T> extends C13810v<T> {

    /* renamed from: a */
    final C13814z<T> f41706a;

    /* renamed from: b */
    final C13204f<? super T> f41707b;

    /* renamed from: f.a.d.e.c.b$a */
    /* compiled from: SingleDoOnSuccess */
    final class C13689a implements C13812x<T> {

        /* renamed from: a */
        private final C13812x<? super T> f41708a;

        C13689a(C13812x<? super T> s) {
            this.f41708a = s;
        }

        public void onSubscribe(C13194b d) {
            this.f41708a.onSubscribe(d);
        }

        public void onSuccess(T value) {
            try {
                C13688b.this.f41707b.accept(value);
                this.f41708a.onSuccess(value);
            } catch (Throwable ex) {
                C13980a.m44462b(ex);
                this.f41708a.onError(ex);
            }
        }

        public void onError(Throwable e) {
            this.f41708a.onError(e);
        }
    }

    public C13688b(C13814z<T> source, C13204f<? super T> onSuccess) {
        this.f41706a = source;
        this.f41707b = onSuccess;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42365b(C13812x<? super T> s) {
        this.f41706a.mo43156a(new C13689a(s));
    }
}
