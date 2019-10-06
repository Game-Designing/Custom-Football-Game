package p026rx.p390c.p391a;

import p026rx.C0125T;
import p026rx.C0126V.C0127a;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.p027b.C0128a;

/* renamed from: rx.c.a.ea */
/* compiled from: OnSubscribeTimerPeriodically */
class C14659ea implements C0128a {

    /* renamed from: a */
    long f43639a;

    /* renamed from: b */
    final /* synthetic */ C14980ia f43640b;

    /* renamed from: c */
    final /* synthetic */ C0127a f43641c;

    /* renamed from: d */
    final /* synthetic */ C14663fa f43642d;

    C14659ea(C14663fa faVar, C14980ia iaVar, C0127a aVar) {
        this.f43642d = faVar;
        this.f43640b = iaVar;
        this.f43641c = aVar;
    }

    public void call() {
        try {
            C14980ia iaVar = this.f43640b;
            long j = this.f43639a;
            this.f43639a = 1 + j;
            iaVar.onNext(Long.valueOf(j));
        } catch (Throwable th) {
            C14927a.m46672a(e, (C0125T<?>) this.f43640b);
            throw th;
        }
    }
}
