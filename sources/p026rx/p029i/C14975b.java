package p026rx.p029i;

import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0137ja;
import p026rx.p027b.C0128a;

/* renamed from: rx.i.b */
/* compiled from: BooleanSubscription */
public final class C14975b implements C0137ja {

    /* renamed from: a */
    static final C0128a f44325a = new C14974a();

    /* renamed from: b */
    final AtomicReference<C0128a> f44326b;

    public C14975b() {
        this.f44326b = new AtomicReference<>();
    }

    private C14975b(C0128a action) {
        this.f44326b = new AtomicReference<>(action);
    }

    /* renamed from: a */
    public static C14975b m46775a() {
        return new C14975b();
    }

    /* renamed from: a */
    public static C14975b m46776a(C0128a onUnsubscribe) {
        return new C14975b(onUnsubscribe);
    }

    public boolean isUnsubscribed() {
        return this.f44326b.get() == f44325a;
    }

    public void unsubscribe() {
        C0128a action = (C0128a) this.f44326b.get();
        C0128a aVar = f44325a;
        if (action != aVar) {
            C0128a action2 = (C0128a) this.f44326b.getAndSet(aVar);
            if (action2 != null && action2 != f44325a) {
                action2.call();
            }
        }
    }
}
