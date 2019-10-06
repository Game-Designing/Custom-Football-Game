package p019d.p273h.p276c.p282f;

/* renamed from: d.h.c.f.F */
/* compiled from: ListenersWrapper */
class C12839F implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f39551a;

    /* renamed from: b */
    final /* synthetic */ C12858Z f39552b;

    C12839F(C12858Z this$0, String str) {
        this.f39552b = this$0;
        this.f39551a = str;
    }

    public void run() {
        this.f39552b.f39594b.onRewardedVideoAdOpened(this.f39551a);
    }
}
