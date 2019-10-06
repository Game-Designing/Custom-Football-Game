package p019d.p143b.p144a.p146b;

import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.b.d */
class C6994d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6988a f12994a;

    C6994d(C6988a aVar) {
        this.f12994a = aVar;
    }

    public void run() {
        if (this.f12994a.f12975s != null) {
            C7262l b = this.f12994a.f12961e;
            StringBuilder sb = new StringBuilder();
            sb.append("Detaching expanded ad: ");
            sb.append(this.f12994a.f12975s.mo22713a());
            b.mo22918c("AppLovinAdView", sb.toString());
            C6988a aVar = this.f12994a;
            aVar.f12976t = aVar.f12975s;
            this.f12994a.f12975s = null;
            C6988a aVar2 = this.f12994a;
            aVar2.m14374a(aVar2.f12962f);
        }
    }
}
