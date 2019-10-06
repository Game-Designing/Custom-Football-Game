package p026rx.p390c.p394d;

import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0137ja;
import p026rx.exceptions.C14927a;
import p026rx.p027b.C14540n;
import p026rx.p400f.C14948s;

/* renamed from: rx.c.d.a */
/* compiled from: CancellableSubscription */
public final class C14820a extends AtomicReference<C14540n> implements C0137ja {
    public C14820a(C14540n cancellable) {
        super(cancellable);
    }

    public boolean isUnsubscribed() {
        return get() == null;
    }

    public void unsubscribe() {
        if (get() != null) {
            C14540n c = (C14540n) getAndSet(null);
            if (c != null) {
                try {
                    c.cancel();
                } catch (Exception ex) {
                    C14927a.m46678c(ex);
                    C14948s.m46719b((Throwable) ex);
                }
            }
        }
    }
}
