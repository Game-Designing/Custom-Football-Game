package p019d.p273h.p276c;

import p019d.p273h.p276c.p281e.C12820l;

/* renamed from: d.h.c.ka */
/* compiled from: RVListenerWrapper */
class C12926ka implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12820l f39769a;

    /* renamed from: b */
    final /* synthetic */ C12929la f39770b;

    C12926ka(C12929la this$0, C12820l lVar) {
        this.f39770b = this$0;
        this.f39769a = lVar;
    }

    public void run() {
        synchronized (this) {
            this.f39770b.f39792b.mo41619b(this.f39769a);
            C12929la laVar = this.f39770b;
            StringBuilder sb = new StringBuilder();
            sb.append("onRewardedVideoAdClicked() placement=");
            sb.append(this.f39769a.mo41504c());
            laVar.m42051a(sb.toString());
        }
    }
}
