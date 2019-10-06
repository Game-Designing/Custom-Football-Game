package p019d.p273h.p276c.p282f;

/* renamed from: d.h.c.f.H */
/* compiled from: ListenersWrapper */
class C12841H implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f39555a;

    /* renamed from: b */
    final /* synthetic */ boolean f39556b;

    /* renamed from: c */
    final /* synthetic */ C12858Z f39557c;

    C12841H(C12858Z this$0, String str, boolean z) {
        this.f39557c = this$0;
        this.f39555a = str;
        this.f39556b = z;
    }

    public void run() {
        this.f39557c.f39594b.onRewardedVideoAvailabilityChanged(this.f39555a, this.f39556b);
    }
}
