package p026rx.p029i;

import p026rx.C0137ja;
import p026rx.p390c.p394d.C14821b;

/* renamed from: rx.i.d */
/* compiled from: MultipleAssignmentSubscription */
public final class C14976d implements C0137ja {

    /* renamed from: a */
    final C14821b f44327a = new C14821b();

    public boolean isUnsubscribed() {
        return this.f44327a.isUnsubscribed();
    }

    public void unsubscribe() {
        this.f44327a.unsubscribe();
    }

    /* renamed from: a */
    public void mo46196a(C0137ja s) {
        if (s != null) {
            this.f44327a.mo45948a(s);
            return;
        }
        throw new IllegalArgumentException("Subscription can not be null");
    }
}
