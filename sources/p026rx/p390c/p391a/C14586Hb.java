package p026rx.p390c.p391a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p026rx.C14972ha;
import p026rx.exceptions.C14927a;
import p026rx.p400f.C14948s;

/* renamed from: rx.c.a.Hb */
/* compiled from: SingleOperatorZip */
class C14586Hb extends C14972ha<T> {

    /* renamed from: b */
    final /* synthetic */ Object[] f43449b;

    /* renamed from: c */
    final /* synthetic */ int f43450c;

    /* renamed from: d */
    final /* synthetic */ AtomicInteger f43451d;

    /* renamed from: e */
    final /* synthetic */ C14972ha f43452e;

    /* renamed from: f */
    final /* synthetic */ AtomicBoolean f43453f;

    /* renamed from: g */
    final /* synthetic */ C14591Ib f43454g;

    C14586Hb(C14591Ib ib, Object[] objArr, int i, AtomicInteger atomicInteger, C14972ha haVar, AtomicBoolean atomicBoolean) {
        this.f43454g = ib;
        this.f43449b = objArr;
        this.f43450c = i;
        this.f43451d = atomicInteger;
        this.f43452e = haVar;
        this.f43453f = atomicBoolean;
    }

    /* renamed from: a */
    public void mo45712a(T value) {
        this.f43449b[this.f43450c] = value;
        if (this.f43451d.decrementAndGet() == 0) {
            try {
                this.f43452e.mo45712a(this.f43454g.f43470b.call(this.f43449b));
            } catch (Throwable e) {
                C14927a.m46678c(e);
                onError(e);
            }
        }
    }

    public void onError(Throwable error) {
        if (this.f43453f.compareAndSet(false, true)) {
            this.f43452e.onError(error);
        } else {
            C14948s.m46719b(error);
        }
    }
}
