package p019d.p273h.p276c.p282f;

/* renamed from: d.h.c.f.L */
/* compiled from: ListenersWrapper */
class C12845L implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f39567a;

    /* renamed from: b */
    final /* synthetic */ C12858Z f39568b;

    C12845L(C12858Z this$0, String str) {
        this.f39568b = this$0;
        this.f39567a = str;
    }

    public void run() {
        this.f39568b.f39596d.onInterstitialAdReady(this.f39567a);
    }
}
