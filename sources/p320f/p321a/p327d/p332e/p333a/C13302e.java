package p320f.p321a.p327d.p332e.p333a;

import java.util.concurrent.atomic.AtomicLong;
import p024io.reactivex.exceptions.MissingBackpressureException;
import p320f.p321a.C13764f;
import p320f.p321a.C13773g;
import p320f.p321a.p327d.p339i.C13737b;
import p320f.p321a.p327d.p340j.C13742d;
import p320f.p321a.p343g.C13774a;
import p363i.p368b.C14229b;
import p363i.p368b.C14230c;

/* renamed from: f.a.d.e.a.e */
/* compiled from: FlowableOnBackpressureError */
public final class C13302e<T> extends C13295a<T, T> {

    /* renamed from: f.a.d.e.a.e$a */
    /* compiled from: FlowableOnBackpressureError */
    static final class C13303a<T> extends AtomicLong implements C13773g<T>, C14230c {

        /* renamed from: a */
        final C14229b<? super T> f40422a;

        /* renamed from: b */
        C14230c f40423b;

        /* renamed from: c */
        boolean f40424c;

        C13303a(C14229b<? super T> actual) {
            this.f40422a = actual;
        }

        /* renamed from: a */
        public void mo42355a(C14230c s) {
            if (C13737b.m43736a(this.f40423b, s)) {
                this.f40423b = s;
                this.f40422a.mo42355a(this);
                s.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            if (!this.f40424c) {
                if (get() != 0) {
                    this.f40422a.onNext(t);
                    C13742d.m43751b(this, 1);
                } else {
                    onError(new MissingBackpressureException("could not emit value due to lack of requests"));
                }
            }
        }

        public void onError(Throwable t) {
            if (this.f40424c) {
                C13774a.m43836b(t);
                return;
            }
            this.f40424c = true;
            this.f40422a.onError(t);
        }

        public void onComplete() {
            if (!this.f40424c) {
                this.f40424c = true;
                this.f40422a.onComplete();
            }
        }

        public void request(long n) {
            if (C13737b.m43735a(n)) {
                C13742d.m43750a((AtomicLong) this, n);
            }
        }

        public void cancel() {
            this.f40423b.cancel();
        }
    }

    public C13302e(C13764f<T> source) {
        super(source);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42351b(C14229b<? super T> s) {
        this.f40399b.mo42780a((C13773g<? super T>) new C13303a<Object>(s));
    }
}
