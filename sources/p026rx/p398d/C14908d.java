package p026rx.p398d;

import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p027b.C14537m;
import p026rx.p390c.p391a.C14630W;
import p026rx.p390c.p391a.C14695n;

/* renamed from: rx.d.d */
/* compiled from: ConnectableObservable */
public abstract class C14908d<T> extends C0120S<T> {
    /* renamed from: d */
    public abstract void mo45763d(C0129b<? super C0137ja> bVar);

    protected C14908d(C0122a<T> onSubscribe) {
        super(onSubscribe);
    }

    /* renamed from: p */
    public final C0137ja mo46116p() {
        C0137ja[] out = new C0137ja[1];
        mo45763d(new C14907c(this, out));
        return out[0];
    }

    /* renamed from: q */
    public C0120S<T> mo46117q() {
        return C0120S.m648b((C0122a<T>) new C14630W<T>(this));
    }

    /* renamed from: o */
    public C0120S<T> mo46115o() {
        return mo46114c(1);
    }

    /* renamed from: c */
    public C0120S<T> mo46114c(int numberOfSubscribers) {
        return mo46113a(numberOfSubscribers, C14537m.m46177a());
    }

    /* renamed from: a */
    public C0120S<T> mo46113a(int numberOfSubscribers, C0129b<? super C0137ja> connection) {
        if (numberOfSubscribers > 0) {
            return C0120S.m648b((C0122a<T>) new C14695n<T>(this, numberOfSubscribers, connection));
        }
        mo45763d(connection);
        return this;
    }
}
