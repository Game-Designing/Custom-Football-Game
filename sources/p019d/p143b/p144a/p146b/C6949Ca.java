package p019d.p143b.p144a.p146b;

import android.view.View;
import p019d.p143b.p144a.p147c.C7052D;
import p019d.p143b.p144a.p147c.C7086Lb;
import p019d.p143b.p150d.C7257g;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.b.Ca */
class C6949Ca implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6988a f12835a;

    private C6949Ca(C6988a aVar) {
        this.f12835a = aVar;
    }

    /* synthetic */ C6949Ca(C6988a aVar, C6994d dVar) {
        this(aVar);
    }

    public void run() {
        if (this.f12835a.f12972p != null) {
            String str = "AppLovinAdView";
            if (this.f12835a.f12968l != null) {
                C7262l b = this.f12835a.f12961e;
                StringBuilder sb = new StringBuilder();
                sb.append("Rendering advertisement ad for #");
                sb.append(this.f12835a.f12972p.mo22758b());
                sb.append(" over placement: \"");
                sb.append(this.f12835a.f12964h);
                sb.append("\"...");
                b.mo22918c(str, sb.toString());
                C6988a.m14379b((View) this.f12835a.f12968l, this.f12835a.f12972p.mo22756a());
                this.f12835a.f12968l.mo22530a(this.f12835a.f12972p, this.f12835a.f12964h);
                if (this.f12835a.f12972p.mo22756a() != C7257g.f14096c && !this.f12835a.f12980x && !(this.f12835a.f12972p instanceof C7052D)) {
                    C6988a aVar = this.f12835a;
                    aVar.f12965i = new C7086Lb(aVar.f12972p, this.f12835a.f12959c);
                    this.f12835a.f12965i.mo22884a();
                    this.f12835a.f12968l.mo22529a(this.f12835a.f12965i);
                    return;
                }
                return;
            }
            C7262l b2 = this.f12835a.f12959c.mo23049b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to render advertisement for ad #");
            sb2.append(this.f12835a.f12972p.mo22758b());
            sb2.append(". Please make sure you are not calling AppLovinAdView.destroy() prematurely.");
            b2.mo22921e(str, sb2.toString());
        }
    }
}
