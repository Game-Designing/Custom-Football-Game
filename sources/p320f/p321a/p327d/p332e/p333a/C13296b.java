package p320f.p321a.p327d.p332e.p333a;

import p320f.p321a.C13764f;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p363i.p368b.C14229b;
import p363i.p368b.C14230c;

/* renamed from: f.a.d.e.a.b */
/* compiled from: FlowableFromObservable */
public final class C13296b<T> extends C13764f<T> {

    /* renamed from: b */
    private final C13797m<T> f40400b;

    /* renamed from: f.a.d.e.a.b$a */
    /* compiled from: FlowableFromObservable */
    static class C13297a<T> implements C13804t<T>, C14230c {

        /* renamed from: a */
        private final C14229b<? super T> f40401a;

        /* renamed from: b */
        private C13194b f40402b;

        C13297a(C14229b<? super T> s) {
            this.f40401a = s;
        }

        public void onComplete() {
            this.f40401a.onComplete();
        }

        public void onError(Throwable e) {
            this.f40401a.onError(e);
        }

        public void onNext(T value) {
            this.f40401a.onNext(value);
        }

        public void onSubscribe(C13194b d) {
            this.f40402b = d;
            this.f40401a.mo42355a(this);
        }

        public void cancel() {
            this.f40402b.dispose();
        }

        public void request(long n) {
        }
    }

    public C13296b(C13797m<T> upstream) {
        this.f40400b = upstream;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42351b(C14229b<? super T> s) {
        this.f40400b.subscribe((C13804t<? super T>) new C13297a<Object>(s));
    }
}
