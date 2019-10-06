package p320f.p321a.p327d.p332e.p333a;

import java.util.concurrent.atomic.AtomicLong;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13764f;
import p320f.p321a.C13773g;
import p320f.p321a.p326c.C13204f;
import p320f.p321a.p327d.p339i.C13737b;
import p320f.p321a.p327d.p340j.C13742d;
import p320f.p321a.p343g.C13774a;
import p363i.p368b.C14229b;
import p363i.p368b.C14230c;

/* renamed from: f.a.d.e.a.d */
/* compiled from: FlowableOnBackpressureDrop */
public final class C13300d<T> extends C13295a<T, T> implements C13204f<T> {

    /* renamed from: c */
    final C13204f<? super T> f40417c = this;

    /* renamed from: f.a.d.e.a.d$a */
    /* compiled from: FlowableOnBackpressureDrop */
    static final class C13301a<T> extends AtomicLong implements C13773g<T>, C14230c {

        /* renamed from: a */
        final C14229b<? super T> f40418a;

        /* renamed from: b */
        final C13204f<? super T> f40419b;

        /* renamed from: c */
        C14230c f40420c;

        /* renamed from: d */
        boolean f40421d;

        C13301a(C14229b<? super T> actual, C13204f<? super T> onDrop) {
            this.f40418a = actual;
            this.f40419b = onDrop;
        }

        /* renamed from: a */
        public void mo42355a(C14230c s) {
            if (C13737b.m43736a(this.f40420c, s)) {
                this.f40420c = s;
                this.f40418a.mo42355a(this);
                s.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            if (!this.f40421d) {
                if (get() != 0) {
                    this.f40418a.onNext(t);
                    C13742d.m43751b(this, 1);
                } else {
                    try {
                        this.f40419b.accept(t);
                    } catch (Throwable e) {
                        C13980a.m44462b(e);
                        cancel();
                        onError(e);
                    }
                }
            }
        }

        public void onError(Throwable t) {
            if (this.f40421d) {
                C13774a.m43836b(t);
                return;
            }
            this.f40421d = true;
            this.f40418a.onError(t);
        }

        public void onComplete() {
            if (!this.f40421d) {
                this.f40421d = true;
                this.f40418a.onComplete();
            }
        }

        public void request(long n) {
            if (C13737b.m43735a(n)) {
                C13742d.m43750a((AtomicLong) this, n);
            }
        }

        public void cancel() {
            this.f40420c.cancel();
        }
    }

    public C13300d(C13764f<T> source) {
        super(source);
    }

    public void accept(T t) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42351b(C14229b<? super T> s) {
        this.f40399b.mo42780a((C13773g<? super T>) new C13301a<Object>(s, this.f40417c));
    }
}
