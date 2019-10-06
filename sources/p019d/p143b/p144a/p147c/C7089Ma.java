package p019d.p143b.p144a.p147c;

import p019d.p143b.p148b.C7239b;
import p019d.p143b.p150d.C7258h;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.Ma */
class C7089Ma extends C7184mb {

    /* renamed from: f */
    private final C7085La f13299f;

    /* renamed from: g */
    final /* synthetic */ C7053Da f13300g;

    private C7089Ma(C7053Da da, C7085La la) {
        this.f13300g = da;
        super("TaskTimeoutMediatedAd", da.f13180c);
        if (la != null) {
            this.f13299f = la;
            return;
        }
        throw new IllegalArgumentException("No loadState specified");
    }

    /* synthetic */ C7089Ma(C7053Da da, C7085La la, C7057Ea ea) {
        this(da, la);
    }

    public void run() {
        C7262l lVar = this.f13626c;
        String str = this.f13624a;
        StringBuilder sb = new StringBuilder();
        sb.append("Timing out ");
        sb.append(this.f13299f.f13284a);
        sb.append("...");
        lVar.mo22913a(str, sb.toString());
        C7239b d = this.f13300g.mo22789d();
        if (this.f13299f.f13284a.mo22759d().equals(C7258h.f14103b)) {
            d.mo23458b();
        } else {
            d.mo23453a();
        }
        this.f13300g.m14642a(-5101, this.f13299f);
    }
}
