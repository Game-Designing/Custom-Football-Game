package p019d.p273h.p276c;

import p019d.p273h.p276c.p280d.C12799b;

/* renamed from: d.h.c.v */
/* compiled from: ISListenerWrapper */
class C12948v implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12799b f39852a;

    /* renamed from: b */
    final /* synthetic */ C12950x f39853b;

    C12948v(C12950x this$0, C12799b bVar) {
        this.f39853b = this$0;
        this.f39852a = bVar;
    }

    public void run() {
        synchronized (this) {
            this.f39853b.f39856b.mo41618b(this.f39852a);
            C12950x xVar = this.f39853b;
            StringBuilder sb = new StringBuilder();
            sb.append("onInterstitialAdShowFailed() error=");
            sb.append(this.f39852a.mo41429b());
            xVar.m42159a(sb.toString());
        }
    }
}
