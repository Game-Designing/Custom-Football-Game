package p026rx.p390c.p391a;

import java.util.concurrent.atomic.AtomicBoolean;
import p026rx.C0137ja;
import p026rx.C14980ia;
import p026rx.p027b.C0129b;

/* renamed from: rx.c.a.T */
/* compiled from: OnSubscribeRefCount */
class C14624T implements C0129b<C0137ja> {

    /* renamed from: a */
    final /* synthetic */ C14980ia f43560a;

    /* renamed from: b */
    final /* synthetic */ AtomicBoolean f43561b;

    /* renamed from: c */
    final /* synthetic */ C14630W f43562c;

    C14624T(C14630W w, C14980ia iaVar, AtomicBoolean atomicBoolean) {
        this.f43562c = w;
        this.f43560a = iaVar;
        this.f43561b = atomicBoolean;
    }

    /* renamed from: a */
    public void call(C0137ja subscription) {
        try {
            this.f43562c.f43577b.mo3713a(subscription);
            this.f43562c.mo45797a(this.f43560a, this.f43562c.f43577b);
        } finally {
            this.f43562c.f43579d.unlock();
            this.f43561b.set(false);
        }
    }
}
