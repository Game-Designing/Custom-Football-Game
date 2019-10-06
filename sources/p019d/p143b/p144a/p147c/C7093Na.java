package p019d.p143b.p144a.p147c;

import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7254d;

/* renamed from: d.b.a.c.Na */
class C7093Na implements C7254d {

    /* renamed from: a */
    final /* synthetic */ long f13312a;

    /* renamed from: b */
    final /* synthetic */ C7053Da f13313b;

    /* renamed from: c */
    final /* synthetic */ C7235za f13314c;

    /* renamed from: d */
    final /* synthetic */ C7254d f13315d;

    /* renamed from: e */
    final /* synthetic */ C7150e f13316e;

    C7093Na(C7150e eVar, long j, C7053Da da, C7235za zaVar, C7254d dVar) {
        this.f13316e = eVar;
        this.f13312a = j;
        this.f13313b = da;
        this.f13314c = zaVar;
        this.f13315d = dVar;
    }

    public void adReceived(C7251a aVar) {
        long currentTimeMillis = System.currentTimeMillis() - this.f13312a;
        synchronized (this.f13316e.f13501d) {
            this.f13316e.f13503f = this.f13313b.mo22781a();
            this.f13316e.f13502e = currentTimeMillis;
        }
        C7086Lb.m14819a(this.f13314c, this.f13316e.f13498a);
        C7086Lb.m14818a(currentTimeMillis, (C7071Hc) this.f13314c, this.f13316e.f13498a);
        if (((Boolean) this.f13316e.f13498a.mo23039a(C7196pb.f13703Hd)).booleanValue()) {
            this.f13316e.f13500c.mo22749a(this.f13313b);
        }
        this.f13316e.m15146a(aVar, this.f13315d);
    }

    public void failedToReceiveAd(int i) {
        this.f13316e.m15145a(this.f13314c, i, this.f13315d);
    }
}
