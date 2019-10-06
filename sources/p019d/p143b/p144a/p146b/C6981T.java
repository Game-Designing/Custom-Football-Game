package p019d.p143b.p144a.p146b;

import p019d.p143b.p144a.p147c.C7113Tb;
import p019d.p143b.p144a.p147c.C7169ic;

/* renamed from: d.b.a.b.T */
class C6981T implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6950D f12946a;

    C6981T(C6950D d) {
        this.f12946a = d;
    }

    public void run() {
        if (this.f12946a.f12865i != null && !this.f12946a.f12865i.mo23416V().getAndSet(true)) {
            this.f12946a.f12864h.mo23027C().mo22970a((C7184mb) new C7169ic(this.f12946a.f12865i, this.f12946a.f12864h), C7113Tb.BACKGROUND);
        }
    }
}
