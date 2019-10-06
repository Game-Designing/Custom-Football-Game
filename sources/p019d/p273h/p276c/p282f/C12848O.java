package p019d.p273h.p276c.p282f;

/* renamed from: d.h.c.f.O */
/* compiled from: ListenersWrapper */
class C12848O implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f39573a;

    /* renamed from: b */
    final /* synthetic */ C12858Z f39574b;

    C12848O(C12858Z this$0, String str) {
        this.f39574b = this$0;
        this.f39573a = str;
    }

    public void run() {
        this.f39574b.f39596d.onInterstitialAdOpened(this.f39573a);
    }
}
