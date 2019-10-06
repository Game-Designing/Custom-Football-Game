package p026rx.p390c.p391a;

import java.util.concurrent.TimeUnit;
import p026rx.C0126V.C0127a;
import p026rx.C0137ja;

/* renamed from: rx.c.a.fb */
/* compiled from: OperatorTimeout */
class C14664fb implements C14680a<T> {

    /* renamed from: a */
    final /* synthetic */ long f43653a;

    /* renamed from: b */
    final /* synthetic */ TimeUnit f43654b;

    C14664fb(long j, TimeUnit timeUnit) {
        this.f43653a = j;
        this.f43654b = timeUnit;
    }

    /* renamed from: a */
    public C0137ja call(C14682c<T> timeoutSubscriber, Long seqId, C0127a inner) {
        return inner.mo3709a(new C14660eb(this, timeoutSubscriber, seqId), this.f43653a, this.f43654b);
    }
}
