package p026rx.p390c.p393c;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p026rx.C0125T;
import p026rx.C0126V.C0127a;
import p026rx.C0137ja;
import p026rx.p027b.C0128a;

/* renamed from: rx.c.c.w */
/* compiled from: SchedulerWhen */
class C14812w extends C0127a {

    /* renamed from: a */
    private final AtomicBoolean f44059a = new AtomicBoolean();

    /* renamed from: b */
    final /* synthetic */ C0127a f44060b;

    /* renamed from: c */
    final /* synthetic */ C0125T f44061c;

    /* renamed from: d */
    final /* synthetic */ C14814y f44062d;

    C14812w(C14814y yVar, C0127a aVar, C0125T t) {
        this.f44062d = yVar;
        this.f44060b = aVar;
        this.f44061c = t;
    }

    public void unsubscribe() {
        if (this.f44059a.compareAndSet(false, true)) {
            this.f44060b.unsubscribe();
            this.f44061c.onCompleted();
        }
    }

    public boolean isUnsubscribed() {
        return this.f44059a.get();
    }

    /* renamed from: a */
    public C0137ja mo3709a(C0128a action, long delayTime, TimeUnit unit) {
        C14815a delayedAction = new C14815a(action, delayTime, unit);
        this.f44061c.onNext(delayedAction);
        return delayedAction;
    }

    /* renamed from: a */
    public C0137ja mo3707a(C0128a action) {
        C14816b immediateAction = new C14816b(action);
        this.f44061c.onNext(immediateAction);
        return immediateAction;
    }
}
