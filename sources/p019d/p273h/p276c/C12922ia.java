package p019d.p273h.p276c;

import p019d.p273h.p276c.p281e.C12820l;

/* renamed from: d.h.c.ia */
/* compiled from: RVListenerWrapper */
class C12922ia implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12820l f39761a;

    /* renamed from: b */
    final /* synthetic */ C12929la f39762b;

    C12922ia(C12929la this$0, C12820l lVar) {
        this.f39762b = this$0;
        this.f39761a = lVar;
    }

    public void run() {
        synchronized (this) {
            this.f39762b.f39792b.mo41612a(this.f39761a);
            C12929la laVar = this.f39762b;
            StringBuilder sb = new StringBuilder();
            sb.append("onRewardedVideoAdRewarded() placement=");
            sb.append(this.f39761a.mo41504c());
            laVar.m42051a(sb.toString());
        }
    }
}
