package p026rx;

import p026rx.p390c.p395e.C14899t;

/* renamed from: rx.ha */
/* compiled from: SingleSubscriber */
public abstract class C14972ha<T> implements C0137ja {

    /* renamed from: a */
    private final C14899t f44320a = new C14899t();

    /* renamed from: a */
    public abstract void mo45712a(T t);

    public abstract void onError(Throwable th);

    /* renamed from: b */
    public final void mo46195b(C0137ja s) {
        this.f44320a.mo46107a(s);
    }

    public final void unsubscribe() {
        this.f44320a.unsubscribe();
    }

    public final boolean isUnsubscribed() {
        return this.f44320a.isUnsubscribed();
    }
}
