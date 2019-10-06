package p026rx.p390c.p391a;

import p026rx.C0125T;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.p027b.C0128a;

/* renamed from: rx.c.a.ca */
/* compiled from: OnSubscribeTimerOnce */
class C14650ca implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C14980ia f43618a;

    /* renamed from: b */
    final /* synthetic */ C14655da f43619b;

    C14650ca(C14655da daVar, C14980ia iaVar) {
        this.f43619b = daVar;
        this.f43618a = iaVar;
    }

    public void call() {
        try {
            this.f43618a.onNext(Long.valueOf(0));
            this.f43618a.onCompleted();
        } catch (Throwable t) {
            C14927a.m46672a(t, (C0125T<?>) this.f43618a);
        }
    }
}
