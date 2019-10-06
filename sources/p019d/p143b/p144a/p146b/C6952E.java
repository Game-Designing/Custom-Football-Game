package p019d.p143b.p144a.p146b;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import com.applovin.adview.C5856b;
import p019d.p143b.p144a.p147c.C7043Ac;
import p019d.p143b.p144a.p147c.C7171ja;
import p019d.p143b.p144a.p147c.C7209sc;
import p019d.p143b.p144a.p147c.C7212tb;
import p019d.p143b.p144a.p147c.C7234z;

/* renamed from: d.b.a.b.E */
class C6952E implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6988a f12887a;

    C6952E(C6988a aVar) {
        this.f12887a = aVar;
    }

    public void run() {
        if (this.f12887a.f12975s == null && (this.f12887a.f12972p instanceof C7043Ac) && this.f12887a.f12968l != null) {
            C7043Ac ac = (C7043Ac) this.f12887a.f12972p;
            Object f = this.f12887a.f12957a;
            if (!(f instanceof Activity)) {
                f = C7209sc.m15463a((View) this.f12887a.f12968l, this.f12887a.f12959c);
            }
            if (f instanceof Activity) {
                if (this.f12887a.f12958b != null) {
                    this.f12887a.f12958b.removeView(this.f12887a.f12968l);
                }
                C6988a aVar = this.f12887a;
                C7030v vVar = new C7030v(ac, aVar.f12964h, this.f12887a.f12968l, (Activity) f, this.f12887a.f12959c);
                aVar.f12975s = vVar;
                this.f12887a.f12975s.setOnDismissListener(new C7001ga(this));
                this.f12887a.f12975s.show();
                C7171ja.m15274a(this.f12887a.f12954B, this.f12887a.f12972p, (C5856b) this.f12887a.f12958b, this.f12887a.f12959c);
                if (this.f12887a.f12965i != null) {
                    this.f12887a.f12965i.mo22890d();
                }
            } else {
                this.f12887a.f12961e.mo22921e("AppLovinAdView", "Unable to expand ad. No Activity found.");
                Uri ja = ac.mo22408ja();
                C7212tb tbVar = new C7212tb(this.f12887a.f12959c);
                if (ja != null && tbVar.mo23268J()) {
                    this.f12887a.f12960d.mo23005a((C7234z) ac, this.f12887a.f12964h, this.f12887a.mo22592k(), this.f12887a, ja);
                    if (this.f12887a.f12965i != null) {
                        this.f12887a.f12965i.mo22886b();
                    }
                }
                this.f12887a.f12968l.mo22531a("javascript:al_onFailedExpand();");
            }
        }
    }
}
