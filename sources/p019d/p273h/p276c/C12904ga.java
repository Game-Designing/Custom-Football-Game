package p019d.p273h.p276c;

/* renamed from: d.h.c.ga */
/* compiled from: RVListenerWrapper */
class C12904ga implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12929la f39620a;

    C12904ga(C12929la this$0) {
        this.f39620a = this$0;
    }

    public void run() {
        synchronized (this) {
            this.f39620a.f39792b.onRewardedVideoAdClosed();
            this.f39620a.m42051a("onRewardedVideoAdClosed()");
        }
    }
}
