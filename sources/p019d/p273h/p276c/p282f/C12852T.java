package p019d.p273h.p276c.p282f;

/* renamed from: d.h.c.f.T */
/* compiled from: ListenersWrapper */
class C12852T implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f39582a;

    /* renamed from: b */
    final /* synthetic */ C12858Z f39583b;

    C12852T(C12858Z this$0, String str) {
        this.f39583b = this$0;
        this.f39582a = str;
    }

    public void run() {
        this.f39583b.f39596d.onInterstitialAdClicked(this.f39582a);
    }
}
