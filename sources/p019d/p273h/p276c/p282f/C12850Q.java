package p019d.p273h.p276c.p282f;

/* renamed from: d.h.c.f.Q */
/* compiled from: ListenersWrapper */
class C12850Q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f39577a;

    /* renamed from: b */
    final /* synthetic */ C12858Z f39578b;

    C12850Q(C12858Z this$0, String str) {
        this.f39578b = this$0;
        this.f39577a = str;
    }

    public void run() {
        this.f39578b.f39596d.onInterstitialAdShowSucceeded(this.f39577a);
    }
}
