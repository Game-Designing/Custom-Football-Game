package p026rx.p390c.p391a;

import p026rx.C0125T;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;

/* renamed from: rx.c.a.sa */
/* compiled from: OperatorDistinctUntilChanged */
class C14724sa extends C14980ia<T> {

    /* renamed from: a */
    U f43810a;

    /* renamed from: b */
    boolean f43811b;

    /* renamed from: c */
    final /* synthetic */ C14980ia f43812c;

    /* renamed from: d */
    final /* synthetic */ C14727ta f43813d;

    C14724sa(C14727ta taVar, C14980ia x0, C14980ia iaVar) {
        this.f43813d = taVar;
        this.f43812c = iaVar;
        super(x0);
    }

    public void onNext(T t) {
        try {
            U key = this.f43813d.f43817a.call(t);
            U currentKey = this.f43810a;
            this.f43810a = key;
            if (this.f43811b) {
                try {
                    if (!((Boolean) this.f43813d.f43818b.call(currentKey, key)).booleanValue()) {
                        this.f43812c.onNext(t);
                    } else {
                        request(1);
                    }
                } catch (Throwable e) {
                    C14927a.m46673a(e, (C0125T<?>) this.f43812c, (Object) key);
                }
            } else {
                this.f43811b = true;
                this.f43812c.onNext(t);
            }
        } catch (Throwable e2) {
            C14927a.m46673a(e2, (C0125T<?>) this.f43812c, (Object) t);
        }
    }

    public void onError(Throwable e) {
        this.f43812c.onError(e);
    }

    public void onCompleted() {
        this.f43812c.onCompleted();
    }
}
