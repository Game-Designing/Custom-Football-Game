package p320f.p321a.p342f;

import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p340j.C13746h;

/* renamed from: f.a.f.c */
/* compiled from: DisposableObserver */
public abstract class C13767c<T> implements C13804t<T>, C13194b {

    /* renamed from: a */
    final AtomicReference<C13194b> f41886a = new AtomicReference<>();

    public final void onSubscribe(C13194b s) {
        if (C13746h.m43760a(this.f41886a, s, getClass())) {
            mo42786a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo42786a() {
    }

    public final void dispose() {
        C13218c.m43150a(this.f41886a);
    }
}
