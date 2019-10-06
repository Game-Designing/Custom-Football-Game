package p019d.p143b.p144a.p146b;

import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.b.ba */
class C6991ba implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f12987a;

    /* renamed from: b */
    final /* synthetic */ int f12988b;

    /* renamed from: c */
    final /* synthetic */ C6989aa f12989c;

    C6991ba(C6989aa aaVar, int i, int i2) {
        this.f12989c = aaVar;
        this.f12987a = i;
        this.f12988b = i2;
    }

    public void run() {
        C7262l lVar = this.f12989c.f12983a.f12952a.f12862f;
        StringBuilder sb = new StringBuilder();
        sb.append("Media player error (");
        sb.append(this.f12987a);
        sb.append(",");
        sb.append(this.f12988b);
        sb.append(").");
        lVar.mo22916b("InterActivity", sb.toString());
        this.f12989c.f12983a.f12952a.mo22499f();
    }
}
