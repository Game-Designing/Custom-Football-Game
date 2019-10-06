package p019d.p143b.p144a.p146b;

/* renamed from: d.b.a.b.ya */
class C7037ya implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f13131a;

    /* renamed from: b */
    final /* synthetic */ C6988a f13132b;

    C7037ya(C6988a aVar, int i) {
        this.f13132b = aVar;
        this.f13131a = i;
    }

    public void run() {
        try {
            if (this.f13132b.f12982z != null) {
                this.f13132b.f12982z.failedToReceiveAd(this.f13131a);
            }
        } catch (Throwable th) {
            this.f13132b.f12961e.mo22919c("AppLovinAdView", "Exception while running app load  callback", th);
        }
    }
}
