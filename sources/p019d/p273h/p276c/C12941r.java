package p019d.p273h.p276c;

/* renamed from: d.h.c.r */
/* compiled from: ISListenerWrapper */
class C12941r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12950x f39844a;

    C12941r(C12950x this$0) {
        this.f39844a = this$0;
    }

    public void run() {
        synchronized (this) {
            this.f39844a.f39856b.mo41609a();
            this.f39844a.m42159a("onInterstitialAdReady()");
        }
    }
}
