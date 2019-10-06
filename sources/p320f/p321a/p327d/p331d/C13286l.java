package p320f.p321a.p327d.p331d;

import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13224i;

/* renamed from: f.a.d.d.l */
/* compiled from: FullArbiterObserver */
public final class C13286l<T> implements C13804t<T> {

    /* renamed from: a */
    final C13224i<T> f40379a;

    /* renamed from: b */
    C13194b f40380b;

    public C13286l(C13224i<T> arbiter) {
        this.f40379a = arbiter;
    }

    public void onSubscribe(C13194b s) {
        if (C13218c.m43149a(this.f40380b, s)) {
            this.f40380b = s;
            this.f40379a.mo42285b(s);
        }
    }

    public void onNext(T t) {
        this.f40379a.mo42283a(t, this.f40380b);
    }

    public void onError(Throwable t) {
        this.f40379a.mo42282a(t, this.f40380b);
    }

    public void onComplete() {
        this.f40379a.mo42281a(this.f40380b);
    }
}
