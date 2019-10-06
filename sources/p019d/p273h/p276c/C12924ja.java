package p019d.p273h.p276c;

import p019d.p273h.p276c.p280d.C12799b;

/* renamed from: d.h.c.ja */
/* compiled from: RVListenerWrapper */
class C12924ja implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12799b f39766a;

    /* renamed from: b */
    final /* synthetic */ C12929la f39767b;

    C12924ja(C12929la this$0, C12799b bVar) {
        this.f39767b = this$0;
        this.f39766a = bVar;
    }

    public void run() {
        synchronized (this) {
            this.f39767b.f39792b.mo41621c(this.f39766a);
            C12929la laVar = this.f39767b;
            StringBuilder sb = new StringBuilder();
            sb.append("onRewardedVideoAdShowFailed() error=");
            sb.append(this.f39766a.mo41429b());
            laVar.m42051a(sb.toString());
        }
    }
}
