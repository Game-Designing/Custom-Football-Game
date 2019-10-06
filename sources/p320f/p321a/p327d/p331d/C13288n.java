package p320f.p321a.p327d.p331d;

import io.reactivex.internal.fuseable.QueueDisposable;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p330c.C13269d;
import p320f.p321a.p327d.p330c.C13274i;
import p320f.p321a.p327d.p340j.C13759r;

/* renamed from: f.a.d.d.n */
/* compiled from: InnerQueuedObserver */
public final class C13288n<T> extends AtomicReference<C13194b> implements C13804t<T>, C13194b {

    /* renamed from: a */
    final C13289o<T> f40384a;

    /* renamed from: b */
    final int f40385b;

    /* renamed from: c */
    C13274i<T> f40386c;

    /* renamed from: d */
    volatile boolean f40387d;

    /* renamed from: e */
    int f40388e;

    public C13288n(C13289o<T> parent, int prefetch) {
        this.f40384a = parent;
        this.f40385b = prefetch;
    }

    public void onSubscribe(C13194b s) {
        if (C13218c.m43153c(this, s)) {
            if (s instanceof C13269d) {
                QueueDisposable<T> qs = (C13269d) s;
                int m = qs.mo42274a(3);
                if (m == 1) {
                    this.f40388e = m;
                    this.f40386c = qs;
                    this.f40387d = true;
                    this.f40384a.mo42338a(this);
                    return;
                } else if (m == 2) {
                    this.f40388e = m;
                    this.f40386c = qs;
                    return;
                }
            }
            this.f40386c = C13759r.m43797a(-this.f40385b);
        }
    }

    public void onNext(T t) {
        if (this.f40388e == 0) {
            this.f40384a.mo42339a(this, t);
        } else {
            this.f40384a.mo42337a();
        }
    }

    public void onError(Throwable t) {
        this.f40384a.mo42340a(this, t);
    }

    public void onComplete() {
        this.f40384a.mo42338a(this);
    }

    public void dispose() {
        C13218c.m43150a((AtomicReference<C13194b>) this);
    }

    /* renamed from: a */
    public boolean mo42334a() {
        return this.f40387d;
    }

    /* renamed from: c */
    public void mo42336c() {
        this.f40387d = true;
    }

    /* renamed from: b */
    public C13274i<T> mo42335b() {
        return this.f40386c;
    }
}
