package p019d.p273h.p276c.p282f;

/* renamed from: d.h.c.f.G */
/* compiled from: ListenersWrapper */
class C12840G implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f39553a;

    /* renamed from: b */
    final /* synthetic */ C12858Z f39554b;

    C12840G(C12858Z this$0, String str) {
        this.f39554b = this$0;
        this.f39553a = str;
    }

    public void run() {
        this.f39554b.f39594b.onRewardedVideoAdClosed(this.f39553a);
    }
}
