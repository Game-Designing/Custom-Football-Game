package p019d.p143b.p144a.p146b;

import com.applovin.adview.C5856b;
import p019d.p143b.p144a.p147c.C7171ja;
import p019d.p143b.p150d.C7251a;

/* renamed from: d.b.a.b.za */
class C7039za implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6988a f13134a;

    C7039za(C6988a aVar) {
        this.f13134a = aVar;
    }

    public void run() {
        C7251a aVar;
        if (this.f13134a.f12976t != null || this.f13134a.f12975s != null) {
            if (this.f13134a.f12976t != null) {
                aVar = this.f13134a.f12976t.mo22713a();
                this.f13134a.f12976t.dismiss();
                this.f13134a.f12976t = null;
            } else if (this.f13134a.f12975s != null) {
                aVar = this.f13134a.f12975s.mo22713a();
                this.f13134a.f12975s.dismiss();
                this.f13134a.f12975s = null;
            } else {
                aVar = null;
            }
            C7171ja.m15283b(this.f13134a.f12954B, aVar, (C5856b) this.f13134a.f12958b, this.f13134a.f12959c);
        }
    }
}
