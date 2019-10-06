package p026rx.p390c.p391a;

import java.util.concurrent.TimeUnit;
import p026rx.C0126V.C0127a;
import p026rx.C0137ja;

/* renamed from: rx.c.a.hb */
/* compiled from: OperatorTimeout */
class C14671hb implements C14681b<T> {

    /* renamed from: a */
    final /* synthetic */ long f43675a;

    /* renamed from: b */
    final /* synthetic */ TimeUnit f43676b;

    C14671hb(long j, TimeUnit timeUnit) {
        this.f43675a = j;
        this.f43676b = timeUnit;
    }

    /* renamed from: a */
    public C0137ja mo45721a(C14682c<T> timeoutSubscriber, Long seqId, T t, C0127a inner) {
        return inner.mo3709a(new C14668gb(this, timeoutSubscriber, seqId), this.f43675a, this.f43676b);
    }
}
