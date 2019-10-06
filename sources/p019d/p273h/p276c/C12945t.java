package p019d.p273h.p276c;

/* renamed from: d.h.c.t */
/* compiled from: ISListenerWrapper */
class C12945t implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12950x f39850a;

    C12945t(C12950x this$0) {
        this.f39850a = this$0;
    }

    public void run() {
        synchronized (this) {
            this.f39850a.f39856b.mo41617b();
            this.f39850a.m42159a("onInterstitialAdClosed()");
        }
    }
}
