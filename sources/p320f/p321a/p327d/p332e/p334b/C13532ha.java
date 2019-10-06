package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13773g;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p339i.C13737b;
import p363i.p368b.C14228a;
import p363i.p368b.C14230c;

/* renamed from: f.a.d.e.b.ha */
/* compiled from: ObservableFromPublisher */
public final class C13532ha<T> extends C13797m<T> {

    /* renamed from: a */
    final C14228a<? extends T> f41153a;

    /* renamed from: f.a.d.e.b.ha$a */
    /* compiled from: ObservableFromPublisher */
    static final class C13533a<T> implements C13773g<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41154a;

        /* renamed from: b */
        C14230c f41155b;

        C13533a(C13804t<? super T> o) {
            this.f41154a = o;
        }

        public void onComplete() {
            this.f41154a.onComplete();
        }

        public void onError(Throwable t) {
            this.f41154a.onError(t);
        }

        public void onNext(T t) {
            this.f41154a.onNext(t);
        }

        /* renamed from: a */
        public void mo42355a(C14230c s) {
            if (C13737b.m43736a(this.f41155b, s)) {
                this.f41155b = s;
                this.f41154a.onSubscribe(this);
                s.request(Long.MAX_VALUE);
            }
        }

        public void dispose() {
            this.f41155b.cancel();
            this.f41155b = C13737b.CANCELLED;
        }
    }

    public C13532ha(C14228a<? extends T> publisher) {
        this.f41153a = publisher;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> o) {
        this.f41153a.mo42781a(new C13533a(o));
    }
}
