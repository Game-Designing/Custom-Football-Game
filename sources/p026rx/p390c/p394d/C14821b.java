package p026rx.p390c.p394d;

import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0137ja;
import p026rx.p029i.C14978f;

/* renamed from: rx.c.d.b */
/* compiled from: SequentialSubscription */
public final class C14821b extends AtomicReference<C0137ja> implements C0137ja {
    public C14821b() {
    }

    public C14821b(C0137ja initial) {
        lazySet(initial);
    }

    /* renamed from: a */
    public C0137ja mo45947a() {
        C0137ja current = (C0137ja) super.get();
        if (current == C14822c.INSTANCE) {
            return C14978f.m46782b();
        }
        return current;
    }

    /* renamed from: b */
    public boolean mo45949b(C0137ja next) {
        C0137ja current;
        do {
            current = (C0137ja) get();
            if (current == C14822c.INSTANCE) {
                if (next != null) {
                    next.unsubscribe();
                }
                return false;
            }
        } while (!compareAndSet(current, next));
        if (current != null) {
            current.unsubscribe();
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo45948a(C0137ja next) {
        C0137ja current;
        do {
            current = (C0137ja) get();
            if (current == C14822c.INSTANCE) {
                if (next != null) {
                    next.unsubscribe();
                }
                return false;
            }
        } while (!compareAndSet(current, next));
        return true;
    }

    public void unsubscribe() {
        C0137ja current = (C0137ja) get();
        C14822c cVar = C14822c.INSTANCE;
        if (current != cVar) {
            C0137ja current2 = (C0137ja) getAndSet(cVar);
            if (current2 != null && current2 != C14822c.INSTANCE) {
                current2.unsubscribe();
            }
        }
    }

    public boolean isUnsubscribed() {
        return get() == C14822c.INSTANCE;
    }
}
