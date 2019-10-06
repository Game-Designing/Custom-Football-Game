package p019d.p273h.p276c.p282f;

/* renamed from: d.h.c.f.P */
/* compiled from: ListenersWrapper */
class C12849P implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f39575a;

    /* renamed from: b */
    final /* synthetic */ C12858Z f39576b;

    C12849P(C12858Z this$0, String str) {
        this.f39576b = this$0;
        this.f39575a = str;
    }

    public void run() {
        this.f39576b.f39596d.onInterstitialAdClosed(this.f39575a);
    }
}
