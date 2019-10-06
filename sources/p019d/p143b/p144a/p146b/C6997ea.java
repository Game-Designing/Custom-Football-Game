package p019d.p143b.p144a.p146b;

import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.b.ea */
class C6997ea implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f12997a;

    /* renamed from: b */
    final /* synthetic */ int f12998b;

    /* renamed from: c */
    final /* synthetic */ C6995da f12999c;

    C6997ea(C6995da daVar, int i, int i2) {
        this.f12999c = daVar;
        this.f12997a = i;
        this.f12998b = i2;
    }

    public void run() {
        C7262l lVar = this.f12999c.f12995a.f12862f;
        StringBuilder sb = new StringBuilder();
        sb.append("Video view error (");
        sb.append(this.f12997a);
        sb.append(",");
        sb.append(this.f12998b);
        sb.append(").");
        lVar.mo22916b("InterActivity", sb.toString());
        this.f12999c.f12995a.mo22499f();
    }
}
