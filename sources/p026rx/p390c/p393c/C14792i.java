package p026rx.p390c.p393c;

import p026rx.C0137ja;
import p026rx.p027b.C0128a;
import p026rx.p029i.C14976d;

/* renamed from: rx.c.c.i */
/* compiled from: ExecutorScheduler */
class C14792i implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C14976d f44007a;

    /* renamed from: b */
    final /* synthetic */ C0128a f44008b;

    /* renamed from: c */
    final /* synthetic */ C0137ja f44009c;

    /* renamed from: d */
    final /* synthetic */ C14794a f44010d;

    C14792i(C14794a aVar, C14976d dVar, C0128a aVar2, C0137ja jaVar) {
        this.f44010d = aVar;
        this.f44007a = dVar;
        this.f44008b = aVar2;
        this.f44009c = jaVar;
    }

    public void call() {
        if (!this.f44007a.isUnsubscribed()) {
            C0137ja s2 = this.f44010d.mo3707a(this.f44008b);
            this.f44007a.mo46196a(s2);
            if (s2.getClass() == C14805s.class) {
                ((C14805s) s2).mo45942a(this.f44009c);
            }
        }
    }
}
