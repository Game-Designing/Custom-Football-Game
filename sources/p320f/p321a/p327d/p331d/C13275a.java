package p320f.p321a.p327d.p331d;

import io.reactivex.internal.fuseable.QueueDisposable;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p330c.C13269d;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.d.a */
/* compiled from: BasicFuseableObserver */
public abstract class C13275a<T, R> implements C13804t<T>, C13269d<R> {

    /* renamed from: a */
    protected final C13804t<? super R> f40354a;

    /* renamed from: b */
    protected C13194b f40355b;

    /* renamed from: c */
    protected C13269d<T> f40356c;

    /* renamed from: d */
    protected boolean f40357d;

    /* renamed from: e */
    protected int f40358e;

    public C13275a(C13804t<? super R> actual) {
        this.f40354a = actual;
    }

    public final void onSubscribe(C13194b s) {
        if (C13218c.m43149a(this.f40355b, s)) {
            this.f40355b = s;
            if (s instanceof C13269d) {
                this.f40356c = (C13269d) s;
            }
            if (mo42321b()) {
                this.f40354a.onSubscribe(this);
                mo42318a();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo42321b() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo42318a() {
    }

    public void onError(Throwable t) {
        if (this.f40357d) {
            C13774a.m43836b(t);
            return;
        }
        this.f40357d = true;
        this.f40354a.onError(t);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo42319a(Throwable t) {
        C13980a.m44462b(t);
        this.f40355b.dispose();
        onError(t);
    }

    public void onComplete() {
        if (!this.f40357d) {
            this.f40357d = true;
            this.f40354a.onComplete();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final int mo42320b(int mode) {
        QueueDisposable<T> qs = this.f40356c;
        if (qs == null || (mode & 4) != 0) {
            return 0;
        }
        int m = qs.mo42274a(mode);
        if (m != 0) {
            this.f40358e = m;
        }
        return m;
    }

    public void dispose() {
        this.f40355b.dispose();
    }

    public boolean isEmpty() {
        return this.f40356c.isEmpty();
    }

    public void clear() {
        this.f40356c.clear();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
