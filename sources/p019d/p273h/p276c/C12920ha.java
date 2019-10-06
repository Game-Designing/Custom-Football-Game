package p019d.p273h.p276c;

/* renamed from: d.h.c.ha */
/* compiled from: RVListenerWrapper */
class C12920ha implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f39756a;

    /* renamed from: b */
    final /* synthetic */ C12929la f39757b;

    C12920ha(C12929la this$0, boolean z) {
        this.f39757b = this$0;
        this.f39756a = z;
    }

    public void run() {
        synchronized (this) {
            this.f39757b.f39792b.mo41616a(this.f39756a);
            C12929la laVar = this.f39757b;
            StringBuilder sb = new StringBuilder();
            sb.append("onRewardedVideoAvailabilityChanged() available=");
            sb.append(this.f39756a);
            laVar.m42051a(sb.toString());
        }
    }
}
