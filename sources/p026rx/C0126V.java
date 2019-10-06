package p026rx;

import java.util.concurrent.TimeUnit;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0132p;
import p026rx.p390c.p393c.C14803r;
import p026rx.p390c.p393c.C14814y;

/* renamed from: rx.V */
/* compiled from: Scheduler */
public abstract class C0126V {

    /* renamed from: rx.V$a */
    /* compiled from: Scheduler */
    public static abstract class C0127a implements C0137ja {
        /* renamed from: a */
        public abstract C0137ja mo3707a(C0128a aVar);

        /* renamed from: a */
        public abstract C0137ja mo3709a(C0128a aVar, long j, TimeUnit timeUnit);

        /* renamed from: a */
        public C0137ja mo3708a(C0128a action, long initialDelay, long period, TimeUnit unit) {
            return C14803r.m46467a(this, action, initialDelay, period, unit, null);
        }

        /* renamed from: b */
        public long mo3710b() {
            return System.currentTimeMillis();
        }
    }

    public abstract C0127a createWorker();

    public long now() {
        return System.currentTimeMillis();
    }

    public <S extends C0126V & C0137ja> S when(C0132p<C0120S<C0120S<C0117M>>, C0117M> combine) {
        return new C14814y(combine, this);
    }
}
