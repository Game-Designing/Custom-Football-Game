package p019d.p273h.p276c;

/* renamed from: d.h.c.fa */
/* compiled from: RVListenerWrapper */
class C12900fa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12929la f39617a;

    C12900fa(C12929la this$0) {
        this.f39617a = this$0;
    }

    public void run() {
        synchronized (this) {
            this.f39617a.f39792b.onRewardedVideoAdOpened();
            this.f39617a.m42051a("onRewardedVideoAdOpened()");
        }
    }
}
