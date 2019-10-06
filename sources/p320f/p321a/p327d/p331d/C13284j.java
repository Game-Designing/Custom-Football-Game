package p320f.p321a.p327d.p331d;

import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13199a;
import p320f.p321a.p326c.C13204f;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.d.j */
/* compiled from: DisposableLambdaObserver */
public final class C13284j<T> implements C13804t<T>, C13194b {

    /* renamed from: a */
    final C13804t<? super T> f40371a;

    /* renamed from: b */
    final C13204f<? super C13194b> f40372b;

    /* renamed from: c */
    final C13199a f40373c;

    /* renamed from: d */
    C13194b f40374d;

    public C13284j(C13804t<? super T> actual, C13204f<? super C13194b> onSubscribe, C13199a onDispose) {
        this.f40371a = actual;
        this.f40372b = onSubscribe;
        this.f40373c = onDispose;
    }

    public void onSubscribe(C13194b s) {
        try {
            this.f40372b.accept(s);
            if (C13218c.m43149a(this.f40374d, s)) {
                this.f40374d = s;
                this.f40371a.onSubscribe(this);
            }
        } catch (Throwable e) {
            C13980a.m44462b(e);
            s.dispose();
            this.f40374d = C13218c.DISPOSED;
            C13219d.m43157a(e, this.f40371a);
        }
    }

    public void onNext(T t) {
        this.f40371a.onNext(t);
    }

    public void onError(Throwable t) {
        if (this.f40374d != C13218c.DISPOSED) {
            this.f40371a.onError(t);
        } else {
            C13774a.m43836b(t);
        }
    }

    public void onComplete() {
        if (this.f40374d != C13218c.DISPOSED) {
            this.f40371a.onComplete();
        }
    }

    public void dispose() {
        try {
            this.f40373c.run();
        } catch (Throwable e) {
            C13980a.m44462b(e);
            C13774a.m43836b(e);
        }
        this.f40374d.dispose();
    }
}
