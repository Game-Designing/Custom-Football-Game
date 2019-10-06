package p026rx.p029i;

import p026rx.C0137ja;
import p026rx.p390c.p394d.C14821b;

/* renamed from: rx.i.e */
/* compiled from: SerialSubscription */
public final class C14977e implements C0137ja {

    /* renamed from: a */
    final C14821b f44328a = new C14821b();

    public boolean isUnsubscribed() {
        return this.f44328a.isUnsubscribed();
    }

    public void unsubscribe() {
        this.f44328a.unsubscribe();
    }

    /* renamed from: a */
    public void mo46198a(C0137ja s) {
        if (s != null) {
            this.f44328a.mo45949b(s);
            return;
        }
        throw new IllegalArgumentException("Subscription can not be null");
    }

    /* renamed from: a */
    public C0137ja mo46197a() {
        return this.f44328a.mo45947a();
    }
}
